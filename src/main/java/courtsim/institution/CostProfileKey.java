package courtsim.institution;

import courtsim.util.Values;

public enum CostProfileKey {
    STYLIZED_INTERNAL(0.34, 0.34, 0.42, 0.30),
    US_SUPREME_COURT(0.74, 0.33, 0.84, 0.48),
    US_APPELLATE_SYSTEM(0.92, 0.56, 0.72, 0.70),
    GERMAN_CONSTITUTIONAL_COURT(0.62, 0.42, 0.82, 0.56),
    FRENCH_CONSTITUTIONAL_COUNCIL(0.34, 0.16, 0.73, 0.36),
    CANADIAN_SUPREME_COURT(0.55, 0.39, 0.68, 0.46),
    SOUTH_AFRICAN_CONSTITUTIONAL_COURT(0.50, 0.60, 0.80, 0.68),
    UK_SUPREME_COURT(0.43, 0.37, 0.66, 0.42),
    INDIA_SUPREME_COURT(0.78, 0.78, 0.86, 0.84),
    BRAZIL_STF(0.74, 0.70, 0.88, 0.80),
    ECHR(0.68, 0.72, 0.76, 0.78),
    CJEU(0.62, 0.54, 0.74, 0.64);

    private final double directCourtCost;
    private final double delayCost;
    private final double complexityCost;
    private final double capacityStrain;

    CostProfileKey(double directCourtCost, double delayCost, double complexityCost, double capacityStrain) {
        this.directCourtCost = directCourtCost;
        this.delayCost = delayCost;
        this.complexityCost = complexityCost;
        this.capacityStrain = capacityStrain;
    }

    public double directCourtCost() {
        return Values.clamp01(directCourtCost);
    }

    public double delayCost() {
        return Values.clamp01(delayCost);
    }

    public double complexityCost() {
        return Values.clamp01(complexityCost);
    }

    public double capacityStrain() {
        return Values.clamp01(capacityStrain);
    }
}
