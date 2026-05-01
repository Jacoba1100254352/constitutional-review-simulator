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
        assertTrue(Files.exists(result.markdownPath()), "expected Markdown artifact");
        assertTrue(Files.exists(result.manifestPath()), "expected manifest artifact");
        assertTrue(Files.readString(result.csvPath()).contains("legalStability"), "expected CSV header");
        assertTrue(Files.readString(result.markdownPath()).contains("Scenario Averages"), "expected Markdown summary");
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

