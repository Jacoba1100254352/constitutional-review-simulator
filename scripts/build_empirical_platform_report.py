#!/usr/bin/env python3
"""Build empirical calibration-platform coverage reports."""

from __future__ import annotations

import argparse
import csv
from collections import Counter, defaultdict
from pathlib import Path

import build_court_profiles


ROOT = Path(__file__).resolve().parents[1]
PROFILE_INDEX = ROOT / "config" / "court-profiles" / "profile-index.csv"
CALIBRATION_SOURCE = ROOT / "config" / "calibration-source-observations.csv"
VALIDATION_MISSES = ROOT / "reports" / "constitutional-review-validation-v1-misses.csv"
REPORT_PREFIX = ROOT / "reports" / "constitutional-review-empirical-platform-v1"
PROFILE_REPORT = REPORT_PREFIX.with_suffix(".csv")
FAMILY_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-families.csv"
MARKDOWN_REPORT = REPORT_PREFIX.with_suffix(".md")

PROFILE_REPORT_HEADER = [
    "profileKey",
    "court",
    "timePeriod",
    "empiricalStatus",
    "sourceRows",
    "validationRows",
    "validationFamilies",
    "stressOnlyFamilies",
    "missingValidationFamilies",
    "withinTargetRows",
    "outOfRangeRows",
    "largestGap",
    "largestGapTarget",
    "largestGapCategory",
    "nextCalibrationPriority",
]

FAMILY_REPORT_HEADER = [
    "profileKey",
    "court",
    "targetFamily",
    "coverageStatus",
    "sourceRows",
    "validationRows",
    "stressOnlyRows",
    "outOfRangeRows",
    "largestGap",
    "largestGapTarget",
    "largestGapCategory",
    "nextAction",
]

MISS_HEADER = [
    "profileKey",
    "court",
    "timePeriod",
    "targetKey",
    "label",
    "sourceName",
    "sourceUrl",
    "observedValue",
    "sourceRange",
    "targetN",
    "modelObservedValue",
    "modelInterval",
    "gap",
    "withinTarget",
    "missCategory",
    "interpretation",
    "nextAction",
]


def read_rows(path: Path, expected_header: list[str]) -> list[dict[str, str]]:
    with path.open(newline="", encoding="utf-8") as handle:
        reader = csv.DictReader(handle)
        if reader.fieldnames != expected_header:
            expected = ", ".join(expected_header)
            actual = ", ".join(reader.fieldnames or [])
            raise SystemExit(f"{path.relative_to(ROOT)} header mismatch; expected {expected}; got {actual}")
        return list(reader)


def csv_text(rows: list[dict[str, str]], header: list[str]) -> str:
    from io import StringIO

    buffer = StringIO()
    writer = csv.DictWriter(buffer, fieldnames=header, lineterminator="\n")
    writer.writeheader()
    for row in rows:
        writer.writerow({key: row.get(key, "") for key in header})
    return buffer.getvalue()


def split_families(value: str) -> set[str]:
    return {part for part in value.split("|") if part}


def gap_value(row: dict[str, str]) -> float:
    try:
        return float(row.get("gap", "0") or 0)
    except ValueError:
        return 0.0


def format_gap(value: float) -> str:
    return f"{value:.3f}"


def profile_miss_index(rows: list[dict[str, str]]) -> dict[str, list[dict[str, str]]]:
    grouped: dict[str, list[dict[str, str]]] = defaultdict(list)
    for row in rows:
        grouped[row["profileKey"]].append(row)
    return grouped


def family_miss_index(rows: list[dict[str, str]]) -> dict[tuple[str, str], list[dict[str, str]]]:
    grouped: dict[tuple[str, str], list[dict[str, str]]] = defaultdict(list)
    for row in rows:
        family = build_court_profiles.family_for(row["targetKey"])
        grouped[(row["profileKey"], family)].append(row)
    return grouped


def source_family_counts(rows: list[dict[str, str]]) -> dict[tuple[str, str], Counter[str]]:
    counts: dict[tuple[str, str], Counter[str]] = defaultdict(Counter)
    for row in rows:
        family = build_court_profiles.family_for(row["targetKey"])
        key = (row["profileKey"], family)
        counts[key]["sourceRows"] += 1
        if row["useForValidation"].lower() == "true":
            counts[key]["validationRows"] += 1
        else:
            counts[key]["stressOnlyRows"] += 1
    return counts


def largest_row(rows: list[dict[str, str]]) -> dict[str, str] | None:
    if not rows:
        return None
    return max(rows, key=gap_value)


def out_of_range(rows: list[dict[str, str]]) -> list[dict[str, str]]:
    return [row for row in rows if row["withinTarget"].lower() != "true"]


def profile_report_rows(
        profiles: list[dict[str, str]],
        misses_by_profile: dict[str, list[dict[str, str]]],
) -> list[dict[str, str]]:
    output: list[dict[str, str]] = []
    for profile in profiles:
        miss_rows = misses_by_profile.get(profile["profileKey"], [])
        failures = out_of_range(miss_rows)
        largest = largest_row(failures)
        output.append(
            {
                "profileKey": profile["profileKey"],
                "court": profile["court"],
                "timePeriod": profile["timePeriod"],
                "empiricalStatus": profile["empiricalStatus"],
                "sourceRows": profile["sourceRows"],
                "validationRows": profile["validationRows"],
                "validationFamilies": profile["validationFamilies"],
                "stressOnlyFamilies": profile["stressOnlyFamilies"],
                "missingValidationFamilies": profile["missingValidationFamilies"],
                "withinTargetRows": str(sum(1 for row in miss_rows if row["withinTarget"].lower() == "true")),
                "outOfRangeRows": str(len(failures)),
                "largestGap": format_gap(gap_value(largest)) if largest else "0.000",
                "largestGapTarget": largest["label"] if largest else "",
                "largestGapCategory": largest["missCategory"] if largest else "",
                "nextCalibrationPriority": profile["nextCalibrationPriority"],
            }
        )
    return output


def family_report_rows(
        profiles: list[dict[str, str]],
        counts: dict[tuple[str, str], Counter[str]],
        misses_by_family: dict[tuple[str, str], list[dict[str, str]]],
) -> list[dict[str, str]]:
    output: list[dict[str, str]] = []
    for profile in profiles:
        profile_key = profile["profileKey"]
        validation_families = split_families(profile["validationFamilies"])
        stress_families = split_families(profile["stressOnlyFamilies"])
        for family in build_court_profiles.PLATFORM_FAMILY_ORDER:
            key = (profile_key, family)
            count = counts.get(key, Counter())
            miss_rows = misses_by_family.get(key, [])
            failures = out_of_range(miss_rows)
            largest = largest_row(failures)
            if family in validation_families:
                coverage_status = "validation-counted"
            elif family in stress_families:
                coverage_status = "stress-only"
            else:
                coverage_status = "missing"
            output.append(
                {
                    "profileKey": profile_key,
                    "court": profile["court"],
                    "targetFamily": family,
                    "coverageStatus": coverage_status,
                    "sourceRows": str(count["sourceRows"]),
                    "validationRows": str(count["validationRows"]),
                    "stressOnlyRows": str(count["stressOnlyRows"]),
                    "outOfRangeRows": str(len(failures)),
                    "largestGap": format_gap(gap_value(largest)) if largest else "0.000",
                    "largestGapTarget": largest["label"] if largest else "",
                    "largestGapCategory": largest["missCategory"] if largest else "",
                    "nextAction": largest["nextAction"] if largest else "",
                }
            )
    return output


def md_escape(value: str) -> str:
    return value.replace("|", "\\|").replace("\n", " ")


def markdown_table(header: list[str], rows: list[list[str]]) -> list[str]:
    lines = [
        "| " + " | ".join(header) + " |",
        "| " + " | ".join("---" for _ in header) + " |",
    ]
    for row in rows:
        lines.append("| " + " | ".join(md_escape(value) for value in row) + " |")
    return lines


def markdown_report(
        profile_rows: list[dict[str, str]],
        family_rows: list[dict[str, str]],
        source_rows: list[dict[str, str]],
        miss_rows: list[dict[str, str]],
) -> str:
    status_counts = Counter(row["empiricalStatus"] for row in profile_rows)
    validation_family_counts = Counter()
    stress_family_counts = Counter()
    missing_family_counts = Counter()
    for row in family_rows:
        if row["coverageStatus"] == "validation-counted":
            validation_family_counts[row["targetFamily"]] += 1
        elif row["coverageStatus"] == "stress-only":
            stress_family_counts[row["targetFamily"]] += 1
        else:
            missing_family_counts[row["targetFamily"]] += 1

    failures = out_of_range(miss_rows)
    miss_category_counts = Counter(row["missCategory"] for row in failures)
    top_profiles = sorted(profile_rows, key=lambda row: (-float(row["largestGap"]), row["profileKey"]))[:8]

    lines = [
        "# Empirical Platform Coverage Report",
        "",
        "This generated report summarizes the reusable calibration-platform surface. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, and `reports/constitutional-review-validation-v1-misses.csv`.",
        "",
        "## Summary",
        "",
        f"- Court profiles: {len(profile_rows)}",
        f"- Calibration source rows: {len(source_rows)}",
        f"- Validation-counted source rows: {sum(int(row['validationRows']) for row in profile_rows)}",
        f"- Validation rows within source range: {sum(1 for row in miss_rows if row['withinTarget'].lower() == 'true')}",
        f"- Validation rows out of range: {len(failures)}",
        "",
        "## Profile Status",
        "",
    ]
    lines.extend(
        markdown_table(
            ["Status", "Profiles"],
            [[status, str(status_counts[status])] for status in sorted(status_counts)],
        )
    )
    lines.extend(["", "## Target-Family Coverage", ""])
    lines.extend(
        markdown_table(
            ["Family", "Validation profiles", "Stress-only profiles", "Missing profiles"],
            [
                [
                    family,
                    str(validation_family_counts[family]),
                    str(stress_family_counts[family]),
                    str(missing_family_counts[family]),
                ]
                for family in build_court_profiles.PLATFORM_FAMILY_ORDER
            ],
        )
    )
    lines.extend(["", "## Out-of-Range Categories", ""])
    if miss_category_counts:
        lines.extend(
            markdown_table(
                ["Category", "Rows"],
                [[category, str(miss_category_counts[category])] for category in sorted(miss_category_counts)],
            )
        )
    else:
        lines.append("No out-of-range validation rows are reported.")
    lines.extend(["", "## Largest Profile Gaps", ""])
    lines.extend(
        markdown_table(
            ["Profile", "Status", "Validation families", "Out of range", "Largest miss", "Gap", "Next priority"],
            [
                [
                    row["profileKey"],
                    row["empiricalStatus"],
                    row["validationFamilies"] or "--",
                    row["outOfRangeRows"],
                    row["largestGapTarget"] or "--",
                    row["largestGap"],
                    row["nextCalibrationPriority"],
                ]
                for row in top_profiles
            ],
        )
    )
    lines.extend(
        [
            "",
            "The coverage report is a planning artifact. Validation-counted rows remain limited to source-backed targets with denominators and direct simulator analogues; stress-only and missing families should not be described as country validation evidence.",
            "",
        ]
    )
    return "\n".join(lines)


def expected_outputs() -> dict[Path, str]:
    profiles = read_rows(PROFILE_INDEX, build_court_profiles.PROFILE_HEADER)
    source_rows = read_rows(CALIBRATION_SOURCE, build_court_profiles.SOURCE_HEADER)
    miss_rows = read_rows(VALIDATION_MISSES, MISS_HEADER)
    misses_by_profile = profile_miss_index(miss_rows)
    misses_by_family = family_miss_index(miss_rows)
    counts = source_family_counts(source_rows)
    profile_rows = profile_report_rows(profiles, misses_by_profile)
    family_rows = family_report_rows(profiles, counts, misses_by_family)
    return {
        PROFILE_REPORT: csv_text(profile_rows, PROFILE_REPORT_HEADER),
        FAMILY_REPORT: csv_text(family_rows, FAMILY_REPORT_HEADER),
        MARKDOWN_REPORT: markdown_report(profile_rows, family_rows, source_rows, miss_rows),
    }


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
    parser.add_argument("--write", action="store_true", help="rewrite empirical platform coverage reports")
    parser.add_argument("--check", action="store_true", help="fail if generated reports differ from checked-in files")
    args = parser.parse_args()

    outputs = expected_outputs()
    if args.write:
        write_outputs(outputs)
    if args.check or not args.write:
        mismatches = check_outputs(outputs)
        if mismatches:
            for path in mismatches:
                print(f"empirical platform report out of date: {path.relative_to(ROOT)}")
            return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
