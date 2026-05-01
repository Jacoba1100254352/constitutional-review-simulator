package courtsim.institution;

import courtsim.util.Values;

public record DesignConfiguration(
        String label,
        AppointmentMethod appointmentMethod,
        int courtSize,
        TermLimit termLimit,
        RemovalStandard removalStandard,
        RecusalRule recusalRule,
        DocketProcedure docketProcedure,
        VotingThreshold votingThreshold,
        ReviewStructure reviewStructure,
        LegislativeOverrideRule overrideRule,
        double appointmentSkew,
        double independence,
        double accountability,
        double transparency,
        double coalitionNorm,
        double rightsPriority,
        double stabilityPreference
) {
    public DesignConfiguration {
        if (courtSize < 3) {
            throw new IllegalArgumentException("courtSize must be at least 3");
        }
        appointmentSkew = Values.signedClamp(appointmentSkew);
        independence = Values.clamp01(independence);
        accountability = Values.clamp01(accountability);
        transparency = Values.clamp01(transparency);
        coalitionNorm = Values.clamp01(coalitionNorm);
        rightsPriority = Values.clamp01(rightsPriority);
        stabilityPreference = Values.clamp01(stabilityPreference);
    }

    public double appointmentPolarizationMultiplier() {
        return switch (appointmentMethod) {
            case PRESIDENTIAL_SENATE -> 1.10;
            case SUPERMAJORITY_COMMISSION -> 0.62;
            case MERIT_SORTITION -> 0.45;
            case LEGISLATIVE_SELECTION -> 1.25;
            case POPULAR_RETENTION -> 0.92;
        };
    }

    public double accountabilityPressure() {
        double removalPressure = switch (removalStandard) {
            case IMPEACHMENT_ONLY -> 0.12;
            case MISCONDUCT_COMMISSION -> 0.34;
            case RETENTION_ELECTION -> 0.62;
        };
        double termPressure = switch (termLimit) {
            case LIFE_TENURE -> 0.12;
            case NONRENEWABLE_18_YEAR -> 0.28;
            case SHORT_RENEWABLE -> 0.58;
        };
        return Values.clamp01((accountability * 0.55) + (removalPressure * 0.25) + (termPressure * 0.20));
    }

    public double emergencyReasonGiving() {
        return switch (docketProcedure) {
            case FAST_SHADOW_DOCKET -> transparency * 0.35;
            case REASONED_EMERGENCY_PANEL -> 0.58 + transparency * 0.30;
            case FULL_COURT_EMERGENCY -> 0.70 + transparency * 0.25;
            case MERITS_FOLLOW_UP -> 0.78 + transparency * 0.18;
        };
    }

    public double recusalMultiplier() {
        return switch (recusalRule) {
            case SELF_POLICING -> 0.35;
            case MANDATORY_CONFLICT -> 0.80;
            case RANDOM_SUBSTITUTION -> 0.95;
            case STRICT_TRANSPARENCY -> 1.12;
        };
    }

    public double invalidationThreshold() {
        return switch (votingThreshold) {
            case SIMPLE_MAJORITY -> 0.500001;
            case SUPERMAJORITY_TO_INVALIDATE -> 0.600001;
            case CONCURRENT_MAJORITY -> 0.550001;
            case HIGH_CONSTITUTIONAL_THRESHOLD -> 0.700001;
        };
    }

    public boolean substitutesRecusedJustices() {
        return recusalRule == RecusalRule.RANDOM_SUBSTITUTION;
    }
}

