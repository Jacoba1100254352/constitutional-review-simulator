package courtsim.simulation;

import courtsim.util.Values;

public record ScenarioReport(
        String scenarioKey,
        String scenarioName,
        int totalCases,
        int reviewedCases,
        int invalidations,
        int emergencyOrders,
        int emergencyReliefs,
        int meritsReviews,
        int meritsInvalidations,
        int overrides,
        double reviewRate,
        double emergencyReliefRate,
        double meritsReviewRate,
        double meritsInvalidationRate,
        double legalStability,
        double rightsProtection,
        double partisanAlignment,
        double shadowDocketAbuse,
        double legitimacy,
        double reversalRate,
        double constitutionalConflict,
        double democraticResponsiveness,
        double independenceAccountabilityBalance,
        double concurrenceFragmentation,
        double dissentIntensity,
        double recusalRate,
        double enBancRate,
        double crossCheckRate,
        double councilScreenRate,
        double overrideRate,
        double lowerCourtConflict,
        double averageTimeToReview,
        double replacementRate,
        double administrativeLoad
) {
    public double directionalScore() {
        return Values.average(
                legalStability,
                rightsProtection,
                Values.lowerIsBetter(partisanAlignment),
                Values.lowerIsBetter(shadowDocketAbuse),
                legitimacy,
                Values.lowerIsBetter(reversalRate),
                Values.lowerIsBetter(emergencyReliefRate),
                Values.lowerIsBetter(meritsInvalidationRate),
                Values.lowerIsBetter(constitutionalConflict),
                democraticResponsiveness,
                independenceAccountabilityBalance,
                Values.lowerIsBetter(administrativeLoad)
        );
    }
}
