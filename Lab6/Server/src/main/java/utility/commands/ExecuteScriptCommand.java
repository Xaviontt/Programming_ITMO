package utility.commands;

import common.general.StudyGroup;
import exceptions.EmptyArgumentException;
import utility.managers.ResponseCreator;

public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand() {
        super("execute_script filename", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }


    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            return true;
        } catch (EmptyArgumentException e) {
            ResponseCreator.error("У этой команды должен быть аргумент (имя файла для чтения скрипта)");
            return false;
        }
    }
}
