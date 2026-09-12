package courtsim.simulation;

import courtsim.model.ChallengeObject;
import courtsim.model.Jurisdiction;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Explicit, unestimated docket assumptions; never inferred from a source outcome rate. */
public final class ChallengeObjectGenerator {
	public static final String MODEL = "stylized-objects-v1: count=1/2/3 at .75/.20/.05; kind=statute/regulation/conduct at .50/.15/.35; vulnerability=uniform";

	static List<ChallengeObject> generate(String caseId, Jurisdiction jurisdiction, Random random) {
		double countDraw = random.nextDouble();
		int count = countDraw < 0.75 ? 1 : countDraw < 0.95 ? 2 : 3;
		List<ChallengeObject> objects = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			double kindDraw = random.nextDouble();
			ChallengeObject.Kind kind = kindDraw < 0.50 ? ChallengeObject.Kind.STATUTE
					: kindDraw < 0.65 ? ChallengeObject.Kind.REGULATION : ChallengeObject.Kind.GOVERNMENT_CONDUCT;
			Jurisdiction level = jurisdiction == Jurisdiction.MIXED_STATE_FEDERAL
					? (random.nextBoolean() ? Jurisdiction.FEDERAL : Jurisdiction.STATE) : jurisdiction;
			objects.add(new ChallengeObject(caseId + "/object-" + (i + 1), kind, level, random.nextDouble()));
		}
		return List.copyOf(objects);
	}
}
