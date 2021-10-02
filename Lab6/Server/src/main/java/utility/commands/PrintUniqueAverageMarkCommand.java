package utility.commands;

import common.general.StudyGroup;
import exceptions.IncorrectValueException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

public class PrintUniqueAverageMarkCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public PrintUniqueAverageMarkCommand(CollectionManager collectionManager) {
        super("print_unique_average_mark", "вывести уникальные значения поля averageMark всех элементов в коллекции");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            ResponseCreator.appendln("уникальные значения поля averageMark всех элементов в коллекции: " + collectionManager.uniqueAverageMark());
            return true;
        } catch (IncorrectValueException exception) {
            ResponseCreator.error("У этой команды нет параметров!");
        }
        return false;
    }
}
