# Constitutional Review Sensitivity Campaign v1

- runs per case: 80
- seed: 20260501
- input: synthetic docket

## Statute-disposition measurement

Objects are generated with explicit unestimated assumptions and relief is allocated conditionally on each case result. This diagnostic does not validate independent object voting or a historical docket. Rates count nullified statutes (including suspended nullifications) over merits statute dispositions, before any later override; regulations, conduct and emergency-only orders are excluded. See docs/object-measurement-contract.md.

| Case | Scenario | Statute dispositions | Nullifications | Rate |
| --- | --- | ---: | ---: | ---: |
| baseline | current-federal-court | 2365 | 918 | 0.388 |
| baseline | eighteen-year-terms | 2372 | 861 | 0.363 |
| baseline | fifteen-justice-commission | 3728 | 1236 | 0.332 |
| baseline | supermajority-invalidation | 3681 | 1170 | 0.318 |
| baseline | strict-recusal-court | 3678 | 1193 | 0.324 |
| baseline | reasoned-emergency-review | 4204 | 1556 | 0.370 |
| baseline | panel-en-banc-review | 3703 | 1254 | 0.339 |
| baseline | dual-cross-checking-courts | 4204 | 1136 | 0.270 |
| baseline | constitutional-council | 3694 | 916 | 0.248 |
| baseline | legislative-override-court | 3684 | 1290 | 0.350 |
| baseline | accountability-retention-court | 3721 | 846 | 0.227 |
| baseline | independence-accountability-hybrid | 4204 | 1237 | 0.294 |
| baseline | weak-form-review | 3667 | 0 | 0.000 |
| baseline | suspended-declaration-review | 4204 | 1535 | 0.365 |
| baseline | override-clause-review | 3704 | 1220 | 0.329 |
| baseline | pre-enactment-review | 3681 | 852 | 0.231 |
| baseline | abstract-review-tribunal | 4204 | 1381 | 0.328 |
| baseline | ombudsman-triggered-review | 3670 | 1339 | 0.365 |
| baseline | constitutional-public-defender | 4204 | 1619 | 0.385 |
| baseline | rights-impact-statement-review | 3718 | 746 | 0.201 |
| baseline | mandatory-legislative-response | 4204 | 1287 | 0.306 |
| low-emergency-pressure | current-federal-court | 3656 | 1476 | 0.404 |
| low-emergency-pressure | eighteen-year-terms | 3640 | 1311 | 0.360 |
| low-emergency-pressure | fifteen-justice-commission | 4115 | 1332 | 0.324 |
| low-emergency-pressure | supermajority-invalidation | 4105 | 1264 | 0.308 |
| low-emergency-pressure | strict-recusal-court | 4104 | 1285 | 0.313 |
| low-emergency-pressure | reasoned-emergency-review | 4132 | 1563 | 0.378 |
| low-emergency-pressure | panel-en-banc-review | 4108 | 1393 | 0.339 |
| low-emergency-pressure | dual-cross-checking-courts | 4132 | 1141 | 0.276 |
| low-emergency-pressure | constitutional-council | 4108 | 996 | 0.242 |
| low-emergency-pressure | legislative-override-court | 4111 | 1413 | 0.344 |
| low-emergency-pressure | accountability-retention-court | 4107 | 885 | 0.215 |
| low-emergency-pressure | independence-accountability-hybrid | 4132 | 1252 | 0.303 |
| low-emergency-pressure | weak-form-review | 4110 | 0 | 0.000 |
| low-emergency-pressure | suspended-declaration-review | 4132 | 1549 | 0.375 |
| low-emergency-pressure | override-clause-review | 4104 | 1330 | 0.324 |
| low-emergency-pressure | pre-enactment-review | 4104 | 935 | 0.228 |
| low-emergency-pressure | abstract-review-tribunal | 4132 | 1404 | 0.340 |
| low-emergency-pressure | ombudsman-triggered-review | 4104 | 1487 | 0.362 |
| low-emergency-pressure | constitutional-public-defender | 4132 | 1604 | 0.388 |
| low-emergency-pressure | rights-impact-statement-review | 4100 | 801 | 0.195 |
| low-emergency-pressure | mandatory-legislative-response | 4132 | 1266 | 0.306 |
| high-emergency-pressure | current-federal-court | 0 | 0 | NaN |
| high-emergency-pressure | eighteen-year-terms | 0 | 0 | NaN |
| high-emergency-pressure | fifteen-justice-commission | 979 | 612 | 0.625 |
| high-emergency-pressure | supermajority-invalidation | 979 | 607 | 0.620 |
| high-emergency-pressure | strict-recusal-court | 979 | 593 | 0.606 |
| high-emergency-pressure | reasoned-emergency-review | 4164 | 1635 | 0.393 |
| high-emergency-pressure | panel-en-banc-review | 979 | 623 | 0.636 |
| high-emergency-pressure | dual-cross-checking-courts | 4164 | 1165 | 0.280 |
| high-emergency-pressure | constitutional-council | 979 | 491 | 0.502 |
| high-emergency-pressure | legislative-override-court | 979 | 629 | 0.642 |
| high-emergency-pressure | accountability-retention-court | 979 | 455 | 0.465 |
| high-emergency-pressure | independence-accountability-hybrid | 4164 | 1307 | 0.314 |
| high-emergency-pressure | weak-form-review | 979 | 0 | 0.000 |
| high-emergency-pressure | suspended-declaration-review | 4164 | 1592 | 0.382 |
| high-emergency-pressure | override-clause-review | 979 | 603 | 0.616 |
| high-emergency-pressure | pre-enactment-review | 979 | 457 | 0.467 |
| high-emergency-pressure | abstract-review-tribunal | 4164 | 1482 | 0.356 |
| high-emergency-pressure | ombudsman-triggered-review | 979 | 642 | 0.656 |
| high-emergency-pressure | constitutional-public-defender | 4164 | 1703 | 0.409 |
| high-emergency-pressure | rights-impact-statement-review | 979 | 435 | 0.444 |
| high-emergency-pressure | mandatory-legislative-response | 4164 | 1354 | 0.325 |
| low-appointment-polarization | current-federal-court | 2386 | 855 | 0.358 |
| low-appointment-polarization | eighteen-year-terms | 2363 | 764 | 0.323 |
| low-appointment-polarization | fifteen-justice-commission | 3672 | 1166 | 0.318 |
| low-appointment-polarization | supermajority-invalidation | 3686 | 1050 | 0.285 |
| low-appointment-polarization | strict-recusal-court | 3666 | 1087 | 0.297 |
| low-appointment-polarization | reasoned-emergency-review | 4223 | 1439 | 0.341 |
| low-appointment-polarization | panel-en-banc-review | 3703 | 1209 | 0.326 |
| low-appointment-polarization | dual-cross-checking-courts | 4223 | 1085 | 0.257 |
| low-appointment-polarization | constitutional-council | 3702 | 876 | 0.237 |
| low-appointment-polarization | legislative-override-court | 3643 | 1155 | 0.317 |
| low-appointment-polarization | accountability-retention-court | 3662 | 730 | 0.199 |
| low-appointment-polarization | independence-accountability-hybrid | 4223 | 1178 | 0.279 |
| low-appointment-polarization | weak-form-review | 3708 | 0 | 0.000 |
| low-appointment-polarization | suspended-declaration-review | 4223 | 1478 | 0.350 |
| low-appointment-polarization | override-clause-review | 3680 | 1127 | 0.306 |
| low-appointment-polarization | pre-enactment-review | 3692 | 778 | 0.211 |
| low-appointment-polarization | abstract-review-tribunal | 4223 | 1319 | 0.312 |
| low-appointment-polarization | ombudsman-triggered-review | 3674 | 1316 | 0.358 |
| low-appointment-polarization | constitutional-public-defender | 4223 | 1580 | 0.374 |
| low-appointment-polarization | rights-impact-statement-review | 3675 | 691 | 0.188 |
| low-appointment-polarization | mandatory-legislative-response | 4223 | 1236 | 0.293 |
| high-appointment-polarization | current-federal-court | 2378 | 1168 | 0.491 |
| high-appointment-polarization | eighteen-year-terms | 2371 | 1077 | 0.454 |
| high-appointment-polarization | fifteen-justice-commission | 3699 | 1492 | 0.403 |
| high-appointment-polarization | supermajority-invalidation | 3701 | 1424 | 0.385 |
| high-appointment-polarization | strict-recusal-court | 3734 | 1444 | 0.387 |
| high-appointment-polarization | reasoned-emergency-review | 4197 | 1907 | 0.454 |
| high-appointment-polarization | panel-en-banc-review | 3701 | 1483 | 0.401 |
| high-appointment-polarization | dual-cross-checking-courts | 4197 | 1311 | 0.312 |
| high-appointment-polarization | constitutional-council | 3695 | 1080 | 0.292 |
| high-appointment-polarization | legislative-override-court | 3716 | 1622 | 0.436 |
| high-appointment-polarization | accountability-retention-court | 3707 | 1073 | 0.289 |
| high-appointment-polarization | independence-accountability-hybrid | 4197 | 1463 | 0.349 |
| high-appointment-polarization | weak-form-review | 3686 | 0 | 0.000 |
| high-appointment-polarization | suspended-declaration-review | 4197 | 1807 | 0.431 |
| high-appointment-polarization | override-clause-review | 3681 | 1521 | 0.413 |
| high-appointment-polarization | pre-enactment-review | 3704 | 1016 | 0.274 |
| high-appointment-polarization | abstract-review-tribunal | 4197 | 1627 | 0.388 |
| high-appointment-polarization | ombudsman-triggered-review | 3699 | 1605 | 0.434 |
| high-appointment-polarization | constitutional-public-defender | 4197 | 1819 | 0.433 |
| high-appointment-polarization | rights-impact-statement-review | 3704 | 926 | 0.250 |
| high-appointment-polarization | mandatory-legislative-response | 4197 | 1540 | 0.367 |
| low-rights-threat | current-federal-court | 2353 | 551 | 0.234 |
| low-rights-threat | eighteen-year-terms | 2327 | 453 | 0.195 |
| low-rights-threat | fifteen-justice-commission | 3613 | 664 | 0.184 |
| low-rights-threat | supermajority-invalidation | 3598 | 579 | 0.161 |
| low-rights-threat | strict-recusal-court | 3630 | 660 | 0.182 |
| low-rights-threat | reasoned-emergency-review | 4205 | 900 | 0.214 |
| low-rights-threat | panel-en-banc-review | 3639 | 702 | 0.193 |
| low-rights-threat | dual-cross-checking-courts | 4205 | 548 | 0.130 |
| low-rights-threat | constitutional-council | 3621 | 402 | 0.111 |
| low-rights-threat | legislative-override-court | 3606 | 712 | 0.197 |
| low-rights-threat | accountability-retention-court | 3627 | 374 | 0.103 |
| low-rights-threat | independence-accountability-hybrid | 4205 | 665 | 0.158 |
| low-rights-threat | weak-form-review | 3639 | 0 | 0.000 |
| low-rights-threat | suspended-declaration-review | 4205 | 903 | 0.215 |
| low-rights-threat | override-clause-review | 3625 | 667 | 0.184 |
| low-rights-threat | pre-enactment-review | 3622 | 382 | 0.105 |
| low-rights-threat | abstract-review-tribunal | 4205 | 773 | 0.184 |
| low-rights-threat | ombudsman-triggered-review | 3625 | 786 | 0.217 |
| low-rights-threat | constitutional-public-defender | 4205 | 977 | 0.232 |
| low-rights-threat | rights-impact-statement-review | 3660 | 280 | 0.077 |
| low-rights-threat | mandatory-legislative-response | 4205 | 700 | 0.166 |
| high-rights-threat | current-federal-court | 2154 | 1409 | 0.654 |
| high-rights-threat | eighteen-year-terms | 2197 | 1335 | 0.608 |
| high-rights-threat | fifteen-justice-commission | 3781 | 2369 | 0.627 |
| high-rights-threat | supermajority-invalidation | 3746 | 2278 | 0.608 |
| high-rights-threat | strict-recusal-court | 3782 | 2346 | 0.620 |
| high-rights-threat | reasoned-emergency-review | 4152 | 2734 | 0.658 |
| high-rights-threat | panel-en-banc-review | 3773 | 2400 | 0.636 |
| high-rights-threat | dual-cross-checking-courts | 4152 | 2391 | 0.576 |
| high-rights-threat | constitutional-council | 3774 | 2079 | 0.551 |
| high-rights-threat | legislative-override-court | 3753 | 2406 | 0.641 |
| high-rights-threat | accountability-retention-court | 3760 | 1960 | 0.521 |
| high-rights-threat | independence-accountability-hybrid | 4152 | 2463 | 0.593 |
| high-rights-threat | weak-form-review | 3746 | 0 | 0.000 |
| high-rights-threat | suspended-declaration-review | 4152 | 2720 | 0.655 |
| high-rights-threat | override-clause-review | 3756 | 2335 | 0.622 |
| high-rights-threat | pre-enactment-review | 3762 | 2023 | 0.538 |
| high-rights-threat | abstract-review-tribunal | 4152 | 2572 | 0.619 |
| high-rights-threat | ombudsman-triggered-review | 3766 | 2470 | 0.656 |
| high-rights-threat | constitutional-public-defender | 4152 | 2791 | 0.672 |
| high-rights-threat | rights-impact-statement-review | 3766 | 1886 | 0.501 |
| high-rights-threat | mandatory-legislative-response | 4152 | 2483 | 0.598 |
| high-public-trust | current-federal-court | 2368 | 862 | 0.364 |
| high-public-trust | eighteen-year-terms | 2305 | 755 | 0.328 |
| high-public-trust | fifteen-justice-commission | 3657 | 1138 | 0.311 |
| high-public-trust | supermajority-invalidation | 3658 | 1099 | 0.300 |
| high-public-trust | strict-recusal-court | 3678 | 1099 | 0.299 |
| high-public-trust | reasoned-emergency-review | 4188 | 1479 | 0.353 |
| high-public-trust | panel-en-banc-review | 3661 | 1178 | 0.322 |
| high-public-trust | dual-cross-checking-courts | 4188 | 1034 | 0.247 |
| high-public-trust | constitutional-council | 3642 | 821 | 0.225 |
| high-public-trust | legislative-override-court | 3688 | 1209 | 0.328 |
| high-public-trust | accountability-retention-court | 3625 | 734 | 0.202 |
| high-public-trust | independence-accountability-hybrid | 4188 | 1182 | 0.282 |
| high-public-trust | weak-form-review | 3667 | 0 | 0.000 |
| high-public-trust | suspended-declaration-review | 4188 | 1417 | 0.338 |
| high-public-trust | override-clause-review | 3640 | 1129 | 0.310 |
| high-public-trust | pre-enactment-review | 3673 | 760 | 0.207 |
| high-public-trust | abstract-review-tribunal | 4188 | 1301 | 0.311 |
| high-public-trust | ombudsman-triggered-review | 3682 | 1283 | 0.348 |
| high-public-trust | constitutional-public-defender | 4188 | 1545 | 0.369 |
| high-public-trust | rights-impact-statement-review | 3675 | 653 | 0.178 |
| high-public-trust | mandatory-legislative-response | 4188 | 1211 | 0.289 |
| low-public-trust | current-federal-court | 2328 | 1064 | 0.457 |
| low-public-trust | eighteen-year-terms | 2294 | 929 | 0.405 |
| low-public-trust | fifteen-justice-commission | 3629 | 1441 | 0.397 |
| low-public-trust | supermajority-invalidation | 3633 | 1314 | 0.362 |
| low-public-trust | strict-recusal-court | 3650 | 1370 | 0.375 |
| low-public-trust | reasoned-emergency-review | 4179 | 1756 | 0.420 |
| low-public-trust | panel-en-banc-review | 3601 | 1464 | 0.407 |
| low-public-trust | dual-cross-checking-courts | 4179 | 1310 | 0.313 |
| low-public-trust | constitutional-council | 3672 | 1074 | 0.292 |
| low-public-trust | legislative-override-court | 3635 | 1469 | 0.404 |
| low-public-trust | accountability-retention-court | 3681 | 1036 | 0.281 |
| low-public-trust | independence-accountability-hybrid | 4179 | 1409 | 0.337 |
| low-public-trust | weak-form-review | 3599 | 0 | 0.000 |
| low-public-trust | suspended-declaration-review | 4179 | 1749 | 0.419 |
| low-public-trust | override-clause-review | 3679 | 1414 | 0.384 |
| low-public-trust | pre-enactment-review | 3632 | 1010 | 0.278 |
| low-public-trust | abstract-review-tribunal | 4179 | 1591 | 0.381 |
| low-public-trust | ombudsman-triggered-review | 3631 | 1537 | 0.423 |
| low-public-trust | constitutional-public-defender | 4179 | 1808 | 0.433 |
| low-public-trust | rights-impact-statement-review | 3675 | 904 | 0.246 |
| low-public-trust | mandatory-legislative-response | 4179 | 1506 | 0.360 |
| low-legislative-conflict | current-federal-court | 2285 | 878 | 0.384 |
| low-legislative-conflict | eighteen-year-terms | 2291 | 792 | 0.346 |
| low-legislative-conflict | fifteen-justice-commission | 3637 | 1153 | 0.317 |
| low-legislative-conflict | supermajority-invalidation | 3645 | 1125 | 0.309 |
| low-legislative-conflict | strict-recusal-court | 3628 | 1106 | 0.305 |
| low-legislative-conflict | reasoned-emergency-review | 4139 | 1466 | 0.354 |
| low-legislative-conflict | panel-en-banc-review | 3607 | 1198 | 0.332 |
| low-legislative-conflict | dual-cross-checking-courts | 4139 | 1074 | 0.259 |
| low-legislative-conflict | constitutional-council | 3639 | 841 | 0.231 |
| low-legislative-conflict | legislative-override-court | 3620 | 1224 | 0.338 |
| low-legislative-conflict | accountability-retention-court | 3591 | 733 | 0.204 |
| low-legislative-conflict | independence-accountability-hybrid | 4139 | 1193 | 0.288 |
| low-legislative-conflict | weak-form-review | 3665 | 0 | 0.000 |
| low-legislative-conflict | suspended-declaration-review | 4139 | 1440 | 0.348 |
| low-legislative-conflict | override-clause-review | 3634 | 1153 | 0.317 |
| low-legislative-conflict | pre-enactment-review | 3650 | 767 | 0.210 |
| low-legislative-conflict | abstract-review-tribunal | 4139 | 1357 | 0.328 |
| low-legislative-conflict | ombudsman-triggered-review | 3612 | 1268 | 0.351 |
| low-legislative-conflict | constitutional-public-defender | 4139 | 1525 | 0.368 |
| low-legislative-conflict | rights-impact-statement-review | 3653 | 683 | 0.187 |
| low-legislative-conflict | mandatory-legislative-response | 4139 | 1218 | 0.294 |
| high-legislative-conflict | current-federal-court | 2344 | 1076 | 0.459 |
| high-legislative-conflict | eighteen-year-terms | 2360 | 988 | 0.419 |
| high-legislative-conflict | fifteen-justice-commission | 3690 | 1478 | 0.401 |
| high-legislative-conflict | supermajority-invalidation | 3662 | 1333 | 0.364 |
| high-legislative-conflict | strict-recusal-court | 3682 | 1421 | 0.386 |
| high-legislative-conflict | reasoned-emergency-review | 4182 | 1774 | 0.424 |
| high-legislative-conflict | panel-en-banc-review | 3666 | 1490 | 0.406 |
| high-legislative-conflict | dual-cross-checking-courts | 4182 | 1359 | 0.325 |
| high-legislative-conflict | constitutional-council | 3666 | 1114 | 0.304 |
| high-legislative-conflict | legislative-override-court | 3677 | 1533 | 0.417 |
| high-legislative-conflict | accountability-retention-court | 3712 | 1117 | 0.301 |
| high-legislative-conflict | independence-accountability-hybrid | 4182 | 1466 | 0.351 |
| high-legislative-conflict | weak-form-review | 3679 | 0 | 0.000 |
| high-legislative-conflict | suspended-declaration-review | 4182 | 1811 | 0.433 |
| high-legislative-conflict | override-clause-review | 3682 | 1470 | 0.399 |
| high-legislative-conflict | pre-enactment-review | 3717 | 1077 | 0.290 |
| high-legislative-conflict | abstract-review-tribunal | 4182 | 1606 | 0.384 |
| high-legislative-conflict | ombudsman-triggered-review | 3694 | 1616 | 0.437 |
| high-legislative-conflict | constitutional-public-defender | 4182 | 1865 | 0.446 |
| high-legislative-conflict | rights-impact-statement-review | 3684 | 967 | 0.262 |
| high-legislative-conflict | mandatory-legislative-response | 4182 | 1564 | 0.374 |

## Top Directional Scores by Case

### Baseline

Baseline assumptions for sensitivity comparison.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.699
- strongest rights protection: Rights-impact statements before review at 0.804
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.002
- lowest emergency relief rate: Mandatory legislative response cycles at 0.274
- highest compliance rate: Weak-form review with legislative reply at 0.800
- lowest defiance rate: Weak-form review with legislative reply at 0.035

### Low emergency pressure

Lower urgency and emergency docket pressure.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.711
- strongest rights protection: Rights-impact statements before review at 0.808
- lowest emergency-process irregularity: Dual supreme courts with cross-checking invalidations at 0.000
- lowest emergency relief rate: Mandatory legislative response cycles at 0.139
- highest compliance rate: Weak-form review with legislative reply at 0.821
- lowest defiance rate: Weak-form review with legislative reply at 0.029

### High emergency pressure

Higher urgency and emergency docket pressure.

- best overall: Suspended declarations of invalidity (`suspended-declaration-review`) at 0.648
- strongest rights protection: Rights-impact statements before review at 0.777
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.036
- lowest emergency relief rate: Retention-election accountability court at 0.329
- highest compliance rate: Mandatory legislative response cycles at 0.502
- lowest defiance rate: Mandatory legislative response cycles at 0.193

### Low appointment polarization

Lower appointment ideology spread and partisan pressure.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.705
- strongest rights protection: Rights-impact statements before review at 0.806
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.261
- highest compliance rate: Weak-form review with legislative reply at 0.804
- lowest defiance rate: Weak-form review with legislative reply at 0.037

### High appointment polarization

Higher appointment ideology spread and partisan pressure.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.689
- strongest rights protection: Rights-impact statements before review at 0.803
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.004
- lowest emergency relief rate: Retention-election accountability court at 0.367
- highest compliance rate: Weak-form review with legislative reply at 0.762
- lowest defiance rate: Weak-form review with legislative reply at 0.052

### Low rights threat

Lower share of cases with generated rights-risk signals.

- best overall: Rights-impact statements before review (`rights-impact-statement-review`) at 0.719
- strongest rights protection: Rights-impact statements before review at 0.859
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.001
- lowest emergency relief rate: Retention-election accountability court at 0.132
- highest compliance rate: Rights-impact statements before review at 0.828
- lowest defiance rate: Weak-form review with legislative reply at 0.028

### High rights threat

Higher share of cases with generated rights-risk signals.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.690
- strongest rights protection: Constitutional public defender access model at 0.854
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.008
- lowest emergency relief rate: Retention-election accountability court at 0.707
- highest compliance rate: Weak-form review with legislative reply at 0.720
- lowest defiance rate: Weak-form review with legislative reply at 0.071

### High public trust

High initial trust and lower institutional conflict.

- best overall: Suspended declarations of invalidity (`suspended-declaration-review`) at 0.719
- strongest rights protection: Rights-impact statements before review at 0.806
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.255
- highest compliance rate: Mandatory legislative response cycles at 0.863
- lowest defiance rate: Weak-form review with legislative reply at 0.013

### Low public trust

Low initial trust and higher institutional conflict.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.645
- strongest rights protection: Rights-impact statements before review at 0.801
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.003
- lowest emergency relief rate: Retention-election accountability court at 0.346
- highest compliance rate: Weak-form review with legislative reply at 0.491
- lowest defiance rate: Weak-form review with legislative reply at 0.175

### Low legislative conflict

Lower legislature-court conflict pressure.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.713
- strongest rights protection: Rights-impact statements before review at 0.805
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.002
- lowest emergency relief rate: Retention-election accountability court at 0.227
- highest compliance rate: Weak-form review with legislative reply at 0.832
- lowest defiance rate: Weak-form review with legislative reply at 0.026

### High legislative conflict

Higher legislature-court conflict pressure and lower trust.

- best overall: Weak-form review with legislative reply (`weak-form-review`) at 0.638
- strongest rights protection: Rights-impact statements before review at 0.800
- lowest emergency-process irregularity: Mandatory legislative response cycles at 0.002
- lowest emergency relief rate: Mandatory legislative response cycles at 0.363
- highest compliance rate: Weak-form review with legislative reply at 0.444
- lowest defiance rate: Weak-form review with legislative reply at 0.220

## Scenario Averages

| Scenario | Kind | Mechanism | Score aid | Dem. const. | Stability | Rights | Partisan | Emerg. irr. | Intake | Emerg. relief | Reasons | Disagree | Merits inval. | Legit. proxy | Reversal | Conflict index | Response | Resp. cred. | Access | Gov. adv. | Impl. cap. | Veto reloc. | Transplant | Culture sens. | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin | Direct | Upstream | Capacity | Cost |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | court_variant | strong_form_court | 0.522 | 0.567 | 0.780 | 0.688 | 0.203 | 0.396 | 0.024 | 0.683 | 0.027 | 0.561 | 0.449 | 0.569 | 0.262 | 0.354 | 0.405 | 0.545 | 0.432 | 0.357 | 0.608 | 0.528 | 0.642 | 0.736 | 0.406 | 0.407 | 0.183 | 0.070 | 0.243 | 2.428 | 0.563 | 0.486 | 0.307 | 0.690 | 0.420 | 0.451 |
| Staggered 18-year nonrenewable terms | court_variant | strong_form_court | 0.532 | 0.573 | 0.789 | 0.695 | 0.186 | 0.392 | 0.024 | 0.640 | 0.034 | 0.552 | 0.409 | 0.579 | 0.239 | 0.348 | 0.414 | 0.545 | 0.432 | 0.357 | 0.607 | 0.519 | 0.643 | 0.735 | 0.410 | 0.410 | 0.179 | 0.070 | 0.251 | 2.428 | 0.563 | 0.494 | 0.311 | 0.690 | 0.435 | 0.455 |
| Fifteen-justice supermajority commission court | court_variant | strong_form_court | 0.611 | 0.640 | 0.875 | 0.741 | 0.153 | 0.092 | 0.023 | 0.446 | 0.690 | 0.274 | 0.455 | 0.695 | 0.362 | 0.260 | 0.462 | 0.572 | 0.432 | 0.357 | 0.613 | 0.435 | 0.643 | 0.725 | 0.564 | 0.565 | 0.124 | 0.058 | 0.386 | 2.428 | 0.563 | 0.484 | 0.364 | 0.691 | 0.425 | 0.471 |
| Supermajority required to invalidate laws | court_variant | strong_form_court | 0.602 | 0.636 | 0.884 | 0.738 | 0.170 | 0.096 | 0.023 | 0.480 | 0.640 | 0.298 | 0.431 | 0.672 | 0.341 | 0.260 | 0.458 | 0.562 | 0.432 | 0.357 | 0.612 | 0.444 | 0.642 | 0.728 | 0.563 | 0.561 | 0.126 | 0.059 | 0.378 | 2.428 | 0.563 | 0.463 | 0.305 | 0.691 | 0.404 | 0.458 |
| Strict recusal with substitute justices | court_variant | strong_form_court | 0.618 | 0.645 | 0.876 | 0.741 | 0.153 | 0.090 | 0.023 | 0.436 | 0.707 | 0.264 | 0.439 | 0.715 | 0.349 | 0.258 | 0.463 | 0.579 | 0.432 | 0.357 | 0.609 | 0.433 | 0.642 | 0.728 | 0.588 | 0.582 | 0.117 | 0.056 | 0.400 | 2.428 | 0.563 | 0.484 | 0.363 | 0.691 | 0.426 | 0.477 |
| Reasoned emergency orders with merits follow-up | court_variant | strong_form_court | 0.625 | 0.650 | 0.884 | 0.745 | 0.170 | 0.007 | 0.023 | 0.461 | 0.876 | 0.135 | 0.466 | 0.734 | 0.466 | 0.244 | 0.462 | 0.592 | 0.432 | 0.357 | 0.613 | 0.445 | 0.642 | 0.726 | 0.587 | 0.588 | 0.123 | 0.064 | 0.398 | 2.428 | 0.563 | 0.471 | 0.310 | 0.692 | 0.415 | 0.461 |
| Panel review with en banc safety valve | court_variant | strong_form_court | 0.607 | 0.641 | 0.870 | 0.741 | 0.152 | 0.092 | 0.023 | 0.437 | 0.696 | 0.270 | 0.465 | 0.708 | 0.369 | 0.261 | 0.462 | 0.577 | 0.432 | 0.357 | 0.605 | 0.432 | 0.642 | 0.727 | 0.565 | 0.568 | 0.123 | 0.058 | 0.385 | 2.428 | 0.563 | 0.675 | 0.434 | 0.691 | 0.460 | 0.513 |
| Dual supreme courts with cross-checking invalidations | court_variant | strong_form_court | 0.622 | 0.647 | 0.908 | 0.750 | 0.139 | 0.009 | 0.023 | 0.375 | 0.868 | 0.127 | 0.348 | 0.745 | 0.348 | 0.249 | 0.474 | 0.584 | 0.432 | 0.357 | 0.584 | 0.595 | 0.638 | 0.740 | 0.625 | 0.621 | 0.104 | 0.050 | 0.435 | 2.428 | 0.563 | 0.867 | 0.519 | 0.692 | 0.570 | 0.590 |
| Pre-enactment constitutional council | court_variant | strong_form_court | 0.621 | 0.644 | 0.938 | 0.742 | 0.132 | 0.087 | 0.023 | 0.399 | 0.748 | 0.247 | 0.348 | 0.742 | 0.275 | 0.249 | 0.470 | 0.581 | 0.432 | 0.357 | 0.596 | 0.661 | 0.641 | 0.734 | 0.629 | 0.632 | 0.097 | 0.047 | 0.448 | 2.428 | 0.563 | 0.738 | 0.443 | 0.691 | 0.487 | 0.534 |
| Judicial review with delayed legislative override | court_variant | strong_form_court | 0.590 | 0.635 | 0.862 | 0.736 | 0.164 | 0.093 | 0.023 | 0.458 | 0.665 | 0.273 | 0.473 | 0.688 | 0.376 | 0.266 | 0.463 | 0.573 | 0.432 | 0.357 | 0.608 | 0.433 | 0.642 | 0.732 | 0.548 | 0.549 | 0.131 | 0.062 | 0.367 | 2.428 | 0.563 | 0.477 | 0.311 | 0.691 | 0.420 | 0.467 |
| Retention-election accountability court | court_variant | strong_form_court | 0.611 | 0.649 | 0.880 | 0.731 | 0.142 | 0.086 | 0.023 | 0.313 | 0.689 | 0.243 | 0.325 | 0.711 | 0.256 | 0.255 | 0.481 | 0.570 | 0.432 | 0.357 | 0.605 | 0.406 | 0.642 | 0.733 | 0.602 | 0.598 | 0.103 | 0.046 | 0.422 | 2.428 | 0.563 | 0.497 | 0.323 | 0.691 | 0.456 | 0.483 |
| Hybrid court balancing independence and accountability | court_variant | strong_form_court | 0.632 | 0.660 | 0.911 | 0.750 | 0.143 | 0.006 | 0.023 | 0.405 | 0.887 | 0.124 | 0.379 | 0.749 | 0.379 | 0.234 | 0.472 | 0.586 | 0.432 | 0.357 | 0.591 | 0.431 | 0.640 | 0.739 | 0.622 | 0.622 | 0.106 | 0.053 | 0.436 | 2.428 | 0.563 | 0.667 | 0.457 | 0.692 | 0.456 | 0.544 |
| Weak-form review with legislative reply | synthetic_mechanism | weak_form_review | 0.684 | 0.696 | 0.952 | 0.717 | 0.119 | 0.088 | 0.857 | 0.375 | 0.715 | 0.257 | 0.000 | 0.747 | 0.000 | 0.220 | 0.503 | 0.617 | 0.538 | 0.357 | 0.636 | 0.176 | 0.676 | 0.767 | 0.706 | 0.702 | 0.059 | 0.021 | 0.522 | 2.428 | 0.563 | 0.477 | 0.312 | 0.398 | 0.299 | 0.361 |
| Suspended declarations of invalidity | synthetic_mechanism | suspended_declaration | 0.672 | 0.680 | 0.925 | 0.722 | 0.149 | 0.007 | 0.879 | 0.413 | 0.867 | 0.126 | 0.461 | 0.755 | 0.461 | 0.251 | 0.519 | 0.634 | 0.539 | 0.357 | 0.626 | 0.206 | 0.622 | 0.843 | 0.610 | 0.606 | 0.115 | 0.057 | 0.414 | 2.428 | 0.563 | 0.476 | 0.330 | 0.451 | 0.300 | 0.385 |
| Strong-form review with explicit override clause | synthetic_mechanism | legislative_override_clause | 0.608 | 0.650 | 0.880 | 0.740 | 0.154 | 0.091 | 0.113 | 0.444 | 0.702 | 0.280 | 0.450 | 0.724 | 0.357 | 0.235 | 0.462 | 0.575 | 0.443 | 0.357 | 0.619 | 0.356 | 0.630 | 0.870 | 0.599 | 0.595 | 0.113 | 0.055 | 0.417 | 2.428 | 0.563 | 0.477 | 0.311 | 0.581 | 0.360 | 0.426 |
| Pre-enactment review before laws take effect | synthetic_mechanism | pre_enactment_review | 0.641 | 0.659 | 0.942 | 0.768 | 0.126 | 0.086 | 0.840 | 0.375 | 0.744 | 0.246 | 0.326 | 0.745 | 0.257 | 0.247 | 0.472 | 0.578 | 0.536 | 0.357 | 0.613 | 0.513 | 0.578 | 0.841 | 0.639 | 0.639 | 0.092 | 0.043 | 0.454 | 2.428 | 0.563 | 0.738 | 0.443 | 0.410 | 0.366 | 0.439 |
| Abstract review tribunal | synthetic_mechanism | abstract_review | 0.638 | 0.664 | 0.902 | 0.774 | 0.155 | 0.010 | 0.896 | 0.450 | 0.857 | 0.135 | 0.421 | 0.741 | 0.421 | 0.240 | 0.468 | 0.586 | 0.540 | 0.357 | 0.613 | 0.314 | 0.563 | 0.911 | 0.607 | 0.609 | 0.113 | 0.056 | 0.423 | 2.428 | 0.563 | 0.668 | 0.434 | 0.443 | 0.331 | 0.438 |
| Ombudsman-triggered constitutional review | synthetic_mechanism | ombudsman_triggered_review | 0.605 | 0.631 | 0.870 | 0.739 | 0.155 | 0.092 | 0.009 | 0.472 | 0.723 | 0.264 | 0.493 | 0.718 | 0.393 | 0.264 | 0.459 | 0.584 | 0.431 | 0.357 | 0.603 | 0.524 | 0.602 | 0.783 | 0.558 | 0.560 | 0.128 | 0.062 | 0.377 | 2.428 | 0.563 | 0.482 | 0.333 | 0.877 | 0.463 | 0.518 |
| Constitutional public defender access model | synthetic_mechanism | constitutional_public_defender | 0.618 | 0.648 | 0.880 | 0.781 | 0.165 | 0.007 | 0.008 | 0.496 | 0.869 | 0.123 | 0.483 | 0.736 | 0.483 | 0.245 | 0.464 | 0.590 | 0.431 | 0.357 | 0.602 | 0.512 | 0.630 | 0.753 | 0.562 | 0.571 | 0.130 | 0.065 | 0.377 | 2.428 | 0.563 | 0.476 | 0.334 | 0.856 | 0.462 | 0.520 |
| Rights-impact statements before review | synthetic_mechanism | rights_impact_statement | 0.673 | 0.680 | 0.944 | 0.807 | 0.121 | 0.085 | 0.841 | 0.351 | 0.760 | 0.242 | 0.295 | 0.765 | 0.231 | 0.244 | 0.474 | 0.579 | 0.536 | 0.357 | 0.612 | 0.504 | 0.697 | 0.717 | 0.654 | 0.651 | 0.089 | 0.041 | 0.471 | 2.428 | 0.563 | 0.735 | 0.417 | 0.427 | 0.366 | 0.439 |
| Mandatory legislative response cycles | synthetic_mechanism | mandatory_legislative_response | 0.653 | 0.677 | 0.915 | 0.721 | 0.130 | 0.006 | 0.876 | 0.330 | 0.870 | 0.101 | 0.394 | 0.782 | 0.394 | 0.200 | 0.478 | 0.589 | 0.539 | 0.357 | 0.624 | 0.223 | 0.614 | 0.921 | 0.636 | 0.643 | 0.097 | 0.053 | 0.451 | 2.428 | 0.563 | 0.476 | 0.313 | 0.474 | 0.301 | 0.397 |

## Mechanism Diagnostics

| Scenario | Kind | Mechanism | Weak decl. | Susp. decl. | Leg. response | Resp. cred. | Rights stmt. | Ombudsman | Pub. defender | Pre-enact. | Abstract | Prelim. ref. | Appeal route | Direct action | Access | Impl. cap. | Dem. const. | Veto reloc. | Transplant | Culture sens. |
| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.545 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.608 | 0.567 | 0.528 | 0.642 | 0.736 |
| Staggered 18-year nonrenewable terms | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.545 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.607 | 0.573 | 0.519 | 0.643 | 0.735 |
| Fifteen-justice supermajority commission court | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.572 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.613 | 0.640 | 0.435 | 0.643 | 0.725 |
| Supermajority required to invalidate laws | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.562 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.612 | 0.636 | 0.444 | 0.642 | 0.728 |
| Strict recusal with substitute justices | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.579 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.609 | 0.645 | 0.433 | 0.642 | 0.728 |
| Reasoned emergency orders with merits follow-up | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.592 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.613 | 0.650 | 0.445 | 0.642 | 0.726 |
| Panel review with en banc safety valve | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.577 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.605 | 0.641 | 0.432 | 0.642 | 0.727 |
| Dual supreme courts with cross-checking invalidations | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.584 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.584 | 0.647 | 0.595 | 0.638 | 0.740 |
| Pre-enactment constitutional council | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.581 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.596 | 0.644 | 0.661 | 0.641 | 0.734 |
| Judicial review with delayed legislative override | court_variant | strong_form_court | 0.000 | 0.000 | 0.016 | 0.573 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.608 | 0.635 | 0.433 | 0.642 | 0.732 |
| Retention-election accountability court | court_variant | strong_form_court | 0.000 | 0.000 | 0.036 | 0.570 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.605 | 0.649 | 0.406 | 0.642 | 0.733 |
| Hybrid court balancing independence and accountability | court_variant | strong_form_court | 0.000 | 0.000 | 0.000 | 0.586 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.432 | 0.591 | 0.660 | 0.431 | 0.640 | 0.739 |
| Weak-form review with legislative reply | synthetic_mechanism | weak_form_review | 0.360 | 0.000 | 0.387 | 0.617 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.538 | 0.636 | 0.696 | 0.176 | 0.676 | 0.767 |
| Suspended declarations of invalidity | synthetic_mechanism | suspended_declaration | 0.000 | 0.461 | 0.470 | 0.634 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.539 | 0.626 | 0.680 | 0.206 | 0.622 | 0.843 |
| Strong-form review with explicit override clause | synthetic_mechanism | legislative_override_clause | 0.000 | 0.000 | 0.247 | 0.575 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.443 | 0.619 | 0.650 | 0.356 | 0.630 | 0.870 |
| Pre-enactment review before laws take effect | synthetic_mechanism | pre_enactment_review | 0.000 | 0.000 | 0.000 | 0.578 | 0.377 | 0.000 | 0.000 | 0.830 | 0.874 | 0.000 | 0.000 | 0.000 | 0.536 | 0.613 | 0.659 | 0.513 | 0.578 | 0.841 |
| Abstract review tribunal | synthetic_mechanism | abstract_review | 0.000 | 0.000 | 0.000 | 0.586 | 0.377 | 0.000 | 0.000 | 0.830 | 0.874 | 0.000 | 0.000 | 0.000 | 0.540 | 0.613 | 0.664 | 0.314 | 0.563 | 0.911 |
| Ombudsman-triggered constitutional review | synthetic_mechanism | ombudsman_triggered_review | 0.000 | 0.000 | 0.000 | 0.584 | 0.000 | 0.291 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.431 | 0.603 | 0.631 | 0.524 | 0.602 | 0.783 |
| Constitutional public defender access model | synthetic_mechanism | constitutional_public_defender | 0.000 | 0.000 | 0.000 | 0.590 | 0.000 | 0.000 | 0.338 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.431 | 0.602 | 0.648 | 0.512 | 0.630 | 0.753 |
| Rights-impact statements before review | synthetic_mechanism | rights_impact_statement | 0.000 | 0.000 | 0.000 | 0.579 | 1.000 | 0.000 | 0.000 | 0.830 | 0.874 | 0.000 | 0.000 | 0.000 | 0.536 | 0.612 | 0.680 | 0.504 | 0.697 | 0.717 |
| Mandatory legislative response cycles | synthetic_mechanism | mandatory_legislative_response | 0.000 | 0.000 | 0.412 | 0.589 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.000 | 0.539 | 0.624 | 0.677 | 0.223 | 0.614 | 0.921 |

## Period Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Dem. const. | Resp. cred. | Access | Gov. adv. | Impl. cap. | Veto reloc. | Transplant | Culture sens. | Emerg. irr. | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust input | Conflict index | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | 1 | 17600 | 1.000 | 0.024 | 0.687 | 0.582 | 0.545 | 0.432 | 0.358 | 0.608 | 0.528 | 0.642 | 0.736 | 0.398 | 0.027 | 0.556 | 0.453 | 2.419 | 0.563 | 0.501 | 0.566 | 0.567 | 0.104 | 0.034 | 0.412 | 0.110 | 0.693 | 0.464 | 0.447 |
| Current-style federal supreme court | 2 | 17600 | 1.000 | 0.024 | 0.686 | 0.564 | 0.545 | 0.433 | 0.357 | 0.607 | 0.528 | 0.642 | 0.736 | 0.401 | 0.029 | 0.569 | 0.447 | 2.425 | 0.561 | 0.500 | 0.386 | 0.395 | 0.192 | 0.075 | 0.235 | 0.000 | 0.934 | 0.923 | 0.452 |
| Current-style federal supreme court | 3 | 17600 | 1.000 | 0.024 | 0.688 | 0.561 | 0.545 | 0.433 | 0.358 | 0.608 | 0.528 | 0.642 | 0.736 | 0.396 | 0.024 | 0.556 | 0.449 | 2.429 | 0.562 | 0.501 | 0.341 | 0.341 | 0.216 | 0.084 | 0.166 | 0.000 | 0.988 | 0.996 | 0.452 |
| Current-style federal supreme court | 4 | 17600 | 1.000 | 0.024 | 0.689 | 0.561 | 0.545 | 0.432 | 0.357 | 0.608 | 0.528 | 0.642 | 0.736 | 0.388 | 0.027 | 0.565 | 0.445 | 2.438 | 0.564 | 0.502 | 0.332 | 0.327 | 0.218 | 0.086 | 0.158 | 0.000 | 0.994 | 1.000 | 0.452 |
| Staggered 18-year nonrenewable terms | 1 | 17600 | 1.000 | 0.024 | 0.695 | 0.589 | 0.545 | 0.432 | 0.358 | 0.609 | 0.519 | 0.643 | 0.735 | 0.393 | 0.034 | 0.558 | 0.413 | 2.419 | 0.563 | 0.501 | 0.567 | 0.569 | 0.101 | 0.035 | 0.419 | 0.117 | 0.675 | 0.437 | 0.447 |
| Staggered 18-year nonrenewable terms | 2 | 17600 | 1.000 | 0.024 | 0.694 | 0.571 | 0.545 | 0.433 | 0.357 | 0.607 | 0.519 | 0.643 | 0.735 | 0.397 | 0.034 | 0.553 | 0.412 | 2.425 | 0.561 | 0.500 | 0.400 | 0.405 | 0.184 | 0.076 | 0.250 | 0.001 | 0.910 | 0.891 | 0.458 |
| Staggered 18-year nonrenewable terms | 3 | 17600 | 1.000 | 0.024 | 0.697 | 0.568 | 0.544 | 0.433 | 0.358 | 0.607 | 0.519 | 0.643 | 0.735 | 0.389 | 0.034 | 0.552 | 0.404 | 2.429 | 0.562 | 0.501 | 0.340 | 0.341 | 0.214 | 0.083 | 0.176 | 0.000 | 0.978 | 0.985 | 0.458 |
| Staggered 18-year nonrenewable terms | 4 | 17600 | 1.000 | 0.024 | 0.695 | 0.566 | 0.544 | 0.432 | 0.357 | 0.607 | 0.519 | 0.643 | 0.735 | 0.389 | 0.034 | 0.545 | 0.409 | 2.438 | 0.564 | 0.502 | 0.333 | 0.327 | 0.216 | 0.084 | 0.158 | 0.000 | 0.992 | 0.998 | 0.458 |
| Fifteen-justice supermajority commission court | 1 | 17600 | 1.000 | 0.023 | 0.740 | 0.652 | 0.572 | 0.432 | 0.358 | 0.614 | 0.435 | 0.643 | 0.724 | 0.093 | 0.712 | 0.284 | 0.458 | 2.419 | 0.563 | 0.501 | 0.673 | 0.668 | 0.074 | 0.031 | 0.497 | 0.214 | 0.523 | 0.317 | 0.461 |
| Fifteen-justice supermajority commission court | 2 | 17600 | 1.000 | 0.023 | 0.741 | 0.640 | 0.572 | 0.433 | 0.357 | 0.612 | 0.435 | 0.643 | 0.725 | 0.093 | 0.683 | 0.268 | 0.460 | 2.425 | 0.561 | 0.500 | 0.566 | 0.572 | 0.121 | 0.059 | 0.398 | 0.020 | 0.633 | 0.625 | 0.474 |
| Fifteen-justice supermajority commission court | 3 | 17600 | 1.000 | 0.023 | 0.742 | 0.635 | 0.572 | 0.432 | 0.358 | 0.612 | 0.435 | 0.643 | 0.725 | 0.092 | 0.703 | 0.267 | 0.453 | 2.429 | 0.562 | 0.501 | 0.522 | 0.520 | 0.144 | 0.071 | 0.337 | 0.003 | 0.691 | 0.723 | 0.475 |
| Fifteen-justice supermajority commission court | 4 | 17600 | 1.000 | 0.023 | 0.740 | 0.633 | 0.572 | 0.432 | 0.357 | 0.612 | 0.435 | 0.643 | 0.725 | 0.091 | 0.671 | 0.287 | 0.450 | 2.438 | 0.564 | 0.502 | 0.494 | 0.499 | 0.155 | 0.071 | 0.311 | 0.002 | 0.733 | 0.765 | 0.475 |
| Supermajority required to invalidate laws | 1 | 17600 | 1.000 | 0.023 | 0.737 | 0.647 | 0.562 | 0.432 | 0.358 | 0.612 | 0.444 | 0.642 | 0.728 | 0.097 | 0.664 | 0.306 | 0.436 | 2.419 | 0.563 | 0.501 | 0.671 | 0.667 | 0.076 | 0.031 | 0.493 | 0.207 | 0.531 | 0.326 | 0.454 |
| Supermajority required to invalidate laws | 2 | 17600 | 1.000 | 0.023 | 0.738 | 0.636 | 0.563 | 0.433 | 0.357 | 0.611 | 0.444 | 0.642 | 0.728 | 0.096 | 0.635 | 0.284 | 0.435 | 2.425 | 0.561 | 0.500 | 0.569 | 0.572 | 0.123 | 0.060 | 0.390 | 0.018 | 0.642 | 0.636 | 0.459 |
| Supermajority required to invalidate laws | 3 | 17600 | 1.000 | 0.023 | 0.738 | 0.631 | 0.562 | 0.432 | 0.358 | 0.611 | 0.444 | 0.642 | 0.728 | 0.096 | 0.623 | 0.289 | 0.424 | 2.429 | 0.562 | 0.501 | 0.515 | 0.516 | 0.146 | 0.070 | 0.330 | 0.003 | 0.699 | 0.732 | 0.459 |
| Supermajority required to invalidate laws | 4 | 17600 | 1.000 | 0.023 | 0.737 | 0.629 | 0.562 | 0.432 | 0.357 | 0.611 | 0.444 | 0.642 | 0.728 | 0.095 | 0.642 | 0.309 | 0.430 | 2.438 | 0.564 | 0.502 | 0.495 | 0.488 | 0.161 | 0.074 | 0.300 | 0.001 | 0.739 | 0.773 | 0.459 |
| Strict recusal with substitute justices | 1 | 17600 | 1.000 | 0.023 | 0.741 | 0.656 | 0.579 | 0.432 | 0.358 | 0.611 | 0.433 | 0.643 | 0.727 | 0.090 | 0.717 | 0.255 | 0.447 | 2.419 | 0.563 | 0.501 | 0.684 | 0.684 | 0.069 | 0.031 | 0.502 | 0.230 | 0.507 | 0.301 | 0.467 |
| Strict recusal with substitute justices | 2 | 17600 | 1.000 | 0.023 | 0.741 | 0.645 | 0.579 | 0.433 | 0.357 | 0.609 | 0.433 | 0.642 | 0.728 | 0.090 | 0.705 | 0.255 | 0.442 | 2.425 | 0.561 | 0.500 | 0.592 | 0.586 | 0.119 | 0.057 | 0.413 | 0.033 | 0.597 | 0.585 | 0.480 |
| Strict recusal with substitute justices | 3 | 17600 | 1.000 | 0.023 | 0.742 | 0.640 | 0.579 | 0.432 | 0.358 | 0.609 | 0.433 | 0.642 | 0.728 | 0.091 | 0.709 | 0.262 | 0.433 | 2.429 | 0.562 | 0.501 | 0.552 | 0.537 | 0.138 | 0.064 | 0.354 | 0.007 | 0.644 | 0.676 | 0.480 |
| Strict recusal with substitute justices | 4 | 17600 | 1.000 | 0.023 | 0.740 | 0.638 | 0.578 | 0.432 | 0.357 | 0.609 | 0.433 | 0.642 | 0.728 | 0.090 | 0.695 | 0.283 | 0.433 | 2.438 | 0.564 | 0.502 | 0.523 | 0.522 | 0.142 | 0.071 | 0.333 | 0.003 | 0.679 | 0.714 | 0.480 |
| Reasoned emergency orders with merits follow-up | 1 | 17600 | 1.000 | 0.023 | 0.744 | 0.662 | 0.592 | 0.432 | 0.358 | 0.614 | 0.445 | 0.642 | 0.725 | 0.007 | 0.893 | 0.126 | 0.469 | 2.419 | 0.563 | 0.501 | 0.695 | 0.691 | 0.073 | 0.036 | 0.515 | 0.229 | 0.518 | 0.341 | 0.453 |
| Reasoned emergency orders with merits follow-up | 2 | 17600 | 1.000 | 0.023 | 0.745 | 0.650 | 0.592 | 0.433 | 0.357 | 0.613 | 0.444 | 0.642 | 0.726 | 0.007 | 0.876 | 0.105 | 0.467 | 2.425 | 0.561 | 0.500 | 0.594 | 0.596 | 0.127 | 0.066 | 0.409 | 0.032 | 0.630 | 0.647 | 0.464 |
| Reasoned emergency orders with merits follow-up | 3 | 17600 | 1.000 | 0.023 | 0.746 | 0.645 | 0.591 | 0.432 | 0.358 | 0.613 | 0.445 | 0.642 | 0.726 | 0.007 | 0.873 | 0.167 | 0.463 | 2.429 | 0.562 | 0.501 | 0.539 | 0.543 | 0.143 | 0.076 | 0.348 | 0.008 | 0.690 | 0.734 | 0.464 |
| Reasoned emergency orders with merits follow-up | 4 | 17600 | 1.000 | 0.023 | 0.744 | 0.642 | 0.591 | 0.432 | 0.357 | 0.613 | 0.445 | 0.642 | 0.726 | 0.007 | 0.871 | 0.146 | 0.464 | 2.438 | 0.564 | 0.502 | 0.518 | 0.523 | 0.148 | 0.079 | 0.322 | 0.003 | 0.728 | 0.768 | 0.464 |
| Panel review with en banc safety valve | 1 | 17600 | 1.000 | 0.023 | 0.740 | 0.653 | 0.578 | 0.432 | 0.358 | 0.606 | 0.432 | 0.642 | 0.727 | 0.093 | 0.690 | 0.273 | 0.470 | 2.419 | 0.563 | 0.501 | 0.668 | 0.670 | 0.075 | 0.034 | 0.504 | 0.215 | 0.524 | 0.319 | 0.502 |
| Panel review with en banc safety valve | 2 | 17600 | 1.000 | 0.023 | 0.741 | 0.641 | 0.578 | 0.433 | 0.357 | 0.604 | 0.432 | 0.642 | 0.727 | 0.092 | 0.695 | 0.265 | 0.469 | 2.425 | 0.561 | 0.500 | 0.579 | 0.576 | 0.122 | 0.059 | 0.396 | 0.025 | 0.630 | 0.625 | 0.516 |
| Panel review with en banc safety valve | 3 | 17600 | 1.000 | 0.023 | 0.742 | 0.637 | 0.577 | 0.432 | 0.358 | 0.604 | 0.432 | 0.642 | 0.727 | 0.091 | 0.692 | 0.260 | 0.462 | 2.429 | 0.562 | 0.501 | 0.517 | 0.521 | 0.142 | 0.071 | 0.333 | 0.005 | 0.690 | 0.726 | 0.516 |
| Panel review with en banc safety valve | 4 | 17600 | 1.000 | 0.023 | 0.740 | 0.634 | 0.577 | 0.432 | 0.357 | 0.604 | 0.432 | 0.642 | 0.728 | 0.091 | 0.704 | 0.285 | 0.459 | 2.438 | 0.564 | 0.502 | 0.498 | 0.503 | 0.152 | 0.069 | 0.306 | 0.002 | 0.732 | 0.765 | 0.516 |
| Dual supreme courts with cross-checking invalidations | 1 | 17600 | 1.000 | 0.023 | 0.751 | 0.657 | 0.584 | 0.432 | 0.358 | 0.585 | 0.595 | 0.639 | 0.740 | 0.009 | 0.854 | 0.103 | 0.351 | 2.419 | 0.563 | 0.501 | 0.703 | 0.709 | 0.062 | 0.029 | 0.527 | 0.260 | 0.472 | 0.265 | 0.580 |
| Dual supreme courts with cross-checking invalidations | 2 | 17600 | 1.000 | 0.023 | 0.750 | 0.647 | 0.584 | 0.433 | 0.357 | 0.583 | 0.595 | 0.638 | 0.740 | 0.009 | 0.856 | 0.154 | 0.352 | 2.425 | 0.561 | 0.500 | 0.631 | 0.629 | 0.100 | 0.051 | 0.441 | 0.061 | 0.532 | 0.514 | 0.593 |
| Dual supreme courts with cross-checking invalidations | 3 | 17600 | 1.000 | 0.023 | 0.751 | 0.643 | 0.583 | 0.432 | 0.358 | 0.583 | 0.595 | 0.638 | 0.740 | 0.009 | 0.885 | 0.134 | 0.345 | 2.429 | 0.562 | 0.501 | 0.591 | 0.580 | 0.124 | 0.058 | 0.397 | 0.021 | 0.571 | 0.596 | 0.594 |
| Dual supreme courts with cross-checking invalidations | 4 | 17600 | 1.000 | 0.023 | 0.750 | 0.641 | 0.583 | 0.432 | 0.357 | 0.583 | 0.595 | 0.638 | 0.740 | 0.009 | 0.872 | 0.116 | 0.345 | 2.438 | 0.564 | 0.502 | 0.574 | 0.564 | 0.129 | 0.061 | 0.375 | 0.008 | 0.601 | 0.630 | 0.594 |
| Pre-enactment constitutional council | 1 | 17600 | 1.000 | 0.023 | 0.741 | 0.653 | 0.581 | 0.432 | 0.358 | 0.599 | 0.661 | 0.641 | 0.733 | 0.088 | 0.746 | 0.255 | 0.349 | 2.419 | 0.563 | 0.501 | 0.698 | 0.701 | 0.062 | 0.026 | 0.519 | 0.272 | 0.457 | 0.244 | 0.518 |
| Pre-enactment constitutional council | 2 | 17600 | 1.000 | 0.023 | 0.742 | 0.644 | 0.581 | 0.433 | 0.357 | 0.595 | 0.661 | 0.641 | 0.734 | 0.088 | 0.758 | 0.239 | 0.352 | 2.425 | 0.561 | 0.500 | 0.634 | 0.634 | 0.096 | 0.048 | 0.447 | 0.071 | 0.493 | 0.466 | 0.539 |
| Pre-enactment constitutional council | 3 | 17600 | 1.000 | 0.023 | 0.744 | 0.641 | 0.581 | 0.432 | 0.358 | 0.595 | 0.661 | 0.641 | 0.734 | 0.085 | 0.748 | 0.245 | 0.348 | 2.429 | 0.562 | 0.501 | 0.594 | 0.603 | 0.113 | 0.057 | 0.424 | 0.025 | 0.507 | 0.521 | 0.539 |
| Pre-enactment constitutional council | 4 | 17600 | 1.000 | 0.023 | 0.742 | 0.640 | 0.581 | 0.432 | 0.357 | 0.595 | 0.661 | 0.641 | 0.734 | 0.086 | 0.741 | 0.252 | 0.345 | 2.438 | 0.564 | 0.502 | 0.591 | 0.589 | 0.117 | 0.055 | 0.404 | 0.011 | 0.525 | 0.543 | 0.540 |
| Judicial review with delayed legislative override | 1 | 17600 | 1.000 | 0.023 | 0.735 | 0.647 | 0.573 | 0.432 | 0.358 | 0.609 | 0.433 | 0.642 | 0.731 | 0.093 | 0.665 | 0.269 | 0.475 | 2.419 | 0.563 | 0.501 | 0.666 | 0.659 | 0.079 | 0.035 | 0.489 | 0.199 | 0.541 | 0.335 | 0.459 |
| Judicial review with delayed legislative override | 2 | 17600 | 1.000 | 0.023 | 0.736 | 0.634 | 0.573 | 0.433 | 0.357 | 0.607 | 0.433 | 0.642 | 0.732 | 0.095 | 0.674 | 0.272 | 0.476 | 2.425 | 0.561 | 0.500 | 0.551 | 0.556 | 0.132 | 0.063 | 0.376 | 0.016 | 0.669 | 0.663 | 0.470 |
| Judicial review with delayed legislative override | 3 | 17600 | 1.000 | 0.023 | 0.737 | 0.630 | 0.573 | 0.432 | 0.358 | 0.607 | 0.434 | 0.642 | 0.732 | 0.094 | 0.645 | 0.276 | 0.474 | 2.429 | 0.562 | 0.501 | 0.501 | 0.503 | 0.153 | 0.072 | 0.315 | 0.003 | 0.733 | 0.763 | 0.470 |
| Judicial review with delayed legislative override | 4 | 17600 | 1.000 | 0.023 | 0.736 | 0.627 | 0.573 | 0.432 | 0.357 | 0.607 | 0.434 | 0.642 | 0.732 | 0.093 | 0.676 | 0.275 | 0.467 | 2.438 | 0.564 | 0.502 | 0.473 | 0.477 | 0.161 | 0.077 | 0.289 | 0.001 | 0.772 | 0.807 | 0.470 |
| Retention-election accountability court | 1 | 17600 | 1.000 | 0.023 | 0.731 | 0.658 | 0.570 | 0.432 | 0.358 | 0.608 | 0.406 | 0.642 | 0.732 | 0.086 | 0.684 | 0.240 | 0.325 | 2.419 | 0.563 | 0.501 | 0.679 | 0.674 | 0.064 | 0.027 | 0.499 | 0.245 | 0.467 | 0.244 | 0.462 |
| Retention-election accountability court | 2 | 17600 | 1.000 | 0.023 | 0.731 | 0.648 | 0.571 | 0.433 | 0.357 | 0.603 | 0.405 | 0.642 | 0.733 | 0.087 | 0.698 | 0.237 | 0.331 | 2.425 | 0.561 | 0.500 | 0.605 | 0.602 | 0.104 | 0.046 | 0.430 | 0.048 | 0.518 | 0.481 | 0.489 |
| Retention-election accountability court | 3 | 17600 | 1.000 | 0.023 | 0.733 | 0.645 | 0.570 | 0.432 | 0.358 | 0.603 | 0.406 | 0.642 | 0.733 | 0.085 | 0.695 | 0.246 | 0.320 | 2.429 | 0.562 | 0.501 | 0.569 | 0.563 | 0.120 | 0.056 | 0.387 | 0.014 | 0.541 | 0.549 | 0.489 |
| Retention-election accountability court | 4 | 17600 | 1.000 | 0.023 | 0.731 | 0.643 | 0.570 | 0.432 | 0.357 | 0.603 | 0.406 | 0.642 | 0.733 | 0.085 | 0.678 | 0.249 | 0.322 | 2.438 | 0.564 | 0.502 | 0.554 | 0.553 | 0.125 | 0.057 | 0.371 | 0.005 | 0.560 | 0.573 | 0.490 |
| Hybrid court balancing independence and accountability | 1 | 17600 | 1.000 | 0.023 | 0.749 | 0.671 | 0.586 | 0.432 | 0.358 | 0.592 | 0.431 | 0.640 | 0.739 | 0.006 | 0.873 | 0.131 | 0.381 | 2.419 | 0.563 | 0.501 | 0.706 | 0.710 | 0.065 | 0.029 | 0.523 | 0.268 | 0.465 | 0.277 | 0.534 |
| Hybrid court balancing independence and accountability | 2 | 17600 | 1.000 | 0.023 | 0.750 | 0.661 | 0.586 | 0.433 | 0.357 | 0.590 | 0.431 | 0.639 | 0.739 | 0.006 | 0.893 | 0.116 | 0.381 | 2.425 | 0.561 | 0.500 | 0.628 | 0.634 | 0.105 | 0.055 | 0.448 | 0.068 | 0.522 | 0.527 | 0.547 |
| Hybrid court balancing independence and accountability | 3 | 17600 | 1.000 | 0.023 | 0.750 | 0.656 | 0.586 | 0.432 | 0.358 | 0.590 | 0.431 | 0.639 | 0.739 | 0.006 | 0.879 | 0.121 | 0.376 | 2.429 | 0.562 | 0.501 | 0.590 | 0.584 | 0.124 | 0.062 | 0.400 | 0.028 | 0.563 | 0.607 | 0.547 |
| Hybrid court balancing independence and accountability | 4 | 17600 | 1.000 | 0.023 | 0.749 | 0.654 | 0.586 | 0.432 | 0.357 | 0.590 | 0.432 | 0.639 | 0.739 | 0.006 | 0.898 | 0.129 | 0.377 | 2.438 | 0.564 | 0.502 | 0.566 | 0.562 | 0.129 | 0.067 | 0.374 | 0.013 | 0.596 | 0.644 | 0.548 |
| Weak-form review with legislative reply | 1 | 17600 | 1.000 | 0.855 | 0.717 | 0.700 | 0.618 | 0.538 | 0.358 | 0.637 | 0.175 | 0.676 | 0.766 | 0.089 | 0.710 | 0.274 | 0.000 | 2.419 | 0.563 | 0.501 | 0.716 | 0.717 | 0.045 | 0.012 | 0.542 | 0.384 | 0.326 | 0.110 | 0.352 |
| Weak-form review with legislative reply | 2 | 17600 | 1.000 | 0.854 | 0.716 | 0.697 | 0.618 | 0.538 | 0.357 | 0.635 | 0.175 | 0.676 | 0.767 | 0.090 | 0.722 | 0.230 | 0.000 | 2.425 | 0.561 | 0.500 | 0.713 | 0.705 | 0.058 | 0.021 | 0.520 | 0.239 | 0.231 | 0.203 | 0.364 |
| Weak-form review with legislative reply | 3 | 17600 | 1.000 | 0.858 | 0.718 | 0.695 | 0.618 | 0.538 | 0.358 | 0.635 | 0.176 | 0.676 | 0.767 | 0.087 | 0.723 | 0.262 | 0.000 | 2.429 | 0.562 | 0.501 | 0.699 | 0.693 | 0.066 | 0.027 | 0.511 | 0.184 | 0.224 | 0.245 | 0.364 |
| Weak-form review with legislative reply | 4 | 17600 | 1.000 | 0.861 | 0.717 | 0.694 | 0.616 | 0.538 | 0.357 | 0.635 | 0.176 | 0.676 | 0.767 | 0.087 | 0.699 | 0.267 | 0.000 | 2.438 | 0.564 | 0.502 | 0.698 | 0.691 | 0.066 | 0.026 | 0.516 | 0.153 | 0.220 | 0.252 | 0.364 |
| Suspended declarations of invalidity | 1 | 17600 | 1.000 | 0.879 | 0.722 | 0.691 | 0.635 | 0.539 | 0.358 | 0.627 | 0.206 | 0.622 | 0.843 | 0.007 | 0.872 | 0.148 | 0.466 | 2.419 | 0.563 | 0.501 | 0.714 | 0.707 | 0.065 | 0.032 | 0.522 | 0.240 | 0.507 | 0.322 | 0.375 |
| Suspended declarations of invalidity | 2 | 17600 | 1.000 | 0.878 | 0.722 | 0.680 | 0.635 | 0.540 | 0.357 | 0.625 | 0.206 | 0.622 | 0.844 | 0.007 | 0.858 | 0.124 | 0.465 | 2.425 | 0.561 | 0.500 | 0.621 | 0.624 | 0.110 | 0.059 | 0.429 | 0.040 | 0.606 | 0.621 | 0.388 |
| Suspended declarations of invalidity | 3 | 17600 | 1.000 | 0.879 | 0.724 | 0.675 | 0.633 | 0.540 | 0.358 | 0.625 | 0.207 | 0.622 | 0.843 | 0.006 | 0.869 | 0.119 | 0.455 | 2.429 | 0.562 | 0.501 | 0.564 | 0.559 | 0.137 | 0.068 | 0.368 | 0.011 | 0.667 | 0.715 | 0.388 |
| Suspended declarations of invalidity | 4 | 17600 | 1.000 | 0.882 | 0.721 | 0.672 | 0.634 | 0.539 | 0.357 | 0.625 | 0.207 | 0.622 | 0.844 | 0.006 | 0.877 | 0.116 | 0.459 | 2.438 | 0.564 | 0.502 | 0.542 | 0.535 | 0.149 | 0.069 | 0.337 | 0.004 | 0.707 | 0.746 | 0.389 |
| Strong-form review with explicit override clause | 1 | 17600 | 1.000 | 0.113 | 0.740 | 0.660 | 0.575 | 0.443 | 0.358 | 0.620 | 0.355 | 0.630 | 0.870 | 0.092 | 0.705 | 0.301 | 0.456 | 2.419 | 0.563 | 0.501 | 0.686 | 0.681 | 0.070 | 0.031 | 0.518 | 0.253 | 0.479 | 0.291 | 0.418 |
| Strong-form review with explicit override clause | 2 | 17600 | 1.000 | 0.113 | 0.740 | 0.649 | 0.575 | 0.443 | 0.357 | 0.618 | 0.356 | 0.630 | 0.870 | 0.092 | 0.708 | 0.284 | 0.454 | 2.425 | 0.561 | 0.500 | 0.601 | 0.593 | 0.116 | 0.056 | 0.422 | 0.050 | 0.542 | 0.551 | 0.429 |
| Strong-form review with explicit override clause | 3 | 17600 | 1.000 | 0.113 | 0.741 | 0.646 | 0.575 | 0.443 | 0.358 | 0.618 | 0.357 | 0.630 | 0.870 | 0.090 | 0.695 | 0.257 | 0.443 | 2.429 | 0.562 | 0.501 | 0.564 | 0.560 | 0.128 | 0.064 | 0.368 | 0.013 | 0.570 | 0.618 | 0.429 |
| Strong-form review with explicit override clause | 4 | 17600 | 1.000 | 0.113 | 0.739 | 0.644 | 0.575 | 0.443 | 0.357 | 0.618 | 0.356 | 0.630 | 0.870 | 0.091 | 0.702 | 0.278 | 0.447 | 2.438 | 0.564 | 0.502 | 0.547 | 0.548 | 0.138 | 0.068 | 0.358 | 0.005 | 0.594 | 0.645 | 0.429 |
| Pre-enactment review before laws take effect | 1 | 17600 | 1.000 | 0.839 | 0.768 | 0.667 | 0.578 | 0.536 | 0.358 | 0.616 | 0.513 | 0.579 | 0.840 | 0.086 | 0.750 | 0.250 | 0.327 | 2.419 | 0.563 | 0.501 | 0.701 | 0.698 | 0.060 | 0.026 | 0.521 | 0.283 | 0.444 | 0.229 | 0.423 |
| Pre-enactment review before laws take effect | 2 | 17600 | 1.000 | 0.838 | 0.768 | 0.658 | 0.579 | 0.536 | 0.357 | 0.612 | 0.513 | 0.578 | 0.841 | 0.087 | 0.739 | 0.235 | 0.334 | 2.425 | 0.561 | 0.500 | 0.638 | 0.640 | 0.094 | 0.047 | 0.454 | 0.083 | 0.472 | 0.440 | 0.444 |
| Pre-enactment review before laws take effect | 3 | 17600 | 1.000 | 0.840 | 0.769 | 0.656 | 0.578 | 0.537 | 0.358 | 0.612 | 0.513 | 0.578 | 0.841 | 0.085 | 0.748 | 0.259 | 0.320 | 2.429 | 0.562 | 0.501 | 0.614 | 0.612 | 0.106 | 0.048 | 0.428 | 0.036 | 0.479 | 0.488 | 0.444 |
| Pre-enactment review before laws take effect | 4 | 17600 | 1.000 | 0.841 | 0.768 | 0.654 | 0.578 | 0.536 | 0.357 | 0.612 | 0.513 | 0.578 | 0.841 | 0.086 | 0.742 | 0.242 | 0.324 | 2.438 | 0.564 | 0.502 | 0.603 | 0.607 | 0.109 | 0.054 | 0.411 | 0.020 | 0.489 | 0.509 | 0.445 |
| Abstract review tribunal | 1 | 17600 | 1.000 | 0.896 | 0.774 | 0.675 | 0.587 | 0.540 | 0.358 | 0.615 | 0.314 | 0.563 | 0.911 | 0.010 | 0.835 | 0.179 | 0.424 | 2.419 | 0.563 | 0.501 | 0.700 | 0.705 | 0.066 | 0.033 | 0.529 | 0.248 | 0.490 | 0.304 | 0.428 |
| Abstract review tribunal | 2 | 17600 | 1.000 | 0.895 | 0.774 | 0.664 | 0.587 | 0.541 | 0.357 | 0.613 | 0.314 | 0.563 | 0.911 | 0.010 | 0.857 | 0.121 | 0.423 | 2.425 | 0.561 | 0.500 | 0.614 | 0.617 | 0.115 | 0.058 | 0.429 | 0.046 | 0.570 | 0.581 | 0.442 |
| Abstract review tribunal | 3 | 17600 | 1.000 | 0.896 | 0.775 | 0.659 | 0.586 | 0.540 | 0.358 | 0.613 | 0.314 | 0.563 | 0.911 | 0.010 | 0.862 | 0.140 | 0.417 | 2.429 | 0.562 | 0.501 | 0.567 | 0.568 | 0.132 | 0.065 | 0.379 | 0.012 | 0.617 | 0.666 | 0.442 |
| Abstract review tribunal | 4 | 17600 | 1.000 | 0.897 | 0.774 | 0.657 | 0.586 | 0.540 | 0.357 | 0.613 | 0.314 | 0.563 | 0.911 | 0.009 | 0.860 | 0.115 | 0.420 | 2.438 | 0.564 | 0.502 | 0.548 | 0.547 | 0.141 | 0.069 | 0.356 | 0.005 | 0.656 | 0.701 | 0.442 |
| Ombudsman-triggered constitutional review | 1 | 17600 | 1.000 | 0.009 | 0.739 | 0.643 | 0.584 | 0.430 | 0.358 | 0.605 | 0.524 | 0.602 | 0.783 | 0.093 | 0.727 | 0.262 | 0.496 | 2.419 | 0.563 | 0.501 | 0.670 | 0.669 | 0.072 | 0.034 | 0.501 | 0.212 | 0.531 | 0.329 | 0.508 |
| Ombudsman-triggered constitutional review | 2 | 17600 | 1.000 | 0.009 | 0.739 | 0.630 | 0.585 | 0.431 | 0.357 | 0.602 | 0.524 | 0.602 | 0.783 | 0.093 | 0.717 | 0.264 | 0.498 | 2.425 | 0.561 | 0.500 | 0.563 | 0.571 | 0.127 | 0.063 | 0.388 | 0.020 | 0.651 | 0.649 | 0.522 |
| Ombudsman-triggered constitutional review | 3 | 17600 | 1.000 | 0.009 | 0.740 | 0.626 | 0.584 | 0.431 | 0.358 | 0.602 | 0.524 | 0.602 | 0.783 | 0.091 | 0.733 | 0.244 | 0.489 | 2.429 | 0.562 | 0.501 | 0.505 | 0.513 | 0.152 | 0.072 | 0.319 | 0.003 | 0.716 | 0.752 | 0.521 |
| Ombudsman-triggered constitutional review | 4 | 17600 | 1.000 | 0.009 | 0.738 | 0.623 | 0.584 | 0.430 | 0.357 | 0.602 | 0.524 | 0.602 | 0.783 | 0.091 | 0.717 | 0.282 | 0.490 | 2.438 | 0.564 | 0.502 | 0.491 | 0.489 | 0.161 | 0.080 | 0.299 | 0.002 | 0.757 | 0.791 | 0.522 |
| Constitutional public defender access model | 1 | 17600 | 1.000 | 0.008 | 0.781 | 0.660 | 0.590 | 0.430 | 0.358 | 0.604 | 0.513 | 0.630 | 0.752 | 0.007 | 0.853 | 0.127 | 0.490 | 2.419 | 0.563 | 0.501 | 0.680 | 0.687 | 0.075 | 0.037 | 0.503 | 0.216 | 0.530 | 0.352 | 0.509 |
| Constitutional public defender access model | 2 | 17600 | 1.000 | 0.008 | 0.782 | 0.648 | 0.590 | 0.431 | 0.357 | 0.601 | 0.512 | 0.630 | 0.753 | 0.007 | 0.876 | 0.122 | 0.487 | 2.425 | 0.561 | 0.500 | 0.571 | 0.581 | 0.131 | 0.066 | 0.388 | 0.026 | 0.658 | 0.685 | 0.523 |
| Constitutional public defender access model | 3 | 17600 | 1.000 | 0.008 | 0.783 | 0.643 | 0.589 | 0.431 | 0.358 | 0.601 | 0.512 | 0.630 | 0.753 | 0.007 | 0.871 | 0.113 | 0.478 | 2.429 | 0.562 | 0.501 | 0.511 | 0.519 | 0.153 | 0.076 | 0.320 | 0.006 | 0.731 | 0.786 | 0.523 |
| Constitutional public defender access model | 4 | 17600 | 1.000 | 0.008 | 0.781 | 0.640 | 0.589 | 0.430 | 0.357 | 0.601 | 0.512 | 0.630 | 0.753 | 0.007 | 0.880 | 0.132 | 0.477 | 2.438 | 0.564 | 0.502 | 0.488 | 0.499 | 0.160 | 0.080 | 0.298 | 0.002 | 0.774 | 0.819 | 0.523 |
| Rights-impact statements before review | 1 | 17600 | 1.000 | 0.838 | 0.806 | 0.688 | 0.579 | 0.536 | 0.358 | 0.615 | 0.504 | 0.698 | 0.716 | 0.086 | 0.764 | 0.244 | 0.295 | 2.419 | 0.563 | 0.501 | 0.707 | 0.709 | 0.056 | 0.023 | 0.528 | 0.305 | 0.422 | 0.207 | 0.422 |
| Rights-impact statements before review | 2 | 17600 | 1.000 | 0.840 | 0.807 | 0.680 | 0.580 | 0.537 | 0.357 | 0.611 | 0.503 | 0.697 | 0.717 | 0.086 | 0.757 | 0.243 | 0.303 | 2.425 | 0.561 | 0.500 | 0.656 | 0.653 | 0.093 | 0.042 | 0.475 | 0.118 | 0.433 | 0.405 | 0.444 |
| Rights-impact statements before review | 3 | 17600 | 1.000 | 0.843 | 0.808 | 0.677 | 0.579 | 0.537 | 0.358 | 0.611 | 0.503 | 0.697 | 0.717 | 0.083 | 0.770 | 0.218 | 0.292 | 2.429 | 0.562 | 0.501 | 0.632 | 0.625 | 0.101 | 0.051 | 0.450 | 0.064 | 0.445 | 0.449 | 0.444 |
| Rights-impact statements before review | 4 | 17600 | 1.000 | 0.845 | 0.807 | 0.676 | 0.579 | 0.536 | 0.357 | 0.611 | 0.503 | 0.697 | 0.717 | 0.083 | 0.753 | 0.253 | 0.291 | 2.438 | 0.564 | 0.502 | 0.622 | 0.619 | 0.106 | 0.048 | 0.429 | 0.038 | 0.453 | 0.465 | 0.445 |
| Mandatory legislative response cycles | 1 | 17600 | 1.000 | 0.877 | 0.721 | 0.685 | 0.589 | 0.539 | 0.358 | 0.626 | 0.223 | 0.614 | 0.921 | 0.006 | 0.888 | 0.092 | 0.396 | 2.419 | 0.563 | 0.501 | 0.701 | 0.713 | 0.063 | 0.033 | 0.524 | 0.303 | 0.418 | 0.254 | 0.386 |
| Mandatory legislative response cycles | 2 | 17600 | 1.000 | 0.873 | 0.721 | 0.677 | 0.590 | 0.539 | 0.357 | 0.623 | 0.223 | 0.614 | 0.922 | 0.006 | 0.872 | 0.105 | 0.396 | 2.425 | 0.561 | 0.500 | 0.640 | 0.652 | 0.096 | 0.054 | 0.458 | 0.113 | 0.429 | 0.465 | 0.400 |
| Mandatory legislative response cycles | 3 | 17600 | 1.000 | 0.878 | 0.722 | 0.673 | 0.589 | 0.539 | 0.358 | 0.623 | 0.224 | 0.614 | 0.921 | 0.006 | 0.888 | 0.122 | 0.391 | 2.429 | 0.562 | 0.501 | 0.608 | 0.608 | 0.111 | 0.061 | 0.417 | 0.063 | 0.459 | 0.520 | 0.400 |
| Mandatory legislative response cycles | 4 | 17600 | 1.000 | 0.878 | 0.720 | 0.671 | 0.589 | 0.539 | 0.357 | 0.623 | 0.224 | 0.614 | 0.922 | 0.005 | 0.843 | 0.096 | 0.393 | 2.438 | 0.564 | 0.502 | 0.595 | 0.599 | 0.116 | 0.064 | 0.405 | 0.036 | 0.481 | 0.540 | 0.400 |

## Doctrine Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Dem. const. | Resp. cred. | Access | Gov. adv. | Impl. cap. | Veto reloc. | Transplant | Culture sens. | Emerg. irr. | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust input | Conflict index | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administrative_state | 10162 | 1.000 | 0.023 | 0.739 | 0.604 | 0.533 | 0.394 | 0.394 | 0.613 | 0.543 | 0.642 | 0.721 | 0.325 | 0.017 | 0.502 | 0.084 | 2.700 | 0.469 | 0.511 | 0.445 | 0.450 | 0.218 | 0.058 | 0.292 | 0.031 | 0.895 | 0.845 | 0.459 |
| Current-style federal supreme court | criminal_procedure | 10046 | 1.000 | 0.024 | 0.675 | 0.562 | 0.550 | 0.441 | 0.347 | 0.608 | 0.519 | 0.643 | 0.736 | 0.385 | 0.020 | 0.554 | 0.573 | 2.325 | 0.562 | 0.491 | 0.400 | 0.402 | 0.175 | 0.077 | 0.235 | 0.027 | 0.904 | 0.848 | 0.446 |
| Current-style federal supreme court | election_law | 10115 | 1.000 | 0.025 | 0.652 | 0.544 | 0.555 | 0.444 | 0.346 | 0.603 | 0.534 | 0.642 | 0.746 | 0.387 | 0.030 | 0.580 | 0.657 | 2.721 | 0.663 | 0.514 | 0.385 | 0.391 | 0.184 | 0.074 | 0.201 | 0.026 | 0.906 | 0.846 | 0.457 |
| Current-style federal supreme court | emergency_powers | 9912 | 1.000 | 0.025 | 0.657 | 0.538 | 0.537 | 0.433 | 0.393 | 0.603 | 0.529 | 0.642 | 0.741 | 0.579 | 0.031 | 0.612 | 0.402 | 1.984 | 0.531 | 0.491 | 0.382 | 0.380 | 0.185 | 0.068 | 0.236 | 0.027 | 0.905 | 0.845 | 0.447 |
| Current-style federal supreme court | equality | 10001 | 1.000 | 0.024 | 0.675 | 0.560 | 0.555 | 0.464 | 0.322 | 0.608 | 0.511 | 0.642 | 0.735 | 0.393 | 0.031 | 0.554 | 0.696 | 2.274 | 0.513 | 0.463 | 0.397 | 0.404 | 0.179 | 0.077 | 0.256 | 0.026 | 0.903 | 0.845 | 0.442 |
| Current-style federal supreme court | federalism | 10051 | 1.000 | 0.024 | 0.734 | 0.590 | 0.531 | 0.398 | 0.375 | 0.607 | 0.547 | 0.642 | 0.745 | 0.328 | 0.020 | 0.541 | 0.140 | 2.752 | 0.754 | 0.586 | 0.416 | 0.414 | 0.162 | 0.066 | 0.200 | 0.028 | 0.901 | 0.845 | 0.464 |
| Current-style federal supreme court | speech | 10113 | 1.000 | 0.023 | 0.681 | 0.568 | 0.552 | 0.453 | 0.325 | 0.611 | 0.512 | 0.643 | 0.727 | 0.377 | 0.034 | 0.566 | 0.579 | 2.228 | 0.447 | 0.450 | 0.418 | 0.409 | 0.175 | 0.070 | 0.278 | 0.028 | 0.903 | 0.846 | 0.440 |
| Staggered 18-year nonrenewable terms | administrative_state | 10162 | 1.000 | 0.023 | 0.746 | 0.612 | 0.533 | 0.394 | 0.394 | 0.613 | 0.534 | 0.642 | 0.720 | 0.317 | 0.031 | 0.473 | 0.057 | 2.700 | 0.469 | 0.511 | 0.449 | 0.454 | 0.218 | 0.057 | 0.307 | 0.032 | 0.882 | 0.827 | 0.463 |
| Staggered 18-year nonrenewable terms | criminal_procedure | 10046 | 1.000 | 0.024 | 0.680 | 0.567 | 0.550 | 0.441 | 0.347 | 0.608 | 0.510 | 0.643 | 0.736 | 0.385 | 0.033 | 0.548 | 0.528 | 2.325 | 0.562 | 0.491 | 0.403 | 0.403 | 0.172 | 0.074 | 0.241 | 0.029 | 0.889 | 0.829 | 0.450 |
| Staggered 18-year nonrenewable terms | election_law | 10115 | 1.000 | 0.025 | 0.661 | 0.551 | 0.555 | 0.444 | 0.346 | 0.603 | 0.524 | 0.642 | 0.746 | 0.384 | 0.042 | 0.577 | 0.612 | 2.721 | 0.663 | 0.514 | 0.397 | 0.388 | 0.180 | 0.078 | 0.207 | 0.028 | 0.894 | 0.829 | 0.462 |
| Staggered 18-year nonrenewable terms | emergency_powers | 9912 | 1.000 | 0.025 | 0.669 | 0.547 | 0.537 | 0.433 | 0.393 | 0.603 | 0.520 | 0.643 | 0.740 | 0.570 | 0.031 | 0.608 | 0.333 | 1.984 | 0.531 | 0.491 | 0.383 | 0.390 | 0.180 | 0.065 | 0.242 | 0.030 | 0.890 | 0.826 | 0.452 |
| Staggered 18-year nonrenewable terms | equality | 10001 | 1.000 | 0.024 | 0.680 | 0.564 | 0.555 | 0.464 | 0.322 | 0.607 | 0.502 | 0.643 | 0.734 | 0.392 | 0.040 | 0.553 | 0.670 | 2.274 | 0.513 | 0.463 | 0.401 | 0.401 | 0.177 | 0.079 | 0.259 | 0.028 | 0.890 | 0.827 | 0.447 |
| Staggered 18-year nonrenewable terms | federalism | 10051 | 1.000 | 0.024 | 0.744 | 0.599 | 0.531 | 0.398 | 0.375 | 0.607 | 0.538 | 0.642 | 0.744 | 0.321 | 0.025 | 0.505 | 0.102 | 2.752 | 0.754 | 0.586 | 0.418 | 0.426 | 0.157 | 0.068 | 0.214 | 0.030 | 0.886 | 0.825 | 0.469 |
| Staggered 18-year nonrenewable terms | speech | 10113 | 1.000 | 0.023 | 0.684 | 0.573 | 0.552 | 0.453 | 0.325 | 0.610 | 0.504 | 0.643 | 0.727 | 0.378 | 0.036 | 0.556 | 0.544 | 2.228 | 0.447 | 0.450 | 0.418 | 0.410 | 0.167 | 0.068 | 0.285 | 0.030 | 0.890 | 0.830 | 0.445 |
| Fifteen-justice supermajority commission court | administrative_state | 10162 | 1.000 | 0.022 | 0.764 | 0.665 | 0.550 | 0.394 | 0.394 | 0.617 | 0.449 | 0.642 | 0.711 | 0.075 | 0.575 | 0.199 | 0.048 | 2.700 | 0.469 | 0.511 | 0.588 | 0.588 | 0.149 | 0.043 | 0.431 | 0.064 | 0.631 | 0.601 | 0.479 |
| Fifteen-justice supermajority commission court | criminal_procedure | 10046 | 1.000 | 0.023 | 0.726 | 0.632 | 0.579 | 0.441 | 0.347 | 0.612 | 0.426 | 0.643 | 0.726 | 0.097 | 0.598 | 0.306 | 0.595 | 2.325 | 0.562 | 0.491 | 0.551 | 0.554 | 0.124 | 0.065 | 0.374 | 0.058 | 0.648 | 0.610 | 0.466 |
| Fifteen-justice supermajority commission court | election_law | 10115 | 1.000 | 0.025 | 0.723 | 0.622 | 0.587 | 0.444 | 0.346 | 0.608 | 0.442 | 0.642 | 0.736 | 0.076 | 0.748 | 0.264 | 0.654 | 2.721 | 0.663 | 0.514 | 0.550 | 0.544 | 0.122 | 0.072 | 0.347 | 0.057 | 0.655 | 0.615 | 0.477 |
| Fifteen-justice supermajority commission court | emergency_powers | 9912 | 1.000 | 0.024 | 0.730 | 0.632 | 0.566 | 0.433 | 0.393 | 0.612 | 0.437 | 0.643 | 0.724 | 0.151 | 0.702 | 0.277 | 0.351 | 1.984 | 0.531 | 0.491 | 0.566 | 0.555 | 0.122 | 0.056 | 0.401 | 0.061 | 0.640 | 0.600 | 0.468 |
| Fifteen-justice supermajority commission court | equality | 10001 | 1.000 | 0.023 | 0.733 | 0.630 | 0.590 | 0.464 | 0.322 | 0.612 | 0.419 | 0.643 | 0.725 | 0.090 | 0.619 | 0.257 | 0.745 | 2.274 | 0.513 | 0.463 | 0.561 | 0.565 | 0.121 | 0.064 | 0.389 | 0.058 | 0.654 | 0.614 | 0.463 |
| Fifteen-justice supermajority commission court | federalism | 10051 | 1.000 | 0.023 | 0.776 | 0.660 | 0.548 | 0.398 | 0.375 | 0.612 | 0.453 | 0.642 | 0.735 | 0.073 | 0.583 | 0.224 | 0.083 | 2.752 | 0.754 | 0.586 | 0.559 | 0.572 | 0.109 | 0.046 | 0.338 | 0.061 | 0.633 | 0.598 | 0.485 |
| Fifteen-justice supermajority commission court | speech | 10113 | 1.000 | 0.023 | 0.733 | 0.638 | 0.583 | 0.453 | 0.325 | 0.615 | 0.420 | 0.643 | 0.717 | 0.083 | 0.614 | 0.265 | 0.606 | 2.228 | 0.447 | 0.450 | 0.572 | 0.575 | 0.117 | 0.062 | 0.420 | 0.059 | 0.653 | 0.615 | 0.460 |
| Supermajority required to invalidate laws | administrative_state | 10162 | 1.000 | 0.022 | 0.762 | 0.660 | 0.542 | 0.394 | 0.394 | 0.616 | 0.459 | 0.641 | 0.715 | 0.079 | 0.538 | 0.212 | 0.047 | 2.700 | 0.469 | 0.511 | 0.581 | 0.589 | 0.152 | 0.041 | 0.425 | 0.062 | 0.641 | 0.613 | 0.466 |
| Supermajority required to invalidate laws | criminal_procedure | 10046 | 1.000 | 0.023 | 0.722 | 0.629 | 0.568 | 0.441 | 0.347 | 0.612 | 0.435 | 0.642 | 0.729 | 0.101 | 0.553 | 0.305 | 0.552 | 2.325 | 0.562 | 0.491 | 0.556 | 0.552 | 0.123 | 0.064 | 0.371 | 0.056 | 0.654 | 0.619 | 0.453 |
| Supermajority required to invalidate laws | election_law | 10115 | 1.000 | 0.025 | 0.719 | 0.618 | 0.578 | 0.444 | 0.346 | 0.607 | 0.450 | 0.641 | 0.739 | 0.081 | 0.677 | 0.270 | 0.630 | 2.721 | 0.663 | 0.514 | 0.549 | 0.542 | 0.129 | 0.070 | 0.335 | 0.054 | 0.662 | 0.623 | 0.464 |
| Supermajority required to invalidate laws | emergency_powers | 9912 | 1.000 | 0.024 | 0.724 | 0.625 | 0.557 | 0.433 | 0.393 | 0.611 | 0.446 | 0.642 | 0.728 | 0.159 | 0.661 | 0.304 | 0.337 | 1.984 | 0.531 | 0.491 | 0.555 | 0.552 | 0.126 | 0.060 | 0.391 | 0.057 | 0.649 | 0.610 | 0.454 |
| Supermajority required to invalidate laws | equality | 10001 | 1.000 | 0.023 | 0.733 | 0.629 | 0.581 | 0.464 | 0.322 | 0.611 | 0.427 | 0.642 | 0.728 | 0.090 | 0.699 | 0.275 | 0.715 | 2.274 | 0.513 | 0.463 | 0.562 | 0.555 | 0.125 | 0.065 | 0.392 | 0.056 | 0.661 | 0.622 | 0.449 |
| Supermajority required to invalidate laws | federalism | 10051 | 1.000 | 0.023 | 0.773 | 0.654 | 0.540 | 0.398 | 0.375 | 0.610 | 0.463 | 0.641 | 0.739 | 0.077 | 0.532 | 0.241 | 0.078 | 2.752 | 0.754 | 0.586 | 0.562 | 0.564 | 0.110 | 0.050 | 0.328 | 0.058 | 0.641 | 0.605 | 0.471 |
| Supermajority required to invalidate laws | speech | 10113 | 1.000 | 0.023 | 0.729 | 0.635 | 0.571 | 0.453 | 0.325 | 0.614 | 0.428 | 0.642 | 0.720 | 0.087 | 0.587 | 0.282 | 0.554 | 2.228 | 0.447 | 0.450 | 0.575 | 0.571 | 0.120 | 0.062 | 0.407 | 0.057 | 0.660 | 0.624 | 0.447 |
| Strict recusal with substitute justices | administrative_state | 10162 | 1.000 | 0.022 | 0.764 | 0.669 | 0.558 | 0.394 | 0.394 | 0.613 | 0.448 | 0.642 | 0.715 | 0.075 | 0.602 | 0.184 | 0.046 | 2.700 | 0.469 | 0.511 | 0.611 | 0.600 | 0.147 | 0.040 | 0.441 | 0.073 | 0.595 | 0.564 | 0.485 |
| Strict recusal with substitute justices | criminal_procedure | 10046 | 1.000 | 0.023 | 0.726 | 0.637 | 0.585 | 0.441 | 0.347 | 0.609 | 0.424 | 0.643 | 0.729 | 0.098 | 0.635 | 0.257 | 0.576 | 2.325 | 0.562 | 0.491 | 0.576 | 0.579 | 0.115 | 0.062 | 0.390 | 0.067 | 0.608 | 0.571 | 0.472 |
| Strict recusal with substitute justices | election_law | 10115 | 1.000 | 0.025 | 0.724 | 0.627 | 0.594 | 0.444 | 0.346 | 0.605 | 0.439 | 0.642 | 0.739 | 0.075 | 0.680 | 0.269 | 0.633 | 2.721 | 0.663 | 0.514 | 0.572 | 0.567 | 0.113 | 0.063 | 0.371 | 0.064 | 0.616 | 0.573 | 0.483 |
| Strict recusal with substitute justices | emergency_powers | 9912 | 1.000 | 0.024 | 0.730 | 0.637 | 0.572 | 0.433 | 0.393 | 0.609 | 0.435 | 0.643 | 0.727 | 0.148 | 0.727 | 0.275 | 0.326 | 1.984 | 0.531 | 0.491 | 0.588 | 0.575 | 0.117 | 0.053 | 0.412 | 0.068 | 0.603 | 0.562 | 0.474 |
| Strict recusal with substitute justices | equality | 10001 | 1.000 | 0.023 | 0.735 | 0.635 | 0.598 | 0.464 | 0.322 | 0.608 | 0.417 | 0.643 | 0.728 | 0.085 | 0.644 | 0.248 | 0.735 | 2.274 | 0.513 | 0.463 | 0.581 | 0.577 | 0.117 | 0.065 | 0.404 | 0.067 | 0.619 | 0.578 | 0.468 |
| Strict recusal with substitute justices | federalism | 10051 | 1.000 | 0.023 | 0.776 | 0.664 | 0.555 | 0.398 | 0.375 | 0.608 | 0.451 | 0.642 | 0.738 | 0.072 | 0.596 | 0.219 | 0.069 | 2.752 | 0.754 | 0.586 | 0.597 | 0.590 | 0.097 | 0.047 | 0.353 | 0.070 | 0.592 | 0.556 | 0.491 |
| Strict recusal with substitute justices | speech | 10113 | 1.000 | 0.023 | 0.733 | 0.643 | 0.590 | 0.453 | 0.325 | 0.612 | 0.418 | 0.643 | 0.720 | 0.080 | 0.659 | 0.261 | 0.586 | 2.228 | 0.447 | 0.450 | 0.589 | 0.588 | 0.113 | 0.061 | 0.430 | 0.068 | 0.615 | 0.577 | 0.466 |
| Reasoned emergency orders with merits follow-up | administrative_state | 10162 | 1.000 | 0.022 | 0.765 | 0.673 | 0.565 | 0.394 | 0.394 | 0.618 | 0.457 | 0.642 | 0.712 | 0.001 | 0.773 | 0.077 | 0.070 | 2.700 | 0.469 | 0.511 | 0.616 | 0.615 | 0.147 | 0.047 | 0.441 | 0.074 | 0.625 | 0.615 | 0.469 |
| Reasoned emergency orders with merits follow-up | criminal_procedure | 10046 | 1.000 | 0.023 | 0.736 | 0.644 | 0.602 | 0.441 | 0.347 | 0.613 | 0.436 | 0.642 | 0.727 | 0.005 | 0.788 | 0.106 | 0.616 | 2.325 | 0.562 | 0.491 | 0.583 | 0.579 | 0.126 | 0.068 | 0.387 | 0.067 | 0.645 | 0.626 | 0.456 |
| Reasoned emergency orders with merits follow-up | election_law | 10115 | 1.000 | 0.024 | 0.723 | 0.629 | 0.608 | 0.444 | 0.346 | 0.608 | 0.453 | 0.642 | 0.737 | 0.008 | 0.808 | 0.122 | 0.682 | 2.721 | 0.663 | 0.514 | 0.569 | 0.572 | 0.124 | 0.076 | 0.359 | 0.064 | 0.651 | 0.628 | 0.467 |
| Reasoned emergency orders with merits follow-up | emergency_powers | 9912 | 1.000 | 0.024 | 0.733 | 0.645 | 0.586 | 0.433 | 0.393 | 0.614 | 0.447 | 0.642 | 0.723 | 0.018 | 0.880 | 0.167 | 0.385 | 1.984 | 0.531 | 0.491 | 0.581 | 0.585 | 0.119 | 0.063 | 0.411 | 0.068 | 0.635 | 0.616 | 0.457 |
| Reasoned emergency orders with merits follow-up | equality | 10001 | 1.000 | 0.023 | 0.742 | 0.642 | 0.612 | 0.464 | 0.322 | 0.612 | 0.429 | 0.642 | 0.726 | 0.008 | 0.799 | 0.092 | 0.767 | 2.274 | 0.513 | 0.463 | 0.583 | 0.581 | 0.123 | 0.078 | 0.416 | 0.066 | 0.653 | 0.629 | 0.453 |
| Reasoned emergency orders with merits follow-up | federalism | 10051 | 1.000 | 0.023 | 0.774 | 0.666 | 0.564 | 0.398 | 0.375 | 0.612 | 0.462 | 0.641 | 0.736 | 0.001 | 0.795 | 0.081 | 0.115 | 2.752 | 0.754 | 0.586 | 0.580 | 0.598 | 0.104 | 0.054 | 0.343 | 0.071 | 0.629 | 0.612 | 0.475 |
| Reasoned emergency orders with merits follow-up | speech | 10113 | 1.000 | 0.023 | 0.739 | 0.648 | 0.604 | 0.453 | 0.325 | 0.615 | 0.430 | 0.642 | 0.718 | 0.007 | 0.788 | 0.113 | 0.628 | 2.228 | 0.447 | 0.450 | 0.595 | 0.586 | 0.116 | 0.065 | 0.431 | 0.067 | 0.652 | 0.633 | 0.450 |
| Panel review with en banc safety valve | administrative_state | 10162 | 1.000 | 0.022 | 0.764 | 0.666 | 0.555 | 0.394 | 0.394 | 0.609 | 0.446 | 0.641 | 0.714 | 0.074 | 0.601 | 0.198 | 0.053 | 2.700 | 0.469 | 0.511 | 0.589 | 0.591 | 0.148 | 0.045 | 0.428 | 0.067 | 0.630 | 0.603 | 0.520 |
| Panel review with en banc safety valve | criminal_procedure | 10046 | 1.000 | 0.023 | 0.726 | 0.633 | 0.585 | 0.441 | 0.347 | 0.605 | 0.423 | 0.642 | 0.728 | 0.098 | 0.689 | 0.275 | 0.613 | 2.325 | 0.562 | 0.491 | 0.553 | 0.563 | 0.122 | 0.061 | 0.384 | 0.060 | 0.648 | 0.611 | 0.503 |
| Panel review with en banc safety valve | election_law | 10115 | 1.000 | 0.025 | 0.722 | 0.622 | 0.592 | 0.444 | 0.346 | 0.599 | 0.438 | 0.641 | 0.739 | 0.077 | 0.641 | 0.270 | 0.662 | 2.721 | 0.663 | 0.514 | 0.550 | 0.547 | 0.123 | 0.068 | 0.342 | 0.059 | 0.654 | 0.616 | 0.524 |
| Panel review with en banc safety valve | emergency_powers | 9912 | 1.000 | 0.024 | 0.731 | 0.634 | 0.571 | 0.433 | 0.393 | 0.604 | 0.434 | 0.642 | 0.727 | 0.149 | 0.722 | 0.287 | 0.355 | 1.984 | 0.531 | 0.491 | 0.566 | 0.561 | 0.117 | 0.056 | 0.397 | 0.061 | 0.639 | 0.602 | 0.513 |
| Panel review with en banc safety valve | equality | 10001 | 1.000 | 0.023 | 0.732 | 0.631 | 0.597 | 0.464 | 0.322 | 0.604 | 0.416 | 0.642 | 0.727 | 0.088 | 0.640 | 0.245 | 0.761 | 2.274 | 0.513 | 0.463 | 0.558 | 0.557 | 0.127 | 0.068 | 0.396 | 0.060 | 0.653 | 0.615 | 0.501 |
| Panel review with en banc safety valve | federalism | 10051 | 1.000 | 0.023 | 0.776 | 0.661 | 0.553 | 0.398 | 0.375 | 0.603 | 0.450 | 0.641 | 0.738 | 0.073 | 0.603 | 0.205 | 0.076 | 2.752 | 0.754 | 0.586 | 0.568 | 0.577 | 0.105 | 0.048 | 0.337 | 0.063 | 0.631 | 0.596 | 0.531 |
| Panel review with en banc safety valve | speech | 10113 | 1.000 | 0.023 | 0.733 | 0.639 | 0.589 | 0.453 | 0.325 | 0.608 | 0.417 | 0.642 | 0.719 | 0.083 | 0.635 | 0.259 | 0.625 | 2.228 | 0.447 | 0.450 | 0.575 | 0.576 | 0.116 | 0.061 | 0.410 | 0.060 | 0.652 | 0.617 | 0.495 |
| Dual supreme courts with cross-checking invalidations | administrative_state | 10162 | 1.000 | 0.022 | 0.764 | 0.667 | 0.562 | 0.394 | 0.394 | 0.588 | 0.611 | 0.638 | 0.726 | 0.003 | 0.780 | 0.056 | 0.014 | 2.700 | 0.469 | 0.511 | 0.652 | 0.641 | 0.128 | 0.037 | 0.481 | 0.095 | 0.528 | 0.494 | 0.598 |
| Dual supreme courts with cross-checking invalidations | criminal_procedure | 10046 | 1.000 | 0.023 | 0.741 | 0.642 | 0.593 | 0.441 | 0.347 | 0.583 | 0.586 | 0.639 | 0.741 | 0.008 | 0.807 | 0.117 | 0.482 | 2.325 | 0.562 | 0.491 | 0.616 | 0.611 | 0.099 | 0.055 | 0.430 | 0.087 | 0.547 | 0.506 | 0.585 |
| Dual supreme courts with cross-checking invalidations | election_law | 10115 | 1.000 | 0.024 | 0.739 | 0.630 | 0.598 | 0.444 | 0.346 | 0.579 | 0.600 | 0.638 | 0.752 | 0.009 | 0.805 | 0.138 | 0.536 | 2.721 | 0.663 | 0.514 | 0.608 | 0.605 | 0.105 | 0.060 | 0.396 | 0.083 | 0.554 | 0.507 | 0.596 |
| Dual supreme courts with cross-checking invalidations | emergency_powers | 9912 | 1.000 | 0.024 | 0.736 | 0.643 | 0.574 | 0.433 | 0.393 | 0.585 | 0.597 | 0.639 | 0.737 | 0.022 | 0.866 | 0.150 | 0.212 | 1.984 | 0.531 | 0.491 | 0.627 | 0.620 | 0.101 | 0.045 | 0.445 | 0.090 | 0.536 | 0.492 | 0.586 |
| Dual supreme courts with cross-checking invalidations | equality | 10001 | 1.000 | 0.023 | 0.751 | 0.639 | 0.606 | 0.464 | 0.322 | 0.583 | 0.579 | 0.639 | 0.740 | 0.011 | 0.803 | 0.121 | 0.670 | 2.274 | 0.513 | 0.463 | 0.626 | 0.616 | 0.107 | 0.060 | 0.439 | 0.085 | 0.558 | 0.513 | 0.582 |
| Dual supreme courts with cross-checking invalidations | federalism | 10051 | 1.000 | 0.023 | 0.778 | 0.663 | 0.558 | 0.398 | 0.375 | 0.582 | 0.614 | 0.638 | 0.750 | 0.002 | 0.766 | 0.051 | 0.022 | 2.752 | 0.754 | 0.586 | 0.619 | 0.627 | 0.087 | 0.042 | 0.391 | 0.089 | 0.528 | 0.487 | 0.604 |
| Dual supreme courts with cross-checking invalidations | speech | 10113 | 1.000 | 0.023 | 0.744 | 0.644 | 0.596 | 0.453 | 0.325 | 0.585 | 0.580 | 0.639 | 0.733 | 0.008 | 0.808 | 0.110 | 0.503 | 2.228 | 0.447 | 0.450 | 0.627 | 0.624 | 0.099 | 0.051 | 0.464 | 0.084 | 0.554 | 0.510 | 0.579 |
| Pre-enactment constitutional council | administrative_state | 10162 | 1.000 | 0.022 | 0.763 | 0.662 | 0.565 | 0.394 | 0.394 | 0.600 | 0.678 | 0.641 | 0.722 | 0.070 | 0.640 | 0.180 | 0.018 | 2.700 | 0.469 | 0.511 | 0.654 | 0.651 | 0.121 | 0.037 | 0.493 | 0.101 | 0.483 | 0.440 | 0.542 |
| Pre-enactment constitutional council | criminal_procedure | 10046 | 1.000 | 0.023 | 0.726 | 0.638 | 0.587 | 0.441 | 0.347 | 0.596 | 0.652 | 0.641 | 0.735 | 0.092 | 0.676 | 0.255 | 0.471 | 2.325 | 0.562 | 0.491 | 0.617 | 0.623 | 0.095 | 0.057 | 0.437 | 0.094 | 0.500 | 0.450 | 0.529 |
| Pre-enactment constitutional council | election_law | 10115 | 1.000 | 0.025 | 0.732 | 0.634 | 0.592 | 0.444 | 0.346 | 0.592 | 0.664 | 0.641 | 0.744 | 0.073 | 0.702 | 0.242 | 0.498 | 2.721 | 0.663 | 0.514 | 0.612 | 0.617 | 0.094 | 0.052 | 0.405 | 0.090 | 0.503 | 0.446 | 0.540 |
| Pre-enactment constitutional council | emergency_powers | 9912 | 1.000 | 0.024 | 0.727 | 0.636 | 0.572 | 0.433 | 0.393 | 0.596 | 0.663 | 0.641 | 0.733 | 0.140 | 0.760 | 0.260 | 0.189 | 1.984 | 0.531 | 0.491 | 0.638 | 0.635 | 0.096 | 0.041 | 0.459 | 0.096 | 0.490 | 0.436 | 0.531 |
| Pre-enactment constitutional council | equality | 10001 | 1.000 | 0.023 | 0.739 | 0.639 | 0.600 | 0.464 | 0.322 | 0.595 | 0.644 | 0.641 | 0.734 | 0.084 | 0.780 | 0.227 | 0.647 | 2.274 | 0.513 | 0.463 | 0.618 | 0.626 | 0.100 | 0.054 | 0.460 | 0.091 | 0.510 | 0.455 | 0.526 |
| Pre-enactment constitutional council | federalism | 10051 | 1.000 | 0.023 | 0.776 | 0.658 | 0.561 | 0.398 | 0.375 | 0.594 | 0.681 | 0.640 | 0.745 | 0.072 | 0.651 | 0.174 | 0.027 | 2.752 | 0.754 | 0.586 | 0.629 | 0.639 | 0.079 | 0.037 | 0.412 | 0.097 | 0.481 | 0.430 | 0.548 |
| Pre-enactment constitutional council | speech | 10113 | 1.000 | 0.023 | 0.732 | 0.644 | 0.592 | 0.453 | 0.325 | 0.599 | 0.646 | 0.642 | 0.726 | 0.079 | 0.691 | 0.237 | 0.495 | 2.228 | 0.447 | 0.450 | 0.637 | 0.631 | 0.094 | 0.049 | 0.474 | 0.093 | 0.502 | 0.450 | 0.523 |
| Judicial review with delayed legislative override | administrative_state | 10162 | 1.000 | 0.022 | 0.763 | 0.661 | 0.550 | 0.394 | 0.394 | 0.612 | 0.449 | 0.642 | 0.718 | 0.078 | 0.569 | 0.192 | 0.068 | 2.700 | 0.469 | 0.511 | 0.575 | 0.577 | 0.158 | 0.047 | 0.418 | 0.060 | 0.666 | 0.637 | 0.475 |
| Judicial review with delayed legislative override | criminal_procedure | 10046 | 1.000 | 0.023 | 0.720 | 0.627 | 0.580 | 0.441 | 0.347 | 0.607 | 0.424 | 0.642 | 0.733 | 0.098 | 0.580 | 0.288 | 0.608 | 2.325 | 0.562 | 0.491 | 0.546 | 0.543 | 0.129 | 0.069 | 0.363 | 0.055 | 0.681 | 0.644 | 0.462 |
| Judicial review with delayed legislative override | election_law | 10115 | 1.000 | 0.025 | 0.714 | 0.616 | 0.590 | 0.444 | 0.346 | 0.603 | 0.437 | 0.642 | 0.743 | 0.078 | 0.634 | 0.253 | 0.671 | 2.721 | 0.663 | 0.514 | 0.532 | 0.531 | 0.126 | 0.069 | 0.325 | 0.052 | 0.688 | 0.647 | 0.473 |
| Judicial review with delayed legislative override | emergency_powers | 9912 | 1.000 | 0.024 | 0.726 | 0.626 | 0.567 | 0.433 | 0.393 | 0.607 | 0.436 | 0.642 | 0.731 | 0.153 | 0.685 | 0.285 | 0.383 | 1.984 | 0.531 | 0.491 | 0.535 | 0.543 | 0.136 | 0.060 | 0.382 | 0.055 | 0.674 | 0.635 | 0.464 |
| Judicial review with delayed legislative override | equality | 10001 | 1.000 | 0.023 | 0.729 | 0.626 | 0.592 | 0.464 | 0.322 | 0.607 | 0.415 | 0.642 | 0.732 | 0.087 | 0.630 | 0.248 | 0.753 | 2.274 | 0.513 | 0.463 | 0.548 | 0.537 | 0.129 | 0.072 | 0.370 | 0.053 | 0.687 | 0.648 | 0.459 |
| Judicial review with delayed legislative override | federalism | 10051 | 1.000 | 0.023 | 0.773 | 0.654 | 0.548 | 0.398 | 0.375 | 0.607 | 0.453 | 0.641 | 0.741 | 0.076 | 0.568 | 0.232 | 0.108 | 2.752 | 0.754 | 0.586 | 0.547 | 0.561 | 0.116 | 0.053 | 0.321 | 0.055 | 0.668 | 0.633 | 0.481 |
| Judicial review with delayed legislative override | speech | 10113 | 1.000 | 0.023 | 0.727 | 0.633 | 0.584 | 0.453 | 0.325 | 0.610 | 0.418 | 0.642 | 0.724 | 0.084 | 0.602 | 0.263 | 0.617 | 2.228 | 0.447 | 0.450 | 0.551 | 0.549 | 0.125 | 0.064 | 0.391 | 0.054 | 0.688 | 0.652 | 0.456 |
| Retention-election accountability court | administrative_state | 10162 | 1.000 | 0.022 | 0.762 | 0.671 | 0.552 | 0.394 | 0.394 | 0.609 | 0.428 | 0.641 | 0.719 | 0.073 | 0.609 | 0.162 | 0.017 | 2.700 | 0.469 | 0.511 | 0.626 | 0.624 | 0.127 | 0.033 | 0.473 | 0.084 | 0.510 | 0.458 | 0.490 |
| Retention-election accountability court | criminal_procedure | 10046 | 1.000 | 0.023 | 0.710 | 0.641 | 0.575 | 0.441 | 0.347 | 0.605 | 0.396 | 0.642 | 0.733 | 0.092 | 0.609 | 0.270 | 0.422 | 2.325 | 0.562 | 0.491 | 0.602 | 0.593 | 0.098 | 0.051 | 0.421 | 0.078 | 0.523 | 0.465 | 0.478 |
| Retention-election accountability court | election_law | 10115 | 1.000 | 0.025 | 0.715 | 0.635 | 0.584 | 0.444 | 0.346 | 0.600 | 0.404 | 0.641 | 0.744 | 0.071 | 0.741 | 0.344 | 0.464 | 2.721 | 0.663 | 0.514 | 0.576 | 0.585 | 0.100 | 0.054 | 0.378 | 0.074 | 0.529 | 0.464 | 0.489 |
| Retention-election accountability court | emergency_powers | 9912 | 1.000 | 0.024 | 0.725 | 0.645 | 0.560 | 0.433 | 0.393 | 0.605 | 0.411 | 0.642 | 0.731 | 0.139 | 0.698 | 0.239 | 0.178 | 1.984 | 0.531 | 0.491 | 0.595 | 0.599 | 0.098 | 0.042 | 0.441 | 0.079 | 0.516 | 0.456 | 0.479 |
| Retention-election accountability court | equality | 10001 | 1.000 | 0.023 | 0.716 | 0.637 | 0.593 | 0.464 | 0.322 | 0.603 | 0.382 | 0.642 | 0.734 | 0.081 | 0.656 | 0.246 | 0.615 | 2.274 | 0.513 | 0.463 | 0.600 | 0.579 | 0.111 | 0.057 | 0.417 | 0.075 | 0.536 | 0.472 | 0.474 |
| Retention-election accountability court | federalism | 10051 | 1.000 | 0.023 | 0.776 | 0.667 | 0.548 | 0.398 | 0.375 | 0.604 | 0.431 | 0.641 | 0.743 | 0.070 | 0.594 | 0.165 | 0.021 | 2.752 | 0.754 | 0.586 | 0.606 | 0.610 | 0.088 | 0.042 | 0.376 | 0.078 | 0.507 | 0.447 | 0.496 |
| Retention-election accountability court | speech | 10113 | 1.000 | 0.023 | 0.714 | 0.645 | 0.581 | 0.453 | 0.325 | 0.607 | 0.389 | 0.642 | 0.725 | 0.077 | 0.627 | 0.255 | 0.454 | 2.228 | 0.447 | 0.450 | 0.608 | 0.597 | 0.100 | 0.046 | 0.448 | 0.076 | 0.529 | 0.469 | 0.472 |
| Hybrid court balancing independence and accountability | administrative_state | 10162 | 1.000 | 0.022 | 0.764 | 0.680 | 0.563 | 0.394 | 0.394 | 0.595 | 0.446 | 0.639 | 0.726 | 0.001 | 0.794 | 0.041 | 0.022 | 2.700 | 0.469 | 0.511 | 0.645 | 0.644 | 0.134 | 0.038 | 0.480 | 0.101 | 0.522 | 0.507 | 0.552 |
| Hybrid court balancing independence and accountability | criminal_procedure | 10046 | 1.000 | 0.023 | 0.740 | 0.655 | 0.597 | 0.441 | 0.347 | 0.591 | 0.423 | 0.640 | 0.740 | 0.005 | 0.814 | 0.093 | 0.532 | 2.325 | 0.562 | 0.491 | 0.615 | 0.624 | 0.102 | 0.062 | 0.431 | 0.093 | 0.542 | 0.520 | 0.533 |
| Hybrid court balancing independence and accountability | election_law | 10115 | 1.000 | 0.024 | 0.737 | 0.644 | 0.600 | 0.444 | 0.346 | 0.585 | 0.436 | 0.639 | 0.751 | 0.007 | 0.805 | 0.115 | 0.561 | 2.721 | 0.663 | 0.514 | 0.610 | 0.606 | 0.102 | 0.063 | 0.402 | 0.089 | 0.547 | 0.519 | 0.556 |
| Hybrid court balancing independence and accountability | emergency_powers | 9912 | 1.000 | 0.024 | 0.736 | 0.658 | 0.576 | 0.433 | 0.393 | 0.591 | 0.432 | 0.640 | 0.736 | 0.015 | 0.885 | 0.156 | 0.238 | 1.984 | 0.531 | 0.491 | 0.625 | 0.621 | 0.097 | 0.050 | 0.445 | 0.098 | 0.529 | 0.505 | 0.544 |
| Hybrid court balancing independence and accountability | equality | 10001 | 1.000 | 0.023 | 0.749 | 0.652 | 0.609 | 0.464 | 0.322 | 0.590 | 0.416 | 0.640 | 0.740 | 0.008 | 0.811 | 0.098 | 0.708 | 2.274 | 0.513 | 0.463 | 0.620 | 0.622 | 0.109 | 0.064 | 0.441 | 0.090 | 0.551 | 0.523 | 0.532 |
| Hybrid court balancing independence and accountability | federalism | 10051 | 1.000 | 0.023 | 0.778 | 0.677 | 0.559 | 0.398 | 0.375 | 0.588 | 0.449 | 0.639 | 0.750 | 0.001 | 0.804 | 0.049 | 0.032 | 2.752 | 0.754 | 0.586 | 0.618 | 0.619 | 0.091 | 0.042 | 0.390 | 0.096 | 0.519 | 0.498 | 0.564 |
| Hybrid court balancing independence and accountability | speech | 10113 | 1.000 | 0.023 | 0.744 | 0.658 | 0.600 | 0.453 | 0.325 | 0.594 | 0.417 | 0.640 | 0.731 | 0.006 | 0.809 | 0.091 | 0.559 | 2.228 | 0.447 | 0.450 | 0.625 | 0.619 | 0.107 | 0.052 | 0.463 | 0.091 | 0.547 | 0.524 | 0.525 |
| Weak-form review with legislative reply | administrative_state | 10162 | 1.000 | 0.869 | 0.763 | 0.706 | 0.564 | 0.500 | 0.394 | 0.638 | 0.243 | 0.676 | 0.757 | 0.072 | 0.628 | 0.173 | 0.000 | 2.700 | 0.469 | 0.511 | 0.747 | 0.741 | 0.080 | 0.017 | 0.568 | 0.246 | 0.245 | 0.202 | 0.364 |
| Weak-form review with legislative reply | criminal_procedure | 10046 | 1.000 | 0.890 | 0.700 | 0.694 | 0.635 | 0.549 | 0.347 | 0.637 | 0.148 | 0.677 | 0.766 | 0.092 | 0.645 | 0.359 | 0.000 | 2.325 | 0.562 | 0.491 | 0.705 | 0.693 | 0.050 | 0.022 | 0.519 | 0.240 | 0.252 | 0.206 | 0.356 |
| Weak-form review with legislative reply | election_law | 10115 | 1.000 | 0.869 | 0.688 | 0.689 | 0.653 | 0.550 | 0.346 | 0.632 | 0.152 | 0.676 | 0.775 | 0.074 | 0.656 | 0.264 | 0.000 | 2.721 | 0.663 | 0.514 | 0.686 | 0.682 | 0.052 | 0.023 | 0.472 | 0.238 | 0.253 | 0.201 | 0.370 |
| Weak-form review with legislative reply | emergency_powers | 9912 | 1.000 | 0.730 | 0.708 | 0.686 | 0.601 | 0.526 | 0.393 | 0.634 | 0.196 | 0.676 | 0.767 | 0.143 | 0.736 | 0.276 | 0.000 | 1.984 | 0.531 | 0.491 | 0.702 | 0.699 | 0.059 | 0.020 | 0.538 | 0.241 | 0.249 | 0.199 | 0.360 |
| Weak-form review with legislative reply | equality | 10001 | 1.000 | 0.898 | 0.689 | 0.697 | 0.664 | 0.573 | 0.322 | 0.636 | 0.113 | 0.676 | 0.764 | 0.086 | 0.669 | 0.251 | 0.000 | 2.274 | 0.513 | 0.463 | 0.689 | 0.682 | 0.058 | 0.023 | 0.529 | 0.238 | 0.256 | 0.209 | 0.355 |
| Weak-form review with legislative reply | federalism | 10051 | 1.000 | 0.862 | 0.773 | 0.702 | 0.564 | 0.504 | 0.375 | 0.632 | 0.245 | 0.676 | 0.780 | 0.072 | 0.607 | 0.170 | 0.000 | 2.752 | 0.754 | 0.586 | 0.713 | 0.711 | 0.055 | 0.024 | 0.485 | 0.238 | 0.245 | 0.195 | 0.372 |
| Weak-form review with legislative reply | speech | 10113 | 1.000 | 0.913 | 0.699 | 0.700 | 0.643 | 0.564 | 0.325 | 0.639 | 0.134 | 0.677 | 0.757 | 0.078 | 0.660 | 0.227 | 0.000 | 2.228 | 0.447 | 0.450 | 0.702 | 0.704 | 0.057 | 0.020 | 0.547 | 0.237 | 0.251 | 0.205 | 0.350 |
| Suspended declarations of invalidity | administrative_state | 10162 | 1.000 | 0.901 | 0.762 | 0.688 | 0.567 | 0.502 | 0.394 | 0.633 | 0.281 | 0.622 | 0.827 | 0.001 | 0.788 | 0.053 | 0.059 | 2.700 | 0.469 | 0.511 | 0.614 | 0.625 | 0.145 | 0.043 | 0.446 | 0.079 | 0.606 | 0.594 | 0.388 |
| Suspended declarations of invalidity | criminal_procedure | 10046 | 1.000 | 0.904 | 0.703 | 0.678 | 0.662 | 0.550 | 0.347 | 0.624 | 0.172 | 0.622 | 0.846 | 0.005 | 0.790 | 0.102 | 0.625 | 2.325 | 0.562 | 0.491 | 0.613 | 0.607 | 0.111 | 0.059 | 0.412 | 0.072 | 0.627 | 0.605 | 0.381 |
| Suspended declarations of invalidity | election_law | 10115 | 1.000 | 0.903 | 0.690 | 0.669 | 0.672 | 0.553 | 0.346 | 0.619 | 0.180 | 0.621 | 0.856 | 0.008 | 0.774 | 0.133 | 0.677 | 2.721 | 0.663 | 0.514 | 0.609 | 0.589 | 0.114 | 0.064 | 0.378 | 0.069 | 0.632 | 0.606 | 0.394 |
| Suspended declarations of invalidity | emergency_powers | 9912 | 1.000 | 0.750 | 0.714 | 0.673 | 0.618 | 0.528 | 0.393 | 0.627 | 0.228 | 0.622 | 0.840 | 0.017 | 0.872 | 0.150 | 0.365 | 1.984 | 0.531 | 0.491 | 0.605 | 0.609 | 0.105 | 0.056 | 0.434 | 0.076 | 0.613 | 0.592 | 0.384 |
| Suspended declarations of invalidity | equality | 10001 | 1.000 | 0.910 | 0.703 | 0.682 | 0.687 | 0.574 | 0.322 | 0.623 | 0.140 | 0.622 | 0.846 | 0.008 | 0.792 | 0.103 | 0.776 | 2.274 | 0.513 | 0.463 | 0.616 | 0.599 | 0.124 | 0.068 | 0.428 | 0.071 | 0.634 | 0.609 | 0.379 |
| Suspended declarations of invalidity | federalism | 10051 | 1.000 | 0.899 | 0.771 | 0.683 | 0.569 | 0.507 | 0.375 | 0.627 | 0.281 | 0.621 | 0.851 | 0.001 | 0.775 | 0.071 | 0.095 | 2.752 | 0.754 | 0.586 | 0.594 | 0.600 | 0.102 | 0.049 | 0.356 | 0.075 | 0.608 | 0.592 | 0.395 |
| Suspended declarations of invalidity | speech | 10113 | 1.000 | 0.918 | 0.710 | 0.684 | 0.665 | 0.563 | 0.325 | 0.627 | 0.162 | 0.622 | 0.837 | 0.006 | 0.768 | 0.116 | 0.636 | 2.228 | 0.447 | 0.450 | 0.621 | 0.615 | 0.106 | 0.059 | 0.445 | 0.072 | 0.633 | 0.611 | 0.375 |
| Strong-form review with explicit override clause | administrative_state | 10162 | 1.000 | 0.107 | 0.764 | 0.668 | 0.554 | 0.404 | 0.394 | 0.622 | 0.406 | 0.630 | 0.859 | 0.075 | 0.624 | 0.196 | 0.065 | 2.700 | 0.469 | 0.511 | 0.621 | 0.620 | 0.137 | 0.042 | 0.463 | 0.085 | 0.535 | 0.520 | 0.432 |
| Strong-form review with explicit override clause | criminal_procedure | 10046 | 1.000 | 0.112 | 0.725 | 0.644 | 0.581 | 0.452 | 0.347 | 0.619 | 0.337 | 0.630 | 0.870 | 0.096 | 0.617 | 0.280 | 0.583 | 2.325 | 0.562 | 0.491 | 0.592 | 0.588 | 0.112 | 0.061 | 0.408 | 0.079 | 0.548 | 0.529 | 0.422 |
| Strong-form review with explicit override clause | election_law | 10115 | 1.000 | 0.120 | 0.722 | 0.637 | 0.590 | 0.456 | 0.346 | 0.616 | 0.337 | 0.630 | 0.879 | 0.076 | 0.631 | 0.273 | 0.640 | 2.721 | 0.663 | 0.514 | 0.588 | 0.583 | 0.113 | 0.064 | 0.374 | 0.077 | 0.555 | 0.532 | 0.434 |
| Strong-form review with explicit override clause | emergency_powers | 9912 | 1.000 | 0.116 | 0.728 | 0.640 | 0.568 | 0.444 | 0.393 | 0.618 | 0.368 | 0.630 | 0.870 | 0.151 | 0.720 | 0.287 | 0.344 | 1.984 | 0.531 | 0.491 | 0.599 | 0.589 | 0.110 | 0.050 | 0.423 | 0.081 | 0.543 | 0.520 | 0.422 |
| Strong-form review with explicit override clause | equality | 10001 | 1.000 | 0.114 | 0.734 | 0.647 | 0.593 | 0.475 | 0.322 | 0.619 | 0.311 | 0.630 | 0.868 | 0.087 | 0.684 | 0.308 | 0.738 | 2.274 | 0.513 | 0.463 | 0.597 | 0.596 | 0.113 | 0.062 | 0.420 | 0.078 | 0.556 | 0.534 | 0.419 |
| Strong-form review with explicit override clause | federalism | 10051 | 1.000 | 0.113 | 0.775 | 0.662 | 0.552 | 0.409 | 0.375 | 0.616 | 0.407 | 0.630 | 0.882 | 0.074 | 0.616 | 0.215 | 0.087 | 2.752 | 0.754 | 0.586 | 0.600 | 0.592 | 0.100 | 0.045 | 0.367 | 0.081 | 0.533 | 0.512 | 0.438 |
| Strong-form review with explicit override clause | speech | 10113 | 1.000 | 0.111 | 0.731 | 0.651 | 0.586 | 0.463 | 0.325 | 0.622 | 0.327 | 0.631 | 0.861 | 0.082 | 0.737 | 0.277 | 0.596 | 2.228 | 0.447 | 0.450 | 0.599 | 0.599 | 0.103 | 0.058 | 0.460 | 0.079 | 0.554 | 0.536 | 0.416 |
| Pre-enactment review before laws take effect | administrative_state | 10162 | 1.000 | 0.860 | 0.775 | 0.673 | 0.563 | 0.499 | 0.394 | 0.617 | 0.527 | 0.578 | 0.828 | 0.071 | 0.639 | 0.173 | 0.011 | 2.700 | 0.469 | 0.511 | 0.668 | 0.664 | 0.117 | 0.032 | 0.495 | 0.112 | 0.461 | 0.415 | 0.443 |
| Pre-enactment review before laws take effect | criminal_procedure | 10046 | 1.000 | 0.862 | 0.749 | 0.652 | 0.583 | 0.547 | 0.347 | 0.613 | 0.502 | 0.579 | 0.841 | 0.092 | 0.658 | 0.267 | 0.435 | 2.325 | 0.562 | 0.491 | 0.628 | 0.629 | 0.095 | 0.045 | 0.446 | 0.106 | 0.473 | 0.418 | 0.433 |
| Pre-enactment review before laws take effect | election_law | 10115 | 1.000 | 0.864 | 0.767 | 0.651 | 0.589 | 0.550 | 0.346 | 0.609 | 0.516 | 0.578 | 0.851 | 0.070 | 0.695 | 0.242 | 0.472 | 2.721 | 0.663 | 0.514 | 0.634 | 0.620 | 0.093 | 0.047 | 0.413 | 0.102 | 0.477 | 0.418 | 0.448 |
| Pre-enactment review before laws take effect | emergency_powers | 9912 | 1.000 | 0.713 | 0.762 | 0.652 | 0.569 | 0.524 | 0.393 | 0.612 | 0.527 | 0.578 | 0.840 | 0.140 | 0.770 | 0.255 | 0.172 | 1.984 | 0.531 | 0.491 | 0.634 | 0.638 | 0.088 | 0.041 | 0.465 | 0.106 | 0.466 | 0.410 | 0.440 |
| Pre-enactment review before laws take effect | equality | 10001 | 1.000 | 0.869 | 0.773 | 0.656 | 0.597 | 0.570 | 0.322 | 0.612 | 0.494 | 0.579 | 0.841 | 0.083 | 0.697 | 0.244 | 0.622 | 2.274 | 0.513 | 0.463 | 0.627 | 0.635 | 0.090 | 0.052 | 0.463 | 0.103 | 0.485 | 0.429 | 0.431 |
| Pre-enactment review before laws take effect | federalism | 10051 | 1.000 | 0.860 | 0.789 | 0.669 | 0.559 | 0.504 | 0.375 | 0.612 | 0.530 | 0.578 | 0.851 | 0.071 | 0.637 | 0.170 | 0.011 | 2.752 | 0.754 | 0.586 | 0.638 | 0.650 | 0.078 | 0.041 | 0.404 | 0.107 | 0.458 | 0.405 | 0.451 |
| Pre-enactment review before laws take effect | speech | 10113 | 1.000 | 0.878 | 0.761 | 0.659 | 0.587 | 0.560 | 0.325 | 0.616 | 0.495 | 0.579 | 0.833 | 0.079 | 0.669 | 0.242 | 0.456 | 2.228 | 0.447 | 0.450 | 0.642 | 0.639 | 0.085 | 0.046 | 0.488 | 0.105 | 0.476 | 0.421 | 0.427 |
| Abstract review tribunal | administrative_state | 10162 | 1.000 | 0.919 | 0.777 | 0.683 | 0.561 | 0.503 | 0.394 | 0.619 | 0.324 | 0.563 | 0.897 | 0.003 | 0.762 | 0.059 | 0.037 | 2.700 | 0.469 | 0.511 | 0.636 | 0.638 | 0.137 | 0.040 | 0.472 | 0.084 | 0.568 | 0.557 | 0.443 |
| Abstract review tribunal | criminal_procedure | 10046 | 1.000 | 0.918 | 0.763 | 0.658 | 0.598 | 0.550 | 0.347 | 0.614 | 0.304 | 0.564 | 0.912 | 0.008 | 0.778 | 0.097 | 0.583 | 2.325 | 0.562 | 0.491 | 0.602 | 0.604 | 0.111 | 0.063 | 0.407 | 0.076 | 0.588 | 0.568 | 0.427 |
| Abstract review tribunal | election_law | 10115 | 1.000 | 0.921 | 0.766 | 0.647 | 0.601 | 0.554 | 0.346 | 0.606 | 0.321 | 0.562 | 0.923 | 0.010 | 0.764 | 0.110 | 0.625 | 2.721 | 0.663 | 0.514 | 0.588 | 0.597 | 0.115 | 0.067 | 0.385 | 0.074 | 0.595 | 0.569 | 0.454 |
| Abstract review tribunal | emergency_powers | 9912 | 1.000 | 0.771 | 0.770 | 0.660 | 0.578 | 0.530 | 0.393 | 0.613 | 0.325 | 0.563 | 0.909 | 0.025 | 0.865 | 0.167 | 0.303 | 1.984 | 0.531 | 0.491 | 0.615 | 0.606 | 0.110 | 0.050 | 0.443 | 0.079 | 0.575 | 0.554 | 0.443 |
| Abstract review tribunal | equality | 10001 | 1.000 | 0.919 | 0.779 | 0.657 | 0.609 | 0.574 | 0.322 | 0.612 | 0.298 | 0.563 | 0.912 | 0.011 | 0.781 | 0.091 | 0.743 | 2.274 | 0.513 | 0.463 | 0.602 | 0.596 | 0.119 | 0.065 | 0.427 | 0.075 | 0.597 | 0.572 | 0.427 |
| Abstract review tribunal | federalism | 10051 | 1.000 | 0.923 | 0.791 | 0.678 | 0.558 | 0.508 | 0.375 | 0.612 | 0.328 | 0.562 | 0.921 | 0.003 | 0.754 | 0.072 | 0.056 | 2.752 | 0.754 | 0.586 | 0.605 | 0.612 | 0.094 | 0.048 | 0.370 | 0.080 | 0.569 | 0.551 | 0.456 |
| Abstract review tribunal | speech | 10113 | 1.000 | 0.926 | 0.773 | 0.663 | 0.600 | 0.563 | 0.325 | 0.617 | 0.298 | 0.564 | 0.904 | 0.009 | 0.773 | 0.098 | 0.602 | 2.228 | 0.447 | 0.450 | 0.603 | 0.611 | 0.109 | 0.061 | 0.458 | 0.076 | 0.592 | 0.571 | 0.419 |
| Ombudsman-triggered constitutional review | administrative_state | 10162 | 1.000 | 0.008 | 0.765 | 0.657 | 0.561 | 0.392 | 0.394 | 0.608 | 0.535 | 0.602 | 0.769 | 0.074 | 0.635 | 0.189 | 0.078 | 2.700 | 0.469 | 0.511 | 0.583 | 0.588 | 0.154 | 0.047 | 0.418 | 0.065 | 0.649 | 0.623 | 0.522 |
| Ombudsman-triggered constitutional review | criminal_procedure | 10046 | 1.000 | 0.009 | 0.723 | 0.622 | 0.592 | 0.439 | 0.347 | 0.602 | 0.516 | 0.602 | 0.785 | 0.099 | 0.651 | 0.251 | 0.646 | 2.325 | 0.562 | 0.491 | 0.557 | 0.557 | 0.126 | 0.067 | 0.363 | 0.059 | 0.666 | 0.632 | 0.514 |
| Ombudsman-triggered constitutional review | election_law | 10115 | 1.000 | 0.010 | 0.719 | 0.612 | 0.599 | 0.442 | 0.346 | 0.598 | 0.532 | 0.601 | 0.794 | 0.077 | 0.686 | 0.238 | 0.687 | 2.721 | 0.663 | 0.514 | 0.542 | 0.545 | 0.125 | 0.073 | 0.332 | 0.056 | 0.674 | 0.637 | 0.525 |
| Ombudsman-triggered constitutional review | emergency_powers | 9912 | 1.000 | 0.009 | 0.731 | 0.624 | 0.578 | 0.431 | 0.393 | 0.602 | 0.526 | 0.602 | 0.782 | 0.151 | 0.739 | 0.286 | 0.403 | 1.984 | 0.531 | 0.491 | 0.552 | 0.560 | 0.124 | 0.065 | 0.388 | 0.059 | 0.659 | 0.621 | 0.515 |
| Ombudsman-triggered constitutional review | equality | 10001 | 1.000 | 0.010 | 0.729 | 0.620 | 0.603 | 0.462 | 0.322 | 0.601 | 0.510 | 0.602 | 0.784 | 0.089 | 0.662 | 0.225 | 0.785 | 2.274 | 0.513 | 0.463 | 0.553 | 0.547 | 0.131 | 0.070 | 0.393 | 0.057 | 0.674 | 0.638 | 0.513 |
| Ombudsman-triggered constitutional review | federalism | 10051 | 1.000 | 0.009 | 0.776 | 0.652 | 0.559 | 0.397 | 0.375 | 0.603 | 0.539 | 0.601 | 0.792 | 0.073 | 0.638 | 0.201 | 0.102 | 2.752 | 0.754 | 0.586 | 0.560 | 0.568 | 0.110 | 0.049 | 0.337 | 0.061 | 0.651 | 0.619 | 0.528 |
| Ombudsman-triggered constitutional review | speech | 10113 | 1.000 | 0.009 | 0.729 | 0.627 | 0.597 | 0.451 | 0.325 | 0.605 | 0.511 | 0.602 | 0.776 | 0.085 | 0.667 | 0.255 | 0.663 | 2.228 | 0.447 | 0.450 | 0.554 | 0.558 | 0.125 | 0.066 | 0.408 | 0.058 | 0.674 | 0.641 | 0.509 |
| Constitutional public defender access model | administrative_state | 10162 | 1.000 | 0.008 | 0.782 | 0.668 | 0.562 | 0.392 | 0.394 | 0.607 | 0.523 | 0.630 | 0.738 | 0.001 | 0.783 | 0.066 | 0.071 | 2.700 | 0.469 | 0.511 | 0.580 | 0.589 | 0.158 | 0.048 | 0.424 | 0.068 | 0.659 | 0.656 | 0.525 |
| Constitutional public defender access model | criminal_procedure | 10046 | 1.000 | 0.009 | 0.784 | 0.644 | 0.601 | 0.439 | 0.347 | 0.601 | 0.505 | 0.630 | 0.755 | 0.006 | 0.797 | 0.082 | 0.650 | 2.325 | 0.562 | 0.491 | 0.561 | 0.566 | 0.129 | 0.073 | 0.375 | 0.061 | 0.676 | 0.663 | 0.516 |
| Constitutional public defender access model | election_law | 10115 | 1.000 | 0.009 | 0.763 | 0.628 | 0.605 | 0.442 | 0.346 | 0.597 | 0.521 | 0.629 | 0.764 | 0.008 | 0.808 | 0.121 | 0.691 | 2.721 | 0.663 | 0.514 | 0.546 | 0.547 | 0.135 | 0.075 | 0.332 | 0.059 | 0.685 | 0.668 | 0.526 |
| Constitutional public defender access model | emergency_powers | 9912 | 1.000 | 0.009 | 0.769 | 0.644 | 0.584 | 0.431 | 0.393 | 0.603 | 0.514 | 0.630 | 0.750 | 0.018 | 0.866 | 0.155 | 0.401 | 1.984 | 0.531 | 0.491 | 0.570 | 0.575 | 0.125 | 0.063 | 0.390 | 0.064 | 0.666 | 0.654 | 0.516 |
| Constitutional public defender access model | equality | 10001 | 1.000 | 0.009 | 0.795 | 0.642 | 0.611 | 0.462 | 0.322 | 0.600 | 0.499 | 0.630 | 0.754 | 0.009 | 0.789 | 0.084 | 0.796 | 2.274 | 0.513 | 0.463 | 0.563 | 0.577 | 0.125 | 0.072 | 0.382 | 0.060 | 0.683 | 0.666 | 0.514 |
| Constitutional public defender access model | federalism | 10051 | 1.000 | 0.008 | 0.789 | 0.661 | 0.560 | 0.396 | 0.375 | 0.602 | 0.527 | 0.629 | 0.762 | 0.001 | 0.774 | 0.086 | 0.105 | 2.752 | 0.754 | 0.586 | 0.552 | 0.572 | 0.110 | 0.051 | 0.326 | 0.065 | 0.661 | 0.651 | 0.531 |
| Constitutional public defender access model | speech | 10113 | 1.000 | 0.008 | 0.788 | 0.647 | 0.604 | 0.451 | 0.325 | 0.603 | 0.499 | 0.630 | 0.746 | 0.007 | 0.789 | 0.101 | 0.670 | 2.228 | 0.447 | 0.450 | 0.566 | 0.574 | 0.126 | 0.070 | 0.411 | 0.061 | 0.682 | 0.667 | 0.510 |
| Rights-impact statements before review | administrative_state | 10162 | 1.000 | 0.861 | 0.826 | 0.696 | 0.566 | 0.499 | 0.394 | 0.616 | 0.519 | 0.697 | 0.705 | 0.070 | 0.649 | 0.155 | 0.005 | 2.700 | 0.469 | 0.511 | 0.679 | 0.672 | 0.114 | 0.032 | 0.513 | 0.137 | 0.427 | 0.378 | 0.445 |
| Rights-impact statements before review | criminal_procedure | 10046 | 1.000 | 0.864 | 0.790 | 0.674 | 0.583 | 0.547 | 0.347 | 0.613 | 0.493 | 0.698 | 0.717 | 0.090 | 0.682 | 0.255 | 0.387 | 2.325 | 0.562 | 0.491 | 0.646 | 0.643 | 0.090 | 0.041 | 0.464 | 0.132 | 0.442 | 0.386 | 0.433 |
| Rights-impact statements before review | election_law | 10115 | 1.000 | 0.865 | 0.798 | 0.671 | 0.589 | 0.550 | 0.346 | 0.609 | 0.505 | 0.697 | 0.727 | 0.068 | 0.688 | 0.280 | 0.422 | 2.721 | 0.663 | 0.514 | 0.639 | 0.634 | 0.088 | 0.050 | 0.431 | 0.127 | 0.444 | 0.384 | 0.446 |
| Rights-impact statements before review | emergency_powers | 9912 | 1.000 | 0.713 | 0.791 | 0.671 | 0.571 | 0.524 | 0.393 | 0.612 | 0.516 | 0.697 | 0.716 | 0.137 | 0.768 | 0.241 | 0.141 | 1.984 | 0.531 | 0.491 | 0.657 | 0.650 | 0.081 | 0.038 | 0.483 | 0.133 | 0.432 | 0.374 | 0.438 |
| Rights-impact statements before review | equality | 10001 | 1.000 | 0.871 | 0.808 | 0.677 | 0.597 | 0.571 | 0.322 | 0.612 | 0.484 | 0.697 | 0.717 | 0.082 | 0.716 | 0.240 | 0.579 | 2.274 | 0.513 | 0.463 | 0.646 | 0.644 | 0.090 | 0.051 | 0.476 | 0.126 | 0.454 | 0.395 | 0.430 |
| Rights-impact statements before review | federalism | 10051 | 1.000 | 0.864 | 0.838 | 0.692 | 0.562 | 0.504 | 0.375 | 0.610 | 0.522 | 0.697 | 0.728 | 0.068 | 0.649 | 0.177 | 0.009 | 2.752 | 0.754 | 0.586 | 0.655 | 0.659 | 0.077 | 0.034 | 0.426 | 0.135 | 0.424 | 0.369 | 0.453 |
| Rights-impact statements before review | speech | 10113 | 1.000 | 0.881 | 0.796 | 0.680 | 0.588 | 0.560 | 0.325 | 0.615 | 0.485 | 0.698 | 0.709 | 0.077 | 0.696 | 0.240 | 0.422 | 2.228 | 0.447 | 0.450 | 0.655 | 0.659 | 0.082 | 0.041 | 0.501 | 0.129 | 0.442 | 0.385 | 0.427 |
| Mandatory legislative response cycles | administrative_state | 10162 | 1.000 | 0.899 | 0.762 | 0.691 | 0.563 | 0.502 | 0.394 | 0.627 | 0.293 | 0.614 | 0.912 | 0.001 | 0.779 | 0.034 | 0.033 | 2.700 | 0.469 | 0.511 | 0.665 | 0.661 | 0.121 | 0.035 | 0.492 | 0.137 | 0.436 | 0.440 | 0.400 |
| Mandatory legislative response cycles | criminal_procedure | 10046 | 1.000 | 0.902 | 0.701 | 0.673 | 0.600 | 0.549 | 0.347 | 0.625 | 0.192 | 0.614 | 0.921 | 0.005 | 0.806 | 0.092 | 0.537 | 2.325 | 0.562 | 0.491 | 0.631 | 0.639 | 0.097 | 0.063 | 0.449 | 0.128 | 0.449 | 0.449 | 0.392 |
| Mandatory legislative response cycles | election_law | 10115 | 1.000 | 0.902 | 0.691 | 0.661 | 0.606 | 0.553 | 0.346 | 0.620 | 0.199 | 0.613 | 0.931 | 0.007 | 0.793 | 0.115 | 0.594 | 2.721 | 0.663 | 0.514 | 0.616 | 0.625 | 0.097 | 0.066 | 0.413 | 0.123 | 0.456 | 0.450 | 0.405 |
| Mandatory legislative response cycles | emergency_powers | 9912 | 1.000 | 0.749 | 0.719 | 0.675 | 0.579 | 0.528 | 0.393 | 0.625 | 0.244 | 0.614 | 0.919 | 0.013 | 0.867 | 0.122 | 0.266 | 1.984 | 0.531 | 0.491 | 0.632 | 0.642 | 0.097 | 0.047 | 0.463 | 0.132 | 0.439 | 0.435 | 0.395 |
| Mandatory legislative response cycles | equality | 10001 | 1.000 | 0.904 | 0.697 | 0.672 | 0.613 | 0.573 | 0.322 | 0.624 | 0.157 | 0.614 | 0.920 | 0.008 | 0.805 | 0.115 | 0.712 | 2.274 | 0.513 | 0.463 | 0.627 | 0.635 | 0.093 | 0.062 | 0.448 | 0.125 | 0.460 | 0.456 | 0.391 |
| Mandatory legislative response cycles | federalism | 10051 | 1.000 | 0.898 | 0.774 | 0.688 | 0.561 | 0.507 | 0.375 | 0.621 | 0.295 | 0.613 | 0.934 | 0.001 | 0.800 | 0.043 | 0.054 | 2.752 | 0.754 | 0.586 | 0.637 | 0.652 | 0.077 | 0.046 | 0.406 | 0.130 | 0.434 | 0.430 | 0.407 |
| Mandatory legislative response cycles | speech | 10113 | 1.000 | 0.909 | 0.703 | 0.676 | 0.602 | 0.562 | 0.325 | 0.627 | 0.180 | 0.614 | 0.913 | 0.006 | 0.796 | 0.088 | 0.562 | 2.228 | 0.447 | 0.450 | 0.644 | 0.644 | 0.095 | 0.053 | 0.484 | 0.128 | 0.453 | 0.452 | 0.386 |

## Pipeline Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Dem. const. | Resp. cred. | Access | Gov. adv. | Impl. cap. | Veto reloc. | Transplant | Culture sens. | Emerg. irr. | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust input | Conflict index | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.706 | 0.584 | 0.544 | 0.420 | 0.370 | 0.611 | 0.535 | 0.642 | 0.719 | 0.377 | 0.021 | 0.539 | 0.303 | 3.000 | 0.394 | 0.479 | 0.429 | 0.433 | 0.188 | 0.067 | 0.338 | 0.030 | 0.896 | 0.843 | 0.460 |
| Current-style federal supreme court | federal/circuit_panel | 14998 | 1.000 | 0.023 | 0.696 | 0.577 | 0.547 | 0.438 | 0.353 | 0.613 | 0.518 | 0.643 | 0.720 | 0.397 | 0.027 | 0.563 | 0.428 | 2.000 | 0.409 | 0.439 | 0.427 | 0.419 | 0.177 | 0.064 | 0.320 | 0.028 | 0.901 | 0.847 | 0.439 |
| Current-style federal supreme court | federal/district_only | 3975 | 1.000 | 0.023 | 0.690 | 0.571 | 0.545 | 0.443 | 0.355 | 0.615 | 0.507 | 0.644 | 0.722 | 0.455 | 0.030 | 0.589 | 0.440 | 1.000 | 0.407 | 0.411 | 0.413 | 0.418 | 0.169 | 0.064 | 0.329 | 0.031 | 0.894 | 0.834 | 0.420 |
| Current-style federal supreme court | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.691 | 0.574 | 0.553 | 0.423 | 0.359 | 0.610 | 0.542 | 0.643 | 0.726 | 0.352 | 0.018 | 0.553 | 0.412 | 3.000 | 0.531 | 0.515 | 0.413 | 0.434 | 0.161 | 0.079 | 0.316 | 0.030 | 0.892 | 0.834 | 0.463 |
| Current-style federal supreme court | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.025 | 0.686 | 0.560 | 0.539 | 0.422 | 0.367 | 0.602 | 0.540 | 0.641 | 0.754 | 0.387 | 0.023 | 0.558 | 0.405 | 3.000 | 0.762 | 0.569 | 0.387 | 0.396 | 0.200 | 0.074 | 0.169 | 0.026 | 0.910 | 0.852 | 0.465 |
| Current-style federal supreme court | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.660 | 0.532 | 0.532 | 0.433 | 0.393 | 0.603 | 0.520 | 0.643 | 0.758 | 0.579 | 0.039 | 0.621 | 0.405 | 1.000 | 0.739 | 0.512 | 0.383 | 0.370 | 0.195 | 0.063 | 0.153 | 0.026 | 0.905 | 0.840 | 0.430 |
| Current-style federal supreme court | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.025 | 0.671 | 0.550 | 0.543 | 0.430 | 0.357 | 0.600 | 0.540 | 0.641 | 0.758 | 0.392 | 0.024 | 0.572 | 0.522 | 3.000 | 0.787 | 0.586 | 0.379 | 0.386 | 0.190 | 0.075 | 0.153 | 0.026 | 0.909 | 0.849 | 0.466 |
| Current-style federal supreme court | state/circuit_en_banc | 588 | 1.000 | 0.023 | 0.739 | 0.607 | 0.532 | 0.394 | 0.398 | 0.611 | 0.544 | 0.641 | 0.723 | 0.345 | 0.047 | 0.519 | 0.091 | 3.000 | 0.475 | 0.521 | 0.437 | 0.437 | 0.233 | 0.056 | 0.247 | 0.031 | 0.890 | 0.834 | 0.464 |
| Current-style federal supreme court | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.696 | 0.573 | 0.542 | 0.433 | 0.355 | 0.610 | 0.522 | 0.642 | 0.736 | 0.392 | 0.024 | 0.551 | 0.427 | 2.000 | 0.569 | 0.478 | 0.408 | 0.422 | 0.177 | 0.072 | 0.215 | 0.027 | 0.901 | 0.844 | 0.441 |
| Current-style federal supreme court | state/district_only | 893 | 1.000 | 0.024 | 0.679 | 0.551 | 0.533 | 0.434 | 0.391 | 0.608 | 0.519 | 0.643 | 0.740 | 0.571 | 0.043 | 0.619 | 0.314 | 1.000 | 0.538 | 0.462 | 0.395 | 0.377 | 0.191 | 0.062 | 0.202 | 0.033 | 0.900 | 0.838 | 0.427 |
| Current-style federal supreme court | state/state_federal_split | 9332 | 1.000 | 0.025 | 0.678 | 0.560 | 0.547 | 0.431 | 0.354 | 0.604 | 0.536 | 0.641 | 0.740 | 0.387 | 0.027 | 0.551 | 0.499 | 3.000 | 0.597 | 0.535 | 0.400 | 0.400 | 0.178 | 0.069 | 0.204 | 0.027 | 0.905 | 0.848 | 0.463 |
| Current-style federal supreme court | state/state_high_court | 9417 | 1.000 | 0.024 | 0.687 | 0.568 | 0.548 | 0.442 | 0.346 | 0.609 | 0.518 | 0.642 | 0.735 | 0.380 | 0.030 | 0.556 | 0.520 | 2.000 | 0.549 | 0.480 | 0.405 | 0.400 | 0.177 | 0.075 | 0.224 | 0.028 | 0.901 | 0.845 | 0.441 |
| Staggered 18-year nonrenewable terms | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.712 | 0.590 | 0.544 | 0.420 | 0.370 | 0.610 | 0.526 | 0.643 | 0.718 | 0.373 | 0.032 | 0.531 | 0.268 | 3.000 | 0.394 | 0.479 | 0.432 | 0.440 | 0.182 | 0.063 | 0.340 | 0.032 | 0.882 | 0.826 | 0.465 |
| Staggered 18-year nonrenewable terms | federal/circuit_panel | 14998 | 1.000 | 0.023 | 0.702 | 0.583 | 0.547 | 0.438 | 0.353 | 0.613 | 0.509 | 0.644 | 0.720 | 0.396 | 0.035 | 0.545 | 0.392 | 2.000 | 0.409 | 0.439 | 0.431 | 0.423 | 0.177 | 0.065 | 0.332 | 0.030 | 0.887 | 0.828 | 0.443 |
| Staggered 18-year nonrenewable terms | federal/district_only | 3975 | 1.000 | 0.023 | 0.697 | 0.578 | 0.545 | 0.443 | 0.355 | 0.615 | 0.499 | 0.645 | 0.721 | 0.444 | 0.028 | 0.567 | 0.400 | 1.000 | 0.407 | 0.411 | 0.411 | 0.415 | 0.161 | 0.070 | 0.337 | 0.034 | 0.877 | 0.813 | 0.425 |
| Staggered 18-year nonrenewable terms | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.707 | 0.586 | 0.553 | 0.423 | 0.359 | 0.610 | 0.533 | 0.644 | 0.724 | 0.328 | 0.021 | 0.507 | 0.366 | 3.000 | 0.531 | 0.515 | 0.453 | 0.437 | 0.174 | 0.071 | 0.312 | 0.031 | 0.874 | 0.813 | 0.468 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.025 | 0.695 | 0.567 | 0.538 | 0.422 | 0.367 | 0.601 | 0.530 | 0.641 | 0.753 | 0.387 | 0.030 | 0.572 | 0.356 | 3.000 | 0.762 | 0.569 | 0.378 | 0.397 | 0.193 | 0.070 | 0.173 | 0.028 | 0.896 | 0.834 | 0.470 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.674 | 0.543 | 0.530 | 0.433 | 0.393 | 0.603 | 0.512 | 0.643 | 0.757 | 0.574 | 0.042 | 0.607 | 0.327 | 1.000 | 0.739 | 0.512 | 0.373 | 0.381 | 0.171 | 0.058 | 0.177 | 0.028 | 0.890 | 0.821 | 0.435 |
| Staggered 18-year nonrenewable terms | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.025 | 0.679 | 0.557 | 0.543 | 0.430 | 0.357 | 0.600 | 0.530 | 0.641 | 0.758 | 0.387 | 0.033 | 0.550 | 0.480 | 3.000 | 0.787 | 0.586 | 0.383 | 0.385 | 0.189 | 0.078 | 0.165 | 0.027 | 0.896 | 0.832 | 0.471 |
| Staggered 18-year nonrenewable terms | state/circuit_en_banc | 588 | 1.000 | 0.023 | 0.741 | 0.614 | 0.531 | 0.394 | 0.398 | 0.612 | 0.536 | 0.642 | 0.722 | 0.325 | 0.033 | 0.453 | 0.041 | 3.000 | 0.475 | 0.521 | 0.452 | 0.461 | 0.216 | 0.065 | 0.296 | 0.033 | 0.879 | 0.819 | 0.468 |
| Staggered 18-year nonrenewable terms | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.703 | 0.580 | 0.543 | 0.433 | 0.355 | 0.610 | 0.513 | 0.643 | 0.735 | 0.384 | 0.033 | 0.534 | 0.390 | 2.000 | 0.569 | 0.478 | 0.418 | 0.421 | 0.170 | 0.069 | 0.229 | 0.029 | 0.889 | 0.828 | 0.446 |
| Staggered 18-year nonrenewable terms | state/district_only | 893 | 1.000 | 0.024 | 0.684 | 0.556 | 0.533 | 0.434 | 0.391 | 0.607 | 0.511 | 0.643 | 0.739 | 0.563 | 0.031 | 0.612 | 0.277 | 1.000 | 0.538 | 0.462 | 0.366 | 0.400 | 0.184 | 0.059 | 0.225 | 0.036 | 0.889 | 0.822 | 0.432 |
| Staggered 18-year nonrenewable terms | state/state_federal_split | 9332 | 1.000 | 0.025 | 0.686 | 0.566 | 0.547 | 0.431 | 0.354 | 0.604 | 0.527 | 0.642 | 0.740 | 0.387 | 0.039 | 0.567 | 0.465 | 3.000 | 0.597 | 0.535 | 0.396 | 0.394 | 0.177 | 0.073 | 0.205 | 0.028 | 0.892 | 0.830 | 0.468 |
| Staggered 18-year nonrenewable terms | state/state_high_court | 9417 | 1.000 | 0.024 | 0.694 | 0.574 | 0.547 | 0.442 | 0.346 | 0.609 | 0.509 | 0.643 | 0.734 | 0.377 | 0.036 | 0.550 | 0.481 | 2.000 | 0.549 | 0.480 | 0.422 | 0.416 | 0.170 | 0.072 | 0.230 | 0.029 | 0.888 | 0.826 | 0.446 |
| Fifteen-justice supermajority commission court | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.747 | 0.652 | 0.568 | 0.420 | 0.370 | 0.615 | 0.442 | 0.643 | 0.708 | 0.089 | 0.681 | 0.220 | 0.321 | 3.000 | 0.394 | 0.479 | 0.589 | 0.586 | 0.130 | 0.047 | 0.470 | 0.063 | 0.630 | 0.597 | 0.481 |
| Fifteen-justice supermajority commission court | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.743 | 0.648 | 0.575 | 0.438 | 0.353 | 0.618 | 0.425 | 0.644 | 0.710 | 0.093 | 0.680 | 0.275 | 0.440 | 2.000 | 0.409 | 0.439 | 0.583 | 0.579 | 0.117 | 0.055 | 0.469 | 0.061 | 0.633 | 0.598 | 0.459 |
| Fifteen-justice supermajority commission court | federal/district_only | 3975 | 1.000 | 0.022 | 0.737 | 0.646 | 0.573 | 0.443 | 0.355 | 0.621 | 0.415 | 0.645 | 0.709 | 0.111 | 0.710 | 0.279 | 0.418 | 1.000 | 0.407 | 0.411 | 0.591 | 0.591 | 0.104 | 0.054 | 0.480 | 0.069 | 0.625 | 0.586 | 0.441 |
| Fifteen-justice supermajority commission court | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.748 | 0.648 | 0.576 | 0.423 | 0.359 | 0.614 | 0.449 | 0.644 | 0.715 | 0.076 | 0.646 | 0.251 | 0.399 | 3.000 | 0.531 | 0.515 | 0.601 | 0.577 | 0.100 | 0.057 | 0.461 | 0.068 | 0.601 | 0.571 | 0.484 |
| Fifteen-justice supermajority commission court | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.745 | 0.635 | 0.564 | 0.422 | 0.367 | 0.607 | 0.447 | 0.641 | 0.742 | 0.087 | 0.674 | 0.326 | 0.406 | 3.000 | 0.762 | 0.569 | 0.535 | 0.541 | 0.134 | 0.063 | 0.305 | 0.057 | 0.657 | 0.620 | 0.485 |
| Fifteen-justice supermajority commission court | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.731 | 0.625 | 0.559 | 0.433 | 0.393 | 0.612 | 0.428 | 0.643 | 0.741 | 0.153 | 0.694 | 0.337 | 0.358 | 1.000 | 0.739 | 0.512 | 0.542 | 0.521 | 0.138 | 0.066 | 0.292 | 0.058 | 0.670 | 0.626 | 0.451 |
| Fifteen-justice supermajority commission court | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.735 | 0.625 | 0.572 | 0.429 | 0.357 | 0.605 | 0.447 | 0.641 | 0.747 | 0.090 | 0.717 | 0.255 | 0.538 | 3.000 | 0.787 | 0.586 | 0.530 | 0.539 | 0.133 | 0.065 | 0.296 | 0.055 | 0.663 | 0.620 | 0.487 |
| Fifteen-justice supermajority commission court | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.759 | 0.668 | 0.549 | 0.393 | 0.398 | 0.616 | 0.451 | 0.642 | 0.713 | 0.076 | 0.521 | 0.145 | 0.034 | 3.000 | 0.475 | 0.521 | 0.602 | 0.587 | 0.145 | 0.048 | 0.420 | 0.066 | 0.637 | 0.605 | 0.484 |
| Fifteen-justice supermajority commission court | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.745 | 0.645 | 0.570 | 0.433 | 0.355 | 0.615 | 0.429 | 0.643 | 0.725 | 0.089 | 0.648 | 0.256 | 0.439 | 2.000 | 0.569 | 0.478 | 0.548 | 0.576 | 0.126 | 0.064 | 0.371 | 0.059 | 0.649 | 0.613 | 0.462 |
| Fifteen-justice supermajority commission court | state/district_only | 893 | 1.000 | 0.023 | 0.737 | 0.643 | 0.558 | 0.433 | 0.391 | 0.617 | 0.427 | 0.643 | 0.723 | 0.142 | 0.696 | 0.298 | 0.249 | 1.000 | 0.538 | 0.462 | 0.574 | 0.531 | 0.139 | 0.055 | 0.366 | 0.065 | 0.646 | 0.599 | 0.448 |
| Fifteen-justice supermajority commission court | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.738 | 0.634 | 0.575 | 0.431 | 0.354 | 0.609 | 0.444 | 0.642 | 0.729 | 0.090 | 0.684 | 0.273 | 0.514 | 3.000 | 0.597 | 0.535 | 0.560 | 0.563 | 0.121 | 0.058 | 0.342 | 0.057 | 0.652 | 0.614 | 0.484 |
| Fifteen-justice supermajority commission court | state/state_high_court | 9417 | 1.000 | 0.023 | 0.740 | 0.640 | 0.576 | 0.442 | 0.346 | 0.614 | 0.425 | 0.643 | 0.724 | 0.087 | 0.695 | 0.274 | 0.531 | 2.000 | 0.549 | 0.480 | 0.566 | 0.564 | 0.121 | 0.059 | 0.362 | 0.059 | 0.649 | 0.611 | 0.461 |
| Supermajority required to invalidate laws | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.745 | 0.648 | 0.558 | 0.420 | 0.370 | 0.614 | 0.451 | 0.642 | 0.712 | 0.090 | 0.612 | 0.366 | 0.302 | 3.000 | 0.394 | 0.479 | 0.586 | 0.590 | 0.129 | 0.050 | 0.457 | 0.061 | 0.638 | 0.607 | 0.467 |
| Supermajority required to invalidate laws | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.739 | 0.644 | 0.564 | 0.438 | 0.353 | 0.617 | 0.434 | 0.643 | 0.713 | 0.097 | 0.643 | 0.303 | 0.404 | 2.000 | 0.409 | 0.439 | 0.582 | 0.580 | 0.120 | 0.053 | 0.466 | 0.059 | 0.642 | 0.609 | 0.446 |
| Supermajority required to invalidate laws | federal/district_only | 3975 | 1.000 | 0.022 | 0.733 | 0.642 | 0.563 | 0.443 | 0.355 | 0.620 | 0.424 | 0.644 | 0.713 | 0.115 | 0.642 | 0.272 | 0.396 | 1.000 | 0.407 | 0.411 | 0.594 | 0.572 | 0.113 | 0.053 | 0.471 | 0.067 | 0.633 | 0.595 | 0.427 |
| Supermajority required to invalidate laws | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.744 | 0.643 | 0.567 | 0.423 | 0.359 | 0.613 | 0.458 | 0.643 | 0.719 | 0.080 | 0.561 | 0.276 | 0.373 | 3.000 | 0.531 | 0.515 | 0.585 | 0.576 | 0.115 | 0.055 | 0.445 | 0.066 | 0.611 | 0.578 | 0.470 |
| Supermajority required to invalidate laws | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.741 | 0.630 | 0.555 | 0.422 | 0.367 | 0.606 | 0.456 | 0.640 | 0.746 | 0.094 | 0.644 | 0.321 | 0.396 | 3.000 | 0.762 | 0.569 | 0.548 | 0.541 | 0.139 | 0.058 | 0.300 | 0.054 | 0.665 | 0.627 | 0.472 |
| Supermajority required to invalidate laws | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.722 | 0.618 | 0.549 | 0.433 | 0.393 | 0.611 | 0.438 | 0.642 | 0.745 | 0.163 | 0.650 | 0.292 | 0.331 | 1.000 | 0.739 | 0.512 | 0.525 | 0.521 | 0.146 | 0.056 | 0.273 | 0.056 | 0.672 | 0.626 | 0.437 |
| Supermajority required to invalidate laws | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.733 | 0.621 | 0.563 | 0.429 | 0.357 | 0.604 | 0.456 | 0.640 | 0.751 | 0.093 | 0.666 | 0.300 | 0.519 | 3.000 | 0.787 | 0.586 | 0.526 | 0.526 | 0.138 | 0.066 | 0.286 | 0.052 | 0.670 | 0.628 | 0.473 |
| Supermajority required to invalidate laws | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.757 | 0.663 | 0.541 | 0.393 | 0.398 | 0.614 | 0.461 | 0.641 | 0.717 | 0.086 | 0.476 | 0.181 | 0.029 | 3.000 | 0.475 | 0.521 | 0.575 | 0.578 | 0.145 | 0.049 | 0.367 | 0.061 | 0.642 | 0.614 | 0.471 |
| Supermajority required to invalidate laws | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.742 | 0.640 | 0.560 | 0.433 | 0.355 | 0.613 | 0.438 | 0.642 | 0.728 | 0.094 | 0.661 | 0.261 | 0.415 | 2.000 | 0.569 | 0.478 | 0.563 | 0.570 | 0.111 | 0.056 | 0.365 | 0.056 | 0.657 | 0.621 | 0.448 |
| Supermajority required to invalidate laws | state/district_only | 893 | 1.000 | 0.023 | 0.730 | 0.636 | 0.548 | 0.433 | 0.391 | 0.615 | 0.436 | 0.642 | 0.727 | 0.153 | 0.642 | 0.277 | 0.204 | 1.000 | 0.538 | 0.462 | 0.558 | 0.561 | 0.118 | 0.054 | 0.364 | 0.062 | 0.657 | 0.615 | 0.435 |
| Supermajority required to invalidate laws | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.735 | 0.630 | 0.566 | 0.431 | 0.354 | 0.608 | 0.453 | 0.641 | 0.733 | 0.093 | 0.661 | 0.300 | 0.497 | 3.000 | 0.597 | 0.535 | 0.556 | 0.553 | 0.129 | 0.068 | 0.341 | 0.055 | 0.659 | 0.624 | 0.471 |
| Supermajority required to invalidate laws | state/state_high_court | 9417 | 1.000 | 0.023 | 0.737 | 0.636 | 0.566 | 0.442 | 0.346 | 0.613 | 0.434 | 0.642 | 0.728 | 0.091 | 0.656 | 0.286 | 0.502 | 2.000 | 0.549 | 0.480 | 0.562 | 0.565 | 0.122 | 0.063 | 0.352 | 0.057 | 0.657 | 0.620 | 0.448 |
| Strict recusal with substitute justices | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.747 | 0.657 | 0.575 | 0.420 | 0.370 | 0.612 | 0.440 | 0.642 | 0.711 | 0.084 | 0.742 | 0.239 | 0.306 | 3.000 | 0.394 | 0.479 | 0.612 | 0.601 | 0.123 | 0.044 | 0.480 | 0.073 | 0.593 | 0.560 | 0.486 |
| Strict recusal with substitute justices | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.742 | 0.652 | 0.582 | 0.438 | 0.353 | 0.615 | 0.423 | 0.643 | 0.713 | 0.093 | 0.714 | 0.278 | 0.423 | 2.000 | 0.409 | 0.439 | 0.607 | 0.602 | 0.113 | 0.053 | 0.485 | 0.070 | 0.594 | 0.560 | 0.465 |
| Strict recusal with substitute justices | federal/district_only | 3975 | 1.000 | 0.022 | 0.737 | 0.652 | 0.580 | 0.443 | 0.355 | 0.618 | 0.413 | 0.644 | 0.712 | 0.106 | 0.705 | 0.260 | 0.402 | 1.000 | 0.407 | 0.411 | 0.607 | 0.604 | 0.107 | 0.050 | 0.491 | 0.079 | 0.585 | 0.543 | 0.446 |
| Strict recusal with substitute justices | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.748 | 0.653 | 0.584 | 0.423 | 0.359 | 0.611 | 0.447 | 0.643 | 0.718 | 0.072 | 0.601 | 0.213 | 0.388 | 3.000 | 0.531 | 0.515 | 0.612 | 0.601 | 0.098 | 0.053 | 0.487 | 0.077 | 0.552 | 0.517 | 0.490 |
| Strict recusal with substitute justices | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.745 | 0.639 | 0.571 | 0.422 | 0.367 | 0.603 | 0.444 | 0.641 | 0.745 | 0.088 | 0.679 | 0.292 | 0.386 | 3.000 | 0.762 | 0.569 | 0.565 | 0.561 | 0.122 | 0.059 | 0.324 | 0.064 | 0.620 | 0.581 | 0.491 |
| Strict recusal with substitute justices | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.729 | 0.630 | 0.566 | 0.433 | 0.393 | 0.609 | 0.426 | 0.643 | 0.744 | 0.150 | 0.738 | 0.287 | 0.340 | 1.000 | 0.739 | 0.512 | 0.547 | 0.545 | 0.133 | 0.056 | 0.317 | 0.068 | 0.626 | 0.578 | 0.456 |
| Strict recusal with substitute justices | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.735 | 0.630 | 0.579 | 0.429 | 0.357 | 0.601 | 0.445 | 0.641 | 0.751 | 0.089 | 0.722 | 0.297 | 0.524 | 3.000 | 0.787 | 0.586 | 0.559 | 0.553 | 0.126 | 0.063 | 0.303 | 0.064 | 0.627 | 0.584 | 0.492 |
| Strict recusal with substitute justices | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.761 | 0.673 | 0.558 | 0.393 | 0.398 | 0.612 | 0.450 | 0.642 | 0.716 | 0.080 | 0.517 | 0.188 | 0.038 | 3.000 | 0.475 | 0.521 | 0.614 | 0.645 | 0.129 | 0.037 | 0.430 | 0.073 | 0.595 | 0.557 | 0.490 |
| Strict recusal with substitute justices | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.745 | 0.650 | 0.576 | 0.433 | 0.355 | 0.611 | 0.427 | 0.642 | 0.728 | 0.086 | 0.695 | 0.224 | 0.416 | 2.000 | 0.569 | 0.478 | 0.587 | 0.584 | 0.113 | 0.053 | 0.374 | 0.068 | 0.611 | 0.575 | 0.467 |
| Strict recusal with substitute justices | state/district_only | 893 | 1.000 | 0.023 | 0.737 | 0.648 | 0.566 | 0.433 | 0.391 | 0.613 | 0.425 | 0.643 | 0.726 | 0.138 | 0.707 | 0.255 | 0.227 | 1.000 | 0.538 | 0.462 | 0.602 | 0.573 | 0.115 | 0.039 | 0.392 | 0.073 | 0.612 | 0.568 | 0.454 |
| Strict recusal with substitute justices | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.739 | 0.640 | 0.582 | 0.431 | 0.354 | 0.605 | 0.441 | 0.641 | 0.732 | 0.088 | 0.697 | 0.248 | 0.496 | 3.000 | 0.597 | 0.535 | 0.576 | 0.573 | 0.115 | 0.061 | 0.364 | 0.065 | 0.613 | 0.575 | 0.490 |
| Strict recusal with substitute justices | state/state_high_court | 9417 | 1.000 | 0.023 | 0.740 | 0.644 | 0.583 | 0.442 | 0.346 | 0.610 | 0.423 | 0.642 | 0.727 | 0.085 | 0.718 | 0.286 | 0.517 | 2.000 | 0.549 | 0.480 | 0.590 | 0.586 | 0.115 | 0.059 | 0.379 | 0.068 | 0.610 | 0.573 | 0.467 |
| Reasoned emergency orders with merits follow-up | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.751 | 0.662 | 0.585 | 0.420 | 0.370 | 0.616 | 0.450 | 0.642 | 0.709 | 0.005 | 0.885 | 0.157 | 0.315 | 3.000 | 0.394 | 0.479 | 0.607 | 0.611 | 0.125 | 0.055 | 0.483 | 0.073 | 0.627 | 0.613 | 0.470 |
| Reasoned emergency orders with merits follow-up | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.748 | 0.658 | 0.594 | 0.438 | 0.353 | 0.619 | 0.434 | 0.643 | 0.710 | 0.007 | 0.874 | 0.119 | 0.449 | 2.000 | 0.409 | 0.439 | 0.603 | 0.603 | 0.110 | 0.061 | 0.484 | 0.069 | 0.629 | 0.615 | 0.449 |
| Reasoned emergency orders with merits follow-up | federal/district_only | 3975 | 1.000 | 0.022 | 0.744 | 0.658 | 0.593 | 0.443 | 0.355 | 0.622 | 0.423 | 0.644 | 0.709 | 0.010 | 0.853 | 0.155 | 0.444 | 1.000 | 0.407 | 0.411 | 0.622 | 0.613 | 0.107 | 0.057 | 0.500 | 0.079 | 0.621 | 0.601 | 0.430 |
| Reasoned emergency orders with merits follow-up | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.747 | 0.654 | 0.596 | 0.423 | 0.359 | 0.614 | 0.459 | 0.643 | 0.717 | 0.004 | 0.790 | 0.168 | 0.411 | 3.000 | 0.531 | 0.515 | 0.583 | 0.628 | 0.101 | 0.055 | 0.464 | 0.078 | 0.598 | 0.586 | 0.474 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.746 | 0.643 | 0.584 | 0.421 | 0.367 | 0.607 | 0.457 | 0.641 | 0.743 | 0.006 | 0.870 | 0.158 | 0.418 | 3.000 | 0.762 | 0.569 | 0.561 | 0.569 | 0.136 | 0.067 | 0.311 | 0.065 | 0.649 | 0.627 | 0.475 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.735 | 0.639 | 0.580 | 0.433 | 0.393 | 0.614 | 0.438 | 0.643 | 0.740 | 0.017 | 0.870 | 0.192 | 0.387 | 1.000 | 0.739 | 0.512 | 0.569 | 0.539 | 0.109 | 0.063 | 0.312 | 0.067 | 0.665 | 0.641 | 0.440 |
| Reasoned emergency orders with merits follow-up | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.737 | 0.634 | 0.592 | 0.429 | 0.357 | 0.605 | 0.459 | 0.641 | 0.749 | 0.007 | 0.878 | 0.170 | 0.547 | 3.000 | 0.787 | 0.586 | 0.563 | 0.559 | 0.134 | 0.071 | 0.304 | 0.063 | 0.661 | 0.636 | 0.477 |
| Reasoned emergency orders with merits follow-up | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.761 | 0.677 | 0.564 | 0.393 | 0.398 | 0.617 | 0.459 | 0.641 | 0.713 | 0.001 | 0.835 | 0.079 | 0.066 | 3.000 | 0.475 | 0.521 | 0.605 | 0.595 | 0.179 | 0.056 | 0.429 | 0.077 | 0.629 | 0.613 | 0.474 |
| Reasoned emergency orders with merits follow-up | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.750 | 0.655 | 0.588 | 0.433 | 0.355 | 0.615 | 0.438 | 0.642 | 0.726 | 0.006 | 0.887 | 0.096 | 0.439 | 2.000 | 0.569 | 0.478 | 0.592 | 0.583 | 0.124 | 0.056 | 0.377 | 0.067 | 0.644 | 0.625 | 0.452 |
| Reasoned emergency orders with merits follow-up | state/district_only | 893 | 1.000 | 0.023 | 0.740 | 0.653 | 0.578 | 0.433 | 0.391 | 0.618 | 0.436 | 0.643 | 0.722 | 0.015 | 0.881 | 0.127 | 0.296 | 1.000 | 0.538 | 0.462 | 0.580 | 0.592 | 0.121 | 0.064 | 0.399 | 0.074 | 0.644 | 0.623 | 0.438 |
| Reasoned emergency orders with merits follow-up | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.742 | 0.643 | 0.596 | 0.431 | 0.354 | 0.609 | 0.454 | 0.641 | 0.730 | 0.007 | 0.881 | 0.096 | 0.522 | 3.000 | 0.597 | 0.535 | 0.577 | 0.590 | 0.125 | 0.073 | 0.357 | 0.066 | 0.648 | 0.629 | 0.474 |
| Reasoned emergency orders with merits follow-up | state/state_high_court | 9417 | 1.000 | 0.023 | 0.745 | 0.648 | 0.597 | 0.442 | 0.346 | 0.614 | 0.435 | 0.642 | 0.725 | 0.006 | 0.904 | 0.112 | 0.553 | 2.000 | 0.549 | 0.480 | 0.586 | 0.583 | 0.124 | 0.068 | 0.379 | 0.067 | 0.649 | 0.629 | 0.451 |
| Panel review with en banc safety valve | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.748 | 0.654 | 0.573 | 0.420 | 0.370 | 0.607 | 0.439 | 0.642 | 0.711 | 0.085 | 0.722 | 0.224 | 0.332 | 3.000 | 0.394 | 0.479 | 0.584 | 0.591 | 0.126 | 0.050 | 0.468 | 0.066 | 0.631 | 0.600 | 0.522 |
| Panel review with en banc safety valve | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.742 | 0.649 | 0.581 | 0.438 | 0.353 | 0.611 | 0.422 | 0.643 | 0.712 | 0.093 | 0.686 | 0.261 | 0.454 | 2.000 | 0.409 | 0.439 | 0.583 | 0.591 | 0.116 | 0.056 | 0.473 | 0.063 | 0.631 | 0.598 | 0.495 |
| Panel review with en banc safety valve | federal/district_only | 3975 | 1.000 | 0.022 | 0.738 | 0.648 | 0.579 | 0.443 | 0.355 | 0.615 | 0.412 | 0.644 | 0.711 | 0.110 | 0.696 | 0.279 | 0.442 | 1.000 | 0.407 | 0.411 | 0.578 | 0.595 | 0.108 | 0.052 | 0.471 | 0.071 | 0.624 | 0.586 | 0.474 |
| Panel review with en banc safety valve | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.749 | 0.650 | 0.581 | 0.423 | 0.359 | 0.605 | 0.445 | 0.643 | 0.718 | 0.071 | 0.559 | 0.201 | 0.397 | 3.000 | 0.531 | 0.515 | 0.592 | 0.586 | 0.096 | 0.057 | 0.481 | 0.070 | 0.601 | 0.569 | 0.532 |
| Panel review with en banc safety valve | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.743 | 0.635 | 0.569 | 0.422 | 0.367 | 0.598 | 0.444 | 0.640 | 0.745 | 0.090 | 0.742 | 0.303 | 0.415 | 3.000 | 0.762 | 0.569 | 0.557 | 0.548 | 0.134 | 0.063 | 0.296 | 0.058 | 0.657 | 0.620 | 0.531 |
| Panel review with en banc safety valve | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.730 | 0.626 | 0.563 | 0.433 | 0.393 | 0.604 | 0.425 | 0.642 | 0.743 | 0.149 | 0.749 | 0.300 | 0.342 | 1.000 | 0.739 | 0.512 | 0.554 | 0.545 | 0.110 | 0.048 | 0.298 | 0.059 | 0.671 | 0.627 | 0.493 |
| Panel review with en banc safety valve | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.734 | 0.626 | 0.577 | 0.429 | 0.357 | 0.596 | 0.444 | 0.640 | 0.750 | 0.089 | 0.659 | 0.264 | 0.542 | 3.000 | 0.787 | 0.586 | 0.537 | 0.541 | 0.132 | 0.067 | 0.285 | 0.057 | 0.662 | 0.620 | 0.534 |
| Panel review with en banc safety valve | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.760 | 0.670 | 0.554 | 0.393 | 0.398 | 0.608 | 0.448 | 0.641 | 0.715 | 0.069 | 0.565 | 0.211 | 0.032 | 3.000 | 0.475 | 0.521 | 0.590 | 0.604 | 0.133 | 0.043 | 0.444 | 0.068 | 0.631 | 0.601 | 0.527 |
| Panel review with en banc safety valve | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.744 | 0.645 | 0.575 | 0.433 | 0.355 | 0.607 | 0.426 | 0.642 | 0.727 | 0.091 | 0.739 | 0.267 | 0.457 | 2.000 | 0.569 | 0.478 | 0.567 | 0.562 | 0.118 | 0.055 | 0.363 | 0.061 | 0.649 | 0.615 | 0.500 |
| Panel review with en banc safety valve | state/district_only | 893 | 1.000 | 0.023 | 0.737 | 0.644 | 0.563 | 0.433 | 0.391 | 0.608 | 0.423 | 0.642 | 0.726 | 0.143 | 0.729 | 0.251 | 0.253 | 1.000 | 0.538 | 0.462 | 0.576 | 0.534 | 0.119 | 0.046 | 0.381 | 0.065 | 0.647 | 0.608 | 0.490 |
| Panel review with en banc safety valve | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.738 | 0.636 | 0.580 | 0.431 | 0.354 | 0.600 | 0.440 | 0.641 | 0.732 | 0.088 | 0.651 | 0.266 | 0.516 | 3.000 | 0.597 | 0.535 | 0.559 | 0.551 | 0.128 | 0.062 | 0.345 | 0.059 | 0.652 | 0.617 | 0.531 |
| Panel review with en banc safety valve | state/state_high_court | 9417 | 1.000 | 0.023 | 0.739 | 0.640 | 0.582 | 0.442 | 0.346 | 0.606 | 0.422 | 0.642 | 0.727 | 0.089 | 0.723 | 0.290 | 0.545 | 2.000 | 0.549 | 0.480 | 0.560 | 0.567 | 0.121 | 0.056 | 0.369 | 0.061 | 0.648 | 0.612 | 0.500 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.752 | 0.657 | 0.579 | 0.420 | 0.370 | 0.586 | 0.602 | 0.638 | 0.723 | 0.007 | 0.879 | 0.099 | 0.223 | 3.000 | 0.394 | 0.479 | 0.648 | 0.638 | 0.112 | 0.043 | 0.522 | 0.092 | 0.527 | 0.489 | 0.600 |
| Dual supreme courts with cross-checking invalidations | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.750 | 0.653 | 0.587 | 0.438 | 0.353 | 0.589 | 0.586 | 0.640 | 0.725 | 0.010 | 0.870 | 0.109 | 0.342 | 2.000 | 0.409 | 0.439 | 0.650 | 0.636 | 0.097 | 0.044 | 0.521 | 0.090 | 0.529 | 0.489 | 0.578 |
| Dual supreme courts with cross-checking invalidations | federal/district_only | 3975 | 1.000 | 0.022 | 0.742 | 0.653 | 0.584 | 0.443 | 0.355 | 0.593 | 0.575 | 0.641 | 0.724 | 0.013 | 0.885 | 0.205 | 0.317 | 1.000 | 0.407 | 0.411 | 0.646 | 0.628 | 0.098 | 0.041 | 0.525 | 0.099 | 0.523 | 0.478 | 0.559 |
| Dual supreme courts with cross-checking invalidations | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.758 | 0.654 | 0.587 | 0.423 | 0.359 | 0.585 | 0.608 | 0.640 | 0.731 | 0.005 | 0.797 | 0.083 | 0.284 | 3.000 | 0.531 | 0.515 | 0.654 | 0.655 | 0.079 | 0.042 | 0.502 | 0.096 | 0.486 | 0.447 | 0.603 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.755 | 0.642 | 0.575 | 0.421 | 0.367 | 0.578 | 0.606 | 0.637 | 0.757 | 0.008 | 0.867 | 0.131 | 0.291 | 3.000 | 0.762 | 0.569 | 0.599 | 0.601 | 0.110 | 0.047 | 0.352 | 0.083 | 0.556 | 0.512 | 0.604 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.733 | 0.635 | 0.566 | 0.433 | 0.393 | 0.584 | 0.588 | 0.639 | 0.754 | 0.021 | 0.809 | 0.158 | 0.192 | 1.000 | 0.739 | 0.512 | 0.602 | 0.583 | 0.110 | 0.045 | 0.337 | 0.089 | 0.564 | 0.522 | 0.569 |
| Dual supreme courts with cross-checking invalidations | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.750 | 0.634 | 0.584 | 0.429 | 0.357 | 0.576 | 0.607 | 0.637 | 0.763 | 0.009 | 0.849 | 0.157 | 0.417 | 3.000 | 0.787 | 0.586 | 0.595 | 0.597 | 0.112 | 0.061 | 0.343 | 0.081 | 0.566 | 0.518 | 0.606 |
| Dual supreme courts with cross-checking invalidations | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.760 | 0.671 | 0.561 | 0.393 | 0.398 | 0.587 | 0.613 | 0.638 | 0.728 | 0.003 | 0.618 | 0.050 | 0.014 | 3.000 | 0.475 | 0.521 | 0.631 | 0.655 | 0.158 | 0.043 | 0.463 | 0.099 | 0.542 | 0.505 | 0.603 |
| Dual supreme courts with cross-checking invalidations | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.753 | 0.651 | 0.581 | 0.433 | 0.355 | 0.586 | 0.589 | 0.639 | 0.740 | 0.008 | 0.894 | 0.116 | 0.329 | 2.000 | 0.569 | 0.478 | 0.627 | 0.623 | 0.101 | 0.046 | 0.415 | 0.086 | 0.551 | 0.509 | 0.581 |
| Dual supreme courts with cross-checking invalidations | state/district_only | 893 | 1.000 | 0.023 | 0.739 | 0.652 | 0.567 | 0.433 | 0.391 | 0.589 | 0.587 | 0.639 | 0.736 | 0.020 | 0.892 | 0.116 | 0.139 | 1.000 | 0.538 | 0.462 | 0.624 | 0.634 | 0.086 | 0.043 | 0.431 | 0.093 | 0.544 | 0.496 | 0.566 |
| Dual supreme courts with cross-checking invalidations | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.751 | 0.643 | 0.587 | 0.431 | 0.354 | 0.580 | 0.603 | 0.638 | 0.745 | 0.009 | 0.899 | 0.115 | 0.401 | 3.000 | 0.597 | 0.535 | 0.615 | 0.616 | 0.099 | 0.055 | 0.403 | 0.084 | 0.551 | 0.507 | 0.603 |
| Dual supreme courts with cross-checking invalidations | state/state_high_court | 9417 | 1.000 | 0.023 | 0.750 | 0.647 | 0.589 | 0.442 | 0.346 | 0.584 | 0.585 | 0.639 | 0.740 | 0.008 | 0.882 | 0.204 | 0.432 | 2.000 | 0.549 | 0.480 | 0.620 | 0.621 | 0.105 | 0.056 | 0.403 | 0.086 | 0.550 | 0.509 | 0.581 |
| Pre-enactment constitutional council | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.747 | 0.654 | 0.579 | 0.420 | 0.370 | 0.599 | 0.669 | 0.641 | 0.718 | 0.082 | 0.750 | 0.232 | 0.244 | 3.000 | 0.394 | 0.479 | 0.656 | 0.652 | 0.106 | 0.038 | 0.539 | 0.102 | 0.478 | 0.431 | 0.543 |
| Pre-enactment constitutional council | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.740 | 0.650 | 0.585 | 0.438 | 0.353 | 0.601 | 0.652 | 0.642 | 0.719 | 0.088 | 0.731 | 0.235 | 0.341 | 2.000 | 0.409 | 0.439 | 0.650 | 0.652 | 0.095 | 0.045 | 0.536 | 0.097 | 0.482 | 0.433 | 0.522 |
| Pre-enactment constitutional council | federal/district_only | 3975 | 1.000 | 0.022 | 0.733 | 0.649 | 0.583 | 0.443 | 0.355 | 0.605 | 0.642 | 0.643 | 0.718 | 0.098 | 0.780 | 0.251 | 0.310 | 1.000 | 0.407 | 0.411 | 0.654 | 0.653 | 0.081 | 0.036 | 0.528 | 0.107 | 0.478 | 0.426 | 0.503 |
| Pre-enactment constitutional council | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.754 | 0.653 | 0.585 | 0.423 | 0.359 | 0.598 | 0.673 | 0.642 | 0.724 | 0.072 | 0.686 | 0.204 | 0.286 | 3.000 | 0.531 | 0.515 | 0.664 | 0.659 | 0.069 | 0.038 | 0.523 | 0.105 | 0.435 | 0.383 | 0.547 |
| Pre-enactment constitutional council | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.748 | 0.638 | 0.573 | 0.422 | 0.367 | 0.590 | 0.672 | 0.640 | 0.752 | 0.085 | 0.762 | 0.226 | 0.302 | 3.000 | 0.762 | 0.569 | 0.609 | 0.614 | 0.108 | 0.051 | 0.372 | 0.090 | 0.510 | 0.458 | 0.548 |
| Pre-enactment constitutional council | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.725 | 0.629 | 0.565 | 0.433 | 0.393 | 0.596 | 0.655 | 0.642 | 0.750 | 0.142 | 0.764 | 0.274 | 0.175 | 1.000 | 0.739 | 0.512 | 0.615 | 0.607 | 0.102 | 0.048 | 0.377 | 0.097 | 0.512 | 0.455 | 0.513 |
| Pre-enactment constitutional council | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.743 | 0.632 | 0.580 | 0.429 | 0.357 | 0.588 | 0.671 | 0.640 | 0.757 | 0.087 | 0.770 | 0.259 | 0.422 | 3.000 | 0.787 | 0.586 | 0.595 | 0.605 | 0.103 | 0.052 | 0.350 | 0.089 | 0.519 | 0.462 | 0.550 |
| Pre-enactment constitutional council | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.759 | 0.665 | 0.564 | 0.393 | 0.398 | 0.599 | 0.680 | 0.640 | 0.723 | 0.065 | 0.663 | 0.201 | 0.010 | 3.000 | 0.475 | 0.521 | 0.624 | 0.658 | 0.122 | 0.046 | 0.468 | 0.103 | 0.485 | 0.439 | 0.547 |
| Pre-enactment constitutional council | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.744 | 0.648 | 0.579 | 0.433 | 0.355 | 0.598 | 0.655 | 0.641 | 0.734 | 0.086 | 0.774 | 0.224 | 0.337 | 2.000 | 0.569 | 0.478 | 0.633 | 0.636 | 0.089 | 0.048 | 0.413 | 0.092 | 0.499 | 0.447 | 0.525 |
| Pre-enactment constitutional council | state/district_only | 893 | 1.000 | 0.023 | 0.731 | 0.645 | 0.566 | 0.433 | 0.391 | 0.600 | 0.654 | 0.642 | 0.732 | 0.130 | 0.754 | 0.263 | 0.109 | 1.000 | 0.538 | 0.462 | 0.638 | 0.635 | 0.091 | 0.043 | 0.436 | 0.098 | 0.501 | 0.442 | 0.510 |
| Pre-enactment constitutional council | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.743 | 0.642 | 0.584 | 0.431 | 0.354 | 0.592 | 0.668 | 0.640 | 0.739 | 0.085 | 0.698 | 0.291 | 0.396 | 3.000 | 0.597 | 0.535 | 0.620 | 0.623 | 0.095 | 0.047 | 0.412 | 0.091 | 0.501 | 0.448 | 0.547 |
| Pre-enactment constitutional council | state/state_high_court | 9417 | 1.000 | 0.023 | 0.739 | 0.645 | 0.585 | 0.442 | 0.346 | 0.597 | 0.651 | 0.641 | 0.734 | 0.082 | 0.732 | 0.268 | 0.419 | 2.000 | 0.549 | 0.480 | 0.626 | 0.623 | 0.094 | 0.052 | 0.431 | 0.093 | 0.500 | 0.448 | 0.524 |
| Judicial review with delayed legislative override | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.745 | 0.648 | 0.568 | 0.420 | 0.370 | 0.611 | 0.441 | 0.642 | 0.715 | 0.089 | 0.638 | 0.249 | 0.344 | 3.000 | 0.394 | 0.479 | 0.574 | 0.573 | 0.139 | 0.052 | 0.461 | 0.059 | 0.665 | 0.632 | 0.476 |
| Judicial review with delayed legislative override | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.738 | 0.642 | 0.575 | 0.438 | 0.353 | 0.613 | 0.424 | 0.643 | 0.716 | 0.096 | 0.655 | 0.278 | 0.451 | 2.000 | 0.409 | 0.439 | 0.571 | 0.565 | 0.125 | 0.056 | 0.451 | 0.056 | 0.668 | 0.635 | 0.455 |
| Judicial review with delayed legislative override | federal/district_only | 3975 | 1.000 | 0.022 | 0.735 | 0.642 | 0.574 | 0.443 | 0.355 | 0.617 | 0.414 | 0.644 | 0.716 | 0.111 | 0.671 | 0.269 | 0.440 | 1.000 | 0.407 | 0.411 | 0.577 | 0.572 | 0.119 | 0.056 | 0.442 | 0.064 | 0.661 | 0.626 | 0.436 |
| Judicial review with delayed legislative override | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.742 | 0.642 | 0.577 | 0.423 | 0.359 | 0.609 | 0.447 | 0.643 | 0.722 | 0.077 | 0.601 | 0.281 | 0.405 | 3.000 | 0.531 | 0.515 | 0.576 | 0.578 | 0.114 | 0.056 | 0.443 | 0.062 | 0.642 | 0.609 | 0.480 |
| Judicial review with delayed legislative override | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.739 | 0.629 | 0.566 | 0.422 | 0.367 | 0.602 | 0.445 | 0.641 | 0.749 | 0.091 | 0.689 | 0.247 | 0.430 | 3.000 | 0.762 | 0.569 | 0.527 | 0.541 | 0.137 | 0.063 | 0.296 | 0.052 | 0.690 | 0.652 | 0.481 |
| Judicial review with delayed legislative override | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.724 | 0.619 | 0.561 | 0.433 | 0.393 | 0.607 | 0.428 | 0.643 | 0.748 | 0.156 | 0.736 | 0.258 | 0.393 | 1.000 | 0.739 | 0.512 | 0.488 | 0.527 | 0.127 | 0.073 | 0.311 | 0.053 | 0.698 | 0.653 | 0.446 |
| Judicial review with delayed legislative override | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.728 | 0.619 | 0.574 | 0.429 | 0.357 | 0.599 | 0.444 | 0.641 | 0.755 | 0.091 | 0.645 | 0.271 | 0.557 | 3.000 | 0.787 | 0.586 | 0.512 | 0.523 | 0.140 | 0.071 | 0.267 | 0.050 | 0.695 | 0.652 | 0.483 |
| Judicial review with delayed legislative override | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.759 | 0.664 | 0.549 | 0.393 | 0.398 | 0.611 | 0.452 | 0.641 | 0.719 | 0.078 | 0.510 | 0.151 | 0.048 | 3.000 | 0.475 | 0.521 | 0.590 | 0.549 | 0.175 | 0.058 | 0.393 | 0.058 | 0.664 | 0.632 | 0.480 |
| Judicial review with delayed legislative override | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.741 | 0.640 | 0.570 | 0.433 | 0.355 | 0.610 | 0.427 | 0.642 | 0.731 | 0.090 | 0.633 | 0.290 | 0.455 | 2.000 | 0.569 | 0.478 | 0.554 | 0.549 | 0.128 | 0.060 | 0.350 | 0.054 | 0.682 | 0.646 | 0.458 |
| Judicial review with delayed legislative override | state/district_only | 893 | 1.000 | 0.023 | 0.736 | 0.638 | 0.559 | 0.433 | 0.391 | 0.612 | 0.426 | 0.643 | 0.729 | 0.143 | 0.694 | 0.286 | 0.264 | 1.000 | 0.538 | 0.462 | 0.546 | 0.538 | 0.130 | 0.058 | 0.351 | 0.058 | 0.683 | 0.641 | 0.444 |
| Judicial review with delayed legislative override | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.731 | 0.628 | 0.577 | 0.431 | 0.354 | 0.604 | 0.442 | 0.641 | 0.737 | 0.091 | 0.694 | 0.252 | 0.536 | 3.000 | 0.597 | 0.535 | 0.531 | 0.537 | 0.134 | 0.063 | 0.330 | 0.053 | 0.686 | 0.649 | 0.480 |
| Judicial review with delayed legislative override | state/state_high_court | 9417 | 1.000 | 0.023 | 0.734 | 0.634 | 0.577 | 0.442 | 0.346 | 0.609 | 0.423 | 0.642 | 0.731 | 0.088 | 0.656 | 0.288 | 0.547 | 2.000 | 0.549 | 0.480 | 0.549 | 0.544 | 0.126 | 0.066 | 0.343 | 0.054 | 0.682 | 0.645 | 0.457 |
| Retention-election accountability court | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.740 | 0.659 | 0.567 | 0.420 | 0.370 | 0.607 | 0.416 | 0.642 | 0.716 | 0.082 | 0.687 | 0.197 | 0.223 | 3.000 | 0.394 | 0.479 | 0.631 | 0.620 | 0.109 | 0.034 | 0.508 | 0.082 | 0.505 | 0.451 | 0.492 |
| Retention-election accountability court | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.729 | 0.654 | 0.572 | 0.438 | 0.353 | 0.610 | 0.398 | 0.643 | 0.717 | 0.087 | 0.682 | 0.235 | 0.308 | 2.000 | 0.409 | 0.439 | 0.624 | 0.619 | 0.099 | 0.040 | 0.503 | 0.080 | 0.508 | 0.451 | 0.471 |
| Retention-election accountability court | federal/district_only | 3975 | 1.000 | 0.022 | 0.722 | 0.654 | 0.570 | 0.443 | 0.355 | 0.614 | 0.389 | 0.644 | 0.716 | 0.098 | 0.693 | 0.262 | 0.279 | 1.000 | 0.407 | 0.411 | 0.624 | 0.615 | 0.093 | 0.048 | 0.510 | 0.090 | 0.503 | 0.443 | 0.451 |
| Retention-election accountability court | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.747 | 0.659 | 0.574 | 0.423 | 0.359 | 0.607 | 0.420 | 0.643 | 0.723 | 0.071 | 0.710 | 0.316 | 0.267 | 3.000 | 0.531 | 0.515 | 0.632 | 0.635 | 0.087 | 0.037 | 0.517 | 0.085 | 0.465 | 0.405 | 0.495 |
| Retention-election accountability court | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.739 | 0.643 | 0.564 | 0.422 | 0.367 | 0.599 | 0.417 | 0.641 | 0.751 | 0.085 | 0.713 | 0.233 | 0.295 | 3.000 | 0.762 | 0.569 | 0.585 | 0.586 | 0.119 | 0.048 | 0.337 | 0.073 | 0.536 | 0.474 | 0.497 |
| Retention-election accountability court | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.723 | 0.637 | 0.552 | 0.433 | 0.393 | 0.605 | 0.404 | 0.642 | 0.748 | 0.142 | 0.689 | 0.232 | 0.159 | 1.000 | 0.739 | 0.512 | 0.562 | 0.601 | 0.097 | 0.036 | 0.347 | 0.079 | 0.542 | 0.480 | 0.461 |
| Retention-election accountability court | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.730 | 0.634 | 0.573 | 0.429 | 0.357 | 0.596 | 0.413 | 0.641 | 0.756 | 0.086 | 0.696 | 0.252 | 0.415 | 3.000 | 0.787 | 0.586 | 0.562 | 0.570 | 0.107 | 0.058 | 0.328 | 0.072 | 0.543 | 0.476 | 0.498 |
| Retention-election accountability court | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.758 | 0.673 | 0.551 | 0.393 | 0.398 | 0.607 | 0.430 | 0.641 | 0.721 | 0.079 | 0.606 | 0.185 | 0.012 | 3.000 | 0.475 | 0.521 | 0.629 | 0.619 | 0.122 | 0.034 | 0.454 | 0.087 | 0.517 | 0.463 | 0.495 |
| Retention-election accountability court | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.732 | 0.653 | 0.567 | 0.433 | 0.355 | 0.607 | 0.401 | 0.642 | 0.733 | 0.086 | 0.699 | 0.222 | 0.294 | 2.000 | 0.569 | 0.478 | 0.594 | 0.603 | 0.098 | 0.047 | 0.390 | 0.078 | 0.528 | 0.470 | 0.473 |
| Retention-election accountability court | state/district_only | 893 | 1.000 | 0.023 | 0.729 | 0.654 | 0.553 | 0.433 | 0.391 | 0.609 | 0.404 | 0.643 | 0.730 | 0.136 | 0.668 | 0.207 | 0.095 | 1.000 | 0.538 | 0.462 | 0.588 | 0.604 | 0.093 | 0.031 | 0.409 | 0.081 | 0.528 | 0.466 | 0.459 |
| Retention-election accountability court | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.732 | 0.646 | 0.574 | 0.431 | 0.354 | 0.601 | 0.412 | 0.641 | 0.737 | 0.083 | 0.703 | 0.266 | 0.373 | 3.000 | 0.597 | 0.535 | 0.591 | 0.580 | 0.105 | 0.050 | 0.387 | 0.074 | 0.526 | 0.465 | 0.496 |
| Retention-election accountability court | state/state_high_court | 9417 | 1.000 | 0.023 | 0.727 | 0.649 | 0.573 | 0.442 | 0.346 | 0.606 | 0.396 | 0.642 | 0.732 | 0.081 | 0.698 | 0.274 | 0.382 | 2.000 | 0.549 | 0.480 | 0.608 | 0.593 | 0.098 | 0.050 | 0.404 | 0.077 | 0.525 | 0.467 | 0.473 |
| Hybrid court balancing independence and accountability | federal/circuit_en_banc | 6748 | 1.000 | 0.023 | 0.752 | 0.670 | 0.581 | 0.420 | 0.370 | 0.593 | 0.438 | 0.639 | 0.723 | 0.004 | 0.899 | 0.079 | 0.245 | 3.000 | 0.394 | 0.479 | 0.639 | 0.647 | 0.112 | 0.045 | 0.519 | 0.100 | 0.523 | 0.505 | 0.554 |
| Hybrid court balancing independence and accountability | federal/circuit_panel | 14998 | 1.000 | 0.022 | 0.750 | 0.667 | 0.590 | 0.438 | 0.353 | 0.597 | 0.422 | 0.641 | 0.724 | 0.006 | 0.866 | 0.121 | 0.383 | 2.000 | 0.409 | 0.439 | 0.641 | 0.639 | 0.102 | 0.050 | 0.520 | 0.097 | 0.522 | 0.503 | 0.525 |
| Hybrid court balancing independence and accountability | federal/district_only | 3975 | 1.000 | 0.022 | 0.743 | 0.667 | 0.589 | 0.443 | 0.355 | 0.602 | 0.412 | 0.642 | 0.722 | 0.009 | 0.902 | 0.144 | 0.369 | 1.000 | 0.407 | 0.411 | 0.641 | 0.634 | 0.102 | 0.050 | 0.521 | 0.106 | 0.517 | 0.491 | 0.504 |
| Hybrid court balancing independence and accountability | federal/state_federal_split | 1500 | 1.000 | 0.024 | 0.756 | 0.668 | 0.588 | 0.423 | 0.359 | 0.591 | 0.444 | 0.640 | 0.730 | 0.004 | 0.831 | 0.086 | 0.293 | 3.000 | 0.531 | 0.515 | 0.671 | 0.622 | 0.092 | 0.049 | 0.520 | 0.103 | 0.474 | 0.455 | 0.564 |
| Hybrid court balancing independence and accountability | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.024 | 0.753 | 0.655 | 0.577 | 0.421 | 0.367 | 0.584 | 0.442 | 0.638 | 0.757 | 0.005 | 0.866 | 0.127 | 0.316 | 3.000 | 0.762 | 0.569 | 0.596 | 0.601 | 0.122 | 0.057 | 0.347 | 0.090 | 0.550 | 0.526 | 0.563 |
| Hybrid court balancing independence and accountability | mixed_state_federal/district_only | 852 | 1.000 | 0.024 | 0.734 | 0.650 | 0.569 | 0.433 | 0.393 | 0.592 | 0.424 | 0.640 | 0.753 | 0.015 | 0.895 | 0.169 | 0.228 | 1.000 | 0.739 | 0.512 | 0.637 | 0.588 | 0.108 | 0.039 | 0.353 | 0.097 | 0.557 | 0.536 | 0.524 |
| Hybrid court balancing independence and accountability | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.024 | 0.748 | 0.647 | 0.585 | 0.429 | 0.357 | 0.581 | 0.443 | 0.638 | 0.762 | 0.006 | 0.905 | 0.131 | 0.440 | 3.000 | 0.787 | 0.586 | 0.594 | 0.600 | 0.111 | 0.060 | 0.347 | 0.088 | 0.557 | 0.527 | 0.566 |
| Hybrid court balancing independence and accountability | state/circuit_en_banc | 588 | 1.000 | 0.022 | 0.760 | 0.684 | 0.562 | 0.393 | 0.398 | 0.593 | 0.448 | 0.639 | 0.728 | 0.001 | 0.669 | 0.076 | 0.032 | 3.000 | 0.475 | 0.521 | 0.651 | 0.619 | 0.131 | 0.044 | 0.468 | 0.105 | 0.523 | 0.505 | 0.559 |
| Hybrid court balancing independence and accountability | state/circuit_panel | 4426 | 1.000 | 0.023 | 0.752 | 0.664 | 0.584 | 0.433 | 0.355 | 0.593 | 0.425 | 0.640 | 0.739 | 0.005 | 0.894 | 0.130 | 0.364 | 2.000 | 0.569 | 0.478 | 0.616 | 0.619 | 0.101 | 0.054 | 0.404 | 0.093 | 0.542 | 0.519 | 0.530 |
| Hybrid court balancing independence and accountability | state/district_only | 893 | 1.000 | 0.023 | 0.740 | 0.666 | 0.569 | 0.433 | 0.391 | 0.596 | 0.422 | 0.640 | 0.735 | 0.014 | 0.899 | 0.169 | 0.160 | 1.000 | 0.538 | 0.462 | 0.654 | 0.626 | 0.094 | 0.035 | 0.421 | 0.100 | 0.540 | 0.510 | 0.521 |
| Hybrid court balancing independence and accountability | state/state_federal_split | 9332 | 1.000 | 0.024 | 0.749 | 0.656 | 0.589 | 0.431 | 0.354 | 0.586 | 0.439 | 0.639 | 0.744 | 0.006 | 0.895 | 0.071 | 0.419 | 3.000 | 0.597 | 0.535 | 0.616 | 0.618 | 0.102 | 0.055 | 0.406 | 0.090 | 0.544 | 0.520 | 0.563 |
| Hybrid court balancing independence and accountability | state/state_high_court | 9417 | 1.000 | 0.023 | 0.749 | 0.659 | 0.592 | 0.442 | 0.346 | 0.592 | 0.422 | 0.640 | 0.739 | 0.006 | 0.886 | 0.193 | 0.472 | 2.000 | 0.549 | 0.480 | 0.621 | 0.622 | 0.103 | 0.056 | 0.414 | 0.092 | 0.544 | 0.522 | 0.531 |
| Weak-form review with legislative reply | federal/circuit_en_banc | 6748 | 1.000 | 0.851 | 0.732 | 0.703 | 0.602 | 0.525 | 0.370 | 0.638 | 0.202 | 0.676 | 0.752 | 0.084 | 0.761 | 0.217 | 0.000 | 3.000 | 0.394 | 0.479 | 0.733 | 0.726 | 0.066 | 0.015 | 0.601 | 0.251 | 0.238 | 0.193 | 0.369 |
| Weak-form review with legislative reply | federal/circuit_panel | 14998 | 1.000 | 0.871 | 0.718 | 0.703 | 0.619 | 0.546 | 0.353 | 0.641 | 0.164 | 0.677 | 0.752 | 0.088 | 0.722 | 0.263 | 0.000 | 2.000 | 0.409 | 0.439 | 0.729 | 0.719 | 0.054 | 0.019 | 0.606 | 0.251 | 0.238 | 0.193 | 0.348 |
| Weak-form review with legislative reply | federal/district_only | 3975 | 1.000 | 0.860 | 0.713 | 0.703 | 0.617 | 0.550 | 0.355 | 0.645 | 0.152 | 0.678 | 0.751 | 0.101 | 0.722 | 0.256 | 0.000 | 1.000 | 0.407 | 0.411 | 0.727 | 0.721 | 0.055 | 0.019 | 0.612 | 0.258 | 0.244 | 0.194 | 0.329 |
| Weak-form review with legislative reply | federal/state_federal_split | 1500 | 1.000 | 0.865 | 0.731 | 0.703 | 0.618 | 0.529 | 0.359 | 0.637 | 0.199 | 0.677 | 0.758 | 0.074 | 0.656 | 0.219 | 0.000 | 3.000 | 0.531 | 0.515 | 0.743 | 0.741 | 0.046 | 0.015 | 0.606 | 0.264 | 0.206 | 0.154 | 0.374 |
| Weak-form review with legislative reply | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.844 | 0.724 | 0.688 | 0.606 | 0.526 | 0.367 | 0.629 | 0.198 | 0.675 | 0.785 | 0.087 | 0.692 | 0.286 | 0.000 | 3.000 | 0.762 | 0.569 | 0.685 | 0.682 | 0.071 | 0.024 | 0.447 | 0.225 | 0.262 | 0.216 | 0.375 |
| Weak-form review with legislative reply | mixed_state_federal/district_only | 852 | 1.000 | 0.746 | 0.710 | 0.679 | 0.592 | 0.528 | 0.393 | 0.634 | 0.188 | 0.677 | 0.784 | 0.142 | 0.705 | 0.271 | 0.000 | 1.000 | 0.739 | 0.512 | 0.691 | 0.697 | 0.079 | 0.021 | 0.458 | 0.220 | 0.262 | 0.203 | 0.342 |
| Weak-form review with legislative reply | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.848 | 0.709 | 0.684 | 0.624 | 0.534 | 0.357 | 0.628 | 0.181 | 0.675 | 0.788 | 0.087 | 0.694 | 0.277 | 0.000 | 3.000 | 0.787 | 0.586 | 0.666 | 0.676 | 0.063 | 0.026 | 0.425 | 0.228 | 0.267 | 0.215 | 0.378 |
| Weak-form review with legislative reply | state/circuit_en_banc | 588 | 1.000 | 0.871 | 0.758 | 0.709 | 0.562 | 0.500 | 0.398 | 0.637 | 0.245 | 0.676 | 0.759 | 0.071 | 0.598 | 0.186 | 0.000 | 3.000 | 0.475 | 0.521 | 0.750 | 0.747 | 0.070 | 0.017 | 0.524 | 0.264 | 0.252 | 0.209 | 0.369 |
| Weak-form review with legislative reply | state/circuit_panel | 4426 | 1.000 | 0.867 | 0.722 | 0.700 | 0.612 | 0.540 | 0.355 | 0.637 | 0.172 | 0.676 | 0.767 | 0.088 | 0.657 | 0.298 | 0.000 | 2.000 | 0.569 | 0.478 | 0.700 | 0.703 | 0.055 | 0.024 | 0.497 | 0.237 | 0.257 | 0.208 | 0.351 |
| Weak-form review with legislative reply | state/district_only | 893 | 1.000 | 0.741 | 0.719 | 0.693 | 0.585 | 0.528 | 0.391 | 0.638 | 0.189 | 0.677 | 0.766 | 0.140 | 0.722 | 0.215 | 0.000 | 1.000 | 0.538 | 0.462 | 0.727 | 0.701 | 0.057 | 0.018 | 0.513 | 0.248 | 0.268 | 0.216 | 0.339 |
| Weak-form review with legislative reply | state/state_federal_split | 9332 | 1.000 | 0.851 | 0.714 | 0.695 | 0.625 | 0.536 | 0.354 | 0.632 | 0.180 | 0.675 | 0.771 | 0.086 | 0.708 | 0.237 | 0.000 | 3.000 | 0.597 | 0.535 | 0.701 | 0.691 | 0.057 | 0.023 | 0.488 | 0.234 | 0.251 | 0.203 | 0.375 |
| Weak-form review with legislative reply | state/state_high_court | 9417 | 1.000 | 0.886 | 0.711 | 0.699 | 0.628 | 0.550 | 0.346 | 0.637 | 0.152 | 0.676 | 0.765 | 0.083 | 0.705 | 0.295 | 0.000 | 2.000 | 0.549 | 0.480 | 0.705 | 0.694 | 0.053 | 0.023 | 0.504 | 0.235 | 0.253 | 0.206 | 0.351 |
| Suspended declarations of invalidity | federal/circuit_en_banc | 6748 | 1.000 | 0.881 | 0.738 | 0.687 | 0.612 | 0.527 | 0.370 | 0.630 | 0.236 | 0.622 | 0.826 | 0.005 | 0.864 | 0.111 | 0.309 | 3.000 | 0.394 | 0.479 | 0.631 | 0.634 | 0.120 | 0.045 | 0.507 | 0.079 | 0.605 | 0.590 | 0.392 |
| Suspended declarations of invalidity | federal/circuit_panel | 14998 | 1.000 | 0.883 | 0.728 | 0.687 | 0.637 | 0.546 | 0.353 | 0.631 | 0.196 | 0.623 | 0.828 | 0.007 | 0.861 | 0.118 | 0.455 | 2.000 | 0.409 | 0.439 | 0.631 | 0.624 | 0.112 | 0.052 | 0.504 | 0.075 | 0.609 | 0.592 | 0.372 |
| Suspended declarations of invalidity | federal/district_only | 3975 | 1.000 | 0.856 | 0.726 | 0.688 | 0.635 | 0.549 | 0.355 | 0.635 | 0.184 | 0.624 | 0.827 | 0.010 | 0.868 | 0.132 | 0.448 | 1.000 | 0.407 | 0.411 | 0.634 | 0.622 | 0.103 | 0.056 | 0.499 | 0.086 | 0.600 | 0.580 | 0.353 |
| Suspended declarations of invalidity | federal/state_federal_split | 1500 | 1.000 | 0.897 | 0.735 | 0.685 | 0.628 | 0.531 | 0.359 | 0.628 | 0.233 | 0.623 | 0.834 | 0.004 | 0.788 | 0.072 | 0.382 | 3.000 | 0.531 | 0.515 | 0.652 | 0.633 | 0.109 | 0.045 | 0.487 | 0.082 | 0.569 | 0.555 | 0.398 |
| Suspended declarations of invalidity | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.879 | 0.724 | 0.671 | 0.620 | 0.528 | 0.367 | 0.620 | 0.229 | 0.621 | 0.861 | 0.005 | 0.865 | 0.112 | 0.403 | 3.000 | 0.762 | 0.569 | 0.581 | 0.588 | 0.127 | 0.062 | 0.323 | 0.070 | 0.633 | 0.610 | 0.399 |
| Suspended declarations of invalidity | mixed_state_federal/district_only | 852 | 1.000 | 0.759 | 0.710 | 0.665 | 0.612 | 0.529 | 0.393 | 0.627 | 0.219 | 0.622 | 0.857 | 0.016 | 0.914 | 0.204 | 0.366 | 1.000 | 0.739 | 0.512 | 0.588 | 0.580 | 0.106 | 0.069 | 0.330 | 0.072 | 0.645 | 0.618 | 0.366 |
| Suspended declarations of invalidity | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.884 | 0.706 | 0.666 | 0.642 | 0.536 | 0.357 | 0.617 | 0.210 | 0.621 | 0.867 | 0.007 | 0.842 | 0.116 | 0.538 | 3.000 | 0.787 | 0.586 | 0.585 | 0.583 | 0.121 | 0.065 | 0.318 | 0.068 | 0.642 | 0.614 | 0.402 |
| Suspended declarations of invalidity | state/circuit_en_banc | 588 | 1.000 | 0.891 | 0.757 | 0.691 | 0.565 | 0.501 | 0.398 | 0.631 | 0.284 | 0.621 | 0.829 | 0.001 | 0.812 | 0.015 | 0.056 | 3.000 | 0.475 | 0.521 | 0.614 | 0.604 | 0.150 | 0.039 | 0.378 | 0.082 | 0.615 | 0.601 | 0.393 |
| Suspended declarations of invalidity | state/circuit_panel | 4426 | 1.000 | 0.883 | 0.727 | 0.683 | 0.629 | 0.540 | 0.355 | 0.628 | 0.202 | 0.622 | 0.843 | 0.006 | 0.886 | 0.150 | 0.440 | 2.000 | 0.569 | 0.478 | 0.603 | 0.605 | 0.103 | 0.059 | 0.388 | 0.071 | 0.628 | 0.610 | 0.375 |
| Suspended declarations of invalidity | state/district_only | 893 | 1.000 | 0.751 | 0.727 | 0.681 | 0.599 | 0.529 | 0.391 | 0.632 | 0.226 | 0.623 | 0.838 | 0.014 | 0.861 | 0.106 | 0.269 | 1.000 | 0.538 | 0.462 | 0.598 | 0.609 | 0.104 | 0.044 | 0.424 | 0.080 | 0.618 | 0.591 | 0.362 |
| Suspended declarations of invalidity | state/state_federal_split | 9332 | 1.000 | 0.882 | 0.717 | 0.677 | 0.643 | 0.538 | 0.354 | 0.621 | 0.209 | 0.621 | 0.849 | 0.006 | 0.866 | 0.161 | 0.513 | 3.000 | 0.597 | 0.535 | 0.604 | 0.600 | 0.115 | 0.061 | 0.380 | 0.071 | 0.631 | 0.609 | 0.399 |
| Suspended declarations of invalidity | state/state_high_court | 9417 | 1.000 | 0.899 | 0.717 | 0.682 | 0.649 | 0.551 | 0.346 | 0.626 | 0.181 | 0.622 | 0.844 | 0.006 | 0.884 | 0.099 | 0.553 | 2.000 | 0.549 | 0.480 | 0.607 | 0.596 | 0.115 | 0.058 | 0.388 | 0.072 | 0.628 | 0.606 | 0.376 |
| Strong-form review with explicit override clause | federal/circuit_en_banc | 6748 | 1.000 | 0.110 | 0.747 | 0.660 | 0.571 | 0.431 | 0.370 | 0.621 | 0.375 | 0.630 | 0.854 | 0.086 | 0.700 | 0.240 | 0.324 | 3.000 | 0.394 | 0.479 | 0.628 | 0.624 | 0.115 | 0.050 | 0.503 | 0.086 | 0.530 | 0.513 | 0.435 |
| Strong-form review with explicit override clause | federal/circuit_panel | 14998 | 1.000 | 0.109 | 0.741 | 0.657 | 0.578 | 0.449 | 0.353 | 0.624 | 0.349 | 0.631 | 0.855 | 0.093 | 0.705 | 0.262 | 0.436 | 2.000 | 0.409 | 0.439 | 0.620 | 0.609 | 0.106 | 0.055 | 0.505 | 0.082 | 0.533 | 0.516 | 0.414 |
| Strong-form review with explicit override clause | federal/district_only | 3975 | 1.000 | 0.107 | 0.735 | 0.656 | 0.575 | 0.454 | 0.355 | 0.628 | 0.340 | 0.632 | 0.854 | 0.106 | 0.746 | 0.277 | 0.402 | 1.000 | 0.407 | 0.411 | 0.619 | 0.614 | 0.097 | 0.045 | 0.511 | 0.090 | 0.527 | 0.506 | 0.395 |
| Strong-form review with explicit override clause | federal/state_federal_split | 1500 | 1.000 | 0.116 | 0.747 | 0.658 | 0.580 | 0.434 | 0.359 | 0.621 | 0.372 | 0.631 | 0.860 | 0.070 | 0.603 | 0.240 | 0.394 | 3.000 | 0.531 | 0.515 | 0.638 | 0.614 | 0.099 | 0.047 | 0.499 | 0.093 | 0.489 | 0.470 | 0.439 |
| Strong-form review with explicit override clause | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.116 | 0.744 | 0.644 | 0.567 | 0.433 | 0.367 | 0.613 | 0.372 | 0.629 | 0.888 | 0.089 | 0.712 | 0.295 | 0.407 | 3.000 | 0.762 | 0.569 | 0.574 | 0.575 | 0.122 | 0.057 | 0.329 | 0.076 | 0.560 | 0.538 | 0.440 |
| Strong-form review with explicit override clause | mixed_state_federal/district_only | 852 | 1.000 | 0.116 | 0.725 | 0.632 | 0.561 | 0.444 | 0.393 | 0.618 | 0.360 | 0.631 | 0.887 | 0.155 | 0.720 | 0.320 | 0.339 | 1.000 | 0.739 | 0.512 | 0.606 | 0.573 | 0.124 | 0.042 | 0.329 | 0.080 | 0.569 | 0.543 | 0.405 |
| Strong-form review with explicit override clause | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.119 | 0.734 | 0.637 | 0.575 | 0.441 | 0.357 | 0.611 | 0.359 | 0.629 | 0.892 | 0.092 | 0.678 | 0.290 | 0.535 | 3.000 | 0.787 | 0.586 | 0.569 | 0.566 | 0.122 | 0.062 | 0.320 | 0.075 | 0.567 | 0.541 | 0.442 |
| Strong-form review with explicit override clause | state/circuit_en_banc | 588 | 1.000 | 0.108 | 0.760 | 0.671 | 0.553 | 0.404 | 0.398 | 0.621 | 0.410 | 0.629 | 0.861 | 0.072 | 0.657 | 0.227 | 0.044 | 3.000 | 0.475 | 0.521 | 0.631 | 0.639 | 0.124 | 0.039 | 0.442 | 0.085 | 0.534 | 0.521 | 0.437 |
| Strong-form review with explicit override clause | state/circuit_panel | 4426 | 1.000 | 0.111 | 0.744 | 0.653 | 0.572 | 0.444 | 0.355 | 0.621 | 0.354 | 0.630 | 0.870 | 0.091 | 0.696 | 0.320 | 0.430 | 2.000 | 0.569 | 0.478 | 0.602 | 0.595 | 0.108 | 0.050 | 0.394 | 0.078 | 0.554 | 0.534 | 0.417 |
| Strong-form review with explicit override clause | state/district_only | 893 | 1.000 | 0.113 | 0.735 | 0.648 | 0.561 | 0.444 | 0.391 | 0.622 | 0.369 | 0.631 | 0.870 | 0.143 | 0.743 | 0.242 | 0.236 | 1.000 | 0.538 | 0.462 | 0.588 | 0.576 | 0.101 | 0.050 | 0.389 | 0.090 | 0.555 | 0.530 | 0.402 |
| Strong-form review with explicit override clause | state/state_federal_split | 9332 | 1.000 | 0.118 | 0.737 | 0.646 | 0.578 | 0.442 | 0.354 | 0.615 | 0.357 | 0.629 | 0.874 | 0.088 | 0.695 | 0.300 | 0.509 | 3.000 | 0.597 | 0.535 | 0.590 | 0.594 | 0.116 | 0.056 | 0.379 | 0.077 | 0.552 | 0.533 | 0.439 |
| Strong-form review with explicit override clause | state/state_high_court | 9417 | 1.000 | 0.113 | 0.738 | 0.651 | 0.579 | 0.453 | 0.346 | 0.620 | 0.339 | 0.630 | 0.869 | 0.086 | 0.686 | 0.258 | 0.519 | 2.000 | 0.549 | 0.480 | 0.592 | 0.594 | 0.112 | 0.056 | 0.394 | 0.078 | 0.552 | 0.532 | 0.417 |
| Pre-enactment review before laws take effect | federal/circuit_en_banc | 6748 | 1.000 | 0.840 | 0.770 | 0.667 | 0.577 | 0.524 | 0.370 | 0.616 | 0.520 | 0.579 | 0.824 | 0.081 | 0.736 | 0.245 | 0.230 | 3.000 | 0.394 | 0.479 | 0.655 | 0.663 | 0.100 | 0.039 | 0.540 | 0.112 | 0.455 | 0.405 | 0.447 |
| Pre-enactment review before laws take effect | federal/circuit_panel | 14998 | 1.000 | 0.841 | 0.767 | 0.665 | 0.581 | 0.543 | 0.353 | 0.618 | 0.503 | 0.580 | 0.826 | 0.088 | 0.751 | 0.252 | 0.315 | 2.000 | 0.409 | 0.439 | 0.654 | 0.661 | 0.086 | 0.039 | 0.537 | 0.108 | 0.456 | 0.404 | 0.426 |
| Pre-enactment review before laws take effect | federal/district_only | 3975 | 1.000 | 0.815 | 0.762 | 0.664 | 0.579 | 0.546 | 0.355 | 0.622 | 0.495 | 0.581 | 0.825 | 0.100 | 0.766 | 0.252 | 0.283 | 1.000 | 0.407 | 0.411 | 0.658 | 0.658 | 0.084 | 0.038 | 0.540 | 0.118 | 0.453 | 0.399 | 0.407 |
| Pre-enactment review before laws take effect | federal/state_federal_split | 1500 | 1.000 | 0.870 | 0.778 | 0.668 | 0.583 | 0.529 | 0.359 | 0.615 | 0.524 | 0.580 | 0.831 | 0.068 | 0.723 | 0.176 | 0.277 | 3.000 | 0.531 | 0.515 | 0.667 | 0.657 | 0.077 | 0.036 | 0.529 | 0.116 | 0.410 | 0.356 | 0.452 |
| Pre-enactment review before laws take effect | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.839 | 0.772 | 0.653 | 0.571 | 0.525 | 0.367 | 0.607 | 0.524 | 0.577 | 0.858 | 0.083 | 0.683 | 0.262 | 0.292 | 3.000 | 0.762 | 0.569 | 0.620 | 0.622 | 0.102 | 0.041 | 0.372 | 0.100 | 0.484 | 0.430 | 0.454 |
| Pre-enactment review before laws take effect | mixed_state_federal/district_only | 852 | 1.000 | 0.712 | 0.756 | 0.642 | 0.561 | 0.524 | 0.393 | 0.612 | 0.518 | 0.579 | 0.857 | 0.147 | 0.745 | 0.263 | 0.141 | 1.000 | 0.739 | 0.512 | 0.604 | 0.616 | 0.092 | 0.046 | 0.367 | 0.101 | 0.488 | 0.428 | 0.423 |
| Pre-enactment review before laws take effect | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.846 | 0.769 | 0.647 | 0.577 | 0.534 | 0.357 | 0.605 | 0.523 | 0.577 | 0.863 | 0.085 | 0.766 | 0.240 | 0.398 | 3.000 | 0.787 | 0.586 | 0.612 | 0.614 | 0.097 | 0.053 | 0.358 | 0.099 | 0.493 | 0.433 | 0.456 |
| Pre-enactment review before laws take effect | state/circuit_en_banc | 588 | 1.000 | 0.862 | 0.770 | 0.675 | 0.562 | 0.499 | 0.398 | 0.616 | 0.529 | 0.578 | 0.830 | 0.072 | 0.625 | 0.114 | 0.016 | 3.000 | 0.475 | 0.521 | 0.679 | 0.667 | 0.129 | 0.032 | 0.466 | 0.122 | 0.470 | 0.424 | 0.448 |
| Pre-enactment review before laws take effect | state/circuit_panel | 4426 | 1.000 | 0.840 | 0.769 | 0.663 | 0.576 | 0.537 | 0.355 | 0.615 | 0.507 | 0.579 | 0.841 | 0.086 | 0.721 | 0.244 | 0.308 | 2.000 | 0.569 | 0.478 | 0.646 | 0.631 | 0.092 | 0.042 | 0.434 | 0.105 | 0.478 | 0.425 | 0.429 |
| Pre-enactment review before laws take effect | state/district_only | 893 | 1.000 | 0.716 | 0.765 | 0.658 | 0.563 | 0.525 | 0.391 | 0.616 | 0.517 | 0.579 | 0.840 | 0.136 | 0.827 | 0.211 | 0.095 | 1.000 | 0.538 | 0.462 | 0.620 | 0.654 | 0.076 | 0.044 | 0.426 | 0.113 | 0.481 | 0.422 | 0.419 |
| Pre-enactment review before laws take effect | state/state_federal_split | 9332 | 1.000 | 0.847 | 0.770 | 0.657 | 0.581 | 0.535 | 0.354 | 0.609 | 0.520 | 0.578 | 0.845 | 0.083 | 0.766 | 0.233 | 0.376 | 3.000 | 0.597 | 0.535 | 0.637 | 0.628 | 0.089 | 0.047 | 0.420 | 0.102 | 0.477 | 0.421 | 0.453 |
| Pre-enactment review before laws take effect | state/state_high_court | 9417 | 1.000 | 0.857 | 0.765 | 0.660 | 0.581 | 0.547 | 0.346 | 0.614 | 0.502 | 0.579 | 0.840 | 0.083 | 0.724 | 0.253 | 0.392 | 2.000 | 0.549 | 0.480 | 0.637 | 0.634 | 0.093 | 0.043 | 0.433 | 0.104 | 0.476 | 0.422 | 0.429 |
| Abstract review tribunal | federal/circuit_en_banc | 6748 | 1.000 | 0.899 | 0.775 | 0.674 | 0.580 | 0.528 | 0.370 | 0.616 | 0.319 | 0.563 | 0.895 | 0.008 | 0.858 | 0.158 | 0.275 | 3.000 | 0.394 | 0.479 | 0.630 | 0.622 | 0.124 | 0.049 | 0.511 | 0.082 | 0.569 | 0.553 | 0.447 |
| Abstract review tribunal | federal/circuit_panel | 14998 | 1.000 | 0.892 | 0.777 | 0.671 | 0.590 | 0.546 | 0.353 | 0.620 | 0.304 | 0.564 | 0.896 | 0.011 | 0.873 | 0.111 | 0.417 | 2.000 | 0.409 | 0.439 | 0.627 | 0.631 | 0.108 | 0.052 | 0.502 | 0.080 | 0.569 | 0.552 | 0.419 |
| Abstract review tribunal | federal/district_only | 3975 | 1.000 | 0.865 | 0.776 | 0.672 | 0.589 | 0.549 | 0.355 | 0.624 | 0.295 | 0.565 | 0.895 | 0.014 | 0.847 | 0.111 | 0.409 | 1.000 | 0.407 | 0.411 | 0.628 | 0.620 | 0.101 | 0.042 | 0.520 | 0.091 | 0.562 | 0.541 | 0.397 |
| Abstract review tribunal | federal/state_federal_split | 1500 | 1.000 | 0.924 | 0.777 | 0.670 | 0.588 | 0.533 | 0.359 | 0.614 | 0.325 | 0.564 | 0.902 | 0.007 | 0.739 | 0.089 | 0.341 | 3.000 | 0.531 | 0.515 | 0.645 | 0.642 | 0.095 | 0.043 | 0.496 | 0.087 | 0.526 | 0.511 | 0.459 |
| Abstract review tribunal | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.904 | 0.773 | 0.657 | 0.578 | 0.530 | 0.367 | 0.607 | 0.325 | 0.562 | 0.928 | 0.008 | 0.770 | 0.105 | 0.365 | 3.000 | 0.762 | 0.569 | 0.586 | 0.591 | 0.121 | 0.055 | 0.343 | 0.073 | 0.597 | 0.574 | 0.458 |
| Abstract review tribunal | mixed_state_federal/district_only | 852 | 1.000 | 0.767 | 0.767 | 0.651 | 0.572 | 0.530 | 0.393 | 0.613 | 0.317 | 0.563 | 0.925 | 0.025 | 0.856 | 0.189 | 0.306 | 1.000 | 0.739 | 0.512 | 0.567 | 0.565 | 0.119 | 0.061 | 0.349 | 0.075 | 0.611 | 0.586 | 0.423 |
| Abstract review tribunal | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.905 | 0.769 | 0.649 | 0.586 | 0.538 | 0.357 | 0.604 | 0.327 | 0.561 | 0.933 | 0.009 | 0.883 | 0.159 | 0.490 | 3.000 | 0.787 | 0.586 | 0.579 | 0.587 | 0.121 | 0.064 | 0.330 | 0.072 | 0.603 | 0.577 | 0.462 |
| Abstract review tribunal | state/circuit_en_banc | 588 | 1.000 | 0.921 | 0.772 | 0.686 | 0.560 | 0.503 | 0.398 | 0.617 | 0.326 | 0.562 | 0.899 | 0.003 | 0.637 | 0.180 | 0.039 | 3.000 | 0.475 | 0.521 | 0.629 | 0.628 | 0.148 | 0.041 | 0.447 | 0.086 | 0.577 | 0.563 | 0.450 |
| Abstract review tribunal | state/circuit_panel | 4426 | 1.000 | 0.898 | 0.778 | 0.667 | 0.584 | 0.541 | 0.355 | 0.616 | 0.307 | 0.563 | 0.911 | 0.009 | 0.761 | 0.127 | 0.405 | 2.000 | 0.569 | 0.478 | 0.606 | 0.602 | 0.119 | 0.056 | 0.396 | 0.075 | 0.587 | 0.568 | 0.424 |
| Abstract review tribunal | state/district_only | 893 | 1.000 | 0.764 | 0.776 | 0.669 | 0.570 | 0.530 | 0.391 | 0.618 | 0.315 | 0.563 | 0.908 | 0.024 | 0.887 | 0.178 | 0.216 | 1.000 | 0.538 | 0.462 | 0.628 | 0.619 | 0.103 | 0.049 | 0.426 | 0.083 | 0.583 | 0.559 | 0.419 |
| Abstract review tribunal | state/state_federal_split | 9332 | 1.000 | 0.907 | 0.773 | 0.658 | 0.590 | 0.540 | 0.354 | 0.608 | 0.322 | 0.562 | 0.916 | 0.009 | 0.784 | 0.095 | 0.469 | 3.000 | 0.597 | 0.535 | 0.595 | 0.599 | 0.107 | 0.066 | 0.380 | 0.075 | 0.592 | 0.572 | 0.458 |
| Abstract review tribunal | state/state_high_court | 9417 | 1.000 | 0.910 | 0.775 | 0.663 | 0.592 | 0.551 | 0.346 | 0.615 | 0.303 | 0.563 | 0.911 | 0.009 | 0.766 | 0.110 | 0.513 | 2.000 | 0.549 | 0.480 | 0.607 | 0.612 | 0.109 | 0.058 | 0.409 | 0.077 | 0.589 | 0.568 | 0.425 |
| Ombudsman-triggered constitutional review | federal/circuit_en_banc | 6748 | 1.000 | 0.009 | 0.746 | 0.643 | 0.580 | 0.419 | 0.370 | 0.606 | 0.530 | 0.602 | 0.766 | 0.088 | 0.713 | 0.249 | 0.357 | 3.000 | 0.394 | 0.479 | 0.590 | 0.581 | 0.140 | 0.054 | 0.464 | 0.063 | 0.651 | 0.623 | 0.526 |
| Ombudsman-triggered constitutional review | federal/circuit_panel | 14998 | 1.000 | 0.009 | 0.741 | 0.638 | 0.588 | 0.437 | 0.353 | 0.608 | 0.515 | 0.603 | 0.768 | 0.094 | 0.716 | 0.257 | 0.487 | 2.000 | 0.409 | 0.439 | 0.573 | 0.575 | 0.125 | 0.060 | 0.462 | 0.060 | 0.654 | 0.623 | 0.507 |
| Ombudsman-triggered constitutional review | federal/district_only | 3975 | 1.000 | 0.009 | 0.738 | 0.637 | 0.587 | 0.442 | 0.355 | 0.611 | 0.504 | 0.604 | 0.768 | 0.108 | 0.733 | 0.271 | 0.490 | 1.000 | 0.407 | 0.411 | 0.581 | 0.593 | 0.107 | 0.059 | 0.463 | 0.068 | 0.649 | 0.614 | 0.489 |
| Ombudsman-triggered constitutional review | federal/state_federal_split | 1500 | 1.000 | 0.009 | 0.747 | 0.640 | 0.588 | 0.421 | 0.359 | 0.605 | 0.536 | 0.603 | 0.773 | 0.072 | 0.690 | 0.245 | 0.423 | 3.000 | 0.531 | 0.515 | 0.573 | 0.596 | 0.095 | 0.058 | 0.458 | 0.067 | 0.620 | 0.589 | 0.529 |
| Ombudsman-triggered constitutional review | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.009 | 0.742 | 0.626 | 0.576 | 0.420 | 0.367 | 0.597 | 0.535 | 0.601 | 0.800 | 0.089 | 0.642 | 0.250 | 0.438 | 3.000 | 0.762 | 0.569 | 0.526 | 0.543 | 0.140 | 0.067 | 0.283 | 0.057 | 0.674 | 0.639 | 0.531 |
| Ombudsman-triggered constitutional review | mixed_state_federal/district_only | 852 | 1.000 | 0.009 | 0.728 | 0.616 | 0.571 | 0.431 | 0.393 | 0.602 | 0.517 | 0.602 | 0.799 | 0.155 | 0.725 | 0.296 | 0.397 | 1.000 | 0.739 | 0.512 | 0.523 | 0.548 | 0.122 | 0.061 | 0.309 | 0.059 | 0.681 | 0.635 | 0.498 |
| Ombudsman-triggered constitutional review | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.010 | 0.731 | 0.616 | 0.583 | 0.428 | 0.357 | 0.595 | 0.536 | 0.601 | 0.805 | 0.091 | 0.738 | 0.248 | 0.563 | 3.000 | 0.787 | 0.586 | 0.539 | 0.535 | 0.136 | 0.070 | 0.285 | 0.055 | 0.679 | 0.640 | 0.533 |
| Ombudsman-triggered constitutional review | state/circuit_en_banc | 588 | 1.000 | 0.008 | 0.761 | 0.662 | 0.560 | 0.392 | 0.398 | 0.607 | 0.537 | 0.601 | 0.770 | 0.073 | 0.633 | 0.172 | 0.050 | 3.000 | 0.475 | 0.521 | 0.594 | 0.568 | 0.141 | 0.036 | 0.410 | 0.068 | 0.644 | 0.613 | 0.527 |
| Ombudsman-triggered constitutional review | state/circuit_panel | 4426 | 1.000 | 0.009 | 0.743 | 0.634 | 0.582 | 0.431 | 0.355 | 0.605 | 0.518 | 0.602 | 0.783 | 0.091 | 0.738 | 0.298 | 0.484 | 2.000 | 0.569 | 0.478 | 0.542 | 0.558 | 0.115 | 0.063 | 0.354 | 0.058 | 0.670 | 0.637 | 0.509 |
| Ombudsman-triggered constitutional review | state/district_only | 893 | 1.000 | 0.009 | 0.738 | 0.633 | 0.571 | 0.432 | 0.391 | 0.607 | 0.515 | 0.603 | 0.781 | 0.147 | 0.711 | 0.302 | 0.296 | 1.000 | 0.538 | 0.462 | 0.558 | 0.568 | 0.128 | 0.057 | 0.326 | 0.063 | 0.667 | 0.624 | 0.495 |
| Ombudsman-triggered constitutional review | state/state_federal_split | 9332 | 1.000 | 0.010 | 0.735 | 0.625 | 0.587 | 0.429 | 0.354 | 0.599 | 0.533 | 0.601 | 0.788 | 0.089 | 0.737 | 0.298 | 0.544 | 3.000 | 0.597 | 0.535 | 0.546 | 0.545 | 0.128 | 0.066 | 0.341 | 0.058 | 0.671 | 0.637 | 0.531 |
| Ombudsman-triggered constitutional review | state/state_high_court | 9417 | 1.000 | 0.009 | 0.738 | 0.630 | 0.589 | 0.440 | 0.346 | 0.604 | 0.515 | 0.602 | 0.783 | 0.087 | 0.715 | 0.243 | 0.572 | 2.000 | 0.549 | 0.480 | 0.560 | 0.563 | 0.125 | 0.061 | 0.361 | 0.059 | 0.667 | 0.633 | 0.509 |
| Constitutional public defender access model | federal/circuit_en_banc | 6748 | 1.000 | 0.008 | 0.781 | 0.659 | 0.584 | 0.418 | 0.370 | 0.605 | 0.518 | 0.630 | 0.736 | 0.005 | 0.863 | 0.088 | 0.337 | 3.000 | 0.394 | 0.479 | 0.586 | 0.589 | 0.137 | 0.056 | 0.460 | 0.067 | 0.659 | 0.653 | 0.528 |
| Constitutional public defender access model | federal/circuit_panel | 14998 | 1.000 | 0.008 | 0.788 | 0.656 | 0.593 | 0.436 | 0.353 | 0.607 | 0.502 | 0.631 | 0.738 | 0.007 | 0.868 | 0.130 | 0.482 | 2.000 | 0.409 | 0.439 | 0.582 | 0.594 | 0.121 | 0.061 | 0.462 | 0.064 | 0.661 | 0.653 | 0.508 |
| Constitutional public defender access model | federal/district_only | 3975 | 1.000 | 0.008 | 0.788 | 0.657 | 0.593 | 0.442 | 0.355 | 0.611 | 0.492 | 0.632 | 0.737 | 0.011 | 0.874 | 0.131 | 0.487 | 1.000 | 0.407 | 0.411 | 0.590 | 0.584 | 0.118 | 0.059 | 0.474 | 0.071 | 0.657 | 0.646 | 0.489 |
| Constitutional public defender access model | federal/state_federal_split | 1500 | 1.000 | 0.008 | 0.775 | 0.652 | 0.592 | 0.421 | 0.359 | 0.604 | 0.525 | 0.631 | 0.743 | 0.004 | 0.728 | 0.170 | 0.402 | 3.000 | 0.531 | 0.515 | 0.592 | 0.594 | 0.101 | 0.055 | 0.443 | 0.071 | 0.630 | 0.625 | 0.531 |
| Constitutional public defender access model | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.008 | 0.777 | 0.641 | 0.580 | 0.420 | 0.367 | 0.596 | 0.523 | 0.629 | 0.770 | 0.006 | 0.863 | 0.111 | 0.413 | 3.000 | 0.762 | 0.569 | 0.545 | 0.554 | 0.139 | 0.063 | 0.301 | 0.060 | 0.685 | 0.672 | 0.533 |
| Constitutional public defender access model | mixed_state_federal/district_only | 852 | 1.000 | 0.009 | 0.770 | 0.637 | 0.578 | 0.431 | 0.393 | 0.603 | 0.505 | 0.630 | 0.767 | 0.018 | 0.851 | 0.205 | 0.399 | 1.000 | 0.739 | 0.512 | 0.534 | 0.545 | 0.123 | 0.070 | 0.289 | 0.062 | 0.686 | 0.667 | 0.499 |
| Constitutional public defender access model | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.009 | 0.772 | 0.633 | 0.589 | 0.428 | 0.357 | 0.594 | 0.526 | 0.629 | 0.775 | 0.007 | 0.900 | 0.126 | 0.549 | 3.000 | 0.787 | 0.586 | 0.527 | 0.541 | 0.141 | 0.071 | 0.281 | 0.058 | 0.691 | 0.671 | 0.535 |
| Constitutional public defender access model | state/circuit_en_banc | 588 | 1.000 | 0.008 | 0.779 | 0.671 | 0.560 | 0.392 | 0.398 | 0.606 | 0.525 | 0.629 | 0.740 | 0.001 | 0.725 | 0.019 | 0.068 | 3.000 | 0.475 | 0.521 | 0.599 | 0.600 | 0.141 | 0.053 | 0.393 | 0.070 | 0.665 | 0.658 | 0.530 |
| Constitutional public defender access model | state/circuit_panel | 4426 | 1.000 | 0.008 | 0.786 | 0.651 | 0.587 | 0.431 | 0.355 | 0.604 | 0.506 | 0.630 | 0.753 | 0.006 | 0.829 | 0.153 | 0.469 | 2.000 | 0.569 | 0.478 | 0.560 | 0.572 | 0.125 | 0.072 | 0.351 | 0.061 | 0.678 | 0.663 | 0.510 |
| Constitutional public defender access model | state/district_only | 893 | 1.000 | 0.008 | 0.775 | 0.652 | 0.576 | 0.432 | 0.391 | 0.607 | 0.503 | 0.631 | 0.749 | 0.017 | 0.863 | 0.117 | 0.312 | 1.000 | 0.538 | 0.462 | 0.568 | 0.564 | 0.140 | 0.064 | 0.362 | 0.066 | 0.670 | 0.650 | 0.495 |
| Constitutional public defender access model | state/state_federal_split | 9332 | 1.000 | 0.009 | 0.776 | 0.641 | 0.593 | 0.429 | 0.354 | 0.598 | 0.521 | 0.629 | 0.757 | 0.007 | 0.868 | 0.141 | 0.526 | 3.000 | 0.597 | 0.535 | 0.555 | 0.562 | 0.130 | 0.065 | 0.341 | 0.060 | 0.681 | 0.668 | 0.532 |
| Constitutional public defender access model | state/state_high_court | 9417 | 1.000 | 0.008 | 0.789 | 0.648 | 0.596 | 0.440 | 0.346 | 0.602 | 0.503 | 0.630 | 0.753 | 0.007 | 0.875 | 0.103 | 0.577 | 2.000 | 0.549 | 0.480 | 0.562 | 0.572 | 0.129 | 0.069 | 0.357 | 0.062 | 0.676 | 0.661 | 0.511 |
| Rights-impact statements before review | federal/circuit_en_banc | 6748 | 1.000 | 0.843 | 0.811 | 0.689 | 0.578 | 0.524 | 0.370 | 0.615 | 0.511 | 0.697 | 0.701 | 0.080 | 0.736 | 0.211 | 0.203 | 3.000 | 0.394 | 0.479 | 0.668 | 0.673 | 0.098 | 0.037 | 0.562 | 0.139 | 0.421 | 0.370 | 0.447 |
| Rights-impact statements before review | federal/circuit_panel | 14998 | 1.000 | 0.847 | 0.804 | 0.686 | 0.582 | 0.543 | 0.353 | 0.618 | 0.494 | 0.698 | 0.702 | 0.084 | 0.769 | 0.249 | 0.277 | 2.000 | 0.409 | 0.439 | 0.674 | 0.672 | 0.082 | 0.038 | 0.555 | 0.135 | 0.422 | 0.368 | 0.425 |
| Rights-impact statements before review | federal/district_only | 3975 | 1.000 | 0.815 | 0.793 | 0.683 | 0.580 | 0.546 | 0.355 | 0.621 | 0.486 | 0.699 | 0.701 | 0.101 | 0.769 | 0.240 | 0.249 | 1.000 | 0.407 | 0.411 | 0.677 | 0.669 | 0.072 | 0.034 | 0.553 | 0.145 | 0.423 | 0.364 | 0.407 |
| Rights-impact statements before review | federal/state_federal_split | 1500 | 1.000 | 0.863 | 0.818 | 0.689 | 0.584 | 0.528 | 0.359 | 0.614 | 0.515 | 0.698 | 0.707 | 0.069 | 0.650 | 0.263 | 0.249 | 3.000 | 0.531 | 0.515 | 0.693 | 0.689 | 0.081 | 0.025 | 0.550 | 0.149 | 0.376 | 0.319 | 0.452 |
| Rights-impact statements before review | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.842 | 0.814 | 0.674 | 0.573 | 0.526 | 0.367 | 0.606 | 0.515 | 0.696 | 0.735 | 0.081 | 0.757 | 0.248 | 0.268 | 3.000 | 0.762 | 0.569 | 0.639 | 0.622 | 0.101 | 0.042 | 0.380 | 0.124 | 0.452 | 0.395 | 0.454 |
| Rights-impact statements before review | mixed_state_federal/district_only | 852 | 1.000 | 0.729 | 0.788 | 0.663 | 0.564 | 0.526 | 0.393 | 0.612 | 0.507 | 0.698 | 0.733 | 0.137 | 0.744 | 0.250 | 0.136 | 1.000 | 0.739 | 0.512 | 0.644 | 0.643 | 0.086 | 0.043 | 0.380 | 0.127 | 0.452 | 0.388 | 0.420 |
| Rights-impact statements before review | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.844 | 0.811 | 0.669 | 0.578 | 0.533 | 0.357 | 0.604 | 0.514 | 0.696 | 0.739 | 0.084 | 0.755 | 0.231 | 0.373 | 3.000 | 0.787 | 0.586 | 0.632 | 0.621 | 0.098 | 0.047 | 0.379 | 0.124 | 0.459 | 0.398 | 0.456 |
| Rights-impact statements before review | state/circuit_en_banc | 588 | 1.000 | 0.852 | 0.822 | 0.698 | 0.565 | 0.498 | 0.398 | 0.614 | 0.522 | 0.696 | 0.707 | 0.075 | 0.662 | 0.109 | 0.007 | 3.000 | 0.475 | 0.521 | 0.673 | 0.658 | 0.122 | 0.031 | 0.468 | 0.143 | 0.437 | 0.386 | 0.451 |
| Rights-impact statements before review | state/circuit_panel | 4426 | 1.000 | 0.842 | 0.807 | 0.684 | 0.577 | 0.537 | 0.355 | 0.614 | 0.498 | 0.697 | 0.717 | 0.085 | 0.761 | 0.229 | 0.272 | 2.000 | 0.569 | 0.478 | 0.648 | 0.657 | 0.087 | 0.043 | 0.448 | 0.131 | 0.445 | 0.388 | 0.429 |
| Rights-impact statements before review | state/district_only | 893 | 1.000 | 0.713 | 0.794 | 0.678 | 0.566 | 0.525 | 0.391 | 0.615 | 0.507 | 0.698 | 0.716 | 0.134 | 0.794 | 0.186 | 0.075 | 1.000 | 0.538 | 0.462 | 0.648 | 0.665 | 0.077 | 0.034 | 0.437 | 0.136 | 0.447 | 0.386 | 0.418 |
| Rights-impact statements before review | state/state_federal_split | 9332 | 1.000 | 0.847 | 0.810 | 0.679 | 0.582 | 0.535 | 0.354 | 0.609 | 0.511 | 0.696 | 0.721 | 0.080 | 0.770 | 0.255 | 0.344 | 3.000 | 0.597 | 0.535 | 0.644 | 0.642 | 0.085 | 0.046 | 0.436 | 0.127 | 0.443 | 0.387 | 0.453 |
| Rights-impact statements before review | state/state_high_court | 9417 | 1.000 | 0.858 | 0.804 | 0.681 | 0.582 | 0.548 | 0.346 | 0.614 | 0.492 | 0.697 | 0.716 | 0.082 | 0.769 | 0.263 | 0.353 | 2.000 | 0.549 | 0.480 | 0.645 | 0.651 | 0.087 | 0.041 | 0.451 | 0.128 | 0.445 | 0.390 | 0.429 |
| Mandatory legislative response cycles | federal/circuit_en_banc | 6748 | 1.000 | 0.875 | 0.734 | 0.685 | 0.584 | 0.527 | 0.370 | 0.626 | 0.251 | 0.614 | 0.907 | 0.004 | 0.880 | 0.076 | 0.262 | 3.000 | 0.394 | 0.479 | 0.654 | 0.660 | 0.102 | 0.040 | 0.536 | 0.137 | 0.430 | 0.433 | 0.404 |
| Mandatory legislative response cycles | federal/circuit_panel | 14998 | 1.000 | 0.876 | 0.722 | 0.684 | 0.592 | 0.545 | 0.353 | 0.630 | 0.213 | 0.615 | 0.907 | 0.006 | 0.862 | 0.103 | 0.385 | 2.000 | 0.409 | 0.439 | 0.659 | 0.658 | 0.093 | 0.047 | 0.533 | 0.134 | 0.430 | 0.432 | 0.384 |
| Mandatory legislative response cycles | federal/district_only | 3975 | 1.000 | 0.842 | 0.718 | 0.685 | 0.590 | 0.548 | 0.355 | 0.634 | 0.202 | 0.616 | 0.905 | 0.008 | 0.881 | 0.095 | 0.369 | 1.000 | 0.407 | 0.411 | 0.660 | 0.664 | 0.079 | 0.049 | 0.544 | 0.146 | 0.425 | 0.421 | 0.365 |
| Mandatory legislative response cycles | federal/state_federal_split | 1500 | 1.000 | 0.905 | 0.732 | 0.682 | 0.592 | 0.531 | 0.359 | 0.625 | 0.248 | 0.615 | 0.914 | 0.003 | 0.792 | 0.089 | 0.328 | 3.000 | 0.531 | 0.515 | 0.661 | 0.667 | 0.071 | 0.055 | 0.549 | 0.148 | 0.385 | 0.382 | 0.409 |
| Mandatory legislative response cycles | mixed_state_federal/circuit_en_banc | 5959 | 1.000 | 0.882 | 0.728 | 0.669 | 0.581 | 0.529 | 0.367 | 0.618 | 0.245 | 0.613 | 0.939 | 0.005 | 0.881 | 0.102 | 0.340 | 3.000 | 0.762 | 0.569 | 0.612 | 0.615 | 0.106 | 0.056 | 0.360 | 0.123 | 0.466 | 0.461 | 0.411 |
| Mandatory legislative response cycles | mixed_state_federal/district_only | 852 | 1.000 | 0.753 | 0.719 | 0.668 | 0.572 | 0.528 | 0.393 | 0.625 | 0.237 | 0.614 | 0.935 | 0.012 | 0.911 | 0.137 | 0.259 | 1.000 | 0.739 | 0.512 | 0.627 | 0.646 | 0.100 | 0.056 | 0.360 | 0.121 | 0.455 | 0.454 | 0.377 |
| Mandatory legislative response cycles | mixed_state_federal/state_federal_split | 11712 | 1.000 | 0.884 | 0.713 | 0.663 | 0.591 | 0.536 | 0.357 | 0.616 | 0.226 | 0.612 | 0.942 | 0.006 | 0.866 | 0.093 | 0.470 | 3.000 | 0.787 | 0.586 | 0.600 | 0.614 | 0.101 | 0.064 | 0.360 | 0.121 | 0.470 | 0.463 | 0.414 |
| Mandatory legislative response cycles | state/circuit_en_banc | 588 | 1.000 | 0.901 | 0.758 | 0.695 | 0.562 | 0.502 | 0.398 | 0.625 | 0.296 | 0.613 | 0.914 | 0.001 | 0.661 | 0.003 | 0.031 | 3.000 | 0.475 | 0.521 | 0.653 | 0.665 | 0.105 | 0.031 | 0.478 | 0.144 | 0.439 | 0.441 | 0.405 |
| Mandatory legislative response cycles | state/circuit_panel | 4426 | 1.000 | 0.881 | 0.725 | 0.680 | 0.586 | 0.540 | 0.355 | 0.626 | 0.220 | 0.614 | 0.922 | 0.005 | 0.872 | 0.100 | 0.370 | 2.000 | 0.569 | 0.478 | 0.641 | 0.636 | 0.101 | 0.053 | 0.429 | 0.127 | 0.455 | 0.455 | 0.386 |
| Mandatory legislative response cycles | state/district_only | 893 | 1.000 | 0.759 | 0.726 | 0.684 | 0.570 | 0.530 | 0.391 | 0.629 | 0.238 | 0.615 | 0.918 | 0.011 | 0.869 | 0.086 | 0.169 | 1.000 | 0.538 | 0.462 | 0.625 | 0.658 | 0.092 | 0.041 | 0.441 | 0.139 | 0.445 | 0.438 | 0.374 |
| Mandatory legislative response cycles | state/state_federal_split | 9332 | 1.000 | 0.884 | 0.717 | 0.672 | 0.594 | 0.538 | 0.354 | 0.620 | 0.225 | 0.613 | 0.926 | 0.005 | 0.824 | 0.089 | 0.446 | 3.000 | 0.597 | 0.535 | 0.624 | 0.645 | 0.096 | 0.059 | 0.412 | 0.122 | 0.454 | 0.450 | 0.411 |
| Mandatory legislative response cycles | state/state_high_court | 9417 | 1.000 | 0.895 | 0.715 | 0.677 | 0.594 | 0.550 | 0.346 | 0.626 | 0.199 | 0.614 | 0.921 | 0.005 | 0.894 | 0.106 | 0.477 | 2.000 | 0.549 | 0.480 | 0.642 | 0.643 | 0.096 | 0.055 | 0.430 | 0.125 | 0.452 | 0.449 | 0.387 |

## Policy Domain Diagnostics

| Scenario | Segment | Cases | Review | Intake | Rights | Dem. const. | Resp. cred. | Access | Gov. adv. | Impl. cap. | Veto reloc. | Transplant | Culture sens. | Emerg. irr. | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust input | Conflict index | Curbing | Cost |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Current-style federal supreme court | administration | 6591 | 1.000 | 0.023 | 0.738 | 0.604 | 0.533 | 0.394 | 0.403 | 0.613 | 0.543 | 0.642 | 0.721 | 0.324 | 0.018 | 0.498 | 0.084 | 2.700 | 0.468 | 0.511 | 0.443 | 0.448 | 0.219 | 0.059 | 0.288 | 0.030 | 0.896 | 0.846 | 0.458 |
| Current-style federal supreme court | civil-rights | 11836 | 1.000 | 0.024 | 0.676 | 0.561 | 0.555 | 0.463 | 0.323 | 0.608 | 0.511 | 0.643 | 0.733 | 0.390 | 0.032 | 0.558 | 0.679 | 2.265 | 0.503 | 0.461 | 0.400 | 0.405 | 0.179 | 0.075 | 0.259 | 0.027 | 0.903 | 0.845 | 0.442 |
| Current-style federal supreme court | criminal-justice | 10046 | 1.000 | 0.024 | 0.675 | 0.562 | 0.550 | 0.441 | 0.347 | 0.608 | 0.519 | 0.643 | 0.736 | 0.385 | 0.020 | 0.554 | 0.573 | 2.325 | 0.562 | 0.491 | 0.400 | 0.402 | 0.175 | 0.077 | 0.235 | 0.027 | 0.904 | 0.848 | 0.446 |
| Current-style federal supreme court | economic-regulation | 6433 | 1.000 | 0.023 | 0.738 | 0.599 | 0.532 | 0.393 | 0.380 | 0.610 | 0.545 | 0.642 | 0.732 | 0.327 | 0.017 | 0.511 | 0.112 | 2.719 | 0.597 | 0.545 | 0.434 | 0.435 | 0.192 | 0.062 | 0.252 | 0.031 | 0.897 | 0.844 | 0.461 |
| Current-style federal supreme court | elections | 10115 | 1.000 | 0.025 | 0.652 | 0.544 | 0.555 | 0.444 | 0.346 | 0.603 | 0.534 | 0.642 | 0.746 | 0.387 | 0.030 | 0.580 | 0.657 | 2.721 | 0.663 | 0.514 | 0.385 | 0.391 | 0.184 | 0.074 | 0.201 | 0.026 | 0.906 | 0.846 | 0.457 |
| Current-style federal supreme court | emergency-security | 9912 | 1.000 | 0.025 | 0.657 | 0.538 | 0.537 | 0.433 | 0.393 | 0.603 | 0.529 | 0.642 | 0.741 | 0.579 | 0.031 | 0.612 | 0.402 | 1.984 | 0.531 | 0.491 | 0.382 | 0.380 | 0.185 | 0.068 | 0.236 | 0.027 | 0.905 | 0.845 | 0.447 |
| Current-style federal supreme court | federalism | 7189 | 1.000 | 0.024 | 0.734 | 0.591 | 0.531 | 0.401 | 0.372 | 0.607 | 0.547 | 0.642 | 0.745 | 0.328 | 0.021 | 0.550 | 0.137 | 2.756 | 0.753 | 0.585 | 0.416 | 0.415 | 0.162 | 0.065 | 0.203 | 0.029 | 0.900 | 0.844 | 0.464 |
| Current-style federal supreme court | speech-religion | 8278 | 1.000 | 0.023 | 0.681 | 0.569 | 0.552 | 0.453 | 0.324 | 0.611 | 0.512 | 0.643 | 0.727 | 0.377 | 0.033 | 0.561 | 0.578 | 2.231 | 0.447 | 0.450 | 0.419 | 0.408 | 0.174 | 0.071 | 0.278 | 0.028 | 0.903 | 0.846 | 0.440 |
| Staggered 18-year nonrenewable terms | administration | 6591 | 1.000 | 0.023 | 0.745 | 0.611 | 0.533 | 0.394 | 0.403 | 0.613 | 0.535 | 0.642 | 0.720 | 0.318 | 0.032 | 0.468 | 0.057 | 2.700 | 0.468 | 0.511 | 0.445 | 0.461 | 0.214 | 0.057 | 0.305 | 0.031 | 0.882 | 0.828 | 0.463 |
| Staggered 18-year nonrenewable terms | civil-rights | 11836 | 1.000 | 0.024 | 0.680 | 0.566 | 0.555 | 0.463 | 0.323 | 0.608 | 0.502 | 0.643 | 0.733 | 0.389 | 0.039 | 0.553 | 0.649 | 2.265 | 0.503 | 0.461 | 0.403 | 0.404 | 0.176 | 0.078 | 0.262 | 0.028 | 0.890 | 0.827 | 0.447 |
| Staggered 18-year nonrenewable terms | criminal-justice | 10046 | 1.000 | 0.024 | 0.680 | 0.567 | 0.550 | 0.441 | 0.347 | 0.608 | 0.510 | 0.643 | 0.736 | 0.385 | 0.033 | 0.548 | 0.528 | 2.325 | 0.562 | 0.491 | 0.403 | 0.403 | 0.172 | 0.074 | 0.241 | 0.029 | 0.889 | 0.829 | 0.450 |
| Staggered 18-year nonrenewable terms | economic-regulation | 6433 | 1.000 | 0.023 | 0.747 | 0.606 | 0.532 | 0.393 | 0.380 | 0.610 | 0.536 | 0.642 | 0.731 | 0.319 | 0.025 | 0.482 | 0.079 | 2.719 | 0.597 | 0.545 | 0.437 | 0.434 | 0.193 | 0.059 | 0.270 | 0.031 | 0.884 | 0.827 | 0.466 |
| Staggered 18-year nonrenewable terms | elections | 10115 | 1.000 | 0.025 | 0.661 | 0.551 | 0.555 | 0.444 | 0.346 | 0.603 | 0.524 | 0.642 | 0.746 | 0.384 | 0.042 | 0.577 | 0.612 | 2.721 | 0.663 | 0.514 | 0.397 | 0.388 | 0.180 | 0.078 | 0.207 | 0.028 | 0.894 | 0.829 | 0.462 |
| Staggered 18-year nonrenewable terms | emergency-security | 9912 | 1.000 | 0.025 | 0.669 | 0.547 | 0.537 | 0.433 | 0.393 | 0.603 | 0.520 | 0.643 | 0.740 | 0.570 | 0.031 | 0.608 | 0.333 | 1.984 | 0.531 | 0.491 | 0.383 | 0.390 | 0.180 | 0.065 | 0.242 | 0.030 | 0.890 | 0.826 | 0.452 |
| Staggered 18-year nonrenewable terms | federalism | 7189 | 1.000 | 0.024 | 0.744 | 0.599 | 0.531 | 0.401 | 0.372 | 0.607 | 0.538 | 0.642 | 0.744 | 0.319 | 0.028 | 0.513 | 0.100 | 2.756 | 0.753 | 0.585 | 0.420 | 0.426 | 0.159 | 0.070 | 0.213 | 0.030 | 0.885 | 0.825 | 0.469 |
| Staggered 18-year nonrenewable terms | speech-religion | 8278 | 1.000 | 0.023 | 0.685 | 0.573 | 0.552 | 0.453 | 0.324 | 0.610 | 0.503 | 0.643 | 0.727 | 0.379 | 0.037 | 0.556 | 0.547 | 2.231 | 0.447 | 0.450 | 0.419 | 0.409 | 0.166 | 0.067 | 0.286 | 0.029 | 0.891 | 0.830 | 0.445 |
| Fifteen-justice supermajority commission court | administration | 6591 | 1.000 | 0.022 | 0.763 | 0.665 | 0.550 | 0.394 | 0.403 | 0.617 | 0.450 | 0.642 | 0.711 | 0.077 | 0.579 | 0.196 | 0.051 | 2.700 | 0.468 | 0.511 | 0.592 | 0.587 | 0.152 | 0.044 | 0.431 | 0.064 | 0.631 | 0.602 | 0.479 |
| Fifteen-justice supermajority commission court | civil-rights | 11836 | 1.000 | 0.023 | 0.733 | 0.632 | 0.589 | 0.462 | 0.323 | 0.612 | 0.419 | 0.643 | 0.724 | 0.089 | 0.621 | 0.261 | 0.720 | 2.265 | 0.503 | 0.461 | 0.564 | 0.566 | 0.120 | 0.064 | 0.393 | 0.058 | 0.653 | 0.614 | 0.462 |
| Fifteen-justice supermajority commission court | criminal-justice | 10046 | 1.000 | 0.023 | 0.726 | 0.632 | 0.579 | 0.441 | 0.347 | 0.612 | 0.426 | 0.643 | 0.726 | 0.097 | 0.598 | 0.306 | 0.595 | 2.325 | 0.562 | 0.491 | 0.551 | 0.554 | 0.124 | 0.065 | 0.374 | 0.058 | 0.648 | 0.610 | 0.466 |
| Fifteen-justice supermajority commission court | economic-regulation | 6433 | 1.000 | 0.023 | 0.770 | 0.663 | 0.549 | 0.393 | 0.380 | 0.615 | 0.451 | 0.642 | 0.722 | 0.073 | 0.575 | 0.218 | 0.065 | 2.719 | 0.597 | 0.545 | 0.571 | 0.580 | 0.127 | 0.042 | 0.393 | 0.063 | 0.632 | 0.599 | 0.482 |
| Fifteen-justice supermajority commission court | elections | 10115 | 1.000 | 0.025 | 0.723 | 0.622 | 0.587 | 0.444 | 0.346 | 0.608 | 0.442 | 0.642 | 0.736 | 0.076 | 0.748 | 0.264 | 0.654 | 2.721 | 0.663 | 0.514 | 0.550 | 0.544 | 0.122 | 0.072 | 0.347 | 0.057 | 0.655 | 0.615 | 0.477 |
| Fifteen-justice supermajority commission court | emergency-security | 9912 | 1.000 | 0.024 | 0.730 | 0.632 | 0.566 | 0.433 | 0.393 | 0.612 | 0.437 | 0.643 | 0.724 | 0.151 | 0.702 | 0.277 | 0.351 | 1.984 | 0.531 | 0.491 | 0.566 | 0.555 | 0.122 | 0.056 | 0.401 | 0.061 | 0.640 | 0.600 | 0.468 |
| Fifteen-justice supermajority commission court | federalism | 7189 | 1.000 | 0.023 | 0.776 | 0.660 | 0.548 | 0.401 | 0.372 | 0.612 | 0.453 | 0.642 | 0.734 | 0.073 | 0.580 | 0.222 | 0.077 | 2.756 | 0.753 | 0.585 | 0.558 | 0.574 | 0.110 | 0.047 | 0.335 | 0.061 | 0.634 | 0.598 | 0.485 |
| Fifteen-justice supermajority commission court | speech-religion | 8278 | 1.000 | 0.023 | 0.733 | 0.638 | 0.583 | 0.452 | 0.324 | 0.615 | 0.420 | 0.643 | 0.717 | 0.084 | 0.610 | 0.260 | 0.611 | 2.231 | 0.447 | 0.450 | 0.569 | 0.575 | 0.117 | 0.062 | 0.421 | 0.059 | 0.654 | 0.615 | 0.460 |
| Supermajority required to invalidate laws | administration | 6591 | 1.000 | 0.022 | 0.761 | 0.659 | 0.542 | 0.394 | 0.403 | 0.616 | 0.459 | 0.641 | 0.715 | 0.080 | 0.555 | 0.214 | 0.041 | 2.700 | 0.468 | 0.511 | 0.579 | 0.583 | 0.151 | 0.042 | 0.428 | 0.061 | 0.641 | 0.613 | 0.466 |
| Supermajority required to invalidate laws | civil-rights | 11836 | 1.000 | 0.023 | 0.732 | 0.630 | 0.579 | 0.462 | 0.323 | 0.611 | 0.428 | 0.642 | 0.727 | 0.089 | 0.697 | 0.268 | 0.689 | 2.265 | 0.503 | 0.461 | 0.564 | 0.559 | 0.123 | 0.065 | 0.395 | 0.057 | 0.661 | 0.623 | 0.449 |
| Supermajority required to invalidate laws | criminal-justice | 10046 | 1.000 | 0.023 | 0.722 | 0.629 | 0.568 | 0.441 | 0.347 | 0.612 | 0.435 | 0.642 | 0.729 | 0.101 | 0.553 | 0.305 | 0.552 | 2.325 | 0.562 | 0.491 | 0.556 | 0.552 | 0.123 | 0.064 | 0.371 | 0.056 | 0.654 | 0.619 | 0.453 |
| Supermajority required to invalidate laws | economic-regulation | 6433 | 1.000 | 0.023 | 0.768 | 0.658 | 0.541 | 0.393 | 0.380 | 0.613 | 0.460 | 0.641 | 0.725 | 0.077 | 0.527 | 0.215 | 0.071 | 2.719 | 0.597 | 0.545 | 0.579 | 0.584 | 0.134 | 0.046 | 0.377 | 0.060 | 0.643 | 0.612 | 0.468 |
| Supermajority required to invalidate laws | elections | 10115 | 1.000 | 0.025 | 0.719 | 0.618 | 0.578 | 0.444 | 0.346 | 0.607 | 0.450 | 0.641 | 0.739 | 0.081 | 0.677 | 0.270 | 0.630 | 2.721 | 0.663 | 0.514 | 0.549 | 0.542 | 0.129 | 0.070 | 0.335 | 0.054 | 0.662 | 0.623 | 0.464 |
| Supermajority required to invalidate laws | emergency-security | 9912 | 1.000 | 0.024 | 0.724 | 0.625 | 0.557 | 0.433 | 0.393 | 0.611 | 0.446 | 0.642 | 0.728 | 0.159 | 0.661 | 0.304 | 0.337 | 1.984 | 0.531 | 0.491 | 0.555 | 0.552 | 0.126 | 0.060 | 0.391 | 0.057 | 0.649 | 0.610 | 0.454 |
| Supermajority required to invalidate laws | federalism | 7189 | 1.000 | 0.023 | 0.772 | 0.654 | 0.540 | 0.401 | 0.372 | 0.610 | 0.462 | 0.641 | 0.739 | 0.077 | 0.525 | 0.248 | 0.073 | 2.756 | 0.753 | 0.585 | 0.558 | 0.565 | 0.110 | 0.049 | 0.331 | 0.058 | 0.640 | 0.604 | 0.472 |
| Supermajority required to invalidate laws | speech-religion | 8278 | 1.000 | 0.023 | 0.730 | 0.635 | 0.571 | 0.452 | 0.324 | 0.614 | 0.428 | 0.642 | 0.720 | 0.087 | 0.585 | 0.295 | 0.556 | 2.231 | 0.447 | 0.450 | 0.575 | 0.568 | 0.121 | 0.063 | 0.406 | 0.056 | 0.660 | 0.624 | 0.447 |
| Strict recusal with substitute justices | administration | 6591 | 1.000 | 0.022 | 0.763 | 0.669 | 0.558 | 0.394 | 0.403 | 0.613 | 0.448 | 0.642 | 0.715 | 0.075 | 0.604 | 0.179 | 0.047 | 2.700 | 0.468 | 0.511 | 0.616 | 0.598 | 0.148 | 0.040 | 0.443 | 0.073 | 0.594 | 0.562 | 0.485 |
| Strict recusal with substitute justices | civil-rights | 11836 | 1.000 | 0.023 | 0.734 | 0.637 | 0.597 | 0.462 | 0.323 | 0.609 | 0.417 | 0.643 | 0.727 | 0.085 | 0.644 | 0.244 | 0.709 | 2.265 | 0.503 | 0.461 | 0.583 | 0.581 | 0.115 | 0.065 | 0.410 | 0.067 | 0.618 | 0.578 | 0.468 |
| Strict recusal with substitute justices | criminal-justice | 10046 | 1.000 | 0.023 | 0.726 | 0.637 | 0.585 | 0.441 | 0.347 | 0.609 | 0.424 | 0.643 | 0.729 | 0.098 | 0.635 | 0.257 | 0.576 | 2.325 | 0.562 | 0.491 | 0.576 | 0.579 | 0.115 | 0.062 | 0.390 | 0.067 | 0.608 | 0.571 | 0.472 |
| Strict recusal with substitute justices | economic-regulation | 6433 | 1.000 | 0.023 | 0.769 | 0.667 | 0.557 | 0.393 | 0.380 | 0.611 | 0.449 | 0.642 | 0.725 | 0.074 | 0.595 | 0.202 | 0.053 | 2.719 | 0.597 | 0.545 | 0.599 | 0.599 | 0.124 | 0.044 | 0.400 | 0.072 | 0.596 | 0.563 | 0.487 |
| Strict recusal with substitute justices | elections | 10115 | 1.000 | 0.025 | 0.724 | 0.627 | 0.594 | 0.444 | 0.346 | 0.605 | 0.439 | 0.642 | 0.739 | 0.075 | 0.680 | 0.269 | 0.633 | 2.721 | 0.663 | 0.514 | 0.572 | 0.567 | 0.113 | 0.063 | 0.371 | 0.064 | 0.616 | 0.573 | 0.483 |
| Strict recusal with substitute justices | emergency-security | 9912 | 1.000 | 0.024 | 0.730 | 0.637 | 0.572 | 0.433 | 0.393 | 0.609 | 0.435 | 0.643 | 0.727 | 0.148 | 0.727 | 0.275 | 0.326 | 1.984 | 0.531 | 0.491 | 0.588 | 0.575 | 0.117 | 0.053 | 0.412 | 0.068 | 0.603 | 0.562 | 0.474 |
| Strict recusal with substitute justices | federalism | 7189 | 1.000 | 0.023 | 0.776 | 0.665 | 0.555 | 0.401 | 0.372 | 0.608 | 0.451 | 0.642 | 0.738 | 0.071 | 0.598 | 0.222 | 0.072 | 2.756 | 0.753 | 0.585 | 0.597 | 0.590 | 0.097 | 0.047 | 0.354 | 0.070 | 0.591 | 0.555 | 0.491 |
| Strict recusal with substitute justices | speech-religion | 8278 | 1.000 | 0.023 | 0.733 | 0.643 | 0.590 | 0.452 | 0.324 | 0.612 | 0.418 | 0.643 | 0.720 | 0.080 | 0.661 | 0.270 | 0.590 | 2.231 | 0.447 | 0.450 | 0.588 | 0.584 | 0.116 | 0.060 | 0.428 | 0.067 | 0.616 | 0.577 | 0.466 |
| Reasoned emergency orders with merits follow-up | administration | 6591 | 1.000 | 0.022 | 0.765 | 0.673 | 0.565 | 0.394 | 0.403 | 0.618 | 0.457 | 0.642 | 0.712 | 0.001 | 0.767 | 0.070 | 0.069 | 2.700 | 0.468 | 0.511 | 0.612 | 0.618 | 0.151 | 0.048 | 0.442 | 0.074 | 0.625 | 0.615 | 0.469 |
| Reasoned emergency orders with merits follow-up | civil-rights | 11836 | 1.000 | 0.023 | 0.741 | 0.643 | 0.611 | 0.462 | 0.323 | 0.612 | 0.429 | 0.642 | 0.725 | 0.008 | 0.791 | 0.096 | 0.745 | 2.265 | 0.503 | 0.461 | 0.585 | 0.582 | 0.121 | 0.076 | 0.418 | 0.066 | 0.653 | 0.629 | 0.452 |
| Reasoned emergency orders with merits follow-up | criminal-justice | 10046 | 1.000 | 0.023 | 0.736 | 0.644 | 0.602 | 0.441 | 0.347 | 0.613 | 0.436 | 0.642 | 0.727 | 0.005 | 0.788 | 0.106 | 0.616 | 2.325 | 0.562 | 0.491 | 0.583 | 0.579 | 0.126 | 0.068 | 0.387 | 0.067 | 0.645 | 0.626 | 0.456 |
| Reasoned emergency orders with merits follow-up | economic-regulation | 6433 | 1.000 | 0.022 | 0.769 | 0.670 | 0.564 | 0.393 | 0.380 | 0.615 | 0.459 | 0.641 | 0.722 | 0.001 | 0.798 | 0.080 | 0.090 | 2.719 | 0.597 | 0.545 | 0.605 | 0.610 | 0.121 | 0.048 | 0.399 | 0.073 | 0.628 | 0.616 | 0.472 |
| Reasoned emergency orders with merits follow-up | elections | 10115 | 1.000 | 0.024 | 0.723 | 0.629 | 0.608 | 0.444 | 0.346 | 0.608 | 0.453 | 0.642 | 0.737 | 0.008 | 0.808 | 0.122 | 0.682 | 2.721 | 0.663 | 0.514 | 0.569 | 0.572 | 0.124 | 0.076 | 0.359 | 0.064 | 0.651 | 0.628 | 0.467 |
| Reasoned emergency orders with merits follow-up | emergency-security | 9912 | 1.000 | 0.024 | 0.733 | 0.645 | 0.586 | 0.433 | 0.393 | 0.614 | 0.447 | 0.642 | 0.723 | 0.018 | 0.880 | 0.167 | 0.385 | 1.984 | 0.531 | 0.491 | 0.581 | 0.585 | 0.119 | 0.063 | 0.411 | 0.068 | 0.635 | 0.616 | 0.457 |
| Reasoned emergency orders with merits follow-up | federalism | 7189 | 1.000 | 0.023 | 0.774 | 0.666 | 0.564 | 0.401 | 0.372 | 0.612 | 0.461 | 0.641 | 0.736 | 0.001 | 0.788 | 0.084 | 0.116 | 2.756 | 0.753 | 0.585 | 0.579 | 0.593 | 0.106 | 0.054 | 0.342 | 0.072 | 0.628 | 0.610 | 0.475 |
| Reasoned emergency orders with merits follow-up | speech-religion | 8278 | 1.000 | 0.023 | 0.740 | 0.648 | 0.604 | 0.452 | 0.324 | 0.615 | 0.429 | 0.642 | 0.718 | 0.007 | 0.797 | 0.110 | 0.629 | 2.231 | 0.447 | 0.450 | 0.595 | 0.586 | 0.117 | 0.066 | 0.432 | 0.067 | 0.652 | 0.633 | 0.450 |
| Panel review with en banc safety valve | administration | 6591 | 1.000 | 0.022 | 0.764 | 0.666 | 0.555 | 0.394 | 0.403 | 0.609 | 0.447 | 0.641 | 0.714 | 0.073 | 0.591 | 0.194 | 0.055 | 2.700 | 0.468 | 0.511 | 0.589 | 0.587 | 0.149 | 0.044 | 0.429 | 0.067 | 0.629 | 0.601 | 0.520 |
| Panel review with en banc safety valve | civil-rights | 11836 | 1.000 | 0.023 | 0.732 | 0.632 | 0.595 | 0.462 | 0.323 | 0.605 | 0.416 | 0.642 | 0.726 | 0.087 | 0.637 | 0.248 | 0.738 | 2.265 | 0.503 | 0.461 | 0.562 | 0.561 | 0.124 | 0.067 | 0.398 | 0.060 | 0.653 | 0.615 | 0.500 |
| Panel review with en banc safety valve | criminal-justice | 10046 | 1.000 | 0.023 | 0.726 | 0.633 | 0.585 | 0.441 | 0.347 | 0.605 | 0.423 | 0.642 | 0.728 | 0.098 | 0.689 | 0.275 | 0.613 | 2.325 | 0.562 | 0.491 | 0.553 | 0.563 | 0.122 | 0.061 | 0.384 | 0.060 | 0.648 | 0.611 | 0.503 |
| Panel review with en banc safety valve | economic-regulation | 6433 | 1.000 | 0.023 | 0.770 | 0.664 | 0.554 | 0.393 | 0.380 | 0.606 | 0.447 | 0.641 | 0.724 | 0.077 | 0.594 | 0.213 | 0.058 | 2.719 | 0.597 | 0.545 | 0.581 | 0.590 | 0.131 | 0.045 | 0.382 | 0.066 | 0.633 | 0.604 | 0.526 |
| Panel review with en banc safety valve | elections | 10115 | 1.000 | 0.025 | 0.722 | 0.622 | 0.592 | 0.444 | 0.346 | 0.599 | 0.438 | 0.641 | 0.739 | 0.077 | 0.641 | 0.270 | 0.662 | 2.721 | 0.663 | 0.514 | 0.550 | 0.547 | 0.123 | 0.068 | 0.342 | 0.059 | 0.654 | 0.616 | 0.524 |
| Panel review with en banc safety valve | emergency-security | 9912 | 1.000 | 0.024 | 0.731 | 0.634 | 0.571 | 0.433 | 0.393 | 0.604 | 0.434 | 0.642 | 0.727 | 0.149 | 0.722 | 0.287 | 0.355 | 1.984 | 0.531 | 0.491 | 0.566 | 0.561 | 0.117 | 0.056 | 0.397 | 0.061 | 0.639 | 0.602 | 0.513 |
| Panel review with en banc safety valve | federalism | 7189 | 1.000 | 0.023 | 0.776 | 0.661 | 0.553 | 0.401 | 0.372 | 0.603 | 0.449 | 0.641 | 0.737 | 0.072 | 0.619 | 0.196 | 0.077 | 2.756 | 0.753 | 0.585 | 0.567 | 0.575 | 0.103 | 0.051 | 0.341 | 0.063 | 0.630 | 0.595 | 0.531 |
| Panel review with en banc safety valve | speech-religion | 8278 | 1.000 | 0.023 | 0.733 | 0.639 | 0.589 | 0.452 | 0.324 | 0.608 | 0.417 | 0.642 | 0.719 | 0.083 | 0.638 | 0.259 | 0.629 | 2.231 | 0.447 | 0.450 | 0.572 | 0.575 | 0.117 | 0.061 | 0.410 | 0.060 | 0.653 | 0.617 | 0.495 |
| Dual supreme courts with cross-checking invalidations | administration | 6591 | 1.000 | 0.022 | 0.763 | 0.667 | 0.562 | 0.394 | 0.403 | 0.588 | 0.611 | 0.638 | 0.726 | 0.003 | 0.791 | 0.051 | 0.014 | 2.700 | 0.468 | 0.511 | 0.654 | 0.644 | 0.125 | 0.037 | 0.480 | 0.094 | 0.527 | 0.492 | 0.598 |
| Dual supreme courts with cross-checking invalidations | civil-rights | 11836 | 1.000 | 0.023 | 0.749 | 0.640 | 0.604 | 0.462 | 0.323 | 0.583 | 0.579 | 0.639 | 0.739 | 0.010 | 0.806 | 0.126 | 0.641 | 2.265 | 0.503 | 0.461 | 0.625 | 0.618 | 0.106 | 0.058 | 0.441 | 0.084 | 0.556 | 0.512 | 0.581 |
| Dual supreme courts with cross-checking invalidations | criminal-justice | 10046 | 1.000 | 0.023 | 0.741 | 0.642 | 0.593 | 0.441 | 0.347 | 0.583 | 0.586 | 0.639 | 0.741 | 0.008 | 0.807 | 0.117 | 0.482 | 2.325 | 0.562 | 0.491 | 0.616 | 0.611 | 0.099 | 0.055 | 0.430 | 0.087 | 0.547 | 0.506 | 0.585 |
| Dual supreme courts with cross-checking invalidations | economic-regulation | 6433 | 1.000 | 0.022 | 0.771 | 0.666 | 0.560 | 0.393 | 0.380 | 0.586 | 0.612 | 0.638 | 0.737 | 0.002 | 0.769 | 0.049 | 0.017 | 2.719 | 0.597 | 0.545 | 0.633 | 0.629 | 0.115 | 0.040 | 0.440 | 0.092 | 0.531 | 0.495 | 0.601 |
| Dual supreme courts with cross-checking invalidations | elections | 10115 | 1.000 | 0.024 | 0.739 | 0.630 | 0.598 | 0.444 | 0.346 | 0.579 | 0.600 | 0.638 | 0.752 | 0.009 | 0.805 | 0.138 | 0.536 | 2.721 | 0.663 | 0.514 | 0.608 | 0.605 | 0.105 | 0.060 | 0.396 | 0.083 | 0.554 | 0.507 | 0.596 |
| Dual supreme courts with cross-checking invalidations | emergency-security | 9912 | 1.000 | 0.024 | 0.736 | 0.643 | 0.574 | 0.433 | 0.393 | 0.585 | 0.597 | 0.639 | 0.737 | 0.022 | 0.866 | 0.150 | 0.212 | 1.984 | 0.531 | 0.491 | 0.627 | 0.620 | 0.101 | 0.045 | 0.445 | 0.090 | 0.536 | 0.492 | 0.586 |
| Dual supreme courts with cross-checking invalidations | federalism | 7189 | 1.000 | 0.023 | 0.778 | 0.664 | 0.558 | 0.401 | 0.372 | 0.582 | 0.613 | 0.638 | 0.750 | 0.002 | 0.762 | 0.059 | 0.023 | 2.756 | 0.753 | 0.585 | 0.619 | 0.630 | 0.085 | 0.041 | 0.392 | 0.090 | 0.527 | 0.485 | 0.604 |
| Dual supreme courts with cross-checking invalidations | speech-religion | 8278 | 1.000 | 0.023 | 0.745 | 0.644 | 0.596 | 0.452 | 0.324 | 0.585 | 0.580 | 0.639 | 0.733 | 0.008 | 0.804 | 0.098 | 0.506 | 2.231 | 0.447 | 0.450 | 0.628 | 0.622 | 0.098 | 0.051 | 0.467 | 0.084 | 0.555 | 0.511 | 0.580 |
| Pre-enactment constitutional council | administration | 6591 | 1.000 | 0.022 | 0.762 | 0.661 | 0.565 | 0.394 | 0.403 | 0.600 | 0.678 | 0.641 | 0.722 | 0.070 | 0.629 | 0.188 | 0.019 | 2.700 | 0.468 | 0.511 | 0.650 | 0.646 | 0.123 | 0.040 | 0.500 | 0.099 | 0.484 | 0.440 | 0.542 |
| Pre-enactment constitutional council | civil-rights | 11836 | 1.000 | 0.023 | 0.738 | 0.640 | 0.599 | 0.462 | 0.323 | 0.596 | 0.644 | 0.641 | 0.733 | 0.083 | 0.777 | 0.229 | 0.622 | 2.265 | 0.503 | 0.461 | 0.619 | 0.626 | 0.099 | 0.053 | 0.462 | 0.092 | 0.508 | 0.454 | 0.525 |
| Pre-enactment constitutional council | criminal-justice | 10046 | 1.000 | 0.023 | 0.726 | 0.638 | 0.587 | 0.441 | 0.347 | 0.596 | 0.652 | 0.641 | 0.735 | 0.092 | 0.676 | 0.255 | 0.471 | 2.325 | 0.562 | 0.491 | 0.617 | 0.623 | 0.095 | 0.057 | 0.437 | 0.094 | 0.500 | 0.450 | 0.529 |
| Pre-enactment constitutional council | economic-regulation | 6433 | 1.000 | 0.023 | 0.769 | 0.660 | 0.563 | 0.393 | 0.380 | 0.597 | 0.679 | 0.641 | 0.732 | 0.071 | 0.655 | 0.170 | 0.023 | 2.719 | 0.597 | 0.545 | 0.643 | 0.649 | 0.105 | 0.035 | 0.447 | 0.101 | 0.483 | 0.436 | 0.545 |
| Pre-enactment constitutional council | elections | 10115 | 1.000 | 0.025 | 0.732 | 0.634 | 0.592 | 0.444 | 0.346 | 0.592 | 0.664 | 0.641 | 0.744 | 0.073 | 0.702 | 0.242 | 0.498 | 2.721 | 0.663 | 0.514 | 0.612 | 0.617 | 0.094 | 0.052 | 0.405 | 0.090 | 0.503 | 0.446 | 0.540 |
| Pre-enactment constitutional council | emergency-security | 9912 | 1.000 | 0.024 | 0.727 | 0.636 | 0.572 | 0.433 | 0.393 | 0.596 | 0.663 | 0.641 | 0.733 | 0.140 | 0.760 | 0.260 | 0.189 | 1.984 | 0.531 | 0.491 | 0.638 | 0.635 | 0.096 | 0.041 | 0.459 | 0.096 | 0.490 | 0.436 | 0.531 |
| Pre-enactment constitutional council | federalism | 7189 | 1.000 | 0.023 | 0.776 | 0.658 | 0.561 | 0.401 | 0.372 | 0.594 | 0.680 | 0.640 | 0.745 | 0.072 | 0.652 | 0.173 | 0.024 | 2.756 | 0.753 | 0.585 | 0.632 | 0.641 | 0.075 | 0.036 | 0.414 | 0.097 | 0.481 | 0.429 | 0.548 |
| Pre-enactment constitutional council | speech-religion | 8278 | 1.000 | 0.023 | 0.733 | 0.643 | 0.591 | 0.452 | 0.324 | 0.599 | 0.646 | 0.642 | 0.726 | 0.079 | 0.696 | 0.235 | 0.498 | 2.231 | 0.447 | 0.450 | 0.639 | 0.632 | 0.094 | 0.049 | 0.474 | 0.093 | 0.502 | 0.450 | 0.523 |
| Judicial review with delayed legislative override | administration | 6591 | 1.000 | 0.022 | 0.763 | 0.660 | 0.550 | 0.394 | 0.403 | 0.612 | 0.450 | 0.642 | 0.718 | 0.079 | 0.578 | 0.185 | 0.071 | 2.700 | 0.468 | 0.511 | 0.577 | 0.583 | 0.160 | 0.046 | 0.420 | 0.059 | 0.664 | 0.635 | 0.475 |
| Judicial review with delayed legislative override | civil-rights | 11836 | 1.000 | 0.023 | 0.728 | 0.627 | 0.591 | 0.462 | 0.323 | 0.607 | 0.416 | 0.642 | 0.731 | 0.086 | 0.627 | 0.247 | 0.729 | 2.265 | 0.503 | 0.461 | 0.548 | 0.539 | 0.129 | 0.072 | 0.372 | 0.054 | 0.686 | 0.648 | 0.458 |
| Judicial review with delayed legislative override | criminal-justice | 10046 | 1.000 | 0.023 | 0.720 | 0.627 | 0.580 | 0.441 | 0.347 | 0.607 | 0.424 | 0.642 | 0.733 | 0.098 | 0.580 | 0.288 | 0.608 | 2.325 | 0.562 | 0.491 | 0.546 | 0.543 | 0.129 | 0.069 | 0.363 | 0.055 | 0.681 | 0.644 | 0.462 |
| Judicial review with delayed legislative override | economic-regulation | 6433 | 1.000 | 0.023 | 0.768 | 0.658 | 0.549 | 0.393 | 0.380 | 0.610 | 0.451 | 0.641 | 0.728 | 0.077 | 0.556 | 0.212 | 0.083 | 2.719 | 0.597 | 0.545 | 0.557 | 0.564 | 0.138 | 0.051 | 0.368 | 0.058 | 0.670 | 0.639 | 0.478 |
| Judicial review with delayed legislative override | elections | 10115 | 1.000 | 0.025 | 0.714 | 0.616 | 0.590 | 0.444 | 0.346 | 0.603 | 0.437 | 0.642 | 0.743 | 0.078 | 0.634 | 0.253 | 0.671 | 2.721 | 0.663 | 0.514 | 0.532 | 0.531 | 0.126 | 0.069 | 0.325 | 0.052 | 0.688 | 0.647 | 0.473 |
| Judicial review with delayed legislative override | emergency-security | 9912 | 1.000 | 0.024 | 0.726 | 0.626 | 0.567 | 0.433 | 0.393 | 0.607 | 0.436 | 0.642 | 0.731 | 0.153 | 0.685 | 0.285 | 0.383 | 1.984 | 0.531 | 0.491 | 0.535 | 0.543 | 0.136 | 0.060 | 0.382 | 0.055 | 0.674 | 0.635 | 0.464 |
| Judicial review with delayed legislative override | federalism | 7189 | 1.000 | 0.023 | 0.772 | 0.654 | 0.548 | 0.401 | 0.372 | 0.607 | 0.453 | 0.641 | 0.741 | 0.075 | 0.569 | 0.237 | 0.110 | 2.756 | 0.753 | 0.585 | 0.550 | 0.561 | 0.115 | 0.051 | 0.325 | 0.056 | 0.667 | 0.631 | 0.481 |
| Judicial review with delayed legislative override | speech-religion | 8278 | 1.000 | 0.023 | 0.728 | 0.633 | 0.584 | 0.452 | 0.324 | 0.610 | 0.418 | 0.642 | 0.724 | 0.084 | 0.600 | 0.267 | 0.621 | 2.231 | 0.447 | 0.450 | 0.552 | 0.549 | 0.125 | 0.062 | 0.393 | 0.053 | 0.689 | 0.652 | 0.456 |
| Retention-election accountability court | administration | 6591 | 1.000 | 0.022 | 0.762 | 0.670 | 0.552 | 0.394 | 0.403 | 0.609 | 0.429 | 0.641 | 0.720 | 0.073 | 0.595 | 0.167 | 0.022 | 2.700 | 0.468 | 0.511 | 0.623 | 0.633 | 0.124 | 0.032 | 0.481 | 0.083 | 0.509 | 0.457 | 0.490 |
| Retention-election accountability court | civil-rights | 11836 | 1.000 | 0.023 | 0.715 | 0.638 | 0.591 | 0.462 | 0.323 | 0.603 | 0.383 | 0.642 | 0.733 | 0.080 | 0.654 | 0.251 | 0.588 | 2.265 | 0.503 | 0.461 | 0.603 | 0.581 | 0.109 | 0.054 | 0.422 | 0.076 | 0.534 | 0.472 | 0.474 |
| Retention-election accountability court | criminal-justice | 10046 | 1.000 | 0.023 | 0.710 | 0.641 | 0.575 | 0.441 | 0.347 | 0.605 | 0.396 | 0.642 | 0.733 | 0.092 | 0.609 | 0.270 | 0.422 | 2.325 | 0.562 | 0.491 | 0.602 | 0.593 | 0.098 | 0.051 | 0.421 | 0.078 | 0.523 | 0.465 | 0.478 |
| Retention-election accountability court | economic-regulation | 6433 | 1.000 | 0.023 | 0.769 | 0.669 | 0.551 | 0.393 | 0.380 | 0.606 | 0.429 | 0.641 | 0.730 | 0.072 | 0.632 | 0.149 | 0.017 | 2.719 | 0.597 | 0.545 | 0.619 | 0.609 | 0.110 | 0.038 | 0.424 | 0.081 | 0.510 | 0.456 | 0.493 |
| Retention-election accountability court | elections | 10115 | 1.000 | 0.025 | 0.715 | 0.635 | 0.584 | 0.444 | 0.346 | 0.600 | 0.404 | 0.641 | 0.744 | 0.071 | 0.741 | 0.344 | 0.464 | 2.721 | 0.663 | 0.514 | 0.576 | 0.585 | 0.100 | 0.054 | 0.378 | 0.074 | 0.529 | 0.464 | 0.489 |
| Retention-election accountability court | emergency-security | 9912 | 1.000 | 0.024 | 0.725 | 0.645 | 0.560 | 0.433 | 0.393 | 0.605 | 0.411 | 0.642 | 0.731 | 0.139 | 0.698 | 0.239 | 0.178 | 1.984 | 0.531 | 0.491 | 0.595 | 0.599 | 0.098 | 0.042 | 0.441 | 0.079 | 0.516 | 0.456 | 0.479 |
| Retention-election accountability court | federalism | 7189 | 1.000 | 0.023 | 0.776 | 0.667 | 0.548 | 0.401 | 0.372 | 0.604 | 0.431 | 0.641 | 0.742 | 0.070 | 0.580 | 0.173 | 0.019 | 2.756 | 0.753 | 0.585 | 0.608 | 0.610 | 0.090 | 0.041 | 0.373 | 0.079 | 0.506 | 0.445 | 0.496 |
| Retention-election accountability court | speech-religion | 8278 | 1.000 | 0.023 | 0.715 | 0.644 | 0.581 | 0.452 | 0.324 | 0.607 | 0.388 | 0.642 | 0.725 | 0.078 | 0.625 | 0.250 | 0.458 | 2.231 | 0.447 | 0.450 | 0.606 | 0.598 | 0.101 | 0.047 | 0.447 | 0.075 | 0.530 | 0.470 | 0.472 |
| Hybrid court balancing independence and accountability | administration | 6591 | 1.000 | 0.022 | 0.764 | 0.680 | 0.562 | 0.394 | 0.403 | 0.595 | 0.447 | 0.639 | 0.726 | 0.001 | 0.800 | 0.046 | 0.022 | 2.700 | 0.468 | 0.511 | 0.642 | 0.644 | 0.133 | 0.038 | 0.484 | 0.101 | 0.520 | 0.505 | 0.552 |
| Hybrid court balancing independence and accountability | civil-rights | 11836 | 1.000 | 0.023 | 0.747 | 0.653 | 0.608 | 0.462 | 0.323 | 0.591 | 0.416 | 0.640 | 0.738 | 0.008 | 0.815 | 0.096 | 0.682 | 2.265 | 0.503 | 0.461 | 0.620 | 0.621 | 0.109 | 0.060 | 0.445 | 0.091 | 0.550 | 0.523 | 0.531 |
| Hybrid court balancing independence and accountability | criminal-justice | 10046 | 1.000 | 0.023 | 0.740 | 0.655 | 0.597 | 0.441 | 0.347 | 0.591 | 0.423 | 0.640 | 0.740 | 0.005 | 0.814 | 0.093 | 0.532 | 2.325 | 0.562 | 0.491 | 0.615 | 0.624 | 0.102 | 0.062 | 0.431 | 0.093 | 0.542 | 0.520 | 0.533 |
| Hybrid court balancing independence and accountability | economic-regulation | 6433 | 1.000 | 0.022 | 0.771 | 0.679 | 0.561 | 0.393 | 0.380 | 0.592 | 0.447 | 0.639 | 0.737 | 0.001 | 0.788 | 0.039 | 0.025 | 2.719 | 0.597 | 0.545 | 0.634 | 0.633 | 0.116 | 0.039 | 0.439 | 0.099 | 0.524 | 0.507 | 0.558 |
| Hybrid court balancing independence and accountability | elections | 10115 | 1.000 | 0.024 | 0.737 | 0.644 | 0.600 | 0.444 | 0.346 | 0.585 | 0.436 | 0.639 | 0.751 | 0.007 | 0.805 | 0.115 | 0.561 | 2.721 | 0.663 | 0.514 | 0.610 | 0.606 | 0.102 | 0.063 | 0.402 | 0.089 | 0.547 | 0.519 | 0.556 |
| Hybrid court balancing independence and accountability | emergency-security | 9912 | 1.000 | 0.024 | 0.736 | 0.658 | 0.576 | 0.433 | 0.393 | 0.591 | 0.432 | 0.640 | 0.736 | 0.015 | 0.885 | 0.156 | 0.238 | 1.984 | 0.531 | 0.491 | 0.625 | 0.621 | 0.097 | 0.050 | 0.445 | 0.098 | 0.529 | 0.505 | 0.544 |
| Hybrid court balancing independence and accountability | federalism | 7189 | 1.000 | 0.023 | 0.778 | 0.677 | 0.559 | 0.401 | 0.372 | 0.588 | 0.449 | 0.639 | 0.750 | 0.001 | 0.809 | 0.050 | 0.033 | 2.756 | 0.753 | 0.585 | 0.619 | 0.619 | 0.092 | 0.044 | 0.387 | 0.096 | 0.518 | 0.496 | 0.564 |
| Hybrid court balancing independence and accountability | speech-religion | 8278 | 1.000 | 0.023 | 0.744 | 0.658 | 0.600 | 0.452 | 0.324 | 0.594 | 0.417 | 0.640 | 0.731 | 0.006 | 0.802 | 0.093 | 0.563 | 2.231 | 0.447 | 0.450 | 0.626 | 0.619 | 0.106 | 0.056 | 0.464 | 0.091 | 0.548 | 0.525 | 0.525 |
| Weak-form review with legislative reply | administration | 6591 | 1.000 | 0.867 | 0.762 | 0.706 | 0.564 | 0.500 | 0.403 | 0.638 | 0.243 | 0.676 | 0.757 | 0.073 | 0.625 | 0.179 | 0.000 | 2.700 | 0.468 | 0.511 | 0.746 | 0.740 | 0.077 | 0.016 | 0.574 | 0.247 | 0.244 | 0.201 | 0.364 |
| Weak-form review with legislative reply | civil-rights | 11836 | 1.000 | 0.902 | 0.691 | 0.697 | 0.660 | 0.572 | 0.323 | 0.637 | 0.116 | 0.676 | 0.763 | 0.085 | 0.667 | 0.253 | 0.000 | 2.265 | 0.503 | 0.461 | 0.690 | 0.686 | 0.058 | 0.022 | 0.531 | 0.240 | 0.255 | 0.208 | 0.354 |
| Weak-form review with legislative reply | criminal-justice | 10046 | 1.000 | 0.890 | 0.700 | 0.694 | 0.635 | 0.549 | 0.347 | 0.637 | 0.148 | 0.677 | 0.766 | 0.092 | 0.645 | 0.359 | 0.000 | 2.325 | 0.562 | 0.491 | 0.705 | 0.693 | 0.050 | 0.022 | 0.519 | 0.240 | 0.252 | 0.206 | 0.356 |
| Weak-form review with legislative reply | economic-regulation | 6433 | 1.000 | 0.867 | 0.768 | 0.704 | 0.564 | 0.499 | 0.380 | 0.635 | 0.244 | 0.676 | 0.767 | 0.072 | 0.617 | 0.159 | 0.000 | 2.719 | 0.597 | 0.545 | 0.729 | 0.727 | 0.074 | 0.021 | 0.524 | 0.242 | 0.247 | 0.203 | 0.367 |
| Weak-form review with legislative reply | elections | 10115 | 1.000 | 0.869 | 0.688 | 0.689 | 0.653 | 0.550 | 0.346 | 0.632 | 0.152 | 0.676 | 0.775 | 0.074 | 0.656 | 0.264 | 0.000 | 2.721 | 0.663 | 0.514 | 0.686 | 0.682 | 0.052 | 0.023 | 0.472 | 0.238 | 0.253 | 0.201 | 0.370 |
| Weak-form review with legislative reply | emergency-security | 9912 | 1.000 | 0.730 | 0.708 | 0.686 | 0.601 | 0.526 | 0.393 | 0.634 | 0.196 | 0.676 | 0.767 | 0.143 | 0.736 | 0.276 | 0.000 | 1.984 | 0.531 | 0.491 | 0.702 | 0.699 | 0.059 | 0.020 | 0.538 | 0.241 | 0.249 | 0.199 | 0.360 |
| Weak-form review with legislative reply | federalism | 7189 | 1.000 | 0.863 | 0.773 | 0.702 | 0.564 | 0.506 | 0.372 | 0.632 | 0.245 | 0.676 | 0.780 | 0.072 | 0.608 | 0.176 | 0.000 | 2.756 | 0.753 | 0.585 | 0.717 | 0.712 | 0.052 | 0.024 | 0.486 | 0.238 | 0.244 | 0.193 | 0.372 |
| Weak-form review with legislative reply | speech-religion | 8278 | 1.000 | 0.911 | 0.700 | 0.700 | 0.643 | 0.563 | 0.324 | 0.639 | 0.134 | 0.677 | 0.757 | 0.079 | 0.660 | 0.217 | 0.000 | 2.231 | 0.447 | 0.450 | 0.703 | 0.702 | 0.057 | 0.021 | 0.548 | 0.236 | 0.251 | 0.205 | 0.350 |
| Suspended declarations of invalidity | administration | 6591 | 1.000 | 0.899 | 0.762 | 0.688 | 0.566 | 0.502 | 0.403 | 0.633 | 0.281 | 0.622 | 0.827 | 0.001 | 0.792 | 0.050 | 0.058 | 2.700 | 0.468 | 0.511 | 0.611 | 0.630 | 0.146 | 0.045 | 0.451 | 0.079 | 0.605 | 0.592 | 0.388 |
| Suspended declarations of invalidity | civil-rights | 11836 | 1.000 | 0.912 | 0.704 | 0.682 | 0.684 | 0.572 | 0.323 | 0.623 | 0.144 | 0.622 | 0.845 | 0.008 | 0.785 | 0.103 | 0.753 | 2.265 | 0.503 | 0.461 | 0.617 | 0.601 | 0.122 | 0.067 | 0.429 | 0.072 | 0.634 | 0.609 | 0.379 |
| Suspended declarations of invalidity | criminal-justice | 10046 | 1.000 | 0.904 | 0.703 | 0.678 | 0.662 | 0.550 | 0.347 | 0.624 | 0.172 | 0.622 | 0.846 | 0.005 | 0.790 | 0.102 | 0.625 | 2.325 | 0.562 | 0.491 | 0.613 | 0.607 | 0.111 | 0.059 | 0.412 | 0.072 | 0.627 | 0.605 | 0.381 |
| Suspended declarations of invalidity | economic-regulation | 6433 | 1.000 | 0.900 | 0.767 | 0.686 | 0.568 | 0.501 | 0.380 | 0.630 | 0.281 | 0.622 | 0.838 | 0.001 | 0.783 | 0.063 | 0.075 | 2.719 | 0.597 | 0.545 | 0.611 | 0.607 | 0.125 | 0.044 | 0.406 | 0.077 | 0.609 | 0.597 | 0.391 |
| Suspended declarations of invalidity | elections | 10115 | 1.000 | 0.903 | 0.690 | 0.669 | 0.672 | 0.553 | 0.346 | 0.619 | 0.180 | 0.621 | 0.856 | 0.008 | 0.774 | 0.133 | 0.677 | 2.721 | 0.663 | 0.514 | 0.609 | 0.589 | 0.114 | 0.064 | 0.378 | 0.069 | 0.632 | 0.606 | 0.394 |
| Suspended declarations of invalidity | emergency-security | 9912 | 1.000 | 0.750 | 0.714 | 0.673 | 0.618 | 0.528 | 0.393 | 0.627 | 0.228 | 0.622 | 0.840 | 0.017 | 0.872 | 0.150 | 0.365 | 1.984 | 0.531 | 0.491 | 0.605 | 0.609 | 0.105 | 0.056 | 0.434 | 0.076 | 0.613 | 0.592 | 0.384 |
| Suspended declarations of invalidity | federalism | 7189 | 1.000 | 0.900 | 0.770 | 0.683 | 0.569 | 0.509 | 0.372 | 0.627 | 0.280 | 0.621 | 0.851 | 0.001 | 0.774 | 0.072 | 0.096 | 2.756 | 0.753 | 0.585 | 0.592 | 0.602 | 0.102 | 0.048 | 0.351 | 0.075 | 0.607 | 0.590 | 0.395 |
| Suspended declarations of invalidity | speech-religion | 8278 | 1.000 | 0.918 | 0.711 | 0.684 | 0.665 | 0.563 | 0.324 | 0.627 | 0.161 | 0.622 | 0.837 | 0.006 | 0.771 | 0.120 | 0.638 | 2.231 | 0.447 | 0.450 | 0.621 | 0.615 | 0.105 | 0.058 | 0.447 | 0.071 | 0.633 | 0.611 | 0.375 |
| Strong-form review with explicit override clause | administration | 6591 | 1.000 | 0.107 | 0.763 | 0.667 | 0.554 | 0.404 | 0.403 | 0.622 | 0.407 | 0.630 | 0.859 | 0.075 | 0.636 | 0.177 | 0.060 | 2.700 | 0.468 | 0.511 | 0.623 | 0.625 | 0.136 | 0.041 | 0.462 | 0.085 | 0.534 | 0.518 | 0.432 |
| Strong-form review with explicit override clause | civil-rights | 11836 | 1.000 | 0.114 | 0.733 | 0.647 | 0.592 | 0.473 | 0.323 | 0.620 | 0.313 | 0.630 | 0.867 | 0.086 | 0.700 | 0.306 | 0.714 | 2.265 | 0.503 | 0.461 | 0.598 | 0.596 | 0.112 | 0.062 | 0.426 | 0.079 | 0.555 | 0.534 | 0.419 |
| Strong-form review with explicit override clause | criminal-justice | 10046 | 1.000 | 0.112 | 0.725 | 0.644 | 0.581 | 0.452 | 0.347 | 0.619 | 0.337 | 0.630 | 0.870 | 0.096 | 0.617 | 0.280 | 0.583 | 2.325 | 0.562 | 0.491 | 0.592 | 0.588 | 0.112 | 0.061 | 0.408 | 0.079 | 0.548 | 0.529 | 0.422 |
| Strong-form review with explicit override clause | economic-regulation | 6433 | 1.000 | 0.109 | 0.769 | 0.665 | 0.553 | 0.403 | 0.380 | 0.619 | 0.406 | 0.630 | 0.869 | 0.075 | 0.601 | 0.229 | 0.077 | 2.719 | 0.597 | 0.545 | 0.608 | 0.601 | 0.124 | 0.044 | 0.422 | 0.083 | 0.537 | 0.521 | 0.435 |
| Strong-form review with explicit override clause | elections | 10115 | 1.000 | 0.120 | 0.722 | 0.637 | 0.590 | 0.456 | 0.346 | 0.616 | 0.337 | 0.630 | 0.879 | 0.076 | 0.631 | 0.273 | 0.640 | 2.721 | 0.663 | 0.514 | 0.588 | 0.583 | 0.113 | 0.064 | 0.374 | 0.077 | 0.555 | 0.532 | 0.434 |
| Strong-form review with explicit override clause | emergency-security | 9912 | 1.000 | 0.116 | 0.728 | 0.640 | 0.568 | 0.444 | 0.393 | 0.618 | 0.368 | 0.630 | 0.870 | 0.151 | 0.720 | 0.287 | 0.344 | 1.984 | 0.531 | 0.491 | 0.599 | 0.589 | 0.110 | 0.050 | 0.423 | 0.081 | 0.543 | 0.520 | 0.422 |
| Strong-form review with explicit override clause | federalism | 7189 | 1.000 | 0.113 | 0.774 | 0.663 | 0.552 | 0.412 | 0.372 | 0.616 | 0.406 | 0.630 | 0.882 | 0.073 | 0.625 | 0.211 | 0.089 | 2.756 | 0.753 | 0.585 | 0.602 | 0.593 | 0.098 | 0.045 | 0.367 | 0.082 | 0.532 | 0.511 | 0.438 |
| Strong-form review with explicit override clause | speech-religion | 8278 | 1.000 | 0.111 | 0.732 | 0.651 | 0.586 | 0.463 | 0.324 | 0.622 | 0.327 | 0.631 | 0.861 | 0.082 | 0.647 | 0.262 | 0.599 | 2.231 | 0.447 | 0.450 | 0.598 | 0.599 | 0.103 | 0.058 | 0.460 | 0.079 | 0.555 | 0.537 | 0.416 |
| Pre-enactment review before laws take effect | administration | 6591 | 1.000 | 0.859 | 0.775 | 0.672 | 0.563 | 0.499 | 0.403 | 0.617 | 0.527 | 0.578 | 0.828 | 0.072 | 0.626 | 0.171 | 0.009 | 2.700 | 0.468 | 0.511 | 0.672 | 0.663 | 0.118 | 0.033 | 0.496 | 0.112 | 0.459 | 0.413 | 0.443 |
| Pre-enactment review before laws take effect | civil-rights | 11836 | 1.000 | 0.870 | 0.771 | 0.657 | 0.595 | 0.569 | 0.323 | 0.613 | 0.494 | 0.579 | 0.840 | 0.082 | 0.693 | 0.247 | 0.593 | 2.265 | 0.503 | 0.461 | 0.630 | 0.638 | 0.088 | 0.052 | 0.464 | 0.104 | 0.483 | 0.427 | 0.431 |
| Pre-enactment review before laws take effect | criminal-justice | 10046 | 1.000 | 0.862 | 0.749 | 0.652 | 0.583 | 0.547 | 0.347 | 0.613 | 0.502 | 0.579 | 0.841 | 0.092 | 0.658 | 0.267 | 0.435 | 2.325 | 0.562 | 0.491 | 0.628 | 0.629 | 0.095 | 0.045 | 0.446 | 0.106 | 0.473 | 0.418 | 0.433 |
| Pre-enactment review before laws take effect | economic-regulation | 6433 | 1.000 | 0.858 | 0.782 | 0.671 | 0.561 | 0.498 | 0.380 | 0.615 | 0.528 | 0.578 | 0.838 | 0.071 | 0.655 | 0.155 | 0.013 | 2.719 | 0.597 | 0.545 | 0.647 | 0.654 | 0.099 | 0.037 | 0.452 | 0.109 | 0.463 | 0.414 | 0.447 |
| Pre-enactment review before laws take effect | elections | 10115 | 1.000 | 0.864 | 0.767 | 0.651 | 0.589 | 0.550 | 0.346 | 0.609 | 0.516 | 0.578 | 0.851 | 0.070 | 0.695 | 0.242 | 0.472 | 2.721 | 0.663 | 0.514 | 0.634 | 0.620 | 0.093 | 0.047 | 0.413 | 0.102 | 0.477 | 0.418 | 0.448 |
| Pre-enactment review before laws take effect | emergency-security | 9912 | 1.000 | 0.713 | 0.762 | 0.652 | 0.569 | 0.524 | 0.393 | 0.612 | 0.527 | 0.578 | 0.840 | 0.140 | 0.770 | 0.255 | 0.172 | 1.984 | 0.531 | 0.491 | 0.634 | 0.638 | 0.088 | 0.041 | 0.465 | 0.106 | 0.466 | 0.410 | 0.440 |
| Pre-enactment review before laws take effect | federalism | 7189 | 1.000 | 0.864 | 0.788 | 0.669 | 0.559 | 0.506 | 0.372 | 0.612 | 0.530 | 0.578 | 0.851 | 0.069 | 0.633 | 0.189 | 0.010 | 2.756 | 0.753 | 0.585 | 0.642 | 0.655 | 0.078 | 0.041 | 0.406 | 0.107 | 0.457 | 0.403 | 0.451 |
| Pre-enactment review before laws take effect | speech-religion | 8278 | 1.000 | 0.878 | 0.762 | 0.659 | 0.587 | 0.560 | 0.324 | 0.616 | 0.495 | 0.579 | 0.833 | 0.079 | 0.667 | 0.238 | 0.461 | 2.231 | 0.447 | 0.450 | 0.641 | 0.635 | 0.087 | 0.045 | 0.492 | 0.104 | 0.477 | 0.423 | 0.427 |
| Abstract review tribunal | administration | 6591 | 1.000 | 0.918 | 0.777 | 0.682 | 0.561 | 0.503 | 0.403 | 0.619 | 0.325 | 0.563 | 0.897 | 0.003 | 0.768 | 0.066 | 0.039 | 2.700 | 0.468 | 0.511 | 0.634 | 0.645 | 0.137 | 0.041 | 0.475 | 0.085 | 0.566 | 0.555 | 0.443 |
| Abstract review tribunal | civil-rights | 11836 | 1.000 | 0.921 | 0.777 | 0.658 | 0.608 | 0.572 | 0.323 | 0.613 | 0.298 | 0.563 | 0.911 | 0.011 | 0.780 | 0.087 | 0.720 | 2.265 | 0.503 | 0.461 | 0.602 | 0.596 | 0.117 | 0.064 | 0.434 | 0.075 | 0.596 | 0.572 | 0.426 |
| Abstract review tribunal | criminal-justice | 10046 | 1.000 | 0.918 | 0.763 | 0.658 | 0.598 | 0.550 | 0.347 | 0.614 | 0.304 | 0.564 | 0.912 | 0.008 | 0.778 | 0.097 | 0.583 | 2.325 | 0.562 | 0.491 | 0.602 | 0.604 | 0.111 | 0.063 | 0.407 | 0.076 | 0.588 | 0.568 | 0.427 |
| Abstract review tribunal | economic-regulation | 6433 | 1.000 | 0.923 | 0.784 | 0.681 | 0.559 | 0.503 | 0.380 | 0.616 | 0.325 | 0.563 | 0.908 | 0.003 | 0.764 | 0.053 | 0.043 | 2.719 | 0.597 | 0.545 | 0.625 | 0.620 | 0.117 | 0.042 | 0.425 | 0.081 | 0.571 | 0.557 | 0.449 |
| Abstract review tribunal | elections | 10115 | 1.000 | 0.921 | 0.766 | 0.647 | 0.601 | 0.554 | 0.346 | 0.606 | 0.321 | 0.562 | 0.923 | 0.010 | 0.764 | 0.110 | 0.625 | 2.721 | 0.663 | 0.514 | 0.588 | 0.597 | 0.115 | 0.067 | 0.385 | 0.074 | 0.595 | 0.569 | 0.454 |
| Abstract review tribunal | emergency-security | 9912 | 1.000 | 0.771 | 0.770 | 0.660 | 0.578 | 0.530 | 0.393 | 0.613 | 0.325 | 0.563 | 0.909 | 0.025 | 0.865 | 0.167 | 0.303 | 1.984 | 0.531 | 0.491 | 0.615 | 0.606 | 0.110 | 0.050 | 0.443 | 0.079 | 0.575 | 0.554 | 0.443 |
| Abstract review tribunal | federalism | 7189 | 1.000 | 0.922 | 0.790 | 0.678 | 0.558 | 0.511 | 0.372 | 0.612 | 0.327 | 0.562 | 0.921 | 0.003 | 0.745 | 0.072 | 0.057 | 2.756 | 0.753 | 0.585 | 0.605 | 0.611 | 0.094 | 0.048 | 0.368 | 0.080 | 0.567 | 0.550 | 0.456 |
| Abstract review tribunal | speech-religion | 8278 | 1.000 | 0.925 | 0.774 | 0.663 | 0.600 | 0.563 | 0.324 | 0.617 | 0.298 | 0.564 | 0.904 | 0.009 | 0.773 | 0.107 | 0.604 | 2.231 | 0.447 | 0.450 | 0.604 | 0.614 | 0.110 | 0.061 | 0.454 | 0.076 | 0.592 | 0.571 | 0.419 |
| Ombudsman-triggered constitutional review | administration | 6591 | 1.000 | 0.008 | 0.765 | 0.657 | 0.561 | 0.392 | 0.403 | 0.609 | 0.536 | 0.602 | 0.769 | 0.073 | 0.627 | 0.180 | 0.076 | 2.700 | 0.468 | 0.511 | 0.584 | 0.586 | 0.160 | 0.047 | 0.419 | 0.065 | 0.648 | 0.622 | 0.522 |
| Ombudsman-triggered constitutional review | civil-rights | 11836 | 1.000 | 0.010 | 0.729 | 0.621 | 0.602 | 0.461 | 0.323 | 0.602 | 0.510 | 0.602 | 0.783 | 0.088 | 0.661 | 0.230 | 0.765 | 2.265 | 0.503 | 0.461 | 0.556 | 0.548 | 0.129 | 0.068 | 0.393 | 0.058 | 0.674 | 0.638 | 0.512 |
| Ombudsman-triggered constitutional review | criminal-justice | 10046 | 1.000 | 0.009 | 0.723 | 0.622 | 0.592 | 0.439 | 0.347 | 0.602 | 0.516 | 0.602 | 0.785 | 0.099 | 0.651 | 0.251 | 0.646 | 2.325 | 0.562 | 0.491 | 0.557 | 0.557 | 0.126 | 0.067 | 0.363 | 0.059 | 0.666 | 0.632 | 0.514 |
| Ombudsman-triggered constitutional review | economic-regulation | 6433 | 1.000 | 0.008 | 0.770 | 0.655 | 0.560 | 0.391 | 0.380 | 0.606 | 0.537 | 0.602 | 0.779 | 0.074 | 0.651 | 0.210 | 0.090 | 2.719 | 0.597 | 0.545 | 0.566 | 0.580 | 0.126 | 0.048 | 0.383 | 0.064 | 0.652 | 0.624 | 0.525 |
| Ombudsman-triggered constitutional review | elections | 10115 | 1.000 | 0.010 | 0.719 | 0.612 | 0.599 | 0.442 | 0.346 | 0.598 | 0.532 | 0.601 | 0.794 | 0.077 | 0.686 | 0.238 | 0.687 | 2.721 | 0.663 | 0.514 | 0.542 | 0.545 | 0.125 | 0.073 | 0.332 | 0.056 | 0.674 | 0.637 | 0.525 |
| Ombudsman-triggered constitutional review | emergency-security | 9912 | 1.000 | 0.009 | 0.731 | 0.624 | 0.578 | 0.431 | 0.393 | 0.602 | 0.526 | 0.602 | 0.782 | 0.151 | 0.739 | 0.286 | 0.403 | 1.984 | 0.531 | 0.491 | 0.552 | 0.560 | 0.124 | 0.065 | 0.388 | 0.059 | 0.659 | 0.621 | 0.515 |
| Ombudsman-triggered constitutional review | federalism | 7189 | 1.000 | 0.009 | 0.775 | 0.652 | 0.559 | 0.399 | 0.372 | 0.603 | 0.538 | 0.601 | 0.792 | 0.072 | 0.631 | 0.196 | 0.103 | 2.756 | 0.753 | 0.585 | 0.566 | 0.569 | 0.113 | 0.050 | 0.335 | 0.061 | 0.649 | 0.617 | 0.528 |
| Ombudsman-triggered constitutional review | speech-religion | 8278 | 1.000 | 0.009 | 0.730 | 0.627 | 0.596 | 0.451 | 0.324 | 0.604 | 0.510 | 0.602 | 0.776 | 0.086 | 0.670 | 0.255 | 0.665 | 2.231 | 0.447 | 0.450 | 0.551 | 0.558 | 0.127 | 0.067 | 0.411 | 0.057 | 0.674 | 0.640 | 0.509 |
| Constitutional public defender access model | administration | 6591 | 1.000 | 0.008 | 0.783 | 0.668 | 0.562 | 0.392 | 0.403 | 0.607 | 0.523 | 0.630 | 0.738 | 0.001 | 0.789 | 0.064 | 0.071 | 2.700 | 0.468 | 0.511 | 0.584 | 0.586 | 0.160 | 0.048 | 0.424 | 0.067 | 0.657 | 0.654 | 0.525 |
| Constitutional public defender access model | civil-rights | 11836 | 1.000 | 0.009 | 0.793 | 0.643 | 0.610 | 0.461 | 0.323 | 0.600 | 0.499 | 0.630 | 0.753 | 0.008 | 0.788 | 0.083 | 0.776 | 2.265 | 0.503 | 0.461 | 0.565 | 0.574 | 0.128 | 0.070 | 0.386 | 0.061 | 0.683 | 0.666 | 0.513 |
| Constitutional public defender access model | criminal-justice | 10046 | 1.000 | 0.009 | 0.784 | 0.644 | 0.601 | 0.439 | 0.347 | 0.601 | 0.505 | 0.630 | 0.755 | 0.006 | 0.797 | 0.082 | 0.650 | 2.325 | 0.562 | 0.491 | 0.561 | 0.566 | 0.129 | 0.073 | 0.375 | 0.061 | 0.676 | 0.663 | 0.516 |
| Constitutional public defender access model | economic-regulation | 6433 | 1.000 | 0.008 | 0.785 | 0.665 | 0.561 | 0.391 | 0.380 | 0.605 | 0.524 | 0.630 | 0.748 | 0.001 | 0.781 | 0.082 | 0.083 | 2.719 | 0.597 | 0.545 | 0.559 | 0.585 | 0.130 | 0.048 | 0.383 | 0.067 | 0.662 | 0.657 | 0.527 |
| Constitutional public defender access model | elections | 10115 | 1.000 | 0.009 | 0.763 | 0.628 | 0.605 | 0.442 | 0.346 | 0.597 | 0.521 | 0.629 | 0.764 | 0.008 | 0.808 | 0.121 | 0.691 | 2.721 | 0.663 | 0.514 | 0.546 | 0.547 | 0.135 | 0.075 | 0.332 | 0.059 | 0.685 | 0.668 | 0.526 |
| Constitutional public defender access model | emergency-security | 9912 | 1.000 | 0.009 | 0.769 | 0.644 | 0.584 | 0.431 | 0.393 | 0.603 | 0.514 | 0.630 | 0.750 | 0.018 | 0.866 | 0.155 | 0.401 | 1.984 | 0.531 | 0.491 | 0.570 | 0.575 | 0.125 | 0.063 | 0.390 | 0.064 | 0.666 | 0.654 | 0.516 |
| Constitutional public defender access model | federalism | 7189 | 1.000 | 0.008 | 0.789 | 0.661 | 0.560 | 0.399 | 0.372 | 0.602 | 0.527 | 0.629 | 0.762 | 0.001 | 0.765 | 0.083 | 0.107 | 2.756 | 0.753 | 0.585 | 0.555 | 0.571 | 0.114 | 0.051 | 0.322 | 0.066 | 0.660 | 0.650 | 0.531 |
| Constitutional public defender access model | speech-religion | 8278 | 1.000 | 0.008 | 0.789 | 0.647 | 0.604 | 0.451 | 0.324 | 0.603 | 0.499 | 0.630 | 0.746 | 0.007 | 0.791 | 0.106 | 0.672 | 2.231 | 0.447 | 0.450 | 0.563 | 0.576 | 0.122 | 0.072 | 0.412 | 0.061 | 0.683 | 0.667 | 0.510 |
| Rights-impact statements before review | administration | 6591 | 1.000 | 0.863 | 0.825 | 0.695 | 0.566 | 0.499 | 0.403 | 0.616 | 0.520 | 0.697 | 0.705 | 0.070 | 0.645 | 0.150 | 0.004 | 2.700 | 0.468 | 0.511 | 0.674 | 0.670 | 0.115 | 0.033 | 0.510 | 0.136 | 0.427 | 0.378 | 0.445 |
| Rights-impact statements before review | civil-rights | 11836 | 1.000 | 0.873 | 0.806 | 0.678 | 0.595 | 0.569 | 0.323 | 0.612 | 0.484 | 0.698 | 0.715 | 0.081 | 0.712 | 0.240 | 0.553 | 2.265 | 0.503 | 0.461 | 0.647 | 0.646 | 0.089 | 0.050 | 0.479 | 0.127 | 0.451 | 0.393 | 0.429 |
| Rights-impact statements before review | criminal-justice | 10046 | 1.000 | 0.864 | 0.790 | 0.674 | 0.583 | 0.547 | 0.347 | 0.613 | 0.493 | 0.698 | 0.717 | 0.090 | 0.682 | 0.255 | 0.387 | 2.325 | 0.562 | 0.491 | 0.646 | 0.643 | 0.090 | 0.041 | 0.464 | 0.132 | 0.442 | 0.386 | 0.433 |
| Rights-impact statements before review | economic-regulation | 6433 | 1.000 | 0.858 | 0.832 | 0.694 | 0.564 | 0.498 | 0.380 | 0.613 | 0.521 | 0.697 | 0.715 | 0.071 | 0.660 | 0.156 | 0.008 | 2.719 | 0.597 | 0.545 | 0.671 | 0.665 | 0.096 | 0.033 | 0.483 | 0.135 | 0.427 | 0.375 | 0.449 |
| Rights-impact statements before review | elections | 10115 | 1.000 | 0.865 | 0.798 | 0.671 | 0.589 | 0.550 | 0.346 | 0.609 | 0.505 | 0.697 | 0.727 | 0.068 | 0.688 | 0.280 | 0.422 | 2.721 | 0.663 | 0.514 | 0.639 | 0.634 | 0.088 | 0.050 | 0.431 | 0.127 | 0.444 | 0.384 | 0.446 |
| Rights-impact statements before review | emergency-security | 9912 | 1.000 | 0.713 | 0.791 | 0.671 | 0.571 | 0.524 | 0.393 | 0.612 | 0.516 | 0.697 | 0.716 | 0.137 | 0.768 | 0.241 | 0.141 | 1.984 | 0.531 | 0.491 | 0.657 | 0.650 | 0.081 | 0.038 | 0.483 | 0.133 | 0.432 | 0.374 | 0.438 |
| Rights-impact statements before review | federalism | 7189 | 1.000 | 0.866 | 0.838 | 0.692 | 0.562 | 0.507 | 0.372 | 0.610 | 0.522 | 0.697 | 0.728 | 0.068 | 0.646 | 0.190 | 0.009 | 2.756 | 0.753 | 0.585 | 0.657 | 0.662 | 0.076 | 0.033 | 0.420 | 0.136 | 0.424 | 0.368 | 0.453 |
| Rights-impact statements before review | speech-religion | 8278 | 1.000 | 0.880 | 0.796 | 0.680 | 0.588 | 0.560 | 0.324 | 0.615 | 0.485 | 0.698 | 0.709 | 0.078 | 0.697 | 0.240 | 0.425 | 2.231 | 0.447 | 0.450 | 0.655 | 0.658 | 0.083 | 0.041 | 0.502 | 0.128 | 0.444 | 0.386 | 0.427 |
| Mandatory legislative response cycles | administration | 6591 | 1.000 | 0.898 | 0.761 | 0.691 | 0.563 | 0.502 | 0.403 | 0.627 | 0.294 | 0.614 | 0.912 | 0.001 | 0.779 | 0.030 | 0.033 | 2.700 | 0.468 | 0.511 | 0.672 | 0.662 | 0.119 | 0.035 | 0.493 | 0.136 | 0.435 | 0.440 | 0.400 |
| Mandatory legislative response cycles | civil-rights | 11836 | 1.000 | 0.905 | 0.698 | 0.672 | 0.611 | 0.572 | 0.323 | 0.625 | 0.161 | 0.614 | 0.919 | 0.008 | 0.802 | 0.112 | 0.687 | 2.265 | 0.503 | 0.461 | 0.630 | 0.634 | 0.093 | 0.060 | 0.453 | 0.126 | 0.459 | 0.456 | 0.390 |
| Mandatory legislative response cycles | criminal-justice | 10046 | 1.000 | 0.902 | 0.701 | 0.673 | 0.600 | 0.549 | 0.347 | 0.625 | 0.192 | 0.614 | 0.921 | 0.005 | 0.806 | 0.092 | 0.537 | 2.325 | 0.562 | 0.491 | 0.631 | 0.639 | 0.097 | 0.063 | 0.449 | 0.128 | 0.449 | 0.449 | 0.392 |
| Mandatory legislative response cycles | economic-regulation | 6433 | 1.000 | 0.898 | 0.768 | 0.690 | 0.562 | 0.501 | 0.380 | 0.624 | 0.294 | 0.614 | 0.922 | 0.001 | 0.796 | 0.039 | 0.042 | 2.719 | 0.597 | 0.545 | 0.642 | 0.658 | 0.105 | 0.040 | 0.451 | 0.133 | 0.438 | 0.439 | 0.403 |
| Mandatory legislative response cycles | elections | 10115 | 1.000 | 0.902 | 0.691 | 0.661 | 0.606 | 0.553 | 0.346 | 0.620 | 0.199 | 0.613 | 0.931 | 0.007 | 0.793 | 0.115 | 0.594 | 2.721 | 0.663 | 0.514 | 0.616 | 0.625 | 0.097 | 0.066 | 0.413 | 0.123 | 0.456 | 0.450 | 0.405 |
| Mandatory legislative response cycles | emergency-security | 9912 | 1.000 | 0.749 | 0.719 | 0.675 | 0.579 | 0.528 | 0.393 | 0.625 | 0.244 | 0.614 | 0.919 | 0.013 | 0.867 | 0.122 | 0.266 | 1.984 | 0.531 | 0.491 | 0.632 | 0.642 | 0.097 | 0.047 | 0.463 | 0.132 | 0.439 | 0.435 | 0.395 |
| Mandatory legislative response cycles | federalism | 7189 | 1.000 | 0.899 | 0.774 | 0.688 | 0.561 | 0.509 | 0.372 | 0.621 | 0.295 | 0.613 | 0.934 | 0.001 | 0.796 | 0.048 | 0.054 | 2.756 | 0.753 | 0.585 | 0.639 | 0.650 | 0.075 | 0.047 | 0.409 | 0.131 | 0.432 | 0.427 | 0.407 |
| Mandatory legislative response cycles | speech-religion | 8278 | 1.000 | 0.909 | 0.703 | 0.676 | 0.602 | 0.562 | 0.324 | 0.627 | 0.180 | 0.614 | 0.913 | 0.006 | 0.797 | 0.087 | 0.564 | 2.231 | 0.447 | 0.450 | 0.644 | 0.647 | 0.095 | 0.053 | 0.485 | 0.128 | 0.453 | 0.451 | 0.387 |

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
| Weak-form review with legislative reply | 1 | 880 | 9.000 | 0.001 | 0.792 | 0.503 | 0.718 | 0.786 | 0.000 |
| Weak-form review with legislative reply | 2 | 880 | 9.000 | -0.003 | 0.807 | 0.503 | 0.717 | 0.786 | 3.611 |
| Weak-form review with legislative reply | 3 | 880 | 9.000 | 0.003 | 0.832 | 0.502 | 0.716 | 0.785 | 3.611 |
| Weak-form review with legislative reply | 4 | 880 | 9.000 | -0.012 | 0.858 | 0.502 | 0.716 | 0.786 | 3.611 |
| Suspended declarations of invalidity | 1 | 880 | 11.000 | -0.001 | 0.792 | 0.513 | 0.755 | 0.780 | 0.000 |
| Suspended declarations of invalidity | 2 | 880 | 11.000 | 0.003 | 0.827 | 0.512 | 0.754 | 0.779 | 5.139 |
| Suspended declarations of invalidity | 3 | 880 | 11.000 | 0.000 | 0.846 | 0.512 | 0.754 | 0.779 | 5.139 |
| Suspended declarations of invalidity | 4 | 880 | 11.000 | -0.000 | 0.876 | 0.513 | 0.754 | 0.780 | 5.139 |
| Strong-form review with explicit override clause | 1 | 880 | 9.000 | 0.030 | 1.351 | 0.584 | 0.715 | 0.768 | 0.000 |
| Strong-form review with explicit override clause | 2 | 880 | 9.000 | 0.028 | 1.348 | 0.585 | 0.715 | 0.768 | 3.535 |
| Strong-form review with explicit override clause | 3 | 880 | 9.000 | 0.031 | 1.366 | 0.584 | 0.715 | 0.768 | 3.535 |
| Strong-form review with explicit override clause | 4 | 880 | 9.000 | 0.031 | 1.374 | 0.584 | 0.715 | 0.767 | 3.535 |
| Pre-enactment review before laws take effect | 1 | 880 | 12.000 | 0.000 | 0.622 | 0.475 | 0.752 | 0.799 | 0.000 |
| Pre-enactment review before laws take effect | 2 | 880 | 12.000 | -0.009 | 0.667 | 0.474 | 0.751 | 0.799 | 8.654 |
| Pre-enactment review before laws take effect | 3 | 880 | 12.000 | 0.012 | 0.724 | 0.474 | 0.750 | 0.798 | 8.654 |
| Pre-enactment review before laws take effect | 4 | 880 | 12.000 | -0.004 | 0.792 | 0.474 | 0.749 | 0.799 | 8.654 |
| Abstract review tribunal | 1 | 880 | 15.000 | -0.001 | 0.819 | 0.512 | 0.763 | 0.815 | 0.000 |
| Abstract review tribunal | 2 | 880 | 15.000 | -0.003 | 0.846 | 0.512 | 0.762 | 0.815 | 6.756 |
| Abstract review tribunal | 3 | 880 | 15.000 | 0.001 | 0.890 | 0.513 | 0.763 | 0.815 | 6.756 |
| Abstract review tribunal | 4 | 880 | 15.000 | -0.001 | 0.916 | 0.512 | 0.762 | 0.815 | 6.756 |
| Ombudsman-triggered constitutional review | 1 | 880 | 11.000 | -0.004 | 0.614 | 0.494 | 0.780 | 0.761 | 0.000 |
| Ombudsman-triggered constitutional review | 2 | 880 | 11.000 | 0.007 | 0.639 | 0.493 | 0.780 | 0.761 | 5.232 |
| Ombudsman-triggered constitutional review | 3 | 880 | 11.000 | -0.002 | 0.682 | 0.493 | 0.780 | 0.761 | 5.232 |
| Ombudsman-triggered constitutional review | 4 | 880 | 11.000 | 0.005 | 0.717 | 0.494 | 0.780 | 0.762 | 5.232 |
| Constitutional public defender access model | 1 | 880 | 11.000 | 0.000 | 0.609 | 0.503 | 0.796 | 0.757 | 0.000 |
| Constitutional public defender access model | 2 | 880 | 11.000 | -0.001 | 0.641 | 0.503 | 0.797 | 0.757 | 5.170 |
| Constitutional public defender access model | 3 | 880 | 11.000 | -0.004 | 0.683 | 0.503 | 0.795 | 0.757 | 5.170 |
| Constitutional public defender access model | 4 | 880 | 11.000 | 0.002 | 0.725 | 0.503 | 0.795 | 0.757 | 5.170 |
| Rights-impact statements before review | 1 | 880 | 9.000 | 0.016 | 1.515 | 0.557 | 0.726 | 0.775 | 0.000 |
| Rights-impact statements before review | 2 | 880 | 9.000 | 0.014 | 1.517 | 0.556 | 0.728 | 0.776 | 6.667 |
| Rights-impact statements before review | 3 | 880 | 9.000 | 0.006 | 1.531 | 0.558 | 0.727 | 0.775 | 6.667 |
| Rights-impact statements before review | 4 | 880 | 9.000 | 0.017 | 1.554 | 0.557 | 0.727 | 0.775 | 6.667 |
| Mandatory legislative response cycles | 1 | 880 | 9.000 | -0.000 | 0.789 | 0.498 | 0.732 | 0.775 | 0.000 |
| Mandatory legislative response cycles | 2 | 880 | 9.000 | -0.004 | 0.809 | 0.498 | 0.732 | 0.775 | 4.457 |
| Mandatory legislative response cycles | 3 | 880 | 9.000 | 0.009 | 0.837 | 0.498 | 0.732 | 0.775 | 4.457 |
| Mandatory legislative response cycles | 4 | 880 | 9.000 | 0.005 | 0.865 | 0.498 | 0.733 | 0.774 | 4.457 |

## Uncertainty Diagnostics

Campaign and segment CSV artifacts include 95% uncertainty bands using `cluster-bootstrap-runs-200-95` from the compressed case-level export. The bootstrap resamples whole generated-world run blocks, preserving within-run case dependence. Composition and calibration interval artifacts still use `conservative-bounded-normal-95` when no case-level analogue exists.

| Scenario | Median score band width | Median cost band width |
| --- | ---: | ---: |
| Current-style federal supreme court | 0.024 | 0.024 |
| Staggered 18-year nonrenewable terms | 0.024 | 0.024 |
| Fifteen-justice supermajority commission court | 0.024 | 0.024 |
| Supermajority required to invalidate laws | 0.024 | 0.024 |
| Strict recusal with substitute justices | 0.024 | 0.024 |
| Reasoned emergency orders with merits follow-up | 0.024 | 0.024 |
| Panel review with en banc safety valve | 0.024 | 0.024 |
| Dual supreme courts with cross-checking invalidations | 0.024 | 0.024 |
| Pre-enactment constitutional council | 0.024 | 0.024 |
| Judicial review with delayed legislative override | 0.024 | 0.024 |
| Retention-election accountability court | 0.024 | 0.024 |
| Hybrid court balancing independence and accountability | 0.024 | 0.024 |
| Weak-form review with legislative reply | 0.022 | 0.024 |
| Suspended declarations of invalidity | 0.023 | 0.024 |
| Strong-form review with explicit override clause | 0.024 | 0.024 |
| Pre-enactment review before laws take effect | 0.023 | 0.024 |
| Abstract review tribunal | 0.023 | 0.024 |
| Ombudsman-triggered constitutional review | 0.024 | 0.024 |
| Constitutional public defender access model | 0.024 | 0.024 |
| Rights-impact statements before review | 0.023 | 0.024 |
| Mandatory legislative response cycles | 0.023 | 0.024 |

## Calibration Diagnostics

| Profile | Target | Model | Empirical | 95% band | Range | Reliability | Validation | Gap | Status |
| --- | --- | ---: | ---: | ---: | ---: | --- | ---: | ---: | --- |
| canada-charter-dialogue-1982-2007 | Statute nullification among federal and provincial statute dispositions | 0.330 | 0.380 | 0.326-0.335 | 0.259-0.519 | medium | true | 0.000 | within |
| canada-charter-dialogue-1982-2007 | Legislative response after Charter invalidation | 0.138 | 0.803 | 0.138-0.139 | 0.692-0.881 | medium | true | 0.554 | outside |
| canada-charter-dialogue-1982-2007 | Formal override after Charter invalidation | 0.011 | 0.015 | 0.011-0.012 | 0.003-0.081 | medium | true | 0.000 | within |
| canada-charter-dialogue-1982-2007 | Effective overruling or reenactment after Charter invalidation | 0.075 | 0.030 | 0.074-0.075 | 0.008-0.104 | medium | true | 0.000 | within |
| canada-charter-dialogue-1982-2007 | Legislative response after Charter invalidation update period | 0.138 | 0.609 | 0.138-0.139 | 0.408-0.778 | medium | true | 0.270 | outside |
| canada-charter-dialogue-1982-2007 | Formal override after Charter invalidation update period | 0.011 | 0.000 | 0.011-0.012 | 0.000-0.143 | medium | true | 0.000 | within |
| canada-charter-dialogue-1982-2007 | Reenactment after Charter invalidation update period | 0.075 | 0.000 | 0.074-0.075 | 0.000-0.143 | medium | true | 0.000 | within |
| canada-scc-2024 | Leave application grant rate | 0.028 | 0.067 | 0.028-0.028 | 0.060-0.075 | high | true | 0.032 | outside |
| canada-scc-recent | Leave application grant rate | 0.028 | 0.077 | 0.028-0.028 | 0.070-0.084 | high | true | 0.042 | outside |
| canada-scc-recent | Public trust proxy | 0.083 | 0.490 | 0.082-0.083 | 0.430-0.550 | medium | false | 0.347 | outside |
| canada-scc-recent | Normalized direct court cost | 0.365 | 0.550 | 0.365-0.366 | 0.490-0.610 | medium | false | 0.125 | outside |
| cjeu-2024 | Preliminary-reference docket share | 0.000 | 0.623 | 0.000-0.000 | 0.613-0.633 | high | true | 0.613 | outside |
| cjeu-2024 | Appeal route docket share | 0.000 | 0.301 | 0.000-0.000 | 0.292-0.311 | high | true | 0.292 | outside |
| cjeu-2024 | Direct-action docket share | 0.000 | 0.058 | 0.000-0.000 | 0.052-0.064 | high | true | 0.052 | outside |
| cjeu-2024 | Full compliance with rule-of-law rulings | 0.585 | 0.584 | 0.584-0.586 | 0.534-0.632 | medium | true | 0.000 | within |
| echr-2024 | Probable Chamber or Committee case share | 0.028 | 0.316 | 0.028-0.028 | 0.305-0.326 | medium | true | 0.277 | outside |
| echr-2024 | Rule 39 interim-measure grant rate | 0.481 | 0.228 | 0.479-0.482 | 0.218-0.238 | high | true | 0.243 | outside |
| france-conseil-qpc | QPC nonconformity rate | 0.389 | 0.315 | 0.389-0.390 | 0.305-0.324 | high | true | 0.065 | outside |
| france-conseil-qpc | QPC deferred-effect share over all solutions | 0.022 | 0.134 | 0.022-0.022 | 0.126-0.141 | high | true | 0.104 | outside |
| france-conseil-qpc | Public trust proxy | 0.083 | 0.500 | 0.082-0.083 | 0.430-0.570 | low | false | 0.347 | outside |
| france-conseil-qpc | Normalized direct court cost | 0.365 | 0.340 | 0.365-0.366 | 0.280-0.400 | medium | false | 0.000 | within |
| france-conseil-qpc | Normalized upstream screening cost | 0.629 | 0.590 | 0.628-0.630 | 0.520-0.660 | medium | false | 0.000 | within |
| germany-bverfg-2024 | Constitutional complaint success and admission proxy | 0.028 | 0.009 | 0.028-0.028 | 0.006-0.012 | high | true | 0.016 | outside |
| germany-bverfg-2024 | Public trust proxy | 0.083 | 0.740 | 0.082-0.083 | 0.680-0.800 | medium | false | 0.597 | outside |
| germany-bverfg-2024 | Normalized direct court cost | 0.365 | 0.620 | 0.365-0.366 | 0.560-0.680 | medium | false | 0.195 | outside |
| germany-bverfg-2024 | Normalized capacity strain | 0.411 | 0.560 | 0.410-0.411 | 0.500-0.640 | medium | false | 0.089 | outside |
| cost-us-supreme-court | Normalized direct court cost | 0.365 | 0.740 | 0.365-0.366 | 0.690-0.790 | medium | false | 0.325 | outside |
| cost-us-supreme-court | Normalized capacity strain | 0.411 | 0.480 | 0.410-0.411 | 0.420-0.540 | medium | false | 0.009 | outside |
| cost-uk-supreme-court | Normalized direct court cost | 0.365 | 0.430 | 0.365-0.366 | 0.370-0.490 | medium | false | 0.005 | outside |
| cost-france-conseil | Normalized direct court cost | 0.365 | 0.340 | 0.365-0.366 | 0.280-0.400 | medium | false | 0.000 | within |
| south-africa-constcourt-recent | Merits invalidation proxy | 0.389 | 0.532 | 0.389-0.390 | 0.470-0.590 | medium | false | 0.081 | outside |
| south-africa-constcourt-recent | Petition-to-judgment throughput proxy | 0.028 | 0.141 | 0.028-0.028 | 0.109-0.181 | medium | true | 0.081 | outside |
| south-africa-constcourt-recent | Public trust proxy | 0.083 | 0.430 | 0.082-0.083 | 0.360-0.500 | medium | false | 0.277 | outside |
| south-africa-constcourt-recent | Normalized capacity strain | 0.411 | 0.680 | 0.410-0.411 | 0.610-0.750 | medium | false | 0.199 | outside |
| uk-human-rights-doi-2025 | Strict response after declarations of incompatibility | 0.075 | 0.444 | 0.074-0.075 | 0.430-0.460 | medium | true | 0.355 | outside |
| uk-human-rights-doi-2025 | Statutory amendment or repeal after declarations of incompatibility | 0.581 | 0.429 | 0.580-0.582 | 0.410-0.450 | medium | true | 0.131 | outside |
| uk-supreme-court-2024-2025 | Permission-to-appeal grant rate | 0.028 | 0.361 | 0.028-0.028 | 0.345-0.375 | high | true | 0.317 | outside |
| uk-supreme-court-2024-2025 | Permission-to-appeal case-selection access proxy | 0.463 | 0.361 | 0.462-0.464 | 0.345-0.375 | high | true | 0.088 | outside |
| scdb-postwar-merits-1946-2024 | Speech docket share | 0.144 | 0.076 | 0.143-0.144 | 0.060-0.091 | high | true | 0.053 | outside |
| scdb-postwar-merits-1946-2024 | Civil-rights and privacy docket share | 0.142 | 0.152 | 0.141-0.143 | 0.135-0.169 | high | true | 0.000 | within |
| scdb-postwar-merits-1946-2024 | Criminal procedure docket share | 0.143 | 0.225 | 0.142-0.143 | 0.207-0.244 | high | true | 0.064 | outside |
| scdb-postwar-merits-1946-2024 | Federalism docket share | 0.143 | 0.056 | 0.142-0.143 | 0.041-0.071 | high | true | 0.072 | outside |
| scdb-postwar-merits-1946-2024 | Election-law docket share | 0.144 | 0.026 | 0.143-0.144 | 0.013-0.040 | medium | true | 0.104 | outside |
| scdb-postwar-merits-1946-2024 | Emergency-powers merits share | 0.141 | 0.001 | 0.140-0.141 | 0.000-0.012 | medium | true | 0.129 | outside |
| scdb-postwar-merits-1946-2024 | Administrative and economic regulation share | 0.144 | 0.217 | 0.144-0.145 | 0.199-0.236 | medium | true | 0.055 | outside |
| scdb-modern-merits-2000-2024 | Speech docket share | 0.144 | 0.059 | 0.143-0.144 | 0.039-0.080 | high | true | 0.064 | outside |
| scdb-modern-merits-2000-2024 | Civil-rights and privacy docket share | 0.142 | 0.164 | 0.141-0.143 | 0.137-0.191 | high | true | 0.000 | within |
| scdb-modern-merits-2000-2024 | Criminal procedure docket share | 0.143 | 0.259 | 0.142-0.143 | 0.230-0.289 | high | true | 0.087 | outside |
| scdb-modern-merits-2000-2024 | Federalism docket share | 0.143 | 0.057 | 0.142-0.143 | 0.037-0.078 | high | true | 0.065 | outside |
| scdb-modern-merits-2000-2024 | Election-law docket share | 0.144 | 0.026 | 0.143-0.144 | 0.009-0.043 | medium | true | 0.101 | outside |
| scdb-modern-merits-2000-2024 | Emergency-powers merits share | 0.141 | 0.005 | 0.140-0.141 | 0.000-0.019 | medium | true | 0.122 | outside |
| scdb-modern-merits-2000-2024 | Administrative and economic regulation share | 0.144 | 0.222 | 0.144-0.145 | 0.193-0.250 | medium | true | 0.049 | outside |
| scotus-emergency-2024-2025 | Substantive emergency application relief rate | 0.481 | 0.440 | 0.479-0.482 | 0.310-0.460 | medium | true | 0.021 | outside |
| scotus-emergency-2024-2025 | Written explanation share | 0.697 | 0.279 | 0.695-0.698 | 0.200-0.360 | medium | true | 0.337 | outside |
| scotus-emergency-2024-2025 | Public disagreement share | 0.245 | 0.670 | 0.244-0.246 | 0.570-0.760 | medium | true | 0.325 | outside |
| scotus-emergency-2024-2025 | Certiorari or emergency screening acceptance proxy | 0.028 | 0.018 | 0.028-0.028 | 0.014-0.022 | high | true | 0.005 | outside |
| gallup-court-confidence-2024 | Public court trust and approval | 0.083 | 0.420 | 0.082-0.083 | 0.350-0.490 | medium | false | 0.267 | outside |
