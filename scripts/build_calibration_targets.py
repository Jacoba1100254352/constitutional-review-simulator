#!/usr/bin/env python3
"""Build calibration target CSVs from the source-observation matrix."""

from __future__ import annotations

import argparse
import csv
import sys
from collections import defaultdict
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
SOURCE_PATH = ROOT / "config" / "calibration-source-observations.csv"
CALIBRATION_DIR = ROOT / "config" / "calibration"
COMPATIBILITY_PATH = ROOT / "config" / "calibration-targets.csv"

TARGET_HEADER = [
    "profileKey",
    "court",
    "timePeriod",
    "targetKey",
    "label",
    "lowerBound",
    "upperBound",
    "observedValue",
    "n",
    "unit",
    "method",
    "reliability",
    "useForValidation",
    "note",
    "sourceName",
    "sourceUrl",
]


def read_source() -> list[dict[str, str]]:
    with SOURCE_PATH.open(newline="", encoding="utf-8") as handle:
        return list(csv.DictReader(handle))


def csv_text(rows: list[dict[str, str]], header: list[str]) -> str:
    from io import StringIO

    buffer = StringIO()
    writer = csv.DictWriter(buffer, fieldnames=header, lineterminator="\n")
    writer.writeheader()
    for row in rows:
        writer.writerow({key: row.get(key, "") for key in header})
    return buffer.getvalue()


def target_groups(rows: list[dict[str, str]]) -> dict[str, list[dict[str, str]]]:
    grouped: dict[str, list[dict[str, str]]] = defaultdict(list)
    for row in rows:
        target_file = row["targetFile"].strip()
        if not target_file:
            raise ValueError("calibration source row is missing targetFile")
        grouped[target_file].append(row)
    return dict(sorted(grouped.items()))


def expected_outputs(rows: list[dict[str, str]]) -> dict[Path, str]:
    outputs: dict[Path, str] = {}
    for target_file, group in target_groups(rows).items():
        outputs[CALIBRATION_DIR / target_file] = csv_text(group, TARGET_HEADER)
    modern_rows = [
        row
        for row in rows
        if row["targetFile"] == "us-supreme-court-2000-2024.csv"
    ]
    outputs[COMPATIBILITY_PATH] = csv_text(modern_rows, TARGET_HEADER)
    return outputs


def check_outputs(outputs: dict[Path, str]) -> list[Path]:
    mismatches: list[Path] = []
    for path, expected in outputs.items():
        actual = path.read_text(encoding="utf-8") if path.exists() else ""
        if actual != expected:
            mismatches.append(path)
    return mismatches


def write_outputs(outputs: dict[Path, str]) -> None:
    for path, content in outputs.items():
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(content, encoding="utf-8")


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--write", action="store_true", help="rewrite generated calibration target CSVs")
    parser.add_argument("--check", action="store_true", help="fail if generated targets differ from checked-in files")
    args = parser.parse_args()

    rows = read_source()
    outputs = expected_outputs(rows)
    if args.write:
        write_outputs(outputs)
    if args.check or not args.write:
        mismatches = check_outputs(outputs)
        if mismatches:
            for path in mismatches:
                print(f"calibration target out of date: {path.relative_to(ROOT)}", file=sys.stderr)
            return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
