package com.example.pi.provider;

import com.example.pi.exception.PiCalculationException;
import com.example.pi.strategy.PiCalculationStrategy;

/**
 * The default implementation of a PiApproximationProvider. It delegates the
 * actual calculation to a configured PiCalculationStrategy.
 */
public class DefaultPiApproximationProvider implements PiApproximationProvider {
    private final PiCalculationStrategy<Double> strategy;

    public DefaultPiApproximationProvider(PiCalculationStrategy<Double> strategy) {
        this.strategy = strategy;
    }

    @Override
    public double getPi() throws PiCalculationException {
        try {
            return strategy.calculate();
        } catch (Exception e) {
            // This can never happen, but we must be robust.
            throw new PiCalculationException("Unforeseen error in pi calculation strategy.", e);
        }
    }
}
