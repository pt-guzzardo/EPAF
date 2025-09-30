package com.example.pi.strategy;

/**
 * An interface defining the contract for a Pi calculation strategy.
 * This allows the algorithm for approximating Pi to be selected at runtime.
 *
 * @param <T> The numeric type of the result (e.g., Double, BigDecimal).
 */
@FunctionalInterface
public interface PiCalculationStrategy<T extends Number> {
    T calculate();
}
