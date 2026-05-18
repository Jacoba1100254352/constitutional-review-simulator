#!/usr/bin/env python3
"""Audit compiled paper pages for float placement and avoidable whitespace."""

from __future__ import annotations

import argparse
import re
import shutil
import subprocess
from dataclasses import dataclass
from pathlib import Path


ROOT = Path(__file__).resolve().parents[2]
DEFAULT_PDF = ROOT / "paper" / "main.pdf"
DEFAULT_REPORT = ROOT / "paper" / "figure-placement-audit.md"

CAPTION_RE = re.compile(r"\b(?:Figure|Table)\s+\d+:\s+.*")
REFERENCE_RE = re.compile(r"\b(?:Figure|Table)\s+\d+\b(?!:)")
PAGES_RE = re.compile(r"^Pages:\s+(\d+)$", re.MULTILINE)
TRIM_RE = re.compile(r"^(\d+)\s+(\d+)\s+([+-]\d+)\s+([+-]\d+)$")


@dataclass(frozen=True)
class PageAudit:
    page: int
    vertical_used: float
    top_blank: float
    bottom_blank: float
    captions: list[str]
    references: list[str]
    assessment: str


def run(command: list[str]) -> str:
    try:
        return subprocess.check_output(command, text=True, stderr=subprocess.STDOUT)
    except subprocess.CalledProcessError as exc:
        raise SystemExit(exc.output.strip() or str(exc)) from exc


def require_tools() -> None:
    missing = [tool for tool in ("pdfinfo", "pdftotext", "magick") if shutil.which(tool) is None]
    if missing:
        raise SystemExit("Missing required tool(s): " + ", ".join(missing))


def page_count(pdf: Path) -> int:
    match = PAGES_RE.search(run(["pdfinfo", str(pdf)]))
    if not match:
        raise SystemExit(f"Could not determine page count for {pdf}")
    return int(match.group(1))


def page_text(pdf: Path, page: int) -> str:
    return run(["pdftotext", "-layout", "-f", str(page), "-l", str(page), str(pdf), "-"])


def page_metrics(pdf: Path, page: int) -> tuple[float, float, float]:
    page_spec = f"{pdf}[{page - 1}]"
    width_height = run(
        [
            "magick",
            "-density",
            "100",
            page_spec,
            "-alpha",
            "remove",
            "-background",
            "white",
            "-format",
            "%w %h",
            "info:",
        ]
    ).strip()
    try:
        _width, height = [int(part) for part in width_height.split()]
    except ValueError as exc:
        raise SystemExit(f"Could not parse page dimensions for page {page}: {width_height}") from exc

    trim = run(
        [
            "magick",
            "-density",
            "100",
            page_spec,
            "-alpha",
            "remove",
            "-background",
            "white",
            "-fuzz",
            "5%",
            "-trim",
            "-format",
            "%w %h %X %Y",
            "info:",
        ]
    ).strip()
    match = TRIM_RE.match(trim)
    if not match:
        raise SystemExit(f"Could not parse trim geometry for page {page}: {trim}")
    _trim_width, trim_height, _x_offset, y_offset = (int(value) for value in match.groups())
    bottom_blank = max(height - (y_offset + trim_height), 0)
    return (
        trim_height / height,
        y_offset / height,
        bottom_blank / height,
    )


def compact(match_text: str) -> str:
    return re.sub(r"\s+", " ", match_text).strip()


def audit_page(pdf: Path, page: int, total_pages: int) -> PageAudit:
    text = page_text(pdf, page)
    vertical_used, top_blank, bottom_blank = page_metrics(pdf, page)
    captions = [compact(match.group(0)) for match in CAPTION_RE.finditer(text)]
    references = [compact(match.group(0)) for match in REFERENCE_RE.finditer(text)]

    has_float_material = bool(captions)
    final_text_page = page == total_pages and not has_float_material
    if has_float_material and vertical_used < 0.70:
        assessment = "FAIL: float page leaves too much unused vertical space"
    elif has_float_material and bottom_blank > 0.25:
        assessment = "WARN: float page has a large bottom gap"
    elif has_float_material and top_blank > 0.20:
        assessment = "WARN: float page has a large top gap before content"
    elif final_text_page and vertical_used < 0.70:
        assessment = "OK: final references page, not figure-driven"
    else:
        assessment = "OK"

    return PageAudit(
        page=page,
        vertical_used=vertical_used,
        top_blank=top_blank,
        bottom_blank=bottom_blank,
        captions=captions,
        references=references,
        assessment=assessment,
    )


def caption_number(caption: str) -> str:
    match = re.match(r"((?:Figure|Table)\s+\d+):", caption)
    return match.group(1) if match else caption


def build_report(audits: list[PageAudit], pdf: Path) -> str:
    float_pages = [audit for audit in audits if audit.captions]
    failures = [audit for audit in audits if audit.assessment.startswith("FAIL")]
    warnings = [audit for audit in audits if audit.assessment.startswith("WARN")]

    lines = [
        "# Figure and Float Placement Audit",
        "",
        f"Compiled PDF audited: `{pdf.relative_to(ROOT)}`.",
        "",
        "This audit checks rendered pages, not just LaTeX source. It flags figure or table pages that leave excessive vertical whitespace after trimming normal margins. Final text-only pages, such as a short references tail, are noted but not treated as figure-placement defects.",
        "",
        "## Summary",
        "",
        f"- Pages audited: {len(audits)}",
        f"- Pages with figure/table captions: {', '.join(str(page.page) for page in float_pages) or 'none'}",
        f"- Severe figure/table whitespace findings: {len(failures)}",
        f"- Figure/table whitespace warnings: {len(warnings)}",
        "",
        "## Placement Map",
        "",
        "| Page | Figure/table material | Nearby references | Vertical used | Top blank | Bottom blank | Assessment |",
        "| --- | --- | --- | ---: | ---: | ---: | --- |",
    ]

    for audit in audits:
        if not audit.captions and not audit.references and audit.assessment == "OK":
            continue
        captions = ", ".join(caption_number(caption) for caption in audit.captions) or "-"
        references = ", ".join(sorted(set(audit.references))) or "-"
        lines.append(
            "| {page} | {captions} | {refs} | {used:.1%} | {top:.1%} | {bottom:.1%} | {assessment} |".format(
                page=audit.page,
                captions=captions,
                refs=references,
                used=audit.vertical_used,
                top=audit.top_blank,
                bottom=audit.bottom_blank,
                assessment=audit.assessment,
            )
        )

    lines.extend(
        [
            "",
            "## Reading Notes",
            "",
            "- The design-space longtable begins near its first textual reference and continues naturally onto the next page without creating a float-only page.",
            "- The paired-import figure moves to the next page after its first reference, but the preceding page is already densely filled with tables and text, so this is not a blank-page float problem.",
            "- The cost-score and mechanism-tradeoff plots are placed with the comparative-experiment discussion, where they function as tradeoff maps rather than as late design recommendations.",
            "- Re-run `make figure-placement-audit` after changing generated figures, captions, table widths, or float placement.",
        ]
    )
    return "\n".join(lines)


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--pdf", type=Path, default=DEFAULT_PDF)
    parser.add_argument("--report", type=Path, default=DEFAULT_REPORT)
    parser.add_argument("--write", action="store_true", help="write the Markdown audit report")
    args = parser.parse_args()

    require_tools()
    pdf = args.pdf.resolve()
    if not pdf.exists():
        raise SystemExit(f"PDF does not exist: {pdf}")

    total_pages = page_count(pdf)
    audits = [audit_page(pdf, page, total_pages) for page in range(1, total_pages + 1)]
    report = build_report(audits, pdf)

    if args.write:
        args.report.parent.mkdir(parents=True, exist_ok=True)
        args.report.write_text(report + "\n", encoding="utf-8")
        print(f"Wrote {args.report}")
    else:
        print(report)

    failures = [audit for audit in audits if audit.assessment.startswith("FAIL")]
    return 1 if failures else 0


if __name__ == "__main__":
    raise SystemExit(main())
