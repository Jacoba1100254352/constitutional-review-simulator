# Historical Benchmark and Robustness v1: institutional analysis

The registered simulation comprises 3,993,600 case outcomes under four historical forecast profiles,
thirteen contexts and eight base/ablated designs. These are modeled comparisons, not identified
effects of real constitutional reforms. Historical anchoring covers docket composition only.

## Main findings

- Emergency review: reasoned minus current emergency irregularity ranges from -0.8280 to -0.0456; total cost from 0.0095 to 0.0137. The shared review-time input cannot establish a procedural-duration tradeoff.
- Screening: council minus current direct cost is 0.1358 to 0.1375 and total cost 0.0828 to 0.0860. The upstream difference, 0.0004 to 0.0022, is below the practical threshold in every cell. Changing only the council structure changes upstream cost by -0.0001 to 0.0001. Thus this intervention does not substantiate a substantial upstream displacement effect.
- Weak-form response dependence is partial: turning replies off changes responsiveness by -0.0807 to -0.0189 and veto risk by 0.0241 to 0.0872. Yet the no-response variant retains a compliance difference of 0.1625 to 0.3842 and a cost difference of -0.0964 to -0.0861 relative to current. Response dependence does not account for all of its modeled advantages.

These numerical ranges describe the fixed model/grid, not reform recommendations. Direct rule effects,
constructed indices and downstream simulated outcomes require different evidentiary interpretations.

## Conditional-rate warning

At low emergency pressure, the reasoned design has no emergency order in 116 to 119 of 120 runs, depending on the forecast profile.
Those runs contribute zero to the registered mean of conditional run rates. The apparent reason-giving
reversal therefore mixes the incidence of an emergency order with reason-giving conditional on an order.
It does not establish less reason-giving per emergency order. The original contrast and classification
are retained; event-count and pooled-rate diagnostics explain the denominator without replacing the endpoint.

| Forecast | Design | Emergency orders | Orders with reasons | No-order runs | Pooled reasons per order |
| --- | --- | ---: | ---: | ---: | ---: |
| frozen-generator | current-federal-court | 583 | 13 | 0 | 0.0223 |
| frozen-generator | reasoned-emergency-review | 2 | 1 | 118 | 0.5000 |
| recency-weighted-15y | current-federal-court | 611 | 20 | 0 | 0.0327 |
| recency-weighted-15y | reasoned-emergency-review | 4 | 4 | 116 | 1.0000 |
| expanding-history | current-federal-court | 579 | 15 | 1 | 0.0259 |
| expanding-history | reasoned-emergency-review | 1 | 1 | 119 | 1.0000 |
| previous-term | current-federal-court | 591 | 20 | 0 | 0.0338 |
| previous-term | reasoned-emergency-review | 1 | 1 | 119 | 1.0000 |

Pooled rates are post-estimate measurement diagnostics, not substitute primary estimates; sparse
order counts do not support a reliable conditional-rate comparison by themselves.

## Claim-to-evidence matrix

Ranges below span the 52 fixed forecast/context cells. Classification uses the predeclared
+/-0.01 practical threshold on base-contrast point estimates. CI counts are separate, unadjusted
paired-run Monte Carlo intervals; they are not uncertainty about which real context is likely.

| Claim | Component | Difference range | Numerical pattern | CIs above / below zero | Evidence status |
| --- | --- | ---: | --- | ---: | --- |
| emergency | emergencyReasonGivingRate | -0.0255 to 0.8798 | sign-reversing | 48 / 1 | mechanism-and-conditional-denominator-dependent |
| emergency | meritsFollowUpRate | 0.0083 to 1.0000 | mixed/weak | 49 / 0 | mechanism-and-conditional-denominator-dependent |
| emergency | averageTimeToReview | 0.0000 to 0.0000 | mixed/weak | 0 / 0 | unsupported-design-duration-measure |
| emergency | totalInstitutionalCost | 0.0095 to 0.0137 | mixed/weak | 52 / 0 | modeled-downstream-or-accounting-output |
| emergency | shadowDocketAbuse | -0.8280 to -0.0456 | stable | 0 / 52 | modeled-downstream-or-accounting-output |
| emergency | institutionalDelayCost | 0.0029 to 0.0085 | descriptive-only | 52 / 0 | modeled-downstream-or-accounting-output |
| screening | directCourtCost | 0.1358 to 0.1375 | descriptive-only | 52 / 0 | modeled-downstream-or-accounting-output |
| screening | upstreamScreeningCost | 0.0004 to 0.0022 | mixed/weak | 52 / 0 | modeled-downstream-or-accounting-output |
| screening | capacityStrainCost | 0.0631 to 0.0793 | descriptive-only | 52 / 0 | modeled-downstream-or-accounting-output |
| screening | totalInstitutionalCost | 0.0828 to 0.0860 | descriptive-only | 52 / 0 | modeled-downstream-or-accounting-output |
| screening | intakeAcceptanceRate | -0.0008 to -0.0002 | descriptive-only | 0 / 52 | modeled-downstream-or-accounting-output |
| screening | councilScreenRate | 1.0000 to 1.0000 | stable | 52 / 0 | mechanism-dependent-model-output |
| screening | administrativeLoad | 0.2462 to 0.2683 | descriptive-only | 52 / 0 | modeled-downstream-or-accounting-output |
| weak-form | legislativeResponseRate | 0.1496 to 0.5448 | stable | 52 / 0 | mechanism-dependent-model-output |
| weak-form | legislativeResponseCredibility | 0.0443 to 0.0905 | stable | 52 / 0 | mechanism-dependent-model-output |
| weak-form | timelyLegislativeResponseRate | 0.0000 to 0.3279 | mixed/weak | 40 / 0 | conditional-response-populations-not-comparable |
| weak-form | rightsProtection | -0.0055 to 0.0598 | mixed/weak | 48 / 4 | modeled-downstream-or-accounting-output |
| weak-form | complianceRate | 0.1923 to 0.3909 | stable | 52 / 0 | modeled-downstream-or-accounting-output |
| weak-form | democraticResponsiveness | 0.0467 to 0.1088 | stable | 52 / 0 | modeled-downstream-or-accounting-output |
| weak-form | vetoRelocationRisk | -0.3813 to -0.2907 | stable | 0 / 52 | modeled-downstream-or-accounting-output |
| weak-form | totalInstitutionalCost | -0.0947 to -0.0844 | descriptive-only | 0 / 52 | modeled-downstream-or-accounting-output |
| weak-form | averageLegislativeResponseDelay | 0.3607 to 0.4895 | descriptive-only | 52 / 0 | conditional-response-populations-not-comparable |

`descriptive-only` means no signed superiority hypothesis was specified, not that the metric was omitted.
All per-cell estimates, endpoints and Monte Carlo standard errors are retained in the contrasts CSV.

## Mechanism dependence

These ablation ranges are changed mechanism minus its original parent. They do not have to
preserve the base claim. Half/off versus current are separately retained as persistence checks.

| Contrast | Component | Difference range | CIs above / below zero |
| --- | --- | ---: | ---: |
| emergency-ablation | emergencyReasonGivingRate | -0.7348 to 0.1774 | 4 / 48 |
| emergency-ablation | meritsFollowUpRate | -1.0000 to -0.0083 | 0 / 49 |
| emergency-ablation | averageTimeToReview | 0.0000 to 0.0000 | 0 / 0 |
| emergency-ablation | totalInstitutionalCost | -0.0083 to -0.0042 | 0 / 52 |
| emergency-ablation | shadowDocketAbuse | 0.0458 to 0.7970 | 52 / 0 |
| emergency-ablation | institutionalDelayCost | -0.0068 to -0.0013 | 0 / 52 |
| screening-ablation | directCourtCost | -0.0973 to -0.0971 | 0 / 52 |
| screening-ablation | upstreamScreeningCost | -0.0001 to 0.0001 | 1 / 1 |
| screening-ablation | capacityStrainCost | -0.0438 to -0.0425 | 0 / 52 |
| screening-ablation | totalInstitutionalCost | -0.0504 to -0.0501 | 0 / 52 |
| screening-ablation | intakeAcceptanceRate | -0.0000 to 0.0000 | 1 / 1 |
| screening-ablation | councilScreenRate | -1.0000 to -1.0000 | 0 / 52 |
| screening-ablation | administrativeLoad | -0.2410 to -0.2391 | 0 / 52 |
| weak-form-half | legislativeResponseRate | -0.2687 to -0.0744 | 0 / 52 |
| weak-form-half | legislativeResponseCredibility | -0.3258 to -0.2742 | 0 / 52 |
| weak-form-half | timelyLegislativeResponseRate | -0.3229 to 0.0000 | 0 / 40 |
| weak-form-half | rightsProtection | -0.0191 to 0.0014 | 2 / 48 |
| weak-form-half | complianceRate | -0.0697 to 0.0136 | 1 / 17 |
| weak-form-half | democraticResponsiveness | -0.0401 to -0.0098 | 0 / 52 |
| weak-form-half | vetoRelocationRisk | 0.0121 to 0.0433 | 52 / 0 |
| weak-form-half | totalInstitutionalCost | -0.0026 to -0.0006 | 0 / 52 |
| weak-form-half | averageLegislativeResponseDelay | 0.0708 to 0.0860 | 52 / 0 |
| weak-form-off | legislativeResponseRate | -0.5448 to -0.1496 | 0 / 52 |
| weak-form-off | legislativeResponseCredibility | -0.6521 to -0.5483 | 0 / 52 |
| weak-form-off | timelyLegislativeResponseRate | -0.3279 to 0.0000 | 0 / 40 |
| weak-form-off | rightsProtection | -0.0328 to 0.0036 | 4 / 48 |
| weak-form-off | complianceRate | -0.0952 to 0.0026 | 0 / 22 |
| weak-form-off | democraticResponsiveness | -0.0807 to -0.0189 | 0 / 52 |
| weak-form-off | vetoRelocationRisk | 0.0241 to 0.0872 | 52 / 0 |
| weak-form-off | totalInstitutionalCost | -0.0051 to -0.0014 | 0 / 52 |
| weak-form-off | averageLegislativeResponseDelay | -0.4895 to -0.3607 | 0 / 52 |

## Competing normative priorities

Each cell uses the same 1,000 registered Dirichlet preference vectors. Leadership shares below
are minimum to maximum across the fixed grid, not population probabilities or a welfare ranking.
Half/off competitions replace only weak-form review, leaving the same three competitors.

| Response setting | Design | Leadership share range |
| --- | --- | ---: |
| full-response | current-federal-court | 0.0% to 0.0% |
| full-response | reasoned-emergency-review | 0.0% to 63.9% |
| full-response | constitutional-council | 0.0% to 0.0% |
| full-response | weak-form-review | 36.1% to 100.0% |
| half-response | current-federal-court | 0.0% to 0.0% |
| half-response | reasoned-emergency-review | 0.0% to 70.1% |
| half-response | constitutional-council | 0.0% to 0.0% |
| half-response | weak-form-half-response | 29.9% to 100.0% |
| no-response | current-federal-court | 0.0% to 0.0% |
| no-response | reasoned-emergency-review | 0.0% to 76.8% |
| no-response | constitutional-council | 0.0% to 0.4% |
| no-response | weak-form-no-response | 23.2% to 99.8% |

152 of 312 base-design pair/cell comparisons reverse ordering across the sampled preferences.
Per-weight reversals across the context/profile grid are reported separately. Preference-percentile
ranges on response-score changes are not Monte Carlo confidence intervals.

## Accounting and measurement limits

Direct-only versus full cost accounting changes the practical sign in 0 of 52 cells.
This is an accounting-view change, not an institutional intervention. Both outputs are normalized
indices with different construction, so their gap is not a monetary omitted-cost amount.

- Average time to review is a shared docket input. All paired duration contrasts are zero; this measure cannot support a design-specific delay claim.
- Conditional rates retain their legacy zero-denominator convention. No legislative response is not an observed late or instantaneous response.
- Procedural activation and several score/cost terms are assigned by design. Stability of those outputs is not independent validation of the mechanism's substantive value.
- The empirical profile had no clear conditional advantage in the frozen 66-dispute 2025 docket test. That result is retained, not refitted using this study.
- The structural grid and illustrative preferences do not identify real-world causal effects, constitutional correctness or an institutionally optimal design.

## Reproduction and completion status

`make historical-analysis` recreates these tables from the source-hashed run exports;
`make historical-analysis-check` recomputes them and checks their saved bytes. The analysis contract
and manifest document estimands, seeds, inputs, code and output hashes. All calculations use the Python standard library.

This completes an analysis checkpoint, not the overall publication goal. Manuscript/supplement
integration, complete native CI, rendered PDFs and extracted anonymous replication still require verification.
