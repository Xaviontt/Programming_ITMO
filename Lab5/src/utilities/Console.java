package utilities;

import exceptions.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

/**
 * Класс, который управляет вводом команд
 */
public class Console {

    private Scanner scanner;
    private CommandManager commandManager;
    private Creator creator;
    private List<String> scriptFileNames = new ArrayList<String>();

    public Console(Scanner scanner, CommandManager commandManager, Creator creator) {
        this.scanner = scanner;
        this.commandManager = commandManager;
        this.creator = creator;
    }

    /**
     * Метод, который отвечает за ввод пользовательских команд
     */
    public void workMode() {
        String[] userCommand = {"", ""};
        int status = 0;
        try {
            do {
//                System.out.println("\u001B[37m" + "\u001B[36m" + "Введите желаемую команду" + "\u001B[36m" + "\u001B[37m");
                System.out.print("$");
                userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();

                status = executeCommand(userCommand);
//                System.out.println();

            } while (status != 2);
        } catch (NoSuchElementException e) {
            commandManager.save("");
            System.out.println("Программа завершилась с сохранением коллекции в файл");

        }
    }


    /**
     * Метод для считывания комманд из файла
     *
     * @param fileName - файл, из которого считываются команды
     * @return Exit code
     */

    private int scriptMode(String fileName) {
        String[] userCommand = {"", ""};
        scriptFileNames.add(fileName);
        File file = new File(fileName);
        if (file.exists() & !file.canRead()) {
            System.out.println("У указанного файла нет прав на чтение, необходимо  установить");
            return 1;
        }

        try (Scanner scanner2 = new Scanner(file)) {

            if (!scanner2.hasNext()) throw new NoSuchElementException();
            Scanner oldScanner = creator.getScanner();
            int status;
            creator.setScanner(scanner2);
            do {
                userCommand = (scanner2.nextLine().trim() + " ").split(" ", 2);
                userCommand[1] = userCommand[1].trim();
                while (scanner2.hasNextLine() && userCommand[0].isEmpty()){
                    userCommand = (scanner2.nextLine().trim() + " ").split(" ",2);
                    userCommand[1] = userCommand[1].trim();
                }
                System.out.println("\u001B[37m" + "\u001B[33m" + " Выполняется команда " + userCommand[0] + "\u001B[33m" + "\u001B[37m");
                if (userCommand[0].equals("execute_script")) {
                    for (String name : scriptFileNames) {
                        if (name.equals(userCommand[1])) throw new ScriptRecursionException();
                    }

                }
//                status = executeCommand(userCommand);
                executeCommand(userCommand);
                status = 0;
            } while (status == 0 && scanner2.hasNextLine());
            creator.setScanner(oldScanner);
            return status;


        } catch (FileNotFoundException e) {
            System.out.println("Файл со скриптом не найден");
        } catch (NoSuchElementException e) {
            System.err.println("Файл пуст...");
        } catch (ScriptRecursionException e) {
            System.out.println("Скрипты не вызываются рекурсивно");
        }
        return 1;


    }

    /**
     * Метод определяет введеную команду и запускает ее
     *
     * @param userCommand введеная команда для запуска
     * @return Exit code
     */
    private int executeCommand(String[] userCommand) {
        switch (userCommand[0]) {
            case "":
                break;
            case "help":
                if (!commandManager.help(userCommand[1])) return 1;
                break;
            case "info":
                if (!commandManager.info(userCommand[1])) return 1;
                break;
            case "show":
                if (!commandManager.show(userCommand[1])) return 1;
                break;
            case "insert":
                if (!commandManager.insert(userCommand[1])) return 1;
                break;
            case "update":
                if (!commandManager.update(userCommand[1])) return 1;
                break;
            case "remove_key":
                if (!commandManager.removeKey(userCommand[1])) return 1;
                break;
            case "clear":
                if (!commandManager.clear(userCommand[1])) return 1;
                break;
            case "save":
                if (!commandManager.save(userCommand[1])) return 1;
                break;
            case "execute_script":
                if (!commandManager.executeScript(userCommand[1])) return 1;
                else return scriptMode(userCommand[1]);
            case "exit":
                if (!commandManager.exit(userCommand[1])) return 1;
                else return 2;
            case "replace_if_greater":
                if (!commandManager.replaceIfGreater(userCommand[1])) return 1;
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(userCommand[1])) return 1;
                break;
            case "remove_lower":
                if (!commandManager.removeLower(userCommand[1])) return 1;
                break;
            case "print_field_descending_students_count":
                if (!commandManager.printFieldDescendingStudentsCount(userCommand[1])) return 1;
                break;
            case "count_by_students_count":
                if (!commandManager.countByStudentsCountCommand(userCommand[1])) return 1;
                break;
            case "print_unique_average_mark":
                if (!commandManager.printUniqueAverageMark(userCommand[1])) return 1;
                break;
            default:
                System.out.println("Команда " + userCommand[0] + " не найдена. Введите help для справки.");
        }
        return 0;
    }

}
