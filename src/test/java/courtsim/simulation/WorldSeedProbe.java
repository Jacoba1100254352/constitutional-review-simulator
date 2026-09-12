package courtsim.simulation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.List;

/** Child-process fixture: unrelated identity-hash calls must not alter simulation draws. */
public final class WorldSeedProbe {
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < Integer.parseInt(args[0]); i++) System.identityHashCode(new Object());
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		for (DoctrineDocketProfile profile : DoctrineDocketProfile.values()) {
			var spec = WorldSpec.baseline(24).withDoctrineDocketProfile(profile);
			var results = new Simulator().compareDetailed(ScenarioCatalog.scenariosForKeys(List.of(
					"canadian-supreme-court", "weak-form-review", "reasoned-emergency-review")),
					spec, 3, 18221L, List.of());
			digest.update(results.toString().getBytes(StandardCharsets.UTF_8));
		}
		System.out.println(HexFormat.of().formatHex(digest.digest()));
	}
}
