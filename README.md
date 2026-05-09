# Constitutional Review Simulator

This is a dependency-free Java simulator for comparing supreme-court and constitutional-review designs. It is intentionally separate from the legislative simulator, but it can import legislative campaign CSV output as the docket generator for review cases. It is now positioned as a broader comparative-design companion to any narrower Supreme Court simulator, not as a deprecated predecessor or a codebase that should be merged into a single-court model.

The model is built for comparative institutional design, not for predicting any real court. It keeps the same working style as the legislative simulator: named scenarios, randomized worlds, campaign sweeps, metrics with explicit directions, CSV/Markdown reports, and provenance manifests.

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

The aggregate CSVs include scenario kind, review mechanism, intake filings, screened filings, intake acceptance rate, emergency reason-giving, emergency vote disclosure, public emergency disagreement, government emergency applicant/win diagnostics, emergency merits follow-up, mechanism rates, legislative-response credibility, case-selection access, government repeat-player advantage, implementation capacity, democratic constitutionalism, veto-relocation risk, legal-transplant feasibility, political-culture sensitivity, direct court cost, upstream screening cost, capacity strain cost, and aggregate budget/delay/complexity cost fields.

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

Run the validation-style benchmark campaign:

```sh
make validation-check
```

This compares the real-world scenario presets for the U.S. Supreme Court,
German Federal Constitutional Court, French Constitutional Council, Supreme
Court of Canada, and South African Constitutional Court against the shared
benchmark docket. It writes the same aggregate, segment, compressed case-level,
bootstrap interval, calibration, Markdown, and manifest artifact family under
the `reports/constitutional-review-validation-v1*` prefix.

Run tests:

```sh
make test
```

Build the starter LaTeX paper and supplementary appendix:

```sh
make paper
make supplement
```

The paper source is in `paper/main.tex`; the compiled PDF is written to `paper/build/main.pdf`.
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
- emergency/shadow docket procedures: fast emergency orders, reasoned emergency panels, full-court emergency review, and merits follow-up
- doctrine areas: speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state
- policy domains: civil rights, speech/religion, criminal justice, federalism, governance, elections, emergency/security, economic regulation, and administration; imported legislative rows preserve an explicit `policyDomain` column when present and otherwise infer one from row labels and stress signals
- state/federal and lower-court pipeline signals: federal, state, and mixed state-federal jurisdiction; district-only, circuit-panel, en banc, state high-court, and state-federal split paths; panel skew, government win/loss, conflict pressure, certiorari pressure, and time-to-review
- court-system archetypes: discretionary appellate leave, constitutional complaint, pre-enactment council, mixed abstract/concrete review, declaration-only parliamentary review, and supranational treaty review
- real-world presets: U.S. Supreme Court, German Federal Constitutional Court, French Constitutional Council, Supreme Court of Canada, South African Constitutional Court, UK Supreme Court, India Supreme Court, Brazil STF, ECHR, and CJEU
- public and legislative reaction dynamics: compliance, defiance, workarounds, repeated litigation, court-curbing pressure, amendment pressure, trust shifts, executive implementation, agency nonacquiescence, legislative reenactment, and local-government compliance
- political-system and implementation assumptions: party fragmentation, governing coalition control, electoral time pressure, civil-society capacity, implementation capacity, and legal-tradition compatibility
- voting thresholds: simple majority, supermajority invalidation, concurrent-majority logic, and high constitutional thresholds
- concurring/dissenting coalitions: modeled as fragmentation and dissent intensity metrics
- panel vs en banc review
- dual supreme courts or cross-checking courts
- constitutional councils
- legislative override rules
- independence vs accountability balance
- scenario-kind separation: real-world presets, court variants, and synthetic mechanism tests
- synthetic noncourt mechanisms: weak-form review, suspended declarations of invalidity, legislative override clauses, pre-enactment review, abstract review, ombudsman-triggered review, constitutional public defenders, rights-impact statements, and mandatory legislative response cycles

## Metrics

Core metrics:

- `legalStability` `↑`: doctrinal and institutional stability after review
- `rightsProtection` `↑`: protection against high-rights-threat laws without over-invalidating low-threat laws
- `partisanAlignment` `↓`: extent to which review tracks partisan/ideological law origin more than legal risk
- `shadowDocketAbuse` `↓`: unexplained or emergency-driven high-impact review
- `legitimacy` `↑`: public trust, transparency, broad agreement, and rights performance net of conflict
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
- `democraticConstitutionalism` `↑`: synthetic diagnostic combining rights protection, responsiveness, legitimacy, compliance, implementation, review access, low conflict, low veto relocation, feasibility, and political-culture robustness
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
- `localGovernmentComplianceRate` `↑`: state or local compliance with review outcomes
- `publicTrust` `diag.`: evolving public trust after decisions and institutional reactions
- `legislativeConflict` `↓`: evolving legislature-court conflict pressure
- `courtCurbingPressure` `↓`: pressure to restrict court authority
- `amendmentPressure` `diag.`: constitutional amendment pressure generated by conflict
- `weakFormDeclarationRate` `diag.`: share of cases producing weak-form declarations rather than automatic invalidation
- `suspendedDeclarationRate` `diag.`: share of cases with delayed-effect invalidity declarations
- `legislativeResponseRate` `↑/diag.`: share of declarations, overrides, or mandatory response triggers receiving legislative response
- `rightsImpactStatementRate` `diag.`: share of cases with front-end rights-impact statement review
- `ombudsmanTriggerRate` `diag.`: share of cases receiving ombudsman-triggered review access
- `publicDefenderParticipationRate` `diag.`: share of cases with constitutional public-defender participation
- `preEnactmentReviewRate` `diag.`: share of cases routed through pre-enactment review
- `abstractReviewRate` `diag.`: share of cases routed through abstract review
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
```

The calibration schema is:

```text
targetFile,profileKey,court,timePeriod,targetKey,label,lowerBound,upperBound,observedValue,n,unit,method,reliability,useForValidation,note,sourceName,sourceUrl,constructionNote
```

Current profiles include U.S. Supreme Court merits-docket doctrine shares for 1946-2024 and 2000-2024 from the Supreme Court Database, 2024-2025 public/emergency context targets, country-specific calibration profiles for Germany, France, Canada, and South Africa, and normalized institutional cost profiles. Generated `*-calibration.csv` files carry the target fields plus `modelObservedValue`, 95% bands, gap, and the simulator sample denominator. Under the current source-specific rule, validation-counted rows require a source URL, nonzero denominator, direct target analogue, and no synthesis or normalized-cost construction. Other rows are documented stress-test assumptions, not empirical validation evidence.

Research-roadmap and source-candidate CSVs live in `config/research/`. They are not calibration targets yet. They define the next source-gathering tasks for court-specific calibration packs, legislative response evidence, transplant feasibility factors, compliance/enforcement channels, and case-selection/access data. The `*-source-candidates.csv` files preserve denominator-backed findings from the research pass, but keep them out of validation until source URLs, coding rules, and direct simulator analogues are verified. Use `docs/deep-research-prompts.md` to generate source-backed updates before promoting any roadmap or candidate row into `config/calibration-source-observations.csv`.

The target-method note in `docs/calibration-target-methods.md` separates
source-specific targets from provisional synthesis ranges. Rows without a source
URL, rows without denominators, rows marked as synthesis, low-reliability contextual rows, public-trust proxies, and normalized-cost rows should be treated as transparent stress-test assumptions, not as empirical validation evidence.

## Research Configs

Research-derived structured inputs are checked in under `config/`:

- `config/comparative/constitutional-review-designs.csv`: court-system design matrix and simulator scenario mapping
- `config/comparative/synthetic-review-mechanisms.csv`: synthetic mechanism matrix with transplant, culture-fit, and implementation-cost notes
- `config/research/legislative-response-source-candidates.csv`: denominator-backed weak-form, suspended-declaration, override, and mandatory-response findings awaiting source-URL verification
- `config/research/comparative-calibration-source-candidates.csv`: comparative court intake, route-mix, timing, emergency, and nonunanimity targets awaiting source-URL and mapping verification
- `config/research/transplant-indicator-operationalization.csv`: transplant-feasibility indicators, source families, ranges, and simulator-field mappings
- `config/pipeline/us-scotus-pipeline.csv`: filings, certiorari, lower-court conflict, state-court origin, en banc, and timing benchmarks
- `config/emergency/scotus-emergency-schema.csv`: row schema for future emergency/shadow-docket datasets
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
