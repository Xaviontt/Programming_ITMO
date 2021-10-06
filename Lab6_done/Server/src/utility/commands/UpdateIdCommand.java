package utility.commands;

import exceptions.EmptyArgumentException;
import common.general.*;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;
//import utilities.Creator;

import java.time.LocalDate;

/**
 * Класс команды "update". Заменяет элемент по ключу
 */
public class UpdateIdCommand extends AbstractCommand {
//    Creator creator;
    CollectionManager collectionManager;

    public UpdateIdCommand(CollectionManager collectionManager) {
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
//        this.creator = creator;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды
     *
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Integer id = Integer.parseInt(argument);
            collectionManager.checkId(id);
            int key = collectionManager.getKeyById(id);
            collectionManager.update(key, studyGroup);
            ResponseCreator.appendln("Элемент коллекции был успешно заменен");
            return true;
        } catch (EmptyArgumentException e) {
            ResponseCreator.error("У этой команды должен быть аргумент (ID для удаления элемента)");
        } catch (NumberFormatException e) {
            ResponseCreator.error("Формат введенного аргумента неверен . Он должен быть целым.");
        } catch (NullPointerException e) {
            ResponseCreator.error("Элемента с таким id не существует");
        }
        return false;
    }
}