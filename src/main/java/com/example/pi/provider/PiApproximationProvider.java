package com.example.pi.provider;

import com.example.pi.exception.PiCalculationException;

/**
 * Defines the contract for an object that provides an approximation of Pi.
 */
public interface PiApproximationProvider {
    double getPi() throws PiCalculationException;
}
