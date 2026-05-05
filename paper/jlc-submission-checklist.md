# JLC Submission Checklist

Use this checklist before uploading to Editorial Manager.

## Main Manuscript

- Main manuscript is anonymous and uses `Anonymous Author`.
- Main manuscript uses the Cambridge `cup-journal` interface.
- Article type is `research-article`.
- Text is below JLC's 10,000-word ceiling unless extra length is justified.
- Tables and figures appear near first reference rather than at the end.
- Figures and tables are numbered consecutively and have captions.
- Citations use Chicago author-date style in the text.
- Reference list text is in Chicago author-date form, not default `plainnat`
  output.
- Reference list contains only works cited in the manuscript.
- Legal cases, if added later, are not placed in the reference list.
- Directional-score formula and component metrics are disclosed.
- Main text includes a compact result table and a compact calibration-target
  table.
- Back-matter declarations appear as separate headings before references:
  `Funding Declaration`, `Competing Interests Declaration`,
  `Data Availability Statement`, and `Ethical Statement`.
- AI use is declared under `AI Tools Declaration`.

## Figures, Tables, And Accessibility

- `paper/accessibility-descriptions.md` has one description for every figure
  and table label in `paper/main.tex`.
- Final accepted figures are exported as separate high-resolution files if
  Cambridge requests production artwork.
- Color and contrast remain legible without relying on color alone.
- Any third-party figure, table, or excerpt permissions are cleared before
  submission.

## Supplement And Replication Package

- Supplementary material is anonymized for review.
- `make paired-campaign` uses a portable `LEGISLATIVE_INPUT` path or a
  submitted supplementary CSV, not an author-specific absolute path.
- Supplement includes source code, configuration files, calibration targets,
  generated reports, figure-generation scripts, and reproduction commands.
- Repository URLs, user paths, commit metadata, and author-identifying file
  names are removed or redacted in the anonymous submission package.
- Accepted replication materials are deposited in an appropriate public
  repository and cited in the final data availability statement.

## Local Checks

Run these commands from the repository root:

```sh
make paper-check
make paper
make test
```
