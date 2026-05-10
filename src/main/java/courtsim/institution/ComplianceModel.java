package courtsim.institution;

import courtsim.model.CaseFile;
import courtsim.model.DoctrineArea;
import courtsim.model.Jurisdiction;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

final class ComplianceModel {
    private final DesignConfiguration configuration;
    private final WorldSpec worldSpec;

    ComplianceModel(DesignConfiguration configuration, WorldSpec worldSpec) {
        this.configuration = configuration;
        this.worldSpec = worldSpec;
    }

    double complianceRate(
            CaseFile caseFile,
            double legitimacy,
            double constitutionalConflict,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed,
            ReactionState reactionState
    ) {
        double compliancePressure = 0.46
                + legitimacy * 0.24
                + reactionState.complianceNorm() * 0.22
                + worldSpec.implementationCapacity() * 0.10
                + configuration.independence() * 0.06
                - constitutionalConflict * 0.18
                - reactionState.legislativeConflict() * 0.12
                - reactionState.courtCurbingPressure() * 0.10
                - caseFile.stateFederalTension() * 0.04
                - caseFile.intercourtConflict() * 0.05
                - (emergencyReliefGranted && !meritsInvalidated ? 0.08 : 0.0)
                - (overrideUsed ? 0.10 : 0.0)
                - caseFile.executivePressure() * 0.08;
        return Values.clamp01(compliancePressure);
    }

    double defianceRisk(CaseFile caseFile, double constitutionalConflict, ReactionState reactionState) {
        return Values.clamp01(
                0.08
                        + constitutionalConflict * 0.30
                        + reactionState.legislativeConflict() * 0.24
                        + caseFile.executivePressure() * 0.18
                        + caseFile.stateFederalTension() * 0.10
                        - worldSpec.implementationCapacity() * 0.10
                        - reactionState.publicTrust() * 0.12
        );
    }

    double workaroundRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            ReactionState reactionState
    ) {
        return Values.clamp01(
                0.12
                        + (meritsInvalidated ? 0.18 : 0.0)
                        + (emergencyReliefGranted ? 0.10 : 0.0)
                        + reactionState.overridePressure() * 0.22
                        + caseFile.legislativeMandate() * 0.12
                        + caseFile.stateFederalTension() * 0.08
                        + worldSpec.electoralTimePressure() * 0.06
                        - worldSpec.implementationCapacity() * 0.06
        );
    }

    double repeatedLitigationRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted
    ) {
        return Values.clamp01(
                0.10
                        + caseFile.legalAmbiguity() * 0.24
                        + caseFile.lowerCourtConflict() * 0.18
                        + caseFile.intercourtConflict() * 0.16
                        + (emergencyReliefGranted && !meritsInvalidated ? 0.18 : 0.0)
        );
    }

    double executiveImplementationRate(
            CaseFile caseFile,
            double complianceRate,
            double legitimacy,
            double constitutionalConflict,
            ReactionState reactionState
    ) {
        return Values.clamp01(
                complianceRate * 0.62
                        + legitimacy * 0.16
                        + worldSpec.implementationCapacity() * 0.16
                        + reactionState.complianceNorm() * 0.14
                        - constitutionalConflict * 0.10
                        - caseFile.executivePressure() * 0.10
        );
    }

    double agencyNonacquiescenceRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            ReactionState reactionState
    ) {
        double agencyDoctrineRisk = caseFile.doctrineArea() == DoctrineArea.ADMINISTRATIVE_STATE ? 0.16 : 0.04;
        return Values.clamp01(
                agencyDoctrineRisk
                        + caseFile.executivePressure() * 0.18
                        + caseFile.legalAmbiguity() * 0.14
                        + reactionState.courtCurbingPressure() * 0.16
                        - worldSpec.implementationCapacity() * 0.10
                        + (meritsInvalidated ? 0.08 : 0.0)
                        + (emergencyReliefGranted ? 0.06 : 0.0)
        );
    }

    double legislativeReenactmentRisk(
            CaseFile caseFile,
            boolean meritsInvalidated,
            boolean overrideUsed,
            ReactionState reactionState
    ) {
        return Values.clamp01(
                0.06
                        + caseFile.legislativeMandate() * 0.20
                        + reactionState.overridePressure() * 0.22
                        + caseFile.stateFederalTension() * 0.08
                        + worldSpec.governmentControl() * 0.06
                        + worldSpec.electoralTimePressure() * 0.04
                        + (meritsInvalidated ? 0.14 : 0.0)
                        - (overrideUsed ? 0.08 : 0.0)
                        - caseFile.rightsThreat() * 0.08
        );
    }

    double localGovernmentComplianceRate(
            CaseFile caseFile,
            double complianceRate,
            double constitutionalConflict,
            ReactionState reactionState
    ) {
        double localExposure = caseFile.jurisdiction() == Jurisdiction.FEDERAL ? 0.08 : 0.22;
        return Values.clamp01(
                complianceRate * 0.58
                        + reactionState.complianceNorm() * 0.20
                        + worldSpec.implementationCapacity() * 0.10
                        + caseFile.publicSupport() * 0.08
                        - constitutionalConflict * 0.10
                        - caseFile.stateFederalTension() * localExposure
        );
    }
}
