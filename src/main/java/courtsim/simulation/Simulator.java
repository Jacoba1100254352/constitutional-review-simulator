package courtsim.simulation;


import courtsim.institution.*;
import courtsim.model.CaseFile;
import courtsim.model.CourtWorld;
import courtsim.model.LegislativeSignal;

import java.util.*;


public final class Simulator
{
	private final WorldGenerator worldGenerator = new WorldGenerator();
	
	private static long mix(long seed, int run, int stream) {
		long value = seed;
		value ^= 0x9E3779B97F4A7C15L + ((long) run << 6) + ((long) run >> 2);
		value ^= 0xBF58476D1CE4E5B9L * (stream + 31L);
		return value;
	}
	
	public List<ScenarioReport> compare(
			List<Scenario> scenarios,
			WorldSpec worldSpec,
			int runs,
			long seed,
			List<LegislativeSignal> importedSignals
	) {
		return compareDetailed(scenarios, worldSpec, runs, seed, importedSignals)
				.stream()
				.map(ScenarioRunResult::report)
				.toList();
	}
	
	public List<ScenarioRunResult> compareDetailed(
			List<Scenario> scenarios,
			WorldSpec worldSpec,
			int runs,
			long seed,
			List<LegislativeSignal> importedSignals
	) {
		return compareDetailed(scenarios, worldSpec, runs, seed, importedSignals, Map.of());
	}
	
	public List<ScenarioRunResult> compareDetailed(
			List<Scenario> scenarios,
			WorldSpec worldSpec,
			int runs,
			long seed,
			List<LegislativeSignal> importedSignals,
			Map<String, WorldSpec> scenarioSpecs
	) {
		MetricsAccumulator[] accumulators = new MetricsAccumulator[scenarios.size()];
		List<List<CaseOutcome>> outcomes = new ArrayList<>();
		for (int i = 0; i < accumulators.length; i++) {
			accumulators[i] = new MetricsAccumulator();
			outcomes.add(new ArrayList<>());
		}
		
		for (int run = 0; run < runs; run++) {
			int runIndex = run;
			Map<WorldSpec, CourtWorld> worlds = new HashMap<>();
			for (int scenarioIndex = 0; scenarioIndex < scenarios.size(); scenarioIndex++) {
				Scenario scenario = scenarios.get(scenarioIndex);
				WorldSpec scenarioSpec = scenarioSpecs.getOrDefault(scenario.key(), worldSpec);
				CourtWorld world = worlds.computeIfAbsent(
						scenarioSpec,
						spec -> worldGenerator.generate(spec, mix(seed ^ spec.hashCode(), runIndex, 17), importedSignals)
				);
				int currentPeriod = -1;
				ReviewProcess process = null;
				ReviewContext context = null;
				ReactionState reactionState = ReactionState.from(scenarioSpec);
				for (CaseFile caseFile : world.docket()) {
					if (caseFile.reviewPeriod() != currentPeriod) {
						currentPeriod = caseFile.reviewPeriod();
						Random periodRandom = new Random(mix(seed, run, scenarioIndex + 101 + currentPeriod * 503));
						process = scenario.buildProcess(world, periodRandom, currentPeriod);
						context = new ReviewContext(periodRandom, reactionState);
						if (process instanceof ConstitutionalReviewProcess constitutionalReviewProcess) {
							accumulators[scenarioIndex].addComposition(
									constitutionalReviewProcess.compositionSnapshot(currentPeriod)
							);
						}
					}
					CaseOutcome outcome = process.review(caseFile, context);
					accumulators[scenarioIndex].add(outcome);
					outcomes.get(scenarioIndex).add(outcome);
				}
			}
		}
		
		List<ScenarioRunResult> reports = new ArrayList<>();
		for (int i = 0; i < scenarios.size(); i++) {
			Scenario scenario = scenarios.get(i);
			ScenarioReport report = accumulators[i].toReport(
					scenario.key(),
					scenario.name(),
					scenario.kind().name().toLowerCase(),
					scenario.mechanism().name().toLowerCase()
			);
			reports.add(new ScenarioRunResult(
					scenario.key(),
					scenario.name(),
					List.copyOf(outcomes.get(i)),
					report
			));
		}
		return reports;
	}
}
