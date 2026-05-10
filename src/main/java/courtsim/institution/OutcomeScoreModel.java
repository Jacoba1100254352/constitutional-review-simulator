package courtsim.institution;

import courtsim.model.CaseFile;
import courtsim.model.Jurisdiction;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

final class OutcomeScoreModel {
    private final DesignConfiguration configuration;
    private final WorldSpec worldSpec;

    OutcomeScoreModel(DesignConfiguration configuration, WorldSpec worldSpec) {
        this.configuration = configuration;
        this.worldSpec = worldSpec;
    }

    double partisanAlignment(CaseFile caseFile, double strikeShare, boolean invalidated) {
        double rightsJustifiedStrike = caseFile.rightsThreat();
        double partisanGap = Math.max(0.0, strikeShare - rightsJustifiedStrike);
        double lawPolarity = Math.abs(caseFile.policyPosition());
        double decisionBoost = invalidated ? 0.12 : 0.02;
        return Values.clamp01(
                partisanGap * lawPolarity * 0.70
                        + caseFile.executivePressure() * 0.15
                        + worldSpec.partisanPressure() * (1.0 - configuration.coalitionNorm()) * 0.18
                        + decisionBoost * lawPolarity
        );
    }

    double rightsProtection(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed,
            boolean weakFormDeclaration,
            boolean suspendedDeclaration,
            boolean legislativeResponse,
            double legislativeResponseDelay,
            double legislativeResponseDeadline,
            boolean timelyLegislativeResponse,
            boolean rightsImpactStatement,
            boolean publicDefenderParticipation
    ) {
        double score;
        if (meritsInvalidated) {
            score = 0.44 + caseFile.rightsThreat() * 0.54 - caseFile.legalAmbiguity() * 0.08;
        } else if (emergencyReliefGranted) {
            score = 0.38 + caseFile.rightsThreat() * 0.40 - caseFile.timeToReview() * 0.08;
        } else if (weakFormDeclaration) {
            score = 0.34 + caseFile.rightsThreat() * 0.40 + (legislativeResponse ? 0.16 : 0.02);
        } else {
            score = 1.0 - caseFile.rightsThreat() * 0.72 + caseFile.legislativeMandate() * 0.06 - caseFile.timeToReview() * caseFile.rightsThreat() * 0.08;
        }
        if (suspendedDeclaration) {
            score -= timelyLegislativeResponse ? 0.02 : 0.12 + caseFile.timeToReview() * 0.06;
        }
        if (legislativeResponse && legislativeResponseDeadline > 0.0 && legislativeResponseDelay > legislativeResponseDeadline) {
            score -= 0.06 + (legislativeResponseDelay - legislativeResponseDeadline) * 0.08;
        }
        if (rightsImpactStatement) {
            score += 0.05 + caseFile.rightsThreat() * 0.04;
        }
        if (publicDefenderParticipation) {
            score += 0.07 + caseFile.rightsThreat() * 0.06;
        }
        if (overrideUsed && caseFile.rightsThreat() > 0.55) {
            score -= 0.24 + caseFile.rightsThreat() * 0.14;
        }
        return Values.clamp01(score);
    }

    double constitutionalConflict(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed,
            double shadowAbuse,
            double crossCheckConflict,
            boolean weakFormDeclaration,
            boolean suspendedDeclaration,
            boolean legislativeResponse
    ) {
        double countermajoritarianClash = meritsInvalidated
                ? caseFile.legislativeMandate() * (0.22 + worldSpec.legislativeConflict() * 0.24)
                : emergencyReliefGranted
                ? caseFile.legislativeMandate() * 0.18
                : caseFile.rightsThreat() * caseFile.constitutionalSalience() * 0.18;
        return Values.clamp01(
                countermajoritarianClash
                        + (overrideUsed ? 0.36 : 0.0)
                        + (weakFormDeclaration ? 0.08 : 0.0)
                        + (suspendedDeclaration ? 0.12 : 0.0)
                        - (legislativeResponse ? 0.10 : 0.0)
                        + shadowAbuse * 0.30
                        + crossCheckConflict * 0.24
                        + caseFile.executivePressure() * 0.10
                        + Math.abs(caseFile.lowerCourtPanelSkew()) * 0.05
                        + caseFile.stateFederalTension() * 0.12
                        + caseFile.intercourtConflict() * 0.10
        );
    }

    double democraticResponsiveness(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed,
            boolean weakFormDeclaration,
            boolean suspendedDeclaration,
            boolean legislativeResponse
    ) {
        if (weakFormDeclaration || suspendedDeclaration) {
            return Values.clamp01(
                    caseFile.legislativeMandate() * 0.36
                            + caseFile.rightsThreat() * 0.26
                            + caseFile.publicSupport() * 0.18
                            + (legislativeResponse ? 0.16 : 0.0)
                            - stateDeferencePenalty(caseFile) * 0.50
            );
        }
        if (overrideUsed) {
            return Values.clamp01(0.48
                    + caseFile.legislativeMandate() * 0.34
                    - caseFile.rightsThreat() * 0.18
                    - caseFile.stateFederalTension() * 0.04);
        }
        if (meritsInvalidated) {
            return Values.clamp01(
                    (1.0 - caseFile.legislativeMandate()) * 0.26
                            + caseFile.rightsThreat() * 0.44
                            + caseFile.publicSupport() * 0.10
                            - stateDeferencePenalty(caseFile)
            );
        }
        if (emergencyReliefGranted) {
            return Values.clamp01(
                    (1.0 - caseFile.legislativeMandate()) * 0.16
                            + caseFile.rightsThreat() * 0.30
                            + caseFile.publicSupport() * 0.08
                            - stateDeferencePenalty(caseFile) * 0.55
            );
        }
        return Values.clamp01(
                caseFile.legislativeMandate() * 0.56
                        + caseFile.publicSupport() * 0.22
                        + (1.0 - caseFile.rightsThreat()) * 0.16
                        + (caseFile.jurisdiction() == Jurisdiction.STATE ? 0.04 : 0.0)
        );
    }

    double independenceAccountabilityBalance(CaseFile caseFile) {
        double desiredIndependence = Values.clamp01(
                0.42
                        + caseFile.rightsThreat() * 0.32
                        + caseFile.constitutionalSalience() * 0.10
                        - caseFile.legislativeMandate() * 0.16
                        + caseFile.certiorariPressure() * 0.08
        );
        double desiredAccountability = 1.0 - desiredIndependence;
        return Values.clamp01(
                1.0
                        - Math.abs(configuration.independence() - desiredIndependence) * 0.62
                        - Math.abs(configuration.accountabilityPressure() - desiredAccountability) * 0.34
        );
    }

    double vetoRelocationRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean weakFormDeclaration,
            boolean suspendedDeclaration,
            boolean legislativeResponse,
            boolean councilScreen,
            boolean crossChecked,
            IntakeEstimate intake,
            CostEstimate institutionalCosts,
            double caseSelectionAccess
    ) {
        double lowRightsIntervention = (meritsInvalidated || weakFormDeclaration || suspendedDeclaration)
                ? Math.max(0.0, 0.56 - caseFile.rightsThreat()) * 0.34
                : 0.0;
        double upstreamVeto = Values.clamp01(
                (councilScreen ? 0.24 : 0.0)
                        + (crossChecked ? 0.16 : 0.0)
                        + configuration.intakeScreeningIntensity() * 0.20
                        + institutionalCosts.upstreamScreening() * 0.18
                        + (1.0 - intake.acceptanceRate()) * 0.08
        );
        double dialogueOffset = legislativeResponse ? 0.16 : 0.0;
        return Values.clamp01(
                lowRightsIntervention
                        + upstreamVeto
                        + configuration.independence() * 0.08
                        + caseFile.governmentRepeatPlayerAdvantage() * 0.08
                        + Values.lowerIsBetter(caseSelectionAccess) * 0.08
                        + (configuration.transparency() < 0.55 ? 0.08 : 0.0)
                        - caseFile.rightsThreat() * 0.10
                        - dialogueOffset
        );
    }

    double democraticConstitutionalism(
            double legalStability,
            double rightsProtection,
            double legitimacy,
            double democraticResponsiveness,
            double complianceRate,
            double constitutionalConflict,
            double vetoRelocationRisk,
            double legalTransplantFeasibility,
            double politicalCultureSensitivity,
            double legislativeResponseCredibility,
            double caseSelectionAccess,
            double governmentRepeatPlayerAdvantage,
            double implementationCapacity
    ) {
        return Values.clamp01(
                legalStability * 0.11
                        + rightsProtection * 0.18
                        + legitimacy * 0.12
                        + democraticResponsiveness * 0.15
                        + complianceRate * 0.09
                        + Values.lowerIsBetter(constitutionalConflict) * 0.08
                        + Values.lowerIsBetter(vetoRelocationRisk) * 0.07
                        + legalTransplantFeasibility * 0.05
                        + Values.lowerIsBetter(politicalCultureSensitivity) * 0.03
                        + legislativeResponseCredibility * 0.03
                        + caseSelectionAccess * 0.03
                        + Values.lowerIsBetter(governmentRepeatPlayerAdvantage) * 0.03
                        + implementationCapacity * 0.03
        );
    }

    double stateDeferencePenalty(CaseFile caseFile) {
        return caseFile.jurisdiction() == Jurisdiction.STATE
                ? caseFile.legislativeMandate() * caseFile.doctrineArea().deferenceWeight() * 0.08
                : 0.0;
    }
}
