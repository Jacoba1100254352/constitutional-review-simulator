package courtsim.institution;


import courtsim.model.*;
import courtsim.simulation.WorldSpec;


public final class InstitutionModelTests
{
	private InstitutionModelTests() {
	}
	
	public static void runAll() {
		intakeEstimateStaysBoundedAndRespondsToAccessMechanisms();
		emergencyProceduresLowerAbuseWhenMeritsFollowUpIsRequired();
		legislativeResponseCredibilityTracksDialogueMechanisms();
		complianceFallsUnderConflictAndLowImplementationCapacity();
	}
	
	private static void intakeEstimateStaysBoundedAndRespondsToAccessMechanisms() {
		CaseFile caseFile = rightsCase();
		WorldSpec world = WorldSpec.baseline(20).withCivilSocietyCapacity(0.80);
		IntakeModel ordinary = new IntakeModel(configuration(ReviewMechanism.STRONG_FORM_COURT, DocketProcedure.FAST_SHADOW_DOCKET), world);
		IntakeModel defender = new IntakeModel(configuration(ReviewMechanism.CONSTITUTIONAL_PUBLIC_DEFENDER, DocketProcedure.FAST_SHADOW_DOCKET), world);
		
		IntakeEstimate ordinaryEstimate = ordinary.estimate(caseFile, false, true, false, false, false);
		IntakeEstimate defenderEstimate = defender.estimate(caseFile, false, true, false, true, false);
		
		assertBetween(ordinaryEstimate.acceptanceRate(), "ordinary intake acceptance");
		assertBetween(defenderEstimate.acceptanceRate(), "defender intake acceptance");
		assertTrue(defender.caseSelectionAccess(caseFile, defenderEstimate) > ordinary.caseSelectionAccess(caseFile, ordinaryEstimate),
		           "public-defender participation should improve case-selection access");
		assertTrue(defenderEstimate.intakeFilings() >= defenderEstimate.screenedFilings(), "screened filings cannot exceed intake filings");
	}
	
	private static void emergencyProceduresLowerAbuseWhenMeritsFollowUpIsRequired() {
		CaseFile caseFile = emergencyCase();
		VoteResult grantedRelief = new VoteResult(0.64, true);
		EmergencyDocketModel fast = new EmergencyDocketModel(configuration(ReviewMechanism.STRONG_FORM_COURT, DocketProcedure.FAST_SHADOW_DOCKET));
		EmergencyDocketModel followUp = new EmergencyDocketModel(configuration(ReviewMechanism.STRONG_FORM_COURT, DocketProcedure.MERITS_FOLLOW_UP));
		
		double fastAbuse = fast.shadowDocketAbuse(caseFile, true, false, true, false);
		double followUpAbuse = followUp.shadowDocketAbuse(caseFile, true, true, true, true);
		
		assertBetween(fastAbuse, "fast shadow-docket abuse");
		assertBetween(followUpAbuse, "merits follow-up shadow-docket abuse");
		assertTrue(followUpAbuse < fastAbuse, "merits follow-up should reduce modeled emergency abuse risk");
		assertTrue(followUp.reliefGranted(caseFile, true, grantedRelief, new java.util.Random(7L)), "high-vote emergency relief should remain possible");
	}
	
	private static void legislativeResponseCredibilityTracksDialogueMechanisms() {
		CaseFile caseFile = rightsCase();
		PostDecisionResponseModel strong = new PostDecisionResponseModel(
				configuration(ReviewMechanism.STRONG_FORM_COURT, DocketProcedure.FAST_SHADOW_DOCKET),
				WorldSpec.baseline(20)
		);
		PostDecisionResponseModel mandatory = new PostDecisionResponseModel(
				configuration(ReviewMechanism.MANDATORY_LEGISLATIVE_RESPONSE, DocketProcedure.REASONED_EMERGENCY_PANEL),
				WorldSpec.baseline(20).withLegislativeConflict(0.35)
		);
		
		double strongCredibility = strong.legislativeResponseCredibility(caseFile, false, false, true, false);
		double mandatoryCredibility = mandatory.legislativeResponseCredibility(caseFile, true, false, true, false);
		
		assertBetween(strongCredibility, "strong-form response credibility");
		assertBetween(mandatoryCredibility, "mandatory-response credibility");
		assertTrue(mandatoryCredibility > strongCredibility, "mandatory dialogue mechanisms should increase response credibility");
	}
	
	private static void complianceFallsUnderConflictAndLowImplementationCapacity() {
		CaseFile caseFile = emergencyCase();
		DesignConfiguration configuration = configuration(ReviewMechanism.STRONG_FORM_COURT, DocketProcedure.FAST_SHADOW_DOCKET);
		WorldSpec stableWorld = WorldSpec.baseline(20).withImplementationCapacity(0.85).withLegislativeConflict(0.20).withPublicTrust(0.65);
		WorldSpec conflictedWorld = WorldSpec.baseline(20).withImplementationCapacity(0.20).withLegislativeConflict(0.85).withPublicTrust(0.32);
		ComplianceModel stable = new ComplianceModel(configuration, stableWorld);
		ComplianceModel conflicted = new ComplianceModel(configuration, conflictedWorld);
		ReactionState stableReaction = ReactionState.from(stableWorld);
		ReactionState conflictedReaction = ReactionState.from(conflictedWorld);
		
		double stableCompliance = stable.complianceRate(caseFile, 0.70, 0.20, true, false, false, stableReaction);
		double conflictedCompliance = conflicted.complianceRate(caseFile, 0.35, 0.78, true, true, false, conflictedReaction);
		
		assertBetween(stableCompliance, "stable compliance");
		assertBetween(conflictedCompliance, "conflicted compliance");
		assertTrue(stableCompliance > conflictedCompliance, "conflict and weak implementation capacity should reduce compliance");
		assertTrue(conflicted.defianceRisk(caseFile, 0.78, conflictedReaction) > stable.defianceRisk(caseFile, 0.20, stableReaction),
		           "conflict should raise defiance risk");
	}
	
	private static DesignConfiguration configuration(ReviewMechanism mechanism, DocketProcedure docketProcedure) {
		return new DesignConfiguration(
				"test",
				AppointmentMethod.PRESIDENTIAL_SENATE,
				9,
				TermLimit.LIFE_TENURE,
				RemovalStandard.IMPEACHMENT_ONLY,
				RecusalRule.MANDATORY_CONFLICT,
				docketProcedure,
				VotingThreshold.SIMPLE_MAJORITY,
				ReviewStructure.FULL_COURT,
				LegislativeOverrideRule.NONE,
				ReviewArchetype.DISCRETIONARY_APPELLATE_LEAVE,
				ReviewTiming.POST_ENACTMENT,
				DocketControl.DISCRETIONARY_CERTIORARI,
				CostProfileKey.STYLIZED_INTERNAL,
				mechanism == ReviewMechanism.STRONG_FORM_COURT ? ScenarioKind.COURT_VARIANT : ScenarioKind.SYNTHETIC_MECHANISM,
				mechanism,
				0.68,
				0.64,
				0.0,
				0.72,
				0.34,
				0.62,
				0.64,
				0.62,
				0.58
		);
	}
	
	private static CaseFile rightsCase() {
		return new CaseFile(
				"rights",
				CaseType.RIGHTS_CLAIM,
				DoctrineArea.EQUALITY,
				PolicyDomain.CIVIL_RIGHTS,
				Jurisdiction.FEDERAL,
				LowerCourtPath.CIRCUIT_PANEL,
				0,
				-0.35,
				0.78,
				0.48,
				0.44,
				0.34,
				0.42,
				0.74,
				0.38,
				-0.12,
				0.18,
				0.22,
				0.66,
				0.40,
				false,
				0.28,
				0.18,
				0.56,
				0.72,
				0.76,
				0.30,
				"test"
		);
	}
	
	private static CaseFile emergencyCase() {
		return new CaseFile(
				"emergency",
				CaseType.EMERGENCY,
				DoctrineArea.EMERGENCY_POWERS,
				PolicyDomain.EMERGENCY_SECURITY,
				Jurisdiction.MIXED_STATE_FEDERAL,
				LowerCourtPath.STATE_FEDERAL_SPLIT,
				0,
				-0.62,
				0.70,
				0.36,
				0.62,
				0.92,
				0.50,
				0.84,
				0.78,
				0.22,
				0.58,
				0.50,
				0.82,
				0.24,
				true,
				0.86,
				0.36,
				0.42,
				0.58,
				0.64,
				0.74,
				"test"
		);
	}
	
	private static void assertBetween(double value, String label) {
		assertTrue(value >= 0.0 && value <= 1.0, label + " out of range: " + value);
	}
	
	private static void assertTrue(boolean condition, String message) {
		if (!condition) {
			throw new AssertionError(message);
		}
	}
}
