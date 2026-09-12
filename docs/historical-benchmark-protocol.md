# Historical Benchmark and Robustness v1: frozen protocol

Protocol date: 12 September 2026. Initial implementation revision:
`8edf83b58fb73ef114e63890e6bf98578b3075f0`.
The machine-readable specification is
`config/historical-benchmark/protocol-v1.json`. This protocol must be committed
before downloading or evaluating the SCDB 2026 Release 01 case records. It is
a repository-registered analysis plan, not independent external preregistration.
Later corrections must be additive, dated amendments; retain the first result
and distinguish corrected results from new exploratory specifications.

## Question and scope

Can a historically estimated distribution of docket categories transfer to a
new Supreme Court term, and which modeled institutional tradeoffs survive
changes in docket mix, mechanisms, context, and normative weights? The empirical
endpoint is docket composition. It is not merits-outcome accuracy, rights
correctness, a causal reform estimate, or validation of an entire court.
Public SCDB inputs supply doctrine frequencies only. All other case and
institutional variables remain labeled synthetic assumptions.

The bounded deliverables are a period-aware source pipeline, frozen test,
paired robustness study of three existing claims, claim-to-evidence matrix,
updated manuscript and supplement, and runnable anonymous-safe replication.
Failure to outperform a baseline is a substantive result, not a reason to
change the endpoint, refit on the test term, widen bounds, or delay completion.

## Sources, unit, exclusions, and missingness

Use the official [2025 Release 01](https://scdb.la.psu.edu/data/2025-release-01/)
for every fitted pre-2025 distribution and retrospective test. Use
[2026 Release 01](https://scdb.la.psu.edu/data/2026-release-01/) only for the new
2025-term test and a separate historical-revision audit. Pin release-specific
ZIP URLs, download dates, ZIP and CSV SHA-256 hashes, member names, headers,
record counts, and term bounds. No automatic switch to a later release.

The unit is the case-centered Supreme Court Citation row, which consolidates
multiple dockets and issues into one dispute. Preserve the complete public
source separately from the minimum derived fields: case ID, term, decision
date, issue, issue area, assigned category, and mapping status. Check unique
case IDs, valid integral terms, CSV row width, numeric code syntax, and
source-specific term bounds. Duplicate identifiers and malformed rows fail
ingestion rather than being silently dropped. Missing decision dates remain
flagged; the coded term determines the partition, not calendar decision year.
Include every citation row in the stated term window, regardless of decision
type or whether the dispute is constitutional. Do not call this the universe
of constitutional merits challenges or of petitions seeking review.

Every row contributes exactly once to an eight-category denominator. In order:
election issues 20010, 20020, 20030, 20090, 30140; emergency issue 130015;
administrative issue 90120; then, if either required issue code is missing,
OTHER with a missing-code flag; otherwise issue areas 3, {2,5}, 1, {10,11}, 8
map respectively to speech, equality, criminal procedure, federalism, and
administrative state. All residual areas map to OTHER, retaining the source
codes and an explicit residual/unrecognized-area status. Missing codes are not
imputed from the test distribution. Report missing and residual counts by term.
Fail on a category-probability sum different from one within 1e-12.

Election-first priority removes an overlap in the legacy independent source
predicates (issue 30140 can also meet speech area 3). Report the affected rows
and legacy-predicate versus partition totals. Preserve all existing source
definitions and checks. The new partition is a separate contract, not an
unannounced rewrite of their denominators.

## Exposure, split roles, and fitting

See `docs/historical-benchmark-exposure-audit.md`. The frozen generator's
constants were informed by aggregate evidence through 2024; it is not an
unexposed comparator for older terms. Terms 2005-2014 are development
backtests; 2015-2024 are explicitly retrospective diagnostics. For each target
term t, statistical comparators receive only rows with term < t, from the old
release. Hyperparameters below are fixed now and are not selected by the new
term's scores. No refitting of the institutional model is authorized by this
docket-composition benchmark.

The primary new-data term is 2025. Train its statistical comparators only on
the 2025 release through 2024, not revised pre-2025 rows from the newer release.
Write and lock all four forecast vectors and their training-row hashes before
opening the new case dataset. Evaluate once and retain immutable first-result
bytes with forecast, protocol, source, and evaluation-code hashes. A rerun may
verify the same results but cannot overwrite a divergent first evaluation.
If the exposure audit uncovers prior use of 2025 case data, label the test
exposed and retain it as a retrospective test, with no unseen-data claim.

Models for target term t:

1. Frozen existing generator: the eight exact probabilities captured in the
   machine protocol from the initial WorldGenerator. Score its categorical
   law analytically, avoiding Monte Carlo noise in the primary empirical test.
2. Training-only empirical profile: all rows in t-15 through t-1, with each
   row weighted by 2^(-((t-1)-term)/5), plus a 0.5 pseudocount per category.
3. Expanding-history baseline: all available 1946 through t-1 rows, with a
   0.5 pseudocount per category.
4. Previous-term baseline: t-1 rows only, with a 0.5 pseudocount per category.

Normalize each model's eight counts once. No future-term fallback is allowed.
An empty required training window or test denominator is an explicit error.
Final empirical stress profiles are these four predictions for 2025, not the
observed test frequencies. Simulated draw-frequency tests separately verify
that the Java sampler implements those probabilities.

## Scores and uncertainty

Primary score is mean multiclass Brier score:
sum over categories of (p_k - 1[y=k])^2, averaged over target rows. Lower is
better. Secondary diagnostics are mean natural-log loss (-log p_y) and total
variation (half the sum of absolute forecast/observed share differences).
Report all category counts/shares, per-term scores, paired score differences,
equal-term averages, and pooled case-weighted summaries without picking the
most flattering weighting. No multiplicity-adjusted discovery claim is made.

Use 2,000 deterministic bootstrap replicates, seed 20260912. For 2025 report
paired case-resampling percentile 95% intervals for score differences, holding
forecasts fixed. This is conditional within-term uncertainty; one term cannot
estimate between-term forecast uncertainty and independent-case resampling
does not resolve dependence among related disputes. For retrospective
equal-term mean differences, resample whole target terms. Separately resample
training terms with replacement and recompute the empirical forecast to show
training-composition uncertainty. Do not conflate these intervals with
Monte Carlo error or structural model uncertainty. For zero/one available
cluster, state the interval limitation rather than manufacturing replication.
Percentiles use linear interpolation at (n-1)*p. Score differences must use the
same sampled cases/terms for both compared methods.

Primary descriptive comparison is the empirical profile minus the frozen
generator's Brier score on 2025; also compare against both historical baselines.
Report a clear conditional advantage only when the paired interval is below
zero. Otherwise report the observed difference with uncertainty, including
losses. Never interpret that result as evidence about substantive case outcomes.

## Historical revision audit

Join old and new releases on stable case ID for terms through 2024. Report
additions, removals, and changes to term, decision date, issue, and issue area,
with category-transition counts. Check the original full headers/row values
separately and report other revised fields without using them in fitting.
Keep changes to previously published observations separate from 2025 rows.
Record unmatched IDs and changes in missingness; never merge revised outcomes
back into locked training data. A matching ID is not assumed to prove that the
entire source row is unchanged.

## Paired institutional robustness study

Use the four locked forecast docket profiles, 120 independent runs, 80 cases
per run, four review periods, seed 2026091201. Generate identical dockets for
each scenario in a matched run. Pair run-level contrasts; use 2,000 run-block
bootstrap replicates for Monte Carlo intervals. Scenario-specific voting
streams may differ; record their deterministic identities and do not claim
identical voting draws or that a shared seed alone proves paired dockets.
Preserve the existing campaign and seed behavior; this is an opt-in experiment.

Run the default WorldSpec and the twelve one-at-a-time alternatives in the
machine protocol. Do not choose settings based on which claim they support.
The four base designs are current-style court, reasoned emergency review,
constitutional council, and weak-form review. Their existing bundles differ
on several dimensions. Base-design contrasts alone do not isolate a mechanism.

Predefined claims and ablations:

| Claim | Base contrast and measurements | Mechanism check |
| --- | --- | --- |
| Emergency transparency has delay/cost tradeoffs | Reasoned minus current: emergency reasons, merits follow-up, average review time, total institutional cost, shadow-docket abuse | Change only the reasoned design's docket procedure to FAST_SHADOW_DOCKET; retain its other institutional parameters. |
| Screening burdens can move outside the reviewing body | Council minus current: direct court, upstream screening, capacity strain and total cost, intake and council-screen rates | Change only the council's review structure to FULL_COURT. Also compare direct-only versus full cost accounting; label the former an accounting omission, not an institutional intervention. |
| Weak-form advantages depend on legislative response assumptions | Weak-form minus current: response rate/credibility, timely response, rights protection, compliance, democratic responsiveness, veto risk and total cost | Add opt-in response factors 0.5 and 0: multiply response credibility before downstream evaluation and independently retain otherwise-positive response events with that probability. At zero, no legislative response occurs. Factor 1 preserves exact legacy behavior. Report whether downstream outcomes actually respond. |

The response intervention must propagate through timing, enforcement and score
paths that consume response state. Do not merely relabel an output column.
Retain an independent event stream for response thinning so unchanged branches
do not consume extra legacy random draws. Record any irreducible assumptions
or mechanically encoded advantages revealed by the ablations.

Use practical sign thresholds +/-0.01 on the existing normalized metric scales.
Report all contrasts and interval endpoints, including near-zero cases. Label
each claim component stable if every non-ablated context/profile cell retains
the hypothesized direction beyond this threshold, sign-reversing if at least
one is above +0.01 and another below -0.01, and mixed/weak otherwise. Separately
show how often the run-bootstrap intervals exclude zero. Do not convert this
grid into a probability over real political environments. Ablations identify
model dependence; they are not expected to preserve the base claim.

Sample 1,000 Dirichlet(1,...,1) normative-weight vectors over the twelve named
metrics in the machine protocol using seed 2026091202. Generate weights as
independent -log(U) values normalized by their sum. Invert lower-is-better
metrics as 1-x, without empirical rescaling. Use the same weights for every
design/context/profile, report leadership shares among the four base designs,
pairwise reversals and response-ablation effects. Ties within 1e-12 split credit.
These weight draws are an illustrative preference sensitivity exercise, not a
survey of legitimate values or a welfare function.

## Verification and completion

Automate source identity/schema checks, non-overlapping temporal partitions,
category reconciliation, explicit missingness, train-only fitting, source
revision separation, sampler fidelity, paired docket identity, active ablation
effects, immutable first evaluation, and deterministic re-execution. Include
adversarial tests for duplicate IDs, overlapping categories, empty periods,
future rows, release substitution, altered forecasts, and fake all-clear claims.

Preserve the original benchmark definitions and legacy outputs outside opt-in
extensions. Retain the known France QPC and CJEU misses with no source-bound
widening. Build the benchmark report and claim matrix from the actual results,
then update main and supplementary tables, evidence limits, and replication
recipes. Complete the native CI, PDF visual/structural checks, archive privacy
checks, and an extracted-replication check before final delivery. Commit and
push validated increments. No additional country acquisition, future data,
perfect fit, or institutional winner is required for this milestone.
