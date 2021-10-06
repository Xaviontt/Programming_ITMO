package utility.commands;

import common.general.StudyGroup;
import exceptions.*;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

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
    public boolean execute(String argument, StudyGroup studyGroup) {
        try {
            if (!argument.isEmpty()) throw new IncorrectValueException();
            ResponseCreator.appendln("значения поля shouldBeExpelled всех элементов в порядке убывания: " + collectionManager.sortedByStudentsCount());
            return true;
        } catch (IncorrectValueException e) {
            ResponseCreator.error("У этой команды нет параметров!");
        }
        return false;
    }
}
