"""Ensure an internally consistent but wrong analysis cannot certify itself."""

import csv
import hashlib
import io
import json
from pathlib import Path
import shutil
import tempfile
import unittest

import check_historical_analysis as validator
from historical_data import ROOT
from historical_study import PREFIX, read_rows


class HistoricalAnalysisValidationMeasurementTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        original = ROOT / "reports" / f"{PREFIX}-analysis-manifest.json"
        if not original.exists():
            raise unittest.SkipTest("analysis evidence absent; run make historical-analysis before full validation tests")
        cls.temporary = tempfile.TemporaryDirectory(prefix="historical-analysis-validation-test-")
        cls.directory = Path(cls.temporary.name)
        cls.manifest = json.loads(original.read_text())
        files = [f"{PREFIX}-analysis-manifest.json"]
        files += [f"{PREFIX}{suffix}" for suffix in cls.manifest["outputSha256"]]
        files += [Path(relative).name for relative in cls.manifest["inputSha256"] if relative.startswith("reports/")]
        for name in set(files):
            shutil.copyfile(ROOT / "reports" / name, cls.directory / name)

    @classmethod
    def tearDownClass(cls):
        cls.temporary.cleanup()

    def test_independent_validator_accepts_complete_saved_evidence(self):
        result = validator.validate(self.directory)
        self.assertEqual(result["pairedPointEstimatesAndSEsVerified"], 3692)
        self.assertEqual(result["expandedIndexBootstrapIntervalsVerified"], 93)
        self.assertEqual(result["leadershipRowsVerified"], 624)
        self.assertEqual(result["fixedWeightGridRowsVerified"], 6000)

    def test_fabricated_results_fail_even_when_their_declared_hashes_are_updated(self):
        for mutation, suffix, message in (
                ("point", "-contrasts.csv", "paired point"),
                ("missing-pair", "-preference-pairs.csv", "incomplete registered analysis table"),
                ("follow-up-count", "-conditional-denominators.csv", "conditional denominator meritsFollowUps"),
                ("follow-up-rate", "-conditional-denominators.csv", "pooled diagnostic pooledFollowUpPerOrder"),
                ("accounting-sign", "-cost-accounting.csv", "accounting practical sign change"),
                ("false-stability", "-claim-matrix.csv", "claim matrix differs"),
                ("false-duration-support", "-claim-matrix.csv", "unsupported duration measure")):
            with self.subTest(mutation=mutation):
                path = self.directory / f"{PREFIX}{suffix}"
                manifest_path = self.directory / f"{PREFIX}-analysis-manifest.json"
                original, original_manifest = path.read_bytes(), manifest_path.read_bytes()
                try:
                    rows = list(read_rows(path))
                    if mutation == "point":
                        rows[0]["difference"] = "0.1234567"
                    elif mutation == "missing-pair":
                        rows.pop()
                    elif mutation == "follow-up-count":
                        rows[0]["meritsFollowUps"] = str(int(rows[0]["meritsFollowUps"]) + 1)
                    elif mutation == "follow-up-rate":
                        next(row for row in rows if float(row["emergencyOrders"]) > 0)["pooledFollowUpPerOrder"] = "0.1234567"
                    elif mutation == "accounting-sign":
                        rows[0]["practicalSignChange"] = "True" if rows[0]["practicalSignChange"] == "False" else "False"
                    elif mutation == "false-stability":
                        rows[0]["classification"] = "stable"
                    else:
                        next(row for row in rows if row["metric"] == "averageTimeToReview")["evidenceStatus"] = "supported"
                    stream = io.StringIO(newline="")
                    writer = csv.DictWriter(stream, fieldnames=list(rows[0]), lineterminator="\n")
                    writer.writeheader()
                    writer.writerows(rows)
                    changed = stream.getvalue().encode()
                    path.write_bytes(changed)
                    manifest = json.loads(original_manifest)
                    manifest["outputSha256"][suffix] = hashlib.sha256(changed).hexdigest()
                    manifest["rows"][suffix] = len(rows)
                    manifest_path.write_text(json.dumps(manifest))
                    with self.assertRaisesRegex(ValueError, message):
                        validator.validate(self.directory)
                finally:
                    path.write_bytes(original)
                    manifest_path.write_bytes(original_manifest)


if __name__ == "__main__":
    unittest.main()
