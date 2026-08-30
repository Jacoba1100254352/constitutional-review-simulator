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
		sourceCalibrationHooksApplyOnlyToRealWorldPresets();
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

		assertBetween(fastAbuse, "fast emergency-process irregularity");
		assertBetween(followUpAbuse, "merits follow-up emergency-process irregularity");
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

	private static void sourceCalibrationHooksApplyOnlyToRealWorldPresets() {
		DesignConfiguration generic = configuration(ReviewMechanism.STRONG_FORM_COURT, DocketProcedure.FAST_SHADOW_DOCKET);
		assertTrue(generic.sourceIntakeDenominatorMultiplier() == 1.0, "generic scenarios should not shift source denominators");
		assertTrue(generic.sourceEmergencyReliefThresholdAdjustment() == 0.0, "generic scenarios should not shift emergency thresholds");
		assertTrue(!generic.sourceDeferredEffectRemedyProfile(), "generic scenarios should not use source deferred-effect remedies");
		assertTrue(generic.sourceDialogueConcernFloor() == 0.35, "generic scenarios should keep the standard dialogue concern floor");

		DesignConfiguration canada = sourceConfiguration(
				CostProfileKey.CANADIAN_SUPREME_COURT,
				ReviewArchetype.DISCRETIONARY_APPELLATE_LEAVE,
				DocketControl.LEAVE_TO_APPEAL,
				ReviewMechanism.LEGISLATIVE_OVERRIDE_CLAUSE,
				DocketProcedure.REASONED_EMERGENCY_PANEL
		);
		DesignConfiguration echr = sourceConfiguration(
				CostProfileKey.ECHR,
				ReviewArchetype.SUPRANATIONAL_TREATY,
				DocketControl.COMPLAINT_ADMISSIBILITY,
				ReviewMechanism.SUPRANATIONAL_REVIEW,
				DocketProcedure.REASONED_EMERGENCY_PANEL
		);
		DesignConfiguration france = sourceConfiguration(
				CostProfileKey.FRENCH_CONSTITUTIONAL_COUNCIL,
				ReviewArchetype.PRE_ENACTMENT_COUNCIL,
				DocketControl.REFERRAL_GATED,
				ReviewMechanism.PRE_ENACTMENT_REVIEW,
				DocketProcedure.REASONED_EMERGENCY_PANEL
		);
		DesignConfiguration uk = sourceConfiguration(
				CostProfileKey.UK_SUPREME_COURT,
				ReviewArchetype.DECLARATION_ONLY_PARLIAMENTARY,
				DocketControl.LEAVE_TO_APPEAL,
				ReviewMechanism.WEAK_FORM_REVIEW,
				DocketProcedure.REASONED_EMERGENCY_PANEL
		);
		DesignConfiguration southAfrica = sourceConfiguration(
				CostProfileKey.SOUTH_AFRICAN_CONSTITUTIONAL_COURT,
				ReviewArchetype.MIXED_ABSTRACT_CONCRETE,
				DocketControl.LEAVE_TO_APPEAL,
				ReviewMechanism.ABSTRACT_REVIEW,
				DocketProcedure.MERITS_FOLLOW_UP
		);
		DesignConfiguration us = sourceConfiguration(
				CostProfileKey.US_SUPREME_COURT,
				ReviewArchetype.DISCRETIONARY_APPELLATE_LEAVE,
				DocketControl.DISCRETIONARY_CERTIORARI,
				ReviewMechanism.STRONG_FORM_COURT,
				DocketProcedure.FAST_SHADOW_DOCKET
		);

		assertTrue(canada.sourceIntakeDenominatorMultiplier() < 1.0, "Canada source denominator should lower leave acceptance");
		assertTrue(us.sourceIntakeDenominatorMultiplier() < 1.0, "US source denominator should lower certiorari acceptance");
		assertTrue(southAfrica.sourceIntakeDenominatorMultiplier() < 1.0, "South Africa source denominator should lower petition-throughput acceptance");
		assertTrue(uk.sourceIntakeDenominatorMultiplier() < 1.0, "UK source denominator should lower PTA acceptance");
		assertTrue(echr.sourceIntakeDenominatorMultiplier() > 1.0, "ECHR source denominator should use allocated-application filtering");
		assertTrue(uk.sourceCaseSelectionAccessUsesIntakeProxy(), "UK source profile should expose PTA access proxy");
		assertTrue(us.sourceEmergencyReliefThresholdAdjustment() > 0.0, "US source profile should tighten emergency relief");
		assertTrue(us.sourceEmergencyReasonFloor() > 0.0, "US source profile should expose emergency reason-giving floor");
		assertTrue(us.sourceEmergencyPublicDisagreementAdjustment() > 0.0, "US source profile should preserve public emergency disagreement");
		assertTrue(france.sourceDeferredEffectRemedyProfile(), "French council source profile should expose deferred-effect remedies");
		assertTrue(france.sourceInvalidationThresholdAdjustment() < 0.0, "French council source profile should adjust QPC merits threshold");
		assertTrue(uk.sourceLegislativeResponseCredibilityMultiplier() < 1.0, "UK source profile should distinguish strict cure credibility");
		assertTrue(uk.sourceLegislativeResponseScoreAdjustment() > 0.0, "UK source profile should preserve broader response counts");
		assertTrue(uk.sourceDialogueConcernThresholdAdjustment() < 0.0, "UK source profile should broaden declaration concern threshold");
		assertTrue(uk.sourceDialogueConcernFloor() < generic.sourceDialogueConcernFloor(), "UK source profile should lower the source-range declaration floor");
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

	private static DesignConfiguration sourceConfiguration(
			CostProfileKey costProfileKey,
			ReviewArchetype reviewArchetype,
			DocketControl docketControl,
			ReviewMechanism reviewMechanism,
			DocketProcedure docketProcedure
	) {
		return new DesignConfiguration(
				"source",
				AppointmentMethod.SUPERMAJORITY_COMMISSION,
				9,
				TermLimit.LIFE_TENURE,
				RemovalStandard.IMPEACHMENT_ONLY,
				RecusalRule.MANDATORY_CONFLICT,
				docketProcedure,
				VotingThreshold.SIMPLE_MAJORITY,
				ReviewStructure.FULL_COURT,
				LegislativeOverrideRule.NONE,
				reviewArchetype,
				ReviewTiming.POST_ENACTMENT,
				docketControl,
				costProfileKey,
				ScenarioKind.REAL_WORLD_PRESET,
				reviewMechanism,
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
