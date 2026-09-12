package courtsim.simulation;

import courtsim.institution.ObjectDisposition;
import courtsim.institution.ObjectDispositionModel;
import courtsim.model.ChallengeObject;
import courtsim.model.Jurisdiction;
import java.util.List;

public final class ObjectMeasurementTests {
	private ObjectMeasurementTests() {}

	public static void runAll() throws Exception {
		check(probe("0").equals(probe("10000")), "world draws must survive unrelated identity hashes in fresh JVMs");
		var first = new ChallengeObject("s1", ChallengeObject.Kind.STATUTE, Jurisdiction.FEDERAL, 0.9);
		var second = new ChallengeObject("s2", ChallengeObject.Kind.STATUTE, Jurisdiction.STATE, 0.2);
		var conduct = new ChallengeObject("c1", ChallengeObject.Kind.GOVERNMENT_CONDUCT, Jurisdiction.STATE, 0.8);
		var regulation = new ChallengeObject("r1", ChallengeObject.Kind.REGULATION, Jurisdiction.FEDERAL, 0.85);
		var objects = List.of(first, second, conduct, regulation);
		var result = ObjectDispositionModel.resolve(objects, true, true, false, true);
		check(result.stream().filter(ObjectDisposition::statuteDisposition).count() == 2, "one decision must yield two statute dispositions");
		check(result.stream().filter(ObjectDisposition::statuteNullification).count() == 1, "one statute nullified; conduct and regulation excluded");
		check(result.get(0).suspended(), "suspended statutory nullification still counts");
		check(result.get(1).result() == ObjectDisposition.Result.UPHELD, "mixed statutory disposition");
		check(result.get(2).result() == ObjectDisposition.Result.CONDUCT_REMEDY, "conduct relief has its own category");
		check(!result.get(2).suspended(), "conduct relief cannot inherit statute suspension");
		try {
			new ObjectDisposition(conduct, ObjectDisposition.Result.DECLARATION, true);
			throw new AssertionError("suspended conduct declaration accepted");
		} catch (IllegalArgumentException expected) { /* suspension is instrument-only */ }
		check(result.get(3).result() == ObjectDisposition.Result.NULLIFIED, "regulation can be nullified without being counted as a statute");
		var declaration = ObjectDispositionModel.resolve(objects, true, false, true, false);
		check(declaration.stream().noneMatch(ObjectDisposition::statuteNullification), "weak-form declarations are not nullifications");
		check(declaration.stream().filter(ObjectDisposition::statuteDisposition).count() == 2, "declarations stay in the statute denominator");
		var emergencyOnly = ObjectDispositionModel.resolve(objects, false, false, false, false);
		check(emergencyOnly.stream().noneMatch(ObjectDisposition::statuteDisposition), "emergency-only or declined cases have no merits dispositions");
		var noStatutes = new MetricsAccumulator().toReport("empty", "empty", "test", "test");
		check(Double.isNaN(noStatutes.statuteNullificationRate()), "no statute observations is missing, not zero success");
		try {
			ObjectDispositionModel.resolve(objects, false, true, false, false);
			throw new AssertionError("nullification without merits accepted");
		} catch (IllegalArgumentException expected) { /* malformed observation rejected */ }

		var results = new Simulator().compareDetailed(ScenarioCatalog.scenariosForKeys(List.of(
				"canadian-supreme-court", "weak-form-review", "reasoned-emergency-review")),
				WorldSpec.baseline(48), 3, 91421L, List.of());
		for (var scenario : results) {
			long denominator = 0, numerator = 0;
			for (var outcome : scenario.outcomes()) {
				check(outcome.objectDispositions().size() == outcome.caseFile().challengeObjects().size(), "object coverage");
				for (var disposition : outcome.objectDispositions()) {
					if (disposition.object().kind() != ChallengeObject.Kind.STATUTE || !outcome.meritsReview()) continue;
					denominator++;
					if (disposition.result() == ObjectDisposition.Result.NULLIFIED) numerator++;
				}
			}
			check(scenario.report().statuteDispositions() == denominator, "pooled statute denominator");
			check(scenario.report().statuteNullifications() == numerator, "pooled statute numerator");
			check(Math.abs(scenario.report().statuteNullificationRate() - (double) numerator / denominator) < 1e-12, "ratio of sums");
		}
	}

	private static void check(boolean condition, String message) {
		if (!condition) throw new AssertionError(message);
	}

	private static String probe(String noise) throws Exception {
		String javaExecutable = java.nio.file.Path.of(System.getProperty("java.home"), "bin", "java").toString();
		Process child = new ProcessBuilder(javaExecutable, "-cp", System.getProperty("java.class.path"),
				WorldSeedProbe.class.getName(), noise).redirectErrorStream(true).start();
		String output = new String(child.getInputStream().readAllBytes(), java.nio.charset.StandardCharsets.UTF_8);
		check(child.waitFor() == 0, "seed probe failed: " + output);
		return output;
	}
}
