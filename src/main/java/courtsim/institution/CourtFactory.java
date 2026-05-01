package courtsim.institution;

import courtsim.model.Justice;
import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public final class CourtFactory {
    private CourtFactory() {
    }

    public static List<Justice> create(DesignConfiguration configuration, WorldSpec worldSpec, Random random) {
        List<Justice> justices = new ArrayList<>();
        double spread = worldSpec.appointmentPolarization() * configuration.appointmentPolarizationMultiplier();
        double skew = configuration.appointmentSkew();
        for (int i = 0; i < configuration.courtSize(); i++) {
            double seatPosition = configuration.courtSize() == 1
                    ? 0.0
                    : -1.0 + (2.0 * i / (configuration.courtSize() - 1.0));
            double ideology = Values.signedClamp((seatPosition * spread) + (skew * 0.45) + gaussian(random, 0.16));
            double partisanAttachment = Values.clamp01(
                    0.30
                            + worldSpec.partisanPressure() * 0.42
                            + spread * 0.18
                            + random.nextDouble() * 0.14
                            - configuration.coalitionNorm() * 0.24
            );
            double rightsSensitivity = Values.clamp01(
                    0.42
                            + configuration.rightsPriority() * 0.38
                            + random.nextDouble() * 0.18
                            - Math.abs(ideology) * 0.06
            );
            double institutionalism = Values.clamp01(
                    0.35
                            + configuration.stabilityPreference() * 0.38
                            + configuration.independence() * 0.16
                            + random.nextDouble() * 0.14
            );
            double accountability = Values.clamp01(
                    configuration.accountabilityPressure()
                            + worldSpec.legislativeConflict() * 0.12
                            + random.nextDouble() * 0.10
            );
            double legitimacyConcern = Values.clamp01(
                    0.30
                            + configuration.transparency() * 0.24
                            + worldSpec.publicTrust() * 0.18
                            + random.nextDouble() * 0.18
            );
            double recusalStrictness = Values.clamp01(
                    0.20
                            + configuration.recusalMultiplier() * 0.40
                            + random.nextDouble() * 0.18
            );
            justices.add(new Justice(
                    "J" + (i + 1),
                    ideology,
                    partisanAttachment,
                    rightsSensitivity,
                    institutionalism,
                    accountability,
                    legitimacyConcern,
                    recusalStrictness
            ));
        }
        justices.sort(Comparator.comparingDouble(Justice::ideology));
        return List.copyOf(justices);
    }

    private static double gaussian(Random random, double standardDeviation) {
        return random.nextGaussian() * standardDeviation;
    }
}

