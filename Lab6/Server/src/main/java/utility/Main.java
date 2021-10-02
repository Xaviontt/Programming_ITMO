package utility;

import utility.commands.*;
import utility.managers.*;

public class Main {
    public static final int PORT = 8823;

    public static void main(String[] args) {
        FileManager fileManager;
        final String myEnv = "STUDYGROUP_FILE";
        fileManager = new FileManager(myEnv);
//        FileManager fileManager = new FileManager("file.xml");
        CollectionManager collectionManager = new CollectionManager(fileManager);
        CommandManager commandManager = new CommandManager(
                new HelpCommand(),
                new InfoCommand(collectionManager),
                new InsertCommand(collectionManager),
                new ShowCommand(collectionManager),
                new ClearCommand(collectionManager),
                new ExecuteScriptCommand(),
                new RemoveKeyCommand(collectionManager),
                new CountByStudentsCountCommand(collectionManager),
                new ReplaceIfGreaterCommand(collectionManager),
                new RemoveGreaterCommand(collectionManager),
                new RemoveLowerCommand(collectionManager),
                new UpdateIdCommand(collectionManager),
                new SaveCommand(collectionManager),
                new PrintFieldDescendingStudentsCountCommand(collectionManager),
                new PrintUniqueAverageMarkCommand(collectionManager),
                new ExitCommand(collectionManager)
        );
        RequestProcessing requestProcessing = new RequestProcessing(commandManager);
        Server server = new Server(PORT, requestProcessing);
        server.run();
    }
}
