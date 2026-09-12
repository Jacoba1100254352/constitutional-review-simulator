"""Locked SCDB ingestion and train-only docket forecasts (Python standard library).

The CLI deliberately separates old-release preparation from new-data acquisition.
Do not import test records while fitting or selecting forecasts.
"""

from __future__ import annotations

import argparse
import csv
from dataclasses import asdict, dataclass
from datetime import datetime, timezone
import hashlib
import io
import json
import math
from pathlib import Path
import re
import subprocess
from urllib.parse import parse_qs, urljoin, urlparse
from urllib.request import urlopen
import zipfile

from audit_scdb_doctrine_denominators import LinkCollector


ROOT = Path(__file__).resolve().parents[1]
CONFIG = ROOT / "config/historical-benchmark"
DATA = ROOT / "data/historical"
PROTOCOL_FILE = CONFIG / "protocol-v1.json"
FORECAST_FILE = CONFIG / "forecasts-2025.json"
FORECAST_LOCK = CONFIG / "forecast-lock.json"
REGISTRY_FILE = DATA / "source-registry.json"
REQUIRED_FIELDS = ("caseId", "term", "dateDecision", "issue", "issueArea")
KNOWN_AREAS = set(range(1, 15))


def sha256(data: bytes) -> str:
    return hashlib.sha256(data).hexdigest()


def json_bytes(value: object) -> bytes:
    return (json.dumps(value, indent=2, sort_keys=True, allow_nan=False) + "\n").encode()


def check_hashes(hashes: dict[str, str], root: Path = ROOT) -> None:
    for relative, expected in hashes.items():
        path = Path(relative)
        if path.is_absolute() or ".." in path.parts:
            raise ValueError("hash inventory must use safe repository-relative paths")
        actual = sha256((root / path).read_bytes())
        if actual != expected:
            raise ValueError(f"locked artifact changed: {relative}")


def load_protocol() -> dict:
    lock = json.loads((CONFIG / "protocol-lock.json").read_text())
    check_hashes(lock["sha256"])
    protocol = json.loads(PROTOCOL_FILE.read_text())
    if protocol["protocolId"] != lock["protocolId"]:
        raise ValueError("protocol identity mismatch")
    probabilities(protocol["frozenGeneratorProbabilities"], len(protocol["categories"]))
    return protocol


def probabilities(values: list[float], length: int = 8) -> None:
    if len(values) != length or any(not math.isfinite(p) or p < 0 for p in values):
        raise ValueError("invalid categorical probability vector")
    if abs(math.fsum(values) - 1) > 1e-12:
        raise ValueError("category probabilities do not sum to one")


def integer_code(value: str, name: str, allow_missing: bool = True) -> int | None:
    if value == "" and allow_missing:
        return None
    if re.fullmatch(r"[0-9]+", value) is None:
        raise ValueError(f"invalid integral {name}: {value!r}")
    return int(value)


def category_for(issue: int | None, area: int | None, protocol: dict) -> tuple[str, str]:
    # Priority is part of the committed protocol, not selected by target-term fit.
    if issue in protocol["electionIssues"]:
        return "ELECTION_LAW", "explicit-issue"
    if issue == protocol["emergencyIssue"]:
        return "EMERGENCY_POWERS", "explicit-issue"
    if issue == protocol["administrativeIssue"]:
        return "ADMINISTRATIVE_STATE", "explicit-issue"
    if issue is None or area is None:
        return "OTHER", "missing-required-code"
    mapped = {3: "SPEECH", 2: "EQUALITY", 5: "EQUALITY", 1: "CRIMINAL_PROCEDURE",
              10: "FEDERALISM", 11: "FEDERALISM", 8: "ADMINISTRATIVE_STATE"}
    if area in mapped:
        return mapped[area], "issue-area"
    return "OTHER", "residual-area" if area in KNOWN_AREAS else "unrecognized-area"


@dataclass(frozen=True)
class DocketRecord:
    caseId: str
    term: int
    dateDecision: str
    issue: int | None
    issueArea: int | None
    category: str
    mappingStatus: str
    sourceRelease: str
    sourceRowSha256: str


def parse_release(data: bytes, release: str, protocol: dict) -> tuple[list[DocketRecord], dict, dict]:
    if release not in (protocol["developmentRelease"], protocol["testRelease"]):
        raise ValueError("unregistered source release")
    maximum = protocol["trainingLastTerm"] if release == protocol["developmentRelease"] else protocol["newDataTestTerm"]
    with zipfile.ZipFile(io.BytesIO(data)) as archive:
        members = [n for n in archive.namelist() if n.lower().endswith(".csv")]
        if len(members) != 1:
            raise ValueError("expected exactly one source CSV")
        member = members[0]
        required_name = f"{release}_{protocol['sourceOrganization']}.csv"
        if Path(member).name != required_name:
            raise ValueError(f"source member is not the pinned release/unit: {member}")
        raw_csv = archive.read(member)
    reader = csv.DictReader(io.StringIO(raw_csv.decode("utf-8-sig"), newline=""), strict=True)
    fields = reader.fieldnames or []
    if len(fields) != len(set(fields)) or not set(REQUIRED_FIELDS).issubset(fields):
        raise ValueError("duplicate or missing source columns")
    records, raw_rows = [], {}
    for row in reader:
        if None in row or any(value is None for value in row.values()):
            raise ValueError(f"source row width mismatch at CSV line {reader.line_num}")
        case_id = row["caseId"]
        if not case_id or case_id.strip() != case_id or case_id in raw_rows:
            raise ValueError(f"missing, malformed or duplicate case ID: {case_id!r}")
        term = integer_code(row["term"], "term", False)
        if not protocol["sourceMinimumTerm"] <= term <= maximum:
            raise ValueError(f"term {term} outside pinned release range")
        issue = integer_code(row["issue"], "issue")
        area = integer_code(row["issueArea"], "issueArea")
        date = row["dateDecision"]
        if date:
            # Validate the source date; never use its calendar year to split terms.
            datetime.strptime(date, "%m/%d/%Y")
        category, status = category_for(issue, area, protocol)
        raw_rows[case_id] = row
        records.append(DocketRecord(case_id, term, date, issue, area, category, status,
                                    release, sha256(json_bytes(row))))
    records.sort(key=lambda row: (row.term, row.caseId))
    if not records:
        raise ValueError("empty source dataset")
    if {row.term for row in records} != set(range(protocol["sourceMinimumTerm"], maximum + 1)):
        raise ValueError("missing complete term in source release")
    metadata = {"release": release, "organization": protocol["sourceOrganization"],
                "zipSha256": sha256(data), "csvSha256": sha256(raw_csv), "csvMember": member,
                "headers": fields, "recordCount": len(records), "minTerm": records[0].term,
                "maxTerm": records[-1].term}
    return records, metadata, raw_rows


def records_bytes(records: list[DocketRecord]) -> bytes:
    buffer = io.StringIO(newline="")
    writer = csv.DictWriter(buffer, fieldnames=list(DocketRecord.__dataclass_fields__), lineterminator="\n")
    writer.writeheader()
    writer.writerows(asdict(record) for record in records)
    return buffer.getvalue().encode()


def records_path(release: str) -> Path:
    return DATA / f"{release}-docket.csv"


def load_records(release: str, protocol: dict) -> list[DocketRecord]:
    registry = json.loads(REGISTRY_FILE.read_text())
    entry = registry[release]
    content = records_path(release).read_bytes()
    if sha256(content) != entry["derivedSha256"]:
        raise ValueError("derived data changed relative to source registry")
    rows = []
    seen = set()
    for raw in csv.DictReader(io.StringIO(content.decode(), newline="")):
        if set(raw) != set(DocketRecord.__dataclass_fields__) or any(v is None for v in raw.values()):
            raise ValueError("derived CSV schema or row-width mismatch")
        row = DocketRecord(raw["caseId"], integer_code(raw["term"], "term", False), raw["dateDecision"],
                           integer_code(raw["issue"], "issue"), integer_code(raw["issueArea"], "issueArea"),
                           raw["category"], raw["mappingStatus"], raw["sourceRelease"], raw["sourceRowSha256"])
        if row.caseId in seen or not row.caseId:
            raise ValueError("duplicate or missing derived case ID")
        seen.add(row.caseId)
        if row.sourceRelease != release or (row.category, row.mappingStatus) != category_for(row.issue, row.issueArea, protocol):
            raise ValueError("derived source identity or category mismatch")
        rows.append(row)
    if len(rows) != entry["recordCount"]:
        raise ValueError("derived count mismatch")
    return rows


def immutable_write(path: Path, content: bytes) -> None:
    """Create once; deterministic verification is allowed, silent replacement is not."""
    if path.exists():
        if path.read_bytes() != content:
            raise ValueError(f"refusing to overwrite immutable artifact: {path.name}")
        return
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("xb") as handle:
        handle.write(content)


def committed_revision(paths: list[Path]) -> str:
    """Native acquisition requires a recorded Git freeze, not just a file's existence."""
    relative = [str(path.relative_to(ROOT)) for path in paths]
    subprocess.run(["git", "ls-files", "--error-unmatch", "--", *relative], cwd=ROOT,
                   stdout=subprocess.DEVNULL, check=True)
    subprocess.run(["git", "diff", "--exit-code", "HEAD", "--", *relative], cwd=ROOT,
                   stdout=subprocess.DEVNULL, check=True)
    return subprocess.check_output(["git", "rev-parse", "HEAD"], cwd=ROOT, text=True).strip()


def release_url(release: str, protocol: dict) -> str:
    key = "developmentReleaseUrl" if release == protocol["developmentRelease"] else "testReleaseUrl"
    return protocol[key]


def discover_zip(release: str, protocol: dict) -> str:
    page_url = release_url(release, protocol)
    with urlopen(page_url, timeout=45) as response:
        html = response.read().decode("utf-8")
    parser = LinkCollector()
    parser.feed(html)
    for href, label in parser.links:
        if "download csv organized by supreme court citation" in " ".join(label.lower().split()):
            url = urljoin(page_url, href)
            host = urlparse(url).hostname
            if host not in {"scdb.la.psu.edu", "scdb.wustl.edu", "scdb.psu.edu"}:
                raise ValueError("unexpected source download host")
            parsed = urlparse(url)
            named_archive = Path(parsed.path).name == f"{release}_{protocol['sourceOrganization']}.csv.zip"
            query = parse_qs(parsed.query)
            # The official Penn State site uses opaque WordPress download links.
            # Their exact URLs are pinned in the registry and CSV member identity
            # is checked before any source records are accepted.
            official_download = (host == "scdb.la.psu.edu" and set(query) == {"jet_download"}
                                 and len(query["jet_download"]) == 1
                                 and re.fullmatch(r"[a-f0-9]+", query["jet_download"][0]) is not None)
            if not named_archive and not official_download:
                raise ValueError("download link does not identify pinned release/unit")
            return url
    raise ValueError("citation-centered CSV link not found")


def acquire(release: str, protocol: dict) -> dict:
    if release not in (protocol["developmentRelease"], protocol["testRelease"]):
        raise ValueError("unregistered source release")
    freeze_paths = [PROTOCOL_FILE, CONFIG / "protocol-lock.json",
                    ROOT / "docs/historical-benchmark-protocol.md"]
    if release == protocol["testRelease"]:
        check_forecast_lock(protocol)
        freeze_paths += [FORECAST_FILE, FORECAST_LOCK, records_path(protocol["developmentRelease"]), REGISTRY_FILE]
    acquisition_revision = committed_revision(freeze_paths)
    registry = json.loads(REGISTRY_FILE.read_text()) if REGISTRY_FILE.exists() else {}
    existing = registry.get(release)
    url = existing["zipUrl"] if existing else discover_zip(release, protocol)
    cache = DATA / "source-cache" / f"{release}_caseCentered_Citation.csv.zip"
    if cache.exists():
        data = cache.read_bytes()
    else:
        with urlopen(url, timeout=45) as response:
            data = response.read()
    records, metadata, _ = parse_release(data, release, protocol)
    derived = records_bytes(records)
    metadata.update({"zipUrl": url, "releaseUrl": release_url(release, protocol),
                     "derivedSha256": sha256(derived), "derivedPath": str(records_path(release).relative_to(ROOT))})
    if existing:
        # Reacquisition verifies the original bytes and retains the first acquisition time.
        if any(existing.get(key) != value for key, value in metadata.items()):
            raise ValueError("source changed since the recorded acquisition")
    else:
        metadata.update({"acquiredAtUtc": datetime.now(timezone.utc).isoformat(),
                         "acquisitionRevision": acquisition_revision})
        registry[release] = metadata
    immutable_write(cache, data)
    immutable_write(records_path(release), derived)
    DATA.mkdir(parents=True, exist_ok=True)
    # Registry updates only append a newly acquired release; existing entries were checked above.
    REGISTRY_FILE.write_bytes(json_bytes(registry))
    return registry[release]


def fit_models(records: list[DocketRecord], target: int, protocol: dict) -> list[dict]:
    if not records or any(row.sourceRelease != protocol["developmentRelease"] for row in records):
        raise ValueError("fitting requires exclusively the frozen development release")
    categories = protocol["categories"]
    if any(row.category not in categories for row in records):
        raise ValueError("unknown training category")
    if len({row.caseId for row in records}) != len(records):
        raise ValueError("duplicate training IDs")
    if any(not protocol["sourceMinimumTerm"] <= row.term <= protocol["trainingLastTerm"] for row in records):
        raise ValueError("training source contains a forbidden future term")
    forecasts = []
    for model in protocol["models"]:
        minimum = (target - protocol["empiricalLookbackTerms"] if model == "recency-weighted-15y"
                   else target - 1 if model == "previous-term" else protocol["sourceMinimumTerm"])
        training = sorted((row for row in records if minimum <= row.term < target),
                          key=lambda row: (row.term, row.caseId))
        if not training:
            raise ValueError(f"empty training window: {model} for {target}")
        if model == "frozen-generator":
            vector = protocol["frozenGeneratorProbabilities"]
            training = []
        else:
            contributions = {category: [protocol["pseudocountPerCategory"]] for category in categories}
            for row in training:
                weight = (2 ** (-((target - 1) - row.term) / protocol["empiricalHalfLifeTerms"])
                          if model == "recency-weighted-15y" else 1.0)
                contributions[row.category].append(weight)
            counts = [math.fsum(contributions[c]) for c in categories]
            denominator = math.fsum(counts)
            vector = [value / denominator for value in counts]
        probabilities(vector, len(categories))
        forecasts.append({"model": model, "targetTerm": target, "probabilities": vector,
                          "trainingN": len(training),
                          "trainingMinTerm": min((r.term for r in training), default=None),
                          "trainingMaxTerm": max((r.term for r in training), default=None),
                          "trainingRowsSha256": sha256(records_bytes(training)),
                          "trainingIdsSha256": sha256(json_bytes([r.caseId for r in training])),
                          "trainingRelease": protocol["developmentRelease"] if training else None,
                          "exposure": "fixed constants informed through 2024" if not training else "strictly earlier coded terms"})
    return forecasts


def freeze_forecasts(protocol: dict) -> dict:
    records = load_records(protocol["developmentRelease"], protocol)
    registry = json.loads(REGISTRY_FILE.read_text())
    if protocol["testRelease"] in registry:
        raise ValueError("cannot create forecasts after test acquisition")
    result = {"protocolId": protocol["protocolId"], "protocolSha256": sha256(PROTOCOL_FILE.read_bytes()),
              "categories": protocol["categories"], "developmentSource": registry[protocol["developmentRelease"]],
              "forecasts": fit_models(records, protocol["newDataTestTerm"], protocol)}
    immutable_write(FORECAST_FILE, json_bytes(result))
    lock = {"protocolId": protocol["protocolId"], "fittingCodeSha256": sha256(Path(__file__).read_bytes()),
            "sha256": {str(FORECAST_FILE.relative_to(ROOT)): sha256(FORECAST_FILE.read_bytes()),
                       str(records_path(protocol["developmentRelease"]).relative_to(ROOT)):
                           registry[protocol["developmentRelease"]]["derivedSha256"]}}
    immutable_write(FORECAST_LOCK, json_bytes(lock))
    return result


def check_forecast_lock(protocol: dict) -> dict:
    lock = json.loads(FORECAST_LOCK.read_text())
    if lock["protocolId"] != protocol["protocolId"]:
        raise ValueError("forecast lock protocol mismatch")
    check_hashes(lock["sha256"])
    result = json.loads(FORECAST_FILE.read_text())
    expected = fit_models(load_records(protocol["developmentRelease"], protocol), protocol["newDataTestTerm"], protocol)
    if result["forecasts"] != expected or result["protocolSha256"] != sha256(PROTOCOL_FILE.read_bytes()):
        raise ValueError("forecasts differ from the locked train-only procedure")
    return result


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("action", choices=["check-protocol", "acquire-development", "freeze-forecasts", "check-forecasts", "acquire-test"])
    args = parser.parse_args()
    protocol = load_protocol()
    if args.action == "acquire-development":
        result = acquire(protocol["developmentRelease"], protocol)
    elif args.action == "acquire-test":
        result = acquire(protocol["testRelease"], protocol)
    elif args.action == "freeze-forecasts":
        result = freeze_forecasts(protocol)
    elif args.action == "check-forecasts":
        result = check_forecast_lock(protocol)
    else:
        result = {"protocolId": protocol["protocolId"], "status": "locked hashes verified"}
    print(json.dumps(result, indent=2, allow_nan=False))


if __name__ == "__main__":
    main()
