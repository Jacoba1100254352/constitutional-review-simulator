# Historical benchmark inputs

This directory contains a minimum factual derivative of the public Supreme
Court Database citation-centered data, not a new legal-outcome dataset. The
source registry identifies the exact release, download URL, original ZIP/CSV
hashes, acquisition time/revision, full header, term range, and derived-file
hash. `source-cache/` retains the original ZIP locally and is ignored by Git.
Do not substitute a newer release or a docket/justice-centered file.

Sources: [SCDB data releases](https://scdb.la.psu.edu/data/) and
[online codebook](https://scdb.la.psu.edu/online-codebook/). Cite the release
used: Harold J. Spaeth, Lee Epstein, Michael J. Nelson, Andrew D. Martin, et al.,
Supreme Court Database, corresponding version/release. The protocol fixes
the older release for training and the newer release for testing/revision audit.

## Observation and missingness contract

Each derived row preserves a unique source case ID, coded term, decision date,
issue and issue-area codes, one of eight disjoint categories, mapping status,
source release, and a SHA-256 of the canonical full original row. Empty source
codes remain empty; zero is not a missing-value replacement. The case date is
validated but its calendar year does not replace the Supreme Court term.
OTHER retains missing and residual cases in the denominator. The mapping is
fixed in `docs/historical-benchmark-protocol.md`; it deliberately differs from
the legacy source matrix's independently counted, partly overlapping categories.

No outcome, political-direction, personal litigant detail, or justice-level
field is used in fitting these profiles. Source-row hashes allow comparison
with full source rows without copying those extra fields into the derivative.
All non-doctrine inputs to the institutional stress test remain synthetic.

## Recorded acquisition workflow

From the repository root, after committing the protocol:

```sh
make historical-protocol-check
make historical-acquire-development
make historical-freeze-forecasts
make historical-forecast-check
```

Commit the importer, old-source registry/derivative, and locked forecast vectors
before running `make historical-acquire-test`. The acquisition command verifies
that those exact files are committed and unchanged. Forecast creation refuses
to run after the test source is acquired. Existing artifacts can be rechecked
but cannot be silently overwritten. Keep a correction in a separate amendment
and preserve the first forecast/evaluation.

The download links are official release-page links; Penn State may serve them
through opaque `jet_download` queries. The importer validates the source host,
exact CSV member name and release, unit, schema, term range, unique identifiers,
and every row width before accepting the archive. Reacquisition must match the
recorded hashes and retains the original acquisition timestamp.

Replication should use the checked-in locked derivative and forecast for
offline checks. Full raw-source verification reacquires the exact public ZIP
and checks its hash. Anonymous extracted packages must not invent a new Git
freeze or create a new first evaluation; the final replication workflow will
recompute and verify the supplied locked artifacts separately from the original
acquisition workflow.
