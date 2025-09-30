package com.example.pi.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for the core calculation algorithm implemented in the ZhiChongzhiFractionStrategy.
 * This test ensures the mathematical integrity of the primary business logic.
 */
class ZhiChongzhiFractionStrategyTest {

    private PiCalculationStrategy<Double> strategy;

    @BeforeEach
    void setUp() {
        strategy = new ZhiChongzhiFractionStrategy();
    }

    @Test
    @DisplayName("Should calculate Pi as 355/113 with high precision")
    void testCalculate() {
        // Arrange
        double expectedPi = 355.0 / 113.0;
        double delta = 0.000000001; // A small tolerance for floating-point comparison

        // Act
        double actualPi = strategy.calculate();

        // Assert
        assertEquals(expectedPi, actualPi, delta, "The calculated Pi value does not match the expected fraction.");
    }
}
