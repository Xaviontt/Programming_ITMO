package commands;

import exceptions.IncorrectValueException;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new IncorrectValueException();
            return true;
        } catch (IncorrectValueException e) {
            System.err.println("У этой команды нет параметров! Введите: help");
        }
        return false;
    }
}
