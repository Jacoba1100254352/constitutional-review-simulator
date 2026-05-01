# Constitutional Review Campaign v0

- runs per case: 120
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Baseline

Moderately polarized appointment environment with ordinary constitutional-review pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.852
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.744
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.089
- highest compliance rate: Hybrid court balancing independence and accountability at 0.881
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.010

### Polarized appointments

High appointment polarization, higher partisan pressure, and lower public trust.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.831
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.744
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.124
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.850
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.018

### Rights-threat surge

Docket contains more laws or actions with high generated rights-risk signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.762
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.725
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.005
- lowest emergency relief rate: Retention-election accountability court at 0.363
- highest compliance rate: Pre-enactment constitutional council at 0.711
- lowest defiance rate: Hybrid court balancing independence and accountability at 0.060

### Emergency docket stress

Higher urgency and executive pressure, meant to stress shadow-docket procedures.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.821
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.743
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.026
- lowest emergency relief rate: Retention-election accountability court at 0.128
- highest compliance rate: Hybrid court balancing independence and accountability at 0.824
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.028

### Low-trust conflict

Lower public trust and higher legislature-court conflict.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.821
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.741
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.109
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.768
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.042

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Defiance | Trust | Curbing | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.694 | 0.818 | 0.707 | 0.170 | 0.460 | 0.452 | 0.228 | 0.583 | 0.124 | 0.241 | 0.426 | 0.500 | 0.192 | 0.044 | 0.653 | 0.368 |
| Staggered 18-year nonrenewable terms | 0.709 | 0.825 | 0.708 | 0.156 | 0.456 | 0.414 | 0.204 | 0.591 | 0.111 | 0.237 | 0.430 | 0.510 | 0.187 | 0.048 | 0.603 | 0.376 |
| Fifteen-justice supermajority commission court | 0.788 | 0.921 | 0.732 | 0.127 | 0.123 | 0.262 | 0.281 | 0.733 | 0.199 | 0.140 | 0.461 | 0.722 | 0.063 | 0.266 | 0.216 | 0.367 |
| Supermajority required to invalidate laws | 0.782 | 0.930 | 0.726 | 0.141 | 0.126 | 0.276 | 0.244 | 0.707 | 0.171 | 0.139 | 0.456 | 0.728 | 0.063 | 0.250 | 0.214 | 0.346 |
| Strict recusal with substitute justices | 0.795 | 0.922 | 0.730 | 0.127 | 0.122 | 0.258 | 0.268 | 0.756 | 0.190 | 0.139 | 0.461 | 0.748 | 0.053 | 0.308 | 0.171 | 0.368 |
| Reasoned emergency orders with merits follow-up | 0.800 | 0.937 | 0.739 | 0.139 | 0.008 | 0.283 | 0.265 | 0.791 | 0.265 | 0.111 | 0.466 | 0.777 | 0.041 | 0.377 | 0.168 | 0.354 |
| Panel review with en banc safety valve | 0.782 | 0.918 | 0.733 | 0.126 | 0.122 | 0.258 | 0.290 | 0.747 | 0.208 | 0.140 | 0.462 | 0.730 | 0.060 | 0.277 | 0.203 | 0.495 |
| Dual supreme courts with cross-checking invalidations | 0.798 | 0.953 | 0.731 | 0.116 | 0.012 | 0.215 | 0.186 | 0.808 | 0.186 | 0.118 | 0.464 | 0.806 | 0.033 | 0.478 | 0.094 | 0.751 |
| Pre-enactment constitutional council | 0.797 | 0.962 | 0.724 | 0.110 | 0.118 | 0.255 | 0.204 | 0.788 | 0.146 | 0.134 | 0.458 | 0.773 | 0.042 | 0.405 | 0.099 | 0.621 |
| Judicial review with delayed legislative override | 0.783 | 0.912 | 0.730 | 0.136 | 0.125 | 0.279 | 0.290 | 0.723 | 0.205 | 0.142 | 0.461 | 0.715 | 0.067 | 0.239 | 0.239 | 0.360 |
| Retention-election accountability court | 0.808 | 0.928 | 0.715 | 0.127 | 0.117 | 0.163 | 0.172 | 0.751 | 0.123 | 0.134 | 0.460 | 0.763 | 0.044 | 0.351 | 0.079 | 0.380 |
| Hybrid court balancing independence and accountability | 0.813 | 0.953 | 0.735 | 0.118 | 0.007 | 0.247 | 0.218 | 0.812 | 0.218 | 0.106 | 0.465 | 0.800 | 0.033 | 0.484 | 0.112 | 0.484 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Compliance | Defiance | Workaround | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 1.000 | 0.707 | 0.462 | 0.225 | 0.612 | 0.131 | 0.077 | 0.158 | 0.567 | 0.328 |
| Current-style federal supreme court | 2 | 12000 | 1.000 | 0.707 | 0.461 | 0.226 | 0.498 | 0.197 | 0.126 | 0.010 | 0.649 | 0.696 |
| Current-style federal supreme court | 3 | 12000 | 0.999 | 0.707 | 0.461 | 0.228 | 0.451 | 0.218 | 0.147 | 0.004 | 0.671 | 0.783 |
| Current-style federal supreme court | 4 | 12000 | 0.999 | 0.705 | 0.457 | 0.231 | 0.438 | 0.223 | 0.147 | 0.004 | 0.680 | 0.803 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 0.999 | 0.709 | 0.457 | 0.209 | 0.614 | 0.129 | 0.076 | 0.170 | 0.547 | 0.303 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 1.000 | 0.708 | 0.459 | 0.195 | 0.509 | 0.190 | 0.118 | 0.013 | 0.609 | 0.642 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 1.000 | 0.709 | 0.455 | 0.209 | 0.464 | 0.214 | 0.136 | 0.005 | 0.619 | 0.724 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 1.000 | 0.707 | 0.454 | 0.203 | 0.454 | 0.213 | 0.140 | 0.004 | 0.617 | 0.743 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 0.999 | 0.733 | 0.126 | 0.285 | 0.719 | 0.068 | 0.062 | 0.365 | 0.354 | 0.179 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 0.999 | 0.732 | 0.122 | 0.280 | 0.724 | 0.061 | 0.078 | 0.238 | 0.173 | 0.243 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 0.999 | 0.732 | 0.122 | 0.282 | 0.719 | 0.063 | 0.087 | 0.230 | 0.115 | 0.230 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 1.000 | 0.731 | 0.122 | 0.278 | 0.723 | 0.059 | 0.087 | 0.232 | 0.098 | 0.212 |
| Supermajority required to invalidate laws | 1 | 12000 | 0.999 | 0.727 | 0.129 | 0.248 | 0.724 | 0.066 | 0.056 | 0.360 | 0.354 | 0.176 |
| Supermajority required to invalidate laws | 2 | 12000 | 1.000 | 0.726 | 0.126 | 0.243 | 0.733 | 0.063 | 0.070 | 0.221 | 0.170 | 0.232 |
| Supermajority required to invalidate laws | 3 | 12000 | 0.999 | 0.726 | 0.126 | 0.246 | 0.725 | 0.064 | 0.080 | 0.208 | 0.116 | 0.228 |
| Supermajority required to invalidate laws | 4 | 12000 | 1.000 | 0.724 | 0.123 | 0.238 | 0.731 | 0.059 | 0.083 | 0.211 | 0.102 | 0.218 |
| Strict recusal with substitute justices | 1 | 12000 | 1.000 | 0.731 | 0.124 | 0.269 | 0.733 | 0.062 | 0.059 | 0.391 | 0.338 | 0.162 |
| Strict recusal with substitute justices | 2 | 12000 | 0.999 | 0.730 | 0.121 | 0.264 | 0.743 | 0.056 | 0.068 | 0.280 | 0.140 | 0.195 |
| Strict recusal with substitute justices | 3 | 12000 | 0.999 | 0.730 | 0.122 | 0.272 | 0.755 | 0.049 | 0.074 | 0.278 | 0.082 | 0.173 |
| Strict recusal with substitute justices | 4 | 12000 | 1.000 | 0.729 | 0.119 | 0.269 | 0.759 | 0.047 | 0.076 | 0.284 | 0.063 | 0.154 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 1.000 | 0.740 | 0.008 | 0.265 | 0.753 | 0.055 | 0.058 | 0.441 | 0.313 | 0.171 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 0.999 | 0.739 | 0.008 | 0.259 | 0.775 | 0.041 | 0.062 | 0.359 | 0.099 | 0.195 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 1.000 | 0.740 | 0.008 | 0.268 | 0.787 | 0.036 | 0.066 | 0.351 | 0.051 | 0.165 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 1.000 | 0.738 | 0.008 | 0.268 | 0.792 | 0.033 | 0.070 | 0.356 | 0.040 | 0.140 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.734 | 0.123 | 0.291 | 0.724 | 0.066 | 0.060 | 0.376 | 0.349 | 0.175 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.733 | 0.121 | 0.287 | 0.730 | 0.060 | 0.076 | 0.251 | 0.162 | 0.229 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.734 | 0.122 | 0.294 | 0.727 | 0.057 | 0.081 | 0.237 | 0.100 | 0.214 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.732 | 0.120 | 0.291 | 0.738 | 0.056 | 0.082 | 0.243 | 0.082 | 0.195 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.732 | 0.013 | 0.188 | 0.767 | 0.051 | 0.048 | 0.483 | 0.288 | 0.131 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.730 | 0.012 | 0.181 | 0.804 | 0.030 | 0.050 | 0.460 | 0.064 | 0.108 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.732 | 0.012 | 0.189 | 0.822 | 0.028 | 0.049 | 0.473 | 0.026 | 0.076 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.730 | 0.012 | 0.187 | 0.830 | 0.022 | 0.047 | 0.496 | 0.017 | 0.062 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.724 | 0.120 | 0.203 | 0.744 | 0.057 | 0.051 | 0.442 | 0.308 | 0.132 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.724 | 0.118 | 0.201 | 0.771 | 0.043 | 0.058 | 0.376 | 0.088 | 0.116 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.725 | 0.118 | 0.208 | 0.783 | 0.036 | 0.059 | 0.389 | 0.036 | 0.084 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.722 | 0.116 | 0.204 | 0.796 | 0.032 | 0.054 | 0.412 | 0.022 | 0.064 |
| Judicial review with delayed legislative override | 1 | 12000 | 1.000 | 0.731 | 0.127 | 0.295 | 0.719 | 0.070 | 0.059 | 0.351 | 0.362 | 0.186 |
| Judicial review with delayed legislative override | 2 | 12000 | 0.999 | 0.730 | 0.125 | 0.285 | 0.720 | 0.069 | 0.076 | 0.211 | 0.187 | 0.261 |
| Judicial review with delayed legislative override | 3 | 12000 | 0.999 | 0.731 | 0.125 | 0.292 | 0.710 | 0.063 | 0.090 | 0.198 | 0.133 | 0.263 |
| Judicial review with delayed legislative override | 4 | 12000 | 0.999 | 0.729 | 0.122 | 0.290 | 0.711 | 0.069 | 0.089 | 0.195 | 0.118 | 0.248 |
| Retention-election accountability court | 1 | 12000 | 0.999 | 0.715 | 0.120 | 0.172 | 0.726 | 0.058 | 0.053 | 0.423 | 0.308 | 0.124 |
| Retention-election accountability court | 2 | 12000 | 0.999 | 0.715 | 0.118 | 0.173 | 0.761 | 0.045 | 0.056 | 0.327 | 0.080 | 0.095 |
| Retention-election accountability court | 3 | 12000 | 1.000 | 0.716 | 0.117 | 0.176 | 0.776 | 0.038 | 0.058 | 0.323 | 0.027 | 0.058 |
| Retention-election accountability court | 4 | 12000 | 1.000 | 0.713 | 0.115 | 0.166 | 0.788 | 0.032 | 0.056 | 0.330 | 0.016 | 0.038 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.736 | 0.007 | 0.219 | 0.764 | 0.049 | 0.050 | 0.485 | 0.288 | 0.143 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.734 | 0.007 | 0.213 | 0.806 | 0.031 | 0.054 | 0.470 | 0.065 | 0.129 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.735 | 0.007 | 0.218 | 0.814 | 0.026 | 0.053 | 0.482 | 0.028 | 0.096 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.734 | 0.007 | 0.221 | 0.817 | 0.025 | 0.054 | 0.498 | 0.018 | 0.079 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Compliance | Defiance | Workaround | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 6955 | 0.999 | 0.748 | 0.378 | 0.002 | 0.539 | 0.162 | 0.109 | 0.049 | 0.620 | 0.642 |
| Current-style federal supreme court | criminal_procedure | 6865 | 1.000 | 0.688 | 0.451 | 0.296 | 0.496 | 0.197 | 0.127 | 0.043 | 0.648 | 0.659 |
| Current-style federal supreme court | election_law | 6704 | 1.000 | 0.683 | 0.453 | 0.291 | 0.491 | 0.199 | 0.132 | 0.043 | 0.642 | 0.652 |
| Current-style federal supreme court | emergency_powers | 6812 | 1.000 | 0.688 | 0.627 | 0.142 | 0.475 | 0.219 | 0.116 | 0.043 | 0.651 | 0.652 |
| Current-style federal supreme court | equality | 6894 | 1.000 | 0.690 | 0.486 | 0.498 | 0.461 | 0.208 | 0.144 | 0.038 | 0.658 | 0.665 |
| Current-style federal supreme court | federalism | 6962 | 0.999 | 0.761 | 0.371 | 0.002 | 0.549 | 0.161 | 0.108 | 0.049 | 0.621 | 0.636 |
| Current-style federal supreme court | speech | 6808 | 1.000 | 0.685 | 0.460 | 0.349 | 0.485 | 0.200 | 0.136 | 0.043 | 0.654 | 0.663 |
| Staggered 18-year nonrenewable terms | administrative_state | 6955 | 0.999 | 0.749 | 0.378 | 0.001 | 0.547 | 0.167 | 0.105 | 0.053 | 0.576 | 0.589 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 6865 | 1.000 | 0.688 | 0.447 | 0.255 | 0.502 | 0.189 | 0.114 | 0.047 | 0.605 | 0.609 |
| Staggered 18-year nonrenewable terms | election_law | 6704 | 1.000 | 0.685 | 0.449 | 0.254 | 0.504 | 0.190 | 0.123 | 0.046 | 0.598 | 0.602 |
| Staggered 18-year nonrenewable terms | emergency_powers | 6812 | 1.000 | 0.692 | 0.620 | 0.103 | 0.479 | 0.209 | 0.116 | 0.047 | 0.606 | 0.602 |
| Staggered 18-year nonrenewable terms | equality | 6894 | 1.000 | 0.693 | 0.475 | 0.469 | 0.488 | 0.199 | 0.132 | 0.042 | 0.612 | 0.614 |
| Staggered 18-year nonrenewable terms | federalism | 6962 | 0.999 | 0.762 | 0.369 | 0.001 | 0.557 | 0.160 | 0.105 | 0.053 | 0.579 | 0.590 |
| Staggered 18-year nonrenewable terms | speech | 6808 | 1.000 | 0.686 | 0.458 | 0.321 | 0.491 | 0.193 | 0.126 | 0.047 | 0.611 | 0.615 |
| Fifteen-justice supermajority commission court | administrative_state | 6955 | 0.998 | 0.751 | 0.115 | 0.000 | 0.749 | 0.054 | 0.059 | 0.284 | 0.168 | 0.197 |
| Fifteen-justice supermajority commission court | criminal_procedure | 6865 | 0.999 | 0.711 | 0.127 | 0.363 | 0.715 | 0.064 | 0.088 | 0.256 | 0.187 | 0.219 |
| Fifteen-justice supermajority commission court | election_law | 6704 | 1.000 | 0.718 | 0.098 | 0.316 | 0.723 | 0.067 | 0.077 | 0.269 | 0.187 | 0.218 |
| Fifteen-justice supermajority commission court | emergency_powers | 6812 | 1.000 | 0.715 | 0.172 | 0.111 | 0.713 | 0.067 | 0.072 | 0.265 | 0.189 | 0.218 |
| Fifteen-justice supermajority commission court | equality | 6894 | 1.000 | 0.742 | 0.120 | 0.619 | 0.702 | 0.072 | 0.096 | 0.252 | 0.196 | 0.231 |
| Fifteen-justice supermajority commission court | federalism | 6962 | 0.999 | 0.764 | 0.112 | 0.000 | 0.746 | 0.051 | 0.063 | 0.280 | 0.172 | 0.201 |
| Fifteen-justice supermajority commission court | speech | 6808 | 1.000 | 0.721 | 0.118 | 0.436 | 0.702 | 0.064 | 0.093 | 0.257 | 0.195 | 0.228 |
| Supermajority required to invalidate laws | administrative_state | 6955 | 0.999 | 0.751 | 0.116 | 0.000 | 0.745 | 0.056 | 0.061 | 0.266 | 0.170 | 0.197 |
| Supermajority required to invalidate laws | criminal_procedure | 6865 | 0.999 | 0.701 | 0.130 | 0.304 | 0.714 | 0.065 | 0.075 | 0.245 | 0.187 | 0.217 |
| Supermajority required to invalidate laws | election_law | 6704 | 1.000 | 0.709 | 0.102 | 0.270 | 0.720 | 0.066 | 0.075 | 0.253 | 0.187 | 0.213 |
| Supermajority required to invalidate laws | emergency_powers | 6812 | 1.000 | 0.711 | 0.179 | 0.098 | 0.725 | 0.071 | 0.068 | 0.248 | 0.191 | 0.218 |
| Supermajority required to invalidate laws | equality | 6894 | 1.000 | 0.733 | 0.121 | 0.553 | 0.721 | 0.063 | 0.083 | 0.236 | 0.194 | 0.224 |
| Supermajority required to invalidate laws | federalism | 6962 | 0.999 | 0.764 | 0.114 | 0.000 | 0.752 | 0.053 | 0.062 | 0.261 | 0.173 | 0.198 |
| Supermajority required to invalidate laws | speech | 6808 | 1.000 | 0.709 | 0.121 | 0.370 | 0.721 | 0.066 | 0.080 | 0.242 | 0.194 | 0.226 |
| Strict recusal with substitute justices | administrative_state | 6955 | 0.998 | 0.751 | 0.112 | 0.000 | 0.765 | 0.048 | 0.054 | 0.328 | 0.142 | 0.157 |
| Strict recusal with substitute justices | criminal_procedure | 6865 | 1.000 | 0.709 | 0.127 | 0.346 | 0.748 | 0.054 | 0.073 | 0.300 | 0.158 | 0.173 |
| Strict recusal with substitute justices | election_law | 6704 | 1.000 | 0.715 | 0.098 | 0.293 | 0.747 | 0.054 | 0.072 | 0.311 | 0.157 | 0.173 |
| Strict recusal with substitute justices | emergency_powers | 6812 | 1.000 | 0.714 | 0.170 | 0.101 | 0.741 | 0.055 | 0.067 | 0.304 | 0.158 | 0.171 |
| Strict recusal with substitute justices | equality | 6894 | 1.000 | 0.740 | 0.119 | 0.605 | 0.734 | 0.058 | 0.083 | 0.293 | 0.167 | 0.184 |
| Strict recusal with substitute justices | federalism | 6962 | 0.999 | 0.764 | 0.110 | 0.000 | 0.760 | 0.048 | 0.061 | 0.323 | 0.145 | 0.158 |
| Strict recusal with substitute justices | speech | 6808 | 1.000 | 0.718 | 0.116 | 0.416 | 0.738 | 0.057 | 0.074 | 0.299 | 0.163 | 0.181 |
| Reasoned emergency orders with merits follow-up | administrative_state | 6955 | 0.999 | 0.751 | 0.001 | 0.002 | 0.796 | 0.035 | 0.051 | 0.401 | 0.110 | 0.148 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 6865 | 1.000 | 0.726 | 0.007 | 0.353 | 0.765 | 0.041 | 0.072 | 0.363 | 0.129 | 0.172 |
| Reasoned emergency orders with merits follow-up | election_law | 6704 | 1.000 | 0.726 | 0.009 | 0.338 | 0.772 | 0.043 | 0.068 | 0.379 | 0.129 | 0.169 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 6812 | 1.000 | 0.720 | 0.017 | 0.137 | 0.778 | 0.043 | 0.053 | 0.379 | 0.127 | 0.170 |
| Reasoned emergency orders with merits follow-up | equality | 6894 | 1.000 | 0.754 | 0.012 | 0.604 | 0.768 | 0.047 | 0.076 | 0.356 | 0.139 | 0.185 |
| Reasoned emergency orders with merits follow-up | federalism | 6962 | 0.999 | 0.764 | 0.001 | 0.002 | 0.790 | 0.032 | 0.052 | 0.396 | 0.114 | 0.152 |
| Reasoned emergency orders with merits follow-up | speech | 6808 | 1.000 | 0.732 | 0.009 | 0.429 | 0.767 | 0.046 | 0.076 | 0.363 | 0.135 | 0.179 |
| Panel review with en banc safety valve | administrative_state | 6955 | 1.000 | 0.751 | 0.114 | 0.000 | 0.756 | 0.049 | 0.059 | 0.295 | 0.156 | 0.183 |
| Panel review with en banc safety valve | criminal_procedure | 6865 | 1.000 | 0.714 | 0.126 | 0.384 | 0.723 | 0.061 | 0.080 | 0.267 | 0.175 | 0.206 |
| Panel review with en banc safety valve | election_law | 6704 | 1.000 | 0.720 | 0.096 | 0.320 | 0.726 | 0.061 | 0.082 | 0.280 | 0.174 | 0.204 |
| Panel review with en banc safety valve | emergency_powers | 6812 | 1.000 | 0.716 | 0.172 | 0.112 | 0.719 | 0.066 | 0.070 | 0.275 | 0.177 | 0.204 |
| Panel review with en banc safety valve | equality | 6894 | 1.000 | 0.743 | 0.119 | 0.636 | 0.717 | 0.064 | 0.092 | 0.261 | 0.184 | 0.219 |
| Panel review with en banc safety valve | federalism | 6962 | 1.000 | 0.764 | 0.110 | 0.000 | 0.746 | 0.049 | 0.059 | 0.293 | 0.162 | 0.190 |
| Panel review with en banc safety valve | speech | 6808 | 1.000 | 0.724 | 0.116 | 0.460 | 0.720 | 0.067 | 0.080 | 0.265 | 0.184 | 0.218 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 6955 | 1.000 | 0.751 | 0.005 | 0.000 | 0.825 | 0.029 | 0.037 | 0.500 | 0.086 | 0.082 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 6865 | 1.000 | 0.710 | 0.011 | 0.232 | 0.795 | 0.034 | 0.054 | 0.469 | 0.101 | 0.097 |
| Dual supreme courts with cross-checking invalidations | election_law | 6704 | 1.000 | 0.712 | 0.012 | 0.203 | 0.799 | 0.033 | 0.050 | 0.478 | 0.101 | 0.096 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 6812 | 1.000 | 0.710 | 0.025 | 0.052 | 0.802 | 0.034 | 0.045 | 0.478 | 0.099 | 0.094 |
| Dual supreme courts with cross-checking invalidations | equality | 6894 | 1.000 | 0.748 | 0.016 | 0.503 | 0.794 | 0.037 | 0.062 | 0.458 | 0.110 | 0.109 |
| Dual supreme courts with cross-checking invalidations | federalism | 6962 | 1.000 | 0.764 | 0.004 | 0.000 | 0.828 | 0.027 | 0.036 | 0.498 | 0.090 | 0.082 |
| Dual supreme courts with cross-checking invalidations | speech | 6808 | 1.000 | 0.721 | 0.013 | 0.317 | 0.795 | 0.036 | 0.055 | 0.464 | 0.106 | 0.102 |
| Pre-enactment constitutional council | administrative_state | 6955 | 1.000 | 0.751 | 0.110 | 0.000 | 0.800 | 0.035 | 0.042 | 0.421 | 0.103 | 0.088 |
| Pre-enactment constitutional council | criminal_procedure | 6865 | 1.000 | 0.697 | 0.122 | 0.255 | 0.766 | 0.046 | 0.058 | 0.400 | 0.115 | 0.101 |
| Pre-enactment constitutional council | election_law | 6704 | 1.000 | 0.703 | 0.094 | 0.189 | 0.771 | 0.042 | 0.060 | 0.406 | 0.114 | 0.099 |
| Pre-enactment constitutional council | emergency_powers | 6812 | 1.000 | 0.707 | 0.163 | 0.046 | 0.764 | 0.048 | 0.049 | 0.403 | 0.115 | 0.098 |
| Pre-enactment constitutional council | equality | 6894 | 1.000 | 0.733 | 0.118 | 0.526 | 0.761 | 0.044 | 0.072 | 0.389 | 0.124 | 0.112 |
| Pre-enactment constitutional council | federalism | 6962 | 1.000 | 0.764 | 0.106 | 0.000 | 0.785 | 0.032 | 0.052 | 0.419 | 0.106 | 0.091 |
| Pre-enactment constitutional council | speech | 6808 | 1.000 | 0.709 | 0.114 | 0.332 | 0.766 | 0.046 | 0.057 | 0.393 | 0.120 | 0.106 |
| Judicial review with delayed legislative override | administrative_state | 6955 | 0.998 | 0.751 | 0.115 | 0.001 | 0.738 | 0.054 | 0.066 | 0.255 | 0.182 | 0.219 |
| Judicial review with delayed legislative override | criminal_procedure | 6865 | 0.999 | 0.709 | 0.129 | 0.369 | 0.710 | 0.070 | 0.077 | 0.231 | 0.203 | 0.243 |
| Judicial review with delayed legislative override | election_law | 6704 | 1.000 | 0.716 | 0.101 | 0.330 | 0.724 | 0.063 | 0.083 | 0.241 | 0.202 | 0.241 |
| Judicial review with delayed legislative override | emergency_powers | 6812 | 1.000 | 0.715 | 0.176 | 0.135 | 0.710 | 0.072 | 0.075 | 0.238 | 0.204 | 0.243 |
| Judicial review with delayed legislative override | equality | 6894 | 1.000 | 0.738 | 0.123 | 0.620 | 0.697 | 0.075 | 0.096 | 0.222 | 0.210 | 0.252 |
| Judicial review with delayed legislative override | federalism | 6962 | 0.999 | 0.764 | 0.113 | 0.000 | 0.731 | 0.063 | 0.063 | 0.253 | 0.188 | 0.226 |
| Judicial review with delayed legislative override | speech | 6808 | 1.000 | 0.718 | 0.118 | 0.446 | 0.693 | 0.075 | 0.090 | 0.232 | 0.211 | 0.253 |
| Retention-election accountability court | administrative_state | 6955 | 0.998 | 0.751 | 0.113 | 0.000 | 0.781 | 0.038 | 0.049 | 0.367 | 0.098 | 0.069 |
| Retention-election accountability court | criminal_procedure | 6865 | 1.000 | 0.684 | 0.118 | 0.210 | 0.755 | 0.046 | 0.057 | 0.345 | 0.108 | 0.079 |
| Retention-election accountability court | election_law | 6704 | 1.000 | 0.691 | 0.092 | 0.149 | 0.762 | 0.040 | 0.056 | 0.353 | 0.109 | 0.079 |
| Retention-election accountability court | emergency_powers | 6812 | 1.000 | 0.704 | 0.168 | 0.040 | 0.759 | 0.047 | 0.049 | 0.350 | 0.109 | 0.078 |
| Retention-election accountability court | equality | 6894 | 1.000 | 0.713 | 0.112 | 0.455 | 0.746 | 0.052 | 0.068 | 0.336 | 0.117 | 0.091 |
| Retention-election accountability court | federalism | 6962 | 0.999 | 0.764 | 0.111 | 0.000 | 0.782 | 0.035 | 0.047 | 0.363 | 0.101 | 0.071 |
| Retention-election accountability court | speech | 6808 | 1.000 | 0.693 | 0.108 | 0.275 | 0.753 | 0.047 | 0.063 | 0.339 | 0.113 | 0.084 |
| Hybrid court balancing independence and accountability | administrative_state | 6955 | 1.000 | 0.751 | 0.001 | 0.000 | 0.812 | 0.027 | 0.045 | 0.506 | 0.087 | 0.097 |
| Hybrid court balancing independence and accountability | criminal_procedure | 6865 | 1.000 | 0.719 | 0.006 | 0.297 | 0.795 | 0.036 | 0.054 | 0.474 | 0.103 | 0.117 |
| Hybrid court balancing independence and accountability | election_law | 6704 | 1.000 | 0.716 | 0.008 | 0.238 | 0.801 | 0.032 | 0.054 | 0.485 | 0.102 | 0.112 |
| Hybrid court balancing independence and accountability | emergency_powers | 6812 | 1.000 | 0.712 | 0.014 | 0.064 | 0.796 | 0.033 | 0.049 | 0.486 | 0.099 | 0.110 |
| Hybrid court balancing independence and accountability | equality | 6894 | 1.000 | 0.752 | 0.012 | 0.555 | 0.790 | 0.035 | 0.067 | 0.462 | 0.111 | 0.127 |
| Hybrid court balancing independence and accountability | federalism | 6962 | 1.000 | 0.764 | 0.001 | 0.000 | 0.815 | 0.028 | 0.040 | 0.501 | 0.091 | 0.100 |
| Hybrid court balancing independence and accountability | speech | 6808 | 1.000 | 0.727 | 0.009 | 0.375 | 0.792 | 0.038 | 0.061 | 0.469 | 0.106 | 0.118 |
