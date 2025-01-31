package patterns.team.app;

import patterns.team.command.impl.*;
import patterns.team.manager.SmartHome;
import patterns.team.model.*;

/**
 * In this class, there is a demonstration of the operation
 * of all the devices that are included in the program.
 * The devices are switched on randomly.
 */

public class ApplicationRunner {
    public static void main(String[] args) {

        Light livingRoomLight = new Light("Lighting in the house");
        Thermostat homeThermo = new Thermostat("The thermostat");
        CoffeeMaker coffeeMaker = new CoffeeMaker("Coffee Maker");
        SecuritySystem securitySystem = new SecuritySystem("Alarm system");
        Window livingRoomWindow = new Window("Windows on the ground floor");
        MusicPlayer musicPlayer = new MusicPlayer("Yandex Alice Music Player");

        SmartHome smartHome = new SmartHome();

        smartHome.executeCommand(new ToggleCommand(livingRoomLight));
        smartHome.executeCommand(new ThermostatCommand(homeThermo, 22));
        smartHome.executeCommand(new CoffeeMakerCommand(coffeeMaker));
        smartHome.executeCommand(new SecuritySystemCommand(securitySystem));
        smartHome.executeCommand(new WindowCommand(livingRoomWindow));
        smartHome.executeCommand(new MusicPlayerCommand(musicPlayer));

        smartHome.undoLastCommand();
        smartHome.undoLastCommand();
        smartHome.undoLastCommand();
        smartHome.undoLastCommand();
        smartHome.undoLastCommand();
        smartHome.undoLastCommand();
    }
}