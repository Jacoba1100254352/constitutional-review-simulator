package courtsim.experiment;

import courtsim.institution.*;
import courtsim.model.*;
import courtsim.simulation.*;

import java.io.*;
import java.lang.reflect.RecordComponent;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.zip.GZIPOutputStream;

/** Opt-in, run-streamed paired experiment. Does not change the legacy campaign path. */
public final class HistoricalStudyRunner {
    public static final String PREFIX = "constitutional-review-historical-robustness-v1";
    public static final List<String> BASE_KEYS = List.of("current-federal-court", "reasoned-emergency-review",
            "constitutional-council", "weak-form-review");
    public static final List<String> ABLATION_KEYS = List.of("reasoned-with-fast-procedure",
            "council-with-full-court-structure", "weak-form-half-response", "weak-form-no-response");

    public record Context(String key, String field, double value, WorldSpec spec) {}
    public record Design(String key, String parent, DesignConfiguration configuration, double responseFactor) {}
    public record Counts(long runs, long cases, long objects, long sharedCases, long sharedObjects) {}

    private HistoricalStudyRunner() {}

    /** Same stable arithmetic as the existing Simulator, with explicit stream identities exported. */
    public static long seed(long seed, int run, int stream) {
        long value = seed;
        value ^= 0x9E3779B97F4A7C15L + ((long) run << 6) + ((long) run >> 2);
        value ^= 0xBF58476D1CE4E5B9L * (stream + 31L);
        return value;
    }

    public static long votingSeed(long seed, int run, int scenarioIndex, int period) {
        return seed(seed, run, scenarioIndex + 101 + period * 503);
    }

    public static long responseSeed(long seed, int run, int period) {
        // Separate domain and stream; shared across the three response factors for matched gates.
        return seed(seed ^ 0x524553504F4E5345L, run, 10001 + period * 503);
    }

    public static List<Design> designs() {
        var result = new ArrayList<Design>();
        for (String key : BASE_KEYS) result.add(new Design(key, key, ScenarioCatalog.configurationForKey(key), 1));
        DesignConfiguration reasoned = result.get(1).configuration();
        DesignConfiguration council = result.get(2).configuration();
        DesignConfiguration weak = result.get(3).configuration();
        result.add(new Design(ABLATION_KEYS.get(0), BASE_KEYS.get(1),
                changeProcedureOrStructure(reasoned, DocketProcedure.FAST_SHADOW_DOCKET, reasoned.reviewStructure()), 1));
        result.add(new Design(ABLATION_KEYS.get(1), BASE_KEYS.get(2),
                changeProcedureOrStructure(council, council.docketProcedure(), ReviewStructure.FULL_COURT), 1));
        result.add(new Design(ABLATION_KEYS.get(2), BASE_KEYS.get(3), weak, 0.5));
        result.add(new Design(ABLATION_KEYS.get(3), BASE_KEYS.get(3), weak, 0));
        return List.copyOf(result);
    }

    private static DesignConfiguration changeProcedureOrStructure(DesignConfiguration c,
            DocketProcedure procedure, ReviewStructure structure) {
        return new DesignConfiguration(c.label(), c.appointmentMethod(), c.courtSize(), c.termLimit(),
                c.removalStandard(), c.recusalRule(), procedure, c.votingThreshold(), structure,
                c.overrideRule(), c.reviewArchetype(), c.reviewTiming(), c.docketControl(), c.costProfileKey(),
                c.scenarioKind(), c.reviewMechanism(), c.legalTransplantFeasibility(), c.politicalCultureFit(),
                c.appointmentSkew(), c.independence(), c.accountability(), c.transparency(), c.coalitionNorm(),
                c.rightsPriority(), c.stabilityPreference());
    }

    public static WorldSpec contextSpec(WorldSpec baseline, String field, double value) {
        if (!Double.isFinite(value) || value < 0 || value > 1) throw new IllegalArgumentException("invalid context value");
        return switch (field) {
            case "baseline" -> {
                if (value != 0) throw new IllegalArgumentException("baseline context requires zero sentinel");
                yield baseline;
            }
            case "emergencyPressure" -> baseline.withEmergencyPressure(value);
            case "rightsThreatRate" -> baseline.withRightsThreatRate(value);
            case "appointmentPolarization" -> baseline.withAppointmentPolarization(value);
            case "legislativeConflict" -> baseline.withLegislativeConflict(value);
            case "implementationCapacity" -> baseline.withImplementationCapacity(value);
            case "partyFragmentation" -> baseline.withPartyFragmentation(value);
            default -> throw new IllegalArgumentException("unregistered context field: " + field);
        };
    }

    public static List<Context> readContexts(Path path, int cases, int periods) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        if (lines.isEmpty() || !lines.get(0).equals("context,field,value")) throw new IllegalArgumentException("invalid context header");
        Set<String> keys = new HashSet<>();
        Set<WorldSpec> specs = new HashSet<>();
        var result = new ArrayList<Context>();
        var baseline = WorldSpec.baseline(cases).withReviewPeriods(periods);
        for (String line : lines.subList(1, lines.size())) {
            String[] values = line.split(",", -1);
            if (values.length != 3 || !values[0].matches("[a-zA-Z][a-zA-Z0-9.-]*") || !keys.add(values[0]))
                throw new IllegalArgumentException("invalid or duplicate context row");
            double value = Double.parseDouble(values[2]);
            WorldSpec spec = contextSpec(baseline, values[1], value);
            if (!specs.add(spec)) throw new IllegalArgumentException("duplicate context world");
            result.add(new Context(values[0], values[1], value, spec));
        }
        if (result.isEmpty()) throw new IllegalArgumentException("empty context grid");
        return List.copyOf(result);
    }

    /** One immutable world is used for every design; returned outcomes must retain its entire docket. */
    public static ScenarioRunResult simulate(Design design, CourtWorld world, long experimentSeed,
            int run, int scenarioIndex) {
        var accumulator = new MetricsAccumulator();
        var outcomes = new ArrayList<CaseOutcome>();
        int currentPeriod = -1;
        ConstitutionalReviewProcess process = null;
        ReviewContext reviewContext = null;
        ReactionState reactions = ReactionState.from(world.spec());
        for (CaseFile caseFile : world.docket()) {
            if (caseFile.reviewPeriod() != currentPeriod) {
                currentPeriod = caseFile.reviewPeriod();
                Random random = new Random(votingSeed(experimentSeed, run, scenarioIndex, currentPeriod));
                DesignConfiguration config = design.configuration();
                process = new ConstitutionalReviewProcess(config, world.spec(),
                        CourtFactory.create(config, world.spec(), random, currentPeriod), config.periodTurnoverRate(),
                        new ResponseIntervention(design.responseFactor(), responseSeed(experimentSeed, run, currentPeriod)));
                reviewContext = new ReviewContext(random, reactions);
                accumulator.addComposition(process.compositionSnapshot(currentPeriod));
            }
            CaseOutcome outcome = process.review(caseFile, reviewContext);
            if (!outcome.caseFile().equals(caseFile)) throw new IllegalStateException("paired docket changed during review");
            accumulator.add(outcome);
            outcomes.add(outcome);
        }
        var config = design.configuration();
        var report = accumulator.toReport(design.key(), config.label(), config.scenarioKind().name().toLowerCase(Locale.ROOT),
                config.reviewMechanism().name().toLowerCase(Locale.ROOT));
        return new ScenarioRunResult(design.key(), config.label(), List.copyOf(outcomes), report);
    }

    public static Counts run(List<DoctrineDistribution> profiles, List<Context> contexts, int runs,
            long experimentSeed, Path output) throws Exception {
        if (runs < 1 || profiles.isEmpty() || contexts.isEmpty()) throw new IllegalArgumentException("empty experiment");
        if (profiles.stream().map(DoctrineDistribution::key).distinct().count() != profiles.size()
                || contexts.stream().map(Context::key).distinct().count() != contexts.size())
            throw new IllegalArgumentException("duplicate experiment cell");
        Files.createDirectories(output);
        List<Design> designs = designs();
        ScalarSchema reportSchema = new ScalarSchema(ScenarioReport.class);
        ScalarSchema caseSchema = new ScalarSchema(CaseFile.class);
        ScalarSchema outcomeSchema = new ScalarSchema(CaseOutcome.class);
        ScalarSchema objectSchema = new ScalarSchema(ChallengeObject.class);
        ScalarSchema dispositionSchema = new ScalarSchema(ObjectDisposition.class);
        ScalarSchema segmentSchema = new ScalarSchema(SegmentReport.class);
        ScalarSchema compositionSchema = new ScalarSchema(CompositionReport.class);
        long runRows = 0, caseRows = 0, objectRows = 0, sharedCases = 0, sharedObjects = 0;
        try (Csv metrics = new Csv(output, "-runs.csv.gz");
             Csv cases = new Csv(output, "-cases.csv.gz");
             Csv objects = new Csv(output, "-objects.csv.gz");
             Csv dockets = new Csv(output, "-dockets.csv.gz");
             Csv segments = new Csv(output, "-segments.csv.gz");
             Csv compositions = new Csv(output, "-compositions.csv.gz");
             Csv streams = new Csv(output, "-streams.csv.gz")) {
            metrics.row(join(List.of("profile", "context", "run", "scenarioIndex", "responseFactor", "worldSeed",
                    "docketSha256", "objectsSha256"), reportSchema.names()));
            cases.row(join(List.of("profile", "context", "run", "scenario", "caseId"), outcomeSchema.names()));
            objects.row(join(List.of("profile", "context", "run", "scenario", "caseId"),
                    objectSchema.names(), dispositionSchema.names(), List.of("statuteDisposition", "statuteNullification")));
            dockets.row(join(List.of("profile", "context", "run"), caseSchema.names()));
            segments.row(join(List.of("profile", "context", "run", "scenario"), segmentSchema.names()));
            compositions.row(join(List.of("profile", "context", "run", "scenario"), compositionSchema.names()));
            streams.row(List.of("profile", "context", "run", "scenario", "period", "votingSeed", "responseSeed"));
            WorldGenerator generator = new WorldGenerator();
            for (DoctrineDistribution profile : profiles) {
                for (Context context : contexts) {
                    for (int run = 0; run < runs; run++) {
                        long worldSeed = seed(experimentSeed ^ context.spec().seedFingerprint(), run, 17);
                        CourtWorld world = generator.generate(context.spec(), worldSeed, List.of(), profile);
                        List<CaseFile> docket = world.docket();
                        String docketHash = digest(docket);
                        String objectHash = digest(docket.stream().map(CaseFile::challengeObjects).toList());
                        var shared = List.<Object>of(profile.key(), context.key(), run);
                        for (CaseFile caseFile : docket) {
                            dockets.row(join(shared, caseSchema.values(caseFile)));
                            sharedCases++;
                            sharedObjects += caseFile.challengeObjects().size();
                        }
                        for (int index = 0; index < designs.size(); index++) {
                            Design design = designs.get(index);
                            ScenarioRunResult result = simulate(design, world, experimentSeed, run, index);
                            if (!result.outcomes().stream().map(CaseOutcome::caseFile).toList().equals(docket))
                                throw new IllegalStateException("unpaired case/object docket");
                            metrics.row(join(shared, List.of(index, design.responseFactor(), worldSeed, docketHash, objectHash),
                                    reportSchema.values(result.report())));
                            runRows++;
                            var scenario = join(shared, List.of(design.key()));
                            for (int period : docket.stream().map(CaseFile::reviewPeriod).distinct().toList()) {
                                streams.row(join(scenario, List.of(period, votingSeed(experimentSeed, run, index, period),
                                        responseSeed(experimentSeed, run, period))));
                            }
                            for (CaseOutcome outcome : result.outcomes()) {
                                var caseKey = join(scenario, List.of(outcome.caseFile().id()));
                                cases.row(join(caseKey, outcomeSchema.values(outcome)));
                                caseRows++;
                                for (ObjectDisposition disposition : outcome.objectDispositions()) {
                                    objects.row(join(caseKey, objectSchema.values(disposition.object()),
                                            dispositionSchema.values(disposition), List.of(disposition.statuteDisposition(), disposition.statuteNullification())));
                                    objectRows++;
                                }
                            }
                            for (var group : List.of(result.report().periodReports(), result.report().doctrineReports(),
                                    result.report().pipelineReports(), result.report().policyDomainReports())) {
                                for (SegmentReport segment : group) segments.row(join(scenario, segmentSchema.values(segment)));
                            }
                            for (CompositionReport composition : result.report().compositionReports())
                                compositions.row(join(scenario, compositionSchema.values(composition)));
                        }
                    }
                    System.out.println("Completed paired cell: " + profile.key() + " / " + context.key());
                }
            }
        }
        if (caseRows != sharedCases * designs.size() || objectRows != sharedObjects * designs.size())
            throw new IllegalStateException("experiment count reconciliation failed");
        writeSettings(output, contexts, designs);
        var counts = new Counts(runRows, caseRows, objectRows, sharedCases, sharedObjects);
        Files.writeString(output.resolve(PREFIX + "-counts.json"),
                "{\"runs\":" + runRows + ",\"cases\":" + caseRows + ",\"objects\":" + objectRows
                        + ",\"sharedCases\":" + sharedCases + ",\"sharedObjects\":" + sharedObjects + "}\n",
                StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
        return counts;
    }

    private static void writeSettings(Path output, List<Context> contexts, List<Design> designs) throws Exception {
        try (Csv config = new Csv(output, "-designs.csv"); Csv world = new Csv(output, "-contexts.csv")) {
            var configSchema = new ScalarSchema(DesignConfiguration.class);
            var worldSchema = new ScalarSchema(WorldSpec.class);
            config.row(join(List.of("scenario", "parent", "responseFactor"), configSchema.names()));
            world.row(join(List.of("context", "field", "value"), worldSchema.names()));
            for (Design design : designs) config.row(join(List.of(design.key(), design.parent(), design.responseFactor()),
                    configSchema.values(design.configuration())));
            for (Context context : contexts) world.row(join(List.of(context.key(), context.field(), context.value()),
                    worldSchema.values(context.spec())));
        }
    }

    /** Length-framed recursive record/list encoding, UTF-8 scalars, and exact hexadecimal doubles. */
    public static String digest(Object value) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        canonical(digest, value);
        return HexFormat.of().formatHex(digest.digest());
    }

    private static void canonical(MessageDigest digest, Object value) throws Exception {
        if (value instanceof List<?> list) {
            token(digest, "list:" + list.size());
            for (Object item : list) canonical(digest, item);
        } else if (value.getClass().isRecord()) {
            token(digest, value.getClass().getName());
            for (RecordComponent component : value.getClass().getRecordComponents()) {
                token(digest, component.getName());
                canonical(digest, component.getAccessor().invoke(value));
            }
        } else {
            token(digest, value instanceof Double d ? Double.toHexString(d) : value.toString());
        }
    }

    private static void token(MessageDigest digest, String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        digest.update(Integer.toString(bytes.length).getBytes(StandardCharsets.US_ASCII));
        digest.update((byte) ':');
        digest.update(bytes);
    }

    private static final class ScalarSchema {
        private final List<RecordComponent> components;
        ScalarSchema(Class<?> type) {
            components = Arrays.stream(type.getRecordComponents()).filter(c -> c.getType().isPrimitive()
                    || c.getType() == String.class || c.getType().isEnum()).toList();
        }
        List<String> names() { return components.stream().map(RecordComponent::getName).toList(); }
        List<Object> values(Object record) throws ReflectiveOperationException {
            var result = new ArrayList<Object>();
            for (RecordComponent component : components) result.add(component.getAccessor().invoke(record));
            return result;
        }
    }

    @SafeVarargs
    private static List<Object> join(List<?>... parts) {
        var result = new ArrayList<Object>();
        for (List<?> part : parts) result.addAll(part);
        return result;
    }

    private static final class Csv implements AutoCloseable {
        private final BufferedWriter writer;
        Csv(Path directory, String suffix) throws IOException {
            OutputStream stream = Files.newOutputStream(directory.resolve(PREFIX + suffix), StandardOpenOption.CREATE_NEW);
            if (suffix.endsWith(".gz")) stream = new GZIPOutputStream(stream, 65536);
            writer = new BufferedWriter(new OutputStreamWriter(stream, StandardCharsets.UTF_8), 65536);
        }
        void row(List<?> values) throws IOException {
            StringJoiner row = new StringJoiner(",");
            for (Object value : values) {
                if (value instanceof Double d && !Double.isFinite(d)) throw new IllegalArgumentException("nonfinite CSV metric");
                String text = value.toString();
                if (text.contains(",") || text.contains("\"") || text.contains("\n") || text.contains("\r"))
                    text = "\"" + text.replace("\"", "\"\"") + "\"";
                row.add(text);
            }
            writer.write(row.toString());
            writer.write('\n');
        }
        @Override public void close() throws IOException { writer.close(); }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) throw new IllegalArgumentException("usage: HistoricalStudyRunner INPUT_DIRECTORY OUTPUT_DIRECTORY");
        Path inputs = Path.of(args[0]);
        Properties options = new Properties();
        try (Reader reader = Files.newBufferedReader(inputs.resolve("study.properties"), StandardCharsets.UTF_8)) { options.load(reader); }
        int runs = Integer.parseInt(options.getProperty("runs"));
        int cases = Integer.parseInt(options.getProperty("cases"));
        int periods = Integer.parseInt(options.getProperty("periods"));
        long seed = Long.parseLong(options.getProperty("seed"));
        System.out.println(run(DoctrineDistribution.readCsv(inputs.resolve("study-profiles.csv")),
                readContexts(inputs.resolve("study-contexts.csv"), cases, periods), runs, seed, Path.of(args[1])));
    }
}
