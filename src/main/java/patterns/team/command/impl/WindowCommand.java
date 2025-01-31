package patterns.team.command.impl;

import patterns.team.model.Window;

public class WindowCommand extends DeviceCommand {

    public WindowCommand(Window window) {
        super(window);
    }

    @Override
    public void execute() {
        boolean previousState = device.isOn();
        if (previousState) {
            ((Window) device).close();
        } else {
            ((Window) device).open();
        }
        device.setState(!previousState);
    }

    @Override
    public void undo() {
        execute();
    }
}