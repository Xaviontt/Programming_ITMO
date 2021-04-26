import commands.*;
import utilities.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Главный класс, в котором создаются все экземпляры и запускается программа
 *
 * @author Byzova Valeriia
 */
public class Main {
    public static void main(String[] args) {
        FileManager fileManager;
        CollectionManager collectionManager;
        final String myEnv = "STUDYGROUP_FILE";
        Scanner scanner = new Scanner(System.in);
        Creator creator = new Creator(scanner);
        fileManager = new FileManager(myEnv);
        collectionManager = new CollectionManager(fileManager, creator);
//        collectionManager.loadCollection();
        CommandManager commandManager = new CommandManager(
                new HelpCommand(),
                new InfoCommand(collectionManager),
                new InsertCommand(collectionManager, creator),
                new ShowCommand(collectionManager),
//                new UpdateCommand(collectionManager, creator),
//                new RemoveKeyCommand(collectionManager),
//                new SaveCommand(collectionManager),
                new ClearCommand(collectionManager),
//                new ExecuteScriptCommand(),
                new ExitCommand()
//                new ReplaceIfGreaterCommand(collectionManager, creator),
//                new ReplaceIfLowerCommand(collectionManager, creator),
//                new RemoveLowerKeyCommand(collectionManager),
//                new RemoveAllByNumberOfRoomsCommand(collectionManager),
//                new CountGreaterThanFurnishCommand(collectionManager),
//                new FilterNameCommand(collectionManager)
        );

        Console console = new Console(scanner, commandManager, creator);
//        try {
            console.workMode();
//        } catch (NullPointerException e) {
//            System.err.println("Ошибочка");
//        }
    }
}