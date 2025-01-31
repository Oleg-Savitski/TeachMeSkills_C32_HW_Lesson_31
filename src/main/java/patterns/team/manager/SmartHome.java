package patterns.team.manager;

import patterns.team.command.Command;
import patterns.team.register.CommandHistory;

public class SmartHome {
    private final CommandHistory history = new CommandHistory();

    public void executeCommand(Command command) {
        command.execute();
        history.addCommand(command);
    }

    public void undoLastCommand() {
        history.undoLastCommand();
    }
}