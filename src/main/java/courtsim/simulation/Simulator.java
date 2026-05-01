package courtsim.simulation;

import courtsim.institution.CaseOutcome;
import courtsim.institution.ReviewContext;
import courtsim.institution.ReviewProcess;
import courtsim.model.CaseFile;
import courtsim.model.CourtWorld;
import courtsim.model.LegislativeSignal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Simulator {
    private final WorldGenerator worldGenerator = new WorldGenerator();

    public List<ScenarioReport> compare(
            List<Scenario> scenarios,
            WorldSpec worldSpec,
            int runs,
            long seed,
            List<LegislativeSignal> importedSignals
    ) {
        MetricsAccumulator[] accumulators = new MetricsAccumulator[scenarios.size()];
        for (int i = 0; i < accumulators.length; i++) {
            accumulators[i] = new MetricsAccumulator();
        }

        for (int run = 0; run < runs; run++) {
            CourtWorld world = worldGenerator.generate(worldSpec, mix(seed, run, 17), importedSignals);
            for (int scenarioIndex = 0; scenarioIndex < scenarios.size(); scenarioIndex++) {
                Scenario scenario = scenarios.get(scenarioIndex);
                Random scenarioRandom = new Random(mix(seed, run, scenarioIndex + 101));
                ReviewProcess process = scenario.buildProcess(world, scenarioRandom);
                ReviewContext context = new ReviewContext(scenarioRandom);
                for (CaseFile caseFile : world.docket()) {
                    CaseOutcome outcome = process.review(caseFile, context);
                    accumulators[scenarioIndex].add(outcome);
                }
            }
        }

        List<ScenarioReport> reports = new ArrayList<>();
        for (int i = 0; i < scenarios.size(); i++) {
            Scenario scenario = scenarios.get(i);
            reports.add(accumulators[i].toReport(scenario.key(), scenario.name()));
        }
        return reports;
    }

    private static long mix(long seed, int run, int stream) {
        long value = seed;
        value ^= 0x9E3779B97F4A7C15L + ((long) run << 6) + ((long) run >> 2);
        value ^= 0xBF58476D1CE4E5B9L * (stream + 31L);
        return value;
    }
}

