"""Cross-language tests of independent raw reconstruction, including adversarial corruption."""

import copy
import gzip
import json
from pathlib import Path
import subprocess
import tempfile
import unittest

import check_historical_study_raw as raw
from historical_data import FORECAST_FILE, ROOT, load_protocol
from historical_study import PREFIX, csv_bytes, input_artifacts, read_rows


class HistoricalRawMeasurementTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        if not (ROOT / "out/main/courtsim/experiment/HistoricalStudyRunner.class").exists():
            raise unittest.SkipTest("native runner class absent; run make test for the cross-language check")
        cls.temporary = tempfile.TemporaryDirectory(prefix="historical-raw-measurement-")
        cls.directory = Path(cls.temporary.name)
        cls.protocol = copy.deepcopy(load_protocol())
        cls.protocol.update(stressDocketProfiles=["frozen-generator"], contextOneAtATime={},
                            simulationRuns=2, simulationCasesPerRun=16, simulationReviewPeriods=4)
        forecast = json.loads(FORECAST_FILE.read_text())
        forecast["forecasts"] = forecast["forecasts"][:1]
        inputs = cls.directory / "inputs"
        inputs.mkdir()
        for name, data in input_artifacts(cls.protocol, forecast).items():
            (inputs / name).write_bytes(data)
        cls.output = cls.directory / "outputs"
        subprocess.run(["java", "-cp", str(ROOT / "out/main"), "courtsim.experiment.HistoricalStudyRunner",
                        str(inputs), str(cls.output)], cwd=ROOT, check=True, capture_output=True, text=True)

    @classmethod
    def tearDownClass(cls):
        cls.temporary.cleanup()

    def test_independent_aggregate_and_exact_hash_reconstruction(self):
        result = raw.reconcile(self.output, self.protocol)
        self.assertEqual(result["counts"]["sharedDockets"], 2)
        self.assertEqual(result["counts"]["designRuns"], 16)
        self.assertEqual(result["counts"]["caseOutcomes"], 256)
        self.assertGreaterEqual(len(result["runMetricsReconstructed"]), 75)
        self.assertTrue(set(self.protocol["weightMetricsHigher"] + self.protocol["weightMetricsLower"])
                        .issubset(result["runMetricsReconstructed"]))

    @staticmethod
    def write(path, rows):
        with gzip.open(path, "wb") as stream:
            stream.write(csv_bytes(list(rows[0]), [list(row.values()) for row in rows]))

    def test_corrupted_raw_aggregate_identity_object_and_docket_are_detected(self):
        for mutation, suffix in (("mean", "-runs.csv.gz"), ("case-id", "-cases.csv.gz"),
                                 ("object-vulnerability", "-objects.csv.gz"), ("statute-flag", "-objects.csv.gz"),
                                 ("docket-input", "-dockets.csv.gz"), ("drop-run", "-dockets.csv.gz")):
            with self.subTest(mutation=mutation):
                path = self.output / f"{PREFIX}{suffix}"
                original = path.read_bytes()
                rows = list(read_rows(path))
                try:
                    if mutation == "mean":
                        rows[0]["rightsProtection"] = "0.99999"
                    elif mutation == "case-id":
                        rows[0]["caseId"] = "substituted-case"
                    elif mutation == "object-vulnerability":
                        rows[0]["vulnerability"] = "0.99999"
                    elif mutation == "statute-flag":
                        rows[0]["statuteDisposition"] = "false" if rows[0]["statuteDisposition"] == "true" else "true"
                    elif mutation == "docket-input":
                        rows[0]["urgency"] = "0.99999"
                    else:
                        rows = rows[:16]
                    self.write(path, rows)
                    with self.assertRaises(ValueError):
                        raw.reconcile(self.output, self.protocol)
                finally:
                    path.write_bytes(original)

    def test_exact_hex_format_including_zero_and_subnormals(self):
        self.assertEqual(raw.java_hex("0.5"), "0x1.0p-1")
        self.assertEqual(raw.java_hex("1"), "0x1.0p0")
        self.assertEqual(raw.java_hex("-0.0"), "-0x0.0p0")
        self.assertEqual(raw.java_hex("5e-324"), "0x0.0000000000001p-1022")
        with self.assertRaises(ValueError):
            raw.java_hex("nan")


if __name__ == "__main__":
    unittest.main()
