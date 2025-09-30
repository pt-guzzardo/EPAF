package com.example.pi.service;

import com.example.pi.core.PiValueDTO;
import com.example.pi.exception.PiCalculationException;

/**
 * Defines the primary business interface for the Pi calculation service.
 */
public interface PiService {
    PiValueDTO getPi() throws PiCalculationException;
}
