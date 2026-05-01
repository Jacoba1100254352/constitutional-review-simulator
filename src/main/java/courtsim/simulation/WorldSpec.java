package courtsim.simulation;

import courtsim.util.Values;

public record WorldSpec(
        int caseCount,
        int reviewPeriods,
        double appointmentPolarization,
        double rightsThreatRate,
        double emergencyPressure,
        double legislativeConflict,
        double publicTrust,
        double partisanPressure
) {
    public WorldSpec {
        if (caseCount <= 0) {
            throw new IllegalArgumentException("caseCount must be positive");
        }
        if (reviewPeriods <= 0) {
            throw new IllegalArgumentException("reviewPeriods must be positive");
        }
        appointmentPolarization = Values.clamp01(appointmentPolarization);
        rightsThreatRate = Values.clamp01(rightsThreatRate);
        emergencyPressure = Values.clamp01(emergencyPressure);
        legislativeConflict = Values.clamp01(legislativeConflict);
        publicTrust = Values.clamp01(publicTrust);
        partisanPressure = Values.clamp01(partisanPressure);
    }

    public static WorldSpec baseline(int caseCount) {
        return new WorldSpec(caseCount, 4, 0.62, 0.36, 0.28, 0.42, 0.58, 0.55);
    }

    public WorldSpec withCaseCount(int newCaseCount) {
        return new WorldSpec(
                newCaseCount,
                reviewPeriods,
                appointmentPolarization,
                rightsThreatRate,
                emergencyPressure,
                legislativeConflict,
                publicTrust,
                partisanPressure
        );
    }

    public WorldSpec withReviewPeriods(int newReviewPeriods) {
        return new WorldSpec(
                caseCount,
                newReviewPeriods,
                appointmentPolarization,
                rightsThreatRate,
                emergencyPressure,
                legislativeConflict,
                publicTrust,
                partisanPressure
        );
    }

    public WorldSpec withAppointmentPolarization(double value) {
        return new WorldSpec(caseCount, reviewPeriods, value, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, partisanPressure);
    }

    public WorldSpec withRightsThreatRate(double value) {
        return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, value, emergencyPressure, legislativeConflict, publicTrust, partisanPressure);
    }

    public WorldSpec withEmergencyPressure(double value) {
        return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, value, legislativeConflict, publicTrust, partisanPressure);
    }

    public WorldSpec withLegislativeConflict(double value) {
        return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, value, publicTrust, partisanPressure);
    }

    public WorldSpec withPublicTrust(double value) {
        return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, value, partisanPressure);
    }

    public WorldSpec withPartisanPressure(double value) {
        return new WorldSpec(caseCount, reviewPeriods, appointmentPolarization, rightsThreatRate, emergencyPressure, legislativeConflict, publicTrust, value);
    }
}
