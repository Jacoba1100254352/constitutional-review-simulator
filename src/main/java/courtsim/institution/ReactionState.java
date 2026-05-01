package courtsim.institution;

import courtsim.simulation.WorldSpec;
import courtsim.util.Values;

public final class ReactionState {
    private double publicTrust;
    private double legislativeConflict;
    private double courtCurbingPressure;
    private double overridePressure;
    private double amendmentPressure;
    private double complianceNorm;

    private ReactionState(
            double publicTrust,
            double legislativeConflict,
            double courtCurbingPressure,
            double overridePressure,
            double amendmentPressure,
            double complianceNorm
    ) {
        this.publicTrust = Values.clamp01(publicTrust);
        this.legislativeConflict = Values.clamp01(legislativeConflict);
        this.courtCurbingPressure = Values.clamp01(courtCurbingPressure);
        this.overridePressure = Values.clamp01(overridePressure);
        this.amendmentPressure = Values.clamp01(amendmentPressure);
        this.complianceNorm = Values.clamp01(complianceNorm);
    }

    public static ReactionState from(WorldSpec worldSpec) {
        return new ReactionState(
                worldSpec.publicTrust(),
                worldSpec.legislativeConflict(),
                worldSpec.legislativeConflict() * 0.22,
                worldSpec.legislativeConflict() * 0.18,
                0.08,
                0.72 + worldSpec.publicTrust() * 0.16 - worldSpec.legislativeConflict() * 0.18
        );
    }

    public double publicTrust() {
        return publicTrust;
    }

    public double legislativeConflict() {
        return legislativeConflict;
    }

    public double courtCurbingPressure() {
        return courtCurbingPressure;
    }

    public double overridePressure() {
        return overridePressure;
    }

    public double amendmentPressure() {
        return amendmentPressure;
    }

    public double complianceNorm() {
        return complianceNorm;
    }

    public void apply(
            double legitimacy,
            double constitutionalConflict,
            boolean meritsInvalidated,
            boolean emergencyReliefGranted,
            boolean overrideUsed,
            boolean complied,
            boolean defied,
            boolean workaround,
            boolean repeatedLitigation,
            boolean agencyNonacquiescence,
            boolean legislativeReenactment
    ) {
        double decisionShock = constitutionalConflict * 0.16
                + (emergencyReliefGranted ? 0.05 : 0.0)
                + (meritsInvalidated ? 0.04 : 0.0)
                + (overrideUsed ? 0.08 : 0.0)
                + (agencyNonacquiescence ? 0.035 : 0.0)
                + (legislativeReenactment ? 0.030 : 0.0);
        double legitimacyGain = Math.max(0.0, legitimacy - 0.58) * 0.08;
        publicTrust = Values.clamp01(publicTrust + legitimacyGain - decisionShock + (complied ? 0.018 : -0.025));

        legislativeConflict = Values.clamp01(
                legislativeConflict
                        + constitutionalConflict * 0.12
                        + (meritsInvalidated ? 0.035 : 0.0)
                        + (emergencyReliefGranted ? 0.025 : 0.0)
                        + (agencyNonacquiescence ? 0.030 : 0.0)
                        + (legislativeReenactment ? 0.028 : 0.0)
                        - legitimacy * 0.045
                        - (complied ? 0.012 : 0.0)
        );
        courtCurbingPressure = Values.clamp01(
                courtCurbingPressure
                        + legislativeConflict * 0.055
                        + (meritsInvalidated ? 0.045 : 0.0)
                        + (emergencyReliefGranted ? 0.035 : 0.0)
                        + (agencyNonacquiescence ? 0.030 : 0.0)
                        - legitimacy * 0.040
        );
        overridePressure = Values.clamp01(
                overridePressure
                        + (meritsInvalidated ? 0.060 : 0.0)
                        + (legislativeReenactment ? 0.045 : 0.0)
                        + legislativeConflict * 0.040
                        - publicTrust * 0.030
                        - (overrideUsed ? 0.050 : 0.0)
        );
        amendmentPressure = Values.clamp01(
                amendmentPressure
                        + constitutionalConflict * 0.050
                        + (defied ? 0.050 : 0.0)
                        + (repeatedLitigation ? 0.035 : 0.0)
                        + (agencyNonacquiescence ? 0.030 : 0.0)
                        - legitimacy * 0.025
        );
        complianceNorm = Values.clamp01(
                complianceNorm
                        + (complied ? 0.020 : -0.035)
                        - courtCurbingPressure * 0.020
                        - (workaround ? 0.020 : 0.0)
                        - (agencyNonacquiescence ? 0.018 : 0.0)
        );
    }
}
