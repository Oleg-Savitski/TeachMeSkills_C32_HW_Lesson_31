package patterns.team.register;

import patterns.team.command.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private final List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void undoLastCommand() {
        if (!commands.isEmpty()) {
            Command lastCommand = commands.removeLast();
            lastCommand.undo();
        }
    }
}