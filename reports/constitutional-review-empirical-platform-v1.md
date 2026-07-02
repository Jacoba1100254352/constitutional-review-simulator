# Empirical Platform Coverage Report

This generated report summarizes the reusable calibration-platform surface. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, `reports/constitutional-review-validation-v1-misses.csv`, and source-candidate roadmap files under `config/research/`.

## Summary

- Court profiles: 16
- Calibration source rows: 50
- Validation-counted source rows: 15
- Validation rows within source range: 4
- Validation rows out of range: 11
- Promotion queue rows: 60

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

| Category | Rows |
| --- | --- |
| case-selection access proxy | 1 |
| emergency-procedure calibration | 3 |
| intake denominator alignment | 3 |
| merits-outcome mechanism | 1 |
| remedy-timing mechanism | 1 |
| weak-form response mechanism | 2 |

## Promotion Queue Actions

| Action type | Rows |
| --- | --- |
| candidate-verification | 9 |
| model-calibration | 9 |
| source-acquisition | 22 |
| source-promotion | 20 |

## Largest Profile Gaps

| Profile | Status | Validation families | Out of range | Largest miss | Gap | Next priority |
| --- | --- | --- | --- | --- | --- | --- |
| uk-supreme-court-2024-2025 | partial-validation-profile | intake\|case-selection | 2 | Permission-to-appeal grant rate | 0.454 | add denominator-backed emergency source rows |
| scotus-emergency-2024-2025 | partial-validation-profile | emergency | 2 | Substantive emergency application relief rate | 0.321 | promote denominator-backed intake source rows |
| echr-2024 | partial-validation-profile | intake\|emergency | 2 | Rule 39 interim-measure grant rate | 0.270 | add denominator-backed case-selection source rows |
| uk-human-rights-doi-2025 | partial-validation-profile | legislative-response | 2 | Statutory amendment or repeal after declarations of incompatibility | 0.215 | add denominator-backed intake source rows |
| france-conseil-qpc | partial-validation-profile | merits\|remedy-timing | 2 | QPC deferred-effect share over all solutions | 0.126 | add denominator-backed intake source rows |
| canada-scc-2024 | partial-validation-profile | intake | 1 | Leave application grant rate | 0.039 | add denominator-backed case-selection source rows |
| canada-scc-recent | source-backed-stress-profile | -- | 0 | -- | 0.000 | promote denominator-backed intake source rows |
| cjeu-2024 | partial-validation-profile | route-mix | 0 | -- | 0.000 | add denominator-backed intake source rows |

## Top Promotion Queue

| Rank | Action | Profile | Family | Coverage | Gap | Candidate rows | Roadmap rows | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | model-calibration | uk-supreme-court-2024-2025 | intake | validation-counted | 0.454 | 0 | 0 | Refine upstream filing volume, leave/admission filters, and docket-source mapping before making court-specific intake claims. |
| 2 | model-calibration | scotus-emergency-2024-2025 | emergency | validation-counted | 0.321 | 0 | 1 | Separate applicant mix, urgency, merits-follow-through, and grant standards for this court profile. |
| 3 | model-calibration | echr-2024 | emergency | validation-counted | 0.270 | 2 | 0 | Separate applicant mix, urgency, merits-follow-through, and grant standards for this court profile. |
| 4 | model-calibration | echr-2024 | intake | validation-counted | 0.232 | 2 | 0 | Refine upstream filing volume, leave/admission filters, and docket-source mapping before making court-specific intake claims. |
| 5 | model-calibration | uk-human-rights-doi-2025 | legislative-response | validation-counted | 0.215 | 4 | 0 | Constrain response quality so remedial action is not treated as credible without amendment, repeal, or equivalent implementation. |
| 6 | model-calibration | uk-supreme-court-2024-2025 | case-selection | validation-counted | 0.215 | 0 | 0 | Separate grant-rate fit from access mechanisms such as counsel, filing cost, public-interest standing, repeat-player advantage, and legal-aid capacity. |
| 7 | model-calibration | france-conseil-qpc | remedy-timing | validation-counted | 0.126 | 2 | 0 | Add remedy timing rules that distinguish immediate invalidation from suspended or prospective-effect declarations. |
| 8 | model-calibration | canada-scc-2024 | intake | validation-counted | 0.039 | 1 | 0 | Refine upstream filing volume, leave/admission filters, and docket-source mapping before making court-specific intake claims. |
| 9 | model-calibration | france-conseil-qpc | merits | validation-counted | 0.015 | 1 | 0 | Retune doctrine severity, referral screening, and invalidation-threshold parameters only after preserving cross-profile comparability. |
| 10 | candidate-verification | canada-scc-2024 | case-selection | missing | 0.000 | 2 | 0 | keep as contextual evidence unless recoded to a direct simulator analogue |
| 11 | candidate-verification | canada-scc-2024 | emergency | missing | 0.000 | 1 | 0 | keep as contextual evidence unless recoded to a direct simulator analogue |
| 12 | candidate-verification | canada-scc-2024 | compliance | missing | 0.000 | 2 | 0 | verify primary source URL and numerator/denominator before promotion |

The coverage report is a planning artifact. Validation-counted rows remain limited to source-backed targets with denominators and direct simulator analogues; stress-only and missing families should not be described as country validation evidence.
