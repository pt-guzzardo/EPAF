package com.example.pi.factory;

import com.example.pi.strategy.PiCalculationStrategy;
import com.example.pi.strategy.ZhiChongzhiFractionStrategy;

/**
 * A concrete implementation of the abstract factory, providing a specific
 * family of Pi components.
 */
public class ConcretePiProviderFactory implements AbstractPiProviderFactory {
    @Override
    public PiApproximationProviderFactory createProviderFactory() {
        return new DefaultPiApproximationProviderFactory();
    }

    @Override
    public PiCalculationStrategy<Double> createCalculationStrategy() {
        return new ZhiChongzhiFractionStrategy();
    }
}
