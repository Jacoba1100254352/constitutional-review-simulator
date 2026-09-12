package courtsim.simulation;

import courtsim.institution.*;
import courtsim.model.CaseFile;
import courtsim.model.CourtWorld;
import courtsim.model.DoctrineArea;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class HistoricalMechanismTests
{
	private static final List<Double> FROZEN = List.of(0.0700, 0.1580, 0.2360, 0.0565, 0.0262, 0.0060, 0.2190, 0.2283);

	public static void runAll() throws Exception {
		distributionsAreValidatedAndImmutable();
		samplersMatchTheirDeclaredLawAndPreserveLegacyWorlds();
		optInComparisonsUseIdenticalDockets();
		responseInterventionsPreserveDefaultAndChangeRealOutcomes();
	}

	private static void require(boolean condition, String message) {
		if (!condition) throw new AssertionError(message);
	}

	private static void rejects(Runnable action) {
		try {
			action.run();
		} catch (IllegalArgumentException expected) {
			return;
		}
		throw new AssertionError("invalid historical experiment input was accepted");
	}

	private static void distributionsAreValidatedAndImmutable() throws Exception {
		var original = new ArrayList<>(FROZEN);
		var distribution = new DoctrineDistribution("frozen-generator", original);
		original.set(0, 0.99);
		require(distribution.weights().equals(FROZEN), "caller mutated distribution weights");
		rejects(() -> new DoctrineDistribution("invalid key", FROZEN));
		rejects(() -> new DoctrineDistribution("bad", List.of(1.0)));
		for (double bad : new double[]{-0.1, Double.NaN, Double.POSITIVE_INFINITY, 0.9}) {
			var values = new ArrayList<>(FROZEN);
			values.set(0, bad);
			rejects(() -> new DoctrineDistribution("bad", values));
		}
		var path = Files.createTempFile("historical-profile-contract-", ".csv");
		try {
			String header = "profile,SPEECH,EQUALITY,CRIMINAL_PROCEDURE,FEDERALISM,ELECTION_LAW,EMERGENCY_POWERS,ADMINISTRATIVE_STATE,OTHER\n";
			String row = "frozen-generator,0.07,0.158,0.236,0.0565,0.0262,0.006,0.219,0.2283\n";
			Files.writeString(path, header + row);
			require(DoctrineDistribution.readCsv(path).equals(List.of(distribution)), "profile CSV changed law/order");
			Files.writeString(path, header + row + row);
			try {
				DoctrineDistribution.readCsv(path);
				throw new AssertionError("duplicate historical profile accepted");
			} catch (IllegalArgumentException expected) {
				// Expected, rather than silently selecting one duplicate.
			}
		} finally {
			Files.delete(path);
		}
	}

	private static void samplersMatchTheirDeclaredLawAndPreserveLegacyWorlds() {
		var distribution = new DoctrineDistribution("frozen-generator", FROZEN);
		int n = 300000;
		int[] counts = new int[8];
		Random random = new Random(20260912L);
		for (int i = 0; i < n; i++) counts[distribution.sample(random).ordinal()]++;
		for (int i = 0; i < counts.length; i++) {
			double p = FROZEN.get(i);
			double bound = 6 * Math.sqrt(p * (1 - p) / n) + 1.0 / n;
			require(Math.abs((double) counts[i] / n - p) < bound, "sampler misses declared doctrine law");
		}
		var generator = new WorldGenerator();
		var spec = WorldSpec.baseline(160).withDoctrineDocketProfile(DoctrineDocketProfile.SCDB_MERITS);
		for (int seed = 0; seed < 10; seed++) {
			CourtWorld legacy = generator.generate(spec, seed, List.of());
			require(legacy.equals(generator.generate(spec, seed, List.of(), null)), "null extension changed old world");
			require(legacy.equals(generator.generate(spec, seed, List.of(), distribution)), "frozen categorical sampler changed old SCDB draws");
		}
		var onlySpeech = new DoctrineDistribution("speech-only", List.of(1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
		require(generator.generate(spec, 11, List.of(), onlySpeech).docket().stream()
				.allMatch(c -> c.doctrineArea() == DoctrineArea.SPEECH), "opt-in law not applied to generated case features");
	}

	private static void optInComparisonsUseIdenticalDockets() {
		var scenarios = ScenarioCatalog.scenariosForKeys(List.of("current-federal-court", "reasoned-emergency-review", "weak-form-review"));
		var simulator = new Simulator();
		var spec = WorldSpec.baseline(80);
		var distribution = new DoctrineDistribution("frozen-generator", FROZEN);
		var results = simulator.compareDetailed(scenarios, spec, 4, 2026091201L, List.of(), Map.of(), distribution);
		var docket = results.get(0).outcomes().stream().map(CaseOutcome::caseFile).toList();
		for (var result : results) {
			require(result.outcomes().stream().map(CaseOutcome::caseFile).toList().equals(docket), "scenarios did not receive identical case/object dockets");
		}
		require(results.equals(simulator.compareDetailed(scenarios, spec, 4, 2026091201L, List.of(), Map.of(), distribution)), "opt-in experiment is not deterministic");
		require(simulator.compareDetailed(scenarios, spec, 2, 31L, List.of()).equals(
				simulator.compareDetailed(scenarios, spec, 2, 31L, List.of(), Map.of(), null)), "default simulation path changed");
	}

	private static void responseInterventionsPreserveDefaultAndChangeRealOutcomes() {
		rejects(() -> new ResponseIntervention(-0.1, 1));
		rejects(() -> new ResponseIntervention(Double.NaN, 1));
		rejects(() -> new ResponseIntervention(1.1, 1));
		var half = new ResponseIntervention(0.5, 20260912L);
		int retained = 0;
		for (int i = 0; i < 20000; i++) if (half.retain("case-" + i)) retained++;
		require(retained > 9600 && retained < 10400, "case-keyed response thinning is badly biased");
		require(half.retain("repeat") == half.retain("repeat"), "response gate is not deterministic");
		var spec = WorldSpec.baseline(400).withRightsThreatRate(0.6);
		var configuration = ScenarioCatalog.configurationForKey("weak-form-review");
		var court = CourtFactory.create(configuration, spec, new Random(27), 0);
		var world = new WorldGenerator().generate(spec, 42, List.of());
		int responses = 0;
		int effectivenessChanges = 0;
		int rightsChanges = 0;
		for (CaseFile caseFile : world.docket()) {
			var legacy = new ConstitutionalReviewProcess(configuration, spec, court, configuration.periodTurnoverRate());
			var unchanged = new ConstitutionalReviewProcess(configuration, spec, court, configuration.periodTurnoverRate(), ResponseIntervention.NONE);
			var disabled = new ConstitutionalReviewProcess(configuration, spec, court, configuration.periodTurnoverRate(), new ResponseIntervention(0.0, 11L));
			long seed = 1234L + caseFile.id().hashCode();
			var original = legacy.review(caseFile, new ReviewContext(new Random(seed), ReactionState.from(spec)));
			var same = unchanged.review(caseFile, new ReviewContext(new Random(seed), ReactionState.from(spec)));
			var off = disabled.review(caseFile, new ReviewContext(new Random(seed), ReactionState.from(spec)));
			require(original.equals(same), "factor-one intervention changed existing case output or random draws");
			require(!off.legislativeResponse() && !off.timelyLegislativeResponse(), "response-off still produced a legislative reply");
			require(off.legislativeResponseCredibility() == 0, "response-off retained positive response credibility");
			if (original.legislativeResponse()) responses++;
			if (original.lawEffectiveAfterReview() != off.lawEffectiveAfterReview()) effectivenessChanges++;
			if (original.rightsProtection() != off.rightsProtection()) rightsChanges++;
		}
		require(responses > 0 && effectivenessChanges > 0 && rightsChanges > 0,
				"response ablation failed to propagate to actual law effectiveness and rights outcomes");
	}
}
