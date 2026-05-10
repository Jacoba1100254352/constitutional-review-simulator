package courtsim.simulation;

import java.util.List;

public final class DirectionalScoreModelTests {
    private DirectionalScoreModelTests() {
    }

    public static void runAll() {
        scoreRemainsBoundedAndDelegatedFromReport();
        reasonedEmergencyReviewReducesShadowDocketRiskUnderEmergencyStress();
    }

    private static void scoreRemainsBoundedAndDelegatedFromReport() {
        List<ScenarioReport> reports = new Simulator().compare(
                ScenarioCatalog.scenariosForKeys(List.of(
                        "current-federal-court",
                        "mandatory-legislative-response",
                        "reasoned-emergency-review"
                )),
                WorldSpec.baseline(30).withRightsThreatRate(0.62).withEmergencyPressure(0.62),
                6,
                20260510L,
                List.of()
        );
        for (ScenarioReport report : reports) {
            double explicit = DirectionalScoreModel.score(report);
            assertBetween(explicit, "explicit directional score");
            assertTrue(Math.abs(explicit - report.directionalScore()) < 0.0000001,
                    "ScenarioReport should delegate directional score to DirectionalScoreModel");
        }
    }

    private static void reasonedEmergencyReviewReducesShadowDocketRiskUnderEmergencyStress() {
        List<ScenarioReport> reports = new Simulator().compare(
                ScenarioCatalog.scenariosForKeys(List.of(
                        "current-federal-court",
                        "reasoned-emergency-review"
                )),
                WorldSpec.baseline(80).withEmergencyPressure(0.88).withPartisanPressure(0.70),
                12,
                20260511L,
                List.of()
        );
        ScenarioReport current = reports.stream()
                .filter(report -> report.scenarioKey().equals("current-federal-court"))
                .findFirst()
                .orElseThrow();
        ScenarioReport reasoned = reports.stream()
                .filter(report -> report.scenarioKey().equals("reasoned-emergency-review"))
                .findFirst()
                .orElseThrow();

        assertTrue(reasoned.shadowDocketAbuse() < current.shadowDocketAbuse(),
                "reasoned emergency procedure should reduce shadow-docket abuse in the stress scenario");
        assertTrue(reasoned.emergencyReasonGivingRate() > current.emergencyReasonGivingRate(),
                "reasoned emergency procedure should increase emergency reason giving");
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
