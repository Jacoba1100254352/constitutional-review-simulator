#!/usr/bin/env python3
"""Validate calibration promotion hygiene.

The source-candidate CSVs are allowed to contain promising research leads. Rows
counted as validation evidence in config/calibration-source-observations.csv are
held to a stricter standard: they need a source URL, denominator, construction
note, source-specific method, and a simulator target key that the runner can
observe.
"""

from __future__ import annotations

import csv
import sys
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
CALIBRATION_SOURCE = ROOT / "config" / "calibration-source-observations.csv"
RESEARCH_DIR = ROOT / "config" / "research"

SUPPORTED_VALIDATION_KEYS = {
    "doctrine_mix.speech",
    "doctrine_mix.equality",
    "doctrine_mix.criminal_procedure",
    "doctrine_mix.federalism",
    "doctrine_mix.election_law",
    "doctrine_mix.emergency_powers",
    "doctrine_mix.administrative_state",
    "review_rate",
    "intake_acceptance_rate",
    "emergency_relief_rate",
    "emergency_reason_giving_rate",
    "emergency_vote_disclosure_rate",
    "emergency_public_disagreement_rate",
    "government_emergency_win_rate",
    "merits_follow_up_rate",
    "merits_invalidation_rate",
    "override_rate",
    "weak_form_declaration_rate",
    "suspended_declaration_rate",
    "legislative_response_rate",
    "legislative_response_delay",
    "timely_legislative_response_rate",
    "legislative_response_credibility",
    "pre_enactment_review_rate",
    "abstract_review_rate",
    "rights_impact_statement_rate",
    "ombudsman_trigger_rate",
    "public_defender_participation_rate",
    "compliance_rate",
    "legislative_reenactment_rate",
    "public_trust",
    "direct_court_cost",
    "upstream_screening_cost",
    "capacity_strain_cost",
    "total_institutional_cost",
    "legitimacy_trust_gradient",
}


def read_rows(path: Path) -> list[dict[str, str]]:
    with path.open(newline="", encoding="utf-8") as handle:
        return list(csv.DictReader(handle))


def nonzero(value: str) -> bool:
    return bool(value.strip()) and value.strip() != "0"


def check_calibration_source(errors: list[str]) -> None:
    for line_number, row in enumerate(read_rows(CALIBRATION_SOURCE), start=2):
        if row["useForValidation"].lower() != "true":
            continue
        label = f"{CALIBRATION_SOURCE.relative_to(ROOT)}:{line_number} {row['profileKey']}/{row['targetKey']}"
        if row["targetKey"] not in SUPPORTED_VALIDATION_KEYS:
            errors.append(f"{label}: targetKey is not exposed by calibration observation mapping")
        if not row["sourceUrl"].startswith(("https://", "http://")):
            errors.append(f"{label}: validation row must have a public source URL")
        if not nonzero(row["n"]):
            errors.append(f"{label}: validation row must have a nonzero denominator")
        if not row["observedValue"].strip():
            errors.append(f"{label}: validation row must have an observed value")
        if len(row["constructionNote"].strip()) < 30:
            errors.append(f"{label}: validation row needs a reproducible construction note")
        source_name = row["sourceName"].lower()
        method = row["method"].lower()
        if "deep research" in source_name or "synthesis" in source_name or "synthesis" in method:
            errors.append(f"{label}: validation row cannot rely on synthesis or Deep Research as the source")
        if row["unit"].lower() == "normalized" or "public-trust" in method or "benchmark cost" in method:
            errors.append(f"{label}: contextual trust or normalized-cost row cannot be validation evidence")


def check_candidate_file(path: Path, errors: list[str]) -> None:
    rows = read_rows(path)
    if not rows:
        return
    fieldnames = set(rows[0])
    for line_number, row in enumerate(rows, start=2):
        promoted = False
        if "evidenceStatus" in fieldnames:
            promoted = promoted or row["evidenceStatus"].lower() == "promoted"
        if "calibrationAction" in fieldnames:
            promoted = promoted or row["calibrationAction"].lower() == "promoted"
        if not promoted:
            continue
        label = f"{path.relative_to(ROOT)}:{line_number}"
        url_status = row.get("sourceUrlStatus", "")
        if not url_status.startswith("verified:https://"):
            errors.append(f"{label}: promoted candidate must record a verified sourceUrlStatus")
        if not nonzero(row.get("denominator", "")):
            errors.append(f"{label}: promoted candidate must keep its denominator")
        if row.get("directAnalogue", "").lower() != "true":
            errors.append(f"{label}: promoted candidate must be a direct simulator analogue")
        if len(row.get("notes", "").strip()) < 20:
            errors.append(f"{label}: promoted candidate needs a coding note")


def check_candidate_files(errors: list[str]) -> None:
    for path in sorted(RESEARCH_DIR.glob("*.csv")):
        check_candidate_file(path, errors)


def main() -> int:
    errors: list[str] = []
    check_calibration_source(errors)
    check_candidate_files(errors)
    if errors:
        for error in errors:
            print(f"promotion check error: {error}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
