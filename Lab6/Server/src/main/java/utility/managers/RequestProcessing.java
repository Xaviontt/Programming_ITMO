package utility.managers;

import common.Request;
import common.Response;
import common.ResponseCode;
import common.general.StudyGroup;

//Класс для обработки запроса клиента и формирования ответа
public class RequestProcessing {
    private CommandManager commandManager;
    public RequestProcessing(CommandManager commandManager){
        this.commandManager=commandManager;
    }
    public Response processing(Request request){
        return new Response(executeCommand(request.getCommandName(),request.getArgument(), request.getObjectArgument()),ResponseCreator.getAndClear());

    }
    public ResponseCode executeCommand(String commandName, String argument, StudyGroup studyGroup){
        switch (commandName){
            case "help" :
                if (!commandManager.help(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }

                break;
            case"show":
                if (!commandManager.show(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "info":
                if (!commandManager.info(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "insert":
                if (!commandManager.insert(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "update":
                if (!commandManager.update(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "remove_key":
                if (!commandManager.removeKey(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "clear":
                if (!commandManager.clear(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "save":
                if (!commandManager.save(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "execute_script":
                if (!commandManager.executeScript(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "replace_if_greater":
                if (!commandManager.replaceIfGreater(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "count_by_students_count":
                if (!commandManager.countByStudentsCountCommand(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "remove_greater":
                if (!commandManager.removeGreater(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "remove_lower":
                if (!commandManager.removeLower(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "print_field_descending_students_count":
                if (!commandManager.printFieldDescendingStudentsCount(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "print_unique_average_mark":
                if (!commandManager.printUniqueAverageMark(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            case "exit":
                if (!commandManager.exit(argument,studyGroup)){
                    return ResponseCode.ERROR;
                }
                break;
            default:
                ResponseCreator.appendln("Команда '" + commandName+ "' не найдена. Наберите 'help' для справки.");
                return ResponseCode.ERROR;
        }
        return ResponseCode.OK;
    }
}