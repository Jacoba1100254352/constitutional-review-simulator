# Empirical Platform Coverage Report

This generated report summarizes the reusable calibration-platform surface. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, `reports/constitutional-review-validation-v1-misses.csv`, and source-candidate roadmap files under `config/research/`.

## Summary

- Court profiles: 16
- Calibration source rows: 50
- Validation-counted source rows: 15
- Validation rows within source range: 15
- Validation rows out of range: 0
- Promotion queue rows: 51

## Profile Status

| Status | Profiles |
| --- | --- |
| cost-benchmark-profile | 3 |
| partial-validation-profile | 7 |
| source-backed-stress-profile | 6 |

## Target-Family Coverage

| Family | Validation profiles | Stress-only profiles | Missing profiles |
| --- | --- | --- | --- |
| intake | 3 | 4 | 9 |
| case-selection | 1 | 0 | 15 |
| emergency | 2 | 0 | 14 |
| merits | 1 | 2 | 13 |
| remedy-timing | 1 | 0 | 15 |
| legislative-response | 1 | 0 | 15 |
| route-mix | 1 | 0 | 15 |
| compliance | 0 | 0 | 16 |
| cost | 0 | 7 | 9 |
| doctrine-mix | 0 | 2 | 14 |
| political-context | 0 | 5 | 11 |

## Out-of-Range Categories

No out-of-range validation rows are reported.

## Readiness Gates

| Item | Status | Evidence | Next action |
| --- | --- | --- | --- |
| source-range-fit | ready-for-current-claims | 15 validation-counted rows; 15 within range; 0 out of range | Run validation-check before publication and after every calibration-source or source-profile change. |
| profile-validation-depth | needs-source-expansion | 7/16 profiles have validation-counted rows; 3/16 profiles cover multiple validation families | Promote denominator-backed source rows for high-priority profiles before making stronger country-profile claims. |
| target-family-depth | needs-source-expansion | 7/11 families have validation-counted rows; missing validation families: compliance, cost, doctrine-mix, political-context | Use source-acquisition and source-promotion queue rows to expand family coverage with URLs, denominators, and direct analogues. |
| source-documentation | ready-for-current-claims | 50 calibration source rows; 15/15 validation rows have denominators and source URLs; 25 total rows with stored denominators; 39 total rows with source URLs | Keep unverified research leads in config/research until their URLs, denominators, coding rules, and analogues are documented. |
| promotion-pipeline | active-pipeline | 51 queued tasks; 9 candidate-verification, 22 source-acquisition, 20 source-promotion; top queue item: candidate-verification for canada-scc-2024 case-selection | Work promotion-queue rows in rank order, starting with candidate verification and then source promotion. |
| publication-boundary | ready-for-current-claims | Generated profile index, family matrix, promotion queue, benchmark cards, readiness report, manuscript tables, and replication bundle are all derived from the same source matrix. | Keep manuscript claims tied to validation-counted rows and describe missing families as empirical-roadmap work. |

## Promotion Queue Actions

| Action type | Rows |
| --- | --- |
| candidate-verification | 9 |
| source-acquisition | 22 |
| source-promotion | 20 |

## Largest Profile Gaps

| Profile | Status | Validation families | Out of range | Largest miss | Gap | Next priority |
| --- | --- | --- | --- | --- | --- | --- |
| canada-scc-2024 | partial-validation-profile | intake | 0 | -- | 0.000 | add denominator-backed case-selection source rows |
| canada-scc-recent | source-backed-stress-profile | -- | 0 | -- | 0.000 | promote denominator-backed intake source rows |
| cjeu-2024 | partial-validation-profile | route-mix | 0 | -- | 0.000 | add denominator-backed intake source rows |
| cost-france-conseil | cost-benchmark-profile | -- | 0 | -- | 0.000 | archive cost normalization workbook and denominators before validation use |
| cost-uk-supreme-court | cost-benchmark-profile | -- | 0 | -- | 0.000 | archive cost normalization workbook and denominators before validation use |
| cost-us-supreme-court | cost-benchmark-profile | -- | 0 | -- | 0.000 | archive cost normalization workbook and denominators before validation use |
| echr-2024 | partial-validation-profile | intake\|emergency | 0 | -- | 0.000 | add denominator-backed case-selection source rows |
| france-conseil-qpc | partial-validation-profile | merits\|remedy-timing | 0 | -- | 0.000 | add denominator-backed intake source rows |

## Top Promotion Queue

| Rank | Action | Profile | Family | Coverage | Gap | Candidate rows | Roadmap rows | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | candidate-verification | canada-scc-2024 | case-selection | missing | 0.000 | 2 | 0 | keep as contextual evidence unless recoded to a direct simulator analogue |
| 2 | candidate-verification | canada-scc-2024 | emergency | missing | 0.000 | 1 | 0 | keep as contextual evidence unless recoded to a direct simulator analogue |
| 3 | candidate-verification | canada-scc-2024 | compliance | missing | 0.000 | 2 | 0 | verify primary source URL and numerator/denominator before promotion |
| 4 | candidate-verification | canada-scc-2024 | legislative-response | missing | 0.000 | 5 | 1 | verify primary source URL and numerator/denominator before promotion |
| 5 | candidate-verification | canada-scc-recent | compliance | missing | 0.000 | 2 | 0 | verify primary source URL and numerator/denominator before promotion |
| 6 | candidate-verification | canada-scc-recent | legislative-response | missing | 0.000 | 5 | 1 | verify primary source URL and numerator/denominator before promotion |
| 7 | candidate-verification | germany-bverfg-2024 | legislative-response | missing | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| 8 | candidate-verification | germany-bverfg-2024 | merits | missing | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| 9 | candidate-verification | south-africa-constcourt-recent | legislative-response | missing | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| 10 | source-promotion | canada-scc-recent | cost | stress-only | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 11 | source-promotion | canada-scc-recent | intake | stress-only | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 12 | source-promotion | canada-scc-recent | merits | stress-only | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

The coverage report is a planning artifact. Validation-counted rows remain limited to source-backed targets with denominators and direct simulator analogues; stress-only and missing families should not be described as country validation evidence.
