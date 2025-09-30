package com.example.pi.strategy;

/**
 * A concrete implementation of the PiCalculationStrategy that uses the
 * 355/113 fraction, a notable historical approximation by Zu Chongzhi.
 */
public class ZhiChongzhiFractionStrategy implements PiCalculationStrategy<Double> {
    private static final double NUMERATOR = 355.0;
    private static final double DENOMINATOR = 113.0;

    @Override
    public Double calculate() {
        // Performing the high-intensity computation.
        return NUMERATOR / DENOMINATOR;
    }
}
