#!/usr/bin/env python3
"""Generate compact JLC-facing LaTeX tables from simulator artifacts."""

from __future__ import annotations

import csv
import random
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

ARCHITECTURE_ORDER = [
    "current-federal-court",
    "eighteen-year-terms",
    "fifteen-justice-commission",
    "supermajority-invalidation",
    "strict-recusal-court",
    "reasoned-emergency-review",
    "panel-en-banc-review",
    "dual-cross-checking-courts",
    "constitutional-council",
    "legislative-override-court",
    "accountability-retention-court",
    "independence-accountability-hybrid",
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

SCENARIO_NAMES = {
    "current-federal-court": "Current-style discretionary apex court",
    "eighteen-year-terms": "Eighteen-year terms",
    "fifteen-justice-commission": "Fifteen-justice commission",
    "supermajority-invalidation": "Supermajority invalidation rule",
    "strict-recusal-court": "Strict recusal court",
    "reasoned-emergency-review": "Reasoned emergency review",
    "panel-en-banc-review": "Panel and en banc routing",
    "dual-cross-checking-courts": "Dual cross-checking courts",
    "constitutional-council": "Constitutional council",
    "legislative-override-court": "Legislative override court",
    "accountability-retention-court": "Retention-accountability court",
    "independence-accountability-hybrid": "Independence-accountability hybrid",
    "weak-form-review": "Weak-form review",
    "suspended-declaration-review": "Suspended declaration",
    "override-clause-review": "Override clause",
    "pre-enactment-review": "Pre-enactment review",
    "abstract-review-tribunal": "Abstract review tribunal",
    "ombudsman-triggered-review": "Ombudsman-triggered review",
    "constitutional-public-defender": "Constitutional public defender",
    "rights-impact-statement-review": "Rights-impact statement",
    "mandatory-legislative-response": "Mandatory legislative response",
}

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
    ("south-africa-constcourt-recent.csv", "south-africa-constcourt-recent", "intake_acceptance_rate"),
]

VALIDATION_PROFILES = [
    ("scdb-postwar-merits-1946-2024", "us-supreme-court-benchmark", "SCDB postwar merits"),
    ("scdb-modern-merits-2000-2024", "us-supreme-court-benchmark", "SCDB modern merits"),
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


def lower_is_better(value: str | float) -> float:
    return 1.0 - float(value)


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
        r"\caption{Court-architecture stress-test results.}",
        r"\label{tab:baseline-results}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{2pt}",
        r"\begin{tabular}{@{}lL{0.26\linewidth}rrrrrrr@{}}",
        r"\toprule",
        r"Code & Architecture & Dem. const. & Rights & Emerg. irr. $\downarrow$ & Legit. proxy & Veto $\downarrow$ & Cost $\downarrow$ & Score aid \\",
        r"\midrule",
    ]
    for scenario in ARCHITECTURE_ORDER:
        row = baseline_rows[scenario]
        lines.append(
            " & ".join(
                [
                    SCENARIO_LABELS[scenario],
                    latex_escape(SCENARIO_NAMES[scenario]),
                    num(row["democraticConstitutionalism"]),
                    num(row["rightsProtection"]),
                    num(row["shadowDocketAbuse"]),
                    num(row["legitimacy"]),
                    num(row["vetoRelocationRisk"]),
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
            r"\footnotesize Notes: Values are baseline campaign estimates for court-architecture scenarios only; mechanism scenarios are separated in Table~\ref{tab:mechanism-results}. Lower emergency irregularity indicates less opaque or merits-displacing emergency intervention. The legitimacy column is a modeled public-legitimacy proxy. The score aid is the equally weighted directional display score; its 95\% run-block bootstrap interval is reported in the replication files.",
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
        r"\caption{Mechanism activation and downstream propagation effects.}",
        r"\label{tab:mechanism-results}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{2pt}",
        r"\begin{tabular}{@{}lL{0.18\linewidth}L{0.22\linewidth}rrrrrrr@{}}",
        r"\toprule",
        r"Code & Mechanism & Direct activation & Rights & Compliance & Conflict $\downarrow$ & Legit. & Cost $\downarrow$ & Veto $\downarrow$ & Dem. const. \\",
        r"\midrule",
    ]
    for scenario in MECHANISM_ORDER:
        row = baseline_rows[scenario]
        activation_parts: list[str] = []
        if float(row["weakFormDeclarationRate"]):
            activation_parts.append(f"Weak {num(row['weakFormDeclarationRate'])}")
        if float(row["suspendedDeclarationRate"]):
            activation_parts.append(f"Susp. {num(row['suspendedDeclarationRate'])}")
        if scenario == "override-clause-review":
            activation_parts.append(f"Override {num(row['overrideRate'])}")
        if float(row["ombudsmanTriggerRate"]):
            activation_parts.append(f"Omb. {num(row['ombudsmanTriggerRate'])}")
        if float(row["publicDefenderParticipationRate"]):
            activation_parts.append(f"Def. {num(row['publicDefenderParticipationRate'])}")
        if float(row["rightsImpactStatementRate"]):
            activation_parts.append(f"RIS {num(row['rightsImpactStatementRate'])}")
        if float(row["preEnactmentReviewRate"]):
            activation_parts.append(f"Pre {num(row['preEnactmentReviewRate'])}")
        if float(row["abstractReviewRate"]):
            activation_parts.append(f"Abs {num(row['abstractReviewRate'])}")
        if float(row["legislativeResponseRate"]):
            activation_parts.append(f"Resp. {num(row['legislativeResponseRate'])}")
        direct_activation = "; ".join(activation_parts) if activation_parts else "not triggered"
        lines.append(
            " & ".join(
                [
                    SCENARIO_LABELS[scenario],
                    latex_escape(SCENARIO_NAMES[scenario]),
                    latex_escape(direct_activation),
                    num(row["rightsProtection"]),
                    num(row["complianceRate"]),
                    num(row["constitutionalConflict"]),
                    num(row["legitimacy"]),
                    num(row["totalInstitutionalCost"]),
                    num(row["vetoRelocationRisk"]),
                    num(row["democraticConstitutionalism"]),
                ]
            )
            + r" \\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: Direct activation reports implementation-facing outputs; the remaining columns report downstream propagation effects. Front-end rows are bundle/routing scenarios rather than isolated toggles, so RIS, Pre, and Abs may all appear when a design routes review through multiple upstream screens. Lower conflict, cost, and veto-relocation risk are better; higher rights, compliance, legitimacy, and democratic constitutionalism are better.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("mechanism_results.tex", "\n".join(lines))


ROBUSTNESS_HIGHER_METRICS = [
    ("rightsProtection", True),
    ("democraticResponsiveness", True),
    ("legitimacy", True),
    ("legalStability", True),
    ("complianceRate", True),
    ("constitutionalConflict", False),
    ("vetoRelocationRisk", False),
    ("caseSelectionAccess", True),
    ("implementationCapacity", True),
    ("totalInstitutionalCost", False),
    ("legalTransplantFeasibility", True),
    ("politicalCultureSensitivity", False),
]


def random_weight_winners(rows: list[dict[str, str]], seed: int = 20260518, draws: int = 1000) -> tuple[dict[str, int], float]:
    rng = random.Random(seed)
    wins = {row["scenarioKey"]: 0 for row in rows}
    margins: list[float] = []
    for _ in range(draws):
        raw_weights = [rng.expovariate(1.0) for _ in ROBUSTNESS_HIGHER_METRICS]
        total_weight = sum(raw_weights)
        weights = [weight / total_weight for weight in raw_weights]
        scores: list[tuple[float, str]] = []
        for row in rows:
            score = 0.0
            for weight, (metric, higher_is_better) in zip(weights, ROBUSTNESS_HIGHER_METRICS):
                value = float(row[metric])
                score += weight * (value if higher_is_better else 1.0 - value)
            scores.append((score, row["scenarioKey"]))
        scores.sort(reverse=True)
        wins[scores[0][1]] += 1
        margins.append(scores[0][0] - scores[1][0])
    return wins, sum(margins) / len(margins)


def winner_summary(wins: dict[str, int], draws: int) -> tuple[str, str, str]:
    ranked = sorted(wins.items(), key=lambda item: item[1], reverse=True)
    leader_key, leader_wins = ranked[0]
    def pct(value: int) -> str:
        return f"{value / draws:.1%}".replace("%", r"\%")
    next_leaders = [
        f"{SCENARIO_LABELS[key]} {pct(count)}"
        for key, count in ranked[1:4]
        if count > 0
    ]
    return (
        f"{SCENARIO_LABELS[leader_key]} ({latex_escape(SCENARIO_NAMES[leader_key])})",
        pct(leader_wins),
        "; ".join(next_leaders) if next_leaders else "none",
    )


def generate_weight_robustness_results() -> None:
    draws = 1000
    baseline_rows = [
        row
        for row in read_rows(BASELINE_CSV)
        if row["caseKey"] == "baseline" and row["scenarioKey"] in set(ARCHITECTURE_ORDER + MECHANISM_ORDER)
    ]
    architecture_rows = [row for row in baseline_rows if row["scenarioKey"] in ARCHITECTURE_ORDER]
    mechanism_rows = [row for row in baseline_rows if row["scenarioKey"] in MECHANISM_ORDER]
    arch_wins, arch_margin = random_weight_winners(architecture_rows, seed=20260518, draws=draws)
    mech_wins, mech_margin = random_weight_winners(mechanism_rows, seed=20260519, draws=draws)
    arch_leader, arch_share, arch_next = winner_summary(arch_wins, draws)
    mech_leader, mech_share, mech_next = winner_summary(mech_wins, draws)
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Random-weight robustness over baseline outputs.}",
        r"\label{tab:weight-robustness}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{2pt}",
        r"\begin{tabular}{@{}L{0.13\linewidth}L{0.22\linewidth}rL{0.20\linewidth}rL{0.17\linewidth}@{}}",
        r"\toprule",
        r"Design set & Most frequent leader & Share & Next leaders & Mean margin & Reading \\",
        r"\midrule",
        f"Architectures & {arch_leader} & {arch_share} & {arch_next} & {arch_margin:.3f} & Architecture leadership is fragile under broad normative weights. \\\\",
        f"Mechanisms & {mech_leader} & {mech_share} & {mech_next} & {mech_margin:.3f} & Weak-form dominance should be tested against legislative-response assumptions. \\\\",
        r"\bottomrule",
        r"\end{tabular}",
        r"\begin{minipage}{0.96\linewidth}",
        rf"\footnotesize Notes: The table samples {draws} random normalized weight vectors over twelve outputs: rights protection, responsiveness, legitimacy, legal stability, compliance, inverse conflict, inverse veto-relocation risk, access, implementation capacity, inverse cost, transplant feasibility, and inverse political-culture sensitivity. The margins are differences between the top two designs under each sampled vector.",
        r"\end{minipage}",
        r"\end{table}",
        "",
    ]
    write("weight_robustness_results.tex", "\n".join(lines))


def profile_score(row: dict[str, str], profile: str) -> float:
    if profile == "Rights-centered":
        return (
            0.40 * float(row["rightsProtection"])
            + 0.20 * float(row["caseSelectionAccess"])
            + 0.15 * float(row["complianceRate"])
            + 0.15 * float(row["implementationCapacity"])
            + 0.10 * lower_is_better(row["vetoRelocationRisk"])
        )
    if profile == "Parliamentary-dialogue":
        return (
            0.30 * float(row["democraticResponsiveness"])
            + 0.25 * float(row["legislativeResponseCredibility"])
            + 0.15 * float(row["timelyLegislativeResponseRate"])
            + 0.15 * lower_is_better(row["vetoRelocationRisk"])
            + 0.15 * lower_is_better(row["constitutionalConflict"])
        )
    if profile == "Legal-stability":
        return (
            0.35 * float(row["legalStability"])
            + 0.25 * lower_is_better(row["constitutionalConflict"])
            + 0.20 * float(row["complianceRate"])
            + 0.10 * lower_is_better(row["reversalRate"])
            + 0.10 * lower_is_better(row["politicalCultureSensitivity"])
        )
    if profile == "Cost-minimizing":
        return (
            0.45 * lower_is_better(row["totalInstitutionalCost"])
            + 0.20 * lower_is_better(row["administrativeLoad"])
            + 0.15 * float(row["implementationCapacity"])
            + 0.10 * float(row["legalTransplantFeasibility"])
            + 0.10 * lower_is_better(row["institutionalDelayCost"])
        )
    if profile == "Anti-veto-relocation":
        return (
            0.45 * lower_is_better(row["vetoRelocationRisk"])
            + 0.20 * float(row["caseSelectionAccess"])
            + 0.15 * lower_is_better(row["governmentRepeatPlayerAdvantage"])
            + 0.10 * float(row["legitimacy"])
            + 0.10 * float(row["democraticResponsiveness"])
        )
    raise ValueError(profile)


def generate_normative_profile_results() -> None:
    baseline_rows = [
        row
        for row in read_rows(BASELINE_CSV)
        if row["caseKey"] == "baseline" and row["scenarioKey"] in set(ARCHITECTURE_ORDER + MECHANISM_ORDER)
    ]
    profile_definitions = [
        ("Rights-centered", "rights, access, compliance, implementation"),
        ("Parliamentary-dialogue", "responsiveness, response credibility, low conflict"),
        ("Legal-stability", "stability, compliance, low conflict"),
        ("Cost-minimizing", "low cost, low load, implementation capacity"),
        ("Anti-veto-relocation", "visible access with low hidden veto transfer"),
    ]
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Alternative normative-profile readings of the same baseline outputs.}",
        r"\label{tab:normative-profiles}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{3pt}",
        r"\begin{tabular}{@{}L{0.18\linewidth}L{0.24\linewidth}L{0.20\linewidth}rL{0.20\linewidth}@{}}",
        r"\toprule",
        r"Profile & Emphasis & Leading architecture & Score & Leading mechanism \\",
        r"\midrule",
    ]
    for profile, emphasis in profile_definitions:
        architectures = [row for row in baseline_rows if row["scenarioKey"] in ARCHITECTURE_ORDER]
        mechanisms = [row for row in baseline_rows if row["scenarioKey"] in MECHANISM_ORDER]
        best_arch = max(architectures, key=lambda row: profile_score(row, profile))
        best_mech = max(mechanisms, key=lambda row: profile_score(row, profile))
        lines.append(
            " & ".join(
                [
                    latex_escape(profile),
                    latex_escape(emphasis),
                    f"{SCENARIO_LABELS[best_arch['scenarioKey']]} ({latex_escape(SCENARIO_NAMES[best_arch['scenarioKey']])})",
                    f"{profile_score(best_arch, profile):.3f}",
                    f"{SCENARIO_LABELS[best_mech['scenarioKey']]} ({latex_escape(SCENARIO_NAMES[best_mech['scenarioKey']] )})",
                ]
            )
            + r" \\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: Profile scores use alternative display weights. They show that the preferred design can change when the reader prioritizes rights, dialogue, legal stability, low cost, or anti-veto-relocation. These profiles are a first-order weight-sensitivity display; the stress-case sensitivity campaign and full interval files remain in the replication package.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("normative_profile_results.tex", "\n".join(lines))


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
        r"\begin{tabular}{@{}L{0.26\linewidth}L{0.27\linewidth}rrrl@{}}",
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
            r"\footnotesize Notes: The table reports selected external calibration targets used for source-range checks. Ranges are target intervals, not estimated model effects. Source names, URLs, construction notes, and validation flags are retained in the replication materials. Contextual trust proxies and normalized cost benchmarks are excluded from fit counts unless separately source-denominated.",
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
        r"\caption{External source-range checks against documented target ranges.}",
        r"\label{tab:validation-summary}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{4pt}",
        r"\begin{tabular}{@{}L{0.22\linewidth}L{0.25\linewidth}rrL{0.27\linewidth}@{}}",
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
        if not gaps:
            continue
        median_gap = sorted(gaps)[len(gaps) // 2]
        largest = max(misses, default=(0.0, "none" if gaps else "not counted"))[1]
        in_range = f"{within}/{len(gaps)}"
        median_text = f"{median_gap:.3f}"
        lines.append(
            f"{latex_escape(label)} & {latex_escape(scenario['scenario'])} & {in_range} & {median_text} & {latex_escape(largest)} \\\\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: The source-range comparison runs stylized archetype presets against a shared benchmark docket. Counts include only source-backed target rows marked for validation in the calibration source matrix. Profiles with no counted direct targets are omitted from this main-text table and remain documented in the supplement and replication files.",
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
    display_rows = rows[:4]
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{table}[hbt!]",
        r"\centering",
        r"\caption{Calibration roadmap from the largest source-range misses.}",
        r"\label{tab:validation-miss-interpretation}",
        r"\scriptsize",
        r"\setlength{\tabcolsep}{3pt}",
        r"\begin{tabular}{@{}L{0.24\linewidth}L{0.18\linewidth}L{0.21\linewidth}L{0.29\linewidth}@{}}",
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
    if not display_rows:
        lines.append(
            r"\multicolumn{4}{@{}p{0.95\linewidth}@{}}{All currently validation-counted source-range checks fall within their documented ranges. Remaining calibration work is therefore about broadening source-backed coverage, not resolving a current out-of-range benchmark.} \\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{tabular}",
            r"\begin{minipage}{0.96\linewidth}",
            r"\footnotesize Notes: The table reports source-range misses when validation-counted checks fall outside documented ranges; when none do, it records the no-current-miss state. The full generated source-range report is retained in \texttt{reports/constitutional-review-validation-v1-misses.csv} and \texttt{.md}.",
            r"\end{minipage}",
            r"\end{table}",
            "",
        ]
    )
    write("validation_miss_interpretation.tex", "\n".join(lines))


def generate_supplement_validation_misses() -> None:
    rows = [
        row
        for row in read_rows(VALIDATION_MISSES_CSV)
        if row["withinTarget"].lower() == "false"
    ]
    rows.sort(key=lambda row: float(row["gap"]), reverse=True)
    lines = [
        "% Auto-generated by paper/scripts/generate_tables.py",
        r"\begin{longtable}{@{}L{0.20\linewidth}L{0.16\linewidth}L{0.16\linewidth}L{0.19\linewidth}L{0.10\linewidth}@{}}",
        r"\caption{Full source-range miss roadmap.}",
        r"\label{tab:supp-validation-misses}\\",
        r"\toprule",
        r"Target & Model vs. source & Category & Next action & Gap \\",
        r"\midrule",
        r"\endfirsthead",
        r"\toprule",
        r"Target & Model vs. source & Category & Next action & Gap \\",
        r"\midrule",
        r"\endhead",
    ]
    for row in rows:
        target = f"{row['court']}: {row['label']}"
        comparison = f"{row['modelObservedValue']} vs. {row['sourceRange']}"
        lines.append(
            " & ".join(
                [
                    latex_escape(target),
                    latex_escape(comparison),
                    latex_escape(row["missCategory"]),
                    latex_escape(row["nextAction"]),
                    latex_escape(row["gap"]),
                ]
            )
            + r" \\"
        )
    if not rows:
        lines.append(
            r"\multicolumn{5}{@{}p{0.86\linewidth}@{}}{No out-of-range source checks are currently reported. The empirical roadmap remains focused on expanding source-backed coverage beyond the narrow validation-counted rows.} \\"
        )
    lines.extend(
        [
            r"\bottomrule",
            r"\end{longtable}",
            "",
        ]
    )
    write("supplement_validation_misses.tex", "\n".join(lines))


def main() -> None:
    generate_baseline_results()
    generate_mechanism_results()
    generate_normative_profile_results()
    generate_weight_robustness_results()
    generate_calibration_targets()
    generate_validation_summary()
    generate_validation_miss_interpretation()
    generate_supplement_validation_misses()
    generate_reference_items()


if __name__ == "__main__":
    main()
