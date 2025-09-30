package com.example.pi.exception;

/**
 * A custom checked exception for handling fatal errors during the
 * highly complex process of Pi approximation.
 */
public class PiCalculationException extends Exception {
    public PiCalculationException(String message, Throwable cause) {
        super(message, cause);
    }
}
