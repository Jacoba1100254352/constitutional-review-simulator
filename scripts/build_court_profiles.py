#!/usr/bin/env python3
"""Build a derived empirical court-profile index.

The calibration source-observation matrix remains the source of truth. This
script creates a profile-level index so replication users can see which court
profiles are already source-range usable and which profile families still need
denominator-backed data.
"""

from __future__ import annotations

import argparse
import csv
import sys
from collections import defaultdict
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
CALIBRATION_SOURCE = ROOT / "config" / "calibration-source-observations.csv"
CONTEXT_SOURCE = ROOT / "config" / "context" / "country-year-context.csv"
PROFILE_DIR = ROOT / "config" / "court-profiles"
PROFILE_INDEX = PROFILE_DIR / "profile-index.csv"

PROFILE_HEADER = [
    "profileKey",
    "court",
    "timePeriod",
    "targetFile",
    "contextScenarioKey",
    "contextSourceFamily",
    "sourceRows",
    "validationRows",
    "highReliabilityRows",
    "mediumReliabilityRows",
    "lowReliabilityRows",
    "sourceUrlRows",
    "denominatorRows",
    "validationFamilies",
    "stressOnlyFamilies",
    "missingValidationFamilies",
    "empiricalStatus",
    "nextCalibrationPriority",
]

SOURCE_HEADER = [
    "targetFile",
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
    "constructionNote",
]

CONTEXT_HEADER = [
    "scenarioKey",
    "system",
    "period",
    "publicTrust",
    "partisanPressure",
    "partyFragmentation",
    "governmentControl",
    "electoralTimePressure",
    "civilSocietyCapacity",
    "implementationCapacity",
    "legalTraditionCompatibility",
    "legislativeConflict",
    "sourceFamily",
    "sourceUrl",
    "applyInValidation",
    "note",
]

CONTEXT_OVERRIDES = {
    "canada-scc-2024": "canadian-supreme-court",
    "canada-scc-recent": "canadian-supreme-court",
    "cjeu-2024": "cjeu-court-of-justice",
    "cost-france-conseil": "french-constitutional-council",
    "cost-uk-supreme-court": "uk-supreme-court",
    "cost-us-supreme-court": "us-supreme-court-benchmark",
    "echr-2024": "echr-treaty-court",
    "france-conseil-qpc": "french-constitutional-council",
    "gallup-court-confidence-2024": "us-supreme-court-benchmark",
    "germany-bverfg-2024": "german-constitutional-court",
    "scdb-modern-merits-2000-2024": "us-supreme-court-benchmark",
    "scdb-postwar-merits-1946-2024": "us-supreme-court-benchmark",
    "scotus-emergency-2024-2025": "us-supreme-court-benchmark",
    "south-africa-constcourt-recent": "south-african-constitutional-court",
    "uk-human-rights-doi-2025": "uk-supreme-court",
    "uk-supreme-court-2024-2025": "uk-supreme-court",
}

PLATFORM_FAMILY_ORDER = [
    "intake",
    "case-selection",
    "emergency",
    "merits",
    "remedy-timing",
    "legislative-response",
    "route-mix",
    "compliance",
    "cost",
    "doctrine-mix",
    "political-context",
]

TARGET_FAMILIES = {
    "abstract_review_rate": "case-selection",
    "appeal_route_rate": "route-mix",
    "capacity_strain_cost": "cost",
    "case_selection_access": "case-selection",
    "direct_action_rate": "route-mix",
    "direct_court_cost": "cost",
    "emergency_public_disagreement_rate": "emergency",
    "emergency_reason_giving_rate": "emergency",
    "emergency_relief_rate": "emergency",
    "emergency_vote_disclosure_rate": "emergency",
    "government_emergency_win_rate": "emergency",
    "intake_acceptance_rate": "intake",
    "legislative_response_credibility": "legislative-response",
    "legislative_response_delay": "legislative-response",
    "legislative_response_rate": "legislative-response",
    "merits_follow_up_rate": "emergency",
    "merits_invalidation_rate": "merits",
    "ombudsman_trigger_rate": "case-selection",
    "pre_enactment_review_rate": "case-selection",
    "preliminary_reference_rate": "route-mix",
    "public_defender_participation_rate": "case-selection",
    "public_trust": "political-context",
    "review_rate": "intake",
    "rights_impact_statement_rate": "case-selection",
    "suspended_declaration_rate": "remedy-timing",
    "timely_legislative_response_rate": "legislative-response",
    "total_institutional_cost": "cost",
    "upstream_screening_cost": "cost",
    "weak_form_declaration_rate": "legislative-response",
}


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


def nonzero(value: str) -> bool:
    return bool(value.strip()) and value.strip() != "0"


def family_for(target_key: str) -> str:
    if target_key.startswith("doctrine_mix."):
        return "doctrine-mix"
    if target_key not in TARGET_FAMILIES:
        raise SystemExit(f"no court-profile target family mapping for targetKey {target_key}")
    return TARGET_FAMILIES[target_key]


def sorted_join(values: set[str]) -> str:
    return "|".join(value for value in PLATFORM_FAMILY_ORDER if value in values)


def context_index(rows: list[dict[str, str]]) -> dict[str, dict[str, str]]:
    return {row["scenarioKey"]: row for row in rows}


def empirical_status(profile_key: str, validation_rows: int, validation_families: set[str], source_url_rows: int) -> str:
    if profile_key.startswith("cost-"):
        return "cost-benchmark-profile"
    if validation_rows >= 3 and len(validation_families) >= 2:
        return "multi-target-validation-profile"
    if validation_rows > 0:
        return "partial-validation-profile"
    if source_url_rows > 0:
        return "source-backed-stress-profile"
    return "stress-assumption-profile"


def next_priority(profile_key: str, missing: list[str], validation_rows: int, stress_families: set[str]) -> str:
    if not missing:
        return "complete current platform scope before adding new target families"
    if profile_key.startswith("cost-"):
        return "archive cost normalization workbook and denominators before validation use"
    stress_candidates = [family for family in PLATFORM_FAMILY_ORDER if family in missing and family in stress_families]
    lead = stress_candidates[0] if stress_candidates else missing[0]
    if lead == "cost":
        return "archive cost normalization workbook and denominators before validation use"
    if validation_rows == 0 or lead in stress_families:
        return f"promote denominator-backed {lead} source rows"
    return f"add denominator-backed {lead} source rows"


def profile_index_rows(source_rows: list[dict[str, str]], context_rows: list[dict[str, str]]) -> list[dict[str, str]]:
    grouped: dict[str, list[dict[str, str]]] = defaultdict(list)
    for row in source_rows:
        grouped[row["profileKey"]].append(row)

    contexts = context_index(context_rows)
    output: list[dict[str, str]] = []
    for profile_key in sorted(grouped):
        rows = grouped[profile_key]
        courts = sorted({row["court"] for row in rows})
        periods = sorted({row["timePeriod"] for row in rows})
        target_files = sorted({row["targetFile"] for row in rows})
        validation_families: set[str] = set()
        stress_families: set[str] = set()
        reliability_counts = {"high": 0, "medium": 0, "low": 0}
        source_url_rows = 0
        denominator_rows = 0
        validation_rows = 0

        for row in rows:
            family = family_for(row["targetKey"])
            if row["useForValidation"].lower() == "true":
                validation_rows += 1
                validation_families.add(family)
            else:
                stress_families.add(family)
            reliability = row["reliability"].lower()
            if reliability in reliability_counts:
                reliability_counts[reliability] += 1
            if row["sourceUrl"].strip():
                source_url_rows += 1
            if nonzero(row["n"]):
                denominator_rows += 1

        missing = [family for family in PLATFORM_FAMILY_ORDER if family not in validation_families]
        context_key = CONTEXT_OVERRIDES.get(profile_key, "")
        context = contexts.get(context_key, {})
        output.append(
            {
                "profileKey": profile_key,
                "court": " | ".join(courts),
                "timePeriod": " | ".join(periods),
                "targetFile": " | ".join(target_files),
                "contextScenarioKey": context_key,
                "contextSourceFamily": context.get("sourceFamily", ""),
                "sourceRows": str(len(rows)),
                "validationRows": str(validation_rows),
                "highReliabilityRows": str(reliability_counts["high"]),
                "mediumReliabilityRows": str(reliability_counts["medium"]),
                "lowReliabilityRows": str(reliability_counts["low"]),
                "sourceUrlRows": str(source_url_rows),
                "denominatorRows": str(denominator_rows),
                "validationFamilies": sorted_join(validation_families),
                "stressOnlyFamilies": sorted_join(stress_families),
                "missingValidationFamilies": "|".join(missing),
                "empiricalStatus": empirical_status(profile_key, validation_rows, validation_families, source_url_rows),
                "nextCalibrationPriority": next_priority(profile_key, missing, validation_rows, stress_families),
            }
        )
    return output


def validate_profile_index(rows: list[dict[str, str]]) -> None:
    errors: list[str] = []
    seen: set[str] = set()
    for index, row in enumerate(rows, start=2):
        key = row["profileKey"]
        if key in seen:
            errors.append(f"line {index}: duplicate profileKey {key}")
        seen.add(key)
        if row["empiricalStatus"] != "cost-benchmark-profile" and not row["contextScenarioKey"]:
            errors.append(f"line {index} {key}: missing contextScenarioKey")
        if row["validationRows"] != "0" and not row["validationFamilies"]:
            errors.append(f"line {index} {key}: validation rows without validationFamilies")
        if row["sourceUrlRows"] == "0" and row["empiricalStatus"] != "stress-assumption-profile":
            errors.append(f"line {index} {key}: status requires at least one source URL")
    if errors:
        for error in errors:
            print(f"court profile error: {error}", file=sys.stderr)
        raise SystemExit(1)


def check_output(expected: str) -> bool:
    actual = PROFILE_INDEX.read_text(encoding="utf-8") if PROFILE_INDEX.exists() else ""
    return actual == expected


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--write", action="store_true", help="rewrite config/court-profiles/profile-index.csv")
    parser.add_argument("--check", action="store_true", help="fail if the profile index is out of date")
    args = parser.parse_args()

    source_rows = read_rows(CALIBRATION_SOURCE, SOURCE_HEADER)
    context_rows = read_rows(CONTEXT_SOURCE, CONTEXT_HEADER)
    rows = profile_index_rows(source_rows, context_rows)
    validate_profile_index(rows)
    expected = csv_text(rows, PROFILE_HEADER)

    if args.write:
        PROFILE_DIR.mkdir(parents=True, exist_ok=True)
        PROFILE_INDEX.write_text(expected, encoding="utf-8")
    if args.check or not args.write:
        if not check_output(expected):
            print(f"court profile index out of date: {PROFILE_INDEX.relative_to(ROOT)}", file=sys.stderr)
            return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
