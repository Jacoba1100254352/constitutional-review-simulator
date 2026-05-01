package courtsim.experiment;

import courtsim.importer.LegislativeOutputImporter;
import courtsim.model.DoctrineArea;
import courtsim.model.LegislativeSignal;
import courtsim.reporting.ReportProvenance;
import courtsim.simulation.CompositionReport;
import courtsim.simulation.Scenario;
import courtsim.simulation.ScenarioCatalog;
import courtsim.simulation.ScenarioReport;
import courtsim.simulation.SegmentReport;
import courtsim.simulation.Simulator;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class CampaignRunner {
    private static final Path DEFAULT_CALIBRATION_TARGETS = Path.of("config/calibration-targets.csv");
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
        if (!isSupportedCampaign(campaignKey)) {
            throw new IllegalArgumentException("Unknown campaign: " + campaignKey);
        }
        Files.createDirectories(outputDir);
        List<Scenario> scenarios = ScenarioCatalog.scenariosForKeys(CORE_SCENARIOS);
        boolean pairedImport = isPairedImport(campaignKey);
        List<CampaignCase> cases = isSensitivity(campaignKey)
                ? sensitivityCases(baseSpec)
                : (pairedImport
                        ? pairedImportCases(baseSpec, importedSignals)
                        : campaignCases(baseSpec, !importedSignals.isEmpty()));
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

        String basename = basename(campaignKey);
        String reportName = reportName(campaignKey);
        Path csvPath = outputDir.resolve(basename + ".csv");
        Path periodCsvPath = outputDir.resolve(basename + "-periods.csv");
        Path doctrineCsvPath = outputDir.resolve(basename + "-doctrines.csv");
        Path pipelineCsvPath = outputDir.resolve(basename + "-pipelines.csv");
        Path compositionCsvPath = outputDir.resolve(basename + "-composition.csv");
        Path calibrationCsvPath = outputDir.resolve(basename + "-calibration.csv");
        Path markdownPath = outputDir.resolve(basename + ".md");
        Path manifestPath = outputDir.resolve(basename + "-manifest.json");
        writeCsv(csvPath, rows);
        writeSegmentCsv(periodCsvPath, rows, SegmentKind.PERIOD);
        writeSegmentCsv(doctrineCsvPath, rows, SegmentKind.DOCTRINE);
        writeSegmentCsv(pipelineCsvPath, rows, SegmentKind.PIPELINE);
        writeCompositionCsv(compositionCsvPath, rows);
        List<CalibrationRow> calibrationRows = calibrationRows(rows);
        writeCalibrationCsv(calibrationCsvPath, calibrationRows);
        writeMarkdown(markdownPath, rows, runs, seed, importedSignals, reportName, calibrationRows);
        ReportProvenance.write(
                manifestPath,
                reportName,
                runs,
                baseSpec.caseCount(),
                seed,
                cases.size(),
                scenarios.size(),
                LegislativeOutputImporter.describeImport(importedSignals),
                List.of(csvPath, periodCsvPath, doctrineCsvPath, pipelineCsvPath, compositionCsvPath, calibrationCsvPath, markdownPath)
        );
        return new CampaignResult(
                reportName,
                csvPath,
                periodCsvPath,
                doctrineCsvPath,
                pipelineCsvPath,
                compositionCsvPath,
                calibrationCsvPath,
                markdownPath,
                manifestPath,
                List.copyOf(rows)
        );
    }

    private boolean isSupportedCampaign(String campaignKey) {
        return "v0".equals(campaignKey)
                || "v1-paired".equals(campaignKey)
                || "paired-import".equals(campaignKey)
                || isSensitivity(campaignKey);
    }

    private boolean isPairedImport(String campaignKey) {
        return "v1-paired".equals(campaignKey) || "paired-import".equals(campaignKey);
    }

    private boolean isSensitivity(String campaignKey) {
        return "sensitivity".equals(campaignKey) || "sensitivity-v1".equals(campaignKey);
    }

    private String basename(String campaignKey) {
        if (isPairedImport(campaignKey)) {
            return "constitutional-review-paired-import-v1";
        }
        if (isSensitivity(campaignKey)) {
            return "constitutional-review-sensitivity-v1";
        }
        return "constitutional-review-campaign-v0";
    }

    private String reportName(String campaignKey) {
        if (isPairedImport(campaignKey)) {
            return "Constitutional Review Paired Import Campaign v1";
        }
        if (isSensitivity(campaignKey)) {
            return "Constitutional Review Sensitivity Campaign v1";
        }
        return "Constitutional Review Campaign v0";
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

    private List<CampaignCase> sensitivityCases(WorldSpec baseSpec) {
        return List.of(
                new CampaignCase(
                        "baseline",
                        "Baseline",
                        "Baseline assumptions for sensitivity comparison.",
                        baseSpec,
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "low-emergency-pressure",
                        "Low emergency pressure",
                        "Lower urgency and emergency docket pressure.",
                        baseSpec.withEmergencyPressure(0.12),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "high-emergency-pressure",
                        "High emergency pressure",
                        "Higher urgency and emergency docket pressure.",
                        baseSpec.withEmergencyPressure(0.82),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "low-appointment-polarization",
                        "Low appointment polarization",
                        "Lower appointment ideology spread and partisan pressure.",
                        baseSpec.withAppointmentPolarization(0.24).withPartisanPressure(0.28),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "high-appointment-polarization",
                        "High appointment polarization",
                        "Higher appointment ideology spread and partisan pressure.",
                        baseSpec.withAppointmentPolarization(0.90).withPartisanPressure(0.86),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "low-rights-threat",
                        "Low rights threat",
                        "Lower share of cases with generated rights-risk signals.",
                        baseSpec.withRightsThreatRate(0.16),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "high-rights-threat",
                        "High rights threat",
                        "Higher share of cases with generated rights-risk signals.",
                        baseSpec.withRightsThreatRate(0.78),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "high-public-trust",
                        "High public trust",
                        "High initial trust and lower institutional conflict.",
                        baseSpec.withPublicTrust(0.82).withLegislativeConflict(0.24),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "low-public-trust",
                        "Low public trust",
                        "Low initial trust and higher institutional conflict.",
                        baseSpec.withPublicTrust(0.24).withLegislativeConflict(0.70),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "low-legislative-conflict",
                        "Low legislative conflict",
                        "Lower legislature-court conflict pressure.",
                        baseSpec.withLegislativeConflict(0.18),
                        SignalMode.SYNTHETIC
                ),
                new CampaignCase(
                        "high-legislative-conflict",
                        "High legislative conflict",
                        "Higher legislature-court conflict pressure and lower trust.",
                        baseSpec.withLegislativeConflict(0.86).withPublicTrust(0.38),
                        SignalMode.SYNTHETIC
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
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,totalCases,reviewedCases,invalidations,emergencyOrders,emergencyReliefs,meritsReviews,meritsInvalidations,overrides,directionalScore,reviewRate,emergencyReliefRate,meritsReviewRate,meritsInvalidationRate,legalStability,rightsProtection,partisanAlignment,shadowDocketAbuse,legitimacy,reversalRate,constitutionalConflict,democraticResponsiveness,independenceAccountabilityBalance,concurrenceFragmentation,dissentIntensity,recusalRate,enBancRate,crossCheckRate,councilScreenRate,overrideRate,lowerCourtConflict,averageTimeToReview,replacementRate,stateCaseShare,mixedJurisdictionShare,averageLowerCourtDepth,stateFederalTension,intercourtConflict,complianceRate,defianceRate,workaroundRate,repeatedLitigationRate,executiveImplementationRate,agencyNonacquiescenceRate,legislativeReenactmentRate,localGovernmentComplianceRate,publicTrust,legislativeConflict,courtCurbingPressure,amendmentPressure,administrativeLoad\n");
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
                    .append(number(report.stateCaseShare())).append(',')
                    .append(number(report.mixedJurisdictionShare())).append(',')
                    .append(number(report.averageLowerCourtDepth())).append(',')
                    .append(number(report.stateFederalTension())).append(',')
                    .append(number(report.intercourtConflict())).append(',')
                    .append(number(report.complianceRate())).append(',')
                    .append(number(report.defianceRate())).append(',')
                    .append(number(report.workaroundRate())).append(',')
                    .append(number(report.repeatedLitigationRate())).append(',')
                    .append(number(report.executiveImplementationRate())).append(',')
                    .append(number(report.agencyNonacquiescenceRate())).append(',')
                    .append(number(report.legislativeReenactmentRate())).append(',')
                    .append(number(report.localGovernmentComplianceRate())).append(',')
                    .append(number(report.publicTrust())).append(',')
                    .append(number(report.legislativeConflict())).append(',')
                    .append(number(report.courtCurbingPressure())).append(',')
                    .append(number(report.amendmentPressure())).append(',')
                    .append(number(report.administrativeLoad()))
                    .append('\n');
        }
        Files.writeString(path, builder.toString());
    }

    private void writeSegmentCsv(Path path, List<CampaignRow> rows, SegmentKind kind) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,segmentType,segmentKey,totalCases,reviewedCases,reviewRate,legalStability,rightsProtection,shadowDocketAbuse,emergencyReliefRate,meritsInvalidationRate,lowerCourtConflict,averageTimeToReview,averageLowerCourtDepth,stateFederalTension,intercourtConflict,legitimacy,constitutionalConflict,democraticResponsiveness,complianceRate,defianceRate,workaroundRate,repeatedLitigationRate,executiveImplementationRate,agencyNonacquiescenceRate,legislativeReenactmentRate,localGovernmentComplianceRate,publicTrust,legislativeConflict,courtCurbingPressure,amendmentPressure\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            for (SegmentReport segment : segments(row, kind)) {
                builder.append(csv(row.caseKey())).append(',')
                        .append(csv(row.caseName())).append(',')
                        .append(csv(row.caseDescription())).append(',')
                        .append(csv(report.scenarioKey())).append(',')
                        .append(csv(report.scenarioName())).append(',')
                        .append(csv(segment.segmentType())).append(',')
                        .append(csv(segment.segmentKey())).append(',')
                        .append(segment.totalCases()).append(',')
                        .append(segment.reviewedCases()).append(',')
                        .append(number(segment.reviewRate())).append(',')
                        .append(number(segment.legalStability())).append(',')
                        .append(number(segment.rightsProtection())).append(',')
                        .append(number(segment.shadowDocketAbuse())).append(',')
                        .append(number(segment.emergencyReliefRate())).append(',')
                        .append(number(segment.meritsInvalidationRate())).append(',')
                        .append(number(segment.lowerCourtConflict())).append(',')
                        .append(number(segment.averageTimeToReview())).append(',')
                        .append(number(segment.averageLowerCourtDepth())).append(',')
                        .append(number(segment.stateFederalTension())).append(',')
                        .append(number(segment.intercourtConflict())).append(',')
                        .append(number(segment.legitimacy())).append(',')
                        .append(number(segment.constitutionalConflict())).append(',')
                        .append(number(segment.democraticResponsiveness())).append(',')
                        .append(number(segment.complianceRate())).append(',')
                        .append(number(segment.defianceRate())).append(',')
                        .append(number(segment.workaroundRate())).append(',')
                        .append(number(segment.repeatedLitigationRate())).append(',')
                        .append(number(segment.executiveImplementationRate())).append(',')
                        .append(number(segment.agencyNonacquiescenceRate())).append(',')
                        .append(number(segment.legislativeReenactmentRate())).append(',')
                        .append(number(segment.localGovernmentComplianceRate())).append(',')
                        .append(number(segment.publicTrust())).append(',')
                        .append(number(segment.legislativeConflict())).append(',')
                        .append(number(segment.courtCurbingPressure())).append(',')
                        .append(number(segment.amendmentPressure()))
                        .append('\n');
            }
        }
        Files.writeString(path, builder.toString());
    }

    private void writeCompositionCsv(Path path, List<CampaignRow> rows) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,segmentType,segmentKey,observations,courtSize,medianIdeology,ideologicalSpread,meanPartisanAttachment,meanRightsSensitivity,meanInstitutionalism,replacementPressure,estimatedReplacementEvents\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            for (CompositionReport composition : report.compositionReports()) {
                builder.append(csv(row.caseKey())).append(',')
                        .append(csv(row.caseName())).append(',')
                        .append(csv(row.caseDescription())).append(',')
                        .append(csv(report.scenarioKey())).append(',')
                        .append(csv(report.scenarioName())).append(',')
                        .append(csv(composition.segmentType())).append(',')
                        .append(csv(composition.segmentKey())).append(',')
                        .append(composition.observations()).append(',')
                        .append(number(composition.courtSize())).append(',')
                        .append(number(composition.medianIdeology())).append(',')
                        .append(number(composition.ideologicalSpread())).append(',')
                        .append(number(composition.meanPartisanAttachment())).append(',')
                        .append(number(composition.meanRightsSensitivity())).append(',')
                        .append(number(composition.meanInstitutionalism())).append(',')
                        .append(number(composition.replacementPressure())).append(',')
                        .append(number(composition.estimatedReplacementEvents()))
                        .append('\n');
            }
        }
        Files.writeString(path, builder.toString());
    }

    private void writeCalibrationCsv(Path path, List<CalibrationRow> rows) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("targetKey,label,targetSource,observedValue,lowerBound,upperBound,withinTarget,gap,note\n");
        for (CalibrationRow row : rows) {
            builder.append(csv(row.target().key())).append(',')
                    .append(csv(row.target().label())).append(',')
                    .append(csv(row.target().source())).append(',')
                    .append(number(row.observedValue())).append(',')
                    .append(number(row.target().lowerBound())).append(',')
                    .append(number(row.target().upperBound())).append(',')
                    .append(row.withinTarget()).append(',')
                    .append(number(row.gap())).append(',')
                    .append(csv(row.target().note()))
                    .append('\n');
        }
        Files.writeString(path, builder.toString());
    }

    private void writeMarkdown(
            Path path,
            List<CampaignRow> rows,
            int runs,
            long seed,
            List<LegislativeSignal> importedSignals,
            String reportName,
            List<CalibrationRow> calibrationRows
    ) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("# ").append(reportName).append("\n\n");
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
            CampaignRow highestCompliance = caseRows.stream()
                    .max(Comparator.comparingDouble(row -> row.report().complianceRate()))
                    .orElseThrow();
            CampaignRow lowestDefiance = caseRows.stream()
                    .min(Comparator.comparingDouble(row -> row.report().defianceRate()))
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
                    .append(" at ").append(Values.format(lowestEmergencyRelief.report().emergencyReliefRate())).append('\n');
            builder.append("- highest compliance rate: ").append(highestCompliance.report().scenarioName())
                    .append(" at ").append(Values.format(highestCompliance.report().complianceRate())).append('\n');
            builder.append("- lowest defiance rate: ").append(lowestDefiance.report().scenarioName())
                    .append(" at ").append(Values.format(lowestDefiance.report().defianceRate())).append("\n\n");
        }

        builder.append("## Scenario Averages\n\n");
        builder.append("| Scenario | Score | Stability | Rights | Partisan | Shadow | Emerg. relief | Merits inval. | Legitimacy | Reversal | Conflict | Response | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin |\n");
        builder.append("| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
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
                    .append(number(average(reports, ScenarioReport::complianceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::executiveImplementationRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::agencyNonacquiescenceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legislativeReenactmentRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::localGovernmentComplianceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::averageLowerCourtDepth))).append(" | ")
                    .append(number(average(reports, ScenarioReport::stateFederalTension))).append(" | ")
                    .append(number(average(reports, ScenarioReport::administrativeLoad))).append(" |\n");
        }
        appendSegmentDiagnostics(builder, rows, "Period Diagnostics", SegmentKind.PERIOD);
        appendSegmentDiagnostics(builder, rows, "Doctrine Diagnostics", SegmentKind.DOCTRINE);
        appendSegmentDiagnostics(builder, rows, "Pipeline Diagnostics", SegmentKind.PIPELINE);
        appendCompositionDiagnostics(builder, rows);
        appendCalibrationDiagnostics(builder, calibrationRows);
        Files.writeString(path, builder.toString());
    }

    private void appendSegmentDiagnostics(
            StringBuilder builder,
            List<CampaignRow> rows,
            String title,
            SegmentKind kind
    ) {
        builder.append("\n## ").append(title).append("\n\n");
        builder.append("| Scenario | Segment | Cases | Review | Rights | Shadow | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing |\n");
        builder.append("| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
        for (String scenarioKey : rows.stream().map(row -> row.report().scenarioKey()).distinct().toList()) {
            List<CampaignRow> scenarioRows = rows.stream()
                    .filter(row -> row.report().scenarioKey().equals(scenarioKey))
                    .toList();
            ScenarioReport first = scenarioRows.get(0).report();
            List<String> segmentKeys = scenarioRows.stream()
                    .flatMap(row -> segments(row, kind).stream())
                    .map(SegmentReport::segmentKey)
                    .distinct()
                    .sorted()
                    .toList();
            for (String segmentKey : segmentKeys) {
                List<SegmentReport> reports = scenarioRows.stream()
                        .flatMap(row -> segments(row, kind).stream())
                        .filter(segment -> segment.segmentKey().equals(segmentKey))
                        .toList();
                builder.append("| ").append(first.scenarioName()).append(" | ")
                        .append(segmentKey).append(" | ")
                        .append(segmentCases(reports)).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::reviewRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::rightsProtection))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::shadowDocketAbuse))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::meritsInvalidationRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::averageLowerCourtDepth))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::stateFederalTension))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::intercourtConflict))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::complianceRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::executiveImplementationRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::agencyNonacquiescenceRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::legislativeReenactmentRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::localGovernmentComplianceRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::publicTrust))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::legislativeConflict))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::courtCurbingPressure))).append(" |\n");
            }
        }
    }

    private void appendCompositionDiagnostics(StringBuilder builder, List<CampaignRow> rows) {
        builder.append("\n## Composition Diagnostics\n\n");
        builder.append("| Scenario | Period | Observations | Size | Median ideology | Spread | Partisan attach. | Rights sens. | Institutionalism | Replacement events |\n");
        builder.append("| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
        for (String scenarioKey : rows.stream().map(row -> row.report().scenarioKey()).distinct().toList()) {
            List<CampaignRow> scenarioRows = rows.stream()
                    .filter(row -> row.report().scenarioKey().equals(scenarioKey))
                    .toList();
            ScenarioReport first = scenarioRows.get(0).report();
            List<String> periodKeys = scenarioRows.stream()
                    .flatMap(row -> row.report().compositionReports().stream())
                    .map(CompositionReport::segmentKey)
                    .distinct()
                    .sorted()
                    .toList();
            for (String periodKey : periodKeys) {
                List<CompositionReport> reports = scenarioRows.stream()
                        .flatMap(row -> row.report().compositionReports().stream())
                        .filter(report -> report.segmentKey().equals(periodKey))
                        .toList();
                builder.append("| ").append(first.scenarioName()).append(" | ")
                        .append(periodKey).append(" | ")
                        .append(compositionObservations(reports)).append(" | ")
                        .append(number(compositionAverage(reports, CompositionReport::courtSize))).append(" | ")
                        .append(number(compositionAverage(reports, CompositionReport::medianIdeology))).append(" | ")
                        .append(number(compositionAverage(reports, CompositionReport::ideologicalSpread))).append(" | ")
                        .append(number(compositionAverage(reports, CompositionReport::meanPartisanAttachment))).append(" | ")
                        .append(number(compositionAverage(reports, CompositionReport::meanRightsSensitivity))).append(" | ")
                        .append(number(compositionAverage(reports, CompositionReport::meanInstitutionalism))).append(" | ")
                        .append(number(compositionAverage(reports, CompositionReport::estimatedReplacementEvents))).append(" |\n");
            }
        }
    }

    private void appendCalibrationDiagnostics(StringBuilder builder, List<CalibrationRow> rows) {
        builder.append("\n## Calibration Diagnostics\n\n");
        builder.append("| Target | Observed | Range | Gap | Status |\n");
        builder.append("| --- | ---: | ---: | ---: | --- |\n");
        for (CalibrationRow row : rows) {
            builder.append("| ").append(row.target().label()).append(" | ")
                    .append(number(row.observedValue())).append(" | ")
                    .append(number(row.target().lowerBound())).append("-")
                    .append(number(row.target().upperBound())).append(" | ")
                    .append(number(row.gap())).append(" | ")
                    .append(row.withinTarget() ? "within" : "outside")
                    .append(" |\n");
        }
    }

    private static List<SegmentReport> segments(CampaignRow row, SegmentKind kind) {
        return switch (kind) {
            case PERIOD -> row.report().periodReports();
            case DOCTRINE -> row.report().doctrineReports();
            case PIPELINE -> row.report().pipelineReports();
        };
    }

    private static int segmentCases(List<SegmentReport> reports) {
        int cases = 0;
        for (SegmentReport report : reports) {
            cases += report.totalCases();
        }
        return cases;
    }

    private static double segmentAverage(List<SegmentReport> reports, SegmentMetricReader reader) {
        int cases = segmentCases(reports);
        if (cases == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (SegmentReport report : reports) {
            sum += reader.value(report) * report.totalCases();
        }
        return sum / cases;
    }

    private static int compositionObservations(List<CompositionReport> reports) {
        int observations = 0;
        for (CompositionReport report : reports) {
            observations += report.observations();
        }
        return observations;
    }

    private static double compositionAverage(List<CompositionReport> reports, CompositionMetricReader reader) {
        int observations = compositionObservations(reports);
        if (observations == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (CompositionReport report : reports) {
            sum += reader.value(report) * report.observations();
        }
        return sum / observations;
    }

    private List<CalibrationRow> calibrationRows(List<CampaignRow> rows) throws IOException {
        Map<String, Double> observed = observedCalibrationValues(rows);
        List<CalibrationRow> calibrationRows = new ArrayList<>();
        for (CalibrationTarget target : calibrationTargets()) {
            double value = observed.getOrDefault(target.key(), 0.0);
            boolean within = value >= target.lowerBound() && value <= target.upperBound();
            double gap = within ? 0.0 : Math.min(Math.abs(value - target.lowerBound()), Math.abs(value - target.upperBound()));
            calibrationRows.add(new CalibrationRow(target, value, within, gap));
        }
        return List.copyOf(calibrationRows);
    }

    private Map<String, Double> observedCalibrationValues(List<CampaignRow> rows) {
        Map<String, Double> observed = new LinkedHashMap<>();
        int totalCases = rows.stream().mapToInt(row -> row.report().totalCases()).sum();
        for (DoctrineArea doctrineArea : DoctrineArea.values()) {
            int doctrineCases = rows.stream()
                    .flatMap(row -> row.report().doctrineReports().stream())
                    .filter(segment -> segment.segmentKey().equals(doctrineArea.name().toLowerCase()))
                    .mapToInt(SegmentReport::totalCases)
                    .sum();
            observed.put("doctrine_mix." + doctrineArea.name().toLowerCase(), Values.ratio(doctrineCases, totalCases));
        }
        int emergencyOrders = rows.stream().mapToInt(row -> row.report().emergencyOrders()).sum();
        int emergencyReliefs = rows.stream().mapToInt(row -> row.report().emergencyReliefs()).sum();
        observed.put("emergency_relief_rate", Values.ratio(emergencyReliefs, emergencyOrders));
        observed.put("compliance_rate", weightedAverage(rows, ScenarioReport::complianceRate));
        observed.put("legitimacy_trust_gradient", legitimacyTrustGradient(rows));
        return observed;
    }

    private List<CalibrationTarget> calibrationTargets() throws IOException {
        if (!Files.exists(DEFAULT_CALIBRATION_TARGETS)) {
            return defaultCalibrationTargets("built-in-defaults");
        }
        List<CalibrationTarget> targets = new ArrayList<>();
        List<String> lines = Files.readAllLines(DEFAULT_CALIBRATION_TARGETS);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }
            String[] parts = line.split(",", -1);
            if (parts.length < 5) {
                throw new IOException("Malformed calibration target row " + (i + 1) + " in " + DEFAULT_CALIBRATION_TARGETS);
            }
            targets.add(new CalibrationTarget(
                    parts[0].trim(),
                    parts[1].trim(),
                    Double.parseDouble(parts[2].trim()),
                    Double.parseDouble(parts[3].trim()),
                    parts[4].trim(),
                    DEFAULT_CALIBRATION_TARGETS.toString()
            ));
        }
        return targets.isEmpty() ? defaultCalibrationTargets("built-in-defaults") : List.copyOf(targets);
    }

    private List<CalibrationTarget> defaultCalibrationTargets(String source) {
        return List.of(
                new CalibrationTarget("doctrine_mix.speech", "Speech docket share", 0.08, 0.20, "Starter external range for speech claims.", source),
                new CalibrationTarget("doctrine_mix.equality", "Equality docket share", 0.08, 0.20, "Starter external range for equality claims.", source),
                new CalibrationTarget("doctrine_mix.criminal_procedure", "Criminal procedure docket share", 0.08, 0.20, "Starter external range for criminal-procedure claims.", source),
                new CalibrationTarget("doctrine_mix.federalism", "Federalism docket share", 0.06, 0.18, "Starter external range for federalism claims.", source),
                new CalibrationTarget("doctrine_mix.election_law", "Election law docket share", 0.05, 0.16, "Starter external range for election-law claims.", source),
                new CalibrationTarget("doctrine_mix.emergency_powers", "Emergency powers docket share", 0.04, 0.14, "Starter external range for emergency-powers claims.", source),
                new CalibrationTarget("doctrine_mix.administrative_state", "Administrative state docket share", 0.06, 0.18, "Starter external range for administrative-state claims.", source),
                new CalibrationTarget("emergency_relief_rate", "Emergency relief rate", 0.05, 0.24, "Share of emergency orders granting interim relief.", source),
                new CalibrationTarget("compliance_rate", "Compliance rate", 0.70, 0.95, "Share of cases with institutional compliance.", source),
                new CalibrationTarget("legitimacy_trust_gradient", "Legitimacy response to trust", 0.15, 1.20, "Slope of legitimacy over public-trust outcomes across campaign rows.", source)
        );
    }

    private static double weightedAverage(List<CampaignRow> rows, MetricReader reader) {
        int totalCases = rows.stream().mapToInt(row -> row.report().totalCases()).sum();
        if (totalCases == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (CampaignRow row : rows) {
            sum += reader.value(row.report()) * row.report().totalCases();
        }
        return sum / totalCases;
    }

    private static double legitimacyTrustGradient(List<CampaignRow> rows) {
        double meanTrust = rows.stream().mapToDouble(row -> row.report().publicTrust()).average().orElse(0.0);
        double meanLegitimacy = rows.stream().mapToDouble(row -> row.report().legitimacy()).average().orElse(0.0);
        double covariance = 0.0;
        double variance = 0.0;
        for (CampaignRow row : rows) {
            double trustDelta = row.report().publicTrust() - meanTrust;
            covariance += trustDelta * (row.report().legitimacy() - meanLegitimacy);
            variance += trustDelta * trustDelta;
        }
        if (variance <= 0.000001) {
            return 0.0;
        }
        return covariance / variance;
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

    private enum SegmentKind {
        PERIOD,
        DOCTRINE,
        PIPELINE
    }

    @FunctionalInterface
    private interface SignalPredicate {
        boolean matches(LegislativeSignal signal);
    }

    @FunctionalInterface
    private interface MetricReader {
        double value(ScenarioReport report);
    }

    @FunctionalInterface
    private interface SegmentMetricReader {
        double value(SegmentReport report);
    }

    @FunctionalInterface
    private interface CompositionMetricReader {
        double value(CompositionReport report);
    }

    private record CalibrationTarget(
            String key,
            String label,
            double lowerBound,
            double upperBound,
            String note,
            String source
    ) {
    }

    private record CalibrationRow(
            CalibrationTarget target,
            double observedValue,
            boolean withinTarget,
            double gap
    ) {
    }
}
