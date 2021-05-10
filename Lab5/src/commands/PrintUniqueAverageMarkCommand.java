package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;

public class PrintUniqueAverageMarkCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public PrintUniqueAverageMarkCommand(CollectionManager collectionManager) {
        super("print_unique_average_mark", "вывести уникальные значения поля averageMark всех элементов в коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            System.out.println("уникальные значения поля averageMark всех элементов в коллекции: " + collectionManager.uniqueAverageMark());
            return true;
        } catch (IncorrectValueException exception) {
            System.out.println("У этой команды нет параметров!");
        }
        return false;
    }
}
