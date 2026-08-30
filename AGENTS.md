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
- `make paper-pdf-check`
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

## Public Repository and Secret Handling

- Treat this repository and every committed file as public information.
- Never commit `.env`, `.env.*`, credentials, access tokens, private keys, signing material, restricted-source caches, or environment-specific private paths. Track only scrubbed templates such as `.env.example`, with blank or unmistakably fake values.
- Before staging or publishing, inspect `git status --short`, review the staged diff, and run a redacted secret scan when available. Confirm that ignored local credential files remain ignored.
- If a real secret ever enters tracked content or Git history, stop publication, remove it from the affected history, and rotate or revoke the credential before pushing or changing visibility.

## Commit, Tag, and Release Policy

- Commit coherent, validated increments frequently: normally after each focused change passes its relevant checks and before switching to a different concern. Preserve unrelated user work and do not fold it into an unclear commit.
- Push validated commits as the normal completion step so the public repository stays current.
- Create tags less frequently, only for meaningful version, citation, submission, or compatibility milestones. An ordinary commit does not need a tag.
- Publish a release only at a milestone with aligned version metadata, release notes, verified artifacts and checksums where applicable, and passing release checks. Use a draft or prerelease for genuinely provisional milestones, a source-only release when that is the intended artifact, and a stable release only when the documented stable benchmark is met.
