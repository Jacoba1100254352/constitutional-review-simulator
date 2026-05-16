package courtsim.simulation;


import courtsim.institution.CaseOutcome;

import java.util.List;


public record ScenarioRunResult(
		String scenarioKey,
		String scenarioName,
		List<CaseOutcome> outcomes,
		ScenarioReport report
)
{
}
