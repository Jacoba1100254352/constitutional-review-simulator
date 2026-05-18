# Figure and Float Placement Audit

Compiled PDF audited: `paper/main.pdf`.

This audit checks rendered pages, not just LaTeX source. It flags figure or table pages that leave excessive vertical whitespace after trimming normal margins. Final text-only pages, such as a short references tail, are noted but not treated as figure-placement defects.

## Summary

- Pages audited: 20
- Pages with figure/table captions: 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 15, 17
- Severe figure/table whitespace findings: 0
- Figure/table whitespace warnings: 0

## Placement Map

| Page | Figure/table material | Nearby references | Vertical used | Top blank | Bottom blank | Assessment |
| --- | --- | --- | ---: | ---: | ---: | --- |
| 3 | Table 1 | Table 1 | 86.0% | 4.8% | 9.2% | OK |
| 4 | Figure 1 | Figure 1 | 86.4% | 4.7% | 8.9% | OK |
| 5 | Table 2 | - | 83.1% | 4.8% | 12.1% | OK |
| 6 | Figure 2 | Figure 2 | 86.6% | 4.8% | 8.5% | OK |
| 7 | Table 3 | Table 4 | 86.6% | 4.7% | 8.6% | OK |
| 9 | Table 4 | Table 5, Table 6 | 86.1% | 4.8% | 9.1% | OK |
| 10 | Table 5, Table 6 | Figure 3, Table 6, Table 7 | 84.6% | 4.8% | 10.5% | OK |
| 11 | Table 7, Figure 3 | Figure 4 | 81.4% | 4.8% | 13.8% | OK |
| 12 | Figure 4 | Figure 5 | 86.4% | 4.8% | 8.8% | OK |
| 13 | Figure 5 | - | 79.4% | 4.8% | 15.8% | OK |
| 14 | - | Table 10, Table 9 | 85.8% | 4.7% | 9.5% | OK |
| 15 | Table 8, Table 9 | - | 82.3% | 4.8% | 12.9% | OK |
| 17 | Table 10 | - | 82.2% | 4.7% | 13.1% | OK |

## Reading Notes

- The design-space longtable begins near its first textual reference and continues naturally onto the next page without creating a float-only page.
- The paired-import figure moves to the next page after its first reference, but the preceding page is already densely filled with tables and text, so this is not a blank-page float problem.
- The cost-score and mechanism-tradeoff plots are placed with the comparative-experiment discussion, where they function as tradeoff maps rather than as late design recommendations.
- Re-run `make figure-placement-audit` after changing generated figures, captions, table widths, or float placement.
