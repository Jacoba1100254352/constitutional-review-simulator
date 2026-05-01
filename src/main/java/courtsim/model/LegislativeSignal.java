package courtsim.model;

public record LegislativeSignal(
        String caseKey,
        String scenarioKey,
        String scenarioName,
        PolicyDomain policyDomain,
        double averageSupport,
        double welfare,
        double legitimacy,
        double lowSupportPassage,
        double weakPublicMandatePassage,
        double minorityHarm,
        double concentratedHarmPassage,
        double lobbyCapture,
        double publicAlignment,
        double publicPreferenceDistortion,
        double policyShift,
        double proposerGain,
        double reversalRate,
        double statusQuoVolatility,
        double fastLaneRate,
        double highRiskLaneRate,
        double challengeRate
) {
}
