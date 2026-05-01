# Design Notes

The simulator treats constitutional review as a second-stage institutional process over laws or government actions. Inputs can be synthetic or imported from the legislative simulator's campaign reports.

The core abstraction mirrors the legislative simulator without sharing code:

- `Scenario`: named institutional design
- `ScenarioCatalog`: stable scenario keys for CLI and campaign work
- `ReviewProcess`: process that turns a case into a `CaseOutcome`
- `Simulator`: compares scenarios over repeated randomized worlds
- `CampaignRunner`: writes CSV, Markdown, and provenance artifacts

The court model deliberately separates institutional variables from outcome metrics. A design can be highly independent but illegitimate, responsive but rights-weak, or procedurally stable but vulnerable to emergency-docket abuse.

Imported legislative outputs are not treated as empirical truth. They become stress signals for generated cases:

- weak public mandate and low welfare increase rights-threat probability
- high policy shift and status-quo volatility increase legal ambiguity and reversal pressure
- lobby capture and proposer gain increase partisan/executive pressure
- high challenge, fast-lane, and high-risk lane rates increase emergency docket pressure

The first campaign is meant to expose design tradeoffs, not select a winner. Later iterations should add richer doctrine areas, lower-court pipelines, state/federal splits, and empirical calibration only after the starter metrics are useful.

