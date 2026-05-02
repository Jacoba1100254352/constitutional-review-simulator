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
        ReviewArchetype reviewArchetype,
        ReviewTiming reviewTiming,
        DocketControl docketControl,
        CostProfileKey costProfileKey,
        double appointmentSkew,
        double independence,
        double accountability,
        double transparency,
        double coalitionNorm,
        double rightsPriority,
        double stabilityPreference
) {
    public DesignConfiguration(
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
        this(
                label,
                appointmentMethod,
                courtSize,
                termLimit,
                removalStandard,
                recusalRule,
                docketProcedure,
                votingThreshold,
                reviewStructure,
                overrideRule,
                ReviewArchetype.DISCRETIONARY_APPELLATE_LEAVE,
                ReviewTiming.POST_ENACTMENT,
                DocketControl.DISCRETIONARY_CERTIORARI,
                CostProfileKey.STYLIZED_INTERNAL,
                appointmentSkew,
                independence,
                accountability,
                transparency,
                coalitionNorm,
                rightsPriority,
                stabilityPreference
        );
    }

    public DesignConfiguration {
        if (courtSize < 3) {
            throw new IllegalArgumentException("courtSize must be at least 3");
        }
        if (reviewArchetype == null) {
            reviewArchetype = ReviewArchetype.DISCRETIONARY_APPELLATE_LEAVE;
        }
        if (reviewTiming == null) {
            reviewTiming = ReviewTiming.POST_ENACTMENT;
        }
        if (docketControl == null) {
            docketControl = DocketControl.DISCRETIONARY_CERTIORARI;
        }
        if (costProfileKey == null) {
            costProfileKey = CostProfileKey.STYLIZED_INTERNAL;
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

    public boolean preEnactmentReview() {
        return reviewTiming == ReviewTiming.PRE_ENACTMENT
                || reviewTiming == ReviewTiming.MIXED_TIMING
                || reviewArchetype == ReviewArchetype.PRE_ENACTMENT_COUNCIL;
    }

    public double baseIntakeAcceptanceRate() {
        double archetypeBase = switch (reviewArchetype) {
            case DISCRETIONARY_APPELLATE_LEAVE -> 0.018;
            case CONSTITUTIONAL_COMPLAINT -> 0.0085;
            case PRE_ENACTMENT_COUNCIL -> 0.32;
            case MIXED_ABSTRACT_CONCRETE -> 0.12;
            case DECLARATION_ONLY_PARLIAMENTARY -> 0.26;
            case SUPRANATIONAL_TREATY -> 0.10;
        };
        double controlMultiplier = switch (docketControl) {
            case DISCRETIONARY_CERTIORARI -> 1.00;
            case LEAVE_TO_APPEAL -> 4.80;
            case COMPLAINT_ADMISSIBILITY -> 0.75;
            case REFERRAL_GATED -> 2.80;
            case MANDATORY_WITH_FILTERS -> 6.50;
        };
        return Values.clamp(archetypeBase * controlMultiplier, 0.003, 0.72);
    }

    public double intakeScreeningIntensity() {
        double control = switch (docketControl) {
            case DISCRETIONARY_CERTIORARI -> 0.72;
            case LEAVE_TO_APPEAL -> 0.62;
            case COMPLAINT_ADMISSIBILITY -> 0.88;
            case REFERRAL_GATED -> 0.56;
            case MANDATORY_WITH_FILTERS -> 0.48;
        };
        double archetype = switch (reviewArchetype) {
            case CONSTITUTIONAL_COMPLAINT -> 0.82;
            case PRE_ENACTMENT_COUNCIL -> 0.42;
            case MIXED_ABSTRACT_CONCRETE -> 0.64;
            case DECLARATION_ONLY_PARLIAMENTARY -> 0.36;
            case SUPRANATIONAL_TREATY -> 0.76;
            case DISCRETIONARY_APPELLATE_LEAVE -> 0.68;
        };
        return Values.clamp01((control + archetype) / 2.0);
    }

    public double benchmarkedDirectCourtCost() {
        return costProfileKey.directCourtCost();
    }

    public double benchmarkedDelayCost() {
        return costProfileKey.delayCost();
    }

    public double benchmarkedComplexityCost() {
        return costProfileKey.complexityCost();
    }

    public double benchmarkedCapacityStrain() {
        return costProfileKey.capacityStrain();
    }

    public double periodTurnoverRate() {
        double termTurnover = switch (termLimit) {
            case LIFE_TENURE -> 0.08;
            case NONRENEWABLE_18_YEAR -> 0.28;
            case SHORT_RENEWABLE -> 0.52;
        };
        double removalTurnover = switch (removalStandard) {
            case IMPEACHMENT_ONLY -> 0.04;
            case MISCONDUCT_COMMISSION -> 0.12;
            case RETENTION_ELECTION -> 0.30;
        };
        return Values.clamp01(termTurnover + removalTurnover + accountability * 0.14);
    }
}
