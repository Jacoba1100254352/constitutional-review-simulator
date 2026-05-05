# Design Notes

The simulator treats constitutional review as a second-stage institutional process over laws or government actions. Inputs can be synthetic or imported from the legislative simulator's campaign reports. This workspace is now positioned as the comparative-design companion to any narrower Supreme Court simulator, not as a deprecated predecessor or a codebase to merge into a single-court project.

The core abstraction mirrors the legislative simulator without sharing code:

- `Scenario`: named institutional design
- `ScenarioCatalog`: stable scenario keys for CLI and campaign work
- `ReviewProcess`: process that turns a case into a `CaseOutcome`
- `Simulator`: compares scenarios over repeated randomized worlds
- `CampaignRunner`: writes CSV, Markdown, and provenance artifacts

The model deliberately separates institutional variables from outcome metrics. A design can be highly independent but illegitimate, responsive but rights-weak, procedurally stable but vulnerable to emergency-docket abuse, or democratically responsive while simply relocating veto power to a new institutional stage.

Scenario outputs now distinguish `scenarioKind` and `reviewMechanism`. Real-world presets encode observable institutional rules for named systems without claiming fitted empirical replication. Synthetic mechanisms isolate design ideas: weak-form review, suspended declarations, explicit override clauses, pre-enactment review, abstract review, ombudsman-triggered review, constitutional public defenders, rights-impact statements, and mandatory legislative response cycles.

Cases now carry doctrine, jurisdiction, and lower-court pipeline structure. Doctrine areas are speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state. Jurisdiction distinguishes federal, state, and mixed state-federal disputes. The lower-court pipeline distinguishes district-only, circuit panel, circuit en banc, state high-court, and state-federal split paths, contributing panel skew, government win/loss, state-federal tension, intercourt conflict, certiorari pressure, and time-to-review. These inputs affect review selection, deference, rights sensitivity, delay costs, and partisan-alignment risk.

Emergency review is split into interim relief and merits invalidation. A case can receive emergency relief without a merits decision, receive a merits decision without emergency relief, or move through both stages. This lets the shadow-docket metric track unexplained or non-merits emergency action instead of treating every emergency order as a final reversal.

Court composition now changes across review periods. `WorldSpec.reviewPeriods` partitions each run's docket, and scenario term/removal/accountability settings control replacement pressure between periods. Life-tenure scenarios drift slowly; renewable or retention-election designs turn over faster. Composition reports expose period-level court size, median ideology, ideological spread, mean partisan attachment, rights sensitivity, institutionalism, replacement pressure, and estimated replacement events.

Outcomes now update public and legislative reaction state. Each decision changes public trust, legislature-court conflict, court-curbing pressure, override pressure, amendment pressure, and a compliance norm. Those state variables feed later cases in the same run, so emergency relief, merits invalidation, override use, defiance, workaround behavior, and repeated litigation can compound instead of appearing as isolated case-level events. Enforcement is split into executive implementation, agency nonacquiescence, legislative reenactment, and local-government compliance.

Mechanism outputs expose weak-form declarations, suspended declarations, legislative response, rights-impact statement use, ombudsman triggers, public-defender participation, pre-enactment review, abstract review, veto-relocation risk, legal-transplant feasibility, political-culture sensitivity, and democratic constitutionalism. The central diagnostic is whether review improves rights, responsiveness, legitimacy, and compliance without merely hiding veto power in a less accountable location.

Imported legislative outputs are not treated as empirical truth. They become stress signals for generated cases:

- weak public mandate and low welfare increase rights-threat probability
- high policy shift and status-quo volatility increase legal ambiguity and reversal pressure
- lobby capture and proposer gain increase partisan/executive pressure
- high challenge, fast-lane, and high-risk lane rates increase emergency docket pressure

The first campaign is meant to expose design tradeoffs, not select a winner. The paired-import campaign uses the sibling legislative simulator's generated rows in four docket modes: all imported rows, high-capture rows, high-volatility rows, and low-mandate rows.

Campaign reports now write reproducible CSV layers plus compressed raw case
exports:

- aggregate scenario/campaign-case averages
- period-by-period diagnostics for replacement and reaction dynamics
- doctrine-specific scoreboards for speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state claims
- pipeline scoreboards for state/federal jurisdiction and lower-court hierarchy paths
- composition diagnostics for each review period
- calibration diagnostics against `config/calibration-targets.csv`
- aggregate and segment uncertainty bands
- compressed case-level outcomes for bootstrap replication
- mechanism diagnostics and scenario-kind metadata in aggregate, segment, composition, and case-level exports

The sensitivity campaign is a brittleness check rather than empirical
validation. It runs the same scenario catalog over high/low assumption sweeps
for emergency pressure, appointment polarization, rights-threat rate, public
trust, and legislative conflict so directional scores, democratic
constitutionalism, veto-relocation risk, transplant feasibility, and
political-culture sensitivity can be inspected for parameter dependence. The
validation campaign separately runs real-world scenario presets against
documented target ranges where a source-specific analogue exists. A validation
miss is useful evidence about model scope or target comparability, not a failed
forecast.

Calibration targets are documented in `config/calibration-source-observations.csv`
and `docs/calibration-target-methods.md`. Source-specific validation rows and
provisional synthesis rows must remain distinguishable in paper and supplement
language. Rows with synthesis labels, missing denominators, public-trust
proxies, or normalized-cost construction are stress-test context, not
validation evidence.
