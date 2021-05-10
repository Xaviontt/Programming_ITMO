package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;

import java.time.*;

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager cm) {
        super("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.collectionManager = cm;
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new IncorrectValueException();
            System.out.println("Information about collection");
            LocalDate lastInitTime = collectionManager.getLastInitTime();
            String lastInitTimeString = (lastInitTime == null) ? "no initialization has occurred in this session yet" :
                    lastInitTime.toString();
            System.out.println(" Type: " + collectionManager.collectionType());
            System.out.println(" Last initialization date: " + lastInitTimeString);
            System.out.println(" Number of elements: " + collectionManager.collectionSize());
        } catch (IncorrectValueException e) {
            System.err.println("У этой команды нет параметров! Введите: info");
        }
        return false;
    }
}
