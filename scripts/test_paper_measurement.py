"""Publication gates must preserve period-specific checks and display genuine misses."""

import sys
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
