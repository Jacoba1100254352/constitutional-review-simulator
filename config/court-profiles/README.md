# Court Profile Index

This directory is the profile-level entry point for the empirical calibration
platform. The canonical target rows remain in
`config/calibration-source-observations.csv`; the generated
`profile-index.csv` groups those rows into court profiles and records the
current validation surface for each profile.

Regenerate or check the index from the repository root:

```sh
make court-profile-build
make court-profile-check
make research-data-check
make empirical-platform-report
make empirical-platform-check
```

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
deciding which profile family to verify, promote, or retune next.
