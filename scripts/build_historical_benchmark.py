"""Create/check the frozen empirical evaluation and its inspectable audit reports.

Report generation cannot fit to the new release or replace an existing first result.
Use --fetch-sources to reacquire hash-pinned originals without a new acquisition.
"""

from __future__ import annotations

import argparse
from collections import Counter
import csv
from datetime import datetime, timezone
import io
import json
import math
from pathlib import Path
import random
from urllib.request import urlopen

from audit_scdb_doctrine_denominators import TARGET_PREDICATES
import historical_data as data
import historical_scoring as scoring


PREFIX = data.ROOT / "reports/constitutional-review-historical-benchmark-v1"
FIRST = data.ROOT / "reports/constitutional-review-historical-benchmark-v1-first-evaluation.json"
FIRST_LOCK = data.CONFIG / "first-evaluation-lock.json"


def artifact(suffix: str) -> Path:
    return Path(f"{PREFIX}{suffix}")


def csv_bytes(rows: list[dict], fields: list[str] | None = None) -> bytes:
    if fields is None and not rows:
        raise ValueError("empty report needs an explicit schema")
    buffer = io.StringIO(newline="")
    writer = csv.DictWriter(buffer, fieldnames=fields or list(rows[0]), lineterminator="\n")
    writer.writeheader()
    writer.writerows(rows)
    return buffer.getvalue().encode()


def generated(path: Path, content: bytes, check: bool) -> None:
    if check:
        if not path.exists() or path.read_bytes() != content:
            raise ValueError(f"historical report is stale: {path.name}")
    else:
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_bytes(content)


def verify_originals(protocol: dict, registry: dict, fetch: bool = False) -> dict:
    originals = {}
    for release in (protocol["developmentRelease"], protocol["testRelease"]):
        entry = registry[release]
        path = data.DATA / "source-cache" / f"{release}_caseCentered_Citation.csv.zip"
        if not path.exists():
            if not fetch:
                raise ValueError("original source cache missing; run historical-sources or use --check-scores")
            with urlopen(entry["zipUrl"], timeout=45) as response:
                content = response.read()
            if data.sha256(content) != entry["zipSha256"]:
                raise ValueError("reacquired original does not match pinned source hash")
            data.immutable_write(path, content)
        content = path.read_bytes()
        records, metadata, raw_rows = data.parse_release(content, release, protocol)
        if any(entry[key] != value for key, value in metadata.items()):
            raise ValueError("original source metadata differs from registry")
        if data.records_bytes(records) != data.records_path(release).read_bytes():
            raise ValueError("derivative does not reconstruct from original source")
        originals[release] = raw_rows
    return originals


def first_evaluation(protocol: dict, forecast: dict, new_records: list[data.DocketRecord], registry: dict,
                     check: bool = False) -> dict:
    selected = [record for record in new_records if record.term == protocol["newDataTestTerm"]]
    previous_ids = {record.caseId for record in data.load_records(protocol["developmentRelease"], protocol)}
    if previous_ids.intersection(record.caseId for record in selected):
        raise ValueError("new-term IDs appeared in the old release; exposure amendment required before evaluation")
    result = scoring.new_term_result(selected, forecast["forecasts"], protocol)
    result["provenance"] = {
        "protocolSha256": data.sha256(data.PROTOCOL_FILE.read_bytes()),
        "forecastSha256": data.sha256(data.FORECAST_FILE.read_bytes()),
        "testRowsSha256": data.sha256(data.records_bytes(selected)),
        "testSource": registry[protocol["testRelease"]],
        "developmentSource": registry[protocol["developmentRelease"]],
        "evaluationCodeHashes": {f"scripts/{name}": data.sha256((data.ROOT / "scripts" / name).read_bytes())
                                  for name in ("historical_data.py", "historical_scoring.py")},
    }
    content = data.json_bytes(result)
    if check and not FIRST.exists():
        raise ValueError("missing first evaluation; checking cannot create it")
    data.immutable_write(FIRST, content)
    if FIRST_LOCK.exists():
        lock = json.loads(FIRST_LOCK.read_text())
        data.check_hashes(lock["sha256"])
        if lock["protocolId"] != protocol["protocolId"]:
            raise ValueError("first evaluation protocol identity mismatch")
    elif check:
        raise ValueError("first-evaluation lock missing")
    else:
        data.immutable_write(FIRST_LOCK, data.json_bytes({
            "protocolId": protocol["protocolId"], "firstEvaluatedAtUtc": datetime.now(timezone.utc).isoformat(),
            "sha256": {str(FIRST.relative_to(data.ROOT)): data.sha256(content)},
            "policy": "Do not overwrite the first result. Append any correction and retain the original."
        }))
    return result


def quality_rows(records: list[data.DocketRecord], protocol: dict) -> list[dict]:
    output = []
    for term in sorted({row.term for row in records}):
        period = [row for row in records if row.term == term]
        counts = scoring.category_counts(period, protocol["categories"])
        if sum(counts) != len(period):
            raise ValueError("partition denominator does not reconcile")
        legacy = Counter()
        overlap = 0
        for record in period:
            source = {"issue": str(record.issue) if record.issue is not None else "",
                      "issueArea": str(record.issueArea) if record.issueArea is not None else ""}
            selected = [key for key, (_, predicate) in TARGET_PREDICATES.items() if predicate(source)]
            legacy.update(selected)
            overlap += len(selected) > 1
        output.append({"release": period[0].sourceRelease, "term": term, "n": len(period),
                       "missingIssue": sum(row.issue is None for row in period),
                       "missingIssueArea": sum(row.issueArea is None for row in period),
                       "missingDate": sum(not row.dateDecision for row in period),
                       "residualOther": sum(row.mappingStatus == "residual-area" for row in period),
                       "unrecognizedArea": sum(row.mappingStatus == "unrecognized-area" for row in period),
                       "legacyOverlapCases": overlap,
                       **dict(zip(protocol["categories"], counts)),
                       **{f"legacy.{key}": legacy[key] for key in TARGET_PREDICATES}})
    return output


def revision_rows(old: list[data.DocketRecord], new: list[data.DocketRecord], originals: dict,
                  protocol: dict) -> tuple[list[dict], dict]:
    cutoff = protocol["trainingLastTerm"]
    old_by = {row.caseId: row for row in old}
    new_by = {row.caseId: row for row in new if row.term <= cutoff}
    old_raw, new_raw = originals[protocol["developmentRelease"]], originals[protocol["testRelease"]]
    output = []
    transitions = Counter()
    changed_field_counts = Counter()
    matched_field_counts = Counter()
    for case_id in sorted(set(old_by) | set(new_by)):
        before, after = old_by.get(case_id), new_by.get(case_id)
        if before and after and before.sourceRowSha256 == after.sourceRowSha256:
            continue
        status = "changed" if before and after else "added-historical" if after else "removed-historical"
        before_raw, after_raw = old_raw.get(case_id, {}), new_raw.get(case_id, {})
        fields = sorted(key for key in set(before_raw) | set(after_raw) if before_raw.get(key) != after_raw.get(key))
        changed_field_counts.update(fields)
        if before and after:
            matched_field_counts.update(fields)
        transition = f"{before.category if before else 'ABSENT'}->{after.category if after else 'ABSENT'}"
        transitions[transition] += 1
        output.append({"caseId": case_id, "status": status, "changedFields": "|".join(fields),
                       "oldTerm": before.term if before else "", "newTerm": after.term if after else "",
                       "oldDate": before.dateDecision if before else "", "newDate": after.dateDecision if after else "",
                       "oldIssue": before.issue if before else "", "newIssue": after.issue if after else "",
                       "oldIssueArea": before.issueArea if before else "", "newIssueArea": after.issueArea if after else "",
                       "oldCategory": before.category if before else "", "newCategory": after.category if after else "",
                       "oldRowSha256": before.sourceRowSha256 if before else "",
                       "newRowSha256": after.sourceRowSha256 if after else ""})
    summary = {"historicalCutoffTerm": cutoff, "oldHistoricalRows": len(old_by), "newHistoricalRows": len(new_by),
               "unchangedRows": len(set(old_by) & set(new_by)) - sum(row["status"] == "changed" for row in output),
               "statusCounts": dict(sorted(Counter(row["status"] for row in output).items())),
               "categoryTransitions": dict(sorted(transitions.items())),
               "changedFieldCounts": dict(sorted(changed_field_counts.items())),
               "matchedRowChangedFieldCounts": dict(sorted(matched_field_counts.items())),
               "fieldCountNote": "changedFieldCounts includes additions/removals; matchedRowChangedFieldCounts excludes them",
               "newTermRows": sum(row.term == protocol["newDataTestTerm"] for row in new),
               "headersEqual": list(next(iter(old_raw.values()))) == list(next(iter(new_raw.values()))),
               "sourceFieldCount": len(next(iter(old_raw.values()))),
               "trainingTreatment": "original old-release records retained; revisions never enter locked fitting"}
    return output, summary


def retrospective_scores(records: list[data.DocketRecord], protocol: dict) -> list[dict]:
    output = []
    for role, bounds in (("development-retrospective", protocol["developmentTerms"]),
                         ("retrospective-exposed", protocol["retrospectiveTerms"])):
        for term in range(bounds[0], bounds[1] + 1):
            target = [record for record in records if record.term == term]
            counts = scoring.category_counts(target, protocol["categories"])
            for forecast in data.fit_models(records, term, protocol):
                output.append({"role": role, "term": term, "n": len(target), "model": forecast["model"],
                               **scoring.scores(forecast["probabilities"], counts),
                               "trainingN": forecast["trainingN"], "trainingMaxTerm": forecast["trainingMaxTerm"],
                               "trainingRowsSha256": forecast["trainingRowsSha256"],
                               "frozenGeneratorExposure": "all pre-2025 terms exposed through aggregate calibration"})
    return output


def retrospective_summary(rows: list[dict], protocol: dict) -> list[dict]:
    output = []
    for role in sorted({row["role"] for row in rows}):
        group = [row for row in rows if row["role"] == role]
        terms = sorted({row["term"] for row in group})
        if len(terms) < 2:
            raise ValueError("retrospective uncertainty needs at least two target-term clusters")
        indexed = {(row["term"], row["model"]): row for row in group}
        rng = random.Random(protocol["bootstrapSeed"])
        # All comparisons in this role use the same sampled term clusters.
        samples = [rng.choices(terms, k=len(terms)) for _ in range(protocol["bootstrapReplicates"])]
        for model in protocol["models"]:
            for metric in (protocol["primaryScore"], *protocol["secondaryScores"]):
                values = [indexed[t, model][metric] for t in terms]
                total_n = sum(indexed[t, model]["n"] for t in terms)
                mean = math.fsum(values) / len(values)
                difference = {t: indexed[t, "recency-weighted-15y"][metric] - indexed[t, model][metric] for t in terms}
                draws = [math.fsum(difference[t] for t in selected) / len(selected) for selected in samples]
                output.append({"role": role, "model": model, "metric": metric, "terms": len(terms), "n": total_n,
                               "equalTermMean": mean,
                               "caseWeightedMean": math.fsum(indexed[t, model][metric] * indexed[t, model]["n"] for t in terms) / total_n,
                               "empiricalMinusModel": math.fsum(difference.values()) / len(terms),
                               **scoring.interval(draws), "method": "paired-target-term-cluster-bootstrap",
                               "replicates": protocol["bootstrapReplicates"]})
    return output


def report_markdown(first: dict, revisions: dict, quality: list[dict], history: list[dict], protocol: dict) -> bytes:
    primary = next(row for row in first["pairedDifferences"] if row["metric"] == protocol["primaryScore"]
                   and row["comparison"] == "recency-weighted-15y minus frozen-generator")
    conclusion = ("a conditional improvement" if primary["upper"] < 0 else
                  "a conditional deterioration" if primary["lower"] > 0 else "no clear conditional advantage")
    lines = ["# Historical Benchmark v1: empirical docket evaluation", "",
             f"The frozen 2025-term test contains **{first['testN']} citation-centered disputes**. The training-only",
             f"empirical profile shows **{conclusion}** relative to the fixed generator on the primary",
             f"Brier score: difference {primary['difference']:.6f}, paired 95% interval",
             f"[{primary['lower']:.6f}, {primary['upper']:.6f}]. Lower scores are better.", "",
             "These are docket-composition results, not legal-outcome predictions or empirical proof that",
             "institutional reforms work. The one-term interval is conditional case-resampling uncertainty;",
             "it does not establish across-term forecast reliability or account fully for related disputes.", "",
             "## Locked new-term comparison", "",
             "| Forecast | Brier | Log loss | Total variation |", "| --- | ---: | ---: | ---: |"]
    for row in first["modelScores"]:
        lines.append(f"| {row['model']} | {row['multiclass-brier']:.6f} | {row['log-loss']:.6f} | {row['total-variation']:.6f} |")
    lines += ["", "| Category | Cases | Share |", "| --- | ---: | ---: |"]
    lines += [f"| {row['category']} | {row['count']} | {row['share']:.4f} |" for row in first["categories"]]
    lines += ["", "## Source quality and historical revisions", "",
              f"The original development release has {revisions['oldHistoricalRows']} records through 2024.",
              f"The newer release has {revisions['newHistoricalRows']} records through 2024 and {revisions['newTermRows']} new-term records.",
              f"Historical revision status counts: `{json.dumps(revisions['statusCounts'], sort_keys=True)}`.",
              "The full-row audit compares every original source field as well as the minimal derived variables.",
              "Revisions do not replace the old training records. All source ZIPs, CSV members, derivatives,",
              "forecasts, and the first evaluation are identified by hashes.", ""]
    for release in (protocol["developmentRelease"], protocol["testRelease"]):
        group = [row for row in quality if row["release"] == release]
        lines.append(f"- {release}: {sum(row['n'] for row in group)} rows; "
                     f"{sum(row['missingIssue'] for row in group)} missing issue codes; "
                     f"{sum(row['missingIssueArea'] for row in group)} missing issue-area codes; "
                     f"{sum(row['missingDate'] for row in group)} missing dates; "
                     f"{sum(row['unrecognizedArea'] for row in group)} unrecognized areas; "
                     f"{sum(row['legacyOverlapCases'] for row in group)} cases meeting multiple legacy predicates.")
    lines += ["", "Missing and residual codes remain visible within OTHER, not dropped from the denominator.",
              "The new partition resolves legacy overlap without altering any existing benchmark definition.", "",
              "## Retrospective checks", "",
              "Earlier target terms already contributed to the original generator's aggregate calibration.",
              "They are retrospective diagnostics, never untouched holdouts. Statistical comparators use",
              "only earlier terms; the fixed generator is an exposed comparator for all these periods.", "",
              "| Role | Model | Equal-term Brier | Case-weighted Brier |", "| --- | --- | ---: | ---: |"]
    for row in history:
        if row["metric"] == protocol["primaryScore"]:
            lines.append(f"| {row['role']} | {row['model']} | {row['equalTermMean']:.6f} | {row['caseWeightedMean']:.6f} |")
    lines += ["", "Separate files retain per-term scores, paired target-term intervals, all category counts,",
              "missingness, legacy-predicate counts, full-field revision details, and training-term uncertainty.",
              "The fixed hyperparameters were not selected using the 2025 results. The first evaluation is",
              "immutable; subsequent exploratory models must not replace it.", "",
              "## Remaining work and claim boundary", "",
              "This report completes the empirical docket test, not Historical Benchmark and Robustness v1",
              "as a whole. The [paired institutional analysis](constitutional-review-historical-robustness-v1.md)",
              "reports the mechanism ablations, normative-weight sensitivity and claim-to-evidence matrix",
              "separately. Manuscript integration and final publication/replication checks remain required",
              "before the overall milestone is complete. No whole-court or causal claim follows from these scores.", ""]
    return "\n".join(lines).encode()


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true")
    parser.add_argument("--check-scores", action="store_true", help="offline check of the locked first evaluation only")
    parser.add_argument("--fetch-sources", action="store_true", help="verify/reacquire existing pinned originals, no new freeze")
    args = parser.parse_args()
    protocol = data.load_protocol()
    forecast = data.check_forecast_lock(protocol)
    registry = json.loads(data.REGISTRY_FILE.read_text())
    old = data.load_records(protocol["developmentRelease"], protocol)
    new = data.load_records(protocol["testRelease"], protocol)
    first = first_evaluation(protocol, forecast, new, registry, args.check or args.check_scores or args.fetch_sources)
    if args.check_scores:
        print("Locked first evaluation reproduced from source-hashed derivatives; no raw-source re-audit requested.")
        return
    originals = verify_originals(protocol, registry, args.fetch_sources)
    if args.fetch_sources:
        print("Both original source archives and their complete derived records match the pinned hashes.")
        return
    quality = quality_rows(old, protocol) + quality_rows(new, protocol)
    revisions, revision_summary = revision_rows(old, new, originals, protocol)
    retrospective = retrospective_scores(old, protocol)
    summary = retrospective_summary(retrospective, protocol)
    training = scoring.training_composition_intervals(old, protocol["newDataTestTerm"], protocol)
    revision_fields = ["caseId", "status", "changedFields", "oldTerm", "newTerm", "oldDate", "newDate", "oldIssue", "newIssue",
                       "oldIssueArea", "newIssueArea", "oldCategory", "newCategory", "oldRowSha256", "newRowSha256"]
    artifacts = {
        "-data-quality.csv": csv_bytes(quality), "-source-revisions.csv": csv_bytes(revisions, revision_fields),
        "-revision-summary.json": data.json_bytes(revision_summary), "-retrospective.csv": csv_bytes(retrospective),
        "-retrospective-summary.csv": csv_bytes(summary), "-training-uncertainty.csv": csv_bytes(training),
        "-test-differences.csv": csv_bytes(first["pairedDifferences"]),
        ".md": report_markdown(first, revision_summary, quality, summary, protocol),
    }
    for suffix, content in artifacts.items():
        generated(artifact(suffix), content, args.check)
    print(f"{'Verified' if args.check else 'Generated'} {len(artifacts)} historical reports; first evaluation retained.")
    print(json.dumps(first["modelScores"], indent=2))


if __name__ == "__main__":
    main()
