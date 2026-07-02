# Design Notes

The simulator treats constitutional review as a second-stage institutional process over laws or government actions. Inputs can be synthetic or imported from the legislative simulator's campaign reports. This workspace is the primary Constitutional Review implementation. The sibling `Supreme Court Simulator Design` workspace is an earlier related artifact; consult it only for deliberately imported design notes, source trails, or historical comparison, not as an authoritative upstream or a codebase to merge by default.

The core abstraction mirrors the legislative simulator without sharing code:

- `Scenario`: named institutional design
- `ScenarioCatalog`: stable scenario keys for CLI and campaign work
- `ReviewProcess`: process that turns a case into a `CaseOutcome`
- `Simulator`: compares scenarios over repeated randomized worlds
- `CampaignRunner`: writes CSV, Markdown, and provenance artifacts

The model deliberately separates institutional variables from outcome metrics. A design can be highly independent but illegitimate, responsive but rights-weak, procedurally stable but vulnerable to emergency-docket abuse, or democratically responsive while simply relocating veto power to a new institutional stage.

Scenario outputs now distinguish `scenarioKind` and `reviewMechanism`. Stylized archetype presets encode observable institutional rules inspired by named systems. Mechanism scenarios isolate design ideas: weak-form review, suspended declarations, explicit override clauses, pre-enactment review, abstract review, ombudsman-triggered review, constitutional public defenders, rights-impact statements, and mandatory legislative response cycles.

Cases now carry doctrine, jurisdiction, and lower-court pipeline structure. Doctrine areas are speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state. Jurisdiction distinguishes federal, state, and mixed state-federal disputes. The lower-court pipeline distinguishes district-only, circuit panel, circuit en banc, state high-court, and state-federal split paths, contributing panel skew, government win/loss, state-federal tension, intercourt conflict, certiorari pressure, and time-to-review. These inputs affect review selection, deference, rights sensitivity, delay costs, and partisan-alignment risk.

Cases also carry access and repeat-player variables. `litigantCapacity` approximates claimant resources and legal-aid support, `publicInterestSupport` approximates NGO/amicus/rights-commission backing, and `governmentRepeatPlayerAdvantage` approximates the procedural advantage of repeat government litigants. These fields now affect review probability, intake acceptance, veto-relocation risk, and democratic constitutionalism.

Emergency review is split into interim relief and merits invalidation. A case can receive emergency relief without a merits decision, receive a merits decision without emergency relief, or move through both stages. This lets the shadow-docket metric track unexplained or non-merits emergency action instead of treating every emergency order as a final reversal.

Court composition now changes across review periods. `WorldSpec.reviewPeriods` partitions each run's docket, and scenario term/removal/accountability settings control replacement pressure between periods. Life-tenure scenarios drift slowly; renewable or retention-election designs turn over faster. Composition reports expose period-level court size, median ideology, ideological spread, mean partisan attachment, rights sensitivity, institutionalism, replacement pressure, and estimated replacement events.

Outcomes now update public and legislative reaction state. Each decision changes public trust, legislature-court conflict, court-curbing pressure, override pressure, amendment pressure, and a compliance norm. Those state variables feed later cases in the same run, so emergency relief, merits invalidation, override use, defiance, workaround behavior, and repeated litigation can compound instead of appearing as isolated case-level events. Enforcement is split into executive implementation, agency nonacquiescence, legislative reenactment, and local-government compliance.

Mechanism outputs expose weak-form declarations, suspended declarations, legislative response, legislative-response delay, timely legislative response, legislative-response credibility, rights-impact statement use, ombudsman triggers, public-defender participation, pre-enactment review, abstract review, case-selection access, implementation capacity, veto-relocation risk, legal-transplant feasibility, political-culture sensitivity, and democratic constitutionalism. The central design question is whether review improves rights, responsiveness, legitimacy, access, implementation, and compliance without merely hiding veto power in a less accountable location.

The world specification now separates formal review design from political and administrative context. Party fragmentation, governing coalition control, electoral time pressure, civil-society capacity, implementation capacity, and legal-tradition compatibility feed response credibility, transplant feasibility, political-culture sensitivity, and compliance channels. Source-range archetype runs read these context values from `config/context/country-year-context.csv`; other campaigns treat them as stress-test levers unless source-specific research promotes a value into documented calibration evidence.

Imported legislative outputs are not treated as empirical truth. They become stress signals for generated cases:

- weak public mandate and low welfare increase rights-threat probability
- high policy shift and status-quo volatility increase legal ambiguity and reversal pressure
- lobby capture and proposer gain increase partisan/executive pressure
- high challenge, fast-lane, and high-risk lane rates increase emergency docket pressure

The first campaign is meant to expose design tradeoffs, not select a winner. The paired-import campaign uses the sibling legislative simulator's generated rows in four docket modes: all imported rows, high-capture rows, high-volatility rows, and low-mandate rows.

Campaign reports now write reproducible CSV layers plus compressed raw case
exports:

- aggregate scenario/campaign-case averages
- period-by-period outputs for replacement and reaction dynamics
- doctrine-specific scoreboards for speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state claims
- pipeline scoreboards for state/federal jurisdiction and lower-court hierarchy paths
- composition outputs for each review period
- source-range checks against `config/calibration-targets.csv`
- aggregate and segment uncertainty bands
- compressed case-level outcomes for bootstrap replication
- mechanism outputs, legislative-response timing fields, and scenario-kind metadata in aggregate, segment, composition, and case-level exports
- research-roadmap inputs under `config/research/` for empirical court packs, legislative response evidence, transplant factors, enforcement channels, and case-selection access

The sensitivity campaign is a brittleness check rather than empirical
validation. It runs the same scenario catalog over high/low assumption sweeps
for emergency pressure, appointment polarization, rights-threat rate, public
trust, and legislative conflict so directional scores, democratic
constitutionalism, veto-relocation risk, transplant feasibility, and
political-culture sensitivity can be inspected for parameter dependence. The
external source-range campaign separately runs stylized archetype presets against
documented target ranges where a source-specific analogue exists. A source-range
miss is useful evidence about model scope or target comparability, not a failed
forecast.

Calibration targets are documented in `config/calibration-source-observations.csv`
and `docs/calibration-target-methods.md`. Source-specific source-range
rows and provisional synthesis rows must remain distinguishable in paper and
supplement language. Rows with synthesis labels, missing denominators,
public-trust proxies, or normalized-cost construction are stress-test context,
not validation evidence.

The derived court-profile index in `config/court-profiles/profile-index.csv`
groups the source-observation matrix into empirical profiles. It records
validation-counted rows, stress-only rows, political-context mappings, missing
validation families, and the next calibration priority for each profile. The
index is generated by `scripts/build_court_profiles.py` and checked with
`make court-profile-check`; it should not be edited by hand.

The empirical platform report under
`reports/constitutional-review-empirical-platform-v1.*` combines the profile
index with the current source-range miss report. It is regenerated by
`make empirical-platform-report` and by `make validation-check`, giving the
replication package a machine-readable profile summary, family-coverage matrix,
promotion queue, and Markdown roadmap.

Deep-research prompts for the next empirical pass are maintained in
`docs/deep-research-prompts.md`. Their requested outputs should be treated as
source-discovery material until denominators, URLs, coding rules, and target
analogues are checked into the calibration source matrix. When a research pass
returns useful denominator-backed findings but not enough source trail for
source-range use, preserve them in `config/research/*-source-candidates.csv`
or in an operationalization file. Candidate rows should record the reported
numerator, denominator, period, source family, URL-verification status, and
whether the row is a direct simulator analogue. They should not be promoted into
`config/calibration-source-observations.csv` until the original source URL and
coding rule have been independently verified. `make promotion-check` enforces
the current promotion gate for counted source-range rows and promoted candidate
rows.
