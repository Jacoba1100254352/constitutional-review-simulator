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
    "recommendedAction",
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
    "direct_defiance_rate": "compliance",
    "doctrine_share_by_area": "doctrine-mix",
    "emergencyReliefRate".lower(): "emergency",
    "executive_implementation_rate": "compliance",
    "front_end_rights_statement_accuracy": "case-selection",
    "government_repeat_player_advantage": "case-selection",
    "implementation_delay": "compliance",
    "implementation_follow_up_rate": "compliance",
    "intake_rejection_rate": "intake",
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
    "canada-scc": ["canada-scc-2024", "canada-scc-recent"],
    "south-africa-constcourt": ["south-africa-constcourt-recent"],
    "uk-supreme-court": ["uk-supreme-court-2024-2025", "uk-human-rights-doi-2025"],
    "echr": ["echr-2024"],
    "cjeu": ["cjeu-2024"],
}

LEGISLATIVE_SYSTEM_PROFILES = {
    "United Kingdom": ["uk-human-rights-doi-2025"],
    "Canada": ["canada-scc-recent", "canada-scc-2024"],
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


def candidate_score(row: dict[str, str]) -> tuple[int, int, int, str]:
    verified = 1 if row["sourceUrlStatus"].startswith("verified:https://") else 0
    direct = 1 if row["directAnalogue"].lower() == "true" else 0
    denominator = 1 if row["denominator"].strip() and row["denominator"].strip() != "0" else 0
    return (verified, direct, denominator, row["label"])


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
        return "verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows"
    if action_type == "candidate-verification" and top_candidate:
        if not top_candidate["sourceUrlStatus"].startswith("verified:https://"):
            return "verify primary source URL and numerator/denominator before promotion"
        if top_candidate["directAnalogue"].lower() != "true":
            return "keep as contextual evidence unless recoded to a direct simulator analogue"
        return "audit construction note and promote if target key is simulator-observable"
    if action_type == "source-acquisition":
        return "collect denominator-backed source rows for this profile-family"
    return ""


def promotion_queue_rows(
        family_rows: list[dict[str, str]],
        candidates_by_family: dict[tuple[str, str], list[dict[str, str]]],
        roadmap_by_family: dict[tuple[str, str], int],
) -> list[dict[str, str]]:
    pending: list[tuple[tuple[float, int, int, str, str], dict[str, str]]] = []
    for family_row in family_rows:
        key = (family_row["profileKey"], family_row["targetFamily"])
        candidates = candidates_by_family.get(key, [])
        roadmap_count = roadmap_by_family.get(key, 0)
        action_type = queue_action_type(family_row, candidates, roadmap_count)
        if not action_type:
            continue

        verified_count = sum(1 for row in candidates if row["sourceUrlStatus"].startswith("verified:https://"))
        pending_count = sum(1 for row in candidates if row["sourceUrlStatus"].startswith("pending"))
        direct_count = sum(1 for row in candidates if row["directAnalogue"].lower() == "true")
        top_candidate = max(candidates, key=candidate_score) if candidates else None
        action_weight = {
            "model-calibration": 0,
            "candidate-verification": 1,
            "source-promotion": 2,
            "source-acquisition": 3,
        }[action_type]
        sort_key = (
            -float(family_row["largestGap"]),
            action_weight,
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
                    "recommendedAction": queue_recommendation(action_type, family_row, top_candidate),
                },
            )
        )
    output = [row for _, row in sorted(pending, key=lambda item: item[0])]
    for index, row in enumerate(output, start=1):
        row["priorityRank"] = str(index)
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
        for family in build_court_profiles.PLATFORM_FAMILY_ORDER
        if family not in validation_families
    ]
    action_counts = Counter(row["actionType"] for row in queue_rows)
    queue_summary = ", ".join(
        f"{action_counts[action]} {action}"
        for action in sorted(action_counts)
    ) or "no queued actions"
    top_queue = queue_rows[0] if queue_rows else None
    top_queue_summary = (
        f"{top_queue['actionType']} for {top_queue['profileKey']} {top_queue['targetFamily']}"
        if top_queue
        else "no current queue item"
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
                f"{len(validation_families)}/{len(build_court_profiles.PLATFORM_FAMILY_ORDER)} families have validation-counted rows; "
                f"missing validation families: {', '.join(missing_validation_families) if missing_validation_families else 'none'}"
            ),
            "interpretation": "The platform now fits its narrow benchmark surface, but compliance, cost, doctrine, and political-context families remain outside validation counts.",
            "nextAction": "Use source-acquisition and source-promotion queue rows to expand family coverage with URLs, denominators, and direct analogues.",
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
            "evidence": f"{len(queue_rows)} queued tasks; {queue_summary}; top queue item: {top_queue_summary}",
            "interpretation": "After clearing current source-range misses, the next empirical work is coverage expansion rather than additional retuning.",
            "nextAction": "Work promotion-queue rows in rank order, starting with candidate verification and then source promotion.",
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
                    ["Rank", "Action", "Family", "Coverage", "Candidate rows", "Top candidate", "Recommended action"],
                    [
                        [
                            row["priorityRank"],
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
    top_profiles = sorted(profile_rows, key=lambda row: (-float(row["largestGap"]), row["profileKey"]))[:8]
    top_queue = queue_rows[:12]

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
            ["Rank", "Action", "Profile", "Family", "Coverage", "Gap", "Candidate rows", "Roadmap rows", "Recommended action"],
            [
                [
                    row["priorityRank"],
                    row["actionType"],
                    row["profileKey"],
                    row["targetFamily"],
                    row["coverageStatus"],
                    row["largestGap"],
                    row["candidateRows"],
                    row["roadmapRows"],
                    row["recommendedAction"],
                ]
                for row in top_queue
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
    queue_rows = promotion_queue_rows(family_rows, candidate_rows(), roadmap_rows())
    readiness = readiness_rows(profile_rows, family_rows, queue_rows, source_rows, miss_rows)
    return {
        PROFILE_REPORT: csv_text(profile_rows, PROFILE_REPORT_HEADER),
        FAMILY_REPORT: csv_text(family_rows, FAMILY_REPORT_HEADER),
        PROMOTION_QUEUE_REPORT: csv_text(queue_rows, PROMOTION_QUEUE_HEADER),
        READINESS_REPORT: csv_text(readiness, READINESS_HEADER),
        READINESS_MARKDOWN_REPORT: readiness_markdown(readiness),
        MARKDOWN_REPORT: markdown_report(profile_rows, family_rows, queue_rows, source_rows, miss_rows, readiness),
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
