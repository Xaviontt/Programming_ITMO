package utility.commands;

import common.general.StudyGroup;
import exceptions.IncorrectValueException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

public class ShowCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager){
        super("show"," вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager=collectionManager;
    }
    public boolean execute(String argument, StudyGroup studyGroup){
        try {
            if (!argument.isEmpty())throw new IncorrectValueException();
            ResponseCreator.appendln(collectionManager.getStringElements());
            return true;
        }
        catch (IncorrectValueException e) {
            ResponseCreator.error("У этой команды нет параметров! Необходимо ввести: show");
        }
        return false;
    }
}