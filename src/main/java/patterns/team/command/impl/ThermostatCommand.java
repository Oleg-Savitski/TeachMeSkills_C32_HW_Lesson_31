package patterns.team.command.impl;

import patterns.team.model.Thermostat;

public class ThermostatCommand extends DeviceCommand {
    private final int temperature;
    private int previousTemperature;

    public ThermostatCommand(Thermostat thermostat, int temperature) {
        super(thermostat);
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        Thermostat thermostat = (Thermostat) device;
        previousTemperature = thermostat.getTemperature();
        thermostat.setTemperature(temperature);
    }

    @Override
    public void undo() {
        Thermostat thermostat = (Thermostat) device;
        thermostat.setTemperature(previousTemperature);
    }
}