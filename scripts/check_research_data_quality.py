#!/usr/bin/env python3
"""Validate research CSV hygiene for the empirical platform."""

from __future__ import annotations

import csv
import sys
from pathlib import Path

import build_empirical_platform_report


ROOT = Path(__file__).resolve().parents[1]
RESEARCH_DIR = ROOT / "config" / "research"

EXPECTED_HEADERS = {
    "case-selection-targets.csv": [
        "targetKey",
        "simulatorFieldOrMetric",
        "unit",
        "preferredSystems",
        "neededDenominator",
        "codingNotes",
    ],
    "comparative-calibration-source-candidates.csv": [
        "profileKey",
        "courtOrSystem",
        "period",
        "targetKey",
        "label",
        "observedValue",
        "lowerBound",
        "upperBound",
        "numerator",
        "denominator",
        "unit",
        "reliability",
        "directAnalogue",
        "calibrationAction",
        "sourceTrail",
        "sourceUrlStatus",
        "notes",
    ],
    "compliance-enforcement-targets.csv": [
        "targetKey",
        "simulatorMetric",
        "unit",
        "preferredSystems",
        "neededDenominator",
        "codingNotes",
    ],
    "empirical-target-roadmap.csv": [
        "profileKey",
        "courtOrSystem",
        "period",
        "targetFamily",
        "targetKey",
        "neededObservedValue",
        "neededDenominator",
        "preferredSources",
        "validationUseIfDocumented",
        "notes",
    ],
    "legislative-response-evidence.csv": [
        "mechanism",
        "targetKey",
        "unit",
        "preferredSystems",
        "neededDenominator",
        "notes",
    ],
    "legislative-response-source-candidates.csv": [
        "system",
        "mechanism",
        "period",
        "targetKey",
        "label",
        "observedValue",
        "lowerBound",
        "upperBound",
        "numerator",
        "denominator",
        "unit",
        "evidenceStatus",
        "reliability",
        "directAnalogue",
        "sourceTrail",
        "sourceUrlStatus",
        "notes",
    ],
    "transplant-feasibility-factors.csv": [
        "factor",
        "simulatorField",
        "expectedDirection",
        "measurementCandidates",
        "notes",
    ],
    "transplant-indicator-operationalization.csv": [
        "indicator",
        "simulatorField",
        "operationalMeasure",
        "sourceFamilies",
        "timeCoverage",
        "recommendedRawRange",
        "modelUse",
        "evidenceStatus",
        "notes",
    ],
}

KNOWN_ROADMAP_FAMILIES = set(build_empirical_platform_report.ROADMAP_FAMILY_ALIASES)


def check_csv(path: Path, errors: list[str]) -> None:
    expected = EXPECTED_HEADERS.get(path.name)
    with path.open(newline="", encoding="utf-8") as handle:
        reader = csv.DictReader(handle)
        if expected is None:
            errors.append(f"{path.relative_to(ROOT)}: no expected header registered")
            return
        if reader.fieldnames != expected:
            errors.append(
                f"{path.relative_to(ROOT)}: header mismatch; expected {expected}; got {reader.fieldnames}"
            )
            return
        for line_number, row in enumerate(reader, start=2):
            label = f"{path.relative_to(ROOT)}:{line_number}"
            if None in row:
                errors.append(f"{label}: row has extra CSV cells; quote comma-containing text fields")
            for field, value in row.items():
                if field is None:
                    continue
                if value is None:
                    errors.append(f"{label}: missing value for field {field}")
                    continue
                if field in required_fields(path.name) and not value.strip():
                    errors.append(f"{label}: required field {field} is blank")
            if "targetKey" in row:
                family = build_empirical_platform_report.target_family(row["targetKey"])
                if not family:
                    errors.append(f"{label}: targetKey {row['targetKey']} is not mapped to a platform family")
            if path.name == "empirical-target-roadmap.csv":
                target_family = row["targetFamily"].strip()
                if target_family and target_family not in KNOWN_ROADMAP_FAMILIES:
                    errors.append(f"{label}: targetFamily {target_family} is not mapped to a platform family")


def required_fields(filename: str) -> set[str]:
    if filename in {
            "case-selection-targets.csv",
            "compliance-enforcement-targets.csv",
            "legislative-response-evidence.csv",
    }:
        return set(EXPECTED_HEADERS[filename])
    if filename == "empirical-target-roadmap.csv":
        return {"profileKey", "courtOrSystem", "targetFamily", "targetKey", "preferredSources", "notes"}
    if filename.endswith("-source-candidates.csv") or filename == "comparative-calibration-source-candidates.csv":
        return {"targetKey", "label", "unit", "reliability", "directAnalogue", "sourceUrlStatus", "notes"}
    return set()


def main() -> int:
    errors: list[str] = []
    expected_files = set(EXPECTED_HEADERS)
    actual_files = {path.name for path in RESEARCH_DIR.glob("*.csv")}
    for missing in sorted(expected_files - actual_files):
        errors.append(f"config/research/{missing}: expected research CSV is missing")
    for extra in sorted(actual_files - expected_files):
        errors.append(f"config/research/{extra}: unexpected research CSV; add schema to check_research_data_quality.py")
    for path in sorted(RESEARCH_DIR.glob("*.csv")):
        check_csv(path, errors)
    if errors:
        for error in errors:
            print(f"research data error: {error}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
