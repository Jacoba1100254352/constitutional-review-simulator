package courtsim.experiment;

import java.nio.file.Path;
import java.util.List;

public record CampaignResult(
        String name,
        Path csvPath,
        Path periodCsvPath,
        Path doctrineCsvPath,
        Path pipelineCsvPath,
        Path policyDomainCsvPath,
        Path compositionCsvPath,
        Path calibrationCsvPath,
        Path intervalCsvPath,
        Path pipelineIntervalCsvPath,
        Path compositionIntervalCsvPath,
        Path calibrationIntervalCsvPath,
        Path markdownPath,
        Path manifestPath,
        List<CampaignRow> rows
) {
}
