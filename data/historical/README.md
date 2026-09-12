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

## Reproducing the existing evaluation

The following commands do not invent a new acquisition or overwrite the first
evaluation. They work without repository metadata, including inside an
anonymous extracted replication package:

```sh
make historical-scores-check
make historical-sources
make historical-benchmark-check
```

The first command is offline: it recomputes the locked first evaluation using
the source-hashed derivatives, forecasts, and scoring code. It does not claim
a new audit of the raw ZIPs. The second verifies or downloads the two exact
original ZIPs and byte-checks their derivatives, retaining the original source
registry and acquisition timestamps. It requires source availability only when
the originals are not already cached. The third recomputes every empirical
report, including the original full-field revision audit, and fails on drift.

`make historical-benchmark` regenerates the non-frozen report files but still
cannot replace a divergent first evaluation. Use that command only for intended
report refreshes. Neither reproduction path refits using the test release or
substitutes revised historical observations for the old training records.
