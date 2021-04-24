package commands;

import exceptions.IncorrectValueException;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "terminate the program without saving to file");
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new IncorrectValueException();
            return true;
        } catch (IncorrectValueException e) {
            System.err.println("This command has no parameters! You must enter: exit");
        }
        return false;
    }
}
