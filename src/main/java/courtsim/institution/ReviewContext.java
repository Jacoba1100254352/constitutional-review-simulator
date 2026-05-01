package courtsim.institution;

import java.util.Random;

public final class ReviewContext {
    private final Random random;

    public ReviewContext(Random random) {
        this.random = random;
    }

    public Random random() {
        return random;
    }
}

