package commands;

import exceptions.EmptyArgumentException;

public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand() {
        super("execute_script filename", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
    }


    @Override
    public boolean execute(String arg) {
        try {
            if (arg.isEmpty()) throw new EmptyArgumentException();
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент (имя файла для чтения скрипта)");
            return false;
        }
    }
}
