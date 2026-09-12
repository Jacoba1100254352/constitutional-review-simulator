package courtsim.simulation;

import courtsim.experiment.HistoricalStudyRunner;
import courtsim.institution.*;
import courtsim.model.CaseFile;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.reflect.RecordComponent;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

public final class HistoricalStudyTests {
    private HistoricalStudyTests() {}

    public static void runAll() throws Exception {
        ablationsChangeOnlyRegisteredFields();
        streamedBaseRunsMatchLegacySimulator();
        streamSeedsAreIndependentAcrossRuns();
        allLockedSamplersMatchDeclaredLaws();
        streamedExportsAreCompleteAndDeterministic();
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    private static void ablationsChangeOnlyRegisteredFields() throws Exception {
        var designs = HistoricalStudyRunner.designs();
        var changes = Map.of(4, Set.of("docketProcedure"), 5, Set.of("reviewStructure"),
                6, Set.<String>of(), 7, Set.<String>of());
        for (int index = 4; index < designs.size(); index++) {
            var design = designs.get(index);
            var parent = designs.stream().filter(d -> d.key().equals(design.parent())).findFirst().orElseThrow();
            var changed = new HashSet<String>();
            for (RecordComponent field : DesignConfiguration.class.getRecordComponents()) {
                if (!field.getAccessor().invoke(design.configuration()).equals(field.getAccessor().invoke(parent.configuration())))
                    changed.add(field.getName());
            }
            require(changed.equals(changes.get(index)), "ablation changed an unregistered design parameter");
        }
        require(designs.get(6).responseFactor() == 0.5 && designs.get(7).responseFactor() == 0,
                "response interventions differ from registered factors");
    }

    private static void streamedBaseRunsMatchLegacySimulator() throws Exception {
        var spec = WorldSpec.baseline(80);
        var profile = DoctrineDistribution.readCsv(Path.of("config/historical-benchmark/study-profiles.csv")).get(0);
        long seed = 2026091201L;
        var legacy = new Simulator().compareDetailed(ScenarioCatalog.scenariosForKeys(HistoricalStudyRunner.BASE_KEYS),
                spec, 1, seed, List.of(), Map.of(), profile);
        var world = new WorldGenerator().generate(spec,
                HistoricalStudyRunner.seed(seed ^ spec.seedFingerprint(), 0, 17), List.of(), profile);
        for (int index = 0; index < 4; index++) {
            var streamed = HistoricalStudyRunner.simulate(HistoricalStudyRunner.designs().get(index), world, seed, 0, index);
            require(legacy.get(index).equals(streamed), "streamed base experiment changed legacy outcomes/aggregation");
        }
        var base = HistoricalStudyRunner.simulate(HistoricalStudyRunner.designs().get(3), world, seed, 0, 3);
        var off = HistoricalStudyRunner.simulate(HistoricalStudyRunner.designs().get(7), world, seed, 0, 3);
        require(base.outcomes().stream().map(CaseOutcome::caseFile).toList().equals(
                off.outcomes().stream().map(CaseOutcome::caseFile).toList()), "response ablation changed the docket");
        require(off.report().legislativeResponseRate() == 0 && off.report().legislativeResponseCredibility() == 0,
                "streamed no-response intervention did not propagate");
        require(base.report().rightsProtection() != off.report().rightsProtection(), "response intervention only relabeled an aggregate");
        require(base.report().averageTimeToReview() == off.report().averageTimeToReview(),
                "docket-defined average review time was silently redefined");
    }

    private static void streamSeedsAreIndependentAcrossRuns() {
        var voting = new HashSet<Long>();
        var response = new HashSet<Long>();
        for (int run = 0; run < 120; run++) {
            for (int period = 0; period < 4; period++) {
                long gate = HistoricalStudyRunner.responseSeed(2026091201L, run, period);
                require(response.add(gate), "response stream repeated across run/period");
                for (int scenario = 0; scenario < 8; scenario++)
                    require(voting.add(HistoricalStudyRunner.votingSeed(2026091201L, run, scenario, period)),
                            "voting stream repeated across scenario/run/period");
            }
        }
        require(Collections.disjoint(voting, response), "response thinning consumed a voting stream");
    }

    private static void allLockedSamplersMatchDeclaredLaws() throws Exception {
        var profiles = DoctrineDistribution.readCsv(Path.of("config/historical-benchmark/study-profiles.csv"));
        require(profiles.size() == 4, "registered historical profile missing");
        for (var profile : profiles) {
            int n = 300000;
            int[] counts = new int[8];
            var random = new Random(2026091201L);
            for (int i = 0; i < n; i++) counts[profile.sample(random).ordinal()]++;
            for (int i = 0; i < counts.length; i++) {
                double p = profile.weights().get(i);
                double bound = 6 * Math.sqrt(p * (1 - p) / n) + 1.0 / n;
                require(Math.abs((double) counts[i] / n - p) < bound, "historical profile sampler misses its law");
            }
        }
    }

    private static long rows(Path path) throws Exception {
        try (var reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(Files.newInputStream(path)), StandardCharsets.UTF_8))) {
            return reader.lines().count() - 1;
        }
    }

    private static void streamedExportsAreCompleteAndDeterministic() throws Exception {
        Path temporary = Files.createTempDirectory("historical-study-test-");
        try {
            var profiles = DoctrineDistribution.readCsv(Path.of("config/historical-benchmark/study-profiles.csv")).subList(0, 2);
            var baseline = WorldSpec.baseline(24);
            var contexts = List.of(new HistoricalStudyRunner.Context("baseline", "baseline", 0, baseline),
                    new HistoricalStudyRunner.Context("emergencyPressure-high", "emergencyPressure", 0.6, baseline.withEmergencyPressure(0.6)));
            var first = HistoricalStudyRunner.run(profiles, contexts, 3, 2026091201L, temporary.resolve("first"));
            var second = HistoricalStudyRunner.run(profiles, contexts, 3, 2026091201L, temporary.resolve("second"));
            require(first.equals(second), "streamed run counts are nondeterministic");
            require(first.runs() == 96 && first.cases() == 2304 && first.sharedCases() == 288,
                    "small-grid case/run counts do not reconcile");
            String prefix = HistoricalStudyRunner.PREFIX;
            for (String suffix : List.of("-cases.csv.gz", "-objects.csv.gz", "-runs.csv.gz", "-dockets.csv.gz",
                    "-segments.csv.gz", "-streams.csv.gz", "-compositions.csv.gz", "-designs.csv", "-contexts.csv", "-counts.json")) {
                Path left = temporary.resolve("first").resolve(prefix + suffix);
                Path right = temporary.resolve("second").resolve(prefix + suffix);
                require(Files.mismatch(left, right) == -1, "study export is not byte deterministic: " + suffix);
            }
            require(rows(temporary.resolve("first").resolve(prefix + "-cases.csv.gz")) == first.cases(), "missing raw cases");
            require(rows(temporary.resolve("first").resolve(prefix + "-objects.csv.gz")) == first.objects(), "missing raw objects");
            require(rows(temporary.resolve("first").resolve(prefix + "-dockets.csv.gz")) == first.sharedCases(), "missing raw docket inputs");
            var world = new WorldGenerator().generate(baseline, 31, List.of(), profiles.get(0));
            String original = HistoricalStudyRunner.digest(world.docket());
            var reversed = new ArrayList<CaseFile>(world.docket());
            Collections.reverse(reversed);
            require(!original.equals(HistoricalStudyRunner.digest(reversed)), "docket hash lost ordered case identity");
            require(original.equals(HistoricalStudyRunner.digest(world.docket())), "docket hash is nondeterministic");
        } finally {
            try (var paths = Files.walk(temporary)) {
                for (Path path : paths.sorted(Comparator.reverseOrder()).toList()) Files.delete(path);
            }
        }
    }
}
