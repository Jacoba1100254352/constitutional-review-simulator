package courtsim.simulation;

public record CompositionReport(
        String segmentType,
        String segmentKey,
        int observations,
        double courtSize,
        double medianIdeology,
        double ideologicalSpread,
        double meanPartisanAttachment,
        double meanRightsSensitivity,
        double meanInstitutionalism,
        double replacementPressure,
        double estimatedReplacementEvents
) {
}
