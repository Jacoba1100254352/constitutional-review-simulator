package courtsim.institution;

import courtsim.model.ChallengeObject;
import java.util.List;

/** Conditional allocation of an existing case disposition, not independent object-level voting. */
public final class ObjectDispositionModel {
	private ObjectDispositionModel() {}

	public static List<ObjectDisposition> resolve(List<ChallengeObject> objects, boolean meritsReview,
			boolean meritsInvalidated, boolean weakFormDeclaration, boolean suspendedDeclaration) {
		if (objects.isEmpty()) throw new IllegalArgumentException("a case needs at least one challenge object");
		if ((!meritsReview && (meritsInvalidated || weakFormDeclaration || suspendedDeclaration))
				|| (meritsInvalidated && weakFormDeclaration)
				|| (suspendedDeclaration && !meritsInvalidated && !weakFormDeclaration)) {
			throw new IllegalArgumentException("inconsistent case disposition");
		}
		double maximum = objects.stream().mapToDouble(ChallengeObject::vulnerability).max().orElseThrow();
		return objects.stream().map(object -> {
			ObjectDisposition.Result result;
			if (!meritsReview) result = ObjectDisposition.Result.NOT_REACHED;
			else if ((!meritsInvalidated && !weakFormDeclaration) || object.vulnerability() < maximum - 0.20) {
				result = ObjectDisposition.Result.UPHELD;
			} else if (weakFormDeclaration) result = ObjectDisposition.Result.DECLARATION;
			else if (object.kind() == ChallengeObject.Kind.GOVERNMENT_CONDUCT) result = ObjectDisposition.Result.CONDUCT_REMEDY;
			else result = ObjectDisposition.Result.NULLIFIED;
			return new ObjectDisposition(object, result, suspendedDeclaration
					&& object.kind() != ChallengeObject.Kind.GOVERNMENT_CONDUCT
					&& (result == ObjectDisposition.Result.NULLIFIED || result == ObjectDisposition.Result.DECLARATION));
		}).toList();
	}
}
