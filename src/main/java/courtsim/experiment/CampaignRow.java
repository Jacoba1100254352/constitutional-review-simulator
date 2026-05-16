package courtsim.experiment;


import courtsim.institution.CaseOutcome;
import courtsim.simulation.ScenarioReport;

import java.util.List;


public record CampaignRow(
		String caseKey,
		String caseName,
		String caseDescription,
		ScenarioReport report,
		List<CaseOutcome> outcomes,
		int casesPerRun,
		int runs
)
{
}
