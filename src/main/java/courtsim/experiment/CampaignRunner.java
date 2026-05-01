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
        if (!"v0".equals(campaignKey) && !"v1-paired".equals(campaignKey) && !"paired-import".equals(campaignKey)) {
            throw new IllegalArgumentException("Unknown campaign: " + campaignKey);
        }
        Files.createDirectories(outputDir);
        List<Scenario> scenarios = ScenarioCatalog.scenariosForKeys(CORE_SCENARIOS);
        boolean pairedImport = "v1-paired".equals(campaignKey) || "paired-import".equals(campaignKey);
        List<CampaignCase> cases = pairedImport
                ? pairedImportCases(baseSpec, importedSignals)
                : campaignCases(baseSpec, !importedSignals.isEmpty());
        List<CampaignRow> rows = new ArrayList<>();
        for (int caseIndex = 0; caseIndex < cases.size(); caseIndex++) {
            CampaignCase campaignCase = cases.get(caseIndex);
            List<LegislativeSignal> caseSignals = campaignSignals(campaignCase, importedSignals);
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

        String basename = pairedImport ? "constitutional-review-paired-import-v1" : "constitutional-review-campaign-v0";
        Path csvPath = outputDir.resolve(basename + ".csv");
        Path markdownPath = outputDir.resolve(basename + ".md");
        Path manifestPath = outputDir.resolve(basename + "-manifest.json");
        writeCsv(csvPath, rows);
        writeMarkdown(markdownPath, rows, runs, seed, importedSignals);
        ReportProvenance.write(
                manifestPath,
                pairedImport ? "Constitutional Review Paired Import Campaign v1" : "Constitutional Review Campaign v0",
                runs,
                baseSpec.caseCount(),
                seed,
                cases.size(),
                scenarios.size(),
                LegislativeOutputImporter.describeImport(importedSignals),
                List.of(csvPath, markdownPath)
        );
        return new CampaignResult(
                pairedImport ? "Constitutional Review Paired Import Campaign v1" : "Constitutional Review Campaign v0",
                csvPath,
                markdownPath,
                manifestPath,
                List.copyOf(rows)
        );
    }

    private List<CampaignCase> campaignCases(WorldSpec baseSpec, boolean includeImportedCase) {
        List<CampaignCase> cases = new ArrayList<>();
        cases.add(new CampaignCase(
                "baseline",
                "Baseline",
                "Moderately polarized appointment environment with ordinary constitutional-review pressure.",
                baseSpec,
                SignalMode.SYNTHETIC
        ));
        cases.add(new CampaignCase(
                "polarized-appointments",
                "Polarized appointments",
                "High appointment polarization, higher partisan pressure, and lower public trust.",
                baseSpec.withAppointmentPolarization(0.86).withPartisanPressure(0.78).withPublicTrust(0.46),
                SignalMode.SYNTHETIC
        ));
        cases.add(new CampaignCase(
                "rights-threat-surge",
                "Rights-threat surge",
                "Docket contains more laws or actions with high generated rights-risk signals.",
                baseSpec.withRightsThreatRate(0.68).withLegislativeConflict(0.56),
                SignalMode.SYNTHETIC
        ));
        cases.add(new CampaignCase(
                "emergency-docket-stress",
                "Emergency docket stress",
                "Higher urgency and executive pressure, meant to stress shadow-docket procedures.",
                baseSpec.withEmergencyPressure(0.76).withPartisanPressure(0.68),
                SignalMode.SYNTHETIC
        ));
        cases.add(new CampaignCase(
                "low-trust-conflict",
                "Low-trust conflict",
                "Lower public trust and higher legislature-court conflict.",
                baseSpec.withPublicTrust(0.36).withLegislativeConflict(0.78),
                SignalMode.SYNTHETIC
        ));
        if (includeImportedCase) {
            cases.add(new CampaignCase(
                    "imported-legislative-output",
                    "Imported legislative output",
                    "Docket generated from legislative simulator campaign rows.",
                    baseSpec.withLegislativeConflict(0.58).withEmergencyPressure(0.42),
                    SignalMode.ALL_IMPORTED
            ));
        }
        return List.copyOf(cases);
    }

    private List<CampaignCase> pairedImportCases(WorldSpec baseSpec, List<LegislativeSignal> importedSignals) {
        if (importedSignals.isEmpty()) {
            throw new IllegalArgumentException("v1-paired requires --legislative-input");
        }
        return List.of(
                new CampaignCase(
                        "synthetic-baseline",
                        "Synthetic baseline",
                        "Synthetic docket using the same world assumptions as the imported comparisons.",
                        baseSpec.withLegislativeConflict(0.58).withEmergencyPressure(0.42),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "legislative-all",
                        "All imported legislative outputs",
                        "Docket generated from every imported legislative campaign row.",
                        baseSpec.withLegislativeConflict(0.58).withEmergencyPressure(0.42),
                        SignalMode.ALL_IMPORTED
                ),
                new CampaignCase(
                        "legislative-high-capture",
                        "High-capture legislative outputs",
                        "Imported rows with high lobby-capture or proposer-gain signals.",
                        baseSpec.withLegislativeConflict(0.66).withPartisanPressure(0.68),
                        SignalMode.HIGH_CAPTURE
                ),
                new CampaignCase(
                        "legislative-high-volatility",
                        "High-volatility legislative outputs",
                        "Imported rows with high policy-shift, reversal, or status-quo volatility signals.",
                        baseSpec.withLegislativeConflict(0.72).withEmergencyPressure(0.50),
                        SignalMode.HIGH_VOLATILITY
                ),
                new CampaignCase(
                        "legislative-low-mandate",
                        "Low-mandate legislative outputs",
                        "Imported rows with weak public mandate, low support, or public-preference distortion.",
                        baseSpec.withRightsThreatRate(0.54).withLegislativeConflict(0.70),
                        SignalMode.LOW_MANDATE
                )
        );
    }

    private List<LegislativeSignal> campaignSignals(CampaignCase campaignCase, List<LegislativeSignal> importedSignals) {
        return switch (campaignCase.signalMode()) {
            case SYNTHETIC -> List.of();
            case ALL_IMPORTED -> importedSignals;
            case HIGH_CAPTURE -> filtered(importedSignals, signal ->
                    signal.lobbyCapture() >= 0.22 || signal.proposerGain() >= 0.18);
            case HIGH_VOLATILITY -> filtered(importedSignals, signal ->
                    signal.policyShift() >= 0.18 || signal.reversalRate() >= 0.06 || signal.statusQuoVolatility() >= 0.12);
            case LOW_MANDATE -> filtered(importedSignals, signal ->
                    signal.lowSupportPassage() >= 0.12
                            || signal.weakPublicMandatePassage() >= 0.16
                            || signal.publicPreferenceDistortion() >= 0.18);
        };
    }

    private List<LegislativeSignal> filtered(List<LegislativeSignal> signals, SignalPredicate predicate) {
        List<LegislativeSignal> filtered = signals.stream().filter(predicate::matches).toList();
        return filtered.isEmpty() ? signals : filtered;
    }

    private void writeCsv(Path path, List<CampaignRow> rows) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,totalCases,reviewedCases,invalidations,emergencyOrders,emergencyReliefs,meritsReviews,meritsInvalidations,overrides,directionalScore,reviewRate,emergencyReliefRate,meritsReviewRate,meritsInvalidationRate,legalStability,rightsProtection,partisanAlignment,shadowDocketAbuse,legitimacy,reversalRate,constitutionalConflict,democraticResponsiveness,independenceAccountabilityBalance,concurrenceFragmentation,dissentIntensity,recusalRate,enBancRate,crossCheckRate,councilScreenRate,overrideRate,lowerCourtConflict,averageTimeToReview,replacementRate,administrativeLoad\n");
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
                    .append(report.emergencyReliefs()).append(',')
                    .append(report.meritsReviews()).append(',')
                    .append(report.meritsInvalidations()).append(',')
                    .append(report.overrides()).append(',')
                    .append(number(report.directionalScore())).append(',')
                    .append(number(report.reviewRate())).append(',')
                    .append(number(report.emergencyReliefRate())).append(',')
                    .append(number(report.meritsReviewRate())).append(',')
                    .append(number(report.meritsInvalidationRate())).append(',')
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
                    .append(number(report.lowerCourtConflict())).append(',')
                    .append(number(report.averageTimeToReview())).append(',')
                    .append(number(report.replacementRate())).append(',')
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
        builder.append("# ").append(rows.stream().anyMatch(row -> row.caseKey().startsWith("legislative-"))
                ? "Constitutional Review Paired Import Campaign v1"
                : "Constitutional Review Campaign v0").append("\n\n");
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
            CampaignRow lowestEmergencyRelief = caseRows.stream()
                    .min(Comparator.comparingDouble(row -> row.report().emergencyReliefRate()))
                    .orElseThrow();
            builder.append("### ").append(best.caseName()).append("\n\n");
            builder.append(best.caseDescription()).append("\n\n");
            builder.append("- best overall: ").append(best.report().scenarioName())
                    .append(" (`").append(best.report().scenarioKey()).append("`) at ")
                    .append(Values.format(best.report().directionalScore())).append('\n');
            builder.append("- strongest rights protection: ").append(bestRights.report().scenarioName())
                    .append(" at ").append(Values.format(bestRights.report().rightsProtection())).append('\n');
            builder.append("- lowest shadow-docket abuse: ").append(lowestShadow.report().scenarioName())
                    .append(" at ").append(Values.format(lowestShadow.report().shadowDocketAbuse())).append('\n');
            builder.append("- lowest emergency relief rate: ").append(lowestEmergencyRelief.report().scenarioName())
                    .append(" at ").append(Values.format(lowestEmergencyRelief.report().emergencyReliefRate())).append("\n\n");
        }

        builder.append("## Scenario Averages\n\n");
        builder.append("| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Delay | Turnover | Admin |\n");
        builder.append("| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
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
                    .append(number(average(reports, ScenarioReport::emergencyReliefRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::meritsInvalidationRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legitimacy))).append(" | ")
                    .append(number(average(reports, ScenarioReport::reversalRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::constitutionalConflict))).append(" | ")
                    .append(number(average(reports, ScenarioReport::democraticResponsiveness))).append(" | ")
                    .append(number(average(reports, ScenarioReport::averageTimeToReview))).append(" | ")
                    .append(number(average(reports, ScenarioReport::replacementRate))).append(" | ")
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
            SignalMode signalMode
    ) {
    }

    private enum SignalMode {
        SYNTHETIC,
        ALL_IMPORTED,
        HIGH_CAPTURE,
        HIGH_VOLATILITY,
        LOW_MANDATE
    }

    @FunctionalInterface
    private interface SignalPredicate {
        boolean matches(LegislativeSignal signal);
    }

    @FunctionalInterface
    private interface MetricReader {
        double value(ScenarioReport report);
    }
}
