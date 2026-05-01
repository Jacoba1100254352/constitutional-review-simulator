# Constitutional Review Campaign v0

- runs per case: 120
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Baseline

Moderately polarized appointment environment with ordinary constitutional-review pressure.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.707
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.747
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.311
- highest compliance rate: Hybrid court balancing independence and accountability at 0.516
- lowest defiance rate: Pre-enactment constitutional council at 0.201

### Polarized appointments

High appointment polarization, higher partisan pressure, and lower public trust.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.679
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.745
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.352
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.452
- lowest defiance rate: Pre-enactment constitutional council at 0.256

### Rights-threat surge

Docket contains more laws or actions with high generated rights-risk signals.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.610
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.007
- lowest emergency relief rate: Retention-election accountability court at 0.643
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.394
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.309

### Emergency docket stress

Higher urgency and executive pressure, meant to stress shadow-docket procedures.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.660
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.736
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.038
- lowest emergency relief rate: Retention-election accountability court at 0.341
- highest compliance rate: Hybrid court balancing independence and accountability at 0.405
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.288

### Low-trust conflict

Lower public trust and higher legislature-court conflict.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.657
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.342
- highest compliance rate: Hybrid court balancing independence and accountability at 0.369
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.312

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.563 | 0.744 | 0.665 | 0.228 | 0.492 | 0.751 | 0.446 | 0.530 | 0.245 | 0.393 | 0.386 | 0.285 | 0.210 | 0.305 | 0.066 | 0.105 | 2.399 | 0.581 | 0.497 |
| Staggered 18-year nonrenewable terms | 0.577 | 0.753 | 0.673 | 0.210 | 0.485 | 0.709 | 0.418 | 0.540 | 0.230 | 0.387 | 0.395 | 0.289 | 0.213 | 0.300 | 0.064 | 0.107 | 2.399 | 0.581 | 0.505 |
| Fifteen-justice supermajority commission court | 0.635 | 0.848 | 0.728 | 0.172 | 0.138 | 0.532 | 0.553 | 0.665 | 0.394 | 0.288 | 0.452 | 0.377 | 0.303 | 0.263 | 0.067 | 0.160 | 2.399 | 0.581 | 0.496 |
| Supermajority required to invalidate laws | 0.627 | 0.856 | 0.724 | 0.190 | 0.142 | 0.569 | 0.529 | 0.641 | 0.376 | 0.289 | 0.446 | 0.375 | 0.301 | 0.265 | 0.066 | 0.159 | 2.399 | 0.581 | 0.475 |
| Strict recusal with substitute justices | 0.641 | 0.849 | 0.728 | 0.171 | 0.135 | 0.528 | 0.538 | 0.684 | 0.382 | 0.286 | 0.453 | 0.383 | 0.315 | 0.256 | 0.066 | 0.164 | 2.399 | 0.581 | 0.497 |
| Reasoned emergency orders with merits follow-up | 0.642 | 0.866 | 0.736 | 0.190 | 0.012 | 0.563 | 0.527 | 0.711 | 0.527 | 0.262 | 0.457 | 0.408 | 0.335 | 0.253 | 0.070 | 0.180 | 2.399 | 0.581 | 0.483 |
| Panel review with en banc safety valve | 0.627 | 0.843 | 0.728 | 0.170 | 0.136 | 0.527 | 0.560 | 0.678 | 0.400 | 0.288 | 0.452 | 0.379 | 0.311 | 0.261 | 0.066 | 0.165 | 2.399 | 0.581 | 0.694 |
| Dual supreme courts with cross-checking invalidations | 0.650 | 0.891 | 0.741 | 0.156 | 0.016 | 0.478 | 0.403 | 0.720 | 0.403 | 0.267 | 0.467 | 0.423 | 0.352 | 0.239 | 0.064 | 0.195 | 2.399 | 0.581 | 0.880 |
| Pre-enactment constitutional council | 0.653 | 0.919 | 0.730 | 0.149 | 0.130 | 0.485 | 0.434 | 0.709 | 0.309 | 0.276 | 0.459 | 0.405 | 0.338 | 0.237 | 0.061 | 0.189 | 2.399 | 0.581 | 0.750 |
| Judicial review with delayed legislative override | 0.628 | 0.833 | 0.724 | 0.185 | 0.140 | 0.555 | 0.574 | 0.656 | 0.408 | 0.297 | 0.453 | 0.370 | 0.293 | 0.265 | 0.067 | 0.153 | 2.399 | 0.581 | 0.489 |
| Retention-election accountability court | 0.653 | 0.850 | 0.721 | 0.161 | 0.128 | 0.398 | 0.417 | 0.676 | 0.296 | 0.287 | 0.472 | 0.379 | 0.312 | 0.247 | 0.061 | 0.169 | 2.399 | 0.581 | 0.510 |
| Hybrid court balancing independence and accountability | 0.659 | 0.895 | 0.741 | 0.160 | 0.011 | 0.494 | 0.431 | 0.724 | 0.431 | 0.250 | 0.466 | 0.424 | 0.352 | 0.241 | 0.068 | 0.195 | 2.399 | 0.581 | 0.686 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 1.000 | 0.664 | 0.492 | 0.450 | 2.398 | 0.579 | 0.515 | 0.415 | 0.337 | 0.222 | 0.036 | 0.237 | 0.063 | 0.840 | 0.610 |
| Current-style federal supreme court | 2 | 12000 | 1.000 | 0.664 | 0.490 | 0.447 | 2.396 | 0.582 | 0.517 | 0.247 | 0.173 | 0.337 | 0.077 | 0.068 | 0.000 | 0.996 | 0.996 |
| Current-style federal supreme court | 3 | 12000 | 1.000 | 0.665 | 0.490 | 0.443 | 2.401 | 0.579 | 0.516 | 0.236 | 0.161 | 0.331 | 0.076 | 0.058 | 0.000 | 0.998 | 1.000 |
| Current-style federal supreme court | 4 | 12000 | 1.000 | 0.665 | 0.494 | 0.444 | 2.401 | 0.582 | 0.518 | 0.240 | 0.170 | 0.330 | 0.074 | 0.057 | 0.000 | 0.998 | 1.000 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 1.000 | 0.672 | 0.487 | 0.418 | 2.398 | 0.579 | 0.515 | 0.415 | 0.344 | 0.218 | 0.034 | 0.239 | 0.065 | 0.830 | 0.591 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 1.000 | 0.674 | 0.482 | 0.420 | 2.396 | 0.582 | 0.517 | 0.251 | 0.178 | 0.326 | 0.072 | 0.071 | 0.000 | 0.993 | 0.992 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 1.000 | 0.674 | 0.480 | 0.417 | 2.401 | 0.579 | 0.516 | 0.242 | 0.166 | 0.326 | 0.078 | 0.063 | 0.000 | 0.998 | 1.000 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 1.000 | 0.671 | 0.490 | 0.415 | 2.401 | 0.582 | 0.518 | 0.250 | 0.165 | 0.328 | 0.072 | 0.057 | 0.000 | 0.998 | 1.000 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 1.000 | 0.728 | 0.137 | 0.557 | 2.398 | 0.579 | 0.515 | 0.536 | 0.448 | 0.175 | 0.039 | 0.318 | 0.107 | 0.710 | 0.485 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 1.000 | 0.728 | 0.138 | 0.553 | 2.396 | 0.582 | 0.517 | 0.351 | 0.286 | 0.275 | 0.069 | 0.138 | 0.000 | 0.915 | 0.924 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 1.000 | 0.730 | 0.136 | 0.553 | 2.401 | 0.579 | 0.516 | 0.315 | 0.242 | 0.296 | 0.082 | 0.097 | 0.000 | 0.975 | 0.992 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 1.000 | 0.728 | 0.139 | 0.549 | 2.401 | 0.582 | 0.518 | 0.305 | 0.236 | 0.307 | 0.078 | 0.089 | 0.000 | 0.991 | 1.000 |
| Supermajority required to invalidate laws | 1 | 12000 | 1.000 | 0.723 | 0.143 | 0.533 | 2.398 | 0.579 | 0.515 | 0.526 | 0.446 | 0.175 | 0.036 | 0.320 | 0.104 | 0.718 | 0.495 |
| Supermajority required to invalidate laws | 2 | 12000 | 1.000 | 0.723 | 0.141 | 0.529 | 2.396 | 0.582 | 0.517 | 0.346 | 0.282 | 0.282 | 0.074 | 0.133 | 0.000 | 0.920 | 0.931 |
| Supermajority required to invalidate laws | 3 | 12000 | 1.000 | 0.724 | 0.143 | 0.534 | 2.401 | 0.579 | 0.516 | 0.316 | 0.246 | 0.297 | 0.077 | 0.091 | 0.000 | 0.975 | 0.990 |
| Supermajority required to invalidate laws | 4 | 12000 | 1.000 | 0.723 | 0.142 | 0.521 | 2.401 | 0.582 | 0.518 | 0.312 | 0.230 | 0.307 | 0.077 | 0.092 | 0.000 | 0.989 | 0.999 |
| Strict recusal with substitute justices | 1 | 12000 | 1.000 | 0.728 | 0.134 | 0.540 | 2.398 | 0.579 | 0.515 | 0.539 | 0.465 | 0.162 | 0.039 | 0.320 | 0.114 | 0.692 | 0.462 |
| Strict recusal with substitute justices | 2 | 12000 | 1.000 | 0.728 | 0.135 | 0.542 | 2.396 | 0.582 | 0.517 | 0.358 | 0.298 | 0.269 | 0.068 | 0.148 | 0.001 | 0.894 | 0.902 |
| Strict recusal with substitute justices | 3 | 12000 | 1.000 | 0.729 | 0.135 | 0.539 | 2.401 | 0.579 | 0.516 | 0.322 | 0.256 | 0.293 | 0.075 | 0.096 | 0.000 | 0.964 | 0.983 |
| Strict recusal with substitute justices | 4 | 12000 | 1.000 | 0.727 | 0.137 | 0.531 | 2.401 | 0.582 | 0.518 | 0.312 | 0.240 | 0.299 | 0.083 | 0.092 | 0.000 | 0.984 | 0.994 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 1.000 | 0.736 | 0.012 | 0.527 | 2.398 | 0.579 | 0.515 | 0.559 | 0.477 | 0.167 | 0.042 | 0.344 | 0.119 | 0.693 | 0.502 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 1.000 | 0.736 | 0.012 | 0.526 | 2.396 | 0.582 | 0.517 | 0.383 | 0.318 | 0.263 | 0.079 | 0.153 | 0.001 | 0.907 | 0.932 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 1.000 | 0.737 | 0.012 | 0.527 | 2.401 | 0.579 | 0.516 | 0.350 | 0.280 | 0.289 | 0.077 | 0.116 | 0.000 | 0.968 | 0.988 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 1.000 | 0.735 | 0.012 | 0.527 | 2.401 | 0.582 | 0.518 | 0.340 | 0.266 | 0.295 | 0.082 | 0.106 | 0.000 | 0.984 | 0.996 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.728 | 0.137 | 0.562 | 2.398 | 0.579 | 0.515 | 0.536 | 0.466 | 0.167 | 0.037 | 0.330 | 0.110 | 0.703 | 0.477 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.728 | 0.137 | 0.561 | 2.396 | 0.582 | 0.517 | 0.359 | 0.287 | 0.279 | 0.072 | 0.140 | 0.000 | 0.911 | 0.922 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.729 | 0.135 | 0.564 | 2.401 | 0.579 | 0.516 | 0.318 | 0.245 | 0.300 | 0.079 | 0.095 | 0.000 | 0.976 | 0.991 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.728 | 0.137 | 0.554 | 2.401 | 0.582 | 0.518 | 0.305 | 0.246 | 0.297 | 0.075 | 0.094 | 0.000 | 0.990 | 0.998 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.741 | 0.016 | 0.409 | 2.398 | 0.579 | 0.515 | 0.578 | 0.502 | 0.154 | 0.036 | 0.351 | 0.135 | 0.649 | 0.421 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.741 | 0.016 | 0.399 | 2.396 | 0.582 | 0.517 | 0.410 | 0.344 | 0.238 | 0.071 | 0.194 | 0.001 | 0.835 | 0.836 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.742 | 0.016 | 0.402 | 2.401 | 0.579 | 0.516 | 0.353 | 0.281 | 0.277 | 0.074 | 0.124 | 0.001 | 0.917 | 0.943 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.741 | 0.016 | 0.402 | 2.401 | 0.582 | 0.518 | 0.350 | 0.279 | 0.285 | 0.075 | 0.110 | 0.000 | 0.953 | 0.976 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.729 | 0.130 | 0.439 | 2.398 | 0.579 | 0.515 | 0.554 | 0.482 | 0.155 | 0.032 | 0.341 | 0.133 | 0.646 | 0.399 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.729 | 0.130 | 0.430 | 2.396 | 0.582 | 0.517 | 0.394 | 0.324 | 0.248 | 0.067 | 0.175 | 0.002 | 0.819 | 0.811 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.731 | 0.129 | 0.440 | 2.401 | 0.579 | 0.516 | 0.341 | 0.282 | 0.268 | 0.076 | 0.126 | 0.001 | 0.889 | 0.915 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.729 | 0.132 | 0.429 | 2.401 | 0.582 | 0.518 | 0.330 | 0.266 | 0.275 | 0.071 | 0.112 | 0.000 | 0.928 | 0.951 |
| Judicial review with delayed legislative override | 1 | 12000 | 1.000 | 0.724 | 0.141 | 0.580 | 2.398 | 0.579 | 0.515 | 0.512 | 0.439 | 0.176 | 0.040 | 0.303 | 0.099 | 0.727 | 0.504 |
| Judicial review with delayed legislative override | 2 | 12000 | 1.000 | 0.724 | 0.141 | 0.575 | 2.396 | 0.582 | 0.517 | 0.340 | 0.269 | 0.278 | 0.072 | 0.130 | 0.000 | 0.937 | 0.947 |
| Judicial review with delayed legislative override | 3 | 12000 | 1.000 | 0.725 | 0.140 | 0.572 | 2.401 | 0.579 | 0.516 | 0.318 | 0.238 | 0.297 | 0.079 | 0.094 | 0.000 | 0.987 | 0.997 |
| Judicial review with delayed legislative override | 4 | 12000 | 1.000 | 0.723 | 0.141 | 0.569 | 2.401 | 0.582 | 0.518 | 0.309 | 0.225 | 0.308 | 0.079 | 0.084 | 0.000 | 0.993 | 1.000 |
| Retention-election accountability court | 1 | 12000 | 1.000 | 0.721 | 0.128 | 0.424 | 2.398 | 0.579 | 0.515 | 0.532 | 0.455 | 0.160 | 0.033 | 0.325 | 0.120 | 0.662 | 0.404 |
| Retention-election accountability court | 2 | 12000 | 1.000 | 0.720 | 0.128 | 0.411 | 2.396 | 0.582 | 0.517 | 0.360 | 0.303 | 0.261 | 0.068 | 0.156 | 0.001 | 0.853 | 0.836 |
| Retention-election accountability court | 3 | 12000 | 1.000 | 0.722 | 0.128 | 0.417 | 2.401 | 0.579 | 0.516 | 0.319 | 0.254 | 0.274 | 0.073 | 0.101 | 0.000 | 0.920 | 0.938 |
| Retention-election accountability court | 4 | 12000 | 1.000 | 0.720 | 0.129 | 0.415 | 2.401 | 0.582 | 0.518 | 0.304 | 0.236 | 0.293 | 0.070 | 0.094 | 0.000 | 0.953 | 0.969 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.740 | 0.011 | 0.435 | 2.398 | 0.579 | 0.515 | 0.577 | 0.503 | 0.157 | 0.038 | 0.351 | 0.137 | 0.644 | 0.438 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.740 | 0.011 | 0.430 | 2.396 | 0.582 | 0.517 | 0.409 | 0.340 | 0.245 | 0.077 | 0.186 | 0.002 | 0.830 | 0.853 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.741 | 0.010 | 0.430 | 2.401 | 0.579 | 0.516 | 0.362 | 0.292 | 0.277 | 0.076 | 0.128 | 0.001 | 0.913 | 0.948 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.740 | 0.011 | 0.431 | 2.401 | 0.582 | 0.518 | 0.347 | 0.274 | 0.286 | 0.080 | 0.113 | 0.001 | 0.947 | 0.974 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 6824 | 1.000 | 0.714 | 0.406 | 0.109 | 2.622 | 0.485 | 0.527 | 0.321 | 0.253 | 0.362 | 0.055 | 0.148 | 0.018 | 0.954 | 0.900 |
| Current-style federal supreme court | criminal_procedure | 6852 | 1.000 | 0.656 | 0.481 | 0.573 | 2.344 | 0.580 | 0.509 | 0.281 | 0.202 | 0.300 | 0.067 | 0.096 | 0.016 | 0.959 | 0.902 |
| Current-style federal supreme court | election_law | 6995 | 1.000 | 0.635 | 0.483 | 0.618 | 2.465 | 0.683 | 0.521 | 0.262 | 0.191 | 0.306 | 0.075 | 0.074 | 0.015 | 0.961 | 0.907 |
| Current-style federal supreme court | emergency_powers | 6799 | 1.000 | 0.625 | 0.669 | 0.439 | 2.316 | 0.548 | 0.519 | 0.261 | 0.181 | 0.310 | 0.062 | 0.097 | 0.016 | 0.957 | 0.896 |
| Current-style federal supreme court | equality | 6893 | 1.000 | 0.660 | 0.494 | 0.676 | 2.290 | 0.532 | 0.480 | 0.277 | 0.209 | 0.290 | 0.069 | 0.105 | 0.015 | 0.959 | 0.903 |
| Current-style federal supreme court | federalism | 6848 | 1.000 | 0.705 | 0.417 | 0.142 | 2.514 | 0.768 | 0.593 | 0.299 | 0.223 | 0.275 | 0.061 | 0.081 | 0.017 | 0.956 | 0.901 |
| Current-style federal supreme court | speech | 6789 | 1.000 | 0.657 | 0.493 | 0.575 | 2.240 | 0.464 | 0.467 | 0.294 | 0.211 | 0.293 | 0.071 | 0.133 | 0.015 | 0.960 | 0.903 |
| Staggered 18-year nonrenewable terms | administrative_state | 6824 | 1.000 | 0.723 | 0.394 | 0.085 | 2.622 | 0.485 | 0.527 | 0.333 | 0.258 | 0.357 | 0.059 | 0.157 | 0.019 | 0.950 | 0.894 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 6852 | 1.000 | 0.660 | 0.478 | 0.543 | 2.344 | 0.580 | 0.509 | 0.287 | 0.216 | 0.287 | 0.068 | 0.098 | 0.016 | 0.956 | 0.896 |
| Staggered 18-year nonrenewable terms | election_law | 6995 | 1.000 | 0.642 | 0.483 | 0.583 | 2.465 | 0.683 | 0.521 | 0.268 | 0.195 | 0.292 | 0.068 | 0.077 | 0.015 | 0.958 | 0.901 |
| Staggered 18-year nonrenewable terms | emergency_powers | 6799 | 1.000 | 0.638 | 0.657 | 0.388 | 2.316 | 0.548 | 0.519 | 0.260 | 0.184 | 0.304 | 0.059 | 0.103 | 0.016 | 0.953 | 0.891 |
| Staggered 18-year nonrenewable terms | equality | 6893 | 1.000 | 0.665 | 0.484 | 0.657 | 2.290 | 0.532 | 0.480 | 0.278 | 0.203 | 0.296 | 0.072 | 0.108 | 0.016 | 0.956 | 0.897 |
| Staggered 18-year nonrenewable terms | federalism | 6848 | 1.000 | 0.718 | 0.414 | 0.107 | 2.514 | 0.768 | 0.593 | 0.312 | 0.225 | 0.271 | 0.053 | 0.079 | 0.018 | 0.952 | 0.894 |
| Staggered 18-year nonrenewable terms | speech | 6789 | 1.000 | 0.663 | 0.487 | 0.555 | 2.240 | 0.464 | 0.467 | 0.289 | 0.214 | 0.290 | 0.068 | 0.131 | 0.015 | 0.957 | 0.898 |
| Fifteen-justice supermajority commission court | administrative_state | 6824 | 1.000 | 0.748 | 0.114 | 0.088 | 2.622 | 0.485 | 0.527 | 0.403 | 0.326 | 0.308 | 0.047 | 0.203 | 0.031 | 0.890 | 0.847 |
| Fifteen-justice supermajority commission court | criminal_procedure | 6852 | 1.000 | 0.716 | 0.147 | 0.707 | 2.344 | 0.580 | 0.509 | 0.370 | 0.304 | 0.252 | 0.068 | 0.156 | 0.026 | 0.899 | 0.850 |
| Fifteen-justice supermajority commission court | election_law | 6995 | 1.000 | 0.713 | 0.120 | 0.729 | 2.465 | 0.683 | 0.521 | 0.357 | 0.282 | 0.255 | 0.078 | 0.121 | 0.024 | 0.908 | 0.860 |
| Fifteen-justice supermajority commission court | emergency_powers | 6799 | 1.000 | 0.715 | 0.195 | 0.484 | 2.316 | 0.548 | 0.519 | 0.373 | 0.295 | 0.260 | 0.067 | 0.174 | 0.028 | 0.893 | 0.841 |
| Fifteen-justice supermajority commission court | equality | 6893 | 1.000 | 0.727 | 0.136 | 0.836 | 2.290 | 0.532 | 0.480 | 0.382 | 0.299 | 0.265 | 0.083 | 0.163 | 0.026 | 0.904 | 0.855 |
| Fifteen-justice supermajority commission court | federalism | 6848 | 1.000 | 0.759 | 0.117 | 0.103 | 2.514 | 0.768 | 0.593 | 0.379 | 0.311 | 0.238 | 0.057 | 0.119 | 0.029 | 0.893 | 0.847 |
| Fifteen-justice supermajority commission court | speech | 6789 | 1.000 | 0.722 | 0.135 | 0.723 | 2.240 | 0.464 | 0.467 | 0.374 | 0.304 | 0.264 | 0.069 | 0.189 | 0.025 | 0.899 | 0.850 |
| Supermajority required to invalidate laws | administrative_state | 6824 | 1.000 | 0.744 | 0.119 | 0.088 | 2.622 | 0.485 | 0.527 | 0.397 | 0.326 | 0.312 | 0.052 | 0.207 | 0.030 | 0.894 | 0.851 |
| Supermajority required to invalidate laws | criminal_procedure | 6852 | 1.000 | 0.712 | 0.150 | 0.669 | 2.344 | 0.580 | 0.509 | 0.366 | 0.300 | 0.258 | 0.067 | 0.144 | 0.025 | 0.902 | 0.853 |
| Supermajority required to invalidate laws | election_law | 6995 | 1.000 | 0.706 | 0.126 | 0.708 | 2.465 | 0.683 | 0.521 | 0.363 | 0.279 | 0.264 | 0.076 | 0.122 | 0.024 | 0.909 | 0.862 |
| Supermajority required to invalidate laws | emergency_powers | 6799 | 1.000 | 0.704 | 0.204 | 0.458 | 2.316 | 0.548 | 0.519 | 0.366 | 0.290 | 0.264 | 0.065 | 0.167 | 0.027 | 0.896 | 0.847 |
| Supermajority required to invalidate laws | equality | 6893 | 1.000 | 0.727 | 0.135 | 0.809 | 2.290 | 0.532 | 0.480 | 0.371 | 0.292 | 0.266 | 0.074 | 0.166 | 0.025 | 0.905 | 0.857 |
| Supermajority required to invalidate laws | federalism | 6848 | 1.000 | 0.754 | 0.123 | 0.123 | 2.514 | 0.768 | 0.593 | 0.386 | 0.305 | 0.247 | 0.057 | 0.116 | 0.028 | 0.895 | 0.850 |
| Supermajority required to invalidate laws | speech | 6789 | 1.000 | 0.717 | 0.140 | 0.672 | 2.240 | 0.464 | 0.467 | 0.376 | 0.314 | 0.247 | 0.071 | 0.191 | 0.024 | 0.901 | 0.854 |
| Strict recusal with substitute justices | administrative_state | 6824 | 1.000 | 0.747 | 0.113 | 0.089 | 2.622 | 0.485 | 0.527 | 0.413 | 0.338 | 0.303 | 0.049 | 0.212 | 0.032 | 0.877 | 0.833 |
| Strict recusal with substitute justices | criminal_procedure | 6852 | 1.000 | 0.716 | 0.145 | 0.688 | 2.344 | 0.580 | 0.509 | 0.371 | 0.306 | 0.250 | 0.071 | 0.156 | 0.028 | 0.885 | 0.836 |
| Strict recusal with substitute justices | election_law | 6995 | 1.000 | 0.713 | 0.116 | 0.706 | 2.465 | 0.683 | 0.521 | 0.373 | 0.297 | 0.259 | 0.072 | 0.121 | 0.026 | 0.894 | 0.846 |
| Strict recusal with substitute justices | emergency_powers | 6799 | 1.000 | 0.713 | 0.194 | 0.460 | 2.316 | 0.548 | 0.519 | 0.379 | 0.308 | 0.250 | 0.068 | 0.173 | 0.030 | 0.878 | 0.825 |
| Strict recusal with substitute justices | equality | 6893 | 1.000 | 0.728 | 0.131 | 0.827 | 2.290 | 0.532 | 0.480 | 0.381 | 0.313 | 0.259 | 0.077 | 0.166 | 0.028 | 0.889 | 0.839 |
| Strict recusal with substitute justices | federalism | 6848 | 1.000 | 0.758 | 0.115 | 0.090 | 2.514 | 0.768 | 0.593 | 0.379 | 0.325 | 0.217 | 0.056 | 0.121 | 0.031 | 0.875 | 0.829 |
| Strict recusal with substitute justices | speech | 6789 | 1.000 | 0.722 | 0.134 | 0.705 | 2.240 | 0.464 | 0.467 | 0.383 | 0.319 | 0.251 | 0.068 | 0.198 | 0.027 | 0.885 | 0.837 |
| Reasoned emergency orders with merits follow-up | administrative_state | 6824 | 1.000 | 0.749 | 0.002 | 0.093 | 2.622 | 0.485 | 0.527 | 0.439 | 0.360 | 0.291 | 0.051 | 0.221 | 0.035 | 0.879 | 0.852 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 6852 | 1.000 | 0.732 | 0.009 | 0.687 | 2.344 | 0.580 | 0.509 | 0.399 | 0.327 | 0.252 | 0.077 | 0.174 | 0.029 | 0.890 | 0.854 |
| Reasoned emergency orders with merits follow-up | election_law | 6995 | 1.000 | 0.719 | 0.014 | 0.738 | 2.465 | 0.683 | 0.521 | 0.379 | 0.326 | 0.248 | 0.083 | 0.138 | 0.027 | 0.901 | 0.864 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 6799 | 1.000 | 0.718 | 0.029 | 0.490 | 2.316 | 0.548 | 0.519 | 0.409 | 0.333 | 0.255 | 0.065 | 0.181 | 0.032 | 0.883 | 0.847 |
| Reasoned emergency orders with merits follow-up | equality | 6893 | 1.000 | 0.742 | 0.015 | 0.836 | 2.290 | 0.532 | 0.480 | 0.412 | 0.334 | 0.259 | 0.085 | 0.189 | 0.029 | 0.895 | 0.858 |
| Reasoned emergency orders with merits follow-up | federalism | 6848 | 1.000 | 0.757 | 0.002 | 0.130 | 2.514 | 0.768 | 0.593 | 0.409 | 0.339 | 0.219 | 0.055 | 0.134 | 0.033 | 0.880 | 0.849 |
| Reasoned emergency orders with merits follow-up | speech | 6789 | 1.000 | 0.735 | 0.012 | 0.705 | 2.240 | 0.464 | 0.467 | 0.410 | 0.328 | 0.248 | 0.073 | 0.222 | 0.028 | 0.891 | 0.857 |
| Panel review with en banc safety valve | administrative_state | 6824 | 1.000 | 0.748 | 0.113 | 0.094 | 2.622 | 0.485 | 0.527 | 0.410 | 0.335 | 0.314 | 0.050 | 0.209 | 0.032 | 0.888 | 0.844 |
| Panel review with en banc safety valve | criminal_procedure | 6852 | 1.000 | 0.716 | 0.148 | 0.714 | 2.344 | 0.580 | 0.509 | 0.372 | 0.301 | 0.258 | 0.070 | 0.156 | 0.027 | 0.895 | 0.846 |
| Panel review with en banc safety valve | election_law | 6995 | 1.000 | 0.712 | 0.116 | 0.733 | 2.465 | 0.683 | 0.521 | 0.364 | 0.294 | 0.259 | 0.080 | 0.119 | 0.026 | 0.905 | 0.857 |
| Panel review with en banc safety valve | emergency_powers | 6799 | 1.000 | 0.715 | 0.193 | 0.480 | 2.316 | 0.548 | 0.519 | 0.366 | 0.313 | 0.252 | 0.064 | 0.169 | 0.029 | 0.891 | 0.840 |
| Panel review with en banc safety valve | equality | 6893 | 1.000 | 0.725 | 0.135 | 0.850 | 2.290 | 0.532 | 0.480 | 0.374 | 0.301 | 0.260 | 0.073 | 0.172 | 0.026 | 0.900 | 0.850 |
| Panel review with en banc safety valve | federalism | 6848 | 1.000 | 0.759 | 0.116 | 0.099 | 2.514 | 0.768 | 0.593 | 0.378 | 0.315 | 0.225 | 0.055 | 0.125 | 0.030 | 0.888 | 0.842 |
| Panel review with en banc safety valve | speech | 6789 | 1.000 | 0.722 | 0.136 | 0.742 | 2.240 | 0.464 | 0.467 | 0.393 | 0.318 | 0.260 | 0.068 | 0.202 | 0.026 | 0.896 | 0.847 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 6824 | 1.000 | 0.748 | 0.005 | 0.018 | 2.622 | 0.485 | 0.527 | 0.450 | 0.373 | 0.274 | 0.045 | 0.233 | 0.039 | 0.828 | 0.791 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 6852 | 1.000 | 0.737 | 0.013 | 0.552 | 2.344 | 0.580 | 0.509 | 0.412 | 0.342 | 0.238 | 0.070 | 0.188 | 0.032 | 0.841 | 0.795 |
| Dual supreme courts with cross-checking invalidations | election_law | 6995 | 1.000 | 0.731 | 0.017 | 0.592 | 2.465 | 0.683 | 0.521 | 0.409 | 0.342 | 0.243 | 0.073 | 0.153 | 0.031 | 0.854 | 0.807 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 6799 | 1.000 | 0.723 | 0.035 | 0.294 | 2.316 | 0.548 | 0.519 | 0.416 | 0.349 | 0.233 | 0.058 | 0.204 | 0.037 | 0.831 | 0.784 |
| Dual supreme courts with cross-checking invalidations | equality | 6893 | 1.000 | 0.750 | 0.020 | 0.746 | 2.290 | 0.532 | 0.480 | 0.417 | 0.343 | 0.244 | 0.080 | 0.202 | 0.032 | 0.848 | 0.801 |
| Dual supreme courts with cross-checking invalidations | federalism | 6848 | 1.000 | 0.761 | 0.005 | 0.023 | 2.514 | 0.768 | 0.593 | 0.421 | 0.363 | 0.205 | 0.050 | 0.157 | 0.037 | 0.829 | 0.788 |
| Dual supreme courts with cross-checking invalidations | speech | 6789 | 1.000 | 0.739 | 0.017 | 0.588 | 2.240 | 0.464 | 0.467 | 0.433 | 0.350 | 0.232 | 0.072 | 0.228 | 0.032 | 0.838 | 0.792 |
| Pre-enactment constitutional council | administrative_state | 6824 | 1.000 | 0.746 | 0.111 | 0.018 | 2.622 | 0.485 | 0.527 | 0.441 | 0.359 | 0.285 | 0.048 | 0.242 | 0.038 | 0.813 | 0.766 |
| Pre-enactment constitutional council | criminal_procedure | 6852 | 1.000 | 0.718 | 0.138 | 0.576 | 2.344 | 0.580 | 0.509 | 0.388 | 0.336 | 0.227 | 0.069 | 0.181 | 0.032 | 0.821 | 0.767 |
| Pre-enactment constitutional council | election_law | 6995 | 1.000 | 0.718 | 0.112 | 0.574 | 2.465 | 0.683 | 0.521 | 0.385 | 0.319 | 0.229 | 0.069 | 0.144 | 0.032 | 0.835 | 0.784 |
| Pre-enactment constitutional council | emergency_powers | 6799 | 1.000 | 0.711 | 0.183 | 0.280 | 2.316 | 0.548 | 0.519 | 0.401 | 0.330 | 0.231 | 0.059 | 0.198 | 0.036 | 0.815 | 0.760 |
| Pre-enactment constitutional council | equality | 6893 | 1.000 | 0.732 | 0.127 | 0.752 | 2.290 | 0.532 | 0.480 | 0.395 | 0.335 | 0.243 | 0.070 | 0.197 | 0.032 | 0.826 | 0.775 |
| Pre-enactment constitutional council | federalism | 6848 | 1.000 | 0.759 | 0.112 | 0.022 | 2.514 | 0.768 | 0.593 | 0.415 | 0.353 | 0.211 | 0.051 | 0.147 | 0.036 | 0.812 | 0.762 |
| Pre-enactment constitutional council | speech | 6789 | 1.000 | 0.722 | 0.130 | 0.610 | 2.240 | 0.464 | 0.467 | 0.408 | 0.338 | 0.230 | 0.062 | 0.212 | 0.031 | 0.819 | 0.767 |
| Judicial review with delayed legislative override | administrative_state | 6824 | 1.000 | 0.746 | 0.118 | 0.145 | 2.622 | 0.485 | 0.527 | 0.406 | 0.323 | 0.302 | 0.052 | 0.200 | 0.028 | 0.904 | 0.860 |
| Judicial review with delayed legislative override | criminal_procedure | 6852 | 1.000 | 0.711 | 0.149 | 0.717 | 2.344 | 0.580 | 0.509 | 0.355 | 0.288 | 0.268 | 0.073 | 0.142 | 0.024 | 0.913 | 0.862 |
| Judicial review with delayed legislative override | election_law | 6995 | 1.000 | 0.707 | 0.119 | 0.745 | 2.465 | 0.683 | 0.521 | 0.354 | 0.265 | 0.265 | 0.074 | 0.113 | 0.022 | 0.920 | 0.871 |
| Judicial review with delayed legislative override | emergency_powers | 6799 | 1.000 | 0.708 | 0.201 | 0.515 | 2.316 | 0.548 | 0.519 | 0.358 | 0.282 | 0.265 | 0.066 | 0.165 | 0.026 | 0.907 | 0.855 |
| Judicial review with delayed legislative override | equality | 6893 | 1.000 | 0.722 | 0.137 | 0.849 | 2.290 | 0.532 | 0.480 | 0.368 | 0.286 | 0.261 | 0.075 | 0.161 | 0.024 | 0.916 | 0.866 |
| Judicial review with delayed legislative override | federalism | 6848 | 1.000 | 0.755 | 0.121 | 0.135 | 2.514 | 0.768 | 0.593 | 0.373 | 0.303 | 0.233 | 0.055 | 0.112 | 0.027 | 0.905 | 0.858 |
| Judicial review with delayed legislative override | speech | 6789 | 1.000 | 0.718 | 0.138 | 0.736 | 2.240 | 0.464 | 0.467 | 0.377 | 0.303 | 0.259 | 0.073 | 0.178 | 0.023 | 0.912 | 0.862 |
| Retention-election accountability court | administrative_state | 6824 | 1.000 | 0.747 | 0.112 | 0.024 | 2.622 | 0.485 | 0.527 | 0.402 | 0.349 | 0.291 | 0.050 | 0.220 | 0.034 | 0.841 | 0.786 |
| Retention-election accountability court | criminal_procedure | 6852 | 1.000 | 0.704 | 0.135 | 0.535 | 2.344 | 0.580 | 0.509 | 0.372 | 0.302 | 0.241 | 0.061 | 0.165 | 0.029 | 0.848 | 0.786 |
| Retention-election accountability court | election_law | 6995 | 1.000 | 0.706 | 0.108 | 0.546 | 2.465 | 0.683 | 0.521 | 0.361 | 0.301 | 0.242 | 0.064 | 0.129 | 0.028 | 0.858 | 0.798 |
| Retention-election accountability court | emergency_powers | 6799 | 1.000 | 0.710 | 0.178 | 0.261 | 2.316 | 0.548 | 0.519 | 0.378 | 0.306 | 0.248 | 0.054 | 0.178 | 0.033 | 0.841 | 0.778 |
| Retention-election accountability court | equality | 6893 | 1.000 | 0.715 | 0.125 | 0.741 | 2.290 | 0.532 | 0.480 | 0.360 | 0.295 | 0.252 | 0.078 | 0.163 | 0.028 | 0.855 | 0.792 |
| Retention-election accountability court | federalism | 6848 | 1.000 | 0.759 | 0.113 | 0.043 | 2.514 | 0.768 | 0.593 | 0.394 | 0.321 | 0.216 | 0.052 | 0.133 | 0.033 | 0.841 | 0.783 |
| Retention-election accountability court | speech | 6789 | 1.000 | 0.706 | 0.127 | 0.575 | 2.240 | 0.464 | 0.467 | 0.383 | 0.311 | 0.237 | 0.067 | 0.196 | 0.029 | 0.847 | 0.785 |
| Hybrid court balancing independence and accountability | administrative_state | 6824 | 1.000 | 0.748 | 0.001 | 0.030 | 2.622 | 0.485 | 0.527 | 0.444 | 0.379 | 0.277 | 0.054 | 0.241 | 0.039 | 0.823 | 0.801 |
| Hybrid court balancing independence and accountability | criminal_procedure | 6852 | 1.000 | 0.738 | 0.009 | 0.602 | 2.344 | 0.580 | 0.509 | 0.423 | 0.348 | 0.234 | 0.074 | 0.189 | 0.033 | 0.837 | 0.805 |
| Hybrid court balancing independence and accountability | election_law | 6995 | 1.000 | 0.729 | 0.013 | 0.614 | 2.465 | 0.683 | 0.521 | 0.413 | 0.328 | 0.248 | 0.080 | 0.153 | 0.032 | 0.847 | 0.814 |
| Hybrid court balancing independence and accountability | emergency_powers | 6799 | 1.000 | 0.721 | 0.025 | 0.315 | 2.316 | 0.548 | 0.519 | 0.412 | 0.352 | 0.235 | 0.068 | 0.204 | 0.038 | 0.825 | 0.794 |
| Hybrid court balancing independence and accountability | equality | 6893 | 1.000 | 0.748 | 0.015 | 0.777 | 2.290 | 0.532 | 0.480 | 0.422 | 0.340 | 0.244 | 0.077 | 0.204 | 0.032 | 0.842 | 0.807 |
| Hybrid court balancing independence and accountability | federalism | 6848 | 1.000 | 0.761 | 0.001 | 0.035 | 2.514 | 0.768 | 0.593 | 0.428 | 0.362 | 0.216 | 0.049 | 0.145 | 0.038 | 0.823 | 0.797 |
| Hybrid court balancing independence and accountability | speech | 6789 | 1.000 | 0.740 | 0.012 | 0.639 | 2.240 | 0.464 | 0.467 | 0.423 | 0.358 | 0.231 | 0.071 | 0.226 | 0.033 | 0.835 | 0.804 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 4307 | 1.000 | 0.682 | 0.471 | 0.334 | 3.000 | 0.409 | 0.495 | 0.317 | 0.231 | 0.318 | 0.058 | 0.176 | 0.018 | 0.952 | 0.896 |
| Current-style federal supreme court | federal/circuit_panel | 11144 | 1.000 | 0.674 | 0.508 | 0.410 | 2.000 | 0.432 | 0.459 | 0.297 | 0.220 | 0.302 | 0.060 | 0.167 | 0.016 | 0.956 | 0.901 |
| Current-style federal supreme court | federal/district_only | 2580 | 1.000 | 0.678 | 0.509 | 0.457 | 1.000 | 0.441 | 0.430 | 0.304 | 0.215 | 0.277 | 0.069 | 0.166 | 0.015 | 0.959 | 0.904 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.656 | 0.482 | 0.463 | 3.000 | 0.790 | 0.583 | 0.274 | 0.189 | 0.319 | 0.070 | 0.041 | 0.015 | 0.962 | 0.909 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.645 | 0.490 | 0.491 | 3.000 | 0.790 | 0.600 | 0.251 | 0.189 | 0.315 | 0.070 | 0.046 | 0.015 | 0.961 | 0.904 |
| Current-style federal supreme court | state/circuit_panel | 3097 | 1.000 | 0.672 | 0.475 | 0.431 | 2.000 | 0.585 | 0.493 | 0.299 | 0.239 | 0.295 | 0.066 | 0.084 | 0.017 | 0.956 | 0.898 |
| Current-style federal supreme court | state/state_federal_split | 4548 | 1.000 | 0.651 | 0.492 | 0.527 | 3.000 | 0.584 | 0.545 | 0.275 | 0.197 | 0.317 | 0.073 | 0.080 | 0.015 | 0.960 | 0.904 |
| Current-style federal supreme court | state/state_high_court | 9453 | 1.000 | 0.668 | 0.488 | 0.450 | 2.000 | 0.584 | 0.505 | 0.287 | 0.212 | 0.294 | 0.067 | 0.083 | 0.016 | 0.958 | 0.900 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 4307 | 1.000 | 0.690 | 0.462 | 0.303 | 3.000 | 0.409 | 0.495 | 0.312 | 0.243 | 0.310 | 0.064 | 0.186 | 0.019 | 0.948 | 0.890 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 11144 | 1.000 | 0.681 | 0.498 | 0.373 | 2.000 | 0.432 | 0.459 | 0.305 | 0.225 | 0.286 | 0.055 | 0.169 | 0.017 | 0.953 | 0.895 |
| Staggered 18-year nonrenewable terms | federal/district_only | 2580 | 1.000 | 0.683 | 0.509 | 0.438 | 1.000 | 0.441 | 0.430 | 0.291 | 0.222 | 0.295 | 0.068 | 0.169 | 0.015 | 0.955 | 0.898 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.665 | 0.481 | 0.435 | 3.000 | 0.790 | 0.583 | 0.259 | 0.192 | 0.318 | 0.065 | 0.051 | 0.015 | 0.959 | 0.905 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.655 | 0.487 | 0.456 | 3.000 | 0.790 | 0.600 | 0.267 | 0.195 | 0.313 | 0.068 | 0.046 | 0.016 | 0.957 | 0.898 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 3097 | 1.000 | 0.678 | 0.471 | 0.408 | 2.000 | 0.585 | 0.493 | 0.293 | 0.218 | 0.281 | 0.063 | 0.088 | 0.017 | 0.953 | 0.892 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 4548 | 1.000 | 0.660 | 0.478 | 0.508 | 3.000 | 0.584 | 0.545 | 0.288 | 0.209 | 0.297 | 0.069 | 0.085 | 0.016 | 0.956 | 0.898 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 9453 | 1.000 | 0.677 | 0.481 | 0.430 | 2.000 | 0.584 | 0.505 | 0.294 | 0.212 | 0.298 | 0.066 | 0.081 | 0.016 | 0.955 | 0.894 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 4307 | 1.000 | 0.734 | 0.129 | 0.429 | 3.000 | 0.409 | 0.495 | 0.399 | 0.316 | 0.279 | 0.062 | 0.242 | 0.031 | 0.887 | 0.840 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 11144 | 1.000 | 0.732 | 0.141 | 0.524 | 2.000 | 0.432 | 0.459 | 0.388 | 0.321 | 0.258 | 0.063 | 0.238 | 0.028 | 0.893 | 0.847 |
| Fifteen-justice supermajority commission court | federal/district_only | 2580 | 1.000 | 0.734 | 0.143 | 0.559 | 1.000 | 0.441 | 0.430 | 0.397 | 0.319 | 0.245 | 0.069 | 0.240 | 0.027 | 0.894 | 0.850 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.726 | 0.139 | 0.562 | 3.000 | 0.790 | 0.583 | 0.351 | 0.278 | 0.274 | 0.078 | 0.080 | 0.024 | 0.909 | 0.865 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.720 | 0.142 | 0.600 | 3.000 | 0.790 | 0.600 | 0.349 | 0.274 | 0.277 | 0.069 | 0.079 | 0.025 | 0.904 | 0.853 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 3097 | 1.000 | 0.731 | 0.127 | 0.518 | 2.000 | 0.585 | 0.493 | 0.399 | 0.311 | 0.251 | 0.067 | 0.154 | 0.027 | 0.895 | 0.845 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 4548 | 1.000 | 0.722 | 0.137 | 0.649 | 3.000 | 0.584 | 0.545 | 0.371 | 0.300 | 0.261 | 0.075 | 0.131 | 0.026 | 0.901 | 0.853 |
| Fifteen-justice supermajority commission court | state/state_high_court | 9453 | 1.000 | 0.731 | 0.133 | 0.561 | 2.000 | 0.584 | 0.505 | 0.380 | 0.308 | 0.255 | 0.064 | 0.137 | 0.027 | 0.898 | 0.850 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 4307 | 1.000 | 0.730 | 0.133 | 0.406 | 3.000 | 0.409 | 0.495 | 0.397 | 0.321 | 0.279 | 0.061 | 0.251 | 0.030 | 0.891 | 0.845 |
| Supermajority required to invalidate laws | federal/circuit_panel | 11144 | 1.000 | 0.727 | 0.147 | 0.492 | 2.000 | 0.432 | 0.459 | 0.388 | 0.320 | 0.258 | 0.065 | 0.231 | 0.027 | 0.896 | 0.851 |
| Supermajority required to invalidate laws | federal/district_only | 2580 | 1.000 | 0.727 | 0.147 | 0.512 | 1.000 | 0.441 | 0.430 | 0.395 | 0.329 | 0.226 | 0.064 | 0.239 | 0.026 | 0.895 | 0.853 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.722 | 0.144 | 0.548 | 3.000 | 0.790 | 0.583 | 0.355 | 0.270 | 0.283 | 0.067 | 0.075 | 0.023 | 0.911 | 0.867 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.715 | 0.148 | 0.585 | 3.000 | 0.790 | 0.600 | 0.349 | 0.281 | 0.273 | 0.070 | 0.090 | 0.024 | 0.906 | 0.857 |
| Supermajority required to invalidate laws | state/circuit_panel | 3097 | 1.000 | 0.725 | 0.133 | 0.501 | 2.000 | 0.585 | 0.493 | 0.380 | 0.303 | 0.254 | 0.073 | 0.131 | 0.027 | 0.899 | 0.850 |
| Supermajority required to invalidate laws | state/state_federal_split | 4548 | 1.000 | 0.719 | 0.140 | 0.631 | 3.000 | 0.584 | 0.545 | 0.377 | 0.290 | 0.279 | 0.068 | 0.127 | 0.026 | 0.902 | 0.855 |
| Supermajority required to invalidate laws | state/state_high_court | 9453 | 1.000 | 0.727 | 0.137 | 0.539 | 2.000 | 0.584 | 0.505 | 0.374 | 0.297 | 0.262 | 0.063 | 0.134 | 0.026 | 0.901 | 0.853 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 4307 | 1.000 | 0.734 | 0.129 | 0.424 | 3.000 | 0.409 | 0.495 | 0.399 | 0.331 | 0.279 | 0.062 | 0.256 | 0.033 | 0.874 | 0.827 |
| Strict recusal with substitute justices | federal/circuit_panel | 11144 | 1.000 | 0.731 | 0.141 | 0.507 | 2.000 | 0.432 | 0.459 | 0.403 | 0.333 | 0.242 | 0.060 | 0.244 | 0.030 | 0.877 | 0.831 |
| Strict recusal with substitute justices | federal/district_only | 2580 | 1.000 | 0.731 | 0.142 | 0.547 | 1.000 | 0.441 | 0.430 | 0.409 | 0.339 | 0.234 | 0.070 | 0.243 | 0.029 | 0.880 | 0.835 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.727 | 0.134 | 0.548 | 3.000 | 0.790 | 0.583 | 0.356 | 0.297 | 0.264 | 0.069 | 0.075 | 0.026 | 0.895 | 0.849 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.721 | 0.139 | 0.583 | 3.000 | 0.790 | 0.600 | 0.359 | 0.295 | 0.270 | 0.070 | 0.085 | 0.027 | 0.890 | 0.838 |
| Strict recusal with substitute justices | state/circuit_panel | 3097 | 1.000 | 0.731 | 0.122 | 0.504 | 2.000 | 0.585 | 0.493 | 0.370 | 0.315 | 0.244 | 0.074 | 0.140 | 0.029 | 0.882 | 0.832 |
| Strict recusal with substitute justices | state/state_federal_split | 4548 | 1.000 | 0.723 | 0.130 | 0.629 | 3.000 | 0.584 | 0.545 | 0.376 | 0.305 | 0.258 | 0.071 | 0.133 | 0.028 | 0.886 | 0.838 |
| Strict recusal with substitute justices | state/state_high_court | 9453 | 1.000 | 0.731 | 0.133 | 0.546 | 2.000 | 0.584 | 0.505 | 0.384 | 0.311 | 0.253 | 0.064 | 0.139 | 0.029 | 0.884 | 0.835 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 4307 | 1.000 | 0.740 | 0.010 | 0.384 | 3.000 | 0.409 | 0.495 | 0.432 | 0.360 | 0.268 | 0.058 | 0.277 | 0.035 | 0.875 | 0.845 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 11144 | 1.000 | 0.740 | 0.013 | 0.491 | 2.000 | 0.432 | 0.459 | 0.423 | 0.344 | 0.248 | 0.064 | 0.259 | 0.032 | 0.882 | 0.851 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 2580 | 1.000 | 0.743 | 0.014 | 0.549 | 1.000 | 0.441 | 0.430 | 0.434 | 0.341 | 0.228 | 0.071 | 0.269 | 0.031 | 0.884 | 0.855 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.732 | 0.011 | 0.531 | 3.000 | 0.790 | 0.583 | 0.387 | 0.316 | 0.261 | 0.072 | 0.096 | 0.027 | 0.900 | 0.868 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.727 | 0.012 | 0.581 | 3.000 | 0.790 | 0.600 | 0.381 | 0.320 | 0.265 | 0.077 | 0.095 | 0.028 | 0.896 | 0.858 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 3097 | 1.000 | 0.739 | 0.011 | 0.503 | 2.000 | 0.585 | 0.493 | 0.414 | 0.323 | 0.244 | 0.071 | 0.155 | 0.032 | 0.886 | 0.849 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 4548 | 1.000 | 0.731 | 0.012 | 0.622 | 3.000 | 0.584 | 0.545 | 0.399 | 0.336 | 0.255 | 0.072 | 0.151 | 0.029 | 0.891 | 0.856 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 9453 | 1.000 | 0.739 | 0.012 | 0.535 | 2.000 | 0.584 | 0.505 | 0.409 | 0.339 | 0.247 | 0.072 | 0.154 | 0.030 | 0.890 | 0.854 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 4307 | 1.000 | 0.735 | 0.129 | 0.444 | 3.000 | 0.409 | 0.495 | 0.404 | 0.336 | 0.277 | 0.055 | 0.250 | 0.032 | 0.884 | 0.837 |
| Panel review with en banc safety valve | federal/circuit_panel | 11144 | 1.000 | 0.732 | 0.142 | 0.533 | 2.000 | 0.432 | 0.459 | 0.396 | 0.323 | 0.252 | 0.062 | 0.242 | 0.029 | 0.890 | 0.844 |
| Panel review with en banc safety valve | federal/district_only | 2580 | 1.000 | 0.733 | 0.144 | 0.574 | 1.000 | 0.441 | 0.430 | 0.384 | 0.317 | 0.264 | 0.064 | 0.244 | 0.027 | 0.893 | 0.849 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.726 | 0.135 | 0.567 | 3.000 | 0.790 | 0.583 | 0.353 | 0.295 | 0.270 | 0.069 | 0.077 | 0.026 | 0.903 | 0.857 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.719 | 0.139 | 0.602 | 3.000 | 0.790 | 0.600 | 0.354 | 0.285 | 0.271 | 0.063 | 0.086 | 0.026 | 0.901 | 0.850 |
| Panel review with en banc safety valve | state/circuit_panel | 3097 | 1.000 | 0.730 | 0.127 | 0.537 | 2.000 | 0.585 | 0.493 | 0.391 | 0.320 | 0.243 | 0.069 | 0.147 | 0.029 | 0.893 | 0.843 |
| Panel review with en banc safety valve | state/state_federal_split | 4548 | 1.000 | 0.723 | 0.135 | 0.649 | 3.000 | 0.584 | 0.545 | 0.369 | 0.313 | 0.259 | 0.077 | 0.134 | 0.026 | 0.899 | 0.851 |
| Panel review with en banc safety valve | state/state_high_court | 9453 | 1.000 | 0.731 | 0.132 | 0.567 | 2.000 | 0.584 | 0.505 | 0.384 | 0.311 | 0.257 | 0.070 | 0.144 | 0.028 | 0.895 | 0.846 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 4307 | 1.000 | 0.742 | 0.013 | 0.278 | 3.000 | 0.409 | 0.495 | 0.455 | 0.356 | 0.253 | 0.054 | 0.285 | 0.039 | 0.825 | 0.783 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 11144 | 1.000 | 0.742 | 0.017 | 0.377 | 2.000 | 0.432 | 0.459 | 0.439 | 0.372 | 0.227 | 0.063 | 0.276 | 0.035 | 0.831 | 0.789 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 2580 | 1.000 | 0.740 | 0.019 | 0.409 | 1.000 | 0.441 | 0.430 | 0.449 | 0.360 | 0.224 | 0.055 | 0.286 | 0.035 | 0.829 | 0.790 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.742 | 0.014 | 0.402 | 3.000 | 0.790 | 0.583 | 0.384 | 0.337 | 0.251 | 0.069 | 0.116 | 0.031 | 0.854 | 0.812 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.739 | 0.016 | 0.438 | 3.000 | 0.790 | 0.600 | 0.400 | 0.327 | 0.249 | 0.069 | 0.114 | 0.033 | 0.846 | 0.799 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 3097 | 1.000 | 0.741 | 0.014 | 0.390 | 2.000 | 0.585 | 0.493 | 0.414 | 0.337 | 0.246 | 0.061 | 0.168 | 0.035 | 0.841 | 0.793 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 4548 | 1.000 | 0.740 | 0.016 | 0.494 | 3.000 | 0.584 | 0.545 | 0.414 | 0.343 | 0.237 | 0.066 | 0.161 | 0.033 | 0.841 | 0.795 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 9453 | 1.000 | 0.743 | 0.015 | 0.415 | 2.000 | 0.584 | 0.505 | 0.425 | 0.361 | 0.233 | 0.065 | 0.167 | 0.034 | 0.840 | 0.795 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 4307 | 1.000 | 0.734 | 0.124 | 0.330 | 3.000 | 0.409 | 0.495 | 0.432 | 0.359 | 0.239 | 0.051 | 0.283 | 0.039 | 0.808 | 0.760 |
| Pre-enactment constitutional council | federal/circuit_panel | 11144 | 1.000 | 0.729 | 0.137 | 0.412 | 2.000 | 0.432 | 0.459 | 0.418 | 0.350 | 0.233 | 0.056 | 0.272 | 0.036 | 0.813 | 0.762 |
| Pre-enactment constitutional council | federal/district_only | 2580 | 1.000 | 0.728 | 0.134 | 0.428 | 1.000 | 0.441 | 0.430 | 0.428 | 0.363 | 0.225 | 0.064 | 0.265 | 0.034 | 0.815 | 0.766 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.732 | 0.128 | 0.439 | 3.000 | 0.790 | 0.583 | 0.365 | 0.321 | 0.238 | 0.058 | 0.105 | 0.030 | 0.836 | 0.787 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.727 | 0.133 | 0.469 | 3.000 | 0.790 | 0.600 | 0.386 | 0.318 | 0.248 | 0.067 | 0.108 | 0.032 | 0.827 | 0.773 |
| Pre-enactment constitutional council | state/circuit_panel | 3097 | 1.000 | 0.730 | 0.118 | 0.415 | 2.000 | 0.585 | 0.493 | 0.413 | 0.341 | 0.223 | 0.064 | 0.165 | 0.035 | 0.822 | 0.769 |
| Pre-enactment constitutional council | state/state_federal_split | 4548 | 1.000 | 0.727 | 0.128 | 0.519 | 3.000 | 0.584 | 0.545 | 0.390 | 0.329 | 0.241 | 0.064 | 0.159 | 0.033 | 0.822 | 0.771 |
| Pre-enactment constitutional council | state/state_high_court | 9453 | 1.000 | 0.731 | 0.127 | 0.442 | 2.000 | 0.584 | 0.505 | 0.408 | 0.340 | 0.234 | 0.065 | 0.160 | 0.034 | 0.822 | 0.770 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 4307 | 1.000 | 0.732 | 0.130 | 0.457 | 3.000 | 0.409 | 0.495 | 0.391 | 0.319 | 0.272 | 0.064 | 0.230 | 0.028 | 0.902 | 0.853 |
| Judicial review with delayed legislative override | federal/circuit_panel | 11144 | 1.000 | 0.728 | 0.146 | 0.539 | 2.000 | 0.432 | 0.459 | 0.389 | 0.302 | 0.263 | 0.065 | 0.235 | 0.026 | 0.907 | 0.860 |
| Judicial review with delayed legislative override | federal/district_only | 2580 | 1.000 | 0.729 | 0.145 | 0.580 | 1.000 | 0.441 | 0.430 | 0.381 | 0.305 | 0.259 | 0.063 | 0.222 | 0.024 | 0.911 | 0.867 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.722 | 0.137 | 0.583 | 3.000 | 0.790 | 0.583 | 0.344 | 0.257 | 0.269 | 0.076 | 0.078 | 0.022 | 0.920 | 0.873 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.714 | 0.145 | 0.623 | 3.000 | 0.790 | 0.600 | 0.338 | 0.275 | 0.281 | 0.070 | 0.080 | 0.024 | 0.916 | 0.865 |
| Judicial review with delayed legislative override | state/circuit_panel | 3097 | 1.000 | 0.727 | 0.131 | 0.550 | 2.000 | 0.585 | 0.493 | 0.378 | 0.298 | 0.253 | 0.067 | 0.134 | 0.026 | 0.910 | 0.859 |
| Judicial review with delayed legislative override | state/state_federal_split | 4548 | 1.000 | 0.717 | 0.139 | 0.662 | 3.000 | 0.584 | 0.545 | 0.369 | 0.283 | 0.266 | 0.066 | 0.120 | 0.024 | 0.914 | 0.864 |
| Judicial review with delayed legislative override | state/state_high_court | 9453 | 1.000 | 0.726 | 0.138 | 0.585 | 2.000 | 0.584 | 0.505 | 0.374 | 0.301 | 0.251 | 0.067 | 0.123 | 0.025 | 0.911 | 0.861 |
| Retention-election accountability court | federal/circuit_en_banc | 4307 | 1.000 | 0.727 | 0.123 | 0.315 | 3.000 | 0.409 | 0.495 | 0.401 | 0.326 | 0.270 | 0.052 | 0.253 | 0.034 | 0.836 | 0.778 |
| Retention-election accountability court | federal/circuit_panel | 11144 | 1.000 | 0.720 | 0.134 | 0.386 | 2.000 | 0.432 | 0.459 | 0.394 | 0.326 | 0.242 | 0.060 | 0.246 | 0.032 | 0.839 | 0.780 |
| Retention-election accountability court | federal/district_only | 2580 | 1.000 | 0.716 | 0.134 | 0.396 | 1.000 | 0.441 | 0.430 | 0.395 | 0.313 | 0.219 | 0.056 | 0.257 | 0.031 | 0.843 | 0.788 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.725 | 0.127 | 0.425 | 3.000 | 0.790 | 0.583 | 0.345 | 0.286 | 0.271 | 0.057 | 0.089 | 0.027 | 0.862 | 0.803 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.720 | 0.132 | 0.475 | 3.000 | 0.790 | 0.600 | 0.352 | 0.290 | 0.259 | 0.067 | 0.093 | 0.029 | 0.855 | 0.792 |
| Retention-election accountability court | state/circuit_panel | 3097 | 1.000 | 0.721 | 0.116 | 0.384 | 2.000 | 0.585 | 0.493 | 0.386 | 0.316 | 0.229 | 0.060 | 0.147 | 0.031 | 0.850 | 0.786 |
| Retention-election accountability court | state/state_federal_split | 4548 | 1.000 | 0.718 | 0.125 | 0.512 | 3.000 | 0.584 | 0.545 | 0.371 | 0.320 | 0.237 | 0.062 | 0.142 | 0.030 | 0.848 | 0.787 |
| Retention-election accountability court | state/state_high_court | 9453 | 1.000 | 0.721 | 0.123 | 0.412 | 2.000 | 0.584 | 0.505 | 0.386 | 0.317 | 0.239 | 0.061 | 0.142 | 0.030 | 0.849 | 0.787 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 4307 | 1.000 | 0.742 | 0.009 | 0.305 | 3.000 | 0.409 | 0.495 | 0.449 | 0.365 | 0.254 | 0.062 | 0.286 | 0.039 | 0.821 | 0.794 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 11144 | 1.000 | 0.742 | 0.012 | 0.414 | 2.000 | 0.432 | 0.459 | 0.440 | 0.370 | 0.231 | 0.063 | 0.276 | 0.036 | 0.824 | 0.797 |
| Hybrid court balancing independence and accountability | federal/district_only | 2580 | 1.000 | 0.742 | 0.013 | 0.460 | 1.000 | 0.441 | 0.430 | 0.430 | 0.361 | 0.232 | 0.067 | 0.271 | 0.036 | 0.825 | 0.797 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 3672 | 1.000 | 0.740 | 0.009 | 0.420 | 3.000 | 0.790 | 0.583 | 0.403 | 0.333 | 0.253 | 0.066 | 0.108 | 0.030 | 0.848 | 0.819 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 9199 | 1.000 | 0.737 | 0.011 | 0.458 | 3.000 | 0.790 | 0.600 | 0.395 | 0.330 | 0.250 | 0.071 | 0.107 | 0.033 | 0.841 | 0.808 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 3097 | 1.000 | 0.741 | 0.010 | 0.419 | 2.000 | 0.585 | 0.493 | 0.438 | 0.353 | 0.229 | 0.067 | 0.182 | 0.035 | 0.836 | 0.804 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 4548 | 1.000 | 0.738 | 0.011 | 0.516 | 3.000 | 0.584 | 0.545 | 0.430 | 0.339 | 0.261 | 0.067 | 0.164 | 0.033 | 0.838 | 0.807 |
| Hybrid court balancing independence and accountability | state/state_high_court | 9453 | 1.000 | 0.742 | 0.011 | 0.443 | 2.000 | 0.584 | 0.505 | 0.419 | 0.358 | 0.229 | 0.074 | 0.174 | 0.035 | 0.837 | 0.805 |

## Composition Diagnostics

| Scenario | Period | Observations | Size | Median ideology | Spread | Partisan attach. | Rights sens. | Institutionalism | Replacement events |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 600 | 9.000 | 0.067 | 1.462 | 0.678 | 0.706 | 0.797 | 0.000 |
| Current-style federal supreme court | 2 | 600 | 9.000 | 0.069 | 1.475 | 0.677 | 0.706 | 0.796 | 1.307 |
| Current-style federal supreme court | 3 | 600 | 9.000 | 0.072 | 1.480 | 0.678 | 0.704 | 0.798 | 1.307 |
| Current-style federal supreme court | 4 | 600 | 9.000 | 0.073 | 1.460 | 0.677 | 0.703 | 0.797 | 1.307 |
| Staggered 18-year nonrenewable terms | 1 | 600 | 9.000 | 0.039 | 1.485 | 0.659 | 0.705 | 0.782 | 0.000 |
| Staggered 18-year nonrenewable terms | 2 | 600 | 9.000 | 0.033 | 1.469 | 0.657 | 0.706 | 0.780 | 3.258 |
| Staggered 18-year nonrenewable terms | 3 | 600 | 9.000 | 0.035 | 1.475 | 0.658 | 0.707 | 0.781 | 3.258 |
| Staggered 18-year nonrenewable terms | 4 | 600 | 9.000 | 0.043 | 1.487 | 0.658 | 0.705 | 0.781 | 3.258 |
| Fifteen-justice supermajority commission court | 1 | 600 | 15.000 | -0.003 | 0.881 | 0.566 | 0.732 | 0.779 | 0.000 |
| Fifteen-justice supermajority commission court | 2 | 600 | 15.000 | 0.001 | 0.910 | 0.567 | 0.731 | 0.778 | 6.798 |
| Fifteen-justice supermajority commission court | 3 | 600 | 15.000 | -0.003 | 0.943 | 0.566 | 0.732 | 0.779 | 6.798 |
| Fifteen-justice supermajority commission court | 4 | 600 | 15.000 | -0.002 | 0.980 | 0.566 | 0.732 | 0.779 | 6.798 |
| Supermajority required to invalidate laws | 1 | 600 | 9.000 | 0.054 | 1.472 | 0.652 | 0.700 | 0.843 | 0.000 |
| Supermajority required to invalidate laws | 2 | 600 | 9.000 | 0.057 | 1.469 | 0.653 | 0.697 | 0.843 | 1.357 |
| Supermajority required to invalidate laws | 3 | 600 | 9.000 | 0.057 | 1.474 | 0.653 | 0.699 | 0.843 | 1.357 |
| Supermajority required to invalidate laws | 4 | 600 | 9.000 | 0.055 | 1.480 | 0.654 | 0.696 | 0.843 | 1.357 |
| Strict recusal with substitute justices | 1 | 600 | 12.000 | -0.001 | 0.862 | 0.567 | 0.732 | 0.768 | 0.000 |
| Strict recusal with substitute justices | 2 | 600 | 12.000 | 0.005 | 0.896 | 0.566 | 0.731 | 0.768 | 5.506 |
| Strict recusal with substitute justices | 3 | 600 | 12.000 | -0.001 | 0.921 | 0.566 | 0.731 | 0.767 | 5.506 |
| Strict recusal with substitute justices | 4 | 600 | 12.000 | 0.001 | 0.953 | 0.567 | 0.731 | 0.768 | 5.506 |
| Reasoned emergency orders with merits follow-up | 1 | 600 | 9.000 | 0.026 | 1.463 | 0.634 | 0.728 | 0.798 | 0.000 |
| Reasoned emergency orders with merits follow-up | 2 | 600 | 9.000 | 0.023 | 1.474 | 0.635 | 0.728 | 0.799 | 3.258 |
| Reasoned emergency orders with merits follow-up | 3 | 600 | 9.000 | 0.017 | 1.476 | 0.635 | 0.729 | 0.798 | 3.258 |
| Reasoned emergency orders with merits follow-up | 4 | 600 | 9.000 | 0.022 | 1.481 | 0.633 | 0.728 | 0.799 | 3.258 |
| Panel review with en banc safety valve | 1 | 600 | 15.000 | 0.002 | 0.673 | 0.537 | 0.735 | 0.749 | 0.000 |
| Panel review with en banc safety valve | 2 | 600 | 15.000 | 0.005 | 0.712 | 0.537 | 0.735 | 0.749 | 6.882 |
| Panel review with en banc safety valve | 3 | 600 | 15.000 | -0.004 | 0.747 | 0.536 | 0.734 | 0.749 | 6.882 |
| Panel review with en banc safety valve | 4 | 600 | 15.000 | -0.002 | 0.788 | 0.536 | 0.735 | 0.749 | 6.882 |
| Dual supreme courts with cross-checking invalidations | 1 | 600 | 18.000 | -0.001 | 0.900 | 0.547 | 0.747 | 0.805 | 0.000 |
| Dual supreme courts with cross-checking invalidations | 2 | 600 | 18.000 | 0.005 | 0.926 | 0.548 | 0.747 | 0.805 | 8.208 |
| Dual supreme courts with cross-checking invalidations | 3 | 600 | 18.000 | -0.002 | 0.959 | 0.548 | 0.746 | 0.805 | 8.208 |
| Dual supreme courts with cross-checking invalidations | 4 | 600 | 18.000 | -0.002 | 1.008 | 0.547 | 0.746 | 0.804 | 8.208 |
| Pre-enactment constitutional council | 1 | 600 | 12.000 | -0.001 | 0.666 | 0.512 | 0.766 | 0.793 | 0.000 |
| Pre-enactment constitutional council | 2 | 600 | 12.000 | 0.012 | 0.715 | 0.513 | 0.764 | 0.794 | 8.604 |
| Pre-enactment constitutional council | 3 | 600 | 12.000 | 0.005 | 0.767 | 0.512 | 0.765 | 0.794 | 8.604 |
| Pre-enactment constitutional council | 4 | 600 | 12.000 | 0.005 | 0.834 | 0.513 | 0.764 | 0.794 | 8.604 |
| Judicial review with delayed legislative override | 1 | 600 | 9.000 | 0.036 | 1.464 | 0.638 | 0.712 | 0.755 | 0.000 |
| Judicial review with delayed legislative override | 2 | 600 | 9.000 | 0.032 | 1.469 | 0.638 | 0.713 | 0.756 | 3.460 |
| Judicial review with delayed legislative override | 3 | 600 | 9.000 | 0.039 | 1.488 | 0.639 | 0.712 | 0.754 | 3.460 |
| Judicial review with delayed legislative override | 4 | 600 | 9.000 | 0.039 | 1.490 | 0.639 | 0.712 | 0.756 | 3.460 |
| Retention-election accountability court | 1 | 600 | 9.000 | 0.020 | 1.238 | 0.627 | 0.695 | 0.675 | 0.000 |
| Retention-election accountability court | 2 | 600 | 9.000 | 0.031 | 1.272 | 0.626 | 0.694 | 0.677 | 8.363 |
| Retention-election accountability court | 3 | 600 | 9.000 | 0.026 | 1.300 | 0.626 | 0.694 | 0.676 | 8.363 |
| Retention-election accountability court | 4 | 600 | 9.000 | 0.036 | 1.353 | 0.626 | 0.692 | 0.677 | 8.363 |
| Hybrid court balancing independence and accountability | 1 | 600 | 15.000 | -0.000 | 0.891 | 0.538 | 0.754 | 0.802 | 0.000 |
| Hybrid court balancing independence and accountability | 2 | 600 | 15.000 | -0.001 | 0.914 | 0.537 | 0.755 | 0.802 | 6.966 |
| Hybrid court balancing independence and accountability | 3 | 600 | 15.000 | -0.004 | 0.957 | 0.537 | 0.754 | 0.803 | 6.966 |
| Hybrid court balancing independence and accountability | 4 | 600 | 15.000 | -0.004 | 0.977 | 0.538 | 0.755 | 0.803 | 6.966 |

## Calibration Diagnostics

| Target | Observed | Range | Gap | Status |
| --- | ---: | ---: | ---: | --- |
| Speech docket share | 0.141 | 0.080-0.200 | 0.000 | within |
| Equality docket share | 0.144 | 0.080-0.200 | 0.000 | within |
| Criminal procedure docket share | 0.143 | 0.080-0.200 | 0.000 | within |
| Federalism docket share | 0.143 | 0.060-0.180 | 0.000 | within |
| Election law docket share | 0.146 | 0.050-0.160 | 0.000 | within |
| Emergency powers docket share | 0.142 | 0.040-0.140 | 0.002 | outside |
| Administrative state docket share | 0.142 | 0.060-0.180 | 0.000 | within |
| Emergency relief rate | 0.547 | 0.050-0.240 | 0.307 | outside |
| Compliance rate | 0.375 | 0.700-0.950 | 0.325 | outside |
| Legitimacy response to trust | 3.446 | 0.150-1.200 | 2.246 | outside |
