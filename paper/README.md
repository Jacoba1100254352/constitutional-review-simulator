# Paper

The current target venue is the *Journal of Law and Courts* (JLC), based on the
venue research report in the Deep Research Reports folder. JLC fits the project
because the manuscript is about courts as institutions, judicial selection,
constitutional review, comparative design, and computational methods.

Build the manuscript from the repository root:

```sh
make paper
```

`make paper` regenerates the LaTeX figure fragments in `paper/figures/` and
the LaTeX table fragments in `paper/tables/` from tracked CSV artifacts, runs
the repository JLC formatting check, and then compiles the PDF.

Run only the JLC formatting check with:

```sh
make paper-check
```

Build the supplementary appendix and anonymous submission/replication bundle
with:

```sh
make supplement
make submission-bundle
```

`make submission-bundle` writes ignored local artifacts under `submission/`:
an anonymous manuscript PDF, a supplementary appendix PDF, editable source ZIP,
replication-package ZIP, and a combined review bundle ZIP.

Run a word-count check when `texcount` is installed:

```sh
make paper-word-count
```

If `texcount` is not installed, the target falls back to the repository's
approximate LaTeX word counter and fails when the manuscript exceeds JLC's
ordinary 10,000-word ceiling.

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
publisher class bundle. The official template uses `biblatex` with Chicago
style; the local build keeps `natbib` citation commands but prints the reference
list manually in Chicago author-date form because `biblatex`/`biber` are not
installed in the local TeX environment.

Relevant venue-format constraints now reflected in the manuscript:

- anonymous-review posture;
- compact article structure rather than a broad working-paper report;
- author-date citations in the text;
- Chicago-style reference-list text rather than default `plainnat` output;
- tables and figures placed near their first discussion;
- back-matter declarations placed under separate headings before references;
- data availability and replication-package statements;
- AI-tool use declaration;
- explicit directional-score formula and a generated baseline results table;
- generated calibration target table;
- generated validation-style diagnostics table;
- compressed case-level report exports and run-block bootstrap intervals;
- large scenario matrices, calibration source tables, and sensitivity details
  treated as supplement candidates instead of main-text material.

The current figures are deterministic LaTeX fragments generated from repository
reports. They are kept inline for review because JLC asks tables and figures to
appear near first reference; if accepted, the figures should also be exported as
separate high-resolution artwork files for production. Accessibility
descriptions for all current figures and tables are maintained in
`paper/accessibility-descriptions.md`.

The paired legislative-input campaign is portable by default. The imported
Congress simulator output used for the paper is tracked at
`data/legislative/simulation-campaign-v21-paper.csv`, and the Makefile exposes
`LEGISLATIVE_INPUT=...` for overriding that source.

Calibration targets are now regenerated from
`config/calibration-source-observations.csv` with
`scripts/build_calibration_targets.py`; `make calibration-check` verifies that
the source-observation matrix, `config/calibration/*.csv`, and the compatibility
`config/calibration-targets.csv` file remain synchronized.

The submission checklist in `paper/jlc-submission-checklist.md` tracks the
remaining upload-time tasks, especially anonymous supplementary material,
publisher artwork, and repository deposit after acceptance.

For the venue comparison against the ACM route used by the Congress simulator,
see `paper/venue-rationale.md`.

Reference links:

- JLC preparation instructions: https://www.cambridge.org/core/journals/journal-of-law-and-courts/information/author-instructions/preparing-your-materials
- Cambridge Overleaf template entry point: https://www.overleaf.com/project/new/template/43288?brandVariationId=987&id=106890041&latexEngine=pdflatex&mainFile=sample.tex&templateName=Cambridge+Small+Template+Class+File&texImage=texlive-full%3A2025.1

Generated build files live under `paper/build/` and are intentionally not
tracked.
