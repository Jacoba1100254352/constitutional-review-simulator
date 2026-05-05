#!/usr/bin/env python3
"""Approximate manuscript word count when texcount is unavailable."""

from __future__ import annotations

import re
import sys
from pathlib import Path


ROOT = Path(__file__).resolve().parents[2]
MAIN_TEX = ROOT / "paper" / "main.tex"
WORD_LIMIT = 10_000


def count_words(tex: str) -> int:
    tex = re.sub(r"%.*", "", tex)
    tex = re.sub(r"\\begin\{[^}]+\}|\\end\{[^}]+\}", " ", tex)
    tex = re.sub(
        r"\\(citep|citet|citealp|ref|label|path|texttt|url|bibitem)(\[[^]]*\])?(\{[^}]*\}){0,2}",
        " ",
        tex,
    )
    tex = re.sub(r"\\[a-zA-Z*]+(\[[^]]*\])?", " ", tex)
    tex = re.sub(r"[{}\\]", " ", tex)
    return len(re.findall(r"[A-Za-z0-9][A-Za-z0-9'-]*", tex))


def main() -> None:
    count = count_words(MAIN_TEX.read_text(encoding="utf-8"))
    print(f"Approximate manuscript word count: {count}")
    if count > WORD_LIMIT:
        print(f"Word count exceeds JLC's ordinary {WORD_LIMIT}-word ceiling.", file=sys.stderr)
        raise SystemExit(1)


if __name__ == "__main__":
    main()
