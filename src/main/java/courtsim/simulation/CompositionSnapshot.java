package courtsim.simulation;

public record CompositionSnapshot(
        int reviewPeriod,
        int courtSize,
        double medianIdeology,
        double ideologicalSpread,
        double meanPartisanAttachment,
        double meanRightsSensitivity,
        double meanInstitutionalism,
        double replacementPressure,
        double estimatedReplacementEvents
) {
}
