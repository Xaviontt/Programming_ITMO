package commands;

import exceptions.EmptyArgumentException;
import utilities.CollectionManager;

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
    public boolean execute(String argument) {// проверить ключ на наличие
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Integer key = Integer.parseInt(argument);
            collectionManager.removeKey(key);
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент(ключ для удаления элемента)");
        } catch (NumberFormatException e) {
            System.err.println("Формат введенного аргумента неверен. Он должен быть целым.");
        }
        return false;
    }
}
