"""Registered paired-run and normative sensitivity analysis, using only the standard library."""

from __future__ import annotations

import argparse
from collections import Counter
from concurrent.futures import ProcessPoolExecutor
from dataclasses import dataclass
from itertools import combinations
import hashlib
import json
import math
from pathlib import Path
import random

from historical_data import CONFIG, ROOT, check_hashes, json_bytes, load_protocol
from historical_study import PREFIX, check_study, csv_bytes, expected_contexts, file_hash, read_rows


COMPONENT_FILE = CONFIG / "claim-components.csv"
CONTRACT_FILE = ROOT / "docs/historical-robustness-analysis-contract.md"
TIE_TOLERANCE = 1e-12
REGISTERED = {
    "emergency": ("emergencyReasonGivingRate", "meritsFollowUpRate", "averageTimeToReview", "totalInstitutionalCost", "shadowDocketAbuse"),
    "screening": ("directCourtCost", "upstreamScreeningCost", "capacityStrainCost", "totalInstitutionalCost", "intakeAcceptanceRate", "councilScreenRate"),
    "weak-form": ("legislativeResponseRate", "legislativeResponseCredibility", "timelyLegislativeResponseRate", "rightsProtection",
                  "complianceRate", "democraticResponsiveness", "vetoRelocationRisk", "totalInstitutionalCost"),
}
ADDITIONAL = {"emergency": "institutionalDelayCost", "screening": "administrativeLoad", "weak-form": "averageLegislativeResponseDelay"}


@dataclass(frozen=True)
class BootstrapPlan:
    n: int
    blocks: tuple[tuple[tuple[int, int], ...], ...]

    def __post_init__(self):
        if self.n < 2 or len(self.blocks) < 2:
            raise ValueError("run uncertainty requires multiple runs and replicates")
        for block in self.blocks:
            if (sum(count for _, count in block) != self.n or len({index for index, _ in block}) != len(block)
                    or any(not 0 <= index < self.n or count < 1 for index, count in block)):
                raise ValueError("invalid paired run resampling block")


def bootstrap_plan(n: int, replicates: int, seed: int) -> BootstrapPlan:
    if n < 2 or replicates < 2:
        raise ValueError("run uncertainty requires multiple runs and replicates")
    rng = random.Random(seed)
    blocks = tuple(tuple(sorted(Counter(rng.randrange(n) for _ in range(n)).items())) for _ in range(replicates))
    return BootstrapPlan(n, blocks)


def percentile(values, p: float) -> float:
    if not values or not 0 <= p <= 1 or any(not math.isfinite(x) for x in values):
        raise ValueError("invalid percentile input")
    ordered = sorted(values)
    position = (len(ordered) - 1) * p
    low, high = math.floor(position), math.ceil(position)
    fraction = position - low
    return ordered[low] * (1 - fraction) + ordered[high] * fraction


def difference_summary(differences, plan: BootstrapPlan) -> dict:
    if len(differences) != plan.n or any(not math.isfinite(x) for x in differences):
        raise ValueError("invalid paired contrast observations")
    estimate = math.fsum(differences) / plan.n
    if min(differences) == max(differences):
        lower = upper = differences[0]
        standard_error = 0.0
    else:
        draws = [math.fsum(differences[index] * count for index, count in block) / plan.n for block in plan.blocks]
        lower, upper = percentile(draws, 0.025), percentile(draws, 0.975)
        standard_error = math.sqrt(math.fsum((x - estimate) ** 2 for x in differences) / (plan.n - 1) / plan.n)
    return {"difference": estimate, "lower": lower, "upper": upper, "monteCarloSE": standard_error,
            "runs": plan.n, "bootstrapReplicates": len(plan.blocks)}


def paired_summary(left, right, plan: BootstrapPlan) -> dict:
    if len(left) != len(right):
        raise ValueError("unpaired scenario observations")
    return difference_summary([a - b for a, b in zip(left, right)], plan)


def load_components() -> list[dict]:
    rows = list(read_rows(COMPONENT_FILE))
    seen = set()
    for row in rows:
        key = row["claim"], row["metric"]
        if key in seen or row["claim"] not in REGISTERED or row["expectedSign"] not in {"-1", "0", "1"}:
            raise ValueError("invalid or duplicate claim binding")
        seen.add(key)
        row["expectedSign"] = int(row["expectedSign"])
    expected = {(claim, metric) for claim, metrics in REGISTERED.items() for metric in (*metrics, ADDITIONAL[claim])}
    if seen != expected:
        raise ValueError("claim bindings omit or substitute registered metrics")
    return rows


def contrast_definitions(protocol: dict) -> list[dict]:
    current, reasoned, council, weak = protocol["stressScenarioKeys"]
    fast, full_court, half, off = protocol["stressAblations"]
    entries = (
        ("emergency-base", "emergency", reasoned, current, "base"),
        ("screening-base", "screening", council, current, "base"),
        ("weak-form-base", "weak-form", weak, current, "base"),
        ("emergency-ablation", "emergency", fast, reasoned, "ablation"),
        ("screening-ablation", "screening", full_court, council, "ablation"),
        ("weak-form-half", "weak-form", half, weak, "ablation"),
        ("weak-form-off", "weak-form", off, weak, "ablation"),
        ("weak-form-half-v-current", "weak-form", half, current, "persistence"),
        ("weak-form-off-v-current", "weak-form", off, current, "persistence"),
    )
    return [dict(contrast=key, claim=claim, left=left, right=right, kind=kind) for key, claim, left, right, kind in entries]


def metric_fields(protocol, components):
    return sorted({row["metric"] for row in components} | set(protocol["weightMetricsHigher"])
                  | set(protocol["weightMetricsLower"]) | {"emergencyOrders"})


def load_cells(directory: Path, protocol: dict, components: list[dict]) -> dict:
    fields = metric_fields(protocol, components)
    keys = [(profile, context) for profile in protocol["stressDocketProfiles"] for context in expected_contexts(protocol)]
    scenarios = protocol["stressScenarioKeys"] + protocol["stressAblations"]
    n = protocol["simulationRuns"]
    cells = {key: {scenario: {field: [None] * n for field in fields} for scenario in scenarios} for key in keys}
    for row in read_rows(directory / f"{PREFIX}-runs.csv.gz"):
        key = row["profile"], row["context"]
        scenario, run = row["scenarioKey"], int(row["run"])
        if key not in cells or scenario not in scenarios or not 0 <= run < n:
            raise ValueError("unregistered analysis cell/run")
        vectors = cells[key][scenario]
        if vectors[fields[0]][run] is not None or int(row["totalCases"]) != protocol["simulationCasesPerRun"]:
            raise ValueError("duplicate run or changed denominator in analysis")
        for field in fields:
            value = float(row[field])
            if not math.isfinite(value):
                raise ValueError("nonfinite analysis observation")
            vectors[field][run] = value
    if any(value is None for cell in cells.values() for scenario in cell.values() for vector in scenario.values() for value in vector):
        raise ValueError("incomplete analysis grid")
    return cells


def cell_analysis(key, cell, protocol, components, plan):
    contrasts = []
    for definition in contrast_definitions(protocol):
        for component in components:
            if component["claim"] != definition["claim"]:
                continue
            metric = component["metric"]
            contrasts.append({"profile": key[0], "context": key[1], **definition, "metric": metric,
                              "componentRole": component["role"],
                              **paired_summary(cell[definition["left"]][metric], cell[definition["right"]][metric], plan)})
    council, current = protocol["stressScenarioKeys"][2], protocol["stressScenarioKeys"][0]
    direct = [a - b for a, b in zip(cell[council]["directCourtCost"], cell[current]["directCourtCost"])]
    full = [a - b for a, b in zip(cell[council]["totalInstitutionalCost"], cell[current]["totalInstitutionalCost"])]
    gap = [a - b for a, b in zip(full, direct)]
    accounting = {"profile": key[0], "context": key[1]}
    for label, values in (("directOnly", direct), ("fullAccounting", full), ("fullMinusDirectContrast", gap)):
        accounting.update({label + name[0].upper() + name[1:]: value for name, value in difference_summary(values, plan).items()})
    threshold = protocol["practicalDifferenceThreshold"]
    a, b = accounting["directOnlyDifference"], accounting["fullAccountingDifference"]
    accounting["practicalSignChange"] = (a > threshold and b < -threshold) or (a < -threshold and b > threshold)
    return contrasts, accounting


_WORKER_PLAN = None


def initialize_worker(plan):
    global _WORKER_PLAN
    _WORKER_PLAN = plan


def worker_cell(arguments):
    return cell_analysis(*arguments, _WORKER_PLAN)


def pattern(values, lower, upper, expected_sign, threshold):
    if not values or len(values) != len(lower) or len(values) != len(upper):
        raise ValueError("incomplete component pattern")
    positive = sum(value > threshold for value in values)
    negative = sum(value < -threshold for value in values)
    if expected_sign == 0:
        classification = "descriptive-only"
    elif (expected_sign == 1 and positive == len(values)) or (expected_sign == -1 and negative == len(values)):
        classification = "stable"
    elif positive and negative:
        classification = "sign-reversing"
    else:
        classification = "mixed/weak"
    return {"cells": len(values), "pointMin": min(values), "pointMax": max(values),
            "positiveCells": positive, "negativeCells": negative, "nearZeroCells": len(values) - positive - negative,
            "intervalsAboveZero": sum(value > 0 for value in lower), "intervalsBelowZero": sum(value < 0 for value in upper),
            "classification": classification}


def component_patterns(contrasts, protocol, components):
    result = []
    expected_cells = len(protocol["stressDocketProfiles"]) * len(expected_contexts(protocol))
    for definition in contrast_definitions(protocol):
        for component in components:
            if component["claim"] != definition["claim"]:
                continue
            rows = [row for row in contrasts if row["contrast"] == definition["contrast"] and row["metric"] == component["metric"]]
            if len(rows) != expected_cells or len({(row["profile"], row["context"]) for row in rows}) != expected_cells:
                raise ValueError("missing or duplicated component cell")
            expected = component["expectedSign"] if definition["kind"] == "base" else 0
            result.append({**definition, **component, "expectedSign": expected,
                           **pattern([row["difference"] for row in rows], [row["lower"] for row in rows],
                                     [row["upper"] for row in rows], expected, protocol["practicalDifferenceThreshold"])})
    return result


def claim_matrix(patterns):
    result = []
    for row in patterns:
        if row["kind"] != "base":
            continue
        metric = row["metric"]
        if metric == "averageTimeToReview":
            status = "unsupported-design-duration-measure"
        elif metric in {"timelyLegislativeResponseRate", "averageLegislativeResponseDelay"}:
            status = "conditional-response-populations-not-comparable"
        elif metric in {"emergencyReasonGivingRate", "meritsFollowUpRate"}:
            status = "mechanism-and-conditional-denominator-dependent"
        elif metric in {"emergencyReasonGivingRate", "meritsFollowUpRate", "councilScreenRate", "legislativeResponseRate", "legislativeResponseCredibility"}:
            status = "mechanism-dependent-model-output"
        else:
            status = "modeled-downstream-or-accounting-output"
        result.append({**row, "evidenceStatus": status})
    return result


def dirichlet_weights(draws: int, dimensions: int, seed: int) -> list[tuple[float, ...]]:
    if draws < 1 or dimensions < 1:
        raise ValueError("empty preference sample")
    rng = random.Random(seed)
    weights = []
    for _ in range(draws):
        raw = []
        for _ in range(dimensions):
            u = rng.random()
            while u == 0:
                u = rng.random()
            raw.append(-math.log(u))
        total = math.fsum(raw)
        if total <= 0:
            raise ValueError("degenerate preference vector")
        weights.append(tuple(value / total for value in raw))
    return weights


def oriented_vector(means, higher, lower):
    if set(higher) & set(lower) or len(set(higher + lower)) != len(higher + lower):
        raise ValueError("duplicated or conflicting metric direction")
    values = [means[name] for name in higher] + [1 - means[name] for name in lower]
    if any(not math.isfinite(value) or not 0 <= value <= 1 for value in values):
        raise ValueError("normative metric is not on its declared normalized scale")
    return values


def weighted_score(values, weights):
    if len(values) != len(weights) or abs(math.fsum(weights) - 1) > 1e-12 or any(w < 0 for w in weights):
        raise ValueError("invalid normative score inputs")
    return math.fsum(value * weight for value, weight in zip(values, weights))


def leader_credits(scores, tolerance=TIE_TOLERANCE):
    if not scores or any(not math.isfinite(value) for value in scores.values()):
        raise ValueError("invalid leadership scores")
    best = max(scores.values())
    leaders = [key for key, value in scores.items() if best - value <= tolerance]
    return {key: (1 / len(leaders) if key in leaders else 0.0) for key in scores}


def weighted_signs(values):
    positive = sum(value > TIE_TOLERANCE for value in values)
    negative = sum(value < -TIE_TOLERANCE for value in values)
    return {"positiveDraws": positive, "negativeDraws": negative, "tiedDraws": len(values) - positive - negative,
            "differenceMin": min(values), "differenceMax": max(values), "reversesAcrossWeights": bool(positive and negative)}


def integer_count(value):
    rounded = round(value)
    if not math.isfinite(value) or value < 0 or abs(value - rounded) > 1e-9:
        raise ValueError("conditional diagnostic cannot reconcile an integer event count")
    return rounded


def denominator_diagnostics(vectors, cases_per_run):
    emergency = [integer_count(value) for value in vectors["emergencyOrders"]]
    replies = [integer_count(value * cases_per_run) for value in vectors["legislativeResponseRate"]]
    reasons = sum(integer_count(rate * count) for rate, count in zip(vectors["emergencyReasonGivingRate"], emergency))
    follow_up = sum(integer_count(rate * count) for rate, count in zip(vectors["meritsFollowUpRate"], emergency))
    timely = sum(integer_count(rate * count) for rate, count in zip(vectors["timelyLegislativeResponseRate"], replies))
    events, responses = sum(emergency), sum(replies)
    return {"runs": len(emergency), "runsWithoutEmergencyOrders": emergency.count(0),
            "runsWithoutLegislativeResponses": replies.count(0), "emergencyOrders": events,
            "ordersWithReasons": reasons, "meritsFollowUps": follow_up,
            "pooledReasonsPerOrder": reasons / events if events else "",
            "pooledFollowUpPerOrder": follow_up / events if events else "",
            "legislativeResponses": responses, "timelyResponses": timely,
            "pooledTimelyPerResponse": timely / responses if responses else ""}


def normative_analysis(cells, protocol, weights):
    bases = protocol["stressScenarioKeys"]
    half, off = protocol["stressAblations"][2:]
    variants = {"full-response": bases[3], "half-response": half, "no-response": off}
    pairs = list(combinations(bases, 2))
    grid = {pair: [[math.inf, -math.inf, 0, 0, 0] for _ in weights] for pair in pairs}
    leaders, preference_pairs, response_effects, means_rows, denominators = [], [], [], [], []
    for (profile, context), cell in cells.items():
        means = {scenario: {metric: math.fsum(values) / len(values) for metric, values in vectors.items()}
                 for scenario, vectors in cell.items()}
        for scenario, values in means.items():
            means_rows.append({"profile": profile, "context": context, "scenario": scenario, **values})
            denominators.append({"profile": profile, "context": context, "scenario": scenario,
                                 **denominator_diagnostics(cell[scenario], protocol["simulationCasesPerRun"])})
        vectors = {scenario: oriented_vector(values, protocol["weightMetricsHigher"], protocol["weightMetricsLower"])
                   for scenario, values in means.items()}
        scores = {scenario: [weighted_score(vector, weight) for weight in weights] for scenario, vector in vectors.items()}
        for variant, weak in variants.items():
            competition = bases[:3] + [weak]
            totals = {scenario: 0.0 for scenario in competition}
            for draw in range(len(weights)):
                credits = leader_credits({scenario: scores[scenario][draw] for scenario in competition})
                for scenario, credit in credits.items():
                    totals[scenario] += credit
            if not math.isclose(math.fsum(totals.values()), len(weights), abs_tol=1e-9):
                raise ValueError("leadership tie credits do not reconcile")
            for scenario in competition:
                leaders.append({"profile": profile, "context": context, "responseVariant": variant, "scenario": scenario,
                                "weightDraws": len(weights), "leadershipCredit": totals[scenario],
                                "leadershipShare": totals[scenario] / len(weights)})
        for left, right in pairs:
            differences = [a - b for a, b in zip(scores[left], scores[right])]
            preference_pairs.append({"profile": profile, "context": context, "left": left, "right": right,
                                     "weightDraws": len(weights), **weighted_signs(differences)})
            for state, value in zip(grid[(left, right)], differences):
                state[0], state[1] = min(state[0], value), max(state[1], value)
                state[2 if value > TIE_TOLERANCE else 3 if value < -TIE_TOLERANCE else 4] += 1
        for weak in (half, off):
            changes = [a - b for a, b in zip(scores[weak], scores[bases[3]])]
            response_effects.append({"profile": profile, "context": context, "left": weak, "right": bases[3],
                                     "weightDraws": len(weights), "meanDifference": math.fsum(changes) / len(weights),
                                     "preferenceP025": percentile(changes, 0.025), "preferenceP975": percentile(changes, 0.975),
                                     **weighted_signs(changes)})
    grid_rows = []
    for (left, right), states in grid.items():
        for draw, (minimum, maximum, positive, negative, tied) in enumerate(states):
            grid_rows.append({"left": left, "right": right, "weightDraw": draw, "cells": len(cells),
                              "differenceMin": minimum, "differenceMax": maximum, "positiveCells": positive,
                              "negativeCells": negative, "tiedCells": tied,
                              "reversesAcrossGrid": bool(positive and negative)})
    return {"-leadership.csv": leaders, "-preference-pairs.csv": preference_pairs,
            "-response-weight-effects.csv": response_effects, "-weight-grid-reversals.csv": grid_rows,
            "-cell-means.csv": means_rows, "-conditional-denominators.csv": denominators}


def table_bytes(rows):
    if not rows:
        raise ValueError("empty analysis output")
    fields = list(rows[0])
    if any(set(row) != set(fields) for row in rows):
        raise ValueError("inconsistent analysis output schema")
    return csv_bytes(fields, [[row[field] for field in fields] for row in rows])


def report_markdown(claims, patterns, normative, accounting, protocol):
    by_component = {(row["contrast"], row["metric"]): row for row in patterns}
    def span(contrast, metric):
        row = by_component[(contrast, metric)]
        return f"{row['pointMin']:.4f} to {row['pointMax']:.4f}"
    denominators = normative["-conditional-denominators.csv"]
    low_reasoned = [row for row in denominators if row["scenario"] == protocol["stressScenarioKeys"][1]
                    and row["context"] == "emergencyPressure-low"]
    empty_low = [row["runsWithoutEmergencyOrders"] for row in low_reasoned]
    lines = ["# Historical Benchmark and Robustness v1: institutional analysis", "",
             "The registered simulation comprises 3,993,600 case outcomes under four historical forecast profiles,",
             "thirteen contexts and eight base/ablated designs. These are modeled comparisons, not identified",
             "effects of real constitutional reforms. Historical anchoring covers docket composition only.", "",
             "## Main findings", "",
             f"- Emergency review: reasoned minus current emergency irregularity ranges from {span('emergency-base', 'shadowDocketAbuse')}; total cost from {span('emergency-base', 'totalInstitutionalCost')}. The shared review-time input cannot establish a procedural-duration tradeoff.",
             f"- Screening: council minus current direct cost is {span('screening-base', 'directCourtCost')} and total cost {span('screening-base', 'totalInstitutionalCost')}. The upstream difference, {span('screening-base', 'upstreamScreeningCost')}, is below the practical threshold in every cell. Changing only the council structure changes upstream cost by {span('screening-ablation', 'upstreamScreeningCost')}. Thus this intervention does not substantiate a substantial upstream displacement effect.",
             f"- Weak-form response dependence is partial: turning replies off changes responsiveness by {span('weak-form-off', 'democraticResponsiveness')} and veto risk by {span('weak-form-off', 'vetoRelocationRisk')}. Yet the no-response variant retains a compliance difference of {span('weak-form-off-v-current', 'complianceRate')} and a cost difference of {span('weak-form-off-v-current', 'totalInstitutionalCost')} relative to current. Response dependence does not account for all of its modeled advantages.", "",
             "These numerical ranges describe the fixed model/grid, not reform recommendations. Direct rule effects,",
             "constructed indices and downstream simulated outcomes require different evidentiary interpretations.", "",
             "## Conditional-rate warning", "",
             f"At low emergency pressure, the reasoned design has no emergency order in {min(empty_low)} to {max(empty_low)} of 120 runs, depending on the forecast profile.",
             "Those runs contribute zero to the registered mean of conditional run rates. The apparent reason-giving",
             "reversal therefore mixes the incidence of an emergency order with reason-giving conditional on an order.",
             "It does not establish less reason-giving per emergency order. The original contrast and classification",
             "are retained; event-count and pooled-rate diagnostics explain the denominator without replacing the endpoint.", "",
             "| Forecast | Design | Emergency orders | Orders with reasons | No-order runs | Pooled reasons per order |",
             "| --- | --- | ---: | ---: | ---: | ---: |"]
    for row in denominators:
        if row["context"] == "emergencyPressure-low" and row["scenario"] in protocol["stressScenarioKeys"][:2]:
            pooled = f"{row['pooledReasonsPerOrder']:.4f}" if row["emergencyOrders"] else "not estimable"
            lines.append(f"| {row['profile']} | {row['scenario']} | {row['emergencyOrders']} | {row['ordersWithReasons']} | {row['runsWithoutEmergencyOrders']} | {pooled} |")
    lines += ["", "Pooled rates are post-estimate measurement diagnostics, not substitute primary estimates; sparse",
              "order counts do not support a reliable conditional-rate comparison by themselves.", "",
             "## Claim-to-evidence matrix", "",
             "Ranges below span the 52 fixed forecast/context cells. Classification uses the predeclared",
             "+/-0.01 practical threshold on base-contrast point estimates. CI counts are separate, unadjusted",
             "paired-run Monte Carlo intervals; they are not uncertainty about which real context is likely.", "",
             "| Claim | Component | Difference range | Numerical pattern | CIs above / below zero | Evidence status |",
             "| --- | --- | ---: | --- | ---: | --- |"]
    for row in claims:
        lines.append(f"| {row['claim']} | {row['metric']} | {row['pointMin']:.4f} to {row['pointMax']:.4f} | "
                     f"{row['classification']} | {row['intervalsAboveZero']} / {row['intervalsBelowZero']} | {row['evidenceStatus']} |")
    lines += ["", "`descriptive-only` means no signed superiority hypothesis was specified, not that the metric was omitted.",
              "All per-cell estimates, endpoints and Monte Carlo standard errors are retained in the contrasts CSV.", "",
              "## Mechanism dependence", "",
              "These ablation ranges are changed mechanism minus its original parent. They do not have to",
              "preserve the base claim. Half/off versus current are separately retained as persistence checks.", "",
              "| Contrast | Component | Difference range | CIs above / below zero |",
              "| --- | --- | ---: | ---: |"]
    for row in patterns:
        if row["kind"] == "ablation":
            lines.append(f"| {row['contrast']} | {row['metric']} | {row['pointMin']:.4f} to {row['pointMax']:.4f} | "
                         f"{row['intervalsAboveZero']} / {row['intervalsBelowZero']} |")
    lines += ["", "## Competing normative priorities", "",
              "Each cell uses the same 1,000 registered Dirichlet preference vectors. Leadership shares below",
              "are minimum to maximum across the fixed grid, not population probabilities or a welfare ranking.",
              "Half/off competitions replace only weak-form review, leaving the same three competitors.", "",
              "| Response setting | Design | Leadership share range |", "| --- | --- | ---: |"]
    leadership = normative["-leadership.csv"]
    for variant in ("full-response", "half-response", "no-response"):
        scenarios = list(dict.fromkeys(row["scenario"] for row in leadership if row["responseVariant"] == variant))
        for scenario in scenarios:
            values = [row["leadershipShare"] for row in leadership if row["responseVariant"] == variant and row["scenario"] == scenario]
            lines.append(f"| {variant} | {scenario} | {min(values):.1%} to {max(values):.1%} |")
    pairs = normative["-preference-pairs.csv"]
    reversing = sum(row["reversesAcrossWeights"] for row in pairs)
    lines += ["", f"{reversing} of {len(pairs)} base-design pair/cell comparisons reverse ordering across the sampled preferences.",
              "Per-weight reversals across the context/profile grid are reported separately. Preference-percentile",
              "ranges on response-score changes are not Monte Carlo confidence intervals.", "",
              "## Accounting and measurement limits", "",
              f"Direct-only versus full cost accounting changes the practical sign in {sum(row['practicalSignChange'] for row in accounting)} of {len(accounting)} cells.",
              "This is an accounting-view change, not an institutional intervention. Both outputs are normalized",
              "indices with different construction, so their gap is not a monetary omitted-cost amount.", "",
              "- Average time to review is a shared docket input. All paired duration contrasts are zero; this measure cannot support a design-specific delay claim.",
              "- Conditional rates retain their legacy zero-denominator convention. No legislative response is not an observed late or instantaneous response.",
              "- Procedural activation and several score/cost terms are assigned by design. Stability of those outputs is not independent validation of the mechanism's substantive value.",
              "- The empirical profile had no clear conditional advantage in the frozen 66-dispute 2025 docket test. That result is retained, not refitted using this study.",
              "- The structural grid and illustrative preferences do not identify real-world causal effects, constitutional correctness or an institutionally optimal design.", "",
              "## Reproduction and completion status", "",
              "`make historical-analysis` recreates these tables from the source-hashed run exports;",
              "`make historical-analysis-check` recomputes them and checks their saved bytes. The analysis contract",
              "and manifest document estimands, seeds, inputs, code and output hashes. All calculations use the Python standard library.", "",
              "This completes an analysis checkpoint, not the overall publication goal. Manuscript/supplement",
              "integration, complete native CI, rendered PDFs and extracted anonymous replication still require verification.", ""]
    return "\n".join(lines).encode()


def analysis_input_hashes(directory):
    paths = [Path(__file__).resolve(), COMPONENT_FILE, CONTRACT_FILE,
             ROOT / "scripts/check_historical_study_raw.py", CONFIG / "first-evaluation-lock.json",
             ROOT / "reports/constitutional-review-historical-benchmark-v1-first-evaluation.json"]
    result = {path.relative_to(ROOT).as_posix(): file_hash(path) for path in paths}
    for suffix in ("-runs.csv.gz", "-manifest.json", "-raw-audit.json"):
        result[f"reports/{PREFIX}{suffix}"] = file_hash(directory / f"{PREFIX}{suffix}")
    return result


def build_analysis(directory: Path, workers: int = 2, check: bool = False):
    if workers < 1 or workers > 4:
        raise ValueError("analysis workers must be between one and four")
    protocol = load_protocol()
    check_study(directory)
    check_hashes(json.loads((CONFIG / "first-evaluation-lock.json").read_text())["sha256"])
    raw = json.loads((directory / f"{PREFIX}-raw-audit.json").read_text())
    if (raw["simulationManifestSha256"] != file_hash(directory / f"{PREFIX}-manifest.json")
            or raw["sourceSha256"]["scripts/check_historical_study_raw.py"] != file_hash(ROOT / "scripts/check_historical_study_raw.py")):
        raise ValueError("raw audit does not match the current study and independent checker")
    before = analysis_input_hashes(directory)
    components = load_components()
    cells = load_cells(directory, protocol, components)
    plan = bootstrap_plan(protocol["simulationRuns"], protocol["bootstrapReplicates"], protocol["bootstrapSeed"])
    jobs = [(key, cell, protocol, components) for key, cell in cells.items()]
    contrasts, accounting = [], []
    if workers == 1:
        results = [cell_analysis(*job, plan) for job in jobs]
    else:
        with ProcessPoolExecutor(max_workers=workers, initializer=initialize_worker, initargs=(plan,)) as pool:
            results = list(pool.map(worker_cell, jobs))
    for rows, cost in results:
        contrasts.extend(rows)
        accounting.append(cost)
    patterns = component_patterns(contrasts, protocol, components)
    claims = claim_matrix(patterns)
    metrics = protocol["weightMetricsHigher"] + protocol["weightMetricsLower"]
    weights = dirichlet_weights(protocol["weightDraws"], len(metrics), protocol["weightSeed"])
    normative = normative_analysis(cells, protocol, weights)
    tables = {"-contrasts.csv": contrasts, "-component-patterns.csv": patterns, "-claim-matrix.csv": claims,
              "-cost-accounting.csv": accounting,
              "-weight-vectors.csv": [{"weightDraw": index, **dict(zip(metrics, vector))} for index, vector in enumerate(weights)],
              **normative}
    artifacts = {suffix: table_bytes(rows) for suffix, rows in tables.items()}
    artifacts[".md"] = report_markdown(claims, patterns, normative, accounting, protocol)
    if before != analysis_input_hashes(directory):
        raise ValueError("analysis source or evidence changed during execution")
    manifest = {"protocolId": protocol["protocolId"], "status": "analysis-complete-publication-incomplete",
                "inputSha256": before, "rows": {suffix: len(rows) for suffix, rows in tables.items()},
                "outputSha256": {suffix: hashlib.sha256(data).hexdigest() for suffix, data in artifacts.items()},
                "bootstrapReplicates": protocol["bootstrapReplicates"], "bootstrapSeed": protocol["bootstrapSeed"],
                "bootstrapUnit": "paired whole simulation run; same resampling matrix for all cells and metrics",
                "weightDraws": protocol["weightDraws"], "weightSeed": protocol["weightSeed"],
                "weightAlgorithm": "Python Random positive uniforms; -log(U); normalize by sum; fixed metric directions",
                "zeroDenominatorGroups": raw["zeroDenominatorGroups"],
                "uncertaintyBoundary": "run-bootstrap MC intervals; structural grid ranges; preference sensitivity reported separately"}
    artifacts["-analysis-manifest.json"] = json_bytes(manifest)
    for suffix, data in artifacts.items():
        path = directory / f"{PREFIX}{suffix}"
        if check:
            if not path.exists() or path.read_bytes() != data:
                raise ValueError(f"analysis artifact differs from recomputation: {path.name}")
        else:
            path.write_bytes(data)
    print(json.dumps({"cells": len(cells), "contrasts": len(contrasts), "claimComponents": len(claims),
                      "weightDraws": len(weights), "checked": check}, indent=2))


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--output-dir", type=Path, default=ROOT / "reports")
    parser.add_argument("--workers", type=int, default=2)
    parser.add_argument("--check", action="store_true")
    args = parser.parse_args()
    build_analysis(args.output_dir, args.workers, args.check)


if __name__ == "__main__":
    main()
