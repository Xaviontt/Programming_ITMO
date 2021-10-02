package utility.commands;

import common.general.StudyGroup;
import exceptions.IncorrectValueException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

public class ClearCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            collectionManager.clear();
            ResponseCreator.appendln("Коллекция удалена");
            return true;
        } catch (IncorrectValueException e) {
            ResponseCreator.error("У этой команды нет параметров! Введите: clear");
        }
        return false;
    }
}
