package courtsim.institution;


import courtsim.model.CaseFile;
import courtsim.util.Values;

import java.util.Random;


final class DecisionMechanismModel
{
	private final DesignConfiguration configuration;
	
	DecisionMechanismModel(DesignConfiguration configuration) {
		this.configuration = configuration;
	}
	
	boolean rightsImpactStatementUsed(CaseFile caseFile) {
		return configuration.rightsImpactStatementMechanism()
				|| (configuration.preEnactmentReview()
				&& caseFile.constitutionalSalience() > 0.46
				&& caseFile.legislativeMandate() > 0.38);
	}
	
	boolean ombudsmanTriggered(CaseFile caseFile) {
		return configuration.ombudsmanAccessMechanism()
				&& (caseFile.rightsThreat() * 0.58
				+ caseFile.constitutionalSalience() * 0.24
				+ (1.0 - caseFile.publicSupport()) * 0.18) > 0.54;
	}
	
	boolean publicDefenderParticipation(CaseFile caseFile) {
		return configuration.publicDefenderMechanism()
				&& (caseFile.rightsThreat() * 0.66
				+ caseFile.legalAmbiguity() * 0.16
				+ (1.0 - caseFile.publicSupport()) * 0.18) > 0.52;
	}
	
	boolean preEnactmentReview(CaseFile caseFile) {
		return configuration.preEnactmentReview()
				&& (caseFile.reviewPeriod() == 0
				|| caseFile.legislativeMandate() > 0.44
				|| caseFile.constitutionalSalience() > 0.50);
	}
	
	boolean abstractReview(CaseFile caseFile) {
		return configuration.abstractReviewMechanism()
				&& (caseFile.constitutionalSalience() > 0.52
				|| caseFile.stateFederalTension() > 0.46
				|| caseFile.intercourtConflict() > 0.46);
	}
	
	String supranationalRoute(CaseFile caseFile, Random random) {
		if (configuration.costProfileKey() == CostProfileKey.ECHR) {
			return "individual_application";
		}
		if (configuration.costProfileKey() != CostProfileKey.CJEU) {
			return "none";
		}
		
		double preliminary = Values.clamp(
				0.61
						+ caseFile.legalAmbiguity() * 0.05
						+ caseFile.intercourtConflict() * 0.04
						- caseFile.urgency() * 0.03,
				0.54,
				0.70
		);
		double appeal = Values.clamp(
				0.28
						+ (caseFile.lowerCourtGovernmentWin() ? 0.03 : 0.0)
						+ caseFile.lowerCourtConflict() * 0.04
						- caseFile.stateFederalTension() * 0.02,
				0.22,
				0.36
		);
		double direct = Values.clamp(
				0.045
						+ caseFile.executivePressure() * 0.02
						+ caseFile.constitutionalSalience() * 0.015,
				0.035,
				0.095
		);
		double total = preliminary + appeal + direct;
		if (total > 0.995) {
			double scale = 0.995 / total;
			preliminary *= scale;
			appeal *= scale;
			direct *= scale;
		}
		
		double draw = random.nextDouble();
		if (draw < preliminary) {
			return "preliminary_reference";
		}
		if (draw < preliminary + appeal) {
			return "appeal";
		}
		if (draw < preliminary + appeal + direct) {
			return "direct_action";
		}
		return "other";
	}
}
