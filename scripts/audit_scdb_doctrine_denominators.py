#!/usr/bin/env python3
"""Audit SCDB doctrine-mix source rows against the official case-centered CSV."""

from __future__ import annotations

import argparse
import csv
import io
import re
import sys
import zipfile
from html.parser import HTMLParser
from pathlib import Path
from urllib.parse import urljoin
from urllib.request import urlopen


ROOT = Path(__file__).resolve().parents[1]
SOURCE_PATH = ROOT / "config" / "calibration-source-observations.csv"
REPORT_PATH = ROOT / "reports" / "constitutional-review-scdb-doctrine-denominator-audit.csv"
SCDB_RELEASE_URL = "https://scdb.la.psu.edu/data/2025-release-01/"
MATCH_TOLERANCE = 0.002

SOURCE_HEADER = [
    "targetFile",
    "profileKey",
    "court",
    "timePeriod",
    "targetKey",
    "label",
    "lowerBound",
    "upperBound",
    "observedValue",
    "n",
    "unit",
    "method",
    "reliability",
    "useForValidation",
    "note",
    "sourceName",
    "sourceUrl",
    "constructionNote",
]

REPORT_HEADER = [
    "profileKey",
    "targetFile",
    "timePeriod",
    "targetKey",
    "label",
    "currentObservedValue",
    "auditedObservedValue",
    "currentDenominator",
    "auditedDenominator",
    "auditedNumerator",
    "sourceRange",
    "unit",
    "sourceUrl",
    "auditSourceUrl",
    "auditStatus",
    "promotionRecommendation",
    "constructionNote",
]

ELECTION_ISSUES = {"20010", "20020", "20030", "20090", "30140"}
TARGET_PREDICATES = {
    "doctrine_mix.speech": (
        "issueArea=3",
        lambda row: row["issueArea"] == "3",
    ),
    "doctrine_mix.equality": (
        "issueArea in {2,5} excluding election-law issue codes 20010, 20020, 20030, 20090, 30140",
        lambda row: row["issueArea"] in {"2", "5"} and row["issue"] not in ELECTION_ISSUES,
    ),
    "doctrine_mix.criminal_procedure": (
        "issueArea=1",
        lambda row: row["issueArea"] == "1",
    ),
    "doctrine_mix.federalism": (
        "issueArea in {10,11}",
        lambda row: row["issueArea"] in {"10", "11"},
    ),
    "doctrine_mix.election_law": (
        "issue in {20010,20020,20030,20090,30140}",
        lambda row: row["issue"] in ELECTION_ISSUES,
    ),
    "doctrine_mix.emergency_powers": (
        "issue=130015",
        lambda row: row["issue"] == "130015",
    ),
    "doctrine_mix.administrative_state": (
        "issueArea=8 or issue=90120",
        lambda row: row["issueArea"] == "8" or row["issue"] == "90120",
    ),
}


class LinkCollector(HTMLParser):
    def __init__(self) -> None:
        super().__init__()
        self.links: list[tuple[str, str]] = []
        self._href: str | None = None
        self._parts: list[str] = []

    def handle_starttag(self, tag: str, attrs: list[tuple[str, str | None]]) -> None:
        if tag != "a":
            return
        attrs_by_name = {name: value for name, value in attrs}
        href = attrs_by_name.get("href")
        if href:
            self._href = href
            self._parts = []

    def handle_data(self, data: str) -> None:
        if self._href is not None:
            self._parts.append(data)

    def handle_endtag(self, tag: str) -> None:
        if tag != "a" or self._href is None:
            return
        text = " ".join(part.strip() for part in self._parts if part.strip())
        self.links.append((self._href, text))
        self._href = None
        self._parts = []


def read_source_rows() -> list[dict[str, str]]:
    with SOURCE_PATH.open(newline="", encoding="utf-8") as handle:
        reader = csv.DictReader(handle)
        if reader.fieldnames != SOURCE_HEADER:
            expected = ", ".join(SOURCE_HEADER)
            actual = ", ".join(reader.fieldnames or [])
            raise SystemExit(f"calibration source header mismatch; expected {expected}; got {actual}")
        return list(reader)


def release_zip_url() -> str:
    with urlopen(SCDB_RELEASE_URL, timeout=30) as response:
        html = response.read().decode("utf-8", errors="replace")
    parser = LinkCollector()
    parser.feed(html)
    for href, text in parser.links:
        normalized = " ".join(text.lower().split())
        if "download csv organized by supreme court citation" in normalized:
            return urljoin(SCDB_RELEASE_URL, href)
    raise SystemExit("could not find SCDB case-centered citation CSV link on release page")


def read_scdb_rows(zip_path: Path | None) -> list[dict[str, str]]:
    if zip_path is None:
        with urlopen(release_zip_url(), timeout=60) as response:
            data = response.read()
    else:
        data = zip_path.read_bytes()
    with zipfile.ZipFile(io.BytesIO(data)) as archive:
        csv_names = [name for name in archive.namelist() if name.lower().endswith(".csv")]
        if len(csv_names) != 1:
            raise SystemExit(f"expected one CSV in SCDB ZIP; found {csv_names}")
        with archive.open(csv_names[0]) as raw:
            text = io.TextIOWrapper(raw, encoding="utf-8-sig", newline="")
            return list(csv.DictReader(text))


def period_bounds(time_period: str) -> tuple[int, int]:
    match = re.search(r"(\d{4})-(\d{4})", time_period)
    if not match:
        raise ValueError(f"could not parse SCDB term period from {time_period!r}")
    return int(match.group(1)), int(match.group(2))


def doctrine_source_rows(rows: list[dict[str, str]]) -> list[dict[str, str]]:
    return [
        row
        for row in rows
        if row["profileKey"].startswith("scdb-") and row["targetKey"].startswith("doctrine_mix.")
    ]


def audit_rows(source_rows: list[dict[str, str]], scdb_rows: list[dict[str, str]]) -> list[dict[str, str]]:
    output: list[dict[str, str]] = []
    for source_row in doctrine_source_rows(source_rows):
        target_key = source_row["targetKey"]
        if target_key not in TARGET_PREDICATES:
            raise SystemExit(f"unsupported doctrine target key {target_key!r}")
        start, end = period_bounds(source_row["timePeriod"])
        period_rows = [row for row in scdb_rows if start <= int(row["term"]) <= end]
        denominator = len(period_rows)
        rule_label, predicate = TARGET_PREDICATES[target_key]
        numerator = sum(1 for row in period_rows if predicate(row))
        observed = numerator / denominator if denominator else 0.0
        current_observed = float(source_row["observedValue"])
        value_matches = abs(current_observed - observed) <= MATCH_TOLERANCE
        current_denominator = source_row["n"].strip()
        denominator_missing = not current_denominator or current_denominator == "0"
        denominator_matches = current_denominator == str(denominator)
        if value_matches and denominator_missing:
            audit_status = "denominator-ready"
            recommendation = (
                "fill denominator and construction note; promote only if doctrine-mix source-range misses "
                "are accepted as model-calibration evidence"
            )
        elif value_matches and denominator_matches:
            audit_status = "matches-current-row"
            recommendation = "keep denominator and construction note synchronized with SCDB release"
        elif value_matches:
            audit_status = "denominator-mismatch"
            recommendation = "update stored denominator and construction note before validation promotion"
        else:
            audit_status = "value-mismatch"
            recommendation = "update observed value or coding rule before any validation promotion"
        output.append(
            {
                "profileKey": source_row["profileKey"],
                "targetFile": source_row["targetFile"],
                "timePeriod": source_row["timePeriod"],
                "targetKey": target_key,
                "label": source_row["label"],
                "currentObservedValue": source_row["observedValue"],
                "auditedObservedValue": f"{observed:.4f}",
                "currentDenominator": source_row["n"],
                "auditedDenominator": str(denominator),
                "auditedNumerator": str(numerator),
                "sourceRange": f"{source_row['lowerBound']}--{source_row['upperBound']}",
                "unit": source_row["unit"],
                "sourceUrl": source_row["sourceUrl"],
                "auditSourceUrl": SCDB_RELEASE_URL,
                "auditStatus": audit_status,
                "promotionRecommendation": recommendation,
                "constructionNote": (
                    f"Audited from SCDB 2025 Release 01 case-centered Supreme Court Citation CSV: "
                    f"{numerator} cases matching {rule_label} divided by {denominator} case-centered "
                    f"citation rows in {start}-{end} terms."
                ),
            }
        )
    return output


def csv_text(rows: list[dict[str, str]]) -> str:
    buffer = io.StringIO()
    writer = csv.DictWriter(buffer, fieldnames=REPORT_HEADER, lineterminator="\n")
    writer.writeheader()
    for row in rows:
        writer.writerow(row)
    return buffer.getvalue()


def write_source_rows(rows: list[dict[str, str]]) -> None:
    buffer = io.StringIO()
    writer = csv.DictWriter(buffer, fieldnames=SOURCE_HEADER, lineterminator="\n")
    writer.writeheader()
    for row in rows:
        writer.writerow(row)
    SOURCE_PATH.write_text(buffer.getvalue(), encoding="utf-8")


def source_key(row: dict[str, str]) -> tuple[str, str, str, str]:
    return row["profileKey"], row["targetFile"], row["timePeriod"], row["targetKey"]


def require_audited_value_in_range(source_row: dict[str, str], audited_row: dict[str, str]) -> None:
    audited_value = float(audited_row["auditedObservedValue"])
    lower = float(source_row["lowerBound"])
    upper = float(source_row["upperBound"])
    if not lower <= audited_value <= upper:
        key = " / ".join(source_key(source_row))
        raise SystemExit(
            f"audited SCDB value {audited_value:.4f} is outside existing range "
            f"{lower:.4f}--{upper:.4f} for {key}; update the range deliberately before applying"
        )


def apply_ready_denominators(
        source_rows: list[dict[str, str]],
        audited_rows: list[dict[str, str]],
) -> tuple[list[dict[str, str]], int]:
    audited_by_key = {source_key(row): row for row in audited_rows}
    changed = 0
    output: list[dict[str, str]] = []
    for source_row in source_rows:
        row = dict(source_row)
        audited_row = audited_by_key.get(source_key(source_row))
        if audited_row is not None and audited_row["auditStatus"] != "value-mismatch":
            new_denominator = audited_row["auditedDenominator"]
            new_note = audited_row["constructionNote"]
            if row["n"] != new_denominator or row["constructionNote"] != new_note:
                row["n"] = new_denominator
                row["constructionNote"] = new_note
                changed += 1
        output.append(row)
    return output, changed


def apply_audited_values(
        source_rows: list[dict[str, str]],
        audited_rows: list[dict[str, str]],
) -> tuple[list[dict[str, str]], int]:
    audited_by_key = {source_key(row): row for row in audited_rows}
    changed = 0
    output: list[dict[str, str]] = []
    for source_row in source_rows:
        row = dict(source_row)
        audited_row = audited_by_key.get(source_key(source_row))
        if audited_row is not None:
            require_audited_value_in_range(source_row, audited_row)
            new_observed = audited_row["auditedObservedValue"]
            new_denominator = audited_row["auditedDenominator"]
            new_note = audited_row["constructionNote"]
            if (
                    row["observedValue"] != new_observed
                    or row["n"] != new_denominator
                    or row["constructionNote"] != new_note
            ):
                row["observedValue"] = new_observed
                row["n"] = new_denominator
                row["constructionNote"] = new_note
                changed += 1
        output.append(row)
    return output, changed


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--zip", type=Path, help="use a local SCDB ZIP instead of downloading the release")
    parser.add_argument("--write", action="store_true", help="rewrite the checked-in audit report")
    parser.add_argument("--check", action="store_true", help="fail if the checked-in audit report is out of date")
    parser.add_argument(
        "--apply-ready-denominators",
        action="store_true",
        help=(
            "fill source-matrix denominators and construction notes for rows whose current observed values "
            "match the SCDB audit; mismatched rows and validation-use flags are left unchanged"
        ),
    )
    parser.add_argument(
        "--apply-audited-values",
        action="store_true",
        help=(
            "fill source-matrix observed values, denominators, and construction notes from the SCDB audit "
            "when audited values remain inside existing source ranges; validation-use flags are left unchanged"
        ),
    )
    args = parser.parse_args()
    if args.apply_ready_denominators and args.apply_audited_values:
        raise SystemExit("--apply-ready-denominators and --apply-audited-values are separate update modes")

    source_rows = read_source_rows()
    scdb_rows = read_scdb_rows(args.zip)
    audited_rows = audit_rows(source_rows, scdb_rows)
    if args.apply_ready_denominators:
        source_rows, changed = apply_ready_denominators(source_rows, audited_rows)
        if changed:
            write_source_rows(source_rows)
        audited_rows = audit_rows(source_rows, scdb_rows)
    if args.apply_audited_values:
        source_rows, changed = apply_audited_values(source_rows, audited_rows)
        if changed:
            write_source_rows(source_rows)
        audited_rows = audit_rows(source_rows, scdb_rows)

    expected = csv_text(audited_rows)
    if args.write or args.apply_ready_denominators or args.apply_audited_values:
        REPORT_PATH.parent.mkdir(parents=True, exist_ok=True)
        REPORT_PATH.write_text(expected, encoding="utf-8")
    if args.check or not args.write:
        actual = REPORT_PATH.read_text(encoding="utf-8") if REPORT_PATH.exists() else ""
        if actual != expected:
            print(f"SCDB doctrine denominator audit out of date: {REPORT_PATH.relative_to(ROOT)}", file=sys.stderr)
            return 1
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
