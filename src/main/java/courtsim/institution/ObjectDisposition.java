package courtsim.institution;

import courtsim.model.ChallengeObject;
import java.util.Objects;

public record ObjectDisposition(ChallengeObject object, Result result, boolean suspended) {
	public enum Result { NOT_REACHED, UPHELD, NULLIFIED, CONDUCT_REMEDY, DECLARATION }

	public ObjectDisposition {
		Objects.requireNonNull(object, "challenge object");
		Objects.requireNonNull(result, "disposition");
		if (result == Result.NULLIFIED && object.kind() == ChallengeObject.Kind.GOVERNMENT_CONDUCT) {
			throw new IllegalArgumentException("conduct relief is not instrument nullification");
		}
		if (result == Result.CONDUCT_REMEDY && object.kind() != ChallengeObject.Kind.GOVERNMENT_CONDUCT) {
			throw new IllegalArgumentException("conduct remedy requires a conduct object");
		}
		if (suspended && (object.kind() == ChallengeObject.Kind.GOVERNMENT_CONDUCT
				|| (result != Result.NULLIFIED && result != Result.DECLARATION))) {
			throw new IllegalArgumentException("only an instrument remedy can be suspended");
		}
	}

	public boolean statuteDisposition() {
		return object.kind() == ChallengeObject.Kind.STATUTE && result != Result.NOT_REACHED;
	}

	public boolean statuteNullification() {
		return statuteDisposition() && result == Result.NULLIFIED;
	}
}
