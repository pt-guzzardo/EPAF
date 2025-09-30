package com.example.pi.observer;

import java.time.Instant;

/**
 * A concrete observer that logs the calculated Pi value to the console.
 */
public class ConsoleLoggingPiObserver implements PiCalculationObserver {
    @Override
    public void onPiCalculated(double piValue) {
        System.out.println("[OBSERVER LOG] " + Instant.now() + ": Pi calculated with value: " + piValue);
    }
}
