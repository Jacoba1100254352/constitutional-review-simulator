package courtsim.institution;

import java.util.Random;

public final class ReviewContext {
    private final Random random;
    private final ReactionState reactionState;

    public ReviewContext(Random random, ReactionState reactionState) {
        this.random = random;
        this.reactionState = reactionState;
    }

    public Random random() {
        return random;
    }

    public ReactionState reactionState() {
        return reactionState;
    }
}
