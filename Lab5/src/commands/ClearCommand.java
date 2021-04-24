package commands;

import exceptions.IncorrectValueException;
import utilities.CollectionManager;

public class ClearCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "clear collection");
    }

    @Override
    public boolean execute(String arg) {
        try {
            if (!arg.isEmpty()) throw new IncorrectValueException();
            collectionManager.clear();
            System.out.println("Collection deleted");
            return true;
        } catch (IncorrectValueException e) {
            System.err.println("This command has no parameters! Enter: show");
        }
        return false;
    }
}
