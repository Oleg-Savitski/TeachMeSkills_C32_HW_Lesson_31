package patterns.team.command.impl;

import patterns.team.command.Command;
import patterns.team.model.Device;

abstract class DeviceCommand implements Command {
    protected Device device;

    public DeviceCommand(Device device) {
        this.device = device;
    }
}