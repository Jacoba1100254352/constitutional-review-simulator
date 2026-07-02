# Calibration Target Methods

This note describes how the calibration target files should be interpreted in
the paper and replication package. The targets are a transparent benchmark
registry used for source-range checks and calibration planning.

## Target Tiers

- `high`: direct source-derived or codebook-derived target with a reasonably
  clear mapping to a simulator metric.
- `medium`: documented but approximate proxy, normalized institutional-cost
  benchmark, or cross-source synthesis with a clear note.
- `low`: contextual reference only. These rows should not carry validation
  weight unless replaced by a source-specific dataset.

Rows with a source URL and nonzero `n` are the strongest targets. Rows with a
source URL but `n=0` may still be source-backed ratio or codebook targets, but
they lack a stored denominator and should not support precision claims until the
denominator is added. Rows with no source URL, low reliability, contextual
public-trust proxies, normalized cost benchmarks, or broad comparative
synthesis labels are provisional stress-test ranges. They remain in the
repository so that weak assumptions are visible, editable, and excluded from
source-range fit counts.

Deep Research outputs and other secondary research notes can produce useful
candidate rows before they are ready for calibration. Those rows belong in
`config/research/*-source-candidates.csv` or an operationalization file, not in
the source-counted calibration matrix. A candidate row may preserve a
numerator, denominator, period, and plausible simulator mapping, but it should
remain a source-candidate until the original source URL, denominator
construction, category coding, and direct analogue to a simulator metric are
verified from the primary source.

## Current Target Families

- U.S. doctrine mix targets use Supreme Court Database issue-area and issue-code
  mappings. These are docket-composition checks, not substantive outcome
  validation.
- U.S. emergency-docket targets use a bounded emergency-application summary and
  therefore should be interpreted as emergency-procedure context, not as a full
  merits docket.
- Public-trust rows are contextual political-environment checks. They should not
  be treated as direct evidence that the simulated reaction state matches public
  opinion.
- Intake, leave, complaint, and petition-throughput rows are court-access
  proxies. They are useful for checking order of magnitude but depend heavily on
  local doctrine, jurisdiction, filing rules, and reporting conventions.
- Cost rows are normalized institutional-cost benchmarks. They are appropriate
  for stress-testing relative burden, not for estimating actual budgets.

## External Source-Range Use

Only rows with `useForValidation=true` are counted in the manuscript's
external source-range table. The source-matrix builder rejects counted rows that
lack a source URL, lack a nonzero denominator, have low reliability, use any
synthesis source or synthesis method label, use contextual public-trust
proxies, or use normalized-cost/benchmark-cost construction. The promotion
checker also rejects counted rows whose target keys are not exposed by the
simulator's calibration observation mapping. Under this stricter rule, the
current source-range surface remains intentionally narrow, but it
now includes official-source checks for U.S. emergency procedure, Canada SCC
leave grants, France QPC nonconformity and deferred-effect rates, UK Supreme
Court permission grants, UK declarations of incompatibility responses, ECHR
intake/interim-measure measures, and CJEU preliminary-reference, appeal, and
direct-action route mix.
Comparative doctrine mix without stored SCDB denominators, trust,
merits-outcome synthesis, unsupported route-mix statistics, and normalized cost
rows are stress-test context only.

The external source-range campaign intentionally reports misses. A failed target should be
read as one of three things:

- the simulator lacks a case-flow mechanism needed for that court or period;
- the target is contextual rather than directly comparable to a simulator
  metric;
- the stylized archetype preset needs refinement.

Before final empirical submission, replace provisional synthesis rows with
documented source-specific datasets where possible, especially doctrine mix
denominators, comparative intake/throughput rows, public trust, normalized cost,
and merits-invalidation proxies outside the emergency-docket context. Once
those datasets include URLs, denominators, and construction formulas, set
`useForValidation=true` and regenerate the calibration target files.

For profile-level planning, `config/court-profiles/profile-index.csv` is the
generated coverage index. It is derived from the source-observation matrix and
the country-context file, and it records which target families are already
validation-counted for each court profile. Treat its missing-family columns as a
calibration roadmap, not as evidence that a missing target is available or
comparable for every system.

The generated empirical platform reports in `reports/` reuse the same profile
index and add the current source-range miss categories. They should be refreshed
after any validation campaign or calibration-source change so the profile
roadmap, family-coverage matrix, and replication package describe the same
evidence surface.

The current post-research candidate files identify the most promising remaining
promotion targets: Canadian Charter legislative sequels, French QPC invalidation
and conditional deferred-effect rates, pre-enactment review frequency evidence,
and transplant-feasibility indicators from V-Dem, ParlGov, PPEG, DPI, WGI,
CEPEJ, OECD, WVS, and related source families. Rows already marked
`promoted` have been added to the calibration source matrix; rows marked
`verified-context-only` have source support but are not source-range results.
