package commands;

import exceptions.EmptyArgumentException;
import general.*;
import utilities.CollectionManager;
import utilities.Creator;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Класс команды "update". Заменяет элемент по ключу
 */
public class UpdateIdCommand extends AbstractCommand {
    Creator creator;
    CollectionManager collectionManager;

    public UpdateIdCommand(CollectionManager collectionManager, Creator creator) {
        super("update id {element}", "обновить значение элемента коллекции, id которого равен заданному");
        this.creator = creator;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполнение команды
     *
     * @param argument аргумент
     * @return состояние выполнения команды
     */
    public boolean execute(String argument) {
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Integer id = Integer.parseInt(argument);
            collectionManager.checkId(id);
            int key = collectionManager.getKeyById(id);
            collectionManager.update(key, new StudyGroup(id, creator.newStudyGroup(), creator.newCoordinates(), LocalDate.now(), creator.newStudentsCount(), creator.newExpelledStudents(), creator.newAverageMark(), creator.newSemester(), creator.newGroupAdmin()));
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент (ID для удаления элемента)");
        } catch (NumberFormatException e) {
            System.err.println("Формат введенного аргумента неверен . Он должен быть целым.");
        } catch (NullPointerException e) {
            System.err.println("Элемента с таким id не существует");
        }
        return false;
    }
}