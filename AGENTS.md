# Codex Guidance

This is the primary Constitutional Review Simulator implementation workspace. It is a dependency-free Java simulator for comparing court and constitutional-review institutional designs.

Use these commands from this directory:

- `make run`
- `make test`
- `make campaign`
- `make paired-campaign`
- `make sensitivity-check`
- `make run ARGS="--legislative-input '/Users/jacobanderson/Documents/simulators/Congress Institutional Simulator/reports/simulation-campaign-v21-paper.csv'"`

Project constraints:

- Keep this simulator separate from the Congress Institutional Simulator, with legislative outputs imported as CSV stress signals.
- Preserve named scenarios, randomized worlds, campaign sweeps, directional metrics, CSV/Markdown reports, and provenance manifests.
- Keep doctrine areas, state/federal and lower-court pipeline fields, emergency-relief/merits-invalidation split metrics, review-period composition turnover, reaction dynamics, compliance/enforcement outcomes, calibration diagnostics, and sensitivity diagnostics visible in reports.
- Keep `config/calibration-targets.csv` in sync with generated `*-calibration.csv` report columns when adding calibration checks.
- Treat the sibling `Supreme Court Simulator Design` workspace as an earlier related artifact, not as an automatically authoritative source.
