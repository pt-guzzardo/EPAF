package com.example.pi.command;

import com.example.pi.core.PiValueDTO;

/**
 * The invoker class that takes a command and executes it.
 */
public class PiCommandInvoker {
    public PiValueDTO executeCommand(Command command) throws Exception {
        return command.execute();
    }
}
