# Accessibility Descriptions

These descriptions are prepared for JLC/Cambridge accessibility materials. They
should be submitted or adapted with the manuscript if figures and tables remain
in the article.

## Figures

`fig:model-pipeline`: Flow diagram showing the simulator pipeline. Scenario
catalog rules produce shared worlds and dockets, which pass through a review
pipeline and generate metrics and reports. A separate legislative-output CSV
box feeds into the docket stage as stress-signal input.

`fig:emergency-docket`: Horizontal grouped bar chart comparing six court-design
scenarios on shadow-docket abuse, emergency reason-giving, and merits
follow-up. The current-style court is marked `CUR*` and has higher shadow-docket abuse than the
reasoned emergency, cross-checking, council, and hybrid designs.

`fig:paired-import`: Line chart comparing directional diagnostic scores across
five docket sources: synthetic baseline, all imported legislative rows,
high-capture imports, high-volatility imports, and low-mandate imports. The
current-style court is marked `CUR*`. The designs move differently as the docket source changes, showing why imported
legislative outputs are useful stress tests.

`fig:cost-score`: Scatterplot of baseline total institutional cost against
directional diagnostic score. The current-style court is marked `CUR*` and appears at the lower-cost
and lower-score end, while cross-checking, council, and hybrid designs appear
with higher scores and higher institutional costs.

## Tables

`tab:design-space`: Table listing modeled design families and variants,
including appointment method, court size, tenure and removal, recusal, docket
control, emergency docket procedure, doctrine, policy domains, lower-court
pathways, voting thresholds, review structures, override rules, and benchmark
presets.

`tab:metrics`: Table grouping the simulator's outcome metrics into legal
performance, political alignment, emergency docket, legitimacy and conflict,
pipeline and intake, coalitions and recusals, compliance, and institutional
cost categories.

`tab:calibration-targets`: Table listing selected external calibration targets
for U.S. Supreme Court doctrine and emergency activity, public trust, and
comparative court intake or invalidation benchmarks. Columns report the court
and period, target label, observed value, target range, sample size, and
reliability.

`tab:validation-summary`: Table listing validation-style diagnostics for U.S.,
German, Canadian, French, and South African benchmark scenario presets. Columns
show the scenario preset, count of mapped targets falling within documented
ranges, median target gap, and the largest remaining miss.

`tab:baseline-results`: Table listing baseline estimates for all core scenario
codes. Columns report directional score and score interval, legal stability,
rights protection, shadow-docket abuse, legitimacy, democratic responsiveness,
and institutional cost.

`tab:supp-scenario-matrix`: Supplementary long table listing all starter
campaign case-scenario combinations with score, rights protection,
shadow-docket abuse, legitimacy, and institutional cost.

`tab:supp-sensitivity`: Supplementary long table listing sensitivity campaign
stress cases and scenario diagnostics for score, stability, constitutional
conflict, and trust.

`tab:supp-artifacts`: Supplementary long table inventorying generated report
artifacts and file sizes.
