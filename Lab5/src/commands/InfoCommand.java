package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;

import java.time.*;

public class InfoCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager cm) {
        super("info", "print information about the collection (type, date of initialization, number of elements, etc.) to the standard output stream");
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
            System.err.println("This command has no parameters! Enter: info");
        }
        return false;
    }
}
