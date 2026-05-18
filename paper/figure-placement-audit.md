# Figure and Float Placement Audit

Compiled PDF audited: `paper/main.pdf`.

This audit checks rendered pages, not just LaTeX source. It flags figure or table pages that leave excessive vertical whitespace after trimming normal margins. Final text-only pages, such as a short references tail, are noted but not treated as figure-placement defects.

## Summary

- Pages audited: 18
- Pages with figure/table captions: 3, 4, 6, 8, 9, 10, 11, 13, 14, 15, 16
- Severe figure/table whitespace findings: 0
- Figure/table whitespace warnings: 0

## Placement Map

| Page | Figure/table material | Nearby references | Vertical used | Top blank | Bottom blank | Assessment |
| --- | --- | --- | ---: | ---: | ---: | --- |
| 2 | - | Table 1 | 82.0% | 4.8% | 13.2% | OK |
| 3 | Table 1 | - | 86.3% | 4.8% | 8.9% | OK |
| 4 | Figure 1 | Figure 1 | 85.8% | 4.7% | 9.5% | OK |
| 5 | - | Figure 2 | 86.1% | 4.8% | 9.1% | OK |
| 6 | Figure 2, Table 2 | Table 3 | 86.3% | 4.8% | 8.9% | OK |
| 8 | Table 3 | - | 85.8% | 4.8% | 9.4% | OK |
| 9 | Table 4 | - | 86.6% | 4.8% | 8.5% | OK |
| 10 | Table 5 | Table 5, Table 6 | 85.9% | 4.8% | 9.3% | OK |
| 11 | Table 6 | - | 85.5% | 4.8% | 9.6% | OK |
| 12 | - | Figure 3, Table 7, Table 8 | 85.5% | 4.8% | 9.7% | OK |
| 13 | Table 7, Table 8 | - | 85.0% | 4.8% | 10.2% | OK |
| 14 | Figure 3 | - | 85.2% | 4.7% | 10.1% | OK |
| 15 | Figure 4 | Figure 4, Figure 5 | 85.6% | 4.8% | 9.5% | OK |
| 16 | Figure 5 | - | 86.1% | 4.8% | 9.1% | OK |
| 18 | - | - | 50.5% | 4.8% | 44.6% | OK: final references page, not figure-driven |

## Reading Notes

- The design-space longtable begins near its first textual reference and continues naturally onto the next page without creating a float-only page.
- The paired-import figure moves to the next page after its first reference, but the preceding page is already densely filled with tables and text, so this is not a blank-page float problem.
- The cost-score plot remains inline with the design-implications discussion; the mechanism-tradeoff plot is allowed to float to the next page so the limitations text can fill the preceding page instead of leaving a large blank area.
- Re-run `make figure-placement-audit` after changing generated figures, captions, table widths, or float placement.
