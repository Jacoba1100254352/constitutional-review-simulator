package courtsim.institution;

import courtsim.model.CaseFile;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

final class InstitutionalCostModel {
    private final DesignConfiguration configuration;
    private final WorldSpec worldSpec;
    private final double replacementPressure;

    InstitutionalCostModel(DesignConfiguration configuration, WorldSpec worldSpec, double replacementPressure) {
        this.configuration = configuration;
        this.worldSpec = worldSpec;
        this.replacementPressure = replacementPressure;
    }

    double administrativeLoad(
            CaseFile caseFile,
            boolean emergency,
            boolean enBanc,
            boolean crossChecked,
            boolean councilScreen,
            int recused
    ) {
        double structureCost = switch (configuration.reviewStructure()) {
            case FULL_COURT -> 0.20;
            case PANEL_EN_BANC -> 0.24 + (enBanc ? 0.20 : 0.0);
            case DUAL_SUPREME_COURTS -> 0.48;
            case CROSS_CHECKING_COURTS -> 0.42;
            case CONSTITUTIONAL_COUNCIL -> 0.34;
        };
        return Values.clamp01(
                structureCost
                        + (emergency ? 0.10 : 0.0)
                        + (crossChecked ? 0.16 : 0.0)
                        + (councilScreen ? 0.10 : 0.0)
                        + recused * 0.018
                        + caseFile.legalAmbiguity() * 0.12
                        + caseFile.timeToReview() * 0.08
                        + caseFile.lowerCourtPath().depth() * 0.025
                        + caseFile.stateFederalTension() * 0.06
                        + caseFile.intercourtConflict() * 0.05
                        + (caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure * 0.05)
        );
    }

    CostEstimate institutionalCosts(
            CaseFile caseFile,
            boolean emergency,
            boolean enBanc,
            boolean crossChecked,
            boolean councilScreen,
            int recused,
            double administrativeLoad,
            IntakeEstimate intake,
            boolean rightsImpactStatement,
            boolean ombudsmanTriggered,
            boolean publicDefenderParticipation,
            boolean preEnactmentReview,
            boolean abstractReview,
            boolean legislativeResponse
    ) {
        double sizeCost = Values.clamp01(0.10 + Math.max(0, configuration.courtSize() - 9) * 0.028);
        double structureBudget = switch (configuration.reviewStructure()) {
            case FULL_COURT -> 0.08;
            case PANEL_EN_BANC -> 0.20 + (enBanc ? 0.08 : 0.0);
            case DUAL_SUPREME_COURTS -> 0.46;
            case CROSS_CHECKING_COURTS -> 0.40;
            case CONSTITUTIONAL_COUNCIL -> 0.34;
        };
        double stylizedBudget = Values.clamp01(
                sizeCost
                        + structureBudget
                        + (configuration.substitutesRecusedJustices() ? 0.08 : 0.0)
                        + recused * 0.012
                        + (ombudsmanTriggered ? 0.035 : 0.0)
                        + (publicDefenderParticipation ? 0.045 : 0.0)
                        + (caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure * 0.08)
        );

        double structureDelay = switch (configuration.reviewStructure()) {
            case FULL_COURT -> 0.08;
            case PANEL_EN_BANC -> 0.14 + (enBanc ? 0.18 : 0.0);
            case DUAL_SUPREME_COURTS -> 0.30;
            case CROSS_CHECKING_COURTS -> 0.26;
            case CONSTITUTIONAL_COUNCIL -> 0.20;
        };
        double stylizedDelay = Values.clamp01(
                caseFile.timeToReview() * 0.42
                        + caseFile.lowerCourtPath().delayWeight() * 0.10
                        + caseFile.lowerCourtPath().depth() * 0.035
                        + structureDelay
                        + (crossChecked ? 0.14 : 0.0)
                        + (councilScreen ? 0.06 : 0.0)
                        + (abstractReview ? 0.05 : 0.0)
                        + (legislativeResponse ? 0.08 : 0.0)
                        - (emergency ? 0.08 : 0.0)
                        - (preEnactmentReview ? 0.05 : 0.0)
        );

        double thresholdComplexity = switch (configuration.votingThreshold()) {
            case SIMPLE_MAJORITY -> 0.06;
            case SUPERMAJORITY_TO_INVALIDATE -> 0.18;
            case CONCURRENT_MAJORITY -> 0.24;
            case HIGH_CONSTITUTIONAL_THRESHOLD -> 0.20;
        };
        double overrideComplexity = switch (configuration.overrideRule()) {
            case NONE -> 0.00;
            case SUPERMAJORITY_OVERRIDE -> 0.14;
            case DELAYED_MAJORITY_OVERRIDE -> 0.18;
            case REFERENDUM_OVERRIDE -> 0.24;
        };
        double procedureComplexity = switch (configuration.docketProcedure()) {
            case FAST_SHADOW_DOCKET -> 0.08;
            case REASONED_EMERGENCY_PANEL -> 0.14;
            case FULL_COURT_EMERGENCY -> 0.20;
            case MERITS_FOLLOW_UP -> 0.24;
        };
        double stylizedComplexity = Values.clamp01(
                administrativeLoad * 0.34
                        + thresholdComplexity
                        + overrideComplexity
                        + procedureComplexity
                        + (configuration.recusalRule() == RecusalRule.STRICT_TRANSPARENCY ? 0.08 : 0.0)
                        + (configuration.recusalRule() == RecusalRule.RANDOM_SUBSTITUTION ? 0.10 : 0.0)
                        + (rightsImpactStatement ? 0.06 : 0.0)
                        + (ombudsmanTriggered ? 0.05 : 0.0)
                        + (publicDefenderParticipation ? 0.07 : 0.0)
                        + (legislativeResponse ? 0.08 : 0.0)
                        + caseFile.legalAmbiguity() * 0.08
        );
        double directCourt = Values.clamp01(
                configuration.benchmarkedDirectCourtCost() * 0.62
                        + stylizedBudget * 0.30
                        + administrativeLoad * 0.08
        );
        double intakePressure = Values.clamp01(Math.log1p(intake.intakeFilings()) / Math.log(140.0));
        double upstreamScreening = Values.clamp01(
                configuration.intakeScreeningIntensity() * 0.38
                        + intakePressure * 0.30
                        + caseFile.lowerCourtPath().depth() * 0.035
                        + caseFile.lowerCourtConflict() * 0.10
                        + caseFile.intercourtConflict() * 0.08
                        + (ombudsmanTriggered ? 0.07 : 0.0)
                        + (publicDefenderParticipation ? 0.05 : 0.0)
                        + (rightsImpactStatement ? 0.04 : 0.0)
                        + (configuration.preEnactmentReview() ? -0.08 : 0.0)
        );
        double capacityStrain = Values.clamp01(
                configuration.benchmarkedCapacityStrain() * 0.48
                        + intakePressure * 0.20
                        + administrativeLoad * 0.18
                        + (emergency ? 0.06 : 0.0)
                        + (crossChecked ? 0.08 : 0.0)
                        + (caseFile.reviewPeriod() == 0 ? 0.0 : replacementPressure * 0.08)
        );
        double budget = Values.clamp01(directCourt * 0.68 + upstreamScreening * 0.22 + stylizedBudget * 0.10);
        double delay = Values.clamp01(
                configuration.benchmarkedDelayCost() * 0.45
                        + stylizedDelay * 0.34
                        + upstreamScreening * 0.10
                        + capacityStrain * 0.11
        );
        double complexity = Values.clamp01(
                configuration.benchmarkedComplexityCost() * 0.42
                        + stylizedComplexity * 0.34
                        + upstreamScreening * 0.14
                        + capacityStrain * 0.10
        );
        double total = Values.clamp01(directCourt * 0.25 + upstreamScreening * 0.20 + capacityStrain * 0.20 + delay * 0.18 + complexity * 0.17);
        return new CostEstimate(directCourt, upstreamScreening, capacityStrain, budget, delay, complexity, total);
    }

    double legalTransplantFeasibility(CaseFile caseFile, CostEstimate institutionalCosts) {
        double institutionalDemand = Values.clamp01(
                institutionalCosts.total() * 0.38
                        + institutionalCosts.upstreamScreening() * 0.18
                        + institutionalCosts.complexity() * 0.22
                        + configuration.intakeScreeningIntensity() * 0.10
                        + (configuration.syntheticMechanism() ? 0.08 : 0.0)
        );
        double politicalMismatch = Values.clamp01(
                worldSpec.legislativeConflict() * 0.24
                        + worldSpec.partisanPressure() * 0.20
                        + (1.0 - worldSpec.publicTrust()) * 0.18
                        + Math.abs(configuration.independence() - configuration.accountabilityPressure()) * 0.10
        );
        return Values.clamp01(
                configuration.legalTransplantFeasibility() * 0.36
                        + configuration.politicalCultureFit() * 0.16
                        + worldSpec.legalTraditionCompatibility() * 0.14
                        + worldSpec.implementationCapacity() * 0.12
                        + worldSpec.civilSocietyCapacity() * 0.08
                        + caseFile.publicTrust() * 0.06
                        + Values.lowerIsBetter(institutionalDemand) * 0.05
                        + Values.lowerIsBetter(politicalMismatch) * 0.03
        );
    }

    double politicalCultureSensitivity(
            CaseFile caseFile,
            double constitutionalConflict,
            CostEstimate institutionalCosts
    ) {
        double mechanismFragility = switch (configuration.reviewMechanism()) {
            case STRONG_FORM_COURT -> 0.22;
            case WEAK_FORM_REVIEW -> 0.30;
            case SUSPENDED_DECLARATION -> 0.34;
            case LEGISLATIVE_OVERRIDE_CLAUSE -> 0.36;
            case PRE_ENACTMENT_REVIEW -> 0.32;
            case ABSTRACT_REVIEW -> 0.38;
            case OMBUDSMAN_TRIGGERED_REVIEW -> 0.28;
            case CONSTITUTIONAL_PUBLIC_DEFENDER -> 0.26;
            case RIGHTS_IMPACT_STATEMENT -> 0.24;
            case MANDATORY_LEGISLATIVE_RESPONSE -> 0.42;
            case SUPRANATIONAL_REVIEW -> 0.46;
        };
        return Values.clamp01(
                mechanismFragility
                        + (1.0 - configuration.politicalCultureFit()) * 0.28
                        + worldSpec.legislativeConflict() * 0.18
                        + worldSpec.partisanPressure() * 0.16
                        + worldSpec.partyFragmentation() * 0.10
                        + worldSpec.electoralTimePressure() * 0.06
                        + Values.lowerIsBetter(worldSpec.civilSocietyCapacity()) * 0.06
                        + Values.lowerIsBetter(worldSpec.implementationCapacity()) * 0.06
                        + constitutionalConflict * 0.14
                        + institutionalCosts.complexity() * 0.10
                        + caseFile.stateFederalTension() * 0.06
        );
    }

    double implementationCapacity(
            CaseFile caseFile,
            double constitutionalConflict,
            CostEstimate institutionalCosts
    ) {
        return Values.clamp01(
                worldSpec.implementationCapacity() * 0.48
                        + worldSpec.legalTraditionCompatibility() * 0.10
                        + caseFile.publicTrust() * 0.10
                        + Values.lowerIsBetter(institutionalCosts.total()) * 0.14
                        + Values.lowerIsBetter(institutionalCosts.complexity()) * 0.08
                        + Values.lowerIsBetter(constitutionalConflict) * 0.10
        );
    }
}
