package patterns.team.command;

public interface Command {
    void execute();
    void undo();
}