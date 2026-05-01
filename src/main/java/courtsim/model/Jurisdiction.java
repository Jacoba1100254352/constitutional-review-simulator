package courtsim.model;

public enum Jurisdiction {
    FEDERAL("federal", 0.10, 1.00),
    STATE("state", 0.22, 0.86),
    MIXED_STATE_FEDERAL("mixed_state_federal", 0.42, 1.14);

    private final String key;
    private final double stateFederalTensionWeight;
    private final double reviewAccessWeight;

    Jurisdiction(String key, double stateFederalTensionWeight, double reviewAccessWeight) {
        this.key = key;
        this.stateFederalTensionWeight = stateFederalTensionWeight;
        this.reviewAccessWeight = reviewAccessWeight;
    }

    public String key() {
        return key;
    }

    public double stateFederalTensionWeight() {
        return stateFederalTensionWeight;
    }

    public double reviewAccessWeight() {
        return reviewAccessWeight;
    }
}
