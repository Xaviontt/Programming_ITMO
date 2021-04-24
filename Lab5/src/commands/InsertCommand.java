package commands;

import utilities.CollectionManager;
import utilities.Creator;

public class InsertCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private Creator creator;

    public InsertCommand(CollectionManager collectionManager, Creator creator) {
        super("insert null {element}","add a new element with the given key");
        this.collectionManager = collectionManager;
        this.creator = creator;
    }

    @Override
    public boolean execute(String arg) {

    }
}
