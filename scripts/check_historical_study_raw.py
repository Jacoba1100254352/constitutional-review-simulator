"""Independent streaming reconciliation of paired-study cases, objects and run metrics."""

from __future__ import annotations

import argparse
from collections import Counter, defaultdict
import hashlib
from itertools import groupby
import json
import math
from pathlib import Path

from historical_data import ROOT, json_bytes, load_protocol
from historical_study import PREFIX, check_study, expected_contexts, file_hash, read_rows


# Independent, explicit declaration-order contract, not Java reflection or its aggregators.
CASE_FIELDS = [(name, "text") for name in ("id", "type", "doctrineArea", "policyDomain", "jurisdiction", "lowerCourtPath")]
CASE_FIELDS += [("reviewPeriod", "integer")]
CASE_FIELDS += [(name, "double") for name in (
    "policyPosition", "rightsThreat", "publicSupport", "legislativeMandate", "urgency", "legalAmbiguity",
    "constitutionalSalience", "lowerCourtConflict", "lowerCourtPanelSkew", "stateFederalTension",
    "intercourtConflict", "certiorariPressure", "timeToReview")]
CASE_FIELDS += [("lowerCourtGovernmentWin", "boolean")]
CASE_FIELDS += [(name, "double") for name in ("executivePressure", "conflictOfInterestRisk", "publicTrust",
                                            "litigantCapacity", "publicInterestSupport", "governmentRepeatPlayerAdvantage")]
CASE_FIELDS += [("source", "text")]
OBJECT_FIELDS = [("id", "text"), ("kind", "text"), ("jurisdiction", "text"), ("vulnerability", "double")]
MEAN_FIELDS = (
    "legalStability", "rightsProtection", "partisanAlignment", "shadowDocketAbuse", "legitimacy",
    "constitutionalConflict", "democraticResponsiveness", "legislativeResponseCredibility", "caseSelectionAccess",
    "governmentRepeatPlayerAdvantage", "implementationCapacity", "independenceAccountabilityBalance",
    "concurrenceFragmentation", "dissentIntensity", "courtCurbingPressure", "amendmentPressure",
    "administrativeLoad", "directCourtCost", "upstreamScreeningCost", "capacityStrainCost",
    "institutionalBudgetCost", "institutionalDelayCost", "implementationComplexity", "totalInstitutionalCost",
    "vetoRelocationRisk", "legalTransplantFeasibility", "politicalCultureSensitivity", "democraticConstitutionalism")
EVENT_RATES = {
    "complianceRate": "complied", "defianceRate": "defied", "workaroundRate": "workaround",
    "repeatedLitigationRate": "repeatedLitigation", "executiveImplementationRate": "executiveImplementation",
    "agencyNonacquiescenceRate": "agencyNonacquiescence", "legislativeReenactmentRate": "legislativeReenactment",
    "localGovernmentComplianceRate": "localGovernmentCompliance", "weakFormDeclarationRate": "weakFormDeclaration",
    "suspendedDeclarationRate": "suspendedDeclaration", "legislativeResponseRate": "legislativeResponse",
    "rightsImpactStatementRate": "rightsImpactStatement", "ombudsmanTriggerRate": "ombudsmanTriggered",
    "publicDefenderParticipationRate": "publicDefenderParticipation", "preEnactmentReviewRate": "preEnactmentReview",
    "abstractReviewRate": "abstractReview", "preliminaryReferenceRate": "preliminaryReferenceRoute",
    "appealRouteRate": "appealRoute", "directActionRate": "directActionRoute"}


def boolean(value: str) -> int:
    if value not in {"true", "false"}:
        raise ValueError("invalid raw boolean")
    return int(value == "true")


def java_hex(value: str) -> str:
    number = float(value)
    if not math.isfinite(number):
        raise ValueError("nonfinite raw input")
    fraction, exponent = number.hex().split("p")
    fraction = fraction.rstrip("0")
    if fraction.endswith("."):
        fraction += "0"
    return f"{fraction}p{int(exponent)}"


def token(digest, value: str) -> None:
    encoded = value.encode()
    digest.update(f"{len(encoded)}:".encode())
    digest.update(encoded)


def record(digest, class_name: str, fields: list, row: dict) -> None:
    token(digest, class_name)
    for field, kind in fields:
        token(digest, field)
        value = row[field]
        if kind == "double":
            value = java_hex(value)
        elif kind == "integer":
            value = str(int(value))
        elif kind == "boolean":
            boolean(value)
        token(digest, value)


def object_list(digest, objects: list[dict]) -> None:
    token(digest, f"list:{len(objects)}")
    for row in objects:
        record(digest, "courtsim.model.ChallengeObject", OBJECT_FIELDS, row)


def docket_hashes(docket: list[dict], objects: dict[str, list[dict]]) -> tuple[str, str]:
    cases_digest, objects_digest = hashlib.sha256(), hashlib.sha256()
    token(cases_digest, f"list:{len(docket)}")
    token(objects_digest, f"list:{len(docket)}")
    for case in docket:
        record(cases_digest, "courtsim.model.CaseFile", CASE_FIELDS, case)
        token(cases_digest, "challengeObjects")
        object_list(cases_digest, objects[case["id"]])
        object_list(objects_digest, objects[case["id"]])
    return cases_digest.hexdigest(), objects_digest.hexdigest()


def ratio(numerator, denominator):
    return numerator / denominator if denominator else 0.0


def aggregate(docket: list[dict], cases: list[dict], objects: list[dict]) -> dict:
    n = len(cases)
    if n == 0:
        raise ValueError("empty raw run")
    counts = {name: sum(boolean(row[field]) for row in cases) for name, field in {
        "reviewedCases": "reviewed", "invalidations": "invalidated", "emergencyOrders": "emergencyOrder",
        "emergencyReliefs": "emergencyReliefGranted", "meritsReviews": "meritsReview",
        "meritsInvalidations": "meritsInvalidated", "overrides": "overrideUsed"}.items()}
    counts.update(totalCases=n, intakeFilings=sum(int(row["intakeFilings"]) for row in cases),
                  screenedFilings=sum(int(row["screenedFilings"]) for row in cases))
    result = dict(counts)
    result.update({name: math.fsum(float(row[name]) for row in cases) / n for name in MEAN_FIELDS})
    result.update({name: sum(boolean(row[field]) for row in cases) / n for name, field in EVENT_RATES.items()})
    result.update({name: math.fsum(float(row[field]) for row in cases) / n for name, field in {
        "publicTrust": "publicTrustAfter", "legislativeConflict": "legislativeConflictAfter",
        "replacementRate": "replacementPressure"}.items()})
    result.update({name: math.fsum(float(row[field]) for row in docket) / n for name, field in {
        "averageTimeToReview": "timeToReview", "lowerCourtConflict": "lowerCourtConflict",
        "stateFederalTension": "stateFederalTension", "intercourtConflict": "intercourtConflict"}.items()})
    result.update(reviewRate=ratio(counts["reviewedCases"], n),
                  intakeAcceptanceRate=ratio(counts["reviewedCases"], counts["intakeFilings"]),
                  emergencyReliefRate=ratio(counts["emergencyReliefs"], counts["emergencyOrders"]),
                  meritsReviewRate=ratio(counts["meritsReviews"], counts["reviewedCases"]),
                  meritsInvalidationRate=ratio(counts["meritsInvalidations"], counts["meritsReviews"]),
                  overrideRate=ratio(counts["overrides"], counts["invalidations"]),
                  reversalRate=ratio(counts["invalidations"], counts["reviewedCases"]))
    for name, field in (("emergencyReasonGivingRate", "reasonsGiven"),
                        ("emergencyVoteDisclosureRate", "voteDisclosed"),
                        ("emergencyPublicDisagreementRate", "publicDisagreement")):
        result[name] = ratio(sum(boolean(row["emergencyOrder"]) * boolean(row[field]) for row in cases), counts["emergencyOrders"])
    for name, field, denominator in (
            ("meritsFollowUpRate", "meritsFollowUp", counts["emergencyOrders"]),
            ("governmentEmergencyApplicantShare", "governmentEmergencyApplicant", counts["emergencyOrders"]),
            ("governmentEmergencyWinRate", "governmentEmergencyWin", sum(boolean(r["governmentEmergencyApplicant"]) for r in cases)),
            ("councilScreenRate", "councilScreen", counts["reviewedCases"]),
            ("crossCheckRate", "crossChecked", counts["reviewedCases"]),
            ("enBancRate", "enBancReview", counts["reviewedCases"])):
        result[name] = ratio(sum(boolean(row[field]) for row in cases), denominator)
    replies = sum(boolean(row["legislativeResponse"]) for row in cases)
    result["timelyLegislativeResponseRate"] = ratio(sum(boolean(row["timelyLegislativeResponse"]) for row in cases), replies)
    result["averageLegislativeResponseDelay"] = ratio(math.fsum(float(row["legislativeResponseDelay"])
                                                               for row in cases if boolean(row["legislativeResponse"])), replies)
    result["statuteDispositions"] = sum(row["kind"] == "STATUTE" and row["result"] != "NOT_REACHED" for row in objects)
    result["statuteNullifications"] = sum(row["kind"] == "STATUTE" and row["result"] == "NULLIFIED" for row in objects)
    return result


def groups(path: Path, fields: tuple[str, ...]):
    for key, rows in groupby(read_rows(path), key=lambda row: tuple(row[field] for field in fields)):
        yield key, list(rows)


def matching_group(iterator, expected):
    item = next(iterator, None)
    if item is None or item[0] != expected:
        raise ValueError("missing, reordered or substituted raw run group")
    return item[1]


def reconcile(directory: Path, protocol: dict) -> dict:
    key_fields = ("profile", "context", "run")
    dockets = groups(directory / f"{PREFIX}-dockets.csv.gz", key_fields)
    cases = groups(directory / f"{PREFIX}-cases.csv.gz", (*key_fields, "scenario"))
    objects = groups(directory / f"{PREFIX}-objects.csv.gz", (*key_fields, "scenario"))
    metrics = iter(read_rows(directory / f"{PREFIX}-runs.csv.gz"))
    designs = protocol["stressScenarioKeys"] + protocol["stressAblations"]
    totals = Counter()
    empty = Counter()
    checked_metrics = set()
    shared_keys = set()
    for shared_key, docket in dockets:
        if (shared_key in shared_keys or shared_key[0] not in protocol["stressDocketProfiles"]
                or shared_key[1] not in expected_contexts(protocol)
                or not 0 <= int(shared_key[2]) < protocol["simulationRuns"]):
            raise ValueError("duplicate or unregistered shared docket")
        shared_keys.add(shared_key)
        if len(docket) != protocol["simulationCasesPerRun"] or len({row["id"] for row in docket}) != len(docket):
            raise ValueError("shared docket case count or uniqueness failure")
        docket_ids = [row["id"] for row in docket]
        expected_object_inputs = None
        hashes = None
        for scenario in designs:
            key = (*shared_key, scenario)
            case_rows = matching_group(cases, key)
            object_rows = matching_group(objects, key)
            summary = next(metrics, None)
            if summary is None or tuple(summary[field] for field in key_fields) + (summary["scenarioKey"],) != key:
                raise ValueError("raw/aggregate run ordering or identity failure")
            if [row["caseId"] for row in case_rows] != docket_ids:
                raise ValueError("raw cases do not match the complete ordered shared docket")
            by_case = defaultdict(list)
            object_inputs = []
            seen_objects = set()
            for row in object_rows:
                object_key = row["caseId"], row["id"]
                if object_key in seen_objects or row["caseId"] not in docket_ids:
                    raise ValueError("duplicate or orphan challenged object")
                seen_objects.add(object_key)
                by_case[row["caseId"]].append(row)
                object_inputs.append((row["caseId"], *(row[field] for field, _ in OBJECT_FIELDS)))
                if row["result"] not in {"NOT_REACHED", "UPHELD", "NULLIFIED", "CONDUCT_REMEDY", "DECLARATION"}:
                    raise ValueError("unrecognized object disposition")
                if (boolean(row["statuteDisposition"]) != (row["kind"] == "STATUTE" and row["result"] != "NOT_REACHED")
                        or boolean(row["statuteNullification"]) != (row["kind"] == "STATUTE" and row["result"] == "NULLIFIED")):
                    raise ValueError("raw statute indicators disagree with source object unit and disposition")
            if set(by_case) != set(docket_ids):
                raise ValueError("raw objects do not cover every docket case")
            if expected_object_inputs is None:
                expected_object_inputs = object_inputs
                hashes = docket_hashes(docket, by_case)
            elif object_inputs != expected_object_inputs:
                raise ValueError("designs received different ordered challenged objects")
            if hashes != (summary["docketSha256"], summary["objectsSha256"]):
                raise ValueError("independent raw reconstruction differs from recorded docket/object hashes")
            reconstructed = aggregate(docket, case_rows, object_rows)
            for metric, value in reconstructed.items():
                if not math.isclose(float(summary[metric]), value, rel_tol=1e-12, abs_tol=1e-12):
                    raise ValueError(f"raw/run metric mismatch: {metric}, {key}")
                checked_metrics.add(metric)
            if reconstructed["emergencyOrders"] == 0:
                empty["runsWithoutEmergencyOrders"] += 1
            if reconstructed["legislativeResponseRate"] == 0:
                empty["runsWithoutLegislativeResponses"] += 1
            totals["designRuns"] += 1
            totals["caseOutcomes"] += len(case_rows)
            totals["objectOutcomes"] += len(object_rows)
        totals["sharedDockets"] += 1
        totals["sharedCases"] += len(docket)
        totals["sharedObjects"] += len(expected_object_inputs)
    if next(cases, None) is not None or next(objects, None) is not None or next(metrics, None) is not None:
        raise ValueError("trailing orphan raw outcomes or aggregates")
    expected_dockets = len(protocol["stressDocketProfiles"]) * len(expected_contexts(protocol)) * protocol["simulationRuns"]
    if totals["sharedDockets"] != expected_dockets or totals["designRuns"] != expected_dockets * len(designs):
        raise ValueError("incomplete raw study grid")
    return {"counts": dict(totals), "zeroDenominatorGroups": dict(empty),
            "runMetricsReconstructed": sorted(checked_metrics),
            "pairing": "all ordered case and object inputs independently rehashed and reconciled",
            "conditionalRatePolicy": "legacy zero denominators remain zero; no response is not a late or instantaneous response"}


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--output-dir", type=Path, default=ROOT / "reports")
    parser.add_argument("--check", action="store_true")
    args = parser.parse_args()
    check_study(args.output_dir, raw=True)
    quality = reconcile(args.output_dir, load_protocol())
    quality["sourceSha256"] = {"scripts/check_historical_study_raw.py": file_hash(Path(__file__))}
    quality["simulationManifestSha256"] = file_hash(args.output_dir / f"{PREFIX}-manifest.json")
    data = json_bytes(quality)
    output = args.output_dir / f"{PREFIX}-raw-audit.json"
    if args.check:
        if output.read_bytes() != data:
            raise ValueError("raw audit artifact differs from recomputation")
    else:
        output.write_bytes(data)
    print(json.dumps(quality, indent=2))


if __name__ == "__main__":
    main()
