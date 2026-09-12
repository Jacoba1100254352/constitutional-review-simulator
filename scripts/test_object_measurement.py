"""Adversarial checks of the independent object-export reconciliation guard."""

import csv
import gzip
import tempfile
import unittest
from pathlib import Path

from check_object_measurement import check
from build_empirical_platform_report import measurement_audit_rows, readiness_rows, CALIBRATION_SOURCE


class ObjectMeasurementGuardTests(unittest.TestCase):
    def setUp(self):
        self.directory = tempfile.TemporaryDirectory()
        self.addCleanup(self.directory.cleanup)
        self.prefix = Path(self.directory.name) / "fixture"
        self.case = dict(caseKey="fixture", scenarioKey="court", runIndex="1", caseIndex="1", caseId="c1",
                         meritsReview="true", meritsInvalidated="true", weakFormDeclaration="false",
                         statuteDispositions="2", statuteNullifications="1")
        parent = {key: self.case[key] for key in ("caseKey", "scenarioKey", "runIndex", "caseIndex", "caseId")}
        self.objects = [
            dict(parent, objectId="s1", objectKind="STATUTE", disposition="NULLIFIED", statuteDisposition="true", statuteNullification="true"),
            dict(parent, objectId="s2", objectKind="STATUTE", disposition="UPHELD", statuteDisposition="true", statuteNullification="false"),
            dict(parent, objectId="c1", objectKind="GOVERNMENT_CONDUCT", disposition="CONDUCT_REMEDY", statuteDisposition="false", statuteNullification="false"),
        ]
        self.aggregate = dict(caseKey="fixture", scenarioKey="court", totalCases="1", statuteDispositions="2",
                              statuteNullifications="1", statuteNullificationRate="0.500")

    def write(self, duplicate_case=False):
        for suffix, records in (("-cases.csv.gz", [self.case] * (2 if duplicate_case else 1)),
                                ("-objects.csv.gz", self.objects), (".csv", [self.aggregate])):
            path = Path(str(self.prefix) + suffix)
            opener = gzip.open if suffix.endswith(".gz") else open
            with opener(path, "wt", encoding="utf-8", newline="") as handle:
                writer = csv.DictWriter(handle, fieldnames=list(records[0]))
                writer.writeheader()
                writer.writerows(records)

    def test_mixed_objects_reconcile(self):
        self.write()
        check(self.prefix)

    def test_rejects_corrupt_exports(self):
        mutations = [
            (self.aggregate, "statuteNullificationRate", "1.000"),
            (self.aggregate, "statuteNullificationRate", "NaN"),
            (self.aggregate, "statuteDispositions", "1"),
            (self.case, "statuteNullifications", "2"),
            (self.objects[1], "objectId", "s1"),
            (self.objects[1], "caseId", "orphan"),
            (self.objects[0], "statuteDisposition", "false"),
            (self.objects[2], "disposition", "NULLIFIED"),
            (self.objects[2], "disposition", "TYPO"),
        ]
        for record, key, bad_value in mutations:
            original = record[key]
            with self.subTest(key=key, bad_value=bad_value):
                record[key] = bad_value
                self.write()
                with self.assertRaises(ValueError):
                    check(self.prefix)
            record[key] = original

    def test_duplicate_case_rejected(self):
        self.write(duplicate_case=True)
        with self.assertRaises(ValueError):
            check(self.prefix)

    def test_empty_statute_denominator_is_missing(self):
        self.objects = self.objects[2:]
        for record in (self.case, self.aggregate):
            record["statuteDispositions"] = record["statuteNullifications"] = "0"
        self.aggregate["statuteNullificationRate"] = "NaN"
        self.write()
        check(self.prefix)
        self.aggregate["statuteNullificationRate"] = "0.000"
        self.write()
        with self.assertRaises(ValueError):
            check(self.prefix)

    def test_source_measurements_preserve_counts_and_claim_boundaries(self):
        with CALIBRATION_SOURCE.open(encoding="utf-8", newline="") as handle:
            source_rows = list(csv.DictReader(handle))
        audit = measurement_audit_rows(source_rows)
        expected = {
            "statute_nullification_rate": (19, 50, "true"),
            "complaint_success_rate": (39, 4595, "false"),
            "legal_representation_share": (1500, 4436, "false"),
            "emergency_application_share": (1003, 4436, "false"),
            "direct_instrument_challenge_share": (110, 4436, "false"),
            "leave_petition_share": (189, 217, "false"),
            "direct_access_petition_share": (19, 217, "false"),
            "dismissed_petition_snapshot_share": (57, 217, "false"),
            "dismissal_reason_observed_share": (40, 57, "false"),
        }
        self.assertEqual(len(audit), len(expected))
        for row in audit:
            self.assertEqual((int(row["numerator"]), int(row["denominator"]), row["useForValidation"]), expected[row["targetKey"]])

    def test_readiness_wording_preserves_misses_and_empty_evidence(self):
        profiles = [dict(validationRows="1", validationFamilies="merits")]
        for within in ("false", "true"):
            with self.subTest(within=within):
                fit = readiness_rows(profiles, [], [], [], [], [dict(withinTarget=within)])[0]
                if within == "false":
                    self.assertEqual(fit["status"], "needs-model-calibration")
                    self.assertIn("outside their documented ranges", fit["interpretation"])
                else:
                    self.assertEqual(fit["status"], "ready-for-current-claims")
                    self.assertIn("not independent validation", fit["interpretation"])
        fit = readiness_rows([], [], [], [], [], [])[0]
        self.assertNotEqual(fit["status"], "ready-for-current-claims")
        self.assertIn("has not been assessed", fit["interpretation"])


if __name__ == "__main__":
    unittest.main()
