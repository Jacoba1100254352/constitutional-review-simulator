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

## Streaming institutional runner checkpoint

The eight-design runner and input generator now implement the registered grid.
Regression tests verify exact base-outcome agreement with the legacy Simulator,
only-field configuration ablations, independent response seeds, all four
sampling laws, complete small-grid exports and byte-identical reruns. Native
Java tests and 37 Python measurement tests passed before full-grid execution.
The [data contract](historical-robustness-data-contract.md) records output keys,
pairing, source provenance and reproduction commands.

Code inspection before the full grid identified a measurement limitation:
`averageTimeToReview` averages the shared case input, so paired design
contrasts are necessarily zero. The definition is preserved. This component
cannot support the procedure-delay claim; institutional delay cost is a
different diagnostic and will not replace the registered endpoint.

The full grid and subsequent analyses are not completed by the runner tests.

## Full simulation and independent raw audit checkpoint

Runner source was committed and pushed as `8381c12` before the full grid was
executed. All four forecast profiles, thirteen contexts, eight designs, 120
runs and 80 cases per run completed without reducing the registered sample.
The simulation manifest records source/input/output hashes and the runtime:
Java release-21 compilation on OpenJDK 25. The run contains:

- 49,920 design-run observations and 3,993,600 case outcomes;
- 5,193,352 challenged-object outcomes;
- 6,240 shared dockets with 499,200 cases and 649,169 challenged objects;
- 199,680 independently checked voting/response stream identities.

An independent streaming Python audit reconstructed 84 run measures from
the raw outcomes, covering all twelve normative-weight measures and the
registered claim measurements. It independently rebuilt every complete
ordered case/object hash and reconciled all output counts. This audit uses
explicit field and denominator rules, not Java's aggregation/reflection code.
The report is `reports/constitutional-review-historical-robustness-v1-raw-audit.json`.

The audit also records 2,792 design-runs without emergency orders and 37,440
without legislative responses. Existing conditional rates return zero for
these empty denominators. In particular, response-off zero timeliness/delay
must not be interpreted as a late or instantaneous legislative response.
The fixed docket-defined average review-time contrast is zero in every pair.

All 43 Python measurement tests pass, including cross-language reconstruction,
deliberately corrupted raw exports, and anonymous-package inclusion/exclusion
tests. Native Java runner tests, historical score/input checks, calibration,
research-data, court-profile, empirical-platform and legacy-preservation checks
also pass. Retained compressed evidence has been checked for local-path and
credential markers. Large raw outputs and original source caches are excluded
from review packages; the final rebuilt package still requires its full audit.

The final staged secret scan raised one generic-key false positive on the
manifest's SHA-256 for `CostProfileKey.java`. Independently hashing that public
Java source reproduced the exact recorded value, confirming it is a source
checksum, not a credential. No secret-scanner rule or allowlist was weakened.

Remaining mandatory work: paired bootstrap contrasts, normative-weight
sensitivity, claim-to-evidence matrix, updated empirical/institutional report,
manuscript and supplement integration, complete native CI, rendered PDF checks,
and an extracted anonymous replication check. No robustness result, winning
institution or goal completion is claimed by this simulation checkpoint.

## Paired inference and normative analysis checkpoint

Analysis estimands and claim bindings were committed as `e11a48a` before
computing comparative estimates. This operationalization occurred after the
simulation, as disclosed in the analysis contract; it is not represented as
an independent preregistration. The original protocol and empirical first
evaluation remain unchanged.

The analysis now reports 3,692 paired contrasts across all 52 cells, with
2,000 run-block bootstrap replicates, 22 claim/diagnostic components, and
1,000 shared Dirichlet normative-weight vectors. It includes response-off and
half-response persistence comparisons, direct-only versus full accounting,
624 leadership rows and 6,000 fixed-preference cross-grid comparisons.
Conditional Monte Carlo intervals, fixed-grid ranges and preference
sensitivity are separate quantities.

The validation workflow identified an important interpretation hazard:
at low emergency pressure, the reasoned design has no emergency orders in
116 to 119 of 120 runs. The original zero-denominator convention creates
apparent reason-giving reversals. Integer-reconciled event counts and pooled
rates were added as explicitly post-estimate diagnostics, not replacement
endpoints. All original 3,692 contrast bytes and leadership bytes remained
unchanged after adding that explanation.

The results qualify three manuscript claims. Emergency irregularity falls
throughout the grid, but the review-time endpoint cannot identify procedural
duration. Council upstream-cost differences stay below the practical
threshold, and changing the council structure does not materially change
that upstream measure. Turning weak-form response off reduces responsiveness
and increases veto risk, but several advantages and substantial sampled
leadership persist, exposing dependence on other modeled design/score terms.
None of these are empirical reform effects or an institutional recommendation.

Independent calculation checks verify every point estimate and Monte Carlo
standard error, 93 expanded-index bootstrap intervals, every component
classification, all preference vectors and leadership comparisons, and every
conditional-denominator diagnostic. A full analysis rerun reproduces every
saved output byte. All 57 Python measurement tests pass, including deliberately
wrong but rehashed results that the independent validator rejects.

The final checkpoint reran the native Java suite, all 57 Python tests, the
full-field empirical report check, retained-study provenance, and full bytewise
analysis reproduction. The independent checker additionally verifies merits
follow-up counts and pooled rates, eligible-run counts, and the cost-accounting
practical-sign flag; deliberately changed but rehashed versions are rejected.
Python compilation and whitespace checks pass. The optional Ruff version guard
remains unresolved and was not bypassed.

Remaining mandatory work: integrate the findings into the manuscript and
supplement; run complete native CI, rendered publication checks and an
extracted anonymous replication audit. The goal remains active.

## Manuscript and supplement integration checkpoint

The paired analysis and independent checks were committed and pushed as
`4f4e836`. The main manuscript now reports the frozen new-term test and the
three qualified institutional claims. The supplement preserves all 22
components, all 49 intervention/persistence patterns, all 71 reference-cell
intervals, nine empirical paired scores, and the forecast, denominator,
context, accounting and normative tables. Thirteen new tables plus a
publication manifest are generated directly from verified evidence, with no
refitting or replacement of the original evaluation. The manuscript explicitly
discloses the timing of the signed analysis contract and post-estimate
denominator diagnostic.

Four new publication tests check table inclusion/coverage, unfiltered value
projection, stale generated tables, and changed source evidence. Two additional
anonymous-package tests verify decoded gzip inspection and detection across
stream-read boundaries. All 63 Python measurement tests and the native Java
suite pass at the full-CI test stage.

The first integrated render has 22 main-text pages and 33 supplementary pages.
Every page was rendered and inspected in a contact overview, with detailed
inspection of the new score, claim, interval, denominator, accounting and
leadership pages. No clipping or table overlap was found. Final LaTeX logs have
no unresolved references/citations or overfull boxes. Native main-text float
auditing reports zero severe findings and zero whitespace warnings. Bounding-box
checks cover all 55 pages with no empty pages or off-page words; extracted text
contains no unresolved-reference or private-path markers, and PDF author
metadata is blank. Existing underfull-spacing notices in long references and
legacy dense model tables are not overflow findings.

The complete `make ci` subsequently passed: calibration, research data, court
profiles, all tests, all four original campaigns and their raw object/case
reconciliation, all 96 legacy aggregate fields across eight presets, empirical
platform consistency, retained historical provenance, full bytewise analysis
reproduction, independent analysis validation, manuscript/supplement builds,
format and float checks, and anonymous source/replication/review packaging.
All tracked original campaign results remain unchanged. France QPC merits
invalidation and CJEU rule-of-law compliance remain the two reported misses.

The final built PDFs are byte-identical to those visually inspected above:

| PDF | SHA-256 |
| --- | --- |
| Main manuscript | `8796fc90d0faa91420915258df2bc93951f0ffbf57ef1f3712c55984ccb0370e` |
| Supplement | `1a88038b17173eb0b762c860397c638f34a0533a70c94e43ace4f8f92e5217f6` |

The staged integration secret scan reports no leaks. Extracted anonymous
replication and the final requirement-by-requirement completion audit remain
mandatory. This checkpoint is not overall goal completion.

## Extracted-package failure and correction

The first fresh anonymous extraction reacquired both pinned SCDB sources,
verified all eight empirical reports, passed the native Java and 63 Python
tests, regenerated/reconciled all four original campaigns, preserved all 96
legacy fields across eight presets, and reproduced the retained historical
analysis and its independent validation. It then failed the manuscript format
gate because that gate unconditionally read `AGENTS.md`, a developer-only file
intentionally excluded from the anonymous package. Consequently that command
chain did not reach the full historical simulation or final publication build.
This failed attempt is not counted as complete replication.

The correction keeps developer instructions optional only for this privacy
scan. Present instructions, required publication files and report manifests
are still scanned, and missing required publication inputs fail explicitly.
Three regression tests cover an anonymous tree without instructions, private
paths in every scanned file category, and missing required inputs. The source
archive policy is unchanged; developer instructions are not added to review
materials. No model, input, estimate or manuscript content changes as a result.
The corrected package must pass a new extracted run before completion.
