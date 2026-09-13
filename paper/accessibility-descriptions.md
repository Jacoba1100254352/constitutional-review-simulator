# Accessibility Descriptions

These descriptions are prepared for JLC/Cambridge accessibility materials. They
should be submitted or adapted with the manuscript if figures and tables remain
in the article.

## Figures

`fig:model-pipeline`: Flow diagram showing the simulator pipeline as separate
audit points: institutional design set, world and case generation, institutional
routing, decision process, outputs and reports, legislative-output stress
signals, intake and access filters, emergency and merits review, compliance,
reaction, cost, and period turnover or political-culture state.

`fig:emergency-docket`: Horizontal grouped bar chart comparing six court-design
scenarios on emergency-process irregularity, emergency reason-giving, and merits
follow-up. The current-style court is marked `CUR*` and has higher emergency-process irregularity than the
reasoned emergency, cross-checking, council, and hybrid designs.

`fig:paired-import`: Supplementary line chart comparing directional display
scores across five docket sources: generated baseline, all imported legislative
rows, high-capture imports, high-volatility imports, and low-mandate imports.
The current-style court is marked `CUR*`. The designs move differently as the
docket source changes, showing why imported legislative outputs are useful
stress tests.

`fig:cost-score`: Scatterplot of baseline total institutional cost against
democratic constitutionalism. The current-style court is marked `CUR*`.
Filled markers show court architectures and open markers show mechanism
scenarios, all labeled so readers can compare
cost against the rights, responsiveness, legitimacy, compliance, feasibility,
implementation, access, response credibility, feasibility, and veto-relocation
measure.

`fig:mechanism-tradeoff`: Scatterplot of mechanism scenarios only. The
horizontal axis is veto-relocation risk and the vertical axis is democratic
constitutionalism. Weak-form, suspended-declaration, override-clause,
pre-enactment, abstract-review, ombudsman, public-defender, rights-impact
statement, and mandatory legislative-response mechanisms are labeled.

## Tables

`tab:design-space`: Table listing the scenario groups used in the reported
stress tests: court architecture variants, emergency-review procedure,
dialogic and weak-form mechanisms, front-end and access mechanisms, stylized
archetype presets, and feasibility constraints.

`tab:model-transparency`: Table summarizing model-input families, scale or
construction, model role, and evidentiary status for generated case facts,
world context, institutional rules, model weights, and external source ranges.

`tab:metrics`: Table grouping the simulator's outcome metrics into legal
performance, political alignment, democratic constitutionalism, noncourt
mechanisms, emergency docket, legitimacy and conflict, pipeline and intake,
coalitions and recusals, compliance, and institutional cost categories.

`tab:mechanical-diagnostic`: Table separating mechanically implied model
patterns from downstream tests. It explains when emergency-reasoning,
no-relief-without-merits, appointment, and weak-form response results should be
read as implementation checks rather than substantive tradeoffs.

`tab:calibration-targets`: Table listing selected external calibration targets
for U.S. Supreme Court doctrine and emergency activity, public trust, and
comparative court intake or invalidation benchmarks. Columns report the court
and period, target label, observed value, target range, sample size, and
reliability.

`tab:validation-summary`: Table listing external source-range checks for
U.S. emergency-docket, Canadian, French, UK, ECHR, and CJEU-inspired archetype
presets with counted direct targets. Columns show the scenario preset, count of
mapped targets falling within documented ranges, median target gap, and the
largest current miss, if any.

`tab:validation-miss-interpretation`: Main-text table listing out-of-range
source-range checks when any remain, or a no-current-miss statement when all
validation-counted checks fall within their documented ranges. The full
generated source-range table remains in the replication files.

`tab:baseline-results`: Table listing selected baseline estimates for court
architecture scenario codes. Columns report design label, democratic
constitutionalism, rights protection, emergency-process irregularity, modeled
public-legitimacy proxy, veto-relocation risk, institutional cost, and the
display-score aid.

`tab:mechanism-results`: Table listing mechanism activation and downstream
propagation effects. Columns report the mechanism label, direct activation
outputs, rights protection, compliance, constitutional conflict, modeled
public-legitimacy proxy, cost, veto-relocation risk, and democratic
constitutionalism. The note explains that front-end rows are bundle/routing
scenarios rather than isolated toggles.

`tab:normative-profiles`: Table listing five alternative normative-profile
readings of the same baseline outputs. Rows identify rights-centered,
parliamentary-dialogue, legal-stability, cost-minimizing, and
anti-veto-relocation profiles, along with the leading court architecture and
leading mechanism under each profile.

`tab:weight-robustness`: Table summarizing 1,000 random-weight profiles over
twelve baseline outputs for architecture scenarios and mechanism scenarios.
Columns report the most frequent leader, leader share, next leaders, mean
winner margin, and interpretive reading.

`tab:supp-model-weights`: Supplementary long table describing the fixed model
weights and formulas for core simulated outcomes, including emergency-process
irregularity, legal stability, modeled public-legitimacy proxy, rights
protection, constitutional-conflict index, compliance, enforcement,
case-selection access, legislative-response
credibility, implementation capacity, institutional cost, and the directional
display score.

`tab:supp-model-crosswalk`: Supplementary long table mapping manuscript model
stages to implementation modules. Columns identify each stage, the main code
module, principal inputs, principal outputs, and whether the component is an
institutional mapping, mechanism flag, normalized index, or source-range check.

`tab:supp-scenario-matrix`: Supplementary long table listing all main-comparison
case-scenario combinations with mechanism family, score, democratic
constitutionalism, rights protection, veto-relocation risk, political-culture
sensitivity, and institutional cost.

`tab:supp-sensitivity`: Supplementary long table listing sensitivity stress
cases and scenario outputs for score, democratic constitutionalism,
veto-relocation risk, transplant feasibility, political-culture sensitivity,
and trust.

`tab:supp-calibration-sources`: Supplementary long table listing each
calibration source-observation row by profile, target, method, sample size,
reliability, and source-status category. Rows without direct URLs or sample
counts are identified as provisional synthesis targets.

`tab:supp-validation-misses`: Supplementary long table listing all out-of-range
source-range checks retained in the generated miss roadmap, or the generated
no-current-miss statement when none remain. Columns show the target, model value
versus source range, miss category, next action, and gap when rows exist.

`tab:supp-measurement-audit`: Supplementary table of nine source proportions,
showing court and period, measured quantity, numerator and denominator, rate,
and permitted model use. Canada's statute-nullification row is the only counted
range check. Four German and four South African observations remain source
context or missing model measures. The accompanying note identifies distinct
complaint universes, a one-petition route discrepancy, censored dismissals, and
missing source orders.

`tab:supp-research-roadmap`: Supplementary long table listing the empirical
data-development files, row counts, and the purpose of each file. It
distinguishes source-gathering tasks from calibration targets.

`tab:supp-artifacts`: Supplementary long table inventorying generated
aggregate output artifacts and file sizes. A note explains that compressed
case-level exports are reproducible from the simulation commands but omitted
from the tracked size table because they are local large artifacts.

`tab:historical-scores`: Four fixed forecasts evaluated on 66 new-term disputes.
Columns show Brier score, log loss, and total variation, all lower-is-better.
The note retains the primary difference and its interval spanning zero.

`tab:historical-claims`: Three claim families, their paired difference ranges
across 52 cells, and qualified conclusions. Duration is unsupported, upstream
displacement is weak under the intervention, and response dependence is partial.

`tab:supp-historical-categories`: All eight mutually exclusive test categories,
including Other, with dispute counts and shares of the same 66-case denominator.

`tab:supp-historical-forecasts`: Eight categories by four locked forecast
probabilities. The table distinguishes fixed constants and training-only
empirical forecasts from the observed test distribution.

`tab:supp-historical-scores`: All nine frozen empirical paired-score comparisons
with within-term intervals. Secondary findings do not replace the primary test.

`tab:supp-historical-contexts`: Six world inputs with low and high values. Each
is changed one at a time around baseline, yielding thirteen contexts.

`tab:supp-historical-claims`: All 22 claim components, fixed-grid difference
ranges, practical-sign classifications, and counts of intervals above/below
zero. Additional diagnostics and conditional-denominator limitations are marked.

`tab:supp-historical-ablations`: All 49 intervention and persistence components,
with fixed-grid ranges and interval sign counts. Changed design is compared
with its parent; half/off variants are also compared with current review.

`tab:supp-historical-intervals`: All 71 component/contrast combinations in the
fixed-generator baseline cell, with point estimates and paired-run intervals.
The complete CSV includes all 3,692 comparisons without significance filtering.

`tab:supp-historical-denominators`: Low-emergency counts by forecast and design,
including orders, reasons, empty runs, and pooled rates. Sparse event counts
explain an apparent run-mean reversal without replacing the original endpoint.

`tab:supp-historical-accounting`: Council-minus-current differences under
direct-only and full accounting and their contrast gap. Ranges are normalized
index differences, not money, and no practical sign switches occur.

`tab:supp-historical-weights`: Six higher-is-better and six lower-is-better
measures in the new preference exercise. The shared time input cannot
distinguish designs within a cell.

`tab:supp-historical-leadership`: Twelve design/response-setting rows with
minimum and maximum sampled leadership shares over 52 cells. These are finite
preference sensitivities, not probabilities of institutional optimality.
