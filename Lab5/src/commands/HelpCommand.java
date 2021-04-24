package commands;

import exceptions.IncorrectValueException;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        super("help", "display help for available commands");
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new IncorrectValueException();
            return true;
        } catch (IncorrectValueException e) {
            System.err.println("This command has no parameters! Enter: help");
        }
        return false;
    }
}
