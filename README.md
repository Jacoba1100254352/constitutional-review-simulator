# Constitutional Review Simulator

This is a dependency-free Java simulator for stress-testing supreme-court and constitutional-review design bundles. It is intentionally separate from the legislative simulator, but it can import legislative campaign CSV output as docket stress signals for review cases. Within the local simulator workspaces, this is the primary Constitutional Review implementation. The sibling `Supreme Court Simulator Design` workspace is an earlier related artifact and may contain useful design notes or source trails, but it is not an authoritative upstream and should not be treated as a repo to merge into this one by default.

The model is built for comparative institutional design stress testing. Given stated rules, weights, dockets, political-culture assumptions, and scoring profiles, it exposes tradeoffs such as veto-relocation risk, cost, compliance, and rights-sensitive access. It keeps the same working style as the legislative simulator: named scenarios, randomized worlds, campaign sweeps, metrics with explicit directions, CSV/Markdown reports, and provenance manifests.

## Run

```sh
make run
```

With selected scenarios:

```sh
make run ARGS="--scenarios current-federal-court,reasoned-emergency-review,dual-cross-checking-courts --runs 300 --cases 120 --charts"
```

Import legislative simulator output as the case docket:

```sh
make run ARGS="--legislative-input data/legislative/simulation-campaign-v21-paper.csv --scenarios current-federal-court,constitutional-council,legislative-override-court"
```

Run the starter campaign:

```sh
make campaign
```

This writes:

- `reports/constitutional-review-campaign-v0.csv`
- `reports/constitutional-review-campaign-v0-periods.csv`
- `reports/constitutional-review-campaign-v0-doctrines.csv`
- `reports/constitutional-review-campaign-v0-pipelines.csv`
- `reports/constitutional-review-campaign-v0-policy-domains.csv`
- `reports/constitutional-review-campaign-v0-composition.csv`
- `reports/constitutional-review-campaign-v0-calibration.csv`
- `reports/constitutional-review-campaign-v0-cases.csv.gz`
- `reports/constitutional-review-campaign-v0-intervals.csv`
- `reports/constitutional-review-campaign-v0-period-intervals.csv`
- `reports/constitutional-review-campaign-v0-doctrine-intervals.csv`
- `reports/constitutional-review-campaign-v0-pipeline-intervals.csv`
- `reports/constitutional-review-campaign-v0-policy-domain-intervals.csv`
- `reports/constitutional-review-campaign-v0-composition-intervals.csv`
- `reports/constitutional-review-campaign-v0-calibration-intervals.csv`
- `reports/constitutional-review-campaign-v0.md`
- `reports/constitutional-review-campaign-v0-manifest.json`

The aggregate CSVs include scenario kind, review mechanism, intake filings, screened filings, intake acceptance rate, emergency reason-giving, emergency vote disclosure, public emergency disagreement, government emergency applicant/win outputs, emergency merits follow-up, mechanism rates, legislative-response credibility, case-selection access, government repeat-player advantage, implementation capacity, democratic constitutionalism, veto-relocation risk, legal-transplant feasibility, political-culture sensitivity, direct court cost, upstream screening cost, capacity strain cost, and aggregate budget/delay/complexity cost fields.

Run the paired imported-legislative campaign:

```sh
make paired-campaign
```

This reads the tracked legislative simulator campaign CSV at
`data/legislative/simulation-campaign-v21-paper.csv` by default. Override it
with `LEGISLATIVE_INPUT=/path/to/other.csv make paired-campaign`.

The paired campaign writes:

- `reports/constitutional-review-paired-import-v1.csv`
- `reports/constitutional-review-paired-import-v1-periods.csv`
- `reports/constitutional-review-paired-import-v1-doctrines.csv`
- `reports/constitutional-review-paired-import-v1-pipelines.csv`
- `reports/constitutional-review-paired-import-v1-policy-domains.csv`
- `reports/constitutional-review-paired-import-v1-composition.csv`
- `reports/constitutional-review-paired-import-v1-calibration.csv`
- `reports/constitutional-review-paired-import-v1-cases.csv.gz`
- `reports/constitutional-review-paired-import-v1-intervals.csv`
- `reports/constitutional-review-paired-import-v1-period-intervals.csv`
- `reports/constitutional-review-paired-import-v1-doctrine-intervals.csv`
- `reports/constitutional-review-paired-import-v1-pipeline-intervals.csv`
- `reports/constitutional-review-paired-import-v1-policy-domain-intervals.csv`
- `reports/constitutional-review-paired-import-v1-composition-intervals.csv`
- `reports/constitutional-review-paired-import-v1-calibration-intervals.csv`
- `reports/constitutional-review-paired-import-v1.md`
- `reports/constitutional-review-paired-import-v1-manifest.json`

Run the sensitivity campaign:

```sh
make sensitivity-check
```

This writes high/low assumption sweeps for emergency pressure, appointment polarization, rights-threat rate, public trust, and legislature-court conflict:

- `reports/constitutional-review-sensitivity-v1.csv`
- `reports/constitutional-review-sensitivity-v1-periods.csv`
- `reports/constitutional-review-sensitivity-v1-doctrines.csv`
- `reports/constitutional-review-sensitivity-v1-pipelines.csv`
- `reports/constitutional-review-sensitivity-v1-policy-domains.csv`
- `reports/constitutional-review-sensitivity-v1-composition.csv`
- `reports/constitutional-review-sensitivity-v1-calibration.csv`
- `reports/constitutional-review-sensitivity-v1-cases.csv.gz`
- `reports/constitutional-review-sensitivity-v1-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-period-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-doctrine-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-pipeline-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-policy-domain-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-composition-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-calibration-intervals.csv`
- `reports/constitutional-review-sensitivity-v1.md`
- `reports/constitutional-review-sensitivity-v1-manifest.json`

Run the external source-range benchmark campaign:

```sh
make validation-check
```

This compares stylized archetype presets inspired by the U.S. Supreme Court,
German Federal Constitutional Court, French Constitutional Council, Supreme
Court of Canada, South African Constitutional Court, UK Supreme Court, ECHR,
and CJEU against a source-range benchmark. The campaign applies country/context
modifiers from `config/context/country-year-context.csv` while keeping empirical
fit claims limited to source-backed calibration rows. It writes the same
aggregate, segment, compressed case-level, bootstrap interval, calibration,
Markdown, and manifest artifact family under the
`reports/constitutional-review-validation-v1*` prefix. It also writes
`reports/constitutional-review-validation-v1-misses.csv` and
`reports/constitutional-review-validation-v1-misses.md`, which interpret
out-of-range source checks when any remain and otherwise preserve the full
source-range status table for the calibration platform.

Run tests:

```sh
make test
```

Build the starter LaTeX paper and supplementary appendix:

```sh
make paper
make supplement
```

The paper source is in `paper/constitutional-review-design-stress-test.tex`;
the compiled PDF is written to
`paper/build/constitutional-review-design-stress-test.pdf` and refreshed at
`paper/constitutional-review-design-stress-test.pdf`. `make paper` also
updates `paper/figure-placement-audit.md`, which maps rendered figure and table
pages and flags figure-driven white-space problems.
The supplementary appendix source is in `paper/supplementary-appendix.tex`;
its compiled PDF is written to `paper/build/supplementary-appendix.pdf`.
Use `make submission-bundle` to refresh the generated LaTeX inputs, rebuild both
PDFs with `latexmk` when their content changes, and assemble anonymous review
and replication ZIP archives under `submission/`. The bundle builder fails if
PDF generation fails or if source or replication ZIPs contain build logs, local
machine paths, IDE files, `.DS_Store`, generated PDFs, or other anonymous-review
leakage. The review replication ZIP excludes raw
`reports/*-cases.csv.gz` outputs and interval CSVs to keep the upload practical; those outputs are regenerated by the campaign commands and listed in
`submission/excluded-large-artifacts.txt` for final deposit or separate reviewer
delivery.

## Scenario Families

The starter catalog covers:

- appointment methods: presidential/senate, supermajority commission, merit sortition, legislative selection, and retention-accountability variants
- court size: 9, 12, 15, and 18 member designs
- term limits: life tenure, nonrenewable 18-year terms, and shorter renewable terms
- removal standards: impeachment-only, misconduct commission, and retention election pressure
- recusal rules: self-policing, mandatory conflict recusal, random substitution, and strict transparency
- emergency-review procedures: fast emergency orders, reasoned emergency panels, full-court emergency review, and merits follow-up
- doctrine areas: speech, equality, criminal procedure, federalism, election law, emergency powers, administrative state, and an empirical residual `other` bucket used by the SCDB merits-docket profile
- policy domains: civil rights, speech/religion, criminal justice, federalism, governance, elections, emergency/security, economic regulation, and administration; imported legislative rows preserve an explicit `policyDomain` column when present and otherwise infer one from row labels and stress signals
- state/federal and lower-court pipeline signals: federal, state, and mixed state-federal jurisdiction; district-only, circuit-panel, en banc, state high-court, and state-federal split paths; panel skew, government win/loss, conflict pressure, certiorari pressure, and time-to-review
- court-system archetypes: discretionary appellate leave, constitutional complaint, pre-enactment council, mixed abstract/concrete review, declaration-only parliamentary review, and supranational treaty review
- stylized archetype presets: U.S.-style discretionary apex review, Kelsenian constitutional-court review, council-style pre-enactment/abstract review, weak-form parliamentary review, supranational treaty review, dual-court/cross-checking review, and related presets inspired by Germany, France, Canada, South Africa, the United Kingdom, India, Brazil, the ECHR, and the CJEU
- public and legislative reaction dynamics: compliance, defiance, workarounds, repeated litigation, court-curbing pressure, amendment pressure, trust shifts, executive implementation, agency nonacquiescence, legislative reenactment, and local-government compliance
- political-system and implementation assumptions: party fragmentation, governing coalition control, electoral time pressure, civil-society capacity, implementation capacity, and legal-tradition compatibility
- voting thresholds: simple majority, supermajority invalidation, concurrent-majority logic, and high constitutional thresholds
- concurring/dissenting coalitions: modeled as fragmentation and dissent intensity metrics
- panel vs en banc review
- dual supreme courts or cross-checking courts
- constitutional councils
- legislative override rules
- independence vs accountability balance
- scenario-kind separation: stylized archetype presets, court variants, and mechanism tests
- noncourt mechanisms: weak-form review, suspended declarations of invalidity, legislative override clauses, pre-enactment review, abstract review, ombudsman-triggered review, constitutional public defenders, rights-impact statements, and mandatory legislative response cycles

## Metrics

Core metrics:

- `legalStability` `↑`: doctrinal and institutional stability after review
- `rightsProtection` `↑`: protection against high-rights-threat laws without over-invalidating low-threat laws
- `partisanAlignment` `↓`: extent to which review tracks partisan/ideological law origin more than legal risk
- `shadowDocketAbuse` `↓`: emergency-process irregularity; the legacy report column captures unexplained, opaque, or emergency-driven high-impact review
- `legitimacy` `↑`: modeled public-legitimacy proxy combining trust input, transparency, broad agreement, and rights performance net of conflict
- `reversalRate` `↓/diag.`: share of cases where laws are invalidated or reversed
- `emergencyReliefRate` `↓`: emergency orders granting interim relief
- `intakeAcceptanceRate` `diag.`: accepted review matters divided by estimated upstream filings
- `emergencyReasonGivingRate` `↑`: emergency orders with public reasons or explanation
- `emergencyVoteDisclosureRate` `↑`: emergency orders with disclosed votes or member positions
- `emergencyPublicDisagreementRate` `↓`: emergency orders with public dissents, concurrences, or visible disagreement
- `governmentEmergencyWinRate` `diag.`: government emergency applicants receiving requested interim relief
- `meritsFollowUpRate` `↑`: emergency matters routed into merits review
- `meritsReviewRate` `diag.`: accepted cases receiving merits review
- `meritsInvalidationRate` `↓/diag.`: merits reviews that invalidate a law or action
- `constitutionalConflict` `↓`: clashes among court, legislature, executive, public mandate, and cross-checking bodies
- `democraticResponsiveness` `↑`: respect for public mandate unless rights-threat signals justify countermajoritarian action
- `legislativeResponseCredibility` `↑`: modeled capacity and incentive for constructive legislative response to review
- `caseSelectionAccess` `↑`: modeled access to constitutional review after litigant capacity, public-interest support, repeat-player advantage, and intake filtering
- `governmentRepeatPlayerAdvantage` `↓`: modeled procedural or capacity advantage for repeat government litigants
- `implementationCapacity` `↑`: modeled ability of public institutions to implement review outcomes despite cost and conflict
- `democraticConstitutionalism` `↑`: composite combining rights protection, responsiveness, legitimacy, compliance, implementation, review access, low conflict, low veto relocation, feasibility, and political-culture robustness
- `vetoRelocationRisk` `↓`: risk that review merely shifts veto power into courts, councils, screeners, cross-checking bodies, or response stages
- `legalTransplantFeasibility` `↑`: modeled fit between a design, institutional capacity, and portability outside its home context
- `politicalCultureSensitivity` `↓`: modeled dependence on trust, low polarization, compliance norms, and cooperative legislative response
- `independenceAccountabilityBalance` `↑`: scenario-specific fit between independence and accountability pressure
- `complianceRate` `↑`: share of cases where institutions comply with review outcomes
- `defianceRate` `↓`: direct refusal to follow court outcomes
- `workaroundRate` `↓`: legislative or executive workaround behavior after review
- `repeatedLitigationRate` `diag.`: follow-on litigation pressure after ambiguous, defied, or worked-around outcomes
- `executiveImplementationRate` `↑`: executive implementation of review outcomes
- `agencyNonacquiescenceRate` `↓`: agency refusal, narrowing, or delayed implementation after review
- `legislativeReenactmentRate` `↓`: reenactment or recoding after adverse review
- `invalidationLegislativeReenactmentRate` `↓/diag.`: reenactment or effective overruling among merits invalidations
- `localGovernmentComplianceRate` `↑`: state or local compliance with review outcomes
- `publicTrust` `diag.`: evolving public trust after decisions and institutional reactions
- `legislativeConflict` `↓`: evolving legislature-court conflict pressure
- `courtCurbingPressure` `↓`: pressure to restrict court authority
- `amendmentPressure` `diag.`: constitutional amendment pressure generated by conflict
- `weakFormDeclarationRate` `diag.`: share of cases producing weak-form declarations rather than automatic invalidation
- `suspendedDeclarationRate` `diag.`: share of cases with delayed-effect invalidity declarations
- `legislativeResponseRate` `↑/diag.`: share of declarations, overrides, or mandatory response triggers receiving legislative response
- `invalidationLegislativeResponseRate` `↑/diag.`: share of merits invalidations followed by a modeled legislative response
- `averageLegislativeResponseDelay` `↓/diag.`: normalized delay among legislative responses after declarations, overrides, or mandatory response triggers
- `timelyLegislativeResponseRate` `↑`: share of legislative responses occurring before the modeled response deadline
- `rightsImpactStatementRate` `diag.`: share of cases with front-end rights-impact statement review
- `ombudsmanTriggerRate` `diag.`: share of cases receiving ombudsman-triggered review access
- `publicDefenderParticipationRate` `diag.`: share of cases with constitutional public-defender participation
- `preEnactmentReviewRate` `diag.`: share of cases routed through pre-enactment review
- `abstractReviewRate` `diag.`: share of cases routed through abstract review
- `preliminaryReferenceRate` `diag.`: share of CJEU-style docket entering through preliminary reference
- `appealRouteRate` `diag.`: share of CJEU-style docket entering through appeal route
- `directActionRate` `diag.`: share of CJEU-style docket entering through direct action
- `concurrenceFragmentation` `↓/diag.`: fractured majority/opinion structure
- `dissentIntensity` `↓/diag.`: close, polarized dissent pressure
- `stateCaseShare` `diag.`: share of docket originating primarily in state-law or state-court settings
- `mixedJurisdictionShare` `diag.`: share of docket with state-federal conflict structure
- `averageLowerCourtDepth` `diag.`: average number of lower-court layers before final review
- `stateFederalTension` `diag.`: average federalism tension in the docket
- `intercourtConflict` `diag.`: average conflict among lower courts or court systems
- `averageTimeToReview` `diag.`: lower-court and certiorari pipeline delay
- `replacementRate` `diag.`: court-composition turnover pressure across review periods
- `administrativeLoad` `↓`: procedural burden from review structure, emergency review, cross-checks, and recusals
- `directCourtCost` `↓`: benchmarked direct court budget, staffing, and institutional-scale burden
- `upstreamScreeningCost` `↓`: burden shifted to intake filters, lower courts, councils, or admissibility screening
- `capacityStrainCost` `↓`: capacity pressure from filings, emergency load, cross-checks, and turnover
- `institutionalBudgetCost` `↓`: scenario-specific staffing and duplication cost from court size, councils, cross-checking structures, and recusal substitutions
- `institutionalDelayCost` `↓`: scenario-specific delay cost from lower-court path, en banc steps, cross-checks, councils, and emergency shortcuts
- `implementationComplexity` `↓`: operational complexity from thresholds, overrides, recusal machinery, and docket procedure
- `totalInstitutionalCost` `↓`: weighted budget, delay, and implementation complexity cost

## Calibration Targets

Default calibration profiles live in `config/calibration/*.csv`; `config/calibration-targets.csv` mirrors the modern SCDB profile for compatibility. The canonical construction input is `config/calibration-source-observations.csv`, which can regenerate the checked-in calibration target files:

```sh
make calibration-check
make calibration-build
make promotion-check
make research-data-check
make court-profile-check
make empirical-platform-check
```

The calibration schema is:

```text
targetFile,profileKey,court,timePeriod,targetKey,label,lowerBound,upperBound,observedValue,n,unit,method,reliability,useForValidation,note,sourceName,sourceUrl,constructionNote
```

Current profiles include U.S. Supreme Court merits-docket doctrine shares for 1946-2024 and 2000-2024 from the Supreme Court Database, 2024-2025 public/emergency context targets, country-specific calibration profiles for Germany, France, Canada, South Africa, the United Kingdom, the ECHR, and the CJEU, and normalized institutional cost profiles. Generated `*-calibration.csv` files carry the target fields plus `modelObservedValue`, 95% bands, gap, and the simulator sample denominator. Under the current source-specific rule, counted rows require a source URL, nonzero denominator, direct target analogue, and no synthesis, contextual public-trust proxy, or normalized-cost construction. The denominator-backed source-check pack currently includes U.S. Supreme Court SCDB doctrine-mix rows, U.S. emergency-docket relief, reason-giving, and public-disagreement rows, Canada SCC leave grants, historical Canada Charter-dialogue response, override, and reenactment rows, France QPC nonconformity and deferred-effect remedies, UK Supreme Court permission-to-appeal grants, UK declaration-of-incompatibility legislative responses, ECHR allocated-application and Rule 39 interim-measure targets, and CJEU route mix plus narrow rule-of-law compliance. `make promotion-check` enforces those promotion rules and rejects counted rows whose target keys are not exposed by the simulator. Other rows are documented stress-test assumptions.

Research-roadmap and source-candidate CSVs live in `config/research/`. They are not calibration targets by default. They define the next source-gathering tasks for court-specific calibration packs, legislative response evidence, transplant feasibility factors, compliance/enforcement channels, and case-selection/access data. Rows marked `promoted` have been moved into `config/calibration-source-observations.csv`; rows marked `verified-source-candidate` have denominator-backed source values and direct-analogue claims that still need promotion review; rows marked `verified-model-gap` have reproducible source measures whose statistical unit is not yet exposed by the simulator and therefore remain outside validation; rows marked `verified-context-only` have primary-source URLs but are not direct simulator analogues; rows marked `verified-bibliography-only:<url>` have a verified article or report page but unresolved numeric coding; rows still marked `pending-url-verification` remain research leads. Use `docs/deep-research-prompts.md` to generate source-backed updates before promoting any roadmap or candidate row.

The target-method note in `docs/calibration-target-methods.md` separates
source-specific targets from provisional synthesis ranges. Rows without a source
URL, rows without denominators, rows marked as synthesis, low-reliability contextual rows, public-trust proxies, and normalized-cost rows should be treated as transparent stress-test assumptions, not as empirical validation evidence.
Named real-world presets include bounded source-profile calibration hooks for
documented denominator and procedure differences in the source-range audit
surface. Synthetic mechanism scenarios continue to use the generic comparative
mechanics.

## Court Profile Index

The profile-level empirical platform index lives in
`config/court-profiles/profile-index.csv` and is generated from the calibration
source-observation matrix plus `config/context/country-year-context.csv`:

```sh
make court-profile-build
make court-profile-check
make research-data-check
make empirical-platform-report
make empirical-platform-check
make scdb-doctrine-audit
make scdb-doctrine-apply-ready
make scdb-doctrine-apply-audited-values
```

The index groups target rows by `profileKey`, records how many rows are
validation-counted, maps each profile to the relevant political-context row
when one exists, and lists missing validation-eligible families such as intake,
case-selection access, emergency, merits, remedy timing, legislative response,
route mix, compliance, and profile-specific doctrine mix. Cost and political
context remain visible in the family-coverage and source-promotion reports, but
they are contextual calibration surfaces under the current promotion rule rather
than missing source-range validation families. Treat `missingValidationFamilies`
as the empirical buildout roadmap for validation-counted rows: new rows should
be promoted only when the public source URL, denominator, period, coding rule,
construction note, and direct simulator analogue are documented.

`make research-data-check` validates the source-candidate and research-roadmap
CSV files before they feed the platform reports. It rejects malformed CSV rows,
unexpected headers, blank required fields, and research `targetKey` values that
are not mapped to a platform target family. It also enforces the source-candidate
status taxonomy, source-URL status prefixes, reliability labels, roadmap
validation-use flags, direct-analogue booleans, numeric range ordering, share
bounds, and numerator/denominator math for rows that provide counts.

`make empirical-platform-report` writes
`reports/constitutional-review-empirical-platform-v1.csv`,
`reports/constitutional-review-empirical-platform-v1-families.csv`, and
`reports/constitutional-review-empirical-platform-v1-promotion-queue.csv`,
`reports/constitutional-review-empirical-platform-v1-source-gaps.csv`,
`reports/constitutional-review-empirical-platform-v1-candidate-verification.csv`,
`reports/constitutional-review-empirical-platform-v1-source-acquisition.csv`,
`reports/constitutional-review-empirical-platform-v1-source-promotion.csv`,
and
`reports/constitutional-review-empirical-platform-v1-readiness.csv`, plus
Markdown coverage and readiness reports. The promotion queue includes
`promotionReadiness`, `claimBoundary`, and `blockingReason` columns so direct
promotion candidates are kept separate from context-only evidence and ordinary
source-acquisition gaps. A `verify-source-values` readiness state means the
source page is located but the numeric coding still needs page-level audit; a
`claim-boundary-decision-needed` state means the source package is complete but
validation promotion would broaden the manuscript's empirical claim boundary. The
candidate-verification report expands queued gaps
into the underlying candidate rows to make source checks reproducible, and the
source-acquisition report expands roadmap-backed gaps into preferred sources,
needed denominators, validation-use flags, and acquisition recommendations. It
also writes a source-promotion report that expands stress-only queue rows into
the underlying calibration-source rows, promotion blockers, and recommended
audit or validation-scope actions, plus
`config/court-profiles/profile-benchmark-cards.md`, a generated per-profile
handoff that combines each court profile's validation checks, stress-only rows,
missing families, candidate rows, and queued promotion tasks. These reports
combine profile coverage, source-observation families, source-candidate
evidence, and current source-range miss categories into a reusable
calibration-platform roadmap. The readiness report is the claim-boundary
artifact: it records which publication claims are currently supported and which
ones require source expansion before broader country-profile validation claims.
`make empirical-platform-check` verifies the generated files and also checks
that queue ranks, source-gap ranks, candidate-verification rows,
source-acquisition rows, source-promotion rows, actionability categories, and
readiness counts agree.
`make scdb-doctrine-audit` is an optional network-backed source-audit aid:
it downloads the official SCDB 2025 Release 01 case-centered citation CSV,
audits the checked-in SCDB doctrine-mix rows against their denominator and
numerator coding rules, and writes
`reports/constitutional-review-scdb-doctrine-denominator-audit.csv`. The audit
does not promote rows by itself. The checked-in SCDB doctrine rows are now
validation-counted after denominator audit and model-calibration against an
explicit SCDB merits-docket profile with a residual `other` bucket.
`make scdb-doctrine-apply-ready` fills
denominators and construction notes only for SCDB doctrine rows whose current
observed values match the audit; it leaves value-mismatch rows and
`useForValidation` flags unchanged. `make scdb-doctrine-apply-audited-values`
also updates observed values from the audit, but only when the audited value
falls inside the row's existing source range; it still leaves validation-use
flags unchanged. Any future SCDB coding change should be paired with
`make validation-check` so doctrine-mix source-range evidence remains a
deliberate claim-boundary decision rather than an automatic audit side effect.

## Research Configs

Research-derived structured inputs are checked in under `config/`:

- `config/comparative/constitutional-review-designs.csv`: court-system design matrix and simulator scenario mapping
- `config/comparative/synthetic-review-mechanisms.csv`: synthetic mechanism matrix with transplant, culture-fit, and implementation-cost notes
- `config/court-profiles/profile-index.csv`: generated profile-level index of source rows, counted validation rows, context mappings, missing validation families, and next calibration priorities
- `config/court-profiles/profile-benchmark-cards.md`: generated per-profile benchmark cards separating validation-counted rows, stress-only context, source-range misses, and promotion tasks
- `config/research/legislative-response-source-candidates.csv`: denominator-backed weak-form, suspended-declaration, override, and mandatory-response findings with promotion status
- `config/research/comparative-calibration-source-candidates.csv`: comparative court intake, route-mix, timing, emergency, and nonunanimity targets with source and mapping status
- `config/research/transplant-indicator-operationalization.csv`: transplant-feasibility indicators, source families, ranges, and simulator-field mappings
- `config/pipeline/us-scotus-pipeline.csv`: filings, certiorari, lower-court conflict, state-court origin, en banc, and timing benchmarks
- `config/emergency/scotus-emergency-schema.csv`: row schema for future emergency-review and shadow-docket datasets
- `config/emergency/scotus-emergency-summary.csv`: universe and curated-sample emergency docket benchmarks
- `config/cost-benchmarks/institutional-costs.csv`: normalized direct, delay, complexity, and capacity cost profiles

## Case-Level Exports and Uncertainty Bands

Campaign runs write compressed raw outcome files under `reports/*-cases.csv.gz`.
These files contain one row per generated case outcome, including case inputs,
review pathway, mechanism flags, emergency disposition, merits disposition, compliance outcomes,
reaction state, transplant/culture/veto diagnostics, and cost metrics. Aggregate campaign and segment interval CSVs
now use a deterministic 200-sample cluster bootstrap that resamples whole
generated-world run blocks from these case-level outcomes. Composition and
calibration intervals remain conservative denominator-based checks where there
is no direct case-level analogue. The compressed case-level and interval files
are generated locally and should be included in a final public replication
deposit, but the anonymous review ZIP excludes them by default to avoid an
unnecessarily large upload.

## Legislative Import Contract

The importer reads the legislative simulator's campaign CSV columns when present:

- `scenarioKey`, `caseKey`, `avgSupport`, `welfare`, `legitimacy`
- `policyDomain` when present; accepted values include `civil-rights`, `speech-religion`, `criminal-justice`, `federalism`, `governance`, `elections`, `emergency-security`, `economic-regulation`, and `administration`
- `lowSupport`, `weakPublicMandatePassage`, `minorityHarm`, `concentratedHarmPassage`
- `lobbyCapture`, `publicAlignment`, `publicPreferenceDistortion`
- `policyShift`, `proposerGain`, `reversalRate`, `statusQuoVolatility`
- `fastLaneRate`, `highRiskLaneRate`, `challengeRate`

Missing columns are tolerated and replaced with neutral defaults. If `policyDomain` is missing, the importer infers a domain from row names and stress signals. Each imported row becomes a legislative signal that can generate constitutional-review cases. This keeps the court project decoupled from the legislative simulator while preserving a stable data bridge.
