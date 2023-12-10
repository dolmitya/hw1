package edu.project4.UsefulClasses;

import java.util.concurrent.ThreadLocalRandom;

public record Coefficients(double a, double b, double c, double d, double e, double f) {
    public static Coefficients randomCoefficients() {
        while (true) {
            double a = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            double b = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            double c = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            double d = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            double e = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            double f = ThreadLocalRandom.current().nextDouble(-1.0, 1.0);
            if (isCoefValid(a, b, c, d, e, f)) {
                return new Coefficients(a, b, c, d, e, f);
            }
        }
    }

    private static boolean isCoefValid(double a, double b, double c, double d, double e, double f) {
        return (a * a + d * d < 1)
            && (b * b + e * e < 1)
            && (a * a + b * b + d * d + e * e < 1 + (a * e - b * d) * (a * e - b * d));
    }
}
