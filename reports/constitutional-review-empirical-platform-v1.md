# Empirical Platform Coverage Report

This generated report summarizes the reusable calibration-platform surface. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, `reports/constitutional-review-validation-v1-misses.csv`, and source-candidate roadmap files under `config/research/`.

## Summary

- Court profiles: 17
- Calibration source rows: 56
- Validation-counted source rows: 40
- Validation rows within source range: 40
- Validation rows out of range: 0
- Promotion queue rows: 45
- Source-promotion queue rows: 13

## Profile Status

| Status | Profiles |
| --- | --- |
| cost-benchmark-profile | 3 |
| multi-target-validation-profile | 3 |
| partial-validation-profile | 10 |
| source-backed-stress-profile | 1 |

## Target-Family Coverage

| Family | Validation profiles | Stress-only profiles | Missing profiles |
| --- | --- | --- | --- |
| intake | 7 | 0 | 10 |
| case-selection | 1 | 0 | 16 |
| emergency | 2 | 0 | 15 |
| merits | 1 | 1 | 15 |
| remedy-timing | 1 | 0 | 16 |
| legislative-response | 2 | 0 | 15 |
| route-mix | 1 | 0 | 16 |
| compliance | 2 | 0 | 15 |
| cost | 0 | 7 | 10 |
| doctrine-mix | 2 | 0 | 15 |
| political-context | 0 | 5 | 12 |

## Out-of-Range Categories

No out-of-range validation rows are reported.

## Readiness Gates

| Item | Status | Evidence | Next action |
| --- | --- | --- | --- |
| source-range-fit | ready-for-current-claims | 40 validation-counted rows; 40 within range; 0 out of range | Run validation-check before publication and after every calibration-source or source-profile change. |
| profile-validation-depth | needs-source-expansion | 13/17 profiles have validation-counted rows; 6/17 profiles cover multiple validation families | Promote denominator-backed source rows for high-priority profiles before making stronger country-profile claims. |
| target-family-depth | needs-source-expansion | 9/9 validation-eligible families have validation-counted rows; missing validation families: none | Use source-acquisition and source-promotion queue rows to expand family coverage with URLs, denominators, and direct analogues. |
| contextual-source-depth | contextual-surface-active | 2/2 contextual families have stress-source rows; 15 source rows across 8 profiles; 0 validation-counted by policy | Build raw cost-accounting and political-context source packs separately from validation-counted case-output analogues. |
| source-documentation | ready-for-current-claims | 56 calibration source rows; 40/40 validation rows have denominators and source URLs; 46 total rows with stored denominators; 46 total rows with source URLs | Keep unverified research leads in config/research until their URLs, denominators, coding rules, and analogues are documented. |
| promotion-pipeline | active-pipeline | 45 queued tasks; 7 candidate-verification, 25 source-acquisition, 13 source-promotion; readiness: 1 model-metric-gap, 1 needs-source-documentation, 14 contextual-source-documentation, 3 candidate-triage-needed, 23 source-acquisition-needed, 3 context-only-blocked; top actionable item: model-metric-gap for canada-charter-dialogue-1982-2007 merits; source-promotion detail: 16 stress-only source rows; blockers: 14 context-or-normalized-measure, 10 missing-denominator, 10 missing-source-url, 16 not-validation-counted, 15 synthesis-source | Resolve model-metric-gap rows only by implementing the matching source unit or keeping them excluded; then work direct-candidate and stress-promotion rows. |
| publication-boundary | ready-for-current-claims | Generated profile index, family matrix, promotion queue, benchmark cards, readiness report, manuscript tables, and replication bundle are all derived from the same source matrix. | Keep manuscript claims tied to validation-counted rows and describe missing families as empirical-roadmap work. |

## Promotion Queue Actions

| Action type | Rows |
| --- | --- |
| candidate-verification | 7 |
| source-acquisition | 25 |
| source-promotion | 13 |

## Promotion Readiness

| Readiness | Rows |
| --- | --- |
| model-metric-gap | 1 |
| needs-source-documentation | 1 |
| contextual-source-documentation | 14 |
| candidate-triage-needed | 3 |
| source-acquisition-needed | 23 |
| context-only-blocked | 3 |

## Source Promotion Blockers

| Blocker | Rows |
| --- | --- |
| context-or-normalized-measure | 14 |
| missing-denominator | 10 |
| missing-source-url | 10 |
| not-validation-counted | 16 |
| synthesis-source | 15 |

## Largest Profile Gaps

| Profile | Status | Validation families | Out of range | Largest miss | Gap | Next priority |
| --- | --- | --- | --- | --- | --- | --- |
| canada-charter-dialogue-1982-2007 | multi-target-validation-profile | legislative-response\|compliance | 0 | -- | 0.000 | add denominator-backed intake source rows |
| canada-scc-2024 | partial-validation-profile | intake | 0 | -- | 0.000 | add denominator-backed case-selection source rows |
| canada-scc-recent | partial-validation-profile | intake | 0 | -- | 0.000 | add denominator-backed case-selection source rows |
| cjeu-2024 | multi-target-validation-profile | route-mix\|compliance | 0 | -- | 0.000 | add denominator-backed intake source rows |
| cost-france-conseil | cost-benchmark-profile | -- | 0 | -- | 0.000 | archive cost normalization workbook and denominators before validation use |
| cost-uk-supreme-court | cost-benchmark-profile | -- | 0 | -- | 0.000 | archive cost normalization workbook and denominators before validation use |
| cost-us-supreme-court | cost-benchmark-profile | -- | 0 | -- | 0.000 | archive cost normalization workbook and denominators before validation use |
| echr-2024 | partial-validation-profile | intake\|emergency | 0 | -- | 0.000 | add denominator-backed case-selection source rows |

## Top Promotion Queue

| Rank | Readiness | Action | Profile | Family | Coverage | Candidate rows | Roadmap rows | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | model-metric-gap | candidate-verification | canada-charter-dialogue-1982-2007 | merits | missing | 1 | 0 | add the missing simulator output and preserve the source unit before reconsidering validation promotion |
| 2 | needs-source-documentation | source-promotion | south-africa-constcourt-recent | merits | stress-only | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 3 | contextual-source-documentation | source-promotion | canada-scc-recent | cost | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 4 | contextual-source-documentation | source-promotion | canada-scc-recent | political-context | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 5 | contextual-source-documentation | source-promotion | cost-france-conseil | cost | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 6 | contextual-source-documentation | source-promotion | cost-uk-supreme-court | cost | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 7 | contextual-source-documentation | source-promotion | cost-us-supreme-court | cost | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 8 | contextual-source-documentation | source-promotion | france-conseil-qpc | cost | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 9 | contextual-source-documentation | source-promotion | france-conseil-qpc | political-context | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 10 | contextual-source-documentation | source-promotion | gallup-court-confidence-2024 | political-context | stress-only | 0 | 1 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 11 | contextual-source-documentation | source-promotion | germany-bverfg-2024 | cost | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 12 | contextual-source-documentation | source-promotion | germany-bverfg-2024 | political-context | stress-only | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

## Source Gap Handoff

| Gap rank | Readiness | Profile | Family | Claim boundary | Blocker |
| --- | --- | --- | --- | --- | --- |
| 1 | model-metric-gap | canada-charter-dialogue-1982-2007 | merits | verified source measure lacks a matching simulator output unit | source evidence is reproducible but cannot be compared to the current all-merits simulator metric without mixing units |
| 2 | needs-source-documentation | south-africa-constcourt-recent | merits | stress-only row needs promotion evidence | stress-only coverage lacks the full promotion package: source URL, denominator, coding rule, and direct analogue |
| 3 | contextual-source-documentation | canada-scc-recent | cost | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 4 | contextual-source-documentation | canada-scc-recent | political-context | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 5 | contextual-source-documentation | cost-france-conseil | cost | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 6 | contextual-source-documentation | cost-uk-supreme-court | cost | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 7 | contextual-source-documentation | cost-us-supreme-court | cost | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 8 | contextual-source-documentation | france-conseil-qpc | cost | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 9 | contextual-source-documentation | france-conseil-qpc | political-context | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 10 | contextual-source-documentation | gallup-court-confidence-2024 | political-context | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 11 | contextual-source-documentation | germany-bverfg-2024 | cost | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |
| 12 | contextual-source-documentation | germany-bverfg-2024 | political-context | contextual source surface, not validation-family gap | current validation policy excludes normalized cost and public-trust proxy rows from source-range validation |

The coverage report is a planning artifact. Validation-counted rows remain limited to source-backed targets with denominators and direct simulator analogues; stress-only and missing families should not be described as country validation evidence.
Use the source-promotion packet for row-level stress-only promotion audits, the candidate-verification packet for unpromoted candidates, and the source-acquisition packet for missing profile-family rows with no registered candidate.
