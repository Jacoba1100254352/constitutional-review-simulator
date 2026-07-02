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
largest remaining miss.

`tab:validation-miss-interpretation`: Main-text table listing up to four
out-of-range source-range checks as a calibration roadmap. Columns show the
target, model value versus source range, miss category, interpretation, and
next calibration step. The full generated miss table remains in the replication
files.

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
source-range checks retained in the generated miss roadmap. Columns show the
target, model value versus source range, miss category, next action, and gap.

`tab:supp-research-roadmap`: Supplementary long table listing the empirical
data-development files, row counts, and the purpose of each file. It
distinguishes source-gathering tasks from calibration targets.

`tab:supp-artifacts`: Supplementary long table inventorying generated
aggregate output artifacts and file sizes. A note explains that compressed
case-level exports are reproducible from the simulation commands but omitted
from the tracked size table because they are local large artifacts.
