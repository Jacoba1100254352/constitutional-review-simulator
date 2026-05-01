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
            new MetricDefinition("complianceRate", "Compliance rate", MetricDirection.HIGHER_IS_BETTER, "Share of cases where institutions comply with review outcomes."),
            new MetricDefinition("defianceRate", "Defiance rate", MetricDirection.LOWER_IS_BETTER, "Direct noncompliance with review outcomes."),
            new MetricDefinition("workaroundRate", "Workaround rate", MetricDirection.LOWER_IS_BETTER, "Legislative or executive workaround behavior after review."),
            new MetricDefinition("concurrenceFragmentation", "Concurrence fragmentation", MetricDirection.LOWER_IS_BETTER, "Fractured majority or concurrence structure."),
            new MetricDefinition("dissentIntensity", "Dissent intensity", MetricDirection.LOWER_IS_BETTER, "Close and polarized dissent pressure."),
            new MetricDefinition("executiveImplementationRate", "Executive implementation", MetricDirection.HIGHER_IS_BETTER, "Executive implementation of review outcomes."),
            new MetricDefinition("agencyNonacquiescenceRate", "Agency nonacquiescence", MetricDirection.LOWER_IS_BETTER, "Agency refusal, narrowing, or delayed implementation after review."),
            new MetricDefinition("legislativeReenactmentRate", "Legislative reenactment", MetricDirection.LOWER_IS_BETTER, "Reenactment or recoding after adverse review."),
            new MetricDefinition("localGovernmentComplianceRate", "Local-government compliance", MetricDirection.HIGHER_IS_BETTER, "State or local compliance with review outcomes."),
            new MetricDefinition("reviewRate", "Review rate", MetricDirection.DIAGNOSTIC, "Share of docket accepted for constitutional review."),
            new MetricDefinition("recusalRate", "Recusal rate", MetricDirection.DIAGNOSTIC, "Justice recusals per possible justice-case."),
            new MetricDefinition("overrideRate", "Override rate", MetricDirection.DIAGNOSTIC, "Legislative overrides per invalidation."),
            new MetricDefinition("meritsReviewRate", "Merits review rate", MetricDirection.DIAGNOSTIC, "Share of accepted cases receiving merits review."),
            new MetricDefinition("repeatedLitigationRate", "Repeated litigation rate", MetricDirection.DIAGNOSTIC, "Follow-on litigation pressure from ambiguous, defied, or worked-around outcomes."),
            new MetricDefinition("publicTrust", "Public trust", MetricDirection.DIAGNOSTIC, "Period-end public trust after decisions and compliance reactions."),
            new MetricDefinition("legislativeConflict", "Legislative conflict", MetricDirection.LOWER_IS_BETTER, "Period-end legislature-court conflict pressure after decisions."),
            new MetricDefinition("courtCurbingPressure", "Court-curbing pressure", MetricDirection.LOWER_IS_BETTER, "Political pressure to restrict court authority after decisions."),
            new MetricDefinition("amendmentPressure", "Amendment pressure", MetricDirection.DIAGNOSTIC, "Constitutional amendment pressure generated by institutional conflict."),
            new MetricDefinition("stateCaseShare", "State case share", MetricDirection.DIAGNOSTIC, "Share of docket originating primarily in state-law or state-court settings."),
            new MetricDefinition("mixedJurisdictionShare", "Mixed jurisdiction share", MetricDirection.DIAGNOSTIC, "Share of docket with state-federal conflict structure."),
            new MetricDefinition("averageLowerCourtDepth", "Lower-court depth", MetricDirection.DIAGNOSTIC, "Average number of lower-court layers before final review."),
            new MetricDefinition("stateFederalTension", "State-federal tension", MetricDirection.DIAGNOSTIC, "Average federalism tension in the docket."),
            new MetricDefinition("intercourtConflict", "Intercourt conflict", MetricDirection.DIAGNOSTIC, "Average conflict among lower courts or court systems."),
            new MetricDefinition("lowerCourtConflict", "Lower-court conflict", MetricDirection.DIAGNOSTIC, "Average lower-court conflict and circuit-split pressure."),
            new MetricDefinition("averageTimeToReview", "Time to review", MetricDirection.DIAGNOSTIC, "Stylized delay before final review."),
            new MetricDefinition("replacementRate", "Replacement pressure", MetricDirection.DIAGNOSTIC, "Dynamic court-composition turnover pressure across review periods."),
            new MetricDefinition("administrativeLoad", "Administrative load", MetricDirection.LOWER_IS_BETTER, "Procedural cost from review structure, emergency review, cross-checks, and recusals."),
            new MetricDefinition("institutionalBudgetCost", "Institutional budget cost", MetricDirection.LOWER_IS_BETTER, "Scenario-specific staffing and duplication cost from court size, councils, cross-checking structures, and substitutions."),
            new MetricDefinition("institutionalDelayCost", "Institutional delay cost", MetricDirection.LOWER_IS_BETTER, "Scenario-specific delay burden from lower-court path, en banc steps, cross-checks, councils, and emergency shortcuts."),
            new MetricDefinition("implementationComplexity", "Implementation complexity", MetricDirection.LOWER_IS_BETTER, "Operational complexity of thresholds, overrides, recusal machinery, and docket procedures."),
            new MetricDefinition("totalInstitutionalCost", "Total institutional cost", MetricDirection.LOWER_IS_BETTER, "Weighted budget, delay, and implementation complexity cost.")
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
