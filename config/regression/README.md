# Object-extension preservation fixture

`validation-before-object-extension.csv` was generated from the committed
pre-object implementation with only the explicit value-based world seed fix
applied. It uses the canonical validation campaign: 120 runs, 80 cases,
seed 20260501, the existing eight court presets, and unchanged context inputs.

It is not a target fit or a new empirical source. It verifies that introducing
typed challenge objects does not change any existing aggregate output under
the same reproducible world draws. The paired audit also compared all 76,800
raw case rows and all 56 pre-existing calibration rows, with no differing
shared fields. The new Canadian statute row is outside that legacy comparison.

Do not regenerate this fixture from the object-extended implementation to make
a regression disappear. Any intentional change to institutional mechanisms,
world inputs, or seed protocol requires an explicit fixture migration and
separate evidence that its empirical claims remain appropriately bounded.
