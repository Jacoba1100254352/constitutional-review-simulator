#!/usr/bin/env python3
"""Validate research CSV hygiene for the empirical platform."""

from __future__ import annotations

import csv
import sys
from decimal import Decimal, InvalidOperation
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

BOOLEAN_VALUES = {"true", "false"}
RELIABILITY_VALUES = {"high", "medium", "low"}
LEGISLATIVE_EVIDENCE_STATUSES = {
    "promoted",
    "qualitative",
    "source-candidate",
    "verified-source-candidate",
}
COMPARATIVE_CALIBRATION_ACTIONS = {
    "context-only",
    "promote-after-url-verification",
    "promoted",
    "source-gap",
    "verified-model-gap",
    "verified-source-candidate",
    "verified-context-only",
}
TRANSPLANT_EVIDENCE_STATUSES = {
    "derived-from-source-families",
    "source-family-identified",
}
SOURCE_URL_STATUS_LITERALS = {
    "not-available-in-report",
    "pending-url-verification",
}
SOURCE_URL_STATUS_PREFIXES = (
    "verified:https://",
    "verified:http://",
    "verified-bibliography-only:https://",
    "verified-bibliography-only:http://",
)
NUMERIC_FIELDS = {"observedValue", "lowerBound", "upperBound", "numerator", "denominator"}
RATIO_TOLERANCE = Decimal("0.003")
ZERO = Decimal("0")
ONE = Decimal("1")


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
            check_status_fields(path.name, row, label, errors)
            check_numeric_fields(row, label, errors)


def check_status_fields(filename: str, row: dict[str, str], label: str, errors: list[str]) -> None:
    if "reliability" in row:
        require_member(row["reliability"], RELIABILITY_VALUES, "reliability", label, errors)
    if "directAnalogue" in row:
        require_member(row["directAnalogue"].lower(), BOOLEAN_VALUES, "directAnalogue", label, errors)
    if "validationUseIfDocumented" in row:
        require_member(row["validationUseIfDocumented"].lower(), BOOLEAN_VALUES, "validationUseIfDocumented", label, errors)
    if "sourceUrlStatus" in row:
        check_source_url_status(row["sourceUrlStatus"], label, errors)
    if filename == "legislative-response-source-candidates.csv":
        require_member(row["evidenceStatus"], LEGISLATIVE_EVIDENCE_STATUSES, "evidenceStatus", label, errors)
    if filename == "comparative-calibration-source-candidates.csv":
        require_member(row["calibrationAction"], COMPARATIVE_CALIBRATION_ACTIONS, "calibrationAction", label, errors)
        if row["calibrationAction"] == "verified-model-gap":
            if not row["sourceUrlStatus"].startswith(("verified:https://", "verified:http://")):
                errors.append(f"{label}: verified-model-gap requires a verified public source URL")
            if not row["denominator"].strip() or row["denominator"].strip() == "0":
                errors.append(f"{label}: verified-model-gap requires a nonzero source denominator")
            if row["directAnalogue"].lower() != "false":
                errors.append(f"{label}: verified-model-gap must remain non-direct until the matching simulator metric exists")
    if filename == "transplant-indicator-operationalization.csv":
        require_member(row["evidenceStatus"], TRANSPLANT_EVIDENCE_STATUSES, "evidenceStatus", label, errors)


def require_member(value: str, allowed: set[str], field: str, label: str, errors: list[str]) -> None:
    if value not in allowed:
        errors.append(f"{label}: {field} has unsupported value {value!r}")


def check_source_url_status(value: str, label: str, errors: list[str]) -> None:
    if value in SOURCE_URL_STATUS_LITERALS:
        return
    if value.startswith(SOURCE_URL_STATUS_PREFIXES):
        url = value.split(":", 1)[1]
        if not url.startswith(("https://", "http://")):
            errors.append(f"{label}: sourceUrlStatus verified prefix must include a public URL")
        return
    errors.append(f"{label}: sourceUrlStatus has unsupported value {value!r}")


def check_numeric_fields(row: dict[str, str], label: str, errors: list[str]) -> None:
    if not NUMERIC_FIELDS.issubset(row):
        return

    values: dict[str, Decimal] = {}
    for field in sorted(NUMERIC_FIELDS):
        raw_value = row[field].strip()
        if not raw_value:
            continue
        try:
            values[field] = Decimal(raw_value)
        except InvalidOperation:
            errors.append(f"{label}: field {field} must be numeric when present; got {raw_value!r}")

    lower = values.get("lowerBound")
    upper = values.get("upperBound")
    observed = values.get("observedValue")
    numerator = values.get("numerator")
    denominator = values.get("denominator")
    unit = row.get("unit", "").strip()

    if lower is not None and upper is not None and lower > upper:
        errors.append(f"{label}: lowerBound cannot exceed upperBound")
    if observed is not None and lower is not None and observed < lower:
        errors.append(f"{label}: observedValue cannot be below lowerBound")
    if observed is not None and upper is not None and observed > upper:
        errors.append(f"{label}: observedValue cannot exceed upperBound")

    if (numerator is None) != (denominator is None):
        errors.append(f"{label}: numerator and denominator must be provided together")
    if numerator is not None and numerator < ZERO:
        errors.append(f"{label}: numerator cannot be negative")
    if denominator is not None and denominator <= ZERO:
        errors.append(f"{label}: denominator must be positive when present")

    if unit == "share":
        for field in ("observedValue", "lowerBound", "upperBound"):
            value = values.get(field)
            if value is not None and (value < ZERO or value > ONE):
                errors.append(f"{label}: {field} share value must be between 0 and 1")
        if numerator is not None and denominator is not None:
            if numerator > denominator:
                errors.append(f"{label}: numerator cannot exceed denominator for share rows")
            elif observed is not None:
                ratio = numerator / denominator
                if abs(observed - ratio) > RATIO_TOLERANCE:
                    errors.append(
                        f"{label}: observedValue {observed} differs from numerator/denominator ratio {ratio:.6f}"
                    )


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
