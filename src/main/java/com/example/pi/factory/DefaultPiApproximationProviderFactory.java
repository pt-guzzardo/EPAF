package com.example.pi.factory;

import com.example.pi.provider.DefaultPiApproximationProvider;
import com.example.pi.provider.PiApproximationProvider;
import com.example.pi.strategy.ZhiChongzhiFractionStrategy;

/**
 * The default factory implementation that produces providers configured
 * with the ZhiChongzhiFractionStrategy.
 */
public class DefaultPiApproximationProviderFactory implements PiApproximationProviderFactory {
    @Override
    public PiApproximationProvider createProvider() {
        return new DefaultPiApproximationProvider(new ZhiChongzhiFractionStrategy());
    }
}
