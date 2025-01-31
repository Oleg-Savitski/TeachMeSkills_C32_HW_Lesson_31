package patterns.team.model;

public class Window extends Device {
    public Window(String name) {
        super(name);
    }

    public void open() {
        setState(true);
        System.out.println(name + " open.");
    }

    public void close() {
        setState(false);
        System.out.println(name + " closed");
    }
}