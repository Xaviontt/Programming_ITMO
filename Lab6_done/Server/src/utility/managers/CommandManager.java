package utility.managers;

import utility.commands.*;
import common.general.StudyGroup;

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


    /**
     * Выводит все доступные команды с описанием
     *
     * @param argument это аргумент
     * @return Состояние работы команды
     */

    public boolean help(String argument, StudyGroup studyGroup) {
        if (helpCommand.execute(argument, studyGroup)) {
            for (AbstractCommand command : commands) {
                ResponseCreator.appendln("\u001B[37m" + "\u001B[33m" + command.getName() + "\u001B[33m" + "\u001B[37m" + ": " + command.getDescription());
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
    public boolean info(String argument, StudyGroup studyGroup) {
        return infoCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду выхода из программы
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean exit(String argument, StudyGroup studyGroup) {
        return exitCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду показа всех элементов коллекции
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean show(String argument, StudyGroup studyGroup) {
        return showCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду очистки коллекции
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean clear(String argument, StudyGroup studyGroup) {
        return clearCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду сохранения коллекции в файл
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean save(String argument, StudyGroup studyGroup) {
        return saveCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду добавления нового элемента
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean insert(String argument, StudyGroup studyGroup) {
        return insertCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду замены элемента по ключу
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean update(String argument, StudyGroup studyGroup) {
        return updateIdCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду удаления элемента по ключу
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeKey(String argument, StudyGroup studyGroup) {
        return removeKeyCommand.execute(argument, studyGroup);
    }


    /**
     * Запускает команду выполнения скрипта
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean executeScript(String argument, StudyGroup studyGroup) {
        return executeScriptCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду замены элемента, если он больше
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean replaceIfGreater(String argument, StudyGroup studyGroup) {
        return replaceIfGreaterCommand.execute(argument, studyGroup);
    }


    public boolean countByStudentsCountCommand(String argument, StudyGroup studyGroup) {
        return countByStudentsCountCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду удаления элементов, если они больше заданного значения
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeGreater(String argument, StudyGroup studyGroup) {
        return removeGreaterCommand.execute(argument, studyGroup);
    }

    /**
     * Запускает команду удаления элементов, если они меньше заданного значения
     *
     * @param argument это переданный аргумент
     * @return состояние работы программы
     */
    public boolean removeLower(String argument, StudyGroup studyGroup) {
        return removeLowerCommand.execute(argument, studyGroup);
    }

    public boolean printFieldDescendingStudentsCount(String argument, StudyGroup studyGroup){
        return printFieldDescendingStudentsCountCommand.execute(argument, studyGroup);
    }

    public boolean printUniqueAverageMark(String argument, StudyGroup studyGroup) {
        return printUniqueAverageMarkCommand.execute(argument, studyGroup);
    }
}
