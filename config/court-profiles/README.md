# Court Profile Index

This directory is the profile-level entry point for the empirical calibration
platform. The canonical target rows remain in
`config/calibration-source-observations.csv`; the generated
`profile-index.csv` groups those rows into court profiles and records the
current validation surface for each profile. The generated
`profile-benchmark-cards.md` file expands that index into per-profile benchmark
cards with family coverage, source rows, validation misses, and promotion tasks.

Regenerate or check the index from the repository root:

```sh
make court-profile-build
make court-profile-check
make research-data-check
make empirical-platform-report
make empirical-platform-check
```

`make research-data-check` also validates the source-candidate status taxonomy
before profile reports are generated, including verified URLs, bibliography-only
source locations, pending URL verification, context-only rows, promoted rows,
and numeric range or numerator/denominator consistency where candidate rows
provide provisional values.

Profile status values:

- `multi-target-validation-profile`: at least three validation rows across at
  least two target families.
- `partial-validation-profile`: at least one denominator-backed validation row.
- `source-backed-stress-profile`: source-backed rows exist, but none are counted
  as validation evidence under the current promotion rules.
- `stress-assumption-profile`: retained for transparent stress testing only.
- `cost-benchmark-profile`: normalized institutional-cost benchmark rows; these
  remain stress-test inputs until the normalization workbook and denominators
  are archived.

The `missingValidationFamilies` and `nextCalibrationPriority` columns are a
roadmap, not a claim that every family is equally available for every court.
Promote new rows only after a public source URL, denominator, period, coding
rule, construction note, and direct simulator analogue are documented.

The empirical platform report targets in `reports/` combine this profile index
with the current source-range miss report and source-candidate files. Use
`reports/constitutional-review-empirical-platform-v1-promotion-queue.csv` when
deciding which profile family to verify, promote, or retune next, and use
`reports/constitutional-review-empirical-platform-v1-source-gaps.csv` when you
need the same queue grouped by promotion readiness and claim boundary. Use
`reports/constitutional-review-empirical-platform-v1-candidate-verification.csv`
when source verification needs every underlying candidate row, not only the top
candidate for each gap. Use
`reports/constitutional-review-empirical-platform-v1-source-acquisition.csv`
when missing profile-family coverage has no registered candidate row and the
roadmap needs preferred sources, denominators, validation-use flags, and
collection recommendations. Use
`reports/constitutional-review-empirical-platform-v1-source-promotion.csv`
when stress-only rows need row-level blocker labels before promotion. Use
`reports/constitutional-review-empirical-platform-v1-readiness.csv` when
checking which publication claims are supported by the current source surface
and which claims still require source expansion. Use
`profile-benchmark-cards.md` when reviewing one court profile at a time, because
it keeps validation-counted rows, stress-only context, missing families, and
queued tasks in the same generated card.
