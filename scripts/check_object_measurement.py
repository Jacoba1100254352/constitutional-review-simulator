#!/usr/bin/env python3
"""Independently reconstruct statute counts from raw campaign object and case exports."""

import argparse
import csv
import gzip
import math
from collections import defaultdict
from itertools import groupby
from pathlib import Path


def rows(path):
    opener = gzip.open if path.suffix == ".gz" else open
    with opener(path, "rt", encoding="utf-8", newline="") as handle:
        for row in csv.DictReader(handle):
            if None in row or any(value is None for value in row.values()):
                raise ValueError(f"CSV width mismatch in {path}")
            yield row


def check(prefix):
    # Both exports are ordered by campaign/scenario/run/case. Stream this join so
    # full sensitivity sweeps do not require retaining millions of case records.
    def case_key(row):
        return tuple(row[name] for name in ("caseKey", "scenarioKey", "runIndex", "caseIndex", "caseId"))

    totals = defaultdict(lambda: [0, 0, 0])
    previous = {}
    object_groups = iter(groupby(rows(Path(str(prefix) + "-objects.csv.gz")), key=case_key))
    case_count = object_count = 0
    for case in rows(Path(str(prefix) + "-cases.csv.gz")):
        key = case_key(case)
        aggregate_key = key[:2]
        run, index = int(case["runIndex"]), int(case["caseIndex"])
        last_run, last_index = previous.get(aggregate_key, (1, 0))
        if (run, index) not in {(last_run, last_index + 1), (last_run + 1, 1)} or (
            aggregate_key not in previous and (run, index) != (1, 1)
        ):
            raise ValueError(f"duplicate or unordered case key {key}")
        previous[aggregate_key] = (run, index)
        group_key, objects = next(object_groups, (None, ()))
        if group_key != key:
            raise ValueError(f"missing, orphan, or unordered object group for {key}")
        denominator = numerator = count = 0
        object_ids = set()
        for row in objects:
            if not row["objectId"] or row["objectId"] in object_ids:
                raise ValueError(f"missing or duplicate object ID {key}")
            object_ids.add(row["objectId"])
            if row["objectKind"] not in {"STATUTE", "REGULATION", "GOVERNMENT_CONDUCT"} or row["disposition"] not in {
                "NOT_REACHED", "UPHELD", "NULLIFIED", "CONDUCT_REMEDY", "DECLARATION"
            }:
                raise ValueError(f"unknown object kind or disposition {key}")
            for flag in ("statuteDisposition", "statuteNullification"):
                if row[flag] not in {"true", "false"}:
                    raise ValueError(f"invalid object boolean {flag}: {key}")
            reached = row["disposition"] != "NOT_REACHED"
            if reached != (case["meritsReview"] == "true"):
                raise ValueError(f"object merits status inconsistent with case {key}")
            in_denominator = reached and row["objectKind"] == "STATUTE"
            in_numerator = in_denominator and row["disposition"] == "NULLIFIED"
            if (row["statuteDisposition"] == "true") != in_denominator or (row["statuteNullification"] == "true") != in_numerator:
                raise ValueError(f"wrong inclusion flags {key}")
            if in_numerator and (case["meritsInvalidated"] != "true" or case["weakFormDeclaration"] == "true"):
                raise ValueError(f"statute nullification inconsistent with case relief {key}")
            if row["objectKind"] == "GOVERNMENT_CONDUCT" and row["disposition"] == "NULLIFIED":
                raise ValueError(f"conduct mislabeled as instrument nullification {key}")
            denominator += int(in_denominator)
            numerator += int(in_numerator)
            count += 1
        if not count or denominator != int(case["statuteDispositions"]) or numerator != int(case["statuteNullifications"]):
            raise ValueError(f"case counts disagree with raw objects {key}")
        totals[aggregate_key][0] += denominator
        totals[aggregate_key][1] += numerator
        totals[aggregate_key][2] += 1
        case_count += 1
        object_count += count
    if next(object_groups, None) is not None:
        raise ValueError("orphan object group after last case")
    report_keys = set()
    for row in rows(Path(str(prefix) + ".csv")):
        key = (row["caseKey"], row["scenarioKey"])
        if key in report_keys or key not in totals:
            raise ValueError(f"unexpected or duplicate aggregate {key}")
        report_keys.add(key)
        denominator, numerator, count = totals[key]
        if int(row["totalCases"]) != count:
            raise ValueError(f"aggregate case count disagrees with raw cases {key}")
        if denominator != int(row["statuteDispositions"]) or numerator != int(row["statuteNullifications"]):
            raise ValueError(f"aggregate counts disagree with raw objects {key}")
        rate = float(row["statuteNullificationRate"])
        if denominator == 0:
            if not math.isnan(rate):
                raise ValueError(f"empty denominator represented as a rate {key}")
        elif not math.isfinite(rate) or abs(rate - numerator / denominator) > 0.000501:
            raise ValueError(f"aggregate rate is not ratio of pooled object counts {key}")
    if not report_keys or report_keys != set(totals):
        raise ValueError("aggregate coverage differs from object coverage")
    print(f"{prefix.name}: reconciled {object_count} objects, {case_count} cases, {len(totals)} aggregates")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("prefix", nargs="+", type=Path, help="campaign path without .csv suffix")
    for prefix in parser.parse_args().prefix:
        check(prefix)
