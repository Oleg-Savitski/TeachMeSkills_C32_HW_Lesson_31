package patterns.team.model;

public class SecuritySystem extends Device {
    public SecuritySystem(String name) {
        super(name);
    }

    public void arm() {
        System.out.println(name + " -> on");
    }

    public void disarm() {
        System.out.println(name + " -> off");
    }
}