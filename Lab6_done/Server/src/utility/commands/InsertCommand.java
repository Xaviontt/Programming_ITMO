package utility.commands;

import exceptions.EmptyArgumentException;
import common.general.StudyGroup;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;
//import utility.Creator;

import java.time.LocalDate;

public class InsertCommand extends AbstractCommand {
    private CollectionManager collectionManager;
//    private Creator creator;

    public InsertCommand(CollectionManager collectionManager) {
        super("insert null {element}", "добавить новый элемент с заданным ключом");
        this.collectionManager = collectionManager;
//        this.creator = creator;
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
            int key = Integer.parseInt(argument);//доделать проверку на наличие уже такого ключа в коллекции
            collectionManager.Key(key);
            collectionManager.insertNew(key, studyGroup);
            ResponseCreator.appendln("\u001B[37m" + "\u001B[33m" + "Элемент с заданным ключом успешно добавлен" + "\u001B[33m" + "\u001B[37m");
            return true;
        } catch (EmptyArgumentException e) {
            ResponseCreator.error("У этой команды должен быть аргумент(Ключ для добавления нового значения)");
        } catch (NumberFormatException e) {
            ResponseCreator.error("Формат введенного аргумента неверен. Он должен быть целым....");
        } catch (NullPointerException e) {
            ResponseCreator.error("Элемент с таким ключом уже существует");
        }
        return false;
    }
}