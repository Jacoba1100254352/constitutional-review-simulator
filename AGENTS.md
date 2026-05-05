# Codex Guidance

This is the primary Constitutional Review Simulator implementation workspace. It is a dependency-free Java simulator for comparing court and constitutional-review institutional designs.

Use these commands from this directory:

- `make run`
- `make test`
- `make campaign`
- `make paired-campaign`
- `make validation-check`
- `make sensitivity-check`
- `make calibration-check`
- `make supplement`
- `make submission-bundle`
- `make run ARGS="--legislative-input data/legislative/simulation-campaign-v21-paper.csv"`

Project constraints:

- Keep this simulator separate from the Congress Institutional Simulator, with legislative outputs imported as CSV stress signals.
- Preserve named scenarios, randomized worlds, campaign sweeps, directional metrics, CSV/Markdown reports, and provenance manifests.
- Keep doctrine areas, policy-domain overlays, state/federal and lower-court pipeline fields, emergency-relief/merits-invalidation split metrics, review-period composition turnover, reaction dynamics, compliance/enforcement outcomes, institutional cost metrics, raw case-level exports, bootstrap uncertainty bands, calibration diagnostics, validation diagnostics, and sensitivity diagnostics visible in reports.
- Keep comparative design, pipeline, emergency docket, and institutional cost benchmark configs in `config/comparative`, `config/pipeline`, `config/emergency`, and `config/cost-benchmarks` aligned with real-world scenario presets when adding court-system archetypes.
- Keep `config/calibration-source-observations.csv`, `config/calibration/*.csv`, and the compatibility `config/calibration-targets.csv` in sync with generated `*-calibration.csv` report columns when adding calibration checks.
- Keep the submission bundle anonymous-review safe: no local paths, build logs, IDE files, generated PDFs inside replication/source ZIPs, or unredacted repository metadata.
- Treat the sibling `Supreme Court Simulator Design` workspace as an earlier related artifact, not as an automatically authoritative source.
