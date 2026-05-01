package courtsim.simulation;

import courtsim.institution.ReviewProcess;
import courtsim.model.CourtWorld;

import java.util.Random;

public interface Scenario {
    String key();

    String name();

    ReviewProcess buildProcess(CourtWorld world, Random random);
}

