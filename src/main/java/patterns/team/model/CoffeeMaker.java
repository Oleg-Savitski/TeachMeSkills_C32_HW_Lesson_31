package patterns.team.model;

public class CoffeeMaker extends Device {
    public CoffeeMaker(String name) {
        super(name);
    }

    public void brew() {
        System.out.println(name + " started making coffee.");
    }

    public void stop() {
        System.out.println(name + " stopped.");
    }
}