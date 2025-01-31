package patterns.team.command.impl;

import patterns.team.model.MusicPlayer;

public class MusicPlayerCommand extends DeviceCommand {

    public MusicPlayerCommand(MusicPlayer musicPlayer) {
        super(musicPlayer);
    }

    @Override
    public void execute() {
        boolean previousState = device.isOn();
        if (previousState) {
            ((MusicPlayer) device).stop();
        } else {
            ((MusicPlayer) device).play();
        }
        device.setState(!previousState);
    }

    @Override
    public void undo() {
        execute();
    }
}