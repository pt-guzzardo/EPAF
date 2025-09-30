package com.example.pi.factory;

import com.example.pi.strategy.PiCalculationStrategy;

/**
 * An abstract factory for creating families of Pi-related components.
 * This provides an interface for creating both providers and strategies.
 */
public interface AbstractPiProviderFactory {
    PiApproximationProviderFactory createProviderFactory();
    PiCalculationStrategy<Double> createCalculationStrategy();
}
