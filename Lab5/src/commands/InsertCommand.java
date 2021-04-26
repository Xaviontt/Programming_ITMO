package commands;

import exceptions.EmptyArgumentException;
import general.StudyGroup;
import utilities.CollectionManager;
import utilities.Creator;

import java.time.LocalDate;

public class InsertCommand extends AbstractCommand {
    private CollectionManager collectionManager;
    private Creator creator;

    public InsertCommand(CollectionManager collectionManager, Creator creator) {
        super("insert null {element}", "add a new element with the given key");
        this.collectionManager = collectionManager;
        this.creator = creator;
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
            int key = Integer.parseInt(argument);//доделать проверку на наличие уже такого ключа в коллекции
            collectionManager.Key(key);
            LocalDate localDate = LocalDate.now();
            collectionManager.insertNew(key, new StudyGroup(collectionManager.newId(), creator.newStudyGroup(), creator.newCoordinates(), localDate, creator.newStudentsCount(), creator.newExpelledStudents(), creator.newAverageMark(), creator.newSemester(), creator.newGroupAdmin()));
            System.out.println("\u001B[37m" + "\u001B[33m" + "Элемент с заданным ключом успешно добавлен" + "\u001B[33m" + "\u001B[37m");
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент(Ключ для добавления нового значения)");
        } catch (NumberFormatException e) {
            System.err.println("Формат введенного аргумента неверен. Он должен быть целым....");
        } catch (NullPointerException e) {
            System.err.println("Элемент с таким ключом уже существует");
        }
        return false;
    }
}