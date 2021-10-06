package common;

import common.general.StudyGroup;

import java.io.Serializable;

//Класс для формирования запроса
// экземпляр состоит из названия команды, аргумента, экземпляра группы (если есть)
public class Request implements Serializable {
    private String commandName;
    private String argument;
    private StudyGroup objectArgument;

    public Request(String commandName, String argument, StudyGroup objectArgument) {
        this.commandName = commandName;
        this.argument = argument;
        this.objectArgument = objectArgument;
    }

    public Request(String commandName, String argument) {
        this.commandName = commandName;
        this.argument = argument;
        this.objectArgument = null;
    }

    public Request() {
        this.commandName = "";
        this.argument = "";
        this.objectArgument = null;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getArgument() {
        return argument;
    }

    public StudyGroup getObjectArgument() {
        return objectArgument;
    }

    public boolean isEmpty() {
        return commandName.isEmpty() && argument.isEmpty() && objectArgument == null;
    }
}
