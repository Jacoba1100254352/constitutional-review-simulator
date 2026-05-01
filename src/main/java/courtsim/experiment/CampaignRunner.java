package courtsim.experiment;

import courtsim.importer.LegislativeOutputImporter;
import courtsim.model.LegislativeSignal;
import courtsim.reporting.ReportProvenance;
import courtsim.simulation.Scenario;
import courtsim.simulation.ScenarioCatalog;
import courtsim.simulation.ScenarioReport;
import courtsim.simulation.Simulator;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public final class CampaignRunner {
    private static final List<String> CORE_SCENARIOS = List.of(
            "current-federal-court",
            "eighteen-year-terms",
            "fifteen-justice-commission",
            "supermajority-invalidation",
            "strict-recusal-court",
            "reasoned-emergency-review",
            "panel-en-banc-review",
            "dual-cross-checking-courts",
            "constitutional-council",
            "legislative-override-court",
            "accountability-retention-court",
            "independence-accountability-hybrid"
    );

    private final Simulator simulator = new Simulator();

    public CampaignResult run(
            String campaignKey,
            WorldSpec baseSpec,
            int runs,
            long seed,
            Path outputDir,
            List<LegislativeSignal> importedSignals
    ) throws IOException {
        if (!"v0".equals(campaignKey)) {
            throw new IllegalArgumentException("Unknown campaign: " + campaignKey);
        }
        Files.createDirectories(outputDir);
        List<Scenario> scenarios = ScenarioCatalog.scenariosForKeys(CORE_SCENARIOS);
        List<CampaignCase> cases = campaignCases(baseSpec, !importedSignals.isEmpty());
        List<CampaignRow> rows = new ArrayList<>();
        for (int caseIndex = 0; caseIndex < cases.size(); caseIndex++) {
            CampaignCase campaignCase = cases.get(caseIndex);
            List<LegislativeSignal> caseSignals = campaignCase.importedCase() ? importedSignals : List.of();
            List<ScenarioReport> reports = simulator.compare(
                    scenarios,
                    campaignCase.spec(),
                    runs,
                    seed + (caseIndex * 10_000L),
                    caseSignals
            );
            for (ScenarioReport report : reports) {
                rows.add(new CampaignRow(campaignCase.key(), campaignCase.name(), campaignCase.description(), report));
            }
        }

        String basename = "constitutional-review-campaign-v0";
        Path csvPath = outputDir.resolve(basename + ".csv");
        Path markdownPath = outputDir.resolve(basename + ".md");
        Path manifestPath = outputDir.resolve(basename + "-manifest.json");
        writeCsv(csvPath, rows);
        writeMarkdown(markdownPath, rows, runs, seed, importedSignals);
        ReportProvenance.write(
                manifestPath,
                "Constitutional Review Campaign v0",
                runs,
                baseSpec.caseCount(),
                seed,
                cases.size(),
                scenarios.size(),
                LegislativeOutputImporter.describeImport(importedSignals),
                List.of(csvPath, markdownPath)
        );
        return new CampaignResult("Constitutional Review Campaign v0", csvPath, markdownPath, manifestPath, List.copyOf(rows));
    }

    private List<CampaignCase> campaignCases(WorldSpec baseSpec, boolean includeImportedCase) {
        List<CampaignCase> cases = new ArrayList<>();
        cases.add(new CampaignCase(
                "baseline",
                "Baseline",
                "Moderately polarized appointment environment with ordinary constitutional-review pressure.",
                baseSpec,
                false
        ));
        cases.add(new CampaignCase(
                "polarized-appointments",
                "Polarized appointments",
                "High appointment polarization, higher partisan pressure, and lower public trust.",
                baseSpec.withAppointmentPolarization(0.86).withPartisanPressure(0.78).withPublicTrust(0.46),
                false
        ));
        cases.add(new CampaignCase(
                "rights-threat-surge",
                "Rights-threat surge",
                "Docket contains more laws or actions with high generated rights-risk signals.",
                baseSpec.withRightsThreatRate(0.68).withLegislativeConflict(0.56),
                false
        ));
        cases.add(new CampaignCase(
                "emergency-docket-stress",
                "Emergency docket stress",
                "Higher urgency and executive pressure, meant to stress shadow-docket procedures.",
                baseSpec.withEmergencyPressure(0.76).withPartisanPressure(0.68),
                false
        ));
        cases.add(new CampaignCase(
                "low-trust-conflict",
                "Low-trust conflict",
                "Lower public trust and higher legislature-court conflict.",
                baseSpec.withPublicTrust(0.36).withLegislativeConflict(0.78),
                false
        ));
        if (includeImportedCase) {
            cases.add(new CampaignCase(
                    "imported-legislative-output",
                    "Imported legislative output",
                    "Docket generated from legislative simulator campaign rows.",
                    baseSpec.withLegislativeConflict(0.58).withEmergencyPressure(0.42),
                    true
            ));
        }
        return List.copyOf(cases);
    }

    private void writeCsv(Path path, List<CampaignRow> rows) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,totalCases,reviewedCases,invalidations,emergencyOrders,overrides,directionalScore,reviewRate,legalStability,rightsProtection,partisanAlignment,shadowDocketAbuse,legitimacy,reversalRate,constitutionalConflict,democraticResponsiveness,independenceAccountabilityBalance,concurrenceFragmentation,dissentIntensity,recusalRate,enBancRate,crossCheckRate,councilScreenRate,overrideRate,administrativeLoad\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            builder.append(csv(row.caseKey())).append(',')
                    .append(csv(row.caseName())).append(',')
                    .append(csv(row.caseDescription())).append(',')
                    .append(csv(report.scenarioKey())).append(',')
                    .append(csv(report.scenarioName())).append(',')
                    .append(report.totalCases()).append(',')
                    .append(report.reviewedCases()).append(',')
                    .append(report.invalidations()).append(',')
                    .append(report.emergencyOrders()).append(',')
                    .append(report.overrides()).append(',')
                    .append(number(report.directionalScore())).append(',')
                    .append(number(report.reviewRate())).append(',')
                    .append(number(report.legalStability())).append(',')
                    .append(number(report.rightsProtection())).append(',')
                    .append(number(report.partisanAlignment())).append(',')
                    .append(number(report.shadowDocketAbuse())).append(',')
                    .append(number(report.legitimacy())).append(',')
                    .append(number(report.reversalRate())).append(',')
                    .append(number(report.constitutionalConflict())).append(',')
                    .append(number(report.democraticResponsiveness())).append(',')
                    .append(number(report.independenceAccountabilityBalance())).append(',')
                    .append(number(report.concurrenceFragmentation())).append(',')
                    .append(number(report.dissentIntensity())).append(',')
                    .append(number(report.recusalRate())).append(',')
                    .append(number(report.enBancRate())).append(',')
                    .append(number(report.crossCheckRate())).append(',')
                    .append(number(report.councilScreenRate())).append(',')
                    .append(number(report.overrideRate())).append(',')
                    .append(number(report.administrativeLoad()))
                    .append('\n');
        }
        Files.writeString(path, builder.toString());
    }

    private void writeMarkdown(
            Path path,
            List<CampaignRow> rows,
            int runs,
            long seed,
            List<LegislativeSignal> importedSignals
    ) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("# Constitutional Review Campaign v0\n\n");
        builder.append("- runs per case: ").append(runs).append('\n');
        builder.append("- seed: ").append(seed).append('\n');
        builder.append("- input: ").append(LegislativeOutputImporter.describeImport(importedSignals)).append("\n\n");
        builder.append("## Top Directional Scores by Case\n\n");
        for (String caseKey : rows.stream().map(CampaignRow::caseKey).distinct().toList()) {
            List<CampaignRow> caseRows = rows.stream().filter(row -> row.caseKey().equals(caseKey)).toList();
            CampaignRow best = caseRows.stream()
                    .max(Comparator.comparingDouble(row -> row.report().directionalScore()))
                    .orElseThrow();
            CampaignRow bestRights = caseRows.stream()
                    .max(Comparator.comparingDouble(row -> row.report().rightsProtection()))
                    .orElseThrow();
            CampaignRow lowestShadow = caseRows.stream()
                    .min(Comparator.comparingDouble(row -> row.report().shadowDocketAbuse()))
                    .orElseThrow();
            builder.append("### ").append(best.caseName()).append("\n\n");
            builder.append(best.caseDescription()).append("\n\n");
            builder.append("- best overall: ").append(best.report().scenarioName())
                    .append(" (`").append(best.report().scenarioKey()).append("`) at ")
                    .append(Values.format(best.report().directionalScore())).append('\n');
            builder.append("- strongest rights protection: ").append(bestRights.report().scenarioName())
                    .append(" at ").append(Values.format(bestRights.report().rightsProtection())).append('\n');
            builder.append("- lowest shadow-docket abuse: ").append(lowestShadow.report().scenarioName())
                    .append(" at ").append(Values.format(lowestShadow.report().shadowDocketAbuse())).append("\n\n");
        }

        builder.append("## Scenario Averages\n\n");
        builder.append("| Scenario | Score | Stability | Rights | Partisan | Shadow | Legitimacy | Reversal | Conflict | Response | Admin |\n");
        builder.append("| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
        for (String scenarioKey : rows.stream().map(row -> row.report().scenarioKey()).distinct().toList()) {
            List<ScenarioReport> reports = rows.stream()
                    .filter(row -> row.report().scenarioKey().equals(scenarioKey))
                    .map(CampaignRow::report)
                    .toList();
            ScenarioReport first = reports.get(0);
            builder.append("| ").append(first.scenarioName()).append(" | ")
                    .append(number(average(reports, ScenarioReport::directionalScore))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legalStability))).append(" | ")
                    .append(number(average(reports, ScenarioReport::rightsProtection))).append(" | ")
                    .append(number(average(reports, ScenarioReport::partisanAlignment))).append(" | ")
                    .append(number(average(reports, ScenarioReport::shadowDocketAbuse))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legitimacy))).append(" | ")
                    .append(number(average(reports, ScenarioReport::reversalRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::constitutionalConflict))).append(" | ")
                    .append(number(average(reports, ScenarioReport::democraticResponsiveness))).append(" | ")
                    .append(number(average(reports, ScenarioReport::administrativeLoad))).append(" |\n");
        }
        Files.writeString(path, builder.toString());
    }

    private static double average(List<ScenarioReport> reports, MetricReader reader) {
        if (reports.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (ScenarioReport report : reports) {
            sum += reader.value(report);
        }
        return sum / reports.size();
    }

    private static String csv(String value) {
        if (value.indexOf(',') < 0 && value.indexOf('"') < 0 && value.indexOf('\n') < 0) {
            return value;
        }
        return '"' + value.replace("\"", "\"\"") + '"';
    }

    private static String number(double value) {
        return String.format(Locale.ROOT, "%.3f", value);
    }

    private record CampaignCase(
            String key,
            String name,
            String description,
            WorldSpec spec,
            boolean importedCase
    ) {
    }

    @FunctionalInterface
    private interface MetricReader {
        double value(ScenarioReport report);
    }
}

