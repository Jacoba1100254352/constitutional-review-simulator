# Figure and Float Placement Audit

Compiled PDF audited: `paper/constitutional-review-design-stress-test.pdf`.

This audit checks rendered pages, not just LaTeX source. It flags figure or table pages that leave excessive vertical whitespace after trimming normal margins. Final text-only pages, such as a short references tail, are noted but not treated as figure-placement defects.

## Summary

- Pages audited: 19
- Pages with figure/table captions: 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16
- Severe figure/table whitespace findings: 0
- Figure/table whitespace warnings: 0

## Placement Map

| Page | Figure/table material | Nearby references | Vertical used | Top blank | Bottom blank | Assessment |
| --- | --- | --- | ---: | ---: | ---: | --- |
| 2 | - | Table 1 | 76.9% | 4.8% | 18.3% | OK |
| 3 | Table 1 | - | 86.3% | 4.8% | 8.9% | OK |
| 4 | Figure 1 | Figure 1 | 84.6% | 4.7% | 10.6% | OK |
| 5 | Table 2 | - | 86.0% | 4.8% | 9.2% | OK |
| 6 | Figure 2 | Figure 2 | 86.1% | 4.8% | 9.1% | OK |
| 7 | Table 3 | Table 4 | 86.6% | 4.7% | 8.6% | OK |
| 8 | Table 4 | - | 85.1% | 4.8% | 10.1% | OK |
| 9 | - | Table 5, Table 6 | 86.6% | 4.8% | 8.5% | OK |
| 10 | Table 5, Table 6 | Table 6, Table 7, Table 8 | 86.2% | 4.8% | 9.0% | OK |
| 11 | Table 7, Table 8 | - | 85.5% | 4.8% | 9.7% | OK |
| 12 | Figure 3 | Figure 3, Figure 4 | 86.4% | 4.8% | 8.8% | OK |
| 13 | Figure 4 | - | 86.1% | 4.8% | 9.1% | OK |
| 14 | Table 9 | Table 10, Table 11 | 86.4% | 4.7% | 8.9% | OK |
| 15 | Table 10 | - | 85.2% | 4.8% | 10.0% | OK |
| 16 | Table 11 | - | 85.3% | 4.8% | 9.9% | OK |
| 19 | - | - | 44.4% | 4.8% | 50.8% | OK: final references page, not figure-driven |

## Reading Notes

- The design-space longtable begins near its first textual reference and continues naturally onto the next page without creating a float-only page.
- The paired-import figure moves to the next page after its first reference, but the preceding page is already densely filled with tables and text, so this is not a blank-page float problem.
- The cost-score and mechanism-tradeoff plots are placed with the comparative-experiment discussion, where they function as tradeoff maps rather than as late design recommendations.
- Re-run `make figure-placement-audit` after changing generated figures, captions, table widths, or float placement.
