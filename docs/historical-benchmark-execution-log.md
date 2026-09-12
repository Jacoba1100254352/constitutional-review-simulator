# Historical benchmark execution record

This is an additive execution record for the frozen protocol, not a replacement
protocol or evidence of external preregistration. Times below are UTC.

## Completed evidence checkpoints

| Event | Authoritative record |
| --- | --- |
| Initial model | `8edf83b58fb73ef114e63890e6bf98578b3075f0`; source hashes and eight fixed weights in the protocol |
| Protocol and exposure audit frozen and pushed | `9ff474650c65e7b8817c19899181c5c9b97de818` |
| Old release acquired | 2026-09-12T22:11:49.224717+00:00; source registry records the protocol commit and original ZIP/CSV hashes |
| Training-only forecasts and scoring implementation frozen and pushed | `61944e13d52a02fdb7d900cdbcc9fcfff231f1fb` |
| New release acquired after forecast freeze | 2026-09-12T22:20:56.935881+00:00; source registry records `61944e1` as the acquisition revision |
| First 2025-term evaluation retained | 2026-09-12T22:21:50.263199+00:00; first-evaluation lock records SHA-256 `4344593b9c6db932ce06ef7e5084d2f9577d838208f3f6df3be354142c7c08cb` |

The new-term evaluation contains 66 case-centered citation disputes and no IDs
present in the original training release. The newer release separately adds
two historical records and changes ten prior records. The old 9,341-record
training source remains unchanged. All 53 original fields are compared in the
revision audit, including fields not used in the category mapping.

The primary empirical-minus-fixed-generator Brier difference is
0.001704434404425358, with a paired conditional 95% interval approximately
[-0.007500, 0.010336]. This is not a clear conditional advantage. The primary
score, competing baselines, and fitted hyperparameters are not changed after
this result. Secondary metrics and all retrospective results remain reported,
without substituting a favorable secondary endpoint for the primary one.

## Interpretation and verification boundaries

- The source unit is all citation-centered disputes, not only constitutional
  merits challenges. The test concerns category composition, not substantive
  judicial outcomes or effects of institutional reforms.
- Older terms are retrospective and exposed through the legacy generator's
  aggregate calibration. The new term is a scoped data holdout after a recorded
  forecast freeze, not a claim of blindness to public events.
- The two source releases, observed new-term records, and four predicted docket
  profiles are separate artifacts. Only the four pre-test forecast vectors
  will feed the institutional robustness study.
- Optional guarded Ruff preflight did not run: approved version 0.16.2 differs
  from installed 0.16.7. Its guard was not bypassed. Native Java/Python tests,
  compile checks, source/forecast checks, and redacted staged secret scans are
  the verified checks for the initial implementation milestones.

The institutional robustness study, mechanism interventions, claim matrix,
manuscript integration, complete CI, rendered publication checks, and final
extracted replication audit are not completed by this empirical checkpoint.
Keep the overall goal active until those deliverables are verified.

## Opt-in simulation interfaces

The next implementation increment adds an immutable eight-category
`DoctrineDistribution`, strict profile-CSV reader, an explicit Simulator/WorldGenerator
override, and a case-keyed `ResponseIntervention`. Existing callers retain the
original generator and response logic. Historical profiles cannot silently
replace imported legislative stress signals. The future study runner must give
the response intervention a separately derived run/period seed.

Native tests confirm the declared sampling law, deterministic reruns, identical
case/object dockets across compared designs, exact factor-one identity, and
propagation of a zero-response intervention to actual law effectiveness and
rights outcomes. Invalid vectors, duplicate profile keys, and invalid response
factors are rejected.

A fresh standard validation campaign with 120 runs and 80 cases per run was
written to a separate temporary directory. Its aggregate CSV, calibration CSV,
aggregate intervals, compressed case export, and compressed object export were
byte-identical to the existing corresponding artifacts. The independent object
guard reconciled 99,990 objects, 76,800 cases, and eight aggregates. This tests
legacy behavior with the interventions disabled, not the full robustness grid.
The Java suite and all 32 Python measurement tests passed; the immutable first
empirical evaluation still reproduces exactly.

Still required: generate study inputs from the four locked forecasts; implement
the eight-scenario runner and two remaining configuration ablations; execute
all four docket profiles by thirteen context settings with the registered
run/case counts; calculate paired contrasts, uncertainty and normative-weight
sensitivity; build the claim matrix; integrate and validate publication and
replication artifacts. No full-grid institutional result is claimed yet.
