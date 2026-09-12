"""Keep new historical replication evidence available without caches or private inputs."""

import unittest

from build_submission_bundle import ROOT, should_include


class HistoricalBundleMeasurementTests(unittest.TestCase):
    def test_locked_inputs_and_small_evidence_are_included(self):
        for name in ("config/historical-benchmark/protocol-v1.json",
                     "config/historical-benchmark/forecasts-2025.json",
                     "data/historical/SCDB_2025_01-docket.csv",
                     "data/historical/SCDB_2026_01-docket.csv",
                     "reports/constitutional-review-historical-benchmark-v1-first-evaluation.json",
                     "reports/constitutional-review-historical-robustness-v1-runs.csv.gz",
                     "reports/constitutional-review-historical-robustness-v1-raw-audit.json"):
            with self.subTest(name=name):
                self.assertTrue(should_include(ROOT / name))

    def test_download_cache_and_large_raw_exports_are_excluded(self):
        for name in ("data/historical/source-cache/SCDB_2026_01.zip",
                     "reports/constitutional-review-historical-robustness-v1-cases.csv.gz",
                     "reports/constitutional-review-historical-robustness-v1-objects.csv.gz",
                     "reports/constitutional-review-historical-robustness-v1-dockets.csv.gz",
                     "reports/constitutional-review-historical-robustness-v1-segments.csv.gz"):
            with self.subTest(name=name):
                self.assertFalse(should_include(ROOT / name))

    def test_local_private_configuration_and_build_metadata_are_excluded(self):
        for name in ("data/.env", "config/.env.local", "data/.secrets/source-key",
                     "data/credentials.local/source-key", "paper/build/result.pdf", "paper/result.pdf",
                     "src/.idea/module.iml", "scripts/__pycache__/module.pyc"):
            with self.subTest(name=name):
                self.assertFalse(should_include(ROOT / name))


if __name__ == "__main__":
    unittest.main()
