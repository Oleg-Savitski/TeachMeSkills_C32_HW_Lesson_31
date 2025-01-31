package patterns.team.command.impl;

import patterns.team.model.CoffeeMaker;

public class CoffeeMakerCommand extends DeviceCommand {
    private boolean wasOn;

    public CoffeeMakerCommand(CoffeeMaker coffeeMaker) {
        super(coffeeMaker);
    }

    @Override
    public void execute() {
        CoffeeMaker coffeeMaker = (CoffeeMaker) device;
        wasOn = device.isOn();

        if (!wasOn) {
            device.setState(true);
        }
        coffeeMaker.brew();
    }

    @Override
    public void undo() {
        CoffeeMaker coffeeMaker = (CoffeeMaker) device;
        coffeeMaker.stop();

        if (!wasOn) {
            device.setState(false);
        }
    }
}