package com.example.pi.command;

import com.example.pi.core.PiValueDTO;

/**
 * An interface representing a command to be executed.
 */
@FunctionalInterface
public interface Command {
    PiValueDTO execute() throws Exception;
}
