package commands;

import exceptions.IncorrectValueException;

public class ExitCommand extends AbstractCommand {
    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл)");
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new IncorrectValueException();
            return true;
        } catch (IncorrectValueException e) {
            System.err.println("У этой команды нет парамтров! Введите: exit");
        }
        return false;
    }
}
