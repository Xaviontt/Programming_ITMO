package utility.commands;

import common.general.StudyGroup;
import exceptions.EmptyArgumentException;
import utility.managers.CollectionManager;
import utility.managers.ResponseCreator;

public class CountByStudentsCountCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public CountByStudentsCountCommand(CollectionManager collectionManager) {
        super("count_by_students_count studentsCount", "вывести количество элементов, значение поля studentsCount которых равно заданному");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument, StudyGroup studyGroup) {
        int count = 0;
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Long students = Long.parseLong(argument);
            count = collectionManager.countStudents(students);
            ResponseCreator.appendln(count + "\u001B[37m" + "\u001B[33m" + "-столько элементов имеет значение students равное заданному" + "\u001B[33m" + "\u001B[37m");
            return true;
        } catch (EmptyArgumentException e) {
            ResponseCreator.error("У этой команды должен быть аргумент(значение studentsCount)");
        }
        return false;
    }
}
