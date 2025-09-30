package com.example.pi.service;

import com.example.pi.observer.PiCalculationObserver;
import com.example.pi.provider.PiApproximationProvider;
import java.util.ArrayList;
import java.util.List;

/**
 * A fluent builder for constructing a PiServiceImpl instance.
 * Provides a flexible and readable way to configure the service.
 */
public class PiServiceBuilder {
    private PiApproximationProvider provider;
    private final List<PiCalculationObserver> observers = new ArrayList<>();

    public PiServiceBuilder withProvider(PiApproximationProvider provider) {
        this.provider = provider;
        return this;
    }

    public PiServiceBuilder withObserver(PiCalculationObserver observer) {
        this.observers.add(observer);
        return this;
    }

    // Package-private getters for the service implementation
    PiApproximationProvider getProvider() { return provider; }
    List<PiCalculationObserver> getObservers() { return observers; }

    public PiServiceImpl build() {
        if (provider == null) {
            throw new IllegalStateException("PiApproximationProvider cannot be null.");
        }
        return new PiServiceImpl(this);
    }
}
