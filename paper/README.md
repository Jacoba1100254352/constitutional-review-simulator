# Paper

The current target venue is the *Journal of Law and Courts* (JLC), based on the
venue research report in the Deep Research Reports folder. JLC fits the project
because the manuscript is about courts as institutions, judicial selection,
constitutional review, comparative design, and computational methods.

Build the manuscript from the repository root:

```sh
make paper
```

`make paper` regenerates the LaTeX figure fragments in `paper/figures/` from
the tracked campaign CSVs before compiling the PDF.

Run a word-count check when `texcount` is installed:

```sh
make paper-word-count
```

## Submission Format

JLC is published by Cambridge University Press. Cambridge's JLC preparation
instructions point LaTeX authors to the Cambridge small-template Overleaf
package, whose main file uses the `cup-journal` document class. The manuscript
therefore keeps that interface in `main.tex`:

```tex
\documentclass[
  journal=small,
  manuscript=research-article,
  year=2026
]{cup-journal}
```

The repository includes `paper/cup-journal.cls` as a local compatibility shim
because the official Cambridge class is not installed in the local TeX
environment. For final submission, replace the shim with the official Cambridge
Overleaf template files if Editorial Manager or Cambridge requires the exact
publisher class bundle. The same applies to the final bibliography style: the
local build uses installed `natbib` tooling for author-date citations, while the
submission bundle should use Cambridge's exact JLC bibliography configuration
when that class package is available.

Relevant venue-format constraints now reflected in the manuscript:

- anonymous-review posture;
- compact article structure rather than a broad working-paper report;
- author-date citations in the text;
- tables and figures placed near their first discussion;
- data availability and replication-package statements;
- large scenario matrices, calibration source tables, and sensitivity details
  treated as supplement candidates instead of main-text material.

The current figures are deterministic LaTeX fragments generated from repository
reports. They are kept inline for review because JLC asks tables and figures to
appear near first reference; if accepted, the figures should also be exported as
separate high-resolution artwork files for production.

For the venue comparison against the ACM route used by the Congress simulator,
see `paper/venue-rationale.md`.

Reference links:

- JLC preparation instructions: https://www.cambridge.org/core/journals/journal-of-law-and-courts/information/author-instructions/preparing-your-materials
- Cambridge Overleaf template entry point: https://www.overleaf.com/project/new/template/43288?brandVariationId=987&id=106890041&latexEngine=pdflatex&mainFile=sample.tex&templateName=Cambridge+Small+Template+Class+File&texImage=texlive-full%3A2025.1

Generated build files live under `paper/build/` and are intentionally not
tracked.
