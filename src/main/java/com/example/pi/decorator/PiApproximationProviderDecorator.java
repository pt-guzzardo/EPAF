package com.example.pi.decorator;

import com.example.pi.exception.PiCalculationException;
import com.example.pi.provider.PiApproximationProvider;

/**
 * Abstract decorator class for PiApproximationProvider.
 */
public abstract class PiApproximationProviderDecorator implements PiApproximationProvider {
    protected final PiApproximationProvider decoratedProvider;

    public PiApproximationProviderDecorator(PiApproximationProvider decoratedProvider) {
        this.decoratedProvider = decoratedProvider;
    }

    @Override
    public double getPi() throws PiCalculationException {
        return decoratedProvider.getPi();
    }
}
