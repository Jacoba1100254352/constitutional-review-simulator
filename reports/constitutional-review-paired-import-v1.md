# Constitutional Review Paired Import Campaign v1

- runs per case: 120
- seed: 20260501
- input: 986 imported legislative rows across 29 scenarios

## Top Directional Scores by Case

### Synthetic baseline

Synthetic docket using the same world assumptions as the imported comparisons.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.658
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.010
- lowest emergency relief rate: Retention-election accountability court at 0.321
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.428
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.270

### All imported legislative outputs

Docket generated from every imported legislative campaign row.

- best overall: Strict recusal with substitute justices (`strict-recusal-court`) at 0.824
- strongest rights protection: Pre-enactment constitutional council at 0.814
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.761
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.054

### High-capture legislative outputs

Imported rows with high lobby-capture or proposer-gain signals.

- best overall: Strict recusal with substitute justices (`strict-recusal-court`) at 0.798
- strongest rights protection: Pre-enactment constitutional council at 0.805
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.705
- lowest defiance rate: Pre-enactment constitutional council at 0.080

### High-volatility legislative outputs

Imported rows with high policy-shift, reversal, or status-quo volatility signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.715
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.778
- lowest shadow-docket abuse: Dual supreme courts with cross-checking invalidations at 0.000
- lowest emergency relief rate: Dual supreme courts with cross-checking invalidations at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.488
- lowest defiance rate: Pre-enactment constitutional council at 0.213

### Low-mandate legislative outputs

Imported rows with weak public mandate, low support, or public-preference distortion.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.758
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.774
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.574
- lowest defiance rate: Pre-enactment constitutional council at 0.140

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin | Budget | Delay | Complex | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.676 | 0.879 | 0.748 | 0.175 | 0.175 | 0.434 | 0.286 | 0.643 | 0.191 | 0.280 | 0.520 | 0.443 | 0.357 | 0.198 | 0.056 | 0.226 | 2.451 | 0.580 | 0.448 | 0.190 | 0.517 | 0.324 | 0.341 |
| Staggered 18-year nonrenewable terms | 0.695 | 0.890 | 0.756 | 0.160 | 0.172 | 0.366 | 0.246 | 0.655 | 0.159 | 0.271 | 0.535 | 0.461 | 0.377 | 0.186 | 0.054 | 0.243 | 2.451 | 0.580 | 0.456 | 0.203 | 0.517 | 0.327 | 0.347 |
| Fifteen-justice supermajority commission court | 0.739 | 0.933 | 0.777 | 0.135 | 0.040 | 0.129 | 0.230 | 0.736 | 0.194 | 0.229 | 0.561 | 0.533 | 0.453 | 0.155 | 0.049 | 0.301 | 2.451 | 0.580 | 0.456 | 0.382 | 0.526 | 0.387 | 0.433 |
| Supermajority required to invalidate laws | 0.731 | 0.936 | 0.776 | 0.152 | 0.041 | 0.142 | 0.226 | 0.710 | 0.193 | 0.230 | 0.558 | 0.529 | 0.441 | 0.159 | 0.049 | 0.296 | 2.451 | 0.580 | 0.436 | 0.190 | 0.526 | 0.500 | 0.398 |
| Strict recusal with substitute justices | 0.746 | 0.934 | 0.778 | 0.134 | 0.039 | 0.124 | 0.218 | 0.758 | 0.184 | 0.226 | 0.563 | 0.556 | 0.471 | 0.147 | 0.045 | 0.320 | 2.451 | 0.580 | 0.456 | 0.379 | 0.526 | 0.487 | 0.461 |
| Reasoned emergency orders with merits follow-up | 0.735 | 0.932 | 0.776 | 0.148 | 0.002 | 0.106 | 0.263 | 0.762 | 0.263 | 0.228 | 0.552 | 0.540 | 0.457 | 0.158 | 0.053 | 0.304 | 2.451 | 0.580 | 0.446 | 0.206 | 0.528 | 0.483 | 0.399 |
| Panel review with en banc safety valve | 0.730 | 0.930 | 0.777 | 0.135 | 0.039 | 0.130 | 0.238 | 0.749 | 0.202 | 0.230 | 0.559 | 0.540 | 0.458 | 0.153 | 0.047 | 0.306 | 2.451 | 0.580 | 0.574 | 0.534 | 0.656 | 0.427 | 0.543 |
| Dual supreme courts with cross-checking invalidations | 0.719 | 0.949 | 0.783 | 0.124 | 0.003 | 0.078 | 0.183 | 0.777 | 0.183 | 0.227 | 0.570 | 0.573 | 0.491 | 0.139 | 0.043 | 0.331 | 2.451 | 0.580 | 0.843 | 0.793 | 0.849 | 0.838 | 0.826 |
| Pre-enactment constitutional council | 0.743 | 0.967 | 0.779 | 0.116 | 0.037 | 0.119 | 0.170 | 0.787 | 0.143 | 0.219 | 0.571 | 0.584 | 0.502 | 0.129 | 0.042 | 0.348 | 2.451 | 0.580 | 0.709 | 0.576 | 0.706 | 0.693 | 0.656 |
| Judicial review with delayed legislative override | 0.730 | 0.922 | 0.773 | 0.144 | 0.040 | 0.148 | 0.239 | 0.725 | 0.202 | 0.244 | 0.567 | 0.506 | 0.423 | 0.166 | 0.050 | 0.278 | 2.451 | 0.580 | 0.449 | 0.207 | 0.526 | 0.565 | 0.423 |
| Retention-election accountability court | 0.750 | 0.935 | 0.768 | 0.131 | 0.037 | 0.097 | 0.153 | 0.747 | 0.128 | 0.232 | 0.582 | 0.536 | 0.453 | 0.142 | 0.044 | 0.309 | 2.451 | 0.580 | 0.469 | 0.240 | 0.526 | 0.632 | 0.455 |
| Hybrid court balancing independence and accountability | 0.736 | 0.949 | 0.781 | 0.127 | 0.002 | 0.089 | 0.208 | 0.777 | 0.208 | 0.218 | 0.565 | 0.563 | 0.478 | 0.145 | 0.049 | 0.320 | 2.451 | 0.580 | 0.562 | 0.611 | 0.647 | 0.883 | 0.705 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 1.000 | 0.755 | 0.161 | 0.229 | 2.413 | 0.560 | 0.494 | 0.556 | 0.478 | 0.131 | 0.029 | 0.355 | 0.261 | 0.666 | 0.370 | 0.336 |
| Current-style federal supreme court | 2 | 12000 | 1.000 | 0.739 | 0.183 | 0.333 | 2.443 | 0.575 | 0.505 | 0.435 | 0.338 | 0.206 | 0.061 | 0.219 | 0.024 | 0.732 | 0.695 | 0.342 |
| Current-style federal supreme court | 3 | 12000 | 1.000 | 0.746 | 0.188 | 0.298 | 2.467 | 0.586 | 0.509 | 0.395 | 0.310 | 0.224 | 0.069 | 0.171 | 0.002 | 0.754 | 0.764 | 0.343 |
| Current-style federal supreme court | 4 | 12000 | 1.000 | 0.755 | 0.170 | 0.288 | 2.482 | 0.600 | 0.510 | 0.387 | 0.302 | 0.232 | 0.066 | 0.161 | 0.001 | 0.762 | 0.788 | 0.344 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 1.000 | 0.762 | 0.159 | 0.190 | 2.413 | 0.560 | 0.494 | 0.569 | 0.492 | 0.121 | 0.027 | 0.363 | 0.281 | 0.641 | 0.339 | 0.336 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 1.000 | 0.747 | 0.180 | 0.287 | 2.443 | 0.575 | 0.505 | 0.450 | 0.366 | 0.194 | 0.056 | 0.233 | 0.031 | 0.675 | 0.633 | 0.349 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 1.000 | 0.754 | 0.181 | 0.264 | 2.467 | 0.586 | 0.509 | 0.416 | 0.323 | 0.215 | 0.066 | 0.196 | 0.003 | 0.681 | 0.696 | 0.350 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 1.000 | 0.762 | 0.168 | 0.246 | 2.482 | 0.600 | 0.510 | 0.409 | 0.327 | 0.214 | 0.067 | 0.180 | 0.002 | 0.686 | 0.712 | 0.352 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 1.000 | 0.781 | 0.038 | 0.174 | 2.413 | 0.560 | 0.494 | 0.620 | 0.541 | 0.106 | 0.025 | 0.402 | 0.351 | 0.564 | 0.266 | 0.419 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 1.000 | 0.768 | 0.041 | 0.266 | 2.443 | 0.575 | 0.505 | 0.529 | 0.452 | 0.159 | 0.055 | 0.301 | 0.083 | 0.535 | 0.501 | 0.436 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 1.000 | 0.777 | 0.040 | 0.244 | 2.467 | 0.586 | 0.509 | 0.501 | 0.412 | 0.175 | 0.057 | 0.256 | 0.030 | 0.529 | 0.576 | 0.437 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 1.000 | 0.784 | 0.039 | 0.235 | 2.482 | 0.600 | 0.510 | 0.482 | 0.407 | 0.180 | 0.059 | 0.245 | 0.013 | 0.555 | 0.589 | 0.438 |
| Supermajority required to invalidate laws | 1 | 12000 | 1.000 | 0.779 | 0.039 | 0.172 | 2.413 | 0.560 | 0.494 | 0.623 | 0.538 | 0.105 | 0.027 | 0.399 | 0.337 | 0.576 | 0.280 | 0.392 |
| Supermajority required to invalidate laws | 2 | 12000 | 1.000 | 0.767 | 0.043 | 0.262 | 2.443 | 0.575 | 0.505 | 0.525 | 0.434 | 0.162 | 0.054 | 0.294 | 0.065 | 0.566 | 0.540 | 0.398 |
| Supermajority required to invalidate laws | 3 | 12000 | 1.000 | 0.775 | 0.041 | 0.241 | 2.467 | 0.586 | 0.509 | 0.487 | 0.400 | 0.183 | 0.059 | 0.249 | 0.017 | 0.571 | 0.618 | 0.400 |
| Supermajority required to invalidate laws | 4 | 12000 | 1.000 | 0.781 | 0.041 | 0.231 | 2.482 | 0.600 | 0.510 | 0.483 | 0.390 | 0.188 | 0.058 | 0.240 | 0.005 | 0.593 | 0.629 | 0.401 |
| Strict recusal with substitute justices | 1 | 12000 | 1.000 | 0.782 | 0.037 | 0.165 | 2.413 | 0.560 | 0.494 | 0.630 | 0.559 | 0.098 | 0.023 | 0.407 | 0.372 | 0.545 | 0.247 | 0.448 |
| Strict recusal with substitute justices | 2 | 12000 | 1.000 | 0.769 | 0.041 | 0.251 | 2.443 | 0.575 | 0.505 | 0.549 | 0.465 | 0.148 | 0.050 | 0.323 | 0.113 | 0.489 | 0.452 | 0.465 |
| Strict recusal with substitute justices | 3 | 12000 | 1.000 | 0.777 | 0.039 | 0.235 | 2.467 | 0.586 | 0.509 | 0.527 | 0.435 | 0.169 | 0.053 | 0.280 | 0.057 | 0.480 | 0.532 | 0.466 |
| Strict recusal with substitute justices | 4 | 12000 | 1.000 | 0.784 | 0.038 | 0.222 | 2.482 | 0.600 | 0.510 | 0.518 | 0.427 | 0.172 | 0.052 | 0.269 | 0.031 | 0.515 | 0.557 | 0.467 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 1.000 | 0.780 | 0.002 | 0.209 | 2.413 | 0.560 | 0.494 | 0.636 | 0.553 | 0.099 | 0.028 | 0.416 | 0.354 | 0.567 | 0.280 | 0.388 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 1.000 | 0.767 | 0.002 | 0.298 | 2.443 | 0.575 | 0.505 | 0.532 | 0.451 | 0.163 | 0.057 | 0.304 | 0.091 | 0.567 | 0.544 | 0.401 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 1.000 | 0.775 | 0.002 | 0.280 | 2.467 | 0.586 | 0.509 | 0.499 | 0.417 | 0.184 | 0.060 | 0.254 | 0.036 | 0.585 | 0.623 | 0.403 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 1.000 | 0.782 | 0.002 | 0.264 | 2.482 | 0.600 | 0.510 | 0.492 | 0.407 | 0.187 | 0.066 | 0.241 | 0.019 | 0.603 | 0.631 | 0.404 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.781 | 0.037 | 0.183 | 2.413 | 0.560 | 0.494 | 0.628 | 0.550 | 0.097 | 0.024 | 0.409 | 0.362 | 0.557 | 0.260 | 0.527 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.768 | 0.041 | 0.276 | 2.443 | 0.575 | 0.505 | 0.533 | 0.459 | 0.154 | 0.052 | 0.306 | 0.099 | 0.527 | 0.494 | 0.547 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.776 | 0.040 | 0.253 | 2.467 | 0.586 | 0.509 | 0.504 | 0.415 | 0.176 | 0.055 | 0.265 | 0.042 | 0.527 | 0.578 | 0.549 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.783 | 0.039 | 0.239 | 2.482 | 0.600 | 0.510 | 0.496 | 0.406 | 0.185 | 0.057 | 0.244 | 0.019 | 0.557 | 0.594 | 0.551 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.786 | 0.003 | 0.134 | 2.413 | 0.560 | 0.494 | 0.648 | 0.577 | 0.091 | 0.021 | 0.423 | 0.387 | 0.529 | 0.225 | 0.812 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.774 | 0.003 | 0.213 | 2.443 | 0.575 | 0.505 | 0.577 | 0.492 | 0.135 | 0.045 | 0.341 | 0.121 | 0.461 | 0.417 | 0.829 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.782 | 0.003 | 0.198 | 2.467 | 0.586 | 0.509 | 0.541 | 0.454 | 0.157 | 0.051 | 0.287 | 0.065 | 0.461 | 0.514 | 0.831 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.789 | 0.003 | 0.189 | 2.482 | 0.600 | 0.510 | 0.526 | 0.440 | 0.172 | 0.055 | 0.272 | 0.041 | 0.505 | 0.546 | 0.832 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.783 | 0.035 | 0.124 | 2.413 | 0.560 | 0.494 | 0.642 | 0.571 | 0.093 | 0.023 | 0.421 | 0.408 | 0.511 | 0.210 | 0.636 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.770 | 0.039 | 0.195 | 2.443 | 0.575 | 0.505 | 0.586 | 0.502 | 0.130 | 0.042 | 0.356 | 0.165 | 0.394 | 0.340 | 0.661 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.778 | 0.038 | 0.181 | 2.467 | 0.586 | 0.509 | 0.558 | 0.475 | 0.139 | 0.050 | 0.315 | 0.113 | 0.363 | 0.384 | 0.662 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.786 | 0.037 | 0.179 | 2.482 | 0.600 | 0.510 | 0.550 | 0.458 | 0.153 | 0.054 | 0.300 | 0.089 | 0.396 | 0.426 | 0.663 |
| Judicial review with delayed legislative override | 1 | 12000 | 1.000 | 0.778 | 0.038 | 0.183 | 2.413 | 0.560 | 0.494 | 0.609 | 0.523 | 0.113 | 0.026 | 0.397 | 0.326 | 0.583 | 0.282 | 0.412 |
| Judicial review with delayed legislative override | 2 | 12000 | 1.000 | 0.762 | 0.044 | 0.277 | 2.443 | 0.575 | 0.505 | 0.497 | 0.417 | 0.166 | 0.052 | 0.265 | 0.066 | 0.596 | 0.552 | 0.425 |
| Judicial review with delayed legislative override | 3 | 12000 | 1.000 | 0.772 | 0.040 | 0.256 | 2.467 | 0.586 | 0.509 | 0.469 | 0.377 | 0.194 | 0.059 | 0.233 | 0.020 | 0.612 | 0.637 | 0.427 |
| Judicial review with delayed legislative override | 4 | 12000 | 1.000 | 0.779 | 0.040 | 0.243 | 2.482 | 0.600 | 0.510 | 0.449 | 0.375 | 0.193 | 0.061 | 0.219 | 0.008 | 0.628 | 0.650 | 0.428 |
| Retention-election accountability court | 1 | 12000 | 1.000 | 0.775 | 0.035 | 0.116 | 2.413 | 0.560 | 0.494 | 0.612 | 0.536 | 0.099 | 0.021 | 0.400 | 0.358 | 0.540 | 0.226 | 0.430 |
| Retention-election accountability court | 2 | 12000 | 1.000 | 0.757 | 0.040 | 0.168 | 2.443 | 0.575 | 0.505 | 0.535 | 0.450 | 0.139 | 0.046 | 0.304 | 0.087 | 0.471 | 0.397 | 0.462 |
| Retention-election accountability court | 3 | 12000 | 1.000 | 0.767 | 0.037 | 0.163 | 2.467 | 0.586 | 0.509 | 0.506 | 0.418 | 0.164 | 0.053 | 0.277 | 0.038 | 0.445 | 0.459 | 0.463 |
| Retention-election accountability court | 4 | 12000 | 1.000 | 0.773 | 0.036 | 0.165 | 2.482 | 0.600 | 0.510 | 0.491 | 0.405 | 0.167 | 0.054 | 0.254 | 0.022 | 0.483 | 0.495 | 0.464 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.785 | 0.002 | 0.159 | 2.413 | 0.560 | 0.494 | 0.637 | 0.566 | 0.100 | 0.026 | 0.416 | 0.380 | 0.534 | 0.244 | 0.687 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.772 | 0.002 | 0.239 | 2.443 | 0.575 | 0.505 | 0.559 | 0.472 | 0.145 | 0.050 | 0.322 | 0.117 | 0.474 | 0.454 | 0.708 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.780 | 0.002 | 0.222 | 2.467 | 0.586 | 0.509 | 0.536 | 0.437 | 0.170 | 0.058 | 0.283 | 0.061 | 0.478 | 0.544 | 0.711 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.788 | 0.002 | 0.211 | 2.482 | 0.600 | 0.510 | 0.521 | 0.436 | 0.167 | 0.060 | 0.260 | 0.040 | 0.517 | 0.569 | 0.713 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 5307 | 1.000 | 0.830 | 0.162 | 0.023 | 2.689 | 0.470 | 0.505 | 0.468 | 0.385 | 0.250 | 0.045 | 0.282 | 0.097 | 0.731 | 0.655 | 0.353 |
| Current-style federal supreme court | criminal_procedure | 3498 | 1.000 | 0.731 | 0.270 | 0.258 | 2.354 | 0.574 | 0.493 | 0.414 | 0.341 | 0.206 | 0.058 | 0.210 | 0.089 | 0.760 | 0.679 | 0.336 |
| Current-style federal supreme court | election_law | 7248 | 1.000 | 0.747 | 0.149 | 0.210 | 2.536 | 0.674 | 0.516 | 0.434 | 0.351 | 0.194 | 0.050 | 0.190 | 0.059 | 0.722 | 0.683 | 0.346 |
| Current-style federal supreme court | emergency_powers | 4335 | 1.000 | 0.759 | 0.383 | 0.138 | 2.138 | 0.538 | 0.495 | 0.423 | 0.343 | 0.193 | 0.051 | 0.223 | 0.076 | 0.725 | 0.655 | 0.326 |
| Current-style federal supreme court | equality | 8126 | 1.000 | 0.708 | 0.162 | 0.626 | 2.458 | 0.589 | 0.509 | 0.412 | 0.318 | 0.212 | 0.069 | 0.196 | 0.064 | 0.757 | 0.678 | 0.341 |
| Current-style federal supreme court | federalism | 4682 | 1.000 | 0.829 | 0.187 | 0.042 | 2.662 | 0.812 | 0.592 | 0.431 | 0.368 | 0.188 | 0.052 | 0.166 | 0.097 | 0.749 | 0.667 | 0.357 |
| Current-style federal supreme court | speech | 14804 | 1.000 | 0.718 | 0.114 | 0.349 | 2.369 | 0.509 | 0.474 | 0.472 | 0.376 | 0.176 | 0.059 | 0.264 | 0.061 | 0.701 | 0.616 | 0.336 |
| Staggered 18-year nonrenewable terms | administrative_state | 5307 | 1.000 | 0.833 | 0.161 | 0.012 | 2.689 | 0.470 | 0.505 | 0.479 | 0.400 | 0.243 | 0.049 | 0.294 | 0.105 | 0.684 | 0.608 | 0.358 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 3498 | 1.000 | 0.738 | 0.262 | 0.242 | 2.354 | 0.574 | 0.493 | 0.439 | 0.354 | 0.192 | 0.056 | 0.224 | 0.092 | 0.713 | 0.630 | 0.342 |
| Staggered 18-year nonrenewable terms | election_law | 7248 | 1.000 | 0.758 | 0.146 | 0.165 | 2.536 | 0.674 | 0.516 | 0.456 | 0.356 | 0.174 | 0.056 | 0.208 | 0.066 | 0.653 | 0.616 | 0.352 |
| Staggered 18-year nonrenewable terms | emergency_powers | 4335 | 1.000 | 0.768 | 0.383 | 0.107 | 2.138 | 0.538 | 0.495 | 0.446 | 0.370 | 0.185 | 0.048 | 0.254 | 0.080 | 0.670 | 0.595 | 0.331 |
| Staggered 18-year nonrenewable terms | equality | 8126 | 1.000 | 0.717 | 0.153 | 0.568 | 2.458 | 0.589 | 0.509 | 0.432 | 0.350 | 0.202 | 0.062 | 0.218 | 0.071 | 0.699 | 0.620 | 0.347 |
| Staggered 18-year nonrenewable terms | federalism | 4682 | 1.000 | 0.834 | 0.184 | 0.023 | 2.662 | 0.812 | 0.592 | 0.451 | 0.377 | 0.174 | 0.048 | 0.161 | 0.103 | 0.699 | 0.618 | 0.362 |
| Staggered 18-year nonrenewable terms | speech | 14804 | 1.000 | 0.725 | 0.112 | 0.285 | 2.369 | 0.509 | 0.474 | 0.485 | 0.402 | 0.165 | 0.053 | 0.282 | 0.070 | 0.640 | 0.550 | 0.341 |
| Fifteen-justice supermajority commission court | administrative_state | 5307 | 1.000 | 0.841 | 0.040 | 0.008 | 2.689 | 0.470 | 0.505 | 0.540 | 0.471 | 0.211 | 0.041 | 0.357 | 0.143 | 0.558 | 0.505 | 0.444 |
| Fifteen-justice supermajority commission court | criminal_procedure | 3498 | 1.000 | 0.764 | 0.078 | 0.227 | 2.354 | 0.574 | 0.493 | 0.516 | 0.432 | 0.168 | 0.053 | 0.280 | 0.125 | 0.610 | 0.537 | 0.428 |
| Fifteen-justice supermajority commission court | election_law | 7248 | 1.000 | 0.786 | 0.030 | 0.141 | 2.536 | 0.674 | 0.516 | 0.529 | 0.441 | 0.144 | 0.046 | 0.270 | 0.098 | 0.523 | 0.497 | 0.437 |
| Fifteen-justice supermajority commission court | emergency_powers | 4335 | 1.000 | 0.799 | 0.102 | 0.130 | 2.138 | 0.538 | 0.495 | 0.534 | 0.470 | 0.148 | 0.045 | 0.322 | 0.116 | 0.553 | 0.487 | 0.418 |
| Fifteen-justice supermajority commission court | equality | 8126 | 1.000 | 0.742 | 0.033 | 0.539 | 2.458 | 0.589 | 0.509 | 0.503 | 0.421 | 0.161 | 0.064 | 0.274 | 0.112 | 0.571 | 0.507 | 0.433 |
| Fifteen-justice supermajority commission court | federalism | 4682 | 1.000 | 0.848 | 0.048 | 0.013 | 2.662 | 0.812 | 0.592 | 0.514 | 0.456 | 0.151 | 0.049 | 0.215 | 0.137 | 0.579 | 0.511 | 0.448 |
| Fifteen-justice supermajority commission court | speech | 14804 | 1.000 | 0.744 | 0.018 | 0.263 | 2.369 | 0.509 | 0.474 | 0.560 | 0.470 | 0.138 | 0.045 | 0.337 | 0.120 | 0.511 | 0.433 | 0.427 |
| Supermajority required to invalidate laws | administrative_state | 5307 | 1.000 | 0.840 | 0.040 | 0.008 | 2.689 | 0.470 | 0.505 | 0.548 | 0.453 | 0.213 | 0.039 | 0.338 | 0.132 | 0.589 | 0.537 | 0.409 |
| Supermajority required to invalidate laws | criminal_procedure | 3498 | 1.000 | 0.762 | 0.083 | 0.219 | 2.354 | 0.574 | 0.493 | 0.503 | 0.426 | 0.159 | 0.050 | 0.274 | 0.113 | 0.634 | 0.563 | 0.393 |
| Supermajority required to invalidate laws | election_law | 7248 | 1.000 | 0.782 | 0.030 | 0.146 | 2.536 | 0.674 | 0.516 | 0.519 | 0.437 | 0.145 | 0.049 | 0.258 | 0.086 | 0.554 | 0.533 | 0.402 |
| Supermajority required to invalidate laws | emergency_powers | 4335 | 1.000 | 0.796 | 0.107 | 0.125 | 2.138 | 0.538 | 0.495 | 0.541 | 0.449 | 0.154 | 0.042 | 0.322 | 0.102 | 0.578 | 0.518 | 0.383 |
| Supermajority required to invalidate laws | equality | 8126 | 1.000 | 0.741 | 0.033 | 0.533 | 2.458 | 0.589 | 0.509 | 0.494 | 0.405 | 0.176 | 0.064 | 0.262 | 0.098 | 0.605 | 0.544 | 0.397 |
| Supermajority required to invalidate laws | federalism | 4682 | 1.000 | 0.846 | 0.049 | 0.014 | 2.662 | 0.812 | 0.592 | 0.514 | 0.433 | 0.151 | 0.048 | 0.218 | 0.127 | 0.610 | 0.544 | 0.413 |
| Supermajority required to invalidate laws | speech | 14804 | 1.000 | 0.743 | 0.019 | 0.258 | 2.369 | 0.509 | 0.474 | 0.555 | 0.461 | 0.143 | 0.048 | 0.339 | 0.103 | 0.543 | 0.466 | 0.392 |
| Strict recusal with substitute justices | administrative_state | 5307 | 1.000 | 0.841 | 0.040 | 0.005 | 2.689 | 0.470 | 0.505 | 0.566 | 0.489 | 0.193 | 0.032 | 0.375 | 0.163 | 0.519 | 0.470 | 0.473 |
| Strict recusal with substitute justices | criminal_procedure | 3498 | 1.000 | 0.765 | 0.077 | 0.218 | 2.354 | 0.574 | 0.493 | 0.535 | 0.452 | 0.143 | 0.043 | 0.294 | 0.141 | 0.578 | 0.507 | 0.457 |
| Strict recusal with substitute justices | election_law | 7248 | 1.000 | 0.786 | 0.029 | 0.130 | 2.536 | 0.674 | 0.516 | 0.553 | 0.467 | 0.140 | 0.046 | 0.292 | 0.119 | 0.484 | 0.459 | 0.466 |
| Strict recusal with substitute justices | emergency_powers | 4335 | 1.000 | 0.799 | 0.102 | 0.122 | 2.138 | 0.538 | 0.495 | 0.560 | 0.478 | 0.142 | 0.042 | 0.342 | 0.141 | 0.519 | 0.450 | 0.447 |
| Strict recusal with substitute justices | equality | 8126 | 1.000 | 0.744 | 0.032 | 0.520 | 2.458 | 0.589 | 0.509 | 0.529 | 0.440 | 0.162 | 0.058 | 0.292 | 0.134 | 0.530 | 0.471 | 0.461 |
| Strict recusal with substitute justices | federalism | 4682 | 1.000 | 0.848 | 0.046 | 0.011 | 2.662 | 0.812 | 0.592 | 0.531 | 0.460 | 0.149 | 0.043 | 0.236 | 0.155 | 0.543 | 0.478 | 0.476 |
| Strict recusal with substitute justices | speech | 14804 | 1.000 | 0.745 | 0.017 | 0.246 | 2.369 | 0.509 | 0.474 | 0.581 | 0.490 | 0.127 | 0.042 | 0.355 | 0.150 | 0.470 | 0.395 | 0.456 |
| Reasoned emergency orders with merits follow-up | administrative_state | 5307 | 1.000 | 0.841 | 0.000 | 0.014 | 2.689 | 0.470 | 0.505 | 0.557 | 0.489 | 0.199 | 0.036 | 0.347 | 0.151 | 0.587 | 0.537 | 0.410 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 3498 | 1.000 | 0.773 | 0.003 | 0.254 | 2.354 | 0.574 | 0.493 | 0.537 | 0.451 | 0.156 | 0.053 | 0.282 | 0.134 | 0.633 | 0.567 | 0.394 |
| Reasoned emergency orders with merits follow-up | election_law | 7248 | 1.000 | 0.780 | 0.003 | 0.186 | 2.536 | 0.674 | 0.516 | 0.537 | 0.444 | 0.150 | 0.052 | 0.267 | 0.103 | 0.563 | 0.538 | 0.403 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 4335 | 1.000 | 0.800 | 0.009 | 0.124 | 2.138 | 0.538 | 0.495 | 0.555 | 0.472 | 0.149 | 0.049 | 0.340 | 0.124 | 0.577 | 0.519 | 0.385 |
| Reasoned emergency orders with merits follow-up | equality | 8126 | 1.000 | 0.741 | 0.002 | 0.594 | 2.458 | 0.589 | 0.509 | 0.509 | 0.417 | 0.183 | 0.066 | 0.274 | 0.113 | 0.613 | 0.547 | 0.399 |
| Reasoned emergency orders with merits follow-up | federalism | 4682 | 1.000 | 0.847 | 0.000 | 0.022 | 2.662 | 0.812 | 0.592 | 0.523 | 0.456 | 0.150 | 0.051 | 0.222 | 0.141 | 0.610 | 0.545 | 0.414 |
| Reasoned emergency orders with merits follow-up | speech | 14804 | 1.000 | 0.741 | 0.001 | 0.327 | 2.369 | 0.509 | 0.474 | 0.553 | 0.471 | 0.139 | 0.053 | 0.343 | 0.126 | 0.549 | 0.470 | 0.393 |
| Panel review with en banc safety valve | administrative_state | 5307 | 1.000 | 0.841 | 0.040 | 0.006 | 2.689 | 0.470 | 0.505 | 0.552 | 0.485 | 0.192 | 0.040 | 0.360 | 0.154 | 0.554 | 0.504 | 0.544 |
| Panel review with en banc safety valve | criminal_procedure | 3498 | 1.000 | 0.763 | 0.079 | 0.242 | 2.354 | 0.574 | 0.493 | 0.513 | 0.445 | 0.149 | 0.048 | 0.290 | 0.132 | 0.607 | 0.536 | 0.530 |
| Panel review with en banc safety valve | election_law | 7248 | 1.000 | 0.786 | 0.029 | 0.138 | 2.536 | 0.674 | 0.516 | 0.539 | 0.451 | 0.146 | 0.051 | 0.276 | 0.107 | 0.520 | 0.497 | 0.560 |
| Panel review with en banc safety valve | emergency_powers | 4335 | 1.000 | 0.799 | 0.102 | 0.133 | 2.138 | 0.538 | 0.495 | 0.541 | 0.454 | 0.146 | 0.044 | 0.341 | 0.128 | 0.548 | 0.482 | 0.538 |
| Panel review with en banc safety valve | equality | 8126 | 1.000 | 0.741 | 0.032 | 0.549 | 2.458 | 0.589 | 0.509 | 0.512 | 0.417 | 0.174 | 0.057 | 0.268 | 0.120 | 0.568 | 0.508 | 0.556 |
| Panel review with en banc safety valve | federalism | 4682 | 1.000 | 0.848 | 0.046 | 0.009 | 2.662 | 0.812 | 0.592 | 0.528 | 0.447 | 0.151 | 0.042 | 0.228 | 0.147 | 0.576 | 0.511 | 0.575 |
| Panel review with en banc safety valve | speech | 14804 | 1.000 | 0.743 | 0.018 | 0.282 | 2.369 | 0.509 | 0.474 | 0.562 | 0.480 | 0.134 | 0.044 | 0.342 | 0.134 | 0.507 | 0.430 | 0.522 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 5307 | 1.000 | 0.841 | 0.001 | 0.002 | 2.689 | 0.470 | 0.505 | 0.593 | 0.507 | 0.180 | 0.033 | 0.389 | 0.176 | 0.492 | 0.442 | 0.837 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 3498 | 1.000 | 0.777 | 0.004 | 0.189 | 2.354 | 0.574 | 0.493 | 0.554 | 0.479 | 0.139 | 0.047 | 0.312 | 0.151 | 0.553 | 0.483 | 0.822 |
| Dual supreme courts with cross-checking invalidations | election_law | 7248 | 1.000 | 0.793 | 0.003 | 0.102 | 2.536 | 0.674 | 0.516 | 0.564 | 0.485 | 0.131 | 0.047 | 0.291 | 0.130 | 0.468 | 0.439 | 0.831 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 4335 | 1.000 | 0.802 | 0.012 | 0.063 | 2.138 | 0.538 | 0.495 | 0.595 | 0.506 | 0.134 | 0.039 | 0.358 | 0.154 | 0.498 | 0.434 | 0.812 |
| Dual supreme courts with cross-checking invalidations | equality | 8126 | 1.000 | 0.751 | 0.003 | 0.482 | 2.458 | 0.589 | 0.509 | 0.547 | 0.459 | 0.156 | 0.054 | 0.299 | 0.142 | 0.514 | 0.449 | 0.826 |
| Dual supreme courts with cross-checking invalidations | federalism | 4682 | 1.000 | 0.849 | 0.000 | 0.003 | 2.662 | 0.812 | 0.592 | 0.556 | 0.484 | 0.132 | 0.038 | 0.260 | 0.167 | 0.516 | 0.452 | 0.841 |
| Dual supreme courts with cross-checking invalidations | speech | 14804 | 1.000 | 0.749 | 0.001 | 0.215 | 2.369 | 0.509 | 0.474 | 0.587 | 0.505 | 0.121 | 0.040 | 0.365 | 0.159 | 0.459 | 0.375 | 0.820 |
| Pre-enactment constitutional council | administrative_state | 5307 | 1.000 | 0.841 | 0.038 | 0.001 | 2.689 | 0.470 | 0.505 | 0.598 | 0.518 | 0.180 | 0.040 | 0.402 | 0.204 | 0.426 | 0.354 | 0.667 |
| Pre-enactment constitutional council | criminal_procedure | 3498 | 1.000 | 0.766 | 0.077 | 0.173 | 2.354 | 0.574 | 0.493 | 0.553 | 0.474 | 0.126 | 0.047 | 0.315 | 0.183 | 0.507 | 0.420 | 0.650 |
| Pre-enactment constitutional council | election_law | 7248 | 1.000 | 0.789 | 0.028 | 0.091 | 2.536 | 0.674 | 0.516 | 0.578 | 0.496 | 0.116 | 0.044 | 0.321 | 0.174 | 0.385 | 0.340 | 0.661 |
| Pre-enactment constitutional council | emergency_powers | 4335 | 1.000 | 0.798 | 0.098 | 0.066 | 2.138 | 0.538 | 0.495 | 0.578 | 0.498 | 0.130 | 0.042 | 0.365 | 0.194 | 0.450 | 0.370 | 0.641 |
| Pre-enactment constitutional council | equality | 8126 | 1.000 | 0.748 | 0.031 | 0.454 | 2.458 | 0.589 | 0.509 | 0.564 | 0.476 | 0.142 | 0.051 | 0.315 | 0.179 | 0.427 | 0.351 | 0.656 |
| Pre-enactment constitutional council | federalism | 4682 | 1.000 | 0.848 | 0.044 | 0.003 | 2.662 | 0.812 | 0.592 | 0.571 | 0.487 | 0.123 | 0.041 | 0.260 | 0.196 | 0.458 | 0.374 | 0.670 |
| Pre-enactment constitutional council | speech | 14804 | 1.000 | 0.745 | 0.017 | 0.179 | 2.369 | 0.509 | 0.474 | 0.606 | 0.525 | 0.112 | 0.037 | 0.391 | 0.210 | 0.377 | 0.290 | 0.650 |
| Judicial review with delayed legislative override | administrative_state | 5307 | 1.000 | 0.840 | 0.042 | 0.010 | 2.689 | 0.470 | 0.505 | 0.529 | 0.445 | 0.219 | 0.040 | 0.331 | 0.132 | 0.615 | 0.549 | 0.434 |
| Judicial review with delayed legislative override | criminal_procedure | 3498 | 1.000 | 0.763 | 0.076 | 0.232 | 2.354 | 0.574 | 0.493 | 0.492 | 0.421 | 0.158 | 0.048 | 0.263 | 0.116 | 0.656 | 0.576 | 0.418 |
| Judicial review with delayed legislative override | election_law | 7248 | 1.000 | 0.782 | 0.031 | 0.153 | 2.536 | 0.674 | 0.516 | 0.507 | 0.416 | 0.156 | 0.049 | 0.237 | 0.086 | 0.588 | 0.553 | 0.428 |
| Judicial review with delayed legislative override | emergency_powers | 4335 | 1.000 | 0.797 | 0.103 | 0.145 | 2.138 | 0.538 | 0.495 | 0.517 | 0.430 | 0.171 | 0.048 | 0.308 | 0.104 | 0.602 | 0.529 | 0.408 |
| Judicial review with delayed legislative override | equality | 8126 | 1.000 | 0.735 | 0.033 | 0.547 | 2.458 | 0.589 | 0.509 | 0.475 | 0.390 | 0.181 | 0.062 | 0.249 | 0.096 | 0.636 | 0.558 | 0.423 |
| Judicial review with delayed legislative override | federalism | 4682 | 1.000 | 0.846 | 0.049 | 0.018 | 2.662 | 0.812 | 0.592 | 0.490 | 0.412 | 0.158 | 0.049 | 0.203 | 0.125 | 0.635 | 0.557 | 0.438 |
| Judicial review with delayed legislative override | speech | 14804 | 1.000 | 0.738 | 0.018 | 0.275 | 2.369 | 0.509 | 0.474 | 0.520 | 0.439 | 0.147 | 0.047 | 0.315 | 0.101 | 0.572 | 0.479 | 0.417 |
| Retention-election accountability court | administrative_state | 5307 | 1.000 | 0.841 | 0.040 | 0.003 | 2.689 | 0.470 | 0.505 | 0.568 | 0.457 | 0.197 | 0.036 | 0.355 | 0.154 | 0.492 | 0.412 | 0.466 |
| Retention-election accountability court | criminal_procedure | 3498 | 1.000 | 0.765 | 0.075 | 0.163 | 2.354 | 0.574 | 0.493 | 0.512 | 0.458 | 0.139 | 0.046 | 0.291 | 0.131 | 0.555 | 0.459 | 0.449 |
| Retention-election accountability court | election_law | 7248 | 1.000 | 0.789 | 0.028 | 0.088 | 2.536 | 0.674 | 0.516 | 0.541 | 0.458 | 0.127 | 0.045 | 0.289 | 0.109 | 0.452 | 0.395 | 0.461 |
| Retention-election accountability court | emergency_powers | 4335 | 1.000 | 0.800 | 0.093 | 0.061 | 2.138 | 0.538 | 0.495 | 0.557 | 0.462 | 0.137 | 0.039 | 0.329 | 0.126 | 0.498 | 0.407 | 0.441 |
| Retention-election accountability court | equality | 8126 | 1.000 | 0.707 | 0.030 | 0.429 | 2.458 | 0.589 | 0.509 | 0.484 | 0.399 | 0.162 | 0.056 | 0.275 | 0.116 | 0.508 | 0.414 | 0.455 |
| Retention-election accountability court | federalism | 4682 | 1.000 | 0.849 | 0.046 | 0.004 | 2.662 | 0.812 | 0.592 | 0.523 | 0.444 | 0.150 | 0.043 | 0.237 | 0.148 | 0.516 | 0.424 | 0.469 |
| Retention-election accountability court | speech | 14804 | 1.000 | 0.730 | 0.016 | 0.145 | 2.369 | 0.509 | 0.474 | 0.554 | 0.477 | 0.120 | 0.040 | 0.341 | 0.123 | 0.456 | 0.348 | 0.449 |
| Hybrid court balancing independence and accountability | administrative_state | 5307 | 1.000 | 0.841 | 0.000 | 0.003 | 2.689 | 0.470 | 0.505 | 0.568 | 0.506 | 0.184 | 0.042 | 0.363 | 0.170 | 0.505 | 0.470 | 0.712 |
| Hybrid court balancing independence and accountability | criminal_procedure | 3498 | 1.000 | 0.776 | 0.003 | 0.210 | 2.354 | 0.574 | 0.493 | 0.555 | 0.460 | 0.152 | 0.048 | 0.307 | 0.148 | 0.561 | 0.508 | 0.694 |
| Hybrid court balancing independence and accountability | election_law | 7248 | 1.000 | 0.792 | 0.002 | 0.106 | 2.536 | 0.674 | 0.516 | 0.554 | 0.474 | 0.135 | 0.054 | 0.294 | 0.127 | 0.478 | 0.465 | 0.725 |
| Hybrid court balancing independence and accountability | emergency_powers | 4335 | 1.000 | 0.801 | 0.008 | 0.073 | 2.138 | 0.538 | 0.495 | 0.573 | 0.498 | 0.138 | 0.043 | 0.360 | 0.151 | 0.509 | 0.460 | 0.706 |
| Hybrid court balancing independence and accountability | equality | 8126 | 1.000 | 0.748 | 0.002 | 0.523 | 2.458 | 0.589 | 0.509 | 0.533 | 0.445 | 0.167 | 0.058 | 0.284 | 0.137 | 0.527 | 0.477 | 0.715 |
| Hybrid court balancing independence and accountability | federalism | 4682 | 1.000 | 0.849 | 0.000 | 0.005 | 2.662 | 0.812 | 0.592 | 0.549 | 0.474 | 0.133 | 0.045 | 0.233 | 0.162 | 0.529 | 0.480 | 0.743 |
| Hybrid court balancing independence and accountability | speech | 14804 | 1.000 | 0.746 | 0.001 | 0.261 | 2.369 | 0.509 | 0.474 | 0.586 | 0.486 | 0.129 | 0.046 | 0.357 | 0.155 | 0.471 | 0.403 | 0.677 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 3975 | 1.000 | 0.784 | 0.171 | 0.119 | 3.000 | 0.390 | 0.473 | 0.473 | 0.390 | 0.204 | 0.047 | 0.326 | 0.093 | 0.712 | 0.631 | 0.357 |
| Current-style federal supreme court | federal/circuit_panel | 9755 | 1.000 | 0.761 | 0.175 | 0.138 | 2.000 | 0.404 | 0.434 | 0.486 | 0.392 | 0.175 | 0.046 | 0.332 | 0.085 | 0.691 | 0.611 | 0.323 |
| Current-style federal supreme court | federal/district_only | 2433 | 1.000 | 0.751 | 0.225 | 0.153 | 1.000 | 0.415 | 0.411 | 0.499 | 0.397 | 0.169 | 0.048 | 0.344 | 0.078 | 0.692 | 0.611 | 0.287 |
| Current-style federal supreme court | federal/state_federal_split | 81 | 1.000 | 0.585 | 0.661 | 0.667 | 3.000 | 0.515 | 0.523 | 0.247 | 0.148 | 0.259 | 0.086 | 0.148 | 0.009 | 0.977 | 0.909 | 0.353 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.744 | 0.161 | 0.392 | 3.000 | 0.770 | 0.563 | 0.402 | 0.330 | 0.217 | 0.065 | 0.137 | 0.065 | 0.751 | 0.679 | 0.359 |
| Current-style federal supreme court | mixed_state_federal/district_only | 188 | 1.000 | 0.681 | 0.723 | 0.409 | 1.000 | 0.753 | 0.532 | 0.271 | 0.207 | 0.277 | 0.053 | 0.074 | 0.006 | 0.856 | 0.832 | 0.279 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.738 | 0.154 | 0.435 | 3.000 | 0.773 | 0.583 | 0.414 | 0.325 | 0.214 | 0.068 | 0.147 | 0.064 | 0.748 | 0.677 | 0.363 |
| Current-style federal supreme court | state/circuit_en_banc | 78 | 1.000 | 0.719 | 0.564 | 0.000 | 3.000 | 0.505 | 0.549 | 0.410 | 0.231 | 0.397 | 0.038 | 0.077 | 0.009 | 0.981 | 0.924 | 0.359 |
| Current-style federal supreme court | state/circuit_panel | 2853 | 1.000 | 0.750 | 0.172 | 0.252 | 2.000 | 0.567 | 0.477 | 0.431 | 0.372 | 0.186 | 0.050 | 0.207 | 0.068 | 0.735 | 0.667 | 0.325 |
| Current-style federal supreme court | state/district_only | 155 | 1.000 | 0.695 | 0.734 | 0.269 | 1.000 | 0.549 | 0.490 | 0.348 | 0.265 | 0.245 | 0.065 | 0.155 | 0.029 | 0.882 | 0.815 | 0.279 |
| Current-style federal supreme court | state/state_federal_split | 4433 | 1.000 | 0.726 | 0.196 | 0.378 | 3.000 | 0.572 | 0.528 | 0.427 | 0.339 | 0.198 | 0.056 | 0.192 | 0.064 | 0.746 | 0.673 | 0.359 |
| Current-style federal supreme court | state/state_high_court | 8181 | 1.000 | 0.748 | 0.160 | 0.274 | 2.000 | 0.566 | 0.486 | 0.443 | 0.361 | 0.196 | 0.057 | 0.207 | 0.070 | 0.728 | 0.657 | 0.330 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 3975 | 1.000 | 0.788 | 0.172 | 0.102 | 3.000 | 0.390 | 0.473 | 0.491 | 0.410 | 0.203 | 0.048 | 0.342 | 0.101 | 0.663 | 0.582 | 0.362 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 9755 | 1.000 | 0.767 | 0.171 | 0.103 | 2.000 | 0.404 | 0.434 | 0.505 | 0.411 | 0.162 | 0.046 | 0.351 | 0.092 | 0.637 | 0.552 | 0.329 |
| Staggered 18-year nonrenewable terms | federal/district_only | 2433 | 1.000 | 0.756 | 0.223 | 0.111 | 1.000 | 0.415 | 0.411 | 0.505 | 0.412 | 0.170 | 0.045 | 0.350 | 0.085 | 0.635 | 0.549 | 0.292 |
| Staggered 18-year nonrenewable terms | federal/state_federal_split | 81 | 1.000 | 0.586 | 0.711 | 0.500 | 3.000 | 0.515 | 0.523 | 0.272 | 0.148 | 0.321 | 0.062 | 0.160 | 0.008 | 0.976 | 0.907 | 0.357 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.753 | 0.156 | 0.348 | 3.000 | 0.770 | 0.563 | 0.429 | 0.352 | 0.210 | 0.060 | 0.166 | 0.072 | 0.691 | 0.619 | 0.365 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/district_only | 188 | 1.000 | 0.700 | 0.724 | 0.409 | 1.000 | 0.753 | 0.532 | 0.351 | 0.229 | 0.282 | 0.074 | 0.090 | 0.006 | 0.814 | 0.777 | 0.285 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.749 | 0.149 | 0.381 | 3.000 | 0.773 | 0.583 | 0.426 | 0.352 | 0.200 | 0.061 | 0.157 | 0.070 | 0.687 | 0.616 | 0.369 |
| Staggered 18-year nonrenewable terms | state/circuit_en_banc | 78 | 1.000 | 0.739 | 0.531 | 0.000 | 3.000 | 0.505 | 0.549 | 0.295 | 0.256 | 0.385 | 0.077 | 0.064 | 0.009 | 0.977 | 0.920 | 0.364 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 2853 | 1.000 | 0.756 | 0.167 | 0.220 | 2.000 | 0.567 | 0.477 | 0.469 | 0.367 | 0.173 | 0.053 | 0.228 | 0.073 | 0.674 | 0.602 | 0.330 |
| Staggered 18-year nonrenewable terms | state/district_only | 155 | 1.000 | 0.699 | 0.749 | 0.202 | 1.000 | 0.549 | 0.490 | 0.310 | 0.303 | 0.239 | 0.052 | 0.110 | 0.025 | 0.870 | 0.801 | 0.284 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 4433 | 1.000 | 0.737 | 0.192 | 0.329 | 3.000 | 0.572 | 0.528 | 0.450 | 0.356 | 0.190 | 0.054 | 0.208 | 0.070 | 0.686 | 0.613 | 0.365 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 8181 | 1.000 | 0.754 | 0.158 | 0.234 | 2.000 | 0.566 | 0.486 | 0.458 | 0.383 | 0.174 | 0.056 | 0.229 | 0.078 | 0.670 | 0.597 | 0.335 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 3975 | 1.000 | 0.803 | 0.043 | 0.091 | 3.000 | 0.390 | 0.473 | 0.563 | 0.472 | 0.172 | 0.042 | 0.405 | 0.143 | 0.537 | 0.468 | 0.448 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 9755 | 1.000 | 0.782 | 0.041 | 0.096 | 2.000 | 0.404 | 0.434 | 0.571 | 0.489 | 0.142 | 0.037 | 0.409 | 0.139 | 0.518 | 0.446 | 0.414 |
| Fifteen-justice supermajority commission court | federal/district_only | 2433 | 1.000 | 0.772 | 0.060 | 0.112 | 1.000 | 0.415 | 0.411 | 0.565 | 0.482 | 0.121 | 0.029 | 0.407 | 0.133 | 0.523 | 0.447 | 0.378 |
| Fifteen-justice supermajority commission court | federal/state_federal_split | 81 | 1.000 | 0.697 | 0.175 | 0.714 | 3.000 | 0.515 | 0.523 | 0.284 | 0.259 | 0.346 | 0.062 | 0.185 | 0.028 | 0.919 | 0.849 | 0.447 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.776 | 0.032 | 0.320 | 3.000 | 0.770 | 0.563 | 0.499 | 0.419 | 0.170 | 0.060 | 0.217 | 0.109 | 0.561 | 0.504 | 0.451 |
| Fifteen-justice supermajority commission court | mixed_state_federal/district_only | 188 | 1.000 | 0.755 | 0.216 | 0.348 | 1.000 | 0.753 | 0.532 | 0.457 | 0.346 | 0.239 | 0.053 | 0.170 | 0.029 | 0.728 | 0.696 | 0.374 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.776 | 0.030 | 0.354 | 3.000 | 0.773 | 0.583 | 0.505 | 0.425 | 0.165 | 0.060 | 0.219 | 0.106 | 0.553 | 0.497 | 0.455 |
| Fifteen-justice supermajority commission court | state/circuit_en_banc | 78 | 1.000 | 0.766 | 0.168 | 0.000 | 3.000 | 0.505 | 0.549 | 0.436 | 0.295 | 0.397 | 0.026 | 0.192 | 0.020 | 0.935 | 0.891 | 0.454 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 2853 | 1.000 | 0.774 | 0.039 | 0.220 | 2.000 | 0.567 | 0.477 | 0.532 | 0.469 | 0.146 | 0.046 | 0.290 | 0.113 | 0.550 | 0.490 | 0.416 |
| Fifteen-justice supermajority commission court | state/district_only | 155 | 1.000 | 0.756 | 0.201 | 0.223 | 1.000 | 0.549 | 0.490 | 0.471 | 0.361 | 0.258 | 0.039 | 0.187 | 0.063 | 0.786 | 0.722 | 0.374 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 4433 | 1.000 | 0.767 | 0.046 | 0.298 | 3.000 | 0.572 | 0.528 | 0.511 | 0.434 | 0.156 | 0.051 | 0.264 | 0.107 | 0.565 | 0.500 | 0.451 |
| Fifteen-justice supermajority commission court | state/state_high_court | 8181 | 1.000 | 0.773 | 0.035 | 0.225 | 2.000 | 0.566 | 0.486 | 0.541 | 0.463 | 0.145 | 0.052 | 0.281 | 0.119 | 0.544 | 0.485 | 0.421 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 3975 | 1.000 | 0.802 | 0.044 | 0.080 | 3.000 | 0.390 | 0.473 | 0.569 | 0.463 | 0.170 | 0.039 | 0.389 | 0.128 | 0.568 | 0.504 | 0.413 |
| Supermajority required to invalidate laws | federal/circuit_panel | 9755 | 1.000 | 0.781 | 0.043 | 0.092 | 2.000 | 0.404 | 0.434 | 0.566 | 0.481 | 0.140 | 0.039 | 0.407 | 0.123 | 0.546 | 0.477 | 0.379 |
| Supermajority required to invalidate laws | federal/district_only | 2433 | 1.000 | 0.771 | 0.061 | 0.100 | 1.000 | 0.415 | 0.411 | 0.566 | 0.484 | 0.129 | 0.035 | 0.415 | 0.120 | 0.546 | 0.474 | 0.344 |
| Supermajority required to invalidate laws | federal/state_federal_split | 81 | 1.000 | 0.698 | 0.172 | 0.621 | 3.000 | 0.515 | 0.523 | 0.383 | 0.272 | 0.272 | 0.062 | 0.309 | 0.030 | 0.925 | 0.859 | 0.412 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.774 | 0.033 | 0.312 | 3.000 | 0.770 | 0.563 | 0.498 | 0.414 | 0.174 | 0.060 | 0.212 | 0.096 | 0.597 | 0.543 | 0.415 |
| Supermajority required to invalidate laws | mixed_state_federal/district_only | 188 | 1.000 | 0.754 | 0.221 | 0.322 | 1.000 | 0.753 | 0.532 | 0.447 | 0.410 | 0.191 | 0.032 | 0.165 | 0.020 | 0.749 | 0.720 | 0.338 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.773 | 0.031 | 0.356 | 3.000 | 0.773 | 0.583 | 0.496 | 0.412 | 0.177 | 0.061 | 0.207 | 0.095 | 0.587 | 0.533 | 0.419 |
| Supermajority required to invalidate laws | state/circuit_en_banc | 78 | 1.000 | 0.763 | 0.158 | 0.000 | 3.000 | 0.505 | 0.549 | 0.308 | 0.308 | 0.295 | 0.090 | 0.103 | 0.021 | 0.931 | 0.881 | 0.418 |
| Supermajority required to invalidate laws | state/circuit_panel | 2853 | 1.000 | 0.772 | 0.041 | 0.219 | 2.000 | 0.567 | 0.477 | 0.529 | 0.433 | 0.159 | 0.040 | 0.266 | 0.099 | 0.580 | 0.524 | 0.381 |
| Supermajority required to invalidate laws | state/district_only | 155 | 1.000 | 0.749 | 0.217 | 0.247 | 1.000 | 0.549 | 0.490 | 0.394 | 0.400 | 0.226 | 0.090 | 0.155 | 0.044 | 0.803 | 0.739 | 0.338 |
| Supermajority required to invalidate laws | state/state_federal_split | 4433 | 1.000 | 0.764 | 0.047 | 0.301 | 3.000 | 0.572 | 0.528 | 0.524 | 0.426 | 0.163 | 0.051 | 0.266 | 0.095 | 0.593 | 0.534 | 0.416 |
| Supermajority required to invalidate laws | state/state_high_court | 8181 | 1.000 | 0.771 | 0.037 | 0.220 | 2.000 | 0.566 | 0.486 | 0.530 | 0.437 | 0.147 | 0.050 | 0.284 | 0.103 | 0.575 | 0.518 | 0.386 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 3975 | 1.000 | 0.803 | 0.042 | 0.085 | 3.000 | 0.390 | 0.473 | 0.577 | 0.500 | 0.150 | 0.035 | 0.430 | 0.164 | 0.500 | 0.433 | 0.477 |
| Strict recusal with substitute justices | federal/circuit_panel | 9755 | 1.000 | 0.782 | 0.041 | 0.090 | 2.000 | 0.404 | 0.434 | 0.593 | 0.503 | 0.137 | 0.036 | 0.427 | 0.166 | 0.482 | 0.411 | 0.443 |
| Strict recusal with substitute justices | federal/district_only | 2433 | 1.000 | 0.772 | 0.058 | 0.101 | 1.000 | 0.415 | 0.411 | 0.600 | 0.529 | 0.108 | 0.038 | 0.418 | 0.164 | 0.490 | 0.415 | 0.407 |
| Strict recusal with substitute justices | federal/state_federal_split | 81 | 1.000 | 0.688 | 0.179 | 0.596 | 3.000 | 0.515 | 0.523 | 0.383 | 0.284 | 0.222 | 0.123 | 0.185 | 0.034 | 0.914 | 0.845 | 0.476 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.777 | 0.034 | 0.299 | 3.000 | 0.770 | 0.563 | 0.519 | 0.432 | 0.163 | 0.045 | 0.215 | 0.131 | 0.519 | 0.466 | 0.479 |
| Strict recusal with substitute justices | mixed_state_federal/district_only | 188 | 1.000 | 0.752 | 0.225 | 0.280 | 1.000 | 0.753 | 0.532 | 0.415 | 0.330 | 0.207 | 0.064 | 0.138 | 0.047 | 0.711 | 0.674 | 0.403 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.777 | 0.030 | 0.338 | 3.000 | 0.773 | 0.583 | 0.524 | 0.446 | 0.157 | 0.052 | 0.239 | 0.129 | 0.512 | 0.459 | 0.483 |
| Strict recusal with substitute justices | state/circuit_en_banc | 78 | 1.000 | 0.770 | 0.164 | 0.000 | 3.000 | 0.505 | 0.549 | 0.308 | 0.359 | 0.295 | 0.051 | 0.205 | 0.022 | 0.923 | 0.879 | 0.483 |
| Strict recusal with substitute justices | state/circuit_panel | 2853 | 1.000 | 0.773 | 0.038 | 0.210 | 2.000 | 0.567 | 0.477 | 0.570 | 0.471 | 0.142 | 0.043 | 0.303 | 0.136 | 0.509 | 0.453 | 0.445 |
| Strict recusal with substitute justices | state/district_only | 155 | 1.000 | 0.755 | 0.204 | 0.230 | 1.000 | 0.549 | 0.490 | 0.406 | 0.368 | 0.239 | 0.071 | 0.155 | 0.066 | 0.780 | 0.711 | 0.401 |
| Strict recusal with substitute justices | state/state_federal_split | 4433 | 1.000 | 0.768 | 0.043 | 0.284 | 3.000 | 0.572 | 0.528 | 0.561 | 0.460 | 0.153 | 0.047 | 0.297 | 0.130 | 0.526 | 0.465 | 0.480 |
| Strict recusal with substitute justices | state/state_high_court | 8181 | 1.000 | 0.774 | 0.033 | 0.215 | 2.000 | 0.566 | 0.486 | 0.556 | 0.472 | 0.140 | 0.048 | 0.307 | 0.141 | 0.504 | 0.449 | 0.450 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 3975 | 1.000 | 0.803 | 0.002 | 0.105 | 3.000 | 0.390 | 0.473 | 0.569 | 0.484 | 0.164 | 0.041 | 0.401 | 0.149 | 0.568 | 0.504 | 0.414 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 9755 | 1.000 | 0.783 | 0.002 | 0.116 | 2.000 | 0.404 | 0.434 | 0.577 | 0.496 | 0.134 | 0.046 | 0.417 | 0.147 | 0.549 | 0.478 | 0.380 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 2433 | 1.000 | 0.774 | 0.004 | 0.118 | 1.000 | 0.415 | 0.411 | 0.566 | 0.500 | 0.141 | 0.045 | 0.407 | 0.140 | 0.548 | 0.478 | 0.344 |
| Reasoned emergency orders with merits follow-up | federal/state_federal_split | 81 | 1.000 | 0.706 | 0.015 | 0.654 | 3.000 | 0.515 | 0.523 | 0.506 | 0.370 | 0.259 | 0.099 | 0.247 | 0.035 | 0.906 | 0.866 | 0.414 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.773 | 0.002 | 0.359 | 3.000 | 0.770 | 0.563 | 0.510 | 0.414 | 0.179 | 0.056 | 0.217 | 0.114 | 0.601 | 0.545 | 0.417 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/district_only | 188 | 1.000 | 0.763 | 0.018 | 0.245 | 1.000 | 0.753 | 0.532 | 0.447 | 0.436 | 0.186 | 0.074 | 0.170 | 0.036 | 0.735 | 0.715 | 0.340 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.770 | 0.002 | 0.409 | 3.000 | 0.773 | 0.583 | 0.502 | 0.431 | 0.173 | 0.062 | 0.216 | 0.112 | 0.594 | 0.537 | 0.421 |
| Reasoned emergency orders with merits follow-up | state/circuit_en_banc | 78 | 1.000 | 0.767 | 0.001 | 0.064 | 3.000 | 0.505 | 0.549 | 0.423 | 0.333 | 0.321 | 0.026 | 0.256 | 0.033 | 0.905 | 0.883 | 0.420 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 2853 | 1.000 | 0.775 | 0.003 | 0.252 | 2.000 | 0.567 | 0.477 | 0.545 | 0.464 | 0.150 | 0.048 | 0.277 | 0.118 | 0.578 | 0.522 | 0.382 |
| Reasoned emergency orders with merits follow-up | state/district_only | 155 | 1.000 | 0.759 | 0.024 | 0.252 | 1.000 | 0.549 | 0.490 | 0.406 | 0.297 | 0.271 | 0.065 | 0.252 | 0.061 | 0.790 | 0.747 | 0.340 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 4433 | 1.000 | 0.764 | 0.003 | 0.350 | 3.000 | 0.572 | 0.528 | 0.528 | 0.435 | 0.164 | 0.057 | 0.277 | 0.112 | 0.600 | 0.540 | 0.417 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 8181 | 1.000 | 0.774 | 0.002 | 0.257 | 2.000 | 0.566 | 0.486 | 0.554 | 0.459 | 0.150 | 0.053 | 0.290 | 0.122 | 0.581 | 0.523 | 0.387 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 3975 | 1.000 | 0.803 | 0.042 | 0.090 | 3.000 | 0.390 | 0.473 | 0.573 | 0.490 | 0.152 | 0.036 | 0.413 | 0.153 | 0.532 | 0.468 | 0.550 |
| Panel review with en banc safety valve | federal/circuit_panel | 9755 | 1.000 | 0.782 | 0.041 | 0.104 | 2.000 | 0.404 | 0.434 | 0.576 | 0.492 | 0.136 | 0.038 | 0.411 | 0.152 | 0.515 | 0.444 | 0.507 |
| Panel review with en banc safety valve | federal/district_only | 2433 | 1.000 | 0.771 | 0.060 | 0.117 | 1.000 | 0.415 | 0.411 | 0.573 | 0.513 | 0.125 | 0.041 | 0.401 | 0.146 | 0.517 | 0.444 | 0.467 |
| Panel review with en banc safety valve | federal/state_federal_split | 81 | 1.000 | 0.700 | 0.178 | 0.607 | 3.000 | 0.515 | 0.523 | 0.346 | 0.333 | 0.296 | 0.086 | 0.173 | 0.035 | 0.921 | 0.855 | 0.624 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.775 | 0.032 | 0.327 | 3.000 | 0.770 | 0.563 | 0.506 | 0.430 | 0.168 | 0.054 | 0.210 | 0.118 | 0.559 | 0.506 | 0.570 |
| Panel review with en banc safety valve | mixed_state_federal/district_only | 188 | 1.000 | 0.758 | 0.199 | 0.303 | 1.000 | 0.753 | 0.532 | 0.399 | 0.309 | 0.234 | 0.043 | 0.207 | 0.046 | 0.721 | 0.685 | 0.512 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.774 | 0.030 | 0.367 | 3.000 | 0.773 | 0.583 | 0.511 | 0.429 | 0.170 | 0.057 | 0.226 | 0.118 | 0.550 | 0.496 | 0.585 |
| Panel review with en banc safety valve | state/circuit_en_banc | 78 | 1.000 | 0.770 | 0.171 | 0.000 | 3.000 | 0.505 | 0.549 | 0.487 | 0.359 | 0.308 | 0.026 | 0.205 | 0.029 | 0.929 | 0.886 | 0.617 |
| Panel review with en banc safety valve | state/circuit_panel | 2853 | 1.000 | 0.774 | 0.038 | 0.227 | 2.000 | 0.567 | 0.477 | 0.547 | 0.454 | 0.139 | 0.053 | 0.295 | 0.123 | 0.545 | 0.486 | 0.518 |
| Panel review with en banc safety valve | state/district_only | 155 | 1.000 | 0.760 | 0.214 | 0.241 | 1.000 | 0.549 | 0.490 | 0.439 | 0.387 | 0.206 | 0.058 | 0.174 | 0.068 | 0.785 | 0.719 | 0.518 |
| Panel review with en banc safety valve | state/state_federal_split | 4433 | 1.000 | 0.767 | 0.044 | 0.307 | 3.000 | 0.572 | 0.528 | 0.532 | 0.447 | 0.157 | 0.047 | 0.275 | 0.118 | 0.560 | 0.499 | 0.576 |
| Panel review with en banc safety valve | state/state_high_court | 8181 | 1.000 | 0.773 | 0.034 | 0.233 | 2.000 | 0.566 | 0.486 | 0.541 | 0.453 | 0.146 | 0.044 | 0.295 | 0.128 | 0.541 | 0.484 | 0.523 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 3975 | 1.000 | 0.806 | 0.003 | 0.056 | 3.000 | 0.390 | 0.473 | 0.605 | 0.527 | 0.144 | 0.031 | 0.434 | 0.180 | 0.481 | 0.414 | 0.841 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 9755 | 1.000 | 0.785 | 0.003 | 0.065 | 2.000 | 0.404 | 0.434 | 0.613 | 0.527 | 0.119 | 0.032 | 0.435 | 0.177 | 0.466 | 0.392 | 0.807 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 2433 | 1.000 | 0.775 | 0.005 | 0.069 | 1.000 | 0.415 | 0.411 | 0.600 | 0.533 | 0.124 | 0.033 | 0.444 | 0.169 | 0.469 | 0.393 | 0.771 |
| Dual supreme courts with cross-checking invalidations | federal/state_federal_split | 81 | 1.000 | 0.715 | 0.020 | 0.481 | 3.000 | 0.515 | 0.523 | 0.407 | 0.506 | 0.173 | 0.037 | 0.247 | 0.044 | 0.857 | 0.796 | 0.842 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.782 | 0.002 | 0.268 | 3.000 | 0.770 | 0.563 | 0.536 | 0.466 | 0.156 | 0.053 | 0.250 | 0.139 | 0.501 | 0.444 | 0.844 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/district_only | 188 | 1.000 | 0.759 | 0.028 | 0.138 | 1.000 | 0.753 | 0.532 | 0.537 | 0.335 | 0.218 | 0.032 | 0.207 | 0.070 | 0.679 | 0.653 | 0.770 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.784 | 0.002 | 0.298 | 3.000 | 0.773 | 0.583 | 0.544 | 0.461 | 0.150 | 0.053 | 0.248 | 0.139 | 0.493 | 0.435 | 0.848 |
| Dual supreme courts with cross-checking invalidations | state/circuit_en_banc | 78 | 1.000 | 0.771 | 0.002 | 0.000 | 3.000 | 0.505 | 0.549 | 0.513 | 0.372 | 0.282 | 0.038 | 0.128 | 0.048 | 0.843 | 0.810 | 0.850 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 2853 | 1.000 | 0.778 | 0.003 | 0.182 | 2.000 | 0.567 | 0.477 | 0.563 | 0.492 | 0.135 | 0.043 | 0.320 | 0.146 | 0.498 | 0.438 | 0.810 |
| Dual supreme courts with cross-checking invalidations | state/district_only | 155 | 1.000 | 0.761 | 0.028 | 0.110 | 1.000 | 0.549 | 0.490 | 0.523 | 0.419 | 0.194 | 0.058 | 0.232 | 0.090 | 0.735 | 0.679 | 0.769 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 4433 | 1.000 | 0.775 | 0.003 | 0.242 | 3.000 | 0.572 | 0.528 | 0.566 | 0.482 | 0.140 | 0.046 | 0.308 | 0.142 | 0.505 | 0.440 | 0.844 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 8181 | 1.000 | 0.777 | 0.002 | 0.183 | 2.000 | 0.566 | 0.486 | 0.572 | 0.483 | 0.133 | 0.043 | 0.304 | 0.150 | 0.488 | 0.427 | 0.814 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 3975 | 1.000 | 0.804 | 0.041 | 0.058 | 3.000 | 0.390 | 0.473 | 0.604 | 0.531 | 0.143 | 0.040 | 0.456 | 0.216 | 0.419 | 0.337 | 0.671 |
| Pre-enactment constitutional council | federal/circuit_panel | 9755 | 1.000 | 0.782 | 0.039 | 0.066 | 2.000 | 0.404 | 0.434 | 0.610 | 0.538 | 0.112 | 0.035 | 0.450 | 0.221 | 0.405 | 0.321 | 0.637 |
| Pre-enactment constitutional council | federal/district_only | 2433 | 1.000 | 0.771 | 0.057 | 0.069 | 1.000 | 0.415 | 0.411 | 0.618 | 0.538 | 0.113 | 0.035 | 0.463 | 0.218 | 0.418 | 0.331 | 0.601 |
| Pre-enactment constitutional council | federal/state_federal_split | 81 | 1.000 | 0.707 | 0.184 | 0.491 | 3.000 | 0.515 | 0.523 | 0.457 | 0.395 | 0.148 | 0.037 | 0.284 | 0.040 | 0.873 | 0.796 | 0.667 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.778 | 0.030 | 0.237 | 3.000 | 0.770 | 0.563 | 0.563 | 0.484 | 0.143 | 0.045 | 0.265 | 0.178 | 0.415 | 0.344 | 0.674 |
| Pre-enactment constitutional council | mixed_state_federal/district_only | 188 | 1.000 | 0.756 | 0.210 | 0.215 | 1.000 | 0.753 | 0.532 | 0.500 | 0.335 | 0.176 | 0.059 | 0.160 | 0.090 | 0.668 | 0.624 | 0.598 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.782 | 0.029 | 0.269 | 3.000 | 0.773 | 0.583 | 0.559 | 0.474 | 0.136 | 0.051 | 0.266 | 0.178 | 0.407 | 0.338 | 0.678 |
| Pre-enactment constitutional council | state/circuit_en_banc | 78 | 1.000 | 0.770 | 0.165 | 0.000 | 3.000 | 0.505 | 0.549 | 0.385 | 0.321 | 0.410 | 0.064 | 0.154 | 0.031 | 0.876 | 0.825 | 0.676 |
| Pre-enactment constitutional council | state/circuit_panel | 2853 | 1.000 | 0.772 | 0.037 | 0.166 | 2.000 | 0.567 | 0.477 | 0.598 | 0.501 | 0.130 | 0.043 | 0.329 | 0.186 | 0.418 | 0.345 | 0.639 |
| Pre-enactment constitutional council | state/district_only | 155 | 1.000 | 0.759 | 0.209 | 0.140 | 1.000 | 0.549 | 0.490 | 0.497 | 0.381 | 0.258 | 0.032 | 0.206 | 0.100 | 0.736 | 0.665 | 0.594 |
| Pre-enactment constitutional council | state/state_federal_split | 4433 | 1.000 | 0.770 | 0.041 | 0.221 | 3.000 | 0.572 | 0.528 | 0.574 | 0.483 | 0.134 | 0.045 | 0.321 | 0.185 | 0.435 | 0.357 | 0.674 |
| Pre-enactment constitutional council | state/state_high_court | 8181 | 1.000 | 0.773 | 0.032 | 0.167 | 2.000 | 0.566 | 0.486 | 0.586 | 0.500 | 0.118 | 0.041 | 0.331 | 0.190 | 0.409 | 0.335 | 0.644 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 3975 | 1.000 | 0.801 | 0.045 | 0.097 | 3.000 | 0.390 | 0.473 | 0.542 | 0.463 | 0.183 | 0.039 | 0.390 | 0.131 | 0.597 | 0.521 | 0.438 |
| Judicial review with delayed legislative override | federal/circuit_panel | 9755 | 1.000 | 0.781 | 0.041 | 0.101 | 2.000 | 0.404 | 0.434 | 0.551 | 0.463 | 0.140 | 0.040 | 0.383 | 0.124 | 0.570 | 0.489 | 0.405 |
| Judicial review with delayed legislative override | federal/district_only | 2433 | 1.000 | 0.771 | 0.059 | 0.117 | 1.000 | 0.415 | 0.411 | 0.538 | 0.461 | 0.143 | 0.043 | 0.392 | 0.115 | 0.570 | 0.484 | 0.369 |
| Judicial review with delayed legislative override | federal/state_federal_split | 81 | 1.000 | 0.696 | 0.165 | 0.702 | 3.000 | 0.515 | 0.523 | 0.407 | 0.296 | 0.272 | 0.049 | 0.160 | 0.029 | 0.924 | 0.856 | 0.438 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.769 | 0.034 | 0.336 | 3.000 | 0.770 | 0.563 | 0.461 | 0.390 | 0.188 | 0.054 | 0.193 | 0.095 | 0.628 | 0.557 | 0.441 |
| Judicial review with delayed legislative override | mixed_state_federal/district_only | 188 | 1.000 | 0.748 | 0.226 | 0.390 | 1.000 | 0.753 | 0.532 | 0.441 | 0.309 | 0.213 | 0.069 | 0.138 | 0.016 | 0.765 | 0.725 | 0.364 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.768 | 0.031 | 0.366 | 3.000 | 0.773 | 0.583 | 0.473 | 0.386 | 0.182 | 0.061 | 0.191 | 0.093 | 0.620 | 0.549 | 0.445 |
| Judicial review with delayed legislative override | state/circuit_en_banc | 78 | 1.000 | 0.765 | 0.175 | 0.024 | 3.000 | 0.505 | 0.549 | 0.410 | 0.385 | 0.269 | 0.013 | 0.167 | 0.024 | 0.927 | 0.882 | 0.443 |
| Judicial review with delayed legislative override | state/circuit_panel | 2853 | 1.000 | 0.771 | 0.038 | 0.228 | 2.000 | 0.567 | 0.477 | 0.500 | 0.426 | 0.158 | 0.053 | 0.253 | 0.100 | 0.607 | 0.536 | 0.407 |
| Judicial review with delayed legislative override | state/district_only | 155 | 1.000 | 0.757 | 0.219 | 0.320 | 1.000 | 0.549 | 0.490 | 0.426 | 0.374 | 0.187 | 0.052 | 0.232 | 0.051 | 0.810 | 0.748 | 0.363 |
| Judicial review with delayed legislative override | state/state_federal_split | 4433 | 1.000 | 0.760 | 0.046 | 0.313 | 3.000 | 0.572 | 0.528 | 0.493 | 0.413 | 0.178 | 0.052 | 0.250 | 0.095 | 0.622 | 0.548 | 0.441 |
| Judicial review with delayed legislative override | state/state_high_court | 8181 | 1.000 | 0.769 | 0.035 | 0.231 | 2.000 | 0.566 | 0.486 | 0.511 | 0.424 | 0.154 | 0.047 | 0.265 | 0.103 | 0.604 | 0.533 | 0.411 |
| Retention-election accountability court | federal/circuit_en_banc | 3975 | 1.000 | 0.803 | 0.042 | 0.054 | 3.000 | 0.390 | 0.473 | 0.569 | 0.463 | 0.158 | 0.039 | 0.410 | 0.152 | 0.480 | 0.387 | 0.470 |
| Retention-election accountability court | federal/circuit_panel | 9755 | 1.000 | 0.781 | 0.039 | 0.062 | 2.000 | 0.404 | 0.434 | 0.578 | 0.495 | 0.125 | 0.033 | 0.407 | 0.146 | 0.465 | 0.368 | 0.436 |
| Retention-election accountability court | federal/district_only | 2433 | 1.000 | 0.771 | 0.055 | 0.068 | 1.000 | 0.415 | 0.411 | 0.592 | 0.494 | 0.113 | 0.038 | 0.431 | 0.138 | 0.473 | 0.372 | 0.400 |
| Retention-election accountability court | federal/state_federal_split | 81 | 1.000 | 0.707 | 0.182 | 0.528 | 3.000 | 0.515 | 0.523 | 0.370 | 0.432 | 0.222 | 0.062 | 0.148 | 0.033 | 0.887 | 0.809 | 0.467 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.757 | 0.029 | 0.217 | 3.000 | 0.770 | 0.563 | 0.513 | 0.431 | 0.154 | 0.043 | 0.229 | 0.116 | 0.492 | 0.406 | 0.473 |
| Retention-election accountability court | mixed_state_federal/district_only | 188 | 1.000 | 0.753 | 0.209 | 0.185 | 1.000 | 0.753 | 0.532 | 0.441 | 0.282 | 0.239 | 0.059 | 0.165 | 0.039 | 0.683 | 0.630 | 0.399 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.760 | 0.029 | 0.247 | 3.000 | 0.773 | 0.583 | 0.496 | 0.418 | 0.157 | 0.052 | 0.228 | 0.112 | 0.487 | 0.400 | 0.477 |
| Retention-election accountability court | state/circuit_en_banc | 78 | 1.000 | 0.770 | 0.158 | 0.000 | 3.000 | 0.505 | 0.549 | 0.333 | 0.295 | 0.346 | 0.051 | 0.141 | 0.029 | 0.905 | 0.860 | 0.476 |
| Retention-election accountability court | state/circuit_panel | 2853 | 1.000 | 0.759 | 0.037 | 0.145 | 2.000 | 0.567 | 0.477 | 0.549 | 0.442 | 0.140 | 0.042 | 0.298 | 0.119 | 0.491 | 0.404 | 0.438 |
| Retention-election accountability court | state/district_only | 155 | 1.000 | 0.755 | 0.185 | 0.136 | 1.000 | 0.549 | 0.490 | 0.439 | 0.329 | 0.213 | 0.052 | 0.206 | 0.068 | 0.761 | 0.684 | 0.396 |
| Retention-election accountability court | state/state_federal_split | 4433 | 1.000 | 0.757 | 0.040 | 0.200 | 3.000 | 0.572 | 0.528 | 0.513 | 0.453 | 0.137 | 0.049 | 0.276 | 0.115 | 0.502 | 0.411 | 0.473 |
| Retention-election accountability court | state/state_high_court | 8181 | 1.000 | 0.761 | 0.032 | 0.140 | 2.000 | 0.566 | 0.486 | 0.535 | 0.456 | 0.134 | 0.045 | 0.293 | 0.125 | 0.479 | 0.391 | 0.443 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 3975 | 1.000 | 0.805 | 0.002 | 0.073 | 3.000 | 0.390 | 0.473 | 0.581 | 0.502 | 0.150 | 0.042 | 0.419 | 0.172 | 0.493 | 0.440 | 0.714 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 9755 | 1.000 | 0.784 | 0.002 | 0.081 | 2.000 | 0.404 | 0.434 | 0.601 | 0.521 | 0.129 | 0.039 | 0.428 | 0.172 | 0.476 | 0.417 | 0.669 |
| Hybrid court balancing independence and accountability | federal/district_only | 2433 | 1.000 | 0.774 | 0.003 | 0.085 | 1.000 | 0.415 | 0.411 | 0.604 | 0.525 | 0.115 | 0.034 | 0.431 | 0.172 | 0.479 | 0.416 | 0.630 |
| Hybrid court balancing independence and accountability | federal/state_federal_split | 81 | 1.000 | 0.716 | 0.014 | 0.469 | 3.000 | 0.515 | 0.523 | 0.506 | 0.346 | 0.198 | 0.049 | 0.321 | 0.041 | 0.855 | 0.823 | 0.794 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 4462 | 1.000 | 0.780 | 0.002 | 0.298 | 3.000 | 0.770 | 0.563 | 0.536 | 0.443 | 0.158 | 0.059 | 0.226 | 0.136 | 0.514 | 0.475 | 0.732 |
| Hybrid court balancing independence and accountability | mixed_state_federal/district_only | 188 | 1.000 | 0.758 | 0.018 | 0.191 | 1.000 | 0.753 | 0.532 | 0.495 | 0.410 | 0.186 | 0.074 | 0.181 | 0.068 | 0.673 | 0.661 | 0.681 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 11406 | 1.000 | 0.781 | 0.001 | 0.329 | 3.000 | 0.773 | 0.583 | 0.531 | 0.449 | 0.160 | 0.058 | 0.230 | 0.133 | 0.508 | 0.467 | 0.747 |
| Hybrid court balancing independence and accountability | state/circuit_en_banc | 78 | 1.000 | 0.771 | 0.000 | 0.000 | 3.000 | 0.505 | 0.549 | 0.397 | 0.321 | 0.333 | 0.064 | 0.128 | 0.039 | 0.857 | 0.839 | 0.785 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 2853 | 1.000 | 0.777 | 0.002 | 0.207 | 2.000 | 0.567 | 0.477 | 0.562 | 0.471 | 0.147 | 0.043 | 0.305 | 0.142 | 0.504 | 0.459 | 0.678 |
| Hybrid court balancing independence and accountability | state/district_only | 155 | 1.000 | 0.759 | 0.017 | 0.103 | 1.000 | 0.549 | 0.490 | 0.548 | 0.394 | 0.187 | 0.026 | 0.265 | 0.094 | 0.732 | 0.693 | 0.686 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 4433 | 1.000 | 0.773 | 0.003 | 0.268 | 3.000 | 0.572 | 0.528 | 0.558 | 0.470 | 0.148 | 0.053 | 0.305 | 0.137 | 0.515 | 0.467 | 0.737 |
| Hybrid court balancing independence and accountability | state/state_high_court | 8181 | 1.000 | 0.777 | 0.002 | 0.212 | 2.000 | 0.566 | 0.486 | 0.564 | 0.471 | 0.139 | 0.048 | 0.308 | 0.148 | 0.499 | 0.454 | 0.684 |

## Policy Domain Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administration | 852 | 1.000 | 0.726 | 0.533 | 0.097 | 2.694 | 0.484 | 0.534 | 0.304 | 0.235 | 0.351 | 0.039 | 0.155 | 0.018 | 0.973 | 0.912 | 0.349 |
| Current-style federal supreme court | civil-rights | 18740 | 1.000 | 0.703 | 0.143 | 0.517 | 2.435 | 0.554 | 0.496 | 0.437 | 0.344 | 0.198 | 0.065 | 0.223 | 0.047 | 0.738 | 0.655 | 0.339 |
| Current-style federal supreme court | criminal-justice | 1417 | 1.000 | 0.623 | 0.637 | 0.608 | 2.356 | 0.588 | 0.518 | 0.256 | 0.193 | 0.294 | 0.064 | 0.082 | 0.018 | 0.974 | 0.911 | 0.331 |
| Current-style federal supreme court | economic-regulation | 4920 | 1.000 | 0.808 | 0.168 | 0.053 | 2.628 | 0.622 | 0.547 | 0.429 | 0.354 | 0.226 | 0.054 | 0.213 | 0.083 | 0.785 | 0.716 | 0.352 |
| Current-style federal supreme court | elections | 1928 | 1.000 | 0.671 | 0.464 | 0.462 | 2.742 | 0.693 | 0.530 | 0.316 | 0.241 | 0.263 | 0.054 | 0.097 | 0.010 | 0.867 | 0.828 | 0.347 |
| Current-style federal supreme court | emergency-security | 2136 | 1.000 | 0.671 | 0.710 | 0.285 | 1.958 | 0.545 | 0.511 | 0.310 | 0.229 | 0.254 | 0.061 | 0.140 | 0.013 | 0.852 | 0.804 | 0.312 |
| Current-style federal supreme court | governance | 18007 | 1.000 | 0.808 | 0.064 | 0.068 | 2.443 | 0.591 | 0.495 | 0.504 | 0.418 | 0.161 | 0.048 | 0.272 | 0.116 | 0.643 | 0.567 | 0.344 |
| Staggered 18-year nonrenewable terms | administration | 852 | 1.000 | 0.737 | 0.545 | 0.045 | 2.694 | 0.484 | 0.534 | 0.336 | 0.250 | 0.342 | 0.047 | 0.142 | 0.019 | 0.970 | 0.906 | 0.354 |
| Staggered 18-year nonrenewable terms | civil-rights | 18740 | 1.000 | 0.711 | 0.138 | 0.452 | 2.435 | 0.554 | 0.496 | 0.454 | 0.370 | 0.188 | 0.060 | 0.241 | 0.055 | 0.680 | 0.592 | 0.345 |
| Staggered 18-year nonrenewable terms | criminal-justice | 1417 | 1.000 | 0.635 | 0.619 | 0.583 | 2.356 | 0.588 | 0.518 | 0.270 | 0.193 | 0.301 | 0.066 | 0.078 | 0.018 | 0.973 | 0.907 | 0.336 |
| Staggered 18-year nonrenewable terms | economic-regulation | 4920 | 1.000 | 0.815 | 0.161 | 0.027 | 2.628 | 0.622 | 0.547 | 0.443 | 0.365 | 0.223 | 0.051 | 0.219 | 0.096 | 0.737 | 0.671 | 0.358 |
| Staggered 18-year nonrenewable terms | elections | 1928 | 1.000 | 0.677 | 0.459 | 0.457 | 2.742 | 0.693 | 0.530 | 0.329 | 0.234 | 0.247 | 0.058 | 0.115 | 0.011 | 0.834 | 0.793 | 0.353 |
| Staggered 18-year nonrenewable terms | emergency-security | 2136 | 1.000 | 0.688 | 0.702 | 0.221 | 1.958 | 0.545 | 0.511 | 0.334 | 0.259 | 0.258 | 0.052 | 0.158 | 0.013 | 0.816 | 0.761 | 0.318 |
| Staggered 18-year nonrenewable terms | governance | 18007 | 1.000 | 0.814 | 0.064 | 0.040 | 2.443 | 0.591 | 0.495 | 0.523 | 0.437 | 0.143 | 0.048 | 0.293 | 0.122 | 0.570 | 0.496 | 0.349 |
| Fifteen-justice supermajority commission court | administration | 852 | 1.000 | 0.768 | 0.154 | 0.026 | 2.694 | 0.484 | 0.534 | 0.430 | 0.340 | 0.300 | 0.039 | 0.231 | 0.035 | 0.919 | 0.863 | 0.444 |
| Fifteen-justice supermajority commission court | civil-rights | 18740 | 1.000 | 0.735 | 0.025 | 0.425 | 2.435 | 0.554 | 0.496 | 0.528 | 0.440 | 0.155 | 0.055 | 0.297 | 0.105 | 0.554 | 0.480 | 0.430 |
| Fifteen-justice supermajority commission court | criminal-justice | 1417 | 1.000 | 0.697 | 0.193 | 0.555 | 2.356 | 0.588 | 0.518 | 0.351 | 0.304 | 0.262 | 0.071 | 0.136 | 0.032 | 0.930 | 0.869 | 0.426 |
| Fifteen-justice supermajority commission court | economic-regulation | 4920 | 1.000 | 0.826 | 0.036 | 0.015 | 2.628 | 0.622 | 0.547 | 0.507 | 0.432 | 0.187 | 0.045 | 0.267 | 0.139 | 0.599 | 0.568 | 0.444 |
| Fifteen-justice supermajority commission court | elections | 1928 | 1.000 | 0.743 | 0.110 | 0.478 | 2.742 | 0.693 | 0.530 | 0.423 | 0.338 | 0.216 | 0.059 | 0.174 | 0.024 | 0.751 | 0.711 | 0.441 |
| Fifteen-justice supermajority commission court | emergency-security | 2136 | 1.000 | 0.751 | 0.203 | 0.265 | 1.958 | 0.545 | 0.511 | 0.455 | 0.368 | 0.210 | 0.052 | 0.246 | 0.043 | 0.722 | 0.672 | 0.407 |
| Fifteen-justice supermajority commission court | governance | 18007 | 1.000 | 0.822 | 0.012 | 0.026 | 2.443 | 0.591 | 0.495 | 0.586 | 0.512 | 0.118 | 0.041 | 0.351 | 0.159 | 0.432 | 0.368 | 0.434 |
| Supermajority required to invalidate laws | administration | 852 | 1.000 | 0.766 | 0.162 | 0.031 | 2.694 | 0.484 | 0.534 | 0.399 | 0.312 | 0.337 | 0.046 | 0.194 | 0.033 | 0.928 | 0.871 | 0.408 |
| Supermajority required to invalidate laws | civil-rights | 18740 | 1.000 | 0.733 | 0.025 | 0.419 | 2.435 | 0.554 | 0.496 | 0.524 | 0.428 | 0.164 | 0.058 | 0.294 | 0.089 | 0.585 | 0.514 | 0.395 |
| Supermajority required to invalidate laws | criminal-justice | 1417 | 1.000 | 0.693 | 0.204 | 0.536 | 2.356 | 0.588 | 0.518 | 0.349 | 0.291 | 0.243 | 0.063 | 0.139 | 0.031 | 0.934 | 0.873 | 0.390 |
| Supermajority required to invalidate laws | economic-regulation | 4920 | 1.000 | 0.825 | 0.036 | 0.018 | 2.628 | 0.622 | 0.547 | 0.512 | 0.423 | 0.186 | 0.043 | 0.266 | 0.127 | 0.637 | 0.603 | 0.409 |
| Supermajority required to invalidate laws | elections | 1928 | 1.000 | 0.740 | 0.113 | 0.448 | 2.742 | 0.693 | 0.530 | 0.427 | 0.369 | 0.197 | 0.067 | 0.171 | 0.019 | 0.764 | 0.729 | 0.405 |
| Supermajority required to invalidate laws | emergency-security | 2136 | 1.000 | 0.744 | 0.212 | 0.254 | 1.958 | 0.545 | 0.511 | 0.460 | 0.376 | 0.198 | 0.051 | 0.248 | 0.033 | 0.737 | 0.690 | 0.371 |
| Supermajority required to invalidate laws | governance | 18007 | 1.000 | 0.820 | 0.012 | 0.028 | 2.443 | 0.591 | 0.495 | 0.579 | 0.492 | 0.124 | 0.040 | 0.342 | 0.145 | 0.467 | 0.408 | 0.399 |
| Strict recusal with substitute justices | administration | 852 | 1.000 | 0.769 | 0.156 | 0.017 | 2.694 | 0.484 | 0.534 | 0.400 | 0.345 | 0.288 | 0.046 | 0.230 | 0.034 | 0.912 | 0.856 | 0.473 |
| Strict recusal with substitute justices | civil-rights | 18740 | 1.000 | 0.736 | 0.024 | 0.406 | 2.435 | 0.554 | 0.496 | 0.549 | 0.459 | 0.149 | 0.051 | 0.315 | 0.133 | 0.512 | 0.443 | 0.459 |
| Strict recusal with substitute justices | criminal-justice | 1417 | 1.000 | 0.698 | 0.189 | 0.538 | 2.356 | 0.588 | 0.518 | 0.368 | 0.308 | 0.227 | 0.065 | 0.143 | 0.035 | 0.920 | 0.861 | 0.455 |
| Strict recusal with substitute justices | economic-regulation | 4920 | 1.000 | 0.826 | 0.036 | 0.013 | 2.628 | 0.622 | 0.547 | 0.535 | 0.442 | 0.182 | 0.041 | 0.295 | 0.155 | 0.551 | 0.527 | 0.473 |
| Strict recusal with substitute justices | elections | 1928 | 1.000 | 0.744 | 0.108 | 0.450 | 2.742 | 0.693 | 0.530 | 0.440 | 0.371 | 0.220 | 0.064 | 0.184 | 0.036 | 0.728 | 0.686 | 0.470 |
| Strict recusal with substitute justices | emergency-security | 2136 | 1.000 | 0.749 | 0.202 | 0.248 | 1.958 | 0.545 | 0.511 | 0.463 | 0.394 | 0.196 | 0.053 | 0.268 | 0.062 | 0.703 | 0.650 | 0.436 |
| Strict recusal with substitute justices | governance | 18007 | 1.000 | 0.822 | 0.011 | 0.021 | 2.443 | 0.591 | 0.495 | 0.615 | 0.530 | 0.109 | 0.034 | 0.370 | 0.185 | 0.391 | 0.328 | 0.463 |
| Reasoned emergency orders with merits follow-up | administration | 852 | 1.000 | 0.768 | 0.001 | 0.054 | 2.694 | 0.484 | 0.534 | 0.430 | 0.351 | 0.268 | 0.039 | 0.197 | 0.040 | 0.898 | 0.869 | 0.411 |
| Reasoned emergency orders with merits follow-up | civil-rights | 18740 | 1.000 | 0.732 | 0.002 | 0.492 | 2.435 | 0.554 | 0.496 | 0.526 | 0.442 | 0.163 | 0.060 | 0.302 | 0.109 | 0.590 | 0.516 | 0.396 |
| Reasoned emergency orders with merits follow-up | criminal-justice | 1417 | 1.000 | 0.722 | 0.007 | 0.613 | 2.356 | 0.588 | 0.518 | 0.402 | 0.323 | 0.243 | 0.077 | 0.155 | 0.039 | 0.914 | 0.873 | 0.393 |
| Reasoned emergency orders with merits follow-up | economic-regulation | 4920 | 1.000 | 0.824 | 0.000 | 0.034 | 2.628 | 0.622 | 0.547 | 0.518 | 0.437 | 0.188 | 0.043 | 0.275 | 0.138 | 0.640 | 0.603 | 0.410 |
| Reasoned emergency orders with merits follow-up | elections | 1928 | 1.000 | 0.751 | 0.010 | 0.492 | 2.742 | 0.693 | 0.530 | 0.469 | 0.383 | 0.200 | 0.071 | 0.191 | 0.031 | 0.761 | 0.738 | 0.408 |
| Reasoned emergency orders with merits follow-up | emergency-security | 2136 | 1.000 | 0.753 | 0.019 | 0.252 | 1.958 | 0.545 | 0.511 | 0.477 | 0.403 | 0.190 | 0.066 | 0.273 | 0.050 | 0.725 | 0.692 | 0.374 |
| Reasoned emergency orders with merits follow-up | governance | 18007 | 1.000 | 0.819 | 0.000 | 0.046 | 2.443 | 0.591 | 0.495 | 0.591 | 0.508 | 0.125 | 0.043 | 0.346 | 0.167 | 0.477 | 0.412 | 0.400 |
| Panel review with en banc safety valve | administration | 852 | 1.000 | 0.769 | 0.161 | 0.019 | 2.694 | 0.484 | 0.534 | 0.393 | 0.349 | 0.291 | 0.050 | 0.183 | 0.036 | 0.919 | 0.864 | 0.604 |
| Panel review with en banc safety valve | civil-rights | 18740 | 1.000 | 0.734 | 0.024 | 0.442 | 2.435 | 0.554 | 0.496 | 0.528 | 0.447 | 0.156 | 0.051 | 0.300 | 0.118 | 0.549 | 0.477 | 0.540 |
| Panel review with en banc safety valve | criminal-justice | 1417 | 1.000 | 0.696 | 0.194 | 0.591 | 2.356 | 0.588 | 0.518 | 0.361 | 0.304 | 0.240 | 0.066 | 0.144 | 0.033 | 0.928 | 0.867 | 0.568 |
| Panel review with en banc safety valve | economic-regulation | 4920 | 1.000 | 0.826 | 0.033 | 0.012 | 2.628 | 0.622 | 0.547 | 0.519 | 0.438 | 0.184 | 0.041 | 0.279 | 0.147 | 0.595 | 0.568 | 0.561 |
| Panel review with en banc safety valve | elections | 1928 | 1.000 | 0.745 | 0.108 | 0.467 | 2.742 | 0.693 | 0.530 | 0.438 | 0.375 | 0.215 | 0.072 | 0.179 | 0.028 | 0.750 | 0.711 | 0.592 |
| Panel review with en banc safety valve | emergency-security | 2136 | 1.000 | 0.750 | 0.202 | 0.269 | 1.958 | 0.545 | 0.511 | 0.459 | 0.374 | 0.201 | 0.051 | 0.257 | 0.050 | 0.717 | 0.665 | 0.555 |
| Panel review with en banc safety valve | governance | 18007 | 1.000 | 0.822 | 0.011 | 0.027 | 2.443 | 0.591 | 0.495 | 0.600 | 0.510 | 0.115 | 0.040 | 0.359 | 0.172 | 0.430 | 0.368 | 0.531 |
| Dual supreme courts with cross-checking invalidations | administration | 852 | 1.000 | 0.770 | 0.002 | 0.006 | 2.694 | 0.484 | 0.534 | 0.453 | 0.377 | 0.258 | 0.035 | 0.251 | 0.051 | 0.848 | 0.812 | 0.839 |
| Dual supreme courts with cross-checking invalidations | civil-rights | 18740 | 1.000 | 0.741 | 0.002 | 0.367 | 2.435 | 0.554 | 0.496 | 0.559 | 0.474 | 0.142 | 0.048 | 0.326 | 0.141 | 0.499 | 0.422 | 0.824 |
| Dual supreme courts with cross-checking invalidations | criminal-justice | 1417 | 1.000 | 0.729 | 0.009 | 0.466 | 2.356 | 0.588 | 0.518 | 0.419 | 0.349 | 0.212 | 0.068 | 0.201 | 0.047 | 0.864 | 0.819 | 0.822 |
| Dual supreme courts with cross-checking invalidations | economic-regulation | 4920 | 1.000 | 0.827 | 0.000 | 0.003 | 2.628 | 0.622 | 0.547 | 0.557 | 0.477 | 0.165 | 0.042 | 0.304 | 0.163 | 0.528 | 0.498 | 0.837 |
| Dual supreme courts with cross-checking invalidations | elections | 1928 | 1.000 | 0.762 | 0.011 | 0.377 | 2.742 | 0.693 | 0.530 | 0.490 | 0.406 | 0.202 | 0.064 | 0.210 | 0.050 | 0.688 | 0.650 | 0.836 |
| Dual supreme courts with cross-checking invalidations | emergency-security | 2136 | 1.000 | 0.757 | 0.024 | 0.129 | 1.958 | 0.545 | 0.511 | 0.513 | 0.438 | 0.184 | 0.047 | 0.287 | 0.078 | 0.664 | 0.620 | 0.803 |
| Dual supreme courts with cross-checking invalidations | governance | 18007 | 1.000 | 0.824 | 0.000 | 0.013 | 2.443 | 0.591 | 0.495 | 0.626 | 0.544 | 0.104 | 0.034 | 0.375 | 0.197 | 0.380 | 0.312 | 0.826 |
| Pre-enactment constitutional council | administration | 852 | 1.000 | 0.769 | 0.147 | 0.004 | 2.694 | 0.484 | 0.534 | 0.396 | 0.377 | 0.295 | 0.058 | 0.208 | 0.043 | 0.875 | 0.818 | 0.667 |
| Pre-enactment constitutional council | civil-rights | 18740 | 1.000 | 0.737 | 0.023 | 0.328 | 2.435 | 0.554 | 0.496 | 0.576 | 0.493 | 0.130 | 0.044 | 0.347 | 0.187 | 0.414 | 0.334 | 0.653 |
| Pre-enactment constitutional council | criminal-justice | 1417 | 1.000 | 0.702 | 0.190 | 0.426 | 2.356 | 0.588 | 0.518 | 0.398 | 0.318 | 0.207 | 0.070 | 0.157 | 0.042 | 0.883 | 0.823 | 0.649 |
| Pre-enactment constitutional council | economic-regulation | 4920 | 1.000 | 0.827 | 0.035 | 0.001 | 2.628 | 0.622 | 0.547 | 0.564 | 0.489 | 0.160 | 0.047 | 0.325 | 0.187 | 0.438 | 0.382 | 0.667 |
| Pre-enactment constitutional council | elections | 1928 | 1.000 | 0.749 | 0.105 | 0.343 | 2.742 | 0.693 | 0.530 | 0.453 | 0.397 | 0.180 | 0.058 | 0.221 | 0.073 | 0.669 | 0.616 | 0.665 |
| Pre-enactment constitutional council | emergency-security | 2136 | 1.000 | 0.749 | 0.192 | 0.135 | 1.958 | 0.545 | 0.511 | 0.490 | 0.401 | 0.185 | 0.055 | 0.283 | 0.107 | 0.657 | 0.599 | 0.631 |
| Pre-enactment constitutional council | governance | 18007 | 1.000 | 0.823 | 0.011 | 0.013 | 2.443 | 0.591 | 0.495 | 0.646 | 0.557 | 0.093 | 0.033 | 0.399 | 0.245 | 0.298 | 0.214 | 0.657 |
| Judicial review with delayed legislative override | administration | 852 | 1.000 | 0.765 | 0.168 | 0.041 | 2.694 | 0.484 | 0.534 | 0.373 | 0.310 | 0.332 | 0.045 | 0.205 | 0.033 | 0.927 | 0.870 | 0.433 |
| Judicial review with delayed legislative override | civil-rights | 18740 | 1.000 | 0.727 | 0.025 | 0.436 | 2.435 | 0.554 | 0.496 | 0.491 | 0.407 | 0.169 | 0.055 | 0.272 | 0.086 | 0.613 | 0.525 | 0.421 |
| Judicial review with delayed legislative override | criminal-justice | 1417 | 1.000 | 0.695 | 0.188 | 0.567 | 2.356 | 0.588 | 0.518 | 0.350 | 0.289 | 0.256 | 0.056 | 0.152 | 0.032 | 0.933 | 0.873 | 0.416 |
| Judicial review with delayed legislative override | economic-regulation | 4920 | 1.000 | 0.825 | 0.038 | 0.022 | 2.628 | 0.622 | 0.547 | 0.485 | 0.414 | 0.201 | 0.047 | 0.248 | 0.123 | 0.663 | 0.614 | 0.434 |
| Judicial review with delayed legislative override | elections | 1928 | 1.000 | 0.737 | 0.114 | 0.487 | 2.742 | 0.693 | 0.530 | 0.418 | 0.325 | 0.237 | 0.055 | 0.161 | 0.021 | 0.786 | 0.741 | 0.431 |
| Judicial review with delayed legislative override | emergency-security | 2136 | 1.000 | 0.747 | 0.203 | 0.294 | 1.958 | 0.545 | 0.511 | 0.434 | 0.353 | 0.225 | 0.063 | 0.240 | 0.035 | 0.749 | 0.697 | 0.397 |
| Judicial review with delayed legislative override | governance | 18007 | 1.000 | 0.821 | 0.012 | 0.030 | 2.443 | 0.591 | 0.495 | 0.564 | 0.477 | 0.124 | 0.042 | 0.324 | 0.147 | 0.503 | 0.428 | 0.424 |
| Retention-election accountability court | administration | 852 | 1.000 | 0.769 | 0.158 | 0.010 | 2.694 | 0.484 | 0.534 | 0.420 | 0.331 | 0.297 | 0.053 | 0.194 | 0.038 | 0.892 | 0.829 | 0.465 |
| Retention-election accountability court | civil-rights | 18740 | 1.000 | 0.708 | 0.022 | 0.290 | 2.435 | 0.554 | 0.496 | 0.510 | 0.432 | 0.145 | 0.048 | 0.301 | 0.106 | 0.498 | 0.395 | 0.452 |
| Retention-election accountability court | criminal-justice | 1417 | 1.000 | 0.699 | 0.184 | 0.401 | 2.356 | 0.588 | 0.518 | 0.366 | 0.307 | 0.246 | 0.064 | 0.149 | 0.037 | 0.897 | 0.827 | 0.447 |
| Retention-election accountability court | economic-regulation | 4920 | 1.000 | 0.827 | 0.035 | 0.004 | 2.628 | 0.622 | 0.547 | 0.520 | 0.428 | 0.178 | 0.043 | 0.279 | 0.152 | 0.520 | 0.461 | 0.466 |
| Retention-election accountability court | elections | 1928 | 1.000 | 0.747 | 0.103 | 0.330 | 2.742 | 0.693 | 0.530 | 0.442 | 0.372 | 0.192 | 0.053 | 0.183 | 0.033 | 0.697 | 0.635 | 0.464 |
| Retention-election accountability court | emergency-security | 2136 | 1.000 | 0.752 | 0.184 | 0.123 | 1.958 | 0.545 | 0.511 | 0.452 | 0.373 | 0.184 | 0.047 | 0.255 | 0.052 | 0.684 | 0.619 | 0.431 |
| Retention-election accountability court | governance | 18007 | 1.000 | 0.823 | 0.011 | 0.012 | 2.443 | 0.591 | 0.495 | 0.606 | 0.516 | 0.104 | 0.036 | 0.363 | 0.170 | 0.364 | 0.269 | 0.456 |
| Hybrid court balancing independence and accountability | administration | 852 | 1.000 | 0.770 | 0.000 | 0.009 | 2.694 | 0.484 | 0.534 | 0.444 | 0.386 | 0.272 | 0.049 | 0.210 | 0.049 | 0.850 | 0.833 | 0.771 |
| Hybrid court balancing independence and accountability | civil-rights | 18740 | 1.000 | 0.738 | 0.001 | 0.416 | 2.435 | 0.554 | 0.496 | 0.553 | 0.459 | 0.152 | 0.053 | 0.313 | 0.136 | 0.511 | 0.450 | 0.696 |
| Hybrid court balancing independence and accountability | criminal-justice | 1417 | 1.000 | 0.727 | 0.007 | 0.517 | 2.356 | 0.588 | 0.518 | 0.430 | 0.327 | 0.258 | 0.073 | 0.171 | 0.045 | 0.870 | 0.840 | 0.731 |
| Hybrid court balancing independence and accountability | economic-regulation | 4920 | 1.000 | 0.827 | 0.000 | 0.007 | 2.628 | 0.622 | 0.547 | 0.533 | 0.464 | 0.167 | 0.048 | 0.282 | 0.159 | 0.543 | 0.530 | 0.728 |
| Hybrid court balancing independence and accountability | elections | 1928 | 1.000 | 0.761 | 0.009 | 0.378 | 2.742 | 0.693 | 0.530 | 0.476 | 0.395 | 0.191 | 0.072 | 0.220 | 0.046 | 0.697 | 0.679 | 0.760 |
| Hybrid court balancing independence and accountability | emergency-security | 2136 | 1.000 | 0.754 | 0.016 | 0.147 | 1.958 | 0.545 | 0.511 | 0.505 | 0.434 | 0.179 | 0.049 | 0.289 | 0.076 | 0.668 | 0.641 | 0.723 |
| Hybrid court balancing independence and accountability | governance | 18007 | 1.000 | 0.823 | 0.000 | 0.020 | 2.443 | 0.591 | 0.495 | 0.614 | 0.531 | 0.109 | 0.039 | 0.370 | 0.193 | 0.392 | 0.339 | 0.695 |

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
| Current-style federal supreme court | 0.019 | 0.019 |
| Staggered 18-year nonrenewable terms | 0.018 | 0.019 |
| Fifteen-justice supermajority commission court | 0.018 | 0.020 |
| Supermajority required to invalidate laws | 0.018 | 0.020 |
| Strict recusal with substitute justices | 0.017 | 0.020 |
| Reasoned emergency orders with merits follow-up | 0.018 | 0.020 |
| Panel review with en banc safety valve | 0.018 | 0.020 |
| Dual supreme courts with cross-checking invalidations | 0.018 | 0.015 |
| Pre-enactment constitutional council | 0.017 | 0.019 |
| Judicial review with delayed legislative override | 0.018 | 0.020 |
| Retention-election accountability court | 0.017 | 0.020 |
| Hybrid court balancing independence and accountability | 0.018 | 0.018 |

## Calibration Diagnostics

| Profile | Target | Observed | 95% band | Range | Gap | Status |
| --- | --- | ---: | ---: | ---: | ---: | --- |
| scdb-postwar-merits-1946-2024 | Speech docket share | 0.308 | 0.307-0.310 | 0.060-0.091 | 0.217 | outside |
| scdb-postwar-merits-1946-2024 | Civil-rights and privacy docket share | 0.169 | 0.168-0.170 | 0.135-0.169 | 0.000 | outside |
| scdb-postwar-merits-1946-2024 | Criminal procedure docket share | 0.073 | 0.072-0.074 | 0.207-0.244 | 0.134 | outside |
| scdb-postwar-merits-1946-2024 | Federalism docket share | 0.098 | 0.097-0.098 | 0.041-0.071 | 0.027 | outside |
| scdb-postwar-merits-1946-2024 | Election-law docket share | 0.151 | 0.150-0.152 | 0.013-0.040 | 0.111 | outside |
| scdb-postwar-merits-1946-2024 | Emergency-powers merits share | 0.090 | 0.090-0.091 | 0.000-0.012 | 0.078 | outside |
| scdb-postwar-merits-1946-2024 | Administrative and economic regulation share | 0.111 | 0.110-0.111 | 0.199-0.236 | 0.088 | outside |
| scdb-modern-merits-2000-2024 | Speech docket share | 0.308 | 0.307-0.310 | 0.039-0.080 | 0.228 | outside |
| scdb-modern-merits-2000-2024 | Civil-rights and privacy docket share | 0.169 | 0.168-0.170 | 0.137-0.191 | 0.000 | within |
| scdb-modern-merits-2000-2024 | Criminal procedure docket share | 0.073 | 0.072-0.074 | 0.230-0.289 | 0.157 | outside |
| scdb-modern-merits-2000-2024 | Federalism docket share | 0.098 | 0.097-0.098 | 0.037-0.078 | 0.020 | outside |
| scdb-modern-merits-2000-2024 | Election-law docket share | 0.151 | 0.150-0.152 | 0.009-0.043 | 0.108 | outside |
| scdb-modern-merits-2000-2024 | Emergency-powers merits share | 0.090 | 0.090-0.091 | 0.000-0.019 | 0.071 | outside |
| scdb-modern-merits-2000-2024 | Administrative and economic regulation share | 0.111 | 0.110-0.111 | 0.193-0.250 | 0.082 | outside |
| scotusblog-interim-2024 | Significant interim docket relief rate | 0.471 | 0.467-0.474 | 0.200-0.450 | 0.021 | outside |
| gallup-court-confidence-2024 | Public court trust and approval | 0.125 | 0.124-0.126 | 0.350-0.490 | 0.225 | outside |
