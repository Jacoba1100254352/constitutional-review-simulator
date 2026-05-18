#!/usr/bin/env python3
"""Generate compact JLC-facing LaTeX tables from simulator artifacts."""

from __future__ import annotations

import csv
import re
from pathlib import Path


ROOT = Path(__file__).resolve().parents[2]
REPORT_DIR = ROOT / "reports"
CONFIG_DIR = ROOT / "config" / "calibration"
TABLE_DIR = ROOT / "paper" / "tables"
REFERENCES_BIB = ROOT / "paper" / "references.bib"
BASELINE_CSV = REPORT_DIR / "constitutional-review-campaign-v0.csv"
BASELINE_INTERVALS_CSV = REPORT_DIR / "constitutional-review-campaign-v0-intervals.csv"
VALIDATION_CSV = REPORT_DIR / "constitutional-review-validation-v1.csv"
VALIDATION_DOCTRINE_CSV = REPORT_DIR / "constitutional-review-validation-v1-doctrines.csv"
VALIDATION_MISSES_CSV = REPORT_DIR / "constitutional-review-validation-v1-misses.csv"

SCENARIO_LABELS = {
    "current-federal-court": "CUR",
    "eighteen-year-terms": "18Y",
    "fifteen-justice-commission": "15J",
    "supermajority-invalidation": "SUP",
    "strict-recusal-court": "REC",
    "reasoned-emergency-review": "EMR",
    "panel-en-banc-review": "PAN",
    "dual-cross-checking-courts": "DUAL",
    "constitutional-council": "COUNC",
    "legislative-override-court": "OVR",
    "accountability-retention-court": "RET",
    "independence-accountability-hybrid": "HYB",
    "weak-form-review": "WFR",
    "suspended-declaration-review": "SUS",
    "override-clause-review": "OVC",
    "pre-enactment-review": "PRE",
    "abstract-review-tribunal": "ABS",
    "ombudsman-triggered-review": "OMB",
    "constitutional-public-defender": "DEF",
    "rights-impact-statement-review": "RIS",
    "mandatory-legislative-response": "MLR",
}

SCENARIO_ORDER = [
    "current-federal-court",
    "reasoned-emergency-review",
    "dual-cross-checking-courts",
    "constitutional-council",
    "legislative-override-court",
    "independence-accountability-hybrid",
    "weak-form-review",
    "suspended-declaration-review",
    "pre-enactment-review",
    "abstract-review-tribunal",
    "ombudsman-triggered-review",
    "constitutional-public-defender",
    "rights-impact-statement-review",
    "mandatory-legislative-response",
]

MECHANISM_ORDER = [
    "weak-form-review",
    "suspended-declaration-review",
    "override-clause-review",
    "pre-enactment-review",
    "abstract-review-tribunal",
    "ombudsman-triggered-review",
    "constitutional-public-defender",
    "rights-impact-statement-review",
    "mandatory-legislative-response",
]

CALIBRATION_ROWS = [
    ("us-supreme-court-2000-2024.csv", "scdb-modern-merits-2000-2024", "doctrine_mix.speech"),
    ("us-supreme-court-2000-2024.csv", "scdb-modern-merits-2000-2024", "doctrine_mix.equality"),
    ("us-supreme-court-2024-public-emergency.csv", "scotus-emergency-2024-2025", "emergency_relief_rate"),
    ("us-supreme-court-2024-public-emergency.csv", "scotus-emergency-2024-2025", "emergency_reason_giving_rate"),
    ("canada-scc-2024.csv", "canada-scc-2024", "intake_acceptance_rate"),
    ("uk-human-rights-doi-2025.csv", "uk-human-rights-doi-2025", "legislative_response_rate"),
    ("uk-supreme-court-2024-2025.csv", "uk-supreme-court-2024-2025", "intake_acceptance_rate"),
    ("uk-supreme-court-2024-2025.csv", "uk-supreme-court-2024-2025", "case_selection_access"),
    ("echr-2024.csv", "echr-2024", "emergency_relief_rate"),
    ("us-supreme-court-2024-public-emergency.csv", "gallup-court-confidence-2024", "public_trust"),
    ("germany-bverfg-2024.csv", "germany-bverfg-2024", "intake_acceptance_rate"),
    ("canada-scc-recent.csv", "canada-scc-recent", "intake_acceptance_rate"),
    ("france-conseil-qpc.csv", "france-conseil-qpc", "merits_invalidation_rate"),
    ("south-africa-constcourt-recent.csv", "south-africa-constcourt-recent", "review_rate"),
]

VALIDATION_PROFILES = [
    ("scdb-modern-merits-2000-2024", "us-supreme-court-benchmark", "U.S. Supreme Court"),
    ("scotus-emergency-2024-2025", "us-supreme-court-benchmark", "U.S. emergency docket"),
    ("germany-bverfg-2024", "german-constitutional-court", "Germany BVerfG"),
    ("canada-scc-2024", "canadian-supreme-court", "Canada SCC"),
    ("france-conseil-qpc", "french-constitutional-council", "France Conseil"),
    ("south-africa-constcourt-recent", "south-african-constitutional-court", "South Africa ConstCourt"),
    ("uk-supreme-court-2024-2025", "uk-supreme-court", "UK Supreme Court"),
    ("uk-human-rights-doi-2025", "uk-supreme-court", "UK declarations"),
    ("echr-2024", "echr-treaty-court", "ECHR"),
    ("cjeu-2024", "cjeu-court-of-justice", "CJEU"),
]

METRIC_TARGETS = {
    "review_rate": "reviewRate",
    "intake_acceptance_rate": "intakeAcceptanceRate",
    "case_selection_access": "caseSelectionAccess",
    "emergency_relief_rate": "emergencyReliefRate",
    "emergency_reason_giving_rate": "emergencyReasonGivingRate",
    "emergency_vote_disclosure_rate": "emergencyVoteDisclosureRate",
    "emergency_public_disagreement_rate": "emergencyPublicDisagreementRate",
    "government_emergency_win_rate": "governmentEmergencyWinRate",
    "merits_follow_up_rate": "meritsFollowUpRate",
    "merits_invalidation_rate": "meritsInvalidationRate",
    "override_rate": "overrideRate",
    "weak_form_declaration_rate": "weakFormDeclarationRate",
    "suspended_declaration_rate": "suspendedDeclarationRate",
    "legislative_response_rate": "legislativeResponseRate",
    "legislative_response_delay": "averageLegislativeResponseDelay",
    "timely_legislative_response_rate": "timelyLegislativeResponseRate",
    "legislative_response_credibility": "legislativeResponseCredibility",
    "pre_enactment_review_rate": "preEnactmentReviewRate",
    "abstract_review_rate": "abstractReviewRate",
    "preliminary_reference_rate": "preliminaryReferenceRate",
    "appeal_route_rate": "appealRouteRate",
    "direct_action_rate": "directActionRate",
    "rights_impact_statement_rate": "rightsImpactStatementRate",
    "ombudsman_trigger_rate": "ombudsmanTriggerRate",
    "public_defender_participation_rate": "publicDefenderParticipationRate",
    "compliance_rate": "complianceRate",
    "legislative_reenactment_rate": "legislativeReenactmentRate",
    "public_trust": "publicTrust",
    "direct_court_cost": "directCourtCost",
    "upstream_screening_cost": "upstreamScreeningCost",
    "capacity_strain_cost": "capacityStrainCost",
    "total_institutional_cost": "totalInstitutionalCost",
}


def read_rows(path: Path) -> list[dict[str, str]]:
    with path.open(newline="") as handle:
        return list(csv.DictReader(handle))


def latex_escape(value: str) -> str:
    replacements = {
        "&": r"\&",
        "%": r"\%",
        "$": r"\$",
        "#": r"\#",
        "_": r"\_",
        "{": r"\{",
        "}": r"\}",
    }
    return "".join(replacements.get(char, char) for char in value)


def num(value: str | float) -> str:
    return f"{float(value):.3f}"


def write(name: str, content: str) -> None:
    TABLE_DIR.mkdir(parents=True, exist_ok=True)
    (TABLE_DIR / name).write_text(content, encoding="utf-8")


def strip_outer_braces(value: str) -> str:
    value = value.strip()
    changed = True
    while changed and len(value) >= 2:
        changed = False
        if value.startswith("{") and value.endswith("}"):
            value = value[1:-1].strip()
            changed = True
    return value


def parse_bibtex() -> list[dict[str, str]]:
    entries: list[dict[str, str]] = []
    text = REFERENCES_BIB.read_text(encoding="utf-8")
    for match in re.finditer(r"@(?P<type>\w+)\{(?P<key>[^,]+),(?P<body>.*?)(?=\n@\w+\{|\Z)", text, flags=re.S):
        fields: dict[str, str] = {"entryType": match.group("type").lower(), "key": match.group("key").strip()}
        for line in match.group("body").splitlines():
            line = line.strip().rstrip(",")
            if not line or "=" not in line:
                continue
            name, raw_value = line.split("=", 1)
            fields[name.strip()] = strip_outer_braces(raw_value.strip())
        entries.append(fields)
    return entries


def author_parts(author: str) -> list[str]:
    return [strip_outer_braces(part.strip()) for part in author.split(" and ") if part.strip()]


def author_last_name(author: str) -> str:
    author = strip_outer_braces(author)
    if "," in author:
        return author.split(",", 1)[0].strip()
    return author


def author_label(author: str) -> str:
    parts = author_parts(author)
    if not parts:
        return "Unknown"
    if len(parts) == 1:
        return author_last_name(parts[0])
    if len(parts) == 2:
        return f"{author_last_name(parts[0])} and {author_last_name(parts[1])}"
    return f"{author_last_name(parts[0])} et al."


def format_personal_author(author: str, *, first_author: bool) -> str:
    author = strip_outer_braces(author)
    if "," not in author:
        return author
    last, given = [part.strip() for part in author.split(",", 1)]
    return f"{last}, {given}" if first_author else f"{given} {last}"


def format_authors(author: str) -> str:
    parts = author_parts(author)
    if len(parts) == 1:
        return format_personal_author(parts[0], first_author=True)
    if len(parts) == 2:
        return f"{format_personal_author(parts[0], first_author=True)}, and {format_personal_author(parts[1], first_author=False)}"
    formatted = [format_personal_author(part, first_author=(idx == 0)) for idx, part in enumerate(parts)]
    return ", ".join(formatted[:-1]) + f", and {formatted[-1]}"


def sort_key(entry: dict[str, str]) -> tuple[str, str, str]:
    return (author_label(entry.get("author", "")).lower(), entry.get("year", ""), entry.get("title", "").lower())


def sentence_prefix(value: str) -> str:
    return value if value.endswith(".") else f"{value}."


def generate_reference_items() -> None:
    entries = sorted(parse_bibtex(), key=sort_key)
    labels: dict[tuple[str, str], list[dict[str, str]]] = {}
    for entry in entries:
        labels.setdefault((author_label(entry.get("author", "")), entry.get("year", "")), []).append(entry)
    suffixes: dict[str, str] = {}
    for (_label, _year), group in labels.items():
        if len(group) > 1:
            for index, entry in enumerate(group):
                suffixes[entry["key"]] = chr(ord("a") + index)

    lines = ["% Auto-generated by paper/scripts/generate_tables.py", ""]
    for entry in entries:
        year = entry.get("year", "")
        suffix = suffixes.get(entry["key"], "")
        cited_year = f"{year}{suffix}"
        lines.append(rf"\bibitem[{author_label(entry.get('author', ''))}({cited_year})]{{{entry['key']}}}")
        authors = format_authors(entry.get("author", ""))
        author_text = sentence_prefix(authors)
        title = entry.get("title", "")
        if entry["entryType"] == "book":
            address = entry.get("address", "")
            publisher = entry.get("publisher", "")
            publisher_text = f"{address}: {publisher}" if address else publisher
            lines.append(rf"{author_text} {cited_year}. \textit{{{title}}}. {publisher_text}.")
        else:
            url_match = re.search(r"\\url\{([^}]+)\}", entry.get("howpublished", ""))
            url = url_match.group(1) if url_match else entry.get("howpublished", "")
            note = entry.get("note", "")
            note_text = f" {note}." if note else ""
            lines.append(rf"{author_text} {cited_year}. ``{title}.'' \url{{{url}}}.{note_text}")
        lines.append("")
    write("reference_items.tex", "\n".join(lines))


def generate_baseline_results() -> None:
    baseline_rows = {
        row["scenarioKey"]: row
        for row in read_rows(BASELINE_CSV)
        if row["caseKey"] == "baseline"
    }
    interval_rows = {
        row["scenarioKey"]: row
        for row in read_rows(BASELINE_INTERVALS_CSV)
        if row["caseKey"] == "baseline" and row["metric"] == "directionalScore"
    }
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Baseline scenario diagnostics.}",
        r"\label{tab:baseline-results}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{3pt}",
        r"\begin{tabular}{@{}llrrrrrrrr@{}}",
        r"\toprule",
        r"Scenario & Kind & Dem. const. & Rights & Emerg. irr. $\downarrow$ & Legit. proxy & Veto $\downarrow$ & Transplant & Cost $\downarrow$ & Score aid \\",
        r"\midrule",
    ]
    for scenario in SCENARIO_ORDER:
        row = baseline_rows[scenario]
        interval = interval_rows[scenario]
        lines.append(
            " & ".join(
                [
                    SCENARIO_LABELS[scenario],
                    "S" if row["scenarioKind"] == "synthetic_mechanism" else ("R" if row["scenarioKind"] == "real_world_preset" else "C"),
                    num(row["democraticConstitutionalism"]),
                    num(row["rightsProtection"]),
                    num(row["shadowDocketAbuse"]),
                    num(row["legitimacy"]),
                    num(row["vetoRelocationRisk"]),
                    num(row["legalTransplantFeasibility"]),
                    num(row["totalInstitutionalCost"]),
                    num(row["directionalScore"]),
                ]
            )
            + r" \\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: Values are baseline campaign estimates. C denotes court-variant scenarios and S denotes synthetic mechanism scenarios. Emergency irregularity is the renamed emergency-process irregularity index stored in reports as \texttt{shadowDocketAbuse}; lower values indicate less opaque or merits-displacing emergency intervention. The legitimacy column is a modeled public-legitimacy proxy, not public-opinion measurement. The score aid is the equally weighted directional diagnostic score and should not be read as a rank ordering. Its 95\% run-block bootstrap interval is reported in the replication files. Democratic constitutionalism, veto-relocation risk, transplant feasibility, case-selection access, response credibility, repeat-player advantage, and implementation capacity are synthetic diagnostic constructs, not empirical estimates.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("baseline_results.tex", "\n".join(lines))


def generate_mechanism_results() -> None:
    baseline_rows = {
        row["scenarioKey"]: row
        for row in read_rows(BASELINE_CSV)
        if row["caseKey"] == "baseline"
    }
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Synthetic constitutional-review mechanism diagnostics.}",
        r"\label{tab:mechanism-results}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{3pt}",
        r"\begin{tabular}{@{}lrrrrrrrrr@{}}",
        r"\toprule",
        r"Mechanism & Dem. const. & Veto $\downarrow$ & Transplant & Culture $\downarrow$ & Weak & Susp. & Response & Front-end & Access \\",
        r"\midrule",
    ]
    for scenario in MECHANISM_ORDER:
        row = baseline_rows[scenario]
        front_end = max(float(row["rightsImpactStatementRate"]), float(row["preEnactmentReviewRate"]), float(row["abstractReviewRate"]))
        access = float(row["caseSelectionAccess"])
        lines.append(
            " & ".join(
                [
                    SCENARIO_LABELS[scenario],
                    num(row["democraticConstitutionalism"]),
                    num(row["vetoRelocationRisk"]),
                    num(row["legalTransplantFeasibility"]),
                    num(row["politicalCultureSensitivity"]),
                    num(row["weakFormDeclarationRate"]),
                    num(row["suspendedDeclarationRate"]),
                    num(row["legislativeResponseRate"]),
                    num(front_end),
                    num(access),
                ]
            )
            + r" \\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: These are synthetic mechanism tests, not claims about named legal systems. Front-end is the maximum of rights-impact statement, pre-enactment review, and abstract review rates. Access is the synthetic case-selection access diagnostic, which combines litigant capacity, public-interest support, repeat-player advantage, and intake filtering.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("mechanism_results.tex", "\n".join(lines))


def calibration_lookup() -> dict[tuple[str, str], dict[str, str]]:
    rows: dict[tuple[str, str], dict[str, str]] = {}
    for path in CONFIG_DIR.glob("*.csv"):
        for row in read_rows(path):
            rows[(row["profileKey"], row["targetKey"])] = row
    return rows


def generate_calibration_targets() -> None:
    lookup = calibration_lookup()
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Examples of external calibration targets.}",
        r"\label{tab:calibration-targets}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{3pt}",
        r"\begin{tabular}{@{}p{0.26\linewidth}p{0.27\linewidth}rrrl@{}}",
        r"\toprule",
        r"Court and period & Target & Observed & Range & $n$ & Reliability \\",
        r"\midrule",
    ]
    for _, profile, target in CALIBRATION_ROWS:
        row = lookup[(profile, target)]
        court = f"{row['court']} ({row['timePeriod']})"
        target_label = row["label"]
        observed = num(row["observedValue"])
        target_range = f"{num(row['lowerBound'])}--{num(row['upperBound'])}"
        n = row["n"] if row["n"] and row["n"] != "0" else "--"
        lines.append(
            f"{latex_escape(court)} & {latex_escape(target_label)} & {observed} & {target_range} & {latex_escape(n)} & {latex_escape(row['reliability'])} \\\\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: The table reports selected external calibration targets used for source-range diagnostics. Ranges are target intervals, not estimated model effects. Source names, URLs, construction notes, and validation flags are retained in the replication materials. Contextual trust proxies and normalized cost benchmarks are not counted as validation evidence unless separately source-denominated.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("calibration_targets.tex", "\n".join(lines))


def doctrine_shares() -> dict[tuple[str, str], float]:
    shares: dict[tuple[str, str], float] = {}
    rows = [
        row
        for row in read_rows(VALIDATION_DOCTRINE_CSV)
        if row["caseKey"] == "benchmark-context"
    ]
    totals: dict[str, int] = {}
    for row in rows:
        totals[row["scenarioKey"]] = totals.get(row["scenarioKey"], 0) + int(row["totalCases"])
    for row in rows:
        total = totals.get(row["scenarioKey"], 0)
        if total:
            shares[(row["scenarioKey"], row["segmentKey"])] = int(row["totalCases"]) / total
    return shares


def target_value(row: dict[str, str], scenario: dict[str, str], shares: dict[tuple[str, str], float]) -> float | None:
    key = row["targetKey"]
    if key.startswith("doctrine_mix."):
        doctrine = key.removeprefix("doctrine_mix.")
        return shares.get((scenario["scenarioKey"], doctrine))
    metric = METRIC_TARGETS.get(key)
    if metric is None or metric not in scenario:
        return None
    return float(scenario[metric])


def generate_validation_summary() -> None:
    validation_rows = {
        row["scenarioKey"]: row
        for row in read_rows(VALIDATION_CSV)
        if row["caseKey"] == "benchmark-context"
    }
    targets_by_profile: dict[str, list[dict[str, str]]] = {}
    for row in calibration_lookup().values():
        if row["useForValidation"].lower() == "true":
            targets_by_profile.setdefault(row["profileKey"], []).append(row)
    shares = doctrine_shares()
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Validation-style checks against documented target ranges.}",
        r"\label{tab:validation-summary}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{4pt}",
        r"\begin{tabular}{@{}p{0.22\linewidth}p{0.25\linewidth}rrp{0.27\linewidth}@{}}",
        r"\toprule",
        r"Profile & Scenario preset & In range & Median gap & Largest miss \\",
        r"\midrule",
    ]
    for profile, scenario_key, label in VALIDATION_PROFILES:
        scenario = validation_rows[scenario_key]
        gaps: list[float] = []
        within = 0
        misses: list[tuple[float, str]] = []
        for target in targets_by_profile.get(profile, []):
            value = target_value(target, scenario, shares)
            if value is None:
                continue
            lower = float(target["lowerBound"])
            upper = float(target["upperBound"])
            gap = 0.0 if lower <= value <= upper else min(abs(value - lower), abs(value - upper))
            gaps.append(gap)
            if gap == 0.0:
                within += 1
            else:
                misses.append((gap, target["label"]))
        median_gap = sorted(gaps)[len(gaps) // 2] if gaps else 0.0
        largest = max(misses, default=(0.0, "none" if gaps else "not counted"))[1]
        in_range = f"{within}/{len(gaps)}" if gaps else "--"
        median_text = f"{median_gap:.3f}" if gaps else "--"
        lines.append(
            f"{latex_escape(label)} & {latex_escape(scenario['scenario'])} & {in_range} & {median_text} & {latex_escape(largest)} \\\\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: The validation campaign runs real-world scenario presets against a shared benchmark docket. The checks count only source-backed target rows marked for validation in the calibration source matrix. Rows with synthesis source labels, missing denominators, contextual public-trust proxies, or normalized-cost construction are excluded and shown as not counted. These are external diagnostics, not fitted validation estimates.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("validation_summary.tex", "\n".join(lines))


def generate_validation_miss_interpretation() -> None:
    rows = [
        row
        for row in read_rows(VALIDATION_MISSES_CSV)
        if row["withinTarget"].lower() == "false"
    ]
    rows.sort(key=lambda row: float(row["gap"]), reverse=True)
    display_rows = rows[:8]
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Interpretation of the largest source-specific validation misses.}",
        r"\label{tab:validation-miss-interpretation}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{3pt}",
        r"\begin{tabular}{@{}p{0.24\linewidth}p{0.18\linewidth}p{0.21\linewidth}p{0.29\linewidth}@{}}",
        r"\toprule",
        r"Target & Model vs. source & Category & Interpretation and next step \\",
        r"\midrule",
    ]
    for row in display_rows:
        target = f"{row['court']}: {row['label']}"
        comparison = f"{row['modelObservedValue']} vs. {row['sourceRange']}; gap {row['gap']}"
        interpretation = f"{row['interpretation']} Next: {row['nextAction']}"
        lines.append(
            " & ".join(
                [
                    latex_escape(target),
                    latex_escape(comparison),
                    latex_escape(row["missCategory"]),
                    latex_escape(interpretation),
                ]
            )
            + r" \\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: The table reports the eight largest out-of-range source-specific diagnostics. The full generated miss report is retained in \texttt{reports/constitutional-review-validation-v1-misses.csv} and \texttt{.md}. These rows separate empirical source checks from synthetic design findings: misses are priorities for future calibration, not evidence that a country profile has been predicted incorrectly.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("validation_miss_interpretation.tex", "\n".join(lines))


def main() -> None:
    generate_baseline_results()
    generate_mechanism_results()
    generate_calibration_targets()
    generate_validation_summary()
    generate_validation_miss_interpretation()
    generate_reference_items()


if __name__ == "__main__":
    main()
