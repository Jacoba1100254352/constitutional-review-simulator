"""Independent verification of study estimates, selected intervals and all preference rankings.

Does not import the analysis implementation or use its bootstrap compression,
summary/classification functions, score functions or tie handling.
"""

from collections import Counter, defaultdict
from itertools import combinations
import json
import math
from pathlib import Path
import random

from historical_data import CONFIG, ROOT, json_bytes, load_protocol
from historical_study import PREFIX, file_hash, read_rows


def close(actual, expected, label, tolerance=1e-12):
    if not math.isfinite(float(actual)) or not math.isclose(float(actual), expected, rel_tol=tolerance, abs_tol=tolerance):
        raise ValueError(f"independent analysis discrepancy: {label}")


def bounds(values):
    ordered = sorted(values)
    result = []
    for probability in (0.025, 0.975):
        position = probability * (len(ordered) - 1)
        i = int(position)
        result.append(ordered[i] + (position - i) * (ordered[min(i + 1, len(ordered) - 1)] - ordered[i]))
    return result


def numeric_order(values, eps=1e-12):
    return sum(value > eps for value in values), sum(value < -eps for value in values), sum(abs(value) <= eps for value in values)


def validate(directory: Path):
    protocol = load_protocol()
    manifest = json.loads((directory / f"{PREFIX}-analysis-manifest.json").read_text())
    expected_inputs = {"scripts/historical_robustness_analysis.py", "config/historical-benchmark/claim-components.csv",
                       "docs/historical-robustness-analysis-contract.md", "scripts/check_historical_study_raw.py",
                       "config/historical-benchmark/first-evaluation-lock.json",
                       "reports/constitutional-review-historical-benchmark-v1-first-evaluation.json",
                       *[f"reports/{PREFIX}{suffix}" for suffix in ("-runs.csv.gz", "-manifest.json", "-raw-audit.json")]}
    expected_tables = {"-contrasts.csv", "-component-patterns.csv", "-claim-matrix.csv", "-cost-accounting.csv",
                       "-weight-vectors.csv", "-leadership.csv", "-preference-pairs.csv", "-response-weight-effects.csv",
                       "-weight-grid-reversals.csv", "-cell-means.csv", "-conditional-denominators.csv"}
    if (set(manifest["inputSha256"]) != expected_inputs or set(manifest["outputSha256"]) != expected_tables | {".md"}
            or set(manifest["rows"]) != expected_tables or manifest["protocolId"] != protocol["protocolId"]):
        raise ValueError("incomplete or substituted analysis provenance inventory")
    for relative, expected in manifest["inputSha256"].items():
        path = directory / Path(relative).name if relative.startswith("reports/") else ROOT / relative
        if file_hash(path) != expected:
            raise ValueError("analysis input hash is stale: " + relative)
    tables = {}
    for suffix, expected in manifest["outputSha256"].items():
        path = directory / f"{PREFIX}{suffix}"
        if file_hash(path) != expected:
            raise ValueError("analysis artifact hash mismatch: " + suffix)
        if suffix.endswith(".csv"):
            tables[suffix] = list(read_rows(path))
            if len(tables[suffix]) != manifest["rows"][suffix]:
                raise ValueError("analysis artifact row count mismatch")
    context_count = 1 + sum(len(values) for values in protocol["contextOneAtATime"].values())
    cell_count = len(protocol["stressDocketProfiles"]) * context_count
    components = list(read_rows(CONFIG / "claim-components.csv"))
    family_counts = Counter(row["claim"] for row in components)
    pattern_count = family_counts["emergency"] * 2 + family_counts["screening"] * 2 + family_counts["weak-form"] * 5
    required_rows = {"-contrasts.csv": pattern_count * cell_count, "-component-patterns.csv": pattern_count,
                     "-claim-matrix.csv": len(components), "-cost-accounting.csv": cell_count,
                     "-weight-vectors.csv": protocol["weightDraws"], "-leadership.csv": cell_count * 12,
                     "-preference-pairs.csv": cell_count * 6, "-response-weight-effects.csv": cell_count * 2,
                     "-weight-grid-reversals.csv": protocol["weightDraws"] * 6,
                     "-cell-means.csv": cell_count * 8, "-conditional-denominators.csv": cell_count * 8}
    for suffix, expected in required_rows.items():
        if len(tables[suffix]) != expected:
            raise ValueError("incomplete registered analysis table: " + suffix)
    keys = {"-contrasts.csv": ("profile", "context", "contrast", "metric"),
            "-component-patterns.csv": ("contrast", "metric"), "-claim-matrix.csv": ("claim", "metric"),
            "-cost-accounting.csv": ("profile", "context"), "-weight-vectors.csv": ("weightDraw",),
            "-leadership.csv": ("profile", "context", "responseVariant", "scenario"),
            "-preference-pairs.csv": ("profile", "context", "left", "right"),
            "-response-weight-effects.csv": ("profile", "context", "left", "right"),
            "-weight-grid-reversals.csv": ("left", "right", "weightDraw"),
            "-cell-means.csv": ("profile", "context", "scenario"),
            "-conditional-denominators.csv": ("profile", "context", "scenario")}
    for suffix, fields in keys.items():
        if len({tuple(row[field] for field in fields) for row in tables[suffix]}) != len(tables[suffix]):
            raise ValueError("duplicate analysis evidence key: " + suffix)
    means_rows = tables["-cell-means.csv"]
    metric_names = [field for field in means_rows[0] if field not in {"profile", "context", "scenario"}]
    n = protocol["simulationRuns"]
    observations = defaultdict(lambda: {field: {} for field in metric_names})
    for row in read_rows(directory / f"{PREFIX}-runs.csv.gz"):
        key = row["profile"], row["context"], row["scenarioKey"]
        run = int(row["run"])
        for field in metric_names:
            if run in observations[key][field]:
                raise ValueError("duplicate source run in independent analysis")
            observations[key][field][run] = float(row[field])
    means = {}
    for row in means_rows:
        key = row["profile"], row["context"], row["scenario"]
        if key in means:
            raise ValueError("duplicate cell mean")
        means[key] = {}
        for field in metric_names:
            source = observations[key][field]
            if set(source) != set(range(n)):
                raise ValueError("independent analysis source run gap")
            expected = math.fsum(source.values()) / n
            close(row[field], expected, "equal-run " + field)
            means[key][field] = expected
    if set(observations) != set(means):
        raise ValueError("cell means omit source groups")
    # Expanded run indices, independently of the production count-compressed bootstrap.
    rng = random.Random(protocol["bootstrapSeed"])
    selected = [[rng.randrange(n) for _ in range(n)] for _ in range(protocol["bootstrapReplicates"])]
    checked_intervals = 0
    contrasts = tables["-contrasts.csv"]
    current, reasoned, council, weak = protocol["stressScenarioKeys"]
    fast, full_court, half, off = protocol["stressAblations"]
    defined_pairs = {
        "emergency-base": (reasoned, current, "emergency"), "screening-base": (council, current, "screening"),
        "weak-form-base": (weak, current, "weak-form"), "emergency-ablation": (fast, reasoned, "emergency"),
        "screening-ablation": (full_court, council, "screening"), "weak-form-half": (half, weak, "weak-form"),
        "weak-form-off": (off, weak, "weak-form"), "weak-form-half-v-current": (half, current, "weak-form"),
        "weak-form-off-v-current": (off, current, "weak-form")}
    component_keys = {(row["claim"], row["metric"]) for row in components}
    for row in contrasts:
        if (row["contrast"] not in defined_pairs or (row["left"], row["right"], row["claim"]) != defined_pairs[row["contrast"]]
                or (row["claim"], row["metric"]) not in component_keys):
            raise ValueError("analysis substituted a registered comparison or component")
        left_key = row["profile"], row["context"], row["left"]
        right_key = row["profile"], row["context"], row["right"]
        field = row["metric"]
        expected = means[left_key][field] - means[right_key][field]
        close(row["difference"], expected, "paired point " + field)
        left, right = observations[left_key][field], observations[right_key][field]
        differences = [left[index] - right[index] for index in range(n)]
        se = math.sqrt(math.fsum((value - math.fsum(differences) / n) ** 2 for value in differences) / (n - 1) / n)
        close(row["monteCarloSE"], se, "paired standard error " + field)
        if ((row["profile"] == "frozen-generator" and row["context"] == "baseline")
                or (row["profile"] == "previous-term" and row["context"] == "emergencyPressure-low" and row["kind"] == "base")):
            draws = [math.fsum(differences[index] for index in indices) / n for indices in selected]
            lower, upper = bounds(draws)
            close(row["lower"], lower, "expanded bootstrap lower " + field)
            close(row["upper"], upper, "expanded bootstrap upper " + field)
            checked_intervals += 1
    for row in tables["-component-patterns.csv"]:
        group = [r for r in contrasts if r["contrast"] == row["contrast"] and r["metric"] == row["metric"]]
        values = [float(r["difference"]) for r in group]
        if len(values) != int(row["cells"]) or len({(r["profile"], r["context"]) for r in group}) != len(group):
            raise ValueError("component coverage mismatch")
        threshold = protocol["practicalDifferenceThreshold"]
        positive = sum(value > threshold for value in values)
        negative = sum(value < -threshold for value in values)
        expected_sign = int(row["expectedSign"])
        expected = "descriptive-only" if expected_sign == 0 else (
            "stable" if ((expected_sign == 1 and positive == len(values)) or (expected_sign == -1 and negative == len(values)))
            else "sign-reversing" if positive and negative else "mixed/weak")
        if row["classification"] != expected:
            raise ValueError("component sign classification mismatch")
        for name, value in {"pointMin": min(values), "pointMax": max(values), "positiveCells": positive,
                            "negativeCells": negative, "nearZeroCells": len(values) - positive - negative,
                            "intervalsAboveZero": sum(float(r["lower"]) > 0 for r in group),
                            "intervalsBelowZero": sum(float(r["upper"]) < 0 for r in group)}.items():
            close(row[name], value, "component pattern " + name)
    base_patterns = {(row["claim"], row["metric"]): row for row in tables["-component-patterns.csv"] if row["kind"] == "base"}
    for row in tables["-claim-matrix.csv"]:
        expected = base_patterns[(row["claim"], row["metric"])]
        if any(row[field] != value for field, value in expected.items()):
            raise ValueError("claim matrix differs from verified component evidence")
        if (row["metric"] == "averageTimeToReview" and row["evidenceStatus"] != "unsupported-design-duration-measure"):
            raise ValueError("unsupported duration measure was promoted to a supported claim")
    # Independently regenerate weights, then reconstruct every score and leadership competition.
    weight_rows = tables["-weight-vectors.csv"]
    metrics = protocol["weightMetricsHigher"] + protocol["weightMetricsLower"]
    rng = random.Random(protocol["weightSeed"])
    weights = []
    for draw, row in enumerate(weight_rows):
        if int(row["weightDraw"]) != draw:
            raise ValueError("preference identity/order mismatch")
        raw = []
        for _ in metrics:
            u = rng.random()
            while u == 0:
                u = rng.random()
            raw.append(-math.log(u))
        vector = [float(row[metric]) for metric in metrics]
        for value, expected in zip(vector, (value / math.fsum(raw) for value in raw)):
            close(value, expected, "registered Dirichlet weight", tolerance=1e-15)
        close(math.fsum(vector), 1, "preference sum")
        weights.append(vector)
    if len(weights) != protocol["weightDraws"]:
        raise ValueError("wrong preference sample size")
    scores = {}
    lower = set(protocol["weightMetricsLower"])
    for key, values in means.items():
        scores[key] = [math.fsum(weight * (1 - values[metric] if metric in lower else values[metric])
                                for metric, weight in zip(metrics, vector)) for vector in weights]
    bases = protocol["stressScenarioKeys"]
    half, off = protocol["stressAblations"][2:]
    variants = {"full-response": bases[3], "half-response": half, "no-response": off}
    cells = list(dict.fromkeys(key[:2] for key in means))
    expected_pairs = set(combinations(bases, 2))
    if ({(row["left"], row["right"]) for row in tables["-preference-pairs.csv"]} != expected_pairs
            or {(row["left"], row["right"]) for row in tables["-weight-grid-reversals.csv"]} != expected_pairs
            or {(row["left"], row["right"]) for row in tables["-response-weight-effects.csv"]} != {(half, bases[3]), (off, bases[3])}):
        raise ValueError("substituted normative comparison set")
    expected_leaders = {}
    for cell in cells:
        for variant, weak in variants.items():
            designs = bases[:3] + [weak]
            total = Counter()
            for draw in range(len(weights)):
                best = max(scores[(*cell, design)][draw] for design in designs)
                tied = [design for design in designs if best - scores[(*cell, design)][draw] <= 1e-12]
                for design in tied:
                    total[design] += 1 / len(tied)
            for design in designs:
                expected_leaders[(*cell, variant, design)] = total[design]
    actual_leaders = set()
    for row in tables["-leadership.csv"]:
        key = row["profile"], row["context"], row["responseVariant"], row["scenario"]
        if key in actual_leaders:
            raise ValueError("duplicate leadership row")
        actual_leaders.add(key)
        close(row["leadershipCredit"], expected_leaders[key], "leadership credit")
        close(row["leadershipShare"], expected_leaders[key] / len(weights), "leadership share")
    if actual_leaders != set(expected_leaders):
        raise ValueError("incomplete leadership competitions")
    for row in tables["-preference-pairs.csv"] + tables["-response-weight-effects.csv"]:
        cell = row["profile"], row["context"]
        differences = [a - b for a, b in zip(scores[(*cell, row["left"])], scores[(*cell, row["right"])])]
        positive, negative, tied = numeric_order(differences)
        for name, value in {"positiveDraws": positive, "negativeDraws": negative, "tiedDraws": tied,
                            "differenceMin": min(differences), "differenceMax": max(differences)}.items():
            close(row[name], value, "preference comparison " + name)
        if row["reversesAcrossWeights"] != str(bool(positive and negative)):
            raise ValueError("preference reversal mismatch")
        if "meanDifference" in row:
            lo, hi = bounds(differences)
            close(row["meanDifference"], math.fsum(differences) / len(weights), "response preference mean")
            close(row["preferenceP025"], lo, "response preference percentile")
            close(row["preferenceP975"], hi, "response preference percentile")
    for row in tables["-weight-grid-reversals.csv"]:
        draw = int(row["weightDraw"])
        differences = [scores[(*cell, row["left"])][draw] - scores[(*cell, row["right"])][draw] for cell in cells]
        positive, negative, tied = numeric_order(differences)
        for name, value in {"positiveCells": positive, "negativeCells": negative, "tiedCells": tied,
                            "differenceMin": min(differences), "differenceMax": max(differences)}.items():
            close(row[name], value, "fixed-weight grid ordering " + name)
        if row["reversesAcrossGrid"] != str(bool(positive and negative)):
            raise ValueError("fixed-weight context reversal mismatch")
    for row in tables["-cost-accounting.csv"]:
        cell = row["profile"], row["context"]
        direct = means[(*cell, bases[2])]["directCourtCost"] - means[(*cell, bases[0])]["directCourtCost"]
        full = means[(*cell, bases[2])]["totalInstitutionalCost"] - means[(*cell, bases[0])]["totalInstitutionalCost"]
        close(row["directOnlyDifference"], direct, "direct accounting")
        close(row["fullAccountingDifference"], full, "full accounting")
        close(row["fullMinusDirectContrastDifference"], full - direct, "accounting-view contrast")
        threshold = protocol["practicalDifferenceThreshold"]
        sign_change = (direct > threshold and full < -threshold) or (direct < -threshold and full > threshold)
        if row["practicalSignChange"] != str(sign_change):
            raise ValueError("accounting practical sign change mismatch")
    for row in tables["-conditional-denominators.csv"]:
        key = row["profile"], row["context"], row["scenario"]
        source = observations[key]
        emergency = source["emergencyOrders"]
        responses = {i: round(source["legislativeResponseRate"][i] * protocol["simulationCasesPerRun"]) for i in range(n)}
        reason_count = sum(round(source["emergencyReasonGivingRate"][i] * emergency[i]) for i in range(n))
        follow_up_count = sum(round(source["meritsFollowUpRate"][i] * emergency[i]) for i in range(n))
        timely_count = sum(round(source["timelyLegislativeResponseRate"][i] * responses[i]) for i in range(n))
        for name, value in {"runs": n, "emergencyOrders": sum(emergency.values()), "ordersWithReasons": reason_count,
                            "meritsFollowUps": follow_up_count,
                            "legislativeResponses": sum(responses.values()), "timelyResponses": timely_count,
                            "runsWithoutEmergencyOrders": sum(value == 0 for value in emergency.values()),
                            "runsWithoutLegislativeResponses": sum(value == 0 for value in responses.values())}.items():
            close(row[name], value, "conditional denominator " + name)
        for name, numerator, denominator in (("pooledReasonsPerOrder", reason_count, sum(emergency.values())),
                                             ("pooledFollowUpPerOrder", follow_up_count, sum(emergency.values())),
                                             ("pooledTimelyPerResponse", timely_count, sum(responses.values()))):
            if denominator:
                close(row[name], numerator / denominator, "pooled diagnostic " + name)
            elif row[name] != "":
                raise ValueError("empty pooled denominator was presented as an observed rate")
    report = " ".join((directory / f"{PREFIX}.md").read_text().split())
    for caveat in ("not identified effects", "does not establish less reason-giving per emergency order",
                   "not a monetary omitted-cost amount", "not Monte Carlo confidence intervals",
                   "not the overall publication goal"):
        if caveat not in report:
            raise ValueError("required interpretation boundary missing: " + caveat)
    return {"assessment": "share-with-caveats-model-results-not-reform-recommendations", "cells": len(cells),
            "pairedPointEstimatesAndSEsVerified": len(contrasts), "expandedIndexBootstrapIntervalsVerified": checked_intervals,
            "cellMeanRowsVerified": len(means), "leadershipRowsVerified": len(expected_leaders),
            "dirichletVectorsRegenerated": len(weights), "preferencePairRowsVerified": len(tables["-preference-pairs.csv"]),
            "responsePreferenceRowsVerified": len(tables["-response-weight-effects.csv"]),
            "fixedWeightGridRowsVerified": len(tables["-weight-grid-reversals.csv"]),
            "conditionalDenominatorRowsVerified": len(tables["-conditional-denominators.csv"]),
            "inputSha256": {"analysisManifest": file_hash(directory / f"{PREFIX}-analysis-manifest.json"),
                            "validator": file_hash(Path(__file__))}}


def main():
    import argparse
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--output-dir", type=Path, default=ROOT / "reports")
    parser.add_argument("--check", action="store_true")
    args = parser.parse_args()
    before = file_hash(Path(__file__))
    result = validate(args.output_dir)
    if before != file_hash(Path(__file__)):
        raise ValueError("validator changed during execution")
    markdown = f"""# Analysis validation report

## Overall assessment: Share with caveats

The calculations support a bounded description of this synthetic model and
fixed grid, not empirical identification of reforms or a recommended court.

## Methodology and calculation checks

- Verified all {result['pairedPointEstimatesAndSEsVerified']} paired point estimates and Monte Carlo standard errors directly from run observations.
- Recomputed {result['expandedIndexBootstrapIntervalsVerified']} selected intervals using expanded sampled run indices, independently of the production count-compressed bootstrap.
- Checked every component classification, claim-matrix mapping and required table/key inventory.
- Regenerated all {result['dirichletVectorsRegenerated']} registered preference vectors and all {result['leadershipRowsVerified']} leadership rows, including ties and response replacement.
- Verified all {result['fixedWeightGridRowsVerified']} fixed-weight cross-grid comparisons and {result['conditionalDenominatorRowsVerified']} conditional-denominator rows.

The production analysis also has a separate full deterministic re-execution
check. This validator does not claim independent re-estimation of all bootstrap
intervals; its independent interval coverage is explicitly limited above.

## Important issues and required caveats

1. High interpretive risk: no-order runs are coded zero in the registered mean of conditional run rates. Low-emergency reason-giving reversals must not be read as fewer reasons per actual order. Pooled event counts are explanatory diagnostics only.
2. High interpretive risk: average review time is a shared case input, not a design-specific duration. It cannot support the registered delay claim.
3. High interpretive risk: no legislative replies is not an observed late or instantaneous reply. Conditional timeliness comparisons have different eligible populations.
4. Structural cost, credibility and veto terms are partly imposed by model rules. Their movement and preference leadership are not independent empirical validation.
5. Bootstrap intervals describe conditional Monte Carlo error. Grid ranges and preference sensitivity are separate and do not assign probabilities to real institutions or political environments.

## Presentation and incomplete handoff checks

The Markdown tables, explicit caveats and linked CSV evidence were inspected.
No new graphical or PDF output is certified by this calculation check.
Manuscript/supplement integration, full native CI, rendered publication checks
and extracted anonymous replication remain separate required work.

## Reproduce

Run `make historical-analysis-check historical-analysis-validation-check`.
The companion JSON records exact counts and source/analysis hashes.
""".encode()
    for suffix, data in (("-analysis-validation.json", json_bytes(result)), ("-analysis-validation.md", markdown)):
        path = args.output_dir / f"{PREFIX}{suffix}"
        if args.check:
            if path.read_bytes() != data:
                raise ValueError("analysis validation record differs from recomputation")
        else:
            path.write_bytes(data)
    print(json.dumps(result, indent=2))


if __name__ == "__main__":
    main()
