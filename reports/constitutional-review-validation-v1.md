# Constitutional Review Calibration Validation Campaign v1

- runs per case: 120
- seed: 20260501
- input: synthetic docket

## Top Directional Scores by Case

### Shared benchmark context

Shared docket context for comparing real-world scenario presets against documented calibration target ranges.

- best overall: French Constitutional Council (`french-constitutional-council`) at 0.692
- strongest rights protection: South African Constitutional Court at 0.741
- lowest shadow-docket abuse: South African Constitutional Court at 0.005
- lowest emergency relief rate: French Constitutional Council at 0.359
- highest compliance rate: French Constitutional Council at 0.469
- lowest defiance rate: French Constitutional Council at 0.233

## Scenario Averages

| Scenario | Score | Stability | Rights | Partisan | Shadow | Intake | Emerg. relief | Reasons | Disagree | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin | Direct | Upstream | Capacity | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| U.S. Supreme Court benchmark | 0.535 | 0.770 | 0.673 | 0.204 | 0.447 | 0.022 | 0.675 | 0.024 | 0.563 | 0.480 | 0.557 | 0.221 | 0.368 | 0.393 | 0.310 | 0.235 | 0.281 | 0.060 | 0.121 | 2.436 | 0.569 | 0.495 | 0.555 | 0.697 | 0.516 | 0.566 |
| German Federal Constitutional Court | 0.651 | 0.894 | 0.734 | 0.150 | 0.091 | 0.006 | 0.471 | 0.721 | 0.257 | 0.424 | 0.716 | 0.348 | 0.261 | 0.454 | 0.441 | 0.361 | 0.239 | 0.062 | 0.208 | 2.436 | 0.569 | 0.683 | 0.618 | 0.820 | 0.633 | 0.677 |
| French Constitutional Council | 0.692 | 0.938 | 0.735 | 0.136 | 0.086 | 0.817 | 0.359 | 0.707 | 0.246 | 0.272 | 0.719 | 0.223 | 0.245 | 0.467 | 0.469 | 0.404 | 0.185 | 0.050 | 0.241 | 2.436 | 0.569 | 0.737 | 0.417 | 0.352 | 0.395 | 0.431 |
| Canadian Supreme Court with override context | 0.649 | 0.870 | 0.728 | 0.164 | 0.094 | 0.101 | 0.498 | 0.698 | 0.265 | 0.470 | 0.694 | 0.385 | 0.273 | 0.452 | 0.392 | 0.329 | 0.247 | 0.070 | 0.176 | 2.436 | 0.569 | 0.472 | 0.437 | 0.590 | 0.427 | 0.498 |
| South African Constitutional Court | 0.678 | 0.891 | 0.741 | 0.162 | 0.005 | 0.856 | 0.447 | 0.853 | 0.122 | 0.444 | 0.720 | 0.444 | 0.243 | 0.460 | 0.417 | 0.348 | 0.240 | 0.068 | 0.198 | 2.436 | 0.569 | 0.477 | 0.429 | 0.484 | 0.481 | 0.505 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| U.S. Supreme Court benchmark | 1 | 2400 | 1.000 | 0.022 | 0.674 | 0.451 | 0.024 | 0.551 | 0.456 | 2.424 | 0.570 | 0.510 | 0.463 | 0.389 | 0.188 | 0.038 | 0.260 | 0.083 | 0.799 | 0.550 | 0.563 |
| U.S. Supreme Court benchmark | 2 | 2400 | 1.000 | 0.022 | 0.672 | 0.442 | 0.023 | 0.562 | 0.510 | 2.428 | 0.567 | 0.508 | 0.282 | 0.200 | 0.300 | 0.063 | 0.089 | 0.000 | 0.997 | 0.998 | 0.567 |
| U.S. Supreme Court benchmark | 3 | 2400 | 1.000 | 0.022 | 0.673 | 0.451 | 0.029 | 0.572 | 0.483 | 2.441 | 0.570 | 0.506 | 0.248 | 0.184 | 0.312 | 0.075 | 0.070 | 0.000 | 0.997 | 1.000 | 0.567 |
| U.S. Supreme Court benchmark | 4 | 2400 | 1.000 | 0.022 | 0.674 | 0.445 | 0.020 | 0.566 | 0.473 | 2.450 | 0.569 | 0.508 | 0.245 | 0.168 | 0.325 | 0.066 | 0.064 | 0.000 | 0.997 | 1.000 | 0.568 |
| German Federal Constitutional Court | 1 | 2400 | 1.000 | 0.006 | 0.732 | 0.092 | 0.683 | 0.286 | 0.408 | 2.424 | 0.570 | 0.510 | 0.613 | 0.518 | 0.147 | 0.032 | 0.393 | 0.158 | 0.588 | 0.363 | 0.668 |
| German Federal Constitutional Court | 2 | 2400 | 1.000 | 0.006 | 0.734 | 0.090 | 0.714 | 0.246 | 0.428 | 2.428 | 0.567 | 0.508 | 0.440 | 0.355 | 0.243 | 0.065 | 0.193 | 0.001 | 0.832 | 0.868 | 0.681 |
| German Federal Constitutional Court | 3 | 2400 | 1.000 | 0.006 | 0.734 | 0.092 | 0.744 | 0.238 | 0.437 | 2.441 | 0.570 | 0.506 | 0.365 | 0.292 | 0.280 | 0.075 | 0.129 | 0.001 | 0.959 | 0.990 | 0.680 |
| German Federal Constitutional Court | 4 | 2400 | 1.000 | 0.006 | 0.735 | 0.089 | 0.741 | 0.261 | 0.425 | 2.450 | 0.569 | 0.508 | 0.344 | 0.281 | 0.285 | 0.076 | 0.115 | 0.001 | 0.984 | 0.999 | 0.681 |
| French Constitutional Council | 1 | 2400 | 1.000 | 0.822 | 0.734 | 0.085 | 0.710 | 0.269 | 0.260 | 2.424 | 0.570 | 0.510 | 0.618 | 0.545 | 0.110 | 0.020 | 0.393 | 0.207 | 0.492 | 0.238 | 0.416 |
| French Constitutional Council | 2 | 2400 | 1.000 | 0.818 | 0.734 | 0.085 | 0.694 | 0.252 | 0.277 | 2.428 | 0.567 | 0.508 | 0.504 | 0.428 | 0.166 | 0.054 | 0.260 | 0.002 | 0.592 | 0.564 | 0.436 |
| French Constitutional Council | 3 | 2400 | 1.000 | 0.808 | 0.736 | 0.090 | 0.703 | 0.219 | 0.283 | 2.441 | 0.570 | 0.506 | 0.397 | 0.342 | 0.224 | 0.066 | 0.174 | 0.001 | 0.745 | 0.810 | 0.437 |
| French Constitutional Council | 4 | 2400 | 1.000 | 0.820 | 0.737 | 0.084 | 0.723 | 0.244 | 0.271 | 2.450 | 0.569 | 0.508 | 0.359 | 0.301 | 0.240 | 0.062 | 0.135 | 0.001 | 0.851 | 0.912 | 0.437 |
| Canadian Supreme Court with override context | 1 | 2400 | 1.000 | 0.101 | 0.727 | 0.097 | 0.673 | 0.252 | 0.458 | 2.424 | 0.570 | 0.510 | 0.567 | 0.488 | 0.148 | 0.042 | 0.354 | 0.135 | 0.635 | 0.411 | 0.494 |
| Canadian Supreme Court with override context | 2 | 2400 | 1.000 | 0.101 | 0.727 | 0.094 | 0.689 | 0.261 | 0.471 | 2.428 | 0.567 | 0.508 | 0.370 | 0.313 | 0.259 | 0.074 | 0.160 | 0.001 | 0.908 | 0.931 | 0.499 |
| Canadian Supreme Court with override context | 3 | 2400 | 1.000 | 0.102 | 0.728 | 0.095 | 0.699 | 0.276 | 0.481 | 2.441 | 0.570 | 0.506 | 0.305 | 0.258 | 0.280 | 0.087 | 0.096 | 0.000 | 0.988 | 0.999 | 0.499 |
| Canadian Supreme Court with override context | 4 | 2400 | 1.000 | 0.102 | 0.731 | 0.091 | 0.729 | 0.271 | 0.472 | 2.450 | 0.569 | 0.508 | 0.325 | 0.256 | 0.299 | 0.078 | 0.094 | 0.000 | 0.991 | 1.000 | 0.500 |
| South African Constitutional Court | 1 | 2400 | 1.000 | 0.856 | 0.741 | 0.005 | 0.867 | 0.111 | 0.437 | 2.424 | 0.570 | 0.510 | 0.588 | 0.516 | 0.135 | 0.040 | 0.373 | 0.162 | 0.590 | 0.390 | 0.495 |
| South African Constitutional Court | 2 | 2400 | 1.000 | 0.855 | 0.739 | 0.004 | 0.856 | 0.115 | 0.453 | 2.428 | 0.567 | 0.508 | 0.412 | 0.335 | 0.257 | 0.072 | 0.187 | 0.001 | 0.837 | 0.895 | 0.508 |
| South African Constitutional Court | 3 | 2400 | 1.000 | 0.853 | 0.740 | 0.005 | 0.858 | 0.128 | 0.446 | 2.441 | 0.570 | 0.506 | 0.334 | 0.269 | 0.293 | 0.078 | 0.112 | 0.001 | 0.967 | 0.997 | 0.508 |
| South African Constitutional Court | 4 | 2400 | 1.000 | 0.860 | 0.742 | 0.005 | 0.832 | 0.133 | 0.441 | 2.450 | 0.569 | 0.508 | 0.336 | 0.273 | 0.274 | 0.085 | 0.119 | 0.001 | 0.986 | 1.000 | 0.508 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| U.S. Supreme Court benchmark | administrative_state | 1354 | 1.000 | 0.021 | 0.738 | 0.361 | 0.015 | 0.531 | 0.072 | 2.694 | 0.473 | 0.517 | 0.363 | 0.275 | 0.329 | 0.049 | 0.176 | 0.023 | 0.943 | 0.886 | 0.574 |
| U.S. Supreme Court benchmark | criminal_procedure | 1417 | 1.000 | 0.022 | 0.655 | 0.433 | 0.015 | 0.530 | 0.606 | 2.372 | 0.572 | 0.501 | 0.306 | 0.224 | 0.286 | 0.064 | 0.101 | 0.021 | 0.950 | 0.893 | 0.562 |
| U.S. Supreme Court benchmark | election_law | 1352 | 1.000 | 0.023 | 0.629 | 0.452 | 0.038 | 0.574 | 0.709 | 2.709 | 0.665 | 0.519 | 0.277 | 0.210 | 0.277 | 0.071 | 0.078 | 0.016 | 0.957 | 0.901 | 0.572 |
| U.S. Supreme Court benchmark | emergency_powers | 1397 | 1.000 | 0.023 | 0.641 | 0.655 | 0.022 | 0.616 | 0.370 | 1.994 | 0.538 | 0.495 | 0.285 | 0.192 | 0.282 | 0.053 | 0.109 | 0.022 | 0.946 | 0.878 | 0.563 |
| U.S. Supreme Court benchmark | equality | 1353 | 1.000 | 0.022 | 0.650 | 0.459 | 0.028 | 0.564 | 0.808 | 2.291 | 0.519 | 0.470 | 0.302 | 0.227 | 0.290 | 0.061 | 0.147 | 0.021 | 0.948 | 0.884 | 0.558 |
| U.S. Supreme Court benchmark | federalism | 1381 | 1.000 | 0.022 | 0.735 | 0.363 | 0.024 | 0.515 | 0.146 | 2.772 | 0.755 | 0.596 | 0.311 | 0.251 | 0.250 | 0.055 | 0.087 | 0.019 | 0.946 | 0.886 | 0.581 |
| U.S. Supreme Court benchmark | speech | 1346 | 1.000 | 0.021 | 0.665 | 0.404 | 0.027 | 0.586 | 0.609 | 2.227 | 0.457 | 0.456 | 0.325 | 0.268 | 0.253 | 0.070 | 0.150 | 0.023 | 0.944 | 0.881 | 0.555 |
| German Federal Constitutional Court | administrative_state | 1354 | 1.000 | 0.006 | 0.768 | 0.067 | 0.710 | 0.175 | 0.019 | 2.694 | 0.473 | 0.517 | 0.449 | 0.385 | 0.283 | 0.038 | 0.261 | 0.045 | 0.832 | 0.802 | 0.684 |
| German Federal Constitutional Court | criminal_procedure | 1417 | 1.000 | 0.006 | 0.714 | 0.095 | 0.744 | 0.311 | 0.559 | 2.372 | 0.572 | 0.501 | 0.437 | 0.363 | 0.215 | 0.070 | 0.195 | 0.038 | 0.843 | 0.810 | 0.668 |
| German Federal Constitutional Court | election_law | 1352 | 1.000 | 0.007 | 0.714 | 0.071 | 0.777 | 0.247 | 0.620 | 2.709 | 0.665 | 0.519 | 0.422 | 0.361 | 0.226 | 0.075 | 0.145 | 0.031 | 0.855 | 0.821 | 0.691 |
| German Federal Constitutional Court | emergency_powers | 1397 | 1.000 | 0.007 | 0.723 | 0.169 | 0.719 | 0.307 | 0.317 | 1.994 | 0.538 | 0.495 | 0.451 | 0.344 | 0.248 | 0.058 | 0.215 | 0.044 | 0.831 | 0.790 | 0.680 |
| German Federal Constitutional Court | equality | 1353 | 1.000 | 0.007 | 0.718 | 0.080 | 0.720 | 0.233 | 0.761 | 2.291 | 0.519 | 0.470 | 0.434 | 0.356 | 0.243 | 0.078 | 0.219 | 0.041 | 0.846 | 0.806 | 0.665 |
| German Federal Constitutional Court | federalism | 1381 | 1.000 | 0.006 | 0.782 | 0.071 | 0.633 | 0.180 | 0.023 | 2.772 | 0.755 | 0.596 | 0.442 | 0.349 | 0.219 | 0.050 | 0.181 | 0.042 | 0.832 | 0.802 | 0.698 |
| German Federal Constitutional Court | speech | 1346 | 1.000 | 0.006 | 0.718 | 0.081 | 0.743 | 0.268 | 0.603 | 2.227 | 0.457 | 0.456 | 0.449 | 0.371 | 0.238 | 0.064 | 0.238 | 0.042 | 0.845 | 0.805 | 0.657 |
| French Constitutional Council | administrative_state | 1354 | 1.000 | 0.838 | 0.768 | 0.066 | 0.650 | 0.218 | 0.002 | 2.694 | 0.473 | 0.517 | 0.479 | 0.444 | 0.236 | 0.041 | 0.295 | 0.054 | 0.661 | 0.626 | 0.437 |
| French Constitutional Council | criminal_procedure | 1417 | 1.000 | 0.851 | 0.712 | 0.087 | 0.667 | 0.279 | 0.350 | 2.372 | 0.572 | 0.501 | 0.470 | 0.394 | 0.170 | 0.057 | 0.234 | 0.050 | 0.669 | 0.633 | 0.426 |
| French Constitutional Council | election_law | 1352 | 1.000 | 0.834 | 0.720 | 0.067 | 0.734 | 0.312 | 0.405 | 2.709 | 0.665 | 0.519 | 0.446 | 0.385 | 0.184 | 0.067 | 0.207 | 0.042 | 0.680 | 0.647 | 0.438 |
| French Constitutional Council | emergency_powers | 1397 | 1.000 | 0.671 | 0.723 | 0.161 | 0.740 | 0.237 | 0.133 | 1.994 | 0.538 | 0.495 | 0.468 | 0.394 | 0.180 | 0.044 | 0.251 | 0.059 | 0.667 | 0.623 | 0.432 |
| French Constitutional Council | equality | 1353 | 1.000 | 0.855 | 0.724 | 0.082 | 0.741 | 0.259 | 0.583 | 2.291 | 0.519 | 0.470 | 0.481 | 0.392 | 0.185 | 0.050 | 0.256 | 0.054 | 0.684 | 0.640 | 0.423 |
| French Constitutional Council | federalism | 1381 | 1.000 | 0.835 | 0.784 | 0.068 | 0.629 | 0.167 | 0.005 | 2.772 | 0.755 | 0.596 | 0.474 | 0.411 | 0.175 | 0.049 | 0.188 | 0.054 | 0.657 | 0.617 | 0.445 |
| French Constitutional Council | speech | 1346 | 1.000 | 0.877 | 0.717 | 0.069 | 0.738 | 0.255 | 0.373 | 2.227 | 0.457 | 0.456 | 0.467 | 0.410 | 0.167 | 0.046 | 0.256 | 0.055 | 0.670 | 0.630 | 0.418 |
| Canadian Supreme Court with override context | administrative_state | 1354 | 1.000 | 0.096 | 0.766 | 0.067 | 0.663 | 0.169 | 0.048 | 2.694 | 0.473 | 0.517 | 0.422 | 0.372 | 0.290 | 0.050 | 0.222 | 0.040 | 0.870 | 0.832 | 0.505 |
| Canadian Supreme Court with override context | criminal_procedure | 1417 | 1.000 | 0.100 | 0.709 | 0.096 | 0.686 | 0.284 | 0.603 | 2.372 | 0.572 | 0.501 | 0.382 | 0.315 | 0.243 | 0.073 | 0.169 | 0.032 | 0.882 | 0.839 | 0.494 |
| Canadian Supreme Court with override context | election_law | 1352 | 1.000 | 0.107 | 0.700 | 0.075 | 0.727 | 0.252 | 0.703 | 2.709 | 0.665 | 0.519 | 0.374 | 0.305 | 0.238 | 0.088 | 0.143 | 0.027 | 0.897 | 0.854 | 0.504 |
| Canadian Supreme Court with override context | emergency_powers | 1397 | 1.000 | 0.106 | 0.716 | 0.179 | 0.714 | 0.292 | 0.414 | 1.994 | 0.538 | 0.495 | 0.384 | 0.321 | 0.251 | 0.064 | 0.175 | 0.035 | 0.873 | 0.823 | 0.496 |
| Canadian Supreme Court with override context | equality | 1353 | 1.000 | 0.101 | 0.714 | 0.086 | 0.692 | 0.281 | 0.782 | 2.291 | 0.519 | 0.470 | 0.387 | 0.316 | 0.249 | 0.083 | 0.194 | 0.034 | 0.888 | 0.837 | 0.490 |
| Canadian Supreme Court with override context | federalism | 1381 | 1.000 | 0.102 | 0.776 | 0.073 | 0.645 | 0.262 | 0.067 | 2.772 | 0.755 | 0.596 | 0.382 | 0.344 | 0.211 | 0.055 | 0.127 | 0.034 | 0.872 | 0.830 | 0.512 |
| Canadian Supreme Court with override context | speech | 1346 | 1.000 | 0.098 | 0.715 | 0.079 | 0.730 | 0.266 | 0.620 | 2.227 | 0.457 | 0.456 | 0.412 | 0.329 | 0.246 | 0.077 | 0.205 | 0.037 | 0.882 | 0.834 | 0.487 |
| South African Constitutional Court | administrative_state | 1354 | 1.000 | 0.890 | 0.768 | 0.000 | 0.829 | 0.061 | 0.038 | 2.694 | 0.473 | 0.517 | 0.447 | 0.376 | 0.273 | 0.057 | 0.250 | 0.045 | 0.832 | 0.817 | 0.510 |
| South African Constitutional Court | criminal_procedure | 1417 | 1.000 | 0.885 | 0.727 | 0.002 | 0.852 | 0.117 | 0.606 | 2.372 | 0.572 | 0.501 | 0.434 | 0.339 | 0.236 | 0.067 | 0.176 | 0.039 | 0.850 | 0.827 | 0.500 |
| South African Constitutional Court | election_law | 1352 | 1.000 | 0.884 | 0.717 | 0.006 | 0.883 | 0.140 | 0.666 | 2.709 | 0.665 | 0.519 | 0.389 | 0.326 | 0.263 | 0.084 | 0.139 | 0.032 | 0.863 | 0.838 | 0.511 |
| South African Constitutional Court | emergency_powers | 1397 | 1.000 | 0.702 | 0.733 | 0.015 | 0.842 | 0.152 | 0.343 | 1.994 | 0.538 | 0.495 | 0.406 | 0.352 | 0.218 | 0.064 | 0.223 | 0.045 | 0.835 | 0.808 | 0.505 |
| South African Constitutional Court | equality | 1353 | 1.000 | 0.887 | 0.729 | 0.006 | 0.883 | 0.106 | 0.778 | 2.291 | 0.519 | 0.470 | 0.425 | 0.358 | 0.242 | 0.075 | 0.207 | 0.040 | 0.854 | 0.821 | 0.496 |
| South African Constitutional Court | federalism | 1381 | 1.000 | 0.884 | 0.782 | 0.000 | 0.846 | 0.071 | 0.054 | 2.772 | 0.755 | 0.596 | 0.411 | 0.342 | 0.213 | 0.054 | 0.160 | 0.043 | 0.831 | 0.810 | 0.518 |
| South African Constitutional Court | speech | 1346 | 1.000 | 0.905 | 0.729 | 0.004 | 0.863 | 0.137 | 0.630 | 2.227 | 0.457 | 0.456 | 0.409 | 0.344 | 0.235 | 0.078 | 0.232 | 0.043 | 0.851 | 0.823 | 0.492 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| U.S. Supreme Court benchmark | federal/circuit_en_banc | 887 | 1.000 | 0.021 | 0.703 | 0.419 | 0.017 | 0.561 | 0.312 | 3.000 | 0.399 | 0.489 | 0.349 | 0.278 | 0.307 | 0.054 | 0.191 | 0.022 | 0.945 | 0.888 | 0.576 |
| U.S. Supreme Court benchmark | federal/circuit_panel | 2016 | 1.000 | 0.021 | 0.682 | 0.438 | 0.024 | 0.573 | 0.463 | 2.000 | 0.417 | 0.447 | 0.323 | 0.249 | 0.285 | 0.055 | 0.188 | 0.023 | 0.945 | 0.884 | 0.554 |
| U.S. Supreme Court benchmark | federal/district_only | 536 | 1.000 | 0.021 | 0.670 | 0.543 | 0.015 | 0.611 | 0.485 | 1.000 | 0.415 | 0.420 | 0.345 | 0.231 | 0.278 | 0.049 | 0.196 | 0.024 | 0.938 | 0.870 | 0.536 |
| U.S. Supreme Court benchmark | federal/state_federal_split | 207 | 1.000 | 0.022 | 0.693 | 0.398 | 0.029 | 0.558 | 0.408 | 3.000 | 0.549 | 0.531 | 0.261 | 0.242 | 0.266 | 0.039 | 0.150 | 0.018 | 0.946 | 0.891 | 0.580 |
| U.S. Supreme Court benchmark | mixed_state_federal/circuit_en_banc | 778 | 1.000 | 0.023 | 0.664 | 0.462 | 0.030 | 0.565 | 0.437 | 3.000 | 0.766 | 0.565 | 0.299 | 0.204 | 0.310 | 0.066 | 0.072 | 0.014 | 0.954 | 0.896 | 0.580 |
| U.S. Supreme Court benchmark | mixed_state_federal/district_only | 113 | 1.000 | 0.023 | 0.633 | 0.648 | 0.025 | 0.679 | 0.406 | 1.000 | 0.743 | 0.515 | 0.283 | 0.177 | 0.292 | 0.062 | 0.044 | 0.014 | 0.952 | 0.887 | 0.545 |
| U.S. Supreme Court benchmark | mixed_state_federal/state_federal_split | 1629 | 1.000 | 0.023 | 0.658 | 0.429 | 0.028 | 0.526 | 0.554 | 3.000 | 0.789 | 0.590 | 0.297 | 0.218 | 0.274 | 0.068 | 0.058 | 0.021 | 0.947 | 0.883 | 0.581 |
| U.S. Supreme Court benchmark | state/circuit_en_banc | 87 | 1.000 | 0.021 | 0.742 | 0.350 | 0.000 | 0.524 | 0.044 | 3.000 | 0.490 | 0.514 | 0.287 | 0.230 | 0.379 | 0.023 | 0.103 | 0.008 | 0.958 | 0.914 | 0.578 |
| U.S. Supreme Court benchmark | state/circuit_panel | 594 | 1.000 | 0.021 | 0.689 | 0.429 | 0.016 | 0.516 | 0.427 | 2.000 | 0.569 | 0.483 | 0.306 | 0.264 | 0.271 | 0.056 | 0.114 | 0.016 | 0.955 | 0.900 | 0.557 |
| U.S. Supreme Court benchmark | state/district_only | 117 | 1.000 | 0.022 | 0.690 | 0.560 | 0.013 | 0.675 | 0.200 | 1.000 | 0.536 | 0.460 | 0.333 | 0.197 | 0.205 | 0.017 | 0.103 | 0.026 | 0.943 | 0.874 | 0.542 |
| U.S. Supreme Court benchmark | state/state_federal_split | 1361 | 1.000 | 0.023 | 0.662 | 0.450 | 0.031 | 0.575 | 0.546 | 3.000 | 0.602 | 0.545 | 0.295 | 0.228 | 0.267 | 0.071 | 0.086 | 0.021 | 0.949 | 0.890 | 0.579 |
| U.S. Supreme Court benchmark | state/state_high_court | 1275 | 1.000 | 0.022 | 0.663 | 0.450 | 0.022 | 0.552 | 0.576 | 2.000 | 0.552 | 0.485 | 0.295 | 0.227 | 0.269 | 0.067 | 0.089 | 0.022 | 0.949 | 0.887 | 0.557 |
| German Federal Constitutional Court | federal/circuit_en_banc | 887 | 1.000 | 0.006 | 0.747 | 0.084 | 0.750 | 0.250 | 0.267 | 3.000 | 0.399 | 0.489 | 0.443 | 0.380 | 0.267 | 0.057 | 0.276 | 0.045 | 0.843 | 0.813 | 0.687 |
| German Federal Constitutional Court | federal/circuit_panel | 2016 | 1.000 | 0.006 | 0.733 | 0.093 | 0.709 | 0.270 | 0.426 | 2.000 | 0.417 | 0.447 | 0.459 | 0.382 | 0.230 | 0.060 | 0.301 | 0.042 | 0.835 | 0.800 | 0.658 |
| German Federal Constitutional Court | federal/district_only | 536 | 1.000 | 0.006 | 0.732 | 0.110 | 0.680 | 0.242 | 0.440 | 1.000 | 0.415 | 0.420 | 0.487 | 0.390 | 0.226 | 0.071 | 0.267 | 0.048 | 0.824 | 0.783 | 0.637 |
| German Federal Constitutional Court | federal/state_federal_split | 207 | 1.000 | 0.006 | 0.755 | 0.074 | 0.609 | 0.217 | 0.310 | 3.000 | 0.549 | 0.531 | 0.483 | 0.343 | 0.208 | 0.058 | 0.271 | 0.039 | 0.836 | 0.807 | 0.699 |
| German Federal Constitutional Court | mixed_state_federal/circuit_en_banc | 778 | 1.000 | 0.007 | 0.735 | 0.088 | 0.749 | 0.257 | 0.384 | 3.000 | 0.766 | 0.565 | 0.432 | 0.324 | 0.234 | 0.055 | 0.154 | 0.031 | 0.848 | 0.816 | 0.696 |
| German Federal Constitutional Court | mixed_state_federal/district_only | 113 | 1.000 | 0.007 | 0.724 | 0.171 | 0.667 | 0.298 | 0.425 | 1.000 | 0.743 | 0.515 | 0.442 | 0.319 | 0.195 | 0.080 | 0.230 | 0.041 | 0.825 | 0.790 | 0.659 |
| German Federal Constitutional Court | mixed_state_federal/state_federal_split | 1629 | 1.000 | 0.007 | 0.730 | 0.086 | 0.700 | 0.263 | 0.476 | 3.000 | 0.789 | 0.590 | 0.431 | 0.331 | 0.258 | 0.058 | 0.113 | 0.039 | 0.848 | 0.808 | 0.700 |
| German Federal Constitutional Court | state/circuit_en_banc | 87 | 1.000 | 0.006 | 0.773 | 0.070 | 0.833 | 0.111 | 0.014 | 3.000 | 0.490 | 0.514 | 0.379 | 0.414 | 0.230 | 0.046 | 0.218 | 0.038 | 0.846 | 0.825 | 0.691 |
| German Federal Constitutional Court | state/circuit_panel | 594 | 1.000 | 0.006 | 0.739 | 0.085 | 0.715 | 0.314 | 0.425 | 2.000 | 0.569 | 0.483 | 0.444 | 0.384 | 0.221 | 0.054 | 0.170 | 0.034 | 0.848 | 0.816 | 0.664 |
| German Federal Constitutional Court | state/district_only | 117 | 1.000 | 0.006 | 0.737 | 0.160 | 0.643 | 0.232 | 0.190 | 1.000 | 0.536 | 0.460 | 0.393 | 0.333 | 0.256 | 0.068 | 0.171 | 0.045 | 0.838 | 0.797 | 0.653 |
| German Federal Constitutional Court | state/state_federal_split | 1361 | 1.000 | 0.007 | 0.734 | 0.087 | 0.745 | 0.237 | 0.458 | 3.000 | 0.602 | 0.545 | 0.409 | 0.364 | 0.245 | 0.067 | 0.164 | 0.039 | 0.847 | 0.812 | 0.697 |
| German Federal Constitutional Court | state/state_high_court | 1275 | 1.000 | 0.006 | 0.724 | 0.089 | 0.764 | 0.252 | 0.510 | 2.000 | 0.552 | 0.485 | 0.442 | 0.356 | 0.227 | 0.070 | 0.197 | 0.041 | 0.834 | 0.795 | 0.663 |
| French Constitutional Council | federal/circuit_en_banc | 887 | 1.000 | 0.823 | 0.747 | 0.078 | 0.692 | 0.259 | 0.176 | 3.000 | 0.399 | 0.489 | 0.455 | 0.427 | 0.195 | 0.044 | 0.317 | 0.057 | 0.670 | 0.642 | 0.440 |
| French Constitutional Council | federal/circuit_panel | 2016 | 1.000 | 0.821 | 0.730 | 0.089 | 0.727 | 0.211 | 0.267 | 2.000 | 0.417 | 0.447 | 0.491 | 0.411 | 0.181 | 0.047 | 0.323 | 0.054 | 0.659 | 0.620 | 0.419 |
| French Constitutional Council | federal/district_only | 536 | 1.000 | 0.789 | 0.720 | 0.107 | 0.768 | 0.232 | 0.243 | 1.000 | 0.415 | 0.420 | 0.491 | 0.424 | 0.181 | 0.041 | 0.323 | 0.059 | 0.664 | 0.618 | 0.400 |
| French Constitutional Council | federal/state_federal_split | 207 | 1.000 | 0.815 | 0.759 | 0.075 | 0.766 | 0.170 | 0.182 | 3.000 | 0.549 | 0.531 | 0.454 | 0.440 | 0.174 | 0.063 | 0.343 | 0.054 | 0.678 | 0.651 | 0.446 |
| French Constitutional Council | mixed_state_federal/circuit_en_banc | 778 | 1.000 | 0.805 | 0.739 | 0.088 | 0.626 | 0.251 | 0.230 | 3.000 | 0.766 | 0.565 | 0.436 | 0.384 | 0.210 | 0.054 | 0.179 | 0.044 | 0.668 | 0.628 | 0.446 |
| French Constitutional Council | mixed_state_federal/district_only | 113 | 1.000 | 0.685 | 0.724 | 0.154 | 0.704 | 0.185 | 0.222 | 1.000 | 0.743 | 0.515 | 0.540 | 0.469 | 0.115 | 0.053 | 0.150 | 0.055 | 0.644 | 0.596 | 0.414 |
| French Constitutional Council | mixed_state_federal/state_federal_split | 1629 | 1.000 | 0.823 | 0.740 | 0.082 | 0.669 | 0.277 | 0.320 | 3.000 | 0.789 | 0.590 | 0.453 | 0.384 | 0.197 | 0.060 | 0.150 | 0.054 | 0.678 | 0.634 | 0.447 |
| French Constitutional Council | state/circuit_en_banc | 87 | 1.000 | 0.879 | 0.772 | 0.047 | 0.667 | 0.250 | 0.000 | 3.000 | 0.490 | 0.514 | 0.414 | 0.437 | 0.253 | 0.046 | 0.172 | 0.036 | 0.702 | 0.680 | 0.442 |
| French Constitutional Council | state/circuit_panel | 594 | 1.000 | 0.820 | 0.735 | 0.080 | 0.755 | 0.252 | 0.272 | 2.000 | 0.569 | 0.483 | 0.505 | 0.406 | 0.185 | 0.044 | 0.221 | 0.046 | 0.670 | 0.637 | 0.422 |
| French Constitutional Council | state/district_only | 117 | 1.000 | 0.727 | 0.738 | 0.141 | 0.735 | 0.327 | 0.094 | 1.000 | 0.536 | 0.460 | 0.530 | 0.368 | 0.137 | 0.051 | 0.197 | 0.068 | 0.676 | 0.647 | 0.408 |
| French Constitutional Council | state/state_federal_split | 1361 | 1.000 | 0.812 | 0.742 | 0.081 | 0.719 | 0.241 | 0.331 | 3.000 | 0.602 | 0.545 | 0.450 | 0.384 | 0.188 | 0.057 | 0.196 | 0.050 | 0.677 | 0.635 | 0.445 |
| French Constitutional Council | state/state_high_court | 1275 | 1.000 | 0.843 | 0.723 | 0.084 | 0.697 | 0.277 | 0.314 | 2.000 | 0.552 | 0.485 | 0.475 | 0.418 | 0.161 | 0.043 | 0.234 | 0.053 | 0.672 | 0.632 | 0.421 |
| Canadian Supreme Court with override context | federal/circuit_en_banc | 887 | 1.000 | 0.099 | 0.744 | 0.086 | 0.714 | 0.315 | 0.316 | 3.000 | 0.399 | 0.489 | 0.406 | 0.374 | 0.255 | 0.056 | 0.283 | 0.039 | 0.877 | 0.835 | 0.507 |
| Canadian Supreme Court with override context | federal/circuit_panel | 2016 | 1.000 | 0.097 | 0.730 | 0.094 | 0.722 | 0.265 | 0.461 | 2.000 | 0.417 | 0.447 | 0.408 | 0.339 | 0.239 | 0.070 | 0.239 | 0.036 | 0.877 | 0.835 | 0.486 |
| Canadian Supreme Court with override context | federal/district_only | 536 | 1.000 | 0.096 | 0.727 | 0.132 | 0.667 | 0.283 | 0.486 | 1.000 | 0.415 | 0.420 | 0.435 | 0.345 | 0.274 | 0.065 | 0.271 | 0.038 | 0.870 | 0.817 | 0.468 |
| Canadian Supreme Court with override context | federal/state_federal_split | 207 | 1.000 | 0.106 | 0.748 | 0.084 | 0.740 | 0.140 | 0.380 | 3.000 | 0.549 | 0.531 | 0.401 | 0.290 | 0.232 | 0.072 | 0.280 | 0.031 | 0.883 | 0.842 | 0.512 |
| Canadian Supreme Court with override context | mixed_state_federal/circuit_en_banc | 778 | 1.000 | 0.105 | 0.724 | 0.103 | 0.718 | 0.228 | 0.432 | 3.000 | 0.766 | 0.565 | 0.387 | 0.326 | 0.257 | 0.087 | 0.108 | 0.026 | 0.889 | 0.845 | 0.511 |
| Canadian Supreme Court with override context | mixed_state_federal/district_only | 113 | 1.000 | 0.107 | 0.716 | 0.181 | 0.586 | 0.310 | 0.488 | 1.000 | 0.743 | 0.515 | 0.310 | 0.283 | 0.363 | 0.106 | 0.053 | 0.027 | 0.884 | 0.835 | 0.478 |
| Canadian Supreme Court with override context | mixed_state_federal/state_federal_split | 1629 | 1.000 | 0.107 | 0.721 | 0.084 | 0.660 | 0.305 | 0.532 | 3.000 | 0.789 | 0.590 | 0.374 | 0.318 | 0.254 | 0.071 | 0.091 | 0.033 | 0.887 | 0.836 | 0.513 |
| Canadian Supreme Court with override context | state/circuit_en_banc | 87 | 1.000 | 0.097 | 0.773 | 0.037 | 0.300 | 0.100 | 0.013 | 3.000 | 0.490 | 0.514 | 0.391 | 0.299 | 0.322 | 0.046 | 0.115 | 0.029 | 0.883 | 0.857 | 0.509 |
| Canadian Supreme Court with override context | state/circuit_panel | 594 | 1.000 | 0.099 | 0.737 | 0.088 | 0.698 | 0.228 | 0.468 | 2.000 | 0.569 | 0.483 | 0.396 | 0.320 | 0.217 | 0.069 | 0.131 | 0.029 | 0.884 | 0.845 | 0.489 |
| Canadian Supreme Court with override context | state/district_only | 117 | 1.000 | 0.101 | 0.734 | 0.169 | 0.673 | 0.182 | 0.272 | 1.000 | 0.536 | 0.460 | 0.376 | 0.350 | 0.214 | 0.060 | 0.171 | 0.046 | 0.865 | 0.815 | 0.475 |
| Canadian Supreme Court with override context | state/state_federal_split | 1361 | 1.000 | 0.106 | 0.726 | 0.090 | 0.708 | 0.245 | 0.500 | 3.000 | 0.602 | 0.545 | 0.356 | 0.314 | 0.237 | 0.072 | 0.150 | 0.033 | 0.883 | 0.838 | 0.511 |
| Canadian Supreme Court with override context | state/state_high_court | 1275 | 1.000 | 0.100 | 0.717 | 0.089 | 0.714 | 0.272 | 0.559 | 2.000 | 0.552 | 0.485 | 0.406 | 0.321 | 0.240 | 0.067 | 0.162 | 0.035 | 0.876 | 0.829 | 0.488 |
| South African Constitutional Court | federal/circuit_en_banc | 887 | 1.000 | 0.861 | 0.753 | 0.003 | 0.872 | 0.101 | 0.297 | 3.000 | 0.399 | 0.489 | 0.440 | 0.362 | 0.257 | 0.056 | 0.275 | 0.046 | 0.845 | 0.826 | 0.513 |
| South African Constitutional Court | federal/circuit_panel | 2016 | 1.000 | 0.849 | 0.740 | 0.005 | 0.880 | 0.120 | 0.450 | 2.000 | 0.417 | 0.447 | 0.425 | 0.376 | 0.226 | 0.073 | 0.284 | 0.043 | 0.842 | 0.819 | 0.492 |
| South African Constitutional Court | federal/district_only | 536 | 1.000 | 0.802 | 0.739 | 0.007 | 0.868 | 0.132 | 0.422 | 1.000 | 0.415 | 0.420 | 0.416 | 0.360 | 0.200 | 0.047 | 0.289 | 0.047 | 0.831 | 0.807 | 0.473 |
| South African Constitutional Court | federal/state_federal_split | 207 | 1.000 | 0.873 | 0.755 | 0.003 | 0.767 | 0.100 | 0.329 | 3.000 | 0.549 | 0.531 | 0.391 | 0.319 | 0.184 | 0.077 | 0.256 | 0.039 | 0.842 | 0.818 | 0.518 |
| South African Constitutional Court | mixed_state_federal/circuit_en_banc | 778 | 1.000 | 0.844 | 0.739 | 0.004 | 0.813 | 0.111 | 0.396 | 3.000 | 0.766 | 0.565 | 0.406 | 0.347 | 0.246 | 0.072 | 0.102 | 0.034 | 0.849 | 0.825 | 0.519 |
| South African Constitutional Court | mixed_state_federal/district_only | 113 | 1.000 | 0.693 | 0.731 | 0.019 | 0.780 | 0.160 | 0.407 | 1.000 | 0.743 | 0.515 | 0.407 | 0.372 | 0.212 | 0.044 | 0.133 | 0.038 | 0.834 | 0.820 | 0.488 |
| South African Constitutional Court | mixed_state_federal/state_federal_split | 1629 | 1.000 | 0.877 | 0.736 | 0.005 | 0.861 | 0.109 | 0.509 | 3.000 | 0.789 | 0.590 | 0.388 | 0.333 | 0.241 | 0.077 | 0.130 | 0.042 | 0.852 | 0.820 | 0.520 |
| South African Constitutional Court | state/circuit_en_banc | 87 | 1.000 | 0.916 | 0.772 | 0.000 | 0.625 | 0.000 | 0.034 | 3.000 | 0.490 | 0.514 | 0.483 | 0.310 | 0.310 | 0.046 | 0.218 | 0.027 | 0.862 | 0.856 | 0.515 |
| South African Constitutional Court | state/circuit_panel | 594 | 1.000 | 0.876 | 0.747 | 0.005 | 0.871 | 0.118 | 0.451 | 2.000 | 0.569 | 0.483 | 0.451 | 0.333 | 0.261 | 0.069 | 0.152 | 0.035 | 0.852 | 0.827 | 0.494 |
| South African Constitutional Court | state/district_only | 117 | 1.000 | 0.701 | 0.746 | 0.015 | 0.860 | 0.100 | 0.179 | 1.000 | 0.536 | 0.460 | 0.393 | 0.316 | 0.205 | 0.034 | 0.188 | 0.050 | 0.846 | 0.823 | 0.484 |
| South African Constitutional Court | state/state_federal_split | 1361 | 1.000 | 0.871 | 0.740 | 0.005 | 0.861 | 0.134 | 0.481 | 3.000 | 0.602 | 0.545 | 0.404 | 0.341 | 0.247 | 0.075 | 0.151 | 0.040 | 0.845 | 0.822 | 0.518 |
| South African Constitutional Court | state/state_high_court | 1275 | 1.000 | 0.872 | 0.733 | 0.003 | 0.825 | 0.150 | 0.525 | 2.000 | 0.552 | 0.485 | 0.436 | 0.333 | 0.253 | 0.064 | 0.184 | 0.041 | 0.840 | 0.815 | 0.494 |

## Policy Domain Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| U.S. Supreme Court benchmark | administration | 836 | 1.000 | 0.021 | 0.738 | 0.364 | 0.014 | 0.518 | 0.073 | 2.699 | 0.470 | 0.512 | 0.368 | 0.279 | 0.339 | 0.051 | 0.171 | 0.021 | 0.943 | 0.884 | 0.574 |
| U.S. Supreme Court benchmark | civil-rights | 1593 | 1.000 | 0.022 | 0.655 | 0.445 | 0.030 | 0.564 | 0.768 | 2.286 | 0.510 | 0.467 | 0.304 | 0.232 | 0.285 | 0.062 | 0.146 | 0.020 | 0.949 | 0.886 | 0.558 |
| U.S. Supreme Court benchmark | criminal-justice | 1417 | 1.000 | 0.022 | 0.655 | 0.433 | 0.015 | 0.530 | 0.606 | 2.372 | 0.572 | 0.501 | 0.306 | 0.224 | 0.286 | 0.064 | 0.101 | 0.021 | 0.950 | 0.893 | 0.562 |
| U.S. Supreme Court benchmark | economic-regulation | 895 | 1.000 | 0.021 | 0.736 | 0.355 | 0.018 | 0.540 | 0.108 | 2.728 | 0.596 | 0.557 | 0.330 | 0.256 | 0.288 | 0.051 | 0.142 | 0.024 | 0.942 | 0.884 | 0.577 |
| U.S. Supreme Court benchmark | elections | 1352 | 1.000 | 0.023 | 0.629 | 0.452 | 0.038 | 0.574 | 0.709 | 2.709 | 0.665 | 0.519 | 0.277 | 0.210 | 0.277 | 0.071 | 0.078 | 0.016 | 0.957 | 0.901 | 0.572 |
| U.S. Supreme Court benchmark | emergency-security | 1397 | 1.000 | 0.023 | 0.641 | 0.655 | 0.022 | 0.616 | 0.370 | 1.994 | 0.538 | 0.495 | 0.285 | 0.192 | 0.282 | 0.053 | 0.109 | 0.022 | 0.946 | 0.878 | 0.563 |
| U.S. Supreme Court benchmark | federalism | 1004 | 1.000 | 0.022 | 0.735 | 0.367 | 0.025 | 0.513 | 0.140 | 2.767 | 0.753 | 0.593 | 0.316 | 0.256 | 0.249 | 0.054 | 0.088 | 0.018 | 0.948 | 0.889 | 0.580 |
| U.S. Supreme Court benchmark | speech-religion | 1106 | 1.000 | 0.021 | 0.661 | 0.412 | 0.024 | 0.591 | 0.616 | 2.220 | 0.457 | 0.457 | 0.327 | 0.270 | 0.252 | 0.070 | 0.152 | 0.024 | 0.943 | 0.879 | 0.555 |
| German Federal Constitutional Court | administration | 836 | 1.000 | 0.006 | 0.768 | 0.067 | 0.683 | 0.156 | 0.021 | 2.699 | 0.470 | 0.512 | 0.450 | 0.390 | 0.287 | 0.042 | 0.268 | 0.045 | 0.827 | 0.796 | 0.685 |
| German Federal Constitutional Court | civil-rights | 1593 | 1.000 | 0.006 | 0.720 | 0.079 | 0.717 | 0.236 | 0.736 | 2.286 | 0.510 | 0.467 | 0.431 | 0.361 | 0.242 | 0.073 | 0.225 | 0.041 | 0.848 | 0.808 | 0.664 |
| German Federal Constitutional Court | criminal-justice | 1417 | 1.000 | 0.006 | 0.714 | 0.095 | 0.744 | 0.311 | 0.559 | 2.372 | 0.572 | 0.501 | 0.437 | 0.363 | 0.215 | 0.070 | 0.195 | 0.038 | 0.843 | 0.810 | 0.668 |
| German Federal Constitutional Court | economic-regulation | 895 | 1.000 | 0.006 | 0.774 | 0.069 | 0.717 | 0.183 | 0.018 | 2.728 | 0.596 | 0.557 | 0.440 | 0.373 | 0.256 | 0.037 | 0.222 | 0.048 | 0.833 | 0.803 | 0.690 |
| German Federal Constitutional Court | elections | 1352 | 1.000 | 0.007 | 0.714 | 0.071 | 0.777 | 0.247 | 0.620 | 2.709 | 0.665 | 0.519 | 0.422 | 0.361 | 0.226 | 0.075 | 0.145 | 0.031 | 0.855 | 0.821 | 0.691 |
| German Federal Constitutional Court | emergency-security | 1397 | 1.000 | 0.007 | 0.723 | 0.169 | 0.719 | 0.307 | 0.317 | 1.994 | 0.538 | 0.495 | 0.451 | 0.344 | 0.248 | 0.058 | 0.215 | 0.044 | 0.831 | 0.790 | 0.680 |
| German Federal Constitutional Court | federalism | 1004 | 1.000 | 0.006 | 0.781 | 0.070 | 0.620 | 0.190 | 0.024 | 2.767 | 0.753 | 0.593 | 0.446 | 0.342 | 0.215 | 0.052 | 0.179 | 0.038 | 0.836 | 0.806 | 0.697 |
| German Federal Constitutional Court | speech-religion | 1106 | 1.000 | 0.006 | 0.716 | 0.082 | 0.751 | 0.270 | 0.605 | 2.220 | 0.457 | 0.457 | 0.457 | 0.366 | 0.240 | 0.068 | 0.233 | 0.042 | 0.843 | 0.802 | 0.657 |
| French Constitutional Council | administration | 836 | 1.000 | 0.836 | 0.768 | 0.067 | 0.677 | 0.192 | 0.003 | 2.699 | 0.470 | 0.512 | 0.489 | 0.447 | 0.225 | 0.033 | 0.288 | 0.053 | 0.654 | 0.617 | 0.437 |
| French Constitutional Council | civil-rights | 1593 | 1.000 | 0.858 | 0.724 | 0.080 | 0.754 | 0.246 | 0.554 | 2.286 | 0.510 | 0.467 | 0.481 | 0.389 | 0.183 | 0.048 | 0.259 | 0.052 | 0.683 | 0.641 | 0.422 |
| French Constitutional Council | criminal-justice | 1417 | 1.000 | 0.851 | 0.712 | 0.087 | 0.667 | 0.279 | 0.350 | 2.372 | 0.572 | 0.501 | 0.470 | 0.394 | 0.170 | 0.057 | 0.234 | 0.050 | 0.669 | 0.633 | 0.426 |
| French Constitutional Council | economic-regulation | 895 | 1.000 | 0.844 | 0.775 | 0.064 | 0.589 | 0.250 | 0.001 | 2.728 | 0.596 | 0.557 | 0.479 | 0.431 | 0.226 | 0.051 | 0.261 | 0.058 | 0.662 | 0.623 | 0.441 |
| French Constitutional Council | elections | 1352 | 1.000 | 0.834 | 0.720 | 0.067 | 0.734 | 0.312 | 0.405 | 2.709 | 0.665 | 0.519 | 0.446 | 0.385 | 0.184 | 0.067 | 0.207 | 0.042 | 0.680 | 0.647 | 0.438 |
| French Constitutional Council | emergency-security | 1397 | 1.000 | 0.671 | 0.723 | 0.161 | 0.740 | 0.237 | 0.133 | 1.994 | 0.538 | 0.495 | 0.468 | 0.394 | 0.180 | 0.044 | 0.251 | 0.059 | 0.667 | 0.623 | 0.432 |
| French Constitutional Council | federalism | 1004 | 1.000 | 0.831 | 0.783 | 0.070 | 0.650 | 0.146 | 0.006 | 2.767 | 0.753 | 0.593 | 0.463 | 0.407 | 0.169 | 0.048 | 0.183 | 0.052 | 0.661 | 0.624 | 0.445 |
| French Constitutional Council | speech-religion | 1106 | 1.000 | 0.878 | 0.716 | 0.069 | 0.717 | 0.274 | 0.369 | 2.220 | 0.457 | 0.457 | 0.464 | 0.419 | 0.165 | 0.048 | 0.251 | 0.057 | 0.669 | 0.626 | 0.418 |
| Canadian Supreme Court with override context | administration | 836 | 1.000 | 0.096 | 0.767 | 0.067 | 0.648 | 0.185 | 0.047 | 2.699 | 0.470 | 0.512 | 0.421 | 0.370 | 0.297 | 0.050 | 0.242 | 0.038 | 0.870 | 0.831 | 0.505 |
| Canadian Supreme Court with override context | civil-rights | 1593 | 1.000 | 0.101 | 0.716 | 0.084 | 0.691 | 0.274 | 0.750 | 2.286 | 0.510 | 0.467 | 0.390 | 0.318 | 0.244 | 0.080 | 0.190 | 0.033 | 0.888 | 0.839 | 0.490 |
| Canadian Supreme Court with override context | criminal-justice | 1417 | 1.000 | 0.100 | 0.709 | 0.096 | 0.686 | 0.284 | 0.603 | 2.372 | 0.572 | 0.501 | 0.382 | 0.315 | 0.243 | 0.073 | 0.169 | 0.032 | 0.882 | 0.839 | 0.494 |
| Canadian Supreme Court with override context | economic-regulation | 895 | 1.000 | 0.099 | 0.771 | 0.068 | 0.675 | 0.219 | 0.048 | 2.728 | 0.596 | 0.557 | 0.402 | 0.373 | 0.258 | 0.051 | 0.171 | 0.043 | 0.869 | 0.829 | 0.508 |
| Canadian Supreme Court with override context | elections | 1352 | 1.000 | 0.107 | 0.700 | 0.075 | 0.727 | 0.252 | 0.703 | 2.709 | 0.665 | 0.519 | 0.374 | 0.305 | 0.238 | 0.088 | 0.143 | 0.027 | 0.897 | 0.854 | 0.504 |
| Canadian Supreme Court with override context | emergency-security | 1397 | 1.000 | 0.106 | 0.716 | 0.179 | 0.714 | 0.292 | 0.414 | 1.994 | 0.538 | 0.495 | 0.384 | 0.321 | 0.251 | 0.064 | 0.175 | 0.035 | 0.873 | 0.823 | 0.496 |
| Canadian Supreme Court with override context | federalism | 1004 | 1.000 | 0.102 | 0.776 | 0.074 | 0.641 | 0.239 | 0.075 | 2.767 | 0.753 | 0.593 | 0.385 | 0.335 | 0.204 | 0.056 | 0.121 | 0.031 | 0.874 | 0.833 | 0.512 |
| Canadian Supreme Court with override context | speech-religion | 1106 | 1.000 | 0.098 | 0.712 | 0.080 | 0.740 | 0.274 | 0.631 | 2.220 | 0.457 | 0.457 | 0.413 | 0.330 | 0.252 | 0.080 | 0.213 | 0.038 | 0.880 | 0.829 | 0.486 |
| South African Constitutional Court | administration | 836 | 1.000 | 0.896 | 0.768 | 0.000 | 0.842 | 0.084 | 0.037 | 2.699 | 0.470 | 0.512 | 0.446 | 0.377 | 0.278 | 0.057 | 0.257 | 0.045 | 0.827 | 0.811 | 0.510 |
| South African Constitutional Court | civil-rights | 1593 | 1.000 | 0.894 | 0.731 | 0.005 | 0.879 | 0.107 | 0.753 | 2.286 | 0.510 | 0.467 | 0.421 | 0.357 | 0.238 | 0.073 | 0.207 | 0.039 | 0.855 | 0.825 | 0.495 |
| South African Constitutional Court | criminal-justice | 1417 | 1.000 | 0.885 | 0.727 | 0.002 | 0.852 | 0.117 | 0.606 | 2.372 | 0.572 | 0.501 | 0.434 | 0.339 | 0.236 | 0.067 | 0.176 | 0.039 | 0.850 | 0.827 | 0.500 |
| South African Constitutional Court | economic-regulation | 895 | 1.000 | 0.877 | 0.774 | 0.000 | 0.831 | 0.032 | 0.047 | 2.728 | 0.596 | 0.557 | 0.429 | 0.369 | 0.240 | 0.055 | 0.215 | 0.048 | 0.835 | 0.818 | 0.514 |
| South African Constitutional Court | elections | 1352 | 1.000 | 0.884 | 0.717 | 0.006 | 0.883 | 0.140 | 0.666 | 2.709 | 0.665 | 0.519 | 0.389 | 0.326 | 0.263 | 0.084 | 0.139 | 0.032 | 0.863 | 0.838 | 0.511 |
| South African Constitutional Court | emergency-security | 1397 | 1.000 | 0.702 | 0.733 | 0.015 | 0.842 | 0.152 | 0.343 | 1.994 | 0.538 | 0.495 | 0.406 | 0.352 | 0.218 | 0.064 | 0.223 | 0.045 | 0.835 | 0.808 | 0.505 |
| South African Constitutional Court | federalism | 1004 | 1.000 | 0.888 | 0.781 | 0.000 | 0.843 | 0.087 | 0.053 | 2.767 | 0.753 | 0.593 | 0.413 | 0.335 | 0.215 | 0.054 | 0.152 | 0.041 | 0.832 | 0.812 | 0.518 |
| South African Constitutional Court | speech-religion | 1106 | 1.000 | 0.898 | 0.726 | 0.004 | 0.867 | 0.141 | 0.635 | 2.220 | 0.457 | 0.457 | 0.412 | 0.344 | 0.239 | 0.081 | 0.238 | 0.045 | 0.848 | 0.819 | 0.491 |

## Composition Diagnostics

| Scenario | Period | Observations | Size | Median ideology | Spread | Partisan attach. | Rights sens. | Institutionalism | Replacement events |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| U.S. Supreme Court benchmark | 1 | 120 | 9.000 | 0.071 | 1.360 | 0.640 | 0.705 | 0.797 | 0.000 |
| U.S. Supreme Court benchmark | 2 | 120 | 9.000 | 0.073 | 1.406 | 0.638 | 0.705 | 0.796 | 1.307 |
| U.S. Supreme Court benchmark | 3 | 120 | 9.000 | 0.072 | 1.391 | 0.639 | 0.704 | 0.795 | 1.307 |
| U.S. Supreme Court benchmark | 4 | 120 | 9.000 | 0.070 | 1.380 | 0.639 | 0.705 | 0.797 | 1.307 |
| German Federal Constitutional Court | 1 | 120 | 16.000 | 0.011 | 0.853 | 0.504 | 0.771 | 0.841 | 0.000 |
| German Federal Constitutional Court | 2 | 120 | 16.000 | -0.003 | 0.870 | 0.503 | 0.769 | 0.839 | 7.162 |
| German Federal Constitutional Court | 3 | 120 | 16.000 | -0.010 | 0.903 | 0.503 | 0.770 | 0.839 | 7.162 |
| German Federal Constitutional Court | 4 | 120 | 16.000 | -0.015 | 0.927 | 0.503 | 0.769 | 0.840 | 7.162 |
| French Constitutional Council | 1 | 120 | 9.000 | 0.034 | 1.354 | 0.575 | 0.716 | 0.781 | 0.000 |
| French Constitutional Council | 2 | 120 | 9.000 | 0.016 | 1.356 | 0.575 | 0.715 | 0.775 | 6.440 |
| French Constitutional Council | 3 | 120 | 9.000 | 0.016 | 1.370 | 0.573 | 0.715 | 0.782 | 6.440 |
| French Constitutional Council | 4 | 120 | 9.000 | 0.056 | 1.453 | 0.576 | 0.716 | 0.778 | 6.440 |
| Canadian Supreme Court with override context | 1 | 120 | 9.000 | 0.009 | 0.825 | 0.530 | 0.742 | 0.795 | 0.000 |
| Canadian Supreme Court with override context | 2 | 120 | 9.000 | 0.006 | 0.799 | 0.531 | 0.740 | 0.792 | 1.508 |
| Canadian Supreme Court with override context | 3 | 120 | 9.000 | 0.017 | 0.822 | 0.531 | 0.741 | 0.792 | 1.508 |
| Canadian Supreme Court with override context | 4 | 120 | 9.000 | 0.010 | 0.814 | 0.531 | 0.739 | 0.790 | 1.508 |
| South African Constitutional Court | 1 | 120 | 11.000 | 0.001 | 0.822 | 0.526 | 0.770 | 0.782 | 0.000 |
| South African Constitutional Court | 2 | 120 | 11.000 | 0.006 | 0.825 | 0.526 | 0.771 | 0.784 | 5.047 |
| South African Constitutional Court | 3 | 120 | 11.000 | -0.014 | 0.869 | 0.527 | 0.770 | 0.782 | 5.047 |
| South African Constitutional Court | 4 | 120 | 11.000 | -0.009 | 0.907 | 0.528 | 0.770 | 0.781 | 5.047 |

## Uncertainty Diagnostics

Campaign and segment CSV artifacts include 95% uncertainty bands using `cluster-bootstrap-runs-200-95` from the compressed case-level export. The bootstrap resamples whole generated-world run blocks, preserving within-run case dependence. Composition and calibration interval artifacts still use `conservative-bounded-normal-95` when no case-level analogue exists.

| Scenario | Median score band width | Median cost band width |
| --- | ---: | ---: |
| U.S. Supreme Court benchmark | 0.020 | 0.020 |
| German Federal Constitutional Court | 0.019 | 0.019 |
| French Constitutional Council | 0.018 | 0.020 |
| Canadian Supreme Court with override context | 0.019 | 0.020 |
| South African Constitutional Court | 0.019 | 0.020 |

## Calibration Diagnostics

| Profile | Target | Model | Empirical | 95% band | Range | Reliability | Validation | Gap | Status |
| --- | --- | ---: | ---: | ---: | ---: | --- | ---: | ---: | --- |
| canada-scc-recent | Leave application grant rate | 0.023 | 0.089 | 0.023-0.024 | 0.075-0.105 | high | true | 0.052 | outside |
| canada-scc-recent | Charter invalidation proxy | 0.414 | 0.565 | 0.409-0.419 | 0.510-0.620 | medium | false | 0.096 | outside |
| canada-scc-recent | Public trust proxy | 0.038 | 0.490 | 0.036-0.040 | 0.430-0.550 | medium | false | 0.392 | outside |
| canada-scc-recent | Normalized direct court cost | 0.491 | 0.550 | 0.487-0.496 | 0.490-0.610 | medium | false | 0.000 | within |
| france-conseil-qpc | QPC invalidation rate | 0.414 | 0.315 | 0.409-0.419 | 0.260-0.360 | medium | true | 0.054 | outside |
| france-conseil-qpc | Public trust proxy | 0.038 | 0.500 | 0.036-0.040 | 0.430-0.570 | low | false | 0.392 | outside |
| france-conseil-qpc | Normalized direct court cost | 0.491 | 0.340 | 0.487-0.496 | 0.280-0.400 | medium | false | 0.091 | outside |
| france-conseil-qpc | Normalized upstream screening cost | 0.589 | 0.590 | 0.584-0.593 | 0.520-0.660 | medium | false | 0.000 | within |
| germany-bverfg-2024 | Constitutional complaint success and admission proxy | 0.023 | 0.009 | 0.023-0.024 | 0.006-0.012 | medium | true | 0.011 | outside |
| germany-bverfg-2024 | Public trust proxy | 0.038 | 0.740 | 0.036-0.040 | 0.680-0.800 | medium | false | 0.642 | outside |
| germany-bverfg-2024 | Normalized direct court cost | 0.491 | 0.620 | 0.487-0.496 | 0.560-0.680 | medium | false | 0.069 | outside |
| germany-bverfg-2024 | Normalized capacity strain | 0.490 | 0.560 | 0.486-0.495 | 0.500-0.640 | medium | false | 0.010 | outside |
| cost-us-supreme-court | Normalized direct court cost | 0.491 | 0.740 | 0.487-0.496 | 0.690-0.790 | medium | false | 0.199 | outside |
| cost-us-supreme-court | Normalized capacity strain | 0.490 | 0.480 | 0.486-0.495 | 0.420-0.540 | medium | false | 0.000 | within |
| cost-uk-supreme-court | Normalized direct court cost | 0.491 | 0.430 | 0.487-0.496 | 0.370-0.490 | medium | false | 0.001 | outside |
| cost-france-conseil | Normalized direct court cost | 0.491 | 0.340 | 0.487-0.496 | 0.280-0.400 | medium | false | 0.091 | outside |
| south-africa-constcourt-recent | Merits invalidation proxy | 0.414 | 0.532 | 0.409-0.419 | 0.470-0.590 | medium | false | 0.056 | outside |
| south-africa-constcourt-recent | Petition-to-judgment throughput proxy | 1.000 | 0.141 | 0.998-1.000 | 0.110-0.170 | medium | true | 0.830 | outside |
| south-africa-constcourt-recent | Public trust proxy | 0.038 | 0.430 | 0.036-0.040 | 0.360-0.500 | medium | false | 0.322 | outside |
| south-africa-constcourt-recent | Normalized capacity strain | 0.490 | 0.680 | 0.486-0.495 | 0.610-0.750 | medium | false | 0.120 | outside |
| scdb-postwar-merits-1946-2024 | Speech docket share | 0.140 | 0.076 | 0.137-0.143 | 0.060-0.091 | high | true | 0.049 | outside |
| scdb-postwar-merits-1946-2024 | Civil-rights and privacy docket share | 0.141 | 0.152 | 0.138-0.144 | 0.135-0.169 | high | true | 0.000 | within |
| scdb-postwar-merits-1946-2024 | Criminal procedure docket share | 0.148 | 0.226 | 0.144-0.151 | 0.207-0.244 | high | true | 0.059 | outside |
| scdb-postwar-merits-1946-2024 | Federalism docket share | 0.144 | 0.056 | 0.141-0.147 | 0.041-0.071 | high | true | 0.073 | outside |
| scdb-postwar-merits-1946-2024 | Election-law docket share | 0.141 | 0.027 | 0.138-0.144 | 0.013-0.040 | medium | true | 0.101 | outside |
| scdb-postwar-merits-1946-2024 | Emergency-powers merits share | 0.146 | 0.006 | 0.142-0.149 | 0.000-0.012 | medium | true | 0.134 | outside |
| scdb-postwar-merits-1946-2024 | Administrative and economic regulation share | 0.141 | 0.218 | 0.138-0.144 | 0.199-0.236 | medium | true | 0.058 | outside |
| scdb-modern-merits-2000-2024 | Speech docket share | 0.140 | 0.060 | 0.137-0.143 | 0.039-0.080 | high | true | 0.060 | outside |
| scdb-modern-merits-2000-2024 | Civil-rights and privacy docket share | 0.141 | 0.164 | 0.138-0.144 | 0.137-0.191 | high | true | 0.000 | within |
| scdb-modern-merits-2000-2024 | Criminal procedure docket share | 0.148 | 0.260 | 0.144-0.151 | 0.230-0.289 | high | true | 0.082 | outside |
| scdb-modern-merits-2000-2024 | Federalism docket share | 0.144 | 0.058 | 0.141-0.147 | 0.037-0.078 | high | true | 0.066 | outside |
| scdb-modern-merits-2000-2024 | Election-law docket share | 0.141 | 0.026 | 0.138-0.144 | 0.009-0.043 | medium | true | 0.098 | outside |
| scdb-modern-merits-2000-2024 | Emergency-powers merits share | 0.146 | 0.010 | 0.142-0.149 | 0.000-0.019 | medium | true | 0.127 | outside |
| scdb-modern-merits-2000-2024 | Administrative and economic regulation share | 0.141 | 0.222 | 0.138-0.144 | 0.193-0.250 | medium | true | 0.052 | outside |
| scotus-emergency-2024-2025 | Substantive emergency application relief rate | 0.529 | 0.440 | 0.521-0.537 | 0.310-0.460 | medium | true | 0.069 | outside |
| scotus-emergency-2024-2025 | Written explanation share | 0.601 | 0.279 | 0.592-0.609 | 0.200-0.360 | medium | true | 0.241 | outside |
| scotus-emergency-2024-2025 | Public disagreement share | 0.291 | 0.670 | 0.283-0.298 | 0.570-0.760 | medium | true | 0.279 | outside |
| scotus-emergency-2024-2025 | Certiorari or emergency screening acceptance proxy | 0.023 | 0.018 | 0.023-0.024 | 0.013-0.018 | medium | true | 0.005 | outside |
| gallup-court-confidence-2024 | Public court trust and approval | 0.038 | 0.420 | 0.036-0.040 | 0.350-0.490 | medium | false | 0.312 | outside |
