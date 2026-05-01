# Constitutional Review Campaign v0

- runs per case: 120
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Baseline

Moderately polarized appointment environment with ordinary constitutional-review pressure.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.820
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.744
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.095

### Polarized appointments

High appointment polarization, higher partisan pressure, and lower public trust.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.801
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.745
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.148

### Rights-threat surge

Docket contains more laws or actions with high generated rights-risk signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.732
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.725
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.005
- lowest emergency relief rate: Retention-election accountability court at 0.396

### Emergency docket stress

Higher urgency and executive pressure, meant to stress shadow-docket procedures.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.790
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.027
- lowest emergency relief rate: Retention-election accountability court at 0.140

### Low-trust conflict

Lower public trust and higher legislature-court conflict.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.802
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.001
- lowest emergency relief rate: Dual supreme courts with cross-checking invalidations at 0.134

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Delay | Turnover | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.684 | 0.817 | 0.706 | 0.171 | 0.461 | 0.460 | 0.227 | 0.576 | 0.124 | 0.241 | 0.425 | 0.474 | 0.109 | 0.368 |
| Staggered 18-year nonrenewable terms | 0.699 | 0.824 | 0.708 | 0.157 | 0.456 | 0.425 | 0.211 | 0.584 | 0.115 | 0.238 | 0.429 | 0.474 | 0.272 | 0.376 |
| Fifteen-justice supermajority commission court | 0.765 | 0.919 | 0.733 | 0.129 | 0.123 | 0.268 | 0.290 | 0.700 | 0.206 | 0.141 | 0.461 | 0.474 | 0.340 | 0.367 |
| Supermajority required to invalidate laws | 0.757 | 0.929 | 0.726 | 0.142 | 0.127 | 0.283 | 0.249 | 0.677 | 0.175 | 0.140 | 0.456 | 0.474 | 0.113 | 0.346 |
| Strict recusal with substitute justices | 0.769 | 0.920 | 0.731 | 0.128 | 0.121 | 0.272 | 0.279 | 0.718 | 0.198 | 0.139 | 0.461 | 0.474 | 0.344 | 0.368 |
| Reasoned emergency orders with merits follow-up | 0.770 | 0.935 | 0.740 | 0.140 | 0.008 | 0.294 | 0.273 | 0.745 | 0.273 | 0.112 | 0.465 | 0.474 | 0.272 | 0.354 |
| Panel review with en banc safety valve | 0.755 | 0.916 | 0.734 | 0.127 | 0.122 | 0.271 | 0.303 | 0.713 | 0.217 | 0.141 | 0.462 | 0.474 | 0.344 | 0.495 |
| Dual supreme courts with cross-checking invalidations | 0.764 | 0.952 | 0.732 | 0.117 | 0.012 | 0.220 | 0.194 | 0.750 | 0.194 | 0.119 | 0.464 | 0.474 | 0.342 | 0.751 |
| Pre-enactment constitutional council | 0.766 | 0.961 | 0.725 | 0.111 | 0.118 | 0.260 | 0.216 | 0.739 | 0.154 | 0.135 | 0.458 | 0.474 | 0.538 | 0.621 |
| Judicial review with delayed legislative override | 0.759 | 0.910 | 0.731 | 0.138 | 0.125 | 0.290 | 0.302 | 0.693 | 0.212 | 0.143 | 0.460 | 0.474 | 0.288 | 0.360 |
| Retention-election accountability court | 0.780 | 0.925 | 0.717 | 0.129 | 0.118 | 0.183 | 0.188 | 0.708 | 0.135 | 0.136 | 0.461 | 0.474 | 0.697 | 0.380 |
| Hybrid court balancing independence and accountability | 0.784 | 0.952 | 0.736 | 0.119 | 0.007 | 0.249 | 0.227 | 0.754 | 0.227 | 0.107 | 0.465 | 0.474 | 0.348 | 0.484 |
