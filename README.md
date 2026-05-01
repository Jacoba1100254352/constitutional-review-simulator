# Constitutional Review Simulator

This is a dependency-free Java simulator for comparing supreme-court and constitutional-review designs. It is intentionally separate from the legislative simulator, but it can import legislative campaign CSV output as the docket generator for review cases.

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
make run ARGS="--legislative-input '/Users/jacobanderson/Documents/simulators/Congress Institutional Simulator/reports/simulation-campaign-v21-paper.csv' --scenarios current-federal-court,constitutional-council,legislative-override-court"
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
- `reports/constitutional-review-campaign-v0-intervals.csv`
- `reports/constitutional-review-campaign-v0-pipeline-intervals.csv`
- `reports/constitutional-review-campaign-v0-composition-intervals.csv`
- `reports/constitutional-review-campaign-v0-calibration-intervals.csv`
- `reports/constitutional-review-campaign-v0.md`
- `reports/constitutional-review-campaign-v0-manifest.json`

Run the paired imported-legislative campaign:

```sh
make paired-campaign
```

This reads the sibling legislative simulator campaign CSV and writes:

- `reports/constitutional-review-paired-import-v1.csv`
- `reports/constitutional-review-paired-import-v1-periods.csv`
- `reports/constitutional-review-paired-import-v1-doctrines.csv`
- `reports/constitutional-review-paired-import-v1-pipelines.csv`
- `reports/constitutional-review-paired-import-v1-policy-domains.csv`
- `reports/constitutional-review-paired-import-v1-composition.csv`
- `reports/constitutional-review-paired-import-v1-calibration.csv`
- `reports/constitutional-review-paired-import-v1-intervals.csv`
- `reports/constitutional-review-paired-import-v1-pipeline-intervals.csv`
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
- `reports/constitutional-review-sensitivity-v1-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-pipeline-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-composition-intervals.csv`
- `reports/constitutional-review-sensitivity-v1-calibration-intervals.csv`
- `reports/constitutional-review-sensitivity-v1.md`
- `reports/constitutional-review-sensitivity-v1-manifest.json`

Run tests:

```sh
make test
```

Build the starter LaTeX paper:

```sh
make paper
```

The paper source is in `paper/main.tex`; the compiled PDF is written to `paper/build/main.pdf`.

## Scenario Families

The starter catalog covers:

- appointment methods: presidential/senate, supermajority commission, merit sortition, legislative selection, and retention-accountability variants
- court size: 9, 12, 15, and 18 member designs
- term limits: life tenure, nonrenewable 18-year terms, and shorter renewable terms
- removal standards: impeachment-only, misconduct commission, and retention election pressure
- recusal rules: self-policing, mandatory conflict recusal, random substitution, and strict transparency
- emergency/shadow docket procedures: fast emergency orders, reasoned emergency panels, full-court emergency review, and merits follow-up
- doctrine areas: speech, equality, criminal procedure, federalism, election law, emergency powers, and administrative state
- policy domains: civil rights, criminal justice, governance, elections, emergency/security, economic regulation, and administration; imported legislative rows preserve an explicit `policyDomain` column when present and otherwise infer one from row labels and stress signals
- state/federal and lower-court pipeline signals: federal, state, and mixed state-federal jurisdiction; district-only, circuit-panel, en banc, state high-court, and state-federal split paths; panel skew, government win/loss, conflict pressure, certiorari pressure, and time-to-review
- public and legislative reaction dynamics: compliance, defiance, workarounds, repeated litigation, court-curbing pressure, amendment pressure, trust shifts, executive implementation, agency nonacquiescence, legislative reenactment, and local-government compliance
- voting thresholds: simple majority, supermajority invalidation, concurrent-majority logic, and high constitutional thresholds
- concurring/dissenting coalitions: modeled as fragmentation and dissent intensity metrics
- panel vs en banc review
- dual supreme courts or cross-checking courts
- constitutional councils
- legislative override rules
- independence vs accountability balance

## Metrics

Core metrics:

- `legalStability` `↑`: doctrinal and institutional stability after review
- `rightsProtection` `↑`: protection against high-rights-threat laws without over-invalidating low-threat laws
- `partisanAlignment` `↓`: extent to which review tracks partisan/ideological law origin more than legal risk
- `shadowDocketAbuse` `↓`: unexplained or emergency-driven high-impact review
- `legitimacy` `↑`: public trust, transparency, broad agreement, and rights performance net of conflict
- `reversalRate` `↓/diag.`: share of cases where laws are invalidated or reversed
- `emergencyReliefRate` `↓`: emergency orders granting interim relief
- `meritsReviewRate` `diag.`: accepted cases receiving merits review
- `meritsInvalidationRate` `↓/diag.`: merits reviews that invalidate a law or action
- `constitutionalConflict` `↓`: clashes among court, legislature, executive, public mandate, and cross-checking bodies
- `democraticResponsiveness` `↑`: respect for public mandate unless rights-threat signals justify countermajoritarian action
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
- `institutionalBudgetCost` `↓`: scenario-specific staffing and duplication cost from court size, councils, cross-checking structures, and recusal substitutions
- `institutionalDelayCost` `↓`: scenario-specific delay cost from lower-court path, en banc steps, cross-checks, councils, and emergency shortcuts
- `implementationComplexity` `↓`: operational complexity from thresholds, overrides, recusal machinery, and docket procedure
- `totalInstitutionalCost` `↓`: weighted budget, delay, and implementation complexity cost

## Calibration Targets

Default calibration profiles live in `config/calibration/*.csv`; `config/calibration-targets.csv` mirrors the modern SCDB profile for compatibility. Current profiles include U.S. Supreme Court merits-docket doctrine shares for 1946-2024 and 2000-2024 from the Supreme Court Database, plus 2024 public/emergency context targets from SCOTUSblog and Gallup. The campaign `*-calibration.csv` files report profile key, court, time period, source URL, observed value, target range, 95% band, and gap. These are documented external checks, not claims that the synthetic model is empirically validated.

## Uncertainty Bands

Campaign runs write conservative 95% uncertainty bands for aggregate campaign metrics, pipeline segments, composition periods, and calibration targets. The interval files use aggregate denominators already stored in the reports, so they are lightweight confidence bands rather than raw per-case bootstrap resamples.

## Legislative Import Contract

The importer reads the legislative simulator's campaign CSV columns when present:

- `scenarioKey`, `caseKey`, `avgSupport`, `welfare`, `legitimacy`
- `policyDomain` when present; accepted values include `civil-rights`, `criminal-justice`, `governance`, `elections`, `emergency-security`, `economic-regulation`, and `administration`
- `lowSupport`, `weakPublicMandatePassage`, `minorityHarm`, `concentratedHarmPassage`
- `lobbyCapture`, `publicAlignment`, `publicPreferenceDistortion`
- `policyShift`, `proposerGain`, `reversalRate`, `statusQuoVolatility`
- `fastLaneRate`, `highRiskLaneRate`, `challengeRate`

Missing columns are tolerated and replaced with neutral defaults. If `policyDomain` is missing, the importer infers a domain from row names and stress signals. Each imported row becomes a legislative signal that can generate constitutional-review cases. This keeps the court project decoupled from the legislative simulator while preserving a stable data bridge.
