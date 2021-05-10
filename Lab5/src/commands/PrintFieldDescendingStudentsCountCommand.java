package commands;

import general.StudyGroup;
import exceptions.*;
import utilities.*;

public class PrintFieldDescendingStudentsCountCommand extends AbstractCommand {
    private CollectionManager collectionManager;

    public PrintFieldDescendingStudentsCountCommand(CollectionManager collectionManager) {
        super("print_field_descending_students_count", "вывести значения поля studentsCount всех элементов в порядке убывания");
        this.collectionManager = collectionManager;
    }

    /**
     * Executes the command.
     * @return Command execute status.
     */
    @Override
    public boolean execute(String argument) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            System.out.println("значения поля shouldBeExpelled всех элементов в порядке убывания: " + collectionManager.sortedByStudentsCount());
            return true;
        } catch (IncorrectValueException e) {
            System.out.println("У этой команды нет параметров!");
        }
        return false;
    }
}
