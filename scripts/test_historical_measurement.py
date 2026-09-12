"""Adversarial checks for the frozen historical data and forecast contract."""

from dataclasses import replace
import csv
import io
import json
import math
from pathlib import Path
import tempfile
import unittest
import zipfile

import historical_data as data
import historical_scoring as scoring
import build_historical_benchmark as benchmark


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

    def test_quality_reconciles_denominators_without_silently_dropping_overlap(self):
        record = replace(self.records()[0], issue=30140, issueArea=3, category="ELECTION_LAW", mappingStatus="explicit-issue")
        report = benchmark.quality_rows([record], self.protocol)[0]
        self.assertEqual(sum(report[c] for c in self.protocol["categories"]), report["n"])
        self.assertEqual(report["legacyOverlapCases"], 1)
        self.assertEqual(report["legacy.doctrine_mix.speech"], 1)
        self.assertEqual(report["legacy.doctrine_mix.election_law"], 1)
        self.assertEqual(report["SPEECH"], 0)

    def test_revision_audit_separates_new_term_and_changes_outside_fitted_fields(self):
        before = replace(self.records()[0], term=2024, caseId="prior", sourceRowSha256="1" * 64)
        after = replace(before, sourceRelease="SCDB_2026_01", sourceRowSha256="2" * 64)
        new_term = replace(after, term=2025, caseId="new-term")
        originals = {"SCDB_2025_01": {"prior": {"term": "2024", "unused": "old"}},
                     "SCDB_2026_01": {"prior": {"term": "2024", "unused": "new"},
                                      "new-term": {"term": "2025", "unused": "new"}}}
        rows, summary = benchmark.revision_rows([before], [after, new_term], originals, self.protocol)
        self.assertEqual(len(rows), 1)
        self.assertEqual(rows[0]["changedFields"], "unused")
        self.assertEqual(summary["newTermRows"], 1)
        self.assertEqual(summary["newHistoricalRows"], 1)
        self.assertEqual(summary["changedFieldCounts"], {"unused": 1})

    def test_retrospective_intervals_use_target_terms_not_independent_case_rows(self):
        rows = [{"role": "retrospective-exposed", "term": term, "model": model, "n": term - 2010,
                 "multiclass-brier": 0.8, "log-loss": 1.8, "total-variation": 0.1}
                for term in (2023, 2024) for model in self.protocol["models"]]
        result = benchmark.retrospective_summary(rows, {**self.protocol, "bootstrapReplicates": 30})
        self.assertEqual(len(result), 12)
        for row in result:
            self.assertEqual((row["terms"], row["n"]), (2, 27))
            self.assertEqual((row["empiricalMinusModel"], row["lower"], row["upper"]), (0, 0, 0))
        with self.assertRaises(ValueError):
            benchmark.retrospective_summary(rows[:4], self.protocol)

    def test_committed_new_term_result_cannot_be_presented_as_clear_advantage(self):
        if not benchmark.FIRST.exists():
            self.skipTest("first evaluation not yet created in this checkpoint")
        first = json.loads(benchmark.FIRST.read_text())
        primary = next(row for row in first["pairedDifferences"]
                       if row["metric"] == "multiclass-brier" and row["comparison"].endswith("frozen-generator"))
        self.assertEqual(first["testN"], 66)
        self.assertGreater(primary["difference"], 0)
        self.assertLess(primary["lower"], 0)
        self.assertGreater(primary["upper"], 0)
        self.assertFalse(primary["conditionalAdvantage"])
        revisions = {"oldHistoricalRows": 9341, "newHistoricalRows": 9343, "newTermRows": 66,
                     "statusCounts": {"changed": 10, "added-historical": 2}}
        report = benchmark.report_markdown(first, revisions, [], [], self.protocol).decode()
        self.assertIn("no clear conditional advantage", report)
        self.assertIn("not legal-outcome predictions", report)
        self.assertIn("not Historical Benchmark and Robustness v1", report)

    def test_raw_new_term_counts_by_independent_set_partition(self):
        path = data.DATA / "source-cache/SCDB_2026_01_caseCentered_Citation.csv.zip"
        if not path.exists():
            self.skipTest("raw-source check requires make historical-sources; offline score checks remain available")
        with zipfile.ZipFile(path) as archive:
            source = archive.read("SCDB_2026_01_caseCentered_Citation.csv").decode("utf-8-sig")
        # Independent set algebra, not the importer's category_for function.
        rows = [row for row in csv.DictReader(io.StringIO(source)) if row["term"] == "2025"]
        ids = {row["caseId"] for row in rows}
        election = {row["caseId"] for row in rows if row["issue"] in {"20010", "20020", "20030", "20090", "30140"}}
        emergency = {row["caseId"] for row in rows if row["issue"] == "130015"} - election
        administrative_issue = {row["caseId"] for row in rows if row["issue"] == "90120"} - election - emergency
        eligible = {row["caseId"] for row in rows if row["issue"] and row["issueArea"]} - election - emergency - administrative_issue
        areas = [{row["caseId"] for row in rows if row["issueArea"] in allowed} & eligible
                 for allowed in ({"3"}, {"2", "5"}, {"1"}, {"10", "11"}, {"8"})]
        selected = [areas[0], areas[1], areas[2], areas[3], election, emergency, areas[4] | administrative_issue]
        selected.append(ids - set().union(*selected))
        self.assertEqual(sum(map(len, selected)), len(ids))
        first = json.loads(benchmark.FIRST.read_text())
        self.assertEqual([len(group) for group in selected], [row["count"] for row in first["categories"]])
        forecasts = json.loads(data.FORECAST_FILE.read_text())["forecasts"]
        for forecast, measured in zip(forecasts, first["modelScores"]):
            vector = forecast["probabilities"]
            direct = sum(sum((p - int(i == label)) ** 2 for i, p in enumerate(vector))
                         for label, group in enumerate(selected) for _ in group) / len(ids)
            self.assertAlmostEqual(measured["multiclass-brier"], direct, places=13)


if __name__ == "__main__":
    unittest.main()
