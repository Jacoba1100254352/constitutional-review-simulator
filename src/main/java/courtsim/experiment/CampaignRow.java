package courtsim.experiment;

import courtsim.simulation.ScenarioReport;

public record CampaignRow(
        String caseKey,
        String caseName,
        String caseDescription,
        ScenarioReport report
) {
}

