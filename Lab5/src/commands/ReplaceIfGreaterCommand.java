package commands;

import exceptions.EmptyArgumentException;
import utilities.CollectionManager;
import utilities.Creator;

/**
 * Класс команды "replace_if_greater". Удаляет, если элемент меньше
 */
public class ReplaceIfGreaterCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private Creator creator;

    public ReplaceIfGreaterCommand(CollectionManager collectionManager, Creator creator) {
        super("replace_if_greater null {element}", "заменить значение по ключу, если новое значение больше старого");
        this.collectionManager = collectionManager;
        this.creator = creator;
    }

    /**
     * Выполнение команды
     *
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Integer key = Integer.parseInt(argument);
            collectionManager.checkKey(key);
            collectionManager.replaceIfGreater(key);
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент(ключ для удаления элементов)");
        } catch (NumberFormatException e) {
            System.err.println("Формат введенного аргумента неверен. Он должен быть целым.");
        } catch (NullPointerException e) {
            System.err.println("Элемента с таким ключом не существует");
        }
        return false;
    }
}
