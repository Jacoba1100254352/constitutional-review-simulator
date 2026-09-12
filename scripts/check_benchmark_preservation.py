"""Check the object extension against the fixed-seed pre-extension aggregate fixture."""

import csv
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]


def indexed(path):
    with path.open(encoding="utf-8", newline="") as handle:
        reader = csv.DictReader(handle)
        rows = list(reader)
    result = {(row["caseKey"], row["scenarioKey"]): row for row in rows}
    if len(result) != len(rows) or not rows:
        raise ValueError(f"empty or duplicate benchmark rows: {path.name}")
    return result


def main():
    legacy = indexed(ROOT / "config/regression/validation-before-object-extension.csv")
    current = indexed(ROOT / "reports/constitutional-review-validation-v1.csv")
    if legacy.keys() != current.keys():
        raise ValueError("legacy scenario coverage changed")
    for key, old in legacy.items():
        changed = [field for field, value in old.items() if current[key].get(field) != value]
        if changed:
            raise ValueError(f"pre-object benchmark changed for {key}: {changed}")
    print(f"Preserved all {len(next(iter(legacy.values())))} legacy aggregate fields across {len(legacy)} court presets")


if __name__ == "__main__":
    main()
