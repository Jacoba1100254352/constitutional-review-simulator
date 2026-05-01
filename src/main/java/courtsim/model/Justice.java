package courtsim.model;

public record Justice(
        String id,
        double ideology,
        double partisanAttachment,
        double rightsSensitivity,
        double institutionalism,
        double accountabilityPressure,
        double legitimacyConcern,
        double recusalStrictness
) {
}

