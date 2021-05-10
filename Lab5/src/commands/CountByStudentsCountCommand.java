package commands;

import exceptions.EmptyArgumentException;
import utilities.CollectionManager;

public class CountByStudentsCountCommand extends AbstractCommand {
    CollectionManager collectionManager;

    public CountByStudentsCountCommand(CollectionManager collectionManager) {
        super("count_by_students_count studentsCount", "вывести количество элементов, значение поля studentsCount которых равно заданному");
        this.collectionManager = collectionManager;
    }


    @Override
    public boolean execute(String argument) {
        int count = 0;
        try {
            if (argument.isEmpty()) throw new EmptyArgumentException();
            Long students = Long.parseLong(argument);
            count = collectionManager.countStudents(students);
            System.out.println(count + "\u001B[37m" + "\u001B[33m" + "-столько элементов имеет значение students равное заданному" + "\u001B[33m" + "\u001B[37m");
            return true;
        } catch (EmptyArgumentException e) {
            System.err.println("У этой команды должен быть аргумент(значение studentsCount)");
        }
        return false;
    }
}
