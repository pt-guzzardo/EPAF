package com.example.pi.facade;

import com.example.pi.exception.PiCalculationException;
import com.example.pi.factory.AbstractPiProviderFactory;
import com.example.pi.factory.ConcretePiProviderFactory;
import com.example.pi.locator.ServiceLocator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * An integration test for the PiServiceFacade.
 * This test validates that the entire dependency graph is correctly initialized
 * and that the public-facing API returns the expected result.
 */
class PiServiceFacadeTest {

    @BeforeAll
    static void bootstrap() {
        // The ServiceLocator must be primed with the necessary factory
        // before the Facade's singleton instance is created.
        if (ServiceLocator.getService(AbstractPiProviderFactory.class) == null) {
            ServiceLocator.registerService(AbstractPiProviderFactory.class, new ConcretePiProviderFactory());
        }
    }

    @Test
    @DisplayName("Facade should return the correct Pi approximation through the full stack")
    void testGetPiApproximation() throws PiCalculationException {
        // Arrange
        double expectedPi = 355.0 / 113.0;
        double delta = 0.000000001;
        PiServiceFacade facade = PiServiceFacade.getInstance();

        // Act
        double actualPi = facade.getPiApproximation();

        // Assert
        assertEquals(expectedPi, actualPi, delta, "The facade did not return the correct Pi value.");
    }
}
