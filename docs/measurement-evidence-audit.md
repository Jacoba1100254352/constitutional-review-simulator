# Canada, Germany, and South Africa measurement audit

## Scope and intended use

This audit resolves the Canadian statute-disposition mismatch and expands
denominator-backed evidence for Germany and South Africa, whose existing court
profiles each have only one counted intake check. Cost and public-opinion
profiles remain deliberately contextual. The source of truth is
`config/research/comparative-calibration-source-candidates.csv`; the generated
`reports/constitutional-review-measurement-audit-v1.csv` reconstructs nine
proportions from their counts. Profile cards and the supplementary measurement
table expose those observations without treating all nine as model validation.

## Source verification and statistical units

- Canada: the retained primary-table audit of Morton, Russell, and Withey
  (1992), Table 7, records 19 nullifications among 50 statute dispositions.
  Neither the article's 100 decisions nor Table 6's separate 49 statute
  challenge objects is the denominator. The public article landing page remains
  available, but its PDF endpoint returned HTTP 403 during this follow-up.
  The counts use the earlier table audit, not a claimed fresh PDF inspection.
  See [the article](https://digitalcommons.osgoode.yorku.ca/ohlj/vol30/iss1/1/)
  and `docs/object-measurement-contract.md` for the limited model interpretation.
- Germany: the official 2024 annual report was downloaded and its printed
  pages 48, 51, 52, and 54 visually inspected. PDF page numbers are two greater.
  SHA-256: `75ee9b396bb77d7ad5380557b9972bda02e0ec900ab3915772be8a052a3684be`.
  [Official report](https://www.bundesverfassungsgericht.de/SharedDocs/Downloads/EN/Jahresbericht/jahresbericht_2024.pdf?__blob=publicationFile&v=2).
- South Africa: Ally et al.'s primary docket study was inspected in its
  full-text publication, sections 2, 3, and 5, and Figure 3 was visually checked.
  The observation cutoff is 26 July 2024, not a completed annual cohort.
  [Published study](https://www.scielo.org.za/scielo.php?pid=S1727-37812024000100077&script=sci_arttext).

## Findings and analytical risks

| Finding | Evidence | Severity / confidence | Interpretation and treatment |
| --- | --- | --- | --- |
| Canadian numerator and denominator originally used different units | 19 statute nullifications / 50 statute dispositions | High / retained primary-table audit | The new output counts statute dispositions. Only this narrow source-range check is promoted; synthetic object assumptions remain unestimated. |
| German complaint universes differ | 4,436 new; 4,647 concluded; 4,595 decided; 39 successful | High / high | 39/4,595 measures complaint success, not merits statute invalidation. Keep the existing intake proxy labeled as a proxy and the exact success measure outside validation. |
| German procedural counts do not measure outcomes | 1,500/4,436 represented; 1,003/4,436 with interim applications; 110/4,436 direct laws/ordinances challenges | High / high | These describe representation, application demand, and filing composition. They do not estimate access success, injunction grants, or statute nullification. |
| South African route categories do not exhaust the stated total | 189 leave + 19 direct + 4 combined + 4 unknown = 216, versus 217 petitions | Medium / high confidence in discrepancy | Preserve the stated counts and one unaccounted petition. Figure 3's rounded percentages do not resolve the mismatch. Do not silently renormalize or import this as a complete route distribution. |
| South African outcomes are censored and reasons incompletely observed | 57/217 dismissed at cutoff; reasons found for 40/57 | High / high | These are snapshot dismissal and source-coverage proportions. They are not eventual rejection or judicial reason-giving rates. |

## Automated checks and remaining boundaries

A rerun of the committed pre-extension source did not reproduce its checked-in
validation aggregates: all eight scenario rows changed, and five original
source-range checks missed. The pre-existing seed expression used the record
hash of `WorldSpec`, including the process-local identity hash of its doctrine
enum. The object extension exposed this reproducibility defect; it did not
justify changing institutional parameters or source ranges. The corrected
`world-spec-value-fingerprint-v1` uses numeric component values and the doctrine
enum name. All campaigns must be regenerated under this declared seed protocol.
Original benchmark definitions remain intact; their regenerated results and
any misses, rather than the earlier all-within-range claim, are authoritative.

With both implementations on the same value-based seed protocol, the
pre-object and extended implementations agree on all 96 shared aggregate
fields for eight court presets, all shared fields in 76,800 raw case rows, and
all 56 existing calibration rows. `make benchmark-preservation-check` verifies
the aggregate comparison against the pre-extension fixture. The canonical
post-migration campaign reports 39/41 source-range checks within bounds; the
French QPC outcome and CJEU compliance checks remain misses with their original
ranges and mechanisms unchanged. This is an explicit benchmark limitation,
not evidence that the added object allocation altered existing case decisions.

The report generator recomputes each proportion, rejects duplicate measurement
keys and impossible counts, and verifies that promotion agrees with the source
matrix. Regression fixtures retain all nine count pairs and require the eight
German/South African observations to remain outside validation. Source rows
carry their own periods, URLs, locators, and limitations.

A pre-existing unquoted comma in the South African throughput source row
silently truncated its construction caveat. Quoting the full field restores
the existing warning without changing any target value, denominator, or
validation flag. The calibration-source gate now rejects mismatched CSV row
widths, and the readiness report tests reject all-clear language when misses
remain or no evidence is available.

The case/object export guard independently reconstructs denominators and
numerators, checks parent coverage and duplicate IDs, and rejects a numeric zero
for an empty denominator. It runs after every standard campaign. Java tests
cover mixed objects, conduct, regulations, weak-form declarations, suspension,
emergency-only cases, and pooled aggregation. Statute calibration uncertainty
resamples whole run blocks, including all objects from each case; it does not
assume independent statute observations.

This evidence expansion does not validate the German or South African court
profile as a whole. New procedural models would need independently specified
measurement contracts before these observations could become calibration
targets. The South African classification discrepancy remains unresolved, and
the unavailable orders must not be coded as courts giving no reasons.
