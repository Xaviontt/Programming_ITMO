package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;

public class ClearCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new IncorrectValueException();
            collectionManager.clear();
            System.out.println("Коллекция удалена");
            return true;
        } catch (IncorrectValueException e) {
            System.err.println("У этой команды нет парамметров! Введите: clear");
        }
        return false;
    }
}
