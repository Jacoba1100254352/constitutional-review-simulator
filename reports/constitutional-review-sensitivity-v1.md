# Constitutional Review Sensitivity Campaign v1

- runs per case: 80
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Baseline

Baseline assumptions for sensitivity comparison.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.849
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.744
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.095
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.880
- lowest defiance rate: Reasoned emergency orders with merits follow-up at 0.009

### Low emergency pressure

Lower urgency and emergency docket pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.864
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.743
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.000
- lowest emergency relief rate: Retention-election accountability court at 0.023
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.879
- lowest defiance rate: Strict recusal with substitute justices at 0.008

### High emergency pressure

Higher urgency and emergency docket pressure.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.823
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.744
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.028
- lowest emergency relief rate: Retention-election accountability court at 0.122
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.827
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.025

### Low appointment polarization

Lower appointment ideology spread and partisan pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.862
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.745
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.068
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.895
- lowest defiance rate: Reasoned emergency orders with merits follow-up at 0.008

### High appointment polarization

Higher appointment ideology spread and partisan pressure.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.831
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.745
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.155
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.860
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.015

### Low rights threat

Lower share of cases with generated rights-risk signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.879
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.804
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.000
- lowest emergency relief rate: Retention-election accountability court at 0.024
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.897
- lowest defiance rate: Reasoned emergency orders with merits follow-up at 0.006

### High rights threat

Higher share of cases with generated rights-risk signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.747
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.736
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.007
- lowest emergency relief rate: Retention-election accountability court at 0.447
- highest compliance rate: Pre-enactment constitutional council at 0.740
- lowest defiance rate: Pre-enactment constitutional council at 0.054

### High public trust

High initial trust and lower institutional conflict.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.862
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.745
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.102
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.913
- lowest defiance rate: Reasoned emergency orders with merits follow-up at 0.003

### Low public trust

Low initial trust and higher institutional conflict.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.820
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.740
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.101
- highest compliance rate: Pre-enactment constitutional council at 0.752
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.047

### Low legislative conflict

Lower legislature-court conflict pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.856
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.746
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.098
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.888
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.006

### High legislative conflict

Higher legislature-court conflict pressure and lower trust.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.814
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.740
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.131
- highest compliance rate: Pre-enactment constitutional council at 0.714
- lowest defiance rate: Pre-enactment constitutional council at 0.056

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Defiance | Trust | Curbing | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.733 | 0.853 | 0.725 | 0.149 | 0.369 | 0.381 | 0.204 | 0.629 | 0.118 | 0.205 | 0.442 | 0.631 | 0.125 | 0.125 | 0.380 | 0.358 |
| Staggered 18-year nonrenewable terms | 0.748 | 0.860 | 0.726 | 0.136 | 0.364 | 0.343 | 0.180 | 0.640 | 0.104 | 0.202 | 0.446 | 0.641 | 0.119 | 0.145 | 0.353 | 0.366 |
| Fifteen-justice supermajority commission court | 0.818 | 0.940 | 0.743 | 0.113 | 0.083 | 0.201 | 0.215 | 0.789 | 0.167 | 0.119 | 0.469 | 0.790 | 0.038 | 0.539 | 0.123 | 0.355 |
| Supermajority required to invalidate laws | 0.811 | 0.949 | 0.737 | 0.125 | 0.085 | 0.216 | 0.181 | 0.765 | 0.141 | 0.118 | 0.465 | 0.793 | 0.038 | 0.522 | 0.115 | 0.335 |
| Strict recusal with substitute justices | 0.823 | 0.941 | 0.741 | 0.113 | 0.081 | 0.199 | 0.203 | 0.811 | 0.158 | 0.117 | 0.469 | 0.804 | 0.033 | 0.572 | 0.100 | 0.356 |
| Reasoned emergency orders with merits follow-up | 0.822 | 0.949 | 0.748 | 0.124 | 0.004 | 0.221 | 0.220 | 0.836 | 0.220 | 0.100 | 0.472 | 0.827 | 0.026 | 0.616 | 0.100 | 0.342 |
| Panel review with en banc safety valve | 0.811 | 0.938 | 0.744 | 0.113 | 0.082 | 0.203 | 0.228 | 0.803 | 0.178 | 0.119 | 0.470 | 0.794 | 0.036 | 0.548 | 0.121 | 0.474 |
| Dual supreme courts with cross-checking invalidations | 0.816 | 0.963 | 0.741 | 0.103 | 0.007 | 0.165 | 0.152 | 0.847 | 0.152 | 0.106 | 0.471 | 0.833 | 0.024 | 0.660 | 0.059 | 0.739 |
| Pre-enactment constitutional council | 0.822 | 0.973 | 0.735 | 0.098 | 0.079 | 0.196 | 0.152 | 0.839 | 0.119 | 0.114 | 0.467 | 0.822 | 0.026 | 0.635 | 0.056 | 0.609 |
| Judicial review with delayed legislative override | 0.813 | 0.934 | 0.741 | 0.121 | 0.084 | 0.220 | 0.223 | 0.779 | 0.173 | 0.121 | 0.469 | 0.779 | 0.043 | 0.505 | 0.140 | 0.348 |
| Retention-election accountability court | 0.833 | 0.948 | 0.727 | 0.114 | 0.079 | 0.124 | 0.124 | 0.804 | 0.097 | 0.114 | 0.468 | 0.800 | 0.031 | 0.595 | 0.049 | 0.368 |
| Hybrid court balancing independence and accountability | 0.832 | 0.963 | 0.744 | 0.105 | 0.004 | 0.187 | 0.180 | 0.850 | 0.180 | 0.096 | 0.472 | 0.830 | 0.023 | 0.665 | 0.069 | 0.463 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Compliance | Defiance | Workaround | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 17600 | 0.999 | 0.725 | 0.368 | 0.206 | 0.680 | 0.094 | 0.059 | 0.286 | 0.404 | 0.208 |
| Current-style federal supreme court | 2 | 17600 | 0.999 | 0.726 | 0.369 | 0.203 | 0.635 | 0.123 | 0.092 | 0.103 | 0.382 | 0.404 |
| Current-style federal supreme court | 3 | 17600 | 0.999 | 0.725 | 0.372 | 0.200 | 0.605 | 0.141 | 0.101 | 0.062 | 0.386 | 0.448 |
| Current-style federal supreme court | 4 | 17600 | 0.999 | 0.723 | 0.367 | 0.207 | 0.603 | 0.144 | 0.102 | 0.049 | 0.391 | 0.460 |
| Staggered 18-year nonrenewable terms | 1 | 17600 | 0.999 | 0.726 | 0.366 | 0.179 | 0.689 | 0.089 | 0.060 | 0.305 | 0.386 | 0.188 |
| Staggered 18-year nonrenewable terms | 2 | 17600 | 0.999 | 0.727 | 0.363 | 0.178 | 0.641 | 0.118 | 0.083 | 0.129 | 0.352 | 0.372 |
| Staggered 18-year nonrenewable terms | 3 | 17600 | 0.999 | 0.726 | 0.364 | 0.180 | 0.620 | 0.132 | 0.097 | 0.082 | 0.353 | 0.423 |
| Staggered 18-year nonrenewable terms | 4 | 17600 | 1.000 | 0.725 | 0.365 | 0.184 | 0.613 | 0.135 | 0.099 | 0.063 | 0.353 | 0.429 |
| Fifteen-justice supermajority commission court | 1 | 17600 | 0.998 | 0.743 | 0.083 | 0.219 | 0.773 | 0.046 | 0.048 | 0.516 | 0.246 | 0.115 |
| Fifteen-justice supermajority commission court | 2 | 17600 | 0.999 | 0.743 | 0.083 | 0.212 | 0.795 | 0.036 | 0.052 | 0.524 | 0.093 | 0.140 |
| Fifteen-justice supermajority commission court | 3 | 17600 | 0.998 | 0.743 | 0.083 | 0.210 | 0.793 | 0.035 | 0.057 | 0.551 | 0.054 | 0.125 |
| Fifteen-justice supermajority commission court | 4 | 17600 | 0.999 | 0.742 | 0.081 | 0.216 | 0.798 | 0.035 | 0.059 | 0.564 | 0.049 | 0.112 |
| Supermajority required to invalidate laws | 1 | 17600 | 0.999 | 0.737 | 0.086 | 0.183 | 0.767 | 0.048 | 0.045 | 0.507 | 0.246 | 0.112 |
| Supermajority required to invalidate laws | 2 | 17600 | 0.999 | 0.738 | 0.087 | 0.179 | 0.798 | 0.037 | 0.050 | 0.503 | 0.092 | 0.132 |
| Supermajority required to invalidate laws | 3 | 17600 | 0.998 | 0.738 | 0.085 | 0.178 | 0.803 | 0.033 | 0.054 | 0.531 | 0.053 | 0.115 |
| Supermajority required to invalidate laws | 4 | 17600 | 0.999 | 0.737 | 0.082 | 0.184 | 0.803 | 0.034 | 0.057 | 0.545 | 0.049 | 0.103 |
| Strict recusal with substitute justices | 1 | 17600 | 0.998 | 0.741 | 0.081 | 0.207 | 0.779 | 0.041 | 0.046 | 0.537 | 0.237 | 0.106 |
| Strict recusal with substitute justices | 2 | 17600 | 0.998 | 0.742 | 0.081 | 0.199 | 0.806 | 0.033 | 0.051 | 0.562 | 0.077 | 0.115 |
| Strict recusal with substitute justices | 3 | 17600 | 0.998 | 0.741 | 0.081 | 0.200 | 0.814 | 0.029 | 0.052 | 0.588 | 0.040 | 0.095 |
| Strict recusal with substitute justices | 4 | 17600 | 0.999 | 0.740 | 0.079 | 0.204 | 0.819 | 0.028 | 0.053 | 0.601 | 0.034 | 0.083 |
| Reasoned emergency orders with merits follow-up | 1 | 17600 | 0.999 | 0.748 | 0.004 | 0.221 | 0.796 | 0.040 | 0.048 | 0.569 | 0.225 | 0.112 |
| Reasoned emergency orders with merits follow-up | 2 | 17600 | 0.998 | 0.749 | 0.004 | 0.216 | 0.835 | 0.024 | 0.046 | 0.613 | 0.057 | 0.116 |
| Reasoned emergency orders with merits follow-up | 3 | 17600 | 0.998 | 0.748 | 0.004 | 0.219 | 0.836 | 0.021 | 0.049 | 0.637 | 0.026 | 0.092 |
| Reasoned emergency orders with merits follow-up | 4 | 17600 | 0.998 | 0.748 | 0.005 | 0.223 | 0.843 | 0.019 | 0.050 | 0.644 | 0.024 | 0.079 |
| Panel review with en banc safety valve | 1 | 17600 | 1.000 | 0.744 | 0.082 | 0.233 | 0.777 | 0.044 | 0.046 | 0.522 | 0.246 | 0.115 |
| Panel review with en banc safety valve | 2 | 17600 | 1.000 | 0.744 | 0.082 | 0.226 | 0.800 | 0.036 | 0.053 | 0.535 | 0.092 | 0.139 |
| Panel review with en banc safety valve | 3 | 17600 | 1.000 | 0.744 | 0.083 | 0.225 | 0.795 | 0.031 | 0.060 | 0.561 | 0.052 | 0.123 |
| Panel review with en banc safety valve | 4 | 17600 | 1.000 | 0.743 | 0.080 | 0.228 | 0.803 | 0.032 | 0.058 | 0.575 | 0.046 | 0.108 |
| Dual supreme courts with cross-checking invalidations | 1 | 17600 | 1.000 | 0.741 | 0.007 | 0.154 | 0.796 | 0.039 | 0.043 | 0.593 | 0.210 | 0.088 |
| Dual supreme courts with cross-checking invalidations | 2 | 17600 | 1.000 | 0.742 | 0.007 | 0.151 | 0.837 | 0.022 | 0.040 | 0.661 | 0.040 | 0.069 |
| Dual supreme courts with cross-checking invalidations | 3 | 17600 | 1.000 | 0.741 | 0.007 | 0.149 | 0.846 | 0.018 | 0.041 | 0.689 | 0.014 | 0.045 |
| Dual supreme courts with cross-checking invalidations | 4 | 17600 | 1.000 | 0.740 | 0.007 | 0.154 | 0.851 | 0.018 | 0.040 | 0.698 | 0.011 | 0.036 |
| Pre-enactment constitutional council | 1 | 17600 | 1.000 | 0.735 | 0.080 | 0.153 | 0.790 | 0.040 | 0.042 | 0.581 | 0.216 | 0.086 |
| Pre-enactment constitutional council | 2 | 17600 | 1.000 | 0.735 | 0.079 | 0.151 | 0.830 | 0.022 | 0.044 | 0.632 | 0.048 | 0.065 |
| Pre-enactment constitutional council | 3 | 17600 | 1.000 | 0.735 | 0.080 | 0.151 | 0.835 | 0.020 | 0.042 | 0.656 | 0.017 | 0.040 |
| Pre-enactment constitutional council | 4 | 17600 | 1.000 | 0.734 | 0.077 | 0.153 | 0.832 | 0.021 | 0.043 | 0.673 | 0.013 | 0.032 |
| Judicial review with delayed legislative override | 1 | 17600 | 0.999 | 0.742 | 0.084 | 0.228 | 0.762 | 0.049 | 0.050 | 0.500 | 0.254 | 0.121 |
| Judicial review with delayed legislative override | 2 | 17600 | 0.999 | 0.742 | 0.084 | 0.218 | 0.786 | 0.040 | 0.055 | 0.491 | 0.105 | 0.156 |
| Judicial review with delayed legislative override | 3 | 17600 | 0.998 | 0.742 | 0.085 | 0.222 | 0.784 | 0.040 | 0.060 | 0.509 | 0.067 | 0.148 |
| Judicial review with delayed legislative override | 4 | 17600 | 0.998 | 0.741 | 0.081 | 0.225 | 0.784 | 0.042 | 0.061 | 0.521 | 0.064 | 0.134 |
| Retention-election accountability court | 1 | 17600 | 0.999 | 0.727 | 0.079 | 0.126 | 0.761 | 0.045 | 0.045 | 0.555 | 0.220 | 0.084 |
| Retention-election accountability court | 2 | 17600 | 0.998 | 0.728 | 0.079 | 0.121 | 0.802 | 0.030 | 0.043 | 0.590 | 0.047 | 0.059 |
| Retention-election accountability court | 3 | 17600 | 0.999 | 0.727 | 0.078 | 0.126 | 0.814 | 0.025 | 0.045 | 0.614 | 0.015 | 0.031 |
| Retention-election accountability court | 4 | 17600 | 0.999 | 0.726 | 0.078 | 0.125 | 0.823 | 0.023 | 0.045 | 0.621 | 0.010 | 0.022 |
| Hybrid court balancing independence and accountability | 1 | 17600 | 1.000 | 0.745 | 0.004 | 0.181 | 0.792 | 0.035 | 0.045 | 0.596 | 0.209 | 0.095 |
| Hybrid court balancing independence and accountability | 2 | 17600 | 1.000 | 0.745 | 0.004 | 0.177 | 0.833 | 0.022 | 0.043 | 0.668 | 0.040 | 0.079 |
| Hybrid court balancing independence and accountability | 3 | 17600 | 1.000 | 0.745 | 0.004 | 0.178 | 0.845 | 0.017 | 0.044 | 0.693 | 0.015 | 0.056 |
| Hybrid court balancing independence and accountability | 4 | 17600 | 1.000 | 0.743 | 0.004 | 0.182 | 0.848 | 0.016 | 0.043 | 0.701 | 0.012 | 0.047 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Compliance | Defiance | Workaround | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 10169 | 0.997 | 0.766 | 0.295 | 0.003 | 0.663 | 0.107 | 0.076 | 0.135 | 0.380 | 0.375 |
| Current-style federal supreme court | criminal_procedure | 10138 | 0.999 | 0.703 | 0.353 | 0.265 | 0.618 | 0.127 | 0.096 | 0.124 | 0.397 | 0.389 |
| Current-style federal supreme court | election_law | 10047 | 1.000 | 0.706 | 0.360 | 0.245 | 0.629 | 0.127 | 0.089 | 0.124 | 0.386 | 0.374 |
| Current-style federal supreme court | emergency_powers | 9747 | 1.000 | 0.711 | 0.537 | 0.104 | 0.612 | 0.133 | 0.088 | 0.127 | 0.393 | 0.376 |
| Current-style federal supreme court | equality | 10125 | 1.000 | 0.704 | 0.387 | 0.466 | 0.612 | 0.142 | 0.099 | 0.115 | 0.404 | 0.389 |
| Current-style federal supreme court | federalism | 10175 | 0.998 | 0.777 | 0.294 | 0.001 | 0.662 | 0.109 | 0.075 | 0.131 | 0.374 | 0.368 |
| Current-style federal supreme court | speech | 9999 | 0.999 | 0.705 | 0.362 | 0.325 | 0.619 | 0.134 | 0.097 | 0.119 | 0.401 | 0.390 |
| Staggered 18-year nonrenewable terms | administrative_state | 10169 | 0.998 | 0.767 | 0.293 | 0.003 | 0.668 | 0.100 | 0.075 | 0.155 | 0.350 | 0.347 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 10138 | 0.999 | 0.701 | 0.350 | 0.224 | 0.627 | 0.121 | 0.090 | 0.144 | 0.367 | 0.361 |
| Staggered 18-year nonrenewable terms | election_law | 10047 | 1.000 | 0.708 | 0.351 | 0.203 | 0.637 | 0.116 | 0.088 | 0.145 | 0.357 | 0.348 |
| Staggered 18-year nonrenewable terms | emergency_powers | 9747 | 1.000 | 0.716 | 0.527 | 0.078 | 0.627 | 0.133 | 0.082 | 0.147 | 0.361 | 0.345 |
| Staggered 18-year nonrenewable terms | equality | 10125 | 1.000 | 0.706 | 0.384 | 0.439 | 0.620 | 0.131 | 0.093 | 0.134 | 0.376 | 0.363 |
| Staggered 18-year nonrenewable terms | federalism | 10175 | 0.998 | 0.777 | 0.294 | 0.000 | 0.679 | 0.103 | 0.073 | 0.152 | 0.344 | 0.343 |
| Staggered 18-year nonrenewable terms | speech | 9999 | 0.999 | 0.705 | 0.358 | 0.296 | 0.625 | 0.126 | 0.092 | 0.139 | 0.371 | 0.364 |
| Fifteen-justice supermajority commission court | administrative_state | 10169 | 0.996 | 0.767 | 0.073 | 0.001 | 0.804 | 0.036 | 0.044 | 0.547 | 0.106 | 0.118 |
| Fifteen-justice supermajority commission court | criminal_procedure | 10138 | 0.999 | 0.719 | 0.080 | 0.264 | 0.783 | 0.039 | 0.055 | 0.531 | 0.113 | 0.127 |
| Fifteen-justice supermajority commission court | election_law | 10047 | 1.000 | 0.730 | 0.064 | 0.224 | 0.792 | 0.038 | 0.054 | 0.546 | 0.109 | 0.123 |
| Fifteen-justice supermajority commission court | emergency_powers | 9747 | 1.000 | 0.730 | 0.135 | 0.075 | 0.789 | 0.036 | 0.051 | 0.544 | 0.110 | 0.118 |
| Fifteen-justice supermajority commission court | equality | 10125 | 0.999 | 0.744 | 0.081 | 0.515 | 0.770 | 0.044 | 0.066 | 0.523 | 0.121 | 0.133 |
| Fifteen-justice supermajority commission court | federalism | 10175 | 0.998 | 0.778 | 0.072 | 0.000 | 0.808 | 0.034 | 0.046 | 0.555 | 0.101 | 0.112 |
| Fifteen-justice supermajority commission court | speech | 9999 | 0.998 | 0.729 | 0.075 | 0.340 | 0.782 | 0.040 | 0.062 | 0.527 | 0.115 | 0.131 |
| Supermajority required to invalidate laws | administrative_state | 10169 | 0.997 | 0.767 | 0.074 | 0.000 | 0.804 | 0.030 | 0.050 | 0.531 | 0.106 | 0.111 |
| Supermajority required to invalidate laws | criminal_procedure | 10138 | 0.998 | 0.709 | 0.081 | 0.214 | 0.784 | 0.038 | 0.056 | 0.514 | 0.111 | 0.116 |
| Supermajority required to invalidate laws | election_law | 10047 | 0.999 | 0.724 | 0.067 | 0.192 | 0.798 | 0.042 | 0.049 | 0.527 | 0.107 | 0.115 |
| Supermajority required to invalidate laws | emergency_powers | 9747 | 1.000 | 0.728 | 0.140 | 0.066 | 0.784 | 0.041 | 0.050 | 0.524 | 0.111 | 0.115 |
| Supermajority required to invalidate laws | equality | 10125 | 0.999 | 0.736 | 0.081 | 0.447 | 0.782 | 0.042 | 0.058 | 0.508 | 0.120 | 0.125 |
| Supermajority required to invalidate laws | federalism | 10175 | 0.997 | 0.778 | 0.075 | 0.000 | 0.812 | 0.033 | 0.045 | 0.538 | 0.101 | 0.105 |
| Supermajority required to invalidate laws | speech | 9999 | 0.998 | 0.718 | 0.077 | 0.276 | 0.784 | 0.040 | 0.054 | 0.510 | 0.113 | 0.121 |
| Strict recusal with substitute justices | administrative_state | 10169 | 0.996 | 0.767 | 0.070 | 0.001 | 0.814 | 0.029 | 0.046 | 0.580 | 0.093 | 0.095 |
| Strict recusal with substitute justices | criminal_procedure | 10138 | 0.999 | 0.716 | 0.079 | 0.247 | 0.801 | 0.036 | 0.052 | 0.565 | 0.098 | 0.101 |
| Strict recusal with substitute justices | election_law | 10047 | 1.000 | 0.727 | 0.062 | 0.204 | 0.809 | 0.030 | 0.051 | 0.577 | 0.095 | 0.098 |
| Strict recusal with substitute justices | emergency_powers | 9747 | 1.000 | 0.729 | 0.133 | 0.068 | 0.804 | 0.035 | 0.045 | 0.576 | 0.098 | 0.098 |
| Strict recusal with substitute justices | equality | 10125 | 1.000 | 0.742 | 0.078 | 0.493 | 0.792 | 0.036 | 0.058 | 0.557 | 0.107 | 0.110 |
| Strict recusal with substitute justices | federalism | 10175 | 0.997 | 0.778 | 0.070 | 0.000 | 0.817 | 0.029 | 0.043 | 0.586 | 0.089 | 0.090 |
| Strict recusal with substitute justices | speech | 9999 | 0.998 | 0.726 | 0.073 | 0.328 | 0.794 | 0.036 | 0.057 | 0.562 | 0.100 | 0.106 |
| Reasoned emergency orders with merits follow-up | administrative_state | 10169 | 0.996 | 0.767 | 0.001 | 0.002 | 0.840 | 0.023 | 0.040 | 0.629 | 0.078 | 0.094 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 10138 | 0.999 | 0.730 | 0.004 | 0.289 | 0.813 | 0.029 | 0.055 | 0.605 | 0.086 | 0.105 |
| Reasoned emergency orders with merits follow-up | election_law | 10047 | 1.000 | 0.737 | 0.005 | 0.265 | 0.827 | 0.025 | 0.049 | 0.619 | 0.081 | 0.100 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 9747 | 1.000 | 0.734 | 0.009 | 0.100 | 0.825 | 0.026 | 0.043 | 0.622 | 0.082 | 0.097 |
| Reasoned emergency orders with merits follow-up | equality | 10125 | 0.999 | 0.753 | 0.007 | 0.525 | 0.817 | 0.028 | 0.060 | 0.600 | 0.092 | 0.109 |
| Reasoned emergency orders with merits follow-up | federalism | 10175 | 0.997 | 0.778 | 0.000 | 0.001 | 0.843 | 0.020 | 0.037 | 0.634 | 0.074 | 0.088 |
| Reasoned emergency orders with merits follow-up | speech | 9999 | 0.999 | 0.738 | 0.005 | 0.355 | 0.827 | 0.030 | 0.054 | 0.602 | 0.087 | 0.106 |
| Panel review with en banc safety valve | administrative_state | 10169 | 1.000 | 0.767 | 0.072 | 0.001 | 0.805 | 0.033 | 0.044 | 0.558 | 0.104 | 0.115 |
| Panel review with en banc safety valve | criminal_procedure | 10138 | 1.000 | 0.722 | 0.080 | 0.298 | 0.791 | 0.035 | 0.060 | 0.539 | 0.112 | 0.125 |
| Panel review with en banc safety valve | election_law | 10047 | 1.000 | 0.732 | 0.062 | 0.236 | 0.795 | 0.036 | 0.057 | 0.553 | 0.107 | 0.120 |
| Panel review with en banc safety valve | emergency_powers | 9747 | 1.000 | 0.731 | 0.136 | 0.078 | 0.788 | 0.037 | 0.049 | 0.553 | 0.109 | 0.118 |
| Panel review with en banc safety valve | equality | 10125 | 1.000 | 0.745 | 0.080 | 0.533 | 0.779 | 0.040 | 0.069 | 0.532 | 0.119 | 0.131 |
| Panel review with en banc safety valve | federalism | 10175 | 1.000 | 0.778 | 0.070 | 0.000 | 0.810 | 0.032 | 0.044 | 0.566 | 0.099 | 0.111 |
| Panel review with en banc safety valve | speech | 9999 | 1.000 | 0.732 | 0.075 | 0.367 | 0.787 | 0.039 | 0.057 | 0.536 | 0.113 | 0.127 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 10169 | 1.000 | 0.767 | 0.002 | 0.000 | 0.843 | 0.021 | 0.035 | 0.670 | 0.065 | 0.056 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 10138 | 1.000 | 0.715 | 0.006 | 0.183 | 0.830 | 0.026 | 0.040 | 0.653 | 0.070 | 0.061 |
| Dual supreme courts with cross-checking invalidations | election_law | 10047 | 1.000 | 0.725 | 0.006 | 0.155 | 0.829 | 0.024 | 0.043 | 0.663 | 0.067 | 0.059 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 9747 | 1.000 | 0.727 | 0.015 | 0.036 | 0.830 | 0.026 | 0.039 | 0.667 | 0.067 | 0.056 |
| Dual supreme courts with cross-checking invalidations | equality | 10125 | 1.000 | 0.747 | 0.009 | 0.432 | 0.827 | 0.026 | 0.049 | 0.644 | 0.077 | 0.068 |
| Dual supreme courts with cross-checking invalidations | federalism | 10175 | 1.000 | 0.778 | 0.002 | 0.000 | 0.845 | 0.020 | 0.032 | 0.678 | 0.062 | 0.051 |
| Dual supreme courts with cross-checking invalidations | speech | 9999 | 1.000 | 0.726 | 0.007 | 0.256 | 0.825 | 0.026 | 0.047 | 0.647 | 0.072 | 0.064 |
| Pre-enactment constitutional council | administrative_state | 10169 | 1.000 | 0.767 | 0.069 | 0.000 | 0.833 | 0.024 | 0.036 | 0.642 | 0.070 | 0.053 |
| Pre-enactment constitutional council | criminal_procedure | 10138 | 1.000 | 0.705 | 0.077 | 0.179 | 0.821 | 0.026 | 0.045 | 0.630 | 0.074 | 0.057 |
| Pre-enactment constitutional council | election_law | 10047 | 1.000 | 0.718 | 0.060 | 0.133 | 0.822 | 0.024 | 0.041 | 0.642 | 0.070 | 0.054 |
| Pre-enactment constitutional council | emergency_powers | 9747 | 1.000 | 0.725 | 0.128 | 0.032 | 0.818 | 0.031 | 0.039 | 0.639 | 0.073 | 0.054 |
| Pre-enactment constitutional council | equality | 10125 | 1.000 | 0.734 | 0.079 | 0.424 | 0.812 | 0.030 | 0.052 | 0.621 | 0.082 | 0.064 |
| Pre-enactment constitutional council | federalism | 10175 | 1.000 | 0.778 | 0.068 | 0.000 | 0.835 | 0.021 | 0.035 | 0.648 | 0.067 | 0.050 |
| Pre-enactment constitutional council | speech | 9999 | 1.000 | 0.715 | 0.073 | 0.241 | 0.810 | 0.026 | 0.049 | 0.627 | 0.077 | 0.061 |
| Judicial review with delayed legislative override | administrative_state | 10169 | 0.996 | 0.767 | 0.074 | 0.001 | 0.791 | 0.040 | 0.048 | 0.514 | 0.116 | 0.134 |
| Judicial review with delayed legislative override | criminal_procedure | 10138 | 0.999 | 0.717 | 0.084 | 0.279 | 0.770 | 0.046 | 0.062 | 0.496 | 0.125 | 0.142 |
| Judicial review with delayed legislative override | election_law | 10047 | 1.000 | 0.729 | 0.064 | 0.241 | 0.781 | 0.043 | 0.055 | 0.511 | 0.121 | 0.139 |
| Judicial review with delayed legislative override | emergency_powers | 9747 | 0.999 | 0.730 | 0.136 | 0.094 | 0.778 | 0.044 | 0.053 | 0.510 | 0.123 | 0.138 |
| Judicial review with delayed legislative override | equality | 10125 | 0.999 | 0.741 | 0.080 | 0.517 | 0.764 | 0.048 | 0.070 | 0.489 | 0.133 | 0.149 |
| Judicial review with delayed legislative override | federalism | 10175 | 0.998 | 0.778 | 0.072 | 0.000 | 0.795 | 0.035 | 0.046 | 0.522 | 0.112 | 0.129 |
| Judicial review with delayed legislative override | speech | 9999 | 0.999 | 0.727 | 0.076 | 0.349 | 0.774 | 0.044 | 0.062 | 0.495 | 0.127 | 0.147 |
| Retention-election accountability court | administrative_state | 10169 | 0.997 | 0.767 | 0.073 | 0.000 | 0.811 | 0.025 | 0.038 | 0.601 | 0.070 | 0.046 |
| Retention-election accountability court | criminal_procedure | 10138 | 0.999 | 0.694 | 0.074 | 0.135 | 0.791 | 0.032 | 0.046 | 0.589 | 0.074 | 0.050 |
| Retention-election accountability court | election_law | 10047 | 1.000 | 0.710 | 0.059 | 0.105 | 0.805 | 0.033 | 0.043 | 0.602 | 0.070 | 0.047 |
| Retention-election accountability court | emergency_powers | 9747 | 1.000 | 0.722 | 0.131 | 0.024 | 0.791 | 0.033 | 0.044 | 0.601 | 0.073 | 0.046 |
| Retention-election accountability court | equality | 10125 | 0.999 | 0.715 | 0.075 | 0.358 | 0.788 | 0.036 | 0.056 | 0.580 | 0.081 | 0.057 |
| Retention-election accountability court | federalism | 10175 | 0.997 | 0.778 | 0.070 | 0.000 | 0.813 | 0.025 | 0.040 | 0.608 | 0.067 | 0.043 |
| Retention-election accountability court | speech | 9999 | 0.998 | 0.701 | 0.070 | 0.196 | 0.801 | 0.030 | 0.043 | 0.584 | 0.075 | 0.053 |
| Hybrid court balancing independence and accountability | administrative_state | 10169 | 1.000 | 0.767 | 0.001 | 0.000 | 0.846 | 0.019 | 0.034 | 0.673 | 0.065 | 0.065 |
| Hybrid court balancing independence and accountability | criminal_procedure | 10138 | 1.000 | 0.724 | 0.003 | 0.241 | 0.822 | 0.022 | 0.050 | 0.654 | 0.071 | 0.072 |
| Hybrid court balancing independence and accountability | election_law | 10047 | 1.000 | 0.728 | 0.004 | 0.180 | 0.830 | 0.021 | 0.045 | 0.668 | 0.066 | 0.067 |
| Hybrid court balancing independence and accountability | emergency_powers | 9747 | 1.000 | 0.729 | 0.008 | 0.046 | 0.822 | 0.025 | 0.040 | 0.673 | 0.068 | 0.066 |
| Hybrid court balancing independence and accountability | equality | 10125 | 1.000 | 0.750 | 0.007 | 0.478 | 0.824 | 0.027 | 0.052 | 0.651 | 0.077 | 0.078 |
| Hybrid court balancing independence and accountability | federalism | 10175 | 1.000 | 0.778 | 0.000 | 0.000 | 0.840 | 0.020 | 0.036 | 0.683 | 0.062 | 0.060 |
| Hybrid court balancing independence and accountability | speech | 9999 | 1.000 | 0.734 | 0.005 | 0.310 | 0.823 | 0.025 | 0.048 | 0.651 | 0.073 | 0.076 |
