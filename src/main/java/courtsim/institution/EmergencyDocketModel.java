package courtsim.institution;


import courtsim.model.CaseFile;
import courtsim.model.Jurisdiction;
import courtsim.model.PolicyDomain;
import courtsim.util.Values;

import java.util.Random;


final class EmergencyDocketModel
{
	private final DesignConfiguration configuration;
	
	EmergencyDocketModel(DesignConfiguration configuration) {
		this.configuration = configuration;
	}
	
	String applicantType(CaseFile caseFile, boolean emergency) {
		if (!emergency) {
			return "not-emergency";
		}
		PolicyDomain domain = caseFile.policyDomain();
		if (domain == PolicyDomain.ADMINISTRATION || domain == PolicyDomain.EMERGENCY_SECURITY) {
			return caseFile.executivePressure() > 0.45 ? "federal-government" : "agency";
		}
		if (domain == PolicyDomain.FEDERALISM || domain == PolicyDomain.ELECTIONS
				|| caseFile.jurisdiction() == Jurisdiction.STATE
				|| caseFile.jurisdiction() == Jurisdiction.MIXED_STATE_FEDERAL) {
			return "state-government";
		}
		if (domain == PolicyDomain.CRIMINAL_JUSTICE) {
			return "criminal-defendant";
		}
		if (domain == PolicyDomain.ECONOMIC_REGULATION) {
			return caseFile.publicSupport() > 0.58 ? "federal-government" : "regulated-party";
		}
		return "private-party";
	}
	
	boolean isGovernmentApplicant(String applicantType) {
		return applicantType.contains("government") || applicantType.equals("agency");
	}
	
	boolean meritsReview(boolean emergency, CaseFile caseFile) {
		if (!emergency) {
			return true;
		}
		return switch (configuration.docketProcedure()) {
			case FAST_SHADOW_DOCKET -> false;
			case REASONED_EMERGENCY_PANEL -> caseFile.constitutionalSalience() > 0.60;
			case FULL_COURT_EMERGENCY, MERITS_FOLLOW_UP -> true;
		};
	}
	
	boolean reliefGranted(CaseFile caseFile, boolean emergency, VoteResult vote, Random random) {
		if (!emergency) {
			return false;
		}
		double threshold = switch (configuration.docketProcedure()) {
			case FAST_SHADOW_DOCKET -> 0.44;
			case REASONED_EMERGENCY_PANEL -> 0.50;
			case FULL_COURT_EMERGENCY -> 0.54;
			case MERITS_FOLLOW_UP -> 0.55;
		} + configuration.sourceEmergencyReliefThresholdAdjustment();
		double reliefScore = vote.strikeVoteShare()
				+ caseFile.urgency() * 0.14
				+ caseFile.rightsThreat() * 0.08
				+ caseFile.executivePressure() * 0.05
				- configuration.emergencyReasonGiving() * 0.04
				+ random.nextGaussian() * 0.035;
		return reliefScore >= threshold;
	}
	
	double reasonsProbability(CaseFile caseFile, boolean emergencyReliefGranted, boolean meritsReview) {
		double probability = Values.clamp01(
				configuration.emergencyReasonGiving() * 0.62
						+ configuration.transparency() * 0.18
						+ (meritsReview ? 0.12 : 0.0)
						+ (emergencyReliefGranted ? caseFile.constitutionalSalience() * 0.08 : 0.03)
						- (configuration.docketProcedure() == DocketProcedure.FAST_SHADOW_DOCKET ? 0.18 : 0.0)
		);
		return Math.max(configuration.sourceEmergencyReasonFloor(), probability);
	}
	
	double voteDisclosureProbability(CaseFile caseFile, boolean emergencyReliefGranted, boolean reasonsGiven) {
		return Values.clamp01(
				configuration.transparency() * 0.52
						+ configuration.coalitionNorm() * 0.14
						+ (reasonsGiven ? 0.14 : 0.0)
						+ (emergencyReliefGranted ? 0.08 : 0.0)
						+ caseFile.constitutionalSalience() * 0.08
		);
	}
	
	double publicDisagreementProbability(
			CaseFile caseFile,
			double dissentIntensity,
			double shadowAbuse,
			boolean reasonsGiven
	) {
		return Values.clamp01(
				shadowAbuse * 0.42
						+ dissentIntensity * 0.32
						+ caseFile.constitutionalSalience() * 0.18
						+ caseFile.executivePressure() * 0.08
						- (reasonsGiven ? 0.12 : 0.0)
						+ configuration.sourceEmergencyPublicDisagreementAdjustment()
		);
	}
	
	double shadowDocketAbuse(
			CaseFile caseFile,
			boolean emergency,
			boolean meritsReview,
			boolean emergencyReliefGranted,
			boolean meritsInvalidated
	) {
		if (!emergency) {
			return 0.0;
		}
		double procedureRisk = switch (configuration.docketProcedure()) {
			case FAST_SHADOW_DOCKET -> 0.72;
			case REASONED_EMERGENCY_PANEL -> 0.34;
			case FULL_COURT_EMERGENCY -> 0.20;
			case MERITS_FOLLOW_UP -> 0.16;
		};
		double meritsPenalty = meritsReview ? 0.0 : 0.26;
		double reliefPenalty = emergencyReliefGranted && !meritsReview ? 0.18 : 0.0;
		double impact = meritsInvalidated || emergencyReliefGranted
				? caseFile.constitutionalSalience() * 0.22
				: caseFile.rightsThreat() * 0.12;
		return Values.clamp01(
				procedureRisk * caseFile.urgency()
						+ meritsPenalty
						+ reliefPenalty
						+ impact
						+ caseFile.executivePressure() * 0.12
						- configuration.emergencyReasonGiving() * 0.22
		);
	}
}
