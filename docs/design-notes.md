# Design Notes

The simulator treats constitutional review as a second-stage institutional process over laws or government actions. Inputs can be synthetic or imported from the legislative simulator's campaign reports.

The core abstraction mirrors the legislative simulator without sharing code:

- `Scenario`: named institutional design
- `ScenarioCatalog`: stable scenario keys for CLI and campaign work
- `ReviewProcess`: process that turns a case into a `CaseOutcome`
- `Simulator`: compares scenarios over repeated randomized worlds
- `CampaignRunner`: writes CSV, Markdown, and provenance artifacts

The court model deliberately separates institutional variables from outcome metrics. A design can be highly independent but illegitimate, responsive but rights-weak, or procedurally stable but vulnerable to emergency-docket abuse.

Cases now carry doctrine and lower-court pipeline structure. Doctrine areas are speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state. The lower-court pipeline contributes panel skew, government win/loss, conflict pressure, certiorari pressure, and time-to-review. These inputs affect review selection, deference, rights sensitivity, delay costs, and partisan-alignment risk.

Emergency review is split into interim relief and merits invalidation. A case can receive emergency relief without a merits decision, receive a merits decision without emergency relief, or move through both stages. This lets the shadow-docket metric track unexplained or non-merits emergency action instead of treating every emergency order as a final reversal.

Court composition now changes across review periods. `WorldSpec.reviewPeriods` partitions each run's docket, and scenario term/removal/accountability settings control replacement pressure between periods. Life-tenure scenarios drift slowly; renewable or retention-election designs turn over faster.

Outcomes now update public and legislative reaction state. Each decision changes public trust, legislature-court conflict, court-curbing pressure, override pressure, amendment pressure, and a compliance norm. Those state variables feed later cases in the same run, so emergency relief, merits invalidation, override use, defiance, workaround behavior, and repeated litigation can compound instead of appearing as isolated case-level events.

Imported legislative outputs are not treated as empirical truth. They become stress signals for generated cases:

- weak public mandate and low welfare increase rights-threat probability
- high policy shift and status-quo volatility increase legal ambiguity and reversal pressure
- lobby capture and proposer gain increase partisan/executive pressure
- high challenge, fast-lane, and high-risk lane rates increase emergency docket pressure

The first campaign is meant to expose design tradeoffs, not select a winner. The paired-import campaign uses the sibling legislative simulator's generated rows in four docket modes: all imported rows, high-capture rows, high-volatility rows, and low-mandate rows. Later iterations should add state/federal splits and external calibration targets only after the synthetic diagnostics are useful.

Campaign reports now write three CSV layers:

- aggregate scenario/campaign-case averages
- period-by-period diagnostics for replacement and reaction dynamics
- doctrine-specific scoreboards for speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state claims

The sensitivity campaign is a calibration check rather than empirical validation. It runs the same scenario catalog over high/low assumption sweeps for emergency pressure, appointment polarization, rights-threat rate, public trust, and legislative conflict so directional scores can be inspected for brittle parameter dependence.
