package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;

/**
 * Класс команды "save". Сохраняет коллекцию в файл
 */
public class SaveCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    public SaveCommand(CollectionManager collectionManager){
        super("save","сохранить коллекцию в файл");
        this.collectionManager=collectionManager;
    }
    /**
     * Выполнение команды
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    public boolean execute(String argument){
        try {
            if (!argument.isEmpty())throw new IncorrectValueException();
            collectionManager.saveToFile();
            return true;
        }
        catch (IncorrectValueException e) {
            System.err.println("У этой команды нет параметров! Необходимо ввести: save");
        }
        return false;
    }
}
