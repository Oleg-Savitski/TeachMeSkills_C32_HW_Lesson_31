package patterns.team.command.impl;

import patterns.team.model.SecuritySystem;

public class SecuritySystemCommand extends DeviceCommand {

    public SecuritySystemCommand(SecuritySystem securitySystem) {
        super(securitySystem);
    }

    @Override
    public void execute() {
        if (device.isOn()) {
            ((SecuritySystem) device).disarm();
        } else {
            ((SecuritySystem) device).arm();
        }
        device.setState(!device.isOn());
    }

    @Override
    public void undo() {
        execute();
    }
}