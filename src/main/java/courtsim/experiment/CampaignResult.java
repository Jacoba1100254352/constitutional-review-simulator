package courtsim.experiment;

import java.nio.file.Path;
import java.util.List;

public record CampaignResult(
        String name,
        Path csvPath,
        Path periodCsvPath,
        Path doctrineCsvPath,
        Path markdownPath,
        Path manifestPath,
        List<CampaignRow> rows
) {
}
