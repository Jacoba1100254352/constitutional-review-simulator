"""Source caveats must not disappear through malformed CSV fields."""

from contextlib import redirect_stderr
from io import StringIO
import unittest

import build_calibration_targets as calibration


class CalibrationMeasurementTests(unittest.TestCase):
    def test_source_width_and_complete_south_africa_caveat(self):
        rows = calibration.read_source()
        calibration.validate_source_rows(rows)
        for row in rows:
            self.assertEqual(set(row), set(calibration.SOURCE_HEADER))
        throughput = next(row for row in rows if row["profileKey"] == "south-africa-constcourt-recent"
                          and row["targetKey"] == "intake_acceptance_rate")
        self.assertIn(", not as a full merits review-rate estimate.", throughput["constructionNote"])
        for malformed in (dict(rows[0], constructionNote=None), {**rows[0], None: ["lost caveat"]}):
            with self.assertRaises(SystemExit), redirect_stderr(StringIO()):
                calibration.validate_source_rows([malformed])


if __name__ == "__main__":
    unittest.main()
