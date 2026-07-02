package courtsim.institution;


import courtsim.model.CaseFile;
import courtsim.model.CaseType;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.util.Random;


final class IntakeModel
{
	private final DesignConfiguration configuration;
	private final WorldSpec worldSpec;
	
	IntakeModel(DesignConfiguration configuration, WorldSpec worldSpec) {
		this.configuration = configuration;
		this.worldSpec = worldSpec;
	}
	
	boolean isEmergency(CaseFile caseFile, Random random) {
		double pressure = caseFile.urgency() * 0.72 + worldSpec.emergencyPressure() * 0.28;
		double threshold = switch (configuration.docketProcedure()) {
			case FAST_SHADOW_DOCKET -> 0.46;
			case REASONED_EMERGENCY_PANEL -> 0.55;
			case FULL_COURT_EMERGENCY -> 0.60;
			case MERITS_FOLLOW_UP -> 0.58;
		};
		return caseFile.type() == CaseType.EMERGENCY || pressure + random.nextDouble() * 0.18 > threshold;
	}
	
	boolean shouldReview(
			CaseFile caseFile,
			boolean emergency,
			boolean rightsImpactStatement,
			boolean ombudsmanTriggered,
			boolean publicDefenderParticipation,
			boolean preEnactmentReview,
			boolean abstractReview,
			Random random
	) {
		double structuralAccess = switch (configuration.reviewStructure()) {
			case FULL_COURT -> 0.25;
			case PANEL_EN_BANC -> 0.35;
			case DUAL_SUPREME_COURTS -> 0.30;
			case CROSS_CHECKING_COURTS -> 0.34;
			case CONSTITUTIONAL_COUNCIL -> 0.48;
		};
		double reviewScore = structuralAccess
				+ caseFile.rightsThreat() * 0.26
				+ caseFile.constitutionalSalience() * 0.22
				+ caseFile.lowerCourtConflict() * 0.16
				+ caseFile.certiorariPressure() * 0.22
				+ Math.abs(caseFile.lowerCourtPanelSkew()) * 0.08
				+ caseFile.stateFederalTension() * 0.08
				+ caseFile.intercourtConflict() * 0.12
				+ caseFile.lowerCourtPath().certiorariBoost() * 0.30
				+ (emergency ? 0.18 : 0.0)
				+ (rightsImpactStatement ? 0.05 : 0.0)
				+ (ombudsmanTriggered ? 0.16 : 0.0)
				+ (publicDefenderParticipation ? 0.13 : 0.0)
				+ (preEnactmentReview ? 0.10 : 0.0)
				+ (abstractReview ? 0.12 : 0.0)
				+ caseFile.litigantCapacity() * 0.09
				+ caseFile.publicInterestSupport() * 0.12
				+ caseFile.governmentRepeatPlayerAdvantage() * 0.05
				- caseFile.legalAmbiguity() * 0.05;
		return reviewScore * caseFile.jurisdiction().reviewAccessWeight() + random.nextDouble() * 0.24 > 0.48;
	}
	
	IntakeEstimate estimate(
			CaseFile caseFile,
			boolean emergency,
			boolean reviewed,
			boolean ombudsmanTriggered,
			boolean publicDefenderParticipation,
			boolean abstractReview
	) {
		double acceptance = configuration.baseIntakeAcceptanceRate()
				* (0.64
				+ caseFile.certiorariPressure() * 0.52
				+ caseFile.constitutionalSalience() * 0.34
				+ caseFile.lowerCourtConflict() * 0.24
				+ caseFile.stateFederalTension() * 0.10
				+ caseFile.intercourtConflict() * 0.12
				+ (emergency ? 0.55 : 0.0)
				+ (configuration.preEnactmentReview() ? 0.34 : 0.0)
				+ (ombudsmanTriggered ? 0.22 : 0.0)
				+ (publicDefenderParticipation ? 0.18 : 0.0)
				+ (abstractReview ? 0.20 : 0.0)
				+ caseFile.litigantCapacity() * 0.18
				+ caseFile.publicInterestSupport() * 0.16
				+ caseFile.governmentRepeatPlayerAdvantage() * 0.08);
		if (configuration.docketControl() == DocketControl.MANDATORY_WITH_FILTERS) {
			acceptance *= 1.55;
		}
		if (configuration.docketControl() == DocketControl.COMPLAINT_ADMISSIBILITY) {
			acceptance *= 0.76 + caseFile.rightsThreat() * 0.28;
		}
		acceptance *= configuration.sourceIntakeDenominatorMultiplier();
		acceptance = Values.clamp(acceptance, 0.003, 0.82);
		int representedFilings = Math.max(1, (int) Math.round(1.0 / acceptance));
		int pressureFilings = (int) Math.round(
				representedFilings
						* (1.0
						+ caseFile.legalAmbiguity() * 0.20
						+ caseFile.lowerCourtConflict() * 0.18
						+ (emergency ? 0.24 : 0.0)
						+ configuration.intakeScreeningIntensity() * 0.18)
		);
		int intakeFilings = Math.max(1, pressureFilings);
		int acceptedFilings = reviewed ? 1 : 0;
		int screenedFilings = Math.max(0, intakeFilings - acceptedFilings);
		return new IntakeEstimate(intakeFilings, screenedFilings, Values.ratio(acceptedFilings, intakeFilings));
	}
	
	double caseSelectionAccess(CaseFile caseFile, IntakeEstimate intake) {
		if (configuration.sourceCaseSelectionAccessUsesIntakeProxy()) {
			return Values.clamp01(intake.acceptanceRate() * 0.94);
		}
		return Values.clamp01(
				caseFile.litigantCapacity() * 0.38
						+ caseFile.publicInterestSupport() * 0.32
						+ intake.acceptanceRate() * 0.12
						+ worldSpec.civilSocietyCapacity() * 0.10
						+ Values.lowerIsBetter(caseFile.governmentRepeatPlayerAdvantage()) * 0.08
		);
	}
}
