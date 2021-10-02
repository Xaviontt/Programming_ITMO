package utility.commands;

import common.general.StudyGroup;
import exceptions.EmptyArgumentException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

/**
 * Команда "remove_greater". Удаляет эл-ты с количеством студент больше заданного
 */
public class RemoveGreaterCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public RemoveGreaterCommand(CollectionManager collectionManager) {
        super("remove_greater {element}", " удалить из коллекции все элементы, значение поля numberOfStudents которого больше заданного");
        this.collectionManager = collectionManager;
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
            Integer numberOfStudents = Integer.parseInt(argument);
            int i = collectionManager.removeGreater(numberOfStudents);
            ResponseCreator.appendln("\u001B[37m" + "\u001B[33m" + "Было успешно удалено " + i + " групп с количеством студентов больше чем " + numberOfStudents + "\u001B[33m" + "\u001B[37m");
            return true;
        } catch (EmptyArgumentException e) {
            ResponseCreator.error("У этой команды должен быть аргумент(количество студентов в группе)");
        } catch (NumberFormatException e) {
            ResponseCreator.error("Формат введенного аргумента неверен. Он должен быть целым.");
        }
        return false;
    }
}