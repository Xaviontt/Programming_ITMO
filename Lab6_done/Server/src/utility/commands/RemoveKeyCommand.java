package utility.commands;

import common.general.StudyGroup;
import exceptions.EmptyArgumentException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

/**
 * Команда "remove_key". Удаляет эл-т по ключу
 */
public class RemoveKeyCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public RemoveKeyCommand(CollectionManager collectionManager) {
        super("remove_key null", "удалить элемент из коллекции по его ключу");
        this.collectionManager = collectionManager;

    }

    /**
     * Выполнение команды
     *
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    public boolean execute(String argument, StudyGroup studyGroup) {// проверить ключ на наличие
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Integer key = Integer.parseInt(argument);
            collectionManager.removeKey(key);
            return true;
        } catch (EmptyArgumentException e) {
            ResponseCreator.error("У этой команды должен быть аргумент(ключ для удаления элемента)");
        } catch (NumberFormatException e) {
            ResponseCreator.error("Формат введенного аргумента неверен. Он должен быть целым.");
        }
        return false;
    }
}
