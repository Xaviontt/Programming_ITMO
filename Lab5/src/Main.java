import commands.*;
import utilities.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        FileManager fileManager;
        CollectionManager collectionManager;
//        final String myEnv = "STUDYGROUP_FILE";
        Scanner scanner = new Scanner(System.in);
        Creator creator = new Creator(scanner);
//        fileManager = new FileManager(myEnv);
//        fileManager = new FileManager("C:MyDocs/Proga/Lab5/file.xml");
        fileManager = new FileManager("file.xml");
        collectionManager = new CollectionManager(fileManager, creator);
        collectionManager.loadCollection();
        CommandManager commandManager = new CommandManager(
                new HelpCommand(),
                new InfoCommand(collectionManager),
                new InsertCommand(collectionManager, creator),
                new ShowCommand(collectionManager),
                new ClearCommand(collectionManager),
                new ExecuteScriptCommand(),
                new RemoveKeyCommand(collectionManager),
                new CountByStudentsCountCommand(collectionManager),
                new ReplaceIfGreaterCommand(collectionManager, creator),
                new RemoveGreaterCommand(collectionManager),
                new RemoveLowerCommand(collectionManager),
                new UpdateIdCommand(collectionManager, creator),
                new SaveCommand(collectionManager),
                new PrintFieldDescendingStudentsCountCommand(collectionManager),
                new PrintUniqueAverageMarkCommand(collectionManager),
                new ExitCommand()
        );

        Console console = new Console(scanner, commandManager, creator);
        try {
            console.workMode();
        } catch (NullPointerException e) {
            System.err.println("Экстренное завершение работы программы");
        }
    }
}