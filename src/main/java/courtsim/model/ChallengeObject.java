package courtsim.model;

import java.util.Objects;

/** One challenged instrument or act in one case, not a count of provisions. */
public record ChallengeObject(String id, Kind kind, Jurisdiction jurisdiction, double vulnerability) {
	public enum Kind { STATUTE, REGULATION, GOVERNMENT_CONDUCT }

	public ChallengeObject {
		if (id == null || id.isBlank()) throw new IllegalArgumentException("object id is required");
		Objects.requireNonNull(kind, "object kind");
		Objects.requireNonNull(jurisdiction, "object jurisdiction");
		if (jurisdiction == Jurisdiction.MIXED_STATE_FEDERAL) {
			throw new IllegalArgumentException("an object must identify one government level");
		}
		if (!Double.isFinite(vulnerability) || vulnerability < 0 || vulnerability > 1) {
			throw new IllegalArgumentException("object vulnerability must be in [0,1]");
		}
	}
}
