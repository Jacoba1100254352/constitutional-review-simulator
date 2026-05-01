package courtsim;

import courtsim.experiment.CampaignResult;
import courtsim.experiment.CampaignRunner;
import courtsim.importer.LegislativeOutputImporter;
import courtsim.model.LegislativeSignal;
import courtsim.simulation.Scenario;
import courtsim.simulation.ScenarioCatalog;
import courtsim.simulation.ScenarioReport;
import courtsim.simulation.Simulator;
import courtsim.simulation.WorldSpec;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class SimulatorTests {
    private SimulatorTests() {
    }

    public static void main(String[] args) throws Exception {
        scenarioCatalogSelectsKnownKeys();
        simulatorProducesReports();
        legislativeImporterToleratesCampaignCsv();
        campaignWritesArtifacts();
        pairedCampaignWritesArtifacts();
        sensitivityCampaignWritesArtifacts();
        System.out.println("All simulator tests passed.");
    }

    private static void scenarioCatalogSelectsKnownKeys() {
        List<Scenario> scenarios = ScenarioCatalog.scenariosForKeys(List.of(
                "current-federal-court",
                "constitutional-council",
                "dual-cross-checking-courts"
        ));
        assertTrue(scenarios.size() == 3, "expected selected scenarios");
        assertTrue(scenarios.get(1).name().contains("constitutional council"), "expected council scenario name");
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
            assertTrue(!report.periodReports().isEmpty(), "expected period diagnostics");
            assertTrue(!report.doctrineReports().isEmpty(), "expected doctrine diagnostics");
            assertTrue(!report.pipelineReports().isEmpty(), "expected pipeline diagnostics");
            assertTrue(!report.compositionReports().isEmpty(), "expected composition diagnostics");
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
        assertTrue(Files.exists(result.compositionCsvPath()), "expected composition CSV artifact");
        assertTrue(Files.exists(result.calibrationCsvPath()), "expected calibration CSV artifact");
        assertTrue(Files.exists(result.markdownPath()), "expected Markdown artifact");
        assertTrue(Files.exists(result.manifestPath()), "expected manifest artifact");
        assertTrue(Files.readString(result.csvPath()).contains("legalStability"), "expected CSV header");
        assertTrue(Files.readString(result.csvPath()).contains("emergencyReliefRate"), "expected split emergency metric");
        assertTrue(Files.readString(result.csvPath()).contains("complianceRate"), "expected compliance metric");
        assertTrue(Files.readString(result.csvPath()).contains("executiveImplementationRate"), "expected enforcement metric");
        assertTrue(Files.readString(result.csvPath()).contains("stateFederalTension"), "expected hierarchy metric");
        assertTrue(Files.readString(result.periodCsvPath()).contains("period"), "expected period report rows");
        assertTrue(Files.readString(result.doctrineCsvPath()).contains("doctrine"), "expected doctrine report rows");
        assertTrue(Files.readString(result.pipelineCsvPath()).contains("pipeline"), "expected pipeline report rows");
        assertTrue(Files.readString(result.compositionCsvPath()).contains("medianIdeology"), "expected composition report rows");
        assertTrue(Files.readString(result.calibrationCsvPath()).contains("legitimacy_trust_gradient"), "expected calibration rows");
        assertTrue(Files.readString(result.markdownPath()).contains("Scenario Averages"), "expected Markdown summary");
        assertTrue(Files.readString(result.markdownPath()).contains("Period Diagnostics"), "expected period diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Doctrine Diagnostics"), "expected doctrine diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Pipeline Diagnostics"), "expected pipeline diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Composition Diagnostics"), "expected composition diagnostics");
        assertTrue(Files.readString(result.markdownPath()).contains("Calibration Diagnostics"), "expected calibration diagnostics");
    }

    private static void pairedCampaignWritesArtifacts() throws Exception {
        Path tempDir = Files.createTempDirectory("court-paired-campaign");
        List<LegislativeSignal> signals = List.of(
                new LegislativeSignal(
                        "baseline",
                        "default-pass",
                        "Default pass",
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
        assertTrue(Files.exists(result.compositionCsvPath()), "expected paired composition CSV artifact");
        assertTrue(Files.exists(result.calibrationCsvPath()), "expected paired calibration CSV artifact");
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
        assertTrue(Files.exists(result.compositionCsvPath()), "expected sensitivity composition CSV artifact");
        assertTrue(Files.exists(result.calibrationCsvPath()), "expected sensitivity calibration CSV artifact");
        assertTrue(Files.readString(result.csvPath()).contains("high-emergency-pressure"), "expected sensitivity cases");
        assertTrue(Files.readString(result.markdownPath()).contains("Sensitivity Campaign"), "expected sensitivity Markdown title");
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
