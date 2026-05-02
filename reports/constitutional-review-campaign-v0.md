# Constitutional Review Campaign v0

- runs per case: 120
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Baseline

Moderately polarized appointment environment with ordinary constitutional-review pressure.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.705
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.747
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.268
- highest compliance rate: Pre-enactment constitutional council at 0.534
- lowest defiance rate: Pre-enactment constitutional council at 0.188

### Polarized appointments

High appointment polarization, higher partisan pressure, and lower public trust.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.685
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.746
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.321
- highest compliance rate: Pre-enactment constitutional council at 0.451
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.257

### Rights-threat surge

Docket contains more laws or actions with high generated rights-risk signals.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.631
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.743
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.007
- lowest emergency relief rate: Retention-election accountability court at 0.626
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.381
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.316

### Emergency docket stress

Higher urgency and executive pressure, meant to stress shadow-docket procedures.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.670
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.734
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.039
- lowest emergency relief rate: Retention-election accountability court at 0.351
- highest compliance rate: Hybrid court balancing independence and accountability at 0.409
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.291

### Low-trust conflict

Lower public trust and higher legislature-court conflict.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.666
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.740
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.344
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.371
- lowest defiance rate: Reasoned emergency orders with merits follow-up at 0.316

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Intake | Emerg. relief | Reasons | Disagree | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin | Direct | Upstream | Capacity | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.524 | 0.743 | 0.663 | 0.229 | 0.491 | 0.022 | 0.756 | 0.026 | 0.573 | 0.455 | 0.529 | 0.251 | 0.394 | 0.384 | 0.285 | 0.209 | 0.304 | 0.064 | 0.104 | 2.435 | 0.581 | 0.498 | 0.308 | 0.698 | 0.431 | 0.455 |
| Staggered 18-year nonrenewable terms | 0.537 | 0.751 | 0.671 | 0.211 | 0.488 | 0.022 | 0.714 | 0.036 | 0.567 | 0.422 | 0.538 | 0.231 | 0.389 | 0.393 | 0.288 | 0.215 | 0.299 | 0.064 | 0.106 | 2.435 | 0.581 | 0.507 | 0.312 | 0.698 | 0.446 | 0.460 |
| Fifteen-justice supermajority commission court | 0.635 | 0.847 | 0.727 | 0.172 | 0.138 | 0.021 | 0.525 | 0.674 | 0.288 | 0.554 | 0.664 | 0.397 | 0.288 | 0.451 | 0.376 | 0.304 | 0.258 | 0.066 | 0.164 | 2.435 | 0.581 | 0.498 | 0.365 | 0.700 | 0.438 | 0.476 |
| Supermajority required to invalidate laws | 0.621 | 0.855 | 0.722 | 0.191 | 0.144 | 0.021 | 0.574 | 0.642 | 0.322 | 0.529 | 0.639 | 0.376 | 0.289 | 0.444 | 0.373 | 0.296 | 0.265 | 0.065 | 0.158 | 2.435 | 0.581 | 0.477 | 0.306 | 0.700 | 0.416 | 0.463 |
| Strict recusal with substitute justices | 0.643 | 0.848 | 0.727 | 0.171 | 0.135 | 0.021 | 0.516 | 0.712 | 0.279 | 0.536 | 0.684 | 0.384 | 0.286 | 0.452 | 0.381 | 0.313 | 0.257 | 0.064 | 0.168 | 2.435 | 0.581 | 0.498 | 0.365 | 0.700 | 0.438 | 0.482 |
| Reasoned emergency orders with merits follow-up | 0.659 | 0.865 | 0.735 | 0.190 | 0.012 | 0.021 | 0.566 | 0.873 | 0.133 | 0.530 | 0.711 | 0.530 | 0.262 | 0.456 | 0.407 | 0.332 | 0.255 | 0.073 | 0.180 | 2.435 | 0.581 | 0.485 | 0.311 | 0.701 | 0.427 | 0.466 |
| Panel review with en banc safety valve | 0.629 | 0.843 | 0.727 | 0.170 | 0.137 | 0.021 | 0.526 | 0.700 | 0.274 | 0.558 | 0.677 | 0.401 | 0.288 | 0.451 | 0.381 | 0.306 | 0.261 | 0.065 | 0.161 | 2.435 | 0.581 | 0.697 | 0.437 | 0.700 | 0.474 | 0.519 |
| Dual supreme courts with cross-checking invalidations | 0.663 | 0.891 | 0.741 | 0.156 | 0.016 | 0.021 | 0.445 | 0.872 | 0.134 | 0.404 | 0.720 | 0.404 | 0.268 | 0.466 | 0.423 | 0.349 | 0.239 | 0.064 | 0.196 | 2.435 | 0.581 | 0.881 | 0.520 | 0.701 | 0.582 | 0.595 |
| Pre-enactment constitutional council | 0.657 | 0.918 | 0.728 | 0.149 | 0.131 | 0.021 | 0.486 | 0.755 | 0.256 | 0.432 | 0.709 | 0.309 | 0.276 | 0.458 | 0.410 | 0.342 | 0.235 | 0.058 | 0.194 | 2.435 | 0.581 | 0.752 | 0.444 | 0.700 | 0.499 | 0.539 |
| Judicial review with delayed legislative override | 0.626 | 0.832 | 0.722 | 0.185 | 0.141 | 0.021 | 0.557 | 0.667 | 0.300 | 0.574 | 0.655 | 0.410 | 0.297 | 0.451 | 0.367 | 0.295 | 0.269 | 0.067 | 0.152 | 2.435 | 0.581 | 0.491 | 0.312 | 0.700 | 0.432 | 0.472 |
| Retention-election accountability court | 0.651 | 0.849 | 0.720 | 0.161 | 0.129 | 0.021 | 0.382 | 0.684 | 0.266 | 0.417 | 0.675 | 0.298 | 0.288 | 0.471 | 0.380 | 0.316 | 0.244 | 0.061 | 0.169 | 2.435 | 0.581 | 0.511 | 0.324 | 0.700 | 0.468 | 0.487 |
| Hybrid court balancing independence and accountability | 0.671 | 0.895 | 0.739 | 0.160 | 0.011 | 0.021 | 0.489 | 0.883 | 0.124 | 0.434 | 0.724 | 0.434 | 0.251 | 0.465 | 0.421 | 0.349 | 0.243 | 0.068 | 0.190 | 2.435 | 0.581 | 0.690 | 0.460 | 0.701 | 0.470 | 0.550 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 1.000 | 0.022 | 0.664 | 0.486 | 0.024 | 0.567 | 0.453 | 2.425 | 0.580 | 0.517 | 0.413 | 0.342 | 0.223 | 0.036 | 0.233 | 0.063 | 0.841 | 0.613 | 0.452 |
| Current-style federal supreme court | 2 | 12000 | 1.000 | 0.022 | 0.662 | 0.497 | 0.026 | 0.558 | 0.466 | 2.436 | 0.581 | 0.518 | 0.245 | 0.171 | 0.336 | 0.075 | 0.064 | 0.000 | 0.997 | 0.997 | 0.456 |
| Current-style federal supreme court | 3 | 12000 | 1.000 | 0.022 | 0.662 | 0.496 | 0.024 | 0.585 | 0.452 | 2.438 | 0.580 | 0.517 | 0.238 | 0.162 | 0.327 | 0.076 | 0.059 | 0.000 | 0.998 | 1.000 | 0.456 |
| Current-style federal supreme court | 4 | 12000 | 1.000 | 0.022 | 0.663 | 0.487 | 0.029 | 0.581 | 0.448 | 2.442 | 0.582 | 0.517 | 0.245 | 0.163 | 0.330 | 0.069 | 0.059 | 0.000 | 0.998 | 1.000 | 0.456 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 1.000 | 0.022 | 0.671 | 0.484 | 0.040 | 0.573 | 0.417 | 2.425 | 0.580 | 0.517 | 0.424 | 0.356 | 0.211 | 0.035 | 0.237 | 0.066 | 0.829 | 0.590 | 0.452 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 1.000 | 0.022 | 0.672 | 0.489 | 0.035 | 0.568 | 0.422 | 2.436 | 0.581 | 0.518 | 0.244 | 0.177 | 0.330 | 0.073 | 0.069 | 0.000 | 0.995 | 0.994 | 0.463 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 1.000 | 0.022 | 0.670 | 0.491 | 0.034 | 0.571 | 0.422 | 2.438 | 0.580 | 0.517 | 0.246 | 0.163 | 0.333 | 0.075 | 0.058 | 0.000 | 0.998 | 1.000 | 0.463 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 1.000 | 0.022 | 0.670 | 0.488 | 0.035 | 0.557 | 0.426 | 2.442 | 0.582 | 0.517 | 0.240 | 0.164 | 0.324 | 0.074 | 0.058 | 0.000 | 0.998 | 1.000 | 0.463 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 1.000 | 0.021 | 0.728 | 0.136 | 0.666 | 0.285 | 0.549 | 2.425 | 0.580 | 0.517 | 0.533 | 0.448 | 0.172 | 0.038 | 0.325 | 0.107 | 0.708 | 0.485 | 0.466 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 1.000 | 0.021 | 0.727 | 0.140 | 0.677 | 0.290 | 0.558 | 2.436 | 0.581 | 0.518 | 0.352 | 0.287 | 0.269 | 0.073 | 0.144 | 0.000 | 0.914 | 0.927 | 0.480 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 1.000 | 0.021 | 0.726 | 0.140 | 0.679 | 0.293 | 0.556 | 2.438 | 0.580 | 0.517 | 0.310 | 0.242 | 0.294 | 0.079 | 0.098 | 0.000 | 0.977 | 0.991 | 0.479 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 1.000 | 0.021 | 0.727 | 0.137 | 0.674 | 0.283 | 0.551 | 2.442 | 0.582 | 0.517 | 0.310 | 0.237 | 0.297 | 0.075 | 0.087 | 0.000 | 0.990 | 0.998 | 0.480 |
| Supermajority required to invalidate laws | 1 | 12000 | 1.000 | 0.021 | 0.722 | 0.142 | 0.650 | 0.307 | 0.529 | 2.425 | 0.580 | 0.517 | 0.521 | 0.446 | 0.176 | 0.035 | 0.314 | 0.103 | 0.716 | 0.494 | 0.459 |
| Supermajority required to invalidate laws | 2 | 12000 | 1.000 | 0.021 | 0.722 | 0.145 | 0.637 | 0.320 | 0.530 | 2.436 | 0.581 | 0.518 | 0.352 | 0.272 | 0.278 | 0.070 | 0.135 | 0.000 | 0.923 | 0.938 | 0.464 |
| Supermajority required to invalidate laws | 3 | 12000 | 1.000 | 0.021 | 0.721 | 0.148 | 0.642 | 0.335 | 0.535 | 2.438 | 0.580 | 0.517 | 0.314 | 0.237 | 0.302 | 0.076 | 0.094 | 0.000 | 0.981 | 0.996 | 0.464 |
| Supermajority required to invalidate laws | 4 | 12000 | 1.000 | 0.021 | 0.721 | 0.141 | 0.640 | 0.322 | 0.522 | 2.442 | 0.582 | 0.517 | 0.304 | 0.229 | 0.304 | 0.080 | 0.089 | 0.000 | 0.993 | 1.000 | 0.464 |
| Strict recusal with substitute justices | 1 | 12000 | 1.000 | 0.021 | 0.728 | 0.134 | 0.714 | 0.291 | 0.534 | 2.425 | 0.580 | 0.517 | 0.534 | 0.462 | 0.163 | 0.036 | 0.326 | 0.112 | 0.694 | 0.465 | 0.472 |
| Strict recusal with substitute justices | 2 | 12000 | 1.000 | 0.021 | 0.727 | 0.137 | 0.698 | 0.262 | 0.539 | 2.436 | 0.581 | 0.518 | 0.357 | 0.298 | 0.268 | 0.071 | 0.154 | 0.000 | 0.895 | 0.905 | 0.485 |
| Strict recusal with substitute justices | 3 | 12000 | 1.000 | 0.021 | 0.727 | 0.137 | 0.718 | 0.282 | 0.536 | 2.438 | 0.580 | 0.517 | 0.321 | 0.254 | 0.298 | 0.074 | 0.102 | 0.000 | 0.964 | 0.984 | 0.485 |
| Strict recusal with substitute justices | 4 | 12000 | 1.000 | 0.021 | 0.727 | 0.134 | 0.718 | 0.283 | 0.534 | 2.442 | 0.582 | 0.517 | 0.310 | 0.240 | 0.299 | 0.076 | 0.088 | 0.000 | 0.985 | 0.997 | 0.485 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 1.000 | 0.021 | 0.736 | 0.012 | 0.885 | 0.136 | 0.525 | 2.425 | 0.580 | 0.517 | 0.554 | 0.474 | 0.171 | 0.046 | 0.348 | 0.118 | 0.695 | 0.505 | 0.458 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 1.000 | 0.021 | 0.736 | 0.012 | 0.866 | 0.132 | 0.526 | 2.436 | 0.581 | 0.518 | 0.387 | 0.315 | 0.271 | 0.076 | 0.157 | 0.001 | 0.906 | 0.933 | 0.469 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 1.000 | 0.021 | 0.735 | 0.012 | 0.875 | 0.128 | 0.529 | 2.438 | 0.580 | 0.517 | 0.342 | 0.272 | 0.283 | 0.083 | 0.110 | 0.000 | 0.970 | 0.992 | 0.469 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 1.000 | 0.021 | 0.735 | 0.012 | 0.867 | 0.137 | 0.538 | 2.442 | 0.582 | 0.517 | 0.344 | 0.266 | 0.293 | 0.087 | 0.104 | 0.000 | 0.988 | 1.000 | 0.469 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.021 | 0.727 | 0.136 | 0.684 | 0.278 | 0.554 | 2.425 | 0.580 | 0.517 | 0.532 | 0.455 | 0.169 | 0.036 | 0.320 | 0.110 | 0.703 | 0.479 | 0.509 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.021 | 0.728 | 0.138 | 0.700 | 0.275 | 0.560 | 2.436 | 0.581 | 0.518 | 0.357 | 0.289 | 0.275 | 0.069 | 0.142 | 0.000 | 0.912 | 0.925 | 0.523 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.021 | 0.727 | 0.138 | 0.701 | 0.277 | 0.561 | 2.438 | 0.580 | 0.517 | 0.316 | 0.240 | 0.299 | 0.076 | 0.095 | 0.000 | 0.978 | 0.995 | 0.522 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.021 | 0.726 | 0.138 | 0.713 | 0.267 | 0.557 | 2.442 | 0.582 | 0.517 | 0.320 | 0.240 | 0.302 | 0.077 | 0.088 | 0.000 | 0.992 | 1.000 | 0.522 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.021 | 0.741 | 0.016 | 0.867 | 0.133 | 0.402 | 2.425 | 0.580 | 0.517 | 0.574 | 0.500 | 0.155 | 0.037 | 0.359 | 0.136 | 0.646 | 0.419 | 0.585 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.021 | 0.741 | 0.016 | 0.884 | 0.124 | 0.409 | 2.436 | 0.581 | 0.518 | 0.414 | 0.338 | 0.246 | 0.071 | 0.187 | 0.001 | 0.835 | 0.839 | 0.599 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.021 | 0.740 | 0.016 | 0.863 | 0.150 | 0.401 | 2.438 | 0.580 | 0.517 | 0.359 | 0.286 | 0.272 | 0.076 | 0.125 | 0.000 | 0.919 | 0.947 | 0.598 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.021 | 0.741 | 0.016 | 0.873 | 0.131 | 0.406 | 2.442 | 0.582 | 0.517 | 0.345 | 0.271 | 0.283 | 0.073 | 0.111 | 0.000 | 0.956 | 0.977 | 0.599 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.021 | 0.729 | 0.129 | 0.753 | 0.258 | 0.428 | 2.425 | 0.580 | 0.517 | 0.554 | 0.483 | 0.148 | 0.033 | 0.348 | 0.138 | 0.639 | 0.391 | 0.523 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.021 | 0.729 | 0.132 | 0.764 | 0.249 | 0.436 | 2.436 | 0.581 | 0.518 | 0.406 | 0.333 | 0.244 | 0.061 | 0.185 | 0.002 | 0.811 | 0.800 | 0.545 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.021 | 0.728 | 0.134 | 0.753 | 0.264 | 0.431 | 2.438 | 0.580 | 0.517 | 0.349 | 0.283 | 0.267 | 0.068 | 0.131 | 0.001 | 0.879 | 0.908 | 0.544 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.021 | 0.728 | 0.129 | 0.749 | 0.252 | 0.433 | 2.442 | 0.582 | 0.517 | 0.330 | 0.268 | 0.281 | 0.072 | 0.112 | 0.000 | 0.922 | 0.948 | 0.544 |
| Judicial review with delayed legislative override | 1 | 12000 | 1.000 | 0.021 | 0.723 | 0.139 | 0.646 | 0.295 | 0.570 | 2.425 | 0.580 | 0.517 | 0.513 | 0.445 | 0.172 | 0.035 | 0.311 | 0.101 | 0.724 | 0.501 | 0.463 |
| Judicial review with delayed legislative override | 2 | 12000 | 1.000 | 0.021 | 0.722 | 0.143 | 0.674 | 0.298 | 0.577 | 2.436 | 0.581 | 0.518 | 0.343 | 0.269 | 0.289 | 0.077 | 0.127 | 0.000 | 0.934 | 0.944 | 0.475 |
| Judicial review with delayed legislative override | 3 | 12000 | 1.000 | 0.021 | 0.721 | 0.143 | 0.675 | 0.297 | 0.576 | 2.438 | 0.580 | 0.517 | 0.309 | 0.232 | 0.304 | 0.078 | 0.087 | 0.000 | 0.986 | 0.997 | 0.475 |
| Judicial review with delayed legislative override | 4 | 12000 | 1.000 | 0.021 | 0.721 | 0.139 | 0.669 | 0.312 | 0.571 | 2.442 | 0.582 | 0.517 | 0.303 | 0.234 | 0.312 | 0.078 | 0.084 | 0.000 | 0.994 | 1.000 | 0.475 |
| Retention-election accountability court | 1 | 12000 | 1.000 | 0.021 | 0.720 | 0.127 | 0.691 | 0.270 | 0.419 | 2.425 | 0.580 | 0.517 | 0.528 | 0.459 | 0.157 | 0.035 | 0.319 | 0.121 | 0.659 | 0.403 | 0.467 |
| Retention-election accountability court | 2 | 12000 | 1.000 | 0.021 | 0.720 | 0.130 | 0.679 | 0.258 | 0.421 | 2.436 | 0.581 | 0.518 | 0.368 | 0.306 | 0.254 | 0.065 | 0.157 | 0.001 | 0.846 | 0.825 | 0.494 |
| Retention-election accountability court | 3 | 12000 | 1.000 | 0.021 | 0.721 | 0.131 | 0.680 | 0.267 | 0.418 | 2.438 | 0.580 | 0.517 | 0.319 | 0.259 | 0.279 | 0.074 | 0.108 | 0.000 | 0.915 | 0.934 | 0.494 |
| Retention-election accountability court | 4 | 12000 | 1.000 | 0.021 | 0.719 | 0.127 | 0.688 | 0.269 | 0.412 | 2.442 | 0.582 | 0.517 | 0.303 | 0.241 | 0.286 | 0.072 | 0.092 | 0.000 | 0.949 | 0.966 | 0.494 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.021 | 0.739 | 0.011 | 0.892 | 0.120 | 0.432 | 2.425 | 0.580 | 0.517 | 0.568 | 0.501 | 0.153 | 0.039 | 0.351 | 0.137 | 0.641 | 0.433 | 0.540 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.021 | 0.740 | 0.011 | 0.882 | 0.119 | 0.437 | 2.436 | 0.581 | 0.518 | 0.407 | 0.339 | 0.253 | 0.073 | 0.181 | 0.001 | 0.831 | 0.855 | 0.554 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.021 | 0.739 | 0.011 | 0.861 | 0.135 | 0.431 | 2.438 | 0.580 | 0.517 | 0.366 | 0.282 | 0.278 | 0.078 | 0.123 | 0.001 | 0.916 | 0.957 | 0.554 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.021 | 0.739 | 0.011 | 0.896 | 0.124 | 0.436 | 2.442 | 0.582 | 0.517 | 0.341 | 0.272 | 0.288 | 0.082 | 0.103 | 0.001 | 0.955 | 0.984 | 0.554 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 6924 | 1.000 | 0.021 | 0.712 | 0.404 | 0.018 | 0.529 | 0.108 | 2.701 | 0.486 | 0.529 | 0.329 | 0.251 | 0.352 | 0.053 | 0.156 | 0.018 | 0.955 | 0.901 | 0.463 |
| Current-style federal supreme court | criminal_procedure | 6872 | 1.000 | 0.022 | 0.655 | 0.477 | 0.024 | 0.555 | 0.584 | 2.334 | 0.581 | 0.507 | 0.282 | 0.204 | 0.300 | 0.065 | 0.099 | 0.016 | 0.959 | 0.902 | 0.450 |
| Current-style federal supreme court | election_law | 6946 | 1.000 | 0.023 | 0.628 | 0.493 | 0.030 | 0.569 | 0.647 | 2.725 | 0.680 | 0.529 | 0.253 | 0.189 | 0.305 | 0.074 | 0.069 | 0.014 | 0.963 | 0.908 | 0.461 |
| Current-style federal supreme court | emergency_powers | 6839 | 1.000 | 0.023 | 0.630 | 0.665 | 0.030 | 0.637 | 0.424 | 1.986 | 0.548 | 0.506 | 0.259 | 0.183 | 0.303 | 0.063 | 0.094 | 0.015 | 0.960 | 0.902 | 0.451 |
| Current-style federal supreme court | equality | 6774 | 1.000 | 0.022 | 0.660 | 0.501 | 0.030 | 0.551 | 0.686 | 2.284 | 0.535 | 0.481 | 0.287 | 0.207 | 0.289 | 0.071 | 0.106 | 0.015 | 0.961 | 0.904 | 0.447 |
| Current-style federal supreme court | federalism | 6845 | 1.000 | 0.022 | 0.698 | 0.417 | 0.018 | 0.554 | 0.167 | 2.767 | 0.768 | 0.601 | 0.292 | 0.218 | 0.281 | 0.060 | 0.072 | 0.018 | 0.955 | 0.899 | 0.469 |
| Current-style federal supreme court | speech | 6800 | 1.000 | 0.022 | 0.658 | 0.484 | 0.028 | 0.585 | 0.586 | 2.238 | 0.467 | 0.467 | 0.294 | 0.214 | 0.298 | 0.061 | 0.132 | 0.016 | 0.957 | 0.900 | 0.445 |
| Staggered 18-year nonrenewable terms | administrative_state | 6924 | 1.000 | 0.021 | 0.720 | 0.397 | 0.028 | 0.523 | 0.080 | 2.701 | 0.486 | 0.529 | 0.333 | 0.257 | 0.355 | 0.056 | 0.148 | 0.018 | 0.952 | 0.895 | 0.468 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 6872 | 1.000 | 0.022 | 0.662 | 0.475 | 0.035 | 0.563 | 0.550 | 2.334 | 0.581 | 0.507 | 0.287 | 0.202 | 0.288 | 0.065 | 0.101 | 0.016 | 0.955 | 0.896 | 0.455 |
| Staggered 18-year nonrenewable terms | election_law | 6946 | 1.000 | 0.023 | 0.635 | 0.492 | 0.040 | 0.574 | 0.609 | 2.725 | 0.680 | 0.529 | 0.261 | 0.196 | 0.294 | 0.077 | 0.069 | 0.015 | 0.959 | 0.902 | 0.466 |
| Staggered 18-year nonrenewable terms | emergency_powers | 6839 | 1.000 | 0.023 | 0.641 | 0.661 | 0.043 | 0.624 | 0.369 | 1.986 | 0.548 | 0.506 | 0.266 | 0.181 | 0.302 | 0.060 | 0.101 | 0.016 | 0.956 | 0.895 | 0.456 |
| Staggered 18-year nonrenewable terms | equality | 6774 | 1.000 | 0.022 | 0.663 | 0.502 | 0.039 | 0.550 | 0.670 | 2.284 | 0.535 | 0.481 | 0.283 | 0.215 | 0.291 | 0.064 | 0.112 | 0.015 | 0.958 | 0.898 | 0.452 |
| Staggered 18-year nonrenewable terms | federalism | 6845 | 1.000 | 0.022 | 0.711 | 0.409 | 0.030 | 0.532 | 0.125 | 2.767 | 0.768 | 0.601 | 0.299 | 0.230 | 0.269 | 0.059 | 0.076 | 0.019 | 0.951 | 0.892 | 0.474 |
| Staggered 18-year nonrenewable terms | speech | 6800 | 1.000 | 0.022 | 0.662 | 0.481 | 0.035 | 0.580 | 0.563 | 2.238 | 0.467 | 0.467 | 0.289 | 0.223 | 0.295 | 0.069 | 0.131 | 0.017 | 0.954 | 0.895 | 0.449 |
| Fifteen-justice supermajority commission court | administrative_state | 6924 | 1.000 | 0.020 | 0.746 | 0.115 | 0.646 | 0.234 | 0.096 | 2.701 | 0.486 | 0.529 | 0.403 | 0.329 | 0.299 | 0.050 | 0.210 | 0.030 | 0.891 | 0.849 | 0.484 |
| Fifteen-justice supermajority commission court | criminal_procedure | 6872 | 1.000 | 0.021 | 0.714 | 0.146 | 0.656 | 0.308 | 0.709 | 2.334 | 0.581 | 0.507 | 0.372 | 0.294 | 0.257 | 0.067 | 0.151 | 0.027 | 0.898 | 0.851 | 0.471 |
| Fifteen-justice supermajority commission court | election_law | 6946 | 1.000 | 0.023 | 0.707 | 0.125 | 0.722 | 0.298 | 0.763 | 2.725 | 0.680 | 0.529 | 0.364 | 0.277 | 0.258 | 0.080 | 0.122 | 0.023 | 0.907 | 0.859 | 0.482 |
| Fifteen-justice supermajority commission court | emergency_powers | 6839 | 1.000 | 0.022 | 0.716 | 0.198 | 0.691 | 0.319 | 0.448 | 1.986 | 0.548 | 0.506 | 0.374 | 0.304 | 0.257 | 0.064 | 0.179 | 0.027 | 0.895 | 0.848 | 0.472 |
| Fifteen-justice supermajority commission court | equality | 6774 | 1.000 | 0.021 | 0.728 | 0.136 | 0.686 | 0.279 | 0.848 | 2.284 | 0.535 | 0.481 | 0.371 | 0.295 | 0.257 | 0.076 | 0.167 | 0.025 | 0.903 | 0.854 | 0.468 |
| Fifteen-justice supermajority commission court | federalism | 6845 | 1.000 | 0.022 | 0.756 | 0.118 | 0.632 | 0.224 | 0.138 | 2.767 | 0.768 | 0.601 | 0.374 | 0.324 | 0.228 | 0.055 | 0.129 | 0.030 | 0.887 | 0.841 | 0.490 |
| Fifteen-justice supermajority commission court | speech | 6800 | 1.000 | 0.021 | 0.721 | 0.130 | 0.653 | 0.306 | 0.720 | 2.238 | 0.467 | 0.467 | 0.375 | 0.302 | 0.250 | 0.071 | 0.189 | 0.027 | 0.900 | 0.852 | 0.465 |
| Supermajority required to invalidate laws | administrative_state | 6924 | 1.000 | 0.020 | 0.743 | 0.118 | 0.572 | 0.274 | 0.101 | 2.701 | 0.486 | 0.529 | 0.403 | 0.322 | 0.312 | 0.054 | 0.201 | 0.029 | 0.898 | 0.855 | 0.470 |
| Supermajority required to invalidate laws | criminal_procedure | 6872 | 1.000 | 0.021 | 0.710 | 0.153 | 0.623 | 0.350 | 0.668 | 2.334 | 0.581 | 0.507 | 0.366 | 0.292 | 0.257 | 0.072 | 0.148 | 0.026 | 0.903 | 0.856 | 0.458 |
| Supermajority required to invalidate laws | election_law | 6946 | 1.000 | 0.023 | 0.701 | 0.130 | 0.665 | 0.336 | 0.743 | 2.725 | 0.680 | 0.529 | 0.348 | 0.272 | 0.266 | 0.079 | 0.118 | 0.022 | 0.912 | 0.865 | 0.469 |
| Supermajority required to invalidate laws | emergency_powers | 6839 | 1.000 | 0.022 | 0.706 | 0.207 | 0.661 | 0.345 | 0.427 | 1.986 | 0.548 | 0.506 | 0.363 | 0.284 | 0.255 | 0.062 | 0.158 | 0.026 | 0.903 | 0.856 | 0.459 |
| Supermajority required to invalidate laws | equality | 6774 | 1.000 | 0.021 | 0.725 | 0.141 | 0.664 | 0.282 | 0.818 | 2.284 | 0.535 | 0.481 | 0.377 | 0.287 | 0.271 | 0.075 | 0.167 | 0.024 | 0.907 | 0.859 | 0.455 |
| Supermajority required to invalidate laws | federalism | 6845 | 1.000 | 0.022 | 0.749 | 0.122 | 0.619 | 0.296 | 0.132 | 2.767 | 0.768 | 0.601 | 0.371 | 0.309 | 0.236 | 0.050 | 0.122 | 0.029 | 0.894 | 0.849 | 0.476 |
| Supermajority required to invalidate laws | speech | 6800 | 1.000 | 0.021 | 0.716 | 0.137 | 0.656 | 0.338 | 0.676 | 2.238 | 0.467 | 0.467 | 0.380 | 0.307 | 0.258 | 0.064 | 0.193 | 0.026 | 0.905 | 0.858 | 0.452 |
| Strict recusal with substitute justices | administrative_state | 6924 | 1.000 | 0.020 | 0.746 | 0.112 | 0.669 | 0.224 | 0.070 | 2.701 | 0.486 | 0.529 | 0.402 | 0.346 | 0.294 | 0.048 | 0.213 | 0.031 | 0.878 | 0.836 | 0.490 |
| Strict recusal with substitute justices | criminal_procedure | 6872 | 1.000 | 0.021 | 0.714 | 0.148 | 0.707 | 0.287 | 0.693 | 2.334 | 0.581 | 0.507 | 0.375 | 0.304 | 0.253 | 0.067 | 0.157 | 0.028 | 0.884 | 0.838 | 0.477 |
| Strict recusal with substitute justices | election_law | 6946 | 1.000 | 0.023 | 0.709 | 0.121 | 0.721 | 0.300 | 0.736 | 2.725 | 0.680 | 0.529 | 0.361 | 0.298 | 0.260 | 0.080 | 0.125 | 0.024 | 0.894 | 0.847 | 0.488 |
| Strict recusal with substitute justices | emergency_powers | 6839 | 1.000 | 0.022 | 0.716 | 0.195 | 0.741 | 0.305 | 0.419 | 1.986 | 0.548 | 0.506 | 0.385 | 0.302 | 0.259 | 0.060 | 0.184 | 0.029 | 0.882 | 0.835 | 0.478 |
| Strict recusal with substitute justices | equality | 6774 | 1.000 | 0.021 | 0.728 | 0.134 | 0.710 | 0.281 | 0.834 | 2.284 | 0.535 | 0.481 | 0.377 | 0.307 | 0.259 | 0.071 | 0.167 | 0.026 | 0.891 | 0.842 | 0.474 |
| Strict recusal with substitute justices | federalism | 6845 | 1.000 | 0.022 | 0.756 | 0.112 | 0.674 | 0.233 | 0.126 | 2.767 | 0.768 | 0.601 | 0.379 | 0.329 | 0.225 | 0.055 | 0.129 | 0.031 | 0.874 | 0.828 | 0.495 |
| Strict recusal with substitute justices | speech | 6800 | 1.000 | 0.021 | 0.722 | 0.127 | 0.711 | 0.286 | 0.714 | 2.238 | 0.467 | 0.467 | 0.386 | 0.307 | 0.248 | 0.069 | 0.198 | 0.029 | 0.888 | 0.840 | 0.471 |
| Reasoned emergency orders with merits follow-up | administrative_state | 6924 | 1.000 | 0.020 | 0.748 | 0.002 | 0.878 | 0.101 | 0.101 | 2.701 | 0.486 | 0.529 | 0.424 | 0.362 | 0.295 | 0.056 | 0.227 | 0.033 | 0.882 | 0.857 | 0.474 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 6872 | 1.000 | 0.021 | 0.732 | 0.010 | 0.858 | 0.099 | 0.689 | 2.334 | 0.581 | 0.507 | 0.397 | 0.330 | 0.249 | 0.077 | 0.173 | 0.029 | 0.892 | 0.858 | 0.461 |
| Reasoned emergency orders with merits follow-up | election_law | 6946 | 1.000 | 0.023 | 0.714 | 0.015 | 0.863 | 0.140 | 0.772 | 2.725 | 0.680 | 0.529 | 0.389 | 0.319 | 0.261 | 0.080 | 0.128 | 0.026 | 0.900 | 0.865 | 0.472 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 6839 | 1.000 | 0.022 | 0.721 | 0.029 | 0.875 | 0.174 | 0.462 | 1.986 | 0.548 | 0.506 | 0.406 | 0.325 | 0.243 | 0.073 | 0.195 | 0.030 | 0.886 | 0.855 | 0.462 |
| Reasoned emergency orders with merits follow-up | equality | 6774 | 1.000 | 0.021 | 0.744 | 0.015 | 0.879 | 0.105 | 0.837 | 2.284 | 0.535 | 0.481 | 0.401 | 0.329 | 0.259 | 0.085 | 0.189 | 0.027 | 0.896 | 0.859 | 0.458 |
| Reasoned emergency orders with merits follow-up | federalism | 6845 | 1.000 | 0.021 | 0.755 | 0.003 | 0.874 | 0.095 | 0.147 | 2.767 | 0.768 | 0.601 | 0.414 | 0.330 | 0.224 | 0.064 | 0.137 | 0.034 | 0.879 | 0.850 | 0.480 |
| Reasoned emergency orders with merits follow-up | speech | 6800 | 1.000 | 0.021 | 0.734 | 0.012 | 0.888 | 0.120 | 0.704 | 2.238 | 0.467 | 0.467 | 0.415 | 0.327 | 0.250 | 0.075 | 0.209 | 0.030 | 0.894 | 0.859 | 0.455 |
| Panel review with en banc safety valve | administrative_state | 6924 | 1.000 | 0.020 | 0.747 | 0.114 | 0.648 | 0.232 | 0.097 | 2.701 | 0.486 | 0.529 | 0.402 | 0.339 | 0.310 | 0.047 | 0.206 | 0.031 | 0.891 | 0.849 | 0.527 |
| Panel review with en banc safety valve | criminal_procedure | 6872 | 1.000 | 0.021 | 0.714 | 0.148 | 0.663 | 0.306 | 0.724 | 2.334 | 0.581 | 0.507 | 0.375 | 0.289 | 0.258 | 0.071 | 0.145 | 0.027 | 0.897 | 0.850 | 0.510 |
| Panel review with en banc safety valve | election_law | 6946 | 1.000 | 0.023 | 0.708 | 0.124 | 0.722 | 0.294 | 0.757 | 2.725 | 0.680 | 0.529 | 0.352 | 0.284 | 0.261 | 0.078 | 0.124 | 0.024 | 0.905 | 0.858 | 0.530 |
| Panel review with en banc safety valve | emergency_powers | 6839 | 1.000 | 0.022 | 0.716 | 0.196 | 0.714 | 0.299 | 0.446 | 1.986 | 0.548 | 0.506 | 0.379 | 0.296 | 0.254 | 0.057 | 0.176 | 0.028 | 0.894 | 0.848 | 0.519 |
| Panel review with en banc safety valve | equality | 6774 | 1.000 | 0.021 | 0.728 | 0.135 | 0.718 | 0.234 | 0.855 | 2.284 | 0.535 | 0.481 | 0.382 | 0.300 | 0.260 | 0.074 | 0.167 | 0.025 | 0.902 | 0.853 | 0.508 |
| Panel review with en banc safety valve | federalism | 6845 | 1.000 | 0.022 | 0.757 | 0.115 | 0.684 | 0.229 | 0.134 | 2.767 | 0.768 | 0.601 | 0.387 | 0.321 | 0.233 | 0.054 | 0.123 | 0.031 | 0.886 | 0.841 | 0.537 |
| Panel review with en banc safety valve | speech | 6800 | 1.000 | 0.021 | 0.721 | 0.130 | 0.720 | 0.294 | 0.745 | 2.238 | 0.467 | 0.467 | 0.393 | 0.312 | 0.251 | 0.071 | 0.189 | 0.028 | 0.899 | 0.850 | 0.501 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 6924 | 1.000 | 0.020 | 0.746 | 0.005 | 0.866 | 0.064 | 0.021 | 2.701 | 0.486 | 0.529 | 0.446 | 0.376 | 0.275 | 0.044 | 0.235 | 0.039 | 0.832 | 0.796 | 0.603 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 6872 | 1.000 | 0.021 | 0.736 | 0.014 | 0.859 | 0.121 | 0.562 | 2.334 | 0.581 | 0.507 | 0.417 | 0.350 | 0.235 | 0.069 | 0.187 | 0.033 | 0.840 | 0.795 | 0.590 |
| Dual supreme courts with cross-checking invalidations | election_law | 6946 | 1.000 | 0.022 | 0.729 | 0.018 | 0.877 | 0.120 | 0.622 | 2.725 | 0.680 | 0.529 | 0.405 | 0.332 | 0.240 | 0.078 | 0.153 | 0.030 | 0.848 | 0.803 | 0.601 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 6839 | 1.000 | 0.022 | 0.725 | 0.036 | 0.869 | 0.170 | 0.269 | 1.986 | 0.548 | 0.506 | 0.418 | 0.346 | 0.236 | 0.062 | 0.206 | 0.036 | 0.836 | 0.793 | 0.591 |
| Dual supreme courts with cross-checking invalidations | equality | 6774 | 1.000 | 0.021 | 0.751 | 0.019 | 0.891 | 0.135 | 0.745 | 2.284 | 0.535 | 0.481 | 0.414 | 0.334 | 0.244 | 0.077 | 0.205 | 0.031 | 0.848 | 0.799 | 0.587 |
| Dual supreme courts with cross-checking invalidations | federalism | 6845 | 1.000 | 0.021 | 0.760 | 0.005 | 0.888 | 0.079 | 0.032 | 2.767 | 0.768 | 0.601 | 0.432 | 0.361 | 0.209 | 0.050 | 0.158 | 0.038 | 0.824 | 0.782 | 0.609 |
| Dual supreme courts with cross-checking invalidations | speech | 6800 | 1.000 | 0.021 | 0.739 | 0.016 | 0.874 | 0.125 | 0.584 | 2.238 | 0.467 | 0.467 | 0.429 | 0.341 | 0.235 | 0.067 | 0.227 | 0.035 | 0.845 | 0.801 | 0.585 |
| Pre-enactment constitutional council | administrative_state | 6924 | 1.000 | 0.020 | 0.745 | 0.108 | 0.709 | 0.193 | 0.022 | 2.701 | 0.486 | 0.529 | 0.426 | 0.374 | 0.280 | 0.042 | 0.239 | 0.038 | 0.808 | 0.763 | 0.547 |
| Pre-enactment constitutional council | criminal_procedure | 6872 | 1.000 | 0.021 | 0.715 | 0.141 | 0.735 | 0.264 | 0.583 | 2.334 | 0.581 | 0.507 | 0.405 | 0.328 | 0.226 | 0.065 | 0.185 | 0.035 | 0.812 | 0.760 | 0.534 |
| Pre-enactment constitutional council | election_law | 6946 | 1.000 | 0.023 | 0.715 | 0.118 | 0.780 | 0.296 | 0.604 | 2.725 | 0.680 | 0.529 | 0.388 | 0.319 | 0.236 | 0.069 | 0.156 | 0.031 | 0.820 | 0.769 | 0.545 |
| Pre-enactment constitutional council | emergency_powers | 6839 | 1.000 | 0.022 | 0.713 | 0.184 | 0.768 | 0.264 | 0.256 | 1.986 | 0.548 | 0.506 | 0.405 | 0.340 | 0.226 | 0.056 | 0.207 | 0.036 | 0.812 | 0.760 | 0.535 |
| Pre-enactment constitutional council | equality | 6774 | 1.000 | 0.021 | 0.732 | 0.131 | 0.788 | 0.258 | 0.754 | 2.284 | 0.535 | 0.481 | 0.401 | 0.341 | 0.238 | 0.073 | 0.201 | 0.032 | 0.820 | 0.766 | 0.531 |
| Pre-enactment constitutional council | federalism | 6845 | 1.000 | 0.022 | 0.757 | 0.109 | 0.721 | 0.214 | 0.041 | 2.767 | 0.768 | 0.601 | 0.424 | 0.348 | 0.207 | 0.049 | 0.151 | 0.039 | 0.798 | 0.747 | 0.553 |
| Pre-enactment constitutional council | speech | 6800 | 1.000 | 0.021 | 0.721 | 0.126 | 0.757 | 0.287 | 0.606 | 2.238 | 0.467 | 0.467 | 0.418 | 0.343 | 0.230 | 0.056 | 0.219 | 0.035 | 0.819 | 0.768 | 0.528 |
| Judicial review with delayed legislative override | administrative_state | 6924 | 1.000 | 0.020 | 0.745 | 0.116 | 0.614 | 0.234 | 0.136 | 2.701 | 0.486 | 0.529 | 0.399 | 0.327 | 0.313 | 0.054 | 0.196 | 0.028 | 0.904 | 0.860 | 0.480 |
| Judicial review with delayed legislative override | criminal_procedure | 6872 | 1.000 | 0.021 | 0.709 | 0.148 | 0.643 | 0.321 | 0.724 | 2.334 | 0.581 | 0.507 | 0.352 | 0.285 | 0.264 | 0.070 | 0.142 | 0.025 | 0.910 | 0.860 | 0.467 |
| Judicial review with delayed legislative override | election_law | 6946 | 1.000 | 0.023 | 0.700 | 0.127 | 0.704 | 0.308 | 0.776 | 2.725 | 0.680 | 0.529 | 0.339 | 0.273 | 0.281 | 0.079 | 0.117 | 0.022 | 0.918 | 0.869 | 0.478 |
| Judicial review with delayed legislative override | emergency_powers | 6839 | 1.000 | 0.022 | 0.709 | 0.202 | 0.683 | 0.319 | 0.476 | 1.986 | 0.548 | 0.506 | 0.363 | 0.287 | 0.266 | 0.062 | 0.166 | 0.026 | 0.908 | 0.859 | 0.468 |
| Judicial review with delayed legislative override | equality | 6774 | 1.000 | 0.022 | 0.723 | 0.140 | 0.692 | 0.303 | 0.854 | 2.284 | 0.535 | 0.481 | 0.366 | 0.297 | 0.268 | 0.078 | 0.149 | 0.023 | 0.914 | 0.863 | 0.464 |
| Judicial review with delayed legislative override | federalism | 6845 | 1.000 | 0.022 | 0.751 | 0.121 | 0.631 | 0.285 | 0.191 | 2.767 | 0.768 | 0.601 | 0.379 | 0.299 | 0.240 | 0.056 | 0.116 | 0.028 | 0.901 | 0.853 | 0.485 |
| Judicial review with delayed legislative override | speech | 6800 | 1.000 | 0.021 | 0.716 | 0.134 | 0.663 | 0.307 | 0.744 | 2.238 | 0.467 | 0.467 | 0.370 | 0.297 | 0.253 | 0.071 | 0.177 | 0.026 | 0.912 | 0.862 | 0.461 |
| Retention-election accountability court | administrative_state | 6924 | 1.000 | 0.020 | 0.745 | 0.113 | 0.662 | 0.177 | 0.033 | 2.701 | 0.486 | 0.529 | 0.408 | 0.340 | 0.303 | 0.052 | 0.206 | 0.034 | 0.839 | 0.783 | 0.495 |
| Retention-election accountability court | criminal_procedure | 6872 | 1.000 | 0.021 | 0.702 | 0.135 | 0.654 | 0.301 | 0.554 | 2.334 | 0.581 | 0.507 | 0.372 | 0.305 | 0.239 | 0.070 | 0.166 | 0.030 | 0.841 | 0.780 | 0.482 |
| Retention-election accountability court | election_law | 6946 | 1.000 | 0.023 | 0.703 | 0.111 | 0.724 | 0.301 | 0.581 | 2.725 | 0.680 | 0.529 | 0.368 | 0.286 | 0.244 | 0.066 | 0.123 | 0.027 | 0.850 | 0.790 | 0.493 |
| Retention-election accountability court | emergency_powers | 6839 | 1.000 | 0.022 | 0.712 | 0.179 | 0.703 | 0.276 | 0.241 | 1.986 | 0.548 | 0.506 | 0.379 | 0.329 | 0.219 | 0.055 | 0.181 | 0.032 | 0.840 | 0.779 | 0.483 |
| Retention-election accountability court | equality | 6774 | 1.000 | 0.021 | 0.715 | 0.129 | 0.701 | 0.279 | 0.736 | 2.284 | 0.535 | 0.481 | 0.362 | 0.304 | 0.252 | 0.072 | 0.178 | 0.027 | 0.851 | 0.787 | 0.479 |
| Retention-election accountability court | federalism | 6845 | 1.000 | 0.022 | 0.758 | 0.112 | 0.636 | 0.209 | 0.043 | 2.767 | 0.768 | 0.601 | 0.393 | 0.334 | 0.219 | 0.047 | 0.137 | 0.034 | 0.831 | 0.770 | 0.501 |
| Retention-election accountability court | speech | 6800 | 1.000 | 0.021 | 0.705 | 0.123 | 0.681 | 0.312 | 0.578 | 2.238 | 0.467 | 0.467 | 0.374 | 0.316 | 0.233 | 0.068 | 0.193 | 0.031 | 0.846 | 0.785 | 0.476 |
| Hybrid court balancing independence and accountability | administrative_state | 6924 | 1.000 | 0.020 | 0.747 | 0.001 | 0.848 | 0.066 | 0.029 | 2.701 | 0.486 | 0.529 | 0.443 | 0.378 | 0.275 | 0.051 | 0.226 | 0.039 | 0.828 | 0.806 | 0.559 |
| Hybrid court balancing independence and accountability | criminal_procedure | 6872 | 1.000 | 0.021 | 0.736 | 0.009 | 0.863 | 0.115 | 0.604 | 2.334 | 0.581 | 0.507 | 0.421 | 0.347 | 0.244 | 0.071 | 0.183 | 0.034 | 0.839 | 0.810 | 0.540 |
| Hybrid court balancing independence and accountability | election_law | 6946 | 1.000 | 0.023 | 0.725 | 0.014 | 0.893 | 0.126 | 0.650 | 2.725 | 0.680 | 0.529 | 0.397 | 0.329 | 0.236 | 0.080 | 0.150 | 0.030 | 0.844 | 0.815 | 0.563 |
| Hybrid court balancing independence and accountability | emergency_powers | 6839 | 1.000 | 0.022 | 0.723 | 0.025 | 0.884 | 0.164 | 0.296 | 1.986 | 0.548 | 0.506 | 0.410 | 0.341 | 0.237 | 0.065 | 0.205 | 0.036 | 0.831 | 0.805 | 0.550 |
| Hybrid court balancing independence and accountability | equality | 6774 | 1.000 | 0.021 | 0.749 | 0.015 | 0.900 | 0.095 | 0.784 | 2.284 | 0.535 | 0.481 | 0.416 | 0.343 | 0.251 | 0.081 | 0.196 | 0.031 | 0.844 | 0.810 | 0.539 |
| Hybrid court balancing independence and accountability | federalism | 6845 | 1.000 | 0.021 | 0.759 | 0.002 | 0.895 | 0.085 | 0.045 | 2.767 | 0.768 | 0.601 | 0.429 | 0.355 | 0.212 | 0.052 | 0.148 | 0.039 | 0.822 | 0.795 | 0.569 |
| Hybrid court balancing independence and accountability | speech | 6800 | 1.000 | 0.021 | 0.737 | 0.011 | 0.881 | 0.121 | 0.636 | 2.238 | 0.467 | 0.467 | 0.427 | 0.348 | 0.243 | 0.075 | 0.218 | 0.035 | 0.840 | 0.811 | 0.532 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 4376 | 1.000 | 0.022 | 0.684 | 0.464 | 0.024 | 0.559 | 0.320 | 3.000 | 0.406 | 0.495 | 0.308 | 0.231 | 0.321 | 0.053 | 0.184 | 0.018 | 0.957 | 0.903 | 0.464 |
| Current-style federal supreme court | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.675 | 0.492 | 0.028 | 0.568 | 0.440 | 2.000 | 0.426 | 0.455 | 0.308 | 0.223 | 0.298 | 0.064 | 0.172 | 0.017 | 0.955 | 0.899 | 0.443 |
| Current-style federal supreme court | federal/district_only | 2694 | 1.000 | 0.021 | 0.668 | 0.554 | 0.024 | 0.618 | 0.459 | 1.000 | 0.427 | 0.431 | 0.293 | 0.222 | 0.287 | 0.061 | 0.159 | 0.018 | 0.954 | 0.894 | 0.424 |
| Current-style federal supreme court | federal/state_federal_split | 1044 | 1.000 | 0.023 | 0.661 | 0.470 | 0.023 | 0.574 | 0.398 | 3.000 | 0.550 | 0.533 | 0.287 | 0.193 | 0.281 | 0.056 | 0.135 | 0.015 | 0.959 | 0.905 | 0.468 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.023 | 0.656 | 0.494 | 0.020 | 0.577 | 0.413 | 3.000 | 0.777 | 0.580 | 0.270 | 0.190 | 0.335 | 0.062 | 0.043 | 0.013 | 0.962 | 0.910 | 0.469 |
| Current-style federal supreme court | mixed_state_federal/district_only | 588 | 1.000 | 0.023 | 0.624 | 0.693 | 0.038 | 0.649 | 0.445 | 1.000 | 0.756 | 0.520 | 0.245 | 0.168 | 0.320 | 0.075 | 0.027 | 0.015 | 0.963 | 0.901 | 0.434 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.646 | 0.480 | 0.025 | 0.562 | 0.526 | 3.000 | 0.800 | 0.600 | 0.258 | 0.196 | 0.307 | 0.068 | 0.043 | 0.015 | 0.960 | 0.902 | 0.470 |
| Current-style federal supreme court | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.710 | 0.386 | 0.019 | 0.452 | 0.077 | 3.000 | 0.490 | 0.532 | 0.307 | 0.243 | 0.340 | 0.057 | 0.118 | 0.013 | 0.961 | 0.908 | 0.468 |
| Current-style federal supreme court | state/circuit_panel | 2893 | 1.000 | 0.022 | 0.673 | 0.484 | 0.027 | 0.575 | 0.446 | 2.000 | 0.586 | 0.494 | 0.292 | 0.218 | 0.286 | 0.058 | 0.081 | 0.014 | 0.959 | 0.902 | 0.445 |
| Current-style federal supreme court | state/district_only | 609 | 1.000 | 0.022 | 0.647 | 0.672 | 0.017 | 0.666 | 0.322 | 1.000 | 0.554 | 0.476 | 0.253 | 0.179 | 0.304 | 0.064 | 0.066 | 0.018 | 0.961 | 0.907 | 0.432 |
| Current-style federal supreme court | state/state_federal_split | 6569 | 1.000 | 0.023 | 0.651 | 0.477 | 0.026 | 0.559 | 0.487 | 3.000 | 0.612 | 0.551 | 0.281 | 0.204 | 0.301 | 0.073 | 0.069 | 0.015 | 0.959 | 0.903 | 0.468 |
| Current-style federal supreme court | state/state_high_court | 6361 | 1.000 | 0.022 | 0.664 | 0.489 | 0.028 | 0.574 | 0.522 | 2.000 | 0.563 | 0.495 | 0.281 | 0.205 | 0.296 | 0.061 | 0.087 | 0.015 | 0.960 | 0.904 | 0.446 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 4376 | 1.000 | 0.022 | 0.691 | 0.463 | 0.031 | 0.542 | 0.288 | 3.000 | 0.406 | 0.495 | 0.316 | 0.236 | 0.328 | 0.059 | 0.184 | 0.018 | 0.954 | 0.896 | 0.469 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.680 | 0.487 | 0.037 | 0.570 | 0.418 | 2.000 | 0.426 | 0.455 | 0.304 | 0.233 | 0.293 | 0.057 | 0.170 | 0.018 | 0.951 | 0.892 | 0.448 |
| Staggered 18-year nonrenewable terms | federal/district_only | 2694 | 1.000 | 0.021 | 0.675 | 0.555 | 0.039 | 0.586 | 0.434 | 1.000 | 0.427 | 0.431 | 0.297 | 0.213 | 0.271 | 0.071 | 0.174 | 0.019 | 0.949 | 0.886 | 0.429 |
| Staggered 18-year nonrenewable terms | federal/state_federal_split | 1044 | 1.000 | 0.023 | 0.670 | 0.458 | 0.025 | 0.557 | 0.350 | 3.000 | 0.550 | 0.533 | 0.282 | 0.211 | 0.283 | 0.077 | 0.134 | 0.016 | 0.954 | 0.897 | 0.473 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.023 | 0.667 | 0.484 | 0.035 | 0.572 | 0.369 | 3.000 | 0.777 | 0.580 | 0.273 | 0.193 | 0.320 | 0.069 | 0.045 | 0.014 | 0.959 | 0.904 | 0.474 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/district_only | 588 | 1.000 | 0.023 | 0.634 | 0.668 | 0.035 | 0.660 | 0.428 | 1.000 | 0.756 | 0.520 | 0.241 | 0.170 | 0.301 | 0.068 | 0.041 | 0.015 | 0.958 | 0.893 | 0.438 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.654 | 0.482 | 0.036 | 0.565 | 0.489 | 3.000 | 0.800 | 0.600 | 0.263 | 0.198 | 0.302 | 0.068 | 0.046 | 0.016 | 0.957 | 0.896 | 0.475 |
| Staggered 18-year nonrenewable terms | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.722 | 0.377 | 0.048 | 0.515 | 0.053 | 3.000 | 0.490 | 0.532 | 0.318 | 0.257 | 0.344 | 0.054 | 0.123 | 0.013 | 0.957 | 0.904 | 0.473 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 2893 | 1.000 | 0.022 | 0.680 | 0.477 | 0.034 | 0.557 | 0.409 | 2.000 | 0.586 | 0.494 | 0.290 | 0.225 | 0.298 | 0.065 | 0.076 | 0.015 | 0.956 | 0.896 | 0.450 |
| Staggered 18-year nonrenewable terms | state/district_only | 609 | 1.000 | 0.022 | 0.659 | 0.668 | 0.047 | 0.667 | 0.274 | 1.000 | 0.554 | 0.476 | 0.309 | 0.199 | 0.287 | 0.044 | 0.079 | 0.019 | 0.958 | 0.903 | 0.437 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 6569 | 1.000 | 0.023 | 0.661 | 0.471 | 0.035 | 0.554 | 0.463 | 3.000 | 0.612 | 0.551 | 0.286 | 0.208 | 0.297 | 0.068 | 0.074 | 0.016 | 0.956 | 0.899 | 0.473 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 6361 | 1.000 | 0.022 | 0.670 | 0.489 | 0.038 | 0.569 | 0.477 | 2.000 | 0.563 | 0.495 | 0.286 | 0.213 | 0.288 | 0.066 | 0.085 | 0.016 | 0.956 | 0.898 | 0.450 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.733 | 0.133 | 0.661 | 0.259 | 0.417 | 3.000 | 0.406 | 0.495 | 0.393 | 0.320 | 0.279 | 0.058 | 0.256 | 0.029 | 0.895 | 0.851 | 0.485 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.733 | 0.134 | 0.680 | 0.287 | 0.554 | 2.000 | 0.426 | 0.455 | 0.394 | 0.319 | 0.249 | 0.063 | 0.245 | 0.029 | 0.891 | 0.844 | 0.464 |
| Fifteen-justice supermajority commission court | federal/district_only | 2694 | 1.000 | 0.020 | 0.729 | 0.159 | 0.671 | 0.293 | 0.517 | 1.000 | 0.427 | 0.431 | 0.391 | 0.320 | 0.251 | 0.071 | 0.245 | 0.031 | 0.889 | 0.839 | 0.446 |
| Fifteen-justice supermajority commission court | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.734 | 0.126 | 0.708 | 0.247 | 0.503 | 3.000 | 0.550 | 0.533 | 0.414 | 0.313 | 0.230 | 0.062 | 0.217 | 0.027 | 0.893 | 0.848 | 0.489 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.726 | 0.141 | 0.680 | 0.301 | 0.507 | 3.000 | 0.777 | 0.580 | 0.343 | 0.284 | 0.281 | 0.067 | 0.091 | 0.023 | 0.905 | 0.861 | 0.490 |
| Fifteen-justice supermajority commission court | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.711 | 0.196 | 0.736 | 0.290 | 0.422 | 1.000 | 0.756 | 0.520 | 0.366 | 0.270 | 0.265 | 0.068 | 0.100 | 0.025 | 0.897 | 0.845 | 0.455 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.719 | 0.137 | 0.677 | 0.281 | 0.635 | 3.000 | 0.800 | 0.600 | 0.354 | 0.278 | 0.270 | 0.073 | 0.085 | 0.026 | 0.903 | 0.852 | 0.491 |
| Fifteen-justice supermajority commission court | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.749 | 0.115 | 0.558 | 0.294 | 0.087 | 3.000 | 0.490 | 0.532 | 0.363 | 0.325 | 0.300 | 0.045 | 0.172 | 0.026 | 0.898 | 0.855 | 0.489 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.733 | 0.133 | 0.670 | 0.303 | 0.541 | 2.000 | 0.586 | 0.494 | 0.385 | 0.312 | 0.244 | 0.057 | 0.150 | 0.026 | 0.899 | 0.849 | 0.466 |
| Fifteen-justice supermajority commission court | state/district_only | 609 | 1.000 | 0.022 | 0.717 | 0.200 | 0.667 | 0.288 | 0.345 | 1.000 | 0.554 | 0.476 | 0.397 | 0.322 | 0.248 | 0.062 | 0.159 | 0.028 | 0.898 | 0.856 | 0.454 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.722 | 0.134 | 0.683 | 0.294 | 0.598 | 3.000 | 0.612 | 0.551 | 0.367 | 0.300 | 0.253 | 0.070 | 0.120 | 0.027 | 0.900 | 0.855 | 0.489 |
| Fifteen-justice supermajority commission court | state/state_high_court | 6361 | 1.000 | 0.021 | 0.725 | 0.138 | 0.643 | 0.299 | 0.633 | 2.000 | 0.563 | 0.495 | 0.379 | 0.304 | 0.245 | 0.068 | 0.135 | 0.026 | 0.899 | 0.852 | 0.467 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.729 | 0.140 | 0.627 | 0.290 | 0.386 | 3.000 | 0.406 | 0.495 | 0.392 | 0.309 | 0.280 | 0.066 | 0.232 | 0.028 | 0.900 | 0.858 | 0.472 |
| Supermajority required to invalidate laws | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.726 | 0.140 | 0.651 | 0.310 | 0.518 | 2.000 | 0.426 | 0.455 | 0.391 | 0.318 | 0.253 | 0.061 | 0.237 | 0.028 | 0.898 | 0.853 | 0.451 |
| Supermajority required to invalidate laws | federal/district_only | 2694 | 1.000 | 0.020 | 0.722 | 0.165 | 0.634 | 0.340 | 0.484 | 1.000 | 0.427 | 0.431 | 0.382 | 0.313 | 0.248 | 0.060 | 0.241 | 0.031 | 0.895 | 0.845 | 0.432 |
| Supermajority required to invalidate laws | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.730 | 0.128 | 0.635 | 0.355 | 0.487 | 3.000 | 0.550 | 0.533 | 0.379 | 0.307 | 0.250 | 0.057 | 0.238 | 0.026 | 0.900 | 0.858 | 0.475 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.721 | 0.145 | 0.626 | 0.361 | 0.486 | 3.000 | 0.777 | 0.580 | 0.344 | 0.274 | 0.286 | 0.071 | 0.087 | 0.022 | 0.909 | 0.866 | 0.476 |
| Supermajority required to invalidate laws | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.700 | 0.201 | 0.711 | 0.385 | 0.413 | 1.000 | 0.756 | 0.520 | 0.337 | 0.287 | 0.289 | 0.048 | 0.077 | 0.023 | 0.901 | 0.849 | 0.441 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.714 | 0.145 | 0.637 | 0.317 | 0.621 | 3.000 | 0.800 | 0.600 | 0.343 | 0.266 | 0.274 | 0.066 | 0.078 | 0.025 | 0.909 | 0.859 | 0.478 |
| Supermajority required to invalidate laws | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.746 | 0.116 | 0.659 | 0.192 | 0.033 | 3.000 | 0.490 | 0.532 | 0.420 | 0.340 | 0.297 | 0.057 | 0.198 | 0.025 | 0.903 | 0.860 | 0.476 |
| Supermajority required to invalidate laws | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.727 | 0.141 | 0.632 | 0.336 | 0.506 | 2.000 | 0.586 | 0.494 | 0.373 | 0.299 | 0.262 | 0.064 | 0.125 | 0.025 | 0.905 | 0.855 | 0.453 |
| Supermajority required to invalidate laws | state/district_only | 609 | 1.000 | 0.022 | 0.707 | 0.211 | 0.633 | 0.326 | 0.331 | 1.000 | 0.554 | 0.476 | 0.369 | 0.304 | 0.215 | 0.072 | 0.144 | 0.026 | 0.906 | 0.864 | 0.440 |
| Supermajority required to invalidate laws | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.717 | 0.135 | 0.648 | 0.304 | 0.580 | 3.000 | 0.612 | 0.551 | 0.377 | 0.284 | 0.266 | 0.067 | 0.122 | 0.025 | 0.905 | 0.860 | 0.475 |
| Supermajority required to invalidate laws | state/state_high_court | 6361 | 1.000 | 0.021 | 0.721 | 0.146 | 0.650 | 0.329 | 0.610 | 2.000 | 0.563 | 0.495 | 0.377 | 0.307 | 0.259 | 0.070 | 0.141 | 0.024 | 0.903 | 0.857 | 0.453 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.734 | 0.133 | 0.687 | 0.258 | 0.398 | 3.000 | 0.406 | 0.495 | 0.400 | 0.337 | 0.266 | 0.056 | 0.252 | 0.032 | 0.879 | 0.836 | 0.491 |
| Strict recusal with substitute justices | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.732 | 0.131 | 0.734 | 0.271 | 0.537 | 2.000 | 0.426 | 0.455 | 0.403 | 0.333 | 0.247 | 0.062 | 0.247 | 0.030 | 0.878 | 0.832 | 0.470 |
| Strict recusal with substitute justices | federal/district_only | 2694 | 1.000 | 0.020 | 0.729 | 0.155 | 0.719 | 0.267 | 0.500 | 1.000 | 0.427 | 0.431 | 0.392 | 0.308 | 0.242 | 0.057 | 0.254 | 0.033 | 0.878 | 0.826 | 0.451 |
| Strict recusal with substitute justices | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.735 | 0.122 | 0.730 | 0.289 | 0.492 | 3.000 | 0.550 | 0.533 | 0.367 | 0.322 | 0.215 | 0.079 | 0.250 | 0.028 | 0.881 | 0.840 | 0.495 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.727 | 0.135 | 0.697 | 0.286 | 0.486 | 3.000 | 0.777 | 0.580 | 0.367 | 0.301 | 0.265 | 0.061 | 0.092 | 0.025 | 0.891 | 0.848 | 0.495 |
| Strict recusal with substitute justices | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.711 | 0.195 | 0.733 | 0.332 | 0.399 | 1.000 | 0.756 | 0.520 | 0.389 | 0.298 | 0.236 | 0.061 | 0.104 | 0.027 | 0.878 | 0.826 | 0.460 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.720 | 0.136 | 0.698 | 0.297 | 0.618 | 3.000 | 0.800 | 0.600 | 0.361 | 0.291 | 0.266 | 0.069 | 0.087 | 0.027 | 0.891 | 0.841 | 0.497 |
| Strict recusal with substitute justices | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.749 | 0.117 | 0.703 | 0.229 | 0.036 | 3.000 | 0.490 | 0.532 | 0.394 | 0.333 | 0.300 | 0.050 | 0.208 | 0.027 | 0.885 | 0.844 | 0.495 |
| Strict recusal with substitute justices | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.732 | 0.131 | 0.723 | 0.272 | 0.519 | 2.000 | 0.586 | 0.494 | 0.396 | 0.321 | 0.250 | 0.060 | 0.146 | 0.028 | 0.886 | 0.837 | 0.472 |
| Strict recusal with substitute justices | state/district_only | 609 | 1.000 | 0.022 | 0.718 | 0.196 | 0.724 | 0.304 | 0.336 | 1.000 | 0.554 | 0.476 | 0.383 | 0.299 | 0.256 | 0.069 | 0.156 | 0.029 | 0.885 | 0.840 | 0.459 |
| Strict recusal with substitute justices | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.724 | 0.127 | 0.703 | 0.264 | 0.578 | 3.000 | 0.612 | 0.551 | 0.361 | 0.308 | 0.262 | 0.069 | 0.130 | 0.028 | 0.887 | 0.841 | 0.494 |
| Strict recusal with substitute justices | state/state_high_court | 6361 | 1.000 | 0.021 | 0.726 | 0.137 | 0.712 | 0.292 | 0.617 | 2.000 | 0.563 | 0.495 | 0.375 | 0.308 | 0.261 | 0.068 | 0.140 | 0.027 | 0.886 | 0.840 | 0.472 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.741 | 0.009 | 0.886 | 0.120 | 0.371 | 3.000 | 0.406 | 0.495 | 0.422 | 0.341 | 0.270 | 0.071 | 0.275 | 0.033 | 0.884 | 0.856 | 0.475 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 10083 | 1.000 | 0.020 | 0.741 | 0.013 | 0.877 | 0.141 | 0.522 | 2.000 | 0.426 | 0.455 | 0.421 | 0.348 | 0.241 | 0.072 | 0.268 | 0.032 | 0.883 | 0.853 | 0.454 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 2694 | 1.000 | 0.020 | 0.739 | 0.017 | 0.865 | 0.140 | 0.515 | 1.000 | 0.427 | 0.431 | 0.431 | 0.353 | 0.237 | 0.067 | 0.268 | 0.034 | 0.881 | 0.846 | 0.435 |
| Reasoned emergency orders with merits follow-up | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.738 | 0.009 | 0.854 | 0.110 | 0.469 | 3.000 | 0.550 | 0.533 | 0.432 | 0.338 | 0.253 | 0.064 | 0.230 | 0.031 | 0.883 | 0.854 | 0.479 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.733 | 0.011 | 0.884 | 0.137 | 0.474 | 3.000 | 0.777 | 0.580 | 0.376 | 0.328 | 0.263 | 0.071 | 0.098 | 0.026 | 0.897 | 0.868 | 0.480 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.717 | 0.028 | 0.896 | 0.184 | 0.474 | 1.000 | 0.756 | 0.520 | 0.406 | 0.310 | 0.259 | 0.080 | 0.092 | 0.027 | 0.893 | 0.855 | 0.445 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.022 | 0.727 | 0.012 | 0.865 | 0.124 | 0.606 | 3.000 | 0.800 | 0.600 | 0.386 | 0.311 | 0.264 | 0.079 | 0.093 | 0.028 | 0.896 | 0.859 | 0.481 |
| Reasoned emergency orders with merits follow-up | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.748 | 0.002 | 0.755 | 0.111 | 0.083 | 3.000 | 0.490 | 0.532 | 0.399 | 0.384 | 0.281 | 0.061 | 0.182 | 0.031 | 0.888 | 0.862 | 0.479 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.741 | 0.011 | 0.877 | 0.137 | 0.514 | 2.000 | 0.586 | 0.494 | 0.398 | 0.337 | 0.255 | 0.067 | 0.152 | 0.029 | 0.891 | 0.858 | 0.456 |
| Reasoned emergency orders with merits follow-up | state/district_only | 609 | 1.000 | 0.021 | 0.725 | 0.027 | 0.873 | 0.167 | 0.373 | 1.000 | 0.554 | 0.476 | 0.386 | 0.333 | 0.253 | 0.064 | 0.167 | 0.031 | 0.889 | 0.862 | 0.443 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.730 | 0.011 | 0.854 | 0.116 | 0.578 | 3.000 | 0.612 | 0.551 | 0.400 | 0.323 | 0.254 | 0.073 | 0.141 | 0.029 | 0.893 | 0.860 | 0.479 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 6361 | 1.000 | 0.021 | 0.738 | 0.012 | 0.881 | 0.126 | 0.612 | 2.000 | 0.563 | 0.495 | 0.417 | 0.323 | 0.255 | 0.075 | 0.156 | 0.028 | 0.892 | 0.860 | 0.456 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.734 | 0.133 | 0.684 | 0.271 | 0.415 | 3.000 | 0.406 | 0.495 | 0.393 | 0.335 | 0.271 | 0.059 | 0.245 | 0.030 | 0.893 | 0.850 | 0.529 |
| Panel review with en banc safety valve | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.732 | 0.135 | 0.703 | 0.261 | 0.563 | 2.000 | 0.426 | 0.455 | 0.405 | 0.323 | 0.255 | 0.062 | 0.243 | 0.029 | 0.890 | 0.844 | 0.501 |
| Panel review with en banc safety valve | federal/district_only | 2694 | 1.000 | 0.020 | 0.729 | 0.154 | 0.716 | 0.283 | 0.539 | 1.000 | 0.427 | 0.431 | 0.409 | 0.327 | 0.241 | 0.061 | 0.237 | 0.032 | 0.890 | 0.839 | 0.480 |
| Panel review with en banc safety valve | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.734 | 0.123 | 0.700 | 0.205 | 0.504 | 3.000 | 0.550 | 0.533 | 0.380 | 0.319 | 0.249 | 0.068 | 0.232 | 0.028 | 0.893 | 0.849 | 0.538 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.726 | 0.138 | 0.691 | 0.258 | 0.512 | 3.000 | 0.777 | 0.580 | 0.361 | 0.294 | 0.286 | 0.065 | 0.092 | 0.024 | 0.904 | 0.861 | 0.537 |
| Panel review with en banc safety valve | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.713 | 0.195 | 0.741 | 0.293 | 0.454 | 1.000 | 0.756 | 0.520 | 0.325 | 0.281 | 0.247 | 0.065 | 0.078 | 0.025 | 0.894 | 0.844 | 0.499 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.719 | 0.139 | 0.696 | 0.284 | 0.631 | 3.000 | 0.800 | 0.600 | 0.350 | 0.281 | 0.267 | 0.071 | 0.078 | 0.026 | 0.901 | 0.851 | 0.539 |
| Panel review with en banc safety valve | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.749 | 0.116 | 0.610 | 0.138 | 0.036 | 3.000 | 0.490 | 0.532 | 0.396 | 0.323 | 0.328 | 0.057 | 0.167 | 0.027 | 0.897 | 0.855 | 0.535 |
| Panel review with en banc safety valve | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.734 | 0.130 | 0.698 | 0.263 | 0.553 | 2.000 | 0.586 | 0.494 | 0.394 | 0.309 | 0.247 | 0.063 | 0.133 | 0.028 | 0.896 | 0.847 | 0.506 |
| Panel review with en banc safety valve | state/district_only | 609 | 1.000 | 0.022 | 0.716 | 0.198 | 0.713 | 0.324 | 0.345 | 1.000 | 0.554 | 0.476 | 0.399 | 0.296 | 0.256 | 0.059 | 0.141 | 0.028 | 0.897 | 0.854 | 0.496 |
| Panel review with en banc safety valve | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.724 | 0.129 | 0.686 | 0.284 | 0.593 | 3.000 | 0.612 | 0.551 | 0.368 | 0.295 | 0.263 | 0.061 | 0.125 | 0.027 | 0.899 | 0.853 | 0.536 |
| Panel review with en banc safety valve | state/state_high_court | 6361 | 1.000 | 0.021 | 0.726 | 0.139 | 0.706 | 0.290 | 0.642 | 2.000 | 0.563 | 0.495 | 0.387 | 0.299 | 0.254 | 0.070 | 0.142 | 0.027 | 0.898 | 0.851 | 0.506 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.743 | 0.013 | 0.854 | 0.120 | 0.269 | 3.000 | 0.406 | 0.495 | 0.441 | 0.362 | 0.251 | 0.059 | 0.296 | 0.038 | 0.832 | 0.795 | 0.604 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 10083 | 1.000 | 0.020 | 0.742 | 0.017 | 0.889 | 0.128 | 0.411 | 2.000 | 0.426 | 0.455 | 0.438 | 0.365 | 0.230 | 0.064 | 0.275 | 0.037 | 0.831 | 0.789 | 0.583 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 2694 | 1.000 | 0.020 | 0.737 | 0.023 | 0.899 | 0.154 | 0.391 | 1.000 | 0.427 | 0.431 | 0.441 | 0.365 | 0.235 | 0.058 | 0.288 | 0.039 | 0.831 | 0.784 | 0.565 |
| Dual supreme courts with cross-checking invalidations | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.746 | 0.013 | 0.879 | 0.174 | 0.339 | 3.000 | 0.550 | 0.533 | 0.436 | 0.323 | 0.242 | 0.056 | 0.267 | 0.035 | 0.835 | 0.793 | 0.608 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.740 | 0.015 | 0.853 | 0.142 | 0.344 | 3.000 | 0.777 | 0.580 | 0.408 | 0.345 | 0.252 | 0.061 | 0.116 | 0.031 | 0.848 | 0.808 | 0.609 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.718 | 0.034 | 0.884 | 0.220 | 0.255 | 1.000 | 0.756 | 0.520 | 0.389 | 0.352 | 0.241 | 0.071 | 0.128 | 0.034 | 0.836 | 0.781 | 0.574 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.022 | 0.740 | 0.015 | 0.862 | 0.142 | 0.469 | 3.000 | 0.800 | 0.600 | 0.397 | 0.328 | 0.246 | 0.068 | 0.111 | 0.033 | 0.846 | 0.799 | 0.610 |
| Dual supreme courts with cross-checking invalidations | state/circuit_en_banc | 424 | 1.000 | 0.020 | 0.748 | 0.005 | 0.844 | 0.055 | 0.012 | 3.000 | 0.490 | 0.532 | 0.476 | 0.368 | 0.250 | 0.040 | 0.186 | 0.034 | 0.838 | 0.804 | 0.609 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.744 | 0.015 | 0.867 | 0.144 | 0.388 | 2.000 | 0.586 | 0.494 | 0.414 | 0.349 | 0.224 | 0.059 | 0.174 | 0.034 | 0.839 | 0.794 | 0.585 |
| Dual supreme courts with cross-checking invalidations | state/district_only | 609 | 1.000 | 0.021 | 0.720 | 0.033 | 0.865 | 0.135 | 0.197 | 1.000 | 0.554 | 0.476 | 0.396 | 0.328 | 0.227 | 0.061 | 0.156 | 0.034 | 0.850 | 0.807 | 0.573 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.741 | 0.015 | 0.884 | 0.124 | 0.445 | 3.000 | 0.612 | 0.551 | 0.424 | 0.342 | 0.241 | 0.068 | 0.155 | 0.033 | 0.844 | 0.801 | 0.608 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 6361 | 1.000 | 0.021 | 0.742 | 0.016 | 0.848 | 0.100 | 0.486 | 2.000 | 0.563 | 0.495 | 0.425 | 0.345 | 0.234 | 0.069 | 0.174 | 0.033 | 0.840 | 0.796 | 0.586 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.733 | 0.127 | 0.726 | 0.245 | 0.315 | 3.000 | 0.406 | 0.495 | 0.422 | 0.361 | 0.260 | 0.055 | 0.282 | 0.037 | 0.806 | 0.759 | 0.548 |
| Pre-enactment constitutional council | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.730 | 0.129 | 0.759 | 0.258 | 0.442 | 2.000 | 0.426 | 0.455 | 0.432 | 0.356 | 0.225 | 0.051 | 0.287 | 0.038 | 0.805 | 0.755 | 0.527 |
| Pre-enactment constitutional council | federal/district_only | 2694 | 1.000 | 0.020 | 0.723 | 0.148 | 0.780 | 0.268 | 0.401 | 1.000 | 0.427 | 0.431 | 0.425 | 0.365 | 0.222 | 0.061 | 0.262 | 0.039 | 0.807 | 0.751 | 0.508 |
| Pre-enactment constitutional council | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.740 | 0.118 | 0.792 | 0.261 | 0.405 | 3.000 | 0.550 | 0.533 | 0.426 | 0.321 | 0.244 | 0.055 | 0.261 | 0.035 | 0.805 | 0.756 | 0.552 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.730 | 0.131 | 0.731 | 0.254 | 0.372 | 3.000 | 0.777 | 0.580 | 0.390 | 0.317 | 0.246 | 0.064 | 0.119 | 0.031 | 0.823 | 0.776 | 0.553 |
| Pre-enactment constitutional council | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.709 | 0.180 | 0.793 | 0.226 | 0.243 | 1.000 | 0.756 | 0.520 | 0.379 | 0.345 | 0.197 | 0.053 | 0.122 | 0.034 | 0.811 | 0.753 | 0.518 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.727 | 0.132 | 0.751 | 0.274 | 0.506 | 3.000 | 0.800 | 0.600 | 0.390 | 0.329 | 0.239 | 0.063 | 0.112 | 0.033 | 0.819 | 0.765 | 0.554 |
| Pre-enactment constitutional council | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.747 | 0.104 | 0.852 | 0.155 | 0.008 | 3.000 | 0.490 | 0.532 | 0.429 | 0.382 | 0.281 | 0.042 | 0.205 | 0.034 | 0.825 | 0.778 | 0.552 |
| Pre-enactment constitutional council | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.730 | 0.128 | 0.771 | 0.252 | 0.420 | 2.000 | 0.586 | 0.494 | 0.408 | 0.335 | 0.236 | 0.060 | 0.171 | 0.035 | 0.811 | 0.760 | 0.529 |
| Pre-enactment constitutional council | state/district_only | 609 | 1.000 | 0.022 | 0.711 | 0.184 | 0.743 | 0.291 | 0.181 | 1.000 | 0.554 | 0.476 | 0.411 | 0.345 | 0.233 | 0.054 | 0.166 | 0.035 | 0.827 | 0.781 | 0.517 |
| Pre-enactment constitutional council | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.728 | 0.123 | 0.767 | 0.244 | 0.467 | 3.000 | 0.612 | 0.551 | 0.408 | 0.332 | 0.228 | 0.059 | 0.150 | 0.035 | 0.813 | 0.764 | 0.552 |
| Pre-enactment constitutional council | state/state_high_court | 6361 | 1.000 | 0.021 | 0.725 | 0.133 | 0.744 | 0.253 | 0.511 | 2.000 | 0.563 | 0.495 | 0.398 | 0.345 | 0.229 | 0.063 | 0.166 | 0.034 | 0.816 | 0.765 | 0.529 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.731 | 0.135 | 0.678 | 0.268 | 0.434 | 3.000 | 0.406 | 0.495 | 0.391 | 0.312 | 0.284 | 0.061 | 0.243 | 0.028 | 0.907 | 0.862 | 0.481 |
| Judicial review with delayed legislative override | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.727 | 0.139 | 0.666 | 0.293 | 0.570 | 2.000 | 0.426 | 0.455 | 0.379 | 0.314 | 0.257 | 0.068 | 0.232 | 0.027 | 0.904 | 0.855 | 0.460 |
| Judicial review with delayed legislative override | federal/district_only | 2694 | 1.000 | 0.020 | 0.725 | 0.159 | 0.649 | 0.287 | 0.539 | 1.000 | 0.427 | 0.431 | 0.396 | 0.307 | 0.263 | 0.062 | 0.234 | 0.029 | 0.901 | 0.848 | 0.441 |
| Judicial review with delayed legislative override | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.725 | 0.130 | 0.649 | 0.293 | 0.536 | 3.000 | 0.550 | 0.533 | 0.376 | 0.289 | 0.277 | 0.065 | 0.219 | 0.026 | 0.905 | 0.859 | 0.485 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.722 | 0.140 | 0.658 | 0.280 | 0.530 | 3.000 | 0.777 | 0.580 | 0.336 | 0.280 | 0.287 | 0.074 | 0.075 | 0.022 | 0.917 | 0.872 | 0.486 |
| Judicial review with delayed legislative override | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.706 | 0.198 | 0.700 | 0.304 | 0.493 | 1.000 | 0.756 | 0.520 | 0.337 | 0.240 | 0.265 | 0.071 | 0.088 | 0.024 | 0.910 | 0.859 | 0.450 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.713 | 0.142 | 0.659 | 0.322 | 0.653 | 3.000 | 0.800 | 0.600 | 0.338 | 0.275 | 0.282 | 0.073 | 0.075 | 0.024 | 0.914 | 0.862 | 0.487 |
| Judicial review with delayed legislative override | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.747 | 0.123 | 0.712 | 0.218 | 0.050 | 3.000 | 0.490 | 0.532 | 0.399 | 0.333 | 0.328 | 0.050 | 0.146 | 0.026 | 0.912 | 0.869 | 0.485 |
| Judicial review with delayed legislative override | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.727 | 0.136 | 0.680 | 0.307 | 0.564 | 2.000 | 0.586 | 0.494 | 0.381 | 0.308 | 0.263 | 0.062 | 0.127 | 0.025 | 0.911 | 0.860 | 0.462 |
| Judicial review with delayed legislative override | state/district_only | 609 | 1.000 | 0.022 | 0.714 | 0.201 | 0.701 | 0.311 | 0.371 | 1.000 | 0.554 | 0.476 | 0.389 | 0.297 | 0.251 | 0.066 | 0.138 | 0.026 | 0.911 | 0.868 | 0.449 |
| Judicial review with delayed legislative override | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.716 | 0.135 | 0.654 | 0.311 | 0.623 | 3.000 | 0.612 | 0.551 | 0.364 | 0.279 | 0.263 | 0.066 | 0.110 | 0.024 | 0.912 | 0.863 | 0.484 |
| Judicial review with delayed legislative override | state/state_high_court | 6361 | 1.000 | 0.021 | 0.721 | 0.141 | 0.674 | 0.322 | 0.648 | 2.000 | 0.563 | 0.495 | 0.370 | 0.296 | 0.261 | 0.066 | 0.129 | 0.024 | 0.911 | 0.863 | 0.462 |
| Retention-election accountability court | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.728 | 0.125 | 0.662 | 0.242 | 0.300 | 3.000 | 0.406 | 0.495 | 0.409 | 0.347 | 0.261 | 0.050 | 0.252 | 0.033 | 0.837 | 0.782 | 0.496 |
| Retention-election accountability court | federal/circuit_panel | 10083 | 1.000 | 0.021 | 0.719 | 0.129 | 0.683 | 0.262 | 0.416 | 2.000 | 0.426 | 0.455 | 0.396 | 0.326 | 0.242 | 0.061 | 0.248 | 0.032 | 0.834 | 0.774 | 0.475 |
| Retention-election accountability court | federal/district_only | 2694 | 1.000 | 0.020 | 0.714 | 0.147 | 0.694 | 0.261 | 0.376 | 1.000 | 0.427 | 0.431 | 0.398 | 0.343 | 0.218 | 0.059 | 0.261 | 0.036 | 0.835 | 0.770 | 0.456 |
| Retention-election accountability court | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.731 | 0.114 | 0.751 | 0.243 | 0.379 | 3.000 | 0.550 | 0.533 | 0.413 | 0.322 | 0.223 | 0.045 | 0.238 | 0.031 | 0.835 | 0.777 | 0.500 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.725 | 0.128 | 0.683 | 0.262 | 0.389 | 3.000 | 0.777 | 0.580 | 0.359 | 0.301 | 0.262 | 0.063 | 0.096 | 0.026 | 0.854 | 0.797 | 0.501 |
| Retention-election accountability court | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.706 | 0.177 | 0.671 | 0.243 | 0.246 | 1.000 | 0.756 | 0.520 | 0.374 | 0.332 | 0.207 | 0.049 | 0.100 | 0.031 | 0.841 | 0.776 | 0.466 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.023 | 0.720 | 0.128 | 0.694 | 0.276 | 0.514 | 3.000 | 0.800 | 0.600 | 0.351 | 0.292 | 0.249 | 0.064 | 0.090 | 0.029 | 0.848 | 0.784 | 0.502 |
| Retention-election accountability court | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.747 | 0.118 | 0.852 | 0.132 | 0.011 | 3.000 | 0.490 | 0.532 | 0.406 | 0.358 | 0.276 | 0.038 | 0.170 | 0.029 | 0.853 | 0.794 | 0.501 |
| Retention-election accountability court | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.722 | 0.123 | 0.667 | 0.274 | 0.394 | 2.000 | 0.586 | 0.494 | 0.382 | 0.310 | 0.236 | 0.057 | 0.147 | 0.031 | 0.843 | 0.784 | 0.477 |
| Retention-election accountability court | state/district_only | 609 | 1.000 | 0.022 | 0.709 | 0.180 | 0.738 | 0.294 | 0.157 | 1.000 | 0.554 | 0.476 | 0.389 | 0.340 | 0.215 | 0.054 | 0.133 | 0.032 | 0.851 | 0.797 | 0.465 |
| Retention-election accountability court | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.720 | 0.121 | 0.675 | 0.275 | 0.449 | 3.000 | 0.612 | 0.551 | 0.381 | 0.308 | 0.239 | 0.065 | 0.132 | 0.030 | 0.846 | 0.788 | 0.500 |
| Retention-election accountability court | state/state_high_court | 6361 | 1.000 | 0.021 | 0.713 | 0.129 | 0.677 | 0.279 | 0.479 | 2.000 | 0.563 | 0.495 | 0.366 | 0.314 | 0.247 | 0.069 | 0.144 | 0.029 | 0.842 | 0.781 | 0.478 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 4376 | 1.000 | 0.021 | 0.743 | 0.008 | 0.873 | 0.102 | 0.289 | 3.000 | 0.406 | 0.495 | 0.451 | 0.375 | 0.242 | 0.058 | 0.282 | 0.039 | 0.829 | 0.806 | 0.560 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 10083 | 1.000 | 0.020 | 0.742 | 0.012 | 0.892 | 0.124 | 0.446 | 2.000 | 0.426 | 0.455 | 0.436 | 0.363 | 0.234 | 0.067 | 0.273 | 0.037 | 0.826 | 0.800 | 0.532 |
| Hybrid court balancing independence and accountability | federal/district_only | 2694 | 1.000 | 0.020 | 0.738 | 0.016 | 0.870 | 0.135 | 0.441 | 1.000 | 0.427 | 0.431 | 0.430 | 0.362 | 0.232 | 0.062 | 0.269 | 0.039 | 0.829 | 0.796 | 0.511 |
| Hybrid court balancing independence and accountability | federal/state_federal_split | 1044 | 1.000 | 0.022 | 0.745 | 0.008 | 0.866 | 0.133 | 0.364 | 3.000 | 0.550 | 0.533 | 0.443 | 0.326 | 0.238 | 0.064 | 0.275 | 0.036 | 0.824 | 0.802 | 0.570 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 4206 | 1.000 | 0.022 | 0.738 | 0.009 | 0.869 | 0.136 | 0.361 | 3.000 | 0.777 | 0.580 | 0.397 | 0.328 | 0.258 | 0.066 | 0.108 | 0.030 | 0.845 | 0.819 | 0.569 |
| Hybrid court balancing independence and accountability | mixed_state_federal/district_only | 588 | 1.000 | 0.022 | 0.718 | 0.023 | 0.864 | 0.158 | 0.291 | 1.000 | 0.756 | 0.520 | 0.408 | 0.347 | 0.223 | 0.063 | 0.119 | 0.033 | 0.833 | 0.798 | 0.531 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 8153 | 1.000 | 0.022 | 0.737 | 0.011 | 0.895 | 0.128 | 0.494 | 3.000 | 0.800 | 0.600 | 0.405 | 0.333 | 0.249 | 0.074 | 0.105 | 0.033 | 0.843 | 0.810 | 0.571 |
| Hybrid court balancing independence and accountability | state/circuit_en_banc | 424 | 1.000 | 0.021 | 0.748 | 0.002 | 0.937 | 0.007 | 0.026 | 3.000 | 0.490 | 0.532 | 0.413 | 0.389 | 0.278 | 0.042 | 0.184 | 0.036 | 0.836 | 0.813 | 0.567 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 2893 | 1.000 | 0.021 | 0.742 | 0.010 | 0.874 | 0.113 | 0.428 | 2.000 | 0.586 | 0.494 | 0.415 | 0.351 | 0.226 | 0.068 | 0.161 | 0.034 | 0.837 | 0.807 | 0.537 |
| Hybrid court balancing independence and accountability | state/district_only | 609 | 1.000 | 0.021 | 0.722 | 0.022 | 0.885 | 0.183 | 0.222 | 1.000 | 0.554 | 0.476 | 0.396 | 0.332 | 0.250 | 0.048 | 0.169 | 0.035 | 0.846 | 0.822 | 0.528 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 6569 | 1.000 | 0.022 | 0.737 | 0.010 | 0.893 | 0.114 | 0.459 | 3.000 | 0.612 | 0.551 | 0.412 | 0.339 | 0.248 | 0.071 | 0.152 | 0.034 | 0.840 | 0.813 | 0.569 |
| Hybrid court balancing independence and accountability | state/state_high_court | 6361 | 1.000 | 0.021 | 0.741 | 0.011 | 0.865 | 0.123 | 0.532 | 2.000 | 0.563 | 0.495 | 0.417 | 0.348 | 0.245 | 0.073 | 0.168 | 0.033 | 0.837 | 0.808 | 0.537 |

## Policy Domain Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administration | 4443 | 1.000 | 0.021 | 0.711 | 0.410 | 0.017 | 0.524 | 0.108 | 2.700 | 0.489 | 0.529 | 0.337 | 0.251 | 0.353 | 0.052 | 0.155 | 0.017 | 0.955 | 0.902 | 0.463 |
| Current-style federal supreme court | civil-rights | 7975 | 1.000 | 0.022 | 0.660 | 0.496 | 0.031 | 0.551 | 0.671 | 2.277 | 0.525 | 0.478 | 0.288 | 0.210 | 0.287 | 0.069 | 0.112 | 0.015 | 0.960 | 0.903 | 0.447 |
| Current-style federal supreme court | criminal-justice | 6872 | 1.000 | 0.022 | 0.655 | 0.477 | 0.024 | 0.555 | 0.584 | 2.334 | 0.581 | 0.507 | 0.282 | 0.204 | 0.300 | 0.065 | 0.099 | 0.016 | 0.959 | 0.902 | 0.450 |
| Current-style federal supreme court | economic-regulation | 4360 | 1.000 | 0.022 | 0.708 | 0.399 | 0.018 | 0.533 | 0.141 | 2.733 | 0.605 | 0.560 | 0.306 | 0.229 | 0.321 | 0.061 | 0.121 | 0.018 | 0.955 | 0.900 | 0.465 |
| Current-style federal supreme court | elections | 6946 | 1.000 | 0.023 | 0.628 | 0.493 | 0.030 | 0.569 | 0.647 | 2.725 | 0.680 | 0.529 | 0.253 | 0.189 | 0.305 | 0.074 | 0.069 | 0.014 | 0.963 | 0.908 | 0.461 |
| Current-style federal supreme court | emergency-security | 6839 | 1.000 | 0.023 | 0.630 | 0.665 | 0.030 | 0.637 | 0.424 | 1.986 | 0.548 | 0.506 | 0.259 | 0.183 | 0.303 | 0.063 | 0.094 | 0.015 | 0.960 | 0.902 | 0.451 |
| Current-style federal supreme court | federalism | 4966 | 1.000 | 0.022 | 0.696 | 0.420 | 0.019 | 0.566 | 0.159 | 2.764 | 0.767 | 0.601 | 0.291 | 0.225 | 0.280 | 0.056 | 0.073 | 0.017 | 0.954 | 0.898 | 0.469 |
| Current-style federal supreme court | speech-religion | 5599 | 1.000 | 0.022 | 0.658 | 0.487 | 0.026 | 0.592 | 0.585 | 2.238 | 0.467 | 0.468 | 0.295 | 0.211 | 0.303 | 0.061 | 0.130 | 0.016 | 0.957 | 0.901 | 0.445 |
| Staggered 18-year nonrenewable terms | administration | 4443 | 1.000 | 0.021 | 0.720 | 0.400 | 0.027 | 0.521 | 0.077 | 2.700 | 0.489 | 0.529 | 0.333 | 0.252 | 0.358 | 0.061 | 0.148 | 0.018 | 0.951 | 0.896 | 0.468 |
| Staggered 18-year nonrenewable terms | civil-rights | 7975 | 1.000 | 0.022 | 0.663 | 0.497 | 0.037 | 0.555 | 0.653 | 2.277 | 0.525 | 0.478 | 0.285 | 0.220 | 0.293 | 0.064 | 0.114 | 0.015 | 0.958 | 0.898 | 0.451 |
| Staggered 18-year nonrenewable terms | criminal-justice | 6872 | 1.000 | 0.022 | 0.662 | 0.475 | 0.035 | 0.563 | 0.550 | 2.334 | 0.581 | 0.507 | 0.287 | 0.202 | 0.288 | 0.065 | 0.101 | 0.016 | 0.955 | 0.896 | 0.455 |
| Staggered 18-year nonrenewable terms | economic-regulation | 4360 | 1.000 | 0.022 | 0.717 | 0.397 | 0.030 | 0.530 | 0.112 | 2.733 | 0.605 | 0.560 | 0.316 | 0.248 | 0.314 | 0.049 | 0.118 | 0.019 | 0.952 | 0.895 | 0.470 |
| Staggered 18-year nonrenewable terms | elections | 6946 | 1.000 | 0.023 | 0.635 | 0.492 | 0.040 | 0.574 | 0.609 | 2.725 | 0.680 | 0.529 | 0.261 | 0.196 | 0.294 | 0.077 | 0.069 | 0.015 | 0.959 | 0.902 | 0.466 |
| Staggered 18-year nonrenewable terms | emergency-security | 6839 | 1.000 | 0.023 | 0.641 | 0.661 | 0.043 | 0.624 | 0.369 | 1.986 | 0.548 | 0.506 | 0.266 | 0.181 | 0.302 | 0.060 | 0.101 | 0.016 | 0.956 | 0.895 | 0.456 |
| Staggered 18-year nonrenewable terms | federalism | 4966 | 1.000 | 0.022 | 0.711 | 0.412 | 0.031 | 0.530 | 0.116 | 2.764 | 0.767 | 0.601 | 0.302 | 0.232 | 0.270 | 0.062 | 0.076 | 0.018 | 0.950 | 0.890 | 0.474 |
| Staggered 18-year nonrenewable terms | speech-religion | 5599 | 1.000 | 0.022 | 0.662 | 0.484 | 0.037 | 0.579 | 0.563 | 2.238 | 0.467 | 0.468 | 0.286 | 0.219 | 0.294 | 0.070 | 0.132 | 0.017 | 0.954 | 0.895 | 0.449 |
| Fifteen-justice supermajority commission court | administration | 4443 | 1.000 | 0.021 | 0.747 | 0.117 | 0.659 | 0.219 | 0.100 | 2.700 | 0.489 | 0.529 | 0.403 | 0.331 | 0.299 | 0.049 | 0.213 | 0.029 | 0.891 | 0.849 | 0.484 |
| Fifteen-justice supermajority commission court | civil-rights | 7975 | 1.000 | 0.021 | 0.727 | 0.134 | 0.691 | 0.284 | 0.829 | 2.277 | 0.525 | 0.478 | 0.369 | 0.297 | 0.256 | 0.075 | 0.173 | 0.025 | 0.903 | 0.854 | 0.468 |
| Fifteen-justice supermajority commission court | criminal-justice | 6872 | 1.000 | 0.021 | 0.714 | 0.146 | 0.656 | 0.308 | 0.709 | 2.334 | 0.581 | 0.507 | 0.372 | 0.294 | 0.257 | 0.067 | 0.151 | 0.027 | 0.898 | 0.851 | 0.471 |
| Fifteen-justice supermajority commission court | economic-regulation | 4360 | 1.000 | 0.021 | 0.750 | 0.115 | 0.627 | 0.240 | 0.104 | 2.733 | 0.605 | 0.560 | 0.387 | 0.325 | 0.269 | 0.054 | 0.175 | 0.030 | 0.891 | 0.847 | 0.487 |
| Fifteen-justice supermajority commission court | elections | 6946 | 1.000 | 0.023 | 0.707 | 0.125 | 0.722 | 0.298 | 0.763 | 2.725 | 0.680 | 0.529 | 0.364 | 0.277 | 0.258 | 0.080 | 0.122 | 0.023 | 0.907 | 0.859 | 0.482 |
| Fifteen-justice supermajority commission court | emergency-security | 6839 | 1.000 | 0.022 | 0.716 | 0.198 | 0.691 | 0.319 | 0.448 | 1.986 | 0.548 | 0.506 | 0.374 | 0.304 | 0.257 | 0.064 | 0.179 | 0.027 | 0.895 | 0.848 | 0.472 |
| Fifteen-justice supermajority commission court | federalism | 4966 | 1.000 | 0.022 | 0.755 | 0.118 | 0.633 | 0.227 | 0.142 | 2.764 | 0.767 | 0.601 | 0.376 | 0.324 | 0.226 | 0.055 | 0.125 | 0.030 | 0.886 | 0.840 | 0.490 |
| Fifteen-justice supermajority commission court | speech-religion | 5599 | 1.000 | 0.021 | 0.721 | 0.132 | 0.640 | 0.306 | 0.719 | 2.238 | 0.467 | 0.468 | 0.379 | 0.300 | 0.250 | 0.072 | 0.185 | 0.028 | 0.900 | 0.852 | 0.466 |
| Supermajority required to invalidate laws | administration | 4443 | 1.000 | 0.020 | 0.743 | 0.120 | 0.569 | 0.260 | 0.088 | 2.700 | 0.489 | 0.529 | 0.399 | 0.328 | 0.318 | 0.054 | 0.196 | 0.028 | 0.898 | 0.856 | 0.470 |
| Supermajority required to invalidate laws | civil-rights | 7975 | 1.000 | 0.021 | 0.724 | 0.140 | 0.664 | 0.293 | 0.797 | 2.277 | 0.525 | 0.478 | 0.376 | 0.289 | 0.269 | 0.074 | 0.170 | 0.024 | 0.907 | 0.859 | 0.454 |
| Supermajority required to invalidate laws | criminal-justice | 6872 | 1.000 | 0.021 | 0.710 | 0.153 | 0.623 | 0.350 | 0.668 | 2.334 | 0.581 | 0.507 | 0.366 | 0.292 | 0.257 | 0.072 | 0.148 | 0.026 | 0.903 | 0.856 | 0.458 |
| Supermajority required to invalidate laws | economic-regulation | 4360 | 1.000 | 0.021 | 0.746 | 0.114 | 0.589 | 0.312 | 0.124 | 2.733 | 0.605 | 0.560 | 0.389 | 0.312 | 0.272 | 0.055 | 0.169 | 0.029 | 0.896 | 0.853 | 0.473 |
| Supermajority required to invalidate laws | elections | 6946 | 1.000 | 0.023 | 0.701 | 0.130 | 0.665 | 0.336 | 0.743 | 2.725 | 0.680 | 0.529 | 0.348 | 0.272 | 0.266 | 0.079 | 0.118 | 0.022 | 0.912 | 0.865 | 0.469 |
| Supermajority required to invalidate laws | emergency-security | 6839 | 1.000 | 0.022 | 0.706 | 0.207 | 0.661 | 0.345 | 0.427 | 1.986 | 0.548 | 0.506 | 0.363 | 0.284 | 0.255 | 0.062 | 0.158 | 0.026 | 0.903 | 0.856 | 0.459 |
| Supermajority required to invalidate laws | federalism | 4966 | 1.000 | 0.022 | 0.749 | 0.124 | 0.622 | 0.286 | 0.131 | 2.764 | 0.767 | 0.601 | 0.375 | 0.307 | 0.236 | 0.048 | 0.125 | 0.028 | 0.894 | 0.848 | 0.476 |
| Supermajority required to invalidate laws | speech-religion | 5599 | 1.000 | 0.021 | 0.717 | 0.138 | 0.656 | 0.333 | 0.676 | 2.238 | 0.467 | 0.468 | 0.384 | 0.309 | 0.258 | 0.062 | 0.194 | 0.026 | 0.905 | 0.858 | 0.452 |
| Strict recusal with substitute justices | administration | 4443 | 1.000 | 0.020 | 0.747 | 0.114 | 0.654 | 0.221 | 0.065 | 2.700 | 0.489 | 0.529 | 0.395 | 0.348 | 0.298 | 0.049 | 0.208 | 0.031 | 0.877 | 0.836 | 0.490 |
| Strict recusal with substitute justices | civil-rights | 7975 | 1.000 | 0.021 | 0.727 | 0.132 | 0.712 | 0.288 | 0.817 | 2.277 | 0.525 | 0.478 | 0.380 | 0.303 | 0.260 | 0.068 | 0.169 | 0.026 | 0.891 | 0.842 | 0.473 |
| Strict recusal with substitute justices | criminal-justice | 6872 | 1.000 | 0.021 | 0.714 | 0.148 | 0.707 | 0.287 | 0.693 | 2.334 | 0.581 | 0.507 | 0.375 | 0.304 | 0.253 | 0.067 | 0.157 | 0.028 | 0.884 | 0.838 | 0.477 |
| Strict recusal with substitute justices | economic-regulation | 4360 | 1.000 | 0.021 | 0.750 | 0.110 | 0.690 | 0.226 | 0.091 | 2.733 | 0.605 | 0.560 | 0.400 | 0.335 | 0.260 | 0.045 | 0.180 | 0.032 | 0.877 | 0.834 | 0.492 |
| Strict recusal with substitute justices | elections | 6946 | 1.000 | 0.023 | 0.709 | 0.121 | 0.721 | 0.300 | 0.736 | 2.725 | 0.680 | 0.529 | 0.361 | 0.298 | 0.260 | 0.080 | 0.125 | 0.024 | 0.894 | 0.847 | 0.488 |
| Strict recusal with substitute justices | emergency-security | 6839 | 1.000 | 0.022 | 0.716 | 0.195 | 0.741 | 0.305 | 0.419 | 1.986 | 0.548 | 0.506 | 0.385 | 0.302 | 0.259 | 0.060 | 0.184 | 0.029 | 0.882 | 0.835 | 0.478 |
| Strict recusal with substitute justices | federalism | 4966 | 1.000 | 0.022 | 0.757 | 0.113 | 0.670 | 0.238 | 0.129 | 2.764 | 0.767 | 0.601 | 0.377 | 0.330 | 0.226 | 0.060 | 0.132 | 0.031 | 0.874 | 0.827 | 0.495 |
| Strict recusal with substitute justices | speech-religion | 5599 | 1.000 | 0.021 | 0.722 | 0.127 | 0.707 | 0.278 | 0.713 | 2.238 | 0.467 | 0.468 | 0.384 | 0.313 | 0.244 | 0.072 | 0.202 | 0.029 | 0.888 | 0.840 | 0.471 |
| Reasoned emergency orders with merits follow-up | administration | 4443 | 1.000 | 0.020 | 0.749 | 0.002 | 0.873 | 0.088 | 0.103 | 2.700 | 0.489 | 0.529 | 0.421 | 0.364 | 0.291 | 0.056 | 0.222 | 0.033 | 0.881 | 0.857 | 0.474 |
| Reasoned emergency orders with merits follow-up | civil-rights | 7975 | 1.000 | 0.021 | 0.742 | 0.015 | 0.886 | 0.108 | 0.817 | 2.277 | 0.525 | 0.478 | 0.404 | 0.333 | 0.257 | 0.083 | 0.191 | 0.027 | 0.895 | 0.859 | 0.457 |
| Reasoned emergency orders with merits follow-up | criminal-justice | 6872 | 1.000 | 0.021 | 0.732 | 0.010 | 0.858 | 0.099 | 0.689 | 2.334 | 0.581 | 0.507 | 0.397 | 0.330 | 0.249 | 0.077 | 0.173 | 0.029 | 0.892 | 0.858 | 0.461 |
| Reasoned emergency orders with merits follow-up | economic-regulation | 4360 | 1.000 | 0.021 | 0.750 | 0.002 | 0.885 | 0.119 | 0.122 | 2.733 | 0.605 | 0.560 | 0.425 | 0.346 | 0.270 | 0.060 | 0.194 | 0.034 | 0.883 | 0.856 | 0.476 |
| Reasoned emergency orders with merits follow-up | elections | 6946 | 1.000 | 0.023 | 0.714 | 0.015 | 0.863 | 0.140 | 0.772 | 2.725 | 0.680 | 0.529 | 0.389 | 0.319 | 0.261 | 0.080 | 0.128 | 0.026 | 0.900 | 0.865 | 0.472 |
| Reasoned emergency orders with merits follow-up | emergency-security | 6839 | 1.000 | 0.022 | 0.721 | 0.029 | 0.875 | 0.174 | 0.462 | 1.986 | 0.548 | 0.506 | 0.406 | 0.325 | 0.243 | 0.073 | 0.195 | 0.030 | 0.886 | 0.855 | 0.462 |
| Reasoned emergency orders with merits follow-up | federalism | 4966 | 1.000 | 0.021 | 0.755 | 0.003 | 0.873 | 0.092 | 0.145 | 2.764 | 0.767 | 0.601 | 0.412 | 0.330 | 0.222 | 0.063 | 0.137 | 0.034 | 0.878 | 0.849 | 0.480 |
| Reasoned emergency orders with merits follow-up | speech-religion | 5599 | 1.000 | 0.021 | 0.734 | 0.012 | 0.878 | 0.119 | 0.705 | 2.238 | 0.467 | 0.468 | 0.413 | 0.321 | 0.252 | 0.075 | 0.210 | 0.030 | 0.894 | 0.859 | 0.455 |
| Panel review with en banc safety valve | administration | 4443 | 1.000 | 0.020 | 0.747 | 0.114 | 0.650 | 0.236 | 0.086 | 2.700 | 0.489 | 0.529 | 0.400 | 0.335 | 0.307 | 0.042 | 0.203 | 0.031 | 0.889 | 0.848 | 0.527 |
| Panel review with en banc safety valve | civil-rights | 7975 | 1.000 | 0.021 | 0.726 | 0.134 | 0.718 | 0.244 | 0.839 | 2.277 | 0.525 | 0.478 | 0.384 | 0.298 | 0.261 | 0.074 | 0.171 | 0.025 | 0.901 | 0.853 | 0.507 |
| Panel review with en banc safety valve | criminal-justice | 6872 | 1.000 | 0.021 | 0.714 | 0.148 | 0.663 | 0.306 | 0.724 | 2.334 | 0.581 | 0.507 | 0.375 | 0.289 | 0.258 | 0.071 | 0.145 | 0.027 | 0.897 | 0.850 | 0.510 |
| Panel review with en banc safety valve | economic-regulation | 4360 | 1.000 | 0.021 | 0.752 | 0.112 | 0.650 | 0.217 | 0.123 | 2.733 | 0.605 | 0.560 | 0.400 | 0.338 | 0.276 | 0.056 | 0.172 | 0.031 | 0.891 | 0.849 | 0.531 |
| Panel review with en banc safety valve | elections | 6946 | 1.000 | 0.023 | 0.708 | 0.124 | 0.722 | 0.294 | 0.757 | 2.725 | 0.680 | 0.529 | 0.352 | 0.284 | 0.261 | 0.078 | 0.124 | 0.024 | 0.905 | 0.858 | 0.530 |
| Panel review with en banc safety valve | emergency-security | 6839 | 1.000 | 0.022 | 0.716 | 0.196 | 0.714 | 0.299 | 0.446 | 1.986 | 0.548 | 0.506 | 0.379 | 0.296 | 0.254 | 0.057 | 0.176 | 0.028 | 0.894 | 0.848 | 0.519 |
| Panel review with en banc safety valve | federalism | 4966 | 1.000 | 0.022 | 0.756 | 0.116 | 0.693 | 0.237 | 0.130 | 2.764 | 0.767 | 0.601 | 0.385 | 0.319 | 0.237 | 0.053 | 0.123 | 0.031 | 0.886 | 0.839 | 0.537 |
| Panel review with en banc safety valve | speech-religion | 5599 | 1.000 | 0.021 | 0.722 | 0.131 | 0.721 | 0.290 | 0.744 | 2.238 | 0.467 | 0.468 | 0.392 | 0.317 | 0.249 | 0.070 | 0.188 | 0.029 | 0.899 | 0.850 | 0.502 |
| Dual supreme courts with cross-checking invalidations | administration | 4443 | 1.000 | 0.020 | 0.747 | 0.005 | 0.873 | 0.047 | 0.021 | 2.700 | 0.489 | 0.529 | 0.450 | 0.372 | 0.277 | 0.047 | 0.232 | 0.039 | 0.830 | 0.794 | 0.603 |
| Dual supreme courts with cross-checking invalidations | civil-rights | 7975 | 1.000 | 0.021 | 0.749 | 0.019 | 0.894 | 0.135 | 0.722 | 2.277 | 0.525 | 0.478 | 0.417 | 0.338 | 0.243 | 0.076 | 0.208 | 0.032 | 0.848 | 0.800 | 0.587 |
| Dual supreme courts with cross-checking invalidations | criminal-justice | 6872 | 1.000 | 0.021 | 0.736 | 0.014 | 0.859 | 0.121 | 0.562 | 2.334 | 0.581 | 0.507 | 0.417 | 0.350 | 0.235 | 0.069 | 0.187 | 0.033 | 0.840 | 0.795 | 0.590 |
| Dual supreme courts with cross-checking invalidations | economic-regulation | 4360 | 1.000 | 0.021 | 0.752 | 0.005 | 0.860 | 0.086 | 0.025 | 2.733 | 0.605 | 0.560 | 0.437 | 0.374 | 0.243 | 0.046 | 0.206 | 0.039 | 0.832 | 0.794 | 0.605 |
| Dual supreme courts with cross-checking invalidations | elections | 6946 | 1.000 | 0.022 | 0.729 | 0.018 | 0.877 | 0.120 | 0.622 | 2.725 | 0.680 | 0.529 | 0.405 | 0.332 | 0.240 | 0.078 | 0.153 | 0.030 | 0.848 | 0.803 | 0.601 |
| Dual supreme courts with cross-checking invalidations | emergency-security | 6839 | 1.000 | 0.022 | 0.725 | 0.036 | 0.869 | 0.170 | 0.269 | 1.986 | 0.548 | 0.506 | 0.418 | 0.346 | 0.236 | 0.062 | 0.206 | 0.036 | 0.836 | 0.793 | 0.591 |
| Dual supreme courts with cross-checking invalidations | federalism | 4966 | 1.000 | 0.021 | 0.760 | 0.005 | 0.899 | 0.081 | 0.032 | 2.764 | 0.767 | 0.601 | 0.431 | 0.359 | 0.210 | 0.049 | 0.156 | 0.038 | 0.822 | 0.780 | 0.609 |
| Dual supreme courts with cross-checking invalidations | speech-religion | 5599 | 1.000 | 0.021 | 0.739 | 0.016 | 0.868 | 0.122 | 0.583 | 2.238 | 0.467 | 0.468 | 0.428 | 0.337 | 0.234 | 0.067 | 0.227 | 0.035 | 0.844 | 0.800 | 0.585 |
| Pre-enactment constitutional council | administration | 4443 | 1.000 | 0.020 | 0.745 | 0.109 | 0.686 | 0.201 | 0.025 | 2.700 | 0.489 | 0.529 | 0.428 | 0.387 | 0.275 | 0.044 | 0.235 | 0.038 | 0.806 | 0.760 | 0.547 |
| Pre-enactment constitutional council | civil-rights | 7975 | 1.000 | 0.021 | 0.730 | 0.129 | 0.787 | 0.260 | 0.731 | 2.277 | 0.525 | 0.478 | 0.405 | 0.340 | 0.237 | 0.071 | 0.204 | 0.032 | 0.819 | 0.766 | 0.531 |
| Pre-enactment constitutional council | criminal-justice | 6872 | 1.000 | 0.021 | 0.715 | 0.141 | 0.735 | 0.264 | 0.583 | 2.334 | 0.581 | 0.507 | 0.405 | 0.328 | 0.226 | 0.065 | 0.185 | 0.035 | 0.812 | 0.760 | 0.534 |
| Pre-enactment constitutional council | economic-regulation | 4360 | 1.000 | 0.021 | 0.750 | 0.106 | 0.733 | 0.195 | 0.026 | 2.733 | 0.605 | 0.560 | 0.420 | 0.348 | 0.248 | 0.042 | 0.206 | 0.039 | 0.807 | 0.761 | 0.549 |
| Pre-enactment constitutional council | elections | 6946 | 1.000 | 0.023 | 0.715 | 0.118 | 0.780 | 0.296 | 0.604 | 2.725 | 0.680 | 0.529 | 0.388 | 0.319 | 0.236 | 0.069 | 0.156 | 0.031 | 0.820 | 0.769 | 0.545 |
| Pre-enactment constitutional council | emergency-security | 6839 | 1.000 | 0.022 | 0.713 | 0.184 | 0.768 | 0.264 | 0.256 | 1.986 | 0.548 | 0.506 | 0.405 | 0.340 | 0.226 | 0.056 | 0.207 | 0.036 | 0.812 | 0.760 | 0.535 |
| Pre-enactment constitutional council | federalism | 4966 | 1.000 | 0.022 | 0.756 | 0.110 | 0.722 | 0.213 | 0.041 | 2.764 | 0.767 | 0.601 | 0.426 | 0.350 | 0.212 | 0.049 | 0.152 | 0.039 | 0.797 | 0.745 | 0.553 |
| Pre-enactment constitutional council | speech-religion | 5599 | 1.000 | 0.021 | 0.721 | 0.127 | 0.753 | 0.291 | 0.608 | 2.238 | 0.467 | 0.468 | 0.416 | 0.345 | 0.229 | 0.057 | 0.218 | 0.036 | 0.820 | 0.768 | 0.528 |
| Judicial review with delayed legislative override | administration | 4443 | 1.000 | 0.020 | 0.745 | 0.118 | 0.623 | 0.230 | 0.135 | 2.700 | 0.489 | 0.529 | 0.393 | 0.323 | 0.311 | 0.054 | 0.191 | 0.028 | 0.904 | 0.860 | 0.480 |
| Judicial review with delayed legislative override | civil-rights | 7975 | 1.000 | 0.021 | 0.722 | 0.138 | 0.688 | 0.307 | 0.838 | 2.277 | 0.525 | 0.478 | 0.368 | 0.297 | 0.268 | 0.077 | 0.157 | 0.023 | 0.914 | 0.863 | 0.463 |
| Judicial review with delayed legislative override | criminal-justice | 6872 | 1.000 | 0.021 | 0.709 | 0.148 | 0.643 | 0.321 | 0.724 | 2.334 | 0.581 | 0.507 | 0.352 | 0.285 | 0.264 | 0.070 | 0.142 | 0.025 | 0.910 | 0.860 | 0.467 |
| Judicial review with delayed legislative override | economic-regulation | 4360 | 1.000 | 0.021 | 0.748 | 0.115 | 0.611 | 0.253 | 0.158 | 2.733 | 0.605 | 0.560 | 0.395 | 0.315 | 0.289 | 0.056 | 0.164 | 0.029 | 0.904 | 0.859 | 0.482 |
| Judicial review with delayed legislative override | elections | 6946 | 1.000 | 0.023 | 0.700 | 0.127 | 0.704 | 0.308 | 0.776 | 2.725 | 0.680 | 0.529 | 0.339 | 0.273 | 0.281 | 0.079 | 0.117 | 0.022 | 0.918 | 0.869 | 0.478 |
| Judicial review with delayed legislative override | emergency-security | 6839 | 1.000 | 0.022 | 0.709 | 0.202 | 0.683 | 0.319 | 0.476 | 1.986 | 0.548 | 0.506 | 0.363 | 0.287 | 0.266 | 0.062 | 0.166 | 0.026 | 0.908 | 0.859 | 0.468 |
| Judicial review with delayed legislative override | federalism | 4966 | 1.000 | 0.022 | 0.750 | 0.123 | 0.631 | 0.293 | 0.190 | 2.764 | 0.767 | 0.601 | 0.380 | 0.302 | 0.234 | 0.055 | 0.118 | 0.028 | 0.900 | 0.851 | 0.485 |
| Judicial review with delayed legislative override | speech-religion | 5599 | 1.000 | 0.021 | 0.716 | 0.135 | 0.664 | 0.302 | 0.743 | 2.238 | 0.467 | 0.468 | 0.368 | 0.297 | 0.249 | 0.072 | 0.173 | 0.026 | 0.911 | 0.862 | 0.461 |
| Retention-election accountability court | administration | 4443 | 1.000 | 0.021 | 0.745 | 0.114 | 0.659 | 0.190 | 0.033 | 2.700 | 0.489 | 0.529 | 0.407 | 0.337 | 0.303 | 0.053 | 0.207 | 0.033 | 0.835 | 0.779 | 0.495 |
| Retention-election accountability court | civil-rights | 7975 | 1.000 | 0.021 | 0.713 | 0.127 | 0.698 | 0.278 | 0.709 | 2.277 | 0.525 | 0.478 | 0.364 | 0.309 | 0.248 | 0.072 | 0.181 | 0.028 | 0.850 | 0.787 | 0.479 |
| Retention-election accountability court | criminal-justice | 6872 | 1.000 | 0.021 | 0.702 | 0.135 | 0.654 | 0.301 | 0.554 | 2.334 | 0.581 | 0.507 | 0.372 | 0.305 | 0.239 | 0.070 | 0.166 | 0.030 | 0.841 | 0.780 | 0.482 |
| Retention-election accountability court | economic-regulation | 4360 | 1.000 | 0.021 | 0.750 | 0.110 | 0.656 | 0.175 | 0.040 | 2.733 | 0.605 | 0.560 | 0.406 | 0.341 | 0.265 | 0.049 | 0.177 | 0.034 | 0.841 | 0.784 | 0.498 |
| Retention-election accountability court | elections | 6946 | 1.000 | 0.023 | 0.703 | 0.111 | 0.724 | 0.301 | 0.581 | 2.725 | 0.680 | 0.529 | 0.368 | 0.286 | 0.244 | 0.066 | 0.123 | 0.027 | 0.850 | 0.790 | 0.493 |
| Retention-election accountability court | emergency-security | 6839 | 1.000 | 0.022 | 0.712 | 0.179 | 0.703 | 0.276 | 0.241 | 1.986 | 0.548 | 0.506 | 0.379 | 0.329 | 0.219 | 0.055 | 0.181 | 0.032 | 0.840 | 0.779 | 0.483 |
| Retention-election accountability court | federalism | 4966 | 1.000 | 0.022 | 0.758 | 0.113 | 0.635 | 0.210 | 0.041 | 2.764 | 0.767 | 0.601 | 0.391 | 0.333 | 0.220 | 0.046 | 0.136 | 0.034 | 0.829 | 0.767 | 0.501 |
| Retention-election accountability court | speech-religion | 5599 | 1.000 | 0.021 | 0.705 | 0.124 | 0.681 | 0.317 | 0.583 | 2.238 | 0.467 | 0.468 | 0.374 | 0.313 | 0.234 | 0.067 | 0.191 | 0.031 | 0.845 | 0.784 | 0.477 |
| Hybrid court balancing independence and accountability | administration | 4443 | 1.000 | 0.020 | 0.747 | 0.001 | 0.866 | 0.045 | 0.029 | 2.700 | 0.489 | 0.529 | 0.446 | 0.383 | 0.273 | 0.050 | 0.228 | 0.039 | 0.826 | 0.804 | 0.559 |
| Hybrid court balancing independence and accountability | civil-rights | 7975 | 1.000 | 0.021 | 0.747 | 0.014 | 0.898 | 0.094 | 0.762 | 2.277 | 0.525 | 0.478 | 0.418 | 0.343 | 0.250 | 0.080 | 0.197 | 0.032 | 0.843 | 0.810 | 0.538 |
| Hybrid court balancing independence and accountability | criminal-justice | 6872 | 1.000 | 0.021 | 0.736 | 0.009 | 0.863 | 0.115 | 0.604 | 2.334 | 0.581 | 0.507 | 0.421 | 0.347 | 0.244 | 0.071 | 0.183 | 0.034 | 0.839 | 0.810 | 0.540 |
| Hybrid court balancing independence and accountability | economic-regulation | 4360 | 1.000 | 0.021 | 0.752 | 0.001 | 0.845 | 0.093 | 0.036 | 2.733 | 0.605 | 0.560 | 0.434 | 0.361 | 0.252 | 0.052 | 0.190 | 0.039 | 0.829 | 0.804 | 0.563 |
| Hybrid court balancing independence and accountability | elections | 6946 | 1.000 | 0.023 | 0.725 | 0.014 | 0.893 | 0.126 | 0.650 | 2.725 | 0.680 | 0.529 | 0.397 | 0.329 | 0.236 | 0.080 | 0.150 | 0.030 | 0.844 | 0.815 | 0.563 |
| Hybrid court balancing independence and accountability | emergency-security | 6839 | 1.000 | 0.022 | 0.723 | 0.025 | 0.884 | 0.164 | 0.296 | 1.986 | 0.548 | 0.506 | 0.410 | 0.341 | 0.237 | 0.065 | 0.205 | 0.036 | 0.831 | 0.805 | 0.550 |
| Hybrid court balancing independence and accountability | federalism | 4966 | 1.000 | 0.021 | 0.759 | 0.002 | 0.902 | 0.087 | 0.045 | 2.764 | 0.767 | 0.601 | 0.429 | 0.356 | 0.211 | 0.052 | 0.149 | 0.039 | 0.821 | 0.795 | 0.569 |
| Hybrid court balancing independence and accountability | speech-religion | 5599 | 1.000 | 0.021 | 0.738 | 0.012 | 0.882 | 0.127 | 0.636 | 2.238 | 0.467 | 0.468 | 0.427 | 0.350 | 0.243 | 0.076 | 0.221 | 0.035 | 0.841 | 0.811 | 0.532 |

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
| Current-style federal supreme court | 0.020 | 0.020 |
| Staggered 18-year nonrenewable terms | 0.020 | 0.020 |
| Fifteen-justice supermajority commission court | 0.019 | 0.020 |
| Supermajority required to invalidate laws | 0.019 | 0.020 |
| Strict recusal with substitute justices | 0.019 | 0.020 |
| Reasoned emergency orders with merits follow-up | 0.019 | 0.020 |
| Panel review with en banc safety valve | 0.019 | 0.020 |
| Dual supreme courts with cross-checking invalidations | 0.019 | 0.020 |
| Pre-enactment constitutional council | 0.019 | 0.020 |
| Judicial review with delayed legislative override | 0.019 | 0.020 |
| Retention-election accountability court | 0.019 | 0.020 |
| Hybrid court balancing independence and accountability | 0.019 | 0.020 |

## Calibration Diagnostics

| Profile | Target | Model | Empirical | 95% band | Range | Reliability | Validation | Gap | Status |
| --- | --- | ---: | ---: | ---: | ---: | --- | ---: | ---: | --- |
| canada-scc-recent | Leave application grant rate | 0.021 | 0.089 | 0.021-0.022 | 0.075-0.105 | high | true | 0.054 | outside |
| canada-scc-recent | Charter invalidation proxy | 0.482 | 0.565 | 0.480-0.483 | 0.510-0.620 | medium | true | 0.028 | outside |
| canada-scc-recent | Public trust proxy | 0.028 | 0.490 | 0.027-0.028 | 0.430-0.550 | medium | true | 0.402 | outside |
| canada-scc-recent | Normalized direct court cost | 0.372 | 0.550 | 0.371-0.373 | 0.490-0.610 | medium | true | 0.118 | outside |
| france-conseil-qpc | QPC invalidation rate | 0.482 | 0.315 | 0.480-0.483 | 0.260-0.360 | medium | true | 0.122 | outside |
| france-conseil-qpc | Public trust proxy | 0.028 | 0.500 | 0.027-0.028 | 0.430-0.570 | low | false | 0.402 | outside |
| france-conseil-qpc | Normalized direct court cost | 0.372 | 0.340 | 0.371-0.373 | 0.280-0.400 | medium | true | 0.000 | within |
| france-conseil-qpc | Normalized upstream screening cost | 0.700 | 0.590 | 0.699-0.701 | 0.520-0.660 | medium | true | 0.040 | outside |
| germany-bverfg-2024 | Constitutional complaint success and admission proxy | 0.021 | 0.009 | 0.021-0.022 | 0.006-0.012 | medium | true | 0.009 | outside |
| germany-bverfg-2024 | Public trust proxy | 0.028 | 0.740 | 0.027-0.028 | 0.680-0.800 | medium | true | 0.652 | outside |
| germany-bverfg-2024 | Normalized direct court cost | 0.372 | 0.620 | 0.371-0.373 | 0.560-0.680 | medium | true | 0.188 | outside |
| germany-bverfg-2024 | Normalized capacity strain | 0.460 | 0.560 | 0.459-0.461 | 0.500-0.640 | medium | true | 0.040 | outside |
| cost-us-supreme-court | Normalized direct court cost | 0.372 | 0.740 | 0.371-0.373 | 0.690-0.790 | medium | true | 0.318 | outside |
| cost-us-supreme-court | Normalized capacity strain | 0.460 | 0.480 | 0.459-0.461 | 0.420-0.540 | medium | true | 0.000 | within |
| cost-uk-supreme-court | Normalized direct court cost | 0.372 | 0.430 | 0.371-0.373 | 0.370-0.490 | medium | true | 0.000 | within |
| cost-france-conseil | Normalized direct court cost | 0.372 | 0.340 | 0.371-0.373 | 0.280-0.400 | medium | true | 0.000 | within |
| south-africa-constcourt-recent | Merits invalidation proxy | 0.482 | 0.532 | 0.480-0.483 | 0.470-0.590 | medium | true | 0.000 | within |
| south-africa-constcourt-recent | Petition-to-judgment throughput proxy | 1.000 | 0.141 | 0.999-1.000 | 0.110-0.170 | medium | true | 0.830 | outside |
| south-africa-constcourt-recent | Public trust proxy | 0.028 | 0.430 | 0.027-0.028 | 0.360-0.500 | medium | true | 0.332 | outside |
| south-africa-constcourt-recent | Normalized capacity strain | 0.460 | 0.680 | 0.459-0.461 | 0.610-0.750 | medium | true | 0.150 | outside |
| scdb-postwar-merits-1946-2024 | Speech docket share | 0.142 | 0.076 | 0.141-0.143 | 0.060-0.091 | high | true | 0.051 | outside |
| scdb-postwar-merits-1946-2024 | Civil-rights and privacy docket share | 0.141 | 0.152 | 0.140-0.142 | 0.135-0.169 | high | true | 0.000 | within |
| scdb-postwar-merits-1946-2024 | Criminal procedure docket share | 0.143 | 0.226 | 0.142-0.144 | 0.207-0.244 | high | true | 0.064 | outside |
| scdb-postwar-merits-1946-2024 | Federalism docket share | 0.143 | 0.056 | 0.142-0.144 | 0.041-0.071 | high | true | 0.072 | outside |
| scdb-postwar-merits-1946-2024 | Election-law docket share | 0.145 | 0.027 | 0.144-0.146 | 0.013-0.040 | medium | true | 0.105 | outside |
| scdb-postwar-merits-1946-2024 | Emergency-powers merits share | 0.142 | 0.006 | 0.142-0.143 | 0.000-0.012 | medium | true | 0.130 | outside |
| scdb-postwar-merits-1946-2024 | Administrative and economic regulation share | 0.144 | 0.218 | 0.143-0.145 | 0.199-0.236 | medium | true | 0.055 | outside |
| scdb-modern-merits-2000-2024 | Speech docket share | 0.142 | 0.060 | 0.141-0.143 | 0.039-0.080 | high | true | 0.062 | outside |
| scdb-modern-merits-2000-2024 | Civil-rights and privacy docket share | 0.141 | 0.164 | 0.140-0.142 | 0.137-0.191 | high | true | 0.000 | within |
| scdb-modern-merits-2000-2024 | Criminal procedure docket share | 0.143 | 0.260 | 0.142-0.144 | 0.230-0.289 | high | true | 0.087 | outside |
| scdb-modern-merits-2000-2024 | Federalism docket share | 0.143 | 0.058 | 0.142-0.144 | 0.037-0.078 | high | true | 0.065 | outside |
| scdb-modern-merits-2000-2024 | Election-law docket share | 0.145 | 0.026 | 0.144-0.146 | 0.009-0.043 | medium | true | 0.102 | outside |
| scdb-modern-merits-2000-2024 | Emergency-powers merits share | 0.142 | 0.010 | 0.142-0.143 | 0.000-0.019 | medium | true | 0.123 | outside |
| scdb-modern-merits-2000-2024 | Administrative and economic regulation share | 0.144 | 0.222 | 0.143-0.145 | 0.193-0.250 | medium | true | 0.049 | outside |
| scotus-emergency-2024-2025 | Substantive emergency application relief rate | 0.552 | 0.440 | 0.550-0.554 | 0.310-0.460 | medium | true | 0.092 | outside |
| scotus-emergency-2024-2025 | Written explanation share | 0.627 | 0.279 | 0.625-0.629 | 0.200-0.360 | medium | true | 0.267 | outside |
| scotus-emergency-2024-2025 | Public disagreement share | 0.293 | 0.670 | 0.291-0.295 | 0.570-0.760 | medium | true | 0.277 | outside |
| scotus-emergency-2024-2025 | Certiorari or emergency screening acceptance proxy | 0.021 | 0.018 | 0.021-0.022 | 0.013-0.018 | medium | true | 0.003 | outside |
| gallup-court-confidence-2024 | Public court trust and approval | 0.028 | 0.420 | 0.027-0.028 | 0.350-0.490 | medium | true | 0.322 | outside |
