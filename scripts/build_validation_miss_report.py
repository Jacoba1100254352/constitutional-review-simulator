#!/usr/bin/env python3
"""Build source-specific validation miss diagnostics from calibration output."""

from __future__ import annotations

import csv
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
REPORTS = ROOT / "reports"
INPUT = REPORTS / "constitutional-review-validation-v1-calibration.csv"
OUTPUT_CSV = REPORTS / "constitutional-review-validation-v1-misses.csv"
OUTPUT_MD = REPORTS / "constitutional-review-validation-v1-misses.md"


FIELDNAMES = [
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


def read_rows(path: Path) -> list[dict[str, str]]:
    if not path.exists():
        raise SystemExit(
            f"Missing {path}. Run `make validation-check` before building validation miss diagnostics."
        )
    with path.open(newline="", encoding="utf-8") as handle:
        return list(csv.DictReader(handle))


def truthy(value: str) -> bool:
    return value.strip().lower() == "true"


def fmt(value: str) -> str:
    return f"{float(value):.3f}"


def category_for(row: dict[str, str]) -> str:
    if truthy(row["withinTarget"]):
        return "within source range"
    key = row["targetKey"]
    if key == "intake_acceptance_rate":
        return "intake denominator alignment"
    if key == "case_selection_access":
        return "case-selection access proxy"
    if key.startswith("emergency_"):
        return "emergency-procedure calibration"
    if key in {"legislative_response_rate", "legislative_response_credibility"}:
        return "weak-form response mechanism"
    if key == "suspended_declaration_rate":
        return "remedy-timing mechanism"
    if key == "merits_invalidation_rate":
        return "merits-outcome mechanism"
    if key in {"preliminary_reference_rate", "appeal_route_rate", "direct_action_rate"}:
        return "route-mix preset"
    return "source-specific diagnostic"


def interpretation_for(row: dict[str, str]) -> tuple[str, str]:
    category = category_for(row)
    key = row["targetKey"]
    court = row["court"]
    if category == "within source range":
        return (
            "The preset matches this narrow source-denominated diagnostic only.",
            "Keep the row as a benchmark check; do not generalize it to full court behavior.",
        )
    if key == "intake_acceptance_rate":
        return (
            "The model's generated filing screen is not yet aligned with the source court's annual intake denominator.",
            "Refine upstream filing volume, leave/admission filters, and docket-source mapping before making court-specific intake claims.",
        )
    if key == "case_selection_access":
        return (
            "The source row is a permission-to-appeal grant-rate proxy, not a full measure of litigant capacity or public-interest access.",
            "Separate grant-rate fit from access mechanisms such as counsel, filing cost, public-interest standing, repeat-player advantage, and legal-aid capacity.",
        )
    if key == "emergency_relief_rate":
        return (
            "The emergency-relief process is still tuned as a stress mechanism, not as a source-court interim-measure process.",
            "Separate applicant mix, urgency, merits-follow-through, and grant standards for this court profile.",
        )
    if key.startswith("emergency_"):
        return (
            "Emergency transparency and disagreement parameters remain procedure-level assumptions rather than fitted source behavior.",
            "Add source-coded emergency orders before using the profile as an empirical emergency-docket comparison.",
        )
    if key == "legislative_response_rate":
        return (
            "The weak-form declaration pathway understates source-counted legislative or remedial response.",
            "Tune response-cycle triggers, government capacity, and statutory-remedy coding for the declaration model.",
        )
    if key == "legislative_response_credibility":
        return (
            "The model overstates credible statutory follow-through after declaration-like review.",
            "Constrain response quality so remedial action is not treated as credible without amendment, repeal, or equivalent implementation.",
        )
    if key == "suspended_declaration_rate":
        return (
            "The council preset does not yet reproduce deferred-effect remedial timing.",
            "Add remedy timing rules that distinguish immediate invalidation from suspended or prospective-effect declarations.",
        )
    if key == "merits_invalidation_rate":
        return (
            "The merits-outcome rate is close but outside the source interval for this profile.",
            "Retune doctrine severity, referral screening, and invalidation-threshold parameters only after preserving cross-profile comparability.",
        )
    if category == "route-mix preset":
        return (
            f"The {court} route-mix preset aligns with this official route-share target.",
            "Keep route shares source-specific and avoid treating route fit as validation of merits outcomes.",
        )
    return (
        "The preset misses this source-specific diagnostic.",
        "Inspect whether the source denominator, simulator metric, and scenario preset are directly comparable.",
    )


def validation_rows() -> list[dict[str, str]]:
    rows = [row for row in read_rows(INPUT) if truthy(row["useForValidation"])]
    output: list[dict[str, str]] = []
    for row in rows:
        interpretation, next_action = interpretation_for(row)
        output.append(
            {
                "profileKey": row["profileKey"],
                "court": row["court"],
                "timePeriod": row["timePeriod"],
                "targetKey": row["targetKey"],
                "label": row["label"],
                "sourceName": row["sourceName"],
                "sourceUrl": row["sourceUrl"],
                "observedValue": fmt(row["observedValue"]),
                "sourceRange": f"{fmt(row['lowerBound'])}--{fmt(row['upperBound'])}",
                "targetN": row["targetN"],
                "modelObservedValue": fmt(row["modelObservedValue"]),
                "modelInterval": f"{fmt(row['lower95'])}--{fmt(row['upper95'])}",
                "gap": fmt(row["gap"]),
                "withinTarget": row["withinTarget"].lower(),
                "missCategory": category_for(row),
                "interpretation": interpretation,
                "nextAction": next_action,
            }
        )
    output.sort(key=lambda item: (item["withinTarget"] == "true", -float(item["gap"]), item["court"]))
    return output


def write_csv(rows: list[dict[str, str]]) -> None:
    REPORTS.mkdir(parents=True, exist_ok=True)
    with OUTPUT_CSV.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(handle, fieldnames=FIELDNAMES)
        writer.writeheader()
        writer.writerows(rows)


def write_markdown(rows: list[dict[str, str]]) -> None:
    lines = [
        "# Validation Miss Interpretation",
        "",
        "This file is generated from `constitutional-review-validation-v1-calibration.csv`.",
        "It includes only source-specific validation rows with documented denominators and direct simulator analogues.",
        "A miss is a calibration diagnostic, not a failed forecast.",
        "",
        "| Profile | Target | Source range | Model | Gap | Category | Interpretation | Next action |",
        "| --- | --- | --- | --- | ---: | --- | --- | --- |",
    ]
    for row in rows:
        lines.append(
            " | ".join(
                [
                    f"| {row['profileKey']}",
                    row["label"],
                    row["sourceRange"],
                    row["modelObservedValue"],
                    row["gap"],
                    row["missCategory"],
                    row["interpretation"],
                    f"{row['nextAction']} |",
                ]
            )
        )
    OUTPUT_MD.write_text("\n".join(lines) + "\n", encoding="utf-8")


def main() -> None:
    rows = validation_rows()
    write_csv(rows)
    write_markdown(rows)


if __name__ == "__main__":
    main()
