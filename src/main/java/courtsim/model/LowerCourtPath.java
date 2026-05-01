package courtsim.model;

public enum LowerCourtPath {
    DISTRICT_ONLY("district_only", 1, 0.04, 0.82, 0.74),
    CIRCUIT_PANEL("circuit_panel", 2, 0.10, 1.00, 1.00),
    CIRCUIT_EN_BANC("circuit_en_banc", 3, 0.18, 1.22, 1.20),
    STATE_HIGH_COURT("state_high_court", 2, 0.15, 1.08, 1.10),
    STATE_FEDERAL_SPLIT("state_federal_split", 3, 0.26, 1.36, 1.28);

    private final String key;
    private final int depth;
    private final double certiorariBoost;
    private final double conflictWeight;
    private final double delayWeight;

    LowerCourtPath(String key, int depth, double certiorariBoost, double conflictWeight, double delayWeight) {
        this.key = key;
        this.depth = depth;
        this.certiorariBoost = certiorariBoost;
        this.conflictWeight = conflictWeight;
        this.delayWeight = delayWeight;
    }

    public String key() {
        return key;
    }

    public int depth() {
        return depth;
    }

    public double certiorariBoost() {
        return certiorariBoost;
    }

    public double conflictWeight() {
        return conflictWeight;
    }

    public double delayWeight() {
        return delayWeight;
    }
}
