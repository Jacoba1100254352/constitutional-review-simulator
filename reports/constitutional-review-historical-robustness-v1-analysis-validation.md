# Analysis validation report

## Overall assessment: Share with caveats

The calculations support a bounded description of this synthetic model and
fixed grid, not empirical identification of reforms or a recommended court.

## Methodology and calculation checks

- Verified all 3692 paired point estimates and Monte Carlo standard errors directly from run observations.
- Recomputed 93 selected intervals using expanded sampled run indices, independently of the production count-compressed bootstrap.
- Checked every component classification, claim-matrix mapping and required table/key inventory.
- Regenerated all 1000 registered preference vectors and all 624 leadership rows, including ties and response replacement.
- Verified all 6000 fixed-weight cross-grid comparisons and 416 conditional-denominator rows.

The production analysis also has a separate full deterministic re-execution
check. This validator does not claim independent re-estimation of all bootstrap
intervals; its independent interval coverage is explicitly limited above.

## Important issues and required caveats

1. High interpretive risk: no-order runs are coded zero in the registered mean of conditional run rates. Low-emergency reason-giving reversals must not be read as fewer reasons per actual order. Pooled event counts are explanatory diagnostics only.
2. High interpretive risk: average review time is a shared case input, not a design-specific duration. It cannot support the registered delay claim.
3. High interpretive risk: no legislative replies is not an observed late or instantaneous reply. Conditional timeliness comparisons have different eligible populations.
4. Structural cost, credibility and veto terms are partly imposed by model rules. Their movement and preference leadership are not independent empirical validation.
5. Bootstrap intervals describe conditional Monte Carlo error. Grid ranges and preference sensitivity are separate and do not assign probabilities to real institutions or political environments.

## Presentation and incomplete handoff checks

The Markdown tables, explicit caveats and linked CSV evidence were inspected.
No new graphical or PDF output is certified by this calculation check.
Manuscript/supplement integration, full native CI, rendered publication checks
and extracted anonymous replication remain separate required work.

## Reproduce

Run `make historical-analysis-check historical-analysis-validation-check`.
The companion JSON records exact counts and source/analysis hashes.
