# Historical Benchmark and Robustness v1: completion audit

Status: complete for the bounded research and implementation milestone.
The scientific evidence, publication integration and corrected anonymous
replication have passed their required checks. The fresh extractions use the
recorded local runtime; this is not a claim of independent-researcher or
cross-platform replication, journal acceptance or live deployment.

## Objective and evidence boundaries

The milestone asks whether a historically estimated docket-category model
transfers to a newly evaluated term, and which of three existing institutional
claims survives a registered grid of assumptions and interventions. It does
not require a winning design, favorable forecast result, perfect source fit,
additional countries, or future data.

The empirical result is a 66-dispute SCDB 2025-term docket-composition test.
The recency-weighted model's Brier difference from the fixed generator is
0.001704, with conditional paired 95% interval [-0.007500, 0.010336]: no clear
conditional advantage. This is neither substantive judicial-outcome validation
nor empirical identification of institutional reform effects.

The institutional study qualifies all three original claims. Design-specific
duration is unsupported by the shared review-time input; council screening
does not show substantial upstream displacement in the tested intervention;
and legislative response explains only part of modeled weak-form advantages.
Sparse/empty conditional denominators, mechanically encoded model terms,
Monte Carlo uncertainty, structural alternatives and preference sensitivity
remain visible. No institutional winner is asserted.

## Requirement-to-evidence audit

Core evidence: [frozen empirical report](../reports/constitutional-review-historical-benchmark-v1.md),
[paired analysis](../reports/constitutional-review-historical-robustness-v1.md),
[raw audit](../reports/constitutional-review-historical-robustness-v1-raw-audit.json),
[independent analysis validation](../reports/constitutional-review-historical-robustness-v1-analysis-validation.md),
and [chronological execution log](historical-benchmark-execution-log.md).

| Requirement | Evidence and verification |
| --- | --- |
| Freeze before new-term inspection | The protocol/exposure audit was committed at `9ff4746`; training-only forecasts at `61944e1`; source acquisition metadata and locks preserve the ordering. These are repository records, not independent preregistration or proof of ignorance of public events. |
| Preserve first evaluation and source revisions separately | The immutable first evaluation and lock reproduce without refitting. The full 53-field historical audit reports two added and ten changed old records, separately from 66 new-term disputes; old training records are not replaced. |
| Exact units, identifiers and missingness | `data/historical/README.md`, source registries, derivatives and protocol specify citation-centered disputes, coded terms, stable case IDs, eight disjoint categories and explicit OTHER/missing-code counts. Ingestion and adversarial tests enforce them. |
| Four forecasts and honest uncertainty | The first empirical report retains the fixed generator, recency-weighted empirical model, expanding-history and previous-term baselines; primary/secondary scores, conditional paired intervals and exposed retrospective diagnostics are distinct. |
| Full paired grid | Four profiles, thirteen contexts, eight designs, 120 runs and 80 cases produce 49,920 design-run observations, 3,993,600 case outcomes and 5,193,352 object outcomes. All 6,240 shared dockets and 199,680 stream identities are audited. |
| Real mechanism interventions | Procedure-only and structure-only variants retain other configuration fields. Half/off response interventions affect credibility and events with a separate stream. Factor-one behavior and legacy output identity are tested. |
| All three claims and negative findings | The report and 22-row claim matrix retain every component, unsupported duration, denominator caveats, accounting comparison and partial response dependence. The signed implementation contract's timing and later denominator diagnostic are disclosed. |
| Separate uncertainty types | There are 3,692 paired contrasts with 2,000 whole-run bootstrap draws; the 52-cell structural grid is not probabilistic. The 1,000 shared normative vectors and 6,000 fixed-weight cross-grid comparisons are a separate preference exercise. |
| Independent calculation checks | Raw validation reconstructs 84 run measures. Analysis validation independently checks every paired point estimate/SE, all ranking rows and 93 expanded-index bootstrap intervals. Full deterministic re-execution checks all analysis bytes; independent interval coverage is not overstated. |
| Main manuscript and supplement | Thirteen source-hashed historical tables preserve all 22 components, 49 intervention/persistence patterns, 71 reference-cell intervals and nine empirical paired score differences. The original campaign, calibration and sensitivity tables remain. |
| Legacy/source boundaries | Native preservation verifies 96 aggregate fields across eight presets. Existing source definitions and calibration inputs are unchanged. France QPC invalidation (0.299 versus 0.305--0.324) and CJEU compliance (0.642 versus 0.534--0.632) remain explicit misses. Congress outputs remain separate imported CSV signals. |
| Regression tests and native CI | Main-checkout full CI passed at the publication integration checkpoint. The corrected anonymous package independently passes full native CI, including the Java suite and all 66 Python measurement tests. |
| Anonymous runnable materials | Source and replication ZIPs exclude repository metadata, developer instructions, original source caches, build products and large raw exports. Retained gzip content is decoded for privacy checks. The source-only build and both corrected-package verification runs pass. |
| Publication, commit and push | The analysis (`4f4e836`), manuscript/supplement (`7761177`) and extracted-package fix (`9695ad1`) are committed and pushed. Completion documentation records the final verified state without rewriting scientific evidence. No journal upload, release or acceptance is implied. |

## Corrected-package verification

The first extracted attempt failed because the manuscript checker expected
developer instructions deliberately omitted from the archive. This failure
and its tested correction are preserved in the execution log. No scientific
input, estimate or manuscript text changed.

Two separate fresh extractions of the same corrected 307-member replication
archive were verified byte-for-byte before execution. Neither contained Git
metadata, source caches, compiled code, PDFs or large historical raw outputs.
One ran source reacquisition plus full native CI; the other independently
regenerated the full historical simulation, raw audit and analyses. Separate
trees allow parallel checks without shared output files. They use OpenJDK 25,
release-21 compilation and Python 3.14.7.

| Tested archive | SHA-256 |
| --- | --- |
| Replication package at correction checkpoint | `04c1c4799fe0a911678b99b276272c1a8126ea89c4827c10b9158e88ea0f2027` |
| Editable source package at correction checkpoint | `c523eafa452fe6528a32d3587b7302bf0878f37afcf006059bfc6a9b428f7a53` |

The source-only ZIP was independently extracted and both documents built
directly with `latexmk`, using its disclosed local compatibility shim. All
55 resulting page PNGs are byte-identical to the previously inspected renders;
all-page extracted text also matches. The documents contain 22 and 33 pages,
blank author metadata, no forms or JavaScript, and no final overfull or
unresolved-reference/citation warnings. This is local review-build verification,
not certification of an official publisher production template.

The source checkout's reviewed artifacts retain these fingerprints:

| Artifact | SHA-256 |
| --- | --- |
| Frozen first evaluation | `4344593b9c6db932ce06ef7e5084d2f9577d838208f3f6df3be354142c7c08cb` |
| Full simulation manifest | `2e9c76e414042cacdcb0963b73419e03c256a48cb196d665d799e95db2cb0c60` |
| Paired analysis manifest | `d0747a10d5bb5169b0b4cc6b4b9669f4cf2f8e3cac5659174dce31fbebac93eb` |
| Main manuscript PDF | `8796fc90d0faa91420915258df2bc93951f0ffbf57ef1f3712c55984ccb0370e` |
| Supplement PDF | `1a88038b17173eb0b762c860397c638f34a0533a70c94e43ace4f8f92e5217f6` |

The historical simulation has regenerated all ten output files, including the
omitted case, object, shared-docket and segment exports. Every file matches
the SHA-256 value read from the simulation manifest in the untouched original
archive, and the regenerated simulation manifest itself is byte-identical.
This comparison does not depend only on a newly generated self-consistent
manifest. Independent raw-data reconciliation and analysis regeneration also
passed. The regenerated raw-audit SHA-256 is
`5342653395c7cc79473e51b11201080c465d0198e28b57011ea674fb1a1db174`,
identical to the archived original.

Both command chains exited successfully. After historical regeneration, all
307 retained archive members are byte-identical, including the entire paired
analysis, independent validation, first evaluation, locks and publication
tables. The full-CI tree also preserves all 307 retained members. Its 38
original-campaign report/manifest/miss files match the untouched archive;
its eight regenerated original-campaign raw files and 28 interval files match
the source checkout. Full-CI PDF text and all 55 rendered page PNGs match the
reviewed originals, just as the separately built source-only PDFs do.

The final completion update is documentation-only: the README, chronological
execution log and this audit. The rebuilt replication package contains 308
members; these three documents are its only content differences from the
verified correction-checkpoint archive. All 51 editable-source package members
are unchanged. The final archive privacy checks pass. Archive bytes can change
with documentation and ZIP timestamps; this is not evidence of changed
simulation, data, statistical or publication content.

## Reproduction

Keep an untouched copy of the supplied replication ZIP, extract another copy,
and run from the extracted root:

```sh
make historical-sources historical-benchmark-check
make ci
make historical-replication
make historical-study-check historical-analysis-check historical-analysis-validation-check paper-historical-check
```

Do not repeat the original acquisition/freeze commands or use the test term
to fit replacement forecasts. Source reacquisition requires the two pinned
public downloads; the retained first-evaluation check itself is offline.
Large raw files omitted for review are regenerated by the commands above.
Reproduction on the recorded runtime can compare their SHA-256 values with
the `outputSha256` map in the study manifest inside the untouched ZIP, not
only the newly generated manifest. Compare the original and regenerated
analysis artifacts, first evaluation and publication tables as well.

## Checkpoint status semantics

The frozen empirical report, simulation manifest and analysis manifest retain
their original stage-specific completion wording. Their statuses certify only
their own stage and intentionally do not certify later publication work.
The execution log is chronological. This completion audit and the top-level
README are the current overall-milestone status; historical checkpoint bytes
are not rewritten to manufacture a later certification.

The remaining journal submission checklist concerns editor/production
requirements and any eventual accepted public deposit. Such external actions
are outside this research milestone and are not silently treated as completed.
