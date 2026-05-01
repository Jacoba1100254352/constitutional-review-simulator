package courtsim.simulation;

public record SegmentReport(
        String segmentType,
        String segmentKey,
        int totalCases,
        int reviewedCases,
        double reviewRate,
        double legalStability,
        double rightsProtection,
        double shadowDocketAbuse,
        double emergencyReliefRate,
        double meritsInvalidationRate,
        double legitimacy,
        double constitutionalConflict,
        double democraticResponsiveness,
        double complianceRate,
        double defianceRate,
        double workaroundRate,
        double repeatedLitigationRate,
        double publicTrust,
        double legislativeConflict,
        double courtCurbingPressure,
        double amendmentPressure
) {
}

