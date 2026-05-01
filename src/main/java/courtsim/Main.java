package courtsim;

import courtsim.experiment.CampaignResult;
import courtsim.experiment.CampaignRunner;
import courtsim.importer.LegislativeOutputImporter;
import courtsim.model.LegislativeSignal;
import courtsim.simulation.MetricDefinition;
import courtsim.simulation.Scenario;
import courtsim.simulation.ScenarioCatalog;
import courtsim.simulation.ScenarioReport;
import courtsim.simulation.Simulator;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) throws Exception {
        Options options = Options.parse(args);
        if (options.help) {
            printHelp();
            return;
        }

        List<LegislativeSignal> importedSignals = options.legislativeInput == null
                ? List.of()
                : LegislativeOutputImporter.read(options.legislativeInput);
        WorldSpec worldSpec = new WorldSpec(
                options.caseCount,
                options.appointmentPolarization,
                options.rightsThreatRate,
                options.emergencyPressure,
                options.legislativeConflict,
                options.publicTrust,
                options.partisanPressure
        );

        if (options.campaign != null) {
            CampaignResult result = new CampaignRunner().run(
                    options.campaign,
                    worldSpec,
                    options.runs,
                    options.seed,
                    options.outputDir,
                    importedSignals
            );
            System.out.println("Wrote " + result.csvPath());
            System.out.println("Wrote " + result.markdownPath());
            System.out.println("Wrote " + result.manifestPath());
            return;
        }

        List<Scenario> scenarios = scenarios(options);
        List<ScenarioReport> reports = new Simulator().compare(
                scenarios,
                worldSpec,
                options.runs,
                options.seed,
                importedSignals
        );
        printReports(reports, options.format, options.charts, importedSignals);
    }

    private static List<Scenario> scenarios(Options options) {
        if (options.allScenarios) {
            return ScenarioCatalog.allScenarios();
        }
        if (!options.scenarioKeys.isEmpty()) {
            return ScenarioCatalog.scenariosForKeys(options.scenarioKeys);
        }
        return ScenarioCatalog.defaultScenarios();
    }

    private static void printReports(
            List<ScenarioReport> reports,
            String format,
            boolean charts,
            List<LegislativeSignal> importedSignals
    ) {
        if ("csv".equals(format)) {
            printCsv(reports);
        } else {
            printTable(reports, importedSignals);
            if (charts || "bars".equals(format)) {
                printBars(reports);
            }
        }
    }

    private static void printTable(List<ScenarioReport> reports, List<LegislativeSignal> importedSignals) {
        System.out.println("Input: " + LegislativeOutputImporter.describeImport(importedSignals));
        System.out.printf(
                Locale.ROOT,
                "%-38s %6s %6s %6s %6s %6s %6s %6s %6s %6s%n",
                "Scenario",
                "Score",
                "Stable",
                "Rights",
                "Part",
                "Shadow",
                "Legit",
                "Rev",
                "Conf",
                "Resp"
        );
        for (ScenarioReport report : reports) {
            System.out.printf(
                    Locale.ROOT,
                    "%-38s %6.3f %6.3f %6.3f %6.3f %6.3f %6.3f %6.3f %6.3f %6.3f%n",
                    truncate(report.scenarioKey(), 38),
                    report.directionalScore(),
                    report.legalStability(),
                    report.rightsProtection(),
                    report.partisanAlignment(),
                    report.shadowDocketAbuse(),
                    report.legitimacy(),
                    report.reversalRate(),
                    report.constitutionalConflict(),
                    report.democraticResponsiveness()
            );
        }
    }

    private static void printCsv(List<ScenarioReport> reports) {
        System.out.println("scenarioKey,scenario,totalCases,reviewedCases,invalidations,emergencyOrders,overrides,directionalScore,reviewRate,legalStability,rightsProtection,partisanAlignment,shadowDocketAbuse,legitimacy,reversalRate,constitutionalConflict,democraticResponsiveness,independenceAccountabilityBalance,concurrenceFragmentation,dissentIntensity,recusalRate,enBancRate,crossCheckRate,councilScreenRate,overrideRate,administrativeLoad");
        for (ScenarioReport report : reports) {
            System.out.printf(
                    Locale.ROOT,
                    "%s,%s,%d,%d,%d,%d,%d,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f,%.3f%n",
                    csv(report.scenarioKey()),
                    csv(report.scenarioName()),
                    report.totalCases(),
                    report.reviewedCases(),
                    report.invalidations(),
                    report.emergencyOrders(),
                    report.overrides(),
                    report.directionalScore(),
                    report.reviewRate(),
                    report.legalStability(),
                    report.rightsProtection(),
                    report.partisanAlignment(),
                    report.shadowDocketAbuse(),
                    report.legitimacy(),
                    report.reversalRate(),
                    report.constitutionalConflict(),
                    report.democraticResponsiveness(),
                    report.independenceAccountabilityBalance(),
                    report.concurrenceFragmentation(),
                    report.dissentIntensity(),
                    report.recusalRate(),
                    report.enBancRate(),
                    report.crossCheckRate(),
                    report.councilScreenRate(),
                    report.overrideRate(),
                    report.administrativeLoad()
            );
        }
    }

    private static void printBars(List<ScenarioReport> reports) {
        System.out.println();
        System.out.println("Directional score");
        for (ScenarioReport report : reports) {
            int count = (int) Math.round(report.directionalScore() * 32.0);
            System.out.printf(Locale.ROOT, "%-38s %s %.3f%n", truncate(report.scenarioKey(), 38), "#".repeat(count), report.directionalScore());
        }
    }

    private static void printHelp() {
        System.out.println("Constitutional Review Simulator");
        System.out.println();
        System.out.println("Usage: make run ARGS=\"[options]\"");
        System.out.println();
        System.out.println("Core options:");
        System.out.println("  --runs N                       randomized worlds per scenario (default 100)");
        System.out.println("  --cases N                      cases per run (default 80)");
        System.out.println("  --seed N                       random seed (default 20260501)");
        System.out.println("  --scenarios a,b,c              scenario keys to compare");
        System.out.println("  --all-scenarios                compare every scenario in the catalog");
        System.out.println("  --format table|csv|bars         output format (default table)");
        System.out.println("  --charts                       add ASCII bars after the table");
        System.out.println("  --legislative-input PATH        import legislative campaign CSV rows as docket signals");
        System.out.println("  --campaign v0                  write campaign CSV/Markdown/provenance artifacts");
        System.out.println("  --output-dir PATH               report output directory (default reports)");
        System.out.println();
        System.out.println("World controls:");
        System.out.println("  --appointment-polarization X    appointment ideology spread 0..1");
        System.out.println("  --rights-threat X               generated rights-risk pressure 0..1");
        System.out.println("  --emergency-pressure X          emergency docket pressure 0..1");
        System.out.println("  --legislative-conflict X        legislature-court conflict pressure 0..1");
        System.out.println("  --public-trust X                public trust 0..1");
        System.out.println("  --partisan-pressure X           partisan pressure 0..1");
        System.out.println();
        System.out.println("Scenario keys:");
        for (String key : ScenarioCatalog.scenarioKeys()) {
            System.out.println("  " + key);
        }
        System.out.println();
        System.out.println("Metrics:");
        for (MetricDefinition definition : MetricDefinition.definitions()) {
            String direction = switch (definition.direction()) {
                case HIGHER_IS_BETTER -> "up";
                case LOWER_IS_BETTER -> "down";
                case DIAGNOSTIC -> "diag";
            };
            System.out.println("  " + definition.key() + " (" + direction + "): " + definition.note());
        }
    }

    private static String truncate(String value, int width) {
        if (value.length() <= width) {
            return value;
        }
        return value.substring(0, Math.max(0, width - 1)) + "~";
    }

    private static String csv(String value) {
        if (value.indexOf(',') < 0 && value.indexOf('"') < 0 && value.indexOf('\n') < 0) {
            return value;
        }
        return '"' + value.replace("\"", "\"\"") + '"';
    }

    private static final class Options {
        private boolean help;
        private int runs = 100;
        private int caseCount = 80;
        private long seed = 20260501L;
        private String format = "table";
        private boolean charts;
        private boolean allScenarios;
        private final List<String> scenarioKeys = new ArrayList<>();
        private Path legislativeInput;
        private String campaign;
        private Path outputDir = Path.of("reports");
        private double appointmentPolarization = 0.62;
        private double rightsThreatRate = 0.36;
        private double emergencyPressure = 0.28;
        private double legislativeConflict = 0.42;
        private double publicTrust = 0.58;
        private double partisanPressure = 0.55;

        static Options parse(String[] args) {
            Options options = new Options();
            for (int i = 0; i < args.length; i++) {
                String arg = args[i];
                switch (arg) {
                    case "--help", "-h" -> options.help = true;
                    case "--runs" -> options.runs = integer(next(args, ++i, arg), arg);
                    case "--cases" -> options.caseCount = integer(next(args, ++i, arg), arg);
                    case "--seed" -> options.seed = Long.parseLong(next(args, ++i, arg));
                    case "--format" -> options.format = next(args, ++i, arg);
                    case "--charts" -> options.charts = true;
                    case "--all-scenarios" -> options.allScenarios = true;
                    case "--scenarios" -> {
                        String[] keys = next(args, ++i, arg).split(",");
                        for (String key : keys) {
                            if (!key.isBlank()) {
                                options.scenarioKeys.add(key.trim());
                            }
                        }
                    }
                    case "--legislative-input" -> options.legislativeInput = Path.of(next(args, ++i, arg));
                    case "--campaign" -> options.campaign = next(args, ++i, arg);
                    case "--output-dir" -> options.outputDir = Path.of(next(args, ++i, arg));
                    case "--appointment-polarization" -> options.appointmentPolarization = decimal(next(args, ++i, arg), arg);
                    case "--rights-threat" -> options.rightsThreatRate = decimal(next(args, ++i, arg), arg);
                    case "--emergency-pressure" -> options.emergencyPressure = decimal(next(args, ++i, arg), arg);
                    case "--legislative-conflict" -> options.legislativeConflict = decimal(next(args, ++i, arg), arg);
                    case "--public-trust" -> options.publicTrust = decimal(next(args, ++i, arg), arg);
                    case "--partisan-pressure" -> options.partisanPressure = decimal(next(args, ++i, arg), arg);
                    default -> throw new IllegalArgumentException("Unknown option: " + arg);
                }
            }
            if (!List.of("table", "csv", "bars").contains(options.format)) {
                throw new IllegalArgumentException("Unknown format: " + options.format);
            }
            return options;
        }

        private static String next(String[] args, int index, String option) {
            if (index >= args.length) {
                throw new IllegalArgumentException(option + " requires a value");
            }
            return args[index];
        }

        private static int integer(String value, String option) {
            int parsed = Integer.parseInt(value);
            if (parsed <= 0) {
                throw new IllegalArgumentException(option + " must be positive");
            }
            return parsed;
        }

        private static double decimal(String value, String option) {
            double parsed = Double.parseDouble(value);
            if (parsed < 0.0 || parsed > 1.0) {
                throw new IllegalArgumentException(option + " must be between 0 and 1");
            }
            return Values.clamp01(parsed);
        }
    }
}
