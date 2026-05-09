# Figure and Float Placement Audit

Compiled PDF audited: `paper/main.pdf`.

This audit checks rendered pages, not just LaTeX source. It flags figure or table pages that leave excessive vertical whitespace after trimming normal margins. Final text-only pages, such as a short references tail, are noted but not treated as figure-placement defects.

## Summary

- Pages audited: 15
- Pages with figure/table captions: 2, 4, 5, 7, 8, 9, 10, 11, 12, 13
- Severe figure/table whitespace findings: 0
- Figure/table whitespace warnings: 0

## Placement Map

| Page | Figure/table material | Nearby references | Vertical used | Top blank | Bottom blank | Assessment |
| --- | --- | --- | ---: | ---: | ---: | --- |
| 2 | Table 1 | Table 1 | 84.1% | 4.8% | 11.1% | OK |
| 4 | Figure 1 | Figure 1 | 86.7% | 4.7% | 8.5% | OK |
| 5 | Figure 2 | Figure 2 | 86.1% | 4.8% | 9.1% | OK |
| 6 | - | Table 2 | 85.8% | 4.8% | 9.4% | OK |
| 7 | Table 2 | - | 86.2% | 4.7% | 9.1% | OK |
| 8 | Table 3 | Table 4 | 85.5% | 4.8% | 9.6% | OK |
| 9 | Table 4 | - | 85.9% | 4.8% | 9.3% | OK |
| 10 | Table 5, Table 6 | Figure 3, Table 5, Table 6 | 86.3% | 4.8% | 8.9% | OK |
| 11 | Figure 3 | - | 82.8% | 4.8% | 12.4% | OK |
| 12 | Figure 4 | Figure 4, Figure 5 | 84.7% | 4.8% | 10.5% | OK |
| 13 | Figure 5 | - | 85.3% | 4.8% | 9.9% | OK |
| 15 | - | - | 61.1% | 4.8% | 34.1% | OK: final references page, not figure-driven |

## Reading Notes

- The design-space longtable begins near its first textual reference and continues naturally onto the next page without creating a float-only page.
- The paired-import figure moves to the next page after its first reference, but the preceding page is already densely filled with tables and text, so this is not a blank-page float problem.
- The cost-score and mechanism-tradeoff plots are intentionally inline rather than floating so they remain with the design-implications discussion and do not force separate figure pages.
- Re-run `make figure-placement-audit` after changing generated figures, captions, table widths, or float placement.
