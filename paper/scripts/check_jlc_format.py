#!/usr/bin/env python3
"""Check the manuscript for the repository's JLC submission conventions."""

from __future__ import annotations

import re
import sys
from pathlib import Path


ROOT = Path(__file__).resolve().parents[2]
PAPER_DIR = ROOT / "paper"
MAIN_TEX = PAPER_DIR / "main.tex"
ACCESSIBILITY = PAPER_DIR / "accessibility-descriptions.md"

REQUIRED_BACK_MATTER = [
    "Supplementary Material",
    "Funding Declaration",
    "Competing Interests Declaration",
    "Data Availability Statement",
    "Ethical Statement",
    "AI Tools Declaration",
]


def fail(message: str) -> None:
    print(f"JLC format check failed: {message}", file=sys.stderr)
    raise SystemExit(1)


def label_set(pattern: str, source: str) -> set[str]:
    return set(re.findall(pattern, source))


def main() -> None:
    tex = MAIN_TEX.read_text(encoding="utf-8")
    accessibility = ACCESSIBILITY.read_text(encoding="utf-8")

    if r"\documentclass[" not in tex or "]{cup-journal}" not in tex:
        fail("main.tex should keep the cup-journal document-class interface.")

    if r"\author{Anonymous Author}" not in tex:
        fail("main.tex should remain anonymous for review.")

    if r"\usepackage[authoryear,round]{natbib}" not in tex:
        fail("main.tex should keep author-date natbib citations for JLC review.")

    bibliography_index = tex.find(r"\bibliography{references}")
    if bibliography_index < 0:
        fail("main.tex must include the bibliography at the end of the manuscript.")

    for heading in REQUIRED_BACK_MATTER:
        marker = rf"\section*{{{heading}}}"
        index = tex.find(marker)
        if index < 0:
            fail(f"missing required back-matter heading: {heading}")
        if index > bibliography_index:
            fail(f"{heading} must appear before the reference list.")

    appendix_index = tex.find(r"\appendix")
    if appendix_index >= 0 and appendix_index > bibliography_index:
        fail("appendices should not appear after the reference list in the main manuscript.")

    figure_labels = label_set(r"\\label\{(fig:[^}]+)\}", tex)
    table_labels = label_set(r"\\label\{(tab:[^}]+)\}", tex)
    if not figure_labels:
        fail("expected at least one figure label.")
    if not table_labels:
        fail("expected at least one table label.")

    missing = sorted(label for label in figure_labels | table_labels if f"`{label}`" not in accessibility)
    if missing:
        fail("missing accessibility descriptions for " + ", ".join(missing))

    for environment in ["figure", "table", "longtable"]:
        starts = len(re.findall(rf"\\begin\{{{environment}\}}", tex))
        captions = len(re.findall(rf"\\begin\{{{environment}\}}.*?\\caption", tex, flags=re.S))
        if starts and captions < starts:
            fail(f"each {environment} environment should include a caption.")

    print("JLC format check passed.")


if __name__ == "__main__":
    main()
