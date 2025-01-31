package patterns.team.model;

public abstract class Device {
    protected boolean isOn = false;
    protected String name;

    public Device(String name) {
        this.name = name;
    }

    public void setState(boolean state) {
        isOn = state;
        System.out.println(name + (isOn ? " -> on" : " -> off"));
    }

    public boolean isOn() {
        return isOn;
    }
}