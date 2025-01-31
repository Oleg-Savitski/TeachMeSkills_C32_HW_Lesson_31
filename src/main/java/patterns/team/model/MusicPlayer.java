package patterns.team.model;

public class MusicPlayer extends Device {
    public MusicPlayer(String name) {
        super(name);
    }

    public void play() {
        setState(true);
        System.out.println(name + " playing music.");
    }

    public void stop() {
        setState(false);
        System.out.println(name + " stopped the music.");
    }
}