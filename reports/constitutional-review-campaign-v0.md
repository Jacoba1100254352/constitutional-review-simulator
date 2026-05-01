# Constitutional Review Campaign v0

- runs per case: 120
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Baseline

Moderately polarized appointment environment with ordinary constitutional-review pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.704
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.746
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.276
- highest compliance rate: Pre-enactment constitutional council at 0.561
- lowest defiance rate: Pre-enactment constitutional council at 0.177

### Polarized appointments

High appointment polarization, higher partisan pressure, and lower public trust.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.669
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.745
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.333
- highest compliance rate: Hybrid court balancing independence and accountability at 0.444
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.256

### Rights-threat surge

Docket contains more laws or actions with high generated rights-risk signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.607
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.743
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.007
- lowest emergency relief rate: Retention-election accountability court at 0.622
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.384
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.315

### Emergency docket stress

Higher urgency and executive pressure, meant to stress shadow-docket procedures.

- best overall: Reasoned emergency orders with merits follow-up (`reasoned-emergency-review`) at 0.640
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.734
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.039
- lowest emergency relief rate: Retention-election accountability court at 0.346
- highest compliance rate: Hybrid court balancing independence and accountability at 0.401
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.293

### Low-trust conflict

Lower public trust and higher legislature-court conflict.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.647
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.740
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.345
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.370
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.311

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin | Budget | Delay | Complex | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.567 | 0.743 | 0.663 | 0.229 | 0.494 | 0.754 | 0.452 | 0.529 | 0.248 | 0.394 | 0.384 | 0.282 | 0.209 | 0.305 | 0.063 | 0.104 | 2.400 | 0.581 | 0.497 | 0.190 | 0.477 | 0.353 | 0.337 |
| Staggered 18-year nonrenewable terms | 0.580 | 0.752 | 0.671 | 0.211 | 0.488 | 0.709 | 0.421 | 0.539 | 0.231 | 0.388 | 0.394 | 0.286 | 0.211 | 0.300 | 0.063 | 0.107 | 2.400 | 0.581 | 0.505 | 0.203 | 0.477 | 0.356 | 0.342 |
| Fifteen-justice supermajority commission court | 0.633 | 0.847 | 0.727 | 0.172 | 0.139 | 0.520 | 0.553 | 0.665 | 0.396 | 0.288 | 0.451 | 0.377 | 0.305 | 0.261 | 0.067 | 0.162 | 2.400 | 0.581 | 0.497 | 0.383 | 0.495 | 0.413 | 0.430 |
| Supermajority required to invalidate laws | 0.626 | 0.855 | 0.722 | 0.191 | 0.143 | 0.571 | 0.530 | 0.640 | 0.378 | 0.289 | 0.445 | 0.375 | 0.303 | 0.262 | 0.066 | 0.158 | 2.400 | 0.581 | 0.476 | 0.190 | 0.495 | 0.526 | 0.394 |
| Strict recusal with substitute justices | 0.636 | 0.848 | 0.727 | 0.172 | 0.136 | 0.515 | 0.538 | 0.684 | 0.385 | 0.286 | 0.452 | 0.381 | 0.314 | 0.255 | 0.065 | 0.166 | 2.400 | 0.581 | 0.497 | 0.380 | 0.495 | 0.513 | 0.459 |
| Reasoned emergency orders with merits follow-up | 0.639 | 0.866 | 0.735 | 0.190 | 0.012 | 0.564 | 0.529 | 0.711 | 0.529 | 0.262 | 0.456 | 0.404 | 0.333 | 0.257 | 0.072 | 0.174 | 2.400 | 0.581 | 0.483 | 0.206 | 0.499 | 0.508 | 0.396 |
| Panel review with en banc safety valve | 0.616 | 0.843 | 0.727 | 0.170 | 0.137 | 0.523 | 0.558 | 0.677 | 0.400 | 0.288 | 0.451 | 0.378 | 0.305 | 0.264 | 0.065 | 0.163 | 2.400 | 0.581 | 0.695 | 0.566 | 0.697 | 0.480 | 0.585 |
| Dual supreme courts with cross-checking invalidations | 0.627 | 0.890 | 0.741 | 0.156 | 0.016 | 0.457 | 0.407 | 0.720 | 0.407 | 0.268 | 0.466 | 0.421 | 0.350 | 0.238 | 0.064 | 0.195 | 2.400 | 0.581 | 0.880 | 0.795 | 0.821 | 0.863 | 0.824 |
| Pre-enactment constitutional council | 0.639 | 0.918 | 0.728 | 0.149 | 0.131 | 0.483 | 0.433 | 0.709 | 0.310 | 0.276 | 0.457 | 0.413 | 0.342 | 0.232 | 0.060 | 0.195 | 2.400 | 0.581 | 0.750 | 0.577 | 0.675 | 0.719 | 0.653 |
| Judicial review with delayed legislative override | 0.625 | 0.833 | 0.722 | 0.185 | 0.141 | 0.547 | 0.574 | 0.656 | 0.410 | 0.297 | 0.451 | 0.367 | 0.293 | 0.269 | 0.067 | 0.152 | 2.400 | 0.581 | 0.489 | 0.208 | 0.495 | 0.590 | 0.420 |
| Retention-election accountability court | 0.649 | 0.849 | 0.720 | 0.161 | 0.129 | 0.384 | 0.416 | 0.675 | 0.298 | 0.288 | 0.471 | 0.382 | 0.312 | 0.247 | 0.060 | 0.170 | 2.400 | 0.581 | 0.510 | 0.240 | 0.495 | 0.657 | 0.452 |
| Hybrid court balancing independence and accountability | 0.638 | 0.895 | 0.739 | 0.160 | 0.011 | 0.481 | 0.435 | 0.724 | 0.435 | 0.251 | 0.464 | 0.421 | 0.351 | 0.242 | 0.066 | 0.193 | 2.400 | 0.581 | 0.688 | 0.647 | 0.696 | 0.937 | 0.751 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 1.000 | 0.664 | 0.493 | 0.449 | 2.385 | 0.580 | 0.515 | 0.409 | 0.342 | 0.224 | 0.038 | 0.238 | 0.063 | 0.841 | 0.611 | 0.333 |
| Current-style federal supreme court | 2 | 12000 | 1.000 | 0.664 | 0.492 | 0.460 | 2.406 | 0.582 | 0.517 | 0.246 | 0.169 | 0.328 | 0.068 | 0.064 | 0.000 | 0.997 | 0.997 | 0.338 |
| Current-style federal supreme court | 3 | 12000 | 1.000 | 0.662 | 0.498 | 0.450 | 2.404 | 0.581 | 0.516 | 0.236 | 0.162 | 0.334 | 0.074 | 0.060 | 0.000 | 0.998 | 1.000 | 0.338 |
| Current-style federal supreme court | 4 | 12000 | 1.000 | 0.663 | 0.493 | 0.450 | 2.403 | 0.582 | 0.515 | 0.238 | 0.163 | 0.334 | 0.071 | 0.056 | 0.000 | 0.998 | 1.000 | 0.338 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 1.000 | 0.672 | 0.487 | 0.421 | 2.385 | 0.580 | 0.515 | 0.421 | 0.347 | 0.217 | 0.035 | 0.240 | 0.065 | 0.829 | 0.591 | 0.333 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 1.000 | 0.672 | 0.487 | 0.426 | 2.406 | 0.582 | 0.517 | 0.253 | 0.178 | 0.324 | 0.070 | 0.069 | 0.000 | 0.994 | 0.994 | 0.346 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 1.000 | 0.670 | 0.493 | 0.418 | 2.404 | 0.581 | 0.516 | 0.241 | 0.155 | 0.326 | 0.075 | 0.059 | 0.000 | 0.998 | 1.000 | 0.345 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 1.000 | 0.671 | 0.485 | 0.419 | 2.403 | 0.582 | 0.515 | 0.232 | 0.164 | 0.332 | 0.073 | 0.060 | 0.000 | 0.998 | 1.000 | 0.345 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 1.000 | 0.728 | 0.136 | 0.551 | 2.385 | 0.580 | 0.515 | 0.528 | 0.457 | 0.170 | 0.037 | 0.323 | 0.108 | 0.709 | 0.486 | 0.418 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 1.000 | 0.727 | 0.140 | 0.554 | 2.406 | 0.582 | 0.517 | 0.362 | 0.285 | 0.272 | 0.072 | 0.139 | 0.000 | 0.913 | 0.927 | 0.434 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 1.000 | 0.727 | 0.139 | 0.555 | 2.404 | 0.581 | 0.516 | 0.308 | 0.244 | 0.300 | 0.078 | 0.099 | 0.000 | 0.974 | 0.989 | 0.434 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 1.000 | 0.726 | 0.139 | 0.552 | 2.403 | 0.582 | 0.515 | 0.310 | 0.236 | 0.304 | 0.080 | 0.087 | 0.000 | 0.990 | 0.998 | 0.434 |
| Supermajority required to invalidate laws | 1 | 12000 | 1.000 | 0.723 | 0.142 | 0.527 | 2.385 | 0.580 | 0.515 | 0.525 | 0.454 | 0.168 | 0.037 | 0.319 | 0.104 | 0.715 | 0.493 | 0.390 |
| Supermajority required to invalidate laws | 2 | 12000 | 1.000 | 0.723 | 0.144 | 0.531 | 2.406 | 0.582 | 0.517 | 0.353 | 0.276 | 0.280 | 0.072 | 0.134 | 0.000 | 0.920 | 0.933 | 0.396 |
| Supermajority required to invalidate laws | 3 | 12000 | 1.000 | 0.722 | 0.145 | 0.539 | 2.404 | 0.581 | 0.516 | 0.318 | 0.245 | 0.299 | 0.076 | 0.091 | 0.000 | 0.977 | 0.993 | 0.396 |
| Supermajority required to invalidate laws | 4 | 12000 | 1.000 | 0.722 | 0.143 | 0.525 | 2.403 | 0.582 | 0.515 | 0.305 | 0.236 | 0.299 | 0.078 | 0.087 | 0.000 | 0.991 | 0.998 | 0.396 |
| Strict recusal with substitute justices | 1 | 12000 | 1.000 | 0.728 | 0.134 | 0.536 | 2.385 | 0.580 | 0.515 | 0.534 | 0.467 | 0.163 | 0.038 | 0.325 | 0.114 | 0.692 | 0.463 | 0.447 |
| Strict recusal with substitute justices | 2 | 12000 | 1.000 | 0.728 | 0.137 | 0.543 | 2.406 | 0.582 | 0.517 | 0.356 | 0.296 | 0.268 | 0.072 | 0.150 | 0.001 | 0.893 | 0.902 | 0.463 |
| Strict recusal with substitute justices | 3 | 12000 | 1.000 | 0.727 | 0.138 | 0.539 | 2.404 | 0.581 | 0.516 | 0.322 | 0.251 | 0.287 | 0.072 | 0.099 | 0.000 | 0.960 | 0.982 | 0.463 |
| Strict recusal with substitute justices | 4 | 12000 | 1.000 | 0.727 | 0.135 | 0.534 | 2.403 | 0.582 | 0.515 | 0.312 | 0.244 | 0.303 | 0.078 | 0.090 | 0.000 | 0.986 | 0.997 | 0.463 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 1.000 | 0.737 | 0.012 | 0.524 | 2.385 | 0.580 | 0.515 | 0.545 | 0.478 | 0.162 | 0.045 | 0.339 | 0.117 | 0.692 | 0.501 | 0.387 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 1.000 | 0.736 | 0.012 | 0.532 | 2.406 | 0.582 | 0.517 | 0.389 | 0.311 | 0.273 | 0.076 | 0.152 | 0.001 | 0.906 | 0.932 | 0.400 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 1.000 | 0.734 | 0.012 | 0.527 | 2.404 | 0.581 | 0.516 | 0.346 | 0.273 | 0.296 | 0.082 | 0.106 | 0.000 | 0.971 | 0.993 | 0.399 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 1.000 | 0.735 | 0.012 | 0.531 | 2.403 | 0.582 | 0.515 | 0.336 | 0.269 | 0.299 | 0.084 | 0.099 | 0.000 | 0.988 | 0.999 | 0.400 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.728 | 0.136 | 0.557 | 2.385 | 0.580 | 0.515 | 0.536 | 0.456 | 0.168 | 0.038 | 0.324 | 0.110 | 0.702 | 0.478 | 0.573 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.728 | 0.138 | 0.560 | 2.406 | 0.582 | 0.517 | 0.351 | 0.290 | 0.272 | 0.071 | 0.144 | 0.000 | 0.910 | 0.923 | 0.589 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.727 | 0.138 | 0.561 | 2.404 | 0.581 | 0.516 | 0.314 | 0.241 | 0.308 | 0.078 | 0.094 | 0.000 | 0.975 | 0.993 | 0.588 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.726 | 0.137 | 0.555 | 2.403 | 0.582 | 0.515 | 0.313 | 0.234 | 0.310 | 0.075 | 0.089 | 0.000 | 0.992 | 1.000 | 0.588 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.741 | 0.016 | 0.404 | 2.385 | 0.580 | 0.515 | 0.576 | 0.500 | 0.153 | 0.036 | 0.356 | 0.137 | 0.646 | 0.418 | 0.813 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.741 | 0.016 | 0.411 | 2.406 | 0.582 | 0.517 | 0.412 | 0.336 | 0.241 | 0.073 | 0.190 | 0.001 | 0.836 | 0.839 | 0.829 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.740 | 0.016 | 0.403 | 2.404 | 0.581 | 0.516 | 0.355 | 0.286 | 0.274 | 0.076 | 0.125 | 0.000 | 0.915 | 0.942 | 0.828 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.740 | 0.016 | 0.408 | 2.403 | 0.582 | 0.515 | 0.342 | 0.277 | 0.285 | 0.073 | 0.109 | 0.000 | 0.953 | 0.974 | 0.828 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.728 | 0.130 | 0.427 | 2.385 | 0.580 | 0.515 | 0.552 | 0.484 | 0.149 | 0.032 | 0.351 | 0.137 | 0.642 | 0.395 | 0.635 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.729 | 0.130 | 0.435 | 2.406 | 0.582 | 0.517 | 0.402 | 0.325 | 0.248 | 0.066 | 0.180 | 0.003 | 0.814 | 0.806 | 0.660 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.728 | 0.132 | 0.433 | 2.404 | 0.581 | 0.516 | 0.355 | 0.289 | 0.261 | 0.068 | 0.131 | 0.001 | 0.880 | 0.902 | 0.659 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.727 | 0.133 | 0.434 | 2.403 | 0.582 | 0.515 | 0.342 | 0.272 | 0.272 | 0.073 | 0.116 | 0.000 | 0.916 | 0.936 | 0.659 |
| Judicial review with delayed legislative override | 1 | 12000 | 1.000 | 0.723 | 0.140 | 0.572 | 2.385 | 0.580 | 0.515 | 0.514 | 0.442 | 0.179 | 0.039 | 0.305 | 0.101 | 0.724 | 0.501 | 0.410 |
| Judicial review with delayed legislative override | 2 | 12000 | 1.000 | 0.723 | 0.141 | 0.577 | 2.406 | 0.582 | 0.517 | 0.343 | 0.270 | 0.284 | 0.078 | 0.127 | 0.000 | 0.935 | 0.944 | 0.424 |
| Judicial review with delayed legislative override | 3 | 12000 | 1.000 | 0.722 | 0.142 | 0.577 | 2.404 | 0.581 | 0.516 | 0.304 | 0.233 | 0.304 | 0.077 | 0.092 | 0.000 | 0.984 | 0.995 | 0.423 |
| Judicial review with delayed legislative override | 4 | 12000 | 1.000 | 0.722 | 0.139 | 0.569 | 2.403 | 0.582 | 0.515 | 0.306 | 0.229 | 0.307 | 0.074 | 0.084 | 0.000 | 0.993 | 1.000 | 0.423 |
| Retention-election accountability court | 1 | 12000 | 1.000 | 0.720 | 0.128 | 0.414 | 2.385 | 0.580 | 0.515 | 0.525 | 0.462 | 0.160 | 0.033 | 0.319 | 0.120 | 0.663 | 0.406 | 0.428 |
| Retention-election accountability court | 2 | 12000 | 1.000 | 0.719 | 0.131 | 0.420 | 2.406 | 0.582 | 0.517 | 0.371 | 0.298 | 0.259 | 0.064 | 0.154 | 0.001 | 0.850 | 0.830 | 0.460 |
| Retention-election accountability court | 3 | 12000 | 1.000 | 0.721 | 0.130 | 0.414 | 2.404 | 0.581 | 0.516 | 0.322 | 0.251 | 0.281 | 0.071 | 0.116 | 0.000 | 0.918 | 0.932 | 0.460 |
| Retention-election accountability court | 4 | 12000 | 1.000 | 0.720 | 0.129 | 0.416 | 2.403 | 0.582 | 0.515 | 0.309 | 0.235 | 0.288 | 0.071 | 0.093 | 0.000 | 0.948 | 0.965 | 0.460 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.740 | 0.011 | 0.434 | 2.385 | 0.580 | 0.515 | 0.573 | 0.503 | 0.155 | 0.039 | 0.354 | 0.138 | 0.642 | 0.435 | 0.739 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.740 | 0.011 | 0.439 | 2.406 | 0.582 | 0.517 | 0.406 | 0.340 | 0.250 | 0.067 | 0.181 | 0.002 | 0.827 | 0.850 | 0.755 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.739 | 0.011 | 0.432 | 2.404 | 0.581 | 0.516 | 0.362 | 0.288 | 0.277 | 0.077 | 0.127 | 0.001 | 0.910 | 0.951 | 0.754 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.739 | 0.011 | 0.436 | 2.403 | 0.582 | 0.515 | 0.344 | 0.274 | 0.284 | 0.081 | 0.109 | 0.001 | 0.952 | 0.983 | 0.755 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 6866 | 1.000 | 0.709 | 0.408 | 0.113 | 2.708 | 0.488 | 0.530 | 0.318 | 0.251 | 0.368 | 0.053 | 0.147 | 0.018 | 0.955 | 0.900 | 0.353 |
| Current-style federal supreme court | criminal_procedure | 6892 | 1.000 | 0.655 | 0.482 | 0.584 | 2.330 | 0.580 | 0.507 | 0.279 | 0.203 | 0.296 | 0.075 | 0.092 | 0.016 | 0.958 | 0.900 | 0.333 |
| Current-style federal supreme court | election_law | 7019 | 1.000 | 0.627 | 0.494 | 0.644 | 2.724 | 0.681 | 0.530 | 0.259 | 0.193 | 0.302 | 0.071 | 0.070 | 0.014 | 0.963 | 0.909 | 0.347 |
| Current-style federal supreme court | emergency_powers | 6887 | 1.000 | 0.630 | 0.670 | 0.419 | 1.986 | 0.549 | 0.505 | 0.254 | 0.173 | 0.307 | 0.055 | 0.099 | 0.015 | 0.960 | 0.903 | 0.318 |
| Current-style federal supreme court | equality | 6785 | 1.000 | 0.659 | 0.507 | 0.689 | 2.284 | 0.533 | 0.481 | 0.276 | 0.204 | 0.295 | 0.066 | 0.112 | 0.015 | 0.961 | 0.903 | 0.328 |
| Current-style federal supreme court | federalism | 6759 | 1.000 | 0.705 | 0.412 | 0.141 | 2.522 | 0.768 | 0.591 | 0.300 | 0.229 | 0.275 | 0.058 | 0.082 | 0.018 | 0.954 | 0.897 | 0.351 |
| Current-style federal supreme court | speech | 6792 | 1.000 | 0.658 | 0.482 | 0.590 | 2.237 | 0.467 | 0.467 | 0.291 | 0.212 | 0.289 | 0.062 | 0.130 | 0.016 | 0.957 | 0.900 | 0.326 |
| Staggered 18-year nonrenewable terms | administrative_state | 6866 | 1.000 | 0.720 | 0.397 | 0.077 | 2.708 | 0.488 | 0.530 | 0.331 | 0.258 | 0.351 | 0.052 | 0.149 | 0.018 | 0.951 | 0.894 | 0.359 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 6892 | 1.000 | 0.662 | 0.471 | 0.555 | 2.330 | 0.580 | 0.507 | 0.274 | 0.208 | 0.289 | 0.072 | 0.100 | 0.016 | 0.955 | 0.895 | 0.339 |
| Staggered 18-year nonrenewable terms | election_law | 7019 | 1.000 | 0.634 | 0.494 | 0.611 | 2.724 | 0.681 | 0.530 | 0.268 | 0.187 | 0.301 | 0.069 | 0.073 | 0.014 | 0.960 | 0.904 | 0.352 |
| Staggered 18-year nonrenewable terms | emergency_powers | 6887 | 1.000 | 0.643 | 0.660 | 0.363 | 1.986 | 0.549 | 0.505 | 0.255 | 0.182 | 0.301 | 0.066 | 0.107 | 0.015 | 0.956 | 0.896 | 0.323 |
| Staggered 18-year nonrenewable terms | equality | 6785 | 1.000 | 0.663 | 0.501 | 0.668 | 2.284 | 0.533 | 0.481 | 0.273 | 0.199 | 0.297 | 0.066 | 0.108 | 0.015 | 0.957 | 0.897 | 0.333 |
| Staggered 18-year nonrenewable terms | federalism | 6759 | 1.000 | 0.717 | 0.404 | 0.116 | 2.522 | 0.768 | 0.591 | 0.319 | 0.227 | 0.275 | 0.054 | 0.082 | 0.019 | 0.950 | 0.891 | 0.357 |
| Staggered 18-year nonrenewable terms | speech | 6792 | 1.000 | 0.661 | 0.485 | 0.565 | 2.237 | 0.467 | 0.467 | 0.286 | 0.218 | 0.282 | 0.064 | 0.131 | 0.016 | 0.955 | 0.895 | 0.332 |
| Fifteen-justice supermajority commission court | administrative_state | 6866 | 1.000 | 0.746 | 0.117 | 0.101 | 2.708 | 0.488 | 0.530 | 0.410 | 0.336 | 0.296 | 0.049 | 0.207 | 0.031 | 0.890 | 0.846 | 0.447 |
| Fifteen-justice supermajority commission court | criminal_procedure | 6892 | 1.000 | 0.714 | 0.146 | 0.702 | 2.330 | 0.580 | 0.507 | 0.366 | 0.304 | 0.249 | 0.070 | 0.148 | 0.027 | 0.897 | 0.850 | 0.427 |
| Fifteen-justice supermajority commission court | election_law | 7019 | 1.000 | 0.707 | 0.125 | 0.765 | 2.724 | 0.681 | 0.530 | 0.355 | 0.284 | 0.262 | 0.080 | 0.125 | 0.023 | 0.906 | 0.861 | 0.440 |
| Fifteen-justice supermajority commission court | emergency_powers | 6887 | 1.000 | 0.716 | 0.197 | 0.447 | 1.986 | 0.549 | 0.505 | 0.366 | 0.295 | 0.265 | 0.066 | 0.173 | 0.027 | 0.896 | 0.849 | 0.411 |
| Fifteen-justice supermajority commission court | equality | 6785 | 1.000 | 0.727 | 0.138 | 0.844 | 2.284 | 0.533 | 0.481 | 0.366 | 0.292 | 0.274 | 0.080 | 0.162 | 0.025 | 0.902 | 0.853 | 0.421 |
| Fifteen-justice supermajority commission court | federalism | 6759 | 1.000 | 0.758 | 0.116 | 0.132 | 2.522 | 0.768 | 0.591 | 0.394 | 0.328 | 0.223 | 0.047 | 0.128 | 0.031 | 0.885 | 0.840 | 0.444 |
| Fifteen-justice supermajority commission court | speech | 6792 | 1.000 | 0.722 | 0.131 | 0.722 | 2.237 | 0.467 | 0.467 | 0.381 | 0.299 | 0.259 | 0.073 | 0.192 | 0.027 | 0.899 | 0.851 | 0.420 |
| Supermajority required to invalidate laws | administrative_state | 6866 | 1.000 | 0.743 | 0.117 | 0.110 | 2.708 | 0.488 | 0.530 | 0.412 | 0.338 | 0.303 | 0.051 | 0.207 | 0.030 | 0.896 | 0.852 | 0.412 |
| Supermajority required to invalidate laws | criminal_procedure | 6892 | 1.000 | 0.709 | 0.154 | 0.672 | 2.330 | 0.580 | 0.507 | 0.367 | 0.296 | 0.252 | 0.069 | 0.143 | 0.026 | 0.901 | 0.853 | 0.391 |
| Supermajority required to invalidate laws | election_law | 7019 | 1.000 | 0.702 | 0.130 | 0.745 | 2.724 | 0.681 | 0.530 | 0.355 | 0.282 | 0.264 | 0.076 | 0.119 | 0.022 | 0.910 | 0.864 | 0.405 |
| Supermajority required to invalidate laws | emergency_powers | 6887 | 1.000 | 0.707 | 0.208 | 0.428 | 1.986 | 0.549 | 0.505 | 0.357 | 0.289 | 0.264 | 0.066 | 0.159 | 0.026 | 0.901 | 0.854 | 0.375 |
| Supermajority required to invalidate laws | equality | 6785 | 1.000 | 0.727 | 0.137 | 0.811 | 2.284 | 0.533 | 0.481 | 0.376 | 0.290 | 0.263 | 0.076 | 0.161 | 0.024 | 0.904 | 0.856 | 0.386 |
| Supermajority required to invalidate laws | federalism | 6759 | 1.000 | 0.752 | 0.122 | 0.141 | 2.522 | 0.768 | 0.591 | 0.374 | 0.318 | 0.230 | 0.053 | 0.123 | 0.029 | 0.892 | 0.846 | 0.409 |
| Supermajority required to invalidate laws | speech | 6792 | 1.000 | 0.718 | 0.135 | 0.677 | 2.237 | 0.467 | 0.467 | 0.384 | 0.307 | 0.254 | 0.068 | 0.192 | 0.026 | 0.903 | 0.855 | 0.384 |
| Strict recusal with substitute justices | administrative_state | 6866 | 1.000 | 0.746 | 0.115 | 0.077 | 2.708 | 0.488 | 0.530 | 0.404 | 0.346 | 0.296 | 0.047 | 0.208 | 0.032 | 0.877 | 0.834 | 0.476 |
| Strict recusal with substitute justices | criminal_procedure | 6892 | 1.000 | 0.714 | 0.147 | 0.689 | 2.330 | 0.580 | 0.507 | 0.382 | 0.304 | 0.248 | 0.065 | 0.155 | 0.029 | 0.883 | 0.836 | 0.455 |
| Strict recusal with substitute justices | election_law | 7019 | 1.000 | 0.709 | 0.122 | 0.745 | 2.724 | 0.681 | 0.530 | 0.362 | 0.296 | 0.249 | 0.084 | 0.126 | 0.024 | 0.891 | 0.845 | 0.469 |
| Strict recusal with substitute justices | emergency_powers | 6887 | 1.000 | 0.716 | 0.195 | 0.424 | 1.986 | 0.549 | 0.505 | 0.386 | 0.304 | 0.253 | 0.061 | 0.176 | 0.029 | 0.882 | 0.835 | 0.439 |
| Strict recusal with substitute justices | equality | 6785 | 1.000 | 0.728 | 0.134 | 0.833 | 2.284 | 0.533 | 0.481 | 0.374 | 0.307 | 0.265 | 0.074 | 0.172 | 0.026 | 0.890 | 0.840 | 0.450 |
| Strict recusal with substitute justices | federalism | 6759 | 1.000 | 0.758 | 0.114 | 0.112 | 2.522 | 0.768 | 0.591 | 0.380 | 0.330 | 0.230 | 0.051 | 0.124 | 0.032 | 0.872 | 0.826 | 0.473 |
| Strict recusal with substitute justices | speech | 6792 | 1.000 | 0.723 | 0.125 | 0.709 | 2.237 | 0.467 | 0.467 | 0.382 | 0.316 | 0.248 | 0.072 | 0.201 | 0.029 | 0.885 | 0.836 | 0.449 |
| Reasoned emergency orders with merits follow-up | administrative_state | 6866 | 1.000 | 0.748 | 0.002 | 0.100 | 2.708 | 0.488 | 0.530 | 0.430 | 0.365 | 0.291 | 0.052 | 0.215 | 0.034 | 0.881 | 0.853 | 0.413 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 6892 | 1.000 | 0.732 | 0.009 | 0.688 | 2.330 | 0.580 | 0.507 | 0.411 | 0.324 | 0.244 | 0.074 | 0.162 | 0.029 | 0.890 | 0.855 | 0.393 |
| Reasoned emergency orders with merits follow-up | election_law | 7019 | 1.000 | 0.714 | 0.015 | 0.768 | 2.724 | 0.681 | 0.530 | 0.382 | 0.313 | 0.266 | 0.086 | 0.133 | 0.025 | 0.900 | 0.866 | 0.407 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 6887 | 1.000 | 0.721 | 0.029 | 0.461 | 1.986 | 0.549 | 0.505 | 0.392 | 0.331 | 0.259 | 0.072 | 0.189 | 0.030 | 0.888 | 0.855 | 0.377 |
| Reasoned emergency orders with merits follow-up | equality | 6785 | 1.000 | 0.744 | 0.015 | 0.835 | 2.284 | 0.533 | 0.481 | 0.399 | 0.328 | 0.258 | 0.084 | 0.179 | 0.027 | 0.897 | 0.859 | 0.388 |
| Reasoned emergency orders with merits follow-up | federalism | 6759 | 1.000 | 0.756 | 0.003 | 0.132 | 2.522 | 0.768 | 0.591 | 0.406 | 0.336 | 0.224 | 0.057 | 0.135 | 0.033 | 0.877 | 0.848 | 0.411 |
| Reasoned emergency orders with merits follow-up | speech | 6792 | 1.000 | 0.733 | 0.012 | 0.711 | 2.237 | 0.467 | 0.467 | 0.408 | 0.335 | 0.260 | 0.075 | 0.205 | 0.029 | 0.893 | 0.858 | 0.386 |
| Panel review with en banc safety valve | administrative_state | 6866 | 1.000 | 0.747 | 0.116 | 0.083 | 2.708 | 0.488 | 0.530 | 0.400 | 0.331 | 0.307 | 0.045 | 0.203 | 0.032 | 0.888 | 0.846 | 0.603 |
| Panel review with en banc safety valve | criminal_procedure | 6892 | 1.000 | 0.714 | 0.151 | 0.719 | 2.330 | 0.580 | 0.507 | 0.380 | 0.301 | 0.259 | 0.072 | 0.148 | 0.028 | 0.894 | 0.847 | 0.567 |
| Panel review with en banc safety valve | election_law | 7019 | 1.000 | 0.708 | 0.122 | 0.762 | 2.724 | 0.681 | 0.530 | 0.366 | 0.285 | 0.261 | 0.074 | 0.123 | 0.023 | 0.904 | 0.858 | 0.614 |
| Panel review with en banc safety valve | emergency_powers | 6887 | 1.000 | 0.716 | 0.196 | 0.441 | 1.986 | 0.549 | 0.505 | 0.370 | 0.301 | 0.261 | 0.063 | 0.176 | 0.027 | 0.894 | 0.848 | 0.577 |
| Panel review with en banc safety valve | equality | 6785 | 1.000 | 0.727 | 0.136 | 0.853 | 2.284 | 0.533 | 0.481 | 0.371 | 0.304 | 0.268 | 0.077 | 0.172 | 0.025 | 0.901 | 0.851 | 0.567 |
| Panel review with en banc safety valve | federalism | 6759 | 1.000 | 0.758 | 0.113 | 0.129 | 2.522 | 0.768 | 0.591 | 0.377 | 0.313 | 0.237 | 0.054 | 0.127 | 0.031 | 0.885 | 0.839 | 0.611 |
| Panel review with en banc safety valve | speech | 6792 | 1.000 | 0.721 | 0.128 | 0.748 | 2.237 | 0.467 | 0.467 | 0.386 | 0.301 | 0.257 | 0.072 | 0.190 | 0.028 | 0.898 | 0.850 | 0.553 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 6866 | 1.000 | 0.746 | 0.005 | 0.021 | 2.708 | 0.488 | 0.530 | 0.446 | 0.361 | 0.284 | 0.046 | 0.234 | 0.039 | 0.832 | 0.794 | 0.841 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 6892 | 1.000 | 0.737 | 0.014 | 0.562 | 2.330 | 0.580 | 0.507 | 0.415 | 0.351 | 0.228 | 0.068 | 0.189 | 0.034 | 0.837 | 0.791 | 0.821 |
| Dual supreme courts with cross-checking invalidations | election_law | 7019 | 1.000 | 0.728 | 0.018 | 0.626 | 2.724 | 0.681 | 0.530 | 0.397 | 0.338 | 0.234 | 0.072 | 0.157 | 0.030 | 0.846 | 0.800 | 0.835 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 6887 | 1.000 | 0.724 | 0.035 | 0.269 | 1.986 | 0.549 | 0.505 | 0.415 | 0.344 | 0.237 | 0.065 | 0.201 | 0.035 | 0.836 | 0.793 | 0.805 |
| Dual supreme courts with cross-checking invalidations | equality | 6785 | 1.000 | 0.751 | 0.020 | 0.748 | 2.284 | 0.533 | 0.481 | 0.414 | 0.343 | 0.245 | 0.078 | 0.198 | 0.031 | 0.847 | 0.798 | 0.816 |
| Dual supreme courts with cross-checking invalidations | federalism | 6759 | 1.000 | 0.760 | 0.005 | 0.028 | 2.522 | 0.768 | 0.591 | 0.437 | 0.368 | 0.205 | 0.049 | 0.161 | 0.039 | 0.822 | 0.779 | 0.839 |
| Dual supreme courts with cross-checking invalidations | speech | 6792 | 1.000 | 0.739 | 0.016 | 0.587 | 2.237 | 0.467 | 0.467 | 0.425 | 0.343 | 0.236 | 0.072 | 0.226 | 0.035 | 0.842 | 0.797 | 0.814 |
| Pre-enactment constitutional council | administrative_state | 6866 | 1.000 | 0.744 | 0.109 | 0.025 | 2.708 | 0.488 | 0.530 | 0.445 | 0.368 | 0.280 | 0.045 | 0.238 | 0.039 | 0.811 | 0.763 | 0.670 |
| Pre-enactment constitutional council | criminal_procedure | 6892 | 1.000 | 0.716 | 0.140 | 0.575 | 2.330 | 0.580 | 0.507 | 0.406 | 0.333 | 0.232 | 0.060 | 0.186 | 0.035 | 0.811 | 0.756 | 0.650 |
| Pre-enactment constitutional council | election_law | 7019 | 1.000 | 0.715 | 0.118 | 0.606 | 2.724 | 0.681 | 0.530 | 0.394 | 0.328 | 0.230 | 0.073 | 0.157 | 0.030 | 0.820 | 0.766 | 0.663 |
| Pre-enactment constitutional council | emergency_powers | 6887 | 1.000 | 0.713 | 0.186 | 0.257 | 1.986 | 0.549 | 0.505 | 0.400 | 0.328 | 0.227 | 0.056 | 0.201 | 0.035 | 0.814 | 0.761 | 0.634 |
| Pre-enactment constitutional council | equality | 6785 | 1.000 | 0.731 | 0.133 | 0.752 | 2.284 | 0.533 | 0.481 | 0.403 | 0.343 | 0.236 | 0.073 | 0.201 | 0.032 | 0.820 | 0.763 | 0.644 |
| Pre-enactment constitutional council | federalism | 6759 | 1.000 | 0.758 | 0.108 | 0.031 | 2.522 | 0.768 | 0.591 | 0.423 | 0.354 | 0.202 | 0.046 | 0.157 | 0.040 | 0.798 | 0.745 | 0.668 |
| Pre-enactment constitutional council | speech | 6792 | 1.000 | 0.722 | 0.124 | 0.610 | 2.237 | 0.467 | 0.467 | 0.417 | 0.343 | 0.221 | 0.065 | 0.224 | 0.035 | 0.818 | 0.764 | 0.643 |
| Judicial review with delayed legislative override | administrative_state | 6866 | 1.000 | 0.744 | 0.119 | 0.137 | 2.708 | 0.488 | 0.530 | 0.395 | 0.327 | 0.307 | 0.053 | 0.199 | 0.029 | 0.902 | 0.856 | 0.437 |
| Judicial review with delayed legislative override | criminal_procedure | 6892 | 1.000 | 0.709 | 0.149 | 0.723 | 2.330 | 0.580 | 0.507 | 0.351 | 0.283 | 0.260 | 0.073 | 0.143 | 0.025 | 0.908 | 0.858 | 0.417 |
| Judicial review with delayed legislative override | election_law | 7019 | 1.000 | 0.701 | 0.125 | 0.771 | 2.724 | 0.681 | 0.530 | 0.341 | 0.276 | 0.269 | 0.074 | 0.110 | 0.022 | 0.918 | 0.870 | 0.430 |
| Judicial review with delayed legislative override | emergency_powers | 6887 | 1.000 | 0.710 | 0.202 | 0.481 | 1.986 | 0.549 | 0.505 | 0.359 | 0.284 | 0.263 | 0.062 | 0.162 | 0.025 | 0.909 | 0.859 | 0.401 |
| Judicial review with delayed legislative override | equality | 6785 | 1.000 | 0.723 | 0.138 | 0.850 | 2.284 | 0.533 | 0.481 | 0.370 | 0.287 | 0.275 | 0.078 | 0.157 | 0.023 | 0.915 | 0.864 | 0.411 |
| Judicial review with delayed legislative override | federalism | 6759 | 1.000 | 0.754 | 0.118 | 0.182 | 2.522 | 0.768 | 0.591 | 0.378 | 0.305 | 0.245 | 0.056 | 0.115 | 0.029 | 0.899 | 0.851 | 0.435 |
| Judicial review with delayed legislative override | speech | 6792 | 1.000 | 0.717 | 0.133 | 0.743 | 2.237 | 0.467 | 0.467 | 0.374 | 0.291 | 0.260 | 0.072 | 0.178 | 0.025 | 0.911 | 0.861 | 0.410 |
| Retention-election accountability court | administrative_state | 6866 | 1.000 | 0.745 | 0.114 | 0.030 | 2.708 | 0.488 | 0.530 | 0.416 | 0.352 | 0.295 | 0.047 | 0.214 | 0.034 | 0.841 | 0.783 | 0.469 |
| Retention-election accountability court | criminal_procedure | 6892 | 1.000 | 0.703 | 0.137 | 0.549 | 2.330 | 0.580 | 0.507 | 0.380 | 0.303 | 0.243 | 0.060 | 0.166 | 0.030 | 0.842 | 0.779 | 0.449 |
| Retention-election accountability court | election_law | 7019 | 1.000 | 0.703 | 0.112 | 0.575 | 2.724 | 0.681 | 0.530 | 0.363 | 0.289 | 0.238 | 0.075 | 0.130 | 0.026 | 0.851 | 0.790 | 0.462 |
| Retention-election accountability court | emergency_powers | 6887 | 1.000 | 0.712 | 0.181 | 0.243 | 1.986 | 0.549 | 0.505 | 0.381 | 0.309 | 0.242 | 0.054 | 0.183 | 0.032 | 0.843 | 0.782 | 0.432 |
| Retention-election accountability court | equality | 6785 | 1.000 | 0.714 | 0.128 | 0.729 | 2.284 | 0.533 | 0.481 | 0.361 | 0.297 | 0.260 | 0.070 | 0.174 | 0.027 | 0.853 | 0.790 | 0.443 |
| Retention-election accountability court | federalism | 6759 | 1.000 | 0.758 | 0.112 | 0.059 | 2.522 | 0.768 | 0.591 | 0.386 | 0.326 | 0.215 | 0.053 | 0.134 | 0.034 | 0.834 | 0.771 | 0.466 |
| Retention-election accountability court | speech | 6792 | 1.000 | 0.705 | 0.121 | 0.577 | 2.237 | 0.467 | 0.467 | 0.387 | 0.305 | 0.237 | 0.060 | 0.193 | 0.030 | 0.847 | 0.786 | 0.442 |
| Hybrid court balancing independence and accountability | administrative_state | 6866 | 1.000 | 0.746 | 0.001 | 0.029 | 2.708 | 0.488 | 0.530 | 0.440 | 0.370 | 0.278 | 0.048 | 0.238 | 0.040 | 0.826 | 0.803 | 0.771 |
| Hybrid court balancing independence and accountability | criminal_procedure | 6892 | 1.000 | 0.736 | 0.009 | 0.606 | 2.330 | 0.580 | 0.507 | 0.413 | 0.357 | 0.234 | 0.074 | 0.190 | 0.035 | 0.834 | 0.804 | 0.731 |
| Hybrid court balancing independence and accountability | election_law | 7019 | 1.000 | 0.725 | 0.014 | 0.649 | 2.724 | 0.681 | 0.530 | 0.401 | 0.330 | 0.243 | 0.076 | 0.145 | 0.030 | 0.843 | 0.815 | 0.782 |
| Hybrid court balancing independence and accountability | emergency_powers | 6887 | 1.000 | 0.722 | 0.024 | 0.297 | 1.986 | 0.549 | 0.505 | 0.420 | 0.343 | 0.238 | 0.059 | 0.202 | 0.036 | 0.830 | 0.805 | 0.745 |
| Hybrid court balancing independence and accountability | equality | 6785 | 1.000 | 0.749 | 0.014 | 0.784 | 2.284 | 0.533 | 0.481 | 0.417 | 0.349 | 0.246 | 0.075 | 0.204 | 0.032 | 0.842 | 0.808 | 0.732 |
| Hybrid court balancing independence and accountability | federalism | 6759 | 1.000 | 0.760 | 0.002 | 0.039 | 2.522 | 0.768 | 0.591 | 0.430 | 0.356 | 0.211 | 0.050 | 0.155 | 0.040 | 0.817 | 0.792 | 0.779 |
| Hybrid court balancing independence and accountability | speech | 6792 | 1.000 | 0.738 | 0.011 | 0.639 | 2.237 | 0.467 | 0.467 | 0.429 | 0.353 | 0.240 | 0.077 | 0.217 | 0.036 | 0.835 | 0.806 | 0.716 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 4368 | 1.000 | 0.683 | 0.468 | 0.312 | 3.000 | 0.407 | 0.496 | 0.305 | 0.236 | 0.317 | 0.058 | 0.174 | 0.017 | 0.958 | 0.904 | 0.355 |
| Current-style federal supreme court | federal/circuit_panel | 10391 | 1.000 | 0.675 | 0.493 | 0.432 | 2.000 | 0.431 | 0.456 | 0.295 | 0.219 | 0.297 | 0.063 | 0.173 | 0.017 | 0.955 | 0.898 | 0.320 |
| Current-style federal supreme court | federal/district_only | 2862 | 1.000 | 0.673 | 0.551 | 0.417 | 1.000 | 0.436 | 0.433 | 0.296 | 0.209 | 0.281 | 0.060 | 0.168 | 0.018 | 0.954 | 0.892 | 0.282 |
| Current-style federal supreme court | federal/state_federal_split | 549 | 1.000 | 0.621 | 0.508 | 0.647 | 3.000 | 0.518 | 0.508 | 0.270 | 0.188 | 0.328 | 0.078 | 0.133 | 0.011 | 0.967 | 0.921 | 0.354 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.659 | 0.488 | 0.404 | 3.000 | 0.776 | 0.581 | 0.269 | 0.192 | 0.335 | 0.063 | 0.046 | 0.013 | 0.961 | 0.907 | 0.357 |
| Current-style federal supreme court | mixed_state_federal/district_only | 591 | 1.000 | 0.621 | 0.704 | 0.449 | 1.000 | 0.757 | 0.517 | 0.227 | 0.159 | 0.306 | 0.051 | 0.042 | 0.014 | 0.963 | 0.902 | 0.284 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.644 | 0.487 | 0.528 | 3.000 | 0.800 | 0.600 | 0.254 | 0.194 | 0.312 | 0.067 | 0.045 | 0.015 | 0.961 | 0.902 | 0.361 |
| Current-style federal supreme court | state/circuit_en_banc | 410 | 1.000 | 0.713 | 0.393 | 0.080 | 3.000 | 0.492 | 0.538 | 0.344 | 0.263 | 0.344 | 0.061 | 0.122 | 0.013 | 0.960 | 0.909 | 0.364 |
| Current-style federal supreme court | state/circuit_panel | 2938 | 1.000 | 0.672 | 0.483 | 0.448 | 2.000 | 0.587 | 0.495 | 0.294 | 0.220 | 0.292 | 0.059 | 0.077 | 0.015 | 0.959 | 0.902 | 0.322 |
| Current-style federal supreme court | state/district_only | 621 | 1.000 | 0.646 | 0.676 | 0.314 | 1.000 | 0.554 | 0.474 | 0.248 | 0.190 | 0.306 | 0.058 | 0.050 | 0.017 | 0.963 | 0.909 | 0.282 |
| Current-style federal supreme court | state/state_federal_split | 5577 | 1.000 | 0.644 | 0.487 | 0.562 | 3.000 | 0.595 | 0.542 | 0.276 | 0.196 | 0.303 | 0.067 | 0.075 | 0.015 | 0.960 | 0.905 | 0.358 |
| Current-style federal supreme court | state/state_high_court | 7342 | 1.000 | 0.670 | 0.482 | 0.452 | 2.000 | 0.583 | 0.505 | 0.290 | 0.216 | 0.294 | 0.060 | 0.080 | 0.016 | 0.958 | 0.901 | 0.326 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 4368 | 1.000 | 0.691 | 0.462 | 0.280 | 3.000 | 0.407 | 0.496 | 0.307 | 0.242 | 0.314 | 0.055 | 0.181 | 0.018 | 0.953 | 0.897 | 0.361 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 10391 | 1.000 | 0.680 | 0.491 | 0.403 | 2.000 | 0.431 | 0.456 | 0.296 | 0.224 | 0.293 | 0.058 | 0.172 | 0.018 | 0.951 | 0.892 | 0.325 |
| Staggered 18-year nonrenewable terms | federal/district_only | 2862 | 1.000 | 0.680 | 0.543 | 0.390 | 1.000 | 0.436 | 0.433 | 0.297 | 0.223 | 0.296 | 0.063 | 0.179 | 0.019 | 0.949 | 0.885 | 0.288 |
| Staggered 18-year nonrenewable terms | federal/state_federal_split | 549 | 1.000 | 0.634 | 0.496 | 0.623 | 3.000 | 0.518 | 0.508 | 0.259 | 0.202 | 0.299 | 0.073 | 0.118 | 0.011 | 0.964 | 0.915 | 0.360 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.669 | 0.482 | 0.368 | 3.000 | 0.776 | 0.581 | 0.278 | 0.200 | 0.314 | 0.060 | 0.052 | 0.014 | 0.958 | 0.901 | 0.363 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/district_only | 591 | 1.000 | 0.635 | 0.682 | 0.363 | 1.000 | 0.757 | 0.517 | 0.257 | 0.176 | 0.316 | 0.066 | 0.037 | 0.015 | 0.959 | 0.896 | 0.289 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.655 | 0.478 | 0.494 | 3.000 | 0.800 | 0.600 | 0.266 | 0.189 | 0.305 | 0.071 | 0.045 | 0.016 | 0.957 | 0.897 | 0.367 |
| Staggered 18-year nonrenewable terms | state/circuit_en_banc | 410 | 1.000 | 0.721 | 0.385 | 0.049 | 3.000 | 0.492 | 0.538 | 0.320 | 0.227 | 0.380 | 0.054 | 0.141 | 0.012 | 0.956 | 0.900 | 0.369 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 2938 | 1.000 | 0.681 | 0.474 | 0.413 | 2.000 | 0.587 | 0.495 | 0.294 | 0.207 | 0.286 | 0.070 | 0.088 | 0.015 | 0.957 | 0.897 | 0.327 |
| Staggered 18-year nonrenewable terms | state/district_only | 621 | 1.000 | 0.655 | 0.670 | 0.263 | 1.000 | 0.554 | 0.474 | 0.250 | 0.182 | 0.308 | 0.068 | 0.095 | 0.017 | 0.957 | 0.900 | 0.288 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 5577 | 1.000 | 0.653 | 0.481 | 0.530 | 3.000 | 0.595 | 0.542 | 0.279 | 0.202 | 0.304 | 0.063 | 0.069 | 0.016 | 0.956 | 0.901 | 0.364 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 7342 | 1.000 | 0.678 | 0.476 | 0.427 | 2.000 | 0.583 | 0.505 | 0.293 | 0.216 | 0.283 | 0.065 | 0.083 | 0.016 | 0.954 | 0.896 | 0.332 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 4368 | 1.000 | 0.734 | 0.134 | 0.405 | 3.000 | 0.407 | 0.496 | 0.407 | 0.328 | 0.276 | 0.058 | 0.247 | 0.029 | 0.893 | 0.849 | 0.449 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 10391 | 1.000 | 0.733 | 0.136 | 0.542 | 2.000 | 0.431 | 0.456 | 0.394 | 0.317 | 0.251 | 0.066 | 0.245 | 0.029 | 0.890 | 0.844 | 0.413 |
| Fifteen-justice supermajority commission court | federal/district_only | 2862 | 1.000 | 0.731 | 0.158 | 0.486 | 1.000 | 0.436 | 0.433 | 0.383 | 0.314 | 0.251 | 0.071 | 0.240 | 0.031 | 0.889 | 0.838 | 0.375 |
| Fifteen-justice supermajority commission court | federal/state_federal_split | 549 | 1.000 | 0.709 | 0.119 | 0.777 | 3.000 | 0.518 | 0.508 | 0.364 | 0.264 | 0.264 | 0.071 | 0.195 | 0.019 | 0.905 | 0.867 | 0.448 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.727 | 0.137 | 0.510 | 3.000 | 0.776 | 0.581 | 0.355 | 0.287 | 0.269 | 0.065 | 0.094 | 0.025 | 0.902 | 0.857 | 0.451 |
| Fifteen-justice supermajority commission court | mixed_state_federal/district_only | 591 | 1.000 | 0.715 | 0.197 | 0.442 | 1.000 | 0.757 | 0.517 | 0.382 | 0.286 | 0.264 | 0.076 | 0.107 | 0.023 | 0.892 | 0.841 | 0.377 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.718 | 0.140 | 0.638 | 3.000 | 0.800 | 0.600 | 0.358 | 0.289 | 0.269 | 0.073 | 0.087 | 0.025 | 0.903 | 0.853 | 0.455 |
| Fifteen-justice supermajority commission court | state/circuit_en_banc | 410 | 1.000 | 0.750 | 0.113 | 0.038 | 3.000 | 0.492 | 0.538 | 0.398 | 0.378 | 0.298 | 0.041 | 0.176 | 0.026 | 0.893 | 0.849 | 0.457 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 2938 | 1.000 | 0.732 | 0.133 | 0.533 | 2.000 | 0.587 | 0.495 | 0.375 | 0.305 | 0.250 | 0.062 | 0.135 | 0.026 | 0.899 | 0.850 | 0.415 |
| Fifteen-justice supermajority commission court | state/district_only | 621 | 1.000 | 0.721 | 0.200 | 0.354 | 1.000 | 0.554 | 0.474 | 0.351 | 0.317 | 0.266 | 0.068 | 0.132 | 0.027 | 0.896 | 0.853 | 0.376 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 5577 | 1.000 | 0.716 | 0.135 | 0.670 | 3.000 | 0.595 | 0.542 | 0.363 | 0.297 | 0.273 | 0.074 | 0.120 | 0.026 | 0.903 | 0.859 | 0.452 |
| Fifteen-justice supermajority commission court | state/state_high_court | 7342 | 1.000 | 0.730 | 0.135 | 0.574 | 2.000 | 0.583 | 0.505 | 0.378 | 0.307 | 0.250 | 0.061 | 0.133 | 0.027 | 0.895 | 0.848 | 0.420 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 4368 | 1.000 | 0.730 | 0.137 | 0.384 | 3.000 | 0.407 | 0.496 | 0.401 | 0.316 | 0.266 | 0.064 | 0.247 | 0.028 | 0.897 | 0.855 | 0.413 |
| Supermajority required to invalidate laws | federal/circuit_panel | 10391 | 1.000 | 0.728 | 0.142 | 0.506 | 2.000 | 0.431 | 0.456 | 0.394 | 0.316 | 0.249 | 0.059 | 0.231 | 0.028 | 0.894 | 0.848 | 0.378 |
| Supermajority required to invalidate laws | federal/district_only | 2862 | 1.000 | 0.727 | 0.160 | 0.462 | 1.000 | 0.436 | 0.433 | 0.387 | 0.329 | 0.246 | 0.062 | 0.244 | 0.031 | 0.892 | 0.840 | 0.340 |
| Supermajority required to invalidate laws | federal/state_federal_split | 549 | 1.000 | 0.703 | 0.137 | 0.747 | 3.000 | 0.518 | 0.508 | 0.373 | 0.315 | 0.242 | 0.071 | 0.199 | 0.019 | 0.914 | 0.878 | 0.412 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.722 | 0.142 | 0.483 | 3.000 | 0.776 | 0.581 | 0.354 | 0.287 | 0.281 | 0.068 | 0.090 | 0.023 | 0.907 | 0.862 | 0.415 |
| Supermajority required to invalidate laws | mixed_state_federal/district_only | 591 | 1.000 | 0.702 | 0.207 | 0.429 | 1.000 | 0.757 | 0.517 | 0.340 | 0.291 | 0.281 | 0.081 | 0.080 | 0.021 | 0.897 | 0.847 | 0.341 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.715 | 0.142 | 0.624 | 3.000 | 0.800 | 0.600 | 0.341 | 0.279 | 0.270 | 0.074 | 0.078 | 0.025 | 0.908 | 0.858 | 0.419 |
| Supermajority required to invalidate laws | state/circuit_en_banc | 410 | 1.000 | 0.748 | 0.116 | 0.035 | 3.000 | 0.492 | 0.538 | 0.441 | 0.329 | 0.317 | 0.049 | 0.176 | 0.027 | 0.897 | 0.851 | 0.421 |
| Supermajority required to invalidate laws | state/circuit_panel | 2938 | 1.000 | 0.728 | 0.139 | 0.518 | 2.000 | 0.587 | 0.495 | 0.373 | 0.307 | 0.259 | 0.067 | 0.126 | 0.026 | 0.904 | 0.855 | 0.380 |
| Supermajority required to invalidate laws | state/district_only | 621 | 1.000 | 0.707 | 0.209 | 0.354 | 1.000 | 0.554 | 0.474 | 0.346 | 0.272 | 0.274 | 0.081 | 0.134 | 0.025 | 0.904 | 0.861 | 0.340 |
| Supermajority required to invalidate laws | state/state_federal_split | 5577 | 1.000 | 0.710 | 0.141 | 0.657 | 3.000 | 0.595 | 0.542 | 0.372 | 0.293 | 0.263 | 0.067 | 0.125 | 0.025 | 0.906 | 0.861 | 0.416 |
| Supermajority required to invalidate laws | state/state_high_court | 7342 | 1.000 | 0.726 | 0.140 | 0.548 | 2.000 | 0.583 | 0.505 | 0.383 | 0.307 | 0.258 | 0.063 | 0.136 | 0.026 | 0.899 | 0.852 | 0.384 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 4368 | 1.000 | 0.734 | 0.132 | 0.397 | 3.000 | 0.407 | 0.496 | 0.404 | 0.337 | 0.270 | 0.052 | 0.253 | 0.031 | 0.878 | 0.834 | 0.478 |
| Strict recusal with substitute justices | federal/circuit_panel | 10391 | 1.000 | 0.733 | 0.133 | 0.532 | 2.000 | 0.431 | 0.456 | 0.398 | 0.327 | 0.247 | 0.061 | 0.245 | 0.031 | 0.876 | 0.830 | 0.442 |
| Strict recusal with substitute justices | federal/district_only | 2862 | 1.000 | 0.731 | 0.152 | 0.470 | 1.000 | 0.436 | 0.433 | 0.398 | 0.335 | 0.235 | 0.067 | 0.247 | 0.034 | 0.876 | 0.824 | 0.404 |
| Strict recusal with substitute justices | federal/state_federal_split | 549 | 1.000 | 0.712 | 0.116 | 0.753 | 3.000 | 0.518 | 0.508 | 0.355 | 0.284 | 0.226 | 0.087 | 0.180 | 0.021 | 0.890 | 0.853 | 0.477 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.727 | 0.138 | 0.484 | 3.000 | 0.776 | 0.581 | 0.361 | 0.295 | 0.266 | 0.062 | 0.091 | 0.025 | 0.889 | 0.844 | 0.480 |
| Strict recusal with substitute justices | mixed_state_federal/district_only | 591 | 1.000 | 0.712 | 0.198 | 0.423 | 1.000 | 0.757 | 0.517 | 0.415 | 0.321 | 0.264 | 0.049 | 0.083 | 0.026 | 0.879 | 0.831 | 0.405 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.720 | 0.137 | 0.619 | 3.000 | 0.800 | 0.600 | 0.345 | 0.287 | 0.261 | 0.077 | 0.082 | 0.027 | 0.890 | 0.841 | 0.483 |
| Strict recusal with substitute justices | state/circuit_en_banc | 410 | 1.000 | 0.749 | 0.117 | 0.037 | 3.000 | 0.492 | 0.538 | 0.405 | 0.307 | 0.315 | 0.024 | 0.190 | 0.029 | 0.884 | 0.839 | 0.485 |
| Strict recusal with substitute justices | state/circuit_panel | 2938 | 1.000 | 0.732 | 0.126 | 0.524 | 2.000 | 0.587 | 0.495 | 0.373 | 0.321 | 0.245 | 0.061 | 0.147 | 0.028 | 0.885 | 0.836 | 0.444 |
| Strict recusal with substitute justices | state/district_only | 621 | 1.000 | 0.717 | 0.194 | 0.326 | 1.000 | 0.554 | 0.474 | 0.391 | 0.301 | 0.250 | 0.053 | 0.166 | 0.029 | 0.883 | 0.837 | 0.404 |
| Strict recusal with substitute justices | state/state_federal_split | 5577 | 1.000 | 0.718 | 0.131 | 0.651 | 3.000 | 0.595 | 0.542 | 0.385 | 0.316 | 0.258 | 0.069 | 0.130 | 0.028 | 0.888 | 0.843 | 0.481 |
| Strict recusal with substitute justices | state/state_high_court | 7342 | 1.000 | 0.730 | 0.134 | 0.560 | 2.000 | 0.583 | 0.505 | 0.386 | 0.317 | 0.255 | 0.066 | 0.145 | 0.028 | 0.882 | 0.835 | 0.449 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 4368 | 1.000 | 0.742 | 0.009 | 0.365 | 3.000 | 0.407 | 0.496 | 0.429 | 0.361 | 0.261 | 0.067 | 0.258 | 0.032 | 0.885 | 0.856 | 0.415 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 10391 | 1.000 | 0.741 | 0.013 | 0.509 | 2.000 | 0.431 | 0.456 | 0.417 | 0.347 | 0.250 | 0.068 | 0.256 | 0.031 | 0.883 | 0.851 | 0.380 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 2862 | 1.000 | 0.741 | 0.017 | 0.489 | 1.000 | 0.436 | 0.433 | 0.426 | 0.343 | 0.240 | 0.071 | 0.258 | 0.035 | 0.879 | 0.843 | 0.342 |
| Reasoned emergency orders with merits follow-up | federal/state_federal_split | 549 | 1.000 | 0.715 | 0.014 | 0.770 | 3.000 | 0.518 | 0.508 | 0.430 | 0.322 | 0.286 | 0.077 | 0.224 | 0.023 | 0.900 | 0.874 | 0.415 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.732 | 0.011 | 0.473 | 3.000 | 0.776 | 0.581 | 0.381 | 0.320 | 0.269 | 0.077 | 0.096 | 0.027 | 0.895 | 0.863 | 0.417 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/district_only | 591 | 1.000 | 0.718 | 0.027 | 0.464 | 1.000 | 0.757 | 0.517 | 0.376 | 0.294 | 0.277 | 0.071 | 0.110 | 0.026 | 0.890 | 0.851 | 0.343 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.727 | 0.012 | 0.609 | 3.000 | 0.800 | 0.600 | 0.375 | 0.316 | 0.262 | 0.074 | 0.090 | 0.028 | 0.897 | 0.859 | 0.421 |
| Reasoned emergency orders with merits follow-up | state/circuit_en_banc | 410 | 1.000 | 0.753 | 0.002 | 0.078 | 3.000 | 0.492 | 0.538 | 0.446 | 0.371 | 0.278 | 0.039 | 0.161 | 0.032 | 0.881 | 0.854 | 0.423 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 2938 | 1.000 | 0.740 | 0.011 | 0.514 | 2.000 | 0.587 | 0.495 | 0.394 | 0.332 | 0.261 | 0.072 | 0.155 | 0.028 | 0.890 | 0.856 | 0.381 |
| Reasoned emergency orders with merits follow-up | state/district_only | 621 | 1.000 | 0.723 | 0.026 | 0.366 | 1.000 | 0.554 | 0.474 | 0.369 | 0.304 | 0.311 | 0.064 | 0.166 | 0.029 | 0.892 | 0.860 | 0.342 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 5577 | 1.000 | 0.726 | 0.013 | 0.656 | 3.000 | 0.595 | 0.542 | 0.398 | 0.325 | 0.262 | 0.078 | 0.137 | 0.028 | 0.896 | 0.864 | 0.418 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 7342 | 1.000 | 0.741 | 0.011 | 0.546 | 2.000 | 0.583 | 0.505 | 0.417 | 0.329 | 0.247 | 0.071 | 0.152 | 0.029 | 0.888 | 0.855 | 0.386 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 4368 | 1.000 | 0.734 | 0.135 | 0.408 | 3.000 | 0.407 | 0.496 | 0.403 | 0.315 | 0.280 | 0.051 | 0.247 | 0.029 | 0.890 | 0.848 | 0.606 |
| Panel review with en banc safety valve | federal/circuit_panel | 10391 | 1.000 | 0.733 | 0.135 | 0.553 | 2.000 | 0.431 | 0.456 | 0.404 | 0.323 | 0.255 | 0.064 | 0.244 | 0.030 | 0.889 | 0.843 | 0.551 |
| Panel review with en banc safety valve | federal/district_only | 2862 | 1.000 | 0.732 | 0.153 | 0.497 | 1.000 | 0.436 | 0.433 | 0.404 | 0.328 | 0.246 | 0.063 | 0.250 | 0.033 | 0.888 | 0.837 | 0.505 |
| Panel review with en banc safety valve | federal/state_federal_split | 549 | 1.000 | 0.709 | 0.117 | 0.765 | 3.000 | 0.518 | 0.508 | 0.346 | 0.297 | 0.271 | 0.067 | 0.195 | 0.022 | 0.907 | 0.870 | 0.625 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.726 | 0.140 | 0.512 | 3.000 | 0.776 | 0.581 | 0.352 | 0.286 | 0.292 | 0.060 | 0.090 | 0.025 | 0.900 | 0.856 | 0.620 |
| Panel review with en banc safety valve | mixed_state_federal/district_only | 591 | 1.000 | 0.713 | 0.196 | 0.453 | 1.000 | 0.757 | 0.517 | 0.347 | 0.277 | 0.244 | 0.063 | 0.086 | 0.024 | 0.890 | 0.840 | 0.540 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.719 | 0.138 | 0.639 | 3.000 | 0.800 | 0.600 | 0.357 | 0.285 | 0.277 | 0.071 | 0.083 | 0.026 | 0.902 | 0.852 | 0.628 |
| Panel review with en banc safety valve | state/circuit_en_banc | 410 | 1.000 | 0.749 | 0.110 | 0.034 | 3.000 | 0.492 | 0.538 | 0.393 | 0.320 | 0.322 | 0.054 | 0.161 | 0.028 | 0.896 | 0.849 | 0.622 |
| Panel review with en banc safety valve | state/circuit_panel | 2938 | 1.000 | 0.732 | 0.132 | 0.541 | 2.000 | 0.587 | 0.495 | 0.375 | 0.291 | 0.253 | 0.064 | 0.129 | 0.028 | 0.896 | 0.848 | 0.559 |
| Panel review with en banc safety valve | state/district_only | 621 | 1.000 | 0.718 | 0.192 | 0.337 | 1.000 | 0.554 | 0.474 | 0.393 | 0.303 | 0.243 | 0.069 | 0.142 | 0.028 | 0.895 | 0.850 | 0.530 |
| Panel review with en banc safety valve | state/state_federal_split | 5577 | 1.000 | 0.716 | 0.131 | 0.667 | 3.000 | 0.595 | 0.542 | 0.361 | 0.306 | 0.261 | 0.076 | 0.125 | 0.027 | 0.900 | 0.856 | 0.622 |
| Panel review with en banc safety valve | state/state_high_court | 7342 | 1.000 | 0.730 | 0.135 | 0.588 | 2.000 | 0.583 | 0.505 | 0.373 | 0.306 | 0.253 | 0.068 | 0.139 | 0.028 | 0.893 | 0.847 | 0.568 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 4368 | 1.000 | 0.742 | 0.013 | 0.268 | 3.000 | 0.407 | 0.496 | 0.451 | 0.357 | 0.253 | 0.055 | 0.282 | 0.037 | 0.832 | 0.792 | 0.843 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 10391 | 1.000 | 0.743 | 0.017 | 0.399 | 2.000 | 0.431 | 0.456 | 0.437 | 0.357 | 0.238 | 0.066 | 0.272 | 0.037 | 0.828 | 0.785 | 0.808 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 2862 | 1.000 | 0.740 | 0.022 | 0.364 | 1.000 | 0.436 | 0.433 | 0.451 | 0.371 | 0.222 | 0.058 | 0.287 | 0.040 | 0.831 | 0.785 | 0.770 |
| Dual supreme courts with cross-checking invalidations | federal/state_federal_split | 549 | 1.000 | 0.728 | 0.020 | 0.650 | 3.000 | 0.518 | 0.508 | 0.406 | 0.357 | 0.239 | 0.071 | 0.239 | 0.027 | 0.851 | 0.815 | 0.843 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.740 | 0.015 | 0.339 | 3.000 | 0.776 | 0.581 | 0.402 | 0.352 | 0.247 | 0.063 | 0.125 | 0.032 | 0.845 | 0.801 | 0.845 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/district_only | 591 | 1.000 | 0.718 | 0.035 | 0.259 | 1.000 | 0.757 | 0.517 | 0.379 | 0.333 | 0.230 | 0.068 | 0.115 | 0.032 | 0.837 | 0.786 | 0.772 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.740 | 0.015 | 0.474 | 3.000 | 0.800 | 0.600 | 0.392 | 0.326 | 0.248 | 0.067 | 0.110 | 0.033 | 0.846 | 0.799 | 0.849 |
| Dual supreme courts with cross-checking invalidations | state/circuit_en_banc | 410 | 1.000 | 0.749 | 0.004 | 0.012 | 3.000 | 0.492 | 0.538 | 0.434 | 0.373 | 0.256 | 0.044 | 0.193 | 0.035 | 0.837 | 0.800 | 0.851 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 2938 | 1.000 | 0.742 | 0.015 | 0.390 | 2.000 | 0.587 | 0.495 | 0.419 | 0.360 | 0.221 | 0.060 | 0.167 | 0.034 | 0.839 | 0.794 | 0.810 |
| Dual supreme courts with cross-checking invalidations | state/district_only | 621 | 1.000 | 0.719 | 0.034 | 0.198 | 1.000 | 0.554 | 0.474 | 0.404 | 0.345 | 0.221 | 0.056 | 0.180 | 0.035 | 0.840 | 0.795 | 0.771 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 5577 | 1.000 | 0.736 | 0.017 | 0.526 | 3.000 | 0.595 | 0.542 | 0.411 | 0.339 | 0.242 | 0.069 | 0.163 | 0.032 | 0.845 | 0.803 | 0.846 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 7342 | 1.000 | 0.744 | 0.015 | 0.429 | 2.000 | 0.583 | 0.505 | 0.427 | 0.356 | 0.227 | 0.068 | 0.172 | 0.035 | 0.835 | 0.790 | 0.814 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 4368 | 1.000 | 0.733 | 0.129 | 0.307 | 3.000 | 0.407 | 0.496 | 0.432 | 0.362 | 0.247 | 0.048 | 0.280 | 0.036 | 0.806 | 0.757 | 0.672 |
| Pre-enactment constitutional council | federal/circuit_panel | 10391 | 1.000 | 0.731 | 0.130 | 0.433 | 2.000 | 0.431 | 0.456 | 0.436 | 0.358 | 0.225 | 0.053 | 0.277 | 0.037 | 0.805 | 0.752 | 0.636 |
| Pre-enactment constitutional council | federal/district_only | 2862 | 1.000 | 0.727 | 0.149 | 0.383 | 1.000 | 0.436 | 0.433 | 0.416 | 0.362 | 0.217 | 0.058 | 0.282 | 0.040 | 0.809 | 0.751 | 0.598 |
| Pre-enactment constitutional council | federal/state_federal_split | 549 | 1.000 | 0.719 | 0.113 | 0.607 | 3.000 | 0.518 | 0.508 | 0.432 | 0.339 | 0.231 | 0.071 | 0.253 | 0.025 | 0.824 | 0.778 | 0.672 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.731 | 0.130 | 0.383 | 3.000 | 0.776 | 0.581 | 0.401 | 0.330 | 0.243 | 0.060 | 0.125 | 0.032 | 0.820 | 0.770 | 0.674 |
| Pre-enactment constitutional council | mixed_state_federal/district_only | 591 | 1.000 | 0.709 | 0.184 | 0.255 | 1.000 | 0.757 | 0.517 | 0.398 | 0.335 | 0.220 | 0.051 | 0.127 | 0.034 | 0.813 | 0.750 | 0.600 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.726 | 0.132 | 0.507 | 3.000 | 0.800 | 0.600 | 0.386 | 0.325 | 0.233 | 0.073 | 0.113 | 0.033 | 0.822 | 0.766 | 0.678 |
| Pre-enactment constitutional council | state/circuit_en_banc | 410 | 1.000 | 0.747 | 0.105 | 0.005 | 3.000 | 0.492 | 0.538 | 0.410 | 0.393 | 0.276 | 0.061 | 0.227 | 0.036 | 0.819 | 0.769 | 0.680 |
| Pre-enactment constitutional council | state/circuit_panel | 2938 | 1.000 | 0.730 | 0.126 | 0.415 | 2.000 | 0.587 | 0.495 | 0.399 | 0.344 | 0.233 | 0.064 | 0.163 | 0.035 | 0.813 | 0.759 | 0.638 |
| Pre-enactment constitutional council | state/district_only | 621 | 1.000 | 0.712 | 0.178 | 0.187 | 1.000 | 0.554 | 0.474 | 0.382 | 0.325 | 0.225 | 0.047 | 0.151 | 0.034 | 0.822 | 0.772 | 0.599 |
| Pre-enactment constitutional council | state/state_federal_split | 5577 | 1.000 | 0.722 | 0.123 | 0.531 | 3.000 | 0.595 | 0.542 | 0.397 | 0.331 | 0.239 | 0.068 | 0.151 | 0.034 | 0.819 | 0.769 | 0.675 |
| Pre-enactment constitutional council | state/state_high_court | 7342 | 1.000 | 0.729 | 0.131 | 0.454 | 2.000 | 0.583 | 0.505 | 0.422 | 0.335 | 0.228 | 0.054 | 0.173 | 0.036 | 0.810 | 0.755 | 0.643 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 4368 | 1.000 | 0.732 | 0.136 | 0.429 | 3.000 | 0.407 | 0.496 | 0.396 | 0.314 | 0.279 | 0.057 | 0.231 | 0.027 | 0.906 | 0.860 | 0.439 |
| Judicial review with delayed legislative override | federal/circuit_panel | 10391 | 1.000 | 0.729 | 0.139 | 0.555 | 2.000 | 0.431 | 0.456 | 0.385 | 0.309 | 0.265 | 0.065 | 0.232 | 0.027 | 0.903 | 0.854 | 0.403 |
| Judicial review with delayed legislative override | federal/district_only | 2862 | 1.000 | 0.728 | 0.159 | 0.508 | 1.000 | 0.436 | 0.433 | 0.390 | 0.295 | 0.244 | 0.063 | 0.245 | 0.030 | 0.900 | 0.847 | 0.366 |
| Judicial review with delayed legislative override | federal/state_federal_split | 549 | 1.000 | 0.698 | 0.124 | 0.783 | 3.000 | 0.518 | 0.508 | 0.368 | 0.275 | 0.255 | 0.067 | 0.211 | 0.019 | 0.921 | 0.879 | 0.438 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.722 | 0.142 | 0.533 | 3.000 | 0.776 | 0.581 | 0.338 | 0.295 | 0.283 | 0.071 | 0.079 | 0.022 | 0.915 | 0.868 | 0.441 |
| Judicial review with delayed legislative override | mixed_state_federal/district_only | 591 | 1.000 | 0.709 | 0.200 | 0.538 | 1.000 | 0.757 | 0.517 | 0.340 | 0.274 | 0.276 | 0.066 | 0.098 | 0.022 | 0.910 | 0.856 | 0.367 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.712 | 0.142 | 0.663 | 3.000 | 0.800 | 0.600 | 0.336 | 0.262 | 0.286 | 0.076 | 0.070 | 0.024 | 0.916 | 0.863 | 0.445 |
| Judicial review with delayed legislative override | state/circuit_en_banc | 410 | 1.000 | 0.747 | 0.118 | 0.097 | 3.000 | 0.492 | 0.538 | 0.407 | 0.332 | 0.300 | 0.034 | 0.193 | 0.027 | 0.905 | 0.856 | 0.447 |
| Judicial review with delayed legislative override | state/circuit_panel | 2938 | 1.000 | 0.728 | 0.133 | 0.552 | 2.000 | 0.587 | 0.495 | 0.373 | 0.309 | 0.256 | 0.064 | 0.130 | 0.025 | 0.910 | 0.859 | 0.405 |
| Judicial review with delayed legislative override | state/district_only | 621 | 1.000 | 0.713 | 0.201 | 0.375 | 1.000 | 0.554 | 0.474 | 0.382 | 0.283 | 0.235 | 0.055 | 0.140 | 0.025 | 0.909 | 0.866 | 0.365 |
| Judicial review with delayed legislative override | state/state_federal_split | 5577 | 1.000 | 0.709 | 0.135 | 0.684 | 3.000 | 0.595 | 0.542 | 0.355 | 0.284 | 0.267 | 0.068 | 0.102 | 0.025 | 0.913 | 0.866 | 0.442 |
| Judicial review with delayed legislative override | state/state_high_court | 7342 | 1.000 | 0.727 | 0.136 | 0.597 | 2.000 | 0.583 | 0.505 | 0.370 | 0.294 | 0.258 | 0.068 | 0.132 | 0.025 | 0.908 | 0.858 | 0.410 |
| Retention-election accountability court | federal/circuit_en_banc | 4368 | 1.000 | 0.730 | 0.126 | 0.302 | 3.000 | 0.407 | 0.496 | 0.402 | 0.337 | 0.268 | 0.050 | 0.253 | 0.033 | 0.840 | 0.780 | 0.471 |
| Retention-election accountability court | federal/circuit_panel | 10391 | 1.000 | 0.719 | 0.129 | 0.410 | 2.000 | 0.431 | 0.456 | 0.399 | 0.325 | 0.241 | 0.058 | 0.251 | 0.033 | 0.836 | 0.775 | 0.435 |
| Retention-election accountability court | federal/district_only | 2862 | 1.000 | 0.719 | 0.146 | 0.348 | 1.000 | 0.436 | 0.433 | 0.412 | 0.336 | 0.226 | 0.052 | 0.251 | 0.037 | 0.837 | 0.774 | 0.397 |
| Retention-election accountability court | federal/state_federal_split | 549 | 1.000 | 0.696 | 0.110 | 0.591 | 3.000 | 0.518 | 0.508 | 0.379 | 0.293 | 0.260 | 0.064 | 0.182 | 0.021 | 0.860 | 0.810 | 0.471 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.725 | 0.129 | 0.382 | 3.000 | 0.776 | 0.581 | 0.349 | 0.291 | 0.262 | 0.061 | 0.094 | 0.027 | 0.853 | 0.794 | 0.473 |
| Retention-election accountability court | mixed_state_federal/district_only | 591 | 1.000 | 0.707 | 0.181 | 0.257 | 1.000 | 0.757 | 0.517 | 0.321 | 0.296 | 0.232 | 0.052 | 0.095 | 0.029 | 0.849 | 0.779 | 0.398 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.719 | 0.129 | 0.507 | 3.000 | 0.800 | 0.600 | 0.357 | 0.279 | 0.255 | 0.070 | 0.090 | 0.028 | 0.852 | 0.787 | 0.477 |
| Retention-election accountability court | state/circuit_en_banc | 410 | 1.000 | 0.747 | 0.121 | 0.008 | 3.000 | 0.492 | 0.538 | 0.415 | 0.346 | 0.298 | 0.063 | 0.173 | 0.030 | 0.853 | 0.799 | 0.479 |
| Retention-election accountability court | state/circuit_panel | 2938 | 1.000 | 0.722 | 0.123 | 0.392 | 2.000 | 0.587 | 0.495 | 0.397 | 0.317 | 0.237 | 0.053 | 0.145 | 0.031 | 0.847 | 0.787 | 0.437 |
| Retention-election accountability court | state/district_only | 621 | 1.000 | 0.707 | 0.182 | 0.168 | 1.000 | 0.554 | 0.474 | 0.393 | 0.367 | 0.230 | 0.045 | 0.158 | 0.030 | 0.848 | 0.791 | 0.398 |
| Retention-election accountability court | state/state_federal_split | 5577 | 1.000 | 0.713 | 0.125 | 0.504 | 3.000 | 0.595 | 0.542 | 0.368 | 0.303 | 0.241 | 0.065 | 0.143 | 0.029 | 0.850 | 0.791 | 0.474 |
| Retention-election accountability court | state/state_high_court | 7342 | 1.000 | 0.720 | 0.126 | 0.430 | 2.000 | 0.583 | 0.505 | 0.387 | 0.317 | 0.243 | 0.059 | 0.146 | 0.030 | 0.842 | 0.779 | 0.442 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 4368 | 1.000 | 0.742 | 0.008 | 0.287 | 3.000 | 0.407 | 0.496 | 0.447 | 0.364 | 0.253 | 0.057 | 0.283 | 0.038 | 0.827 | 0.805 | 0.773 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 10391 | 1.000 | 0.742 | 0.011 | 0.435 | 2.000 | 0.431 | 0.456 | 0.437 | 0.363 | 0.238 | 0.065 | 0.277 | 0.038 | 0.824 | 0.798 | 0.715 |
| Hybrid court balancing independence and accountability | federal/district_only | 2862 | 1.000 | 0.741 | 0.014 | 0.406 | 1.000 | 0.436 | 0.433 | 0.446 | 0.364 | 0.213 | 0.063 | 0.260 | 0.041 | 0.825 | 0.794 | 0.667 |
| Hybrid court balancing independence and accountability | federal/state_federal_split | 549 | 1.000 | 0.726 | 0.013 | 0.658 | 3.000 | 0.518 | 0.508 | 0.408 | 0.330 | 0.250 | 0.078 | 0.250 | 0.027 | 0.845 | 0.825 | 0.794 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 4167 | 1.000 | 0.738 | 0.010 | 0.359 | 3.000 | 0.776 | 0.581 | 0.405 | 0.328 | 0.251 | 0.066 | 0.120 | 0.032 | 0.841 | 0.815 | 0.787 |
| Hybrid court balancing independence and accountability | mixed_state_federal/district_only | 591 | 1.000 | 0.719 | 0.022 | 0.299 | 1.000 | 0.757 | 0.517 | 0.406 | 0.328 | 0.213 | 0.064 | 0.134 | 0.031 | 0.835 | 0.801 | 0.706 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 8184 | 1.000 | 0.737 | 0.011 | 0.492 | 3.000 | 0.800 | 0.600 | 0.397 | 0.338 | 0.246 | 0.072 | 0.110 | 0.033 | 0.840 | 0.807 | 0.796 |
| Hybrid court balancing independence and accountability | state/circuit_en_banc | 410 | 1.000 | 0.749 | 0.002 | 0.027 | 3.000 | 0.492 | 0.538 | 0.415 | 0.385 | 0.302 | 0.063 | 0.202 | 0.036 | 0.834 | 0.809 | 0.789 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 2938 | 1.000 | 0.743 | 0.010 | 0.439 | 2.000 | 0.587 | 0.495 | 0.425 | 0.351 | 0.217 | 0.064 | 0.160 | 0.035 | 0.835 | 0.806 | 0.726 |
| Hybrid court balancing independence and accountability | state/district_only | 621 | 1.000 | 0.720 | 0.022 | 0.217 | 1.000 | 0.554 | 0.474 | 0.401 | 0.351 | 0.251 | 0.053 | 0.184 | 0.034 | 0.837 | 0.814 | 0.698 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 5577 | 1.000 | 0.733 | 0.012 | 0.546 | 3.000 | 0.595 | 0.542 | 0.409 | 0.341 | 0.250 | 0.072 | 0.154 | 0.033 | 0.840 | 0.814 | 0.790 |
| Hybrid court balancing independence and accountability | state/state_high_court | 7342 | 1.000 | 0.743 | 0.010 | 0.464 | 2.000 | 0.583 | 0.505 | 0.422 | 0.358 | 0.240 | 0.063 | 0.171 | 0.035 | 0.830 | 0.801 | 0.733 |

## Policy Domain Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administration | 4421 | 1.000 | 0.709 | 0.409 | 0.114 | 2.709 | 0.490 | 0.529 | 0.325 | 0.253 | 0.370 | 0.052 | 0.143 | 0.017 | 0.955 | 0.902 | 0.353 |
| Current-style federal supreme court | civil-rights | 11675 | 1.000 | 0.658 | 0.499 | 0.648 | 2.264 | 0.505 | 0.475 | 0.281 | 0.207 | 0.293 | 0.064 | 0.120 | 0.016 | 0.959 | 0.902 | 0.327 |
| Current-style federal supreme court | criminal-justice | 6892 | 1.000 | 0.655 | 0.482 | 0.584 | 2.330 | 0.580 | 0.507 | 0.279 | 0.203 | 0.296 | 0.075 | 0.092 | 0.016 | 0.958 | 0.900 | 0.333 |
| Current-style federal supreme court | economic-regulation | 5241 | 1.000 | 0.708 | 0.408 | 0.127 | 2.606 | 0.636 | 0.562 | 0.299 | 0.237 | 0.317 | 0.061 | 0.111 | 0.019 | 0.954 | 0.897 | 0.352 |
| Current-style federal supreme court | elections | 7019 | 1.000 | 0.627 | 0.494 | 0.644 | 2.724 | 0.681 | 0.530 | 0.259 | 0.193 | 0.302 | 0.071 | 0.070 | 0.014 | 0.963 | 0.909 | 0.347 |
| Current-style federal supreme court | emergency-security | 6887 | 1.000 | 0.630 | 0.670 | 0.419 | 1.986 | 0.549 | 0.505 | 0.254 | 0.173 | 0.307 | 0.055 | 0.099 | 0.015 | 0.960 | 0.903 | 0.318 |
| Current-style federal supreme court | governance | 5865 | 1.000 | 0.690 | 0.432 | 0.283 | 2.431 | 0.671 | 0.552 | 0.302 | 0.224 | 0.279 | 0.056 | 0.102 | 0.016 | 0.955 | 0.898 | 0.343 |
| Staggered 18-year nonrenewable terms | administration | 4421 | 1.000 | 0.719 | 0.402 | 0.080 | 2.709 | 0.490 | 0.529 | 0.329 | 0.256 | 0.358 | 0.056 | 0.147 | 0.018 | 0.951 | 0.896 | 0.359 |
| Staggered 18-year nonrenewable terms | civil-rights | 11675 | 1.000 | 0.662 | 0.493 | 0.625 | 2.264 | 0.505 | 0.475 | 0.277 | 0.207 | 0.291 | 0.065 | 0.117 | 0.016 | 0.956 | 0.897 | 0.333 |
| Staggered 18-year nonrenewable terms | criminal-justice | 6892 | 1.000 | 0.662 | 0.471 | 0.555 | 2.330 | 0.580 | 0.507 | 0.274 | 0.208 | 0.289 | 0.072 | 0.100 | 0.016 | 0.955 | 0.895 | 0.339 |
| Staggered 18-year nonrenewable terms | economic-regulation | 5241 | 1.000 | 0.719 | 0.394 | 0.099 | 2.606 | 0.636 | 0.562 | 0.334 | 0.241 | 0.301 | 0.048 | 0.115 | 0.019 | 0.950 | 0.891 | 0.358 |
| Staggered 18-year nonrenewable terms | elections | 7019 | 1.000 | 0.634 | 0.494 | 0.611 | 2.724 | 0.681 | 0.530 | 0.268 | 0.187 | 0.301 | 0.069 | 0.073 | 0.014 | 0.960 | 0.904 | 0.352 |
| Staggered 18-year nonrenewable terms | emergency-security | 6887 | 1.000 | 0.643 | 0.660 | 0.363 | 1.986 | 0.549 | 0.505 | 0.255 | 0.182 | 0.301 | 0.066 | 0.107 | 0.015 | 0.956 | 0.896 | 0.323 |
| Staggered 18-year nonrenewable terms | governance | 5865 | 1.000 | 0.699 | 0.435 | 0.251 | 2.431 | 0.671 | 0.552 | 0.305 | 0.226 | 0.280 | 0.060 | 0.097 | 0.017 | 0.951 | 0.892 | 0.349 |
| Fifteen-justice supermajority commission court | administration | 4421 | 1.000 | 0.747 | 0.119 | 0.118 | 2.709 | 0.490 | 0.529 | 0.405 | 0.331 | 0.297 | 0.049 | 0.206 | 0.030 | 0.891 | 0.848 | 0.446 |
| Fifteen-justice supermajority commission court | civil-rights | 11675 | 1.000 | 0.725 | 0.135 | 0.794 | 2.264 | 0.505 | 0.475 | 0.373 | 0.295 | 0.267 | 0.078 | 0.174 | 0.026 | 0.901 | 0.852 | 0.420 |
| Fifteen-justice supermajority commission court | criminal-justice | 6892 | 1.000 | 0.714 | 0.146 | 0.702 | 2.330 | 0.580 | 0.507 | 0.366 | 0.304 | 0.249 | 0.070 | 0.148 | 0.027 | 0.897 | 0.850 | 0.427 |
| Fifteen-justice supermajority commission court | economic-regulation | 5241 | 1.000 | 0.752 | 0.113 | 0.109 | 2.606 | 0.636 | 0.562 | 0.414 | 0.339 | 0.255 | 0.050 | 0.170 | 0.031 | 0.885 | 0.840 | 0.446 |
| Fifteen-justice supermajority commission court | elections | 7019 | 1.000 | 0.707 | 0.125 | 0.765 | 2.724 | 0.681 | 0.530 | 0.355 | 0.284 | 0.262 | 0.080 | 0.125 | 0.023 | 0.906 | 0.861 | 0.440 |
| Fifteen-justice supermajority commission court | emergency-security | 6887 | 1.000 | 0.716 | 0.197 | 0.447 | 1.986 | 0.549 | 0.505 | 0.366 | 0.295 | 0.265 | 0.066 | 0.173 | 0.027 | 0.896 | 0.849 | 0.411 |
| Fifteen-justice supermajority commission court | governance | 5865 | 1.000 | 0.746 | 0.122 | 0.369 | 2.431 | 0.671 | 0.552 | 0.379 | 0.316 | 0.238 | 0.052 | 0.145 | 0.029 | 0.891 | 0.844 | 0.436 |
| Supermajority required to invalidate laws | administration | 4421 | 1.000 | 0.743 | 0.119 | 0.110 | 2.709 | 0.490 | 0.529 | 0.408 | 0.337 | 0.300 | 0.050 | 0.206 | 0.029 | 0.897 | 0.855 | 0.411 |
| Supermajority required to invalidate laws | civil-rights | 11675 | 1.000 | 0.723 | 0.136 | 0.756 | 2.264 | 0.505 | 0.475 | 0.380 | 0.298 | 0.260 | 0.072 | 0.175 | 0.025 | 0.904 | 0.856 | 0.385 |
| Supermajority required to invalidate laws | criminal-justice | 6892 | 1.000 | 0.709 | 0.154 | 0.672 | 2.330 | 0.580 | 0.507 | 0.367 | 0.296 | 0.252 | 0.069 | 0.143 | 0.026 | 0.901 | 0.853 | 0.391 |
| Supermajority required to invalidate laws | economic-regulation | 5241 | 1.000 | 0.748 | 0.116 | 0.130 | 2.606 | 0.636 | 0.562 | 0.402 | 0.331 | 0.264 | 0.051 | 0.166 | 0.030 | 0.891 | 0.845 | 0.410 |
| Supermajority required to invalidate laws | elections | 7019 | 1.000 | 0.702 | 0.130 | 0.745 | 2.724 | 0.681 | 0.530 | 0.355 | 0.282 | 0.264 | 0.076 | 0.119 | 0.022 | 0.910 | 0.864 | 0.405 |
| Supermajority required to invalidate laws | emergency-security | 6887 | 1.000 | 0.707 | 0.208 | 0.428 | 1.986 | 0.549 | 0.505 | 0.357 | 0.289 | 0.264 | 0.066 | 0.159 | 0.026 | 0.901 | 0.854 | 0.375 |
| Supermajority required to invalidate laws | governance | 5865 | 1.000 | 0.740 | 0.128 | 0.354 | 2.431 | 0.671 | 0.552 | 0.371 | 0.309 | 0.239 | 0.061 | 0.143 | 0.028 | 0.896 | 0.849 | 0.401 |
| Strict recusal with substitute justices | administration | 4421 | 1.000 | 0.746 | 0.116 | 0.087 | 2.709 | 0.490 | 0.529 | 0.405 | 0.348 | 0.298 | 0.049 | 0.208 | 0.031 | 0.878 | 0.836 | 0.476 |
| Strict recusal with substitute justices | civil-rights | 11675 | 1.000 | 0.726 | 0.130 | 0.780 | 2.264 | 0.505 | 0.475 | 0.380 | 0.312 | 0.257 | 0.073 | 0.183 | 0.027 | 0.888 | 0.839 | 0.449 |
| Strict recusal with substitute justices | criminal-justice | 6892 | 1.000 | 0.714 | 0.147 | 0.689 | 2.330 | 0.580 | 0.507 | 0.382 | 0.304 | 0.248 | 0.065 | 0.155 | 0.029 | 0.883 | 0.836 | 0.455 |
| Strict recusal with substitute justices | economic-regulation | 5241 | 1.000 | 0.751 | 0.110 | 0.091 | 2.606 | 0.636 | 0.562 | 0.392 | 0.335 | 0.259 | 0.046 | 0.164 | 0.033 | 0.872 | 0.826 | 0.475 |
| Strict recusal with substitute justices | elections | 7019 | 1.000 | 0.709 | 0.122 | 0.745 | 2.724 | 0.681 | 0.530 | 0.362 | 0.296 | 0.249 | 0.084 | 0.126 | 0.024 | 0.891 | 0.845 | 0.469 |
| Strict recusal with substitute justices | emergency-security | 6887 | 1.000 | 0.716 | 0.195 | 0.424 | 1.986 | 0.549 | 0.505 | 0.386 | 0.304 | 0.253 | 0.061 | 0.176 | 0.029 | 0.882 | 0.835 | 0.439 |
| Strict recusal with substitute justices | governance | 5865 | 1.000 | 0.746 | 0.121 | 0.360 | 2.431 | 0.671 | 0.552 | 0.374 | 0.323 | 0.237 | 0.060 | 0.149 | 0.031 | 0.878 | 0.831 | 0.465 |
| Reasoned emergency orders with merits follow-up | administration | 4421 | 1.000 | 0.748 | 0.002 | 0.100 | 2.709 | 0.490 | 0.529 | 0.428 | 0.370 | 0.293 | 0.052 | 0.211 | 0.033 | 0.881 | 0.856 | 0.413 |
| Reasoned emergency orders with merits follow-up | civil-rights | 11675 | 1.000 | 0.740 | 0.014 | 0.783 | 2.264 | 0.505 | 0.475 | 0.405 | 0.330 | 0.260 | 0.080 | 0.189 | 0.028 | 0.896 | 0.859 | 0.387 |
| Reasoned emergency orders with merits follow-up | criminal-justice | 6892 | 1.000 | 0.732 | 0.009 | 0.688 | 2.330 | 0.580 | 0.507 | 0.411 | 0.324 | 0.244 | 0.074 | 0.162 | 0.029 | 0.890 | 0.855 | 0.393 |
| Reasoned emergency orders with merits follow-up | economic-regulation | 5241 | 1.000 | 0.752 | 0.002 | 0.122 | 2.606 | 0.636 | 0.562 | 0.420 | 0.343 | 0.252 | 0.054 | 0.180 | 0.034 | 0.878 | 0.848 | 0.412 |
| Reasoned emergency orders with merits follow-up | elections | 7019 | 1.000 | 0.714 | 0.015 | 0.768 | 2.724 | 0.681 | 0.530 | 0.382 | 0.313 | 0.266 | 0.086 | 0.133 | 0.025 | 0.900 | 0.866 | 0.407 |
| Reasoned emergency orders with merits follow-up | emergency-security | 6887 | 1.000 | 0.721 | 0.029 | 0.461 | 1.986 | 0.549 | 0.505 | 0.392 | 0.331 | 0.259 | 0.072 | 0.189 | 0.030 | 0.888 | 0.855 | 0.377 |
| Reasoned emergency orders with merits follow-up | governance | 5865 | 1.000 | 0.749 | 0.006 | 0.314 | 2.431 | 0.671 | 0.552 | 0.401 | 0.338 | 0.235 | 0.066 | 0.156 | 0.033 | 0.882 | 0.850 | 0.403 |
| Panel review with en banc safety valve | administration | 4421 | 1.000 | 0.747 | 0.117 | 0.083 | 2.709 | 0.490 | 0.529 | 0.398 | 0.328 | 0.306 | 0.042 | 0.201 | 0.031 | 0.888 | 0.847 | 0.604 |
| Panel review with en banc safety valve | civil-rights | 11675 | 1.000 | 0.725 | 0.132 | 0.809 | 2.264 | 0.505 | 0.475 | 0.375 | 0.304 | 0.264 | 0.076 | 0.180 | 0.026 | 0.900 | 0.851 | 0.561 |
| Panel review with en banc safety valve | criminal-justice | 6892 | 1.000 | 0.714 | 0.151 | 0.719 | 2.330 | 0.580 | 0.507 | 0.380 | 0.301 | 0.259 | 0.072 | 0.148 | 0.028 | 0.894 | 0.847 | 0.567 |
| Panel review with en banc safety valve | economic-regulation | 5241 | 1.000 | 0.752 | 0.110 | 0.110 | 2.606 | 0.636 | 0.562 | 0.390 | 0.322 | 0.272 | 0.052 | 0.163 | 0.032 | 0.884 | 0.840 | 0.607 |
| Panel review with en banc safety valve | elections | 7019 | 1.000 | 0.708 | 0.122 | 0.762 | 2.724 | 0.681 | 0.530 | 0.366 | 0.285 | 0.261 | 0.074 | 0.123 | 0.023 | 0.904 | 0.858 | 0.614 |
| Panel review with en banc safety valve | emergency-security | 6887 | 1.000 | 0.716 | 0.196 | 0.441 | 1.986 | 0.549 | 0.505 | 0.370 | 0.301 | 0.261 | 0.063 | 0.176 | 0.027 | 0.894 | 0.848 | 0.577 |
| Panel review with en banc safety valve | governance | 5865 | 1.000 | 0.746 | 0.121 | 0.383 | 2.431 | 0.671 | 0.552 | 0.383 | 0.309 | 0.241 | 0.059 | 0.149 | 0.030 | 0.891 | 0.844 | 0.593 |
| Dual supreme courts with cross-checking invalidations | administration | 4421 | 1.000 | 0.747 | 0.005 | 0.021 | 2.709 | 0.490 | 0.529 | 0.445 | 0.363 | 0.282 | 0.046 | 0.241 | 0.039 | 0.832 | 0.794 | 0.841 |
| Dual supreme courts with cross-checking invalidations | civil-rights | 11675 | 1.000 | 0.746 | 0.018 | 0.679 | 2.264 | 0.505 | 0.475 | 0.417 | 0.342 | 0.242 | 0.076 | 0.211 | 0.033 | 0.845 | 0.798 | 0.815 |
| Dual supreme courts with cross-checking invalidations | criminal-justice | 6892 | 1.000 | 0.737 | 0.014 | 0.562 | 2.330 | 0.580 | 0.507 | 0.415 | 0.351 | 0.228 | 0.068 | 0.189 | 0.034 | 0.837 | 0.791 | 0.821 |
| Dual supreme courts with cross-checking invalidations | economic-regulation | 5241 | 1.000 | 0.753 | 0.005 | 0.026 | 2.606 | 0.636 | 0.562 | 0.443 | 0.363 | 0.247 | 0.049 | 0.194 | 0.040 | 0.827 | 0.785 | 0.840 |
| Dual supreme courts with cross-checking invalidations | elections | 7019 | 1.000 | 0.728 | 0.018 | 0.626 | 2.724 | 0.681 | 0.530 | 0.397 | 0.338 | 0.234 | 0.072 | 0.157 | 0.030 | 0.846 | 0.800 | 0.835 |
| Dual supreme courts with cross-checking invalidations | emergency-security | 6887 | 1.000 | 0.724 | 0.035 | 0.269 | 1.986 | 0.549 | 0.505 | 0.415 | 0.344 | 0.237 | 0.065 | 0.201 | 0.035 | 0.836 | 0.793 | 0.805 |
| Dual supreme courts with cross-checking invalidations | governance | 5865 | 1.000 | 0.753 | 0.008 | 0.210 | 2.431 | 0.671 | 0.552 | 0.436 | 0.363 | 0.210 | 0.055 | 0.174 | 0.038 | 0.830 | 0.786 | 0.831 |
| Pre-enactment constitutional council | administration | 4421 | 1.000 | 0.745 | 0.111 | 0.026 | 2.709 | 0.490 | 0.529 | 0.439 | 0.373 | 0.281 | 0.045 | 0.229 | 0.038 | 0.813 | 0.765 | 0.670 |
| Pre-enactment constitutional council | civil-rights | 11675 | 1.000 | 0.727 | 0.129 | 0.693 | 2.264 | 0.505 | 0.475 | 0.410 | 0.343 | 0.231 | 0.069 | 0.211 | 0.033 | 0.819 | 0.764 | 0.644 |
| Pre-enactment constitutional council | criminal-justice | 6892 | 1.000 | 0.716 | 0.140 | 0.575 | 2.330 | 0.580 | 0.507 | 0.406 | 0.333 | 0.232 | 0.060 | 0.186 | 0.035 | 0.811 | 0.756 | 0.650 |
| Pre-enactment constitutional council | economic-regulation | 5241 | 1.000 | 0.751 | 0.106 | 0.030 | 2.606 | 0.636 | 0.562 | 0.443 | 0.357 | 0.234 | 0.047 | 0.206 | 0.040 | 0.800 | 0.747 | 0.669 |
| Pre-enactment constitutional council | elections | 7019 | 1.000 | 0.715 | 0.118 | 0.606 | 2.724 | 0.681 | 0.530 | 0.394 | 0.328 | 0.230 | 0.073 | 0.157 | 0.030 | 0.820 | 0.766 | 0.663 |
| Pre-enactment constitutional council | emergency-security | 6887 | 1.000 | 0.713 | 0.186 | 0.257 | 1.986 | 0.549 | 0.505 | 0.400 | 0.328 | 0.227 | 0.056 | 0.201 | 0.035 | 0.814 | 0.761 | 0.634 |
| Pre-enactment constitutional council | governance | 5865 | 1.000 | 0.746 | 0.115 | 0.278 | 2.431 | 0.671 | 0.552 | 0.415 | 0.350 | 0.209 | 0.051 | 0.175 | 0.038 | 0.807 | 0.754 | 0.660 |
| Judicial review with delayed legislative override | administration | 4421 | 1.000 | 0.745 | 0.119 | 0.144 | 2.709 | 0.490 | 0.529 | 0.392 | 0.328 | 0.304 | 0.051 | 0.193 | 0.028 | 0.902 | 0.857 | 0.437 |
| Judicial review with delayed legislative override | civil-rights | 11675 | 1.000 | 0.721 | 0.136 | 0.806 | 2.264 | 0.505 | 0.475 | 0.372 | 0.290 | 0.269 | 0.076 | 0.165 | 0.024 | 0.914 | 0.863 | 0.411 |
| Judicial review with delayed legislative override | criminal-justice | 6892 | 1.000 | 0.709 | 0.149 | 0.723 | 2.330 | 0.580 | 0.507 | 0.351 | 0.283 | 0.260 | 0.073 | 0.143 | 0.025 | 0.908 | 0.858 | 0.417 |
| Judicial review with delayed legislative override | economic-regulation | 5241 | 1.000 | 0.749 | 0.115 | 0.150 | 2.606 | 0.636 | 0.562 | 0.392 | 0.319 | 0.276 | 0.056 | 0.159 | 0.030 | 0.899 | 0.851 | 0.436 |
| Judicial review with delayed legislative override | elections | 7019 | 1.000 | 0.701 | 0.125 | 0.771 | 2.724 | 0.681 | 0.530 | 0.341 | 0.276 | 0.269 | 0.074 | 0.110 | 0.022 | 0.918 | 0.870 | 0.430 |
| Judicial review with delayed legislative override | emergency-security | 6887 | 1.000 | 0.710 | 0.202 | 0.481 | 1.986 | 0.549 | 0.505 | 0.359 | 0.284 | 0.263 | 0.062 | 0.162 | 0.025 | 0.909 | 0.859 | 0.401 |
| Judicial review with delayed legislative override | governance | 5865 | 1.000 | 0.741 | 0.126 | 0.405 | 2.431 | 0.671 | 0.552 | 0.373 | 0.295 | 0.249 | 0.061 | 0.137 | 0.027 | 0.904 | 0.855 | 0.427 |
| Retention-election accountability court | administration | 4421 | 1.000 | 0.745 | 0.114 | 0.033 | 2.709 | 0.490 | 0.529 | 0.414 | 0.353 | 0.297 | 0.050 | 0.211 | 0.033 | 0.841 | 0.784 | 0.469 |
| Retention-election accountability court | civil-rights | 11675 | 1.000 | 0.710 | 0.125 | 0.665 | 2.264 | 0.505 | 0.475 | 0.372 | 0.301 | 0.250 | 0.066 | 0.182 | 0.028 | 0.852 | 0.789 | 0.442 |
| Retention-election accountability court | criminal-justice | 6892 | 1.000 | 0.703 | 0.137 | 0.549 | 2.330 | 0.580 | 0.507 | 0.380 | 0.303 | 0.243 | 0.060 | 0.166 | 0.030 | 0.842 | 0.779 | 0.449 |
| Retention-election accountability court | economic-regulation | 5241 | 1.000 | 0.752 | 0.111 | 0.040 | 2.606 | 0.636 | 0.562 | 0.407 | 0.341 | 0.244 | 0.044 | 0.178 | 0.036 | 0.836 | 0.775 | 0.468 |
| Retention-election accountability court | elections | 7019 | 1.000 | 0.703 | 0.112 | 0.575 | 2.724 | 0.681 | 0.530 | 0.363 | 0.289 | 0.238 | 0.075 | 0.130 | 0.026 | 0.851 | 0.790 | 0.462 |
| Retention-election accountability court | emergency-security | 6887 | 1.000 | 0.712 | 0.181 | 0.243 | 1.986 | 0.549 | 0.505 | 0.381 | 0.309 | 0.242 | 0.054 | 0.183 | 0.032 | 0.843 | 0.782 | 0.432 |
| Retention-election accountability court | governance | 5865 | 1.000 | 0.741 | 0.118 | 0.280 | 2.431 | 0.671 | 0.552 | 0.381 | 0.314 | 0.228 | 0.056 | 0.151 | 0.032 | 0.838 | 0.775 | 0.458 |
| Hybrid court balancing independence and accountability | administration | 4421 | 1.000 | 0.747 | 0.001 | 0.028 | 2.709 | 0.490 | 0.529 | 0.443 | 0.369 | 0.278 | 0.049 | 0.235 | 0.039 | 0.825 | 0.802 | 0.771 |
| Hybrid court balancing independence and accountability | civil-rights | 11675 | 1.000 | 0.744 | 0.013 | 0.722 | 2.264 | 0.505 | 0.475 | 0.419 | 0.352 | 0.242 | 0.076 | 0.209 | 0.033 | 0.839 | 0.808 | 0.725 |
| Hybrid court balancing independence and accountability | criminal-justice | 6892 | 1.000 | 0.736 | 0.009 | 0.606 | 2.330 | 0.580 | 0.507 | 0.413 | 0.357 | 0.234 | 0.074 | 0.190 | 0.035 | 0.834 | 0.804 | 0.731 |
| Hybrid court balancing independence and accountability | economic-regulation | 5241 | 1.000 | 0.753 | 0.002 | 0.037 | 2.606 | 0.636 | 0.562 | 0.423 | 0.359 | 0.243 | 0.049 | 0.200 | 0.040 | 0.822 | 0.796 | 0.775 |
| Hybrid court balancing independence and accountability | elections | 7019 | 1.000 | 0.725 | 0.014 | 0.649 | 2.724 | 0.681 | 0.530 | 0.401 | 0.330 | 0.243 | 0.076 | 0.145 | 0.030 | 0.843 | 0.815 | 0.782 |
| Hybrid court balancing independence and accountability | emergency-security | 6887 | 1.000 | 0.722 | 0.024 | 0.297 | 1.986 | 0.549 | 0.505 | 0.420 | 0.343 | 0.238 | 0.059 | 0.202 | 0.036 | 0.830 | 0.805 | 0.745 |
| Hybrid court balancing independence and accountability | governance | 5865 | 1.000 | 0.752 | 0.005 | 0.233 | 2.431 | 0.671 | 0.552 | 0.442 | 0.355 | 0.223 | 0.059 | 0.173 | 0.039 | 0.824 | 0.797 | 0.759 |

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

## Uncertainty Diagnostics

Campaign, pipeline, composition, and calibration CSV artifacts include 95% uncertainty bands using `conservative-bounded-normal-95`. These bands are conservative approximations from aggregate report denominators; they are not a substitute for raw per-case bootstrap resampling.

| Scenario | Median score band width | Median cost band width |
| --- | ---: | ---: |
| Current-style federal supreme court | 0.020 | 0.019 |
| Staggered 18-year nonrenewable terms | 0.020 | 0.019 |
| Fifteen-justice supermajority commission court | 0.019 | 0.020 |
| Supermajority required to invalidate laws | 0.019 | 0.020 |
| Strict recusal with substitute justices | 0.019 | 0.020 |
| Reasoned emergency orders with merits follow-up | 0.019 | 0.020 |
| Panel review with en banc safety valve | 0.019 | 0.020 |
| Dual supreme courts with cross-checking invalidations | 0.019 | 0.015 |
| Pre-enactment constitutional council | 0.019 | 0.019 |
| Judicial review with delayed legislative override | 0.019 | 0.020 |
| Retention-election accountability court | 0.019 | 0.020 |
| Hybrid court balancing independence and accountability | 0.019 | 0.017 |

## Calibration Diagnostics

| Profile | Target | Observed | 95% band | Range | Gap | Status |
| --- | --- | ---: | ---: | ---: | ---: | --- |
| scdb-postwar-merits-1946-2024 | Speech docket share | 0.142 | 0.141-0.142 | 0.060-0.091 | 0.050 | outside |
| scdb-postwar-merits-1946-2024 | Civil-rights and privacy docket share | 0.141 | 0.140-0.142 | 0.135-0.169 | 0.000 | within |
| scdb-postwar-merits-1946-2024 | Criminal procedure docket share | 0.144 | 0.143-0.144 | 0.207-0.244 | 0.063 | outside |
| scdb-postwar-merits-1946-2024 | Federalism docket share | 0.141 | 0.140-0.142 | 0.041-0.071 | 0.070 | outside |
| scdb-postwar-merits-1946-2024 | Election-law docket share | 0.146 | 0.145-0.147 | 0.013-0.040 | 0.106 | outside |
| scdb-postwar-merits-1946-2024 | Emergency-powers merits share | 0.143 | 0.143-0.144 | 0.000-0.012 | 0.131 | outside |
| scdb-postwar-merits-1946-2024 | Administrative and economic regulation share | 0.143 | 0.142-0.144 | 0.199-0.236 | 0.056 | outside |
| scdb-modern-merits-2000-2024 | Speech docket share | 0.142 | 0.141-0.142 | 0.039-0.080 | 0.061 | outside |
| scdb-modern-merits-2000-2024 | Civil-rights and privacy docket share | 0.141 | 0.140-0.142 | 0.137-0.191 | 0.000 | within |
| scdb-modern-merits-2000-2024 | Criminal procedure docket share | 0.144 | 0.143-0.144 | 0.230-0.289 | 0.086 | outside |
| scdb-modern-merits-2000-2024 | Federalism docket share | 0.141 | 0.140-0.142 | 0.037-0.078 | 0.063 | outside |
| scdb-modern-merits-2000-2024 | Election-law docket share | 0.146 | 0.145-0.147 | 0.009-0.043 | 0.103 | outside |
| scdb-modern-merits-2000-2024 | Emergency-powers merits share | 0.143 | 0.143-0.144 | 0.000-0.019 | 0.124 | outside |
| scdb-modern-merits-2000-2024 | Administrative and economic regulation share | 0.143 | 0.142-0.144 | 0.193-0.250 | 0.050 | outside |
| scotusblog-interim-2024 | Significant interim docket relief rate | 0.549 | 0.546-0.551 | 0.200-0.450 | 0.099 | outside |
| gallup-court-confidence-2024 | Public court trust and approval | 0.028 | 0.027-0.028 | 0.350-0.490 | 0.322 | outside |
