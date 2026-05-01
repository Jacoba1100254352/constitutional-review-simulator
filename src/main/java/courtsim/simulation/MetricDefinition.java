package courtsim.simulation;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public record MetricDefinition(
        String key,
        String label,
        MetricDirection direction,
        String note
) {
    private static final List<MetricDefinition> DEFINITIONS = List.of(
            new MetricDefinition("legalStability", "Legal stability", MetricDirection.HIGHER_IS_BETTER, "Doctrinal and institutional stability after review."),
            new MetricDefinition("rightsProtection", "Rights protection", MetricDirection.HIGHER_IS_BETTER, "Protection against high-rights-threat laws without broad over-invalidation."),
            new MetricDefinition("partisanAlignment", "Partisan alignment", MetricDirection.LOWER_IS_BETTER, "Review tracking partisan law origin rather than legal risk."),
            new MetricDefinition("shadowDocketAbuse", "Shadow-docket abuse", MetricDirection.LOWER_IS_BETTER, "Emergency, unexplained, or high-impact non-merits action."),
            new MetricDefinition("legitimacy", "Legitimacy", MetricDirection.HIGHER_IS_BETTER, "Public trust, transparency, agreement, and rights performance net of conflict."),
            new MetricDefinition("reversalRate", "Reversal rate", MetricDirection.LOWER_IS_BETTER, "Share of cases in which a law or action is invalidated."),
            new MetricDefinition("emergencyReliefRate", "Emergency relief rate", MetricDirection.LOWER_IS_BETTER, "Share of emergency orders granting interim relief."),
            new MetricDefinition("meritsInvalidationRate", "Merits invalidation rate", MetricDirection.LOWER_IS_BETTER, "Share of merits reviews invalidating a law or action."),
            new MetricDefinition("constitutionalConflict", "Constitutional conflict", MetricDirection.LOWER_IS_BETTER, "Institutional clash around review outcomes."),
            new MetricDefinition("democraticResponsiveness", "Democratic responsiveness", MetricDirection.HIGHER_IS_BETTER, "Respect for public mandate unless rights risk justifies review."),
            new MetricDefinition("independenceAccountabilityBalance", "Independence/accountability balance", MetricDirection.HIGHER_IS_BETTER, "Fit between decisional independence and accountability pressure."),
            new MetricDefinition("concurrenceFragmentation", "Concurrence fragmentation", MetricDirection.LOWER_IS_BETTER, "Fractured majority or concurrence structure."),
            new MetricDefinition("dissentIntensity", "Dissent intensity", MetricDirection.LOWER_IS_BETTER, "Close and polarized dissent pressure."),
            new MetricDefinition("reviewRate", "Review rate", MetricDirection.DIAGNOSTIC, "Share of docket accepted for constitutional review."),
            new MetricDefinition("recusalRate", "Recusal rate", MetricDirection.DIAGNOSTIC, "Justice recusals per possible justice-case."),
            new MetricDefinition("overrideRate", "Override rate", MetricDirection.DIAGNOSTIC, "Legislative overrides per invalidation."),
            new MetricDefinition("meritsReviewRate", "Merits review rate", MetricDirection.DIAGNOSTIC, "Share of accepted cases receiving merits review."),
            new MetricDefinition("lowerCourtConflict", "Lower-court conflict", MetricDirection.DIAGNOSTIC, "Average lower-court conflict and circuit-split pressure."),
            new MetricDefinition("averageTimeToReview", "Time to review", MetricDirection.DIAGNOSTIC, "Stylized delay before final review."),
            new MetricDefinition("replacementRate", "Replacement pressure", MetricDirection.DIAGNOSTIC, "Dynamic court-composition turnover pressure across review periods."),
            new MetricDefinition("administrativeLoad", "Administrative load", MetricDirection.LOWER_IS_BETTER, "Procedural cost from review structure, emergency review, cross-checks, and recusals.")
    );

    private static final Map<String, MetricDefinition> BY_KEY = DEFINITIONS.stream()
            .collect(Collectors.toUnmodifiableMap(MetricDefinition::key, Function.identity()));

    public static List<MetricDefinition> definitions() {
        return DEFINITIONS;
    }

    public static MetricDefinition require(String key) {
        MetricDefinition definition = BY_KEY.get(key);
        if (definition == null) {
            throw new IllegalArgumentException("Unknown metric: " + key);
        }
        return definition;
    }
}
