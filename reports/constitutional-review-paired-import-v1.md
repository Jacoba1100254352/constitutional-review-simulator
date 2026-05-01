# Constitutional Review Paired Import Campaign v1

- runs per case: 120
- seed: 20260501
- input: 986 imported legislative rows across 29 scenarios

## Top Directional Scores by Case

### Synthetic baseline

Synthetic docket using the same world assumptions as the imported comparisons.

- best overall: Hybrid court balancing independence and accountability (`independence-accountability-hybrid`) at 0.835
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.742
- lowest shadow-docket abuse: Hybrid court balancing independence and accountability at 0.005
- lowest emergency relief rate: Retention-election accountability court at 0.112
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.847
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.017

### All imported legislative outputs

Docket generated from every imported legislative campaign row.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.906
- strongest rights protection: Panel review with en banc safety valve at 0.825
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.897
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.006

### High-capture legislative outputs

Imported rows with high lobby-capture or proposer-gain signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.900
- strongest rights protection: Panel review with en banc safety valve at 0.814
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Strict recusal with substitute justices at 0.879
- lowest defiance rate: Dual supreme courts with cross-checking invalidations at 0.008

### High-volatility legislative outputs

Imported rows with high policy-shift, reversal, or status-quo volatility signals.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.885
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.777
- lowest shadow-docket abuse: Reasoned emergency orders with merits follow-up at 0.000
- lowest emergency relief rate: Reasoned emergency orders with merits follow-up at 0.000
- highest compliance rate: Dual supreme courts with cross-checking invalidations at 0.862
- lowest defiance rate: Pre-enactment constitutional council at 0.013

### Low-mandate legislative outputs

Imported rows with weak public mandate, low support, or public-preference distortion.

- best overall: Retention-election accountability court (`accountability-retention-court`) at 0.890
- strongest rights protection: Reasoned emergency orders with merits follow-up at 0.778
- lowest shadow-docket abuse: Fifteen-justice supermajority commission court at 0.000
- lowest emergency relief rate: Fifteen-justice supermajority commission court at 0.000
- highest compliance rate: Reasoned emergency orders with merits follow-up at 0.875
- lowest defiance rate: Panel review with en banc safety valve at 0.011

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Defiance | Trust | Curbing | Admin |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 0.814 | 0.931 | 0.778 | 0.138 | 0.149 | 0.170 | 0.122 | 0.750 | 0.083 | 0.124 | 0.558 | 0.761 | 0.062 | 0.624 | 0.186 | 0.310 |
| Staggered 18-year nonrenewable terms | 0.825 | 0.935 | 0.778 | 0.126 | 0.147 | 0.159 | 0.109 | 0.759 | 0.072 | 0.121 | 0.560 | 0.759 | 0.061 | 0.649 | 0.179 | 0.317 |
| Fifteen-justice supermajority commission court | 0.866 | 0.967 | 0.783 | 0.107 | 0.034 | 0.050 | 0.101 | 0.841 | 0.086 | 0.086 | 0.569 | 0.850 | 0.018 | 0.795 | 0.031 | 0.318 |
| Supermajority required to invalidate laws | 0.858 | 0.972 | 0.781 | 0.119 | 0.034 | 0.056 | 0.088 | 0.820 | 0.075 | 0.085 | 0.569 | 0.850 | 0.018 | 0.783 | 0.034 | 0.299 |
| Strict recusal with substitute justices | 0.870 | 0.968 | 0.782 | 0.107 | 0.033 | 0.047 | 0.095 | 0.862 | 0.081 | 0.085 | 0.570 | 0.851 | 0.018 | 0.814 | 0.029 | 0.319 |
| Reasoned emergency orders with merits follow-up | 0.865 | 0.970 | 0.786 | 0.116 | 0.001 | 0.043 | 0.118 | 0.879 | 0.118 | 0.081 | 0.569 | 0.866 | 0.013 | 0.864 | 0.028 | 0.309 |
| Panel review with en banc safety valve | 0.864 | 0.969 | 0.785 | 0.108 | 0.033 | 0.050 | 0.108 | 0.864 | 0.092 | 0.087 | 0.570 | 0.846 | 0.018 | 0.799 | 0.031 | 0.395 |
| Dual supreme courts with cross-checking invalidations | 0.853 | 0.981 | 0.783 | 0.100 | 0.002 | 0.033 | 0.073 | 0.900 | 0.073 | 0.082 | 0.572 | 0.868 | 0.012 | 0.901 | 0.020 | 0.711 |
| Pre-enactment constitutional council | 0.868 | 0.988 | 0.779 | 0.093 | 0.032 | 0.052 | 0.060 | 0.898 | 0.050 | 0.081 | 0.572 | 0.851 | 0.015 | 0.859 | 0.019 | 0.578 |
| Judicial review with delayed legislative override | 0.863 | 0.964 | 0.781 | 0.114 | 0.033 | 0.056 | 0.106 | 0.833 | 0.090 | 0.089 | 0.570 | 0.843 | 0.021 | 0.766 | 0.037 | 0.312 |
| Retention-election accountability court | 0.881 | 0.976 | 0.772 | 0.108 | 0.032 | 0.025 | 0.040 | 0.855 | 0.032 | 0.081 | 0.573 | 0.842 | 0.017 | 0.841 | 0.020 | 0.332 |
| Hybrid court balancing independence and accountability | 0.874 | 0.980 | 0.785 | 0.101 | 0.001 | 0.037 | 0.094 | 0.901 | 0.094 | 0.078 | 0.571 | 0.863 | 0.014 | 0.895 | 0.022 | 0.389 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Compliance | Defiance | Workaround | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 12000 | 0.970 | 0.785 | 0.140 | 0.094 | 0.745 | 0.058 | 0.050 | 0.585 | 0.388 | 0.163 |
| Current-style federal supreme court | 2 | 12000 | 0.980 | 0.770 | 0.156 | 0.137 | 0.766 | 0.058 | 0.056 | 0.634 | 0.176 | 0.179 |
| Current-style federal supreme court | 3 | 12000 | 0.981 | 0.774 | 0.156 | 0.127 | 0.767 | 0.068 | 0.051 | 0.651 | 0.188 | 0.199 |
| Current-style federal supreme court | 4 | 12000 | 0.970 | 0.783 | 0.145 | 0.131 | 0.768 | 0.065 | 0.056 | 0.627 | 0.197 | 0.203 |
| Staggered 18-year nonrenewable terms | 1 | 12000 | 0.970 | 0.785 | 0.139 | 0.085 | 0.741 | 0.055 | 0.054 | 0.591 | 0.380 | 0.153 |
| Staggered 18-year nonrenewable terms | 2 | 12000 | 0.981 | 0.770 | 0.156 | 0.115 | 0.768 | 0.056 | 0.051 | 0.662 | 0.163 | 0.165 |
| Staggered 18-year nonrenewable terms | 3 | 12000 | 0.980 | 0.775 | 0.151 | 0.111 | 0.764 | 0.065 | 0.058 | 0.684 | 0.181 | 0.197 |
| Staggered 18-year nonrenewable terms | 4 | 12000 | 0.968 | 0.783 | 0.142 | 0.124 | 0.765 | 0.068 | 0.052 | 0.658 | 0.192 | 0.202 |
| Fifteen-justice supermajority commission court | 1 | 12000 | 0.966 | 0.789 | 0.033 | 0.079 | 0.783 | 0.036 | 0.044 | 0.702 | 0.301 | 0.093 |
| Fifteen-justice supermajority commission court | 2 | 12000 | 0.979 | 0.775 | 0.034 | 0.104 | 0.861 | 0.013 | 0.031 | 0.829 | 0.018 | 0.019 |
| Fifteen-justice supermajority commission court | 3 | 12000 | 0.980 | 0.780 | 0.035 | 0.104 | 0.880 | 0.010 | 0.030 | 0.830 | 0.005 | 0.007 |
| Fifteen-justice supermajority commission court | 4 | 12000 | 0.968 | 0.788 | 0.033 | 0.117 | 0.875 | 0.012 | 0.029 | 0.818 | 0.005 | 0.004 |
| Supermajority required to invalidate laws | 1 | 12000 | 0.967 | 0.788 | 0.032 | 0.069 | 0.783 | 0.037 | 0.043 | 0.690 | 0.306 | 0.098 |
| Supermajority required to invalidate laws | 2 | 12000 | 0.981 | 0.773 | 0.036 | 0.088 | 0.860 | 0.012 | 0.031 | 0.814 | 0.020 | 0.021 |
| Supermajority required to invalidate laws | 3 | 12000 | 0.979 | 0.778 | 0.036 | 0.093 | 0.872 | 0.012 | 0.027 | 0.819 | 0.005 | 0.009 |
| Supermajority required to invalidate laws | 4 | 12000 | 0.971 | 0.786 | 0.032 | 0.101 | 0.886 | 0.010 | 0.025 | 0.808 | 0.004 | 0.005 |
| Strict recusal with substitute justices | 1 | 12000 | 0.967 | 0.789 | 0.031 | 0.076 | 0.785 | 0.037 | 0.046 | 0.716 | 0.293 | 0.088 |
| Strict recusal with substitute justices | 2 | 12000 | 0.979 | 0.774 | 0.034 | 0.095 | 0.859 | 0.013 | 0.031 | 0.847 | 0.015 | 0.018 |
| Strict recusal with substitute justices | 3 | 12000 | 0.979 | 0.780 | 0.034 | 0.098 | 0.876 | 0.011 | 0.026 | 0.852 | 0.004 | 0.008 |
| Strict recusal with substitute justices | 4 | 12000 | 0.969 | 0.787 | 0.032 | 0.110 | 0.883 | 0.011 | 0.026 | 0.843 | 0.004 | 0.004 |
| Reasoned emergency orders with merits follow-up | 1 | 12000 | 0.969 | 0.792 | 0.001 | 0.089 | 0.801 | 0.033 | 0.041 | 0.735 | 0.287 | 0.090 |
| Reasoned emergency orders with merits follow-up | 2 | 12000 | 0.981 | 0.778 | 0.001 | 0.124 | 0.877 | 0.009 | 0.027 | 0.891 | 0.008 | 0.013 |
| Reasoned emergency orders with merits follow-up | 3 | 12000 | 0.980 | 0.783 | 0.001 | 0.124 | 0.887 | 0.006 | 0.028 | 0.913 | 0.005 | 0.005 |
| Reasoned emergency orders with merits follow-up | 4 | 12000 | 0.967 | 0.791 | 0.001 | 0.132 | 0.897 | 0.006 | 0.023 | 0.917 | 0.005 | 0.004 |
| Panel review with en banc safety valve | 1 | 12000 | 1.000 | 0.792 | 0.032 | 0.087 | 0.780 | 0.038 | 0.047 | 0.712 | 0.296 | 0.091 |
| Panel review with en banc safety valve | 2 | 12000 | 1.000 | 0.776 | 0.034 | 0.108 | 0.849 | 0.013 | 0.036 | 0.830 | 0.018 | 0.021 |
| Panel review with en banc safety valve | 3 | 12000 | 1.000 | 0.782 | 0.034 | 0.110 | 0.874 | 0.010 | 0.030 | 0.832 | 0.005 | 0.009 |
| Panel review with en banc safety valve | 4 | 12000 | 1.000 | 0.790 | 0.032 | 0.127 | 0.880 | 0.010 | 0.029 | 0.820 | 0.005 | 0.005 |
| Dual supreme courts with cross-checking invalidations | 1 | 12000 | 1.000 | 0.790 | 0.002 | 0.057 | 0.798 | 0.031 | 0.040 | 0.758 | 0.271 | 0.071 |
| Dual supreme courts with cross-checking invalidations | 2 | 12000 | 1.000 | 0.774 | 0.002 | 0.071 | 0.881 | 0.006 | 0.024 | 0.928 | 0.004 | 0.005 |
| Dual supreme courts with cross-checking invalidations | 3 | 12000 | 1.000 | 0.780 | 0.002 | 0.075 | 0.896 | 0.005 | 0.023 | 0.955 | 0.003 | 0.002 |
| Dual supreme courts with cross-checking invalidations | 4 | 12000 | 1.000 | 0.788 | 0.002 | 0.090 | 0.898 | 0.005 | 0.022 | 0.964 | 0.003 | 0.002 |
| Pre-enactment constitutional council | 1 | 12000 | 1.000 | 0.787 | 0.031 | 0.047 | 0.786 | 0.032 | 0.042 | 0.758 | 0.268 | 0.067 |
| Pre-enactment constitutional council | 2 | 12000 | 1.000 | 0.770 | 0.033 | 0.054 | 0.861 | 0.010 | 0.028 | 0.891 | 0.007 | 0.006 |
| Pre-enactment constitutional council | 3 | 12000 | 1.000 | 0.777 | 0.034 | 0.066 | 0.875 | 0.008 | 0.026 | 0.892 | 0.002 | 0.003 |
| Pre-enactment constitutional council | 4 | 12000 | 1.000 | 0.783 | 0.031 | 0.072 | 0.881 | 0.009 | 0.026 | 0.896 | 0.002 | 0.002 |
| Judicial review with delayed legislative override | 1 | 12000 | 0.969 | 0.788 | 0.032 | 0.083 | 0.778 | 0.042 | 0.042 | 0.688 | 0.307 | 0.098 |
| Judicial review with delayed legislative override | 2 | 12000 | 0.980 | 0.773 | 0.034 | 0.107 | 0.848 | 0.016 | 0.035 | 0.795 | 0.024 | 0.027 |
| Judicial review with delayed legislative override | 3 | 12000 | 0.980 | 0.778 | 0.034 | 0.109 | 0.867 | 0.013 | 0.030 | 0.800 | 0.008 | 0.015 |
| Judicial review with delayed legislative override | 4 | 12000 | 0.968 | 0.786 | 0.032 | 0.125 | 0.878 | 0.012 | 0.032 | 0.779 | 0.007 | 0.008 |
| Retention-election accountability court | 1 | 12000 | 0.970 | 0.781 | 0.031 | 0.034 | 0.782 | 0.038 | 0.037 | 0.731 | 0.278 | 0.071 |
| Retention-election accountability court | 2 | 12000 | 0.980 | 0.764 | 0.033 | 0.035 | 0.850 | 0.009 | 0.028 | 0.874 | 0.007 | 0.005 |
| Retention-election accountability court | 3 | 12000 | 0.979 | 0.769 | 0.033 | 0.045 | 0.866 | 0.010 | 0.028 | 0.880 | 0.003 | 0.002 |
| Retention-election accountability court | 4 | 12000 | 0.968 | 0.774 | 0.031 | 0.046 | 0.869 | 0.011 | 0.024 | 0.881 | 0.003 | 0.001 |
| Hybrid court balancing independence and accountability | 1 | 12000 | 1.000 | 0.792 | 0.001 | 0.071 | 0.789 | 0.034 | 0.040 | 0.754 | 0.272 | 0.076 |
| Hybrid court balancing independence and accountability | 2 | 12000 | 1.000 | 0.777 | 0.001 | 0.095 | 0.875 | 0.007 | 0.029 | 0.922 | 0.005 | 0.007 |
| Hybrid court balancing independence and accountability | 3 | 12000 | 1.000 | 0.782 | 0.001 | 0.099 | 0.892 | 0.006 | 0.024 | 0.949 | 0.003 | 0.003 |
| Hybrid court balancing independence and accountability | 4 | 12000 | 1.000 | 0.791 | 0.001 | 0.110 | 0.895 | 0.007 | 0.022 | 0.956 | 0.003 | 0.003 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Compliance | Defiance | Workaround | Trust | Conflict | Curbing |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 3842 | 0.901 | 0.842 | 0.184 | 0.000 | 0.731 | 0.085 | 0.054 | 0.552 | 0.358 | 0.304 |
| Current-style federal supreme court | criminal_procedure | 3796 | 0.970 | 0.771 | 0.222 | 0.088 | 0.708 | 0.094 | 0.067 | 0.553 | 0.363 | 0.302 |
| Current-style federal supreme court | election_law | 9819 | 0.988 | 0.795 | 0.108 | 0.035 | 0.801 | 0.049 | 0.039 | 0.674 | 0.168 | 0.127 |
| Current-style federal supreme court | emergency_powers | 4624 | 0.985 | 0.805 | 0.307 | 0.016 | 0.718 | 0.090 | 0.054 | 0.595 | 0.309 | 0.256 |
| Current-style federal supreme court | equality | 18185 | 0.997 | 0.736 | 0.086 | 0.243 | 0.786 | 0.040 | 0.053 | 0.666 | 0.154 | 0.104 |
| Current-style federal supreme court | federalism | 3922 | 0.906 | 0.852 | 0.184 | 0.000 | 0.743 | 0.085 | 0.053 | 0.552 | 0.356 | 0.299 |
| Current-style federal supreme court | speech | 3812 | 0.977 | 0.768 | 0.224 | 0.114 | 0.699 | 0.094 | 0.074 | 0.555 | 0.356 | 0.296 |
| Staggered 18-year nonrenewable terms | administrative_state | 3842 | 0.902 | 0.842 | 0.188 | 0.000 | 0.743 | 0.080 | 0.054 | 0.563 | 0.345 | 0.294 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 3796 | 0.963 | 0.772 | 0.217 | 0.087 | 0.697 | 0.095 | 0.068 | 0.561 | 0.352 | 0.294 |
| Staggered 18-year nonrenewable terms | election_law | 9819 | 0.991 | 0.796 | 0.105 | 0.027 | 0.800 | 0.044 | 0.044 | 0.705 | 0.163 | 0.123 |
| Staggered 18-year nonrenewable terms | emergency_powers | 4624 | 0.983 | 0.807 | 0.303 | 0.006 | 0.716 | 0.085 | 0.059 | 0.608 | 0.299 | 0.247 |
| Staggered 18-year nonrenewable terms | equality | 18185 | 0.997 | 0.735 | 0.084 | 0.213 | 0.782 | 0.040 | 0.052 | 0.700 | 0.147 | 0.097 |
| Staggered 18-year nonrenewable terms | federalism | 3922 | 0.905 | 0.852 | 0.180 | 0.000 | 0.731 | 0.088 | 0.049 | 0.565 | 0.347 | 0.291 |
| Staggered 18-year nonrenewable terms | speech | 3812 | 0.973 | 0.769 | 0.218 | 0.109 | 0.710 | 0.092 | 0.068 | 0.568 | 0.346 | 0.289 |
| Fifteen-justice supermajority commission court | administrative_state | 3842 | 0.898 | 0.842 | 0.054 | 0.000 | 0.851 | 0.022 | 0.031 | 0.700 | 0.096 | 0.037 |
| Fifteen-justice supermajority commission court | criminal_procedure | 3796 | 0.962 | 0.780 | 0.061 | 0.087 | 0.848 | 0.023 | 0.033 | 0.695 | 0.105 | 0.042 |
| Fifteen-justice supermajority commission court | election_law | 9819 | 0.990 | 0.801 | 0.018 | 0.028 | 0.867 | 0.013 | 0.027 | 0.858 | 0.063 | 0.022 |
| Fifteen-justice supermajority commission court | emergency_powers | 4624 | 0.981 | 0.813 | 0.076 | 0.013 | 0.847 | 0.015 | 0.036 | 0.739 | 0.087 | 0.034 |
| Fifteen-justice supermajority commission court | equality | 18185 | 0.997 | 0.739 | 0.013 | 0.195 | 0.840 | 0.018 | 0.037 | 0.857 | 0.075 | 0.028 |
| Fifteen-justice supermajority commission court | federalism | 3922 | 0.898 | 0.852 | 0.052 | 0.000 | 0.861 | 0.021 | 0.027 | 0.698 | 0.101 | 0.038 |
| Fifteen-justice supermajority commission court | speech | 3812 | 0.972 | 0.781 | 0.057 | 0.120 | 0.843 | 0.019 | 0.035 | 0.697 | 0.102 | 0.041 |
| Supermajority required to invalidate laws | administrative_state | 3842 | 0.901 | 0.843 | 0.056 | 0.000 | 0.862 | 0.018 | 0.027 | 0.685 | 0.098 | 0.040 |
| Supermajority required to invalidate laws | criminal_procedure | 3796 | 0.967 | 0.777 | 0.062 | 0.064 | 0.833 | 0.027 | 0.031 | 0.679 | 0.107 | 0.045 |
| Supermajority required to invalidate laws | election_law | 9819 | 0.989 | 0.800 | 0.018 | 0.024 | 0.867 | 0.013 | 0.027 | 0.848 | 0.064 | 0.023 |
| Supermajority required to invalidate laws | emergency_powers | 4624 | 0.981 | 0.813 | 0.078 | 0.016 | 0.847 | 0.019 | 0.032 | 0.723 | 0.090 | 0.038 |
| Supermajority required to invalidate laws | equality | 18185 | 0.997 | 0.736 | 0.013 | 0.173 | 0.844 | 0.016 | 0.035 | 0.847 | 0.077 | 0.030 |
| Supermajority required to invalidate laws | federalism | 3922 | 0.905 | 0.852 | 0.054 | 0.000 | 0.857 | 0.021 | 0.027 | 0.684 | 0.104 | 0.042 |
| Supermajority required to invalidate laws | speech | 3812 | 0.974 | 0.777 | 0.054 | 0.087 | 0.839 | 0.022 | 0.036 | 0.684 | 0.104 | 0.043 |
| Strict recusal with substitute justices | administrative_state | 3842 | 0.894 | 0.842 | 0.052 | 0.000 | 0.855 | 0.018 | 0.027 | 0.728 | 0.093 | 0.035 |
| Strict recusal with substitute justices | criminal_procedure | 3796 | 0.965 | 0.779 | 0.061 | 0.082 | 0.844 | 0.020 | 0.033 | 0.722 | 0.102 | 0.041 |
| Strict recusal with substitute justices | election_law | 9819 | 0.989 | 0.801 | 0.017 | 0.027 | 0.868 | 0.012 | 0.027 | 0.872 | 0.062 | 0.021 |
| Strict recusal with substitute justices | emergency_powers | 4624 | 0.983 | 0.813 | 0.073 | 0.011 | 0.846 | 0.023 | 0.035 | 0.760 | 0.085 | 0.033 |
| Strict recusal with substitute justices | equality | 18185 | 0.997 | 0.738 | 0.012 | 0.182 | 0.843 | 0.017 | 0.036 | 0.873 | 0.071 | 0.026 |
| Strict recusal with substitute justices | federalism | 3922 | 0.900 | 0.852 | 0.051 | 0.000 | 0.861 | 0.024 | 0.027 | 0.729 | 0.098 | 0.036 |
| Strict recusal with substitute justices | speech | 3812 | 0.974 | 0.780 | 0.054 | 0.113 | 0.838 | 0.025 | 0.036 | 0.719 | 0.100 | 0.040 |
| Reasoned emergency orders with merits follow-up | administrative_state | 3842 | 0.904 | 0.843 | 0.000 | 0.000 | 0.878 | 0.011 | 0.022 | 0.828 | 0.085 | 0.031 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 3796 | 0.964 | 0.785 | 0.002 | 0.092 | 0.869 | 0.013 | 0.027 | 0.816 | 0.093 | 0.037 |
| Reasoned emergency orders with merits follow-up | election_law | 9819 | 0.990 | 0.802 | 0.001 | 0.033 | 0.881 | 0.009 | 0.023 | 0.906 | 0.058 | 0.019 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 4624 | 0.981 | 0.814 | 0.004 | 0.020 | 0.869 | 0.014 | 0.025 | 0.837 | 0.077 | 0.028 |
| Reasoned emergency orders with merits follow-up | equality | 18185 | 0.997 | 0.745 | 0.001 | 0.241 | 0.849 | 0.015 | 0.038 | 0.884 | 0.074 | 0.029 |
| Reasoned emergency orders with merits follow-up | federalism | 3922 | 0.899 | 0.852 | 0.000 | 0.000 | 0.889 | 0.014 | 0.023 | 0.825 | 0.090 | 0.032 |
| Reasoned emergency orders with merits follow-up | speech | 3812 | 0.976 | 0.785 | 0.003 | 0.115 | 0.864 | 0.016 | 0.030 | 0.816 | 0.091 | 0.037 |
| Panel review with en banc safety valve | administrative_state | 3842 | 1.000 | 0.847 | 0.051 | 0.000 | 0.843 | 0.022 | 0.033 | 0.704 | 0.094 | 0.037 |
| Panel review with en banc safety valve | criminal_procedure | 3796 | 1.000 | 0.782 | 0.059 | 0.091 | 0.838 | 0.025 | 0.035 | 0.702 | 0.103 | 0.043 |
| Panel review with en banc safety valve | election_law | 9819 | 1.000 | 0.801 | 0.018 | 0.031 | 0.862 | 0.012 | 0.031 | 0.861 | 0.062 | 0.022 |
| Panel review with en banc safety valve | emergency_powers | 4624 | 1.000 | 0.814 | 0.075 | 0.015 | 0.844 | 0.023 | 0.030 | 0.741 | 0.086 | 0.034 |
| Panel review with en banc safety valve | equality | 18185 | 1.000 | 0.741 | 0.012 | 0.210 | 0.840 | 0.016 | 0.041 | 0.860 | 0.075 | 0.028 |
| Panel review with en banc safety valve | federalism | 3922 | 1.000 | 0.857 | 0.052 | 0.000 | 0.857 | 0.017 | 0.033 | 0.708 | 0.099 | 0.037 |
| Panel review with en banc safety valve | speech | 3812 | 1.000 | 0.783 | 0.057 | 0.129 | 0.830 | 0.022 | 0.037 | 0.701 | 0.101 | 0.043 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 3842 | 1.000 | 0.847 | 0.000 | 0.000 | 0.879 | 0.007 | 0.027 | 0.878 | 0.079 | 0.021 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 3796 | 1.000 | 0.782 | 0.003 | 0.057 | 0.867 | 0.012 | 0.027 | 0.866 | 0.087 | 0.026 |
| Dual supreme courts with cross-checking invalidations | election_law | 9819 | 1.000 | 0.801 | 0.001 | 0.016 | 0.883 | 0.009 | 0.022 | 0.932 | 0.055 | 0.014 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 4624 | 1.000 | 0.814 | 0.007 | 0.004 | 0.877 | 0.011 | 0.023 | 0.888 | 0.072 | 0.020 |
| Dual supreme courts with cross-checking invalidations | equality | 18185 | 1.000 | 0.737 | 0.001 | 0.156 | 0.857 | 0.014 | 0.031 | 0.912 | 0.066 | 0.020 |
| Dual supreme courts with cross-checking invalidations | federalism | 3922 | 0.999 | 0.857 | 0.000 | 0.000 | 0.866 | 0.010 | 0.025 | 0.873 | 0.084 | 0.022 |
| Dual supreme courts with cross-checking invalidations | speech | 3812 | 1.000 | 0.782 | 0.003 | 0.077 | 0.864 | 0.013 | 0.029 | 0.870 | 0.085 | 0.025 |
| Pre-enactment constitutional council | administrative_state | 3842 | 1.000 | 0.847 | 0.052 | 0.000 | 0.855 | 0.015 | 0.029 | 0.791 | 0.083 | 0.022 |
| Pre-enactment constitutional council | criminal_procedure | 3796 | 1.000 | 0.778 | 0.059 | 0.053 | 0.841 | 0.019 | 0.037 | 0.783 | 0.091 | 0.027 |
| Pre-enactment constitutional council | election_law | 9819 | 1.000 | 0.800 | 0.017 | 0.015 | 0.861 | 0.012 | 0.026 | 0.900 | 0.057 | 0.015 |
| Pre-enactment constitutional council | emergency_powers | 4624 | 1.000 | 0.813 | 0.071 | 0.002 | 0.848 | 0.015 | 0.028 | 0.817 | 0.076 | 0.021 |
| Pre-enactment constitutional council | equality | 18185 | 1.000 | 0.729 | 0.012 | 0.116 | 0.848 | 0.014 | 0.033 | 0.908 | 0.061 | 0.017 |
| Pre-enactment constitutional council | federalism | 3922 | 1.000 | 0.857 | 0.052 | 0.000 | 0.854 | 0.014 | 0.028 | 0.792 | 0.088 | 0.023 |
| Pre-enactment constitutional council | speech | 3812 | 1.000 | 0.778 | 0.054 | 0.077 | 0.844 | 0.019 | 0.028 | 0.787 | 0.089 | 0.027 |
| Judicial review with delayed legislative override | administrative_state | 3842 | 0.902 | 0.843 | 0.054 | 0.000 | 0.855 | 0.020 | 0.032 | 0.674 | 0.100 | 0.046 |
| Judicial review with delayed legislative override | criminal_procedure | 3796 | 0.967 | 0.780 | 0.060 | 0.095 | 0.837 | 0.028 | 0.035 | 0.667 | 0.110 | 0.052 |
| Judicial review with delayed legislative override | election_law | 9819 | 0.989 | 0.800 | 0.018 | 0.032 | 0.858 | 0.015 | 0.029 | 0.830 | 0.065 | 0.025 |
| Judicial review with delayed legislative override | emergency_powers | 4624 | 0.979 | 0.813 | 0.075 | 0.020 | 0.831 | 0.024 | 0.036 | 0.713 | 0.091 | 0.043 |
| Judicial review with delayed legislative override | equality | 18185 | 0.997 | 0.735 | 0.012 | 0.201 | 0.834 | 0.021 | 0.039 | 0.824 | 0.080 | 0.032 |
| Judicial review with delayed legislative override | federalism | 3922 | 0.900 | 0.852 | 0.054 | 0.000 | 0.851 | 0.020 | 0.030 | 0.676 | 0.105 | 0.046 |
| Judicial review with delayed legislative override | speech | 3812 | 0.975 | 0.780 | 0.055 | 0.117 | 0.843 | 0.027 | 0.035 | 0.669 | 0.108 | 0.052 |
| Retention-election accountability court | administrative_state | 3842 | 0.906 | 0.843 | 0.054 | 0.000 | 0.859 | 0.016 | 0.025 | 0.772 | 0.086 | 0.023 |
| Retention-election accountability court | criminal_procedure | 3796 | 0.968 | 0.773 | 0.058 | 0.042 | 0.825 | 0.019 | 0.030 | 0.769 | 0.093 | 0.027 |
| Retention-election accountability court | election_law | 9819 | 0.990 | 0.798 | 0.016 | 0.011 | 0.851 | 0.013 | 0.026 | 0.888 | 0.058 | 0.016 |
| Retention-election accountability court | emergency_powers | 4624 | 0.979 | 0.812 | 0.073 | 0.003 | 0.830 | 0.023 | 0.031 | 0.800 | 0.078 | 0.021 |
| Retention-election accountability court | equality | 18185 | 0.997 | 0.715 | 0.012 | 0.073 | 0.837 | 0.017 | 0.032 | 0.888 | 0.064 | 0.017 |
| Retention-election accountability court | federalism | 3922 | 0.899 | 0.852 | 0.053 | 0.000 | 0.862 | 0.017 | 0.026 | 0.771 | 0.091 | 0.024 |
| Retention-election accountability court | speech | 3812 | 0.974 | 0.773 | 0.050 | 0.058 | 0.833 | 0.022 | 0.030 | 0.766 | 0.090 | 0.026 |
| Hybrid court balancing independence and accountability | administrative_state | 3842 | 1.000 | 0.847 | 0.000 | 0.000 | 0.878 | 0.011 | 0.021 | 0.869 | 0.080 | 0.024 |
| Hybrid court balancing independence and accountability | criminal_procedure | 3796 | 1.000 | 0.785 | 0.002 | 0.076 | 0.861 | 0.016 | 0.028 | 0.859 | 0.088 | 0.030 |
| Hybrid court balancing independence and accountability | election_law | 9819 | 1.000 | 0.801 | 0.001 | 0.021 | 0.873 | 0.012 | 0.026 | 0.928 | 0.055 | 0.015 |
| Hybrid court balancing independence and accountability | emergency_powers | 4624 | 1.000 | 0.814 | 0.003 | 0.005 | 0.864 | 0.013 | 0.027 | 0.880 | 0.072 | 0.022 |
| Hybrid court balancing independence and accountability | equality | 18185 | 1.000 | 0.741 | 0.001 | 0.197 | 0.851 | 0.015 | 0.033 | 0.908 | 0.067 | 0.023 |
| Hybrid court balancing independence and accountability | federalism | 3922 | 1.000 | 0.857 | 0.000 | 0.000 | 0.877 | 0.012 | 0.022 | 0.869 | 0.085 | 0.025 |
| Hybrid court balancing independence and accountability | speech | 3812 | 1.000 | 0.786 | 0.003 | 0.102 | 0.861 | 0.012 | 0.033 | 0.862 | 0.085 | 0.028 |
