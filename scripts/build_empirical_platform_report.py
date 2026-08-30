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
PROFILE_CARDS = ROOT / "config" / "court-profiles" / "profile-benchmark-cards.md"
CALIBRATION_SOURCE = ROOT / "config" / "calibration-source-observations.csv"
VALIDATION_MISSES = ROOT / "reports" / "constitutional-review-validation-v1-misses.csv"
REPORT_PREFIX = ROOT / "reports" / "constitutional-review-empirical-platform-v1"
PROFILE_REPORT = REPORT_PREFIX.with_suffix(".csv")
FAMILY_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-families.csv"
PROMOTION_QUEUE_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-promotion-queue.csv"
SOURCE_GAP_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-source-gaps.csv"
CANDIDATE_VERIFICATION_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-candidate-verification.csv"
SOURCE_ACQUISITION_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-source-acquisition.csv"
SOURCE_PROMOTION_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-source-promotion.csv"
READINESS_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-readiness.csv"
READINESS_MARKDOWN_REPORT = ROOT / "reports" / "constitutional-review-empirical-platform-v1-readiness.md"
MARKDOWN_REPORT = REPORT_PREFIX.with_suffix(".md")
RESEARCH_DIR = ROOT / "config" / "research"

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

PROMOTION_QUEUE_HEADER = [
    "priorityRank",
    "actionType",
    "profileKey",
    "court",
    "targetFamily",
    "coverageStatus",
    "outOfRangeRows",
    "largestGap",
    "largestGapTarget",
    "candidateRows",
    "verifiedCandidateRows",
    "pendingVerificationRows",
    "directAnalogueCandidateRows",
    "roadmapRows",
    "topCandidateFile",
    "topCandidateLabel",
    "topCandidateStatus",
    "topCandidateSourceStatus",
    "promotionReadiness",
    "claimBoundary",
    "blockingReason",
    "recommendedAction",
]

SOURCE_GAP_HEADER = [
    "gapRank",
    "queuePriorityRank",
    "promotionReadiness",
    "claimBoundary",
    "actionType",
    "profileKey",
    "court",
    "targetFamily",
    "coverageStatus",
    "candidateRows",
    "verifiedCandidateRows",
    "pendingVerificationRows",
    "directAnalogueCandidateRows",
    "roadmapRows",
    "topCandidateFile",
    "topCandidateLabel",
    "topCandidateStatus",
    "topCandidateSourceStatus",
    "blockingReason",
    "recommendedAction",
]

CANDIDATE_VERIFICATION_HEADER = [
    "gapRank",
    "queuePriorityRank",
    "candidateRank",
    "promotionReadiness",
    "claimBoundary",
    "profileKey",
    "court",
    "targetFamily",
    "coverageStatus",
    "sourceFile",
    "label",
    "status",
    "sourceUrlStatus",
    "directAnalogue",
    "denominator",
    "topCandidate",
    "recommendedVerification",
]

SOURCE_ACQUISITION_HEADER = [
    "gapRank",
    "queuePriorityRank",
    "acquisitionRank",
    "promotionReadiness",
    "claimBoundary",
    "actionType",
    "profileKey",
    "court",
    "targetFamily",
    "coverageStatus",
    "roadmapSourceFile",
    "roadmapProfileKey",
    "roadmapCourtOrSystem",
    "period",
    "roadmapTargetFamily",
    "targetKey",
    "neededObservedValue",
    "neededDenominator",
    "preferredSources",
    "validationUseIfDocumented",
    "notes",
    "recommendedAcquisition",
]

SOURCE_PROMOTION_HEADER = [
    "gapRank",
    "queuePriorityRank",
    "promotionRank",
    "promotionReadiness",
    "claimBoundary",
    "profileKey",
    "court",
    "targetFamily",
    "coverageStatus",
    "targetFile",
    "timePeriod",
    "targetKey",
    "label",
    "observedValue",
    "sourceRange",
    "denominator",
    "unit",
    "method",
    "reliability",
    "sourceName",
    "sourceUrl",
    "useForValidation",
    "promotionBlockers",
    "recommendedPromotion",
]

READINESS_HEADER = [
    "readinessItem",
    "status",
    "evidence",
    "interpretation",
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

TARGET_FAMILY_ALIASES = {
    "abstractreviewrate": "case-selection",
    "abstract_review_frequency": "case-selection",
    "abstract_review_trigger_rate": "case-selection",
    "agency_nonacquiescence_rate": "compliance",
    "averagetimetoreview": "case-selection",
    "average_time_to_review": "case-selection",
    "caseSelectionAccess".lower(): "case-selection",
    "certiorari_pressure": "case-selection",
    "complaint_success_rate": "intake",
    "compliance_rate": "compliance",
    "direct_defiance_rate": "compliance",
    "doctrine_share_by_area": "doctrine-mix",
    "emergencyReliefRate".lower(): "emergency",
    "executive_implementation_rate": "compliance",
    "front_end_rights_statement_accuracy": "case-selection",
    "government_repeat_player_advantage": "case-selection",
    "implementation_delay": "compliance",
    "implementation_follow_up_rate": "compliance",
    "intake_rejection_rate": "intake",
    "invalidation_legislative_reenactment_rate": "compliance",
    "invalidation_legislative_response_rate": "legislative-response",
    "litigant_capacity": "case-selection",
    "legislativeResponseCredibility".lower(): "legislative-response",
    "legislativeResponseRate".lower(): "legislative-response",
    "legislative_reenactment_rate": "compliance",
    "legislative_response_after_declaration": "legislative-response",
    "legislative_response_credibility": "legislative-response",
    "local_government_compliance_rate": "compliance",
    "lower_court_conflict_creation": "case-selection",
    "mandatoryResponseCompletionRate".lower(): "legislative-response",
    "merits_invalidation_rate": "merits",
    "statute_nullification_rate": "merits",
    "normalized_budget_delay_cost": "cost",
    "ombudsman_review_success_rate": "case-selection",
    "ombudsman_trigger_access": "case-selection",
    "overrideRate".lower(): "legislative-response",
    "override_rate": "legislative-response",
    "override_invocation_rate": "legislative-response",
    "preEnactmentReviewRate".lower(): "case-selection",
    "pre_enactment_defect_detection_rate": "case-selection",
    "pre_enactment_review_rate": "case-selection",
    "publicDisagreementRate".lower(): "emergency",
    "public_disagreement_rate": "emergency",
    "public_defender_access": "case-selection",
    "public_defender_participation_success_rate": "case-selection",
    "public_interest_support": "case-selection",
    "public_trust": "political-context",
    "qpc_decision_outcome_rate": "merits",
    "reenactment_after_adverse_review_rate": "compliance",
    "repeated_litigation_rate": "compliance",
    "responseFailureRate".lower(): "legislative-response",
    "response_failure_rate": "legislative-response",
    "response_after_declaration": "legislative-response",
    "response_before_suspension_expires": "remedy-timing",
    "response_cycle_completion_rate": "legislative-response",
    "mandatory_response_completion_rate": "legislative-response",
    "structural_remedy_monitoring": "compliance",
    "suspendedDeclarationRate".lower(): "remedy-timing",
    "suspended_declaration_rate": "remedy-timing",
    "suspended_order_rate": "remedy-timing",
    "time_to_review": "case-selection",
    "workaround_rate": "compliance",
}

ROADMAP_FAMILY_ALIASES = {
    "abstract_review": "case-selection",
    "case_selection": "case-selection",
    "compliance": "compliance",
    "dialogic_review": "remedy-timing",
    "docket_mix": "doctrine-mix",
    "emergency_docket": "emergency",
    "implementation": "compliance",
    "institutional_cost": "cost",
    "intake": "intake",
    "legislative_response": "legislative-response",
    "legitimacy": "political-context",
    "pre_enactment_review": "case-selection",
    "procedure": "case-selection",
    "remedy": "remedy-timing",
    "remedy_timing": "remedy-timing",
    "review_activity": "merits",
    "review_route": "case-selection",
    "cost": "cost",
}

ROADMAP_PROFILE_ALIASES = {
    "us-scotus-modern": ["scdb-modern-merits-2000-2024", "scotus-emergency-2024-2025", "gallup-court-confidence-2024"],
    "germany-bverfg": ["germany-bverfg-2024"],
    "france-conseil": ["france-conseil-qpc"],
    "canada-scc": ["canada-scc-2024", "canada-scc-recent", "canada-charter-dialogue-1982-2007"],
    "south-africa-constcourt": ["south-africa-constcourt-recent"],
    "uk-supreme-court": ["uk-supreme-court-2024-2025", "uk-human-rights-doi-2025"],
    "echr": ["echr-2024"],
    "cjeu": ["cjeu-2024"],
}

LEGISLATIVE_SYSTEM_PROFILES = {
    "United Kingdom": ["uk-human-rights-doi-2025"],
    "Canada": ["canada-charter-dialogue-1982-2007"],
    "South Africa": ["south-africa-constcourt-recent"],
    "France": ["france-conseil-qpc"],
    "Germany": ["germany-bverfg-2024"],
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


def split_families(value: str) -> set[str]:
    return {part for part in value.split("|") if part}


def target_family(target_key: str) -> str:
    normalized = target_key.strip()
    if not normalized:
        return ""
    if normalized.startswith("doctrine_mix."):
        return "doctrine-mix"
    snake = []
    for index, char in enumerate(normalized):
        if char.isupper() and index > 0 and normalized[index - 1] != "_":
            snake.append("_")
        snake.append(char.lower())
    snake_key = "".join(snake)
    if snake_key in build_court_profiles.TARGET_FAMILIES:
        return build_court_profiles.TARGET_FAMILIES[snake_key]
    return TARGET_FAMILY_ALIASES.get(normalized.lower(), TARGET_FAMILY_ALIASES.get(snake_key, ""))


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


def source_rows_by_family(rows: list[dict[str, str]]) -> dict[tuple[str, str], list[dict[str, str]]]:
    grouped: dict[tuple[str, str], list[dict[str, str]]] = defaultdict(list)
    for row in rows:
        grouped[(row["profileKey"], build_court_profiles.family_for(row["targetKey"]))].append(row)
    return grouped


def candidate_rows() -> dict[tuple[str, str], list[dict[str, str]]]:
    grouped: dict[tuple[str, str], list[dict[str, str]]] = defaultdict(list)
    comparative_path = RESEARCH_DIR / "comparative-calibration-source-candidates.csv"
    for row in read_rows(comparative_path, [
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
    ]):
        family = target_family(row["targetKey"])
        if family:
            item = {
                "sourceFile": str(comparative_path.relative_to(ROOT)),
                "label": row["label"],
                "status": row["calibrationAction"],
                "sourceUrlStatus": row["sourceUrlStatus"],
                "directAnalogue": row["directAnalogue"],
                "denominator": row["denominator"],
            }
            grouped[(row["profileKey"], family)].append(item)

    legislative_path = RESEARCH_DIR / "legislative-response-source-candidates.csv"
    for row in read_rows(legislative_path, [
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
    ]):
        family = target_family(row["targetKey"])
        if not family:
            continue
        item = {
            "sourceFile": str(legislative_path.relative_to(ROOT)),
            "label": row["label"],
            "status": row["evidenceStatus"],
            "sourceUrlStatus": row["sourceUrlStatus"],
            "directAnalogue": row["directAnalogue"],
            "denominator": row["denominator"],
        }
        for profile_key in LEGISLATIVE_SYSTEM_PROFILES.get(row["system"], []):
            grouped[(profile_key, family)].append(item)
    return grouped


def roadmap_rows() -> dict[tuple[str, str], int]:
    grouped: dict[tuple[str, str], int] = defaultdict(int)
    roadmap_path = RESEARCH_DIR / "empirical-target-roadmap.csv"
    for row in read_rows(roadmap_path, [
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
    ]):
        family = ROADMAP_FAMILY_ALIASES.get(row["targetFamily"], target_family(row["targetKey"]))
        if not family:
            continue
        for profile_key in ROADMAP_PROFILE_ALIASES.get(row["profileKey"], [row["profileKey"]]):
            grouped[(profile_key, family)] += 1
    return grouped


def roadmap_items() -> dict[tuple[str, str], list[dict[str, str]]]:
    grouped: dict[tuple[str, str], list[dict[str, str]]] = defaultdict(list)
    roadmap_path = RESEARCH_DIR / "empirical-target-roadmap.csv"
    for row in read_rows(roadmap_path, [
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
    ]):
        family = ROADMAP_FAMILY_ALIASES.get(row["targetFamily"], target_family(row["targetKey"]))
        if not family:
            continue
        item = {
            "sourceFile": str(roadmap_path.relative_to(ROOT)),
            "roadmapProfileKey": row["profileKey"],
            "roadmapCourtOrSystem": row["courtOrSystem"],
            "period": row["period"],
            "roadmapTargetFamily": row["targetFamily"],
            "targetKey": row["targetKey"],
            "neededObservedValue": row["neededObservedValue"],
            "neededDenominator": row["neededDenominator"],
            "preferredSources": row["preferredSources"],
            "validationUseIfDocumented": row["validationUseIfDocumented"],
            "notes": row["notes"],
        }
        for profile_key in ROADMAP_PROFILE_ALIASES.get(row["profileKey"], [row["profileKey"]]):
            grouped[(profile_key, family)].append(item)
    return grouped


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


def source_verified(row: dict[str, str]) -> bool:
    return row["sourceUrlStatus"].startswith("verified:https://")


def source_bibliography_verified(row: dict[str, str]) -> bool:
    return row["sourceUrlStatus"].startswith("verified-bibliography-only:https://")


def source_pending(row: dict[str, str]) -> bool:
    return row["sourceUrlStatus"].startswith("pending")


def verified_model_gap(row: dict[str, str]) -> bool:
    return row["status"] == "verified-model-gap"


def direct_analogue(row: dict[str, str]) -> bool:
    return row["directAnalogue"].lower() == "true"


def has_denominator(row: dict[str, str]) -> bool:
    denominator = row["denominator"].strip()
    return bool(denominator and denominator != "0")


def candidate_score(row: dict[str, str]) -> tuple[int, int, int, str]:
    return (
        1 if direct_analogue(row) else 0,
        1 if source_verified(row) else 0,
        1 if source_bibliography_verified(row) else 0,
        1 if has_denominator(row) else 0,
        row["label"],
    )


def queue_action_type(family_row: dict[str, str], candidates: list[dict[str, str]], roadmap_count: int) -> str:
    if int(family_row["outOfRangeRows"]) > 0:
        return "model-calibration"
    if family_row["coverageStatus"] == "validation-counted":
        return ""
    if family_row["coverageStatus"] == "stress-only":
        return "source-promotion"
    if candidates:
        return "candidate-verification"
    if roadmap_count:
        return "source-acquisition"
    return ""


def queue_recommendation(action_type: str, family_row: dict[str, str], top_candidate: dict[str, str] | None) -> str:
    if action_type == "model-calibration":
        return family_row["nextAction"] or "retune model only after preserving cross-profile comparability"
    if action_type == "source-promotion":
        if family_row["targetFamily"] in build_court_profiles.CONTEXTUAL_CALIBRATION_FAMILIES:
            return "document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation"
        return "verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows"
    if action_type == "candidate-verification" and top_candidate:
        if verified_model_gap(top_candidate):
            return "add the missing simulator output and preserve the source unit before reconsidering validation promotion"
        if source_bibliography_verified(top_candidate):
            return "audit source values and coding table before promotion"
        if not top_candidate["sourceUrlStatus"].startswith("verified:https://"):
            return "verify primary source URL and numerator/denominator before promotion"
        if top_candidate["directAnalogue"].lower() != "true":
            return "keep as contextual evidence unless recoded to a direct simulator analogue"
        return "audit construction note and promote if target key is simulator-observable"
    if action_type == "source-acquisition":
        if family_row["targetFamily"] in build_court_profiles.CONTEXTUAL_CALIBRATION_FAMILIES:
            return "collect contextual source pack; do not count as source-range validation without a raw simulator analogue"
        return "collect denominator-backed source rows for this profile-family"
    return ""


def queue_actionability(
        action_type: str,
        family_row: dict[str, str],
        candidates: list[dict[str, str]],
        top_candidate: dict[str, str] | None,
        source_rows: list[dict[str, str]],
) -> tuple[str, str, str]:
    if action_type == "model-calibration":
        return (
            "model-calibration-needed",
            "validation-counted source-range miss",
            family_row["largestGapTarget"] or "current validation row falls outside its documented source range",
        )
    if action_type == "source-promotion":
        if family_row["targetFamily"] in build_court_profiles.CONTEXTUAL_CALIBRATION_FAMILIES:
            return (
                "contextual-source-documentation",
                "contextual source surface, not validation-family gap",
                "current validation policy excludes normalized cost and public-trust proxy rows from source-range validation",
            )
        source_blockers = [source_promotion_blockers(row) for row in source_rows]
        if source_blockers and all(blockers == ["not-validation-counted"] for blockers in source_blockers):
            return (
                "claim-boundary-decision-needed",
                "source-complete stress rows need validation-scope decision",
                "stress-only rows have URLs, denominators, and construction notes; promotion would broaden validation claims",
            )
        return (
            "needs-source-documentation",
            "stress-only row needs promotion evidence",
            "stress-only coverage lacks the full promotion package: source URL, denominator, coding rule, and direct analogue",
        )
    if action_type == "source-acquisition":
        if family_row["targetFamily"] in build_court_profiles.CONTEXTUAL_CALIBRATION_FAMILIES:
            return (
                "contextual-source-documentation",
                "contextual source surface, not validation-family gap",
                "current validation policy excludes normalized cost and public-trust proxy rows from source-range validation",
            )
        return (
            "source-acquisition-needed",
            "no registered source candidate",
            "no candidate row is registered for this missing profile-family",
        )
    if action_type != "candidate-verification" or not top_candidate:
        return ("needs-triage", "unclassified queue row", "queue row has no candidate or actionability signal")

    direct_candidates = [row for row in candidates if direct_analogue(row)]
    verified_direct = [row for row in direct_candidates if source_verified(row) and has_denominator(row)]
    bibliography_verified_direct = [
        row for row in direct_candidates
        if source_bibliography_verified(row) and has_denominator(row)
    ]
    pending_direct = [row for row in direct_candidates if source_pending(row) and has_denominator(row)]
    model_gap_candidates = [
        row for row in candidates
        if verified_model_gap(row) and source_verified(row) and has_denominator(row)
    ]
    verified_context = [row for row in candidates if source_verified(row) and not direct_analogue(row)]

    if model_gap_candidates:
        return (
            "model-metric-gap",
            "verified source measure lacks a matching simulator output unit",
            "source evidence is reproducible but cannot be compared to the current all-merits simulator metric without mixing units",
        )
    if verified_direct:
        return (
            "ready-for-promotion-review",
            "verified direct analogue candidate",
            "construction note and simulator-observable target key still need final audit before promotion",
        )
    if pending_direct:
        return (
            "verify-primary-source",
            "direct analogue candidate pending URL verification",
            "primary source URL must be verified before this row can become validation evidence",
        )
    if bibliography_verified_direct:
        return (
            "verify-source-values",
            "bibliographic source verified but source values blocked",
            "source landing page is verified, but numerator, denominator, or coding table still needs page-level audit",
        )
    if direct_candidates:
        return (
            "candidate-triage-needed",
            "direct analogue candidate missing promotion prerequisites",
            "candidate needs denominator and source-status cleanup before promotion review",
        )
    if verified_context:
        return (
            "context-only-blocked",
            "verified context but not validation evidence",
            "candidate has a verified URL but is not a direct simulator analogue",
        )
    return (
        "candidate-triage-needed",
        "candidate not yet promotable",
        "candidate lacks a verified source URL or direct simulator analogue",
    )


ACTIONABILITY_SORT_ORDER = {
    "model-calibration-needed": 0,
    "model-metric-gap": 1,
    "ready-for-promotion-review": 2,
    "claim-boundary-decision-needed": 3,
    "verify-primary-source": 4,
    "verify-source-values": 5,
    "needs-source-documentation": 6,
    "contextual-source-documentation": 7,
    "candidate-triage-needed": 8,
    "source-acquisition-needed": 9,
    "context-only-blocked": 10,
    "needs-triage": 11,
}


def promotion_queue_rows(
        family_rows: list[dict[str, str]],
        candidates_by_family: dict[tuple[str, str], list[dict[str, str]]],
        roadmap_by_family: dict[tuple[str, str], int],
        sources_by_family: dict[tuple[str, str], list[dict[str, str]]],
) -> list[dict[str, str]]:
    pending: list[tuple[tuple[float, int, int, str, str], dict[str, str]]] = []
    for family_row in family_rows:
        key = (family_row["profileKey"], family_row["targetFamily"])
        candidates = candidates_by_family.get(key, [])
        roadmap_count = roadmap_by_family.get(key, 0)
        family_sources = sources_by_family.get(key, [])
        action_type = queue_action_type(family_row, candidates, roadmap_count)
        if not action_type:
            continue

        verified_count = sum(1 for row in candidates if source_verified(row))
        pending_count = sum(1 for row in candidates if source_pending(row))
        direct_count = sum(1 for row in candidates if direct_analogue(row))
        top_candidate = max(candidates, key=candidate_score) if candidates else None
        promotion_readiness, claim_boundary, blocking_reason = queue_actionability(
            action_type,
            family_row,
            candidates,
            top_candidate,
            family_sources,
        )
        recommended_action = queue_recommendation(action_type, family_row, top_candidate)
        if promotion_readiness == "claim-boundary-decision-needed":
            recommended_action = (
                "decide whether to promote source-complete stress rows into validation and accept any resulting "
                "model-calibration diagnostics"
            )
        action_weight = {
            "model-calibration": 0,
            "candidate-verification": 1,
            "source-promotion": 2,
            "source-acquisition": 3,
        }[action_type]
        sort_key = (
            -float(family_row["largestGap"]),
            ACTIONABILITY_SORT_ORDER.get(promotion_readiness, 99),
            action_weight,
            -direct_count,
            -verified_count,
            family_row["profileKey"],
            family_row["targetFamily"],
        )
        pending.append(
            (
                sort_key,
                {
                    "priorityRank": "",
                    "actionType": action_type,
                    "profileKey": family_row["profileKey"],
                    "court": family_row["court"],
                    "targetFamily": family_row["targetFamily"],
                    "coverageStatus": family_row["coverageStatus"],
                    "outOfRangeRows": family_row["outOfRangeRows"],
                    "largestGap": family_row["largestGap"],
                    "largestGapTarget": family_row["largestGapTarget"],
                    "candidateRows": str(len(candidates)),
                    "verifiedCandidateRows": str(verified_count),
                    "pendingVerificationRows": str(pending_count),
                    "directAnalogueCandidateRows": str(direct_count),
                    "roadmapRows": str(roadmap_count),
                    "topCandidateFile": top_candidate["sourceFile"] if top_candidate else "",
                    "topCandidateLabel": top_candidate["label"] if top_candidate else "",
                    "topCandidateStatus": top_candidate["status"] if top_candidate else "",
                    "topCandidateSourceStatus": top_candidate["sourceUrlStatus"] if top_candidate else "",
                    "promotionReadiness": promotion_readiness,
                    "claimBoundary": claim_boundary,
                    "blockingReason": blocking_reason,
                    "recommendedAction": recommended_action,
                },
            )
        )
    output = [row for _, row in sorted(pending, key=lambda item: item[0])]
    for index, row in enumerate(output, start=1):
        row["priorityRank"] = str(index)
    return output


def source_gap_rows(queue_rows: list[dict[str, str]]) -> list[dict[str, str]]:
    output: list[dict[str, str]] = []
    sorted_rows = sorted(
        queue_rows,
        key=lambda row: (
            ACTIONABILITY_SORT_ORDER.get(row["promotionReadiness"], 99),
            int(row["priorityRank"]),
        ),
    )
    for index, row in enumerate(sorted_rows, start=1):
        output.append(
            {
                "gapRank": str(index),
                "queuePriorityRank": row["priorityRank"],
                "promotionReadiness": row["promotionReadiness"],
                "claimBoundary": row["claimBoundary"],
                "actionType": row["actionType"],
                "profileKey": row["profileKey"],
                "court": row["court"],
                "targetFamily": row["targetFamily"],
                "coverageStatus": row["coverageStatus"],
                "candidateRows": row["candidateRows"],
                "verifiedCandidateRows": row["verifiedCandidateRows"],
                "pendingVerificationRows": row["pendingVerificationRows"],
                "directAnalogueCandidateRows": row["directAnalogueCandidateRows"],
                "roadmapRows": row["roadmapRows"],
                "topCandidateFile": row["topCandidateFile"],
                "topCandidateLabel": row["topCandidateLabel"],
                "topCandidateStatus": row["topCandidateStatus"],
                "topCandidateSourceStatus": row["topCandidateSourceStatus"],
                "blockingReason": row["blockingReason"],
                "recommendedAction": row["recommendedAction"],
            }
        )
    return output


def candidate_verification_recommendation(candidate: dict[str, str]) -> str:
    if verified_model_gap(candidate):
        return "design a statute-disposition nullification output; do not compare this row with all-merits invalidation"
    if not direct_analogue(candidate):
        if source_verified(candidate):
            return "retain as context unless recoded to a direct simulator analogue"
        return "verify source only if the metric can be recoded to a direct simulator analogue"
    if not has_denominator(candidate):
        return "recover numerator denominator and coding universe before promotion review"
    if source_bibliography_verified(candidate):
        return "audit article text coding table numerator and denominator before promotion"
    if not source_verified(candidate):
        return "verify primary source URL period numerator denominator and coding rule"
    return "audit construction note and simulator target exposure before promotion"


def candidate_verification_rows(
        queue_rows: list[dict[str, str]],
        source_gaps: list[dict[str, str]],
        candidates_by_family: dict[tuple[str, str], list[dict[str, str]]],
) -> list[dict[str, str]]:
    gap_by_queue_rank = {row["queuePriorityRank"]: row["gapRank"] for row in source_gaps}
    output: list[dict[str, str]] = []
    for queue_row in queue_rows:
        key = (queue_row["profileKey"], queue_row["targetFamily"])
        candidates = sorted(candidates_by_family.get(key, []), key=candidate_score, reverse=True)
        top_signature = (
            queue_row["topCandidateFile"],
            queue_row["topCandidateLabel"],
            queue_row["topCandidateStatus"],
            queue_row["topCandidateSourceStatus"],
        )
        for index, candidate in enumerate(candidates, start=1):
            candidate_signature = (
                candidate["sourceFile"],
                candidate["label"],
                candidate["status"],
                candidate["sourceUrlStatus"],
            )
            output.append(
                {
                    "gapRank": gap_by_queue_rank.get(queue_row["priorityRank"], ""),
                    "queuePriorityRank": queue_row["priorityRank"],
                    "candidateRank": str(index),
                    "promotionReadiness": queue_row["promotionReadiness"],
                    "claimBoundary": queue_row["claimBoundary"],
                    "profileKey": queue_row["profileKey"],
                    "court": queue_row["court"],
                    "targetFamily": queue_row["targetFamily"],
                    "coverageStatus": queue_row["coverageStatus"],
                    "sourceFile": candidate["sourceFile"],
                    "label": candidate["label"],
                    "status": candidate["status"],
                    "sourceUrlStatus": candidate["sourceUrlStatus"],
                    "directAnalogue": candidate["directAnalogue"],
                    "denominator": candidate["denominator"],
                    "topCandidate": "true" if candidate_signature == top_signature else "false",
                    "recommendedVerification": candidate_verification_recommendation(candidate),
                }
            )
    return output


def source_acquisition_recommendation(row: dict[str, str], queue_row: dict[str, str]) -> str:
    if row["validationUseIfDocumented"].lower() == "true":
        return "collect URL denominator coding rule and construction note for validation promotion review"
    if queue_row["actionType"] == "source-acquisition":
        return "collect as contextual source unless a direct simulator analogue can be documented"
    return "use as supporting roadmap context after higher-priority candidate verification"


def source_acquisition_rows(
        queue_rows: list[dict[str, str]],
        source_gaps: list[dict[str, str]],
        roadmap_by_family: dict[tuple[str, str], list[dict[str, str]]],
) -> list[dict[str, str]]:
    gap_by_queue_rank = {row["queuePriorityRank"]: row["gapRank"] for row in source_gaps}
    output: list[dict[str, str]] = []
    for queue_row in queue_rows:
        key = (queue_row["profileKey"], queue_row["targetFamily"])
        roadmap = sorted(
            roadmap_by_family.get(key, []),
            key=lambda row: (row["roadmapProfileKey"], row["targetKey"], row["neededObservedValue"]),
        )
        for index, item in enumerate(roadmap, start=1):
            output.append(
                {
                    "gapRank": gap_by_queue_rank.get(queue_row["priorityRank"], ""),
                    "queuePriorityRank": queue_row["priorityRank"],
                    "acquisitionRank": str(index),
                    "promotionReadiness": queue_row["promotionReadiness"],
                    "claimBoundary": queue_row["claimBoundary"],
                    "actionType": queue_row["actionType"],
                    "profileKey": queue_row["profileKey"],
                    "court": queue_row["court"],
                    "targetFamily": queue_row["targetFamily"],
                    "coverageStatus": queue_row["coverageStatus"],
                    "roadmapSourceFile": item["sourceFile"],
                    "roadmapProfileKey": item["roadmapProfileKey"],
                    "roadmapCourtOrSystem": item["roadmapCourtOrSystem"],
                    "period": item["period"],
                    "roadmapTargetFamily": item["roadmapTargetFamily"],
                    "targetKey": item["targetKey"],
                    "neededObservedValue": item["neededObservedValue"],
                    "neededDenominator": item["neededDenominator"],
                    "preferredSources": item["preferredSources"],
                    "validationUseIfDocumented": item["validationUseIfDocumented"],
                    "notes": item["notes"],
                    "recommendedAcquisition": source_acquisition_recommendation(item, queue_row),
                }
            )
    return output


def source_promotion_blockers(row: dict[str, str]) -> list[str]:
    blockers: list[str] = []
    if row["useForValidation"].lower() != "true":
        blockers.append("not-validation-counted")
    if not row["sourceUrl"].strip():
        blockers.append("missing-source-url")
    if not row["n"].strip() or row["n"].strip() == "0":
        blockers.append("missing-denominator")
    if len(row["constructionNote"].strip()) < 30:
        blockers.append("thin-construction-note")

    method = row["method"].lower()
    source_name = row["sourceName"].lower()
    if "synthesis" in method or "synthesis" in source_name or "deep research" in source_name:
        blockers.append("synthesis-source")
    if row["unit"].lower() == "normalized" or "benchmark cost" in method or "public-trust" in method:
        blockers.append("context-or-normalized-measure")
    return blockers


def source_promotion_recommendation(blockers: list[str]) -> str:
    if "context-or-normalized-measure" in blockers:
        return "keep as stress context unless a direct simulator-output analogue and source-specific denominator are documented"
    if "synthesis-source" in blockers:
        return "replace synthesis trail with a primary or authoritative public source before validation promotion"
    if "missing-source-url" in blockers or "missing-denominator" in blockers:
        return "recover public source URL denominator period and coding rule before validation promotion"
    if "thin-construction-note" in blockers:
        return "expand construction note to make numerator denominator period and exclusions reproducible"
    if blockers == ["not-validation-counted"]:
        return "audit direct analogue and target exposure; promote only if row satisfies validation-source rules"
    return "retain as stress-only evidence until all promotion blockers are resolved"


def source_promotion_rows(
        queue_rows: list[dict[str, str]],
        source_gaps: list[dict[str, str]],
        sources_by_family: dict[tuple[str, str], list[dict[str, str]]],
) -> list[dict[str, str]]:
    gap_by_queue_rank = {row["queuePriorityRank"]: row["gapRank"] for row in source_gaps}
    output: list[dict[str, str]] = []
    for queue_row in queue_rows:
        if queue_row["actionType"] != "source-promotion":
            continue
        key = (queue_row["profileKey"], queue_row["targetFamily"])
        sources = sorted(
            sources_by_family.get(key, []),
            key=lambda row: (row["targetFile"], row["targetKey"], row["label"]),
        )
        for index, source_row in enumerate(sources, start=1):
            blockers = source_promotion_blockers(source_row)
            recommended_promotion = source_promotion_recommendation(blockers)
            if queue_row["promotionReadiness"] == "contextual-source-documentation":
                recommended_promotion = (
                    "document raw budget or public-opinion source trail for context; keep normalized-cost "
                    "and public-trust proxy rows outside validation counts"
                )
            output.append(
                {
                    "gapRank": gap_by_queue_rank.get(queue_row["priorityRank"], ""),
                    "queuePriorityRank": queue_row["priorityRank"],
                    "promotionRank": str(index),
                    "promotionReadiness": queue_row["promotionReadiness"],
                    "claimBoundary": queue_row["claimBoundary"],
                    "profileKey": queue_row["profileKey"],
                    "court": queue_row["court"],
                    "targetFamily": queue_row["targetFamily"],
                    "coverageStatus": queue_row["coverageStatus"],
                    "targetFile": source_row["targetFile"],
                    "timePeriod": source_row["timePeriod"],
                    "targetKey": source_row["targetKey"],
                    "label": source_row["label"],
                    "observedValue": source_row["observedValue"],
                    "sourceRange": f"{source_row['lowerBound']}--{source_row['upperBound']}",
                    "denominator": source_row["n"],
                    "unit": source_row["unit"],
                    "method": source_row["method"],
                    "reliability": source_row["reliability"],
                    "sourceName": source_row["sourceName"],
                    "sourceUrl": source_row["sourceUrl"],
                    "useForValidation": source_row["useForValidation"],
                    "promotionBlockers": "|".join(blockers),
                    "recommendedPromotion": recommended_promotion,
                }
            )
    return output


def source_promotion_blocker_counts(rows: list[dict[str, str]]) -> Counter[str]:
    counts: Counter[str] = Counter()
    for row in rows:
        for blocker in row["promotionBlockers"].split("|"):
            if blocker:
                counts[blocker] += 1
    return counts


def source_promotion_blocker_summary(rows: list[dict[str, str]]) -> str:
    counts = source_promotion_blocker_counts(rows)
    if not counts:
        return "no source-promotion blockers"
    return ", ".join(f"{counts[blocker]} {blocker}" for blocker in sorted(counts))


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


def family_sort_key(family: str) -> int:
    try:
        return build_court_profiles.PLATFORM_FAMILY_ORDER.index(family)
    except ValueError:
        return len(build_court_profiles.PLATFORM_FAMILY_ORDER)


def rows_by_profile(rows: list[dict[str, str]]) -> dict[str, list[dict[str, str]]]:
    grouped: dict[str, list[dict[str, str]]] = defaultdict(list)
    for row in rows:
        grouped[row["profileKey"]].append(row)
    return grouped


def readiness_rows(
        profile_rows: list[dict[str, str]],
        family_rows: list[dict[str, str]],
        queue_rows: list[dict[str, str]],
        source_promotion_detail: list[dict[str, str]],
        source_rows: list[dict[str, str]],
        miss_rows: list[dict[str, str]],
) -> list[dict[str, str]]:
    validation_rows = sum(int(row["validationRows"]) for row in profile_rows)
    failures = out_of_range(miss_rows)
    validation_profiles = sum(1 for row in profile_rows if int(row["validationRows"]) > 0)
    multi_family_profiles = sum(1 for row in profile_rows if len(split_families(row["validationFamilies"])) >= 2)
    validation_families = {
        row["targetFamily"]
        for row in family_rows
        if row["coverageStatus"] == "validation-counted"
    }
    missing_validation_families = [
        family
        for family in build_court_profiles.VALIDATION_ELIGIBLE_FAMILY_ORDER
        if family not in validation_families
    ]
    contextual_families = build_court_profiles.CONTEXTUAL_CALIBRATION_FAMILIES
    contextual_family_rows = [
        row
        for row in family_rows
        if row["targetFamily"] in contextual_families and int(row["sourceRows"]) > 0
    ]
    contextual_families_with_sources = {
        row["targetFamily"]
        for row in contextual_family_rows
    }
    contextual_source_rows = sum(int(row["sourceRows"]) for row in contextual_family_rows)
    contextual_validation_rows = sum(int(row["validationRows"]) for row in contextual_family_rows)
    contextual_profile_count = len({
        row["profileKey"]
        for row in contextual_family_rows
    })
    action_counts = Counter(row["actionType"] for row in queue_rows)
    queue_summary = ", ".join(
        f"{action_counts[action]} {action}"
        for action in sorted(action_counts)
    ) or "no queued actions"
    readiness_counts = Counter(row["promotionReadiness"] for row in queue_rows)
    readiness_summary = ", ".join(
        f"{readiness_counts[status]} {status}"
        for status in sorted(readiness_counts, key=lambda status: ACTIONABILITY_SORT_ORDER.get(status, 99))
    ) or "no readiness gaps"
    top_queue = queue_rows[0] if queue_rows else None
    top_queue_summary = (
        f"{top_queue['promotionReadiness']} for {top_queue['profileKey']} {top_queue['targetFamily']}"
        if top_queue
        else "no current queue item"
    )
    source_promotion_summary = (
        f"{len(source_promotion_detail)} stress-only source rows; blockers: "
        f"{source_promotion_blocker_summary(source_promotion_detail)}"
        if source_promotion_detail
        else "no source-promotion detail rows"
    )
    validation_source_rows = [
        row
        for row in source_rows
        if row["useForValidation"].lower() == "true"
    ]
    validation_source_rows_with_denominator_and_url = sum(
        1
        for row in validation_source_rows
        if row["sourceUrl"].strip() and row["n"].strip() and row["n"].strip() != "0"
    )
    source_url_rows = sum(1 for row in source_rows if row["sourceUrl"].strip())
    denominator_rows = sum(1 for row in source_rows if row["n"].strip() and row["n"].strip() != "0")

    missing_family_text = (
        ", ".join(missing_validation_families)
        if missing_validation_families
        else "no"
    )
    missing_family_phrase = (
        f"{missing_family_text} family remains"
        if len(missing_validation_families) == 1
        else f"{missing_family_text} families remain"
    )

    return [
        {
            "readinessItem": "source-range-fit",
            "status": "ready-for-current-claims" if validation_rows and not failures else "needs-model-calibration",
            "evidence": (
                f"{validation_rows} validation-counted rows; "
                f"{sum(1 for row in miss_rows if row['withinTarget'].lower() == 'true')} within range; "
                f"{len(failures)} out of range"
            ),
            "interpretation": "The current source-range surface clears documented benchmark ranges, but only for promoted rows.",
            "nextAction": "Run validation-check before publication and after every calibration-source or source-profile change.",
        },
        {
            "readinessItem": "profile-validation-depth",
            "status": "needs-source-expansion",
            "evidence": (
                f"{validation_profiles}/{len(profile_rows)} profiles have validation-counted rows; "
                f"{multi_family_profiles}/{len(profile_rows)} profiles cover multiple validation families"
            ),
            "interpretation": "Profile cards are reusable handoffs, but many named profiles remain stress-only or narrow single-family benchmarks.",
            "nextAction": "Promote denominator-backed source rows for high-priority profiles before making stronger country-profile claims.",
        },
        {
            "readinessItem": "target-family-depth",
            "status": "needs-source-expansion",
            "evidence": (
                f"{len(validation_families)}/{len(build_court_profiles.VALIDATION_ELIGIBLE_FAMILY_ORDER)} validation-eligible families have validation-counted rows; "
                f"missing validation families: {', '.join(missing_validation_families) if missing_validation_families else 'none'}"
            ),
            "interpretation": f"The platform now fits its narrow benchmark surface, but {missing_family_phrase} outside validation counts.",
            "nextAction": "Use source-acquisition and source-promotion queue rows to expand family coverage with URLs, denominators, and direct analogues.",
        },
        {
            "readinessItem": "contextual-source-depth",
            "status": "contextual-surface-active",
            "evidence": (
                f"{len(contextual_families_with_sources)}/{len(contextual_families)} contextual families have stress-source rows; "
                f"{contextual_source_rows} source rows across {contextual_profile_count} profiles; "
                f"{contextual_validation_rows} validation-counted by policy"
            ),
            "interpretation": "Cost and political-context rows remain visible for calibration context, but normalized cost and public-trust proxies are intentionally excluded from source-range validation.",
            "nextAction": "Build raw cost-accounting and political-context source packs separately from validation-counted case-output analogues.",
        },
        {
            "readinessItem": "source-documentation",
            "status": "ready-for-current-claims",
            "evidence": (
                f"{len(source_rows)} calibration source rows; "
                f"{validation_source_rows_with_denominator_and_url}/{len(validation_source_rows)} validation rows have denominators and source URLs; "
                f"{denominator_rows} total rows with stored denominators; "
                f"{source_url_rows} total rows with source URLs"
            ),
            "interpretation": "The checked-in source matrix preserves the source trail needed for the current narrow validation surface.",
            "nextAction": "Keep unverified research leads in config/research until their URLs, denominators, coding rules, and analogues are documented.",
        },
        {
            "readinessItem": "promotion-pipeline",
            "status": "active-pipeline",
            "evidence": f"{len(queue_rows)} queued tasks; {queue_summary}; readiness: {readiness_summary}; top actionable item: {top_queue_summary}; source-promotion detail: {source_promotion_summary}",
            "interpretation": "After clearing current source-range misses, the next empirical work is coverage expansion, with missing simulator-output units separated from direct candidates and context-only blockers.",
            "nextAction": "Resolve model-metric-gap rows only by implementing the matching source unit or keeping them excluded; then work direct-candidate and stress-promotion rows.",
        },
        {
            "readinessItem": "publication-boundary",
            "status": "ready-for-current-claims",
            "evidence": "Generated profile index, family matrix, promotion queue, benchmark cards, readiness report, manuscript tables, and replication bundle are all derived from the same source matrix.",
            "interpretation": "The project can support bounded comparative simulation claims and a reusable calibration-platform handoff, not comprehensive empirical validation of every named court.",
            "nextAction": "Keep manuscript claims tied to validation-counted rows and describe missing families as empirical-roadmap work.",
        },
    ]


def readiness_markdown(rows: list[dict[str, str]]) -> str:
    lines = [
        "# Empirical Platform Readiness Report",
        "",
        "This generated report converts the empirical-platform coverage matrix into publication-readiness gates. It is a claim-boundary artifact: it says what the current source-backed platform can support and what still requires source expansion.",
        "",
    ]
    lines.extend(
        markdown_table(
            ["Readiness item", "Status", "Evidence", "Interpretation", "Next action"],
            [
                [
                    row["readinessItem"],
                    row["status"],
                    row["evidence"],
                    row["interpretation"],
                    row["nextAction"],
                ]
                for row in rows
            ],
        )
    )
    lines.extend(
        [
            "",
            "Statuses marked `ready-for-current-claims` are bounded by the currently promoted validation rows. `needs-source-expansion` does not mean the simulator is failing; it means the platform should not make broader country-profile claims until more denominator-backed source rows are promoted.",
            "",
        ]
    )
    return "\n".join(lines)


def family_row_index(rows: list[dict[str, str]]) -> dict[tuple[str, str], dict[str, str]]:
    return {(row["profileKey"], row["targetFamily"]): row for row in rows}


def source_row_family(row: dict[str, str]) -> str:
    return build_court_profiles.family_for(row["targetKey"])


def source_use(row: dict[str, str]) -> str:
    return "validation" if row["useForValidation"].lower() == "true" else "stress"


def cards_next_step(
        family_row: dict[str, str],
        queue_row: dict[str, str] | None,
) -> str:
    if family_row["outOfRangeRows"] != "0":
        return family_row["nextAction"] or "calibrate this source-range miss before stronger profile claims"
    if queue_row:
        return queue_row["recommendedAction"]
    if family_row["coverageStatus"] == "validation-counted":
        return "keep as a narrow benchmark check; do not generalize to full court behavior"
    if family_row["coverageStatus"] == "stress-only":
        return "retain as stress context until denominator, source URL, and direct analogue are verified"
    return "no source row or candidate is currently registered for this profile-family"


def benchmark_cards(
        profile_rows: list[dict[str, str]],
        family_rows: list[dict[str, str]],
        queue_rows: list[dict[str, str]],
        source_rows: list[dict[str, str]],
        miss_rows: list[dict[str, str]],
) -> str:
    family_by_key = family_row_index(family_rows)
    queue_by_profile = rows_by_profile(queue_rows)
    queue_by_key = {
        (row["profileKey"], row["targetFamily"]): row
        for row in queue_rows
    }
    source_by_profile = rows_by_profile(source_rows)
    miss_by_profile = rows_by_profile(miss_rows)

    lines = [
        "# Court Profile Benchmark Cards",
        "",
        "This generated artifact is the profile-level handoff for the empirical calibration platform. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, the generated validation-miss report, and the empirical-platform promotion queue. Do not edit it by hand; regenerate it with `make empirical-platform-report`.",
        "",
        "Use these cards to distinguish source-range validation evidence from stress-only context and from candidate or acquisition work. A `validation-counted` family is a narrow benchmark check, not a claim that the stylized preset reproduces the named court.",
        "",
    ]

    for profile in profile_rows:
        profile_key = profile["profileKey"]
        profile_sources = sorted(
            source_by_profile.get(profile_key, []),
            key=lambda row: (family_sort_key(source_row_family(row)), row["targetKey"], row["label"]),
        )
        profile_misses = sorted(
            miss_by_profile.get(profile_key, []),
            key=lambda row: (-gap_value(row), family_sort_key(build_court_profiles.family_for(row["targetKey"])), row["targetKey"]),
        )
        profile_queue = sorted(
            queue_by_profile.get(profile_key, []),
            key=lambda row: int(row["priorityRank"]),
        )

        lines.extend(
            [
                f"## {profile_key}",
                "",
                f"- Court: {profile['court']}",
                f"- Period: {profile['timePeriod']}",
                f"- Status: {profile['empiricalStatus']}",
                f"- Target file(s): {profile.get('targetFile', '')}",
                f"- Context: {profile.get('contextScenarioKey', '') or '--'}; {profile.get('contextSourceFamily', '') or '--'}",
                f"- Evidence rows: {profile['sourceRows']} source rows; {profile['validationRows']} validation-counted rows; {profile.get('denominatorRows', '')} rows with stored denominators; {profile.get('sourceUrlRows', '')} rows with source URLs",
                f"- Next calibration priority: {profile['nextCalibrationPriority']}",
                "",
                "### Family Coverage",
                "",
            ]
        )
        lines.extend(
            markdown_table(
                [
                    "Family",
                    "Coverage",
                    "Source rows",
                    "Validation rows",
                    "Out-of-range",
                    "Largest miss",
                    "Gap",
                    "Candidates",
                    "Roadmap",
                    "Next step",
                ],
                [
                    [
                        family,
                        family_by_key[(profile_key, family)]["coverageStatus"],
                        family_by_key[(profile_key, family)]["sourceRows"],
                        family_by_key[(profile_key, family)]["validationRows"],
                        family_by_key[(profile_key, family)]["outOfRangeRows"],
                        family_by_key[(profile_key, family)]["largestGapTarget"] or "--",
                        family_by_key[(profile_key, family)]["largestGap"],
                        queue_by_key.get((profile_key, family), {}).get("candidateRows", "0"),
                        queue_by_key.get((profile_key, family), {}).get("roadmapRows", "0"),
                        cards_next_step(family_by_key[(profile_key, family)], queue_by_key.get((profile_key, family))),
                    ]
                    for family in build_court_profiles.PLATFORM_FAMILY_ORDER
                ],
            )
        )

        lines.extend(["", "### Validation Checks", ""])
        if profile_misses:
            lines.extend(
                markdown_table(
                    ["Family", "Target", "Source range", "Model interval", "Gap", "Status", "Miss category"],
                    [
                        [
                            build_court_profiles.family_for(row["targetKey"]),
                            row["label"],
                            row["sourceRange"],
                            row["modelInterval"],
                            row["gap"],
                            "within" if row["withinTarget"].lower() == "true" else "miss",
                            row["missCategory"],
                        ]
                        for row in profile_misses
                    ],
                )
            )
        else:
            lines.append("No validation-counted source-range rows are currently registered for this profile.")

        lines.extend(["", "### Source Rows", ""])
        if profile_sources:
            lines.extend(
                markdown_table(
                    ["Family", "Use", "Target", "Observed", "Range", "N", "Reliability", "Source"],
                    [
                        [
                            source_row_family(row),
                            source_use(row),
                            row["label"],
                            row["observedValue"],
                            f"{row['lowerBound']}--{row['upperBound']}",
                            row["n"],
                            row["reliability"],
                            row["sourceName"] or "--",
                        ]
                        for row in profile_sources
                    ],
                )
            )
        else:
            lines.append("No calibration source rows are currently registered for this profile.")

        lines.extend(["", "### Promotion Tasks", ""])
        if profile_queue:
            lines.extend(
                markdown_table(
                    ["Rank", "Readiness", "Action", "Family", "Coverage", "Candidate rows", "Top candidate", "Recommended action"],
                    [
                        [
                            row["priorityRank"],
                            row["promotionReadiness"],
                            row["actionType"],
                            row["targetFamily"],
                            row["coverageStatus"],
                            row["candidateRows"],
                            row["topCandidateLabel"] or "--",
                            row["recommendedAction"],
                        ]
                        for row in profile_queue[:8]
                    ],
                )
            )
        else:
            lines.append("No promotion task is currently queued for this profile.")
        lines.append("")

    return "\n".join(lines)


def markdown_report(
        profile_rows: list[dict[str, str]],
        family_rows: list[dict[str, str]],
        queue_rows: list[dict[str, str]],
        source_promotion_detail: list[dict[str, str]],
        source_rows: list[dict[str, str]],
        miss_rows: list[dict[str, str]],
        readiness: list[dict[str, str]],
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
    action_counts = Counter(row["actionType"] for row in queue_rows)
    readiness_counts = Counter(row["promotionReadiness"] for row in queue_rows)
    top_profiles = sorted(profile_rows, key=lambda row: (-float(row["largestGap"]), row["profileKey"]))[:8]
    top_queue = queue_rows[:12]
    source_gaps = source_gap_rows(queue_rows)[:12]

    lines = [
        "# Empirical Platform Coverage Report",
        "",
        "This generated report summarizes the reusable calibration-platform surface. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, `reports/constitutional-review-validation-v1-misses.csv`, and source-candidate roadmap files under `config/research/`.",
        "",
        "## Summary",
        "",
        f"- Court profiles: {len(profile_rows)}",
        f"- Calibration source rows: {len(source_rows)}",
        f"- Validation-counted source rows: {sum(int(row['validationRows']) for row in profile_rows)}",
        f"- Validation rows within source range: {sum(1 for row in miss_rows if row['withinTarget'].lower() == 'true')}",
        f"- Validation rows out of range: {len(failures)}",
        f"- Promotion queue rows: {len(queue_rows)}",
        f"- Source-promotion queue rows: {sum(1 for row in queue_rows if row['actionType'] == 'source-promotion')}",
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
    lines.extend(["", "## Readiness Gates", ""])
    lines.extend(
        markdown_table(
            ["Item", "Status", "Evidence", "Next action"],
            [
                [
                    row["readinessItem"],
                    row["status"],
                    row["evidence"],
                    row["nextAction"],
                ]
                for row in readiness
            ],
        )
    )
    lines.extend(["", "## Promotion Queue Actions", ""])
    lines.extend(
        markdown_table(
            ["Action type", "Rows"],
            [[action_type, str(action_counts[action_type])] for action_type in sorted(action_counts)],
        )
    )
    lines.extend(["", "## Promotion Readiness", ""])
    lines.extend(
        markdown_table(
            ["Readiness", "Rows"],
            [
                [status, str(readiness_counts[status])]
                for status in sorted(readiness_counts, key=lambda item: ACTIONABILITY_SORT_ORDER.get(item, 99))
            ],
        )
    )
    lines.extend(["", "## Source Promotion Blockers", ""])
    blocker_counts = source_promotion_blocker_counts(source_promotion_detail)
    if blocker_counts:
        lines.extend(
            markdown_table(
                ["Blocker", "Rows"],
                [[blocker, str(blocker_counts[blocker])] for blocker in sorted(blocker_counts)],
            )
        )
    else:
        lines.append("No source-promotion blockers are reported.")
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
    lines.extend(["", "## Top Promotion Queue", ""])
    lines.extend(
        markdown_table(
            ["Rank", "Readiness", "Action", "Profile", "Family", "Coverage", "Candidate rows", "Roadmap rows", "Recommended action"],
            [
                [
                    row["priorityRank"],
                    row["promotionReadiness"],
                    row["actionType"],
                    row["profileKey"],
                    row["targetFamily"],
                    row["coverageStatus"],
                    row["candidateRows"],
                    row["roadmapRows"],
                    row["recommendedAction"],
                ]
                for row in top_queue
            ],
        )
    )
    lines.extend(["", "## Source Gap Handoff", ""])
    lines.extend(
        markdown_table(
            ["Gap rank", "Readiness", "Profile", "Family", "Claim boundary", "Blocker"],
            [
                [
                    row["gapRank"],
                    row["promotionReadiness"],
                    row["profileKey"],
                    row["targetFamily"],
                    row["claimBoundary"],
                    row["blockingReason"],
                ]
                for row in source_gaps
            ],
        )
    )
    lines.extend(
        [
            "",
            "The coverage report is a planning artifact. Validation-counted rows remain limited to source-backed targets with denominators and direct simulator analogues; stress-only and missing families should not be described as country validation evidence.",
            "Use the source-promotion packet for row-level stress-only promotion audits, the candidate-verification packet for unpromoted candidates, and the source-acquisition packet for missing profile-family rows with no registered candidate.",
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
    candidates = candidate_rows()
    roadmaps = roadmap_rows()
    roadmap_detail = roadmap_items()
    source_detail = source_rows_by_family(source_rows)
    queue_rows = promotion_queue_rows(family_rows, candidates, roadmaps, source_detail)
    source_gaps = source_gap_rows(queue_rows)
    candidate_verifications = candidate_verification_rows(queue_rows, source_gaps, candidates)
    source_acquisitions = source_acquisition_rows(queue_rows, source_gaps, roadmap_detail)
    source_promotions = source_promotion_rows(queue_rows, source_gaps, source_detail)
    readiness = readiness_rows(profile_rows, family_rows, queue_rows, source_promotions, source_rows, miss_rows)
    return {
        PROFILE_REPORT: csv_text(profile_rows, PROFILE_REPORT_HEADER),
        FAMILY_REPORT: csv_text(family_rows, FAMILY_REPORT_HEADER),
        PROMOTION_QUEUE_REPORT: csv_text(queue_rows, PROMOTION_QUEUE_HEADER),
        SOURCE_GAP_REPORT: csv_text(source_gaps, SOURCE_GAP_HEADER),
        CANDIDATE_VERIFICATION_REPORT: csv_text(candidate_verifications, CANDIDATE_VERIFICATION_HEADER),
        SOURCE_ACQUISITION_REPORT: csv_text(source_acquisitions, SOURCE_ACQUISITION_HEADER),
        SOURCE_PROMOTION_REPORT: csv_text(source_promotions, SOURCE_PROMOTION_HEADER),
        READINESS_REPORT: csv_text(readiness, READINESS_HEADER),
        READINESS_MARKDOWN_REPORT: readiness_markdown(readiness),
        MARKDOWN_REPORT: markdown_report(profile_rows, family_rows, queue_rows, source_promotions, source_rows, miss_rows, readiness),
        PROFILE_CARDS: benchmark_cards(profiles, family_rows, queue_rows, source_rows, miss_rows),
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
