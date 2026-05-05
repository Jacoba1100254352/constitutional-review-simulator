#!/usr/bin/env python3
"""Check the manuscript for the repository's JLC submission conventions."""

from __future__ import annotations

import re
import sys
from pathlib import Path

from word_count import WORD_LIMIT, count_words


ROOT = Path(__file__).resolve().parents[2]
PAPER_DIR = ROOT / "paper"
MAIN_TEX = PAPER_DIR / "main.tex"
SUPPLEMENT_TEX = PAPER_DIR / "supplementary-appendix.tex"
ACCESSIBILITY = PAPER_DIR / "accessibility-descriptions.md"
REFERENCES_BIB = PAPER_DIR / "references.bib"
VALIDATION_TABLE = PAPER_DIR / "tables" / "validation_summary.tex"

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


def expanded_tex(path: Path, seen: set[Path] | None = None) -> str:
    seen = seen or set()
    if path in seen:
        return ""
    seen.add(path)
    text = path.read_text(encoding="utf-8")

    def replace_input(match: re.Match[str]) -> str:
        raw = match.group(1)
        input_path = PAPER_DIR / (raw if raw.endswith(".tex") else f"{raw}.tex")
        if not input_path.exists():
            return match.group(0)
        return expanded_tex(input_path, seen)

    return re.sub(r"\\input\{([^}]+)\}", replace_input, text)


def main() -> None:
    tex = MAIN_TEX.read_text(encoding="utf-8")
    expanded = expanded_tex(MAIN_TEX)
    supplement_expanded = expanded_tex(SUPPLEMENT_TEX) if SUPPLEMENT_TEX.exists() else ""
    accessibility = ACCESSIBILITY.read_text(encoding="utf-8")
    references = REFERENCES_BIB.read_text(encoding="utf-8")
    validation_table = VALIDATION_TABLE.read_text(encoding="utf-8") if VALIDATION_TABLE.exists() else ""

    if r"\documentclass[" not in tex or "]{cup-journal}" not in tex:
        fail("main.tex should keep the cup-journal document-class interface.")

    if r"\author{Anonymous Author}" not in tex:
        fail("main.tex should remain anonymous for review.")

    if r"\usepackage[authoryear,round]{natbib}" not in tex:
        fail("main.tex should keep author-date natbib citations for JLC review.")

    if r"\bibliographystyle{plainnat}" in tex or r"\bibliography{references}" in tex:
        fail("main.tex should not use plainnat output for the JLC submission draft.")

    bibliography_index = tex.find(r"\begin{thebibliography}")
    if bibliography_index < 0:
        fail("main.tex must include a Chicago-style reference list at the end of the manuscript.")

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

    if "Directional score construction" not in tex:
        fail("main.tex must explain the directional score construction.")

    if "OpenAI ChatGPT Deep Research" not in tex or "OpenAI Codex" not in tex or "GPT-5" not in tex:
        fail("AI Tools Declaration should identify the tools and model/interface family used.")

    for expected in [
            "U.S. Supreme Court",
            "U.S. emergency docket",
            "Germany BVerfG",
            "Canada SCC",
            "France Conseil",
            "South Africa ConstCourt",
    ]:
        if expected not in validation_table:
            fail(f"validation summary table is missing expected profile: {expected}")
    if "not fitted validation estimates" not in validation_table:
        fail("validation table should state that checks are not fitted validation estimates.")

    all_expanded = expanded + "\n" + supplement_expanded
    figure_labels = label_set(r"\\label\{(fig:[^}]+)\}", all_expanded)
    table_labels = label_set(r"\\label\{(tab:[^}]+)\}", all_expanded)
    if not figure_labels:
        fail("expected at least one figure label.")
    if not table_labels:
        fail("expected at least one table label.")

    missing = sorted(label for label in figure_labels | table_labels if f"`{label}`" not in accessibility)
    if missing:
        fail("missing accessibility descriptions for " + ", ".join(missing))

    for environment in ["figure", "table", "longtable"]:
        starts = len(re.findall(rf"\\begin\{{{environment}\}}", all_expanded))
        captions = len(re.findall(rf"\\begin\{{{environment}\}}.*?\\caption", all_expanded, flags=re.S))
        if starts and captions < starts:
            fail(f"each {environment} environment should include a caption.")

    citation_keys: set[str] = set()
    for match in re.findall(r"\\cite\w*(?:\[[^]]*\])?\{([^}]+)\}", tex):
        citation_keys.update(key.strip() for key in match.split(",") if key.strip())
    bib_keys = set(re.findall(r"@\w+\{([^,]+),", references))
    missing_keys = sorted(citation_keys - bib_keys)
    uncited_keys = sorted(bib_keys - citation_keys)
    if missing_keys:
        fail("missing BibTeX entries for " + ", ".join(missing_keys))
    if uncited_keys:
        fail("references.bib contains uncited entries: " + ", ".join(uncited_keys))

    leaked_path_files = [
        ROOT / "Makefile",
        ROOT / "README.md",
        ROOT / "AGENTS.md",
        *sorted((ROOT / "reports").glob("*manifest.json")),
        MAIN_TEX,
    ]
    local_home_marker = "/" + "Users/"
    leaking = [path for path in leaked_path_files if local_home_marker in path.read_text(encoding="utf-8")]
    if leaking:
        fail("local absolute path found in " + ", ".join(str(path.relative_to(ROOT)) for path in leaking))

    words = count_words(tex)
    if words > WORD_LIMIT:
        fail(f"word count {words} exceeds JLC's ordinary {WORD_LIMIT}-word ceiling.")

    print("JLC format check passed.")


if __name__ == "__main__":
    main()
