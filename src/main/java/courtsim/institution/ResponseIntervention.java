package courtsim.institution;

import java.util.Random;

/** Registered opt-in mechanism test, not an estimated country parameter. */
public record ResponseIntervention(double factor, long seed)
{
	public static final ResponseIntervention NONE = new ResponseIntervention(1.0, 0L);

	public ResponseIntervention {
		if (!Double.isFinite(factor) || factor < 0.0 || factor > 1.0) {
			throw new IllegalArgumentException("response factor must be finite and within [0,1]");
		}
	}

	public boolean retain(String caseId) {
		if (factor == 1.0) return true;
		if (factor == 0.0) return false;
		// Stable case-keyed stream, independent of voting/reaction draws. Use all
		// characters rather than record identity or a 32-bit String.hashCode seed.
		long mixed = seed;
		for (int i = 0; i < caseId.length(); i++) {
			mixed = (mixed ^ caseId.charAt(i)) * 0x100000001B3L;
		}
		mixed = (mixed ^ (mixed >>> 30)) * 0xBF58476D1CE4E5B9L;
		mixed = (mixed ^ (mixed >>> 27)) * 0x94D049BB133111EBL;
		mixed ^= mixed >>> 31;
		return new Random(mixed).nextDouble() < factor;
	}
}
