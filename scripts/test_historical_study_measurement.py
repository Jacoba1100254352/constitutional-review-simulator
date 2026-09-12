"""Adversarial checks of the paired experiment input and output contracts."""

import copy
import csv
import gzip
import io
import json
from pathlib import Path
import tempfile
import unittest

from historical_data import FORECAST_FILE, load_protocol
import historical_study as study


class HistoricalStudyMeasurementTests(unittest.TestCase):
    def test_inputs_use_exact_locked_forecasts_and_registered_grid(self):
        protocol = load_protocol()
        forecasts = json.loads(FORECAST_FILE.read_text())
        artifacts = study.input_artifacts(protocol, forecasts)
        rows = list(csv.DictReader(io.StringIO(artifacts["study-profiles.csv"].decode())))
        self.assertEqual([r["profile"] for r in rows], protocol["stressDocketProfiles"])
        for row, forecast in zip(rows, forecasts["forecasts"]):
            self.assertEqual([float(row[c]) for c in protocol["categories"]], forecast["probabilities"])
        contexts = list(csv.DictReader(io.StringIO(artifacts["study-contexts.csv"].decode())))
        self.assertEqual(len(contexts), 13)
        self.assertEqual([row["context"] for row in contexts], study.expected_contexts(protocol))
        for name, data in artifacts.items():
            self.assertEqual((study.CONFIG / name).read_bytes(), data)
        self.assertEqual(protocol["simulationRuns"] * protocol["simulationCasesPerRun"] * 8 * 4 * 13, 3993600)

    def test_forecast_unit_identity_and_inventory_fail_closed(self):
        protocol = load_protocol()
        forecasts = json.loads(FORECAST_FILE.read_text())
        for mutation in ("categories", "duplicate", "missing", "term"):
            value = copy.deepcopy(forecasts)
            if mutation == "categories":
                value["categories"].reverse()
            elif mutation == "duplicate":
                value["forecasts"].append(value["forecasts"][0])
            elif mutation == "missing":
                value["forecasts"].pop()
            else:
                value["forecasts"][0]["targetTerm"] = 2024
            with self.subTest(mutation=mutation), self.assertRaises(ValueError):
                study.input_artifacts(protocol, value)

    def test_random_streams_are_distinct_and_signed_64_bit(self):
        votes, responses = set(), set()
        for run in range(120):
            for period in range(4):
                response = study.stream_seed(2026091201 ^ 0x524553504F4E5345, run, 10001 + period * 503)
                self.assertNotIn(response, responses)
                responses.add(response)
                for scenario in range(8):
                    vote = study.stream_seed(2026091201, run, scenario + 101 + period * 503)
                    self.assertNotIn(vote, votes)
                    votes.add(vote)
        self.assertTrue(votes.isdisjoint(responses))
        self.assertTrue(all(-(1 << 63) <= value < (1 << 63) for value in votes | responses))

    @staticmethod
    def write_rows(path, rows):
        data = study.csv_bytes(list(rows[0]), [list(row.values()) for row in rows])
        if path.suffix == ".gz":
            with gzip.open(path, "wb") as stream:
                stream.write(data)
        else:
            path.write_bytes(data)

    def fixture(self, directory):
        protocol = copy.deepcopy(load_protocol())
        protocol.update(stressDocketProfiles=["frozen-generator"], contextOneAtATime={},
                        simulationRuns=2, simulationCasesPerRun=4, simulationReviewPeriods=1)
        scenarios = protocol["stressScenarioKeys"] + protocol["stressAblations"]
        rows = []
        streams = []
        for run in range(2):
            for index, scenario in enumerate(scenarios):
                row = dict(profile="frozen-generator", context="baseline", run=run, scenarioKey=scenario,
                           scenarioIndex=index, totalCases=4, docketSha256=f"docket-{run}",
                           objectsSha256=f"objects-{run}", worldSeed=str(run + 10), averageTimeToReview=0.5,
                           legislativeResponseRate=0.5, legislativeResponseCredibility=0.5, timelyLegislativeResponseRate=0.5)
                row.update({name: 0.5 for name in protocol["weightMetricsHigher"] + protocol["weightMetricsLower"]})
                if scenario == "weak-form-no-response":
                    row.update(legislativeResponseRate=0, legislativeResponseCredibility=0, timelyLegislativeResponseRate=0)
                rows.append(row)
                streams.append(dict(profile="frozen-generator", context="baseline", run=run, scenario=scenario, period=0,
                                    votingSeed=study.stream_seed(protocol["simulationSeed"], run, index + 101),
                                    responseSeed=study.stream_seed(protocol["simulationSeed"] ^ 0x524553504F4E5345, run, 10001)))
        designs = []
        for index, scenario in enumerate(scenarios):
            parent = scenario if index < 4 else scenarios[{4: 1, 5: 2, 6: 3, 7: 3}[index]]
            designs.append(dict(scenario=scenario, parent=parent, responseFactor="1.0", label=parent,
                                docketProcedure="REASONED_EMERGENCY_PANEL", reviewStructure="COUNCIL"))
        designs[4]["docketProcedure"] = "FAST_SHADOW_DOCKET"
        designs[5]["reviewStructure"] = "FULL_COURT"
        designs[6]["responseFactor"] = "0.5"
        designs[7]["responseFactor"] = "0.0"
        self.write_rows(directory / f"{study.PREFIX}-runs.csv.gz", rows)
        self.write_rows(directory / f"{study.PREFIX}-streams.csv.gz", streams)
        self.write_rows(directory / f"{study.PREFIX}-designs.csv", designs)
        self.write_rows(directory / f"{study.PREFIX}-contexts.csv", [dict(context="baseline", field="baseline", value=0,
                                                                       caseCount=4, reviewPeriods=1)])
        (directory / f"{study.PREFIX}-counts.json").write_text(json.dumps(dict(runs=16, cases=64, objects=80,
                                                                            sharedCases=8, sharedObjects=10)))
        return protocol, rows

    def test_valid_grid_and_corrupted_pairing_counts_metrics_and_response(self):
        for mutation in ("none", "duplicate", "missing", "pairing", "time", "seed", "off", "range", "denominator", "scenario-index"):
            with self.subTest(mutation=mutation), tempfile.TemporaryDirectory() as temporary:
                directory = Path(temporary)
                protocol, rows = self.fixture(directory)
                if mutation == "none":
                    quality = study.verify_runs(directory, protocol)
                    self.assertEqual(quality["caseOutcomes"], 64)
                    self.assertEqual(quality["randomStreamRowsVerified"], 16)
                    continue
                if mutation == "duplicate":
                    rows.append(rows[0])
                elif mutation == "missing":
                    rows.pop()
                elif mutation == "pairing":
                    rows[1]["objectsSha256"] = "different"
                elif mutation == "time":
                    rows[1]["averageTimeToReview"] = 0.3
                elif mutation == "seed":
                    for row in rows[8:]:
                        row["worldSeed"] = rows[0]["worldSeed"]
                elif mutation == "off":
                    rows[7]["legislativeResponseRate"] = 0.1
                elif mutation == "range":
                    rows[0]["rightsProtection"] = float("nan")
                elif mutation == "denominator":
                    rows[0]["totalCases"] = 3
                else:
                    rows[0]["scenarioIndex"] = 3
                self.write_rows(directory / f"{study.PREFIX}-runs.csv.gz", rows)
                with self.assertRaises(ValueError):
                    study.verify_runs(directory, protocol)

    def test_unregistered_ablation_changes_and_stream_seed_substitution_fail(self):
        with tempfile.TemporaryDirectory() as temporary:
            directory = Path(temporary)
            protocol, _ = self.fixture(directory)
            path = directory / f"{study.PREFIX}-designs.csv"
            rows = list(study.read_rows(path))
            rows[4]["label"] = "extra-configuration-change"
            self.write_rows(path, rows)
            with self.assertRaises(ValueError):
                study.verify_designs(directory, protocol)
            path = directory / f"{study.PREFIX}-streams.csv.gz"
            rows = list(study.read_rows(path))
            rows[0]["responseSeed"] = rows[0]["votingSeed"]
            self.write_rows(path, rows)
            with self.assertRaises(ValueError):
                study.verify_streams(directory, protocol)


if __name__ == "__main__":
    unittest.main()
