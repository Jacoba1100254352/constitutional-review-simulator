# Historical robustness study: implementation and data contract

This opt-in experiment implements the unchanged
[frozen protocol](historical-benchmark-protocol.md). The empirical first result,
its scoring code and its forecasts are not rewritten. These implementation
details were recorded before the full institutional grid was executed.

## Inputs and experimental unit

`make historical-study-inputs` deterministically derives `study-profiles.csv`,
`study-contexts.csv` and `study.properties` in `config/historical-benchmark`.
`make historical-study-inputs-check` checks their exact bytes against the locked
protocol and training-only forecasts. Preparation does not read observed 2025
category frequencies. Other inputs and institutional relationships remain
synthetic assumptions.

The full study uses four forecast profiles, thirteen contexts, eight designs,
120 runs per cell and 80 cases per run spanning four review periods. It has
49,920 design-run observations and 3,993,600 case outcomes, from 6,240 shared
dockets containing 499,200 case inputs. Challenged objects are nested within
cases, not additional independent cases.

Each run generates one immutable world for all eight designs. Every returned
case and its complete ordered object list must equal that input or the runner
fails. Within a profile/context cell, runs have distinct world seeds. World
seeds use existing Simulator arithmetic and the WorldSpec value fingerprint;
explicit forecast vectors override its doctrine enum. Across profiles or
contexts, a shared seed does not imply equal dockets. These cells are not
independent samples of real-world political environments.

Voting streams vary by design and period as in the legacy Simulator. Response
thinning uses a separate domain-separated, case-keyed stream with a distinct
run/period seed. Response-factor designs share the thinning stream identity,
but not voting draws. An exported stream inventory is independently checked
in Python using signed 64-bit arithmetic.

Configuration ablations change only the registered procedure or structure,
including retaining the parent configuration's label. Response ablations
leave the design configuration unchanged. Tests compare every configuration
component, exact factor-one behavior and downstream response effects.
Base-design contrasts remain bundle comparisons, not single-variable causal
effects.

## Export families and keys

Outputs in `reports` use prefix `constitutional-review-historical-robustness-v1`.
CSVs use UTF-8, LF line endings, round-trippable unrounded numbers, explicit
headers and standard quoting. Gzip output is deterministic.

| Suffix | Grain and contents |
| --- | --- |
| `-runs.csv.gz` | Profile/context/run/design; all scalar ScenarioReport fields, docket/object hashes, world seed, response factor |
| `-dockets.csv.gz` | Profile/context/run/case; all scalar CaseFile inputs including doctrine, policy, pipeline, period and original review time |
| `-cases.csv.gz` | Profile/context/run/design/case; all scalar CaseOutcome fields including response timing, enforcement, emergency/merits and cost outcomes |
| `-objects.csv.gz` | Profile/context/run/design/case/object; source object fields, dispositions and statute numerator/denominator indicators |
| `-segments.csv.gz` | Profile/context/run/design/segment-type/segment-key; period, doctrine, pipeline and policy-domain reports |
| `-compositions.csv.gz` | Profile/context/run/design/composition segment; turnover and composition diagnostics |
| `-streams.csv.gz` | Profile/context/run/design/period; voting and response seeds |
| `-designs.csv`, `-contexts.csv` | Actual complete design configurations and WorldSpec settings |
| `-counts.json`, `-manifest.json` | Reconciled counts, source/input/output hashes, runtime identity and quality checks |

IDs repeat across runs and are unique only within their composite key. Join
outcomes to shared inputs on profile, context, run and case ID. Any single
design's object export preserves the shared input object fields. Do not
multiply the shared docket denominator by joining all eight designs first.

Hashes use recursive record/list encoding in declaration/order sequence,
length-framed UTF-8 tokens and exact hexadecimal doubles. Ordered objects are
included in the docket hash and separately hashed. These are synthetic
simulation identities, not SCDB case identifiers.

Large case, object, shared-docket and segment exports are ignored in Git;
their hashes remain in the manifest and replication regenerates them.
Compressed run, composition and stream evidence and small settings/manifests
are retained for offline analysis.

## Measurement limits identified before the full run

`MetricsAccumulator` averages `CaseFile.timeToReview()` for
`averageTimeToReview`. This is a shared docket input, not a design-specific
procedural duration. Its paired contrasts must be exactly zero. Preserve
this benchmark definition and mark the registered delay component unsupported
by this measure. `institutionalDelayCost` is a different, synthetic cost-model
quantity; it may be separately described but cannot silently replace that
registered endpoint.

Existing rates retain their denominators. Emergency reason giving is
conditional on emergency orders; timely legislative response is conditional
on legislative responses. Existing zero-denominator rates return zero.
For response-off designs, zero timely-response rate or response delay means
no responses, not late or instantaneous responses. Keep denominators and flag
empty groups. Paired analysis uses equal-weight run-level contrasts, not
pooled case-weighted conditional rates.

Response-off sets credibility to zero before downstream evaluation and
prevents response events. Half response multiplies credibility by 0.5 and
separately retains otherwise-positive events with probability 0.5. This is
the registered compound intervention, not a guarantee that downstream metrics
will be halved.

## Execution and verification

`make historical-study` compiles the recorded source into a fresh temporary
directory, runs the full grid with bounded memory, checks pairing, settings,
denominators and streams, then promotes completed outputs. The manifest is
written last; interrupted promotion cannot pass its hash checks. Changing
source/configuration during execution causes failure.

`make historical-study-check` verifies retained outputs and provenance without
large raw exports. `make historical-study-raw-check` also checks all raw hashes.
Native tests run a small grid twice, compare every export byte, reconcile raw
counts, check all four sampling laws and compare exact base outcomes with the
legacy Simulator. That test grid does not replace the research sample.

Simulation is an intermediate checkpoint. Paired uncertainty, normative-weight
analysis, claim matrix, manuscript/supplement integration, full native CI,
rendered PDFs and extracted anonymous replication remain required for goal
completion.
