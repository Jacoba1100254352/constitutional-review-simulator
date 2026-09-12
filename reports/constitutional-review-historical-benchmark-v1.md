# Historical Benchmark v1: empirical docket evaluation

The frozen 2025-term test contains **66 citation-centered disputes**. The training-only
empirical profile shows **no clear conditional advantage** relative to the fixed generator on the primary
Brier score: difference 0.001704, paired 95% interval
[-0.007500, 0.010336]. Lower scores are better.

These are docket-composition results, not legal-outcome predictions or empirical proof that
institutional reforms work. The one-term interval is conditional case-resampling uncertainty;
it does not establish across-term forecast reliability or account fully for related disputes.

## Locked new-term comparison

| Forecast | Brier | Log loss | Total variation |
| --- | ---: | ---: | ---: |
| frozen-generator | 0.808763 | 1.851358 | 0.149164 |
| recency-weighted-15y | 0.810467 | 1.839549 | 0.139124 |
| expanding-history | 0.811932 | 1.903366 | 0.166701 |
| previous-term | 0.832416 | 1.984112 | 0.233512 |

| Category | Cases | Share |
| --- | ---: | ---: |
| SPEECH | 2 | 0.0303 |
| EQUALITY | 6 | 0.0909 |
| CRIMINAL_PROCEDURE | 20 | 0.3030 |
| FEDERALISM | 3 | 0.0455 |
| ELECTION_LAW | 4 | 0.0606 |
| EMERGENCY_POWERS | 2 | 0.0303 |
| ADMINISTRATIVE_STATE | 16 | 0.2424 |
| OTHER | 13 | 0.1970 |

## Source quality and historical revisions

The original development release has 9341 records through 2024.
The newer release has 9343 records through 2024 and 66 new-term records.
Historical revision status counts: `{"added-historical": 2, "changed": 10}`.
The full-row audit compares every original source field as well as the minimal derived variables.
Revisions do not replace the old training records. All source ZIPs, CSV members, derivatives,
forecasts, and the first evaluation are identified by hashes.

- SCDB_2025_01: 9341 rows; 65 missing issue codes; 65 missing issue-area codes; 0 missing dates; 0 unrecognized areas; 29 cases meeting multiple legacy predicates.
- SCDB_2026_01: 9409 rows; 67 missing issue codes; 67 missing issue-area codes; 0 missing dates; 0 unrecognized areas; 30 cases meeting multiple legacy predicates.

Missing and residual codes remain visible within OTHER, not dropped from the denominator.
The new partition resolves legacy overlap without altering any existing benchmark definition.

## Retrospective checks

Earlier target terms already contributed to the original generator's aggregate calibration.
They are retrospective diagnostics, never untouched holdouts. Statistical comparators use
only earlier terms; the fixed generator is an exposed comparator for all these periods.

| Role | Model | Equal-term Brier | Case-weighted Brier |
| --- | --- | ---: | ---: |
| development-retrospective | frozen-generator | 0.801264 | 0.801170 |
| development-retrospective | recency-weighted-15y | 0.799173 | 0.798827 |
| development-retrospective | expanding-history | 0.805681 | 0.805631 |
| development-retrospective | previous-term | 0.803977 | 0.803687 |
| retrospective-exposed | frozen-generator | 0.806300 | 0.805101 |
| retrospective-exposed | recency-weighted-15y | 0.807843 | 0.806526 |
| retrospective-exposed | expanding-history | 0.807233 | 0.806009 |
| retrospective-exposed | previous-term | 0.818866 | 0.817429 |

Separate files retain per-term scores, paired target-term intervals, all category counts,
missingness, legacy-predicate counts, full-field revision details, and training-term uncertainty.
The fixed hyperparameters were not selected using the 2025 results. The first evaluation is
immutable; subsequent exploratory models must not replace it.

## Remaining work and claim boundary

This report completes the empirical docket test, not Historical Benchmark and Robustness v1
as a whole. The [paired institutional analysis](constitutional-review-historical-robustness-v1.md)
reports the mechanism ablations, normative-weight sensitivity and claim-to-evidence matrix
separately. Manuscript integration and final publication/replication checks remain required
before the overall milestone is complete. No whole-court or causal claim follows from these scores.
