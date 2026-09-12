# Initial data-exposure audit

Audit date: 12 September 2026. Scoped revision:
`8edf83b58fb73ef114e63890e6bf98578b3075f0`, clean worktree.

## Evidence inspected before acquiring the new release

- `config/calibration-source-observations.csv` contains SCDB aggregate docket
  targets for 1946-2024 and 2000-2024. The denominator audit and its acquisition
  script name SCDB 2025 Release 01. Consequently, every pre-2025 test of the
  frozen fixed generator is explicitly retrospective and exposed through
  aggregate calibration, even if individual cases were not manually examined.
- `WorldGenerator.java` contains the eight fixed probabilities recorded in
  `config/historical-benchmark/protocol-v1.json`. No train/test split or fitted
  period-specific distribution is present in this snapshot.
- Scoped tracked-content searches for `SCDB_2026`, `2026-release-01`, `2025 term`
  and `2025 terms` in configuration, data, documentation, scripts, source and
  the main manuscript returned no matches. A repository-history search for
  `2026-release-01` in scripts/configuration/documentation returned no commits.
  A scoped filename inventory found the existing SCDB audit script/report, not
  a raw new-release cache. These checks do not prove absence of all conceivable
  outside exposure or undocumented human knowledge.
- During goal selection, only the official 2026 release landing page and
  codebook/metadata were inspected. The release page reports 7 September 2026,
  terms 1946-2025, and a citation-centered CSV download. No new-release CSV,
  computed 2025 category totals, or 2025 case-level outcome table was inspected.
- Other project references to 2025, including emergency-docket and comparative
  court source summaries, are not a guarantee of ignorance about that period.
  The defensible claim is a newly evaluated SCDB docket-composition term after
  a recorded forecast freeze, not psychological blindness to public events.

## Decision and safeguards

Use the 2025 term as the new-data evaluation for this scoped pipeline, with
the above qualification. Preserve the 2025 release as the only training source.
Commit the protocol first, then construct and freeze forecast vectors before
downloading the new case records. An acquisition log and content hashes must
record those milestones. If later evidence contradicts this exposure finding,
append a correction and downgrade the test label; never erase the first result.

No existing source-range row is promoted, removed, or retuned by this audit.
Missing substantive outcome mappings remain excluded from validation. This
is the practical consequence of the data-quality review, not a claim that
reproducible category counts validate constitutional decisions.
