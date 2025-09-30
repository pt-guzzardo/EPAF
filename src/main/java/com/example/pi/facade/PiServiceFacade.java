package com.example.pi.facade;

import com.example.pi.command.GetPiValueCommand;
import com.example.pi.command.PiCommandInvoker;
import com.example.pi.core.PiValueDTO;
import com.example.pi.decorator.AuditingPiApproximationProviderDecorator;
import com.example.pi.exception.PiCalculationException;
import com.example.pi.factory.AbstractPiProviderFactory;
import com.example.pi.factory.PiApproximationProviderFactory;
import com.example.pi.locator.ServiceLocator;
import com.example.pi.observer.ConsoleLoggingPiObserver;
import com.example.pi.provider.PiApproximationProvider;
import com.example.pi.service.PiService;
import com.example.pi.service.PiServiceImpl;

/**
 * A Singleton Facade that provides a simple, high-level interface to the
 * entire over-engineered Pi calculation subsystem. It initializes and
 * wires all the components together.
 */
public final class PiServiceFacade {

    private static volatile PiServiceFacade instance;

    private final PiService piService;

    private PiServiceFacade() {
        // --- Full System Initialization ---

        // 1. Use the Abstract Factory to get a concrete factory
        AbstractPiProviderFactory abstractFactory = ServiceLocator.getService(AbstractPiProviderFactory.class);
        PiApproximationProviderFactory providerFactory = abstractFactory.createProviderFactory();

        // 2. Use the concrete factory to create a provider
        PiApproximationProvider baseProvider = providerFactory.createProvider();

        // 3. Wrap the provider in a Decorator for auditing
        PiApproximationProvider decoratedProvider = new AuditingPiApproximationProviderDecorator(baseProvider);

        // 4. Use the Builder to construct the core service
        this.piService = PiServiceImpl.builder()
                .withProvider(decoratedProvider)
                .withObserver(new ConsoleLoggingPiObserver())
                .build();
    }

    /**
     * Provides the global access point to the PiServiceFacade instance.
     * Implements the double-checked locking singleton pattern for thread safety.
     *
     * @return The single instance of PiServiceFacade.
     */
    public static PiServiceFacade getInstance() {
        if (instance == null) {
            synchronized (PiServiceFacade.class) {
                if (instance == null) {
                    instance = new PiServiceFacade();
                }
            }
        }
        return instance;
    }

    /**
     * The simplified public method to get the value of Pi.
     * It internally uses the Command and Invoker patterns.
     *
     * @return The calculated value of Pi.
     * @throws PiCalculationException if any error occurs.
     */
    public double getPiApproximation() throws PiCalculationException {
        PiCommandInvoker invoker = new PiCommandInvoker();
        GetPiValueCommand command = new GetPiValueCommand(this.piService);
        try {
            PiValueDTO resultDTO = invoker.executeCommand(command);
            return resultDTO.getValue();
        } catch (Exception e) {
            throw new PiCalculationException("Facade failed to execute command", e);
        }
    }
}
