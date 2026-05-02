# Constitutional Review Paired Import Campaign v1

- runs per case: 120
- seed: 20260501
- input: 1190 imported legislative rows across 35 scenarios

## Top Directional Scores by Case

### Synthetic baseline

Synthetic docket using the same world assumptions as the imported comparisons.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.681
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.010
- lowest emergency relief rate: Retention-election accountability court at 0.319
- highest compliance rate: Hybrid court balancing independence and accountability at 0.420
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.274

### All imported legislative outputs

Docket generated from every imported legislative campaign row.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.819
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.803
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.755
- lowest defiance rate: Pre-enactment constitutional council at 0.056

### High-capture legislative outputs

Imported rows with high lobby-capture or proposer-gain signals.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.783
- strongest rights protection: Pre-enactment constitutional council at 0.796
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.722
- lowest defiance rate: Pre-enactment constitutional council at 0.072

### High-volatility legislative outputs

Imported rows with high policy-shift, reversal, or status-quo volatility signals.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.747
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.774
- lowest shadow-docket abuse: Dual supreme courts with cross-checking invalidations at 0.000
- lowest emergency relief rate: Dual supreme courts with cross-checking invalidations at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.575
- lowest defiance rate: Pre-enactment constitutional council at 0.154

### Low-mandate legislative outputs

Imported rows with weak public mandate, low support, or public-preference distortion.

- best overall: Dual supreme courts with cross-checking invalidations (`dual-cross-checking-courts`) at 0.764
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.764
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.605
- lowest defiance rate: Pre-enactment constitutional council at 0.123

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Intake | Emerg. relief | Reasons | Disagree | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin | Direct | Upstream | Capacity | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.616 | 0.878 | 0.740 | 0.172 | 0.174 | 0.020 | 0.479 | 0.014 | 0.502 | 0.294 | 0.639 | 0.200 | 0.281 | 0.516 | 0.435 | 0.350 | 0.204 | 0.059 | 0.222 | 2.453 | 0.575 | 0.446 | 0.303 | 0.680 | 0.405 | 0.444 |
| Staggered 18-year nonrenewable terms | 0.638 | 0.890 | 0.749 | 0.155 | 0.171 | 0.020 | 0.390 | 0.030 | 0.461 | 0.246 | 0.653 | 0.161 | 0.270 | 0.533 | 0.456 | 0.370 | 0.189 | 0.053 | 0.239 | 2.453 | 0.575 | 0.454 | 0.308 | 0.680 | 0.420 | 0.449 |
| Fifteen-justice supermajority commission court | 0.723 | 0.935 | 0.770 | 0.130 | 0.040 | 0.020 | 0.119 | 0.575 | 0.293 | 0.219 | 0.734 | 0.184 | 0.227 | 0.561 | 0.538 | 0.452 | 0.152 | 0.049 | 0.308 | 2.453 | 0.575 | 0.454 | 0.362 | 0.681 | 0.419 | 0.466 |
| Supermajority required to invalidate laws | 0.712 | 0.938 | 0.768 | 0.147 | 0.041 | 0.020 | 0.155 | 0.574 | 0.219 | 0.218 | 0.708 | 0.185 | 0.228 | 0.558 | 0.525 | 0.442 | 0.161 | 0.050 | 0.297 | 2.453 | 0.575 | 0.435 | 0.303 | 0.681 | 0.397 | 0.453 |
| Strict recusal with substitute justices | 0.737 | 0.936 | 0.771 | 0.129 | 0.039 | 0.020 | 0.115 | 0.655 | 0.209 | 0.208 | 0.756 | 0.175 | 0.224 | 0.563 | 0.559 | 0.475 | 0.144 | 0.045 | 0.322 | 2.453 | 0.575 | 0.455 | 0.361 | 0.681 | 0.419 | 0.472 |
| Reasoned emergency orders with merits follow-up | 0.737 | 0.932 | 0.768 | 0.144 | 0.002 | 0.020 | 0.103 | 0.812 | 0.095 | 0.262 | 0.759 | 0.262 | 0.228 | 0.549 | 0.535 | 0.452 | 0.163 | 0.053 | 0.295 | 2.453 | 0.575 | 0.444 | 0.308 | 0.681 | 0.410 | 0.457 |
| Panel review with en banc safety valve | 0.729 | 0.931 | 0.770 | 0.130 | 0.040 | 0.020 | 0.117 | 0.684 | 0.170 | 0.233 | 0.747 | 0.196 | 0.229 | 0.557 | 0.533 | 0.453 | 0.156 | 0.049 | 0.302 | 2.453 | 0.575 | 0.573 | 0.417 | 0.681 | 0.440 | 0.495 |
| Dual supreme courts with cross-checking invalidations | 0.746 | 0.952 | 0.776 | 0.119 | 0.003 | 0.020 | 0.081 | 0.685 | 0.037 | 0.168 | 0.775 | 0.168 | 0.225 | 0.572 | 0.580 | 0.494 | 0.133 | 0.042 | 0.339 | 2.453 | 0.575 | 0.841 | 0.516 | 0.682 | 0.566 | 0.586 |
| Pre-enactment constitutional council | 0.750 | 0.969 | 0.773 | 0.111 | 0.038 | 0.020 | 0.108 | 0.664 | 0.160 | 0.152 | 0.787 | 0.125 | 0.215 | 0.573 | 0.606 | 0.518 | 0.116 | 0.038 | 0.366 | 2.453 | 0.575 | 0.708 | 0.440 | 0.681 | 0.480 | 0.529 |
| Judicial review with delayed legislative override | 0.715 | 0.923 | 0.767 | 0.139 | 0.041 | 0.020 | 0.125 | 0.503 | 0.186 | 0.233 | 0.722 | 0.196 | 0.245 | 0.567 | 0.509 | 0.426 | 0.162 | 0.050 | 0.282 | 2.453 | 0.575 | 0.448 | 0.309 | 0.681 | 0.413 | 0.462 |
| Retention-election accountability court | 0.742 | 0.941 | 0.764 | 0.126 | 0.037 | 0.020 | 0.084 | 0.613 | 0.233 | 0.131 | 0.749 | 0.106 | 0.225 | 0.584 | 0.563 | 0.474 | 0.126 | 0.039 | 0.330 | 2.453 | 0.575 | 0.468 | 0.320 | 0.681 | 0.450 | 0.477 |
| Hybrid court balancing independence and accountability | 0.732 | 0.951 | 0.774 | 0.122 | 0.002 | 0.020 | 0.089 | 0.525 | 0.035 | 0.200 | 0.776 | 0.200 | 0.216 | 0.564 | 0.566 | 0.481 | 0.140 | 0.048 | 0.328 | 2.453 | 0.575 | 0.560 | 0.439 | 0.681 | 0.437 | 0.526 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 1.000 | 0.020 | 0.748 | 0.163 | 0.009 | 0.410 | 0.252 | 2.432 | 0.568 | 0.495 | 0.556 | 0.469 | 0.136 | 0.030 | 0.345 | 0.252 | 0.676 | 0.382 | 0.440 |
| Current-style federal supreme court | 2 | 12000 | 1.000 | 0.020 | 0.724 | 0.181 | 0.014 | 0.441 | 0.365 | 2.434 | 0.564 | 0.499 | 0.429 | 0.339 | 0.209 | 0.063 | 0.214 | 0.024 | 0.747 | 0.715 | 0.444 |
| Current-style federal supreme court | 3 | 12000 | 1.000 | 0.020 | 0.739 | 0.164 | 0.011 | 0.589 | 0.261 | 2.436 | 0.568 | 0.496 | 0.387 | 0.307 | 0.228 | 0.069 | 0.182 | 0.001 | 0.773 | 0.795 | 0.444 |
| Current-style federal supreme court | 4 | 12000 | 1.000 | 0.020 | 0.751 | 0.187 | 0.012 | 0.432 | 0.303 | 2.509 | 0.597 | 0.511 | 0.368 | 0.284 | 0.245 | 0.073 | 0.146 | 0.001 | 0.812 | 0.836 | 0.447 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 1.000 | 0.020 | 0.756 | 0.160 | 0.019 | 0.343 | 0.205 | 2.432 | 0.568 | 0.495 | 0.563 | 0.486 | 0.125 | 0.028 | 0.351 | 0.278 | 0.645 | 0.343 | 0.440 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 1.000 | 0.020 | 0.732 | 0.179 | 0.022 | 0.411 | 0.310 | 2.434 | 0.564 | 0.499 | 0.441 | 0.356 | 0.198 | 0.058 | 0.234 | 0.035 | 0.680 | 0.639 | 0.451 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 1.000 | 0.020 | 0.748 | 0.159 | 0.026 | 0.367 | 0.212 | 2.436 | 0.568 | 0.496 | 0.420 | 0.325 | 0.213 | 0.059 | 0.201 | 0.002 | 0.696 | 0.709 | 0.451 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 1.000 | 0.020 | 0.759 | 0.184 | 0.021 | 0.495 | 0.261 | 2.509 | 0.597 | 0.511 | 0.402 | 0.313 | 0.219 | 0.067 | 0.172 | 0.001 | 0.712 | 0.736 | 0.454 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 1.000 | 0.020 | 0.776 | 0.038 | 0.257 | 0.109 | 0.182 | 2.432 | 0.568 | 0.495 | 0.616 | 0.541 | 0.106 | 0.026 | 0.399 | 0.353 | 0.563 | 0.263 | 0.456 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 1.000 | 0.020 | 0.755 | 0.043 | 0.332 | 0.166 | 0.269 | 2.434 | 0.564 | 0.499 | 0.535 | 0.452 | 0.152 | 0.052 | 0.309 | 0.095 | 0.515 | 0.483 | 0.469 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 1.000 | 0.020 | 0.770 | 0.038 | 0.570 | 0.168 | 0.182 | 2.436 | 0.568 | 0.496 | 0.506 | 0.413 | 0.169 | 0.056 | 0.266 | 0.029 | 0.521 | 0.567 | 0.469 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 1.000 | 0.020 | 0.781 | 0.042 | 0.402 | 0.146 | 0.244 | 2.509 | 0.597 | 0.511 | 0.494 | 0.401 | 0.181 | 0.064 | 0.259 | 0.012 | 0.533 | 0.585 | 0.472 |
| Supermajority required to invalidate laws | 1 | 12000 | 1.000 | 0.020 | 0.774 | 0.040 | 0.225 | 0.097 | 0.182 | 2.432 | 0.568 | 0.495 | 0.614 | 0.538 | 0.105 | 0.025 | 0.392 | 0.335 | 0.576 | 0.278 | 0.449 |
| Supermajority required to invalidate laws | 2 | 12000 | 1.000 | 0.020 | 0.753 | 0.045 | 0.315 | 0.158 | 0.273 | 2.434 | 0.564 | 0.499 | 0.516 | 0.439 | 0.161 | 0.055 | 0.302 | 0.073 | 0.556 | 0.534 | 0.453 |
| Supermajority required to invalidate laws | 3 | 12000 | 1.000 | 0.020 | 0.767 | 0.039 | 0.612 | 0.131 | 0.181 | 2.436 | 0.568 | 0.496 | 0.489 | 0.402 | 0.181 | 0.057 | 0.260 | 0.014 | 0.579 | 0.623 | 0.453 |
| Supermajority required to invalidate laws | 4 | 12000 | 1.000 | 0.020 | 0.779 | 0.041 | 0.389 | 0.146 | 0.237 | 2.509 | 0.597 | 0.511 | 0.483 | 0.388 | 0.197 | 0.062 | 0.234 | 0.006 | 0.592 | 0.635 | 0.456 |
| Strict recusal with substitute justices | 1 | 12000 | 1.000 | 0.020 | 0.777 | 0.037 | 0.286 | 0.080 | 0.175 | 2.432 | 0.568 | 0.495 | 0.631 | 0.552 | 0.100 | 0.024 | 0.406 | 0.377 | 0.544 | 0.243 | 0.461 |
| Strict recusal with substitute justices | 2 | 12000 | 1.000 | 0.020 | 0.756 | 0.042 | 0.435 | 0.106 | 0.258 | 2.434 | 0.564 | 0.499 | 0.552 | 0.466 | 0.145 | 0.051 | 0.326 | 0.123 | 0.473 | 0.432 | 0.474 |
| Strict recusal with substitute justices | 3 | 12000 | 1.000 | 0.020 | 0.771 | 0.036 | 0.367 | 0.159 | 0.170 | 2.436 | 0.568 | 0.496 | 0.535 | 0.447 | 0.161 | 0.050 | 0.292 | 0.052 | 0.469 | 0.510 | 0.475 |
| Strict recusal with substitute justices | 4 | 12000 | 1.000 | 0.020 | 0.782 | 0.039 | 0.404 | 0.126 | 0.230 | 2.509 | 0.597 | 0.511 | 0.519 | 0.437 | 0.169 | 0.056 | 0.262 | 0.032 | 0.466 | 0.525 | 0.477 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 1.000 | 0.020 | 0.775 | 0.002 | 0.241 | 0.091 | 0.221 | 2.432 | 0.568 | 0.495 | 0.626 | 0.552 | 0.100 | 0.031 | 0.400 | 0.346 | 0.573 | 0.283 | 0.448 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 1.000 | 0.020 | 0.752 | 0.002 | 0.550 | 0.030 | 0.327 | 2.434 | 0.564 | 0.499 | 0.532 | 0.444 | 0.172 | 0.059 | 0.300 | 0.091 | 0.577 | 0.555 | 0.458 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 1.000 | 0.020 | 0.767 | 0.002 | 0.477 | 0.076 | 0.229 | 2.436 | 0.568 | 0.496 | 0.498 | 0.413 | 0.183 | 0.059 | 0.250 | 0.034 | 0.608 | 0.645 | 0.459 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 1.000 | 0.020 | 0.780 | 0.002 | 0.509 | 0.039 | 0.271 | 2.509 | 0.597 | 0.511 | 0.485 | 0.401 | 0.196 | 0.065 | 0.230 | 0.015 | 0.620 | 0.664 | 0.461 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.020 | 0.775 | 0.038 | 0.464 | 0.104 | 0.197 | 2.432 | 0.568 | 0.495 | 0.617 | 0.551 | 0.099 | 0.026 | 0.406 | 0.357 | 0.562 | 0.261 | 0.484 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.020 | 0.754 | 0.042 | 0.597 | 0.183 | 0.291 | 2.434 | 0.564 | 0.499 | 0.533 | 0.444 | 0.159 | 0.049 | 0.304 | 0.106 | 0.527 | 0.496 | 0.498 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.020 | 0.769 | 0.036 | 0.398 | 0.140 | 0.191 | 2.436 | 0.568 | 0.496 | 0.499 | 0.419 | 0.177 | 0.058 | 0.262 | 0.042 | 0.546 | 0.589 | 0.498 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.020 | 0.780 | 0.042 | 0.415 | 0.113 | 0.252 | 2.509 | 0.597 | 0.511 | 0.484 | 0.398 | 0.188 | 0.063 | 0.235 | 0.020 | 0.555 | 0.606 | 0.501 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.020 | 0.782 | 0.003 | 0.375 | 0.025 | 0.136 | 2.432 | 0.568 | 0.495 | 0.651 | 0.571 | 0.095 | 0.021 | 0.417 | 0.392 | 0.525 | 0.217 | 0.575 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.020 | 0.760 | 0.003 | 0.532 | 0.033 | 0.211 | 2.434 | 0.564 | 0.499 | 0.580 | 0.495 | 0.125 | 0.039 | 0.352 | 0.125 | 0.438 | 0.384 | 0.588 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.020 | 0.775 | 0.003 | 0.372 | 0.023 | 0.130 | 2.436 | 0.568 | 0.496 | 0.551 | 0.466 | 0.149 | 0.053 | 0.306 | 0.055 | 0.437 | 0.472 | 0.589 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.020 | 0.786 | 0.003 | 0.522 | 0.032 | 0.194 | 2.509 | 0.597 | 0.511 | 0.540 | 0.444 | 0.164 | 0.056 | 0.280 | 0.034 | 0.441 | 0.497 | 0.591 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.020 | 0.779 | 0.037 | 0.505 | 0.079 | 0.125 | 2.432 | 0.568 | 0.495 | 0.642 | 0.568 | 0.089 | 0.021 | 0.408 | 0.419 | 0.504 | 0.199 | 0.513 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.020 | 0.757 | 0.041 | 0.400 | 0.104 | 0.183 | 2.434 | 0.564 | 0.499 | 0.605 | 0.513 | 0.122 | 0.039 | 0.369 | 0.192 | 0.362 | 0.307 | 0.534 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.020 | 0.773 | 0.036 | 0.427 | 0.088 | 0.119 | 2.436 | 0.568 | 0.496 | 0.591 | 0.497 | 0.122 | 0.044 | 0.357 | 0.119 | 0.314 | 0.315 | 0.534 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.020 | 0.783 | 0.039 | 0.442 | 0.108 | 0.178 | 2.509 | 0.597 | 0.511 | 0.586 | 0.495 | 0.132 | 0.050 | 0.330 | 0.094 | 0.292 | 0.304 | 0.536 |
| Judicial review with delayed legislative override | 1 | 12000 | 1.000 | 0.020 | 0.774 | 0.039 | 0.430 | 0.101 | 0.193 | 2.432 | 0.568 | 0.495 | 0.604 | 0.530 | 0.106 | 0.027 | 0.389 | 0.318 | 0.586 | 0.279 | 0.453 |
| Judicial review with delayed legislative override | 2 | 12000 | 1.000 | 0.020 | 0.750 | 0.044 | 0.323 | 0.131 | 0.287 | 2.434 | 0.564 | 0.499 | 0.499 | 0.420 | 0.164 | 0.054 | 0.278 | 0.071 | 0.588 | 0.545 | 0.464 |
| Judicial review with delayed legislative override | 3 | 12000 | 1.000 | 0.020 | 0.766 | 0.038 | 0.318 | 0.120 | 0.202 | 2.436 | 0.568 | 0.496 | 0.473 | 0.383 | 0.184 | 0.055 | 0.246 | 0.016 | 0.617 | 0.638 | 0.464 |
| Judicial review with delayed legislative override | 4 | 12000 | 1.000 | 0.020 | 0.776 | 0.043 | 0.421 | 0.121 | 0.250 | 2.509 | 0.597 | 0.511 | 0.458 | 0.369 | 0.196 | 0.064 | 0.215 | 0.006 | 0.636 | 0.665 | 0.467 |
| Retention-election accountability court | 1 | 12000 | 1.000 | 0.020 | 0.772 | 0.035 | 0.444 | 0.109 | 0.112 | 2.432 | 0.568 | 0.495 | 0.616 | 0.545 | 0.090 | 0.021 | 0.403 | 0.384 | 0.520 | 0.204 | 0.456 |
| Retention-election accountability court | 2 | 12000 | 1.000 | 0.020 | 0.744 | 0.041 | 0.353 | 0.124 | 0.152 | 2.434 | 0.564 | 0.499 | 0.562 | 0.471 | 0.123 | 0.039 | 0.329 | 0.116 | 0.413 | 0.328 | 0.483 |
| Retention-election accountability court | 3 | 12000 | 1.000 | 0.020 | 0.767 | 0.035 | 0.425 | 0.181 | 0.108 | 2.436 | 0.568 | 0.496 | 0.545 | 0.448 | 0.138 | 0.047 | 0.312 | 0.036 | 0.373 | 0.362 | 0.484 |
| Retention-election accountability court | 4 | 12000 | 1.000 | 0.020 | 0.771 | 0.039 | 0.393 | 0.108 | 0.152 | 2.509 | 0.597 | 0.511 | 0.529 | 0.433 | 0.153 | 0.049 | 0.277 | 0.021 | 0.365 | 0.376 | 0.486 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.020 | 0.780 | 0.002 | 0.177 | 0.021 | 0.167 | 2.432 | 0.568 | 0.495 | 0.637 | 0.569 | 0.093 | 0.025 | 0.422 | 0.382 | 0.532 | 0.238 | 0.514 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.020 | 0.758 | 0.002 | 0.344 | 0.032 | 0.251 | 2.434 | 0.564 | 0.499 | 0.573 | 0.479 | 0.141 | 0.049 | 0.329 | 0.130 | 0.459 | 0.438 | 0.528 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.020 | 0.773 | 0.002 | 0.375 | 0.023 | 0.160 | 2.436 | 0.568 | 0.496 | 0.535 | 0.450 | 0.159 | 0.054 | 0.291 | 0.060 | 0.473 | 0.527 | 0.529 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.020 | 0.785 | 0.002 | 0.553 | 0.027 | 0.221 | 2.509 | 0.597 | 0.511 | 0.519 | 0.428 | 0.169 | 0.062 | 0.269 | 0.036 | 0.476 | 0.544 | 0.532 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 4664 | 1.000 | 0.019 | 0.825 | 0.187 | 0.007 | 0.336 | 0.027 | 2.691 | 0.465 | 0.501 | 0.448 | 0.363 | 0.262 | 0.047 | 0.261 | 0.078 | 0.773 | 0.705 | 0.452 |
| Current-style federal supreme court | criminal_procedure | 3125 | 1.000 | 0.020 | 0.722 | 0.298 | 0.015 | 0.348 | 0.281 | 2.353 | 0.574 | 0.494 | 0.413 | 0.320 | 0.216 | 0.055 | 0.196 | 0.093 | 0.789 | 0.700 | 0.444 |
| Current-style federal supreme court | election_law | 7433 | 1.000 | 0.021 | 0.743 | 0.140 | 0.006 | 0.269 | 0.234 | 2.566 | 0.674 | 0.517 | 0.427 | 0.342 | 0.194 | 0.059 | 0.189 | 0.080 | 0.759 | 0.698 | 0.448 |
| Current-style federal supreme court | emergency_powers | 4166 | 1.000 | 0.021 | 0.749 | 0.424 | 0.017 | 0.540 | 0.142 | 2.170 | 0.557 | 0.501 | 0.399 | 0.332 | 0.204 | 0.050 | 0.215 | 0.073 | 0.759 | 0.690 | 0.447 |
| Current-style federal supreme court | equality | 7618 | 1.000 | 0.021 | 0.700 | 0.162 | 0.014 | 0.541 | 0.612 | 2.445 | 0.583 | 0.501 | 0.415 | 0.331 | 0.225 | 0.069 | 0.198 | 0.058 | 0.765 | 0.687 | 0.442 |
| Current-style federal supreme court | federalism | 4096 | 1.000 | 0.021 | 0.823 | 0.206 | 0.010 | 0.273 | 0.046 | 2.730 | 0.806 | 0.591 | 0.418 | 0.341 | 0.198 | 0.057 | 0.157 | 0.084 | 0.770 | 0.692 | 0.459 |
| Current-style federal supreme court | speech | 16898 | 1.000 | 0.020 | 0.716 | 0.098 | 0.011 | 0.430 | 0.335 | 2.362 | 0.506 | 0.471 | 0.460 | 0.370 | 0.184 | 0.060 | 0.258 | 0.059 | 0.723 | 0.658 | 0.437 |
| Staggered 18-year nonrenewable terms | administrative_state | 4664 | 1.000 | 0.019 | 0.830 | 0.182 | 0.006 | 0.403 | 0.018 | 2.691 | 0.465 | 0.501 | 0.471 | 0.393 | 0.254 | 0.045 | 0.277 | 0.091 | 0.718 | 0.647 | 0.457 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 3125 | 1.000 | 0.020 | 0.727 | 0.293 | 0.027 | 0.322 | 0.262 | 2.353 | 0.574 | 0.494 | 0.425 | 0.351 | 0.204 | 0.046 | 0.212 | 0.100 | 0.743 | 0.648 | 0.449 |
| Staggered 18-year nonrenewable terms | election_law | 7433 | 1.000 | 0.021 | 0.756 | 0.139 | 0.020 | 0.228 | 0.168 | 2.566 | 0.674 | 0.517 | 0.436 | 0.376 | 0.176 | 0.051 | 0.207 | 0.092 | 0.684 | 0.623 | 0.453 |
| Staggered 18-year nonrenewable terms | emergency_powers | 4166 | 1.000 | 0.021 | 0.763 | 0.415 | 0.036 | 0.488 | 0.156 | 2.170 | 0.557 | 0.501 | 0.426 | 0.332 | 0.199 | 0.048 | 0.225 | 0.078 | 0.695 | 0.624 | 0.452 |
| Staggered 18-year nonrenewable terms | equality | 7618 | 1.000 | 0.021 | 0.708 | 0.161 | 0.021 | 0.408 | 0.545 | 2.445 | 0.583 | 0.501 | 0.436 | 0.343 | 0.207 | 0.067 | 0.214 | 0.068 | 0.701 | 0.615 | 0.447 |
| Staggered 18-year nonrenewable terms | federalism | 4096 | 1.000 | 0.021 | 0.830 | 0.198 | 0.015 | 0.270 | 0.033 | 2.730 | 0.806 | 0.591 | 0.455 | 0.360 | 0.187 | 0.044 | 0.163 | 0.093 | 0.718 | 0.638 | 0.464 |
| Staggered 18-year nonrenewable terms | speech | 16898 | 1.000 | 0.020 | 0.723 | 0.096 | 0.021 | 0.473 | 0.272 | 2.362 | 0.506 | 0.471 | 0.484 | 0.388 | 0.164 | 0.054 | 0.282 | 0.069 | 0.643 | 0.565 | 0.441 |
| Fifteen-justice supermajority commission court | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.048 | 0.260 | 0.077 | 0.006 | 2.691 | 0.465 | 0.501 | 0.536 | 0.460 | 0.212 | 0.040 | 0.338 | 0.133 | 0.581 | 0.535 | 0.474 |
| Fifteen-justice supermajority commission court | criminal_procedure | 3125 | 1.000 | 0.020 | 0.758 | 0.089 | 0.346 | 0.151 | 0.255 | 2.353 | 0.574 | 0.494 | 0.511 | 0.425 | 0.175 | 0.042 | 0.271 | 0.132 | 0.643 | 0.561 | 0.465 |
| Fifteen-justice supermajority commission court | election_law | 7433 | 1.000 | 0.021 | 0.783 | 0.029 | 0.270 | 0.058 | 0.139 | 2.566 | 0.674 | 0.517 | 0.522 | 0.452 | 0.140 | 0.055 | 0.281 | 0.133 | 0.520 | 0.478 | 0.470 |
| Fifteen-justice supermajority commission court | emergency_powers | 4166 | 1.000 | 0.021 | 0.797 | 0.111 | 0.609 | 0.287 | 0.138 | 2.170 | 0.557 | 0.501 | 0.537 | 0.441 | 0.157 | 0.049 | 0.306 | 0.114 | 0.553 | 0.499 | 0.468 |
| Fifteen-justice supermajority commission court | equality | 7618 | 1.000 | 0.020 | 0.734 | 0.036 | 0.289 | 0.139 | 0.501 | 2.445 | 0.583 | 0.501 | 0.511 | 0.425 | 0.165 | 0.058 | 0.286 | 0.112 | 0.552 | 0.491 | 0.464 |
| Fifteen-justice supermajority commission court | federalism | 4096 | 1.000 | 0.020 | 0.845 | 0.052 | 0.264 | 0.098 | 0.016 | 2.730 | 0.806 | 0.591 | 0.502 | 0.429 | 0.153 | 0.049 | 0.219 | 0.134 | 0.590 | 0.531 | 0.481 |
| Fifteen-justice supermajority commission court | speech | 16898 | 1.000 | 0.019 | 0.740 | 0.015 | 0.259 | 0.125 | 0.233 | 2.362 | 0.506 | 0.471 | 0.570 | 0.475 | 0.130 | 0.047 | 0.351 | 0.117 | 0.477 | 0.413 | 0.459 |
| Supermajority required to invalidate laws | administrative_state | 4664 | 1.000 | 0.019 | 0.837 | 0.049 | 0.254 | 0.113 | 0.008 | 2.691 | 0.465 | 0.501 | 0.540 | 0.443 | 0.224 | 0.038 | 0.335 | 0.119 | 0.621 | 0.573 | 0.461 |
| Supermajority required to invalidate laws | criminal_procedure | 3125 | 1.000 | 0.020 | 0.757 | 0.088 | 0.277 | 0.135 | 0.244 | 2.353 | 0.574 | 0.494 | 0.489 | 0.418 | 0.174 | 0.049 | 0.267 | 0.123 | 0.666 | 0.585 | 0.453 |
| Supermajority required to invalidate laws | election_law | 7433 | 1.000 | 0.021 | 0.778 | 0.031 | 0.218 | 0.160 | 0.153 | 2.566 | 0.674 | 0.517 | 0.515 | 0.439 | 0.149 | 0.050 | 0.257 | 0.120 | 0.570 | 0.527 | 0.457 |
| Supermajority required to invalidate laws | emergency_powers | 4166 | 1.000 | 0.021 | 0.792 | 0.117 | 0.602 | 0.230 | 0.134 | 2.170 | 0.557 | 0.501 | 0.521 | 0.434 | 0.168 | 0.053 | 0.296 | 0.098 | 0.586 | 0.537 | 0.455 |
| Supermajority required to invalidate laws | equality | 7618 | 1.000 | 0.020 | 0.733 | 0.036 | 0.297 | 0.103 | 0.493 | 2.445 | 0.583 | 0.501 | 0.501 | 0.422 | 0.168 | 0.057 | 0.277 | 0.096 | 0.594 | 0.530 | 0.451 |
| Supermajority required to invalidate laws | federalism | 4096 | 1.000 | 0.020 | 0.843 | 0.055 | 0.241 | 0.113 | 0.016 | 2.730 | 0.806 | 0.591 | 0.491 | 0.421 | 0.159 | 0.046 | 0.216 | 0.123 | 0.628 | 0.564 | 0.467 |
| Supermajority required to invalidate laws | speech | 16898 | 1.000 | 0.019 | 0.739 | 0.015 | 0.235 | 0.090 | 0.231 | 2.362 | 0.506 | 0.471 | 0.553 | 0.462 | 0.142 | 0.051 | 0.338 | 0.098 | 0.525 | 0.464 | 0.446 |
| Strict recusal with substitute justices | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.045 | 0.357 | 0.059 | 0.006 | 2.691 | 0.465 | 0.501 | 0.552 | 0.477 | 0.211 | 0.038 | 0.361 | 0.154 | 0.534 | 0.488 | 0.480 |
| Strict recusal with substitute justices | criminal_procedure | 3125 | 1.000 | 0.020 | 0.758 | 0.086 | 0.356 | 0.139 | 0.250 | 2.353 | 0.574 | 0.494 | 0.500 | 0.443 | 0.161 | 0.044 | 0.288 | 0.147 | 0.613 | 0.530 | 0.471 |
| Strict recusal with substitute justices | election_law | 7433 | 1.000 | 0.021 | 0.784 | 0.028 | 0.238 | 0.090 | 0.128 | 2.566 | 0.674 | 0.517 | 0.560 | 0.476 | 0.128 | 0.043 | 0.282 | 0.153 | 0.470 | 0.427 | 0.476 |
| Strict recusal with substitute justices | emergency_powers | 4166 | 1.000 | 0.021 | 0.797 | 0.108 | 0.664 | 0.218 | 0.129 | 2.170 | 0.557 | 0.501 | 0.572 | 0.474 | 0.147 | 0.041 | 0.313 | 0.134 | 0.521 | 0.464 | 0.474 |
| Strict recusal with substitute justices | equality | 7618 | 1.000 | 0.020 | 0.737 | 0.033 | 0.318 | 0.101 | 0.479 | 2.445 | 0.583 | 0.501 | 0.539 | 0.457 | 0.154 | 0.060 | 0.303 | 0.137 | 0.502 | 0.439 | 0.470 |
| Strict recusal with substitute justices | federalism | 4096 | 1.000 | 0.020 | 0.845 | 0.053 | 0.361 | 0.083 | 0.012 | 2.730 | 0.806 | 0.591 | 0.535 | 0.447 | 0.155 | 0.044 | 0.230 | 0.150 | 0.552 | 0.494 | 0.486 |
| Strict recusal with substitute justices | speech | 16898 | 1.000 | 0.019 | 0.741 | 0.014 | 0.204 | 0.110 | 0.219 | 2.362 | 0.506 | 0.471 | 0.584 | 0.496 | 0.120 | 0.043 | 0.367 | 0.147 | 0.430 | 0.362 | 0.465 |
| Reasoned emergency orders with merits follow-up | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.000 | 0.252 | 0.023 | 0.014 | 2.691 | 0.465 | 0.501 | 0.529 | 0.470 | 0.211 | 0.046 | 0.328 | 0.133 | 0.632 | 0.588 | 0.464 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 3125 | 1.000 | 0.020 | 0.768 | 0.004 | 0.400 | 0.055 | 0.286 | 2.353 | 0.574 | 0.494 | 0.520 | 0.441 | 0.172 | 0.058 | 0.277 | 0.135 | 0.673 | 0.598 | 0.456 |
| Reasoned emergency orders with merits follow-up | election_law | 7433 | 1.000 | 0.021 | 0.777 | 0.003 | 0.155 | 0.021 | 0.186 | 2.566 | 0.674 | 0.517 | 0.523 | 0.444 | 0.156 | 0.052 | 0.257 | 0.128 | 0.597 | 0.552 | 0.461 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 4166 | 1.000 | 0.020 | 0.798 | 0.009 | 0.826 | 0.116 | 0.127 | 2.170 | 0.557 | 0.501 | 0.535 | 0.446 | 0.160 | 0.043 | 0.311 | 0.117 | 0.596 | 0.551 | 0.458 |
| Reasoned emergency orders with merits follow-up | equality | 7618 | 1.000 | 0.020 | 0.733 | 0.002 | 0.148 | 0.020 | 0.573 | 2.445 | 0.583 | 0.501 | 0.517 | 0.427 | 0.175 | 0.065 | 0.274 | 0.110 | 0.616 | 0.551 | 0.455 |
| Reasoned emergency orders with merits follow-up | federalism | 4096 | 1.000 | 0.020 | 0.844 | 0.000 | 0.291 | 0.029 | 0.028 | 2.730 | 0.806 | 0.591 | 0.510 | 0.443 | 0.163 | 0.047 | 0.212 | 0.134 | 0.634 | 0.576 | 0.471 |
| Reasoned emergency orders with merits follow-up | speech | 16898 | 1.000 | 0.019 | 0.736 | 0.001 | 0.073 | 0.011 | 0.309 | 2.362 | 0.506 | 0.471 | 0.560 | 0.468 | 0.146 | 0.054 | 0.330 | 0.116 | 0.550 | 0.485 | 0.450 |
| Panel review with en banc safety valve | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.047 | 0.265 | 0.115 | 0.007 | 2.691 | 0.465 | 0.501 | 0.539 | 0.465 | 0.210 | 0.042 | 0.342 | 0.142 | 0.590 | 0.544 | 0.500 |
| Panel review with en banc safety valve | criminal_procedure | 3125 | 1.000 | 0.020 | 0.757 | 0.086 | 0.354 | 0.131 | 0.275 | 2.353 | 0.574 | 0.494 | 0.494 | 0.427 | 0.170 | 0.052 | 0.282 | 0.140 | 0.651 | 0.569 | 0.493 |
| Panel review with en banc safety valve | election_law | 7433 | 1.000 | 0.021 | 0.783 | 0.029 | 0.282 | 0.052 | 0.138 | 2.566 | 0.674 | 0.517 | 0.522 | 0.439 | 0.138 | 0.052 | 0.271 | 0.140 | 0.538 | 0.497 | 0.504 |
| Panel review with en banc safety valve | emergency_powers | 4166 | 1.000 | 0.021 | 0.797 | 0.111 | 0.697 | 0.191 | 0.138 | 2.170 | 0.557 | 0.501 | 0.525 | 0.440 | 0.161 | 0.041 | 0.312 | 0.123 | 0.564 | 0.510 | 0.502 |
| Panel review with en banc safety valve | equality | 7618 | 1.000 | 0.020 | 0.732 | 0.035 | 0.295 | 0.125 | 0.524 | 2.445 | 0.583 | 0.501 | 0.511 | 0.431 | 0.172 | 0.054 | 0.271 | 0.121 | 0.568 | 0.504 | 0.497 |
| Panel review with en banc safety valve | federalism | 4096 | 1.000 | 0.020 | 0.845 | 0.052 | 0.290 | 0.105 | 0.013 | 2.730 | 0.806 | 0.591 | 0.508 | 0.431 | 0.161 | 0.047 | 0.212 | 0.141 | 0.602 | 0.541 | 0.515 |
| Panel review with en banc safety valve | speech | 16898 | 1.000 | 0.019 | 0.739 | 0.015 | 0.246 | 0.122 | 0.257 | 2.362 | 0.506 | 0.471 | 0.562 | 0.479 | 0.136 | 0.049 | 0.341 | 0.128 | 0.494 | 0.428 | 0.484 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.001 | 0.259 | 0.016 | 0.002 | 2.691 | 0.465 | 0.501 | 0.577 | 0.497 | 0.190 | 0.033 | 0.370 | 0.160 | 0.502 | 0.455 | 0.593 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 3125 | 1.000 | 0.019 | 0.772 | 0.005 | 0.380 | 0.063 | 0.215 | 2.353 | 0.574 | 0.494 | 0.553 | 0.468 | 0.149 | 0.048 | 0.315 | 0.157 | 0.576 | 0.498 | 0.584 |
| Dual supreme courts with cross-checking invalidations | election_law | 7433 | 1.000 | 0.021 | 0.790 | 0.003 | 0.157 | 0.034 | 0.101 | 2.566 | 0.674 | 0.517 | 0.567 | 0.486 | 0.121 | 0.045 | 0.307 | 0.158 | 0.441 | 0.390 | 0.590 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 4166 | 1.000 | 0.020 | 0.800 | 0.012 | 0.720 | 0.062 | 0.067 | 2.170 | 0.557 | 0.501 | 0.582 | 0.493 | 0.145 | 0.037 | 0.344 | 0.143 | 0.489 | 0.429 | 0.587 |
| Dual supreme courts with cross-checking invalidations | equality | 7618 | 1.000 | 0.020 | 0.744 | 0.003 | 0.142 | 0.023 | 0.430 | 2.445 | 0.583 | 0.501 | 0.562 | 0.468 | 0.145 | 0.050 | 0.312 | 0.142 | 0.475 | 0.403 | 0.584 |
| Dual supreme courts with cross-checking invalidations | federalism | 4096 | 1.000 | 0.020 | 0.846 | 0.001 | 0.284 | 0.021 | 0.004 | 2.730 | 0.806 | 0.591 | 0.556 | 0.483 | 0.129 | 0.042 | 0.261 | 0.160 | 0.517 | 0.457 | 0.600 |
| Dual supreme courts with cross-checking invalidations | speech | 16898 | 1.000 | 0.019 | 0.744 | 0.001 | 0.073 | 0.011 | 0.180 | 2.362 | 0.506 | 0.471 | 0.606 | 0.516 | 0.112 | 0.040 | 0.378 | 0.150 | 0.408 | 0.327 | 0.579 |
| Pre-enactment constitutional council | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.046 | 0.338 | 0.059 | 0.001 | 2.691 | 0.465 | 0.501 | 0.605 | 0.532 | 0.167 | 0.030 | 0.406 | 0.201 | 0.417 | 0.342 | 0.537 |
| Pre-enactment constitutional council | criminal_procedure | 3125 | 1.000 | 0.020 | 0.760 | 0.084 | 0.396 | 0.141 | 0.193 | 2.353 | 0.574 | 0.494 | 0.534 | 0.476 | 0.140 | 0.038 | 0.313 | 0.186 | 0.530 | 0.431 | 0.528 |
| Pre-enactment constitutional council | election_law | 7433 | 1.000 | 0.021 | 0.787 | 0.027 | 0.204 | 0.050 | 0.091 | 2.566 | 0.674 | 0.517 | 0.601 | 0.521 | 0.103 | 0.041 | 0.346 | 0.204 | 0.334 | 0.255 | 0.533 |
| Pre-enactment constitutional council | emergency_powers | 4166 | 1.000 | 0.021 | 0.797 | 0.104 | 0.689 | 0.180 | 0.070 | 2.170 | 0.557 | 0.501 | 0.582 | 0.492 | 0.127 | 0.038 | 0.357 | 0.190 | 0.439 | 0.359 | 0.531 |
| Pre-enactment constitutional council | equality | 7618 | 1.000 | 0.020 | 0.741 | 0.034 | 0.340 | 0.080 | 0.394 | 2.445 | 0.583 | 0.501 | 0.588 | 0.495 | 0.130 | 0.050 | 0.336 | 0.200 | 0.369 | 0.279 | 0.527 |
| Pre-enactment constitutional council | federalism | 4096 | 1.000 | 0.020 | 0.846 | 0.051 | 0.362 | 0.088 | 0.004 | 2.730 | 0.806 | 0.591 | 0.558 | 0.495 | 0.125 | 0.040 | 0.268 | 0.195 | 0.447 | 0.362 | 0.543 |
| Pre-enactment constitutional council | speech | 16898 | 1.000 | 0.019 | 0.741 | 0.015 | 0.269 | 0.096 | 0.144 | 2.362 | 0.506 | 0.471 | 0.647 | 0.543 | 0.093 | 0.034 | 0.413 | 0.222 | 0.302 | 0.210 | 0.522 |
| Judicial review with delayed legislative override | administrative_state | 4664 | 1.000 | 0.019 | 0.837 | 0.049 | 0.303 | 0.062 | 0.013 | 2.691 | 0.465 | 0.501 | 0.521 | 0.437 | 0.220 | 0.041 | 0.331 | 0.116 | 0.645 | 0.585 | 0.470 |
| Judicial review with delayed legislative override | criminal_procedure | 3125 | 1.000 | 0.020 | 0.755 | 0.092 | 0.350 | 0.148 | 0.266 | 2.353 | 0.574 | 0.494 | 0.484 | 0.413 | 0.182 | 0.048 | 0.253 | 0.121 | 0.688 | 0.597 | 0.461 |
| Judicial review with delayed legislative override | election_law | 7433 | 1.000 | 0.021 | 0.780 | 0.029 | 0.226 | 0.111 | 0.154 | 2.566 | 0.674 | 0.517 | 0.501 | 0.421 | 0.152 | 0.054 | 0.248 | 0.114 | 0.608 | 0.550 | 0.466 |
| Judicial review with delayed legislative override | emergency_powers | 4166 | 1.000 | 0.021 | 0.795 | 0.114 | 0.554 | 0.210 | 0.147 | 2.170 | 0.557 | 0.501 | 0.503 | 0.433 | 0.159 | 0.051 | 0.288 | 0.098 | 0.609 | 0.546 | 0.464 |
| Judicial review with delayed legislative override | equality | 7618 | 1.000 | 0.020 | 0.728 | 0.035 | 0.321 | 0.079 | 0.512 | 2.445 | 0.583 | 0.501 | 0.480 | 0.393 | 0.178 | 0.060 | 0.258 | 0.091 | 0.628 | 0.544 | 0.460 |
| Judicial review with delayed legislative override | federalism | 4096 | 1.000 | 0.020 | 0.843 | 0.055 | 0.287 | 0.085 | 0.022 | 2.730 | 0.806 | 0.591 | 0.489 | 0.418 | 0.163 | 0.050 | 0.196 | 0.118 | 0.652 | 0.579 | 0.476 |
| Judicial review with delayed legislative override | speech | 16898 | 1.000 | 0.019 | 0.735 | 0.016 | 0.244 | 0.098 | 0.252 | 2.362 | 0.506 | 0.471 | 0.532 | 0.442 | 0.141 | 0.047 | 0.319 | 0.094 | 0.559 | 0.476 | 0.455 |
| Retention-election accountability court | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.046 | 0.286 | 0.055 | 0.003 | 2.691 | 0.465 | 0.501 | 0.566 | 0.484 | 0.194 | 0.036 | 0.364 | 0.153 | 0.466 | 0.383 | 0.485 |
| Retention-election accountability court | criminal_procedure | 3125 | 1.000 | 0.020 | 0.757 | 0.083 | 0.363 | 0.130 | 0.184 | 2.353 | 0.574 | 0.494 | 0.523 | 0.435 | 0.147 | 0.045 | 0.293 | 0.141 | 0.560 | 0.454 | 0.476 |
| Retention-election accountability court | election_law | 7433 | 1.000 | 0.021 | 0.787 | 0.026 | 0.276 | 0.053 | 0.086 | 2.566 | 0.674 | 0.517 | 0.574 | 0.484 | 0.109 | 0.038 | 0.302 | 0.153 | 0.380 | 0.291 | 0.482 |
| Retention-election accountability court | emergency_powers | 4166 | 1.000 | 0.021 | 0.798 | 0.104 | 0.631 | 0.222 | 0.062 | 2.170 | 0.557 | 0.501 | 0.539 | 0.460 | 0.134 | 0.040 | 0.324 | 0.124 | 0.469 | 0.379 | 0.480 |
| Retention-election accountability court | equality | 7618 | 1.000 | 0.020 | 0.707 | 0.031 | 0.298 | 0.132 | 0.354 | 2.445 | 0.583 | 0.501 | 0.523 | 0.444 | 0.139 | 0.046 | 0.304 | 0.129 | 0.429 | 0.323 | 0.475 |
| Retention-election accountability court | federalism | 4096 | 1.000 | 0.020 | 0.846 | 0.050 | 0.292 | 0.066 | 0.006 | 2.730 | 0.806 | 0.591 | 0.543 | 0.442 | 0.139 | 0.042 | 0.233 | 0.150 | 0.488 | 0.393 | 0.491 |
| Retention-election accountability court | speech | 16898 | 1.000 | 0.019 | 0.731 | 0.014 | 0.241 | 0.123 | 0.111 | 2.362 | 0.506 | 0.471 | 0.593 | 0.499 | 0.100 | 0.035 | 0.377 | 0.135 | 0.361 | 0.250 | 0.471 |
| Hybrid court balancing independence and accountability | administrative_state | 4664 | 1.000 | 0.019 | 0.838 | 0.000 | 0.259 | 0.014 | 0.003 | 2.691 | 0.465 | 0.501 | 0.552 | 0.485 | 0.196 | 0.043 | 0.350 | 0.159 | 0.528 | 0.499 | 0.532 |
| Hybrid court balancing independence and accountability | criminal_procedure | 3125 | 1.000 | 0.020 | 0.772 | 0.003 | 0.415 | 0.049 | 0.236 | 2.353 | 0.574 | 0.494 | 0.539 | 0.464 | 0.157 | 0.044 | 0.302 | 0.156 | 0.599 | 0.536 | 0.524 |
| Hybrid court balancing independence and accountability | election_law | 7433 | 1.000 | 0.021 | 0.789 | 0.002 | 0.161 | 0.023 | 0.107 | 2.566 | 0.674 | 0.517 | 0.571 | 0.475 | 0.124 | 0.048 | 0.297 | 0.157 | 0.470 | 0.439 | 0.536 |
| Hybrid court balancing independence and accountability | emergency_powers | 4166 | 1.000 | 0.020 | 0.799 | 0.008 | 0.617 | 0.068 | 0.075 | 2.170 | 0.557 | 0.501 | 0.554 | 0.486 | 0.142 | 0.043 | 0.341 | 0.143 | 0.506 | 0.464 | 0.534 |
| Hybrid court balancing independence and accountability | equality | 7618 | 1.000 | 0.020 | 0.740 | 0.002 | 0.147 | 0.018 | 0.490 | 2.445 | 0.583 | 0.501 | 0.544 | 0.456 | 0.155 | 0.062 | 0.298 | 0.143 | 0.502 | 0.450 | 0.526 |
| Hybrid court balancing independence and accountability | federalism | 4096 | 1.000 | 0.020 | 0.846 | 0.000 | 0.292 | 0.019 | 0.007 | 2.730 | 0.806 | 0.591 | 0.535 | 0.458 | 0.153 | 0.041 | 0.244 | 0.157 | 0.538 | 0.495 | 0.547 |
| Hybrid court balancing independence and accountability | speech | 16898 | 1.000 | 0.019 | 0.741 | 0.001 | 0.203 | 0.010 | 0.235 | 2.362 | 0.506 | 0.471 | 0.592 | 0.503 | 0.119 | 0.045 | 0.370 | 0.152 | 0.434 | 0.374 | 0.513 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.777 | 0.173 | 0.009 | 0.347 | 0.119 | 3.000 | 0.391 | 0.470 | 0.466 | 0.370 | 0.218 | 0.046 | 0.304 | 0.079 | 0.747 | 0.679 | 0.452 |
| Current-style federal supreme court | federal/circuit_panel | 9711 | 1.000 | 0.019 | 0.753 | 0.169 | 0.010 | 0.516 | 0.147 | 2.000 | 0.400 | 0.430 | 0.466 | 0.380 | 0.192 | 0.056 | 0.321 | 0.076 | 0.726 | 0.659 | 0.433 |
| Current-style federal supreme court | federal/district_only | 2381 | 1.000 | 0.018 | 0.745 | 0.204 | 0.011 | 0.501 | 0.144 | 1.000 | 0.408 | 0.406 | 0.472 | 0.397 | 0.179 | 0.037 | 0.306 | 0.074 | 0.731 | 0.665 | 0.415 |
| Current-style federal supreme court | federal/state_federal_split | 188 | 1.000 | 0.023 | 0.670 | 0.592 | 0.014 | 0.619 | 0.306 | 3.000 | 0.565 | 0.562 | 0.293 | 0.213 | 0.239 | 0.059 | 0.138 | 0.017 | 0.973 | 0.915 | 0.473 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.736 | 0.164 | 0.031 | 0.566 | 0.397 | 3.000 | 0.765 | 0.558 | 0.397 | 0.323 | 0.204 | 0.063 | 0.151 | 0.061 | 0.763 | 0.692 | 0.455 |
| Current-style federal supreme court | mixed_state_federal/district_only | 265 | 1.000 | 0.022 | 0.700 | 0.654 | 0.016 | 0.506 | 0.120 | 1.000 | 0.760 | 0.525 | 0.291 | 0.208 | 0.287 | 0.075 | 0.094 | 0.004 | 0.843 | 0.833 | 0.432 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.022 | 0.724 | 0.154 | 0.012 | 0.493 | 0.478 | 3.000 | 0.768 | 0.579 | 0.405 | 0.320 | 0.222 | 0.070 | 0.145 | 0.063 | 0.766 | 0.691 | 0.457 |
| Current-style federal supreme court | state/circuit_en_banc | 86 | 1.000 | 0.022 | 0.726 | 0.573 | 0.015 | 0.515 | 0.000 | 3.000 | 0.501 | 0.542 | 0.291 | 0.244 | 0.430 | 0.012 | 0.093 | 0.008 | 0.977 | 0.924 | 0.473 |
| Current-style federal supreme court | state/circuit_panel | 2833 | 1.000 | 0.020 | 0.749 | 0.169 | 0.006 | 0.539 | 0.233 | 2.000 | 0.564 | 0.473 | 0.443 | 0.355 | 0.195 | 0.055 | 0.222 | 0.072 | 0.751 | 0.680 | 0.435 |
| Current-style federal supreme court | state/district_only | 204 | 1.000 | 0.022 | 0.723 | 0.626 | 0.027 | 0.534 | 0.166 | 1.000 | 0.553 | 0.477 | 0.338 | 0.265 | 0.235 | 0.044 | 0.132 | 0.020 | 0.843 | 0.801 | 0.429 |
| Current-style federal supreme court | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.722 | 0.204 | 0.014 | 0.579 | 0.355 | 3.000 | 0.576 | 0.527 | 0.419 | 0.333 | 0.211 | 0.058 | 0.191 | 0.063 | 0.765 | 0.697 | 0.456 |
| Current-style federal supreme court | state/state_high_court | 8025 | 1.000 | 0.020 | 0.743 | 0.144 | 0.010 | 0.493 | 0.282 | 2.000 | 0.556 | 0.480 | 0.452 | 0.364 | 0.190 | 0.059 | 0.210 | 0.077 | 0.744 | 0.672 | 0.435 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.782 | 0.169 | 0.017 | 0.237 | 0.098 | 3.000 | 0.391 | 0.470 | 0.478 | 0.392 | 0.206 | 0.043 | 0.324 | 0.089 | 0.683 | 0.608 | 0.457 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 9711 | 1.000 | 0.019 | 0.760 | 0.163 | 0.018 | 0.362 | 0.115 | 2.000 | 0.400 | 0.430 | 0.492 | 0.399 | 0.179 | 0.044 | 0.343 | 0.086 | 0.657 | 0.581 | 0.437 |
| Staggered 18-year nonrenewable terms | federal/district_only | 2381 | 1.000 | 0.019 | 0.748 | 0.212 | 0.023 | 0.279 | 0.145 | 1.000 | 0.408 | 0.406 | 0.484 | 0.385 | 0.168 | 0.050 | 0.337 | 0.085 | 0.660 | 0.583 | 0.420 |
| Staggered 18-year nonrenewable terms | federal/state_federal_split | 188 | 1.000 | 0.023 | 0.684 | 0.604 | 0.028 | 0.579 | 0.256 | 3.000 | 0.565 | 0.562 | 0.293 | 0.218 | 0.282 | 0.053 | 0.154 | 0.016 | 0.974 | 0.914 | 0.479 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.747 | 0.165 | 0.013 | 0.463 | 0.318 | 3.000 | 0.765 | 0.558 | 0.422 | 0.346 | 0.201 | 0.060 | 0.160 | 0.071 | 0.697 | 0.622 | 0.460 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/district_only | 265 | 1.000 | 0.022 | 0.730 | 0.609 | 0.025 | 0.451 | 0.240 | 1.000 | 0.760 | 0.525 | 0.325 | 0.260 | 0.204 | 0.060 | 0.087 | 0.004 | 0.773 | 0.764 | 0.438 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.022 | 0.735 | 0.152 | 0.047 | 0.499 | 0.412 | 3.000 | 0.768 | 0.579 | 0.428 | 0.343 | 0.197 | 0.061 | 0.160 | 0.073 | 0.697 | 0.618 | 0.462 |
| Staggered 18-year nonrenewable terms | state/circuit_en_banc | 86 | 1.000 | 0.022 | 0.751 | 0.525 | 0.016 | 0.500 | 0.000 | 3.000 | 0.501 | 0.542 | 0.326 | 0.233 | 0.291 | 0.058 | 0.128 | 0.011 | 0.974 | 0.920 | 0.477 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 2833 | 1.000 | 0.020 | 0.755 | 0.161 | 0.031 | 0.482 | 0.204 | 2.000 | 0.564 | 0.473 | 0.466 | 0.384 | 0.174 | 0.054 | 0.216 | 0.083 | 0.681 | 0.603 | 0.439 |
| Staggered 18-year nonrenewable terms | state/district_only | 204 | 1.000 | 0.022 | 0.728 | 0.643 | 0.016 | 0.519 | 0.237 | 1.000 | 0.553 | 0.477 | 0.407 | 0.260 | 0.225 | 0.034 | 0.147 | 0.020 | 0.781 | 0.742 | 0.435 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.736 | 0.200 | 0.041 | 0.491 | 0.289 | 3.000 | 0.576 | 0.527 | 0.443 | 0.357 | 0.195 | 0.059 | 0.215 | 0.074 | 0.697 | 0.623 | 0.460 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 8025 | 1.000 | 0.020 | 0.749 | 0.141 | 0.018 | 0.423 | 0.230 | 2.000 | 0.556 | 0.480 | 0.468 | 0.384 | 0.177 | 0.051 | 0.230 | 0.087 | 0.672 | 0.593 | 0.439 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.796 | 0.044 | 0.408 | 0.130 | 0.083 | 3.000 | 0.391 | 0.470 | 0.561 | 0.480 | 0.171 | 0.041 | 0.392 | 0.135 | 0.536 | 0.479 | 0.475 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.774 | 0.040 | 0.400 | 0.113 | 0.103 | 2.000 | 0.400 | 0.430 | 0.564 | 0.479 | 0.137 | 0.041 | 0.411 | 0.132 | 0.513 | 0.451 | 0.455 |
| Fifteen-justice supermajority commission court | federal/district_only | 2381 | 1.000 | 0.018 | 0.765 | 0.057 | 0.390 | 0.090 | 0.120 | 1.000 | 0.408 | 0.406 | 0.563 | 0.487 | 0.127 | 0.040 | 0.405 | 0.132 | 0.514 | 0.447 | 0.437 |
| Fifteen-justice supermajority commission court | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.752 | 0.152 | 0.663 | 0.238 | 0.320 | 3.000 | 0.565 | 0.562 | 0.420 | 0.303 | 0.223 | 0.059 | 0.223 | 0.030 | 0.931 | 0.879 | 0.493 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.770 | 0.035 | 0.440 | 0.136 | 0.293 | 3.000 | 0.765 | 0.558 | 0.523 | 0.429 | 0.164 | 0.057 | 0.227 | 0.112 | 0.537 | 0.483 | 0.478 |
| Fifteen-justice supermajority commission court | mixed_state_federal/district_only | 265 | 1.000 | 0.022 | 0.771 | 0.185 | 0.621 | 0.167 | 0.256 | 1.000 | 0.760 | 0.525 | 0.426 | 0.343 | 0.211 | 0.098 | 0.155 | 0.025 | 0.620 | 0.618 | 0.454 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.764 | 0.032 | 0.665 | 0.377 | 0.366 | 3.000 | 0.768 | 0.579 | 0.506 | 0.425 | 0.162 | 0.057 | 0.228 | 0.116 | 0.539 | 0.483 | 0.479 |
| Fifteen-justice supermajority commission court | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.768 | 0.170 | 0.725 | 0.125 | 0.022 | 3.000 | 0.501 | 0.542 | 0.430 | 0.395 | 0.349 | 0.058 | 0.186 | 0.026 | 0.934 | 0.890 | 0.493 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.771 | 0.039 | 0.484 | 0.115 | 0.177 | 2.000 | 0.564 | 0.473 | 0.544 | 0.454 | 0.143 | 0.047 | 0.292 | 0.122 | 0.536 | 0.479 | 0.457 |
| Fifteen-justice supermajority commission court | state/district_only | 204 | 1.000 | 0.021 | 0.769 | 0.184 | 0.604 | 0.301 | 0.159 | 1.000 | 0.553 | 0.477 | 0.539 | 0.397 | 0.196 | 0.039 | 0.216 | 0.048 | 0.647 | 0.620 | 0.451 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.765 | 0.046 | 0.427 | 0.440 | 0.253 | 3.000 | 0.576 | 0.527 | 0.525 | 0.439 | 0.156 | 0.055 | 0.291 | 0.114 | 0.552 | 0.495 | 0.478 |
| Fifteen-justice supermajority commission court | state/state_high_court | 8025 | 1.000 | 0.020 | 0.766 | 0.031 | 0.459 | 0.202 | 0.206 | 2.000 | 0.556 | 0.480 | 0.551 | 0.459 | 0.143 | 0.047 | 0.295 | 0.130 | 0.519 | 0.457 | 0.457 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.795 | 0.044 | 0.447 | 0.091 | 0.082 | 3.000 | 0.391 | 0.470 | 0.548 | 0.469 | 0.176 | 0.042 | 0.393 | 0.119 | 0.579 | 0.522 | 0.461 |
| Supermajority required to invalidate laws | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.773 | 0.041 | 0.352 | 0.122 | 0.093 | 2.000 | 0.400 | 0.430 | 0.562 | 0.472 | 0.144 | 0.042 | 0.401 | 0.116 | 0.550 | 0.490 | 0.442 |
| Supermajority required to invalidate laws | federal/district_only | 2381 | 1.000 | 0.018 | 0.764 | 0.058 | 0.341 | 0.124 | 0.108 | 1.000 | 0.408 | 0.406 | 0.561 | 0.465 | 0.137 | 0.039 | 0.394 | 0.112 | 0.549 | 0.487 | 0.424 |
| Supermajority required to invalidate laws | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.749 | 0.165 | 0.602 | 0.313 | 0.314 | 3.000 | 0.565 | 0.562 | 0.351 | 0.340 | 0.271 | 0.037 | 0.223 | 0.029 | 0.927 | 0.871 | 0.480 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.768 | 0.035 | 0.358 | 0.138 | 0.293 | 3.000 | 0.765 | 0.558 | 0.488 | 0.405 | 0.178 | 0.057 | 0.221 | 0.096 | 0.589 | 0.535 | 0.464 |
| Supermajority required to invalidate laws | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.767 | 0.179 | 0.544 | 0.240 | 0.213 | 1.000 | 0.760 | 0.525 | 0.498 | 0.396 | 0.223 | 0.060 | 0.170 | 0.014 | 0.655 | 0.669 | 0.439 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.761 | 0.034 | 0.533 | 0.280 | 0.370 | 3.000 | 0.768 | 0.579 | 0.494 | 0.413 | 0.176 | 0.061 | 0.209 | 0.100 | 0.587 | 0.529 | 0.466 |
| Supermajority required to invalidate laws | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.766 | 0.156 | 0.556 | 0.250 | 0.040 | 3.000 | 0.501 | 0.542 | 0.407 | 0.291 | 0.279 | 0.047 | 0.151 | 0.026 | 0.931 | 0.886 | 0.478 |
| Supermajority required to invalidate laws | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.769 | 0.041 | 0.622 | 0.090 | 0.180 | 2.000 | 0.564 | 0.473 | 0.540 | 0.454 | 0.149 | 0.037 | 0.280 | 0.110 | 0.575 | 0.516 | 0.444 |
| Supermajority required to invalidate laws | state/district_only | 204 | 1.000 | 0.021 | 0.762 | 0.199 | 0.668 | 0.266 | 0.154 | 1.000 | 0.553 | 0.477 | 0.500 | 0.387 | 0.201 | 0.064 | 0.137 | 0.037 | 0.683 | 0.664 | 0.437 |
| Supermajority required to invalidate laws | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.762 | 0.049 | 0.628 | 0.183 | 0.262 | 3.000 | 0.576 | 0.527 | 0.505 | 0.431 | 0.167 | 0.054 | 0.269 | 0.099 | 0.592 | 0.537 | 0.464 |
| Supermajority required to invalidate laws | state/state_high_court | 8025 | 1.000 | 0.020 | 0.765 | 0.032 | 0.336 | 0.159 | 0.206 | 2.000 | 0.556 | 0.480 | 0.537 | 0.453 | 0.144 | 0.050 | 0.291 | 0.117 | 0.562 | 0.500 | 0.444 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.796 | 0.040 | 0.424 | 0.079 | 0.086 | 3.000 | 0.391 | 0.470 | 0.572 | 0.487 | 0.157 | 0.038 | 0.418 | 0.156 | 0.494 | 0.436 | 0.480 |
| Strict recusal with substitute justices | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.775 | 0.038 | 0.396 | 0.078 | 0.093 | 2.000 | 0.400 | 0.430 | 0.591 | 0.506 | 0.133 | 0.034 | 0.422 | 0.160 | 0.470 | 0.406 | 0.460 |
| Strict recusal with substitute justices | federal/district_only | 2381 | 1.000 | 0.018 | 0.765 | 0.056 | 0.407 | 0.119 | 0.119 | 1.000 | 0.408 | 0.406 | 0.576 | 0.495 | 0.126 | 0.037 | 0.423 | 0.153 | 0.476 | 0.402 | 0.443 |
| Strict recusal with substitute justices | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.746 | 0.172 | 0.716 | 0.227 | 0.296 | 3.000 | 0.565 | 0.562 | 0.420 | 0.372 | 0.213 | 0.053 | 0.181 | 0.033 | 0.924 | 0.870 | 0.499 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.771 | 0.034 | 0.640 | 0.114 | 0.273 | 3.000 | 0.765 | 0.558 | 0.544 | 0.463 | 0.150 | 0.056 | 0.243 | 0.136 | 0.491 | 0.435 | 0.483 |
| Strict recusal with substitute justices | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.771 | 0.176 | 0.679 | 0.244 | 0.211 | 1.000 | 0.760 | 0.525 | 0.509 | 0.408 | 0.192 | 0.057 | 0.177 | 0.045 | 0.596 | 0.587 | 0.459 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.766 | 0.031 | 0.591 | 0.117 | 0.346 | 3.000 | 0.768 | 0.579 | 0.529 | 0.448 | 0.158 | 0.053 | 0.233 | 0.136 | 0.490 | 0.433 | 0.485 |
| Strict recusal with substitute justices | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.765 | 0.181 | 0.614 | 0.136 | 0.000 | 3.000 | 0.501 | 0.542 | 0.337 | 0.326 | 0.326 | 0.023 | 0.163 | 0.029 | 0.927 | 0.883 | 0.499 |
| Strict recusal with substitute justices | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.771 | 0.037 | 0.621 | 0.087 | 0.176 | 2.000 | 0.564 | 0.473 | 0.562 | 0.484 | 0.131 | 0.048 | 0.322 | 0.150 | 0.487 | 0.426 | 0.462 |
| Strict recusal with substitute justices | state/district_only | 204 | 1.000 | 0.021 | 0.769 | 0.186 | 0.643 | 0.244 | 0.156 | 1.000 | 0.553 | 0.477 | 0.539 | 0.431 | 0.196 | 0.029 | 0.260 | 0.074 | 0.618 | 0.579 | 0.456 |
| Strict recusal with substitute justices | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.766 | 0.045 | 0.610 | 0.334 | 0.244 | 3.000 | 0.576 | 0.527 | 0.557 | 0.459 | 0.143 | 0.049 | 0.290 | 0.137 | 0.509 | 0.451 | 0.483 |
| Strict recusal with substitute justices | state/state_high_court | 8025 | 1.000 | 0.020 | 0.767 | 0.029 | 0.334 | 0.201 | 0.197 | 2.000 | 0.556 | 0.480 | 0.567 | 0.486 | 0.132 | 0.044 | 0.318 | 0.155 | 0.471 | 0.408 | 0.463 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.796 | 0.002 | 0.575 | 0.027 | 0.115 | 3.000 | 0.391 | 0.470 | 0.562 | 0.473 | 0.167 | 0.046 | 0.374 | 0.134 | 0.596 | 0.541 | 0.465 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.775 | 0.002 | 0.507 | 0.027 | 0.125 | 2.000 | 0.400 | 0.430 | 0.565 | 0.487 | 0.147 | 0.042 | 0.404 | 0.133 | 0.566 | 0.507 | 0.445 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 2381 | 1.000 | 0.018 | 0.768 | 0.004 | 0.510 | 0.033 | 0.129 | 1.000 | 0.408 | 0.406 | 0.575 | 0.501 | 0.135 | 0.041 | 0.407 | 0.135 | 0.562 | 0.503 | 0.428 |
| Reasoned emergency orders with merits follow-up | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.757 | 0.007 | 0.873 | 0.095 | 0.314 | 3.000 | 0.565 | 0.562 | 0.356 | 0.330 | 0.218 | 0.064 | 0.229 | 0.036 | 0.909 | 0.877 | 0.482 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.767 | 0.002 | 0.480 | 0.039 | 0.341 | 3.000 | 0.765 | 0.558 | 0.492 | 0.426 | 0.178 | 0.062 | 0.216 | 0.111 | 0.608 | 0.554 | 0.468 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.770 | 0.014 | 0.904 | 0.099 | 0.185 | 1.000 | 0.760 | 0.525 | 0.464 | 0.325 | 0.189 | 0.072 | 0.200 | 0.025 | 0.670 | 0.689 | 0.443 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.757 | 0.002 | 0.498 | 0.170 | 0.434 | 3.000 | 0.768 | 0.579 | 0.504 | 0.413 | 0.180 | 0.066 | 0.208 | 0.111 | 0.610 | 0.549 | 0.470 |
| Reasoned emergency orders with merits follow-up | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.768 | 0.001 | 0.906 | 0.031 | 0.058 | 3.000 | 0.501 | 0.542 | 0.419 | 0.372 | 0.291 | 0.105 | 0.198 | 0.037 | 0.920 | 0.898 | 0.482 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.772 | 0.002 | 0.437 | 0.154 | 0.211 | 2.000 | 0.564 | 0.473 | 0.548 | 0.476 | 0.150 | 0.053 | 0.284 | 0.125 | 0.594 | 0.536 | 0.447 |
| Reasoned emergency orders with merits follow-up | state/district_only | 204 | 1.000 | 0.021 | 0.770 | 0.014 | 0.763 | 0.056 | 0.137 | 1.000 | 0.553 | 0.477 | 0.525 | 0.422 | 0.191 | 0.029 | 0.196 | 0.056 | 0.683 | 0.675 | 0.439 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.761 | 0.003 | 0.747 | 0.055 | 0.314 | 3.000 | 0.576 | 0.527 | 0.531 | 0.447 | 0.166 | 0.055 | 0.267 | 0.111 | 0.610 | 0.554 | 0.468 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 8025 | 1.000 | 0.020 | 0.767 | 0.002 | 0.550 | 0.021 | 0.253 | 2.000 | 0.556 | 0.480 | 0.547 | 0.456 | 0.156 | 0.051 | 0.281 | 0.130 | 0.585 | 0.522 | 0.447 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.796 | 0.043 | 0.438 | 0.120 | 0.092 | 3.000 | 0.391 | 0.470 | 0.565 | 0.493 | 0.160 | 0.038 | 0.390 | 0.143 | 0.549 | 0.493 | 0.501 |
| Panel review with en banc safety valve | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.774 | 0.040 | 0.429 | 0.101 | 0.110 | 2.000 | 0.400 | 0.430 | 0.569 | 0.485 | 0.139 | 0.041 | 0.408 | 0.145 | 0.523 | 0.460 | 0.479 |
| Panel review with en banc safety valve | federal/district_only | 2381 | 1.000 | 0.018 | 0.765 | 0.056 | 0.464 | 0.115 | 0.132 | 1.000 | 0.408 | 0.406 | 0.558 | 0.487 | 0.119 | 0.042 | 0.408 | 0.137 | 0.529 | 0.463 | 0.461 |
| Panel review with en banc safety valve | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.753 | 0.148 | 0.705 | 0.231 | 0.331 | 3.000 | 0.565 | 0.562 | 0.378 | 0.282 | 0.207 | 0.069 | 0.207 | 0.032 | 0.926 | 0.873 | 0.542 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.769 | 0.036 | 0.395 | 0.115 | 0.305 | 3.000 | 0.765 | 0.558 | 0.503 | 0.425 | 0.186 | 0.057 | 0.225 | 0.121 | 0.555 | 0.503 | 0.509 |
| Panel review with en banc safety valve | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.773 | 0.178 | 0.678 | 0.230 | 0.268 | 1.000 | 0.760 | 0.525 | 0.498 | 0.400 | 0.204 | 0.034 | 0.192 | 0.031 | 0.632 | 0.634 | 0.486 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.763 | 0.031 | 0.484 | 0.140 | 0.383 | 3.000 | 0.768 | 0.579 | 0.503 | 0.417 | 0.173 | 0.059 | 0.217 | 0.122 | 0.557 | 0.499 | 0.514 |
| Panel review with en banc safety valve | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.772 | 0.154 | 0.553 | 0.289 | 0.021 | 3.000 | 0.501 | 0.542 | 0.453 | 0.314 | 0.256 | 0.047 | 0.128 | 0.028 | 0.923 | 0.880 | 0.538 |
| Panel review with en banc safety valve | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.770 | 0.039 | 0.536 | 0.190 | 0.196 | 2.000 | 0.564 | 0.473 | 0.533 | 0.469 | 0.145 | 0.049 | 0.289 | 0.132 | 0.551 | 0.492 | 0.483 |
| Panel review with en banc safety valve | state/district_only | 204 | 1.000 | 0.021 | 0.770 | 0.172 | 0.598 | 0.177 | 0.151 | 1.000 | 0.553 | 0.477 | 0.485 | 0.377 | 0.230 | 0.029 | 0.250 | 0.050 | 0.647 | 0.616 | 0.482 |
| Panel review with en banc safety valve | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.764 | 0.045 | 0.503 | 0.209 | 0.268 | 3.000 | 0.576 | 0.527 | 0.517 | 0.440 | 0.158 | 0.045 | 0.266 | 0.122 | 0.568 | 0.509 | 0.512 |
| Panel review with en banc safety valve | state/state_high_court | 8025 | 1.000 | 0.020 | 0.766 | 0.032 | 0.806 | 0.092 | 0.223 | 2.000 | 0.556 | 0.480 | 0.542 | 0.461 | 0.141 | 0.051 | 0.290 | 0.139 | 0.532 | 0.468 | 0.484 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.799 | 0.002 | 0.572 | 0.024 | 0.055 | 3.000 | 0.391 | 0.470 | 0.592 | 0.511 | 0.146 | 0.034 | 0.430 | 0.162 | 0.466 | 0.403 | 0.594 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.778 | 0.003 | 0.472 | 0.024 | 0.068 | 2.000 | 0.400 | 0.430 | 0.605 | 0.521 | 0.117 | 0.037 | 0.440 | 0.165 | 0.444 | 0.373 | 0.574 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 2381 | 1.000 | 0.018 | 0.769 | 0.005 | 0.447 | 0.049 | 0.078 | 1.000 | 0.408 | 0.406 | 0.615 | 0.521 | 0.110 | 0.037 | 0.451 | 0.163 | 0.449 | 0.371 | 0.557 |
| Dual supreme courts with cross-checking invalidations | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.763 | 0.008 | 0.854 | 0.146 | 0.218 | 3.000 | 0.565 | 0.562 | 0.367 | 0.335 | 0.213 | 0.069 | 0.266 | 0.046 | 0.865 | 0.827 | 0.610 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.776 | 0.002 | 0.492 | 0.061 | 0.227 | 3.000 | 0.765 | 0.558 | 0.556 | 0.482 | 0.152 | 0.043 | 0.254 | 0.139 | 0.462 | 0.400 | 0.597 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.772 | 0.020 | 0.664 | 0.110 | 0.117 | 1.000 | 0.760 | 0.525 | 0.498 | 0.408 | 0.215 | 0.053 | 0.189 | 0.050 | 0.566 | 0.557 | 0.572 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.774 | 0.002 | 0.434 | 0.059 | 0.294 | 3.000 | 0.768 | 0.579 | 0.553 | 0.470 | 0.144 | 0.049 | 0.255 | 0.142 | 0.460 | 0.393 | 0.599 |
| Dual supreme courts with cross-checking invalidations | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.770 | 0.002 | 0.880 | 0.040 | 0.000 | 3.000 | 0.501 | 0.542 | 0.488 | 0.384 | 0.326 | 0.023 | 0.140 | 0.047 | 0.854 | 0.840 | 0.611 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.774 | 0.003 | 0.457 | 0.023 | 0.143 | 2.000 | 0.564 | 0.473 | 0.580 | 0.496 | 0.121 | 0.042 | 0.317 | 0.153 | 0.466 | 0.398 | 0.576 |
| Dual supreme courts with cross-checking invalidations | state/district_only | 204 | 1.000 | 0.020 | 0.770 | 0.017 | 0.802 | 0.034 | 0.059 | 1.000 | 0.553 | 0.477 | 0.559 | 0.466 | 0.176 | 0.020 | 0.250 | 0.079 | 0.572 | 0.534 | 0.568 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.773 | 0.003 | 0.535 | 0.029 | 0.194 | 3.000 | 0.576 | 0.527 | 0.570 | 0.485 | 0.130 | 0.044 | 0.304 | 0.141 | 0.478 | 0.412 | 0.597 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 8025 | 1.000 | 0.019 | 0.770 | 0.002 | 0.522 | 0.021 | 0.163 | 2.000 | 0.556 | 0.480 | 0.601 | 0.498 | 0.125 | 0.043 | 0.340 | 0.161 | 0.445 | 0.373 | 0.577 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.797 | 0.040 | 0.431 | 0.104 | 0.051 | 3.000 | 0.391 | 0.470 | 0.616 | 0.533 | 0.134 | 0.030 | 0.461 | 0.214 | 0.377 | 0.292 | 0.537 |
| Pre-enactment constitutional council | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.775 | 0.039 | 0.428 | 0.095 | 0.071 | 2.000 | 0.400 | 0.430 | 0.631 | 0.538 | 0.105 | 0.032 | 0.463 | 0.223 | 0.365 | 0.278 | 0.518 |
| Pre-enactment constitutional council | federal/district_only | 2381 | 1.000 | 0.018 | 0.764 | 0.054 | 0.499 | 0.090 | 0.078 | 1.000 | 0.408 | 0.406 | 0.634 | 0.541 | 0.112 | 0.033 | 0.454 | 0.220 | 0.387 | 0.298 | 0.500 |
| Pre-enactment constitutional council | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.751 | 0.165 | 0.736 | 0.253 | 0.195 | 3.000 | 0.565 | 0.562 | 0.367 | 0.309 | 0.197 | 0.080 | 0.213 | 0.039 | 0.893 | 0.836 | 0.556 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.772 | 0.034 | 0.636 | 0.128 | 0.196 | 3.000 | 0.765 | 0.558 | 0.596 | 0.506 | 0.129 | 0.039 | 0.288 | 0.195 | 0.356 | 0.273 | 0.541 |
| Pre-enactment constitutional council | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.770 | 0.164 | 0.583 | 0.262 | 0.171 | 1.000 | 0.760 | 0.525 | 0.502 | 0.400 | 0.147 | 0.045 | 0.230 | 0.111 | 0.526 | 0.497 | 0.518 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.772 | 0.030 | 0.740 | 0.092 | 0.254 | 3.000 | 0.768 | 0.579 | 0.587 | 0.505 | 0.122 | 0.046 | 0.288 | 0.197 | 0.352 | 0.265 | 0.542 |
| Pre-enactment constitutional council | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.771 | 0.158 | 0.675 | 0.200 | 0.000 | 3.000 | 0.501 | 0.542 | 0.453 | 0.419 | 0.256 | 0.012 | 0.233 | 0.038 | 0.897 | 0.850 | 0.556 |
| Pre-enactment constitutional council | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.769 | 0.035 | 0.668 | 0.100 | 0.121 | 2.000 | 0.564 | 0.473 | 0.604 | 0.531 | 0.107 | 0.039 | 0.352 | 0.207 | 0.373 | 0.286 | 0.520 |
| Pre-enactment constitutional council | state/district_only | 204 | 1.000 | 0.021 | 0.766 | 0.179 | 0.718 | 0.205 | 0.074 | 1.000 | 0.553 | 0.477 | 0.544 | 0.417 | 0.147 | 0.049 | 0.309 | 0.120 | 0.559 | 0.497 | 0.514 |
| Pre-enactment constitutional council | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.769 | 0.045 | 0.771 | 0.189 | 0.182 | 3.000 | 0.576 | 0.527 | 0.592 | 0.506 | 0.123 | 0.044 | 0.335 | 0.194 | 0.393 | 0.308 | 0.541 |
| Pre-enactment constitutional council | state/state_high_court | 8025 | 1.000 | 0.020 | 0.766 | 0.029 | 0.540 | 0.164 | 0.146 | 2.000 | 0.556 | 0.480 | 0.616 | 0.521 | 0.102 | 0.036 | 0.360 | 0.216 | 0.344 | 0.252 | 0.520 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.795 | 0.043 | 0.425 | 0.077 | 0.093 | 3.000 | 0.391 | 0.470 | 0.534 | 0.455 | 0.168 | 0.039 | 0.382 | 0.114 | 0.608 | 0.537 | 0.470 |
| Judicial review with delayed legislative override | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.773 | 0.041 | 0.413 | 0.099 | 0.112 | 2.000 | 0.400 | 0.430 | 0.545 | 0.463 | 0.154 | 0.042 | 0.384 | 0.112 | 0.581 | 0.504 | 0.451 |
| Judicial review with delayed legislative override | federal/district_only | 2381 | 1.000 | 0.018 | 0.766 | 0.055 | 0.458 | 0.130 | 0.129 | 1.000 | 0.408 | 0.406 | 0.547 | 0.467 | 0.147 | 0.045 | 0.388 | 0.109 | 0.578 | 0.498 | 0.433 |
| Judicial review with delayed legislative override | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.750 | 0.166 | 0.729 | 0.224 | 0.331 | 3.000 | 0.565 | 0.562 | 0.261 | 0.324 | 0.207 | 0.085 | 0.213 | 0.029 | 0.937 | 0.880 | 0.489 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.763 | 0.037 | 0.552 | 0.129 | 0.308 | 3.000 | 0.765 | 0.558 | 0.478 | 0.402 | 0.162 | 0.059 | 0.207 | 0.094 | 0.618 | 0.548 | 0.474 |
| Judicial review with delayed legislative override | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.769 | 0.184 | 0.543 | 0.214 | 0.286 | 1.000 | 0.760 | 0.525 | 0.464 | 0.355 | 0.196 | 0.064 | 0.166 | 0.012 | 0.676 | 0.671 | 0.449 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.758 | 0.032 | 0.480 | 0.180 | 0.384 | 3.000 | 0.768 | 0.579 | 0.475 | 0.382 | 0.178 | 0.060 | 0.192 | 0.095 | 0.620 | 0.542 | 0.475 |
| Judicial review with delayed legislative override | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.764 | 0.195 | 0.644 | 0.267 | 0.024 | 3.000 | 0.501 | 0.542 | 0.465 | 0.302 | 0.360 | 0.070 | 0.174 | 0.027 | 0.935 | 0.890 | 0.489 |
| Judicial review with delayed legislative override | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.768 | 0.037 | 0.613 | 0.119 | 0.189 | 2.000 | 0.564 | 0.473 | 0.532 | 0.438 | 0.150 | 0.037 | 0.265 | 0.104 | 0.607 | 0.530 | 0.453 |
| Judicial review with delayed legislative override | state/district_only | 204 | 1.000 | 0.021 | 0.767 | 0.174 | 0.556 | 0.193 | 0.167 | 1.000 | 0.553 | 0.477 | 0.417 | 0.314 | 0.191 | 0.074 | 0.260 | 0.036 | 0.699 | 0.668 | 0.446 |
| Judicial review with delayed legislative override | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.760 | 0.050 | 0.438 | 0.139 | 0.269 | 3.000 | 0.576 | 0.527 | 0.489 | 0.416 | 0.166 | 0.052 | 0.251 | 0.094 | 0.624 | 0.550 | 0.474 |
| Judicial review with delayed legislative override | state/state_high_court | 8025 | 1.000 | 0.020 | 0.763 | 0.032 | 0.486 | 0.374 | 0.222 | 2.000 | 0.556 | 0.480 | 0.517 | 0.436 | 0.151 | 0.050 | 0.275 | 0.111 | 0.595 | 0.518 | 0.453 |
| Retention-election accountability court | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.796 | 0.039 | 0.381 | 0.138 | 0.049 | 3.000 | 0.391 | 0.470 | 0.576 | 0.502 | 0.143 | 0.033 | 0.422 | 0.153 | 0.430 | 0.335 | 0.485 |
| Retention-election accountability court | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.773 | 0.038 | 0.331 | 0.105 | 0.065 | 2.000 | 0.400 | 0.430 | 0.600 | 0.503 | 0.121 | 0.033 | 0.439 | 0.149 | 0.409 | 0.307 | 0.466 |
| Retention-election accountability court | federal/district_only | 2381 | 1.000 | 0.018 | 0.764 | 0.049 | 0.300 | 0.075 | 0.072 | 1.000 | 0.408 | 0.406 | 0.583 | 0.485 | 0.100 | 0.032 | 0.411 | 0.147 | 0.425 | 0.319 | 0.448 |
| Retention-election accountability court | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.760 | 0.139 | 0.667 | 0.231 | 0.216 | 3.000 | 0.565 | 0.562 | 0.356 | 0.271 | 0.293 | 0.048 | 0.202 | 0.033 | 0.903 | 0.835 | 0.503 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.757 | 0.033 | 0.440 | 0.208 | 0.170 | 3.000 | 0.765 | 0.558 | 0.540 | 0.462 | 0.140 | 0.045 | 0.257 | 0.131 | 0.411 | 0.313 | 0.489 |
| Retention-election accountability court | mixed_state_federal/district_only | 265 | 1.000 | 0.022 | 0.768 | 0.188 | 0.606 | 0.217 | 0.134 | 1.000 | 0.760 | 0.525 | 0.502 | 0.438 | 0.174 | 0.053 | 0.162 | 0.033 | 0.554 | 0.522 | 0.468 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.754 | 0.030 | 0.579 | 0.322 | 0.220 | 3.000 | 0.768 | 0.579 | 0.529 | 0.447 | 0.130 | 0.045 | 0.240 | 0.131 | 0.410 | 0.309 | 0.491 |
| Retention-election accountability court | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.772 | 0.165 | 0.610 | 0.146 | 0.022 | 3.000 | 0.501 | 0.542 | 0.384 | 0.209 | 0.384 | 0.093 | 0.128 | 0.029 | 0.912 | 0.861 | 0.505 |
| Retention-election accountability court | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.761 | 0.036 | 0.452 | 0.375 | 0.105 | 2.000 | 0.564 | 0.473 | 0.571 | 0.477 | 0.122 | 0.038 | 0.317 | 0.141 | 0.420 | 0.318 | 0.468 |
| Retention-election accountability court | state/district_only | 204 | 1.000 | 0.021 | 0.769 | 0.166 | 0.675 | 0.106 | 0.058 | 1.000 | 0.553 | 0.477 | 0.456 | 0.377 | 0.172 | 0.049 | 0.265 | 0.064 | 0.579 | 0.508 | 0.462 |
| Retention-election accountability court | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.761 | 0.043 | 0.647 | 0.070 | 0.151 | 3.000 | 0.576 | 0.527 | 0.558 | 0.465 | 0.125 | 0.041 | 0.304 | 0.129 | 0.441 | 0.345 | 0.489 |
| Retention-election accountability court | state/state_high_court | 8025 | 1.000 | 0.020 | 0.755 | 0.029 | 0.334 | 0.098 | 0.122 | 2.000 | 0.556 | 0.480 | 0.576 | 0.482 | 0.111 | 0.037 | 0.325 | 0.149 | 0.394 | 0.288 | 0.468 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 3911 | 1.000 | 0.019 | 0.799 | 0.002 | 0.580 | 0.017 | 0.075 | 3.000 | 0.391 | 0.470 | 0.568 | 0.494 | 0.157 | 0.043 | 0.413 | 0.162 | 0.492 | 0.448 | 0.532 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 9711 | 1.000 | 0.018 | 0.777 | 0.002 | 0.540 | 0.027 | 0.088 | 2.000 | 0.400 | 0.430 | 0.595 | 0.515 | 0.130 | 0.041 | 0.423 | 0.166 | 0.465 | 0.412 | 0.509 |
| Hybrid court balancing independence and accountability | federal/district_only | 2381 | 1.000 | 0.018 | 0.767 | 0.004 | 0.410 | 0.033 | 0.097 | 1.000 | 0.408 | 0.406 | 0.591 | 0.515 | 0.121 | 0.038 | 0.436 | 0.157 | 0.475 | 0.416 | 0.491 |
| Hybrid court balancing independence and accountability | federal/state_federal_split | 188 | 1.000 | 0.022 | 0.761 | 0.006 | 0.828 | 0.078 | 0.234 | 3.000 | 0.565 | 0.562 | 0.436 | 0.356 | 0.250 | 0.069 | 0.250 | 0.043 | 0.878 | 0.852 | 0.574 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 4444 | 1.000 | 0.021 | 0.773 | 0.002 | 0.511 | 0.058 | 0.268 | 3.000 | 0.765 | 0.558 | 0.551 | 0.448 | 0.157 | 0.056 | 0.245 | 0.143 | 0.490 | 0.448 | 0.540 |
| Hybrid court balancing independence and accountability | mixed_state_federal/district_only | 265 | 1.000 | 0.021 | 0.774 | 0.013 | 0.713 | 0.063 | 0.151 | 1.000 | 0.760 | 0.525 | 0.487 | 0.415 | 0.177 | 0.064 | 0.204 | 0.048 | 0.577 | 0.586 | 0.517 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 10859 | 1.000 | 0.021 | 0.769 | 0.001 | 0.512 | 0.049 | 0.341 | 3.000 | 0.768 | 0.579 | 0.535 | 0.457 | 0.148 | 0.056 | 0.244 | 0.143 | 0.488 | 0.442 | 0.545 |
| Hybrid court balancing independence and accountability | state/circuit_en_banc | 86 | 1.000 | 0.021 | 0.771 | 0.000 | 0.733 | 0.133 | 0.000 | 3.000 | 0.501 | 0.542 | 0.419 | 0.349 | 0.256 | 0.070 | 0.209 | 0.043 | 0.869 | 0.873 | 0.569 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 2833 | 1.000 | 0.019 | 0.773 | 0.002 | 0.564 | 0.029 | 0.165 | 2.000 | 0.564 | 0.473 | 0.567 | 0.491 | 0.126 | 0.045 | 0.328 | 0.154 | 0.487 | 0.438 | 0.514 |
| Hybrid court balancing independence and accountability | state/district_only | 204 | 1.000 | 0.021 | 0.768 | 0.011 | 0.766 | 0.089 | 0.059 | 1.000 | 0.553 | 0.477 | 0.515 | 0.490 | 0.152 | 0.044 | 0.265 | 0.093 | 0.589 | 0.578 | 0.513 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 5093 | 1.000 | 0.021 | 0.770 | 0.002 | 0.596 | 0.043 | 0.227 | 3.000 | 0.576 | 0.527 | 0.567 | 0.474 | 0.136 | 0.045 | 0.302 | 0.142 | 0.505 | 0.459 | 0.542 |
| Hybrid court balancing independence and accountability | state/state_high_court | 8025 | 1.000 | 0.020 | 0.770 | 0.002 | 0.480 | 0.018 | 0.199 | 2.000 | 0.556 | 0.480 | 0.579 | 0.484 | 0.133 | 0.045 | 0.323 | 0.160 | 0.470 | 0.417 | 0.514 |

## Policy Domain Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administration | 886 | 1.000 | 0.022 | 0.729 | 0.548 | 0.012 | 0.472 | 0.098 | 2.691 | 0.484 | 0.532 | 0.304 | 0.227 | 0.335 | 0.053 | 0.131 | 0.017 | 0.974 | 0.915 | 0.466 |
| Current-style federal supreme court | civil-rights | 19532 | 1.000 | 0.020 | 0.702 | 0.105 | 0.011 | 0.470 | 0.476 | 2.420 | 0.545 | 0.488 | 0.440 | 0.351 | 0.203 | 0.066 | 0.228 | 0.043 | 0.744 | 0.682 | 0.439 |
| Current-style federal supreme court | criminal-justice | 1414 | 1.000 | 0.022 | 0.624 | 0.631 | 0.019 | 0.562 | 0.596 | 2.359 | 0.589 | 0.519 | 0.264 | 0.173 | 0.317 | 0.073 | 0.071 | 0.018 | 0.975 | 0.912 | 0.455 |
| Current-style federal supreme court | economic-regulation | 4109 | 1.000 | 0.020 | 0.813 | 0.161 | 0.011 | 0.328 | 0.042 | 2.644 | 0.599 | 0.534 | 0.428 | 0.344 | 0.234 | 0.057 | 0.217 | 0.046 | 0.780 | 0.734 | 0.452 |
| Current-style federal supreme court | elections | 3138 | 1.000 | 0.022 | 0.705 | 0.303 | 0.013 | 0.419 | 0.370 | 2.753 | 0.691 | 0.529 | 0.365 | 0.289 | 0.223 | 0.062 | 0.136 | 0.028 | 0.814 | 0.781 | 0.456 |
| Current-style federal supreme court | emergency-security | 2371 | 1.000 | 0.023 | 0.677 | 0.692 | 0.023 | 0.576 | 0.255 | 2.033 | 0.576 | 0.516 | 0.294 | 0.227 | 0.257 | 0.059 | 0.133 | 0.011 | 0.852 | 0.812 | 0.452 |
| Current-style federal supreme court | federalism | 1008 | 1.000 | 0.023 | 0.715 | 0.541 | 0.016 | 0.518 | 0.136 | 2.761 | 0.768 | 0.612 | 0.281 | 0.214 | 0.291 | 0.065 | 0.066 | 0.016 | 0.974 | 0.917 | 0.473 |
| Current-style federal supreme court | governance | 13680 | 1.000 | 0.019 | 0.813 | 0.025 | 0.004 | 0.365 | 0.062 | 2.444 | 0.587 | 0.491 | 0.512 | 0.430 | 0.157 | 0.047 | 0.283 | 0.148 | 0.660 | 0.556 | 0.441 |
| Current-style federal supreme court | speech-religion | 1862 | 1.000 | 0.021 | 0.701 | 0.410 | 0.033 | 0.432 | 0.395 | 2.253 | 0.470 | 0.465 | 0.397 | 0.286 | 0.216 | 0.045 | 0.219 | 0.060 | 0.818 | 0.749 | 0.442 |
| Staggered 18-year nonrenewable terms | administration | 886 | 1.000 | 0.022 | 0.745 | 0.523 | 0.015 | 0.466 | 0.075 | 2.691 | 0.484 | 0.532 | 0.350 | 0.253 | 0.337 | 0.037 | 0.132 | 0.018 | 0.970 | 0.907 | 0.471 |
| Staggered 18-year nonrenewable terms | civil-rights | 19532 | 1.000 | 0.020 | 0.709 | 0.105 | 0.020 | 0.450 | 0.406 | 2.420 | 0.545 | 0.488 | 0.463 | 0.365 | 0.182 | 0.059 | 0.250 | 0.053 | 0.666 | 0.592 | 0.444 |
| Staggered 18-year nonrenewable terms | criminal-justice | 1414 | 1.000 | 0.022 | 0.632 | 0.625 | 0.043 | 0.540 | 0.569 | 2.359 | 0.589 | 0.519 | 0.264 | 0.189 | 0.293 | 0.055 | 0.083 | 0.018 | 0.972 | 0.906 | 0.459 |
| Staggered 18-year nonrenewable terms | economic-regulation | 4109 | 1.000 | 0.020 | 0.820 | 0.158 | 0.015 | 0.414 | 0.025 | 2.644 | 0.599 | 0.534 | 0.448 | 0.364 | 0.217 | 0.047 | 0.227 | 0.064 | 0.721 | 0.676 | 0.457 |
| Staggered 18-year nonrenewable terms | elections | 3138 | 1.000 | 0.022 | 0.715 | 0.305 | 0.031 | 0.382 | 0.312 | 2.753 | 0.691 | 0.529 | 0.376 | 0.314 | 0.222 | 0.052 | 0.140 | 0.035 | 0.747 | 0.712 | 0.461 |
| Staggered 18-year nonrenewable terms | emergency-security | 2371 | 1.000 | 0.023 | 0.699 | 0.677 | 0.036 | 0.533 | 0.275 | 2.033 | 0.576 | 0.516 | 0.334 | 0.238 | 0.253 | 0.055 | 0.134 | 0.011 | 0.801 | 0.761 | 0.457 |
| Staggered 18-year nonrenewable terms | federalism | 1008 | 1.000 | 0.023 | 0.734 | 0.531 | 0.020 | 0.512 | 0.091 | 2.761 | 0.768 | 0.612 | 0.299 | 0.210 | 0.293 | 0.040 | 0.067 | 0.018 | 0.972 | 0.912 | 0.478 |
| Staggered 18-year nonrenewable terms | governance | 13680 | 1.000 | 0.019 | 0.820 | 0.023 | 0.015 | 0.421 | 0.030 | 2.444 | 0.587 | 0.491 | 0.536 | 0.463 | 0.140 | 0.047 | 0.308 | 0.160 | 0.579 | 0.473 | 0.445 |
| Staggered 18-year nonrenewable terms | speech-religion | 1862 | 1.000 | 0.021 | 0.708 | 0.397 | 0.021 | 0.417 | 0.351 | 2.253 | 0.470 | 0.465 | 0.396 | 0.286 | 0.213 | 0.054 | 0.222 | 0.065 | 0.773 | 0.691 | 0.446 |
| Fifteen-justice supermajority commission court | administration | 886 | 1.000 | 0.021 | 0.771 | 0.163 | 0.620 | 0.185 | 0.020 | 2.691 | 0.484 | 0.532 | 0.381 | 0.351 | 0.304 | 0.041 | 0.193 | 0.034 | 0.926 | 0.872 | 0.486 |
| Fifteen-justice supermajority commission court | civil-rights | 19532 | 1.000 | 0.020 | 0.729 | 0.017 | 0.284 | 0.139 | 0.357 | 2.420 | 0.545 | 0.488 | 0.545 | 0.451 | 0.144 | 0.053 | 0.321 | 0.101 | 0.499 | 0.442 | 0.462 |
| Fifteen-justice supermajority commission court | criminal-justice | 1414 | 1.000 | 0.021 | 0.696 | 0.196 | 0.636 | 0.334 | 0.563 | 2.359 | 0.589 | 0.519 | 0.371 | 0.286 | 0.256 | 0.058 | 0.136 | 0.032 | 0.934 | 0.872 | 0.474 |
| Fifteen-justice supermajority commission court | economic-regulation | 4109 | 1.000 | 0.019 | 0.830 | 0.034 | 0.262 | 0.107 | 0.010 | 2.644 | 0.599 | 0.534 | 0.510 | 0.436 | 0.189 | 0.046 | 0.280 | 0.121 | 0.561 | 0.557 | 0.475 |
| Fifteen-justice supermajority commission court | elections | 3138 | 1.000 | 0.021 | 0.765 | 0.068 | 0.388 | 0.138 | 0.302 | 2.753 | 0.691 | 0.529 | 0.460 | 0.402 | 0.179 | 0.067 | 0.235 | 0.065 | 0.615 | 0.593 | 0.478 |
| Fifteen-justice supermajority commission court | emergency-security | 2371 | 1.000 | 0.022 | 0.760 | 0.192 | 0.655 | 0.275 | 0.243 | 2.033 | 0.576 | 0.516 | 0.456 | 0.369 | 0.196 | 0.058 | 0.238 | 0.036 | 0.674 | 0.653 | 0.473 |
| Fifteen-justice supermajority commission court | federalism | 1008 | 1.000 | 0.022 | 0.778 | 0.154 | 0.625 | 0.221 | 0.048 | 2.761 | 0.768 | 0.612 | 0.355 | 0.290 | 0.240 | 0.052 | 0.100 | 0.030 | 0.932 | 0.876 | 0.492 |
| Fifteen-justice supermajority commission court | governance | 13680 | 1.000 | 0.019 | 0.824 | 0.001 | 0.371 | 0.009 | 0.011 | 2.444 | 0.587 | 0.491 | 0.613 | 0.525 | 0.108 | 0.039 | 0.370 | 0.206 | 0.413 | 0.325 | 0.463 |
| Fifteen-justice supermajority commission court | speech-religion | 1862 | 1.000 | 0.020 | 0.753 | 0.110 | 0.398 | 0.196 | 0.374 | 2.253 | 0.470 | 0.465 | 0.493 | 0.412 | 0.182 | 0.046 | 0.292 | 0.100 | 0.681 | 0.593 | 0.462 |
| Supermajority required to invalidate laws | administration | 886 | 1.000 | 0.021 | 0.768 | 0.162 | 0.622 | 0.208 | 0.028 | 2.691 | 0.484 | 0.532 | 0.430 | 0.322 | 0.326 | 0.040 | 0.211 | 0.033 | 0.926 | 0.872 | 0.472 |
| Supermajority required to invalidate laws | civil-rights | 19532 | 1.000 | 0.020 | 0.728 | 0.017 | 0.263 | 0.094 | 0.356 | 2.420 | 0.545 | 0.488 | 0.532 | 0.443 | 0.153 | 0.055 | 0.312 | 0.083 | 0.548 | 0.493 | 0.448 |
| Supermajority required to invalidate laws | criminal-justice | 1414 | 1.000 | 0.021 | 0.696 | 0.194 | 0.611 | 0.297 | 0.535 | 2.359 | 0.589 | 0.519 | 0.344 | 0.271 | 0.250 | 0.068 | 0.141 | 0.031 | 0.931 | 0.870 | 0.460 |
| Supermajority required to invalidate laws | economic-regulation | 4109 | 1.000 | 0.019 | 0.829 | 0.035 | 0.265 | 0.107 | 0.013 | 2.644 | 0.599 | 0.534 | 0.505 | 0.419 | 0.194 | 0.046 | 0.277 | 0.103 | 0.616 | 0.602 | 0.461 |
| Supermajority required to invalidate laws | elections | 3138 | 1.000 | 0.021 | 0.760 | 0.074 | 0.280 | 0.142 | 0.301 | 2.753 | 0.691 | 0.529 | 0.469 | 0.386 | 0.182 | 0.057 | 0.209 | 0.055 | 0.649 | 0.626 | 0.464 |
| Supermajority required to invalidate laws | emergency-security | 2371 | 1.000 | 0.022 | 0.751 | 0.203 | 0.636 | 0.259 | 0.235 | 2.033 | 0.576 | 0.516 | 0.450 | 0.371 | 0.211 | 0.064 | 0.226 | 0.026 | 0.697 | 0.683 | 0.459 |
| Supermajority required to invalidate laws | federalism | 1008 | 1.000 | 0.022 | 0.772 | 0.169 | 0.564 | 0.289 | 0.051 | 2.761 | 0.768 | 0.612 | 0.344 | 0.301 | 0.256 | 0.052 | 0.124 | 0.030 | 0.930 | 0.874 | 0.479 |
| Supermajority required to invalidate laws | governance | 13680 | 1.000 | 0.019 | 0.822 | 0.001 | 0.377 | 0.023 | 0.019 | 2.444 | 0.587 | 0.491 | 0.593 | 0.513 | 0.117 | 0.038 | 0.349 | 0.189 | 0.463 | 0.375 | 0.451 |
| Supermajority required to invalidate laws | speech-religion | 1862 | 1.000 | 0.020 | 0.753 | 0.107 | 0.391 | 0.200 | 0.324 | 2.253 | 0.470 | 0.465 | 0.477 | 0.406 | 0.195 | 0.060 | 0.289 | 0.089 | 0.696 | 0.611 | 0.450 |
| Strict recusal with substitute justices | administration | 886 | 1.000 | 0.021 | 0.771 | 0.154 | 0.655 | 0.203 | 0.018 | 2.691 | 0.484 | 0.532 | 0.410 | 0.342 | 0.296 | 0.045 | 0.207 | 0.034 | 0.917 | 0.865 | 0.492 |
| Strict recusal with substitute justices | civil-rights | 19532 | 1.000 | 0.020 | 0.730 | 0.015 | 0.256 | 0.113 | 0.339 | 2.420 | 0.545 | 0.488 | 0.566 | 0.478 | 0.133 | 0.050 | 0.339 | 0.131 | 0.448 | 0.387 | 0.467 |
| Strict recusal with substitute justices | criminal-justice | 1414 | 1.000 | 0.021 | 0.697 | 0.189 | 0.691 | 0.308 | 0.552 | 2.359 | 0.589 | 0.519 | 0.362 | 0.306 | 0.257 | 0.065 | 0.146 | 0.033 | 0.925 | 0.864 | 0.480 |
| Strict recusal with substitute justices | economic-regulation | 4109 | 1.000 | 0.019 | 0.831 | 0.033 | 0.421 | 0.090 | 0.009 | 2.644 | 0.599 | 0.534 | 0.533 | 0.462 | 0.179 | 0.042 | 0.310 | 0.144 | 0.502 | 0.498 | 0.480 |
| Strict recusal with substitute justices | elections | 3138 | 1.000 | 0.021 | 0.767 | 0.066 | 0.399 | 0.176 | 0.286 | 2.753 | 0.691 | 0.529 | 0.499 | 0.432 | 0.161 | 0.057 | 0.225 | 0.084 | 0.578 | 0.555 | 0.484 |
| Strict recusal with substitute justices | emergency-security | 2371 | 1.000 | 0.022 | 0.760 | 0.187 | 0.692 | 0.236 | 0.227 | 2.033 | 0.576 | 0.516 | 0.505 | 0.397 | 0.197 | 0.048 | 0.246 | 0.057 | 0.651 | 0.623 | 0.479 |
| Strict recusal with substitute justices | federalism | 1008 | 1.000 | 0.022 | 0.779 | 0.159 | 0.658 | 0.242 | 0.032 | 2.761 | 0.768 | 0.612 | 0.399 | 0.312 | 0.255 | 0.056 | 0.110 | 0.032 | 0.921 | 0.866 | 0.498 |
| Strict recusal with substitute justices | governance | 13680 | 1.000 | 0.019 | 0.825 | 0.001 | 0.067 | 0.003 | 0.007 | 2.444 | 0.587 | 0.491 | 0.634 | 0.544 | 0.101 | 0.033 | 0.378 | 0.230 | 0.363 | 0.274 | 0.469 |
| Strict recusal with substitute justices | speech-religion | 1862 | 1.000 | 0.020 | 0.755 | 0.102 | 0.441 | 0.179 | 0.362 | 2.253 | 0.470 | 0.465 | 0.483 | 0.427 | 0.168 | 0.044 | 0.307 | 0.114 | 0.666 | 0.578 | 0.468 |
| Reasoned emergency orders with merits follow-up | administration | 886 | 1.000 | 0.021 | 0.770 | 0.001 | 0.847 | 0.071 | 0.042 | 2.691 | 0.484 | 0.532 | 0.416 | 0.360 | 0.307 | 0.056 | 0.209 | 0.039 | 0.904 | 0.874 | 0.476 |
| Reasoned emergency orders with merits follow-up | civil-rights | 19532 | 1.000 | 0.020 | 0.724 | 0.001 | 0.068 | 0.110 | 0.445 | 2.420 | 0.545 | 0.488 | 0.542 | 0.445 | 0.161 | 0.060 | 0.301 | 0.099 | 0.574 | 0.514 | 0.452 |
| Reasoned emergency orders with merits follow-up | criminal-justice | 1414 | 1.000 | 0.021 | 0.722 | 0.008 | 0.883 | 0.121 | 0.617 | 2.359 | 0.589 | 0.519 | 0.391 | 0.328 | 0.253 | 0.073 | 0.166 | 0.037 | 0.916 | 0.874 | 0.463 |
| Reasoned emergency orders with merits follow-up | economic-regulation | 4109 | 1.000 | 0.019 | 0.830 | 0.000 | 0.179 | 0.022 | 0.025 | 2.644 | 0.599 | 0.534 | 0.512 | 0.432 | 0.195 | 0.050 | 0.277 | 0.113 | 0.630 | 0.618 | 0.465 |
| Reasoned emergency orders with merits follow-up | elections | 3138 | 1.000 | 0.021 | 0.764 | 0.007 | 0.521 | 0.050 | 0.340 | 2.753 | 0.691 | 0.529 | 0.487 | 0.402 | 0.185 | 0.063 | 0.207 | 0.066 | 0.663 | 0.645 | 0.468 |
| Reasoned emergency orders with merits follow-up | emergency-security | 2371 | 1.000 | 0.022 | 0.762 | 0.017 | 0.860 | 0.130 | 0.222 | 2.033 | 0.576 | 0.516 | 0.474 | 0.385 | 0.204 | 0.052 | 0.257 | 0.041 | 0.698 | 0.694 | 0.462 |
| Reasoned emergency orders with merits follow-up | federalism | 1008 | 1.000 | 0.021 | 0.777 | 0.001 | 0.875 | 0.075 | 0.089 | 2.761 | 0.768 | 0.612 | 0.402 | 0.374 | 0.220 | 0.046 | 0.127 | 0.036 | 0.908 | 0.878 | 0.481 |
| Reasoned emergency orders with merits follow-up | governance | 13680 | 1.000 | 0.019 | 0.820 | 0.000 | 0.105 | 0.000 | 0.036 | 2.444 | 0.587 | 0.491 | 0.590 | 0.520 | 0.117 | 0.041 | 0.349 | 0.206 | 0.491 | 0.398 | 0.454 |
| Reasoned emergency orders with merits follow-up | speech-religion | 1862 | 1.000 | 0.020 | 0.767 | 0.007 | 0.554 | 0.080 | 0.378 | 2.253 | 0.470 | 0.465 | 0.505 | 0.421 | 0.193 | 0.056 | 0.293 | 0.104 | 0.695 | 0.624 | 0.452 |
| Panel review with en banc safety valve | administration | 886 | 1.000 | 0.021 | 0.771 | 0.158 | 0.623 | 0.195 | 0.026 | 2.691 | 0.484 | 0.532 | 0.380 | 0.323 | 0.295 | 0.052 | 0.196 | 0.035 | 0.923 | 0.868 | 0.530 |
| Panel review with en banc safety valve | civil-rights | 19532 | 1.000 | 0.020 | 0.727 | 0.017 | 0.271 | 0.129 | 0.385 | 2.420 | 0.545 | 0.488 | 0.540 | 0.457 | 0.151 | 0.054 | 0.307 | 0.111 | 0.517 | 0.457 | 0.490 |
| Panel review with en banc safety valve | criminal-justice | 1414 | 1.000 | 0.021 | 0.696 | 0.191 | 0.655 | 0.291 | 0.602 | 2.359 | 0.589 | 0.519 | 0.357 | 0.314 | 0.245 | 0.072 | 0.150 | 0.032 | 0.929 | 0.867 | 0.513 |
| Panel review with en banc safety valve | economic-regulation | 4109 | 1.000 | 0.019 | 0.830 | 0.033 | 0.320 | 0.128 | 0.010 | 2.644 | 0.599 | 0.534 | 0.521 | 0.436 | 0.195 | 0.046 | 0.284 | 0.129 | 0.577 | 0.570 | 0.502 |
| Panel review with en banc safety valve | elections | 3138 | 1.000 | 0.021 | 0.764 | 0.068 | 0.313 | 0.123 | 0.301 | 2.753 | 0.691 | 0.529 | 0.486 | 0.386 | 0.180 | 0.061 | 0.213 | 0.072 | 0.626 | 0.604 | 0.515 |
| Panel review with en banc safety valve | emergency-security | 2371 | 1.000 | 0.022 | 0.760 | 0.191 | 0.698 | 0.238 | 0.243 | 2.033 | 0.576 | 0.516 | 0.462 | 0.371 | 0.205 | 0.048 | 0.237 | 0.044 | 0.680 | 0.658 | 0.513 |
| Panel review with en banc safety valve | federalism | 1008 | 1.000 | 0.022 | 0.779 | 0.154 | 0.678 | 0.214 | 0.039 | 2.761 | 0.768 | 0.612 | 0.384 | 0.314 | 0.242 | 0.052 | 0.106 | 0.032 | 0.927 | 0.872 | 0.540 |
| Panel review with en banc safety valve | governance | 13680 | 1.000 | 0.019 | 0.824 | 0.001 | 0.377 | 0.070 | 0.013 | 2.444 | 0.587 | 0.491 | 0.596 | 0.519 | 0.108 | 0.038 | 0.367 | 0.217 | 0.432 | 0.345 | 0.487 |
| Panel review with en banc safety valve | speech-religion | 1862 | 1.000 | 0.020 | 0.752 | 0.108 | 0.420 | 0.176 | 0.380 | 2.253 | 0.470 | 0.465 | 0.486 | 0.419 | 0.185 | 0.051 | 0.309 | 0.105 | 0.683 | 0.596 | 0.492 |
| Dual supreme courts with cross-checking invalidations | administration | 886 | 1.000 | 0.020 | 0.772 | 0.002 | 0.883 | 0.049 | 0.006 | 2.691 | 0.484 | 0.532 | 0.435 | 0.378 | 0.280 | 0.030 | 0.234 | 0.051 | 0.855 | 0.824 | 0.604 |
| Dual supreme courts with cross-checking invalidations | civil-rights | 19532 | 1.000 | 0.020 | 0.734 | 0.001 | 0.066 | 0.011 | 0.295 | 2.420 | 0.545 | 0.488 | 0.587 | 0.496 | 0.124 | 0.046 | 0.348 | 0.134 | 0.424 | 0.350 | 0.582 |
| Dual supreme courts with cross-checking invalidations | criminal-justice | 1414 | 1.000 | 0.021 | 0.728 | 0.010 | 0.840 | 0.140 | 0.475 | 2.359 | 0.589 | 0.519 | 0.426 | 0.339 | 0.225 | 0.069 | 0.195 | 0.046 | 0.866 | 0.821 | 0.592 |
| Dual supreme courts with cross-checking invalidations | economic-regulation | 4109 | 1.000 | 0.019 | 0.832 | 0.000 | 0.177 | 0.013 | 0.003 | 2.644 | 0.599 | 0.534 | 0.577 | 0.482 | 0.161 | 0.041 | 0.322 | 0.150 | 0.470 | 0.457 | 0.594 |
| Dual supreme courts with cross-checking invalidations | elections | 3138 | 1.000 | 0.021 | 0.778 | 0.007 | 0.525 | 0.081 | 0.237 | 2.753 | 0.691 | 0.529 | 0.513 | 0.440 | 0.157 | 0.052 | 0.254 | 0.090 | 0.542 | 0.518 | 0.597 |
| Dual supreme courts with cross-checking invalidations | emergency-security | 2371 | 1.000 | 0.021 | 0.765 | 0.021 | 0.811 | 0.101 | 0.117 | 2.033 | 0.576 | 0.516 | 0.514 | 0.436 | 0.186 | 0.043 | 0.286 | 0.068 | 0.608 | 0.582 | 0.591 |
| Dual supreme courts with cross-checking invalidations | federalism | 1008 | 1.000 | 0.021 | 0.784 | 0.002 | 0.850 | 0.066 | 0.010 | 2.761 | 0.768 | 0.612 | 0.410 | 0.367 | 0.199 | 0.054 | 0.146 | 0.045 | 0.860 | 0.824 | 0.610 |
| Dual supreme courts with cross-checking invalidations | governance | 13680 | 1.000 | 0.019 | 0.825 | 0.000 | 0.105 | 0.000 | 0.002 | 2.444 | 0.587 | 0.491 | 0.643 | 0.555 | 0.093 | 0.033 | 0.399 | 0.235 | 0.345 | 0.248 | 0.583 |
| Dual supreme courts with cross-checking invalidations | speech-religion | 1862 | 1.000 | 0.020 | 0.768 | 0.007 | 0.548 | 0.073 | 0.290 | 2.253 | 0.470 | 0.465 | 0.532 | 0.457 | 0.172 | 0.044 | 0.316 | 0.125 | 0.626 | 0.543 | 0.581 |
| Pre-enactment constitutional council | administration | 886 | 1.000 | 0.021 | 0.772 | 0.152 | 0.691 | 0.172 | 0.004 | 2.691 | 0.484 | 0.532 | 0.415 | 0.392 | 0.269 | 0.049 | 0.222 | 0.040 | 0.891 | 0.835 | 0.549 |
| Pre-enactment constitutional council | civil-rights | 19532 | 1.000 | 0.020 | 0.732 | 0.016 | 0.301 | 0.092 | 0.250 | 2.420 | 0.545 | 0.488 | 0.628 | 0.527 | 0.102 | 0.040 | 0.384 | 0.205 | 0.309 | 0.221 | 0.525 |
| Pre-enactment constitutional council | criminal-justice | 1414 | 1.000 | 0.021 | 0.701 | 0.185 | 0.748 | 0.312 | 0.427 | 2.359 | 0.589 | 0.519 | 0.351 | 0.314 | 0.238 | 0.062 | 0.156 | 0.039 | 0.893 | 0.829 | 0.537 |
| Pre-enactment constitutional council | economic-regulation | 4109 | 1.000 | 0.019 | 0.831 | 0.033 | 0.387 | 0.060 | 0.001 | 2.644 | 0.599 | 0.534 | 0.592 | 0.516 | 0.138 | 0.036 | 0.363 | 0.193 | 0.347 | 0.297 | 0.538 |
| Pre-enactment constitutional council | elections | 3138 | 1.000 | 0.021 | 0.771 | 0.064 | 0.442 | 0.119 | 0.216 | 2.753 | 0.691 | 0.529 | 0.535 | 0.464 | 0.150 | 0.052 | 0.274 | 0.136 | 0.476 | 0.429 | 0.542 |
| Pre-enactment constitutional council | emergency-security | 2371 | 1.000 | 0.022 | 0.760 | 0.180 | 0.729 | 0.211 | 0.123 | 2.033 | 0.576 | 0.516 | 0.501 | 0.410 | 0.171 | 0.051 | 0.280 | 0.108 | 0.593 | 0.545 | 0.537 |
| Pre-enactment constitutional council | federalism | 1008 | 1.000 | 0.022 | 0.782 | 0.151 | 0.723 | 0.215 | 0.012 | 2.761 | 0.768 | 0.612 | 0.363 | 0.318 | 0.229 | 0.051 | 0.117 | 0.038 | 0.891 | 0.832 | 0.556 |
| Pre-enactment constitutional council | governance | 13680 | 1.000 | 0.019 | 0.825 | 0.001 | 0.381 | 0.011 | 0.001 | 2.444 | 0.587 | 0.491 | 0.681 | 0.591 | 0.074 | 0.026 | 0.434 | 0.293 | 0.233 | 0.115 | 0.525 |
| Pre-enactment constitutional council | speech-religion | 1862 | 1.000 | 0.020 | 0.754 | 0.103 | 0.596 | 0.191 | 0.297 | 2.253 | 0.470 | 0.465 | 0.526 | 0.455 | 0.180 | 0.049 | 0.307 | 0.156 | 0.626 | 0.542 | 0.524 |
| Judicial review with delayed legislative override | administration | 886 | 1.000 | 0.021 | 0.768 | 0.161 | 0.598 | 0.207 | 0.044 | 2.691 | 0.484 | 0.532 | 0.359 | 0.328 | 0.293 | 0.044 | 0.199 | 0.033 | 0.927 | 0.873 | 0.482 |
| Judicial review with delayed legislative override | civil-rights | 19532 | 1.000 | 0.020 | 0.723 | 0.016 | 0.283 | 0.089 | 0.376 | 2.420 | 0.545 | 0.488 | 0.506 | 0.418 | 0.156 | 0.053 | 0.286 | 0.077 | 0.583 | 0.506 | 0.457 |
| Judicial review with delayed legislative override | criminal-justice | 1414 | 1.000 | 0.021 | 0.691 | 0.202 | 0.645 | 0.327 | 0.585 | 2.359 | 0.589 | 0.519 | 0.345 | 0.279 | 0.278 | 0.066 | 0.139 | 0.031 | 0.935 | 0.873 | 0.470 |
| Judicial review with delayed legislative override | economic-regulation | 4109 | 1.000 | 0.019 | 0.829 | 0.034 | 0.322 | 0.043 | 0.020 | 2.644 | 0.599 | 0.534 | 0.509 | 0.415 | 0.203 | 0.044 | 0.264 | 0.096 | 0.640 | 0.614 | 0.470 |
| Judicial review with delayed legislative override | elections | 3138 | 1.000 | 0.021 | 0.762 | 0.069 | 0.374 | 0.221 | 0.316 | 2.753 | 0.691 | 0.529 | 0.458 | 0.376 | 0.181 | 0.062 | 0.201 | 0.054 | 0.675 | 0.642 | 0.474 |
| Judicial review with delayed legislative override | emergency-security | 2371 | 1.000 | 0.022 | 0.757 | 0.198 | 0.638 | 0.250 | 0.259 | 2.033 | 0.576 | 0.516 | 0.447 | 0.368 | 0.197 | 0.057 | 0.229 | 0.027 | 0.711 | 0.687 | 0.469 |
| Judicial review with delayed legislative override | federalism | 1008 | 1.000 | 0.022 | 0.774 | 0.165 | 0.642 | 0.273 | 0.056 | 2.761 | 0.768 | 0.612 | 0.366 | 0.317 | 0.225 | 0.049 | 0.108 | 0.029 | 0.934 | 0.879 | 0.488 |
| Judicial review with delayed legislative override | governance | 13680 | 1.000 | 0.019 | 0.823 | 0.001 | 0.368 | 0.018 | 0.017 | 2.444 | 0.587 | 0.491 | 0.576 | 0.497 | 0.120 | 0.041 | 0.342 | 0.185 | 0.503 | 0.396 | 0.459 |
| Judicial review with delayed legislative override | speech-religion | 1862 | 1.000 | 0.020 | 0.749 | 0.115 | 0.400 | 0.190 | 0.386 | 2.253 | 0.470 | 0.465 | 0.480 | 0.380 | 0.190 | 0.059 | 0.286 | 0.087 | 0.713 | 0.622 | 0.459 |
| Retention-election accountability court | administration | 886 | 1.000 | 0.021 | 0.772 | 0.157 | 0.638 | 0.187 | 0.010 | 2.691 | 0.484 | 0.532 | 0.389 | 0.332 | 0.293 | 0.053 | 0.178 | 0.037 | 0.900 | 0.839 | 0.497 |
| Retention-election accountability court | civil-rights | 19532 | 1.000 | 0.020 | 0.711 | 0.015 | 0.262 | 0.140 | 0.207 | 2.420 | 0.545 | 0.488 | 0.566 | 0.476 | 0.113 | 0.039 | 0.348 | 0.120 | 0.374 | 0.267 | 0.473 |
| Retention-election accountability court | criminal-justice | 1414 | 1.000 | 0.021 | 0.694 | 0.182 | 0.674 | 0.287 | 0.406 | 2.359 | 0.589 | 0.519 | 0.375 | 0.293 | 0.238 | 0.068 | 0.151 | 0.035 | 0.902 | 0.832 | 0.485 |
| Retention-election accountability court | economic-regulation | 4109 | 1.000 | 0.019 | 0.831 | 0.032 | 0.316 | 0.042 | 0.003 | 2.644 | 0.599 | 0.534 | 0.578 | 0.476 | 0.151 | 0.039 | 0.311 | 0.150 | 0.414 | 0.364 | 0.487 |
| Retention-election accountability court | elections | 3138 | 1.000 | 0.021 | 0.770 | 0.063 | 0.400 | 0.178 | 0.203 | 2.753 | 0.691 | 0.529 | 0.502 | 0.424 | 0.151 | 0.047 | 0.237 | 0.080 | 0.515 | 0.460 | 0.491 |
| Retention-election accountability court | emergency-security | 2371 | 1.000 | 0.022 | 0.761 | 0.180 | 0.662 | 0.217 | 0.110 | 2.033 | 0.576 | 0.516 | 0.458 | 0.397 | 0.176 | 0.048 | 0.243 | 0.044 | 0.614 | 0.562 | 0.486 |
| Retention-election accountability court | federalism | 1008 | 1.000 | 0.022 | 0.783 | 0.149 | 0.661 | 0.187 | 0.017 | 2.761 | 0.768 | 0.612 | 0.365 | 0.326 | 0.235 | 0.057 | 0.102 | 0.034 | 0.901 | 0.835 | 0.503 |
| Retention-election accountability court | governance | 13680 | 1.000 | 0.019 | 0.825 | 0.000 | 0.385 | 0.009 | 0.000 | 2.444 | 0.587 | 0.491 | 0.642 | 0.544 | 0.084 | 0.028 | 0.399 | 0.224 | 0.278 | 0.145 | 0.473 |
| Retention-election accountability court | speech-religion | 1862 | 1.000 | 0.020 | 0.750 | 0.101 | 0.503 | 0.154 | 0.281 | 2.253 | 0.470 | 0.465 | 0.487 | 0.405 | 0.179 | 0.047 | 0.281 | 0.107 | 0.646 | 0.548 | 0.472 |
| Hybrid court balancing independence and accountability | administration | 886 | 1.000 | 0.021 | 0.772 | 0.000 | 0.873 | 0.043 | 0.007 | 2.691 | 0.484 | 0.532 | 0.446 | 0.362 | 0.279 | 0.050 | 0.229 | 0.046 | 0.871 | 0.851 | 0.561 |
| Hybrid court balancing independence and accountability | civil-rights | 19532 | 1.000 | 0.020 | 0.731 | 0.001 | 0.219 | 0.008 | 0.358 | 2.420 | 0.545 | 0.488 | 0.571 | 0.481 | 0.132 | 0.052 | 0.338 | 0.136 | 0.452 | 0.399 | 0.519 |
| Hybrid court balancing independence and accountability | criminal-justice | 1414 | 1.000 | 0.021 | 0.728 | 0.007 | 0.916 | 0.108 | 0.519 | 2.359 | 0.589 | 0.519 | 0.417 | 0.359 | 0.236 | 0.066 | 0.185 | 0.042 | 0.876 | 0.846 | 0.543 |
| Hybrid court balancing independence and accountability | economic-regulation | 4109 | 1.000 | 0.019 | 0.831 | 0.000 | 0.184 | 0.010 | 0.005 | 2.644 | 0.599 | 0.534 | 0.532 | 0.459 | 0.173 | 0.047 | 0.301 | 0.148 | 0.499 | 0.508 | 0.535 |
| Hybrid court balancing independence and accountability | elections | 3138 | 1.000 | 0.021 | 0.776 | 0.006 | 0.535 | 0.055 | 0.250 | 2.753 | 0.691 | 0.529 | 0.526 | 0.437 | 0.164 | 0.057 | 0.253 | 0.091 | 0.565 | 0.558 | 0.547 |
| Hybrid court balancing independence and accountability | emergency-security | 2371 | 1.000 | 0.022 | 0.764 | 0.014 | 0.782 | 0.109 | 0.131 | 2.033 | 0.576 | 0.516 | 0.496 | 0.409 | 0.188 | 0.052 | 0.279 | 0.068 | 0.623 | 0.618 | 0.545 |
| Hybrid court balancing independence and accountability | federalism | 1008 | 1.000 | 0.021 | 0.784 | 0.001 | 0.868 | 0.061 | 0.023 | 2.761 | 0.768 | 0.612 | 0.419 | 0.340 | 0.252 | 0.045 | 0.145 | 0.042 | 0.865 | 0.847 | 0.572 |
| Hybrid court balancing independence and accountability | governance | 13680 | 1.000 | 0.019 | 0.824 | 0.000 | 0.105 | 0.000 | 0.008 | 2.444 | 0.587 | 0.491 | 0.626 | 0.547 | 0.098 | 0.034 | 0.384 | 0.234 | 0.373 | 0.293 | 0.519 |
| Hybrid court balancing independence and accountability | speech-religion | 1862 | 1.000 | 0.020 | 0.767 | 0.006 | 0.531 | 0.074 | 0.331 | 2.253 | 0.470 | 0.465 | 0.541 | 0.449 | 0.166 | 0.058 | 0.305 | 0.124 | 0.635 | 0.567 | 0.522 |

## Composition Diagnostics

| Scenario | Period | Observations | Size | Median ideology | Spread | Partisan attach. | Rights sens. | Institutionalism | Replacement events |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 600 | 9.000 | 0.067 | 1.365 | 0.649 | 0.707 | 0.797 | 0.000 |
| Current-style federal supreme court | 2 | 600 | 9.000 | 0.070 | 1.379 | 0.648 | 0.707 | 0.796 | 1.307 |
| Current-style federal supreme court | 3 | 600 | 9.000 | 0.073 | 1.385 | 0.649 | 0.705 | 0.798 | 1.307 |
| Current-style federal supreme court | 4 | 600 | 9.000 | 0.074 | 1.368 | 0.649 | 0.705 | 0.797 | 1.307 |
| Staggered 18-year nonrenewable terms | 1 | 600 | 9.000 | 0.039 | 1.387 | 0.630 | 0.707 | 0.782 | 0.000 |
| Staggered 18-year nonrenewable terms | 2 | 600 | 9.000 | 0.034 | 1.373 | 0.628 | 0.707 | 0.780 | 3.258 |
| Staggered 18-year nonrenewable terms | 3 | 600 | 9.000 | 0.035 | 1.385 | 0.629 | 0.708 | 0.781 | 3.258 |
| Staggered 18-year nonrenewable terms | 4 | 600 | 9.000 | 0.041 | 1.397 | 0.630 | 0.707 | 0.781 | 3.258 |
| Fifteen-justice supermajority commission court | 1 | 600 | 15.000 | -0.002 | 0.824 | 0.542 | 0.733 | 0.779 | 0.000 |
| Fifteen-justice supermajority commission court | 2 | 600 | 15.000 | 0.001 | 0.856 | 0.542 | 0.732 | 0.778 | 6.798 |
| Fifteen-justice supermajority commission court | 3 | 600 | 15.000 | -0.002 | 0.889 | 0.541 | 0.733 | 0.779 | 6.798 |
| Fifteen-justice supermajority commission court | 4 | 600 | 15.000 | -0.001 | 0.928 | 0.542 | 0.732 | 0.779 | 6.798 |
| Supermajority required to invalidate laws | 1 | 600 | 9.000 | 0.055 | 1.373 | 0.623 | 0.702 | 0.843 | 0.000 |
| Supermajority required to invalidate laws | 2 | 600 | 9.000 | 0.056 | 1.372 | 0.624 | 0.699 | 0.843 | 1.357 |
| Supermajority required to invalidate laws | 3 | 600 | 9.000 | 0.058 | 1.378 | 0.625 | 0.701 | 0.843 | 1.357 |
| Supermajority required to invalidate laws | 4 | 600 | 9.000 | 0.055 | 1.386 | 0.625 | 0.698 | 0.843 | 1.357 |
| Strict recusal with substitute justices | 1 | 600 | 12.000 | -0.001 | 0.807 | 0.542 | 0.732 | 0.768 | 0.000 |
| Strict recusal with substitute justices | 2 | 600 | 12.000 | 0.005 | 0.841 | 0.541 | 0.732 | 0.768 | 5.506 |
| Strict recusal with substitute justices | 3 | 600 | 12.000 | -0.001 | 0.868 | 0.542 | 0.732 | 0.767 | 5.506 |
| Strict recusal with substitute justices | 4 | 600 | 12.000 | 0.002 | 0.900 | 0.542 | 0.731 | 0.768 | 5.506 |
| Reasoned emergency orders with merits follow-up | 1 | 600 | 9.000 | 0.026 | 1.362 | 0.606 | 0.729 | 0.798 | 0.000 |
| Reasoned emergency orders with merits follow-up | 2 | 600 | 9.000 | 0.024 | 1.377 | 0.606 | 0.729 | 0.799 | 3.258 |
| Reasoned emergency orders with merits follow-up | 3 | 600 | 9.000 | 0.017 | 1.384 | 0.606 | 0.731 | 0.798 | 3.258 |
| Reasoned emergency orders with merits follow-up | 4 | 600 | 9.000 | 0.023 | 1.386 | 0.605 | 0.730 | 0.799 | 3.258 |
| Panel review with en banc safety valve | 1 | 600 | 15.000 | 0.002 | 0.634 | 0.514 | 0.735 | 0.749 | 0.000 |
| Panel review with en banc safety valve | 2 | 600 | 15.000 | 0.005 | 0.674 | 0.513 | 0.735 | 0.749 | 6.882 |
| Panel review with en banc safety valve | 3 | 600 | 15.000 | -0.003 | 0.711 | 0.513 | 0.735 | 0.749 | 6.882 |
| Panel review with en banc safety valve | 4 | 600 | 15.000 | -0.002 | 0.752 | 0.513 | 0.735 | 0.749 | 6.882 |
| Dual supreme courts with cross-checking invalidations | 1 | 600 | 18.000 | -0.001 | 0.845 | 0.522 | 0.748 | 0.805 | 0.000 |
| Dual supreme courts with cross-checking invalidations | 2 | 600 | 18.000 | 0.004 | 0.873 | 0.523 | 0.748 | 0.805 | 8.208 |
| Dual supreme courts with cross-checking invalidations | 3 | 600 | 18.000 | -0.002 | 0.906 | 0.523 | 0.747 | 0.805 | 8.208 |
| Dual supreme courts with cross-checking invalidations | 4 | 600 | 18.000 | -0.003 | 0.957 | 0.523 | 0.747 | 0.804 | 8.208 |
| Pre-enactment constitutional council | 1 | 600 | 12.000 | -0.001 | 0.626 | 0.489 | 0.767 | 0.793 | 0.000 |
| Pre-enactment constitutional council | 2 | 600 | 12.000 | 0.008 | 0.677 | 0.490 | 0.765 | 0.794 | 8.604 |
| Pre-enactment constitutional council | 3 | 600 | 12.000 | 0.004 | 0.731 | 0.489 | 0.766 | 0.794 | 8.604 |
| Pre-enactment constitutional council | 4 | 600 | 12.000 | 0.004 | 0.800 | 0.490 | 0.764 | 0.794 | 8.604 |
| Judicial review with delayed legislative override | 1 | 600 | 9.000 | 0.036 | 1.364 | 0.610 | 0.714 | 0.755 | 0.000 |
| Judicial review with delayed legislative override | 2 | 600 | 9.000 | 0.032 | 1.374 | 0.609 | 0.715 | 0.756 | 3.460 |
| Judicial review with delayed legislative override | 3 | 600 | 9.000 | 0.039 | 1.393 | 0.610 | 0.714 | 0.754 | 3.460 |
| Judicial review with delayed legislative override | 4 | 600 | 9.000 | 0.039 | 1.401 | 0.610 | 0.714 | 0.756 | 3.460 |
| Retention-election accountability court | 1 | 600 | 9.000 | 0.020 | 1.150 | 0.599 | 0.696 | 0.675 | 0.000 |
| Retention-election accountability court | 2 | 600 | 9.000 | 0.028 | 1.190 | 0.599 | 0.695 | 0.677 | 8.363 |
| Retention-election accountability court | 3 | 600 | 9.000 | 0.024 | 1.221 | 0.599 | 0.696 | 0.676 | 8.363 |
| Retention-election accountability court | 4 | 600 | 9.000 | 0.031 | 1.283 | 0.599 | 0.693 | 0.677 | 8.363 |
| Hybrid court balancing independence and accountability | 1 | 600 | 15.000 | -0.001 | 0.835 | 0.513 | 0.755 | 0.802 | 0.000 |
| Hybrid court balancing independence and accountability | 2 | 600 | 15.000 | -0.000 | 0.860 | 0.512 | 0.756 | 0.802 | 6.966 |
| Hybrid court balancing independence and accountability | 3 | 600 | 15.000 | -0.003 | 0.903 | 0.513 | 0.755 | 0.803 | 6.966 |
| Hybrid court balancing independence and accountability | 4 | 600 | 15.000 | -0.004 | 0.926 | 0.514 | 0.756 | 0.803 | 6.966 |

## Uncertainty Diagnostics

Campaign, pipeline, composition, and calibration CSV artifacts include 95% uncertainty bands using `conservative-bounded-normal-95`. These bands are conservative approximations from aggregate report denominators; they are not a substitute for raw per-case bootstrap resampling.

| Scenario | Median score band width | Median cost band width |
| --- | ---: | ---: |
| Current-style federal supreme court | 0.019 | 0.020 |
| Staggered 18-year nonrenewable terms | 0.019 | 0.020 |
| Fifteen-justice supermajority commission court | 0.018 | 0.020 |
| Supermajority required to invalidate laws | 0.018 | 0.020 |
| Strict recusal with substitute justices | 0.017 | 0.020 |
| Reasoned emergency orders with merits follow-up | 0.018 | 0.020 |
| Panel review with en banc safety valve | 0.018 | 0.020 |
| Dual supreme courts with cross-checking invalidations | 0.017 | 0.020 |
| Pre-enactment constitutional council | 0.017 | 0.020 |
| Judicial review with delayed legislative override | 0.018 | 0.020 |
| Retention-election accountability court | 0.018 | 0.020 |
| Hybrid court balancing independence and accountability | 0.018 | 0.020 |

## Calibration Diagnostics

| Profile | Target | Model | Empirical | 95% band | Range | Reliability | Validation | Gap | Status |
| --- | --- | ---: | ---: | ---: | ---: | --- | ---: | ---: | --- |
| canada-scc-recent | Leave application grant rate | 0.020 | 0.089 | 0.020-0.020 | 0.075-0.105 | high | true | 0.055 | outside |
| canada-scc-recent | Charter invalidation proxy | 0.196 | 0.565 | 0.195-0.197 | 0.510-0.620 | medium | true | 0.314 | outside |
| canada-scc-recent | Public trust proxy | 0.127 | 0.490 | 0.127-0.128 | 0.430-0.550 | medium | true | 0.303 | outside |
| canada-scc-recent | Normalized direct court cost | 0.365 | 0.550 | 0.364-0.367 | 0.490-0.610 | medium | true | 0.125 | outside |
| france-conseil-qpc | QPC invalidation rate | 0.196 | 0.315 | 0.195-0.197 | 0.260-0.360 | medium | true | 0.064 | outside |
| france-conseil-qpc | Public trust proxy | 0.127 | 0.500 | 0.127-0.128 | 0.430-0.570 | low | false | 0.303 | outside |
| france-conseil-qpc | Normalized direct court cost | 0.365 | 0.340 | 0.364-0.367 | 0.280-0.400 | medium | true | 0.000 | within |
| france-conseil-qpc | Normalized upstream screening cost | 0.681 | 0.590 | 0.680-0.682 | 0.520-0.660 | medium | true | 0.021 | outside |
| germany-bverfg-2024 | Constitutional complaint success and admission proxy | 0.020 | 0.009 | 0.020-0.020 | 0.006-0.012 | medium | true | 0.008 | outside |
| germany-bverfg-2024 | Public trust proxy | 0.127 | 0.740 | 0.127-0.128 | 0.680-0.800 | medium | true | 0.553 | outside |
| germany-bverfg-2024 | Normalized direct court cost | 0.365 | 0.620 | 0.364-0.367 | 0.560-0.680 | medium | true | 0.195 | outside |
| germany-bverfg-2024 | Normalized capacity strain | 0.438 | 0.560 | 0.437-0.439 | 0.500-0.640 | medium | true | 0.062 | outside |
| cost-us-supreme-court | Normalized direct court cost | 0.365 | 0.740 | 0.364-0.367 | 0.690-0.790 | medium | true | 0.325 | outside |
| cost-us-supreme-court | Normalized capacity strain | 0.438 | 0.480 | 0.437-0.439 | 0.420-0.540 | medium | true | 0.000 | within |
| cost-uk-supreme-court | Normalized direct court cost | 0.365 | 0.430 | 0.364-0.367 | 0.370-0.490 | medium | true | 0.005 | outside |
| cost-france-conseil | Normalized direct court cost | 0.365 | 0.340 | 0.364-0.367 | 0.280-0.400 | medium | true | 0.000 | within |
| south-africa-constcourt-recent | Merits invalidation proxy | 0.196 | 0.532 | 0.195-0.197 | 0.470-0.590 | medium | true | 0.274 | outside |
| south-africa-constcourt-recent | Petition-to-judgment throughput proxy | 1.000 | 0.141 | 0.999-1.000 | 0.110-0.170 | medium | true | 0.830 | outside |
| south-africa-constcourt-recent | Public trust proxy | 0.127 | 0.430 | 0.127-0.128 | 0.360-0.500 | medium | true | 0.233 | outside |
| south-africa-constcourt-recent | Normalized capacity strain | 0.438 | 0.680 | 0.437-0.439 | 0.610-0.750 | medium | true | 0.172 | outside |
| scdb-postwar-merits-1946-2024 | Speech docket share | 0.352 | 0.076 | 0.351-0.353 | 0.060-0.091 | high | true | 0.261 | outside |
| scdb-postwar-merits-1946-2024 | Civil-rights and privacy docket share | 0.159 | 0.152 | 0.158-0.160 | 0.135-0.169 | high | true | 0.000 | within |
| scdb-postwar-merits-1946-2024 | Criminal procedure docket share | 0.065 | 0.226 | 0.064-0.066 | 0.207-0.244 | high | true | 0.142 | outside |
| scdb-postwar-merits-1946-2024 | Federalism docket share | 0.085 | 0.056 | 0.085-0.086 | 0.041-0.071 | high | true | 0.014 | outside |
| scdb-postwar-merits-1946-2024 | Election-law docket share | 0.155 | 0.027 | 0.154-0.156 | 0.013-0.040 | medium | true | 0.115 | outside |
| scdb-postwar-merits-1946-2024 | Emergency-powers merits share | 0.087 | 0.006 | 0.086-0.088 | 0.000-0.012 | medium | true | 0.075 | outside |
| scdb-postwar-merits-1946-2024 | Administrative and economic regulation share | 0.097 | 0.218 | 0.096-0.098 | 0.199-0.236 | medium | true | 0.102 | outside |
| scdb-modern-merits-2000-2024 | Speech docket share | 0.352 | 0.060 | 0.351-0.353 | 0.039-0.080 | high | true | 0.272 | outside |
| scdb-modern-merits-2000-2024 | Civil-rights and privacy docket share | 0.159 | 0.164 | 0.158-0.160 | 0.137-0.191 | high | true | 0.000 | within |
| scdb-modern-merits-2000-2024 | Criminal procedure docket share | 0.065 | 0.260 | 0.064-0.066 | 0.230-0.289 | high | true | 0.165 | outside |
| scdb-modern-merits-2000-2024 | Federalism docket share | 0.085 | 0.058 | 0.085-0.086 | 0.037-0.078 | high | true | 0.007 | outside |
| scdb-modern-merits-2000-2024 | Election-law docket share | 0.155 | 0.026 | 0.154-0.156 | 0.009-0.043 | medium | true | 0.112 | outside |
| scdb-modern-merits-2000-2024 | Emergency-powers merits share | 0.087 | 0.010 | 0.086-0.088 | 0.000-0.019 | medium | true | 0.068 | outside |
| scdb-modern-merits-2000-2024 | Administrative and economic regulation share | 0.097 | 0.222 | 0.096-0.098 | 0.193-0.250 | medium | true | 0.096 | outside |
| scotus-emergency-2024-2025 | Substantive emergency application relief rate | 0.463 | 0.440 | 0.459-0.466 | 0.310-0.460 | medium | true | 0.003 | outside |
| scotus-emergency-2024-2025 | Written explanation share | 0.528 | 0.279 | 0.524-0.531 | 0.200-0.360 | medium | true | 0.168 | outside |
| scotus-emergency-2024-2025 | Public disagreement share | 0.217 | 0.670 | 0.214-0.220 | 0.570-0.760 | medium | true | 0.353 | outside |
| scotus-emergency-2024-2025 | Certiorari or emergency screening acceptance proxy | 0.020 | 0.018 | 0.020-0.020 | 0.013-0.018 | medium | true | 0.002 | outside |
| gallup-court-confidence-2024 | Public court trust and approval | 0.127 | 0.420 | 0.127-0.128 | 0.350-0.490 | medium | true | 0.223 | outside |
