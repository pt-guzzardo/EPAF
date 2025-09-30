package com.example.pi.factory;

import com.example.pi.provider.PiApproximationProvider;

/**
 * A simple factory for creating PiApproximationProvider instances.
 */
public interface PiApproximationProviderFactory {
    PiApproximationProvider createProvider();
}
