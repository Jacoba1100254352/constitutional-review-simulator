# Calibration Target Methods

This note describes how the calibration target files should be interpreted in
the paper and replication package. The targets are a transparent benchmark
registry, not fitted parameters and not proof that the simulator predicts any
specific court.

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
denominator is added. Rows with no source URL, low reliability, or a
`sourceName` ending in `synthesis` are provisional stress-test ranges. They
remain in the repository so that weak assumptions are visible, editable, and
excluded from stronger empirical claims.

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

## Validation Use

The validation campaign intentionally reports misses. A failed target should be
read as one of three things:

- the simulator lacks a case-flow mechanism needed for that court or period;
- the target is contextual rather than directly comparable to a simulator
  metric;
- the real-world preset needs refinement.

Before final empirical submission, replace provisional synthesis rows with
documented source-specific datasets where possible, especially public trust,
normalized cost, and merits-invalidation proxies outside the U.S. doctrine
targets.
