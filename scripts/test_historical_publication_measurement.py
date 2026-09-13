"""Publication projections must preserve verified evidence and complete table coverage."""

import importlib.util
import json
from pathlib import Path
import shutil
import tempfile
import unittest
from unittest.mock import patch

from historical_data import ROOT


spec = importlib.util.spec_from_file_location("historical_publication", ROOT / "paper/scripts/generate_historical_tables.py")
publication = importlib.util.module_from_spec(spec)
spec.loader.exec_module(publication)


class HistoricalPublicationMeasurementTests(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.artifacts = publication.build_artifacts()

    def test_complete_projection_and_manuscript_table_inclusions(self):
        manifest = json.loads(self.artifacts["historical-publication-manifest.json"])
        self.assertEqual(manifest["coverage"], {"claimComponents": 22, "ablationAndPersistenceComponents": 49,
                                               "referenceCellIntervals": 71, "empiricalPairedScores": 9})
        self.assertEqual(len(self.artifacts), 14)
        main = (ROOT / "paper/constitutional-review-design-stress-test.tex").read_text()
        supplement = (ROOT / "paper/supplementary-appendix.tex").read_text()
        for name, content in self.artifacts.items():
            if name.endswith(".tex"):
                self.assertEqual((main + supplement).count(r"\input{tables/" + name.removesuffix(".tex") + "}"), 1)
                self.assertNotIn(b"nan", content.lower())
                self.assertNotIn(b"-0.0000", content)
        self.assertEqual(publication.generate(check=True), 14)

    def test_primary_score_and_all_component_values_are_projected_without_filtering(self):
        first = json.loads((ROOT / "reports" / f"{publication.EMPIRICAL}-first-evaluation.json").read_text())
        scores = self.artifacts["historical_scores.tex"].decode()
        for row in first["modelScores"]:
            self.assertIn(f"{float(row['multiclass-brier']):.4f}", scores)
        self.assertIn("no clear conditional advantage", scores)
        claims = self.artifacts["supplement_historical_claims.tex"].decode()
        for row in publication.read_rows(ROOT / "reports" / f"{publication.STUDY}-claim-matrix.csv"):
            self.assertIn(publication.METRICS[row["metric"]], claims)
            self.assertIn(publication.span(row), claims)
        self.assertIn("not replacement primary estimands", self.artifacts["supplement_historical_denominators.tex"].decode())
        self.assertIn("not additive monetary costs", self.artifacts["supplement_historical_accounting.tex"].decode())

    def test_stale_generated_table_is_rejected(self):
        with tempfile.TemporaryDirectory(prefix="historical-publication-test-") as raw:
            root = Path(raw)
            with patch.object(publication, "build_artifacts", return_value=self.artifacts):
                publication.generate(root)
                self.assertEqual(publication.generate(root, check=True), 14)
                path = root / "paper/tables/historical_scores.tex"
                path.write_text(path.read_text().replace("0.8088", "0.1234"))
                with self.assertRaisesRegex(ValueError, "publication artifact is stale"):
                    publication.generate(root, check=True)

    def test_changed_evidence_fails_before_publication(self):
        manifest = json.loads(self.artifacts["historical-publication-manifest.json"])
        with tempfile.TemporaryDirectory(prefix="historical-publication-evidence-test-") as raw:
            root = Path(raw)
            for relative in manifest["inputSha256"]:
                path = root / relative
                path.parent.mkdir(parents=True, exist_ok=True)
                shutil.copyfile(ROOT / relative, path)
            publication.load_evidence(root)
            for relative in (f"reports/{publication.STUDY}-contrasts.csv",
                             f"reports/{publication.EMPIRICAL}-first-evaluation.json"):
                path = root / relative
                original = path.read_bytes()
                try:
                    path.write_bytes(original + b"\n")
                    with self.assertRaisesRegex(ValueError, "publication evidence hash mismatch"):
                        publication.load_evidence(root)
                finally:
                    path.write_bytes(original)


if __name__ == "__main__":
    unittest.main()
