"""Replication packaging must preserve object data instructions and current PDFs."""

import unittest
from unittest.mock import call, patch

import build_submission_bundle as bundle


class ReplicationMeasurementTests(unittest.TestCase):
    def test_compact_bundle_preserves_measurement_inputs_not_large_exports(self):
        for relative in (
            "docs/object-measurement-contract.md",
            "docs/measurement-evidence-audit.md",
            "config/regression/validation-before-object-extension.csv",
            "reports/constitutional-review-measurement-audit-v1.csv",
            "scripts/check_object_measurement.py",
            "src/main/java/courtsim/model/ChallengeObject.java",
        ):
            with self.subTest(relative=relative):
                self.assertTrue(bundle.should_include(bundle.ROOT / relative))
        for relative in (
            "reports/constitutional-review-validation-v1-objects.csv.gz",
            "reports/constitutional-review-validation-v1-cases.csv.gz",
            "reports/constitutional-review-validation-v1-calibration-intervals.csv",
            "paper/build/supplementary-appendix.pdf",
            "tmp/pdfs/source-cookies.txt",
        ):
            with self.subTest(relative=relative):
                self.assertFalse(bundle.should_include(bundle.ROOT / relative))

    def test_standalone_bundle_refreshes_both_accessible_pdfs(self):
        with patch.object(bundle, "run"), patch.object(bundle.shutil, "copy2") as copy:
            bundle.refresh_pdfs()
        self.assertEqual(copy.call_args_list, [
            call(bundle.MANUSCRIPT_PDF, bundle.PAPER_DIR / bundle.MANUSCRIPT_PDF_NAME),
            call(bundle.SUPPLEMENT_PDF, bundle.PAPER_DIR / "supplementary-appendix.pdf"),
        ])


if __name__ == "__main__":
    unittest.main()
