package com.example.pi.observer;

/**
 * The Observer interface for receiving notifications of Pi calculations.
 */
public interface PiCalculationObserver {
    void onPiCalculated(double piValue);
}
