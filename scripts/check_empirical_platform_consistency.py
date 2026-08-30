#!/usr/bin/env python3
"""Validate generated empirical-platform queue consistency."""

from __future__ import annotations

import csv
import sys
from collections import Counter
from pathlib import Path

import build_empirical_platform_report


ROOT = Path(__file__).resolve().parents[1]
QUEUE_REPORT = build_empirical_platform_report.PROMOTION_QUEUE_REPORT
FAMILY_REPORT = build_empirical_platform_report.FAMILY_REPORT
SOURCE_GAP_REPORT = build_empirical_platform_report.SOURCE_GAP_REPORT
CANDIDATE_VERIFICATION_REPORT = build_empirical_platform_report.CANDIDATE_VERIFICATION_REPORT
SOURCE_ACQUISITION_REPORT = build_empirical_platform_report.SOURCE_ACQUISITION_REPORT
SOURCE_PROMOTION_REPORT = build_empirical_platform_report.SOURCE_PROMOTION_REPORT
READINESS_REPORT = build_empirical_platform_report.READINESS_REPORT


def read_rows(path: Path, expected_header: list[str], errors: list[str]) -> list[dict[str, str]]:
    if not path.exists():
        errors.append(f"{path.relative_to(ROOT)}: missing generated report")
        return []
    with path.open(newline="", encoding="utf-8") as handle:
        reader = csv.DictReader(handle)
        if reader.fieldnames != expected_header:
            errors.append(
                f"{path.relative_to(ROOT)}: header mismatch; expected {expected_header}; got {reader.fieldnames}"
            )
            return []
        return list(reader)


def int_field(row: dict[str, str], field: str, label: str, errors: list[str]) -> int:
    try:
        return int(row[field])
    except (KeyError, ValueError):
        errors.append(f"{label}: field {field} must be an integer; got {row.get(field, '')!r}")
        return -1


def check_contiguous_ranks(rows: list[dict[str, str]], rank_field: str, label: str, errors: list[str]) -> None:
    ranks = [int_field(row, rank_field, f"{label} row", errors) for row in rows]
    expected = list(range(1, len(rows) + 1))
    if sorted(ranks) != expected:
        errors.append(f"{label}: {rank_field} values must be contiguous 1..{len(rows)}")


def check_actionability(row: dict[str, str], errors: list[str]) -> None:
    label = f"promotion queue rank {row['priorityRank']}"
    status = row["promotionReadiness"]
    action = row["actionType"]
    coverage = row["coverageStatus"]
    candidates = int_field(row, "candidateRows", label, errors)
    verified = int_field(row, "verifiedCandidateRows", label, errors)
    pending = int_field(row, "pendingVerificationRows", label, errors)
    direct = int_field(row, "directAnalogueCandidateRows", label, errors)
    roadmap = int_field(row, "roadmapRows", label, errors)
    out_of_range = int_field(row, "outOfRangeRows", label, errors)

    if status not in build_empirical_platform_report.ACTIONABILITY_SORT_ORDER:
        errors.append(f"{label}: unknown promotionReadiness {status!r}")
    if candidates < verified or candidates < pending or candidates < direct:
        errors.append(f"{label}: candidate subtotals cannot exceed candidateRows")
    if status == "model-calibration-needed" and (action != "model-calibration" or out_of_range <= 0):
        errors.append(f"{label}: model-calibration-needed requires model-calibration action and out-of-range rows")
    if status == "model-metric-gap" and (action != "candidate-verification" or verified <= 0 or direct != 0):
        errors.append(f"{label}: model-metric-gap requires verified source evidence without a current direct analogue")
    if status == "ready-for-promotion-review" and (action != "candidate-verification" or verified <= 0 or direct <= 0):
        errors.append(f"{label}: ready-for-promotion-review requires verified direct candidate evidence")
    if status == "claim-boundary-decision-needed" and (action != "source-promotion" or coverage != "stress-only"):
        errors.append(f"{label}: claim-boundary-decision-needed requires stress-only source-promotion")
    if status == "verify-primary-source" and (action != "candidate-verification" or pending <= 0 or direct <= 0):
        errors.append(f"{label}: verify-primary-source requires pending direct candidate evidence")
    if status == "verify-source-values" and (action != "candidate-verification" or candidates <= 0 or direct <= 0):
        errors.append(f"{label}: verify-source-values requires direct candidate evidence with a located source")
    if status == "needs-source-documentation" and (action != "source-promotion" or coverage != "stress-only"):
        errors.append(f"{label}: needs-source-documentation requires stress-only source-promotion")
    if status == "candidate-triage-needed" and action != "candidate-verification":
        errors.append(f"{label}: candidate-triage-needed requires candidate-verification action")
    if status == "source-acquisition-needed" and (action != "source-acquisition" or candidates != 0 or roadmap <= 0):
        errors.append(f"{label}: source-acquisition-needed requires a roadmap-backed missing candidate")
    if status == "context-only-blocked" and (action != "candidate-verification" or direct != 0 or verified <= 0):
        errors.append(f"{label}: context-only-blocked requires verified non-direct context evidence")


def check_source_gaps(
        queue_rows: list[dict[str, str]],
        source_gap_rows: list[dict[str, str]],
        errors: list[str],
) -> None:
    if len(queue_rows) != len(source_gap_rows):
        errors.append(
            f"{SOURCE_GAP_REPORT.relative_to(ROOT)}: expected {len(queue_rows)} rows from promotion queue; got {len(source_gap_rows)}"
        )
        return
    queue_by_rank = {row["priorityRank"]: row for row in queue_rows}
    expected_order = sorted(
        queue_rows,
        key=lambda row: (
            build_empirical_platform_report.ACTIONABILITY_SORT_ORDER.get(row["promotionReadiness"], 99),
            int(row["priorityRank"]),
        ),
    )
    for index, (gap_row, queue_row) in enumerate(zip(source_gap_rows, expected_order), start=1):
        label = f"source gap rank {index}"
        if gap_row["gapRank"] != str(index):
            errors.append(f"{label}: gapRank should be {index}")
        queue_priority = gap_row["queuePriorityRank"]
        if queue_priority not in queue_by_rank:
            errors.append(f"{label}: queuePriorityRank {queue_priority} does not exist in promotion queue")
            continue
        if queue_priority != queue_row["priorityRank"]:
            errors.append(
                f"{label}: source gaps are not sorted by promotion readiness; expected queue rank {queue_row['priorityRank']}"
            )
        for field in [
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
        ]:
            if gap_row[field] != queue_by_rank[queue_priority][field]:
                errors.append(f"{label}: field {field} differs from promotion queue rank {queue_priority}")


def check_candidate_verifications(
        queue_rows: list[dict[str, str]],
        source_gap_rows: list[dict[str, str]],
        candidate_rows: list[dict[str, str]],
        errors: list[str],
) -> None:
    queue_by_rank = {row["priorityRank"]: row for row in queue_rows}
    gap_by_queue_rank = {row["queuePriorityRank"]: row["gapRank"] for row in source_gap_rows}
    rows_by_queue_rank: dict[str, list[dict[str, str]]] = {}
    for row in candidate_rows:
        queue_rank = row["queuePriorityRank"]
        rows_by_queue_rank.setdefault(queue_rank, []).append(row)
        if queue_rank not in queue_by_rank:
            errors.append(f"candidate verification row {row.get('gapRank', '')}: queuePriorityRank {queue_rank} does not exist")
            continue
        queue_row = queue_by_rank[queue_rank]
        expected_gap_rank = gap_by_queue_rank.get(queue_rank, "")
        if row["gapRank"] != expected_gap_rank:
            errors.append(f"candidate verification queue rank {queue_rank}: gapRank should be {expected_gap_rank}")
        for field in [
                "promotionReadiness",
                "claimBoundary",
                "profileKey",
                "court",
                "targetFamily",
                "coverageStatus",
        ]:
            if row[field] != queue_row[field]:
                errors.append(f"candidate verification queue rank {queue_rank}: field {field} differs from promotion queue")
    for queue_row in queue_rows:
        queue_rank = queue_row["priorityRank"]
        rows = rows_by_queue_rank.get(queue_rank, [])
        expected_count = int_field(queue_row, "candidateRows", f"promotion queue rank {queue_rank}", errors)
        if len(rows) != expected_count:
            errors.append(
                f"candidate verification queue rank {queue_rank}: expected {expected_count} candidates; got {len(rows)}"
            )
            continue
        ranks = [int_field(row, "candidateRank", f"candidate verification queue rank {queue_rank}", errors) for row in rows]
        if sorted(ranks) != list(range(1, len(rows) + 1)):
            errors.append(f"candidate verification queue rank {queue_rank}: candidateRank values must be contiguous")
        top_rows = [row for row in rows if row["topCandidate"].lower() == "true"]
        if expected_count == 0 and top_rows:
            errors.append(f"candidate verification queue rank {queue_rank}: no top candidate expected")
        if expected_count > 0 and len(top_rows) != 1:
            errors.append(f"candidate verification queue rank {queue_rank}: expected one topCandidate=true row")
        if top_rows:
            top = top_rows[0]
            if (
                    top["sourceFile"] != queue_row["topCandidateFile"]
                    or top["label"] != queue_row["topCandidateLabel"]
                    or top["status"] != queue_row["topCandidateStatus"]
                    or top["sourceUrlStatus"] != queue_row["topCandidateSourceStatus"]
            ):
                errors.append(f"candidate verification queue rank {queue_rank}: top candidate fields differ from promotion queue")


def check_source_acquisitions(
        queue_rows: list[dict[str, str]],
        source_gap_rows: list[dict[str, str]],
        acquisition_rows: list[dict[str, str]],
        errors: list[str],
) -> None:
    queue_by_rank = {row["priorityRank"]: row for row in queue_rows}
    gap_by_queue_rank = {row["queuePriorityRank"]: row["gapRank"] for row in source_gap_rows}
    rows_by_queue_rank: dict[str, list[dict[str, str]]] = {}
    for row in acquisition_rows:
        queue_rank = row["queuePriorityRank"]
        rows_by_queue_rank.setdefault(queue_rank, []).append(row)
        if queue_rank not in queue_by_rank:
            errors.append(f"source acquisition row {row.get('gapRank', '')}: queuePriorityRank {queue_rank} does not exist")
            continue
        queue_row = queue_by_rank[queue_rank]
        expected_gap_rank = gap_by_queue_rank.get(queue_rank, "")
        if row["gapRank"] != expected_gap_rank:
            errors.append(f"source acquisition queue rank {queue_rank}: gapRank should be {expected_gap_rank}")
        for field in [
                "promotionReadiness",
                "claimBoundary",
                "actionType",
                "profileKey",
                "court",
                "targetFamily",
                "coverageStatus",
        ]:
            if row[field] != queue_row[field]:
                errors.append(f"source acquisition queue rank {queue_rank}: field {field} differs from promotion queue")
        for field in [
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
        ]:
            if field not in row:
                errors.append(f"source acquisition queue rank {queue_rank}: missing field {field}")
    for queue_row in queue_rows:
        queue_rank = queue_row["priorityRank"]
        rows = rows_by_queue_rank.get(queue_rank, [])
        expected_count = int_field(queue_row, "roadmapRows", f"promotion queue rank {queue_rank}", errors)
        if len(rows) != expected_count:
            errors.append(f"source acquisition queue rank {queue_rank}: expected {expected_count} roadmap rows; got {len(rows)}")
            continue
        ranks = [int_field(row, "acquisitionRank", f"source acquisition queue rank {queue_rank}", errors) for row in rows]
        if sorted(ranks) != list(range(1, len(rows) + 1)):
            errors.append(f"source acquisition queue rank {queue_rank}: acquisitionRank values must be contiguous")


def check_source_promotions(
        queue_rows: list[dict[str, str]],
        family_rows: list[dict[str, str]],
        source_gap_rows: list[dict[str, str]],
        promotion_rows: list[dict[str, str]],
        errors: list[str],
) -> None:
    queue_by_rank = {row["priorityRank"]: row for row in queue_rows}
    family_by_key = {(row["profileKey"], row["targetFamily"]): row for row in family_rows}
    gap_by_queue_rank = {row["queuePriorityRank"]: row["gapRank"] for row in source_gap_rows}
    rows_by_queue_rank: dict[str, list[dict[str, str]]] = {}
    for row in promotion_rows:
        queue_rank = row["queuePriorityRank"]
        rows_by_queue_rank.setdefault(queue_rank, []).append(row)
        if queue_rank not in queue_by_rank:
            errors.append(f"source promotion row {row.get('gapRank', '')}: queuePriorityRank {queue_rank} does not exist")
            continue
        queue_row = queue_by_rank[queue_rank]
        expected_gap_rank = gap_by_queue_rank.get(queue_rank, "")
        if row["gapRank"] != expected_gap_rank:
            errors.append(f"source promotion queue rank {queue_rank}: gapRank should be {expected_gap_rank}")
        if queue_row["actionType"] != "source-promotion":
            errors.append(f"source promotion queue rank {queue_rank}: row points to non-source-promotion queue item")
        for field in [
                "promotionReadiness",
                "claimBoundary",
                "profileKey",
                "court",
                "targetFamily",
                "coverageStatus",
        ]:
            if row[field] != queue_row[field]:
                errors.append(f"source promotion queue rank {queue_rank}: field {field} differs from promotion queue")
        if not row["promotionBlockers"]:
            errors.append(f"source promotion queue rank {queue_rank}: promotionBlockers must not be blank")
        if not row["recommendedPromotion"]:
            errors.append(f"source promotion queue rank {queue_rank}: recommendedPromotion must not be blank")
    for queue_row in queue_rows:
        queue_rank = queue_row["priorityRank"]
        rows = rows_by_queue_rank.get(queue_rank, [])
        if queue_row["actionType"] != "source-promotion":
            if rows:
                errors.append(f"source promotion queue rank {queue_rank}: no source-promotion rows expected")
            continue
        family_row = family_by_key.get((queue_row["profileKey"], queue_row["targetFamily"]))
        if family_row is None:
            errors.append(f"source promotion queue rank {queue_rank}: missing family coverage row")
            continue
        expected_count = int_field(family_row, "stressOnlyRows", f"source promotion queue rank {queue_rank}", errors)
        if len(rows) != expected_count:
            errors.append(f"source promotion queue rank {queue_rank}: expected {expected_count} stress-only rows; got {len(rows)}")
            continue
        ranks = [int_field(row, "promotionRank", f"source promotion queue rank {queue_rank}", errors) for row in rows]
        if sorted(ranks) != list(range(1, len(rows) + 1)):
            errors.append(f"source promotion queue rank {queue_rank}: promotionRank values must be contiguous")


def check_readiness(
        queue_rows: list[dict[str, str]],
        source_promotion_rows: list[dict[str, str]],
        readiness_rows: list[dict[str, str]],
        errors: list[str],
) -> None:
    rows_by_item = {row["readinessItem"]: row for row in readiness_rows}
    row = rows_by_item.get("promotion-pipeline")
    if row is None:
        errors.append(f"{READINESS_REPORT.relative_to(ROOT)}: missing promotion-pipeline readiness row")
        return
    evidence = row["evidence"]
    for action, count in Counter(queue_row["actionType"] for queue_row in queue_rows).items():
        token = f"{count} {action}"
        if token not in evidence:
            errors.append(f"promotion-pipeline readiness evidence missing action count {token!r}")
    for status, count in Counter(queue_row["promotionReadiness"] for queue_row in queue_rows).items():
        token = f"{count} {status}"
        if token not in evidence:
            errors.append(f"promotion-pipeline readiness evidence missing readiness count {token!r}")
    if queue_rows:
        top = queue_rows[0]
        token = f"{top['promotionReadiness']} for {top['profileKey']} {top['targetFamily']}"
        if token not in evidence:
            errors.append(f"promotion-pipeline readiness evidence missing top actionable item {token!r}")
    if source_promotion_rows:
        detail_token = f"{len(source_promotion_rows)} stress-only source rows"
        if detail_token not in evidence:
            errors.append(f"promotion-pipeline readiness evidence missing source-promotion row count {detail_token!r}")
    for blocker, count in build_empirical_platform_report.source_promotion_blocker_counts(source_promotion_rows).items():
        token = f"{count} {blocker}"
        if token not in evidence:
            errors.append(f"promotion-pipeline readiness evidence missing source-promotion blocker count {token!r}")


def main() -> int:
    errors: list[str] = []
    queue_rows = read_rows(
        QUEUE_REPORT,
        build_empirical_platform_report.PROMOTION_QUEUE_HEADER,
        errors,
    )
    family_rows = read_rows(
        FAMILY_REPORT,
        build_empirical_platform_report.FAMILY_REPORT_HEADER,
        errors,
    )
    source_gap_rows = read_rows(
        SOURCE_GAP_REPORT,
        build_empirical_platform_report.SOURCE_GAP_HEADER,
        errors,
    )
    candidate_verification_rows = read_rows(
        CANDIDATE_VERIFICATION_REPORT,
        build_empirical_platform_report.CANDIDATE_VERIFICATION_HEADER,
        errors,
    )
    source_acquisition_rows = read_rows(
        SOURCE_ACQUISITION_REPORT,
        build_empirical_platform_report.SOURCE_ACQUISITION_HEADER,
        errors,
    )
    source_promotion_rows = read_rows(
        SOURCE_PROMOTION_REPORT,
        build_empirical_platform_report.SOURCE_PROMOTION_HEADER,
        errors,
    )
    readiness_rows = read_rows(
        READINESS_REPORT,
        build_empirical_platform_report.READINESS_HEADER,
        errors,
    )
    check_contiguous_ranks(queue_rows, "priorityRank", "promotion queue", errors)
    check_contiguous_ranks(source_gap_rows, "gapRank", "source gaps", errors)
    for row in queue_rows:
        check_actionability(row, errors)
    check_source_gaps(queue_rows, source_gap_rows, errors)
    check_candidate_verifications(queue_rows, source_gap_rows, candidate_verification_rows, errors)
    check_source_acquisitions(queue_rows, source_gap_rows, source_acquisition_rows, errors)
    check_source_promotions(queue_rows, family_rows, source_gap_rows, source_promotion_rows, errors)
    check_readiness(queue_rows, source_promotion_rows, readiness_rows, errors)
    if errors:
        for error in errors:
            print(f"empirical platform consistency error: {error}", file=sys.stderr)
        return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
