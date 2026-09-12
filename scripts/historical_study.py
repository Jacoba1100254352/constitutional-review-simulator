"""Prepare and verify the registered paired study without reading observed test frequencies.

The original first-evaluation implementation is frozen. This separate extension
uses only its locked, training-only forecast artifact plus the registered protocol.
"""

from __future__ import annotations

import argparse
import csv
import gzip
import hashlib
import io
import json
import math
from pathlib import Path
import shutil
import subprocess
import tempfile

from historical_data import CONFIG, FORECAST_FILE, PROTOCOL_FILE, ROOT, check_forecast_lock, json_bytes, load_protocol


PREFIX = "constitutional-review-historical-robustness-v1"
INPUT_NAMES = ("study-profiles.csv", "study-contexts.csv", "study.properties")
RAW_SUFFIXES = ("-cases.csv.gz", "-objects.csv.gz", "-dockets.csv.gz", "-segments.csv.gz")
OUTPUT_SUFFIXES = ("-runs.csv.gz", "-streams.csv.gz", "-compositions.csv.gz", "-designs.csv",
                   "-contexts.csv", "-counts.json", *RAW_SUFFIXES)


def file_hash(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as stream:
        for block in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(block)
    return digest.hexdigest()


def csv_bytes(header: list[str], rows: list[list]) -> bytes:
    stream = io.StringIO(newline="")
    writer = csv.writer(stream, lineterminator="\n")
    writer.writerow(header)
    writer.writerows(rows)
    return stream.getvalue().encode()


def input_artifacts(protocol: dict, forecast: dict) -> dict[str, bytes]:
    if forecast["categories"] != protocol["categories"]:
        raise ValueError("study forecast category order differs from protocol")
    by_model = {row["model"]: row for row in forecast["forecasts"]}
    if len(by_model) != len(forecast["forecasts"]) or set(by_model) != set(protocol["stressDocketProfiles"]):
        raise ValueError("study forecast inventory differs from protocol")
    profiles = []
    for model in protocol["stressDocketProfiles"]:
        row = by_model[model]
        if row["targetTerm"] != protocol["newDataTestTerm"]:
            raise ValueError("wrong forecast target term")
        profiles.append([model, *row["probabilities"]])
    contexts = [["baseline", "baseline", 0]]
    for field, values in protocol["contextOneAtATime"].items():
        for index, value in enumerate(values):
            contexts.append([f"{field}-{'low' if index == 0 else 'high'}", field, value])
    properties = (f"runs={protocol['simulationRuns']}\n"
                  f"cases={protocol['simulationCasesPerRun']}\n"
                  f"periods={protocol['simulationReviewPeriods']}\n"
                  f"seed={protocol['simulationSeed']}\n")
    return {
        "study-profiles.csv": csv_bytes(["profile", *protocol["categories"]], profiles),
        "study-contexts.csv": csv_bytes(["context", "field", "value"], contexts),
        "study.properties": properties.encode(),
    }


def prepare_inputs(check: bool = False) -> dict:
    protocol = load_protocol()
    forecast = check_forecast_lock(protocol)
    artifacts = input_artifacts(protocol, forecast)
    for name, data in artifacts.items():
        path = CONFIG / name
        if check:
            if not path.exists() or path.read_bytes() != data:
                raise ValueError(f"study input does not match the frozen protocol/forecasts: {name}")
        else:
            path.write_bytes(data)
    return protocol


def read_rows(path: Path):
    opener = gzip.open if path.suffix == ".gz" else open
    with opener(path, "rt", newline="", encoding="utf-8") as stream:
        reader = csv.DictReader(stream)
        if not reader.fieldnames or len(set(reader.fieldnames)) != len(reader.fieldnames):
            raise ValueError(f"empty or duplicate CSV headers: {path.name}")
        for row in reader:
            if None in row or None in row.values():
                raise ValueError(f"CSV width mismatch: {path.name}")
            yield row


def expected_contexts(protocol: dict) -> list[str]:
    return ["baseline", *[f"{field}-{level}" for field in protocol["contextOneAtATime"]
                          for level in ("low", "high")]]


def verify_designs(directory: Path, protocol: dict) -> None:
    rows = list(read_rows(directory / f"{PREFIX}-designs.csv"))
    expected = protocol["stressScenarioKeys"] + protocol["stressAblations"]
    if [row["scenario"] for row in rows] != expected:
        raise ValueError("study design inventory/order differs from protocol")
    by_key = {row["scenario"]: row for row in rows}
    allowed = {
        "reasoned-with-fast-procedure": {"docketProcedure": "FAST_SHADOW_DOCKET"},
        "council-with-full-court-structure": {"reviewStructure": "FULL_COURT"},
        "weak-form-half-response": {"responseFactor": "0.5"},
        "weak-form-no-response": {"responseFactor": "0.0"},
    }
    for key in protocol["stressAblations"]:
        row = by_key[key]
        parent = by_key[row["parent"]]
        changed = {field: value for field, value in row.items()
                   if field not in {"scenario", "parent"} and value != parent[field]}
        if changed != allowed[key]:
            raise ValueError(f"ablation changed unregistered design fields: {key}")


def verify_contexts(directory: Path, protocol: dict) -> None:
    rows = list(read_rows(directory / f"{PREFIX}-contexts.csv"))
    if [row["context"] for row in rows] != expected_contexts(protocol):
        raise ValueError("study context inventory/order differs from protocol")
    baseline = rows[0]
    if (int(baseline["caseCount"]) != protocol["simulationCasesPerRun"]
            or int(baseline["reviewPeriods"]) != protocol["simulationReviewPeriods"]):
        raise ValueError("baseline case/period count differs from protocol")
    for row in rows[1:]:
        field = row["field"]
        index = 0 if row["context"].endswith("-low") else 1
        if field not in protocol["contextOneAtATime"] or float(row[field]) != protocol["contextOneAtATime"][field][index]:
            raise ValueError("context parameter differs from the registered value")
        changed = {name for name in baseline if name not in {"context", "field", "value"}
                   and baseline[name] != row[name]}
        if changed != {field}:
            raise ValueError("context sweep is not one-at-a-time")


def signed64(value: int) -> int:
    value &= (1 << 64) - 1
    return value - (1 << 64) if value >= (1 << 63) else value


def stream_seed(seed: int, run: int, stream: int) -> int:
    return signed64(seed ^ (0x9E3779B97F4A7C15 + (run << 6) + (run >> 2))
                    ^ (0xBF58476D1CE4E5B9 * (stream + 31)))


def verify_streams(directory: Path, protocol: dict) -> int:
    scenarios = protocol["stressScenarioKeys"] + protocol["stressAblations"]
    profiles, contexts = protocol["stressDocketProfiles"], expected_contexts(protocol)
    seen = set()
    for row in read_rows(directory / f"{PREFIX}-streams.csv.gz"):
        profile, context, scenario = row["profile"], row["context"], row["scenario"]
        run, period = int(row["run"]), int(row["period"])
        if (profile not in profiles or context not in contexts or scenario not in scenarios
                or not 0 <= run < protocol["simulationRuns"] or not 0 <= period < protocol["simulationReviewPeriods"]):
            raise ValueError("unregistered random stream identity")
        key = profile, context, scenario, run, period
        if key in seen:
            raise ValueError("duplicate random stream row")
        seen.add(key)
        vote = stream_seed(protocol["simulationSeed"], run, scenarios.index(scenario) + 101 + period * 503)
        response = stream_seed(protocol["simulationSeed"] ^ 0x524553504F4E5345, run, 10001 + period * 503)
        if int(row["votingSeed"]) != vote or int(row["responseSeed"]) != response:
            raise ValueError("recorded random stream differs from its declared derivation")
    expected = len(profiles) * len(contexts) * len(scenarios) * protocol["simulationRuns"] * protocol["simulationReviewPeriods"]
    if len(seen) != expected:
        raise ValueError("incomplete random stream inventory")
    return len(seen)


def verify_runs(directory: Path, protocol: dict) -> dict:
    profiles = protocol["stressDocketProfiles"]
    contexts = expected_contexts(protocol)
    scenarios = protocol["stressScenarioKeys"] + protocol["stressAblations"]
    runs, cases = protocol["simulationRuns"], protocol["simulationCasesPerRun"]
    expected_n = len(profiles) * len(contexts) * len(scenarios) * runs
    seen = set()
    pairs = {}
    world_seeds = {}
    count = 0
    off_count = 0
    for row in read_rows(directory / f"{PREFIX}-runs.csv.gz"):
        profile, context, scenario, run = row["profile"], row["context"], row["scenarioKey"], int(row["run"])
        if profile not in profiles or context not in contexts or scenario not in scenarios or not 0 <= run < runs:
            raise ValueError("unexpected paired study cell")
        if int(row["scenarioIndex"]) != scenarios.index(scenario) or int(row["totalCases"]) != cases:
            raise ValueError("run identity or denominator differs from protocol")
        key = profile, context, run, scenario
        if key in seen:
            raise ValueError("duplicate paired study run")
        seen.add(key)
        pair_key = profile, context, run
        identity = row["docketSha256"], row["objectsSha256"], row["worldSeed"], row["averageTimeToReview"]
        if pair_key in pairs and pairs[pair_key] != identity:
            raise ValueError("paired designs received different dockets or docket-defined review times")
        pairs[pair_key] = identity
        world_seeds.setdefault((profile, context), set()).add(row["worldSeed"])
        for field in protocol["weightMetricsHigher"] + protocol["weightMetricsLower"]:
            value = float(row[field])
            if not math.isfinite(value) or not -1e-12 <= value <= 1 + 1e-12:
                raise ValueError(f"invalid normalized study metric: {field}")
        if scenario == "weak-form-no-response":
            for field in ("legislativeResponseRate", "legislativeResponseCredibility", "timelyLegislativeResponseRate"):
                if float(row[field]) != 0:
                    raise ValueError("response-off intervention retained response state")
            off_count += 1
        count += 1
    if count != expected_n or any(len(seeds) != runs for seeds in world_seeds.values()):
        raise ValueError("incomplete experiment or repeated within-cell world seeds")
    counts = json.loads((directory / f"{PREFIX}-counts.json").read_text())
    if (counts["runs"] != count or counts["cases"] != count * cases
            or counts["sharedCases"] != len(pairs) * cases
            or counts["objects"] != counts["sharedObjects"] * len(scenarios)):
        raise ValueError("study count reconciliation failed")
    verify_designs(directory, protocol)
    verify_contexts(directory, protocol)
    stream_rows = verify_streams(directory, protocol)
    return {"runRows": count, "pairedDockets": len(pairs), "caseOutcomes": count * cases,
            "responseOffRunsVerified": off_count, "randomStreamRowsVerified": stream_rows,
            "allPairedReviewTimeContrastsExactlyZero": True}


def source_hashes() -> dict[str, str]:
    paths = sorted((ROOT / "src/main/java").rglob("*.java"))
    paths += [Path(__file__).resolve(), PROTOCOL_FILE, FORECAST_FILE,
              CONFIG / "protocol-lock.json", CONFIG / "forecast-lock.json"]
    paths += [CONFIG / name for name in INPUT_NAMES]
    return {path.relative_to(ROOT).as_posix(): file_hash(path) for path in paths}


def run_study(output: Path) -> None:
    protocol = prepare_inputs(check=True)
    output.mkdir(parents=True, exist_ok=True)
    before = source_hashes()
    # Simulation/check failures keep prior outputs intact. The final manifest is
    # written last so an interrupted multi-file promotion cannot pass hash checks.
    with tempfile.TemporaryDirectory(prefix="historical-study-") as temporary:
        directory = Path(temporary)
        classes = directory / "classes"
        classes.mkdir()
        subprocess.run(["javac", "--release", "21", "-d", str(classes),
                        *[str(path) for path in sorted((ROOT / "src/main/java").rglob("*.java"))]], check=True, cwd=ROOT)
        subprocess.run(["java", "-Xmx1024m", "-Dcourtsim.javaRelease=21", "-cp", str(classes),
                        "courtsim.experiment.HistoricalStudyRunner", str(CONFIG), str(directory)], cwd=ROOT, check=True)
        quality = verify_runs(directory, protocol)
        if before != source_hashes():
            raise ValueError("study source or configuration changed during execution")
        files = {suffix: file_hash(directory / f"{PREFIX}{suffix}") for suffix in OUTPUT_SUFFIXES}
        manifest = {
            "protocolId": protocol["protocolId"], "status": "complete-simulation-not-complete-publication",
            "sourceSha256": before, "outputSha256": files, "quality": quality,
            "runsPerCell": protocol["simulationRuns"], "casesPerRun": protocol["simulationCasesPerRun"],
            "simulationSeed": protocol["simulationSeed"],
            "javaRuntime": subprocess.run(["java", "-version"], capture_output=True, text=True, check=True).stderr.strip(),
            "seedContract": "Simulator arithmetic; world seed incorporates WorldSpec fingerprint; voting stream is scenarioIndex+101+period*503; response stream uses domain 0x524553504F4E5345 and 10001+period*503",
            "pairing": "one shared immutable case/object docket per profile/context/run; scenario voting streams differ",
            "docketProfile": "explicit locked forecast vector overrides WorldSpec doctrineDocketProfile enum; other inputs remain synthetic",
            "interpretation": "run-block Monte Carlo uncertainty and a fixed structural grid, not causal identification",
        }
        # Copy, rather than rename, across potentially different temporary/output filesystems.
        for suffix in OUTPUT_SUFFIXES:
            shutil.copyfile(directory / f"{PREFIX}{suffix}", output / f"{PREFIX}{suffix}")
        (output / f"{PREFIX}-manifest.json").write_bytes(json_bytes(manifest))
    print(json.dumps(quality, indent=2))


def check_study(output: Path, raw: bool = False) -> dict:
    protocol = prepare_inputs(check=True)
    manifest = json.loads((output / f"{PREFIX}-manifest.json").read_text())
    if manifest["sourceSha256"] != source_hashes():
        raise ValueError("study source provenance no longer matches the recorded run")
    expected = set(OUTPUT_SUFFIXES)
    if set(manifest["outputSha256"]) != expected:
        raise ValueError("incomplete study output hash inventory")
    for suffix, expected_hash in manifest["outputSha256"].items():
        if suffix in RAW_SUFFIXES and not raw:
            continue
        if file_hash(output / f"{PREFIX}{suffix}") != expected_hash:
            raise ValueError(f"study output hash mismatch: {suffix}")
    quality = verify_runs(output, protocol)
    if quality != manifest["quality"]:
        raise ValueError("recorded study quality differs from independently recomputed checks")
    return quality


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("action", choices=("prepare", "check-inputs", "run", "check", "check-raw"))
    parser.add_argument("--output-dir", type=Path, default=ROOT / "reports")
    args = parser.parse_args()
    if args.action in {"prepare", "check-inputs"}:
        prepare_inputs(check=args.action == "check-inputs")
        print("Registered study inputs match the protocol and locked training-only forecasts.")
    elif args.action == "run":
        run_study(args.output_dir)
    else:
        print(json.dumps(check_study(args.output_dir, raw=args.action == "check-raw"), indent=2))


if __name__ == "__main__":
    main()
