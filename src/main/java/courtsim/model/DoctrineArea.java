package courtsim.model;

public enum DoctrineArea {
    SPEECH(1.18, 0.88, 1.08, 0.90, 0.82),
    EQUALITY(1.28, 0.92, 1.10, 0.86, 0.92),
    CRIMINAL_PROCEDURE(1.16, 0.98, 0.96, 0.94, 0.88),
    FEDERALISM(0.78, 1.20, 0.92, 1.16, 1.08),
    ELECTION_LAW(1.08, 1.08, 1.22, 0.84, 1.18),
    EMERGENCY_POWERS(0.98, 1.28, 1.30, 1.08, 1.26),
    ADMINISTRATIVE_STATE(0.82, 1.22, 0.90, 1.18, 1.02);

    private final double rightsWeight;
    private final double deferenceWeight;
    private final double salienceWeight;
    private final double ambiguityWeight;
    private final double conflictWeight;

    DoctrineArea(
            double rightsWeight,
            double deferenceWeight,
            double salienceWeight,
            double ambiguityWeight,
            double conflictWeight
    ) {
        this.rightsWeight = rightsWeight;
        this.deferenceWeight = deferenceWeight;
        this.salienceWeight = salienceWeight;
        this.ambiguityWeight = ambiguityWeight;
        this.conflictWeight = conflictWeight;
    }

    public double rightsWeight() {
        return rightsWeight;
    }

    public double deferenceWeight() {
        return deferenceWeight;
    }

    public double salienceWeight() {
        return salienceWeight;
    }

    public double ambiguityWeight() {
        return ambiguityWeight;
    }

    public double conflictWeight() {
        return conflictWeight;
    }
}

