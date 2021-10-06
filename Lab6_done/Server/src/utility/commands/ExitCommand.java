package utility.commands;

import common.general.StudyGroup;
import exceptions.IncorrectValueException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

public class ExitCommand extends AbstractCommand {
    CollectionManager collectionManager;
    public ExitCommand(CollectionManager collectionManager) {
        super("exit", "завершить программу (без сохранения в файл)");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            collectionManager.saveToFile();
            return true;
        } catch (IncorrectValueException e) {
            ResponseCreator.error("У этой команды нет параметров! Введите: exit");
        }
        return false;
    }
}
