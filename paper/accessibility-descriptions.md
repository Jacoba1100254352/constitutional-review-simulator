# Accessibility Descriptions

These descriptions are prepared for JLC/Cambridge accessibility materials. They
should be submitted or adapted with the manuscript if figures and tables remain
in the article.

## Figures

`fig:model-pipeline`: Flow diagram showing the simulator pipeline. Scenario
catalog rules produce shared worlds and dockets, which pass through a review
pipeline and generate metrics and reports. A separate legislative-output box
feeds into the docket stage as stress-signal input.

`fig:emergency-docket`: Horizontal grouped bar chart comparing six court-design
scenarios on emergency-process irregularity, emergency reason-giving, and merits
follow-up. The current-style court is marked `CUR*` and has higher emergency-process irregularity than the
reasoned emergency, cross-checking, council, and hybrid designs.

`fig:paired-import`: Line chart comparing directional diagnostic scores across
five docket sources: synthetic baseline, all imported legislative rows,
high-capture imports, high-volatility imports, and low-mandate imports. The
current-style court is marked `CUR*`. The designs move differently as the docket source changes, showing why imported
legislative outputs are useful stress tests.

`fig:cost-score`: Scatterplot of baseline total institutional cost against
democratic constitutionalism. The current-style court is marked `CUR*`.
Court variants and synthetic mechanisms are labeled so readers can compare
cost against the rights, responsiveness, legitimacy, compliance, feasibility,
implementation, access, response credibility, feasibility, and veto-relocation
diagnostic.

`fig:mechanism-tradeoff`: Scatterplot of synthetic mechanisms only. The
horizontal axis is veto-relocation risk and the vertical axis is democratic
constitutionalism. Weak-form, suspended-declaration, override-clause,
pre-enactment, abstract-review, ombudsman, public-defender, rights-impact
statement, and mandatory legislative-response mechanisms are labeled.

## Tables

`tab:design-space`: Table listing modeled design families and variants,
including appointment method, court size, tenure and removal, recusal, docket
control, emergency docket procedure, doctrine, policy domains, lower-court
pathways, voting thresholds, review structures, override rules, and benchmark
presets.

`tab:metrics`: Table grouping the simulator's outcome metrics into legal
performance, political alignment, democratic constitutionalism, noncourt
mechanisms, emergency docket, legitimacy and conflict, pipeline and intake,
coalitions and recusals, compliance, and institutional cost categories.

`tab:mechanical-diagnostic`: Table separating mechanically implied model
patterns from diagnostic findings. It explains when emergency-reasoning,
no-relief-without-merits, appointment, and weak-form response results should be
read as implementation checks rather than substantive tradeoffs.

`tab:calibration-targets`: Table listing selected external calibration targets
for U.S. Supreme Court doctrine and emergency activity, public trust, and
comparative court intake or invalidation benchmarks. Columns report the court
and period, target label, observed value, target range, sample size, and
reliability.

`tab:validation-summary`: Table listing validation-style diagnostics for U.S.,
German, Canadian, French, and South African benchmark scenario presets. Columns
show the scenario preset, count of mapped targets falling within documented
ranges, median target gap, and the largest remaining miss.

`tab:validation-miss-interpretation`: Table listing the largest out-of-range
source-specific validation diagnostics. Columns show the target, model value
versus source range, miss category, interpretation, and next calibration step.

`tab:baseline-results`: Table listing selected baseline estimates for court
variant and synthetic mechanism scenario codes. Columns report scenario kind,
democratic constitutionalism, rights protection, emergency-process
irregularity, modeled public-legitimacy proxy, veto-relocation risk,
transplant feasibility, institutional cost, and the display-score aid.

`tab:mechanism-results`: Table listing synthetic mechanism diagnostics.
Columns report democratic constitutionalism, veto-relocation risk, transplant
feasibility, political-culture sensitivity, weak-form declaration rate,
suspended declaration rate, legislative response rate, front-end review rate,
and case-selection access diagnostic.

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
institutional mapping, synthetic mechanism, normalized diagnostic, or
source-range diagnostic.

`tab:supp-scenario-matrix`: Supplementary long table listing all main-campaign
case-scenario combinations with mechanism family, score, democratic
constitutionalism, rights protection, veto-relocation risk, political-culture
sensitivity, and institutional cost.

`tab:supp-sensitivity`: Supplementary long table listing sensitivity campaign
stress cases and scenario diagnostics for score, democratic constitutionalism,
veto-relocation risk, transplant feasibility, political-culture sensitivity,
and trust.

`tab:supp-calibration-sources`: Supplementary long table listing each
calibration source-observation row by profile, target, method, sample size,
reliability, and source-status category. Rows without direct URLs or sample
counts are identified as provisional synthesis targets.

`tab:supp-research-roadmap`: Supplementary long table listing the empirical
data-development files, row counts, and the purpose of each file. It
distinguishes source-gathering tasks from calibration targets.

`tab:supp-artifacts`: Supplementary long table inventorying generated
aggregate report artifacts and file sizes. A note explains that compressed
case-level exports are reproducible from the campaign commands but omitted
from the tracked size table because they are local large artifacts.
