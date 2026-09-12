"""Adversarial checks for the frozen historical data and forecast contract."""

from dataclasses import replace
import io
import json
import math
from pathlib import Path
import tempfile
import unittest
import zipfile

import historical_data as data
import historical_scoring as scoring


class HistoricalDataTests(unittest.TestCase):
    def setUp(self):
        self.protocol = data.load_protocol()

    def archive(self, body, release="SCDB_2025_01"):
        buffer = io.BytesIO()
        with zipfile.ZipFile(buffer, "w") as archive:
            archive.writestr(f"{release}_caseCentered_Citation.csv",
                             "caseId,term,dateDecision,issue,issueArea\n" + body)
        return buffer.getvalue()

    def fixture_protocol(self):
        return {**self.protocol, "sourceMinimumTerm": 2023}

    def records(self):
        return [data.DocketRecord(f"{term}-{i:03}", term, "1/1/2025", 10010, 1,
                                  category, "fixture", "SCDB_2025_01", "0" * 64)
                for term in (2021, 2022, 2023, 2024)
                for i, category in enumerate(self.protocol["categories"])]

    def test_locked_protocol_and_frozen_generator_law(self):
        source = (data.ROOT / "src/main/java/courtsim/simulation/WorldGenerator.java").read_text()
        weights = source.split("EMPIRICAL_DOCTRINE_WEIGHTS = {", 1)[1].split("}", 1)[0]
        parsed = [float(item.strip()) for item in weights.split(",") if item.strip()]
        self.assertEqual(parsed, self.protocol["frozenGeneratorProbabilities"])
        self.assertEqual(len(set(self.protocol["categories"])), 8)

    def test_election_priority_removes_legacy_speech_overlap(self):
        self.assertEqual(data.category_for(30140, 3, self.protocol), ("ELECTION_LAW", "explicit-issue"))
        self.assertEqual(data.category_for(30010, 3, self.protocol), ("SPEECH", "issue-area"))
        self.assertEqual(data.category_for(20010, 2, self.protocol)[0], "ELECTION_LAW")

    def test_missing_unmapped_and_explicit_issue_paths(self):
        self.assertEqual(data.category_for(None, 3, self.protocol), ("OTHER", "missing-required-code"))
        self.assertEqual(data.category_for(130015, None, self.protocol)[0], "EMERGENCY_POWERS")
        self.assertEqual(data.category_for(90120, 9, self.protocol)[0], "ADMINISTRATIVE_STATE")
        self.assertEqual(data.category_for(90010, 9, self.protocol), ("OTHER", "residual-area"))
        self.assertEqual(data.category_for(90010, 99, self.protocol), ("OTHER", "unrecognized-area"))

    def test_exact_release_parse_and_calendar_year_is_not_term(self):
        body = "2023-001,2023,1/1/2024,30140,3\n2024-001,2024,,,3\n"
        records, metadata, raw = data.parse_release(self.archive(body), "SCDB_2025_01", self.fixture_protocol())
        self.assertEqual([r.term for r in records], [2023, 2024])
        self.assertEqual([r.category for r in records], ["ELECTION_LAW", "OTHER"])
        self.assertEqual(metadata["recordCount"], 2)
        self.assertEqual(len(raw), 2)
        self.assertEqual(len(metadata["csvSha256"]), 64)

    def test_duplicate_id_row_width_future_term_and_missing_term_fail(self):
        bodies = [
            "a,2023,,10010,1\na,2024,,10010,1\n",
            "a,2023,,10010,1,extra\nb,2024,,10010,1\n",
            "a,2023,,10010\nb,2024,,10010,1\n",
            "a,2023,,10010,1\nb,2025,,10010,1\n",
            "a,2024,,10010,1\n",
            "a,2023,,10010,1\nb,2024,99/99/2025,10010,1\n",
            "a,2023,,10010,1\nb,2024,,NaN,1\n",
        ]
        for body in bodies:
            with self.subTest(body=body), self.assertRaises(ValueError):
                data.parse_release(self.archive(body), "SCDB_2025_01", self.fixture_protocol())

    def test_release_or_observation_unit_substitution_fails(self):
        with self.assertRaises(ValueError):
            data.parse_release(self.archive("a,2024,,10010,1\n", "SCDB_2026_01"),
                               "SCDB_2025_01", self.fixture_protocol())
        with self.assertRaises(ValueError):
            data.parse_release(self.archive(""), "invented-release", self.protocol)

    def test_all_forecasts_are_strictly_train_only_and_order_invariant(self):
        records = self.records()
        forecasts = data.fit_models(records, 2024, self.protocol)
        changed_future = [replace(row, category="OTHER") if row.term == 2024 else row for row in records]
        self.assertEqual(forecasts, data.fit_models(changed_future, 2024, self.protocol))
        self.assertEqual(forecasts, data.fit_models(list(reversed(records)), 2024, self.protocol))
        for forecast in forecasts:
            if forecast["trainingN"]:
                self.assertLess(forecast["trainingMaxTerm"], forecast["targetTerm"])
            data.probabilities(forecast["probabilities"])

    def test_empty_duplicate_and_new_release_training_fail(self):
        records = self.records()
        invalid = [[], records + [records[0]], [replace(row, sourceRelease="SCDB_2026_01") for row in records],
                   records + [replace(records[0], term=2025, caseId="2025-001")]]
        for rows in invalid:
            with self.assertRaises(ValueError):
                data.fit_models(rows, 2025, self.protocol)
        with self.assertRaises(ValueError):
            data.fit_models([row for row in records if row.term != 2024], 2025, self.protocol)

    def test_recency_weights_and_prior_are_exact(self):
        rows = [replace(self.records()[0], term=2019, category="SPEECH", caseId="old"),
                replace(self.records()[1], term=2024, category="EQUALITY", caseId="recent")]
        forecasts = {f["model"]: f for f in data.fit_models(rows, 2025, self.protocol)}
        vector = forecasts["recency-weighted-15y"]["probabilities"]
        # Five-year-old row has weight 0.5; newest row 1; eight half-counts total 4.
        self.assertEqual(vector[0], 1.0 / 5.5)
        self.assertEqual(vector[1], 1.5 / 5.5)
        self.assertEqual(vector[2], 0.5 / 5.5)
        self.assertEqual(forecasts["previous-term"]["trainingN"], 1)

    def test_bad_probability_vectors_fail(self):
        for vector in ([1.0] * 8, [0.0] * 8, [0.125] * 7, [math.nan] + [0.125] * 7,
                       [-0.1, 1.1] + [0.0] * 6):
            with self.assertRaises(ValueError):
                data.probabilities(vector)

    def test_immutable_artifacts_and_hash_guard(self):
        with tempfile.TemporaryDirectory() as directory:
            root = Path(directory)
            path = root / "forecast.json"
            content = data.json_bytes({"probabilities": [0.125] * 8})
            data.immutable_write(path, content)
            data.immutable_write(path, content)
            data.check_hashes({"forecast.json": data.sha256(content)}, root)
            with self.assertRaises(ValueError):
                data.immutable_write(path, data.json_bytes({"probabilities": [0.1] * 8}))
            with self.assertRaises(ValueError):
                data.check_hashes({"forecast.json": "0" * 64}, root)
            with self.assertRaises(ValueError):
                data.check_hashes({"../forecast.json": data.sha256(content)}, root)
            self.assertEqual(json.loads(path.read_text())["probabilities"], [0.125] * 8)

    def test_scores_match_independent_case_level_formula(self):
        vector = self.protocol["frozenGeneratorProbabilities"]
        labels = [0, 0, 1, 2, 7]
        counts = [labels.count(i) for i in range(8)]
        expected = sum(sum((p - int(i == label)) ** 2 for i, p in enumerate(vector))
                       for label in labels) / len(labels)
        measured = scoring.scores(vector, counts)
        self.assertAlmostEqual(measured["multiclass-brier"], expected, places=14)
        self.assertAlmostEqual(measured["log-loss"], -sum(math.log(vector[i]) for i in labels) / 5)
        self.assertAlmostEqual(scoring.scores([0.125] * 8, [1] * 8)["total-variation"], 0)
        with self.assertRaises(ValueError):
            scoring.scores(vector, [0] * 8)

    def test_paired_bootstrap_identical_models_have_exactly_zero_difference(self):
        forecasts = data.fit_models(self.records(), 2025, self.protocol)
        vector = self.protocol["frozenGeneratorProbabilities"]
        forecasts = [{**row, "probabilities": vector} for row in forecasts]
        result = scoring.conditional_score_differences(forecasts, [2] * 8, 30, 17)
        self.assertEqual(result, scoring.conditional_score_differences(forecasts, [2] * 8, 30, 17))
        for row in result:
            self.assertEqual((row["difference"], row["lower"], row["upper"]), (0, 0, 0))
            self.assertFalse(row["conditionalAdvantage"])

    def test_bad_test_release_cutoff_and_duplicate_case_fail(self):
        forecasts = data.fit_models(self.records(), 2025, self.protocol)
        records = [replace(row, term=2025, caseId=f"test-{i}", sourceRelease="SCDB_2026_01")
                   for i, row in enumerate(self.records()[:8])]
        short = {**self.protocol, "bootstrapReplicates": 30}
        result = scoring.new_term_result(records, forecasts, short)
        self.assertEqual(result["testN"], 8)
        for invalid in ([], self.records(), records + [records[0]], [replace(r, term=2024) for r in records]):
            with self.assertRaises(ValueError):
                scoring.new_term_result(invalid, forecasts, short)
        with self.assertRaises(ValueError):
            scoring.new_term_result(records, [{**row, "trainingMaxTerm": 2025} for row in forecasts], short)

    def test_training_term_bootstrap_has_no_test_term(self):
        protocol = {**self.protocol, "empiricalLookbackTerms": 4, "bootstrapReplicates": 30}
        records = self.records()
        intervals = scoring.training_composition_intervals(records, 2025, protocol)
        future = replace(records[0], term=2025, sourceRelease="SCDB_2026_01", caseId="future")
        self.assertEqual(intervals, scoring.training_composition_intervals(records + [future], 2025, protocol))
        self.assertTrue(all(row["trainingTerms"] == 4 for row in intervals))
        with self.assertRaises(ValueError):
            scoring.training_composition_intervals([r for r in records if r.term != 2024], 2025, protocol)


if __name__ == "__main__":
    unittest.main()
