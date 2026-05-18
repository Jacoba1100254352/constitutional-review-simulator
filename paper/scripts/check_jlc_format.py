#!/usr/bin/env python3
"""Check the manuscript for the repository's JLC submission conventions."""

from __future__ import annotations

import re
import subprocess
import sys
import tempfile
from pathlib import Path

from word_count import WORD_LIMIT, count_words


ROOT = Path(__file__).resolve().parents[2]
PAPER_DIR = ROOT / "paper"
MAIN_TEX = PAPER_DIR / "constitutional-review-design-stress-test.tex"
SUPPLEMENT_TEX = PAPER_DIR / "supplementary-appendix.tex"
ACCESSIBILITY = PAPER_DIR / "accessibility-descriptions.md"
REFERENCES_BIB = PAPER_DIR / "references.bib"
VALIDATION_TABLE = PAPER_DIR / "tables" / "validation_summary.tex"
VALIDATION_MISS_TABLE = PAPER_DIR / "tables" / "validation_miss_interpretation.tex"
SCENARIO_POINT_LABELS = {
    "CUR*",
    "18Y",
    "15J",
    "SUP",
    "REC",
    "EMR",
    "PAN",
    "DUAL",
    "COUNC",
    "OVR",
    "RET",
    "HYB",
    "WFR",
    "SUS",
    "OVC",
    "PRE",
    "ABS",
    "OMB",
    "DEF",
    "RIS",
    "MLR",
}

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


def figure_label_boxes(path: Path) -> list[tuple[str, float, float, float, float]]:
    source = path.read_text(encoding="utf-8")
    picture = re.search(r"\\begin\{picture\}\(([\d.]+),([\d.]+)\)", source)
    if not picture:
        return []
    width = float(picture.group(1))
    height = float(picture.group(2))
    boxes: list[tuple[str, float, float, float, float]] = []
    label_pattern = re.compile(
        r"\\put\(([-\d.]+),([-\d.]+)\)\{\\makebox\(0,0\)(?:\[(\w)\])?\{(?:\\color\{[^}]+\})?([^{}]+)\}\}"
    )
    for match in label_pattern.finditer(source):
        label = match.group(4).strip()
        if label not in SCENARIO_POINT_LABELS:
            continue
        x = float(match.group(1))
        y = float(match.group(2))
        align = match.group(3) or "c"
        label_width = max(3.2, len(label) * 1.55)
        label_height = 3.4
        if align == "l":
            left, right = x, x + label_width
        elif align == "r":
            left, right = x - label_width, x
        else:
            left, right = x - (label_width / 2.0), x + (label_width / 2.0)
        bottom, top = y - (label_height / 2.0), y + (label_height / 2.0)
        if left < 0.0 or right > width or bottom < 0.0 or top > height:
            fail(f"{path.relative_to(PAPER_DIR)} has clipped point label {label}")
        boxes.append((label, left, bottom, right, top))
    return boxes


def validate_figure_point_labels() -> None:
    for path in sorted((PAPER_DIR / "figures").glob("*.tex")):
        boxes = figure_label_boxes(path)
        for index, current in enumerate(boxes):
            current_label, left, bottom, right, top = current
            for other_label, other_left, other_bottom, other_right, other_top in boxes[index + 1:]:
                horizontal = min(right, other_right) - max(left, other_left)
                vertical = min(top, other_top) - max(bottom, other_bottom)
                if horizontal > 0.25 and vertical > 0.25:
                    fail(
                        f"{path.relative_to(PAPER_DIR)} has overlapping point labels "
                        f"{current_label} and {other_label}"
                    )
        validate_rendered_figure_labels(path)


def validate_rendered_figure_labels(path: Path) -> None:
    source = path.read_text(encoding="utf-8")
    if not any(label in source for label in SCENARIO_POINT_LABELS):
        return
    with tempfile.TemporaryDirectory(prefix="jlc-figure-check-") as temp_raw:
        temp = Path(temp_raw)
        fragment = temp / "fragment.tex"
        fragment.write_text(source, encoding="utf-8")
        document = temp / "figure-check.tex"
        document.write_text(
            "\n".join(
                [
                    r"\documentclass{article}",
                    r"\usepackage{xcolor}",
                    r"\usepackage{graphicx}",
                    r"\pagestyle{empty}",
                    r"\begin{document}",
                    r"\input{fragment.tex}",
                    r"\end{document}",
                    "",
                ]
            ),
            encoding="utf-8",
        )
        subprocess.run(
            [
                "latexmk",
                "-pdf",
                "-interaction=nonstopmode",
                "-halt-on-error",
                "figure-check.tex",
            ],
            cwd=temp,
            stdout=subprocess.DEVNULL,
            stderr=subprocess.DEVNULL,
            check=True,
        )
        bbox = subprocess.run(
            ["pdftotext", "-bbox", "figure-check.pdf", "-"],
            cwd=temp,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
            text=True,
            check=True,
        ).stdout
    page_match = re.search(r"<page[^>]*width=\"([\d.]+)\"[^>]*height=\"([\d.]+)\"", bbox)
    if not page_match:
        fail(f"could not inspect rendered figure labels for {path.relative_to(PAPER_DIR)}")
    page_width = float(page_match.group(1))
    page_height = float(page_match.group(2))
    rendered_boxes: list[tuple[str, float, float, float, float]] = []
    word_pattern = re.compile(
        r"<word[^>]*xMin=\"([\d.]+)\"[^>]*yMin=\"([\d.]+)\"[^>]*xMax=\"([\d.]+)\"[^>]*yMax=\"([\d.]+)\"[^>]*>([^<]+)</word>"
    )
    for match in word_pattern.finditer(bbox):
        text = (
            match.group(5)
            .replace("&amp;", "&")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
        )
        if text not in SCENARIO_POINT_LABELS:
            continue
        left, top, right, bottom = map(float, match.groups()[:4])
        if left < 0.5 or top < 0.5 or right > page_width - 0.5 or bottom > page_height - 0.5:
            fail(f"{path.relative_to(PAPER_DIR)} has clipped rendered point label {text}")
        rendered_boxes.append((text, left, top, right, bottom))
    expected_labels = {label for label in SCENARIO_POINT_LABELS if label in source}
    rendered_labels = {label for label, *_ in rendered_boxes}
    missing = expected_labels - rendered_labels
    if missing:
        fail(f"{path.relative_to(PAPER_DIR)} missing rendered point labels: {', '.join(sorted(missing))}")
    for index, current in enumerate(rendered_boxes):
        current_label, left, top, right, bottom = current
        for other_label, other_left, other_top, other_right, other_bottom in rendered_boxes[index + 1:]:
            horizontal = min(right, other_right) - max(left, other_left)
            vertical = min(bottom, other_bottom) - max(top, other_top)
            if horizontal > 0.5 and vertical > 0.5:
                fail(
                    f"{path.relative_to(PAPER_DIR)} has overlapping rendered point labels "
                    f"{current_label} and {other_label}"
                )


def main() -> None:
    tex = MAIN_TEX.read_text(encoding="utf-8")
    expanded = expanded_tex(MAIN_TEX)
    supplement_expanded = expanded_tex(SUPPLEMENT_TEX) if SUPPLEMENT_TEX.exists() else ""
    accessibility = ACCESSIBILITY.read_text(encoding="utf-8")
    references = REFERENCES_BIB.read_text(encoding="utf-8")
    validation_table = VALIDATION_TABLE.read_text(encoding="utf-8") if VALIDATION_TABLE.exists() else ""
    validation_miss_table = VALIDATION_MISS_TABLE.read_text(encoding="utf-8") if VALIDATION_MISS_TABLE.exists() else ""

    if r"\documentclass[" not in tex or "]{cup-journal}" not in tex:
        fail("manuscript source should keep the cup-journal document-class interface.")

    if r"\author{Anonymous Author}" not in tex:
        fail("manuscript source should remain anonymous for review.")

    if r"\usepackage[authoryear,round]{natbib}" not in tex:
        fail("manuscript source should keep author-date natbib citations for JLC review.")

    if r"\bibliographystyle{plainnat}" in tex or r"\bibliography{references}" in tex:
        fail("manuscript source should not use plainnat output for the JLC submission draft.")

    bibliography_index = tex.find(r"\begin{thebibliography}")
    if bibliography_index < 0:
        fail("manuscript source must include a Chicago-style reference list at the end of the manuscript.")

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
        fail("manuscript source must explain the directional score construction.")
    if "score differences below about one percentage point should be treated as tied" not in tex:
        fail("manuscript source must warn that close directional-score differences are not meaningful.")
    if "What the diagnostics still miss" not in tex:
        fail("manuscript source must include a diagnostic-misses subsection.")
    if "case-selection-access proxy" not in tex:
        fail("manuscript source must flag case-selection-access proxy limitations.")

    if "OpenAI ChatGPT Deep Research" not in tex or "OpenAI Codex" not in tex or "GPT-5" not in tex:
        fail("AI Tools Declaration should identify the tools and model/interface family used.")
    for required_ai_detail in [
            "May 1--9, 2026",
            "ChatGPT web interface",
            "Codex desktop interface",
            "not expose a more specific model version",
            "not trained, fine-tuned, or otherwise modified",
    ]:
        if required_ai_detail not in tex:
            fail(f"AI Tools Declaration is missing required detail: {required_ai_detail}")
    if "AI outputs were not treated as sources" not in tex:
        fail("AI Tools Declaration should state how AI outputs were handled.")

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
    for expected in [
            "intake denominator alignment",
            "emergency-procedure calibration",
            "weak-form response mechanism",
            "case-selection access proxy",
            "not evidence that a country profile has been predicted incorrectly",
    ]:
        if expected not in validation_miss_table:
            fail(f"validation miss table is missing required interpretive language: {expected}")
    if "tab:supp-model-crosswalk" not in supplement_expanded:
        fail("supplement must include the model-to-code crosswalk table.")

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
    bibitem_keys = set(re.findall(r"\\bibitem(?:\[[^]]+\])?\{([^}]+)\}", expanded))
    missing_keys = sorted(citation_keys - bib_keys)
    uncited_keys = sorted(bib_keys - citation_keys)
    missing_bibitems = sorted(citation_keys - bibitem_keys)
    extra_bibitems = sorted(bibitem_keys - citation_keys)
    if missing_keys:
        fail("missing BibTeX entries for " + ", ".join(missing_keys))
    if uncited_keys:
        fail("references.bib contains uncited entries: " + ", ".join(uncited_keys))
    if missing_bibitems:
        fail("compiled reference list is missing cited keys: " + ", ".join(missing_bibitems))
    if extra_bibitems:
        fail("compiled reference list contains uncited keys: " + ", ".join(extra_bibitems))

    validate_figure_point_labels()

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
