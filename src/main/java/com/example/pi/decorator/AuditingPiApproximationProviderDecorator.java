package com.example.pi.decorator;

import com.example.pi.exception.PiCalculationException;
import com.example.pi.provider.PiApproximationProvider;

/**
 * A concrete decorator that adds auditing (console logging) before and after
 * the Pi value is retrieved.
 */
public class AuditingPiApproximationProviderDecorator extends PiApproximationProviderDecorator {

    public AuditingPiApproximationProviderDecorator(PiApproximationProvider decoratedProvider) {
        super(decoratedProvider);
    }

    @Override
    public double getPi() throws PiCalculationException {
        System.out.println("[AUDIT] Attempting to retrieve Pi value...");
        double pi = super.getPi();
        System.out.println("[AUDIT] Successfully retrieved Pi value: " + pi);
        return pi;
    }
}
