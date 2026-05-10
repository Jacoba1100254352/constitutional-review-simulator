package courtsim.experiment;

record CalibrationRow(
        CalibrationTarget target,
        double observedValue,
        int sampleSize,
        boolean withinTarget,
        double gap
) {
}
