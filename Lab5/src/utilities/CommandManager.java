package utilities;

import commands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для запуска команд
 */
public class CommandManager {
//    private final int maxCommandSize = 14;

    private List<AbstractCommand> commands = new ArrayList<>(); //массив с командами
    private AbstractCommand helpCommand;
    private AbstractCommand infoCommand;
    private AbstractCommand showCommand;
    private AbstractCommand insertCommand;
    private AbstractCommand updateIdCommand;
    private AbstractCommand removeKeyCommand;
    private AbstractCommand executeScriptCommand;
    private AbstractCommand saveCommand;
    private AbstractCommand clearCommand;
    private AbstractCommand exitCommand;
    private AbstractCommand replaceIfGreaterCommand;
    private AbstractCommand replaceIfLowerCommand;
    private AbstractCommand removeLowerKeyCommand;
    private AbstractCommand removeAllByNumberOfRoomsCommand;
    private AbstractCommand countFurnishCommand;
    private AbstractCommand filterNameCommand;
    private AbstractCommand countByStudentsCountCommand;
    private AbstractCommand removeGreaterCommand;
    private AbstractCommand removeLowerCommand;
    private AbstractCommand printFieldDescendingStudentsCountCommand;
    private AbstractCommand printUniqueAverageMarkCommand;

    public CommandManager(AbstractCommand helpCommand,
                          AbstractCommand infoCommand,
                          AbstractCommand insertCommand,
                          AbstractCommand showCommand,
                          AbstractCommand clearCommand,
                          AbstractCommand executeScriptCommand,
                          AbstractCommand removeKeyCommand,
                          AbstractCommand countByStudentsCountCommand,
                          AbstractCommand replaceIfGreaterCommand,
                          AbstractCommand removeGreaterCommand,
                          AbstractCommand removeLowerCommand,
                          AbstractCommand updateIdCommand,
                          AbstractCommand saveCommand,
                          AbstractCommand printFieldDescendingStudentsCountCommand,
                          AbstractCommand printUniqueAverageMarkCommand,
                          AbstractCommand exitCommand) {
        this.helpCommand = helpCommand;
        commands.add(helpCommand);

        this.infoCommand = infoCommand;
        commands.add(infoCommand);

        this.insertCommand = insertCommand;
        commands.add(insertCommand);

        this.showCommand = showCommand;
        commands.add(showCommand);

        this.clearCommand = clearCommand;
        commands.add(clearCommand);

        this.executeScriptCommand = executeScriptCommand;
        commands.add(executeScriptCommand);

        this.removeKeyCommand = removeKeyCommand;
        commands.add(removeKeyCommand);

        this.countByStudentsCountCommand = countByStudentsCountCommand;
        commands.add(countByStudentsCountCommand);

        this.replaceIfGreaterCommand = replaceIfGreaterCommand;
        commands.add(replaceIfGreaterCommand);

        this.removeGreaterCommand = removeGreaterCommand;
        commands.add(removeGreaterCommand);

        this.removeLowerCommand = removeLowerCommand;
        commands.add(removeLowerCommand);

        this.updateIdCommand = updateIdCommand;
        commands.add(updateIdCommand);

        this.saveCommand = saveCommand;
        commands.add(saveCommand);

        this.printFieldDescendingStudentsCountCommand = printFieldDescendingStudentsCountCommand;
        commands.add(printUniqueAverageMarkCommand);

        this.printUniqueAverageMarkCommand = printUniqueAverageMarkCommand;
        commands.add(printFieldDescendingStudentsCountCommand);

        this.exitCommand = exitCommand;
        commands.add(exitCommand);

    }

//    public CommandManager(AbstractCommand helpCommand,
//                          AbstractCommand infoCommand,
//                          AbstractCommand showCommand,
//                          AbstractCommand insertCommand,
//                          AbstractCommand updateIdCommand,
//                          AbstractCommand removeKeyCommand,
//                          AbstractCommand saveCommand,
//                          AbstractCommand clearCommand,
//                          AbstractCommand executeScriptCommand,
//                          AbstractCommand exitCommand,
//                          AbstractCommand replaceIfGreaterCommand,
//                          AbstractCommand replaceIfLowerCommand,
//                          AbstractCommand removeLowerKeyCommand,
//                          AbstractCommand removeAllByNumberOfRoomsCommand,
//                          AbstractCommand countFurnishCommand,
//                          AbstractCommand filterNameCommand) {
//
//        this.helpCommand = helpCommand;
//        commands.add(helpCommand);
//
//        this.infoCommand = infoCommand;
//        commands.add(infoCommand);
//
//        this.showCommand = showCommand;
//        commands.add(showCommand);
//
//        this.insertCommand = insertCommand;
//        commands.add(insertCommand);
//
//        this.updateIdCommand = updateIdCommand;
//        commands.add(updateIdCommand);
//
//        this.removeKeyCommand = removeKeyCommand;
//        commands.add(removeKeyCommand);
//
//        this.saveCommand = saveCommand;
//        commands.add(saveCommand);
//
//        this.clearCommand = clearCommand;
//        commands.add(clearCommand);
//
//        this.executeScriptCommand = executeScriptCommand;
//        commands.add(executeScriptCommand);
//
//        this.exitCommand = exitCommand;
//        commands.add(exitCommand);
//
//        this.replaceIfGreaterCommand = replaceIfGreaterCommand;
//        commands.add(replaceIfGreaterCommand);
//
//        this.replaceIfLowerCommand = replaceIfLowerCommand;
//        commands.add(replaceIfLowerCommand);
//
//        this.removeLowerKeyCommand = removeLowerKeyCommand;
//        commands.add(removeLowerKeyCommand);
//
//        this.removeAllByNumberOfRoomsCommand = removeAllByNumberOfRoomsCommand;
//        commands.add(removeAllByNumberOfRoomsCommand);
//
//        this.countFurnishCommand = countFurnishCommand;
//        commands.add(countFurnishCommand);
//
//        this.filterNameCommand = filterNameCommand;
//        commands.add(filterNameCommand);
//    }

    /**
     * Выводит все доступные команды с описанием
     *
     * @param argument это аргумент
     * @return Состояние работы команды
     */

    public boolean help(String argument) {
        if (helpCommand.execute(argument)) {
            for (AbstractCommand command : commands) {
                System.out.println("\u001B[37m" + "\u001B[33m" + command.getName() + "\u001B[33m" + "\u001B[37m" + ": " + command.getDescription());
            }
            return true;
        } else return false;
    }

    /**
     * Запускает команду информации о коллекции
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean info(String argument) {
        return infoCommand.execute(argument);
    }

    /**
     * Запускает команду выхода из программы
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean exit(String argument) {
        return exitCommand.execute(argument);
    }

    /**
     * Запускает команду показа всех элементов коллекции
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean show(String argument) {
        return showCommand.execute(argument);
    }

    /**
     * Запускает команду очистки коллекции
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean clear(String argument) {
        return clearCommand.execute(argument);
    }

    /**
     * Запускает команду сохранения коллекции в файл
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean save(String argument) {
        return saveCommand.execute(argument);
    }

    /**
     * Запускает команду добавления нового элемента
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean insert(String argument) {
        return insertCommand.execute(argument);
    }

    /**
     * Запускает команду замены элемента по ключу
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean update(String argument) {
        return updateIdCommand.execute(argument);
    }

    /**
     * Запускает команду удаления элемента по ключу
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeKey(String argument) {
        return removeKeyCommand.execute(argument);
    }

    /**
     * Запускает команду удаления элементов по количеству комнат
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeAllByNumber(String argument) {
        return removeAllByNumberOfRoomsCommand.execute(argument);
    }

    /**
     * Запускает команду удаления элементов с ключом меньшим чем заданный
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeLowerKey(String argument) {
        return removeLowerKeyCommand.execute(argument);
    }

    /**
     * Запускает команду, которая выводит элементы по имени
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean filterName(String argument) {
        return filterNameCommand.execute(argument);
    }

    /**
     * Запускает команду выполнения скрипта
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean executeScript(String argument) {
        return executeScriptCommand.execute(argument);
    }

    /**
     * Запускает команду замены элемента, если он больше
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean replaceIfGreater(String argument) {
        return replaceIfGreaterCommand.execute(argument);
    }

    /**
     * Запускает команду замены элемента, если он меньше
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean replaceIfLower(String argument) {
        return replaceIfLowerCommand.execute(argument);
    }

    /**
     * Запускает команду подсчета кол-ва элементов с определенной отделкой
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean countFurnish(String argument) {
        return countFurnishCommand.execute(argument);
    }

    public boolean countByStudentsCountCommand(String argument) {
        return countByStudentsCountCommand.execute(argument);
    }

    /**
     * Запускает команду удаления элементов, если они больше заданного значения
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeGreater(String argument) {
        return removeGreaterCommand.execute(argument);
    }

    /**
     * Запускает команду удаления элементов, если они меньше заданного значения
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeLower(String argument) {
        return removeLowerCommand.execute(argument);
    }

    public boolean printFieldDescendingStudentsCount(String argument){
        return printFieldDescendingStudentsCountCommand.execute(argument);
    }

    public boolean printUniqueAverageMark(String argument) {
        return printUniqueAverageMarkCommand.execute(argument);
    }
}
