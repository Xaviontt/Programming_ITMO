package utility.commands;

import common.general.StudyGroup;
import exceptions.EmptyArgumentException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;
//import utilities.Creator;

/**
 * Класс команды "replace_if_greater". Удаляет, если элемент меньше
 */
public class ReplaceIfGreaterCommand extends AbstractCommand {
    private CollectionManager collectionManager;
//    private Creator creator;

    public ReplaceIfGreaterCommand(CollectionManager collectionManager) {
        super("replace_if_greater null {element}", "заменить значение по ключу, если новое значение больше старого");
        this.collectionManager = collectionManager;
//        this.creator = creator;
    }

    /**
     * Выполнение команды
     *
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Integer key = Integer.parseInt(argument);
            collectionManager.checkKey(key);
            collectionManager.replaceIfGreater(key, studyGroup);
            return true;
        } catch (EmptyArgumentException e) {
            ResponseCreator.error("У этой команды должен быть аргумент(ключ для удаления элементов)");
        } catch (NumberFormatException e) {
            ResponseCreator.error("Формат введенного аргумента неверен. Он должен быть целым.");
        } catch (NullPointerException e) {
            ResponseCreator.error("Элемента с таким ключом не существует");
        }
        return false;
    }
}
