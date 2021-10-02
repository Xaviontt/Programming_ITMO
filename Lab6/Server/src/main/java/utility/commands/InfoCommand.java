package utility.commands;

import common.general.StudyGroup;
import exceptions.IncorrectValueException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

import java.time.*;

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager cm) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = cm;
    }

    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            ResponseCreator.appendln("Information about collection");
            LocalDate lastInitTime = collectionManager.getLastInitTime();
            String lastInitTimeString = (lastInitTime == null) ? "no initialization has occurred in this session yet" :
                    lastInitTime.toString();
            ResponseCreator.appendln(" Type: " + collectionManager.collectionType());
            ResponseCreator.appendln(" Last initialization date: " + lastInitTimeString);
            ResponseCreator.appendln(" Number of elements: " + collectionManager.collectionSize());
        } catch (IncorrectValueException e) {
            ResponseCreator.error("У этой команды нет параметров! Введите: info");
        }
        return false;
    }
}
