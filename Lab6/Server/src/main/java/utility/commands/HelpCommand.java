package utility.commands;

import common.general.StudyGroup;
import exceptions.IncorrectValueException;
import utility.managers.ResponseCreator;

public class HelpCommand extends AbstractCommand {
    public HelpCommand() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
//            Thread.sleep(1000);
            if (!argument.isEmpty()) throw new IncorrectValueException();
            return true;
        } catch (IncorrectValueException e) {
            ResponseCreator.error("У этой команды нет параметров! Введите: help");
        }
        return false;
    }
}
