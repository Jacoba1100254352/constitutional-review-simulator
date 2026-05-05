package courtsim.simulation;

import courtsim.institution.ReviewMechanism;
import courtsim.institution.ReviewProcess;
import courtsim.institution.ScenarioKind;
import courtsim.model.CourtWorld;

import java.util.Random;

public interface Scenario {
    String key();

    String name();

    default ScenarioKind kind() {
        return ScenarioKind.COURT_VARIANT;
    }

    default ReviewMechanism mechanism() {
        return ReviewMechanism.STRONG_FORM_COURT;
    }

    ReviewProcess buildProcess(CourtWorld world, Random random, int reviewPeriod);
}
