package courtsim.util;

import java.util.Locale;

public final class Values {
    private Values() {
    }

    public static double clamp01(double value) {
        return clamp(value, 0.0, 1.0);
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static double signedClamp(double value) {
        return clamp(value, -1.0, 1.0);
    }

    public static double ratio(int numerator, int denominator) {
        if (denominator == 0) {
            return 0.0;
        }
        return (double) numerator / denominator;
    }

    public static double average(double... values) {
        if (values.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (double value : values) {
            sum += clamp01(value);
        }
        return sum / values.length;
    }

    public static double lowerIsBetter(double value) {
        return 1.0 - clamp01(value);
    }

    public static double stableUnit(String value) {
        int hash = value == null ? 0 : value.hashCode();
        long unsigned = Integer.toUnsignedLong(hash);
        return (unsigned % 10_000L) / 10_000.0;
    }

    public static double stableSigned(String value) {
        return stableUnit(value) < 0.5 ? -1.0 : 1.0;
    }

    public static String format(double value) {
        return String.format(Locale.ROOT, "%.3f", value);
    }
}

