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

SOURCE_HEADER = ["targetFile", *TARGET_HEADER, "constructionNote"]

WEAK_SOURCE_NAMES = {
    "Comparative calibration research synthesis",
    "Institutional cost benchmark synthesis",
}

GENERIC_CONSTRUCTION_NOTE = (
    "Checked-in target is regenerated from this normalized source-observation row"
)


def read_source() -> list[dict[str, str]]:
    with SOURCE_PATH.open(newline="", encoding="utf-8") as handle:
        reader = csv.DictReader(handle)
        if reader.fieldnames != SOURCE_HEADER:
            expected = ", ".join(SOURCE_HEADER)
            actual = ", ".join(reader.fieldnames or [])
            raise SystemExit(f"calibration source header mismatch; expected {expected}; got {actual}")
        return list(reader)


def validate_source_rows(rows: list[dict[str, str]]) -> None:
    errors: list[str] = []
    for index, row in enumerate(rows, start=2):
        label = f"line {index} {row.get('profileKey', '')}/{row.get('targetKey', '')}"
        if GENERIC_CONSTRUCTION_NOTE in row.get("constructionNote", ""):
            errors.append(f"{label}: constructionNote is still generic")
        if row.get("useForValidation", "").lower() != "true":
            continue

        source_url = row.get("sourceUrl", "").strip()
        reliability = row.get("reliability", "").strip().lower()
        source_name = row.get("sourceName", "").strip()
        method = row.get("method", "").strip().lower()
        unit = row.get("unit", "").strip().lower()
        n = row.get("n", "").strip()
        has_n = bool(n and n != "0")

        if not source_url:
            errors.append(f"{label}: validation row is missing sourceUrl")
        if not has_n:
            errors.append(f"{label}: validation row is missing a nonzero denominator")
        if reliability == "low":
            errors.append(f"{label}: low-reliability row cannot be validation evidence")
        if source_name in WEAK_SOURCE_NAMES or "synthesis" in source_name.lower():
            errors.append(f"{label}: synthesis source cannot be validation evidence")
        if "synthesis" in method:
            errors.append(f"{label}: synthesis method cannot be validation evidence")
        if "normalized" in unit or "benchmark cost" in method or "public-trust" in method:
            errors.append(f"{label}: contextual trust or normalized-cost proxy cannot be validation evidence")

    if errors:
        for error in errors:
            print(f"calibration source error: {error}", file=sys.stderr)
        raise SystemExit(1)


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
    validate_source_rows(rows)
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
