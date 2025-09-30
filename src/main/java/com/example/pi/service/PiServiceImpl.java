package com.example.pi.service;

import com.example.pi.core.PiValueDTO;
import com.example.pi.exception.PiCalculationException;
import com.example.pi.observer.PiCalculationObserver;
import com.example.pi.observer.PiCalculationSubject;
import com.example.pi.provider.PiApproximationProvider;
import java.util.ArrayList;
import java.util.List;

/**
 * The core implementation of the PiService. It coordinates the provider
 * and observers to deliver the value of Pi.
 */
public class PiServiceImpl implements PiService, PiCalculationSubject {
    private final PiApproximationProvider provider;
    private final List<PiCalculationObserver> observers = new ArrayList<>();

    PiServiceImpl(PiServiceBuilder builder) {
        this.provider = builder.getProvider();
        builder.getObservers().forEach(this::registerObserver);
    }

    public static PiServiceBuilder builder() {
        return new PiServiceBuilder();
    }

    @Override
    public PiValueDTO getPi() throws PiCalculationException {
        double pi = provider.getPi();
        notifyObservers(pi);
        return new PiValueDTO(pi);
    }

    @Override
    public void registerObserver(PiCalculationObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(PiCalculationObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(double piValue) {
        for (PiCalculationObserver observer : observers) {
            observer.onPiCalculated(piValue);
        }
    }
}
