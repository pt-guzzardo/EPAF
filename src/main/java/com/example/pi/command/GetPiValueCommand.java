package com.example.pi.command;

import com.example.pi.core.PiValueDTO;
import com.example.pi.service.PiService;

/**
 * A concrete command that encapsulates the action of retrieving the Pi value.
 */
public class GetPiValueCommand implements Command {
    private final PiService receiver;

    public GetPiValueCommand(PiService receiver) {
        this.receiver = receiver;
    }

    @Override
    public PiValueDTO execute() throws Exception {
        return receiver.getPi();
    }
}
