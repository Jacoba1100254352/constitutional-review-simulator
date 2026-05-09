package courtsim.experiment;

import courtsim.importer.LegislativeOutputImporter;
import courtsim.institution.CaseOutcome;
import courtsim.model.DoctrineArea;
import courtsim.model.LegislativeSignal;
import courtsim.reporting.ReportProvenance;
import courtsim.simulation.CompositionReport;
import courtsim.simulation.MetricsAccumulator;
import courtsim.simulation.Scenario;
import courtsim.simulation.ScenarioCatalog;
import courtsim.simulation.ScenarioReport;
import courtsim.simulation.ScenarioRunResult;
import courtsim.simulation.SegmentReport;
import courtsim.simulation.Simulator;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

public final class CampaignRunner {
    private static final Path DEFAULT_CALIBRATION_TARGETS = Path.of("config/calibration-targets.csv");
    private static final Path CALIBRATION_TARGET_DIR = Path.of("config/calibration");
    private static final Path DEFAULT_CONTEXT_PROFILES = Path.of("config/context/country-year-context.csv");
    private static final String INTERVAL_METHOD = "conservative-bounded-normal-95";
    private static final int BOOTSTRAP_SAMPLES = 200;
    private static final String BOOTSTRAP_METHOD = "cluster-bootstrap-runs-" + BOOTSTRAP_SAMPLES + "-95";
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
            "independence-accountability-hybrid",
            "weak-form-review",
            "suspended-declaration-review",
            "override-clause-review",
            "pre-enactment-review",
            "abstract-review-tribunal",
            "ombudsman-triggered-review",
            "constitutional-public-defender",
            "rights-impact-statement-review",
            "mandatory-legislative-response"
    );
    private static final List<String> VALIDATION_SCENARIOS = List.of(
            "us-supreme-court-benchmark",
            "german-constitutional-court",
            "french-constitutional-council",
            "canadian-supreme-court",
            "south-african-constitutional-court",
            "uk-supreme-court",
            "echr-treaty-court",
            "cjeu-court-of-justice"
    );
    private static final Map<String, String> CALIBRATION_PROFILE_SCENARIOS = Map.ofEntries(
            Map.entry("scdb-postwar-merits-1946-2024", "us-supreme-court-benchmark"),
            Map.entry("scdb-modern-merits-2000-2024", "us-supreme-court-benchmark"),
            Map.entry("scotus-emergency-2024-2025", "us-supreme-court-benchmark"),
            Map.entry("gallup-court-confidence-2024", "us-supreme-court-benchmark"),
            Map.entry("germany-bverfg-2024", "german-constitutional-court"),
            Map.entry("france-conseil-qpc", "french-constitutional-council"),
            Map.entry("canada-scc-recent", "canadian-supreme-court"),
            Map.entry("canada-scc-2024", "canadian-supreme-court"),
            Map.entry("south-africa-constcourt-recent", "south-african-constitutional-court"),
            Map.entry("uk-supreme-court-2024-2025", "uk-supreme-court"),
            Map.entry("uk-human-rights-doi-2025", "uk-supreme-court"),
            Map.entry("echr-2024", "echr-treaty-court"),
            Map.entry("cjeu-2024", "cjeu-court-of-justice")
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
        List<Scenario> scenarios = ScenarioCatalog.scenariosForKeys(isValidation(campaignKey) ? VALIDATION_SCENARIOS : CORE_SCENARIOS);
        boolean pairedImport = isPairedImport(campaignKey);
        List<CampaignCase> cases = isSensitivity(campaignKey)
                ? sensitivityCases(baseSpec)
                : (isValidation(campaignKey)
                        ? validationCases(baseSpec)
                        : (pairedImport
                        ? pairedImportCases(baseSpec, importedSignals)
                        : campaignCases(baseSpec, !importedSignals.isEmpty())));
        List<CampaignRow> rows = new ArrayList<>();
        for (int caseIndex = 0; caseIndex < cases.size(); caseIndex++) {
            CampaignCase campaignCase = cases.get(caseIndex);
            List<LegislativeSignal> caseSignals = campaignSignals(campaignCase, importedSignals);
            Map<String, WorldSpec> scenarioSpecs = scenarioSpecs(
                    campaignCase.spec(),
                    scenarios,
                    isValidation(campaignKey)
            );
            List<ScenarioRunResult> reports = simulator.compareDetailed(
                    scenarios,
                    campaignCase.spec(),
                    runs,
                    seed + (caseIndex * 10_000L),
                    caseSignals,
                    scenarioSpecs
            );
            for (ScenarioRunResult result : reports) {
                rows.add(new CampaignRow(
                        campaignCase.key(),
                        campaignCase.name(),
                        campaignCase.description(),
                        result.report(),
                        result.outcomes(),
                        campaignCase.spec().caseCount(),
                        runs
                ));
            }
        }

        String basename = basename(campaignKey);
        String reportName = reportName(campaignKey);
        Path csvPath = outputDir.resolve(basename + ".csv");
        Path periodCsvPath = outputDir.resolve(basename + "-periods.csv");
        Path doctrineCsvPath = outputDir.resolve(basename + "-doctrines.csv");
        Path pipelineCsvPath = outputDir.resolve(basename + "-pipelines.csv");
        Path policyDomainCsvPath = outputDir.resolve(basename + "-policy-domains.csv");
        Path compositionCsvPath = outputDir.resolve(basename + "-composition.csv");
        Path calibrationCsvPath = outputDir.resolve(basename + "-calibration.csv");
        Path caseCsvGzPath = outputDir.resolve(basename + "-cases.csv.gz");
        Path intervalCsvPath = outputDir.resolve(basename + "-intervals.csv");
        Path periodIntervalCsvPath = outputDir.resolve(basename + "-period-intervals.csv");
        Path doctrineIntervalCsvPath = outputDir.resolve(basename + "-doctrine-intervals.csv");
        Path pipelineIntervalCsvPath = outputDir.resolve(basename + "-pipeline-intervals.csv");
        Path policyDomainIntervalCsvPath = outputDir.resolve(basename + "-policy-domain-intervals.csv");
        Path compositionIntervalCsvPath = outputDir.resolve(basename + "-composition-intervals.csv");
        Path calibrationIntervalCsvPath = outputDir.resolve(basename + "-calibration-intervals.csv");
        Path markdownPath = outputDir.resolve(basename + ".md");
        Path manifestPath = outputDir.resolve(basename + "-manifest.json");
        writeCsv(csvPath, rows);
        writeSegmentCsv(periodCsvPath, rows, SegmentKind.PERIOD);
        writeSegmentCsv(doctrineCsvPath, rows, SegmentKind.DOCTRINE);
        writeSegmentCsv(pipelineCsvPath, rows, SegmentKind.PIPELINE);
        writeSegmentCsv(policyDomainCsvPath, rows, SegmentKind.POLICY_DOMAIN);
        writeCompositionCsv(compositionCsvPath, rows);
        List<CalibrationRow> calibrationRows = calibrationRows(rows);
        writeCalibrationCsv(calibrationCsvPath, calibrationRows);
        writeCaseCsv(caseCsvGzPath, rows);
        Map<CampaignRow, BootstrapSummary> bootstrapSummaries = bootstrapSummaries(rows);
        writeCampaignIntervalCsv(intervalCsvPath, rows, bootstrapSummaries);
        writeSegmentIntervalCsv(periodIntervalCsvPath, rows, SegmentKind.PERIOD, bootstrapSummaries);
        writeSegmentIntervalCsv(doctrineIntervalCsvPath, rows, SegmentKind.DOCTRINE, bootstrapSummaries);
        writeSegmentIntervalCsv(pipelineIntervalCsvPath, rows, SegmentKind.PIPELINE, bootstrapSummaries);
        writeSegmentIntervalCsv(policyDomainIntervalCsvPath, rows, SegmentKind.POLICY_DOMAIN, bootstrapSummaries);
        writeCompositionIntervalCsv(compositionIntervalCsvPath, rows);
        writeCalibrationIntervalCsv(calibrationIntervalCsvPath, calibrationRows);
        String inputDescription = inputDescription(campaignKey, importedSignals);
        writeMarkdown(markdownPath, rows, runs, seed, inputDescription, reportName, calibrationRows);
        ReportProvenance.write(
                manifestPath,
                reportName,
                runs,
                baseSpec.caseCount(),
                seed,
                cases.size(),
                scenarios.size(),
                inputDescription,
                List.of(
                        csvPath,
                        periodCsvPath,
                        doctrineCsvPath,
                        pipelineCsvPath,
                        policyDomainCsvPath,
                        compositionCsvPath,
                        calibrationCsvPath,
                        caseCsvGzPath,
                        intervalCsvPath,
                        periodIntervalCsvPath,
                        doctrineIntervalCsvPath,
                        pipelineIntervalCsvPath,
                        policyDomainIntervalCsvPath,
                        compositionIntervalCsvPath,
                        calibrationIntervalCsvPath,
                        markdownPath
                )
        );
        return new CampaignResult(
                reportName,
                csvPath,
                periodCsvPath,
                doctrineCsvPath,
                pipelineCsvPath,
                policyDomainCsvPath,
                compositionCsvPath,
                calibrationCsvPath,
                caseCsvGzPath,
                intervalCsvPath,
                periodIntervalCsvPath,
                doctrineIntervalCsvPath,
                pipelineIntervalCsvPath,
                policyDomainIntervalCsvPath,
                compositionIntervalCsvPath,
                calibrationIntervalCsvPath,
                markdownPath,
                manifestPath,
                List.copyOf(rows)
        );
    }

    private boolean isSupportedCampaign(String campaignKey) {
        return "v0".equals(campaignKey)
                || "v1-paired".equals(campaignKey)
                || "paired-import".equals(campaignKey)
                || isValidation(campaignKey)
                || isSensitivity(campaignKey);
    }

    private boolean isPairedImport(String campaignKey) {
        return "v1-paired".equals(campaignKey) || "paired-import".equals(campaignKey);
    }

    private boolean isSensitivity(String campaignKey) {
        return "sensitivity".equals(campaignKey) || "sensitivity-v1".equals(campaignKey);
    }

    private boolean isValidation(String campaignKey) {
        return "validation".equals(campaignKey) || "validation-v1".equals(campaignKey);
    }

    private String basename(String campaignKey) {
        if (isPairedImport(campaignKey)) {
            return "constitutional-review-paired-import-v1";
        }
        if (isSensitivity(campaignKey)) {
            return "constitutional-review-sensitivity-v1";
        }
        if (isValidation(campaignKey)) {
            return "constitutional-review-validation-v1";
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
        if (isValidation(campaignKey)) {
            return "Constitutional Review Calibration Validation Campaign v1";
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

    private List<CampaignCase> validationCases(WorldSpec baseSpec) {
        return List.of(
                new CampaignCase(
                        "benchmark-context",
                        "Shared benchmark context",
                        "Validation context compares each real-world preset against documented calibration target ranges using its country/context modifiers.",
                        baseSpec.withLegislativeConflict(0.48).withEmergencyPressure(0.32).withPublicTrust(0.56),
                        SignalMode.SYNTHETIC
                )
        );
    }

    private Map<String, WorldSpec> scenarioSpecs(
            WorldSpec baseSpec,
            List<Scenario> scenarios,
            boolean useContextProfiles
    ) throws IOException {
        if (!useContextProfiles || !Files.exists(DEFAULT_CONTEXT_PROFILES)) {
            return Map.of();
        }
        Map<String, ContextProfile> profiles = contextProfiles();
        Map<String, WorldSpec> specs = new LinkedHashMap<>();
        for (Scenario scenario : scenarios) {
            ContextProfile profile = profiles.get(scenario.key());
            if (profile != null && profile.applyInValidation()) {
                specs.put(scenario.key(), applyContext(baseSpec, profile));
            }
        }
        return specs;
    }

    private Map<String, ContextProfile> contextProfiles() throws IOException {
        Map<String, ContextProfile> profiles = new LinkedHashMap<>();
        if (!Files.exists(DEFAULT_CONTEXT_PROFILES)) {
            return profiles;
        }
        List<String> lines = Files.readAllLines(DEFAULT_CONTEXT_PROFILES);
        if (lines.isEmpty()) {
            return profiles;
        }
        List<String> header = parseCsvLine(lines.get(0));
        Map<String, Integer> columns = new LinkedHashMap<>();
        for (int i = 0; i < header.size(); i++) {
            columns.put(header.get(i), i);
        }
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }
            List<String> parts = parseCsvLine(line);
            ContextProfile profile = new ContextProfile(
                    calibrationValue(parts, columns, "scenarioKey", ""),
                    calibrationValue(parts, columns, "system", ""),
                    calibrationValue(parts, columns, "period", ""),
                    csvDouble(parts, columns, "publicTrust", 0.56),
                    csvDouble(parts, columns, "partisanPressure", 0.55),
                    csvDouble(parts, columns, "partyFragmentation", 0.46),
                    csvDouble(parts, columns, "governmentControl", 0.54),
                    csvDouble(parts, columns, "electoralTimePressure", 0.42),
                    csvDouble(parts, columns, "civilSocietyCapacity", 0.58),
                    csvDouble(parts, columns, "implementationCapacity", 0.62),
                    csvDouble(parts, columns, "legalTraditionCompatibility", 0.68),
                    csvDouble(parts, columns, "legislativeConflict", 0.48),
                    calibrationValue(parts, columns, "sourceFamily", ""),
                    calibrationValue(parts, columns, "sourceUrl", ""),
                    Boolean.parseBoolean(calibrationValue(parts, columns, "applyInValidation", "true")),
                    calibrationValue(parts, columns, "note", "")
            );
            if (!profile.scenarioKey().isBlank()) {
                profiles.put(profile.scenarioKey(), profile);
            }
        }
        return profiles;
    }

    private static WorldSpec applyContext(WorldSpec baseSpec, ContextProfile profile) {
        return baseSpec
                .withPublicTrust(profile.publicTrust())
                .withPartisanPressure(profile.partisanPressure())
                .withPartyFragmentation(profile.partyFragmentation())
                .withGovernmentControl(profile.governmentControl())
                .withElectoralTimePressure(profile.electoralTimePressure())
                .withCivilSocietyCapacity(profile.civilSocietyCapacity())
                .withImplementationCapacity(profile.implementationCapacity())
                .withLegalTraditionCompatibility(profile.legalTraditionCompatibility())
                .withLegislativeConflict(profile.legislativeConflict());
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
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,scenarioKind,reviewMechanism,totalCases,reviewedCases,invalidations,emergencyOrders,emergencyReliefs,meritsReviews,meritsInvalidations,overrides,intakeFilings,screenedFilings,directionalScore,reviewRate,intakeAcceptanceRate,emergencyReliefRate,meritsReviewRate,meritsInvalidationRate,emergencyReasonGivingRate,emergencyVoteDisclosureRate,emergencyPublicDisagreementRate,governmentEmergencyApplicantShare,governmentEmergencyWinRate,meritsFollowUpRate,legalStability,rightsProtection,partisanAlignment,shadowDocketAbuse,legitimacy,reversalRate,constitutionalConflict,democraticResponsiveness,legislativeResponseCredibility,caseSelectionAccess,governmentRepeatPlayerAdvantage,implementationCapacity,democraticConstitutionalism,vetoRelocationRisk,legalTransplantFeasibility,politicalCultureSensitivity,independenceAccountabilityBalance,concurrenceFragmentation,dissentIntensity,recusalRate,enBancRate,crossCheckRate,councilScreenRate,overrideRate,weakFormDeclarationRate,suspendedDeclarationRate,legislativeResponseRate,averageLegislativeResponseDelay,timelyLegislativeResponseRate,rightsImpactStatementRate,ombudsmanTriggerRate,publicDefenderParticipationRate,preEnactmentReviewRate,abstractReviewRate,preliminaryReferenceRate,appealRouteRate,directActionRate,lowerCourtConflict,averageTimeToReview,replacementRate,stateCaseShare,mixedJurisdictionShare,averageLowerCourtDepth,stateFederalTension,intercourtConflict,complianceRate,defianceRate,workaroundRate,repeatedLitigationRate,executiveImplementationRate,agencyNonacquiescenceRate,legislativeReenactmentRate,localGovernmentComplianceRate,publicTrust,legislativeConflict,courtCurbingPressure,amendmentPressure,administrativeLoad,directCourtCost,upstreamScreeningCost,capacityStrainCost,institutionalBudgetCost,institutionalDelayCost,implementationComplexity,totalInstitutionalCost\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            builder.append(csv(row.caseKey())).append(',')
                    .append(csv(row.caseName())).append(',')
                    .append(csv(row.caseDescription())).append(',')
                    .append(csv(report.scenarioKey())).append(',')
                    .append(csv(report.scenarioName())).append(',')
                    .append(csv(report.scenarioKind())).append(',')
                    .append(csv(report.reviewMechanism())).append(',')
                    .append(report.totalCases()).append(',')
                    .append(report.reviewedCases()).append(',')
                    .append(report.invalidations()).append(',')
                    .append(report.emergencyOrders()).append(',')
                    .append(report.emergencyReliefs()).append(',')
                    .append(report.meritsReviews()).append(',')
                    .append(report.meritsInvalidations()).append(',')
                    .append(report.overrides()).append(',')
                    .append(report.intakeFilings()).append(',')
                    .append(report.screenedFilings()).append(',')
                    .append(number(report.directionalScore())).append(',')
                    .append(number(report.reviewRate())).append(',')
                    .append(number(report.intakeAcceptanceRate())).append(',')
                    .append(number(report.emergencyReliefRate())).append(',')
                    .append(number(report.meritsReviewRate())).append(',')
                    .append(number(report.meritsInvalidationRate())).append(',')
                    .append(number(report.emergencyReasonGivingRate())).append(',')
                    .append(number(report.emergencyVoteDisclosureRate())).append(',')
                    .append(number(report.emergencyPublicDisagreementRate())).append(',')
                    .append(number(report.governmentEmergencyApplicantShare())).append(',')
                    .append(number(report.governmentEmergencyWinRate())).append(',')
                    .append(number(report.meritsFollowUpRate())).append(',')
                    .append(number(report.legalStability())).append(',')
                    .append(number(report.rightsProtection())).append(',')
                    .append(number(report.partisanAlignment())).append(',')
                    .append(number(report.shadowDocketAbuse())).append(',')
                    .append(number(report.legitimacy())).append(',')
                    .append(number(report.reversalRate())).append(',')
                    .append(number(report.constitutionalConflict())).append(',')
                    .append(number(report.democraticResponsiveness())).append(',')
                    .append(number(report.legislativeResponseCredibility())).append(',')
                    .append(number(report.caseSelectionAccess())).append(',')
                    .append(number(report.governmentRepeatPlayerAdvantage())).append(',')
                    .append(number(report.implementationCapacity())).append(',')
                    .append(number(report.democraticConstitutionalism())).append(',')
                    .append(number(report.vetoRelocationRisk())).append(',')
                    .append(number(report.legalTransplantFeasibility())).append(',')
                    .append(number(report.politicalCultureSensitivity())).append(',')
                    .append(number(report.independenceAccountabilityBalance())).append(',')
                    .append(number(report.concurrenceFragmentation())).append(',')
                    .append(number(report.dissentIntensity())).append(',')
                    .append(number(report.recusalRate())).append(',')
                    .append(number(report.enBancRate())).append(',')
                    .append(number(report.crossCheckRate())).append(',')
                    .append(number(report.councilScreenRate())).append(',')
                    .append(number(report.overrideRate())).append(',')
                    .append(number(report.weakFormDeclarationRate())).append(',')
                    .append(number(report.suspendedDeclarationRate())).append(',')
                    .append(number(report.legislativeResponseRate())).append(',')
                    .append(number(report.averageLegislativeResponseDelay())).append(',')
                    .append(number(report.timelyLegislativeResponseRate())).append(',')
                    .append(number(report.rightsImpactStatementRate())).append(',')
                    .append(number(report.ombudsmanTriggerRate())).append(',')
                    .append(number(report.publicDefenderParticipationRate())).append(',')
                    .append(number(report.preEnactmentReviewRate())).append(',')
                    .append(number(report.abstractReviewRate())).append(',')
                    .append(number(report.preliminaryReferenceRate())).append(',')
                    .append(number(report.appealRouteRate())).append(',')
                    .append(number(report.directActionRate())).append(',')
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
                    .append(number(report.administrativeLoad())).append(',')
                    .append(number(report.directCourtCost())).append(',')
                    .append(number(report.upstreamScreeningCost())).append(',')
                    .append(number(report.capacityStrainCost())).append(',')
                    .append(number(report.institutionalBudgetCost())).append(',')
                    .append(number(report.institutionalDelayCost())).append(',')
                    .append(number(report.implementationComplexity())).append(',')
                    .append(number(report.totalInstitutionalCost()))
                    .append('\n');
        }
        Files.writeString(path, builder.toString());
    }

    private void writeSegmentCsv(Path path, List<CampaignRow> rows, SegmentKind kind) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,scenarioKind,reviewMechanism,segmentType,segmentKey,totalCases,reviewedCases,intakeFilings,screenedFilings,reviewRate,intakeAcceptanceRate,legalStability,rightsProtection,shadowDocketAbuse,emergencyReliefRate,meritsInvalidationRate,emergencyReasonGivingRate,emergencyVoteDisclosureRate,emergencyPublicDisagreementRate,governmentEmergencyWinRate,meritsFollowUpRate,lowerCourtConflict,averageTimeToReview,averageLowerCourtDepth,stateFederalTension,intercourtConflict,legitimacy,constitutionalConflict,democraticResponsiveness,legislativeResponseCredibility,caseSelectionAccess,governmentRepeatPlayerAdvantage,implementationCapacity,democraticConstitutionalism,vetoRelocationRisk,legalTransplantFeasibility,politicalCultureSensitivity,complianceRate,defianceRate,workaroundRate,repeatedLitigationRate,executiveImplementationRate,agencyNonacquiescenceRate,legislativeReenactmentRate,localGovernmentComplianceRate,publicTrust,legislativeConflict,courtCurbingPressure,amendmentPressure,directCourtCost,upstreamScreeningCost,capacityStrainCost,institutionalBudgetCost,institutionalDelayCost,implementationComplexity,totalInstitutionalCost\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            for (SegmentReport segment : segments(row, kind)) {
                builder.append(csv(row.caseKey())).append(',')
                        .append(csv(row.caseName())).append(',')
                        .append(csv(row.caseDescription())).append(',')
                        .append(csv(report.scenarioKey())).append(',')
                        .append(csv(report.scenarioName())).append(',')
                        .append(csv(report.scenarioKind())).append(',')
                        .append(csv(report.reviewMechanism())).append(',')
                        .append(csv(segment.segmentType())).append(',')
                        .append(csv(segment.segmentKey())).append(',')
                        .append(segment.totalCases()).append(',')
                        .append(segment.reviewedCases()).append(',')
                        .append(segment.intakeFilings()).append(',')
                        .append(segment.screenedFilings()).append(',')
                        .append(number(segment.reviewRate())).append(',')
                        .append(number(segment.intakeAcceptanceRate())).append(',')
                        .append(number(segment.legalStability())).append(',')
                        .append(number(segment.rightsProtection())).append(',')
                        .append(number(segment.shadowDocketAbuse())).append(',')
                        .append(number(segment.emergencyReliefRate())).append(',')
                        .append(number(segment.meritsInvalidationRate())).append(',')
                        .append(number(segment.emergencyReasonGivingRate())).append(',')
                        .append(number(segment.emergencyVoteDisclosureRate())).append(',')
                        .append(number(segment.emergencyPublicDisagreementRate())).append(',')
                        .append(number(segment.governmentEmergencyWinRate())).append(',')
                        .append(number(segment.meritsFollowUpRate())).append(',')
                        .append(number(segment.lowerCourtConflict())).append(',')
                        .append(number(segment.averageTimeToReview())).append(',')
                        .append(number(segment.averageLowerCourtDepth())).append(',')
                        .append(number(segment.stateFederalTension())).append(',')
                        .append(number(segment.intercourtConflict())).append(',')
                        .append(number(segment.legitimacy())).append(',')
                        .append(number(segment.constitutionalConflict())).append(',')
                        .append(number(segment.democraticResponsiveness())).append(',')
                        .append(number(segment.legislativeResponseCredibility())).append(',')
                        .append(number(segment.caseSelectionAccess())).append(',')
                        .append(number(segment.governmentRepeatPlayerAdvantage())).append(',')
                        .append(number(segment.implementationCapacity())).append(',')
                        .append(number(segment.democraticConstitutionalism())).append(',')
                        .append(number(segment.vetoRelocationRisk())).append(',')
                        .append(number(segment.legalTransplantFeasibility())).append(',')
                        .append(number(segment.politicalCultureSensitivity())).append(',')
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
                        .append(number(segment.amendmentPressure())).append(',')
                        .append(number(segment.directCourtCost())).append(',')
                        .append(number(segment.upstreamScreeningCost())).append(',')
                        .append(number(segment.capacityStrainCost())).append(',')
                        .append(number(segment.institutionalBudgetCost())).append(',')
                        .append(number(segment.institutionalDelayCost())).append(',')
                        .append(number(segment.implementationComplexity())).append(',')
                        .append(number(segment.totalInstitutionalCost()))
                        .append('\n');
            }
        }
        Files.writeString(path, builder.toString());
    }

    private void writeCompositionCsv(Path path, List<CampaignRow> rows) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,scenarioKind,reviewMechanism,segmentType,segmentKey,observations,courtSize,medianIdeology,ideologicalSpread,meanPartisanAttachment,meanRightsSensitivity,meanInstitutionalism,replacementPressure,estimatedReplacementEvents\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            for (CompositionReport composition : report.compositionReports()) {
                builder.append(csv(row.caseKey())).append(',')
                        .append(csv(row.caseName())).append(',')
                        .append(csv(row.caseDescription())).append(',')
                        .append(csv(report.scenarioKey())).append(',')
                        .append(csv(report.scenarioName())).append(',')
                        .append(csv(report.scenarioKind())).append(',')
                        .append(csv(report.reviewMechanism())).append(',')
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
        builder.append("profileKey,court,timePeriod,targetKey,label,sourceName,sourceUrl,observedValue,lowerBound,upperBound,unit,targetN,targetMethod,reliability,useForValidation,modelObservedValue,lower95,upper95,withinTarget,gap,n,method,note,targetFile\n");
        for (CalibrationRow row : rows) {
            Interval interval = interval(row.observedValue(), row.sampleSize(), 0.0, 1.0);
            builder.append(csv(row.target().profileKey())).append(',')
                    .append(csv(row.target().court())).append(',')
                    .append(csv(row.target().timePeriod())).append(',')
                    .append(csv(row.target().key())).append(',')
                    .append(csv(row.target().label())).append(',')
                    .append(csv(row.target().sourceName())).append(',')
                    .append(csv(row.target().sourceUrl())).append(',')
                    .append(numberOrBlank(row.target().observedValue())).append(',')
                    .append(number(row.target().lowerBound())).append(',')
                    .append(number(row.target().upperBound())).append(',')
                    .append(csv(row.target().unit())).append(',')
                    .append(row.target().sampleSize()).append(',')
                    .append(csv(row.target().method())).append(',')
                    .append(csv(row.target().reliability())).append(',')
                    .append(row.target().useForValidation()).append(',')
                    .append(number(row.observedValue())).append(',')
                    .append(number(interval.lower())).append(',')
                    .append(number(interval.upper())).append(',')
                    .append(row.withinTarget()).append(',')
                    .append(number(row.gap())).append(',')
                    .append(row.sampleSize()).append(',')
                    .append(csv(INTERVAL_METHOD)).append(',')
                    .append(csv(row.target().note())).append(',')
                    .append(csv(row.target().targetFile()))
                    .append('\n');
        }
        Files.writeString(path, builder.toString());
    }

    private void writeCaseCsv(Path path, List<CampaignRow> rows) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new GZIPOutputStream(Files.newOutputStream(path)),
                StandardCharsets.UTF_8
        ))) {
            writer.write("caseKey,caseName,caseDescription,scenarioKey,scenario,scenarioKind,reviewMechanism,runIndex,caseIndex,globalCaseIndex,caseId,source,reviewPeriod,caseType,doctrineArea,policyDomain,jurisdiction,lowerCourtPath,policyPosition,rightsThreat,publicSupport,legislativeMandate,urgency,legalAmbiguity,constitutionalSalience,lowerCourtConflict,lowerCourtPanelSkew,stateFederalTension,intercourtConflict,certiorariPressure,timeToReview,lowerCourtGovernmentWin,executivePressure,conflictOfInterestRisk,casePublicTrust,litigantCapacity,publicInterestSupport,governmentRepeatPlayerAdvantage,reviewed,emergencyOrder,emergencyReliefGranted,meritsReview,meritsInvalidated,invalidated,lawEffectiveAfterReview,intakeFilings,screenedFilings,intakeAcceptanceRate,reasonsGiven,voteDisclosed,publicDisagreement,emergencyApplicantType,governmentEmergencyApplicant,governmentEmergencyWin,meritsFollowUp,enBancReview,crossChecked,councilScreen,overrideUsed,weakFormDeclaration,suspendedDeclaration,legislativeResponse,legislativeResponseDelay,legislativeResponseDeadline,timelyLegislativeResponse,rightsImpactStatement,ombudsmanTriggered,publicDefenderParticipation,preEnactmentReview,abstractReview,supranationalRoute,preliminaryReferenceRoute,appealRoute,directActionRoute,recusedJustices,participatingJustices,strikeVoteShare,majorityShare,legalStability,rightsProtection,partisanAlignment,shadowDocketAbuse,legitimacy,reversalMagnitude,constitutionalConflict,democraticResponsiveness,legislativeResponseCredibility,caseSelectionAccess,implementationCapacity,democraticConstitutionalism,vetoRelocationRisk,legalTransplantFeasibility,politicalCultureSensitivity,independenceAccountabilityBalance,complianceRate,complied,defied,workaround,repeatedLitigation,executiveImplementation,agencyNonacquiescence,legislativeReenactment,localGovernmentCompliance,publicTrustAfter,legislativeConflictAfter,courtCurbingPressure,amendmentPressure,concurrenceFragmentation,dissentIntensity,replacementPressure,administrativeLoad,directCourtCost,upstreamScreeningCost,capacityStrainCost,institutionalBudgetCost,institutionalDelayCost,implementationComplexity,totalInstitutionalCost\n");
            for (CampaignRow row : rows) {
                for (int outcomeIndex = 0; outcomeIndex < row.outcomes().size(); outcomeIndex++) {
                    CaseOutcome outcome = row.outcomes().get(outcomeIndex);
                    int runIndex = row.casesPerRun() == 0 ? 0 : outcomeIndex / row.casesPerRun();
                    int caseIndex = row.casesPerRun() == 0 ? outcomeIndex : outcomeIndex % row.casesPerRun();
                    var caseFile = outcome.caseFile();
                    writer.write(String.join(",",
                            csv(row.caseKey()),
                            csv(row.caseName()),
                            csv(row.caseDescription()),
                            csv(row.report().scenarioKey()),
                            csv(row.report().scenarioName()),
                            csv(row.report().scenarioKind()),
                            csv(row.report().reviewMechanism()),
                            Integer.toString(runIndex + 1),
                            Integer.toString(caseIndex + 1),
                            Integer.toString(outcomeIndex + 1),
                            csv(caseFile.id()),
                            csv(caseFile.source()),
                            Integer.toString(caseFile.reviewPeriod() + 1),
                            csv(caseFile.type().name().toLowerCase(Locale.ROOT)),
                            csv(caseFile.doctrineArea().name().toLowerCase(Locale.ROOT)),
                            csv(caseFile.policyDomain().key()),
                            csv(caseFile.jurisdiction().key()),
                            csv(caseFile.lowerCourtPath().key()),
                            number(caseFile.policyPosition()),
                            number(caseFile.rightsThreat()),
                            number(caseFile.publicSupport()),
                            number(caseFile.legislativeMandate()),
                            number(caseFile.urgency()),
                            number(caseFile.legalAmbiguity()),
                            number(caseFile.constitutionalSalience()),
                            number(caseFile.lowerCourtConflict()),
                            number(caseFile.lowerCourtPanelSkew()),
                            number(caseFile.stateFederalTension()),
                            number(caseFile.intercourtConflict()),
                            number(caseFile.certiorariPressure()),
                            number(caseFile.timeToReview()),
                            Boolean.toString(caseFile.lowerCourtGovernmentWin()),
                            number(caseFile.executivePressure()),
                            number(caseFile.conflictOfInterestRisk()),
                            number(caseFile.publicTrust()),
                            number(caseFile.litigantCapacity()),
                            number(caseFile.publicInterestSupport()),
                            number(caseFile.governmentRepeatPlayerAdvantage()),
                            Boolean.toString(outcome.reviewed()),
                            Boolean.toString(outcome.emergencyOrder()),
                            Boolean.toString(outcome.emergencyReliefGranted()),
                            Boolean.toString(outcome.meritsReview()),
                            Boolean.toString(outcome.meritsInvalidated()),
                            Boolean.toString(outcome.invalidated()),
                            Boolean.toString(outcome.lawEffectiveAfterReview()),
                            Integer.toString(outcome.intakeFilings()),
                            Integer.toString(outcome.screenedFilings()),
                            number(outcome.intakeAcceptanceRate()),
                            Boolean.toString(outcome.reasonsGiven()),
                            Boolean.toString(outcome.voteDisclosed()),
                            Boolean.toString(outcome.publicDisagreement()),
                            csv(outcome.emergencyApplicantType()),
                            Boolean.toString(outcome.governmentEmergencyApplicant()),
                            Boolean.toString(outcome.governmentEmergencyWin()),
                            Boolean.toString(outcome.meritsFollowUp()),
                            Boolean.toString(outcome.enBancReview()),
                            Boolean.toString(outcome.crossChecked()),
                            Boolean.toString(outcome.councilScreen()),
                            Boolean.toString(outcome.overrideUsed()),
                            Boolean.toString(outcome.weakFormDeclaration()),
                            Boolean.toString(outcome.suspendedDeclaration()),
                            Boolean.toString(outcome.legislativeResponse()),
                            number(outcome.legislativeResponseDelay()),
                            number(outcome.legislativeResponseDeadline()),
                            Boolean.toString(outcome.timelyLegislativeResponse()),
                            Boolean.toString(outcome.rightsImpactStatement()),
                            Boolean.toString(outcome.ombudsmanTriggered()),
                            Boolean.toString(outcome.publicDefenderParticipation()),
                            Boolean.toString(outcome.preEnactmentReview()),
                            Boolean.toString(outcome.abstractReview()),
                            csv(outcome.supranationalRoute()),
                            Boolean.toString(outcome.preliminaryReferenceRoute()),
                            Boolean.toString(outcome.appealRoute()),
                            Boolean.toString(outcome.directActionRoute()),
                            Integer.toString(outcome.recusedJustices()),
                            Integer.toString(outcome.participatingJustices()),
                            number(outcome.strikeVoteShare()),
                            number(outcome.majorityShare()),
                            number(outcome.legalStability()),
                            number(outcome.rightsProtection()),
                            number(outcome.partisanAlignment()),
                            number(outcome.shadowDocketAbuse()),
                            number(outcome.legitimacy()),
                            number(outcome.reversalMagnitude()),
                            number(outcome.constitutionalConflict()),
                            number(outcome.democraticResponsiveness()),
                            number(outcome.legislativeResponseCredibility()),
                            number(outcome.caseSelectionAccess()),
                            number(outcome.implementationCapacity()),
                            number(outcome.democraticConstitutionalism()),
                            number(outcome.vetoRelocationRisk()),
                            number(outcome.legalTransplantFeasibility()),
                            number(outcome.politicalCultureSensitivity()),
                            number(outcome.independenceAccountabilityBalance()),
                            number(outcome.complianceRate()),
                            Boolean.toString(outcome.complied()),
                            Boolean.toString(outcome.defied()),
                            Boolean.toString(outcome.workaround()),
                            Boolean.toString(outcome.repeatedLitigation()),
                            Boolean.toString(outcome.executiveImplementation()),
                            Boolean.toString(outcome.agencyNonacquiescence()),
                            Boolean.toString(outcome.legislativeReenactment()),
                            Boolean.toString(outcome.localGovernmentCompliance()),
                            number(outcome.publicTrustAfter()),
                            number(outcome.legislativeConflictAfter()),
                            number(outcome.courtCurbingPressure()),
                            number(outcome.amendmentPressure()),
                            number(outcome.concurrenceFragmentation()),
                            number(outcome.dissentIntensity()),
                            number(outcome.replacementPressure()),
                            number(outcome.administrativeLoad()),
                            number(outcome.directCourtCost()),
                            number(outcome.upstreamScreeningCost()),
                            number(outcome.capacityStrainCost()),
                            number(outcome.institutionalBudgetCost()),
                            number(outcome.institutionalDelayCost()),
                            number(outcome.implementationComplexity()),
                            number(outcome.totalInstitutionalCost())
                    ));
                    writer.write('\n');
                }
            }
        }
    }

    private Map<CampaignRow, BootstrapSummary> bootstrapSummaries(List<CampaignRow> rows) {
        Map<CampaignRow, BootstrapSummary> summaries = new LinkedHashMap<>();
        for (CampaignRow row : rows) {
            summaries.put(row, bootstrapSummary(row));
        }
        return summaries;
    }

    private BootstrapSummary bootstrapSummary(CampaignRow row) {
        if (row.outcomes().isEmpty() || row.runs() <= 1 || row.casesPerRun() <= 0) {
            return BootstrapSummary.empty();
        }
        List<List<CaseOutcome>> runBlocks = runBlocks(row);
        if (runBlocks.size() <= 1) {
            return BootstrapSummary.empty();
        }
        Map<String, List<Double>> reportSamples = new LinkedHashMap<>();
        for (ReportIntervalMetric metric : reportIntervalMetrics()) {
            reportSamples.put(metric.key(), new ArrayList<>());
        }
        Map<SegmentBootstrapKey, List<Double>> segmentSamples = new LinkedHashMap<>();
        for (SegmentKind kind : SegmentKind.values()) {
            for (SegmentReport segment : segments(row, kind)) {
                for (SegmentIntervalMetric metric : segmentIntervalMetrics()) {
                    segmentSamples.put(new SegmentBootstrapKey(kind, segment.segmentKey(), metric.key()), new ArrayList<>());
                }
            }
        }

        Random random = new Random(bootstrapSeed(row));
        for (int sample = 0; sample < BOOTSTRAP_SAMPLES; sample++) {
            MetricsAccumulator accumulator = new MetricsAccumulator();
            for (int run = 0; run < runBlocks.size(); run++) {
                List<CaseOutcome> block = runBlocks.get(random.nextInt(runBlocks.size()));
                for (CaseOutcome outcome : block) {
                    accumulator.add(outcome);
                }
            }
            ScenarioReport sampledReport = accumulator.toReport(
                    row.report().scenarioKey(),
                    row.report().scenarioName(),
                    row.report().scenarioKind(),
                    row.report().reviewMechanism()
            );
            for (ReportIntervalMetric metric : reportIntervalMetrics()) {
                reportSamples.get(metric.key()).add(metric.value().value(sampledReport));
            }
            for (SegmentKind kind : SegmentKind.values()) {
                Map<String, SegmentReport> sampledSegments = segmentMap(sampledReport, kind);
                for (SegmentReport actualSegment : segments(row, kind)) {
                    SegmentReport sampledSegment = sampledSegments.get(actualSegment.segmentKey());
                    if (sampledSegment == null) {
                        continue;
                    }
                    for (SegmentIntervalMetric metric : segmentIntervalMetrics()) {
                        SegmentBootstrapKey key = new SegmentBootstrapKey(kind, actualSegment.segmentKey(), metric.key());
                        segmentSamples.get(key).add(metric.value().value(sampledSegment));
                    }
                }
            }
        }

        Map<String, Interval> reportIntervals = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : reportSamples.entrySet()) {
            reportIntervals.put(entry.getKey(), percentileInterval(entry.getValue()));
        }
        Map<SegmentBootstrapKey, Interval> segmentIntervals = new LinkedHashMap<>();
        for (Map.Entry<SegmentBootstrapKey, List<Double>> entry : segmentSamples.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                segmentIntervals.put(entry.getKey(), percentileInterval(entry.getValue()));
            }
        }
        return new BootstrapSummary(reportIntervals, segmentIntervals);
    }

    private static List<List<CaseOutcome>> runBlocks(CampaignRow row) {
        List<List<CaseOutcome>> blocks = new ArrayList<>();
        int casesPerRun = row.casesPerRun();
        for (int start = 0; start < row.outcomes().size(); start += casesPerRun) {
            int end = Math.min(start + casesPerRun, row.outcomes().size());
            blocks.add(row.outcomes().subList(start, end));
        }
        return blocks;
    }

    private static long bootstrapSeed(CampaignRow row) {
        return Objects.hash(row.caseKey(), row.report().scenarioKey(), row.casesPerRun(), row.runs()) * 1_000_003L;
    }

    private static Map<String, SegmentReport> segmentMap(ScenarioReport report, SegmentKind kind) {
        Map<String, SegmentReport> segments = new LinkedHashMap<>();
        for (SegmentReport segment : switch (kind) {
            case PERIOD -> report.periodReports();
            case DOCTRINE -> report.doctrineReports();
            case PIPELINE -> report.pipelineReports();
            case POLICY_DOMAIN -> report.policyDomainReports();
        }) {
            segments.put(segment.segmentKey(), segment);
        }
        return segments;
    }

    private static Interval percentileInterval(List<Double> values) {
        if (values.isEmpty()) {
            return new Interval(0.0, 0.0);
        }
        List<Double> sorted = values.stream().sorted().toList();
        return new Interval(percentile(sorted, 0.025), percentile(sorted, 0.975));
    }

    private static double percentile(List<Double> sorted, double p) {
        if (sorted.size() == 1) {
            return sorted.get(0);
        }
        double position = p * (sorted.size() - 1);
        int lower = (int) Math.floor(position);
        int upper = (int) Math.ceil(position);
        if (lower == upper) {
            return sorted.get(lower);
        }
        double fraction = position - lower;
        return sorted.get(lower) * (1.0 - fraction) + sorted.get(upper) * fraction;
    }

    private void writeCampaignIntervalCsv(Path path, List<CampaignRow> rows, Map<CampaignRow, BootstrapSummary> bootstrapSummaries) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,metric,estimate,lower95,upper95,n,method\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            BootstrapSummary summary = bootstrapSummaries.getOrDefault(row, BootstrapSummary.empty());
            for (ReportIntervalMetric metric : reportIntervalMetrics()) {
                Interval interval = summary.reportInterval(metric.key())
                        .orElseGet(() -> interval(metric.value().value(report), metric.sampleSize().value(report), metric.minimum(), metric.maximum()));
                builder.append(csv(row.caseKey())).append(',')
                        .append(csv(row.caseName())).append(',')
                        .append(csv(row.caseDescription())).append(',')
                        .append(csv(report.scenarioKey())).append(',')
                        .append(csv(report.scenarioName())).append(',')
                        .append(csv(metric.key())).append(',')
                        .append(number(metric.value().value(report))).append(',')
                        .append(number(interval.lower())).append(',')
                        .append(number(interval.upper())).append(',')
                        .append(metric.sampleSize().value(report)).append(',')
                        .append(csv(summary.hasReportInterval(metric.key()) ? BOOTSTRAP_METHOD : INTERVAL_METHOD))
                        .append('\n');
            }
        }
        Files.writeString(path, builder.toString());
    }

    private void writeSegmentIntervalCsv(
            Path path,
            List<CampaignRow> rows,
            SegmentKind kind,
            Map<CampaignRow, BootstrapSummary> bootstrapSummaries
    ) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,segmentType,segmentKey,metric,estimate,lower95,upper95,n,method\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            BootstrapSummary summary = bootstrapSummaries.getOrDefault(row, BootstrapSummary.empty());
            for (SegmentReport segment : segments(row, kind)) {
                for (SegmentIntervalMetric metric : segmentIntervalMetrics()) {
                    Interval interval = summary.segmentInterval(kind, segment.segmentKey(), metric.key())
                            .orElseGet(() -> interval(metric.value().value(segment), metric.sampleSize().value(segment), metric.minimum(), metric.maximum()));
                    builder.append(csv(row.caseKey())).append(',')
                            .append(csv(row.caseName())).append(',')
                            .append(csv(row.caseDescription())).append(',')
                            .append(csv(report.scenarioKey())).append(',')
                            .append(csv(report.scenarioName())).append(',')
                            .append(csv(segment.segmentType())).append(',')
                            .append(csv(segment.segmentKey())).append(',')
                            .append(csv(metric.key())).append(',')
                            .append(number(metric.value().value(segment))).append(',')
                            .append(number(interval.lower())).append(',')
                            .append(number(interval.upper())).append(',')
                            .append(metric.sampleSize().value(segment)).append(',')
                            .append(csv(summary.hasSegmentInterval(kind, segment.segmentKey(), metric.key()) ? BOOTSTRAP_METHOD : INTERVAL_METHOD))
                            .append('\n');
                }
            }
        }
        Files.writeString(path, builder.toString());
    }

    private void writeCompositionIntervalCsv(Path path, List<CampaignRow> rows) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("caseKey,caseName,caseDescription,scenarioKey,scenario,segmentType,segmentKey,metric,estimate,lower95,upper95,n,method\n");
        for (CampaignRow row : rows) {
            ScenarioReport report = row.report();
            for (CompositionReport composition : report.compositionReports()) {
                for (CompositionIntervalMetric metric : compositionIntervalMetrics()) {
                    Interval interval = interval(metric.value().value(composition), composition.observations(), metric.minimum(), metric.maximum());
                    builder.append(csv(row.caseKey())).append(',')
                            .append(csv(row.caseName())).append(',')
                            .append(csv(row.caseDescription())).append(',')
                            .append(csv(report.scenarioKey())).append(',')
                            .append(csv(report.scenarioName())).append(',')
                            .append(csv(composition.segmentType())).append(',')
                            .append(csv(composition.segmentKey())).append(',')
                            .append(csv(metric.key())).append(',')
                            .append(number(metric.value().value(composition))).append(',')
                            .append(number(interval.lower())).append(',')
                            .append(number(interval.upper())).append(',')
                            .append(composition.observations()).append(',')
                            .append(csv(INTERVAL_METHOD))
                            .append('\n');
                }
            }
        }
        Files.writeString(path, builder.toString());
    }

    private void writeCalibrationIntervalCsv(Path path, List<CalibrationRow> rows) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("profileKey,court,timePeriod,targetKey,label,estimate,lower95,upper95,targetLower,targetUpper,targetObservedValue,targetN,unit,targetMethod,reliability,useForValidation,n,method,sourceName,sourceUrl\n");
        for (CalibrationRow row : rows) {
            Interval interval = interval(row.observedValue(), row.sampleSize(), 0.0, 1.0);
            builder.append(csv(row.target().profileKey())).append(',')
                    .append(csv(row.target().court())).append(',')
                    .append(csv(row.target().timePeriod())).append(',')
                    .append(csv(row.target().key())).append(',')
                    .append(csv(row.target().label())).append(',')
                    .append(number(row.observedValue())).append(',')
                    .append(number(interval.lower())).append(',')
                    .append(number(interval.upper())).append(',')
                    .append(number(row.target().lowerBound())).append(',')
                    .append(number(row.target().upperBound())).append(',')
                    .append(numberOrBlank(row.target().observedValue())).append(',')
                    .append(row.target().sampleSize()).append(',')
                    .append(csv(row.target().unit())).append(',')
                    .append(csv(row.target().method())).append(',')
                    .append(csv(row.target().reliability())).append(',')
                    .append(row.target().useForValidation()).append(',')
                    .append(row.sampleSize()).append(',')
                    .append(csv(INTERVAL_METHOD)).append(',')
                    .append(csv(row.target().sourceName())).append(',')
                    .append(csv(row.target().sourceUrl()))
                    .append('\n');
        }
        Files.writeString(path, builder.toString());
    }

    private void writeMarkdown(
            Path path,
            List<CampaignRow> rows,
            int runs,
            long seed,
            String inputDescription,
            String reportName,
            List<CalibrationRow> calibrationRows
    ) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("# ").append(reportName).append("\n\n");
        builder.append("- runs per case: ").append(runs).append('\n');
        builder.append("- seed: ").append(seed).append('\n');
        builder.append("- input: ").append(inputDescription).append("\n\n");
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
        builder.append("| Scenario | Kind | Mechanism | Score | Dem. const. | Stability | Rights | Partisan | Shadow | Intake | Emerg. relief | Reasons | Disagree | Merits inval. | Legitimacy | Reversal | Conflict | Response | Resp. cred. | Access | Gov. adv. | Impl. cap. | Veto reloc. | Transplant | Culture sens. | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Depth | St/Fed | Admin | Direct | Upstream | Capacity | Cost |\n");
        builder.append("| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
        for (String scenarioKey : rows.stream().map(row -> row.report().scenarioKey()).distinct().toList()) {
            List<ScenarioReport> reports = rows.stream()
                    .filter(row -> row.report().scenarioKey().equals(scenarioKey))
                    .map(CampaignRow::report)
                    .toList();
            ScenarioReport first = reports.get(0);
            builder.append("| ").append(first.scenarioName()).append(" | ")
                    .append(first.scenarioKind()).append(" | ")
                    .append(first.reviewMechanism()).append(" | ")
                    .append(number(average(reports, ScenarioReport::directionalScore))).append(" | ")
                    .append(number(average(reports, ScenarioReport::democraticConstitutionalism))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legalStability))).append(" | ")
                    .append(number(average(reports, ScenarioReport::rightsProtection))).append(" | ")
                    .append(number(average(reports, ScenarioReport::partisanAlignment))).append(" | ")
                    .append(number(average(reports, ScenarioReport::shadowDocketAbuse))).append(" | ")
                    .append(number(average(reports, ScenarioReport::intakeAcceptanceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::emergencyReliefRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::emergencyReasonGivingRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::emergencyPublicDisagreementRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::meritsInvalidationRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legitimacy))).append(" | ")
                    .append(number(average(reports, ScenarioReport::reversalRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::constitutionalConflict))).append(" | ")
                    .append(number(average(reports, ScenarioReport::democraticResponsiveness))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legislativeResponseCredibility))).append(" | ")
                    .append(number(average(reports, ScenarioReport::caseSelectionAccess))).append(" | ")
                    .append(number(average(reports, ScenarioReport::governmentRepeatPlayerAdvantage))).append(" | ")
                    .append(number(average(reports, ScenarioReport::implementationCapacity))).append(" | ")
                    .append(number(average(reports, ScenarioReport::vetoRelocationRisk))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legalTransplantFeasibility))).append(" | ")
                    .append(number(average(reports, ScenarioReport::politicalCultureSensitivity))).append(" | ")
                    .append(number(average(reports, ScenarioReport::complianceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::executiveImplementationRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::agencyNonacquiescenceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legislativeReenactmentRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::localGovernmentComplianceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::averageLowerCourtDepth))).append(" | ")
                    .append(number(average(reports, ScenarioReport::stateFederalTension))).append(" | ")
                    .append(number(average(reports, ScenarioReport::administrativeLoad))).append(" | ")
                    .append(number(average(reports, ScenarioReport::directCourtCost))).append(" | ")
                    .append(number(average(reports, ScenarioReport::upstreamScreeningCost))).append(" | ")
                    .append(number(average(reports, ScenarioReport::capacityStrainCost))).append(" | ")
                    .append(number(average(reports, ScenarioReport::totalInstitutionalCost))).append(" |\n");
        }
        appendMechanismDiagnostics(builder, rows);
        appendSegmentDiagnostics(builder, rows, "Period Diagnostics", SegmentKind.PERIOD);
        appendSegmentDiagnostics(builder, rows, "Doctrine Diagnostics", SegmentKind.DOCTRINE);
        appendSegmentDiagnostics(builder, rows, "Pipeline Diagnostics", SegmentKind.PIPELINE);
        appendSegmentDiagnostics(builder, rows, "Policy Domain Diagnostics", SegmentKind.POLICY_DOMAIN);
        appendCompositionDiagnostics(builder, rows);
        appendUncertaintySummary(builder, rows);
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
        builder.append("| Scenario | Segment | Cases | Review | Intake | Rights | Dem. const. | Resp. cred. | Access | Gov. adv. | Impl. cap. | Veto reloc. | Transplant | Culture sens. | Shadow | Reasons | Disagree | Merits inval. | Depth | St/Fed | Intercourt | Compliance | Exec impl. | Agency nonaq. | Reenact. | Local comp. | Trust | Conflict | Curbing | Cost |\n");
        builder.append("| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
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
                        .append(number(segmentAverage(reports, SegmentReport::intakeAcceptanceRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::rightsProtection))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::democraticConstitutionalism))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::legislativeResponseCredibility))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::caseSelectionAccess))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::governmentRepeatPlayerAdvantage))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::implementationCapacity))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::vetoRelocationRisk))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::legalTransplantFeasibility))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::politicalCultureSensitivity))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::shadowDocketAbuse))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::emergencyReasonGivingRate))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::emergencyPublicDisagreementRate))).append(" | ")
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
                        .append(number(segmentAverage(reports, SegmentReport::courtCurbingPressure))).append(" | ")
                        .append(number(segmentAverage(reports, SegmentReport::totalInstitutionalCost))).append(" |\n");
            }
        }
    }

    private void appendMechanismDiagnostics(StringBuilder builder, List<CampaignRow> rows) {
        builder.append("\n## Mechanism Diagnostics\n\n");
        builder.append("| Scenario | Kind | Mechanism | Weak decl. | Susp. decl. | Leg. response | Resp. cred. | Rights stmt. | Ombudsman | Pub. defender | Pre-enact. | Abstract | Prelim. ref. | Appeal route | Direct action | Access | Impl. cap. | Dem. const. | Veto reloc. | Transplant | Culture sens. |\n");
        builder.append("| --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |\n");
        for (String scenarioKey : rows.stream().map(row -> row.report().scenarioKey()).distinct().toList()) {
            List<ScenarioReport> reports = rows.stream()
                    .filter(row -> row.report().scenarioKey().equals(scenarioKey))
                    .map(CampaignRow::report)
                    .toList();
            ScenarioReport first = reports.get(0);
            builder.append("| ").append(first.scenarioName()).append(" | ")
                    .append(first.scenarioKind()).append(" | ")
                    .append(first.reviewMechanism()).append(" | ")
                    .append(number(average(reports, ScenarioReport::weakFormDeclarationRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::suspendedDeclarationRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legislativeResponseRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legislativeResponseCredibility))).append(" | ")
                    .append(number(average(reports, ScenarioReport::rightsImpactStatementRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::ombudsmanTriggerRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::publicDefenderParticipationRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::preEnactmentReviewRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::abstractReviewRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::preliminaryReferenceRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::appealRouteRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::directActionRate))).append(" | ")
                    .append(number(average(reports, ScenarioReport::caseSelectionAccess))).append(" | ")
                    .append(number(average(reports, ScenarioReport::implementationCapacity))).append(" | ")
                    .append(number(average(reports, ScenarioReport::democraticConstitutionalism))).append(" | ")
                    .append(number(average(reports, ScenarioReport::vetoRelocationRisk))).append(" | ")
                    .append(number(average(reports, ScenarioReport::legalTransplantFeasibility))).append(" | ")
                    .append(number(average(reports, ScenarioReport::politicalCultureSensitivity))).append(" |\n");
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

    private void appendUncertaintySummary(StringBuilder builder, List<CampaignRow> rows) {
        builder.append("\n## Uncertainty Diagnostics\n\n");
        builder.append("Campaign and segment CSV artifacts include 95% uncertainty bands using `")
                .append(BOOTSTRAP_METHOD)
                .append("` from the compressed case-level export. The bootstrap resamples whole generated-world run blocks, preserving within-run case dependence. Composition and calibration interval artifacts still use `")
                .append(INTERVAL_METHOD)
                .append("` when no case-level analogue exists.\n\n");
        builder.append("| Scenario | Median score band width | Median cost band width |\n");
        builder.append("| --- | ---: | ---: |\n");
        for (String scenarioKey : rows.stream().map(row -> row.report().scenarioKey()).distinct().toList()) {
            List<CampaignRow> scenarioRows = rows.stream()
                    .filter(row -> row.report().scenarioKey().equals(scenarioKey))
                    .toList();
            ScenarioReport first = scenarioRows.get(0).report();
            builder.append("| ").append(first.scenarioName()).append(" | ")
                    .append(number(medianIntervalWidth(scenarioRows, ScenarioReport::directionalScore, 0.0, 1.0))).append(" | ")
                    .append(number(medianIntervalWidth(scenarioRows, ScenarioReport::totalInstitutionalCost, 0.0, 1.0))).append(" |\n");
        }
    }

    private void appendCalibrationDiagnostics(StringBuilder builder, List<CalibrationRow> rows) {
        builder.append("\n## Calibration Diagnostics\n\n");
        builder.append("| Profile | Target | Model | Empirical | 95% band | Range | Reliability | Validation | Gap | Status |\n");
        builder.append("| --- | --- | ---: | ---: | ---: | ---: | --- | ---: | ---: | --- |\n");
        for (CalibrationRow row : rows) {
            Interval interval = interval(row.observedValue(), row.sampleSize(), 0.0, 1.0);
            builder.append("| ").append(row.target().profileKey()).append(" | ")
                    .append(row.target().label()).append(" | ")
                    .append(number(row.observedValue())).append(" | ")
                    .append(numberOrBlank(row.target().observedValue())).append(" | ")
                    .append(number(interval.lower())).append("-")
                    .append(number(interval.upper())).append(" | ")
                    .append(number(row.target().lowerBound())).append("-")
                    .append(number(row.target().upperBound())).append(" | ")
                    .append(row.target().reliability()).append(" | ")
                    .append(row.target().useForValidation()).append(" | ")
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
            case POLICY_DOMAIN -> row.report().policyDomainReports();
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
        Map<String, Map<String, CalibrationObservation>> observedByProfile = new LinkedHashMap<>();
        observedByProfile.put("*", observedCalibrationValues(rows));
        List<CalibrationRow> calibrationRows = new ArrayList<>();
        for (CalibrationTarget target : calibrationTargets()) {
            Map<String, CalibrationObservation> observed = observedByProfile.computeIfAbsent(
                    target.profileKey(),
                    ignored -> observedCalibrationValues(profileRows(rows, target.profileKey()))
            );
            CalibrationObservation observation = observed.getOrDefault(target.key(), new CalibrationObservation(0.0, 0));
            double value = observation.value();
            boolean within = value >= target.lowerBound() && value <= target.upperBound();
            double gap = within ? 0.0 : Math.min(Math.abs(value - target.lowerBound()), Math.abs(value - target.upperBound()));
            calibrationRows.add(new CalibrationRow(target, value, observation.sampleSize(), within, gap));
        }
        return List.copyOf(calibrationRows);
    }

    private List<CampaignRow> profileRows(List<CampaignRow> rows, String profileKey) {
        String scenarioKey = CALIBRATION_PROFILE_SCENARIOS.get(profileKey);
        if (scenarioKey == null) {
            return rows;
        }
        List<CampaignRow> filtered = rows.stream()
                .filter(row -> row.report().scenarioKey().equals(scenarioKey))
                .toList();
        return filtered.isEmpty() ? rows : filtered;
    }

    private Map<String, CalibrationObservation> observedCalibrationValues(List<CampaignRow> rows) {
        Map<String, CalibrationObservation> observed = new LinkedHashMap<>();
        int totalCases = rows.stream().mapToInt(row -> row.report().totalCases()).sum();
        for (DoctrineArea doctrineArea : DoctrineArea.values()) {
            int doctrineCases = rows.stream()
                    .flatMap(row -> row.report().doctrineReports().stream())
                    .filter(segment -> segment.segmentKey().equals(doctrineArea.name().toLowerCase()))
                    .mapToInt(SegmentReport::totalCases)
                    .sum();
            observed.put("doctrine_mix." + doctrineArea.name().toLowerCase(), new CalibrationObservation(Values.ratio(doctrineCases, totalCases), totalCases));
        }
        int emergencyOrders = rows.stream().mapToInt(row -> row.report().emergencyOrders()).sum();
        int emergencyReliefs = rows.stream().mapToInt(row -> row.report().emergencyReliefs()).sum();
        int intakeFilings = rows.stream().mapToInt(row -> row.report().intakeFilings()).sum();
        int reviewedCases = rows.stream().mapToInt(row -> row.report().reviewedCases()).sum();
        int meritsReviews = rows.stream().mapToInt(row -> row.report().meritsReviews()).sum();
        int meritsInvalidations = rows.stream().mapToInt(row -> row.report().meritsInvalidations()).sum();
        observed.put("review_rate", new CalibrationObservation(Values.ratio(reviewedCases, totalCases), totalCases));
        observed.put("emergency_relief_rate", new CalibrationObservation(Values.ratio(emergencyReliefs, emergencyOrders), emergencyOrders));
        observed.put("merits_invalidation_rate", new CalibrationObservation(Values.ratio(meritsInvalidations, meritsReviews), meritsReviews));
        observed.put("intake_acceptance_rate", new CalibrationObservation(Values.ratio(reviewedCases, intakeFilings), intakeFilings));
        observed.put("emergency_reason_giving_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::emergencyReasonGivingRate), emergencyOrders));
        observed.put("emergency_vote_disclosure_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::emergencyVoteDisclosureRate), emergencyOrders));
        observed.put("emergency_public_disagreement_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::emergencyPublicDisagreementRate), emergencyOrders));
        observed.put("government_emergency_win_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::governmentEmergencyWinRate), emergencyOrders));
        observed.put("merits_follow_up_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::meritsFollowUpRate), emergencyOrders));
        observed.put("override_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::overrideRate), totalCases));
        observed.put("weak_form_declaration_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::weakFormDeclarationRate), totalCases));
        observed.put("suspended_declaration_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::suspendedDeclarationRate), totalCases));
        observed.put("legislative_response_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::legislativeResponseRate), totalCases));
        observed.put("legislative_response_delay", new CalibrationObservation(weightedAverage(rows, ScenarioReport::averageLegislativeResponseDelay), totalCases));
        observed.put("timely_legislative_response_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::timelyLegislativeResponseRate), totalCases));
        observed.put("legislative_response_credibility", new CalibrationObservation(weightedAverage(rows, ScenarioReport::legislativeResponseCredibility), totalCases));
        observed.put("pre_enactment_review_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::preEnactmentReviewRate), totalCases));
        observed.put("abstract_review_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::abstractReviewRate), totalCases));
        observed.put("preliminary_reference_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::preliminaryReferenceRate), totalCases));
        observed.put("appeal_route_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::appealRouteRate), totalCases));
        observed.put("direct_action_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::directActionRate), totalCases));
        observed.put("rights_impact_statement_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::rightsImpactStatementRate), totalCases));
        observed.put("ombudsman_trigger_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::ombudsmanTriggerRate), totalCases));
        observed.put("public_defender_participation_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::publicDefenderParticipationRate), totalCases));
        observed.put("compliance_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::complianceRate), totalCases));
        observed.put("legislative_reenactment_rate", new CalibrationObservation(weightedAverage(rows, ScenarioReport::legislativeReenactmentRate), totalCases));
        observed.put("public_trust", new CalibrationObservation(weightedAverage(rows, ScenarioReport::publicTrust), totalCases));
        observed.put("direct_court_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::directCourtCost), totalCases));
        observed.put("upstream_screening_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::upstreamScreeningCost), totalCases));
        observed.put("capacity_strain_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::capacityStrainCost), totalCases));
        observed.put("total_institutional_cost", new CalibrationObservation(weightedAverage(rows, ScenarioReport::totalInstitutionalCost), totalCases));
        observed.put("legitimacy_trust_gradient", new CalibrationObservation(legitimacyTrustGradient(rows), rows.size()));
        return observed;
    }

    private List<CalibrationTarget> calibrationTargets() throws IOException {
        List<CalibrationTarget> targets = new ArrayList<>();
        List<Path> targetFiles = calibrationTargetFiles();
        for (Path targetFile : targetFiles) {
            targets.addAll(calibrationTargets(targetFile));
        }
        return targets.isEmpty() ? defaultCalibrationTargets("built-in-defaults") : List.copyOf(targets);
    }

    private List<Path> calibrationTargetFiles() throws IOException {
        if (Files.isDirectory(CALIBRATION_TARGET_DIR)) {
            try (var stream = Files.list(CALIBRATION_TARGET_DIR)) {
                List<Path> files = stream
                        .filter(path -> Files.isRegularFile(path) && path.getFileName().toString().endsWith(".csv"))
                        .sorted()
                        .toList();
                if (!files.isEmpty()) {
                    return files;
                }
            }
        }
        if (Files.exists(DEFAULT_CALIBRATION_TARGETS)) {
            return List.of(DEFAULT_CALIBRATION_TARGETS);
        }
        return List.of();
    }

    private List<CalibrationTarget> calibrationTargets(Path targetFile) throws IOException {
        List<CalibrationTarget> targets = new ArrayList<>();
        List<String> lines = Files.readAllLines(targetFile);
        if (lines.isEmpty()) {
            return targets;
        }
        List<String> header = parseCsvLine(lines.get(0));
        Map<String, Integer> columns = new LinkedHashMap<>();
        for (int i = 0; i < header.size(); i++) {
            columns.put(header.get(i), i);
        }
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty() || line.startsWith("#")) {
                continue;
            }
            List<String> parts = parseCsvLine(line);
            targets.add(new CalibrationTarget(
                    calibrationValue(parts, columns, "profileKey", "default"),
                    calibrationValue(parts, columns, "court", "unspecified court"),
                    calibrationValue(parts, columns, "timePeriod", "unspecified period"),
                    calibrationValue(parts, columns, "targetKey", positional(parts, 0)),
                    calibrationValue(parts, columns, "label", positional(parts, 1)),
                    Double.parseDouble(calibrationValue(parts, columns, "lowerBound", positional(parts, 2))),
                    Double.parseDouble(calibrationValue(parts, columns, "upperBound", positional(parts, 3))),
                    optionalDouble(calibrationValue(parts, columns, "observedValue", "")),
                    optionalInt(calibrationValue(parts, columns, "n", "0")),
                    calibrationValue(parts, columns, "unit", "share"),
                    calibrationValue(parts, columns, "method", "documented-range"),
                    calibrationValue(parts, columns, "reliability", "medium"),
                    Boolean.parseBoolean(calibrationValue(parts, columns, "useForValidation", "true")),
                    calibrationValue(parts, columns, "note", positional(parts, 4)),
                    calibrationValue(parts, columns, "sourceName", targetFile.getFileName().toString()),
                    calibrationValue(parts, columns, "sourceUrl", ""),
                    targetFile.toString()
            ));
        }
        return targets;
    }

    private List<CalibrationTarget> defaultCalibrationTargets(String source) {
        String sourceUrl = "https://scdb.la.psu.edu/data/2025-release-01/";
        return List.of(
                new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.speech", "Speech docket share", 0.039, 0.080, 0.060, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 3 share in 2000-2024 case-centered data.", source, sourceUrl, source),
                new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.equality", "Civil-rights and privacy docket share", 0.137, 0.191, 0.164, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 2 and 5 less election-law issue subset.", source, sourceUrl, source),
                new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.criminal_procedure", "Criminal procedure docket share", 0.230, 0.289, 0.260, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 1 share in 2000-2024 case-centered data.", source, sourceUrl, source),
                new CalibrationTarget("fallback-scdb-modern", "U.S. Supreme Court", "2000-2024 terms", "doctrine_mix.federalism", "Federalism docket share", 0.037, 0.078, 0.058, 0, "share", "SCDB issue-area proxy", "high", true, "SCDB issueArea 10 and 11 share in 2000-2024 case-centered data.", source, sourceUrl, source)
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

    private static List<ReportIntervalMetric> reportIntervalMetrics() {
        return List.of(
                new ReportIntervalMetric("directionalScore", ScenarioReport::directionalScore, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("legalStability", ScenarioReport::legalStability, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("rightsProtection", ScenarioReport::rightsProtection, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("partisanAlignment", ScenarioReport::partisanAlignment, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("shadowDocketAbuse", ScenarioReport::shadowDocketAbuse, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("legitimacy", ScenarioReport::legitimacy, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("reversalRate", ScenarioReport::reversalRate, ScenarioReport::reviewedCases, 0.0, 1.0),
                new ReportIntervalMetric("reviewRate", ScenarioReport::reviewRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("intakeAcceptanceRate", ScenarioReport::intakeAcceptanceRate, ScenarioReport::intakeFilings, 0.0, 1.0),
                new ReportIntervalMetric("emergencyReliefRate", ScenarioReport::emergencyReliefRate, ScenarioReport::emergencyOrders, 0.0, 1.0),
                new ReportIntervalMetric("emergencyReasonGivingRate", ScenarioReport::emergencyReasonGivingRate, ScenarioReport::emergencyOrders, 0.0, 1.0),
                new ReportIntervalMetric("emergencyVoteDisclosureRate", ScenarioReport::emergencyVoteDisclosureRate, ScenarioReport::emergencyOrders, 0.0, 1.0),
                new ReportIntervalMetric("emergencyPublicDisagreementRate", ScenarioReport::emergencyPublicDisagreementRate, ScenarioReport::emergencyOrders, 0.0, 1.0),
                new ReportIntervalMetric("governmentEmergencyWinRate", ScenarioReport::governmentEmergencyWinRate, ScenarioReport::emergencyOrders, 0.0, 1.0),
                new ReportIntervalMetric("meritsFollowUpRate", ScenarioReport::meritsFollowUpRate, ScenarioReport::emergencyOrders, 0.0, 1.0),
                new ReportIntervalMetric("meritsInvalidationRate", ScenarioReport::meritsInvalidationRate, ScenarioReport::meritsReviews, 0.0, 1.0),
                new ReportIntervalMetric("constitutionalConflict", ScenarioReport::constitutionalConflict, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("democraticResponsiveness", ScenarioReport::democraticResponsiveness, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("legislativeResponseCredibility", ScenarioReport::legislativeResponseCredibility, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("caseSelectionAccess", ScenarioReport::caseSelectionAccess, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("governmentRepeatPlayerAdvantage", ScenarioReport::governmentRepeatPlayerAdvantage, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("implementationCapacity", ScenarioReport::implementationCapacity, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("democraticConstitutionalism", ScenarioReport::democraticConstitutionalism, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("vetoRelocationRisk", ScenarioReport::vetoRelocationRisk, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("legalTransplantFeasibility", ScenarioReport::legalTransplantFeasibility, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("politicalCultureSensitivity", ScenarioReport::politicalCultureSensitivity, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("complianceRate", ScenarioReport::complianceRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("publicTrust", ScenarioReport::publicTrust, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("administrativeLoad", ScenarioReport::administrativeLoad, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("directCourtCost", ScenarioReport::directCourtCost, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("upstreamScreeningCost", ScenarioReport::upstreamScreeningCost, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("capacityStrainCost", ScenarioReport::capacityStrainCost, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("institutionalBudgetCost", ScenarioReport::institutionalBudgetCost, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("institutionalDelayCost", ScenarioReport::institutionalDelayCost, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("implementationComplexity", ScenarioReport::implementationComplexity, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("totalInstitutionalCost", ScenarioReport::totalInstitutionalCost, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("weakFormDeclarationRate", ScenarioReport::weakFormDeclarationRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("suspendedDeclarationRate", ScenarioReport::suspendedDeclarationRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("legislativeResponseRate", ScenarioReport::legislativeResponseRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("averageLegislativeResponseDelay", ScenarioReport::averageLegislativeResponseDelay, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("timelyLegislativeResponseRate", ScenarioReport::timelyLegislativeResponseRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("rightsImpactStatementRate", ScenarioReport::rightsImpactStatementRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("ombudsmanTriggerRate", ScenarioReport::ombudsmanTriggerRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("publicDefenderParticipationRate", ScenarioReport::publicDefenderParticipationRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("preEnactmentReviewRate", ScenarioReport::preEnactmentReviewRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("abstractReviewRate", ScenarioReport::abstractReviewRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("preliminaryReferenceRate", ScenarioReport::preliminaryReferenceRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("appealRouteRate", ScenarioReport::appealRouteRate, ScenarioReport::totalCases, 0.0, 1.0),
                new ReportIntervalMetric("directActionRate", ScenarioReport::directActionRate, ScenarioReport::totalCases, 0.0, 1.0)
        );
    }

    private static List<SegmentIntervalMetric> segmentIntervalMetrics() {
        return List.of(
                new SegmentIntervalMetric("reviewRate", SegmentReport::reviewRate, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("intakeAcceptanceRate", SegmentReport::intakeAcceptanceRate, SegmentReport::intakeFilings, 0.0, 1.0),
                new SegmentIntervalMetric("legalStability", SegmentReport::legalStability, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("rightsProtection", SegmentReport::rightsProtection, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("shadowDocketAbuse", SegmentReport::shadowDocketAbuse, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("emergencyReliefRate", SegmentReport::emergencyReliefRate, SegmentReport::reviewedCases, 0.0, 1.0),
                new SegmentIntervalMetric("emergencyReasonGivingRate", SegmentReport::emergencyReasonGivingRate, SegmentReport::reviewedCases, 0.0, 1.0),
                new SegmentIntervalMetric("emergencyVoteDisclosureRate", SegmentReport::emergencyVoteDisclosureRate, SegmentReport::reviewedCases, 0.0, 1.0),
                new SegmentIntervalMetric("emergencyPublicDisagreementRate", SegmentReport::emergencyPublicDisagreementRate, SegmentReport::reviewedCases, 0.0, 1.0),
                new SegmentIntervalMetric("governmentEmergencyWinRate", SegmentReport::governmentEmergencyWinRate, SegmentReport::reviewedCases, 0.0, 1.0),
                new SegmentIntervalMetric("meritsFollowUpRate", SegmentReport::meritsFollowUpRate, SegmentReport::reviewedCases, 0.0, 1.0),
                new SegmentIntervalMetric("meritsInvalidationRate", SegmentReport::meritsInvalidationRate, SegmentReport::reviewedCases, 0.0, 1.0),
                new SegmentIntervalMetric("legitimacy", SegmentReport::legitimacy, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("constitutionalConflict", SegmentReport::constitutionalConflict, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("democraticResponsiveness", SegmentReport::democraticResponsiveness, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("legislativeResponseCredibility", SegmentReport::legislativeResponseCredibility, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("caseSelectionAccess", SegmentReport::caseSelectionAccess, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("governmentRepeatPlayerAdvantage", SegmentReport::governmentRepeatPlayerAdvantage, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("implementationCapacity", SegmentReport::implementationCapacity, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("democraticConstitutionalism", SegmentReport::democraticConstitutionalism, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("vetoRelocationRisk", SegmentReport::vetoRelocationRisk, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("legalTransplantFeasibility", SegmentReport::legalTransplantFeasibility, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("politicalCultureSensitivity", SegmentReport::politicalCultureSensitivity, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("complianceRate", SegmentReport::complianceRate, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("publicTrust", SegmentReport::publicTrust, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("directCourtCost", SegmentReport::directCourtCost, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("upstreamScreeningCost", SegmentReport::upstreamScreeningCost, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("capacityStrainCost", SegmentReport::capacityStrainCost, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("institutionalBudgetCost", SegmentReport::institutionalBudgetCost, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("institutionalDelayCost", SegmentReport::institutionalDelayCost, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("implementationComplexity", SegmentReport::implementationComplexity, SegmentReport::totalCases, 0.0, 1.0),
                new SegmentIntervalMetric("totalInstitutionalCost", SegmentReport::totalInstitutionalCost, SegmentReport::totalCases, 0.0, 1.0)
        );
    }

    private static List<CompositionIntervalMetric> compositionIntervalMetrics() {
        return List.of(
                new CompositionIntervalMetric("courtSize", CompositionReport::courtSize, 3.0, 30.0),
                new CompositionIntervalMetric("medianIdeology", CompositionReport::medianIdeology, -1.0, 1.0),
                new CompositionIntervalMetric("ideologicalSpread", CompositionReport::ideologicalSpread, 0.0, 2.0),
                new CompositionIntervalMetric("meanPartisanAttachment", CompositionReport::meanPartisanAttachment, 0.0, 1.0),
                new CompositionIntervalMetric("meanRightsSensitivity", CompositionReport::meanRightsSensitivity, 0.0, 1.0),
                new CompositionIntervalMetric("meanInstitutionalism", CompositionReport::meanInstitutionalism, 0.0, 1.0),
                new CompositionIntervalMetric("replacementPressure", CompositionReport::replacementPressure, 0.0, 1.0),
                new CompositionIntervalMetric("estimatedReplacementEvents", CompositionReport::estimatedReplacementEvents, 0.0, 18.0)
        );
    }

    private static double medianIntervalWidth(List<CampaignRow> rows, MetricReader reader, double minimum, double maximum) {
        List<Double> widths = rows.stream()
                .map(row -> interval(reader.value(row.report()), row.report().totalCases(), minimum, maximum))
                .map(interval -> interval.upper() - interval.lower())
                .sorted()
                .toList();
        if (widths.isEmpty()) {
            return 0.0;
        }
        int middle = widths.size() / 2;
        if (widths.size() % 2 == 1) {
            return widths.get(middle);
        }
        return (widths.get(middle - 1) + widths.get(middle)) / 2.0;
    }

    private static Interval interval(double estimate, int sampleSize, double minimum, double maximum) {
        if (sampleSize <= 1 || maximum <= minimum) {
            return new Interval(estimate, estimate);
        }
        double bounded = Values.clamp(estimate, minimum, maximum);
        double width = maximum - minimum;
        double normalized = Values.clamp01((bounded - minimum) / width);
        double variance = Math.max(normalized * (1.0 - normalized), 0.04);
        double margin = 1.96 * width * Math.sqrt(variance / sampleSize);
        return new Interval(
                Values.clamp(bounded - margin, minimum, maximum),
                Values.clamp(bounded + margin, minimum, maximum)
        );
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

    private static List<String> parseCsvLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean quoted = false;
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);
            if (character == '"') {
                if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else {
                    quoted = !quoted;
                }
            } else if (character == ',' && !quoted) {
                values.add(current.toString());
                current.setLength(0);
            } else {
                current.append(character);
            }
        }
        values.add(current.toString());
        return values;
    }

    private static String calibrationValue(List<String> row, Map<String, Integer> columns, String key, String defaultValue) {
        Integer index = columns.get(key);
        if (index == null || index >= row.size()) {
            return defaultValue;
        }
        String value = row.get(index).trim();
        return value.isEmpty() ? defaultValue : value;
    }

    private static String positional(List<String> row, int index) {
        if (index < 0 || index >= row.size()) {
            return "";
        }
        return row.get(index).trim();
    }

    private static double optionalDouble(String value) {
        if (value == null || value.isBlank()) {
            return Double.NaN;
        }
        return Double.parseDouble(value.trim());
    }

    private static int optionalInt(String value) {
        if (value == null || value.isBlank()) {
            return 0;
        }
        return Integer.parseInt(value.trim());
    }

    private static double csvDouble(List<String> row, Map<String, Integer> columns, String key, double defaultValue) {
        String value = calibrationValue(row, columns, key, "");
        if (value.isBlank()) {
            return defaultValue;
        }
        return Double.parseDouble(value);
    }

    private String inputDescription(String campaignKey, List<LegislativeSignal> importedSignals) {
        String description = LegislativeOutputImporter.describeImport(importedSignals);
        if (isValidation(campaignKey) && Files.exists(DEFAULT_CONTEXT_PROFILES)) {
            return description + "; context=" + DEFAULT_CONTEXT_PROFILES;
        }
        return description;
    }

    private static String number(double value) {
        return String.format(Locale.ROOT, "%.3f", value);
    }

    private static String numberOrBlank(double value) {
        if (Double.isNaN(value)) {
            return "";
        }
        return number(value);
    }

    private record CampaignCase(
            String key,
            String name,
            String description,
            WorldSpec spec,
            SignalMode signalMode
    ) {
    }

    private record ContextProfile(
            String scenarioKey,
            String system,
            String period,
            double publicTrust,
            double partisanPressure,
            double partyFragmentation,
            double governmentControl,
            double electoralTimePressure,
            double civilSocietyCapacity,
            double implementationCapacity,
            double legalTraditionCompatibility,
            double legislativeConflict,
            String sourceFamily,
            String sourceUrl,
            boolean applyInValidation,
            String note
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
        PIPELINE,
        POLICY_DOMAIN
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
    private interface ReportSampleSizeReader {
        int value(ScenarioReport report);
    }

    @FunctionalInterface
    private interface SegmentSampleSizeReader {
        int value(SegmentReport report);
    }

    @FunctionalInterface
    private interface CompositionMetricReader {
        double value(CompositionReport report);
    }

    private record ReportIntervalMetric(
            String key,
            MetricReader value,
            ReportSampleSizeReader sampleSize,
            double minimum,
            double maximum
    ) {
    }

    private record SegmentIntervalMetric(
            String key,
            SegmentMetricReader value,
            SegmentSampleSizeReader sampleSize,
            double minimum,
            double maximum
    ) {
    }

    private record CompositionIntervalMetric(
            String key,
            CompositionMetricReader value,
            double minimum,
            double maximum
    ) {
    }

    private record Interval(double lower, double upper) {
    }

    private record SegmentBootstrapKey(
            SegmentKind kind,
            String segmentKey,
            String metricKey
    ) {
    }

    private record BootstrapSummary(
            Map<String, Interval> reportIntervals,
            Map<SegmentBootstrapKey, Interval> segmentIntervals
    ) {
        private static BootstrapSummary empty() {
            return new BootstrapSummary(Map.of(), Map.of());
        }

        private Optional<Interval> reportInterval(String metricKey) {
            return Optional.ofNullable(reportIntervals.get(metricKey));
        }

        private boolean hasReportInterval(String metricKey) {
            return reportIntervals.containsKey(metricKey);
        }

        private Optional<Interval> segmentInterval(SegmentKind kind, String segmentKey, String metricKey) {
            return Optional.ofNullable(segmentIntervals.get(new SegmentBootstrapKey(kind, segmentKey, metricKey)));
        }

        private boolean hasSegmentInterval(SegmentKind kind, String segmentKey, String metricKey) {
            return segmentIntervals.containsKey(new SegmentBootstrapKey(kind, segmentKey, metricKey));
        }
    }

    private record CalibrationTarget(
            String profileKey,
            String court,
            String timePeriod,
            String key,
            String label,
            double lowerBound,
            double upperBound,
            double observedValue,
            int sampleSize,
            String unit,
            String method,
            String reliability,
            boolean useForValidation,
            String note,
            String sourceName,
            String sourceUrl,
            String targetFile
    ) {
    }

    private record CalibrationObservation(double value, int sampleSize) {
    }

    private record CalibrationRow(
            CalibrationTarget target,
            double observedValue,
            int sampleSize,
            boolean withinTarget,
            double gap
    ) {
    }
}
