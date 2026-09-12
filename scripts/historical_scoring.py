"""Frozen categorical scores and conditional uncertainty, independent of report layout."""

from __future__ import annotations

from collections import Counter
import math
import random

from historical_data import DocketRecord, probabilities


def category_counts(records: list[DocketRecord], categories: list[str]) -> list[int]:
    counts = Counter(record.category for record in records)
    if set(counts) - set(categories):
        raise ValueError("observed category outside the frozen partition")
    return [counts[category] for category in categories]


def scores(vector: list[float], counts: list[int]) -> dict[str, float]:
    probabilities(vector, len(counts))
    if any(not isinstance(value, int) or value < 0 for value in counts) or sum(counts) == 0:
        raise ValueError("scores require nonnegative counts and a nonempty test denominator")
    if any(p == 0 and n > 0 for p, n in zip(vector, counts)):
        raise ValueError("observed category has zero forecast probability; log loss is infinite")
    n = sum(counts)
    observed = [value / n for value in counts]
    return {
        "multiclass-brier": 1 + math.fsum(p * p for p in vector)
                            - 2 * math.fsum(q * p for p, q in zip(vector, observed)),
        "log-loss": -math.fsum(q * math.log(p) for p, q in zip(vector, observed) if q > 0),
        "total-variation": math.fsum(abs(p - q) for p, q in zip(vector, observed)) / 2,
    }


def percentile(values: list[float], p: float) -> float:
    if not values or not 0 <= p <= 1:
        raise ValueError("percentile requires values and a probability")
    ordered = sorted(values)
    index = (len(ordered) - 1) * p
    low, high = math.floor(index), math.ceil(index)
    fraction = index - low
    return ordered[low] * (1 - fraction) + ordered[high] * fraction


def interval(values: list[float]) -> dict[str, float]:
    return {"lower": percentile(values, 0.025), "upper": percentile(values, 0.975)}


def conditional_score_differences(forecasts: list[dict], counts: list[int],
                                  replicates: int, seed: int) -> list[dict]:
    """Same sampled cases for every method and metric; forecasts stay fixed."""
    if replicates < 2 or sum(counts) < 2:
        raise ValueError("conditional interval needs at least two replicates and cases")
    models = {row["model"]: row["probabilities"] for row in forecasts}
    if "recency-weighted-15y" not in models:
        raise ValueError("empirical comparison model missing")
    point = {model: scores(vector, counts) for model, vector in models.items()}
    differences = {(model, metric): [] for model in models if model != "recency-weighted-15y"
                   for metric in point[model]}
    rng = random.Random(seed)
    for _ in range(replicates):
        sampled = Counter(rng.choices(range(len(counts)), weights=counts, k=sum(counts)))
        draws = [sampled[i] for i in range(len(counts))]
        measured = {model: scores(vector, draws) for model, vector in models.items()}
        for (model, metric), values in differences.items():
            values.append(measured["recency-weighted-15y"][metric] - measured[model][metric])
    results = []
    for (model, metric), values in differences.items():
        bounds = interval(values)
        results.append({"comparison": f"recency-weighted-15y minus {model}", "metric": metric,
                        "difference": point["recency-weighted-15y"][metric] - point[model][metric],
                        **bounds, "method": "paired-case-bootstrap-fixed-forecasts",
                        "replicates": replicates, "sampleSize": sum(counts),
                        "conditionalAdvantage": bounds["upper"] < 0,
                        "limitation": "within one coded term; does not estimate between-term or structural uncertainty"})
    return results


def training_composition_intervals(records: list[DocketRecord], target: int, protocol: dict) -> list[dict]:
    """Resample original training terms, retaining each term's age and case count."""
    categories = protocol["categories"]
    minimum = target - protocol["empiricalLookbackTerms"]
    grouped = {}
    for term in range(minimum, target):
        period = [row for row in records if row.term == term]
        if not period:
            raise ValueError("empty term in empirical training bootstrap")
        if any(row.sourceRelease != protocol["developmentRelease"] for row in period):
            raise ValueError("training bootstrap cannot use the test release")
        weight = 2 ** (-((target - 1) - term) / protocol["empiricalHalfLifeTerms"])
        grouped[term] = [n * weight for n in category_counts(period, categories)]
    if len(grouped) < 2:
        raise ValueError("training uncertainty requires multiple term clusters")
    terms = sorted(grouped)
    rng = random.Random(protocol["bootstrapSeed"] + 1)
    values = [[] for _ in categories]
    for _ in range(protocol["bootstrapReplicates"]):
        selected = rng.choices(terms, k=len(terms))
        counts = [protocol["pseudocountPerCategory"] + math.fsum(grouped[t][i] for t in selected)
                  for i in range(len(categories))]
        total = math.fsum(counts)
        for i, count in enumerate(counts):
            values[i].append(count / total)
    return [{"category": category, **interval(values[i]), "trainingTerms": len(terms),
             "method": "training-term-cluster-bootstrap-fixed-age-weights",
             "replicates": protocol["bootstrapReplicates"]}
            for i, category in enumerate(categories)]


def new_term_result(records: list[DocketRecord], forecasts: list[dict], protocol: dict) -> dict:
    target = protocol["newDataTestTerm"]
    if len(records) < 2:
        raise ValueError("test population needs at least two cases for the registered interval")
    if any(record.sourceRelease != protocol["testRelease"] or record.term != target for record in records):
        raise ValueError("new-term evaluation accepts only the test term from its registered release")
    if len({record.caseId for record in records}) != len(records):
        raise ValueError("duplicate case in test population")
    if [row["model"] for row in forecasts] != protocol["models"]:
        raise ValueError("forecast model set or order changed")
    if any(row["targetTerm"] != target or (row["trainingMaxTerm"] is not None and row["trainingMaxTerm"] >= target)
           for row in forecasts):
        raise ValueError("forecast term or training cutoff violates protocol")
    counts = category_counts(records, protocol["categories"])
    return {
        "protocolId": protocol["protocolId"], "targetTerm": target, "testN": len(records),
        "exposureLabel": "new SCDB term evaluated after a recorded forecast freeze; not blindness to public events",
        "claimBoundary": "docket composition only; no substantive-outcome or causal institutional validation",
        "categories": [{"category": category, "count": counts[i], "share": counts[i] / len(records)}
                       for i, category in enumerate(protocol["categories"])],
        "mappingStatuses": dict(sorted(Counter(row.mappingStatus for row in records).items())),
        "modelScores": [{"model": row["model"], **scores(row["probabilities"], counts)} for row in forecasts],
        "pairedDifferences": conditional_score_differences(forecasts, counts, protocol["bootstrapReplicates"],
                                                           protocol["bootstrapSeed"]),
    }
