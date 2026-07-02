# Court Profile Benchmark Cards

This generated artifact is the profile-level handoff for the empirical calibration platform. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, the generated validation-miss report, and the empirical-platform promotion queue. Do not edit it by hand; regenerate it with `make empirical-platform-report`.

Use these cards to distinguish source-range validation evidence from stress-only context and from candidate or acquisition work. A `validation-counted` family is a narrow benchmark check, not a claim that the stylized preset reproduces the named court.

## canada-scc-2024

- Court: Supreme Court of Canada
- Period: 2024
- Status: partial-validation-profile
- Target file(s): canada-scc-2024.csv
- Context: canadian-supreme-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 1 source rows; 1 validation-counted rows; 1 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: add denominator-backed case-selection source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 2 | 0 | keep as contextual evidence unless recoded to a direct simulator analogue |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | keep as contextual evidence unless recoded to a direct simulator analogue |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 5 | 1 | verify primary source URL and numerator/denominator before promotion |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 2 | 0 | verify primary source URL and numerator/denominator before promotion |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Leave application grant rate | 0.060--0.075 | 0.064--0.067 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Leave application grant rate | 0.0665 | 0.060--0.075 | 526 | high | Supreme Court of Canada Year in Review 2024 |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | candidate-verification | case-selection | missing | 2 | Post-leave hearing time | keep as contextual evidence unless recoded to a direct simulator analogue |
| 2 | candidate-verification | emergency | missing | 1 | Merits nonunanimity rate | keep as contextual evidence unless recoded to a direct simulator analogue |
| 3 | candidate-verification | compliance | missing | 2 | Reenactment or effective overruling after Charter invalidation | verify primary source URL and numerator/denominator before promotion |
| 4 | candidate-verification | legislative-response | missing | 5 | Legislative sequel after Charter invalidation | verify primary source URL and numerator/denominator before promotion |
| 30 | source-acquisition | remedy-timing | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## canada-scc-recent

- Court: Supreme Court of Canada
- Period: recent annual average
- Status: source-backed-stress-profile
- Target file(s): canada-scc-recent.csv
- Context: canadian-supreme-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 4 source rows; 0 validation-counted rows; 2 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: promote denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 5 | 1 | verify primary source URL and numerator/denominator before promotion |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 2 | 0 | verify primary source URL and numerator/denominator before promotion |
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress | Leave application grant rate | 0.089 | 0.075--0.105 | 524 | high | Supreme Court of Canada statistics synthesis |
| merits | stress | Charter invalidation proxy | 0.565 | 0.510--0.620 | 0 | medium | Comparative calibration research synthesis |
| cost | stress | Normalized direct court cost | 0.550 | 0.490--0.610 | 9 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.490 | 0.430--0.550 | 0 | medium | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 5 | candidate-verification | compliance | missing | 2 | Reenactment or effective overruling after Charter invalidation | verify primary source URL and numerator/denominator before promotion |
| 6 | candidate-verification | legislative-response | missing | 5 | Legislative sequel after Charter invalidation | verify primary source URL and numerator/denominator before promotion |
| 10 | source-promotion | cost | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 11 | source-promotion | intake | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 12 | source-promotion | merits | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 13 | source-promotion | political-context | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 31 | source-acquisition | remedy-timing | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## cjeu-2024

- Court: Court of Justice of the European Union
- Period: 2024
- Status: partial-validation-profile
- Target file(s): cjeu-2024.csv
- Context: cjeu-court-of-justice; CJEU statistics WGI V-Dem synthesis
- Evidence rows: 3 source rows; 3 validation-counted rows; 3 rows with stored denominators; 3 rows with source URLs
- Next calibration priority: add denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | validation-counted | 3 | 3 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| route-mix | Appeal route docket share | 0.292--0.311 | 0.300--0.319 | 0.000 | within | within source range |
| route-mix | Direct-action docket share | 0.052--0.064 | 0.056--0.066 | 0.000 | within | within source range |
| route-mix | Preliminary-reference docket share | 0.613--0.633 | 0.612--0.631 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| route-mix | validation | Appeal route docket share | 0.3011 | 0.292--0.311 | 920 | high | Court of Justice of the European Union judicial activity statistics 2024 |
| route-mix | validation | Direct-action docket share | 0.0576 | 0.052--0.064 | 920 | high | Court of Justice of the European Union judicial activity statistics 2024 |
| route-mix | validation | Preliminary-reference docket share | 0.6228 | 0.613--0.633 | 920 | high | Court of Justice of the European Union judicial activity statistics 2024 |

### Promotion Tasks

No promotion task is currently queued for this profile.

## cost-france-conseil

- Court: French Constitutional Council
- Period: recent annual
- Status: cost-benchmark-profile
- Target file(s): institutional-cost-profiles.csv
- Context: french-constitutional-council; V-Dem WGI WJP QPC360 synthesis
- Evidence rows: 1 source rows; 0 validation-counted rows; 1 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: archive cost normalization workbook and denominators before validation use

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| cost | stress | Normalized direct court cost | 0.340 | 0.280--0.400 | 9 | medium | Institutional cost benchmark synthesis |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 14 | source-promotion | cost | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

## cost-uk-supreme-court

- Court: UK Supreme Court
- Period: recent annual
- Status: cost-benchmark-profile
- Target file(s): institutional-cost-profiles.csv
- Context: uk-supreme-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 1 source rows; 0 validation-counted rows; 1 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: archive cost normalization workbook and denominators before validation use

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| cost | stress | Normalized direct court cost | 0.430 | 0.370--0.490 | 12 | medium | Institutional cost benchmark synthesis |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 15 | source-promotion | cost | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

## cost-us-supreme-court

- Court: U.S. Supreme Court
- Period: FY2025
- Status: cost-benchmark-profile
- Target file(s): institutional-cost-profiles.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 2 source rows; 0 validation-counted rows; 1 rows with stored denominators; 2 rows with source URLs
- Next calibration priority: archive cost normalization workbook and denominators before validation use

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | stress-only | 2 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| cost | stress | Normalized capacity strain | 0.480 | 0.420--0.540 | 0 | medium | Institutional cost benchmark synthesis |
| cost | stress | Normalized direct court cost | 0.740 | 0.690--0.790 | 9 | medium | Institutional cost benchmark synthesis |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 16 | source-promotion | cost | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

## echr-2024

- Court: European Court of Human Rights
- Period: 2024
- Status: partial-validation-profile
- Target file(s): echr-2024.csv
- Context: echr-treaty-court; Council of Europe WGI V-Dem synthesis
- Evidence rows: 2 source rows; 2 validation-counted rows; 2 rows with stored denominators; 2 rows with source URLs
- Next calibration priority: add denominator-backed case-selection source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Probable Chamber or Committee case share | 0.305--0.326 | 0.306--0.317 | 0.000 | within | within source range |
| emergency | Rule 39 interim-measure grant rate | 0.218--0.238 | 0.219--0.253 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Probable Chamber or Committee case share | 0.3160 | 0.305--0.326 | 28800 | medium | ECHR Analysis of Statistics 2024 |
| emergency | validation | Rule 39 interim-measure grant rate | 0.2276 | 0.218--0.238 | 1630 | high | ECHR Analysis of Statistics 2024 |

### Promotion Tasks

No promotion task is currently queued for this profile.

## france-conseil-qpc

- Court: French Constitutional Council
- Period: 2010-2024 QPC | QPC recent period
- Status: partial-validation-profile
- Target file(s): france-conseil-qpc.csv
- Context: french-constitutional-council; V-Dem WGI WJP QPC360 synthesis
- Evidence rows: 5 source rows; 2 validation-counted rows; 3 rows with stored denominators; 2 rows with source URLs
- Next calibration priority: add denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 2 | collect denominator-backed source rows for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| remedy-timing | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | stress-only | 2 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| merits | QPC nonconformity rate | 0.305--0.324 | 0.296--0.317 | 0.000 | within | within source range |
| remedy-timing | QPC deferred-effect share over all solutions | 0.126--0.141 | 0.130--0.144 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| merits | validation | QPC nonconformity rate | 0.3145 | 0.305--0.324 | 1011 | high | Conseil constitutionnel QPC360 statistical overview |
| remedy-timing | validation | QPC deferred-effect share over all solutions | 0.1335 | 0.126--0.141 | 1011 | high | Conseil constitutionnel QPC360 statistical overview |
| cost | stress | Normalized direct court cost | 0.340 | 0.280--0.400 | 9 | medium | Institutional cost benchmark synthesis |
| cost | stress | Normalized upstream screening cost | 0.590 | 0.520--0.660 | 0 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.500 | 0.430--0.570 | 0 | low | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 17 | source-promotion | cost | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 18 | source-promotion | political-context | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 32 | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## gallup-court-confidence-2024

- Court: U.S. Supreme Court
- Period: 2024 public-opinion year
- Status: source-backed-stress-profile
- Target file(s): us-supreme-court-2024-public-emergency.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 1 source rows; 0 validation-counted rows; 0 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: promote denominator-backed political-context source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 1 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| political-context | stress | Public court trust and approval | 0.420 | 0.350--0.490 | 0 | medium | Gallup Supreme Court and courts confidence reporting |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 19 | source-promotion | political-context | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 33 | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 34 | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 35 | source-acquisition | doctrine-mix | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 36 | source-acquisition | emergency | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 37 | source-acquisition | merits | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## germany-bverfg-2024

- Court: German Federal Constitutional Court
- Period: 2024
- Status: source-backed-stress-profile
- Target file(s): germany-bverfg-2024.csv
- Context: german-constitutional-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 4 source rows; 0 validation-counted rows; 2 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: promote denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 2 | collect denominator-backed source rows for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | stress-only | 2 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress | Constitutional complaint success and admission proxy | 0.0085 | 0.006--0.012 | 4640 | medium | Bundesverfassungsgericht annual statistics synthesis |
| cost | stress | Normalized capacity strain | 0.560 | 0.500--0.640 | 0 | medium | Institutional cost benchmark synthesis |
| cost | stress | Normalized direct court cost | 0.620 | 0.560--0.680 | 16 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.740 | 0.680--0.800 | 0 | medium | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 7 | candidate-verification | legislative-response | missing | 1 | Legislative response to unconstitutional-without-nullity decisions | verify primary source URL and numerator/denominator before promotion |
| 8 | candidate-verification | merits | missing | 1 | Constitutional complaint success or grant rate | verify primary source URL and numerator/denominator before promotion |
| 20 | source-promotion | cost | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 21 | source-promotion | intake | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 22 | source-promotion | political-context | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 38 | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 39 | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## scdb-modern-merits-2000-2024

- Court: U.S. Supreme Court
- Period: 2000-2024 terms
- Status: source-backed-stress-profile
- Target file(s): us-supreme-court-2000-2024.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 7 source rows; 0 validation-counted rows; 0 rows with stored denominators; 7 rows with source URLs
- Next calibration priority: promote denominator-backed doctrine-mix source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | stress-only | 7 | 0 | 0 | -- | 0.000 | 0 | 1 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| doctrine-mix | stress | Administrative and economic regulation share | 0.222 | 0.193--0.250 | 0 | medium | Supreme Court Database issue codebook |
| doctrine-mix | stress | Criminal procedure docket share | 0.260 | 0.230--0.289 | 0 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | stress | Election-law docket share | 0.026 | 0.009--0.043 | 0 | medium | Supreme Court Database issue codebook |
| doctrine-mix | stress | Emergency-powers merits share | 0.010 | 0.000--0.019 | 0 | medium | Supreme Court Database issue codebook |
| doctrine-mix | stress | Civil-rights and privacy docket share | 0.164 | 0.137--0.191 | 0 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | stress | Federalism docket share | 0.058 | 0.037--0.078 | 0 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | stress | Speech docket share | 0.060 | 0.039--0.080 | 0 | high | Supreme Court Database 2025 Release 01 |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 23 | source-promotion | doctrine-mix | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 40 | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 41 | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 42 | source-acquisition | emergency | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 43 | source-acquisition | merits | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 44 | source-acquisition | political-context | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## scdb-postwar-merits-1946-2024

- Court: U.S. Supreme Court
- Period: 1946-2024 terms
- Status: source-backed-stress-profile
- Target file(s): us-supreme-court-1946-2024.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 7 source rows; 0 validation-counted rows; 0 rows with stored denominators; 7 rows with source URLs
- Next calibration priority: promote denominator-backed doctrine-mix source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | stress-only | 7 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| doctrine-mix | stress | Administrative and economic regulation share | 0.218 | 0.199--0.236 | 0 | medium | Supreme Court Database issue codebook |
| doctrine-mix | stress | Criminal procedure docket share | 0.226 | 0.207--0.244 | 0 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | stress | Election-law docket share | 0.027 | 0.013--0.040 | 0 | medium | Supreme Court Database issue codebook |
| doctrine-mix | stress | Emergency-powers merits share | 0.006 | 0.000--0.012 | 0 | medium | Supreme Court Database issue codebook |
| doctrine-mix | stress | Civil-rights and privacy docket share | 0.152 | 0.135--0.169 | 0 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | stress | Federalism docket share | 0.056 | 0.041--0.071 | 0 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | stress | Speech docket share | 0.076 | 0.060--0.091 | 0 | high | Supreme Court Database 2025 Release 01 |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 24 | source-promotion | doctrine-mix | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

## scotus-emergency-2024-2025

- Court: U.S. Supreme Court
- Period: 2024-2025 emergency docket
- Status: partial-validation-profile
- Target file(s): us-supreme-court-2024-public-emergency.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 4 source rows; 3 validation-counted rows; 4 rows with stored denominators; 4 rows with source URLs
- Next calibration priority: promote denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| emergency | validation-counted | 3 | 3 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| emergency | Public disagreement share | 0.570--0.760 | 0.563--0.590 | 0.000 | within | within source range |
| emergency | Written explanation share | 0.200--0.360 | 0.224--0.246 | 0.000 | within | within source range |
| emergency | Substantive emergency application relief rate | 0.310--0.460 | 0.445--0.471 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress | Certiorari or emergency screening acceptance proxy | 0.0176 | 0.013--0.018 | 3854 | medium | Supreme Court Journal and lower-court pipeline research synthesis |
| emergency | validation | Public disagreement share | 0.670 | 0.570--0.760 | 43 | medium | SCOTUSblog Davis 2025 emergency docket summary |
| emergency | validation | Written explanation share | 0.279 | 0.200--0.360 | 43 | medium | SCOTUSblog Davis 2025 emergency docket summary |
| emergency | validation | Substantive emergency application relief rate | 0.440 | 0.310--0.460 | 43 | medium | SCOTUSblog Davis 2025 emergency docket summary |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 25 | source-promotion | intake | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 45 | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 46 | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 47 | source-acquisition | doctrine-mix | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 48 | source-acquisition | merits | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 49 | source-acquisition | political-context | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## south-africa-constcourt-recent

- Court: Constitutional Court of South Africa
- Period: recent annual average
- Status: source-backed-stress-profile
- Target file(s): south-africa-constcourt-recent.csv
- Context: south-african-constitutional-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 4 source rows; 0 validation-counted rows; 1 rows with stored denominators; 2 rows with source URLs
- Next calibration priority: promote denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | stress | Petition-to-judgment throughput proxy | 0.141 | 0.110--0.170 | 355 | medium | Constitutional Court statistics synthesis |
| merits | stress | Merits invalidation proxy | 0.5318 | 0.470--0.590 | 0 | medium | Constitutional Court statistics synthesis |
| cost | stress | Normalized capacity strain | 0.680 | 0.610--0.750 | 0 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.430 | 0.360--0.500 | 0 | medium | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- |
| 9 | candidate-verification | legislative-response | missing | 1 | Legislative response to suspended declarations of invalidity | verify primary source URL and numerator/denominator before promotion |
| 26 | source-promotion | cost | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 27 | source-promotion | intake | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 28 | source-promotion | merits | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 29 | source-promotion | political-context | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 50 | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 51 | source-acquisition | remedy-timing | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## uk-human-rights-doi-2025

- Court: United Kingdom domestic courts
- Period: July 2000-July 2025
- Status: partial-validation-profile
- Target file(s): uk-human-rights-doi-2025.csv
- Context: uk-supreme-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 2 source rows; 2 validation-counted rows; 2 rows with stored denominators; 2 rows with source URLs
- Next calibration priority: add denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | validation-counted | 2 | 2 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| legislative-response | Statutory amendment or repeal after declarations of incompatibility | 0.410--0.450 | 0.424--0.444 | 0.000 | within | within source range |
| legislative-response | Strict response after declarations of incompatibility | 0.430--0.460 | 0.423--0.443 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| legislative-response | validation | Statutory amendment or repeal after declarations of incompatibility | 0.4286 | 0.410--0.450 | 63 | medium | Ministry of Justice Responding to human rights judgments 2024-2025 |
| legislative-response | validation | Strict response after declarations of incompatibility | 0.4444 | 0.430--0.460 | 63 | medium | Ministry of Justice Responding to human rights judgments 2024-2025 |

### Promotion Tasks

No promotion task is currently queued for this profile.

## uk-supreme-court-2024-2025

- Court: UK Supreme Court
- Period: 2024-2025
- Status: partial-validation-profile
- Target file(s): uk-supreme-court-2024-2025.csv
- Context: uk-supreme-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 2 source rows; 2 validation-counted rows; 2 rows with stored denominators; 2 rows with source URLs
- Next calibration priority: add denominator-backed emergency source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| case-selection | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Permission-to-appeal grant rate | 0.345--0.375 | 0.366--0.378 | 0.000 | within | within source range |
| case-selection | Permission-to-appeal case-selection access proxy | 0.345--0.375 | 0.357--0.376 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Permission-to-appeal grant rate | 0.3610 | 0.345--0.375 | 170 | high | UK Supreme Court Annual Report and Accounts 2024-2025 |
| case-selection | validation | Permission-to-appeal case-selection access proxy | 0.3610 | 0.345--0.375 | 170 | high | UK Supreme Court Annual Report and Accounts 2024-2025 |

### Promotion Tasks

No promotion task is currently queued for this profile.
