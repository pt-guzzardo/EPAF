package com.example.pi.observer;

/**
 * The Subject interface for managing observers.
 */
public interface PiCalculationSubject {
    void registerObserver(PiCalculationObserver observer);
    void removeObserver(PiCalculationObserver observer);
    void notifyObservers(double piValue);
}
