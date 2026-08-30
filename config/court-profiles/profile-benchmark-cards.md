# Court Profile Benchmark Cards

This generated artifact is the profile-level handoff for the empirical calibration platform. It is derived from `config/court-profiles/profile-index.csv`, `config/calibration-source-observations.csv`, the generated validation-miss report, and the empirical-platform promotion queue. Do not edit it by hand; regenerate it with `make empirical-platform-report`.

Use these cards to distinguish source-range validation evidence from stress-only context and from candidate or acquisition work. A `validation-counted` family is a narrow benchmark check, not a claim that the stylized preset reproduces the named court.

## canada-charter-dialogue-1982-2007

- Court: Supreme Court of Canada
- Period: 1982-1997 Charter invalidations | 1997-2007 Charter invalidations
- Status: multi-target-validation-profile
- Target file(s): canada-charter-dialogue-1982-2007.csv
- Context: canadian-supreme-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 6 source rows; 6 validation-counted rows; 6 rows with stored denominators; 6 rows with source URLs
- Next calibration priority: add denominator-backed intake source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | add the missing simulator output and preserve the source unit before reconsidering validation promotion |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| legislative-response | validation-counted | 4 | 4 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | validation-counted | 2 | 2 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| legislative-response | Legislative response after Charter invalidation | 0.692--0.881 | 0.736--0.753 | 0.000 | within | within source range |
| legislative-response | Legislative response after Charter invalidation update period | 0.408--0.778 | 0.736--0.753 | 0.000 | within | within source range |
| legislative-response | Formal override after Charter invalidation | 0.003--0.081 | 0.036--0.044 | 0.000 | within | within source range |
| legislative-response | Formal override after Charter invalidation update period | 0.000--0.143 | 0.036--0.044 | 0.000 | within | within source range |
| compliance | Effective overruling or reenactment after Charter invalidation | 0.008--0.104 | 0.073--0.084 | 0.000 | within | within source range |
| compliance | Reenactment after Charter invalidation update period | 0.000--0.143 | 0.073--0.084 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| legislative-response | validation | Legislative response after Charter invalidation | 0.8030 | 0.692--0.881 | 66 | medium | Hogg and Bushell Charter dialogue study condensed in Canada Watch |
| legislative-response | validation | Legislative response after Charter invalidation update period | 0.6087 | 0.408--0.778 | 23 | medium | JUSTICE British Bill of Rights report quoting Hogg Bushell Thornton and Wright |
| legislative-response | validation | Formal override after Charter invalidation | 0.0152 | 0.003--0.081 | 66 | medium | JUSTICE British Bill of Rights report quoting Hogg and Bushell |
| legislative-response | validation | Formal override after Charter invalidation update period | 0.0000 | 0.000--0.143 | 23 | medium | JUSTICE British Bill of Rights report quoting Hogg Bushell Thornton and Wright |
| compliance | validation | Effective overruling or reenactment after Charter invalidation | 0.0303 | 0.008--0.104 | 66 | medium | JUSTICE British Bill of Rights report quoting Hogg and Bushell |
| compliance | validation | Reenactment after Charter invalidation update period | 0.0000 | 0.000--0.143 | 23 | medium | JUSTICE British Bill of Rights report quoting Hogg Bushell Thornton and Wright |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 1 | model-metric-gap | candidate-verification | merits | missing | 1 | Statute nullification rate among federal and provincial statute dispositions | add the missing simulator output and preserve the source unit before reconsidering validation promotion |
| 20 | source-acquisition-needed | source-acquisition | remedy-timing | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

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
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Leave application grant rate | 0.060--0.075 | 0.071--0.074 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Leave application grant rate | 0.0665 | 0.060--0.075 | 526 | high | Supreme Court of Canada Year in Review 2024 |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 21 | source-acquisition-needed | source-acquisition | legislative-response | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 22 | source-acquisition-needed | source-acquisition | remedy-timing | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 43 | context-only-blocked | candidate-verification | case-selection | missing | 2 | Post-leave hearing time | keep as contextual evidence unless recoded to a direct simulator analogue |
| 44 | context-only-blocked | candidate-verification | emergency | missing | 1 | Merits nonunanimity rate | keep as contextual evidence unless recoded to a direct simulator analogue |

## canada-scc-recent

- Court: Supreme Court of Canada
- Period: recent annual average
- Status: partial-validation-profile
- Target file(s): canada-scc-recent.csv
- Context: canadian-supreme-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 3 source rows; 1 validation-counted rows; 2 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: add denominator-backed case-selection source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | keep as contextual evidence unless recoded to a direct simulator analogue |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Leave application grant rate | 0.070--0.084 | 0.071--0.074 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Leave application grant rate | 0.0767 | 0.0697--0.0844 | 5070 | high | Supreme Court of Canada statistical summary 2015 to 2024 |
| cost | stress | Normalized direct court cost | 0.550 | 0.490--0.610 | 9 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.490 | 0.430--0.550 | 0 | medium | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 3 | contextual-source-documentation | source-promotion | cost | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 4 | contextual-source-documentation | source-promotion | political-context | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 23 | source-acquisition-needed | source-acquisition | legislative-response | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 24 | source-acquisition-needed | source-acquisition | remedy-timing | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 45 | context-only-blocked | candidate-verification | merits | missing | 1 | Section 7 Charter claimant success context | keep as contextual evidence unless recoded to a direct simulator analogue |

## cjeu-2024

- Court: Court of Justice of the European Union
- Period: 2019-2025 rule-of-law rulings | 2024
- Status: multi-target-validation-profile
- Target file(s): cjeu-2024.csv
- Context: cjeu-court-of-justice; CJEU statistics WGI V-Dem synthesis
- Evidence rows: 4 source rows; 4 validation-counted rows; 4 rows with stored denominators; 4 rows with source URLs
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
| compliance | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| route-mix | Appeal route docket share | 0.292--0.311 | 0.302--0.320 | 0.000 | within | within source range |
| route-mix | Direct-action docket share | 0.052--0.064 | 0.050--0.059 | 0.000 | within | within source range |
| route-mix | Preliminary-reference docket share | 0.613--0.633 | 0.617--0.636 | 0.000 | within | within source range |
| compliance | Full compliance with rule-of-law rulings | 0.534--0.632 | 0.613--0.633 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| route-mix | validation | Appeal route docket share | 0.3011 | 0.292--0.311 | 920 | high | Court of Justice of the European Union judicial activity statistics 2024 |
| route-mix | validation | Direct-action docket share | 0.0576 | 0.052--0.064 | 920 | high | Court of Justice of the European Union judicial activity statistics 2024 |
| route-mix | validation | Preliminary-reference docket share | 0.6228 | 0.613--0.633 | 920 | high | Court of Justice of the European Union judicial activity statistics 2024 |
| compliance | validation | Full compliance with rule-of-law rulings | 0.584 | 0.534--0.632 | 382 | medium | EIN and Democracy Reporting International Justice Delayed and Justice Denied 2025 |

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
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| cost | stress | Normalized direct court cost | 0.340 | 0.280--0.400 | 9 | medium | Institutional cost benchmark synthesis |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 5 | contextual-source-documentation | source-promotion | cost | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

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
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| cost | stress | Normalized direct court cost | 0.430 | 0.370--0.490 | 12 | medium | Institutional cost benchmark synthesis |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 6 | contextual-source-documentation | source-promotion | cost | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

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
| cost | stress-only | 2 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
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

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 7 | contextual-source-documentation | source-promotion | cost | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

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
| emergency | Rule 39 interim-measure grant rate | 0.218--0.238 | 0.217--0.251 | 0.000 | within | within source range |

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
| cost | stress-only | 2 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| merits | QPC nonconformity rate | 0.305--0.324 | 0.302--0.322 | 0.000 | within | within source range |
| remedy-timing | QPC deferred-effect share over all solutions | 0.126--0.141 | 0.134--0.147 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| merits | validation | QPC nonconformity rate | 0.3145 | 0.305--0.324 | 1011 | high | Conseil constitutionnel QPC360 statistical overview |
| remedy-timing | validation | QPC deferred-effect share over all solutions | 0.1335 | 0.126--0.141 | 1011 | high | Conseil constitutionnel QPC360 statistical overview |
| cost | stress | Normalized direct court cost | 0.340 | 0.280--0.400 | 9 | medium | Institutional cost benchmark synthesis |
| cost | stress | Normalized upstream screening cost | 0.590 | 0.520--0.660 | 0 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.500 | 0.430--0.570 | 0 | low | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 8 | contextual-source-documentation | source-promotion | cost | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 9 | contextual-source-documentation | source-promotion | political-context | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 25 | source-acquisition-needed | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## gallup-court-confidence-2024

- Court: U.S. Supreme Court
- Period: 2024 public-opinion year
- Status: source-backed-stress-profile
- Target file(s): us-supreme-court-2024-public-emergency.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 1 source rows; 0 validation-counted rows; 0 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: promote denominator-backed intake source rows

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
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 1 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

### Validation Checks

No validation-counted source-range rows are currently registered for this profile.

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| political-context | stress | Public court trust and approval | 0.420 | 0.350--0.490 | 0 | medium | Gallup Supreme Court and courts confidence reporting |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 10 | contextual-source-documentation | source-promotion | political-context | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 26 | source-acquisition-needed | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 27 | source-acquisition-needed | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 28 | source-acquisition-needed | source-acquisition | doctrine-mix | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 29 | source-acquisition-needed | source-acquisition | emergency | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 30 | source-acquisition-needed | source-acquisition | merits | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## germany-bverfg-2024

- Court: German Federal Constitutional Court
- Period: 2024
- Status: partial-validation-profile
- Target file(s): germany-bverfg-2024.csv
- Context: german-constitutional-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 4 source rows; 1 validation-counted rows; 2 rows with stored denominators; 1 rows with source URLs
- Next calibration priority: add denominator-backed case-selection source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 2 | collect denominator-backed source rows for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | stress-only | 2 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Constitutional complaint success and admission proxy | 0.006--0.012 | 0.007--0.007 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Constitutional complaint success and admission proxy | 0.0085 | 0.0062--0.0116 | 4595 | high | Federal Constitutional Court 2024 annual report |
| cost | stress | Normalized capacity strain | 0.560 | 0.500--0.640 | 0 | medium | Institutional cost benchmark synthesis |
| cost | stress | Normalized direct court cost | 0.620 | 0.560--0.680 | 16 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.740 | 0.680--0.800 | 0 | medium | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 11 | contextual-source-documentation | source-promotion | cost | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 12 | contextual-source-documentation | source-promotion | political-context | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 17 | candidate-triage-needed | candidate-verification | legislative-response | missing | 1 | Legislative response to unconstitutional-without-nullity decisions | verify primary source URL and numerator/denominator before promotion |
| 18 | candidate-triage-needed | candidate-verification | merits | missing | 1 | Constitutional complaint success or grant rate | verify primary source URL and numerator/denominator before promotion |
| 31 | source-acquisition-needed | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 32 | source-acquisition-needed | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## scdb-modern-merits-2000-2024

- Court: U.S. Supreme Court
- Period: 2000-2024 terms
- Status: partial-validation-profile
- Target file(s): us-supreme-court-2000-2024.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 7 source rows; 7 validation-counted rows; 7 rows with stored denominators; 7 rows with source URLs
- Next calibration priority: add denominator-backed intake source rows

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
| doctrine-mix | validation-counted | 7 | 7 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect contextual source pack; do not count as source-range validation without a raw simulator analogue |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| doctrine-mix | Administrative and economic regulation share | 0.193--0.250 | 0.213--0.230 | 0.000 | within | within source range |
| doctrine-mix | Criminal procedure docket share | 0.230--0.289 | 0.227--0.244 | 0.000 | within | within source range |
| doctrine-mix | Election-law docket share | 0.009--0.043 | 0.023--0.031 | 0.000 | within | within source range |
| doctrine-mix | Emergency-powers merits share | 0.000--0.019 | 0.000--0.008 | 0.000 | within | within source range |
| doctrine-mix | Civil-rights and privacy docket share | 0.137--0.191 | 0.147--0.161 | 0.000 | within | within source range |
| doctrine-mix | Federalism docket share | 0.037--0.078 | 0.055--0.065 | 0.000 | within | within source range |
| doctrine-mix | Speech docket share | 0.039--0.080 | 0.064--0.074 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| doctrine-mix | validation | Administrative and economic regulation share | 0.2216 | 0.193--0.250 | 1886 | medium | Supreme Court Database issue codebook |
| doctrine-mix | validation | Criminal procedure docket share | 0.2593 | 0.230--0.289 | 1886 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | validation | Election-law docket share | 0.0260 | 0.009--0.043 | 1886 | medium | Supreme Court Database issue codebook |
| doctrine-mix | validation | Emergency-powers merits share | 0.0053 | 0.000--0.019 | 1886 | medium | Supreme Court Database issue codebook |
| doctrine-mix | validation | Civil-rights and privacy docket share | 0.1638 | 0.137--0.191 | 1886 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | validation | Federalism docket share | 0.0573 | 0.037--0.078 | 1886 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | validation | Speech docket share | 0.0594 | 0.039--0.080 | 1886 | high | Supreme Court Database 2025 Release 01 |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 15 | contextual-source-documentation | source-acquisition | political-context | missing | 0 | -- | collect contextual source pack; do not count as source-range validation without a raw simulator analogue |
| 33 | source-acquisition-needed | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 34 | source-acquisition-needed | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 35 | source-acquisition-needed | source-acquisition | emergency | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 36 | source-acquisition-needed | source-acquisition | merits | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## scdb-postwar-merits-1946-2024

- Court: U.S. Supreme Court
- Period: 1946-2024 terms
- Status: partial-validation-profile
- Target file(s): us-supreme-court-1946-2024.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 7 source rows; 7 validation-counted rows; 7 rows with stored denominators; 7 rows with source URLs
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
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | validation-counted | 7 | 7 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| doctrine-mix | Administrative and economic regulation share | 0.199--0.236 | 0.213--0.230 | 0.000 | within | within source range |
| doctrine-mix | Criminal procedure docket share | 0.207--0.244 | 0.227--0.244 | 0.000 | within | within source range |
| doctrine-mix | Election-law docket share | 0.013--0.040 | 0.023--0.031 | 0.000 | within | within source range |
| doctrine-mix | Emergency-powers merits share | 0.000--0.012 | 0.000--0.008 | 0.000 | within | within source range |
| doctrine-mix | Civil-rights and privacy docket share | 0.135--0.169 | 0.147--0.161 | 0.000 | within | within source range |
| doctrine-mix | Federalism docket share | 0.041--0.071 | 0.055--0.065 | 0.000 | within | within source range |
| doctrine-mix | Speech docket share | 0.060--0.091 | 0.064--0.074 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| doctrine-mix | validation | Administrative and economic regulation share | 0.2171 | 0.199--0.236 | 9341 | medium | Supreme Court Database issue codebook |
| doctrine-mix | validation | Criminal procedure docket share | 0.2251 | 0.207--0.244 | 9341 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | validation | Election-law docket share | 0.0263 | 0.013--0.040 | 9341 | medium | Supreme Court Database issue codebook |
| doctrine-mix | validation | Emergency-powers merits share | 0.0011 | 0.000--0.012 | 9341 | medium | Supreme Court Database issue codebook |
| doctrine-mix | validation | Civil-rights and privacy docket share | 0.1521 | 0.135--0.169 | 9341 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | validation | Federalism docket share | 0.0559 | 0.041--0.071 | 9341 | high | Supreme Court Database 2025 Release 01 |
| doctrine-mix | validation | Speech docket share | 0.0757 | 0.060--0.091 | 9341 | high | Supreme Court Database 2025 Release 01 |

### Promotion Tasks

No promotion task is currently queued for this profile.

## scotus-emergency-2024-2025

- Court: U.S. Supreme Court
- Period: 2024-2025 emergency docket
- Status: multi-target-validation-profile
- Target file(s): us-supreme-court-2024-public-emergency.csv
- Context: us-supreme-court-benchmark; V-Dem WGI WJP Gallup synthesis
- Evidence rows: 4 source rows; 4 validation-counted rows; 4 rows with stored denominators; 4 rows with source URLs
- Next calibration priority: add denominator-backed case-selection source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| emergency | validation-counted | 3 | 3 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| merits | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| political-context | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect contextual source pack; do not count as source-range validation without a raw simulator analogue |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Certiorari or emergency screening acceptance proxy | 0.014--0.022 | 0.017--0.018 | 0.000 | within | within source range |
| emergency | Public disagreement share | 0.570--0.760 | 0.562--0.589 | 0.000 | within | within source range |
| emergency | Written explanation share | 0.200--0.360 | 0.222--0.245 | 0.000 | within | within source range |
| emergency | Substantive emergency application relief rate | 0.310--0.460 | 0.381--0.408 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Certiorari or emergency screening acceptance proxy | 0.0176 | 0.0139--0.0223 | 3856 | high | Supreme Court Journal October Term 2024 |
| emergency | validation | Public disagreement share | 0.670 | 0.570--0.760 | 43 | medium | SCOTUSblog Davis 2025 emergency docket summary |
| emergency | validation | Written explanation share | 0.279 | 0.200--0.360 | 43 | medium | SCOTUSblog Davis 2025 emergency docket summary |
| emergency | validation | Substantive emergency application relief rate | 0.440 | 0.310--0.460 | 43 | medium | SCOTUSblog Davis 2025 emergency docket summary |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 16 | contextual-source-documentation | source-acquisition | political-context | missing | 0 | -- | collect contextual source pack; do not count as source-range validation without a raw simulator analogue |
| 37 | source-acquisition-needed | source-acquisition | case-selection | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 38 | source-acquisition-needed | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 39 | source-acquisition-needed | source-acquisition | doctrine-mix | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 40 | source-acquisition-needed | source-acquisition | merits | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

## south-africa-constcourt-recent

- Court: Constitutional Court of South Africa
- Period: recent annual average
- Status: partial-validation-profile
- Target file(s): south-africa-constcourt-recent.csv
- Context: south-african-constitutional-court; V-Dem WGI WJP institutional synthesis
- Evidence rows: 4 source rows; 1 validation-counted rows; 1 rows with stored denominators; 2 rows with source URLs
- Next calibration priority: promote denominator-backed merits source rows

### Family Coverage

| Family | Coverage | Source rows | Validation rows | Out-of-range | Largest miss | Gap | Candidates | Roadmap | Next step |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation-counted | 1 | 1 | 0 | -- | 0.000 | 0 | 0 | keep as a narrow benchmark check; do not generalize to full court behavior |
| case-selection | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| emergency | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| merits | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| remedy-timing | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| legislative-response | missing | 0 | 0 | 0 | -- | 0.000 | 1 | 0 | verify primary source URL and numerator/denominator before promotion |
| route-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| compliance | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 1 | collect denominator-backed source rows for this profile-family |
| cost | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| doctrine-mix | missing | 0 | 0 | 0 | -- | 0.000 | 0 | 0 | no source row or candidate is currently registered for this profile-family |
| political-context | stress-only | 1 | 0 | 0 | -- | 0.000 | 0 | 0 | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |

### Validation Checks

| Family | Target | Source range | Model interval | Gap | Status | Miss category |
| --- | --- | --- | --- | --- | --- | --- |
| intake | Petition-to-judgment throughput proxy | 0.109--0.181 | 0.171--0.177 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Petition-to-judgment throughput proxy | 0.1408 | 0.1085--0.1809 | 355 | medium | Ally et al. Constitutional Court docket snapshot 2024 |
| merits | stress | Merits invalidation proxy | 0.5318 | 0.470--0.590 | 0 | medium | Constitutional Court statistics synthesis |
| cost | stress | Normalized capacity strain | 0.680 | 0.610--0.750 | 0 | medium | Institutional cost benchmark synthesis |
| political-context | stress | Public trust proxy | 0.430 | 0.360--0.500 | 0 | medium | Comparative calibration research synthesis |

### Promotion Tasks

| Rank | Readiness | Action | Family | Coverage | Candidate rows | Top candidate | Recommended action |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 2 | needs-source-documentation | source-promotion | merits | stress-only | 0 | -- | verify denominator, source URL, coding rule, and direct analogue before promoting stress-only rows |
| 13 | contextual-source-documentation | source-promotion | cost | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 14 | contextual-source-documentation | source-promotion | political-context | stress-only | 0 | -- | document raw source trail for contextual use; do not promote normalized cost or public-trust proxy rows into validation |
| 19 | candidate-triage-needed | candidate-verification | legislative-response | missing | 1 | Legislative response to suspended declarations of invalidity | verify primary source URL and numerator/denominator before promotion |
| 41 | source-acquisition-needed | source-acquisition | compliance | missing | 0 | -- | collect denominator-backed source rows for this profile-family |
| 42 | source-acquisition-needed | source-acquisition | remedy-timing | missing | 0 | -- | collect denominator-backed source rows for this profile-family |

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
| legislative-response | Strict response after declarations of incompatibility | 0.430--0.460 | 0.423--0.442 | 0.000 | within | within source range |

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
| case-selection | Permission-to-appeal case-selection access proxy | 0.345--0.375 | 0.358--0.377 | 0.000 | within | within source range |

### Source Rows

| Family | Use | Target | Observed | Range | N | Reliability | Source |
| --- | --- | --- | --- | --- | --- | --- | --- |
| intake | validation | Permission-to-appeal grant rate | 0.3610 | 0.345--0.375 | 170 | high | UK Supreme Court Annual Report and Accounts 2024-2025 |
| case-selection | validation | Permission-to-appeal case-selection access proxy | 0.3610 | 0.345--0.375 | 170 | high | UK Supreme Court Annual Report and Accounts 2024-2025 |

### Promotion Tasks

No promotion task is currently queued for this profile.
