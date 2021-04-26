package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;

public class ShowCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public ShowCommand(CollectionManager collectionManager){
        super("show"," вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        this.collectionManager=collectionManager;
    }
    public boolean execute(String argument){
        try {
            if (!argument.isEmpty())throw new IncorrectValueException();
            System.out.println(collectionManager.getStringElements());
            return true;
        }
        catch (IncorrectValueException e) {
            System.err.println("У этой команды нет параметров! Необходимо ввести: show");
        }
        return false;
    }
}