package courtsim.experiment;

record CalibrationTarget(
        String profileKey,
        String court,
        String timePeriod,
        String key,
        String label,
        double lowerBound,
        double upperBound,
        double observedValue,
        int sampleSize,
        String unit,
        String method,
        String reliability,
        boolean useForValidation,
        String note,
        String sourceName,
        String sourceUrl,
        String targetFile
) {
}
