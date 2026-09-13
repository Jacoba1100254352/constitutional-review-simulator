"""Publication gates must preserve period-specific checks and display genuine misses."""

import sys
import tempfile
from contextlib import redirect_stderr
from io import StringIO
import unittest
from pathlib import Path
from unittest.mock import patch

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "paper/scripts"))
import check_jlc_format as quality
import generate_tables as tables
import generate_figures as figures


class PaperMeasurementTests(unittest.TestCase):
    def test_anonymous_checkout_does_not_require_developer_instructions(self):
        with tempfile.TemporaryDirectory() as raw:
            root = Path(raw)
            for name in ("Makefile", "README.md", "main.tex"):
                (root / name).write_text("anonymous content", encoding="utf-8")
            quality.check_local_paths(root, root / "main.tex")
            self.assertFalse((root / "AGENTS.md").exists())

    def test_optional_instructions_and_required_inputs_still_reject_private_paths(self):
        with tempfile.TemporaryDirectory() as raw:
            root = Path(raw)
            (root / "reports").mkdir()
            names = ("Makefile", "README.md", "main.tex", "AGENTS.md", "reports/run-manifest.json")
            for name in names:
                (root / name).write_text("anonymous content", encoding="utf-8")
            for name in names:
                with self.subTest(name=name):
                    path = root / name
                    path.write_text("/" + "Users/" + "example", encoding="utf-8")
                    with self.assertRaises(SystemExit), redirect_stderr(StringIO()):
                        quality.check_local_paths(root, root / "main.tex")
                    path.write_text("anonymous content", encoding="utf-8")

    def test_missing_required_publication_inputs_are_not_silently_skipped(self):
        with tempfile.TemporaryDirectory() as raw:
            root = Path(raw)
            for name in ("Makefile", "README.md", "main.tex"):
                (root / name).write_text("anonymous content", encoding="utf-8")
            for name in ("Makefile", "README.md", "main.tex"):
                with self.subTest(name=name):
                    path = root / name
                    path.unlink()
                    with self.assertRaises(SystemExit), redirect_stderr(StringIO()):
                        quality.check_local_paths(root, root / "main.tex")
                    path.write_text("anonymous content", encoding="utf-8")

    def test_scatter_bounds_include_current_baseline_and_reject_outside_points(self):
        rows = figures.read_rows(figures.BASELINE_CSV)
        rows = [row for row in rows if row["caseKey"] == "baseline" and row["scenarioKey"] in figures.BASELINE_SCATTER_SCENARIOS]
        self.assertEqual(len(rows), len(figures.BASELINE_SCATTER_SCENARIOS))
        figures.check_scatter_bounds(rows, "totalInstitutionalCost", (0.25, 0.65))
        for field, value in (("democraticConstitutionalism", "0.54"), ("totalInstitutionalCost", "0.66")):
            with self.assertRaises(ValueError):
                figures.check_scatter_bounds([{**rows[0], field: value}], "totalInstitutionalCost", (0.25, 0.65))

    def setUp(self):
        self.profiles = [("canada", "court", "Canada")]
        self.rows = [dict(profileKey="canada", targetKey="response", timePeriod=period,
                          useForValidation="true", withinTarget=within, gap=gap, label="Response")
                     for period, within, gap in [("earlier", "true", "0.000"), ("later", "false", "0.010")]]

    def test_summary_keeps_duplicate_metric_in_distinct_periods(self):
        def read(path):
            if path == tables.VALIDATION_CSV:
                return [dict(scenarioKey="court", caseKey="benchmark-context", scenario="Court")]
            self.assertEqual(path, tables.VALIDATION_CALIBRATION_CSV)
            return self.rows
        with patch.object(tables, "read_rows", side_effect=read), patch.object(tables, "VALIDATION_PROFILES", self.profiles), patch.object(tables, "write") as output:
            tables.generate_validation_summary()
        content = output.call_args.args[1]
        self.assertIn("Canada & Court & 1/2", content)

    def test_false_all_clear_and_collapsed_periods_rejected(self):
        with patch.object(quality, "VALIDATION_PROFILES", self.profiles):
            quality.check_source_range_tables("Canada & Court & 1/2 & 0.000", "Response; no-current-miss state", self.rows)
            with self.assertRaises(SystemExit), redirect_stderr(StringIO()):
                quality.check_source_range_tables("Canada & Court & 1/1 & 0.000", "Response; no-current-miss state", self.rows)
            with self.assertRaises(SystemExit), redirect_stderr(StringIO()):
                quality.check_source_range_tables("Canada & Court & 1/2 & 0.000", "All currently validation-counted source-range checks; Response; no-current-miss state", self.rows)
            self.rows[1]["withinTarget"] = "true"
            self.rows[1]["gap"] = "0.000"
            quality.check_source_range_tables("Canada & Court & 2/2 & 0.000", "All currently validation-counted source-range checks; broadening source-backed coverage; no-current-miss state", self.rows)


if __name__ == "__main__":
    unittest.main()
