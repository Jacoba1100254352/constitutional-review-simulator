# Constitutional Review Sensitivity Campaign v1

- runs per case: 80
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Baseline

Baseline assumptions for sensitivity comparison.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.707
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.748
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.314
- highest compliance rate: Hybrid court balancing independence and accountability at 0.524
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.201

### Low emergency pressure

Lower urgency and emergency docket pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.734
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.745
- lowest shadow-docket abuse: Dual supreme courts with cross-checking invalidations at 0.000
- lowest emergency relief rate: Retention-election accountability court at 0.211
- highest compliance rate: Pre-enactment constitutional council at 0.599
- lowest defiance rate: Pre-enactment constitutional council at 0.145

### High emergency pressure

Higher urgency and emergency docket pressure.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.663
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.737
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.039
- lowest emergency relief rate: Retention-election accountability court at 0.314
- highest compliance rate: Hybrid court balancing independence and accountability at 0.410
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.288

### Low appointment polarization

Lower appointment ideology spread and partisan pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.741
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.748
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.245
- highest compliance rate: Pre-enactment constitutional council at 0.623
- lowest defiance rate: Pre-enactment constitutional council at 0.127

### High appointment polarization

Higher appointment ideology spread and partisan pressure.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.685
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.004
- lowest emergency relief rate: Retention-election accountability court at 0.386
- highest compliance rate: Pre-enactment constitutional council at 0.471
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.242

### Low rights threat

Lower share of cases with generated rights-risk signals.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.788
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.801
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.114
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.708
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.081

### High rights threat

Higher share of cases with generated rights-risk signals.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.608
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.764
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.008
- lowest emergency relief rate: Retention-election accountability court at 0.680
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.406
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.296

### High public trust

High initial trust and lower institutional conflict.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.780
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.748
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.245
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.764
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.063

### Low public trust

Low initial trust and higher institutional conflict.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.654
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.743
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.350
- highest compliance rate: Hybrid court balancing independence and accountability at 0.372
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.310

### Low legislative conflict

Lower legislature-court conflict pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.768
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.749
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.238
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.723
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.080

### High legislative conflict

Higher legislature-court conflict pressure and lower trust.

- best overall: Pre-enactment constitutional council (`constitutional-council`) at 0.651
- strongest rights protection: Dual supreme courts with cross-checking invalidations at 0.740
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.357
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.358
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.318

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.593 | 0.780 | 0.688 | 0.202 | 0.398 | 0.681 | 0.445 | 0.569 | 0.259 | 0.354 | 0.406 | 0.336 | 0.256 | 0.276 | 0.062 | 0.142 | 2.390 | 0.562 | 0.485 |
| Staggered 18-year nonrenewable terms | 0.607 | 0.789 | 0.696 | 0.185 | 0.392 | 0.635 | 0.411 | 0.579 | 0.240 | 0.348 | 0.415 | 0.337 | 0.263 | 0.272 | 0.063 | 0.147 | 2.390 | 0.562 | 0.493 |
| Fifteen-justice supermajority commission court | 0.676 | 0.874 | 0.741 | 0.153 | 0.093 | 0.458 | 0.460 | 0.694 | 0.364 | 0.260 | 0.462 | 0.463 | 0.391 | 0.209 | 0.059 | 0.246 | 2.390 | 0.562 | 0.483 |
| Supermajority required to invalidate laws | 0.669 | 0.884 | 0.739 | 0.169 | 0.095 | 0.491 | 0.433 | 0.671 | 0.342 | 0.260 | 0.459 | 0.464 | 0.386 | 0.212 | 0.057 | 0.241 | 2.390 | 0.562 | 0.462 |
| Strict recusal with substitute justices | 0.684 | 0.875 | 0.741 | 0.152 | 0.091 | 0.449 | 0.442 | 0.714 | 0.349 | 0.258 | 0.463 | 0.482 | 0.406 | 0.200 | 0.058 | 0.260 | 2.390 | 0.562 | 0.483 |
| Reasoned emergency orders with merits follow-up | 0.678 | 0.884 | 0.745 | 0.170 | 0.007 | 0.474 | 0.464 | 0.733 | 0.464 | 0.244 | 0.463 | 0.487 | 0.411 | 0.208 | 0.064 | 0.264 | 2.390 | 0.562 | 0.470 |
| Panel review with en banc safety valve | 0.667 | 0.869 | 0.741 | 0.152 | 0.093 | 0.447 | 0.469 | 0.707 | 0.371 | 0.261 | 0.461 | 0.468 | 0.391 | 0.212 | 0.059 | 0.244 | 2.390 | 0.562 | 0.672 |
| Dual supreme courts with cross-checking invalidations | 0.691 | 0.908 | 0.750 | 0.139 | 0.009 | 0.384 | 0.349 | 0.743 | 0.349 | 0.249 | 0.474 | 0.531 | 0.450 | 0.181 | 0.051 | 0.299 | 2.390 | 0.562 | 0.866 |
| Pre-enactment constitutional council | 0.700 | 0.938 | 0.742 | 0.132 | 0.088 | 0.415 | 0.348 | 0.739 | 0.274 | 0.249 | 0.469 | 0.528 | 0.451 | 0.175 | 0.047 | 0.303 | 2.390 | 0.562 | 0.737 |
| Judicial review with delayed legislative override | 0.668 | 0.862 | 0.737 | 0.164 | 0.094 | 0.469 | 0.473 | 0.686 | 0.374 | 0.267 | 0.463 | 0.449 | 0.370 | 0.219 | 0.063 | 0.234 | 2.390 | 0.562 | 0.476 |
| Retention-election accountability court | 0.702 | 0.879 | 0.733 | 0.142 | 0.087 | 0.314 | 0.326 | 0.706 | 0.256 | 0.258 | 0.481 | 0.495 | 0.419 | 0.184 | 0.050 | 0.277 | 2.390 | 0.562 | 0.496 |
| Hybrid court balancing independence and accountability | 0.699 | 0.911 | 0.749 | 0.143 | 0.006 | 0.416 | 0.379 | 0.747 | 0.379 | 0.234 | 0.472 | 0.526 | 0.445 | 0.184 | 0.055 | 0.297 | 2.390 | 0.562 | 0.664 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 17600 | 1.000 | 0.688 | 0.401 | 0.437 | 2.388 | 0.561 | 0.499 | 0.493 | 0.405 | 0.180 | 0.031 | 0.297 | 0.103 | 0.707 | 0.481 |
| Current-style federal supreme court | 2 | 17600 | 1.000 | 0.689 | 0.398 | 0.443 | 2.392 | 0.563 | 0.500 | 0.313 | 0.232 | 0.298 | 0.071 | 0.118 | 0.000 | 0.955 | 0.945 |
| Current-style federal supreme court | 3 | 17600 | 1.000 | 0.687 | 0.396 | 0.445 | 2.385 | 0.563 | 0.499 | 0.267 | 0.193 | 0.313 | 0.076 | 0.078 | 0.000 | 0.995 | 1.000 |
| Current-style federal supreme court | 4 | 17600 | 1.000 | 0.688 | 0.397 | 0.453 | 2.397 | 0.562 | 0.500 | 0.271 | 0.194 | 0.313 | 0.071 | 0.075 | 0.000 | 0.996 | 1.000 |
| Staggered 18-year nonrenewable terms | 1 | 17600 | 1.000 | 0.697 | 0.391 | 0.407 | 2.388 | 0.561 | 0.499 | 0.494 | 0.424 | 0.179 | 0.032 | 0.305 | 0.109 | 0.690 | 0.456 |
| Staggered 18-year nonrenewable terms | 2 | 17600 | 1.000 | 0.697 | 0.393 | 0.407 | 2.392 | 0.563 | 0.500 | 0.317 | 0.244 | 0.282 | 0.067 | 0.128 | 0.000 | 0.936 | 0.921 |
| Staggered 18-year nonrenewable terms | 3 | 17600 | 1.000 | 0.694 | 0.389 | 0.413 | 2.385 | 0.563 | 0.499 | 0.270 | 0.191 | 0.309 | 0.075 | 0.080 | 0.000 | 0.991 | 0.998 |
| Staggered 18-year nonrenewable terms | 4 | 17600 | 1.000 | 0.695 | 0.394 | 0.417 | 2.397 | 0.562 | 0.500 | 0.267 | 0.191 | 0.319 | 0.077 | 0.075 | 0.000 | 0.995 | 1.000 |
| Fifteen-justice supermajority commission court | 1 | 17600 | 1.000 | 0.742 | 0.092 | 0.459 | 2.388 | 0.561 | 0.499 | 0.597 | 0.516 | 0.138 | 0.032 | 0.381 | 0.190 | 0.547 | 0.342 |
| Fifteen-justice supermajority commission court | 2 | 17600 | 1.000 | 0.741 | 0.093 | 0.456 | 2.392 | 0.563 | 0.500 | 0.468 | 0.397 | 0.208 | 0.061 | 0.251 | 0.009 | 0.690 | 0.681 |
| Fifteen-justice supermajority commission court | 3 | 17600 | 1.000 | 0.740 | 0.094 | 0.461 | 2.385 | 0.563 | 0.499 | 0.410 | 0.338 | 0.236 | 0.071 | 0.187 | 0.001 | 0.769 | 0.797 |
| Fifteen-justice supermajority commission court | 4 | 17600 | 1.000 | 0.741 | 0.091 | 0.462 | 2.397 | 0.562 | 0.500 | 0.378 | 0.315 | 0.255 | 0.074 | 0.163 | 0.001 | 0.827 | 0.860 |
| Supermajority required to invalidate laws | 1 | 17600 | 1.000 | 0.739 | 0.095 | 0.428 | 2.388 | 0.561 | 0.499 | 0.593 | 0.514 | 0.133 | 0.030 | 0.375 | 0.185 | 0.551 | 0.345 |
| Supermajority required to invalidate laws | 2 | 17600 | 1.000 | 0.739 | 0.095 | 0.430 | 2.392 | 0.563 | 0.500 | 0.468 | 0.388 | 0.213 | 0.057 | 0.247 | 0.010 | 0.694 | 0.688 |
| Supermajority required to invalidate laws | 3 | 17600 | 1.000 | 0.737 | 0.096 | 0.438 | 2.385 | 0.563 | 0.499 | 0.409 | 0.334 | 0.243 | 0.070 | 0.183 | 0.001 | 0.777 | 0.809 |
| Supermajority required to invalidate laws | 4 | 17600 | 1.000 | 0.739 | 0.095 | 0.437 | 2.397 | 0.562 | 0.500 | 0.388 | 0.309 | 0.258 | 0.070 | 0.157 | 0.001 | 0.834 | 0.865 |
| Strict recusal with substitute justices | 1 | 17600 | 1.000 | 0.742 | 0.090 | 0.438 | 2.388 | 0.561 | 0.499 | 0.607 | 0.529 | 0.133 | 0.032 | 0.382 | 0.205 | 0.528 | 0.321 |
| Strict recusal with substitute justices | 2 | 17600 | 1.000 | 0.742 | 0.091 | 0.439 | 2.392 | 0.563 | 0.500 | 0.483 | 0.405 | 0.200 | 0.058 | 0.266 | 0.017 | 0.651 | 0.638 |
| Strict recusal with substitute justices | 3 | 17600 | 1.000 | 0.740 | 0.091 | 0.447 | 2.385 | 0.563 | 0.499 | 0.432 | 0.362 | 0.227 | 0.070 | 0.207 | 0.003 | 0.722 | 0.746 |
| Strict recusal with substitute justices | 4 | 17600 | 1.000 | 0.741 | 0.092 | 0.445 | 2.397 | 0.562 | 0.500 | 0.406 | 0.329 | 0.242 | 0.070 | 0.184 | 0.001 | 0.775 | 0.804 |
| Reasoned emergency orders with merits follow-up | 1 | 17600 | 1.000 | 0.746 | 0.007 | 0.464 | 2.388 | 0.561 | 0.499 | 0.610 | 0.542 | 0.133 | 0.037 | 0.405 | 0.205 | 0.537 | 0.355 |
| Reasoned emergency orders with merits follow-up | 2 | 17600 | 1.000 | 0.745 | 0.007 | 0.460 | 2.392 | 0.563 | 0.500 | 0.485 | 0.414 | 0.211 | 0.068 | 0.264 | 0.016 | 0.680 | 0.692 |
| Reasoned emergency orders with merits follow-up | 3 | 17600 | 1.000 | 0.744 | 0.007 | 0.469 | 2.385 | 0.563 | 0.499 | 0.439 | 0.359 | 0.238 | 0.074 | 0.206 | 0.004 | 0.759 | 0.803 |
| Reasoned emergency orders with merits follow-up | 4 | 17600 | 1.000 | 0.745 | 0.007 | 0.465 | 2.397 | 0.562 | 0.500 | 0.414 | 0.330 | 0.249 | 0.075 | 0.181 | 0.002 | 0.812 | 0.856 |
| Panel review with en banc safety valve | 1 | 17600 | 1.000 | 0.741 | 0.091 | 0.466 | 2.388 | 0.561 | 0.499 | 0.595 | 0.513 | 0.143 | 0.033 | 0.381 | 0.195 | 0.545 | 0.341 |
| Panel review with en banc safety valve | 2 | 17600 | 1.000 | 0.741 | 0.094 | 0.466 | 2.392 | 0.563 | 0.500 | 0.476 | 0.395 | 0.209 | 0.058 | 0.249 | 0.012 | 0.686 | 0.677 |
| Panel review with en banc safety valve | 3 | 17600 | 1.000 | 0.739 | 0.093 | 0.472 | 2.385 | 0.563 | 0.499 | 0.411 | 0.336 | 0.241 | 0.073 | 0.186 | 0.002 | 0.768 | 0.793 |
| Panel review with en banc safety valve | 4 | 17600 | 1.000 | 0.741 | 0.092 | 0.472 | 2.397 | 0.562 | 0.500 | 0.388 | 0.318 | 0.253 | 0.074 | 0.160 | 0.001 | 0.826 | 0.851 |
| Dual supreme courts with cross-checking invalidations | 1 | 17600 | 1.000 | 0.751 | 0.009 | 0.350 | 2.388 | 0.561 | 0.499 | 0.629 | 0.558 | 0.122 | 0.027 | 0.411 | 0.235 | 0.492 | 0.283 |
| Dual supreme courts with cross-checking invalidations | 2 | 17600 | 1.000 | 0.751 | 0.009 | 0.347 | 2.392 | 0.563 | 0.500 | 0.534 | 0.455 | 0.180 | 0.056 | 0.300 | 0.033 | 0.582 | 0.557 |
| Dual supreme courts with cross-checking invalidations | 3 | 17600 | 1.000 | 0.750 | 0.009 | 0.348 | 2.385 | 0.563 | 0.499 | 0.492 | 0.403 | 0.204 | 0.060 | 0.254 | 0.009 | 0.638 | 0.651 |
| Dual supreme courts with cross-checking invalidations | 4 | 17600 | 1.000 | 0.750 | 0.009 | 0.352 | 2.397 | 0.562 | 0.500 | 0.468 | 0.383 | 0.220 | 0.063 | 0.233 | 0.003 | 0.679 | 0.696 |
| Pre-enactment constitutional council | 1 | 17600 | 1.000 | 0.743 | 0.087 | 0.345 | 2.388 | 0.561 | 0.499 | 0.620 | 0.547 | 0.118 | 0.026 | 0.405 | 0.243 | 0.479 | 0.262 |
| Pre-enactment constitutional council | 2 | 17600 | 1.000 | 0.742 | 0.089 | 0.347 | 2.392 | 0.563 | 0.500 | 0.525 | 0.451 | 0.179 | 0.048 | 0.300 | 0.038 | 0.544 | 0.513 |
| Pre-enactment constitutional council | 3 | 17600 | 1.000 | 0.741 | 0.088 | 0.349 | 2.385 | 0.563 | 0.499 | 0.493 | 0.415 | 0.195 | 0.054 | 0.263 | 0.009 | 0.580 | 0.593 |
| Pre-enactment constitutional council | 4 | 17600 | 1.000 | 0.742 | 0.088 | 0.352 | 2.397 | 0.562 | 0.500 | 0.472 | 0.393 | 0.208 | 0.059 | 0.244 | 0.003 | 0.613 | 0.631 |
| Judicial review with delayed legislative override | 1 | 17600 | 1.000 | 0.738 | 0.094 | 0.470 | 2.388 | 0.561 | 0.499 | 0.588 | 0.499 | 0.144 | 0.034 | 0.376 | 0.181 | 0.564 | 0.360 |
| Judicial review with delayed legislative override | 2 | 17600 | 1.000 | 0.738 | 0.095 | 0.470 | 2.392 | 0.563 | 0.500 | 0.446 | 0.374 | 0.221 | 0.066 | 0.239 | 0.008 | 0.722 | 0.713 |
| Judicial review with delayed legislative override | 3 | 17600 | 1.000 | 0.736 | 0.096 | 0.477 | 2.385 | 0.563 | 0.499 | 0.393 | 0.319 | 0.249 | 0.073 | 0.174 | 0.001 | 0.808 | 0.831 |
| Judicial review with delayed legislative override | 4 | 17600 | 1.000 | 0.737 | 0.093 | 0.477 | 2.397 | 0.562 | 0.500 | 0.369 | 0.290 | 0.263 | 0.078 | 0.148 | 0.001 | 0.865 | 0.889 |
| Retention-election accountability court | 1 | 17600 | 1.000 | 0.733 | 0.086 | 0.325 | 2.388 | 0.561 | 0.499 | 0.595 | 0.520 | 0.125 | 0.028 | 0.383 | 0.220 | 0.495 | 0.268 |
| Retention-election accountability court | 2 | 17600 | 1.000 | 0.734 | 0.088 | 0.327 | 2.392 | 0.563 | 0.500 | 0.497 | 0.417 | 0.190 | 0.051 | 0.279 | 0.028 | 0.583 | 0.537 |
| Retention-election accountability court | 3 | 17600 | 1.000 | 0.733 | 0.086 | 0.323 | 2.385 | 0.563 | 0.499 | 0.456 | 0.376 | 0.203 | 0.056 | 0.234 | 0.005 | 0.622 | 0.621 |
| Retention-election accountability court | 4 | 17600 | 1.000 | 0.734 | 0.087 | 0.328 | 2.397 | 0.562 | 0.500 | 0.432 | 0.361 | 0.216 | 0.063 | 0.213 | 0.002 | 0.652 | 0.659 |
| Hybrid court balancing independence and accountability | 1 | 17600 | 1.000 | 0.750 | 0.006 | 0.383 | 2.388 | 0.561 | 0.499 | 0.638 | 0.557 | 0.124 | 0.031 | 0.409 | 0.239 | 0.488 | 0.297 |
| Hybrid court balancing independence and accountability | 2 | 17600 | 1.000 | 0.750 | 0.006 | 0.375 | 2.392 | 0.563 | 0.500 | 0.526 | 0.450 | 0.183 | 0.056 | 0.304 | 0.034 | 0.577 | 0.577 |
| Hybrid court balancing independence and accountability | 3 | 17600 | 1.000 | 0.749 | 0.006 | 0.378 | 2.385 | 0.563 | 0.499 | 0.480 | 0.399 | 0.209 | 0.063 | 0.248 | 0.009 | 0.636 | 0.671 |
| Hybrid court balancing independence and accountability | 4 | 17600 | 1.000 | 0.749 | 0.006 | 0.379 | 2.397 | 0.562 | 0.500 | 0.459 | 0.376 | 0.219 | 0.071 | 0.225 | 0.004 | 0.679 | 0.716 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 9925 | 1.000 | 0.742 | 0.316 | 0.095 | 2.621 | 0.469 | 0.512 | 0.384 | 0.297 | 0.320 | 0.052 | 0.190 | 0.029 | 0.905 | 0.851 |
| Current-style federal supreme court | criminal_procedure | 10037 | 1.000 | 0.677 | 0.375 | 0.575 | 2.337 | 0.562 | 0.489 | 0.337 | 0.255 | 0.265 | 0.063 | 0.135 | 0.026 | 0.914 | 0.858 |
| Current-style federal supreme court | election_law | 10076 | 1.000 | 0.657 | 0.390 | 0.625 | 2.444 | 0.660 | 0.502 | 0.317 | 0.244 | 0.277 | 0.067 | 0.116 | 0.024 | 0.914 | 0.855 |
| Current-style federal supreme court | emergency_powers | 10051 | 1.000 | 0.650 | 0.589 | 0.434 | 2.313 | 0.532 | 0.503 | 0.302 | 0.219 | 0.281 | 0.062 | 0.129 | 0.025 | 0.916 | 0.856 |
| Current-style federal supreme court | equality | 10052 | 1.000 | 0.675 | 0.396 | 0.689 | 2.291 | 0.512 | 0.463 | 0.333 | 0.255 | 0.273 | 0.069 | 0.149 | 0.026 | 0.915 | 0.857 |
| Current-style federal supreme court | federalism | 10097 | 1.000 | 0.738 | 0.332 | 0.123 | 2.506 | 0.753 | 0.578 | 0.338 | 0.262 | 0.251 | 0.056 | 0.109 | 0.027 | 0.911 | 0.856 |
| Current-style federal supreme court | speech | 10162 | 1.000 | 0.681 | 0.388 | 0.577 | 2.223 | 0.448 | 0.451 | 0.341 | 0.258 | 0.267 | 0.066 | 0.167 | 0.024 | 0.917 | 0.862 |
| Staggered 18-year nonrenewable terms | administrative_state | 9925 | 1.000 | 0.747 | 0.314 | 0.067 | 2.621 | 0.469 | 0.512 | 0.376 | 0.307 | 0.319 | 0.049 | 0.192 | 0.030 | 0.895 | 0.838 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 10037 | 1.000 | 0.683 | 0.373 | 0.531 | 2.337 | 0.562 | 0.489 | 0.337 | 0.263 | 0.258 | 0.067 | 0.140 | 0.028 | 0.904 | 0.845 |
| Staggered 18-year nonrenewable terms | election_law | 10076 | 1.000 | 0.666 | 0.378 | 0.581 | 2.444 | 0.660 | 0.502 | 0.321 | 0.248 | 0.267 | 0.072 | 0.115 | 0.026 | 0.904 | 0.842 |
| Staggered 18-year nonrenewable terms | emergency_powers | 10051 | 1.000 | 0.663 | 0.580 | 0.379 | 2.313 | 0.532 | 0.503 | 0.300 | 0.223 | 0.290 | 0.059 | 0.142 | 0.027 | 0.907 | 0.844 |
| Staggered 18-year nonrenewable terms | equality | 10052 | 1.000 | 0.679 | 0.393 | 0.668 | 2.291 | 0.512 | 0.463 | 0.337 | 0.254 | 0.266 | 0.067 | 0.150 | 0.027 | 0.905 | 0.845 |
| Staggered 18-year nonrenewable terms | federalism | 10097 | 1.000 | 0.747 | 0.327 | 0.089 | 2.506 | 0.753 | 0.578 | 0.349 | 0.278 | 0.241 | 0.059 | 0.117 | 0.029 | 0.900 | 0.842 |
| Staggered 18-year nonrenewable terms | speech | 10162 | 1.000 | 0.686 | 0.377 | 0.547 | 2.223 | 0.448 | 0.451 | 0.341 | 0.265 | 0.264 | 0.065 | 0.173 | 0.025 | 0.907 | 0.849 |
| Fifteen-justice supermajority commission court | administrative_state | 9925 | 1.000 | 0.765 | 0.075 | 0.055 | 2.621 | 0.469 | 0.512 | 0.483 | 0.419 | 0.250 | 0.046 | 0.285 | 0.056 | 0.695 | 0.662 |
| Fifteen-justice supermajority commission court | criminal_procedure | 10037 | 1.000 | 0.728 | 0.091 | 0.590 | 2.337 | 0.562 | 0.489 | 0.456 | 0.386 | 0.208 | 0.065 | 0.239 | 0.050 | 0.709 | 0.670 |
| Fifteen-justice supermajority commission court | election_law | 10076 | 1.000 | 0.723 | 0.077 | 0.633 | 2.444 | 0.660 | 0.502 | 0.459 | 0.385 | 0.196 | 0.068 | 0.213 | 0.048 | 0.714 | 0.671 |
| Fifteen-justice supermajority commission court | emergency_powers | 10051 | 1.000 | 0.727 | 0.157 | 0.394 | 2.313 | 0.532 | 0.503 | 0.451 | 0.380 | 0.212 | 0.055 | 0.252 | 0.051 | 0.709 | 0.668 |
| Fifteen-justice supermajority commission court | equality | 10052 | 1.000 | 0.733 | 0.090 | 0.745 | 2.291 | 0.512 | 0.463 | 0.465 | 0.380 | 0.209 | 0.069 | 0.258 | 0.049 | 0.716 | 0.674 |
| Fifteen-justice supermajority commission court | federalism | 10097 | 1.000 | 0.775 | 0.076 | 0.085 | 2.506 | 0.753 | 0.578 | 0.459 | 0.400 | 0.184 | 0.046 | 0.203 | 0.052 | 0.702 | 0.667 |
| Fifteen-justice supermajority commission court | speech | 10162 | 1.000 | 0.735 | 0.083 | 0.609 | 2.223 | 0.448 | 0.451 | 0.470 | 0.390 | 0.203 | 0.066 | 0.271 | 0.047 | 0.714 | 0.678 |
| Supermajority required to invalidate laws | administrative_state | 9925 | 1.000 | 0.763 | 0.076 | 0.059 | 2.621 | 0.469 | 0.512 | 0.490 | 0.415 | 0.253 | 0.040 | 0.277 | 0.055 | 0.703 | 0.672 |
| Supermajority required to invalidate laws | criminal_procedure | 10037 | 1.000 | 0.725 | 0.094 | 0.544 | 2.337 | 0.562 | 0.489 | 0.461 | 0.386 | 0.201 | 0.059 | 0.239 | 0.049 | 0.714 | 0.676 |
| Supermajority required to invalidate laws | election_law | 10076 | 1.000 | 0.721 | 0.081 | 0.607 | 2.444 | 0.660 | 0.502 | 0.449 | 0.376 | 0.203 | 0.068 | 0.201 | 0.047 | 0.719 | 0.677 |
| Supermajority required to invalidate laws | emergency_powers | 10051 | 1.000 | 0.722 | 0.163 | 0.377 | 2.313 | 0.532 | 0.503 | 0.448 | 0.376 | 0.212 | 0.057 | 0.252 | 0.050 | 0.715 | 0.677 |
| Supermajority required to invalidate laws | equality | 10052 | 1.000 | 0.735 | 0.088 | 0.708 | 2.291 | 0.512 | 0.463 | 0.457 | 0.379 | 0.218 | 0.065 | 0.243 | 0.048 | 0.720 | 0.680 |
| Supermajority required to invalidate laws | federalism | 10097 | 1.000 | 0.773 | 0.079 | 0.078 | 2.506 | 0.753 | 0.578 | 0.467 | 0.385 | 0.191 | 0.049 | 0.197 | 0.051 | 0.708 | 0.674 |
| Supermajority required to invalidate laws | speech | 10162 | 1.000 | 0.732 | 0.086 | 0.558 | 2.223 | 0.448 | 0.451 | 0.479 | 0.388 | 0.203 | 0.061 | 0.275 | 0.046 | 0.718 | 0.681 |
| Strict recusal with substitute justices | administrative_state | 9925 | 1.000 | 0.764 | 0.073 | 0.046 | 2.621 | 0.469 | 0.512 | 0.511 | 0.425 | 0.240 | 0.045 | 0.296 | 0.063 | 0.658 | 0.621 |
| Strict recusal with substitute justices | criminal_procedure | 10037 | 1.000 | 0.728 | 0.092 | 0.567 | 2.337 | 0.562 | 0.489 | 0.468 | 0.405 | 0.189 | 0.060 | 0.252 | 0.057 | 0.669 | 0.626 |
| Strict recusal with substitute justices | election_law | 10076 | 1.000 | 0.724 | 0.075 | 0.608 | 2.444 | 0.660 | 0.502 | 0.474 | 0.394 | 0.200 | 0.066 | 0.226 | 0.054 | 0.675 | 0.629 |
| Strict recusal with substitute justices | emergency_powers | 10051 | 1.000 | 0.727 | 0.153 | 0.369 | 2.313 | 0.532 | 0.503 | 0.480 | 0.402 | 0.198 | 0.056 | 0.269 | 0.056 | 0.669 | 0.626 |
| Strict recusal with substitute justices | equality | 10052 | 1.000 | 0.735 | 0.086 | 0.729 | 2.291 | 0.512 | 0.463 | 0.476 | 0.401 | 0.197 | 0.069 | 0.264 | 0.056 | 0.675 | 0.630 |
| Strict recusal with substitute justices | federalism | 10097 | 1.000 | 0.775 | 0.075 | 0.080 | 2.506 | 0.753 | 0.578 | 0.476 | 0.411 | 0.183 | 0.044 | 0.221 | 0.058 | 0.663 | 0.624 |
| Strict recusal with substitute justices | speech | 10162 | 1.000 | 0.734 | 0.084 | 0.590 | 2.223 | 0.448 | 0.451 | 0.490 | 0.407 | 0.196 | 0.062 | 0.291 | 0.053 | 0.675 | 0.636 |
| Reasoned emergency orders with merits follow-up | administrative_state | 9925 | 1.000 | 0.765 | 0.001 | 0.071 | 2.621 | 0.469 | 0.512 | 0.509 | 0.436 | 0.242 | 0.045 | 0.313 | 0.063 | 0.682 | 0.668 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 10037 | 1.000 | 0.737 | 0.005 | 0.610 | 2.337 | 0.562 | 0.489 | 0.484 | 0.408 | 0.201 | 0.068 | 0.261 | 0.056 | 0.700 | 0.679 |
| Reasoned emergency orders with merits follow-up | election_law | 10076 | 1.000 | 0.725 | 0.008 | 0.664 | 2.444 | 0.660 | 0.502 | 0.474 | 0.397 | 0.207 | 0.073 | 0.224 | 0.054 | 0.704 | 0.678 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 10051 | 1.000 | 0.731 | 0.018 | 0.415 | 2.313 | 0.532 | 0.503 | 0.483 | 0.403 | 0.210 | 0.062 | 0.273 | 0.057 | 0.696 | 0.674 |
| Reasoned emergency orders with merits follow-up | equality | 10052 | 1.000 | 0.742 | 0.008 | 0.760 | 2.291 | 0.512 | 0.463 | 0.485 | 0.408 | 0.212 | 0.072 | 0.270 | 0.054 | 0.705 | 0.680 |
| Reasoned emergency orders with merits follow-up | federalism | 10097 | 1.000 | 0.774 | 0.001 | 0.100 | 2.506 | 0.753 | 0.578 | 0.478 | 0.415 | 0.180 | 0.056 | 0.211 | 0.059 | 0.689 | 0.673 |
| Reasoned emergency orders with merits follow-up | speech | 10162 | 1.000 | 0.741 | 0.007 | 0.626 | 2.223 | 0.448 | 0.451 | 0.496 | 0.411 | 0.202 | 0.068 | 0.297 | 0.053 | 0.703 | 0.684 |
| Panel review with en banc safety valve | administrative_state | 9925 | 1.000 | 0.765 | 0.075 | 0.060 | 2.621 | 0.469 | 0.512 | 0.490 | 0.424 | 0.246 | 0.040 | 0.287 | 0.058 | 0.692 | 0.656 |
| Panel review with en banc safety valve | criminal_procedure | 10037 | 1.000 | 0.727 | 0.092 | 0.605 | 2.337 | 0.562 | 0.489 | 0.461 | 0.388 | 0.204 | 0.066 | 0.236 | 0.051 | 0.709 | 0.667 |
| Panel review with en banc safety valve | election_law | 10076 | 1.000 | 0.724 | 0.076 | 0.637 | 2.444 | 0.660 | 0.502 | 0.456 | 0.379 | 0.209 | 0.066 | 0.205 | 0.051 | 0.713 | 0.669 |
| Panel review with en banc safety valve | emergency_powers | 10051 | 1.000 | 0.729 | 0.155 | 0.398 | 2.313 | 0.532 | 0.503 | 0.459 | 0.380 | 0.209 | 0.061 | 0.253 | 0.053 | 0.705 | 0.664 |
| Panel review with en banc safety valve | equality | 10052 | 1.000 | 0.732 | 0.089 | 0.760 | 2.291 | 0.512 | 0.463 | 0.460 | 0.377 | 0.220 | 0.070 | 0.251 | 0.051 | 0.713 | 0.669 |
| Panel review with en banc safety valve | federalism | 10097 | 1.000 | 0.775 | 0.076 | 0.079 | 2.506 | 0.753 | 0.578 | 0.472 | 0.392 | 0.184 | 0.050 | 0.197 | 0.054 | 0.699 | 0.660 |
| Panel review with en banc safety valve | speech | 10162 | 1.000 | 0.733 | 0.085 | 0.632 | 2.223 | 0.448 | 0.451 | 0.476 | 0.395 | 0.210 | 0.062 | 0.279 | 0.049 | 0.714 | 0.675 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 9925 | 1.000 | 0.764 | 0.003 | 0.013 | 2.621 | 0.469 | 0.512 | 0.555 | 0.480 | 0.216 | 0.035 | 0.340 | 0.077 | 0.585 | 0.540 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 10037 | 1.000 | 0.742 | 0.007 | 0.480 | 2.337 | 0.562 | 0.489 | 0.525 | 0.441 | 0.180 | 0.054 | 0.284 | 0.068 | 0.599 | 0.547 |
| Dual supreme courts with cross-checking invalidations | election_law | 10076 | 1.000 | 0.738 | 0.009 | 0.513 | 2.444 | 0.660 | 0.502 | 0.519 | 0.431 | 0.181 | 0.061 | 0.260 | 0.066 | 0.608 | 0.552 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 10051 | 1.000 | 0.736 | 0.022 | 0.247 | 2.313 | 0.532 | 0.503 | 0.526 | 0.448 | 0.176 | 0.050 | 0.308 | 0.071 | 0.595 | 0.544 |
| Dual supreme courts with cross-checking invalidations | equality | 10052 | 1.000 | 0.751 | 0.011 | 0.663 | 2.291 | 0.512 | 0.463 | 0.524 | 0.444 | 0.182 | 0.061 | 0.317 | 0.068 | 0.606 | 0.552 |
| Dual supreme courts with cross-checking invalidations | federalism | 10097 | 1.000 | 0.777 | 0.002 | 0.018 | 2.506 | 0.753 | 0.578 | 0.533 | 0.455 | 0.159 | 0.043 | 0.253 | 0.073 | 0.589 | 0.540 |
| Dual supreme courts with cross-checking invalidations | speech | 10162 | 1.000 | 0.746 | 0.009 | 0.505 | 2.223 | 0.448 | 0.451 | 0.534 | 0.450 | 0.177 | 0.056 | 0.333 | 0.067 | 0.602 | 0.552 |
| Pre-enactment constitutional council | administrative_state | 9925 | 1.000 | 0.763 | 0.072 | 0.018 | 2.621 | 0.469 | 0.512 | 0.560 | 0.478 | 0.216 | 0.033 | 0.349 | 0.080 | 0.544 | 0.495 |
| Pre-enactment constitutional council | criminal_procedure | 10037 | 1.000 | 0.728 | 0.087 | 0.455 | 2.337 | 0.562 | 0.489 | 0.521 | 0.451 | 0.168 | 0.051 | 0.294 | 0.073 | 0.552 | 0.496 |
| Pre-enactment constitutional council | election_law | 10076 | 1.000 | 0.730 | 0.073 | 0.472 | 2.444 | 0.660 | 0.502 | 0.511 | 0.440 | 0.169 | 0.054 | 0.270 | 0.071 | 0.562 | 0.504 |
| Pre-enactment constitutional council | emergency_powers | 10051 | 1.000 | 0.726 | 0.146 | 0.220 | 2.313 | 0.532 | 0.503 | 0.518 | 0.435 | 0.174 | 0.046 | 0.308 | 0.074 | 0.553 | 0.498 |
| Pre-enactment constitutional council | equality | 10052 | 1.000 | 0.739 | 0.085 | 0.647 | 2.291 | 0.512 | 0.463 | 0.525 | 0.444 | 0.177 | 0.054 | 0.307 | 0.071 | 0.562 | 0.506 |
| Pre-enactment constitutional council | federalism | 10097 | 1.000 | 0.775 | 0.072 | 0.021 | 2.506 | 0.753 | 0.578 | 0.523 | 0.460 | 0.152 | 0.038 | 0.256 | 0.075 | 0.548 | 0.495 |
| Pre-enactment constitutional council | speech | 10162 | 1.000 | 0.733 | 0.081 | 0.491 | 2.223 | 0.448 | 0.451 | 0.537 | 0.453 | 0.171 | 0.050 | 0.339 | 0.069 | 0.558 | 0.505 |
| Judicial review with delayed legislative override | administrative_state | 9925 | 1.000 | 0.764 | 0.076 | 0.076 | 2.621 | 0.469 | 0.512 | 0.487 | 0.400 | 0.264 | 0.046 | 0.280 | 0.054 | 0.728 | 0.691 |
| Judicial review with delayed legislative override | criminal_procedure | 10037 | 1.000 | 0.724 | 0.093 | 0.593 | 2.337 | 0.562 | 0.489 | 0.443 | 0.367 | 0.216 | 0.066 | 0.226 | 0.048 | 0.741 | 0.698 |
| Judicial review with delayed legislative override | election_law | 10076 | 1.000 | 0.719 | 0.079 | 0.644 | 2.444 | 0.660 | 0.502 | 0.426 | 0.352 | 0.217 | 0.077 | 0.198 | 0.045 | 0.743 | 0.697 |
| Judicial review with delayed legislative override | emergency_powers | 10051 | 1.000 | 0.723 | 0.160 | 0.422 | 2.313 | 0.532 | 0.503 | 0.438 | 0.361 | 0.217 | 0.058 | 0.244 | 0.048 | 0.743 | 0.699 |
| Judicial review with delayed legislative override | equality | 10052 | 1.000 | 0.730 | 0.089 | 0.753 | 2.291 | 0.512 | 0.463 | 0.444 | 0.363 | 0.219 | 0.075 | 0.236 | 0.047 | 0.745 | 0.701 |
| Judicial review with delayed legislative override | federalism | 10097 | 1.000 | 0.773 | 0.079 | 0.111 | 2.506 | 0.753 | 0.578 | 0.450 | 0.378 | 0.193 | 0.052 | 0.195 | 0.049 | 0.734 | 0.696 |
| Judicial review with delayed legislative override | speech | 10162 | 1.000 | 0.730 | 0.085 | 0.619 | 2.223 | 0.448 | 0.451 | 0.455 | 0.373 | 0.210 | 0.065 | 0.263 | 0.044 | 0.744 | 0.703 |
| Retention-election accountability court | administrative_state | 9925 | 1.000 | 0.763 | 0.074 | 0.022 | 2.621 | 0.469 | 0.512 | 0.517 | 0.442 | 0.221 | 0.037 | 0.320 | 0.071 | 0.578 | 0.517 |
| Retention-election accountability court | criminal_procedure | 10037 | 1.000 | 0.714 | 0.086 | 0.410 | 2.337 | 0.562 | 0.489 | 0.495 | 0.419 | 0.176 | 0.051 | 0.271 | 0.063 | 0.586 | 0.517 |
| Retention-election accountability court | election_law | 10076 | 1.000 | 0.719 | 0.069 | 0.436 | 2.444 | 0.660 | 0.502 | 0.487 | 0.406 | 0.186 | 0.052 | 0.245 | 0.062 | 0.593 | 0.522 |
| Retention-election accountability court | emergency_powers | 10051 | 1.000 | 0.725 | 0.143 | 0.200 | 2.313 | 0.532 | 0.503 | 0.492 | 0.417 | 0.175 | 0.047 | 0.283 | 0.065 | 0.586 | 0.519 |
| Retention-election accountability court | equality | 10052 | 1.000 | 0.720 | 0.083 | 0.620 | 2.291 | 0.512 | 0.463 | 0.482 | 0.402 | 0.187 | 0.062 | 0.280 | 0.061 | 0.597 | 0.527 |
| Retention-election accountability court | federalism | 10097 | 1.000 | 0.775 | 0.073 | 0.032 | 2.506 | 0.753 | 0.578 | 0.502 | 0.428 | 0.165 | 0.042 | 0.236 | 0.065 | 0.583 | 0.519 |
| Retention-election accountability court | speech | 10162 | 1.000 | 0.717 | 0.080 | 0.458 | 2.223 | 0.448 | 0.451 | 0.488 | 0.416 | 0.175 | 0.055 | 0.304 | 0.061 | 0.592 | 0.525 |
| Hybrid court balancing independence and accountability | administrative_state | 9925 | 1.000 | 0.765 | 0.001 | 0.023 | 2.621 | 0.469 | 0.512 | 0.544 | 0.467 | 0.222 | 0.040 | 0.339 | 0.079 | 0.582 | 0.559 |
| Hybrid court balancing independence and accountability | criminal_procedure | 10037 | 1.000 | 0.742 | 0.004 | 0.530 | 2.337 | 0.562 | 0.489 | 0.525 | 0.444 | 0.181 | 0.059 | 0.293 | 0.070 | 0.595 | 0.563 |
| Hybrid court balancing independence and accountability | election_law | 10076 | 1.000 | 0.736 | 0.007 | 0.537 | 2.444 | 0.660 | 0.502 | 0.515 | 0.423 | 0.183 | 0.063 | 0.253 | 0.070 | 0.605 | 0.571 |
| Hybrid court balancing independence and accountability | emergency_powers | 10051 | 1.000 | 0.734 | 0.016 | 0.268 | 2.313 | 0.532 | 0.503 | 0.526 | 0.440 | 0.175 | 0.053 | 0.306 | 0.073 | 0.591 | 0.561 |
| Hybrid court balancing independence and accountability | equality | 10052 | 1.000 | 0.748 | 0.008 | 0.700 | 2.291 | 0.512 | 0.463 | 0.517 | 0.447 | 0.185 | 0.066 | 0.308 | 0.068 | 0.606 | 0.572 |
| Hybrid court balancing independence and accountability | federalism | 10097 | 1.000 | 0.777 | 0.001 | 0.028 | 2.506 | 0.753 | 0.578 | 0.520 | 0.444 | 0.159 | 0.046 | 0.249 | 0.074 | 0.585 | 0.559 |
| Hybrid court balancing independence and accountability | speech | 10162 | 1.000 | 0.745 | 0.006 | 0.560 | 2.223 | 0.448 | 0.451 | 0.531 | 0.454 | 0.182 | 0.060 | 0.328 | 0.068 | 0.600 | 0.572 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 6436 | 1.000 | 0.706 | 0.379 | 0.318 | 3.000 | 0.394 | 0.478 | 0.375 | 0.277 | 0.286 | 0.054 | 0.215 | 0.027 | 0.908 | 0.852 |
| Current-style federal supreme court | federal/circuit_panel | 17050 | 1.000 | 0.698 | 0.405 | 0.411 | 2.000 | 0.415 | 0.442 | 0.355 | 0.267 | 0.269 | 0.059 | 0.209 | 0.027 | 0.908 | 0.853 |
| Current-style federal supreme court | federal/district_only | 3852 | 1.000 | 0.696 | 0.424 | 0.431 | 1.000 | 0.426 | 0.415 | 0.347 | 0.265 | 0.253 | 0.061 | 0.201 | 0.027 | 0.912 | 0.855 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.678 | 0.405 | 0.453 | 3.000 | 0.777 | 0.567 | 0.312 | 0.221 | 0.297 | 0.062 | 0.071 | 0.023 | 0.920 | 0.864 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.671 | 0.393 | 0.506 | 3.000 | 0.776 | 0.586 | 0.304 | 0.240 | 0.294 | 0.067 | 0.078 | 0.024 | 0.920 | 0.861 |
| Current-style federal supreme court | state/circuit_panel | 4443 | 1.000 | 0.696 | 0.389 | 0.430 | 2.000 | 0.569 | 0.479 | 0.338 | 0.265 | 0.268 | 0.060 | 0.127 | 0.028 | 0.910 | 0.851 |
| Current-style federal supreme court | state/state_federal_split | 6399 | 1.000 | 0.671 | 0.402 | 0.539 | 3.000 | 0.567 | 0.528 | 0.319 | 0.249 | 0.274 | 0.066 | 0.112 | 0.025 | 0.916 | 0.860 |
| Current-style federal supreme court | state/state_high_court | 13733 | 1.000 | 0.692 | 0.393 | 0.446 | 2.000 | 0.569 | 0.488 | 0.337 | 0.258 | 0.266 | 0.064 | 0.116 | 0.026 | 0.913 | 0.856 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 6436 | 1.000 | 0.713 | 0.370 | 0.291 | 3.000 | 0.394 | 0.478 | 0.369 | 0.284 | 0.293 | 0.060 | 0.219 | 0.030 | 0.897 | 0.838 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 17050 | 1.000 | 0.704 | 0.396 | 0.378 | 2.000 | 0.415 | 0.442 | 0.355 | 0.282 | 0.262 | 0.058 | 0.210 | 0.028 | 0.898 | 0.840 |
| Staggered 18-year nonrenewable terms | federal/district_only | 3852 | 1.000 | 0.702 | 0.418 | 0.409 | 1.000 | 0.426 | 0.415 | 0.351 | 0.276 | 0.250 | 0.059 | 0.212 | 0.028 | 0.902 | 0.844 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.688 | 0.400 | 0.425 | 3.000 | 0.777 | 0.567 | 0.313 | 0.242 | 0.283 | 0.062 | 0.083 | 0.025 | 0.912 | 0.853 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.680 | 0.393 | 0.470 | 3.000 | 0.776 | 0.586 | 0.311 | 0.232 | 0.288 | 0.067 | 0.076 | 0.025 | 0.910 | 0.848 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 4443 | 1.000 | 0.703 | 0.382 | 0.398 | 2.000 | 0.569 | 0.479 | 0.337 | 0.266 | 0.250 | 0.067 | 0.131 | 0.029 | 0.900 | 0.838 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 6399 | 1.000 | 0.682 | 0.397 | 0.498 | 3.000 | 0.567 | 0.528 | 0.321 | 0.255 | 0.282 | 0.062 | 0.121 | 0.027 | 0.906 | 0.847 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 13733 | 1.000 | 0.699 | 0.385 | 0.410 | 2.000 | 0.569 | 0.488 | 0.339 | 0.266 | 0.263 | 0.065 | 0.127 | 0.027 | 0.903 | 0.844 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 6436 | 1.000 | 0.748 | 0.089 | 0.342 | 3.000 | 0.394 | 0.478 | 0.484 | 0.411 | 0.217 | 0.054 | 0.330 | 0.055 | 0.698 | 0.662 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 17050 | 1.000 | 0.744 | 0.096 | 0.426 | 2.000 | 0.415 | 0.442 | 0.486 | 0.405 | 0.202 | 0.055 | 0.326 | 0.054 | 0.694 | 0.658 |
| Fifteen-justice supermajority commission court | federal/district_only | 3852 | 1.000 | 0.743 | 0.099 | 0.446 | 1.000 | 0.426 | 0.415 | 0.487 | 0.398 | 0.195 | 0.058 | 0.324 | 0.052 | 0.703 | 0.668 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.739 | 0.095 | 0.464 | 3.000 | 0.777 | 0.567 | 0.437 | 0.367 | 0.223 | 0.057 | 0.161 | 0.045 | 0.724 | 0.684 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.736 | 0.092 | 0.515 | 3.000 | 0.776 | 0.586 | 0.440 | 0.371 | 0.220 | 0.066 | 0.157 | 0.047 | 0.722 | 0.680 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 4443 | 1.000 | 0.743 | 0.089 | 0.442 | 2.000 | 0.569 | 0.479 | 0.460 | 0.395 | 0.203 | 0.063 | 0.223 | 0.052 | 0.704 | 0.661 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 6399 | 1.000 | 0.734 | 0.094 | 0.560 | 3.000 | 0.567 | 0.528 | 0.448 | 0.381 | 0.210 | 0.066 | 0.213 | 0.049 | 0.721 | 0.682 |
| Fifteen-justice supermajority commission court | state/state_high_court | 13733 | 1.000 | 0.742 | 0.090 | 0.466 | 2.000 | 0.569 | 0.488 | 0.460 | 0.396 | 0.203 | 0.058 | 0.224 | 0.049 | 0.709 | 0.671 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 6436 | 1.000 | 0.745 | 0.090 | 0.316 | 3.000 | 0.394 | 0.478 | 0.482 | 0.401 | 0.226 | 0.052 | 0.314 | 0.053 | 0.705 | 0.670 |
| Supermajority required to invalidate laws | federal/circuit_panel | 17050 | 1.000 | 0.741 | 0.098 | 0.390 | 2.000 | 0.415 | 0.442 | 0.484 | 0.404 | 0.203 | 0.051 | 0.322 | 0.052 | 0.699 | 0.665 |
| Supermajority required to invalidate laws | federal/district_only | 3852 | 1.000 | 0.738 | 0.102 | 0.410 | 1.000 | 0.426 | 0.415 | 0.485 | 0.407 | 0.201 | 0.056 | 0.310 | 0.052 | 0.710 | 0.676 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.737 | 0.098 | 0.448 | 3.000 | 0.777 | 0.567 | 0.439 | 0.353 | 0.233 | 0.057 | 0.151 | 0.044 | 0.733 | 0.695 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.734 | 0.096 | 0.492 | 3.000 | 0.776 | 0.586 | 0.444 | 0.362 | 0.222 | 0.063 | 0.159 | 0.046 | 0.726 | 0.684 |
| Supermajority required to invalidate laws | state/circuit_panel | 4443 | 1.000 | 0.741 | 0.091 | 0.412 | 2.000 | 0.569 | 0.479 | 0.474 | 0.392 | 0.204 | 0.059 | 0.222 | 0.050 | 0.709 | 0.669 |
| Supermajority required to invalidate laws | state/state_federal_split | 6399 | 1.000 | 0.732 | 0.097 | 0.546 | 3.000 | 0.567 | 0.528 | 0.452 | 0.373 | 0.216 | 0.058 | 0.209 | 0.048 | 0.725 | 0.686 |
| Supermajority required to invalidate laws | state/state_high_court | 13733 | 1.000 | 0.740 | 0.091 | 0.441 | 2.000 | 0.569 | 0.488 | 0.458 | 0.391 | 0.201 | 0.060 | 0.218 | 0.049 | 0.715 | 0.679 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 6436 | 1.000 | 0.748 | 0.086 | 0.332 | 3.000 | 0.394 | 0.478 | 0.497 | 0.415 | 0.216 | 0.053 | 0.340 | 0.061 | 0.660 | 0.621 |
| Strict recusal with substitute justices | federal/circuit_panel | 17050 | 1.000 | 0.744 | 0.093 | 0.407 | 2.000 | 0.415 | 0.442 | 0.502 | 0.425 | 0.191 | 0.055 | 0.342 | 0.060 | 0.654 | 0.615 |
| Strict recusal with substitute justices | federal/district_only | 3852 | 1.000 | 0.742 | 0.097 | 0.429 | 1.000 | 0.426 | 0.415 | 0.494 | 0.404 | 0.184 | 0.058 | 0.337 | 0.059 | 0.661 | 0.625 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.739 | 0.093 | 0.450 | 3.000 | 0.777 | 0.567 | 0.457 | 0.379 | 0.220 | 0.058 | 0.172 | 0.052 | 0.687 | 0.644 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.737 | 0.092 | 0.493 | 3.000 | 0.776 | 0.586 | 0.468 | 0.388 | 0.211 | 0.062 | 0.172 | 0.052 | 0.682 | 0.636 |
| Strict recusal with substitute justices | state/circuit_panel | 4443 | 1.000 | 0.743 | 0.086 | 0.421 | 2.000 | 0.569 | 0.479 | 0.489 | 0.415 | 0.190 | 0.061 | 0.239 | 0.058 | 0.663 | 0.617 |
| Strict recusal with substitute justices | state/state_federal_split | 6399 | 1.000 | 0.734 | 0.093 | 0.542 | 3.000 | 0.567 | 0.528 | 0.471 | 0.400 | 0.205 | 0.060 | 0.233 | 0.056 | 0.683 | 0.641 |
| Strict recusal with substitute justices | state/state_high_court | 13733 | 1.000 | 0.742 | 0.088 | 0.451 | 2.000 | 0.569 | 0.488 | 0.473 | 0.407 | 0.192 | 0.056 | 0.236 | 0.056 | 0.670 | 0.629 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 6436 | 1.000 | 0.751 | 0.006 | 0.335 | 3.000 | 0.394 | 0.478 | 0.510 | 0.433 | 0.221 | 0.050 | 0.351 | 0.062 | 0.684 | 0.666 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 17050 | 1.000 | 0.749 | 0.007 | 0.428 | 2.000 | 0.415 | 0.442 | 0.515 | 0.432 | 0.197 | 0.058 | 0.349 | 0.060 | 0.681 | 0.665 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 3852 | 1.000 | 0.747 | 0.009 | 0.459 | 1.000 | 0.426 | 0.415 | 0.507 | 0.410 | 0.196 | 0.062 | 0.340 | 0.058 | 0.693 | 0.677 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.742 | 0.006 | 0.468 | 3.000 | 0.777 | 0.567 | 0.458 | 0.389 | 0.207 | 0.072 | 0.171 | 0.052 | 0.715 | 0.692 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.738 | 0.007 | 0.519 | 3.000 | 0.776 | 0.586 | 0.455 | 0.391 | 0.220 | 0.072 | 0.174 | 0.053 | 0.710 | 0.686 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 4443 | 1.000 | 0.749 | 0.006 | 0.447 | 2.000 | 0.569 | 0.479 | 0.496 | 0.410 | 0.194 | 0.061 | 0.246 | 0.059 | 0.694 | 0.671 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 6399 | 1.000 | 0.739 | 0.007 | 0.571 | 3.000 | 0.567 | 0.528 | 0.465 | 0.403 | 0.213 | 0.066 | 0.233 | 0.055 | 0.707 | 0.685 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 13733 | 1.000 | 0.747 | 0.007 | 0.474 | 2.000 | 0.569 | 0.488 | 0.486 | 0.408 | 0.208 | 0.067 | 0.239 | 0.056 | 0.699 | 0.679 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 6436 | 1.000 | 0.748 | 0.089 | 0.346 | 3.000 | 0.394 | 0.478 | 0.484 | 0.412 | 0.224 | 0.050 | 0.330 | 0.056 | 0.696 | 0.656 |
| Panel review with en banc safety valve | federal/circuit_panel | 17050 | 1.000 | 0.744 | 0.095 | 0.440 | 2.000 | 0.415 | 0.442 | 0.491 | 0.405 | 0.205 | 0.054 | 0.326 | 0.055 | 0.692 | 0.654 |
| Panel review with en banc safety valve | federal/district_only | 3852 | 1.000 | 0.743 | 0.099 | 0.464 | 1.000 | 0.426 | 0.415 | 0.488 | 0.411 | 0.195 | 0.057 | 0.319 | 0.054 | 0.701 | 0.664 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.739 | 0.094 | 0.472 | 3.000 | 0.777 | 0.567 | 0.449 | 0.362 | 0.208 | 0.061 | 0.162 | 0.048 | 0.722 | 0.681 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.735 | 0.094 | 0.518 | 3.000 | 0.776 | 0.586 | 0.437 | 0.368 | 0.227 | 0.064 | 0.158 | 0.048 | 0.719 | 0.674 |
| Panel review with en banc safety valve | state/circuit_panel | 4443 | 1.000 | 0.744 | 0.089 | 0.458 | 2.000 | 0.569 | 0.479 | 0.484 | 0.394 | 0.193 | 0.059 | 0.217 | 0.055 | 0.700 | 0.657 |
| Panel review with en banc safety valve | state/state_federal_split | 6399 | 1.000 | 0.734 | 0.095 | 0.562 | 3.000 | 0.567 | 0.528 | 0.450 | 0.379 | 0.225 | 0.064 | 0.216 | 0.052 | 0.718 | 0.678 |
| Panel review with en banc safety valve | state/state_high_court | 13733 | 1.000 | 0.742 | 0.088 | 0.477 | 2.000 | 0.569 | 0.488 | 0.465 | 0.394 | 0.205 | 0.064 | 0.218 | 0.051 | 0.709 | 0.668 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 6436 | 1.000 | 0.752 | 0.008 | 0.239 | 3.000 | 0.394 | 0.478 | 0.552 | 0.465 | 0.196 | 0.047 | 0.382 | 0.076 | 0.585 | 0.537 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 17050 | 1.000 | 0.751 | 0.010 | 0.321 | 2.000 | 0.415 | 0.442 | 0.548 | 0.467 | 0.174 | 0.048 | 0.381 | 0.074 | 0.580 | 0.533 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 3852 | 1.000 | 0.746 | 0.011 | 0.343 | 1.000 | 0.426 | 0.415 | 0.542 | 0.459 | 0.164 | 0.045 | 0.382 | 0.073 | 0.588 | 0.540 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.751 | 0.009 | 0.343 | 3.000 | 0.777 | 0.567 | 0.508 | 0.440 | 0.179 | 0.056 | 0.216 | 0.063 | 0.616 | 0.565 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.750 | 0.009 | 0.390 | 3.000 | 0.776 | 0.586 | 0.508 | 0.424 | 0.191 | 0.058 | 0.210 | 0.066 | 0.614 | 0.558 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 4443 | 1.000 | 0.751 | 0.008 | 0.339 | 2.000 | 0.569 | 0.479 | 0.528 | 0.465 | 0.176 | 0.054 | 0.287 | 0.070 | 0.598 | 0.543 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 6399 | 1.000 | 0.748 | 0.009 | 0.448 | 3.000 | 0.567 | 0.528 | 0.528 | 0.439 | 0.183 | 0.055 | 0.261 | 0.068 | 0.611 | 0.559 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 13733 | 1.000 | 0.751 | 0.008 | 0.358 | 2.000 | 0.569 | 0.488 | 0.530 | 0.448 | 0.181 | 0.050 | 0.275 | 0.069 | 0.599 | 0.547 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 6436 | 1.000 | 0.746 | 0.085 | 0.252 | 3.000 | 0.394 | 0.478 | 0.557 | 0.474 | 0.182 | 0.041 | 0.394 | 0.080 | 0.544 | 0.492 |
| Pre-enactment constitutional council | federal/circuit_panel | 17050 | 1.000 | 0.741 | 0.091 | 0.319 | 2.000 | 0.415 | 0.442 | 0.547 | 0.462 | 0.171 | 0.045 | 0.383 | 0.078 | 0.537 | 0.484 |
| Pre-enactment constitutional council | federal/district_only | 3852 | 1.000 | 0.738 | 0.092 | 0.341 | 1.000 | 0.426 | 0.415 | 0.537 | 0.477 | 0.157 | 0.042 | 0.373 | 0.075 | 0.545 | 0.492 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.744 | 0.089 | 0.352 | 3.000 | 0.777 | 0.567 | 0.504 | 0.428 | 0.185 | 0.050 | 0.207 | 0.065 | 0.573 | 0.517 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.743 | 0.088 | 0.382 | 3.000 | 0.776 | 0.586 | 0.509 | 0.425 | 0.188 | 0.051 | 0.226 | 0.069 | 0.570 | 0.512 |
| Pre-enactment constitutional council | state/circuit_panel | 4443 | 1.000 | 0.742 | 0.083 | 0.345 | 2.000 | 0.569 | 0.479 | 0.528 | 0.467 | 0.165 | 0.047 | 0.282 | 0.075 | 0.550 | 0.494 |
| Pre-enactment constitutional council | state/state_federal_split | 6399 | 1.000 | 0.739 | 0.090 | 0.440 | 3.000 | 0.567 | 0.528 | 0.505 | 0.441 | 0.177 | 0.050 | 0.266 | 0.072 | 0.567 | 0.513 |
| Pre-enactment constitutional council | state/state_high_court | 13733 | 1.000 | 0.742 | 0.084 | 0.355 | 2.000 | 0.569 | 0.488 | 0.526 | 0.455 | 0.169 | 0.046 | 0.276 | 0.072 | 0.557 | 0.503 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 6436 | 1.000 | 0.745 | 0.089 | 0.355 | 3.000 | 0.394 | 0.478 | 0.468 | 0.399 | 0.231 | 0.057 | 0.320 | 0.051 | 0.731 | 0.690 |
| Judicial review with delayed legislative override | federal/circuit_panel | 17050 | 1.000 | 0.741 | 0.097 | 0.438 | 2.000 | 0.415 | 0.442 | 0.472 | 0.389 | 0.208 | 0.059 | 0.318 | 0.050 | 0.726 | 0.687 |
| Judicial review with delayed legislative override | federal/district_only | 3852 | 1.000 | 0.739 | 0.100 | 0.462 | 1.000 | 0.426 | 0.415 | 0.463 | 0.373 | 0.210 | 0.059 | 0.300 | 0.049 | 0.735 | 0.698 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.734 | 0.099 | 0.487 | 3.000 | 0.777 | 0.567 | 0.418 | 0.349 | 0.242 | 0.068 | 0.150 | 0.044 | 0.756 | 0.716 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.731 | 0.096 | 0.528 | 3.000 | 0.776 | 0.586 | 0.415 | 0.348 | 0.230 | 0.068 | 0.151 | 0.045 | 0.752 | 0.705 |
| Judicial review with delayed legislative override | state/circuit_panel | 4443 | 1.000 | 0.740 | 0.089 | 0.459 | 2.000 | 0.569 | 0.479 | 0.454 | 0.369 | 0.212 | 0.063 | 0.215 | 0.050 | 0.736 | 0.691 |
| Judicial review with delayed legislative override | state/state_federal_split | 6399 | 1.000 | 0.730 | 0.095 | 0.569 | 3.000 | 0.567 | 0.528 | 0.440 | 0.356 | 0.229 | 0.069 | 0.201 | 0.047 | 0.750 | 0.706 |
| Judicial review with delayed legislative override | state/state_high_court | 13733 | 1.000 | 0.739 | 0.091 | 0.480 | 2.000 | 0.569 | 0.488 | 0.455 | 0.370 | 0.208 | 0.061 | 0.207 | 0.047 | 0.741 | 0.699 |
| Retention-election accountability court | federal/circuit_en_banc | 6436 | 1.000 | 0.741 | 0.084 | 0.238 | 3.000 | 0.394 | 0.478 | 0.514 | 0.435 | 0.202 | 0.041 | 0.366 | 0.070 | 0.579 | 0.515 |
| Retention-election accountability court | federal/circuit_panel | 17050 | 1.000 | 0.732 | 0.089 | 0.292 | 2.000 | 0.415 | 0.442 | 0.515 | 0.440 | 0.171 | 0.046 | 0.356 | 0.069 | 0.569 | 0.505 |
| Retention-election accountability court | federal/district_only | 3852 | 1.000 | 0.726 | 0.093 | 0.297 | 1.000 | 0.426 | 0.415 | 0.505 | 0.439 | 0.173 | 0.053 | 0.350 | 0.066 | 0.580 | 0.515 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.737 | 0.088 | 0.337 | 3.000 | 0.777 | 0.567 | 0.481 | 0.390 | 0.202 | 0.051 | 0.200 | 0.058 | 0.608 | 0.540 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.735 | 0.087 | 0.384 | 3.000 | 0.776 | 0.586 | 0.470 | 0.386 | 0.198 | 0.054 | 0.196 | 0.059 | 0.603 | 0.534 |
| Retention-election accountability court | state/circuit_panel | 4443 | 1.000 | 0.731 | 0.082 | 0.310 | 2.000 | 0.569 | 0.479 | 0.498 | 0.430 | 0.171 | 0.050 | 0.257 | 0.065 | 0.588 | 0.520 |
| Retention-election accountability court | state/state_federal_split | 6399 | 1.000 | 0.728 | 0.089 | 0.413 | 3.000 | 0.567 | 0.528 | 0.477 | 0.416 | 0.181 | 0.052 | 0.238 | 0.062 | 0.598 | 0.533 |
| Retention-election accountability court | state/state_high_court | 13733 | 1.000 | 0.733 | 0.083 | 0.322 | 2.000 | 0.569 | 0.488 | 0.494 | 0.419 | 0.177 | 0.051 | 0.250 | 0.063 | 0.589 | 0.521 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 6436 | 1.000 | 0.752 | 0.005 | 0.264 | 3.000 | 0.394 | 0.478 | 0.542 | 0.468 | 0.196 | 0.049 | 0.384 | 0.077 | 0.583 | 0.556 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 17050 | 1.000 | 0.750 | 0.007 | 0.357 | 2.000 | 0.415 | 0.442 | 0.545 | 0.464 | 0.172 | 0.053 | 0.376 | 0.076 | 0.578 | 0.552 |
| Hybrid court balancing independence and accountability | federal/district_only | 3852 | 1.000 | 0.748 | 0.008 | 0.388 | 1.000 | 0.426 | 0.415 | 0.538 | 0.453 | 0.177 | 0.053 | 0.363 | 0.074 | 0.586 | 0.560 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 5257 | 1.000 | 0.749 | 0.006 | 0.367 | 3.000 | 0.777 | 0.567 | 0.494 | 0.412 | 0.195 | 0.061 | 0.218 | 0.064 | 0.613 | 0.582 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 13230 | 1.000 | 0.748 | 0.006 | 0.410 | 3.000 | 0.776 | 0.586 | 0.499 | 0.420 | 0.195 | 0.062 | 0.209 | 0.067 | 0.610 | 0.576 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 4443 | 1.000 | 0.751 | 0.006 | 0.376 | 2.000 | 0.569 | 0.479 | 0.542 | 0.451 | 0.174 | 0.049 | 0.285 | 0.074 | 0.592 | 0.559 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 6399 | 1.000 | 0.746 | 0.007 | 0.474 | 3.000 | 0.567 | 0.528 | 0.516 | 0.436 | 0.190 | 0.058 | 0.263 | 0.069 | 0.609 | 0.580 |
| Hybrid court balancing independence and accountability | state/state_high_court | 13733 | 1.000 | 0.750 | 0.006 | 0.389 | 2.000 | 0.569 | 0.488 | 0.528 | 0.450 | 0.179 | 0.053 | 0.273 | 0.070 | 0.596 | 0.567 |

## Composition Diagnostics

| Scenario | Period | Observations | Size | Median ideology | Spread | Partisan attach. | Rights sens. | Institutionalism | Replacement events |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 880 | 9.000 | 0.066 | 1.344 | 0.638 | 0.707 | 0.797 | 0.000 |
| Current-style federal supreme court | 2 | 880 | 9.000 | 0.072 | 1.353 | 0.636 | 0.707 | 0.797 | 1.307 |
| Current-style federal supreme court | 3 | 880 | 9.000 | 0.072 | 1.363 | 0.638 | 0.705 | 0.797 | 1.307 |
| Current-style federal supreme court | 4 | 880 | 9.000 | 0.067 | 1.356 | 0.637 | 0.706 | 0.797 | 1.307 |
| Staggered 18-year nonrenewable terms | 1 | 880 | 9.000 | 0.033 | 1.337 | 0.618 | 0.706 | 0.781 | 0.000 |
| Staggered 18-year nonrenewable terms | 2 | 880 | 9.000 | 0.031 | 1.356 | 0.617 | 0.707 | 0.780 | 3.258 |
| Staggered 18-year nonrenewable terms | 3 | 880 | 9.000 | 0.037 | 1.365 | 0.619 | 0.708 | 0.781 | 3.258 |
| Staggered 18-year nonrenewable terms | 4 | 880 | 9.000 | 0.040 | 1.371 | 0.618 | 0.707 | 0.780 | 3.258 |
| Fifteen-justice supermajority commission court | 1 | 880 | 15.000 | 0.001 | 0.819 | 0.532 | 0.733 | 0.778 | 0.000 |
| Fifteen-justice supermajority commission court | 2 | 880 | 15.000 | 0.005 | 0.851 | 0.531 | 0.733 | 0.778 | 6.798 |
| Fifteen-justice supermajority commission court | 3 | 880 | 15.000 | -0.007 | 0.886 | 0.531 | 0.732 | 0.779 | 6.798 |
| Fifteen-justice supermajority commission court | 4 | 880 | 15.000 | -0.000 | 0.923 | 0.532 | 0.732 | 0.779 | 6.798 |
| Supermajority required to invalidate laws | 1 | 880 | 9.000 | 0.054 | 1.346 | 0.613 | 0.700 | 0.843 | 0.000 |
| Supermajority required to invalidate laws | 2 | 880 | 9.000 | 0.056 | 1.354 | 0.613 | 0.699 | 0.843 | 1.357 |
| Supermajority required to invalidate laws | 3 | 880 | 9.000 | 0.058 | 1.356 | 0.613 | 0.700 | 0.843 | 1.357 |
| Supermajority required to invalidate laws | 4 | 880 | 9.000 | 0.054 | 1.361 | 0.613 | 0.700 | 0.843 | 1.357 |
| Strict recusal with substitute justices | 1 | 880 | 12.000 | -0.001 | 0.809 | 0.531 | 0.733 | 0.767 | 0.000 |
| Strict recusal with substitute justices | 2 | 880 | 12.000 | 0.002 | 0.836 | 0.531 | 0.732 | 0.768 | 5.506 |
| Strict recusal with substitute justices | 3 | 880 | 12.000 | 0.000 | 0.864 | 0.532 | 0.733 | 0.767 | 5.506 |
| Strict recusal with substitute justices | 4 | 880 | 12.000 | 0.008 | 0.895 | 0.532 | 0.731 | 0.767 | 5.506 |
| Reasoned emergency orders with merits follow-up | 1 | 880 | 9.000 | 0.029 | 1.350 | 0.594 | 0.730 | 0.798 | 0.000 |
| Reasoned emergency orders with merits follow-up | 2 | 880 | 9.000 | 0.029 | 1.354 | 0.594 | 0.729 | 0.799 | 3.258 |
| Reasoned emergency orders with merits follow-up | 3 | 880 | 9.000 | 0.026 | 1.366 | 0.594 | 0.730 | 0.799 | 3.258 |
| Reasoned emergency orders with merits follow-up | 4 | 880 | 9.000 | 0.028 | 1.364 | 0.594 | 0.730 | 0.799 | 3.258 |
| Panel review with en banc safety valve | 1 | 880 | 15.000 | 0.001 | 0.631 | 0.503 | 0.736 | 0.748 | 0.000 |
| Panel review with en banc safety valve | 2 | 880 | 15.000 | -0.002 | 0.664 | 0.503 | 0.736 | 0.749 | 6.882 |
| Panel review with en banc safety valve | 3 | 880 | 15.000 | 0.001 | 0.710 | 0.503 | 0.735 | 0.749 | 6.882 |
| Panel review with en banc safety valve | 4 | 880 | 15.000 | 0.005 | 0.757 | 0.503 | 0.735 | 0.749 | 6.882 |
| Dual supreme courts with cross-checking invalidations | 1 | 880 | 18.000 | -0.000 | 0.841 | 0.512 | 0.748 | 0.804 | 0.000 |
| Dual supreme courts with cross-checking invalidations | 2 | 880 | 18.000 | 0.011 | 0.864 | 0.513 | 0.749 | 0.805 | 8.208 |
| Dual supreme courts with cross-checking invalidations | 3 | 880 | 18.000 | -0.001 | 0.903 | 0.513 | 0.748 | 0.805 | 8.208 |
| Dual supreme courts with cross-checking invalidations | 4 | 880 | 18.000 | 0.001 | 0.949 | 0.512 | 0.747 | 0.804 | 8.208 |
| Pre-enactment constitutional council | 1 | 880 | 12.000 | 0.000 | 0.625 | 0.479 | 0.766 | 0.794 | 0.000 |
| Pre-enactment constitutional council | 2 | 880 | 12.000 | 0.010 | 0.677 | 0.480 | 0.765 | 0.794 | 8.604 |
| Pre-enactment constitutional council | 3 | 880 | 12.000 | -0.007 | 0.725 | 0.479 | 0.766 | 0.794 | 8.604 |
| Pre-enactment constitutional council | 4 | 880 | 12.000 | 0.007 | 0.792 | 0.479 | 0.763 | 0.794 | 8.604 |
| Judicial review with delayed legislative override | 1 | 880 | 9.000 | 0.036 | 1.340 | 0.599 | 0.715 | 0.755 | 0.000 |
| Judicial review with delayed legislative override | 2 | 880 | 9.000 | 0.032 | 1.355 | 0.599 | 0.714 | 0.756 | 3.460 |
| Judicial review with delayed legislative override | 3 | 880 | 9.000 | 0.043 | 1.358 | 0.598 | 0.715 | 0.755 | 3.460 |
| Judicial review with delayed legislative override | 4 | 880 | 9.000 | 0.042 | 1.381 | 0.599 | 0.713 | 0.756 | 3.460 |
| Retention-election accountability court | 1 | 880 | 9.000 | 0.024 | 1.129 | 0.588 | 0.695 | 0.675 | 0.000 |
| Retention-election accountability court | 2 | 880 | 9.000 | 0.029 | 1.177 | 0.588 | 0.695 | 0.677 | 8.363 |
| Retention-election accountability court | 3 | 880 | 9.000 | 0.022 | 1.206 | 0.589 | 0.694 | 0.676 | 8.363 |
| Retention-election accountability court | 4 | 880 | 9.000 | 0.030 | 1.274 | 0.588 | 0.693 | 0.676 | 8.363 |
| Hybrid court balancing independence and accountability | 1 | 880 | 15.000 | -0.001 | 0.839 | 0.503 | 0.756 | 0.802 | 0.000 |
| Hybrid court balancing independence and accountability | 2 | 880 | 15.000 | 0.005 | 0.853 | 0.502 | 0.755 | 0.802 | 6.966 |
| Hybrid court balancing independence and accountability | 3 | 880 | 15.000 | -0.012 | 0.883 | 0.503 | 0.755 | 0.803 | 6.966 |
| Hybrid court balancing independence and accountability | 4 | 880 | 15.000 | -0.003 | 0.935 | 0.503 | 0.755 | 0.802 | 6.966 |

## Calibration Diagnostics

| Target | Observed | Range | Gap | Status |
| --- | ---: | ---: | ---: | --- |
| Speech docket share | 0.144 | 0.080-0.200 | 0.000 | within |
| Equality docket share | 0.143 | 0.080-0.200 | 0.000 | within |
| Criminal procedure docket share | 0.143 | 0.080-0.200 | 0.000 | within |
| Federalism docket share | 0.143 | 0.060-0.180 | 0.000 | within |
| Election law docket share | 0.143 | 0.050-0.160 | 0.000 | within |
| Emergency powers docket share | 0.143 | 0.040-0.140 | 0.003 | outside |
| Administrative state docket share | 0.141 | 0.060-0.180 | 0.000 | within |
| Emergency relief rate | 0.507 | 0.050-0.240 | 0.267 | outside |
| Compliance rate | 0.464 | 0.700-0.950 | 0.236 | outside |
| Legitimacy response to trust | 1.210 | 0.150-1.200 | 0.010 | outside |
