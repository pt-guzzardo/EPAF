package com.example.pi.service;

import com.example.pi.core.PiValueDTO;
import com.example.pi.exception.PiCalculationException;
import com.example.pi.observer.PiCalculationObserver;
import com.example.pi.provider.PiApproximationProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit test for the PiServiceImpl.
 * This test ensures that the service layer correctly orchestrates its dependencies,
 * including the provider and observers.
 */
class PiServiceImplTest {

    @Test
    @DisplayName("Should get Pi from provider, notify observers, and return DTO")
    void testGetPi() throws PiCalculationException {
        // Arrange
        double expectedPiValue = 3.14159265;
        PiApproximationProvider mockProvider = mock(PiApproximationProvider.class);
        PiCalculationObserver mockObserver = mock(PiCalculationObserver.class);

        when(mockProvider.getPi()).thenReturn(expectedPiValue);

        PiService piService = PiServiceImpl.builder()
                .withProvider(mockProvider)
                .withObserver(mockObserver)
                .build();

        // Act
        PiValueDTO resultDto = piService.getPi();

        // Assert
        // 1. Verify the provider was called
        verify(mockProvider).getPi();

        // 2. Verify the observer was notified with the correct value
        verify(mockObserver).onPiCalculated(expectedPiValue);

        // 3. Verify the returned DTO contains the correct value
        assertEquals(expectedPiValue, resultDto.getValue(), "The DTO should contain the value from the provider.");
    }
}
