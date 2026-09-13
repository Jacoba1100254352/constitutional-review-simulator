"""Keep new historical replication evidence available without caches or private inputs."""

import gzip
import io
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch
import zipfile

import build_submission_bundle as bundle
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

    def test_decoded_compressed_identity_marker_is_rejected(self):
        with tempfile.TemporaryDirectory(prefix="anonymous-bundle-test-") as raw:
            root = Path(raw)
            path = root / "review.zip"
            with patch.object(bundle, "ROOT", root), patch.object(bundle, "leak_markers", return_value=[b"private-identity-fixture"]):
                for payload, expected_failure in ((b"public,fixture\n", False), (b"private-identity-fixture\n", True)):
                    with zipfile.ZipFile(path, "w") as archive:
                        archive.writestr("reports/retained.csv.gz", gzip.compress(payload, mtime=0))
                    if expected_failure:
                        with self.assertRaisesRegex(SystemExit, "identity markers"):
                            bundle.validate_zip(path)
                    else:
                        bundle.validate_zip(path)

    def test_marker_split_across_read_chunks_is_detected(self):
        self.assertTrue(bundle.contains_marker(io.BytesIO(b"aaaa-private-identity-fixture-bbbb"), [b"private-identity-fixture"], 8))
        self.assertFalse(bundle.contains_marker(io.BytesIO(b"public fixture"), [b"private-identity-fixture"], 8))


if __name__ == "__main__":
    unittest.main()
