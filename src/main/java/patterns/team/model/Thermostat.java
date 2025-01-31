package patterns.team.model;

public class Thermostat extends Device {
    private int temperature = 20;

    public Thermostat(String name) {
        super(name);
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println(name + " the temperature is set -> " + temp + "°C");
    }

    public int getTemperature() {
        return temperature;
    }
}