package courtsim.model;

import java.util.HashSet;
import java.util.List;


public record CaseFile(
		String id,
		CaseType type,
		DoctrineArea doctrineArea,
		PolicyDomain policyDomain,
		Jurisdiction jurisdiction,
		LowerCourtPath lowerCourtPath,
		int reviewPeriod,
		double policyPosition,
		double rightsThreat,
		double publicSupport,
		double legislativeMandate,
		double urgency,
		double legalAmbiguity,
		double constitutionalSalience,
		double lowerCourtConflict,
		double lowerCourtPanelSkew,
		double stateFederalTension,
		double intercourtConflict,
		double certiorariPressure,
		double timeToReview,
		boolean lowerCourtGovernmentWin,
		double executivePressure,
		double conflictOfInterestRisk,
		double publicTrust,
		double litigantCapacity,
		double publicInterestSupport,
		double governmentRepeatPlayerAdvantage,
		String source,
		List<ChallengeObject> challengeObjects
)
{
	public CaseFile {
		challengeObjects = List.copyOf(challengeObjects);
		if (challengeObjects.isEmpty()) throw new IllegalArgumentException("a case needs challenge objects");
		var ids = new HashSet<String>();
		for (ChallengeObject object : challengeObjects) {
			if (!ids.add(object.id())) throw new IllegalArgumentException("duplicate challenge object id: " + object.id());
		}
	}
}
