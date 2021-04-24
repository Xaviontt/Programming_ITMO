package commands;

import exceptions.EmptyArgumentException;

public class ExecuteScriptCommand extends AbstractCommand {
    public ExecuteScriptCommand() {
        super("execute script filename", "read and execute a script from the specified file. The script contains commands in the same form in which the user enters them interactively.");
    }


    @Override
    public boolean execute(String arg) {
        try {
            if (arg.isEmpty()) throw new EmptyArgumentException();
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("This command must have an argument (filename to read the script)");
            return false;
        }
    }
}
