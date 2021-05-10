package commands;

import exceptions.EmptyArgumentException;
import utilities.CollectionManager;

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
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Integer numberOfStudents = Integer.parseInt(argument);
            int i = collectionManager.removeGreater(numberOfStudents);
            System.out.println("\u001B[37m" + "\u001B[33m" + "Было успешно удалено " + i + " групп с количеством студентов больше чем " + numberOfStudents + "\u001B[33m" + "\u001B[37m");
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент(количество студентов в группе)");
        } catch (NumberFormatException e) {
            System.err.println("Формат введенного аргумента неверен. Он должен быть целым.");
        }
        return false;
    }
}