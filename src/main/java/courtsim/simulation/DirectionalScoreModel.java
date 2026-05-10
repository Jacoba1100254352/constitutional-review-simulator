package courtsim.simulation;

import courtsim.util.Values;

public final class DirectionalScoreModel {
    private DirectionalScoreModel() {
    }

    public static double score(ScenarioReport report) {
        return Values.average(
                report.legalStability(),
                report.rightsProtection(),
                Values.lowerIsBetter(report.partisanAlignment()),
                Values.lowerIsBetter(report.shadowDocketAbuse()),
                report.legitimacy(),
                Values.lowerIsBetter(report.reversalRate()),
                Values.lowerIsBetter(report.emergencyReliefRate()),
                Values.lowerIsBetter(report.meritsInvalidationRate()),
                Values.lowerIsBetter(report.constitutionalConflict()),
                report.democraticResponsiveness(),
                report.independenceAccountabilityBalance(),
                report.complianceRate(),
                Values.lowerIsBetter(report.defianceRate()),
                Values.lowerIsBetter(report.workaroundRate()),
                report.executiveImplementationRate(),
                Values.lowerIsBetter(report.agencyNonacquiescenceRate()),
                Values.lowerIsBetter(report.legislativeReenactmentRate()),
                report.localGovernmentComplianceRate(),
                Values.lowerIsBetter(report.emergencyPublicDisagreementRate()),
                report.emergencyReasonGivingRate(),
                report.emergencyVoteDisclosureRate(),
                Values.lowerIsBetter(report.administrativeLoad()),
                Values.lowerIsBetter(report.totalInstitutionalCost()),
                Values.lowerIsBetter(report.vetoRelocationRisk()),
                report.legalTransplantFeasibility(),
                Values.lowerIsBetter(report.politicalCultureSensitivity()),
                report.legislativeResponseCredibility(),
                report.caseSelectionAccess(),
                Values.lowerIsBetter(report.governmentRepeatPlayerAdvantage()),
                report.implementationCapacity(),
                report.democraticConstitutionalism(),
                report.legislativeResponseRate(),
                Values.lowerIsBetter(report.averageLegislativeResponseDelay()),
                report.timelyLegislativeResponseRate(),
                report.rightsImpactStatementRate()
        );
    }
}
