package patterns.team.command.impl;

import patterns.team.model.Device;

public class ToggleCommand extends DeviceCommand {
    private boolean previousState;

    public ToggleCommand(Device device) {
        super(device);
    }

    @Override
    public void execute() {
        previousState = device.isOn();
        device.setState(!previousState);
    }

    @Override
    public void undo() {
        device.setState(previousState);
    }
}