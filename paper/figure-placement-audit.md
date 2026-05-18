# Figure and Float Placement Audit

Compiled PDF audited: `paper/constitutional-review-design-stress-test.pdf`.

This audit checks rendered pages, not just LaTeX source. It flags figure or table pages that leave excessive vertical whitespace after trimming normal margins. Final text-only pages, such as a short references tail, are noted but not treated as figure-placement defects.

## Summary

- Pages audited: 19
- Pages with figure/table captions: 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16
- Severe figure/table whitespace findings: 0
- Figure/table whitespace warnings: 0

## Placement Map

| Page | Figure/table material | Nearby references | Vertical used | Top blank | Bottom blank | Assessment |
| --- | --- | --- | ---: | ---: | ---: | --- |
| 2 | - | Table 1 | 71.7% | 4.8% | 23.5% | OK |
| 3 | Table 1 | - | 86.3% | 4.8% | 8.9% | OK |
| 4 | Figure 1 | Figure 1 | 86.4% | 4.7% | 8.9% | OK |
| 5 | Table 2 | - | 86.6% | 4.8% | 8.5% | OK |
| 6 | Figure 2 | Figure 2 | 86.1% | 4.8% | 9.1% | OK |
| 7 | Table 3 | Table 4 | 83.9% | 4.7% | 11.4% | OK |
| 8 | Table 4 | - | 86.5% | 4.8% | 8.7% | OK |
| 9 | Table 5 | Table 5, Table 6 | 84.5% | 4.8% | 10.6% | OK |
| 10 | Table 6, Table 7 | Figure 3, Table 7 | 70.3% | 4.8% | 24.9% | OK |
| 11 | Figure 3 | Figure 4, Figure 5 | 85.8% | 4.8% | 9.4% | OK |
| 12 | Figure 4, Figure 5 | - | 85.8% | 4.8% | 9.4% | OK |
| 14 | Table 8 | Table 10, Table 9 | 85.3% | 4.7% | 10.0% | OK |
| 15 | Table 9 | - | 86.4% | 4.8% | 8.8% | OK |
| 16 | Table 10 | - | 86.4% | 4.8% | 8.8% | OK |
| 19 | - | - | 64.3% | 4.8% | 30.9% | OK: final references page, not figure-driven |

## Reading Notes

- The design-space longtable begins near its first textual reference and continues naturally onto the next page without creating a float-only page.
- The paired-import figure moves to the next page after its first reference, but the preceding page is already densely filled with tables and text, so this is not a blank-page float problem.
- The cost-score and mechanism-tradeoff plots are placed with the comparative-experiment discussion, where they function as tradeoff maps rather than as late design recommendations.
- Re-run `make figure-placement-audit` after changing generated figures, captions, table widths, or float placement.
