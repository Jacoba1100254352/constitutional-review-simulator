# Constitutional Review Paired Import Campaign v1

- runs per case: 120
- seed: 20260501
- input: 986 imported legislative rows across 29 scenarios

## Top Directional Scores by Case

### Synthetic baseline

Synthetic docket using the same world assumptions as the imported comparisons.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.800
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.743
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.006
- lowest emergency relief rate: Retention-election accountability court at 0.125

### All imported legislative outputs

Docket generated from every imported legislative campaign row.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.887
- strongest rights protection: Panel review with en banc safety valve at 0.825
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000

### High-capture legislative outputs

Imported rows with high lobby-capture or proposer-gain signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.879
- strongest rights protection: Panel review with en banc safety valve at 0.814
- lowest shadow-docket abuse: Strict recusal with substitute justices at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000

### High-volatility legislative outputs

Imported rows with high policy-shift, reversal, or status-quo volatility signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.860
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.777
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Reasoned emergency orders with merits follow-up at 0.000

### Low-mandate legislative outputs

Imported rows with weak public mandate, low support, or public-preference distortion.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.866
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.778
- lowest shadow-docket abuse: Strict recusal with substitute justices at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Delay | Turnover | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.788 | 0.930 | 0.778 | 0.139 | 0.149 | 0.205 | 0.126 | 0.678 | 0.085 | 0.124 | 0.557 | 0.501 | 0.109 | 0.310 |
| Staggered 18-year nonrenewable terms | 0.804 | 0.933 | 0.778 | 0.127 | 0.147 | 0.155 | 0.112 | 0.684 | 0.076 | 0.122 | 0.559 | 0.501 | 0.272 | 0.317 |
| Fifteen-justice supermajority commission court | 0.839 | 0.966 | 0.784 | 0.108 | 0.034 | 0.061 | 0.109 | 0.749 | 0.093 | 0.088 | 0.569 | 0.501 | 0.340 | 0.318 |
| Supermajority required to invalidate laws | 0.830 | 0.972 | 0.782 | 0.120 | 0.034 | 0.060 | 0.092 | 0.729 | 0.079 | 0.086 | 0.568 | 0.501 | 0.113 | 0.299 |
| Strict recusal with substitute justices | 0.845 | 0.967 | 0.783 | 0.108 | 0.033 | 0.052 | 0.102 | 0.767 | 0.087 | 0.086 | 0.569 | 0.501 | 0.344 | 0.319 |
| Reasoned emergency orders with merits follow-up | 0.836 | 0.969 | 0.787 | 0.118 | 0.001 | 0.045 | 0.124 | 0.778 | 0.124 | 0.082 | 0.568 | 0.501 | 0.272 | 0.309 |
| Panel review with en banc safety valve | 0.836 | 0.968 | 0.786 | 0.110 | 0.033 | 0.065 | 0.116 | 0.768 | 0.100 | 0.088 | 0.569 | 0.501 | 0.344 | 0.395 |
| Dual supreme courts with cross-checking invalidations | 0.820 | 0.980 | 0.784 | 0.101 | 0.002 | 0.035 | 0.081 | 0.792 | 0.081 | 0.083 | 0.572 | 0.501 | 0.342 | 0.711 |
| Pre-enactment constitutional council | 0.840 | 0.987 | 0.780 | 0.094 | 0.032 | 0.060 | 0.069 | 0.795 | 0.058 | 0.082 | 0.571 | 0.501 | 0.538 | 0.578 |
| Judicial review with delayed legislative override | 0.837 | 0.963 | 0.782 | 0.116 | 0.034 | 0.060 | 0.113 | 0.743 | 0.097 | 0.091 | 0.569 | 0.501 | 0.288 | 0.312 |
| Retention-election accountability court | 0.857 | 0.973 | 0.772 | 0.110 | 0.032 | 0.033 | 0.049 | 0.757 | 0.040 | 0.083 | 0.573 | 0.501 | 0.697 | 0.332 |
| Hybrid court balancing independence and accountability | 0.847 | 0.979 | 0.786 | 0.103 | 0.001 | 0.039 | 0.103 | 0.793 | 0.103 | 0.079 | 0.570 | 0.501 | 0.348 | 0.389 |
