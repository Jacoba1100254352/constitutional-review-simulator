# Institutional analysis implementation contract

Recorded 12 September 2026 after the full simulation and raw audit, but before
computing comparative study estimates or normative leadership. This document
operationalizes the unchanged frozen protocol. It is not an additional
independent preregistration or an assertion that generated data were
unavailable. The code/measurement inspection already established the
docket-defined duration limitation and the raw audit exposed empty conditional
denominators. Those facts are retained rather than hidden.

## Units, contrasts and uncertainty

Use all 52 forecast/context cells and all 120 paired runs per cell. A point
contrast is the arithmetic mean of the 120 within-run design differences.
For conditional rates this is an equal-run estimand retaining the original
zero-denominator convention, not a pooled case-level conditional rate. Export
empty-denominator run counts by design/cell and keep their interpretive limits
next to the relevant claims.

Use a Python standard-library `random.Random(20260912)` generator to sample
120 run indices with replacement for each of 2,000 replicates. Reuse that same
index matrix across all metrics, designs, contexts and forecast profiles. Each
contrast uses both designs from the same sampled run. Compute the 2.5th and
97.5th percentiles by linear interpolation at `(n-1)*p`. Also report the sample
standard deviation of paired differences divided by the square root of 120.
These are conditional Monte Carlo uncertainty measures for a fixed simulated
environment. No cell resampling or interval over the structural grid is used.

Registered base contrasts are reasoned minus current, council minus current
and weak-form minus current. Ablation contrasts are changed procedure minus
reasoned, changed structure minus council, half response minus weak form and
no response minus weak form. Additionally report half/no response minus
current, with those comparisons explicitly identified as persistence checks.
Include the registered endpoints and separately labeled delay-cost,
administrative-load and conditional response-delay diagnostics.

`config/historical-benchmark/claim-components.csv` binds the protocol's verbal
component expectations to signed columns. Zero means no directional
superiority was specified, not a null-effect hypothesis. In particular, the
screening claim does not require a council to be cheaper at the top body, nor
does the weak-form claim prespecify cost superiority. These columns remain
fully reported without inventing a favored direction after seeing estimates.

For signed components, apply the registered strict +/-0.01 thresholds to all
52 base-contrast point estimates: stable if every estimate retains the expected
direction beyond the threshold, sign-reversing if both practical signs occur,
and mixed/weak otherwise. For unsigned diagnostics report their positive,
negative and near-zero counts without awarding a stable directional claim.
Separately count intervals excluding zero. These unadjusted component
intervals are descriptive, not a familywise discovery guarantee.

The claim matrix distinguishes this numerical pattern from evidential status.
A stable procedural activation is not independent downstream validation.
The duration endpoint is unsupported for design-specific duration regardless
of its numeric classification. Conditional timeliness with no responses in a
comparator cannot demonstrate that its responses were slower. Index movements
remain consequences of the model, not identified effects of real reforms.

## Cost accounting diagnostic

Compare council-minus-current differences under directCourtCost and under
totalInstitutionalCost, with paired intervals and any practical sign change.
Also report their difference. This switches accounting views only; it does
not change an institution. Both are normalized indices and the total index
has its own weighting, so the difference is not a monetary omitted-cost
amount or a literal additive decomposition.

## Normative sensitivity

Generate the registered 1,000 Dirichlet(1,...,1) vectors with an independent
`random.Random(2026091202)`: draw twelve positive uniforms using `random()`,
redraw a zero if encountered, transform by `-log(U)` and normalize by their
sum. Metric order is the six higher-is-better fields followed by the six
lower-is-better fields in the locked protocol. Invert only the latter as
`1-x`; do not fit, standardize or rescale metrics using the observed grid.
Save all weight vectors and reuse them in every cell and comparison.

Score each design's equal-run metric means. Among the four base designs,
split leadership credit equally for scores within 1e-12 of the maximum.
Report per-cell leadership shares and all six pairwise preference reversals.
Also report whether the same preference vector reverses each pair's ordering
across contexts/profiles. These are finite preference/grid exercises, not
population probabilities or welfare estimates.

For response dependence, repeat the four-design comparison replacing only
the weak-form entry with its half-response or no-response variant. Retain
the same other three designs and the same weights. Report leadership changes
and weighted-score changes relative to full response. Preference variation,
structural variation and run-bootstrap uncertainty remain separate outputs.

## Verification and release boundary

Use the audited run exports and verify their hashes/provenance before analysis.
Do not edit the frozen first evaluation, its two core scripts, forecasts or
simulation source merely to improve study results. Test pairing, resampling,
percentiles, sign thresholds, empty denominators, equal-run weighting,
Dirichlet vectors, ties, shared preferences and response replacement with
small independently calculable fixtures. Recompute output tables and headline
claims; retain all component results, including null and negative findings.
The main simulator and this analysis remain free of third-party dependencies.

Publication integration, rendered artifacts, full native CI and extracted
anonymous replication remain required after the analysis checkpoint.
