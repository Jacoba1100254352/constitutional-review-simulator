package courtsim.institution;

import courtsim.model.CaseFile;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.util.Random;

final class PostDecisionResponseModel {
    private final DesignConfiguration configuration;
    private final WorldSpec worldSpec;

    PostDecisionResponseModel(DesignConfiguration configuration, WorldSpec worldSpec) {
        this.configuration = configuration;
        this.worldSpec = worldSpec;
    }

    boolean overrideUsed(CaseFile caseFile, boolean invalidated, Random random) {
        if (!invalidated || configuration.overrideRule() == LegislativeOverrideRule.NONE) {
            return false;
        }
        double base = switch (configuration.overrideRule()) {
            case NONE -> 0.0;
            case SUPERMAJORITY_OVERRIDE -> 0.18;
            case DELAYED_MAJORITY_OVERRIDE -> 0.32;
            case REFERENDUM_OVERRIDE -> 0.25 + caseFile.publicSupport() * 0.22;
        };
        double overrideScore = base
                + caseFile.legislativeMandate() * 0.34
                + worldSpec.legislativeConflict() * 0.10
                - caseFile.rightsThreat() * 0.22
                - configuration.independence() * 0.08;
        return overrideScore + random.nextDouble() * 0.18 > 0.55;
    }

    double legislativeResponseCredibility(
            CaseFile caseFile,
            boolean weakFormDeclaration,
            boolean suspendedDeclaration,
            boolean meritsInvalidated,
            boolean overrideUsed
    ) {
        double triggerClarity = (weakFormDeclaration || suspendedDeclaration || overrideUsed)
                ? 0.18
                : (meritsInvalidated ? 0.08 : 0.0);
        return Values.clamp01(
                0.18
                        + worldSpec.governmentControl() * 0.18
                        + Values.lowerIsBetter(worldSpec.partyFragmentation()) * 0.14
                        + worldSpec.implementationCapacity() * 0.16
                        + worldSpec.civilSocietyCapacity() * 0.08
                        + configuration.transparency() * 0.08
                        + caseFile.legislativeMandate() * 0.13
                        + reactionCompatibility(caseFile) * 0.10
                        + triggerClarity
                        - worldSpec.legislativeConflict() * 0.13
                        - worldSpec.partisanPressure() * 0.08
                        - worldSpec.electoralTimePressure() * caseFile.rightsThreat() * 0.08
        );
    }

    boolean legislativeResponse(
            CaseFile caseFile,
            boolean weakFormDeclaration,
            boolean suspendedDeclaration,
            boolean meritsInvalidated,
            boolean overrideUsed,
            double legislativeResponseCredibility,
            Random random
    ) {
        boolean responseTrigger = weakFormDeclaration
                || suspendedDeclaration
                || meritsInvalidated
                || overrideUsed
                || (configuration.mandatoryLegislativeResponseMechanism()
                && caseFile.constitutionalSalience() * caseFile.rightsThreat() > 0.32);
        if (!responseTrigger
                || (!configuration.mandatoryLegislativeResponseMechanism()
                && !weakFormDeclaration
                && !suspendedDeclaration
                && !overrideUsed)) {
            return false;
        }
        double base = configuration.mandatoryLegislativeResponseMechanism() ? 0.52 : 0.30;
        if (weakFormDeclaration) {
            base += 0.12;
        }
        if (suspendedDeclaration) {
            base += 0.10;
        }
        double responseScore = base
                + caseFile.legislativeMandate() * 0.24
                + configuration.accountabilityPressure() * 0.16
                + configuration.transparency() * 0.08
                + legislativeResponseCredibility * 0.22
                + worldSpec.governmentControl() * 0.08
                + worldSpec.implementationCapacity() * 0.08
                - worldSpec.partyFragmentation() * 0.10
                - worldSpec.electoralTimePressure() * caseFile.rightsThreat() * 0.06
                - caseFile.rightsThreat() * 0.12
                - worldSpec.legislativeConflict() * 0.10
                - (meritsInvalidated && !suspendedDeclaration ? 0.08 : 0.0)
                + (overrideUsed ? 0.05 : 0.0);
        return responseScore + random.nextDouble() * 0.20 > 0.55;
    }

    double legislativeResponseDeadline(
            CaseFile caseFile,
            boolean weakFormDeclaration,
            boolean suspendedDeclaration,
            boolean overrideUsed,
            boolean constitutionalConcernFound
    ) {
        if (!weakFormDeclaration
                && !suspendedDeclaration
                && !overrideUsed
                && !(configuration.mandatoryLegislativeResponseMechanism() && constitutionalConcernFound)) {
            return 0.0;
        }
        double base = 0.58;
        if (suspendedDeclaration) {
            base = 0.42;
        } else if (configuration.mandatoryLegislativeResponseMechanism()) {
            base = 0.36;
        } else if (weakFormDeclaration) {
            base = 0.52;
        } else if (overrideUsed) {
            base = 0.46;
        }
        return Values.clamp01(
                base
                        - caseFile.urgency() * 0.08
                        - caseFile.rightsThreat() * 0.06
                        + configuration.transparency() * 0.04
        );
    }

    double legislativeResponseDelay(
            CaseFile caseFile,
            double deadline,
            double legislativeResponseCredibility,
            boolean suspendedDeclaration,
            Random random
    ) {
        double procedureDiscipline = configuration.mandatoryLegislativeResponseMechanism() ? 0.14 : 0.0;
        double suspensionDiscipline = suspendedDeclaration ? 0.10 : 0.0;
        double delay = 0.54
                + worldSpec.partyFragmentation() * 0.18
                + worldSpec.electoralTimePressure() * 0.12
                + worldSpec.legislativeConflict() * 0.10
                + caseFile.legalAmbiguity() * 0.08
                + caseFile.stateFederalTension() * 0.05
                - legislativeResponseCredibility * 0.22
                - worldSpec.implementationCapacity() * 0.12
                - worldSpec.governmentControl() * 0.08
                - procedureDiscipline
                - suspensionDiscipline
                + random.nextDouble() * 0.18;
        if (deadline > 0.0 && deadline < 0.45) {
            delay -= 0.04;
        }
        return Values.clamp01(delay);
    }

    private double reactionCompatibility(CaseFile caseFile) {
        return Values.clamp01(
                caseFile.publicSupport() * 0.36
                        + caseFile.publicTrust() * 0.28
                        + Values.lowerIsBetter(caseFile.legalAmbiguity()) * 0.18
                        + Values.lowerIsBetter(caseFile.stateFederalTension()) * 0.18
        );
    }
}
