package courtsim.model;

import courtsim.simulation.WorldSpec;

import java.util.List;

public record CourtWorld(
        WorldSpec spec,
        List<CaseFile> docket
) {
}

