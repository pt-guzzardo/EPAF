package com.example.pi.core;

import java.io.Serializable;

/**
 * A Data Transfer Object for encapsulating the value of Pi.
 * This class ensures that the Pi value is transported in a standardized,
 * serializable container across different architectural layers.
 */
public final class PiValueDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double value;

    public PiValueDTO(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PiValueDTO{value=" + value + "}";
    }
}
