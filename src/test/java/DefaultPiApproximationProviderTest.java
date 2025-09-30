package com.example.pi.provider;

import com.example.pi.exception.PiCalculationException;
import com.example.pi.strategy.PiCalculationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Unit test for the DefaultPiApproximationProvider.
 * This test verifies that the provider correctly delegates the calculation to its strategy.
 */
@ExtendWith(MockitoExtension.class)
class DefaultPiApproximationProviderTest {

    @Mock
    private PiCalculationStrategy<Double> mockStrategy;

    @InjectMocks
    private DefaultPiApproximationProvider provider;

    @Test
    @DisplayName("Should return the value from the calculation strategy")
    void testGetPi() throws PiCalculationException {
        // Arrange
        double expectedPi = 3.14159;
        when(mockStrategy.calculate()).thenReturn(expectedPi);

        // Act
        double actualPi = provider.getPi();

        // Assert
        assertEquals(expectedPi, actualPi, "Provider should return the value from its strategy.");
        verify(mockStrategy).calculate(); // Verify that the strategy's calculate method was called
    }
}
