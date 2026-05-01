package courtsim.model;

public record CaseFile(
        String id,
        CaseType type,
        DoctrineArea doctrineArea,
        int reviewPeriod,
        double policyPosition,
        double rightsThreat,
        double publicSupport,
        double legislativeMandate,
        double urgency,
        double legalAmbiguity,
        double constitutionalSalience,
        double lowerCourtConflict,
        double lowerCourtPanelSkew,
        double certiorariPressure,
        double timeToReview,
        boolean lowerCourtGovernmentWin,
        double executivePressure,
        double conflictOfInterestRisk,
        double publicTrust,
        String source
) {
}
