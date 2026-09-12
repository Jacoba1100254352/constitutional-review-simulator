package courtsim.simulation;

import courtsim.model.DoctrineArea;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/** Opt-in categorical docket law. No observed test frequencies are fitted here. */
public record DoctrineDistribution(String key, List<Double> weights)
{
	public DoctrineDistribution {
		if (key == null || !key.matches("[a-z0-9][a-z0-9-]*")) {
			throw new IllegalArgumentException("distribution needs a stable lowercase key");
		}
		weights = List.copyOf(weights);
		if (weights.size() != DoctrineArea.values().length
				|| weights.stream().anyMatch(value -> !Double.isFinite(value) || value < 0.0)) {
			throw new IllegalArgumentException("one finite nonnegative weight is required per doctrine");
		}
		if (Math.abs(weights.stream().mapToDouble(Double::doubleValue).sum() - 1.0) > 1e-12) {
			throw new IllegalArgumentException("doctrine weights must sum to one; no silent renormalization");
		}
	}

	public DoctrineArea sample(Random random) {
		double draw = random.nextDouble();
		double cumulative = 0.0;
		DoctrineArea[] areas = DoctrineArea.values();
		for (int i = 0; i < areas.length; i++) {
			cumulative += weights.get(i);
			if (draw < cumulative) return areas[i];
		}
		return areas[areas.length - 1];
	}

	/** The generated contract is deliberately a simple, strict, unquoted numeric CSV. */
	public static List<DoctrineDistribution> readCsv(Path path) throws IOException {
		List<String> lines = Files.readAllLines(path);
		String expected = "profile," + Arrays.stream(DoctrineArea.values()).map(Enum::name).collect(Collectors.joining(","));
		if (lines.isEmpty() || !lines.get(0).equals(expected)) {
			throw new IllegalArgumentException("historical docket profile header/order mismatch");
		}
		List<DoctrineDistribution> distributions = new ArrayList<>();
		var keys = new HashSet<String>();
		for (String line : lines.subList(1, lines.size())) {
			String[] fields = line.split(",", -1);
			if (fields.length != DoctrineArea.values().length + 1 || !keys.add(fields[0])) {
				throw new IllegalArgumentException("duplicate profile or incorrect profile row width");
			}
			List<Double> weights = Arrays.stream(fields).skip(1).map(Double::parseDouble).toList();
			distributions.add(new DoctrineDistribution(fields[0], weights));
		}
		if (distributions.isEmpty()) throw new IllegalArgumentException("no historical docket profiles");
		return List.copyOf(distributions);
	}
}
