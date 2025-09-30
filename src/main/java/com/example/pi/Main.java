package com.example.pi;

import com.example.pi.exception.PiCalculationException;
import com.example.pi.facade.PiServiceFacade;
import com.example.pi.factory.AbstractPiProviderFactory;
import com.example.pi.factory.ConcretePiProviderFactory;
import com.example.pi.locator.ServiceLocator;

/**
 * The main entry point of the Enterprise Pi Approximation Framework.
 * This class demonstrates the usage of the PiServiceFacade to retrieve Pi.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Enterprise Pi Approximation Framework...");

        // 1. Bootstrap: Register dependencies with the Service Locator
        ServiceLocator.registerService(AbstractPiProviderFactory.class, new ConcretePiProviderFactory());

        System.out.println("Framework Initialized. Requesting Pi value via Facade...");
        System.out.println("---------------------------------------------------------");

        try {
            // 2. Get the singleton Facade instance
            PiServiceFacade facade = PiServiceFacade.getInstance();

            // 3. Make the call. The facade handles all the internal complexity.
            double pi = facade.getPiApproximation();

            System.out.println("---------------------------------------------------------");
            System.out.println("Final Result Successfully Retrieved!");
            System.out.printf("The enterprise-grade approximation of Pi is: %.11f%n", pi);

        } catch (PiCalculationException e) {
            System.err.println("A catastrophic error occurred in the Pi Framework.");
            e.printStackTrace();
        }
    }
}
