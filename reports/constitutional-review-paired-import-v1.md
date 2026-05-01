# Constitutional Review Paired Import Campaign v1

- runs per case: 120
- seed: 20260501
- input: 986 imported legislative rows across 29 scenarios

## Top Directional Scores by Case

### Synthetic baseline

Synthetic docket using the same world assumptions as the imported comparisons.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.670
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.743
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.010
- lowest emergency relief rate: Retention-election accountability court at 0.342
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.424
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.277

### All imported legislative outputs

Docket generated from every imported legislative campaign row.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.840
- strongest rights protection: Pre-enactment constitutional council at 0.825
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.760
- lowest defiance rate: Pre-enactment constitutional council at 0.052

### High-capture legislative outputs

Imported rows with high lobby-capture or proposer-gain signals.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.816
- strongest rights protection: Pre-enactment constitutional council at 0.814
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.705
- lowest defiance rate: Pre-enactment constitutional council at 0.079

### High-volatility legislative outputs

Imported rows with high policy-shift, reversal, or status-quo volatility signals.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.732
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.779
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Reasoned emergency orders with merits follow-up at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.482
- lowest defiance rate: Pre-enactment constitutional council at 0.219

### Low-mandate legislative outputs

Imported rows with weak public mandate, low support, or public-preference distortion.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.775
- strongest rights protection: Pre-enactment constitutional council at 0.777
- lowest shadow-docket abuse: Fifteen-justice supermajority commission court at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Pre-enactment constitutional council at 0.579
- lowest defiance rate: Pre-enactment constitutional council at 0.142

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.678 | 0.883 | 0.752 | 0.178 | 0.163 | 0.412 | 0.294 | 0.645 | 0.203 | 0.278 | 0.521 | 0.448 | 0.359 | 0.199 | 0.057 | 0.226 | 2.451 | 0.592 | 0.446 |
| Staggered 18-year nonrenewable terms | 0.699 | 0.894 | 0.760 | 0.162 | 0.161 | 0.344 | 0.249 | 0.658 | 0.168 | 0.269 | 0.535 | 0.463 | 0.379 | 0.182 | 0.055 | 0.245 | 2.451 | 0.592 | 0.454 |
| Fifteen-justice supermajority commission court | 0.747 | 0.934 | 0.781 | 0.138 | 0.038 | 0.117 | 0.233 | 0.736 | 0.197 | 0.229 | 0.561 | 0.528 | 0.449 | 0.153 | 0.049 | 0.297 | 2.451 | 0.592 | 0.455 |
| Supermajority required to invalidate laws | 0.736 | 0.937 | 0.779 | 0.155 | 0.040 | 0.127 | 0.232 | 0.710 | 0.200 | 0.231 | 0.558 | 0.521 | 0.438 | 0.161 | 0.050 | 0.286 | 2.451 | 0.592 | 0.436 |
| Strict recusal with substitute justices | 0.754 | 0.935 | 0.782 | 0.137 | 0.038 | 0.128 | 0.222 | 0.758 | 0.188 | 0.227 | 0.563 | 0.547 | 0.466 | 0.148 | 0.047 | 0.315 | 2.451 | 0.592 | 0.456 |
| Reasoned emergency orders with merits follow-up | 0.741 | 0.933 | 0.779 | 0.151 | 0.002 | 0.099 | 0.269 | 0.762 | 0.269 | 0.230 | 0.551 | 0.536 | 0.452 | 0.159 | 0.053 | 0.299 | 2.451 | 0.592 | 0.446 |
| Panel review with en banc safety valve | 0.744 | 0.931 | 0.781 | 0.137 | 0.038 | 0.126 | 0.241 | 0.750 | 0.205 | 0.231 | 0.559 | 0.541 | 0.454 | 0.153 | 0.048 | 0.304 | 2.451 | 0.592 | 0.574 |
| Dual supreme courts with cross-checking invalidations | 0.746 | 0.950 | 0.787 | 0.127 | 0.003 | 0.081 | 0.187 | 0.777 | 0.187 | 0.228 | 0.571 | 0.565 | 0.484 | 0.138 | 0.046 | 0.325 | 2.451 | 0.592 | 0.842 |
| Pre-enactment constitutional council | 0.763 | 0.968 | 0.784 | 0.119 | 0.036 | 0.117 | 0.177 | 0.788 | 0.150 | 0.220 | 0.572 | 0.582 | 0.497 | 0.125 | 0.042 | 0.343 | 2.451 | 0.592 | 0.709 |
| Judicial review with delayed legislative override | 0.738 | 0.923 | 0.777 | 0.146 | 0.039 | 0.129 | 0.242 | 0.725 | 0.206 | 0.245 | 0.568 | 0.503 | 0.421 | 0.164 | 0.051 | 0.274 | 2.451 | 0.592 | 0.449 |
| Retention-election accountability court | 0.760 | 0.934 | 0.772 | 0.133 | 0.036 | 0.096 | 0.160 | 0.747 | 0.134 | 0.236 | 0.584 | 0.533 | 0.448 | 0.143 | 0.042 | 0.303 | 2.451 | 0.592 | 0.469 |
| Hybrid court balancing independence and accountability | 0.758 | 0.950 | 0.785 | 0.129 | 0.002 | 0.088 | 0.211 | 0.778 | 0.211 | 0.219 | 0.565 | 0.557 | 0.479 | 0.140 | 0.048 | 0.315 | 2.451 | 0.592 | 0.564 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 1.000 | 0.758 | 0.154 | 0.236 | 2.418 | 0.573 | 0.494 | 0.555 | 0.475 | 0.129 | 0.032 | 0.348 | 0.265 | 0.668 | 0.375 |
| Current-style federal supreme court | 2 | 12000 | 1.000 | 0.745 | 0.169 | 0.339 | 2.453 | 0.591 | 0.507 | 0.444 | 0.342 | 0.210 | 0.059 | 0.216 | 0.027 | 0.726 | 0.687 |
| Current-style federal supreme court | 3 | 12000 | 1.000 | 0.747 | 0.168 | 0.314 | 2.454 | 0.597 | 0.511 | 0.400 | 0.313 | 0.223 | 0.071 | 0.172 | 0.003 | 0.744 | 0.761 |
| Current-style federal supreme court | 4 | 12000 | 1.000 | 0.757 | 0.160 | 0.289 | 2.480 | 0.608 | 0.509 | 0.394 | 0.304 | 0.234 | 0.066 | 0.169 | 0.002 | 0.755 | 0.785 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 1.000 | 0.767 | 0.150 | 0.192 | 2.418 | 0.573 | 0.494 | 0.568 | 0.492 | 0.117 | 0.027 | 0.362 | 0.286 | 0.640 | 0.341 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 1.000 | 0.753 | 0.168 | 0.291 | 2.453 | 0.591 | 0.507 | 0.449 | 0.364 | 0.195 | 0.060 | 0.230 | 0.035 | 0.673 | 0.631 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 1.000 | 0.756 | 0.168 | 0.268 | 2.454 | 0.597 | 0.511 | 0.422 | 0.329 | 0.208 | 0.067 | 0.197 | 0.004 | 0.675 | 0.686 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 1.000 | 0.765 | 0.157 | 0.248 | 2.480 | 0.608 | 0.509 | 0.411 | 0.331 | 0.208 | 0.068 | 0.192 | 0.002 | 0.676 | 0.696 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 1.000 | 0.787 | 0.037 | 0.179 | 2.418 | 0.573 | 0.494 | 0.612 | 0.541 | 0.100 | 0.026 | 0.405 | 0.351 | 0.565 | 0.268 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 1.000 | 0.775 | 0.040 | 0.271 | 2.453 | 0.591 | 0.507 | 0.519 | 0.450 | 0.154 | 0.056 | 0.296 | 0.085 | 0.539 | 0.506 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 1.000 | 0.778 | 0.039 | 0.249 | 2.454 | 0.597 | 0.511 | 0.494 | 0.406 | 0.173 | 0.057 | 0.248 | 0.031 | 0.538 | 0.587 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 1.000 | 0.786 | 0.038 | 0.234 | 2.480 | 0.608 | 0.509 | 0.489 | 0.399 | 0.185 | 0.059 | 0.240 | 0.014 | 0.564 | 0.597 |
| Supermajority required to invalidate laws | 1 | 12000 | 1.000 | 0.785 | 0.038 | 0.176 | 2.418 | 0.573 | 0.494 | 0.615 | 0.544 | 0.100 | 0.025 | 0.391 | 0.335 | 0.578 | 0.283 |
| Supermajority required to invalidate laws | 2 | 12000 | 1.000 | 0.773 | 0.041 | 0.269 | 2.453 | 0.591 | 0.507 | 0.511 | 0.429 | 0.169 | 0.056 | 0.284 | 0.063 | 0.580 | 0.553 |
| Supermajority required to invalidate laws | 3 | 12000 | 1.000 | 0.776 | 0.040 | 0.251 | 2.454 | 0.597 | 0.511 | 0.477 | 0.390 | 0.187 | 0.060 | 0.239 | 0.016 | 0.590 | 0.625 |
| Supermajority required to invalidate laws | 4 | 12000 | 1.000 | 0.784 | 0.038 | 0.234 | 2.480 | 0.608 | 0.509 | 0.479 | 0.389 | 0.187 | 0.058 | 0.230 | 0.006 | 0.605 | 0.632 |
| Strict recusal with substitute justices | 1 | 12000 | 1.000 | 0.788 | 0.037 | 0.170 | 2.418 | 0.573 | 0.494 | 0.628 | 0.556 | 0.101 | 0.024 | 0.408 | 0.371 | 0.548 | 0.252 |
| Strict recusal with substitute justices | 2 | 12000 | 1.000 | 0.775 | 0.040 | 0.258 | 2.453 | 0.591 | 0.507 | 0.541 | 0.462 | 0.146 | 0.052 | 0.319 | 0.113 | 0.497 | 0.462 |
| Strict recusal with substitute justices | 3 | 12000 | 1.000 | 0.779 | 0.039 | 0.238 | 2.454 | 0.597 | 0.511 | 0.516 | 0.430 | 0.172 | 0.054 | 0.271 | 0.057 | 0.492 | 0.544 |
| Strict recusal with substitute justices | 4 | 12000 | 1.000 | 0.787 | 0.037 | 0.223 | 2.480 | 0.608 | 0.509 | 0.504 | 0.415 | 0.173 | 0.056 | 0.262 | 0.031 | 0.524 | 0.566 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 1.000 | 0.784 | 0.002 | 0.218 | 2.418 | 0.573 | 0.494 | 0.628 | 0.552 | 0.099 | 0.031 | 0.409 | 0.348 | 0.574 | 0.287 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 1.000 | 0.772 | 0.002 | 0.306 | 2.453 | 0.591 | 0.507 | 0.527 | 0.443 | 0.165 | 0.058 | 0.294 | 0.091 | 0.586 | 0.563 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 1.000 | 0.776 | 0.002 | 0.285 | 2.454 | 0.597 | 0.511 | 0.497 | 0.411 | 0.186 | 0.060 | 0.252 | 0.035 | 0.600 | 0.630 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 1.000 | 0.784 | 0.002 | 0.266 | 2.480 | 0.608 | 0.509 | 0.493 | 0.402 | 0.184 | 0.062 | 0.241 | 0.018 | 0.609 | 0.632 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.786 | 0.037 | 0.189 | 2.418 | 0.573 | 0.494 | 0.626 | 0.548 | 0.100 | 0.026 | 0.407 | 0.362 | 0.561 | 0.266 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.774 | 0.039 | 0.281 | 2.453 | 0.591 | 0.507 | 0.541 | 0.451 | 0.157 | 0.049 | 0.302 | 0.105 | 0.533 | 0.508 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.777 | 0.039 | 0.257 | 2.454 | 0.597 | 0.511 | 0.501 | 0.415 | 0.173 | 0.059 | 0.258 | 0.047 | 0.536 | 0.589 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.785 | 0.038 | 0.238 | 2.480 | 0.608 | 0.509 | 0.498 | 0.404 | 0.183 | 0.059 | 0.247 | 0.022 | 0.565 | 0.604 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.793 | 0.003 | 0.136 | 2.418 | 0.573 | 0.494 | 0.643 | 0.574 | 0.090 | 0.025 | 0.420 | 0.385 | 0.531 | 0.228 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.781 | 0.003 | 0.219 | 2.453 | 0.591 | 0.507 | 0.566 | 0.488 | 0.133 | 0.047 | 0.331 | 0.119 | 0.469 | 0.423 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.784 | 0.003 | 0.206 | 2.454 | 0.597 | 0.511 | 0.533 | 0.444 | 0.160 | 0.055 | 0.281 | 0.062 | 0.476 | 0.524 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.792 | 0.003 | 0.189 | 2.480 | 0.608 | 0.509 | 0.520 | 0.429 | 0.170 | 0.059 | 0.269 | 0.034 | 0.515 | 0.555 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.790 | 0.036 | 0.132 | 2.418 | 0.573 | 0.494 | 0.637 | 0.565 | 0.088 | 0.025 | 0.414 | 0.407 | 0.515 | 0.214 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.778 | 0.038 | 0.202 | 2.453 | 0.591 | 0.507 | 0.579 | 0.497 | 0.126 | 0.045 | 0.346 | 0.162 | 0.403 | 0.350 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.781 | 0.036 | 0.194 | 2.454 | 0.597 | 0.511 | 0.571 | 0.466 | 0.141 | 0.048 | 0.311 | 0.110 | 0.370 | 0.396 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.789 | 0.036 | 0.182 | 2.480 | 0.608 | 0.509 | 0.542 | 0.460 | 0.147 | 0.051 | 0.301 | 0.092 | 0.399 | 0.425 |
| Judicial review with delayed legislative override | 1 | 12000 | 1.000 | 0.784 | 0.038 | 0.186 | 2.418 | 0.573 | 0.494 | 0.605 | 0.522 | 0.110 | 0.026 | 0.390 | 0.324 | 0.586 | 0.284 |
| Judicial review with delayed legislative override | 2 | 12000 | 1.000 | 0.770 | 0.041 | 0.280 | 2.453 | 0.591 | 0.507 | 0.487 | 0.415 | 0.169 | 0.054 | 0.263 | 0.063 | 0.604 | 0.558 |
| Judicial review with delayed legislative override | 3 | 12000 | 1.000 | 0.774 | 0.040 | 0.258 | 2.454 | 0.597 | 0.511 | 0.461 | 0.374 | 0.187 | 0.061 | 0.225 | 0.018 | 0.619 | 0.637 |
| Judicial review with delayed legislative override | 4 | 12000 | 1.000 | 0.781 | 0.038 | 0.244 | 2.480 | 0.608 | 0.509 | 0.459 | 0.373 | 0.191 | 0.061 | 0.220 | 0.007 | 0.630 | 0.645 |
| Retention-election accountability court | 1 | 12000 | 1.000 | 0.781 | 0.035 | 0.123 | 2.418 | 0.573 | 0.494 | 0.611 | 0.536 | 0.097 | 0.023 | 0.397 | 0.359 | 0.543 | 0.229 |
| Retention-election accountability court | 2 | 12000 | 1.000 | 0.763 | 0.037 | 0.178 | 2.453 | 0.591 | 0.507 | 0.533 | 0.445 | 0.143 | 0.044 | 0.297 | 0.085 | 0.482 | 0.411 |
| Retention-election accountability court | 3 | 12000 | 1.000 | 0.768 | 0.037 | 0.168 | 2.454 | 0.597 | 0.511 | 0.501 | 0.410 | 0.164 | 0.051 | 0.268 | 0.034 | 0.466 | 0.482 |
| Retention-election accountability court | 4 | 12000 | 1.000 | 0.774 | 0.035 | 0.170 | 2.480 | 0.608 | 0.509 | 0.487 | 0.402 | 0.167 | 0.050 | 0.251 | 0.019 | 0.504 | 0.518 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.790 | 0.002 | 0.162 | 2.418 | 0.573 | 0.494 | 0.635 | 0.573 | 0.096 | 0.025 | 0.417 | 0.379 | 0.536 | 0.246 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.779 | 0.002 | 0.244 | 2.453 | 0.591 | 0.507 | 0.555 | 0.468 | 0.140 | 0.051 | 0.314 | 0.122 | 0.480 | 0.460 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.782 | 0.002 | 0.227 | 2.454 | 0.597 | 0.511 | 0.529 | 0.445 | 0.158 | 0.058 | 0.276 | 0.065 | 0.486 | 0.548 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.790 | 0.002 | 0.212 | 2.480 | 0.608 | 0.509 | 0.509 | 0.431 | 0.168 | 0.060 | 0.255 | 0.039 | 0.523 | 0.576 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 3891 | 1.000 | 0.828 | 0.202 | 0.029 | 2.659 | 0.464 | 0.501 | 0.464 | 0.386 | 0.254 | 0.044 | 0.280 | 0.095 | 0.730 | 0.653 |
| Current-style federal supreme court | criminal_procedure | 3809 | 1.000 | 0.748 | 0.236 | 0.246 | 2.356 | 0.569 | 0.491 | 0.446 | 0.349 | 0.193 | 0.053 | 0.233 | 0.089 | 0.727 | 0.651 |
| Current-style federal supreme court | election_law | 9850 | 1.000 | 0.759 | 0.119 | 0.188 | 2.464 | 0.668 | 0.514 | 0.441 | 0.360 | 0.188 | 0.059 | 0.202 | 0.069 | 0.718 | 0.672 |
| Current-style federal supreme court | emergency_powers | 4586 | 1.000 | 0.773 | 0.328 | 0.122 | 2.314 | 0.533 | 0.499 | 0.447 | 0.354 | 0.189 | 0.047 | 0.247 | 0.077 | 0.711 | 0.644 |
| Current-style federal supreme court | equality | 18176 | 1.000 | 0.711 | 0.095 | 0.516 | 2.455 | 0.583 | 0.501 | 0.449 | 0.354 | 0.201 | 0.065 | 0.222 | 0.061 | 0.726 | 0.645 |
| Current-style federal supreme court | federalism | 3829 | 1.000 | 0.830 | 0.208 | 0.034 | 2.648 | 0.802 | 0.583 | 0.447 | 0.369 | 0.187 | 0.054 | 0.177 | 0.095 | 0.722 | 0.637 |
| Current-style federal supreme court | speech | 3859 | 1.000 | 0.747 | 0.241 | 0.237 | 2.254 | 0.457 | 0.452 | 0.448 | 0.357 | 0.192 | 0.047 | 0.265 | 0.091 | 0.729 | 0.654 |
| Staggered 18-year nonrenewable terms | administrative_state | 3891 | 1.000 | 0.833 | 0.199 | 0.013 | 2.659 | 0.464 | 0.501 | 0.495 | 0.390 | 0.246 | 0.040 | 0.292 | 0.100 | 0.679 | 0.594 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 3809 | 1.000 | 0.752 | 0.239 | 0.227 | 2.356 | 0.569 | 0.491 | 0.460 | 0.389 | 0.174 | 0.049 | 0.239 | 0.094 | 0.677 | 0.595 |
| Staggered 18-year nonrenewable terms | election_law | 9850 | 1.000 | 0.772 | 0.115 | 0.136 | 2.464 | 0.668 | 0.514 | 0.462 | 0.377 | 0.167 | 0.055 | 0.225 | 0.080 | 0.658 | 0.608 |
| Staggered 18-year nonrenewable terms | emergency_powers | 4586 | 1.000 | 0.781 | 0.324 | 0.113 | 2.314 | 0.533 | 0.499 | 0.453 | 0.375 | 0.178 | 0.055 | 0.266 | 0.081 | 0.654 | 0.578 |
| Staggered 18-year nonrenewable terms | equality | 18176 | 1.000 | 0.721 | 0.094 | 0.448 | 2.455 | 0.583 | 0.501 | 0.460 | 0.377 | 0.180 | 0.064 | 0.247 | 0.070 | 0.665 | 0.578 |
| Staggered 18-year nonrenewable terms | federalism | 3829 | 1.000 | 0.836 | 0.200 | 0.026 | 2.648 | 0.802 | 0.583 | 0.459 | 0.374 | 0.180 | 0.046 | 0.188 | 0.100 | 0.672 | 0.581 |
| Staggered 18-year nonrenewable terms | speech | 3859 | 1.000 | 0.751 | 0.243 | 0.209 | 2.254 | 0.457 | 0.452 | 0.462 | 0.381 | 0.178 | 0.049 | 0.277 | 0.095 | 0.678 | 0.597 |
| Fifteen-justice supermajority commission court | administrative_state | 3891 | 1.000 | 0.844 | 0.056 | 0.012 | 2.659 | 0.464 | 0.501 | 0.544 | 0.477 | 0.197 | 0.037 | 0.351 | 0.132 | 0.575 | 0.500 |
| Fifteen-justice supermajority commission court | criminal_procedure | 3809 | 1.000 | 0.777 | 0.072 | 0.210 | 2.356 | 0.569 | 0.491 | 0.519 | 0.458 | 0.153 | 0.051 | 0.303 | 0.125 | 0.582 | 0.511 |
| Fifteen-justice supermajority commission court | election_law | 9850 | 1.000 | 0.794 | 0.023 | 0.103 | 2.464 | 0.668 | 0.514 | 0.522 | 0.445 | 0.140 | 0.046 | 0.277 | 0.115 | 0.532 | 0.507 |
| Fifteen-justice supermajority commission court | emergency_powers | 4586 | 1.000 | 0.809 | 0.086 | 0.137 | 2.314 | 0.533 | 0.499 | 0.534 | 0.465 | 0.147 | 0.047 | 0.327 | 0.116 | 0.546 | 0.481 |
| Fifteen-justice supermajority commission court | equality | 18176 | 1.000 | 0.741 | 0.015 | 0.414 | 2.455 | 0.583 | 0.501 | 0.532 | 0.439 | 0.154 | 0.055 | 0.294 | 0.116 | 0.541 | 0.470 |
| Fifteen-justice supermajority commission court | federalism | 3829 | 1.000 | 0.852 | 0.054 | 0.013 | 2.648 | 0.802 | 0.583 | 0.522 | 0.460 | 0.147 | 0.045 | 0.236 | 0.134 | 0.572 | 0.493 |
| Fifteen-justice supermajority commission court | speech | 3859 | 1.000 | 0.777 | 0.065 | 0.228 | 2.254 | 0.457 | 0.452 | 0.522 | 0.443 | 0.147 | 0.053 | 0.329 | 0.127 | 0.581 | 0.511 |
| Supermajority required to invalidate laws | administrative_state | 3891 | 1.000 | 0.843 | 0.058 | 0.013 | 2.659 | 0.464 | 0.501 | 0.544 | 0.477 | 0.212 | 0.036 | 0.337 | 0.121 | 0.604 | 0.529 |
| Supermajority required to invalidate laws | criminal_procedure | 3809 | 1.000 | 0.775 | 0.074 | 0.193 | 2.356 | 0.569 | 0.491 | 0.502 | 0.434 | 0.167 | 0.048 | 0.290 | 0.113 | 0.610 | 0.536 |
| Supermajority required to invalidate laws | election_law | 9850 | 1.000 | 0.791 | 0.023 | 0.112 | 2.464 | 0.668 | 0.514 | 0.515 | 0.432 | 0.145 | 0.050 | 0.265 | 0.102 | 0.574 | 0.542 |
| Supermajority required to invalidate laws | emergency_powers | 4586 | 1.000 | 0.805 | 0.089 | 0.125 | 2.314 | 0.533 | 0.499 | 0.539 | 0.454 | 0.151 | 0.045 | 0.312 | 0.103 | 0.575 | 0.511 |
| Supermajority required to invalidate laws | equality | 18176 | 1.000 | 0.739 | 0.015 | 0.419 | 2.455 | 0.583 | 0.501 | 0.514 | 0.426 | 0.165 | 0.055 | 0.284 | 0.097 | 0.584 | 0.509 |
| Supermajority required to invalidate laws | federalism | 3829 | 1.000 | 0.851 | 0.058 | 0.019 | 2.648 | 0.802 | 0.583 | 0.526 | 0.455 | 0.147 | 0.044 | 0.229 | 0.121 | 0.600 | 0.518 |
| Supermajority required to invalidate laws | speech | 3859 | 1.000 | 0.777 | 0.066 | 0.199 | 2.254 | 0.457 | 0.452 | 0.530 | 0.438 | 0.149 | 0.047 | 0.320 | 0.115 | 0.612 | 0.540 |
| Strict recusal with substitute justices | administrative_state | 3891 | 1.000 | 0.844 | 0.055 | 0.008 | 2.659 | 0.464 | 0.501 | 0.554 | 0.485 | 0.199 | 0.042 | 0.366 | 0.153 | 0.546 | 0.473 |
| Strict recusal with substitute justices | criminal_procedure | 3809 | 1.000 | 0.778 | 0.072 | 0.207 | 2.356 | 0.569 | 0.491 | 0.533 | 0.450 | 0.143 | 0.048 | 0.305 | 0.145 | 0.555 | 0.484 |
| Strict recusal with substitute justices | election_law | 9850 | 1.000 | 0.795 | 0.023 | 0.095 | 2.464 | 0.668 | 0.514 | 0.546 | 0.465 | 0.138 | 0.044 | 0.294 | 0.135 | 0.490 | 0.467 |
| Strict recusal with substitute justices | emergency_powers | 4586 | 1.000 | 0.808 | 0.083 | 0.118 | 2.314 | 0.533 | 0.499 | 0.556 | 0.474 | 0.147 | 0.042 | 0.345 | 0.140 | 0.514 | 0.450 |
| Strict recusal with substitute justices | equality | 18176 | 1.000 | 0.742 | 0.015 | 0.397 | 2.455 | 0.583 | 0.501 | 0.548 | 0.459 | 0.145 | 0.052 | 0.314 | 0.142 | 0.501 | 0.434 |
| Strict recusal with substitute justices | federalism | 3829 | 1.000 | 0.852 | 0.055 | 0.015 | 2.648 | 0.802 | 0.583 | 0.536 | 0.473 | 0.148 | 0.042 | 0.249 | 0.153 | 0.544 | 0.466 |
| Strict recusal with substitute justices | speech | 3859 | 1.000 | 0.778 | 0.065 | 0.224 | 2.254 | 0.457 | 0.452 | 0.557 | 0.477 | 0.143 | 0.043 | 0.360 | 0.147 | 0.550 | 0.482 |
| Reasoned emergency orders with merits follow-up | administrative_state | 3891 | 1.000 | 0.844 | 0.000 | 0.021 | 2.659 | 0.464 | 0.501 | 0.557 | 0.489 | 0.209 | 0.039 | 0.354 | 0.141 | 0.597 | 0.527 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 3809 | 1.000 | 0.786 | 0.003 | 0.227 | 2.356 | 0.569 | 0.491 | 0.546 | 0.459 | 0.155 | 0.048 | 0.293 | 0.133 | 0.606 | 0.538 |
| Reasoned emergency orders with merits follow-up | election_law | 9850 | 1.000 | 0.788 | 0.002 | 0.148 | 2.464 | 0.668 | 0.514 | 0.533 | 0.442 | 0.143 | 0.051 | 0.273 | 0.116 | 0.583 | 0.549 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 4586 | 1.000 | 0.811 | 0.009 | 0.123 | 2.314 | 0.533 | 0.499 | 0.557 | 0.480 | 0.145 | 0.049 | 0.342 | 0.124 | 0.576 | 0.518 |
| Reasoned emergency orders with merits follow-up | equality | 18176 | 1.000 | 0.734 | 0.001 | 0.492 | 2.455 | 0.583 | 0.501 | 0.522 | 0.438 | 0.162 | 0.059 | 0.295 | 0.115 | 0.595 | 0.517 |
| Reasoned emergency orders with merits follow-up | federalism | 3829 | 1.000 | 0.852 | 0.000 | 0.025 | 2.648 | 0.802 | 0.583 | 0.541 | 0.465 | 0.150 | 0.051 | 0.246 | 0.142 | 0.593 | 0.518 |
| Reasoned emergency orders with merits follow-up | speech | 3859 | 1.000 | 0.785 | 0.004 | 0.231 | 2.254 | 0.457 | 0.452 | 0.551 | 0.455 | 0.160 | 0.051 | 0.335 | 0.133 | 0.609 | 0.541 |
| Panel review with en banc safety valve | administrative_state | 3891 | 1.000 | 0.844 | 0.054 | 0.010 | 2.659 | 0.464 | 0.501 | 0.556 | 0.468 | 0.212 | 0.035 | 0.351 | 0.146 | 0.573 | 0.502 |
| Panel review with en banc safety valve | criminal_procedure | 3809 | 1.000 | 0.776 | 0.074 | 0.222 | 2.356 | 0.569 | 0.491 | 0.528 | 0.459 | 0.146 | 0.051 | 0.298 | 0.138 | 0.581 | 0.513 |
| Panel review with en banc safety valve | election_law | 9850 | 1.000 | 0.794 | 0.023 | 0.103 | 2.464 | 0.668 | 0.514 | 0.536 | 0.445 | 0.146 | 0.049 | 0.278 | 0.127 | 0.529 | 0.509 |
| Panel review with en banc safety valve | emergency_powers | 4586 | 1.000 | 0.809 | 0.085 | 0.131 | 2.314 | 0.533 | 0.499 | 0.565 | 0.474 | 0.143 | 0.036 | 0.329 | 0.134 | 0.539 | 0.482 |
| Panel review with en banc safety valve | equality | 18176 | 1.000 | 0.739 | 0.015 | 0.432 | 2.455 | 0.583 | 0.501 | 0.540 | 0.453 | 0.151 | 0.056 | 0.305 | 0.131 | 0.539 | 0.472 |
| Panel review with en banc safety valve | federalism | 3829 | 1.000 | 0.852 | 0.056 | 0.019 | 2.648 | 0.802 | 0.583 | 0.532 | 0.445 | 0.146 | 0.039 | 0.243 | 0.146 | 0.573 | 0.497 |
| Panel review with en banc safety valve | speech | 3859 | 1.000 | 0.778 | 0.063 | 0.237 | 2.254 | 0.457 | 0.452 | 0.540 | 0.452 | 0.151 | 0.047 | 0.348 | 0.140 | 0.578 | 0.514 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 3891 | 1.000 | 0.845 | 0.001 | 0.002 | 2.659 | 0.464 | 0.501 | 0.578 | 0.499 | 0.200 | 0.038 | 0.367 | 0.162 | 0.524 | 0.452 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 3809 | 1.000 | 0.788 | 0.004 | 0.174 | 2.356 | 0.569 | 0.491 | 0.574 | 0.496 | 0.140 | 0.045 | 0.333 | 0.156 | 0.527 | 0.456 |
| Dual supreme courts with cross-checking invalidations | election_law | 9850 | 1.000 | 0.800 | 0.002 | 0.071 | 2.464 | 0.668 | 0.514 | 0.563 | 0.486 | 0.120 | 0.042 | 0.303 | 0.142 | 0.474 | 0.443 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 4586 | 1.000 | 0.812 | 0.010 | 0.063 | 2.314 | 0.533 | 0.499 | 0.580 | 0.501 | 0.131 | 0.046 | 0.369 | 0.151 | 0.489 | 0.423 |
| Dual supreme courts with cross-checking invalidations | equality | 18176 | 1.000 | 0.748 | 0.002 | 0.364 | 2.455 | 0.583 | 0.501 | 0.557 | 0.470 | 0.138 | 0.053 | 0.319 | 0.147 | 0.490 | 0.413 |
| Dual supreme courts with cross-checking invalidations | federalism | 3829 | 1.000 | 0.854 | 0.001 | 0.003 | 2.648 | 0.802 | 0.583 | 0.562 | 0.487 | 0.127 | 0.038 | 0.266 | 0.163 | 0.519 | 0.441 |
| Dual supreme courts with cross-checking invalidations | speech | 3859 | 1.000 | 0.788 | 0.005 | 0.181 | 2.254 | 0.457 | 0.452 | 0.576 | 0.494 | 0.141 | 0.045 | 0.364 | 0.156 | 0.528 | 0.458 |
| Pre-enactment constitutional council | administrative_state | 3891 | 1.000 | 0.844 | 0.053 | 0.001 | 2.659 | 0.464 | 0.501 | 0.598 | 0.499 | 0.181 | 0.035 | 0.384 | 0.193 | 0.480 | 0.394 |
| Pre-enactment constitutional council | criminal_procedure | 3809 | 1.000 | 0.778 | 0.070 | 0.165 | 2.356 | 0.569 | 0.491 | 0.556 | 0.489 | 0.130 | 0.039 | 0.336 | 0.193 | 0.482 | 0.395 |
| Pre-enactment constitutional council | election_law | 9850 | 1.000 | 0.798 | 0.021 | 0.067 | 2.464 | 0.668 | 0.514 | 0.584 | 0.500 | 0.117 | 0.040 | 0.327 | 0.189 | 0.377 | 0.330 |
| Pre-enactment constitutional council | emergency_powers | 4586 | 1.000 | 0.809 | 0.078 | 0.079 | 2.314 | 0.533 | 0.499 | 0.590 | 0.517 | 0.109 | 0.043 | 0.372 | 0.198 | 0.436 | 0.357 |
| Pre-enactment constitutional council | equality | 18176 | 1.000 | 0.746 | 0.014 | 0.328 | 2.455 | 0.583 | 0.501 | 0.585 | 0.496 | 0.115 | 0.046 | 0.342 | 0.194 | 0.393 | 0.313 |
| Pre-enactment constitutional council | federalism | 3829 | 1.000 | 0.853 | 0.052 | 0.002 | 2.648 | 0.802 | 0.583 | 0.580 | 0.487 | 0.139 | 0.046 | 0.271 | 0.196 | 0.478 | 0.387 |
| Pre-enactment constitutional council | speech | 3859 | 1.000 | 0.778 | 0.063 | 0.178 | 2.254 | 0.457 | 0.452 | 0.568 | 0.488 | 0.139 | 0.038 | 0.388 | 0.188 | 0.479 | 0.394 |
| Judicial review with delayed legislative override | administrative_state | 3891 | 1.000 | 0.843 | 0.055 | 0.016 | 2.659 | 0.464 | 0.501 | 0.540 | 0.440 | 0.220 | 0.038 | 0.331 | 0.122 | 0.621 | 0.534 |
| Judicial review with delayed legislative override | criminal_procedure | 3809 | 1.000 | 0.776 | 0.073 | 0.218 | 2.356 | 0.569 | 0.491 | 0.498 | 0.417 | 0.166 | 0.047 | 0.268 | 0.115 | 0.631 | 0.549 |
| Judicial review with delayed legislative override | election_law | 9850 | 1.000 | 0.791 | 0.023 | 0.116 | 2.464 | 0.668 | 0.514 | 0.499 | 0.421 | 0.152 | 0.050 | 0.251 | 0.098 | 0.597 | 0.551 |
| Judicial review with delayed legislative override | emergency_powers | 4586 | 1.000 | 0.807 | 0.087 | 0.137 | 2.314 | 0.533 | 0.499 | 0.523 | 0.443 | 0.155 | 0.048 | 0.304 | 0.103 | 0.594 | 0.521 |
| Judicial review with delayed legislative override | equality | 18176 | 1.000 | 0.732 | 0.016 | 0.427 | 2.455 | 0.583 | 0.501 | 0.491 | 0.408 | 0.166 | 0.056 | 0.271 | 0.092 | 0.608 | 0.516 |
| Judicial review with delayed legislative override | federalism | 3829 | 1.000 | 0.851 | 0.056 | 0.023 | 2.648 | 0.802 | 0.583 | 0.499 | 0.431 | 0.151 | 0.043 | 0.217 | 0.119 | 0.620 | 0.527 |
| Judicial review with delayed legislative override | speech | 3859 | 1.000 | 0.777 | 0.067 | 0.234 | 2.254 | 0.457 | 0.452 | 0.520 | 0.433 | 0.154 | 0.051 | 0.324 | 0.116 | 0.628 | 0.546 |
| Retention-election accountability court | administrative_state | 3891 | 1.000 | 0.845 | 0.054 | 0.004 | 2.659 | 0.464 | 0.501 | 0.561 | 0.467 | 0.197 | 0.036 | 0.353 | 0.137 | 0.531 | 0.434 |
| Retention-election accountability court | criminal_procedure | 3809 | 1.000 | 0.775 | 0.069 | 0.157 | 2.356 | 0.569 | 0.491 | 0.529 | 0.450 | 0.141 | 0.037 | 0.300 | 0.131 | 0.537 | 0.445 |
| Retention-election accountability court | election_law | 9850 | 1.000 | 0.796 | 0.021 | 0.062 | 2.464 | 0.668 | 0.514 | 0.538 | 0.456 | 0.127 | 0.043 | 0.289 | 0.127 | 0.461 | 0.408 |
| Retention-election accountability court | emergency_powers | 4586 | 1.000 | 0.810 | 0.077 | 0.072 | 2.314 | 0.533 | 0.499 | 0.554 | 0.459 | 0.141 | 0.036 | 0.349 | 0.122 | 0.495 | 0.408 |
| Retention-election accountability court | equality | 18176 | 1.000 | 0.714 | 0.014 | 0.289 | 2.455 | 0.583 | 0.501 | 0.514 | 0.432 | 0.142 | 0.045 | 0.293 | 0.114 | 0.490 | 0.388 |
| Retention-election accountability court | federalism | 3829 | 1.000 | 0.854 | 0.053 | 0.006 | 2.648 | 0.802 | 0.583 | 0.539 | 0.457 | 0.140 | 0.040 | 0.242 | 0.138 | 0.530 | 0.430 |
| Retention-election accountability court | speech | 3859 | 1.000 | 0.776 | 0.060 | 0.170 | 2.254 | 0.457 | 0.452 | 0.552 | 0.462 | 0.141 | 0.039 | 0.345 | 0.132 | 0.536 | 0.443 |
| Hybrid court balancing independence and accountability | administrative_state | 3891 | 1.000 | 0.845 | 0.000 | 0.004 | 2.659 | 0.464 | 0.501 | 0.576 | 0.508 | 0.183 | 0.039 | 0.376 | 0.161 | 0.528 | 0.469 |
| Hybrid court balancing independence and accountability | criminal_procedure | 3809 | 1.000 | 0.788 | 0.003 | 0.193 | 2.356 | 0.569 | 0.491 | 0.559 | 0.491 | 0.140 | 0.046 | 0.325 | 0.157 | 0.534 | 0.477 |
| Hybrid court balancing independence and accountability | election_law | 9850 | 1.000 | 0.799 | 0.002 | 0.080 | 2.464 | 0.668 | 0.514 | 0.546 | 0.480 | 0.126 | 0.049 | 0.294 | 0.143 | 0.484 | 0.471 |
| Hybrid court balancing independence and accountability | emergency_powers | 4586 | 1.000 | 0.811 | 0.007 | 0.072 | 2.314 | 0.533 | 0.499 | 0.575 | 0.494 | 0.131 | 0.041 | 0.360 | 0.156 | 0.496 | 0.446 |
| Hybrid court balancing independence and accountability | equality | 18176 | 1.000 | 0.743 | 0.001 | 0.411 | 2.455 | 0.583 | 0.501 | 0.553 | 0.467 | 0.144 | 0.055 | 0.306 | 0.148 | 0.500 | 0.441 |
| Hybrid court balancing independence and accountability | federalism | 3829 | 1.000 | 0.853 | 0.000 | 0.005 | 2.648 | 0.802 | 0.583 | 0.540 | 0.471 | 0.130 | 0.042 | 0.258 | 0.162 | 0.527 | 0.463 |
| Hybrid court balancing independence and accountability | speech | 3859 | 1.000 | 0.787 | 0.004 | 0.201 | 2.254 | 0.457 | 0.452 | 0.576 | 0.486 | 0.137 | 0.046 | 0.347 | 0.156 | 0.534 | 0.478 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 3433 | 1.000 | 0.783 | 0.178 | 0.135 | 3.000 | 0.401 | 0.471 | 0.484 | 0.399 | 0.195 | 0.047 | 0.326 | 0.094 | 0.705 | 0.623 |
| Current-style federal supreme court | federal/circuit_panel | 9559 | 1.000 | 0.768 | 0.179 | 0.131 | 2.000 | 0.421 | 0.436 | 0.480 | 0.389 | 0.178 | 0.049 | 0.321 | 0.086 | 0.699 | 0.625 |
| Current-style federal supreme court | federal/district_only | 2285 | 1.000 | 0.765 | 0.182 | 0.142 | 1.000 | 0.429 | 0.410 | 0.494 | 0.396 | 0.172 | 0.049 | 0.316 | 0.084 | 0.693 | 0.619 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.748 | 0.143 | 0.376 | 3.000 | 0.778 | 0.561 | 0.428 | 0.329 | 0.209 | 0.065 | 0.145 | 0.065 | 0.736 | 0.669 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.732 | 0.152 | 0.462 | 3.000 | 0.778 | 0.581 | 0.409 | 0.323 | 0.225 | 0.068 | 0.149 | 0.062 | 0.742 | 0.673 |
| Current-style federal supreme court | state/circuit_panel | 2919 | 1.000 | 0.759 | 0.152 | 0.259 | 2.000 | 0.572 | 0.474 | 0.449 | 0.369 | 0.187 | 0.059 | 0.215 | 0.073 | 0.726 | 0.659 |
| Current-style federal supreme court | state/state_federal_split | 4311 | 1.000 | 0.735 | 0.171 | 0.384 | 3.000 | 0.572 | 0.529 | 0.454 | 0.350 | 0.198 | 0.057 | 0.207 | 0.071 | 0.731 | 0.659 |
| Current-style federal supreme court | state/state_high_court | 9291 | 1.000 | 0.753 | 0.158 | 0.276 | 2.000 | 0.572 | 0.488 | 0.446 | 0.363 | 0.196 | 0.053 | 0.216 | 0.073 | 0.729 | 0.657 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 3433 | 1.000 | 0.790 | 0.178 | 0.105 | 3.000 | 0.401 | 0.471 | 0.503 | 0.405 | 0.192 | 0.047 | 0.345 | 0.101 | 0.647 | 0.556 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 9559 | 1.000 | 0.774 | 0.177 | 0.101 | 2.000 | 0.421 | 0.436 | 0.500 | 0.417 | 0.164 | 0.047 | 0.344 | 0.094 | 0.643 | 0.561 |
| Staggered 18-year nonrenewable terms | federal/district_only | 2285 | 1.000 | 0.770 | 0.178 | 0.121 | 1.000 | 0.429 | 0.410 | 0.491 | 0.404 | 0.148 | 0.046 | 0.345 | 0.092 | 0.637 | 0.556 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.758 | 0.139 | 0.332 | 3.000 | 0.778 | 0.561 | 0.434 | 0.347 | 0.200 | 0.071 | 0.169 | 0.071 | 0.678 | 0.605 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.744 | 0.149 | 0.400 | 3.000 | 0.778 | 0.581 | 0.433 | 0.344 | 0.199 | 0.062 | 0.166 | 0.070 | 0.683 | 0.608 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 2919 | 1.000 | 0.762 | 0.152 | 0.225 | 2.000 | 0.572 | 0.474 | 0.466 | 0.382 | 0.178 | 0.053 | 0.220 | 0.080 | 0.674 | 0.600 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 4311 | 1.000 | 0.746 | 0.167 | 0.323 | 3.000 | 0.572 | 0.529 | 0.444 | 0.373 | 0.185 | 0.055 | 0.222 | 0.077 | 0.673 | 0.597 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 9291 | 1.000 | 0.759 | 0.158 | 0.226 | 2.000 | 0.572 | 0.488 | 0.461 | 0.384 | 0.174 | 0.054 | 0.238 | 0.081 | 0.673 | 0.597 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 3433 | 1.000 | 0.806 | 0.047 | 0.095 | 3.000 | 0.401 | 0.471 | 0.550 | 0.498 | 0.151 | 0.040 | 0.414 | 0.142 | 0.542 | 0.464 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 9559 | 1.000 | 0.790 | 0.044 | 0.103 | 2.000 | 0.421 | 0.436 | 0.562 | 0.480 | 0.136 | 0.039 | 0.401 | 0.136 | 0.531 | 0.461 |
| Fifteen-justice supermajority commission court | federal/district_only | 2285 | 1.000 | 0.784 | 0.045 | 0.112 | 1.000 | 0.429 | 0.410 | 0.560 | 0.476 | 0.123 | 0.039 | 0.404 | 0.136 | 0.529 | 0.461 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.780 | 0.030 | 0.308 | 3.000 | 0.778 | 0.561 | 0.512 | 0.437 | 0.158 | 0.056 | 0.211 | 0.108 | 0.551 | 0.499 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.773 | 0.034 | 0.358 | 3.000 | 0.778 | 0.581 | 0.499 | 0.414 | 0.174 | 0.059 | 0.216 | 0.106 | 0.562 | 0.505 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 2919 | 1.000 | 0.780 | 0.037 | 0.218 | 2.000 | 0.572 | 0.474 | 0.528 | 0.441 | 0.147 | 0.047 | 0.279 | 0.115 | 0.563 | 0.507 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 4311 | 1.000 | 0.773 | 0.041 | 0.289 | 3.000 | 0.572 | 0.529 | 0.523 | 0.439 | 0.151 | 0.052 | 0.276 | 0.115 | 0.561 | 0.499 |
| Fifteen-justice supermajority commission court | state/state_high_court | 9291 | 1.000 | 0.778 | 0.037 | 0.231 | 2.000 | 0.572 | 0.488 | 0.526 | 0.450 | 0.151 | 0.051 | 0.281 | 0.119 | 0.560 | 0.502 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 3433 | 1.000 | 0.804 | 0.047 | 0.088 | 3.000 | 0.401 | 0.471 | 0.562 | 0.478 | 0.157 | 0.039 | 0.388 | 0.125 | 0.575 | 0.497 |
| Supermajority required to invalidate laws | federal/circuit_panel | 9559 | 1.000 | 0.789 | 0.044 | 0.096 | 2.000 | 0.421 | 0.436 | 0.550 | 0.473 | 0.146 | 0.042 | 0.391 | 0.121 | 0.566 | 0.494 |
| Supermajority required to invalidate laws | federal/district_only | 2285 | 1.000 | 0.783 | 0.046 | 0.108 | 1.000 | 0.429 | 0.410 | 0.564 | 0.475 | 0.128 | 0.038 | 0.394 | 0.118 | 0.560 | 0.492 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.778 | 0.032 | 0.316 | 3.000 | 0.778 | 0.561 | 0.501 | 0.418 | 0.168 | 0.055 | 0.204 | 0.094 | 0.593 | 0.534 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.769 | 0.035 | 0.368 | 3.000 | 0.778 | 0.581 | 0.492 | 0.404 | 0.182 | 0.059 | 0.205 | 0.093 | 0.601 | 0.540 |
| Supermajority required to invalidate laws | state/circuit_panel | 2919 | 1.000 | 0.778 | 0.038 | 0.213 | 2.000 | 0.572 | 0.474 | 0.520 | 0.429 | 0.154 | 0.051 | 0.269 | 0.102 | 0.601 | 0.539 |
| Supermajority required to invalidate laws | state/state_federal_split | 4311 | 1.000 | 0.770 | 0.044 | 0.294 | 3.000 | 0.572 | 0.529 | 0.516 | 0.429 | 0.158 | 0.043 | 0.267 | 0.099 | 0.599 | 0.533 |
| Supermajority required to invalidate laws | state/state_high_court | 9291 | 1.000 | 0.777 | 0.039 | 0.222 | 2.000 | 0.572 | 0.488 | 0.512 | 0.438 | 0.158 | 0.053 | 0.270 | 0.103 | 0.596 | 0.534 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 3433 | 1.000 | 0.806 | 0.046 | 0.087 | 3.000 | 0.401 | 0.471 | 0.587 | 0.498 | 0.155 | 0.038 | 0.403 | 0.163 | 0.514 | 0.438 |
| Strict recusal with substitute justices | federal/circuit_panel | 9559 | 1.000 | 0.790 | 0.043 | 0.099 | 2.000 | 0.421 | 0.436 | 0.568 | 0.492 | 0.135 | 0.039 | 0.422 | 0.162 | 0.499 | 0.431 |
| Strict recusal with substitute justices | federal/district_only | 2285 | 1.000 | 0.784 | 0.046 | 0.104 | 1.000 | 0.429 | 0.410 | 0.575 | 0.495 | 0.118 | 0.037 | 0.418 | 0.160 | 0.496 | 0.430 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.781 | 0.030 | 0.295 | 3.000 | 0.778 | 0.561 | 0.533 | 0.439 | 0.158 | 0.054 | 0.236 | 0.130 | 0.514 | 0.463 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.775 | 0.033 | 0.342 | 3.000 | 0.778 | 0.581 | 0.521 | 0.434 | 0.159 | 0.057 | 0.234 | 0.128 | 0.521 | 0.467 |
| Strict recusal with substitute justices | state/circuit_panel | 2919 | 1.000 | 0.780 | 0.037 | 0.207 | 2.000 | 0.572 | 0.474 | 0.543 | 0.470 | 0.155 | 0.046 | 0.295 | 0.138 | 0.523 | 0.471 |
| Strict recusal with substitute justices | state/state_federal_split | 4311 | 1.000 | 0.774 | 0.042 | 0.277 | 3.000 | 0.572 | 0.529 | 0.553 | 0.461 | 0.145 | 0.047 | 0.284 | 0.137 | 0.525 | 0.467 |
| Strict recusal with substitute justices | state/state_high_court | 9291 | 1.000 | 0.778 | 0.038 | 0.220 | 2.000 | 0.572 | 0.488 | 0.543 | 0.474 | 0.146 | 0.044 | 0.306 | 0.140 | 0.525 | 0.468 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 3433 | 1.000 | 0.806 | 0.002 | 0.106 | 3.000 | 0.401 | 0.471 | 0.580 | 0.497 | 0.172 | 0.044 | 0.398 | 0.145 | 0.574 | 0.498 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 9559 | 1.000 | 0.791 | 0.003 | 0.116 | 2.000 | 0.421 | 0.436 | 0.571 | 0.486 | 0.137 | 0.043 | 0.414 | 0.141 | 0.566 | 0.497 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 2285 | 1.000 | 0.786 | 0.003 | 0.119 | 1.000 | 0.429 | 0.410 | 0.578 | 0.475 | 0.139 | 0.046 | 0.396 | 0.139 | 0.565 | 0.497 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.776 | 0.002 | 0.359 | 3.000 | 0.778 | 0.561 | 0.508 | 0.433 | 0.166 | 0.056 | 0.220 | 0.112 | 0.601 | 0.541 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.765 | 0.002 | 0.423 | 3.000 | 0.778 | 0.581 | 0.499 | 0.417 | 0.180 | 0.064 | 0.211 | 0.107 | 0.610 | 0.547 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 2919 | 1.000 | 0.781 | 0.002 | 0.241 | 2.000 | 0.572 | 0.474 | 0.521 | 0.441 | 0.161 | 0.052 | 0.288 | 0.120 | 0.603 | 0.546 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 4311 | 1.000 | 0.769 | 0.003 | 0.336 | 3.000 | 0.572 | 0.529 | 0.538 | 0.449 | 0.158 | 0.051 | 0.273 | 0.118 | 0.600 | 0.535 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 9291 | 1.000 | 0.778 | 0.002 | 0.261 | 2.000 | 0.572 | 0.488 | 0.540 | 0.454 | 0.150 | 0.052 | 0.285 | 0.122 | 0.602 | 0.540 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 3433 | 1.000 | 0.805 | 0.046 | 0.098 | 3.000 | 0.401 | 0.471 | 0.575 | 0.491 | 0.159 | 0.038 | 0.394 | 0.157 | 0.539 | 0.468 |
| Panel review with en banc safety valve | federal/circuit_panel | 9559 | 1.000 | 0.790 | 0.044 | 0.113 | 2.000 | 0.421 | 0.436 | 0.578 | 0.488 | 0.135 | 0.036 | 0.418 | 0.152 | 0.528 | 0.463 |
| Panel review with en banc safety valve | federal/district_only | 2285 | 1.000 | 0.784 | 0.044 | 0.112 | 1.000 | 0.429 | 0.410 | 0.582 | 0.480 | 0.135 | 0.043 | 0.406 | 0.149 | 0.525 | 0.463 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.780 | 0.028 | 0.315 | 3.000 | 0.778 | 0.561 | 0.510 | 0.419 | 0.161 | 0.052 | 0.221 | 0.122 | 0.552 | 0.503 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.772 | 0.033 | 0.369 | 3.000 | 0.778 | 0.581 | 0.516 | 0.421 | 0.169 | 0.057 | 0.219 | 0.119 | 0.558 | 0.505 |
| Panel review with en banc safety valve | state/circuit_panel | 2919 | 1.000 | 0.780 | 0.036 | 0.224 | 2.000 | 0.572 | 0.474 | 0.532 | 0.440 | 0.154 | 0.051 | 0.280 | 0.132 | 0.558 | 0.509 |
| Panel review with en banc safety valve | state/state_federal_split | 4311 | 1.000 | 0.771 | 0.041 | 0.300 | 3.000 | 0.572 | 0.529 | 0.521 | 0.457 | 0.157 | 0.054 | 0.295 | 0.126 | 0.561 | 0.503 |
| Panel review with en banc safety valve | state/state_high_court | 9291 | 1.000 | 0.777 | 0.039 | 0.238 | 2.000 | 0.572 | 0.488 | 0.541 | 0.463 | 0.149 | 0.050 | 0.286 | 0.133 | 0.557 | 0.503 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 3433 | 1.000 | 0.810 | 0.002 | 0.061 | 3.000 | 0.401 | 0.471 | 0.602 | 0.515 | 0.151 | 0.034 | 0.421 | 0.170 | 0.492 | 0.412 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 9559 | 1.000 | 0.794 | 0.003 | 0.070 | 2.000 | 0.421 | 0.436 | 0.594 | 0.514 | 0.128 | 0.039 | 0.434 | 0.171 | 0.480 | 0.408 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 2285 | 1.000 | 0.787 | 0.004 | 0.074 | 1.000 | 0.429 | 0.410 | 0.595 | 0.514 | 0.112 | 0.039 | 0.449 | 0.169 | 0.478 | 0.408 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.786 | 0.002 | 0.267 | 3.000 | 0.778 | 0.561 | 0.546 | 0.466 | 0.144 | 0.050 | 0.241 | 0.136 | 0.497 | 0.439 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.783 | 0.002 | 0.295 | 3.000 | 0.778 | 0.581 | 0.535 | 0.458 | 0.152 | 0.054 | 0.245 | 0.135 | 0.505 | 0.444 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 2919 | 1.000 | 0.784 | 0.003 | 0.179 | 2.000 | 0.572 | 0.474 | 0.565 | 0.470 | 0.133 | 0.045 | 0.300 | 0.144 | 0.505 | 0.448 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 4311 | 1.000 | 0.782 | 0.003 | 0.234 | 3.000 | 0.572 | 0.529 | 0.561 | 0.484 | 0.138 | 0.053 | 0.302 | 0.144 | 0.510 | 0.444 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 9291 | 1.000 | 0.783 | 0.003 | 0.191 | 2.000 | 0.572 | 0.488 | 0.563 | 0.480 | 0.133 | 0.046 | 0.307 | 0.148 | 0.506 | 0.443 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 3433 | 1.000 | 0.807 | 0.044 | 0.062 | 3.000 | 0.401 | 0.471 | 0.604 | 0.516 | 0.142 | 0.037 | 0.441 | 0.212 | 0.433 | 0.343 |
| Pre-enactment constitutional council | federal/circuit_panel | 9559 | 1.000 | 0.790 | 0.041 | 0.074 | 2.000 | 0.421 | 0.436 | 0.612 | 0.525 | 0.116 | 0.034 | 0.438 | 0.213 | 0.420 | 0.339 |
| Pre-enactment constitutional council | federal/district_only | 2285 | 1.000 | 0.783 | 0.045 | 0.083 | 1.000 | 0.429 | 0.410 | 0.622 | 0.531 | 0.108 | 0.039 | 0.449 | 0.216 | 0.417 | 0.337 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.784 | 0.029 | 0.250 | 3.000 | 0.778 | 0.561 | 0.561 | 0.475 | 0.134 | 0.046 | 0.278 | 0.177 | 0.406 | 0.335 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.782 | 0.031 | 0.273 | 3.000 | 0.778 | 0.581 | 0.559 | 0.475 | 0.133 | 0.048 | 0.265 | 0.178 | 0.416 | 0.346 |
| Pre-enactment constitutional council | state/circuit_panel | 2919 | 1.000 | 0.780 | 0.035 | 0.166 | 2.000 | 0.572 | 0.474 | 0.586 | 0.506 | 0.123 | 0.039 | 0.328 | 0.189 | 0.422 | 0.352 |
| Pre-enactment constitutional council | state/state_federal_split | 4311 | 1.000 | 0.777 | 0.040 | 0.222 | 3.000 | 0.572 | 0.529 | 0.566 | 0.475 | 0.130 | 0.049 | 0.319 | 0.184 | 0.436 | 0.362 |
| Pre-enactment constitutional council | state/state_high_court | 9291 | 1.000 | 0.778 | 0.035 | 0.177 | 2.000 | 0.572 | 0.488 | 0.580 | 0.500 | 0.117 | 0.043 | 0.329 | 0.190 | 0.428 | 0.354 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 3433 | 1.000 | 0.804 | 0.048 | 0.099 | 3.000 | 0.401 | 0.471 | 0.539 | 0.455 | 0.174 | 0.039 | 0.382 | 0.124 | 0.594 | 0.504 |
| Judicial review with delayed legislative override | federal/circuit_panel | 9559 | 1.000 | 0.789 | 0.044 | 0.106 | 2.000 | 0.421 | 0.436 | 0.542 | 0.455 | 0.147 | 0.044 | 0.382 | 0.118 | 0.584 | 0.502 |
| Judicial review with delayed legislative override | federal/district_only | 2285 | 1.000 | 0.783 | 0.045 | 0.112 | 1.000 | 0.429 | 0.410 | 0.550 | 0.475 | 0.137 | 0.046 | 0.386 | 0.120 | 0.580 | 0.500 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.774 | 0.032 | 0.319 | 3.000 | 0.778 | 0.561 | 0.479 | 0.399 | 0.166 | 0.055 | 0.192 | 0.092 | 0.620 | 0.547 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.765 | 0.034 | 0.376 | 3.000 | 0.778 | 0.581 | 0.459 | 0.386 | 0.181 | 0.058 | 0.183 | 0.089 | 0.624 | 0.546 |
| Judicial review with delayed legislative override | state/circuit_panel | 2919 | 1.000 | 0.777 | 0.040 | 0.227 | 2.000 | 0.572 | 0.474 | 0.514 | 0.422 | 0.161 | 0.050 | 0.244 | 0.098 | 0.619 | 0.545 |
| Judicial review with delayed legislative override | state/state_federal_split | 4311 | 1.000 | 0.768 | 0.042 | 0.300 | 3.000 | 0.572 | 0.529 | 0.495 | 0.418 | 0.166 | 0.052 | 0.259 | 0.098 | 0.620 | 0.542 |
| Judicial review with delayed legislative override | state/state_high_court | 9291 | 1.000 | 0.773 | 0.039 | 0.238 | 2.000 | 0.572 | 0.488 | 0.505 | 0.416 | 0.163 | 0.050 | 0.268 | 0.102 | 0.618 | 0.543 |
| Retention-election accountability court | federal/circuit_en_banc | 3433 | 1.000 | 0.806 | 0.044 | 0.061 | 3.000 | 0.401 | 0.471 | 0.563 | 0.488 | 0.147 | 0.037 | 0.415 | 0.144 | 0.497 | 0.396 |
| Retention-election accountability court | federal/circuit_panel | 9559 | 1.000 | 0.789 | 0.041 | 0.071 | 2.000 | 0.421 | 0.436 | 0.569 | 0.476 | 0.136 | 0.037 | 0.412 | 0.143 | 0.484 | 0.390 |
| Retention-election accountability court | federal/district_only | 2285 | 1.000 | 0.783 | 0.041 | 0.072 | 1.000 | 0.429 | 0.410 | 0.569 | 0.478 | 0.124 | 0.034 | 0.399 | 0.138 | 0.482 | 0.391 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.760 | 0.027 | 0.225 | 3.000 | 0.778 | 0.561 | 0.507 | 0.412 | 0.148 | 0.046 | 0.233 | 0.113 | 0.492 | 0.409 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.760 | 0.032 | 0.250 | 3.000 | 0.778 | 0.581 | 0.503 | 0.419 | 0.152 | 0.045 | 0.217 | 0.108 | 0.504 | 0.419 |
| Retention-election accountability court | state/circuit_panel | 2919 | 1.000 | 0.764 | 0.034 | 0.138 | 2.000 | 0.572 | 0.474 | 0.524 | 0.460 | 0.132 | 0.039 | 0.285 | 0.124 | 0.501 | 0.417 |
| Retention-election accountability court | state/state_federal_split | 4311 | 1.000 | 0.763 | 0.040 | 0.200 | 3.000 | 0.572 | 0.529 | 0.531 | 0.431 | 0.143 | 0.045 | 0.283 | 0.117 | 0.512 | 0.425 |
| Retention-election accountability court | state/state_high_court | 9291 | 1.000 | 0.764 | 0.036 | 0.152 | 2.000 | 0.572 | 0.488 | 0.529 | 0.454 | 0.143 | 0.043 | 0.284 | 0.123 | 0.506 | 0.421 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 3433 | 1.000 | 0.808 | 0.002 | 0.077 | 3.000 | 0.401 | 0.471 | 0.589 | 0.522 | 0.136 | 0.041 | 0.415 | 0.172 | 0.499 | 0.434 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 9559 | 1.000 | 0.793 | 0.002 | 0.086 | 2.000 | 0.421 | 0.436 | 0.589 | 0.513 | 0.128 | 0.037 | 0.429 | 0.170 | 0.489 | 0.433 |
| Hybrid court balancing independence and accountability | federal/district_only | 2285 | 1.000 | 0.787 | 0.003 | 0.093 | 1.000 | 0.429 | 0.410 | 0.594 | 0.501 | 0.119 | 0.035 | 0.420 | 0.172 | 0.483 | 0.430 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 4614 | 1.000 | 0.783 | 0.002 | 0.291 | 3.000 | 0.778 | 0.561 | 0.543 | 0.456 | 0.146 | 0.048 | 0.228 | 0.139 | 0.505 | 0.463 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 11588 | 1.000 | 0.779 | 0.002 | 0.326 | 3.000 | 0.778 | 0.581 | 0.523 | 0.454 | 0.152 | 0.057 | 0.231 | 0.135 | 0.515 | 0.473 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 2919 | 1.000 | 0.783 | 0.002 | 0.201 | 2.000 | 0.572 | 0.474 | 0.564 | 0.468 | 0.147 | 0.048 | 0.299 | 0.148 | 0.515 | 0.473 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 4311 | 1.000 | 0.778 | 0.002 | 0.264 | 3.000 | 0.572 | 0.529 | 0.553 | 0.469 | 0.142 | 0.054 | 0.304 | 0.145 | 0.515 | 0.466 |
| Hybrid court balancing independence and accountability | state/state_high_court | 9291 | 1.000 | 0.781 | 0.002 | 0.215 | 2.000 | 0.572 | 0.488 | 0.551 | 0.474 | 0.139 | 0.052 | 0.296 | 0.149 | 0.515 | 0.468 |

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

## Calibration Diagnostics

| Target | Observed | Range | Gap | Status |
| --- | ---: | ---: | ---: | --- |
| Speech docket share | 0.080 | 0.080-0.200 | 0.000 | within |
| Equality docket share | 0.379 | 0.080-0.200 | 0.179 | outside |
| Criminal procedure docket share | 0.079 | 0.080-0.200 | 0.001 | outside |
| Federalism docket share | 0.080 | 0.060-0.180 | 0.000 | within |
| Election law docket share | 0.205 | 0.050-0.160 | 0.045 | outside |
| Emergency powers docket share | 0.096 | 0.040-0.140 | 0.000 | within |
| Administrative state docket share | 0.081 | 0.060-0.180 | 0.000 | within |
| Emergency relief rate | 0.491 | 0.050-0.240 | 0.251 | outside |
| Compliance rate | 0.527 | 0.700-0.950 | 0.173 | outside |
| Legitimacy response to trust | 0.451 | 0.150-1.200 | 0.000 | within |
