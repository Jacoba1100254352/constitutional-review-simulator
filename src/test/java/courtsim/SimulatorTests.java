package courtsim;

import courtsim.experiment.CampaignResult;
import courtsim.experiment.CampaignRunner;
import courtsim.importer.LegislativeOutputImporter;
import courtsim.institution.InstitutionModelTests;
import courtsim.model.LegislativeSignal;
import courtsim.model.PolicyDomain;
import courtsim.simulation.DirectionalScoreModelTests;
import courtsim.simulation.Scenario;
import courtsim.simulation.ScenarioCatalog;
import courtsim.simulation.ScenarioReport;
import courtsim.simulation.Simulator;
import courtsim.simulation.WorldSpec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public final class SimulatorTests {
    private SimulatorTests() {
    }

    public static void main(String[] args) throws Exception {
        scenarioCatalogSelectsKnownKeys();
        InstitutionModelTests.runAll();
        DirectionalScoreModelTests.runAll();
        simulatorProducesReports();
        mechanismScenariosProduceDiagnostics();
        cjeuRouteMixDiagnosticsAreExposed();
        contextProfileFileIsWellFormed();
        legislativeImporterToleratesCampaignCsv();
        campaignWritesArtifacts();
        pairedCampaignWritesArtifacts();
        validationCampaignWritesArtifacts();
        sensitivityCampaignWritesArtifacts();
        System.out.println("All simulator tests passed.");
    }

    private static void scenarioCatalogSelectsKnownKeys() {
        List<Scenario> scenarios = ScenarioCatalog.scenariosForKeys(List.of(
                "current-federal-court",
                "constitutional-council",
                "dual-cross-checking-courts",
                "german-constitutional-court",
                "uk-supreme-court",
                "weak-form-review",
                "mandatory-legislative-response"
        ));
        assertTrue(scenarios.size() == 7, "expected selected scenarios");
        assertTrue(scenarios.get(1).name().contains("constitutional council"), "expected council scenario name");
        assertTrue(scenarios.get(3).kind().name().equals("REAL_WORLD_PRESET"), "expected real-world preset kind");
        assertTrue(scenarios.get(4).mechanism().name().equals("WEAK_FORM_REVIEW"), "expected UK weak-form mechanism");
        assertTrue(scenarios.get(5).kind().name().equals("SYNTHETIC_MECHANISM"), "expected synthetic mechanism kind");
        assertTrue(scenarios.get(6).mechanism().name().equals("MANDATORY_LEGISLATIVE_RESPONSE"), "expected mandatory response mechanism");
        assertTrue(ScenarioCatalog.scenarioKeys().contains("canadian-supreme-court"), "expected real-world preset");
        assertTrue(ScenarioCatalog.scenarioKeys().contains("rights-impact-statement-review"), "expected rights-impact mechanism");
        assertTrue(PolicyDomain.fromKey("speech").equals(PolicyDomain.SPEECH_RELIGION), "expected speech domain alias");
        assertTrue(PolicyDomain.fromKey("preemption").equals(PolicyDomain.FEDERALISM), "expected federalism domain alias");
    }

    private static void simulatorProducesReports() {
        List<Scenario> scenarios = ScenarioCatalog.scenariosForKeys(List.of(
                "current-federal-court",
                "reasoned-emergency-review"
        ));
        List<ScenarioReport> reports = new Simulator().compare(
                scenarios,
                WorldSpec.baseline(24),
                8,
                1234L,
                List.of()
        );
        assertTrue(reports.size() == 2, "expected two reports");
        for (ScenarioReport report : reports) {
            assertTrue(report.totalCases() == 192, "unexpected case count");
            assertBetween(report.directionalScore(), "directional score");
            assertBetween(report.legalStability(), "legal stability");
            assertBetween(report.rightsProtection(), "rights protection");
            assertBetween(report.emergencyReliefRate(), "emergency relief rate");
            assertBetween(report.meritsInvalidationRate(), "merits invalidation rate");
            assertTrue(report.intakeFilings() >= report.reviewedCases(), "expected intake filings to cover reviewed cases");
            assertTrue(report.screenedFilings() >= 0, "expected screened filings");
            assertBetween(report.intakeAcceptanceRate(), "intake acceptance rate");
            assertBetween(report.emergencyReasonGivingRate(), "emergency reason-giving rate");
            assertBetween(report.emergencyVoteDisclosureRate(), "emergency vote disclosure rate");
            assertBetween(report.emergencyPublicDisagreementRate(), "emergency public disagreement rate");
            assertBetween(report.governmentEmergencyApplicantShare(), "government emergency applicant share");
            assertBetween(report.governmentEmergencyWinRate(), "government emergency win rate");
            assertBetween(report.meritsFollowUpRate(), "merits follow-up rate");
            assertBetween(report.complianceRate(), "compliance rate");
            assertBetween(report.defianceRate(), "defiance rate");
            assertBetween(report.stateCaseShare(), "state case share");
            assertBetween(report.mixedJurisdictionShare(), "mixed jurisdiction share");
            assertTrue(report.averageLowerCourtDepth() >= 1.0, "expected lower-court depth");
            assertBetween(report.stateFederalTension(), "state-federal tension");
            assertBetween(report.intercourtConflict(), "intercourt conflict");
            assertBetween(report.executiveImplementationRate(), "executive implementation rate");
            assertBetween(report.agencyNonacquiescenceRate(), "agency nonacquiescence rate");
            assertBetween(report.legislativeReenactmentRate(), "legislative reenactment rate");
            assertBetween(report.localGovernmentComplianceRate(), "local-government compliance rate");
            assertBetween(report.directCourtCost(), "direct court cost");
            assertBetween(report.upstreamScreeningCost(), "upstream screening cost");
            assertBetween(report.capacityStrainCost(), "capacity strain cost");
            assertBetween(report.institutionalBudgetCost(), "institutional budget cost");
            assertBetween(report.institutionalDelayCost(), "institutional delay cost");
            assertBetween(report.implementationComplexity(), "implementation complexity");
            assertBetween(report.totalInstitutionalCost(), "total institutional cost");
            assertBetween(report.democraticConstitutionalism(), "democratic constitutionalism");
            assertBetween(report.vetoRelocationRisk(), "veto relocation risk");
            assertBetween(report.legalTransplantFeasibility(), "legal transplant feasibility");
            assertBetween(report.politicalCultureSensitivity(), "political culture sensitivity");
            assertBetween(report.legislativeResponseCredibility(), "legislative response credibility");
            assertBetween(report.caseSelectionAccess(), "case-selection access");
            assertBetween(report.governmentRepeatPlayerAdvantage(), "government repeat-player advantage");
            assertBetween(report.implementationCapacity(), "implementation capacity");
            assertBetween(report.preliminaryReferenceRate(), "preliminary-reference route rate");
            assertBetween(report.appealRouteRate(), "appeal route rate");
            assertBetween(report.directActionRate(), "direct-action route rate");
            assertTrue(!report.periodReports().isEmpty(), "expected period diagnostics");
            assertTrue(!report.doctrineReports().isEmpty(), "expected doctrine diagnostics");
            assertTrue(!report.pipelineReports().isEmpty(), "expected pipeline diagnostics");
            assertTrue(!report.policyDomainReports().isEmpty(), "expected policy-domain diagnostics");
            assertTrue(!report.compositionReports().isEmpty(), "expected composition diagnostics");
        }
    }

    private static void mechanismScenariosProduceDiagnostics() {
        List<ScenarioReport> reports = new Simulator().compare(
                ScenarioCatalog.scenariosForKeys(List.of(
                        "weak-form-review",
                        "suspended-declaration-review",
                        "pre-enactment-review",
                        "abstract-review-tribunal",
                        "ombudsman-triggered-review",
                        "constitutional-public-defender",
                        "rights-impact-statement-review",
                        "mandatory-legislative-response"
                )),
                WorldSpec.baseline(24),
                8,
                20260501L,
                List.of()
        );
        assertTrue(reports.size() == 8, "expected mechanism reports");
        Map<String, ScenarioReport> byKey = new HashMap<>();
        for (ScenarioReport report : reports) {
            byKey.put(report.scenarioKey(), report);
            assertTrue(report.scenarioKind().equals("synthetic_mechanism"), "expected synthetic mechanism report kind");
            assertBetween(report.democraticConstitutionalism(), "mechanism democratic constitutionalism");
            assertBetween(report.vetoRelocationRisk(), "mechanism veto relocation risk");
            assertBetween(report.legalTransplantFeasibility(), "mechanism transplant feasibility");
            assertBetween(report.politicalCultureSensitivity(), "mechanism political culture sensitivity");
            assertBetween(report.legislativeResponseCredibility(), "mechanism legislative response credibility");
            assertBetween(report.caseSelectionAccess(), "mechanism case-selection access");
            assertBetween(report.implementationCapacity(), "mechanism implementation capacity");
        }
        assertTrue(byKey.get("weak-form-review").weakFormDeclarationRate() > 0.0, "expected weak-form declarations");
        assertTrue(byKey.get("suspended-declaration-review").suspendedDeclarationRate() > 0.0, "expected suspended declarations");
        assertTrue(byKey.get("pre-enactment-review").preEnactmentReviewRate() > 0.0, "expected pre-enactment review");
        assertTrue(byKey.get("abstract-review-tribunal").abstractReviewRate() > 0.0, "expected abstract review");
        assertTrue(byKey.get("ombudsman-triggered-review").ombudsmanTriggerRate() > 0.0, "expected ombudsman triggers");
        assertTrue(byKey.get("constitutional-public-defender").publicDefenderParticipationRate() > 0.0, "expected public-defender participation");
        assertTrue(byKey.get("rights-impact-statement-review").rightsImpactStatementRate() > 0.0, "expected rights-impact statements");
        assertTrue(byKey.get("mandatory-legislative-response").legislativeResponseRate() > 0.0, "expected legislative response cycles");
    }

    private static void cjeuRouteMixDiagnosticsAreExposed() {
        List<ScenarioReport> reports = new Simulator().compare(
                ScenarioCatalog.scenariosForKeys(List.of("cjeu-court-of-justice")),
                WorldSpec.baseline(120),
                10,
                20260509L,
                List.of()
        );
        ScenarioReport report = reports.get(0);
        assertTrue(report.preliminaryReferenceRate() > 0.45, "expected visible preliminary-reference route share");
        assertTrue(report.appealRouteRate() > 0.18, "expected visible appeal route share");
        assertTrue(report.directActionRate() > 0.02, "expected visible direct-action route share");
        assertTrue(
                report.preliminaryReferenceRate() + report.appealRouteRate() + report.directActionRate() <= 1.0,
                "route shares should not exceed docket total"
        );
    }

    private static void contextProfileFileIsWellFormed() throws Exception {
        Path path = Path.of("config/context/country-year-context.csv");
        assertTrue(Files.exists(path), "expected validation context profile file");
        List<String[]> rows = readCsv(path);
        assertTrue(rows.size() == 9, "expected one header plus eight validation context rows");
        String[] header = rows.get(0);
        int scenarioKey = column(header, "scenarioKey");
        int publicTrust = column(header, "publicTrust");
        int implementationCapacity = column(header, "implementationCapacity");
        int legalTraditionCompatibility = column(header, "legalTraditionCompatibility");
        int applyInValidation = column(header, "applyInValidation");
        Map<String, Boolean> seen = new HashMap<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            seen.put(row[scenarioKey], true);
            assertBetween(Double.parseDouble(row[publicTrust]), "context publicTrust");
            assertBetween(Double.parseDouble(row[implementationCapacity]), "context implementationCapacity");
            assertBetween(Double.parseDouble(row[legalTraditionCompatibility]), "context legalTraditionCompatibility");
            assertTrue("true".equals(row[applyInValidation]), "context rows should be enabled for validation");
        }
        for (String key : List.of(
                "us-supreme-court-benchmark",
                "german-constitutional-court",
                "french-constitutional-council",
                "canadian-supreme-court",
                "south-african-constitutional-court",
                "uk-supreme-court",
                "echr-treaty-court",
                "cjeu-court-of-justice"
        )) {
            assertTrue(seen.containsKey(key), "missing validation context profile: " + key);
        }
    }

    private static void legislativeImporterToleratesCampaignCsv() throws Exception {
        Path temp = Files.createTempFile("legislative-signals", ".csv");
        Files.writeString(temp, """
                caseKey,scenarioKey,scenario,avgSupport,welfare,legitimacy,lowSupport,weakPublicMandatePassage,minorityHarm,concentratedHarmPassage,lobbyCapture,publicAlignment,publicPreferenceDistortion,policyShift,proposerGain,reversalRate,statusQuoVolatility,fastLaneRate,highRiskLaneRate,challengeRate
                baseline,default-pass,Default pass,0.48,0.42,0.51,0.31,0.44,0.22,0.18,0.27,0.52,0.25,0.36,0.19,0.08,0.14,0.07,0.22,0.18
                baseline,committee-regular-order,Committee regular order,0.66,0.71,0.62,0.02,0.04,0.10,0.05,0.08,0.76,0.08,0.12,0.06,0.04,0.06,0.03,0.08,0.05
                """);
        List<LegislativeSignal> signals = LegislativeOutputImporter.read(temp);
        assertTrue(signals.size() == 2, "expected imported rows");
        assertTrue(signals.get(0).policyDomain() != PolicyDomain.GOVERNANCE, "expected inferred policy domain");
        List<ScenarioReport> reports = new Simulator().compare(
                ScenarioCatalog.scenariosForKeys(List.of("current-federal-court")),
                WorldSpec.baseline(16),
                4,
                42L,
                signals
        );
        assertTrue(reports.get(0).totalCases() == 64, "expected imported docket cases");
    }

    private static void campaignWritesArtifacts() throws Exception {
        Path tempDir = Files.createTempDirectory("court-campaign");
        CampaignResult result = new CampaignRunner().run(
                "v0",
                WorldSpec.baseline(12),
                3,
                20260501L,
                tempDir,
                List.of()
        );
        assertTrue(Files.exists(result.csvPath()), "expected CSV artifact");
        assertTrue(Files.exists(result.periodCsvPath()), "expected period CSV artifact");
        assertTrue(Files.exists(result.doctrineCsvPath()), "expected doctrine CSV artifact");
        assertTrue(Files.exists(result.pipelineCsvPath()), "expected pipeline CSV artifact");
        assertTrue(Files.exists(result.policyDomainCsvPath()), "expected policy-domain CSV artifact");
        assertTrue(Files.exists(result.compositionCsvPath()), "expected composition CSV artifact");
        assertTrue(Files.exists(result.calibrationCsvPath()), "expected calibration CSV artifact");
        assertTrue(Files.exists(result.caseCsvGzPath()), "expected compressed case-level artifact");
        String caseHeader = readGzipHeader(result.caseCsvGzPath());
        assertTrue(caseHeader.contains("scenarioKey"), "expected case-level CSV header");
        assertTrue(caseHeader.contains("reviewMechanism"), "expected mechanism case export");
        assertTrue(caseHeader.contains("weakFormDeclaration"), "expected weak-form case export");
        assertTrue(caseHeader.contains("legislativeResponseDelay"), "expected response-timing case export");
        assertTrue(caseHeader.contains("supranationalRoute"), "expected supranational route case export");
        assertTrue(caseHeader.contains("directActionRoute"), "expected direct-action case export");
        assertTrue(caseHeader.contains("policyDomain"), "expected policy-domain case export");
        assertTrue(caseHeader.contains("litigantCapacity"), "expected case-selection input export");
        assertTrue(caseHeader.contains("caseSelectionAccess"), "expected case-selection outcome export");
        assertTrue(caseHeader.contains("legislativeResponseCredibility"), "expected response credibility export");
        assertTrue(Files.exists(result.intervalCsvPath()), "expected interval CSV artifact");
        assertTrue(Files.exists(result.periodIntervalCsvPath()), "expected period interval CSV artifact");
        assertTrue(Files.exists(result.doctrineIntervalCsvPath()), "expected doctrine interval CSV artifact");
        assertTrue(Files.exists(result.pipelineIntervalCsvPath()), "expected pipeline interval CSV artifact");
        assertTrue(Files.exists(result.policyDomainIntervalCsvPath()), "expected policy-domain interval CSV artifact");
        assertTrue(Files.exists(result.compositionIntervalCsvPath()), "expected composition interval CSV artifact");
        assertTrue(Files.exists(result.calibrationIntervalCsvPath()), "expected calibration interval CSV artifact");
        assertTrue(Files.exists(result.markdownPath()), "expected Markdown artifact");
        assertTrue(Files.exists(result.manifestPath()), "expected manifest artifact");
        assertTrue(Files.readString(result.csvPath()).contains("legalStability"), "expected CSV header");
        assertTrue(Files.readString(result.csvPath()).contains("emergencyReliefRate"), "expected split emergency metric");
        assertTrue(Files.readString(result.csvPath()).contains("intakeAcceptanceRate"), "expected intake metric");
        assertTrue(Files.readString(result.csvPath()).contains("emergencyReasonGivingRate"), "expected emergency transparency metric");
        assertTrue(Files.readString(result.csvPath()).contains("directCourtCost"), "expected direct cost metric");
        assertTrue(Files.readString(result.csvPath()).contains("complianceRate"), "expected compliance metric");
        assertTrue(Files.readString(result.csvPath()).contains("executiveImplementationRate"), "expected enforcement metric");
        assertTrue(Files.readString(result.csvPath()).contains("stateFederalTension"), "expected hierarchy metric");
        assertTrue(Files.readString(result.csvPath()).contains("totalInstitutionalCost"), "expected institutional cost metric");
        assertTrue(Files.readString(result.csvPath()).contains("scenarioKind"), "expected scenario-kind metadata");
        assertTrue(Files.readString(result.csvPath()).contains("reviewMechanism"), "expected review-mechanism metadata");
        assertTrue(Files.readString(result.csvPath()).contains("democraticConstitutionalism"), "expected democratic constitutionalism metric");
        assertTrue(Files.readString(result.csvPath()).contains("vetoRelocationRisk"), "expected veto-relocation metric");
        assertTrue(Files.readString(result.csvPath()).contains("legalTransplantFeasibility"), "expected transplant feasibility metric");
        assertTrue(Files.readString(result.csvPath()).contains("politicalCultureSensitivity"), "expected political-culture sensitivity metric");
        assertTrue(Files.readString(result.csvPath()).contains("legislativeResponseCredibility"), "expected response credibility metric");
        assertTrue(Files.readString(result.csvPath()).contains("caseSelectionAccess"), "expected case-selection access metric");
        assertTrue(Files.readString(result.csvPath()).contains("governmentRepeatPlayerAdvantage"), "expected government repeat-player metric");
        assertTrue(Files.readString(result.csvPath()).contains("implementationCapacity"), "expected implementation capacity metric");
        assertTrue(Files.readString(result.csvPath()).contains("weakFormDeclarationRate"), "expected weak-form mechanism metric");
        assertTrue(Files.readString(result.csvPath()).contains("timelyLegislativeResponseRate"), "expected response-timing metric");
        assertTrue(Files.readString(result.csvPath()).contains("preliminaryReferenceRate"), "expected CJEU route metric");
        assertTrue(Files.readString(result.periodCsvPath()).contains("caseSelectionAccess"), "expected period access metric");
        assertTrue(Files.readString(result.doctrineCsvPath()).contains("implementationCapacity"), "expected doctrine implementation metric");
        assertTrue(Files.readString(result.periodCsvPath()).contains("period"), "expected period report rows");
        assertTrue(Files.readString(result.doctrineCsvPath()).contains("doctrine"), "expected doctrine report rows");
        assertTrue(Files.readString(result.pipelineCsvPath()).contains("pipeline"), "expected pipeline report rows");
        assertTrue(Files.readString(result.policyDomainCsvPath()).contains("policy-domain"), "expected policy-domain report rows");
        assertTrue(Files.readString(result.compositionCsvPath()).contains("medianIdeology"), "expected composition report rows");
        String calibrationCsv = Files.readString(result.calibrationCsvPath());
        assertTrue(calibrationCsv.contains("profileKey"), "expected calibration profiles");
        assertTrue(calibrationCsv.contains("targetMethod"), "expected target method column");
        assertTrue(calibrationCsv.contains("reliability"), "expected reliability column");
        assertTrue(calibrationCsv.contains("useForValidation"), "expected validation-use column");
        assertTrue(calibrationCsv.contains("germany-bverfg-2024"), "expected comparative calibration profile");
        assertTrue(Files.readString(result.intervalCsvPath()).contains("cluster-bootstrap-runs"), "expected campaign bootstrap uncertainty bands");
        assertTrue(Files.readString(result.intervalCsvPath()).contains("legislativeResponseCredibility"), "expected response credibility uncertainty bands");
        assertTrue(Files.readString(result.intervalCsvPath()).contains("caseSelectionAccess"), "expected access uncertainty bands");
        assertTrue(Files.readString(result.periodIntervalCsvPath()).contains("cluster-bootstrap-runs"), "expected period bootstrap bands");
        assertTrue(Files.readString(result.doctrineIntervalCsvPath()).contains("cluster-bootstrap-runs"), "expected doctrine bootstrap bands");
        assertTrue(Files.readString(result.pipelineIntervalCsvPath()).contains("lower95"), "expected pipeline uncertainty bands");
        assertTrue(Files.readString(result.policyDomainIntervalCsvPath()).contains("cluster-bootstrap-runs"), "expected policy-domain bootstrap bands");
        assertTrue(Files.readString(result.compositionIntervalCsvPath()).contains("lower95"), "expected composition uncertainty bands");
        assertTrue(Files.readString(result.calibrationIntervalCsvPath()).contains("lower95"), "expected calibration uncertainty bands");
        assertTrue(Files.readString(result.markdownPath()).contains("Scenario Averages"), "expected Markdown summary");
        assertTrue(Files.readString(result.markdownPath()).contains("Mechanism Diagnostics"), "expected mechanism diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Period Diagnostics"), "expected period diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Doctrine Diagnostics"), "expected doctrine diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Pipeline Diagnostics"), "expected pipeline diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Policy Domain Diagnostics"), "expected policy-domain diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Composition Diagnostics"), "expected composition diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Uncertainty Diagnostics"), "expected uncertainty diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Calibration Diagnostics"), "expected calibration diagnostics");
        assertTrue(Files.exists(Path.of("config/comparative/constitutional-review-designs.csv")), "expected comparative design config");
        assertTrue(Files.exists(Path.of("config/comparative/synthetic-review-mechanisms.csv")), "expected synthetic mechanism config");
        assertTrue(Files.exists(Path.of("config/pipeline/us-scotus-pipeline.csv")), "expected pipeline config");
        assertTrue(Files.exists(Path.of("config/emergency/scotus-emergency-schema.csv")), "expected emergency schema config");
        assertTrue(Files.exists(Path.of("config/cost-benchmarks/institutional-costs.csv")), "expected cost benchmark config");
    }

    private static void pairedCampaignWritesArtifacts() throws Exception {
        Path tempDir = Files.createTempDirectory("court-paired-campaign");
        List<LegislativeSignal> signals = List.of(
                new LegislativeSignal(
                        "baseline",
                        "default-pass",
                        "Default pass",
                        PolicyDomain.CIVIL_RIGHTS,
                        0.48,
                        0.42,
                        0.51,
                        0.31,
                        0.44,
                        0.22,
                        0.18,
                        0.27,
                        0.52,
                        0.25,
                        0.36,
                        0.19,
                        0.08,
                        0.14,
                        0.07,
                        0.22,
                        0.18
                ),
                new LegislativeSignal(
                        "baseline",
                        "committee-regular-order",
                        "Committee regular order",
                        PolicyDomain.GOVERNANCE,
                        0.66,
                        0.71,
                        0.62,
                        0.02,
                        0.04,
                        0.10,
                        0.05,
                        0.08,
                        0.76,
                        0.08,
                        0.12,
                        0.06,
                        0.04,
                        0.06,
                        0.03,
                        0.08,
                        0.05
                )
        );
        CampaignResult result = new CampaignRunner().run(
                "v1-paired",
                WorldSpec.baseline(12),
                3,
                20260501L,
                tempDir,
                signals
        );
        assertTrue(Files.exists(result.csvPath()), "expected paired CSV artifact");
        assertTrue(Files.exists(result.periodCsvPath()), "expected paired period CSV artifact");
        assertTrue(Files.exists(result.doctrineCsvPath()), "expected paired doctrine CSV artifact");
        assertTrue(Files.exists(result.pipelineCsvPath()), "expected paired pipeline CSV artifact");
        assertTrue(Files.exists(result.policyDomainCsvPath()), "expected paired policy-domain CSV artifact");
        assertTrue(Files.exists(result.compositionCsvPath()), "expected paired composition CSV artifact");
        assertTrue(Files.exists(result.calibrationCsvPath()), "expected paired calibration CSV artifact");
        assertTrue(Files.exists(result.caseCsvGzPath()), "expected paired case-level artifact");
        assertTrue(Files.exists(result.intervalCsvPath()), "expected paired interval CSV artifact");
        assertTrue(Files.exists(result.periodIntervalCsvPath()), "expected paired period interval CSV artifact");
        assertTrue(Files.exists(result.doctrineIntervalCsvPath()), "expected paired doctrine interval CSV artifact");
        assertTrue(Files.exists(result.policyDomainIntervalCsvPath()), "expected paired policy-domain interval CSV artifact");
        assertTrue(Files.readString(result.csvPath()).contains("legislative-low-mandate"), "expected paired legislative cases");
        assertTrue(Files.readString(result.markdownPath()).contains("Paired Import Campaign"), "expected paired Markdown title");
    }

    private static void sensitivityCampaignWritesArtifacts() throws Exception {
        Path tempDir = Files.createTempDirectory("court-sensitivity-campaign");
        CampaignResult result = new CampaignRunner().run(
                "sensitivity",
                WorldSpec.baseline(10),
                2,
                20260501L,
                tempDir,
                List.of()
        );
        assertTrue(Files.exists(result.csvPath()), "expected sensitivity CSV artifact");
        assertTrue(Files.exists(result.periodCsvPath()), "expected sensitivity period CSV artifact");
        assertTrue(Files.exists(result.doctrineCsvPath()), "expected sensitivity doctrine CSV artifact");
        assertTrue(Files.exists(result.pipelineCsvPath()), "expected sensitivity pipeline CSV artifact");
        assertTrue(Files.exists(result.policyDomainCsvPath()), "expected sensitivity policy-domain CSV artifact");
        assertTrue(Files.exists(result.compositionCsvPath()), "expected sensitivity composition CSV artifact");
        assertTrue(Files.exists(result.calibrationCsvPath()), "expected sensitivity calibration CSV artifact");
        assertTrue(Files.exists(result.caseCsvGzPath()), "expected sensitivity case-level artifact");
        assertTrue(Files.exists(result.intervalCsvPath()), "expected sensitivity interval CSV artifact");
        assertTrue(Files.exists(result.periodIntervalCsvPath()), "expected sensitivity period interval CSV artifact");
        assertTrue(Files.exists(result.doctrineIntervalCsvPath()), "expected sensitivity doctrine interval CSV artifact");
        assertTrue(Files.exists(result.policyDomainIntervalCsvPath()), "expected sensitivity policy-domain interval CSV artifact");
        assertTrue(Files.readString(result.csvPath()).contains("high-emergency-pressure"), "expected sensitivity cases");
        assertTrue(Files.readString(result.markdownPath()).contains("Sensitivity Campaign"), "expected sensitivity Markdown title");
    }

    private static void validationCampaignWritesArtifacts() throws Exception {
        Path tempDir = Files.createTempDirectory("court-validation-campaign");
        CampaignResult result = new CampaignRunner().run(
                "validation",
                WorldSpec.baseline(10),
                2,
                20260501L,
                tempDir,
                List.of()
        );
        assertTrue(Files.exists(result.csvPath()), "expected validation CSV artifact");
        assertTrue(Files.exists(result.caseCsvGzPath()), "expected validation case-level artifact");
        assertTrue(Files.exists(result.intervalCsvPath()), "expected validation interval artifact");
        assertTrue(Files.exists(result.calibrationCsvPath()), "expected validation calibration artifact");
        assertTrue(Files.exists(result.doctrineCsvPath()), "expected validation doctrine artifact");
        String csv = Files.readString(result.csvPath());
        assertTrue(csv.contains("german-constitutional-court"), "expected German validation preset");
        assertTrue(csv.contains("south-african-constitutional-court"), "expected South African validation preset");
        assertTrue(csv.contains("uk-supreme-court"), "expected UK validation preset");
        assertTrue(csv.contains("echr-treaty-court"), "expected ECHR validation preset");
        assertTrue(csv.contains("cjeu-court-of-justice"), "expected CJEU validation preset");
        assertTrue(csv.contains("preliminaryReferenceRate"), "expected CJEU route metric");
        String calibrationCsv = Files.readString(result.calibrationCsvPath());
        assertTrue(calibrationCsv.contains("scdb-modern-merits-2000-2024"), "expected U.S. doctrine target profile");
        assertTrue(calibrationCsv.contains("scotus-emergency-2024-2025"), "expected emergency target profile");
        assertTrue(calibrationCsv.contains("uk-human-rights-doi-2025"), "expected verified UK declaration response target profile");
        assertTrue(calibrationCsv.contains("echr-2024"), "expected verified ECHR target profile");
        assertTrue(calibrationCsv.contains("france-conseil-qpc"), "expected verified France QPC target profile");
        assertTrue(calibrationCsv.contains("preliminary_reference_rate"), "expected verified CJEU route target");
        assertTrue(calibrationCsv.contains("sourceName"), "expected calibration source metadata");
        assertTrue(calibrationCsv.contains("targetN"), "expected calibration target sample-size metadata");
        assertValidationRowsAreSourceBacked(result.calibrationCsvPath());
        assertTrue(Files.readString(result.intervalCsvPath()).contains("cluster-bootstrap-runs"), "expected validation bootstrap intervals");
        assertTrue(Files.readString(result.markdownPath()).contains("Calibration Validation Campaign"), "expected validation Markdown title");
        assertTrue(Files.readString(result.markdownPath()).contains("config/context/country-year-context.csv"), "expected validation context provenance");
        assertTrue(Files.readString(result.manifestPath()).contains("config/context/country-year-context.csv"), "expected context provenance in manifest");
    }

    private static void assertValidationRowsAreSourceBacked(Path calibrationCsvPath) throws Exception {
        List<String[]> rows = readCsv(calibrationCsvPath);
        assertTrue(rows.size() > 1, "expected calibration rows");
        String[] header = rows.get(0);
        int profileKey = column(header, "profileKey");
        int targetKey = column(header, "targetKey");
        int sourceName = column(header, "sourceName");
        int sourceUrl = column(header, "sourceUrl");
        int reliability = column(header, "reliability");
        int useForValidation = column(header, "useForValidation");
        int modelObservedValue = column(header, "modelObservedValue");
        int lowerBound = column(header, "lowerBound");
        int upperBound = column(header, "upperBound");
        int lower95 = column(header, "lower95");
        int upper95 = column(header, "upper95");
        int withinTarget = column(header, "withinTarget");
        Map<String, Integer> validationCounts = new HashMap<>();
        Map<String, Boolean> validationTargets = new HashMap<>();
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if (!"true".equalsIgnoreCase(row[useForValidation])) {
                continue;
            }
            assertTrue(!row[sourceUrl].isBlank(), "validation row missing source URL: " + row[profileKey]);
            assertTrue(!"low".equalsIgnoreCase(row[reliability]), "low reliability row used for validation: " + row[profileKey]);
            assertTrue(!row[sourceName].equals("Comparative calibration research synthesis"), "comparative synthesis used for validation");
            assertTrue(!row[sourceName].equals("Institutional cost benchmark synthesis"), "cost synthesis used for validation");
            assertTrue(!row[sourceName].toLowerCase().contains("synthesis"), "synthesis source used for validation");
            assertTrue(!row[modelObservedValue].isBlank(), "validation row missing model observed value");
            assertTrue(Double.parseDouble(row[lower95]) <= Double.parseDouble(row[upper95]), "invalid interval bounds");
            assertTrue(row[withinTarget].equals("true") || row[withinTarget].equals("false"), "invalid withinTarget flag");
            double model = Double.parseDouble(row[modelObservedValue]);
            double lower = Double.parseDouble(row[lowerBound]);
            double upper = Double.parseDouble(row[upperBound]);
            boolean expectedWithin = lower <= model && model <= upper;
            assertTrue(Boolean.parseBoolean(row[withinTarget]) == expectedWithin, "withinTarget inconsistent with target range");
            validationCounts.merge(row[profileKey], 1, Integer::sum);
            validationTargets.put(row[profileKey] + "/" + row[targetKey], true);
        }
        assertTrue(validationCounts.size() == 7, "expected verified source-specific validation target families");
        assertTrue(validationCounts.getOrDefault("scotus-emergency-2024-2025", 0) == 3, "expected three emergency validation targets");
        assertTrue(validationCounts.getOrDefault("canada-scc-2024", 0) == 1, "expected Canada 2024 validation target");
        assertTrue(validationCounts.getOrDefault("france-conseil-qpc", 0) == 2, "expected France QPC validation targets");
        assertTrue(validationCounts.getOrDefault("uk-human-rights-doi-2025", 0) == 2, "expected two UK declaration-response validation targets");
        assertTrue(validationCounts.getOrDefault("uk-supreme-court-2024-2025", 0) == 2, "expected UKSC intake and case-selection validation targets");
        assertTrue(validationCounts.getOrDefault("echr-2024", 0) == 2, "expected two ECHR validation targets");
        assertTrue(validationCounts.getOrDefault("cjeu-2024", 0) == 3, "expected three CJEU route validation targets");
        assertTrue(validationTargets.containsKey("cjeu-2024/preliminary_reference_rate"), "missing CJEU preliminary-reference target");
        assertTrue(validationTargets.containsKey("cjeu-2024/appeal_route_rate"), "missing CJEU appeal-route target");
        assertTrue(validationTargets.containsKey("cjeu-2024/direct_action_rate"), "missing CJEU direct-action target");
        assertTrue(validationTargets.containsKey("uk-human-rights-doi-2025/legislative_response_credibility"), "missing UK legislative-response-credibility target");
        assertTrue(validationTargets.containsKey("uk-supreme-court-2024-2025/case_selection_access"), "missing UKSC case-selection-access proxy target");
    }

    private static String readGzipHeader(Path path) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new GZIPInputStream(Files.newInputStream(path)),
                StandardCharsets.UTF_8
        ))) {
            return reader.readLine();
        }
    }

    private static List<String[]> readCsv(Path path) throws Exception {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return reader.lines().map(SimulatorTests::parseCsvLine).toList();
        }
    }

    private static String[] parseCsvLine(String line) {
        java.util.ArrayList<String> values = new java.util.ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean quoted = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '"') {
                if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else {
                    quoted = !quoted;
                }
            } else if (ch == ',' && !quoted) {
                values.add(current.toString());
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        values.add(current.toString());
        return values.toArray(String[]::new);
    }

    private static int column(String[] header, String name) {
        for (int i = 0; i < header.length; i++) {
            if (header[i].equals(name)) {
                return i;
            }
        }
        throw new AssertionError("missing column: " + name);
    }

    private static void assertBetween(double value, String label) {
        assertTrue(value >= 0.0 && value <= 1.0, label + " out of range: " + value);
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
