package utilities;

import exceptions.IncorrectValueException;
import general.Coordinates;

import java.util.Scanner;

public class Creator {
    private boolean t = true;
    private Scanner scanner;

    public Creator(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public String newStudyGroup() {
        t = true;
        String studyGroupName = "";
        while (t) {
            try {
                System.out.println("Enter group name");
                studyGroupName = scanner.nextLine().trim();
                if (studyGroupName.equals("")) throw new IncorrectValueException();
                t = false;
            } catch (IncorrectValueException e) {
                System.err.println("Group name cannot be an empty string");
            }
        }
        return studyGroupName;
    }

    public Coordinates newCoordinates() {
        float x = 0.0f;
        Float y = 0.0F;
        t = true;
        System.out.println("Enter group coordinates");
        while (t) {
            try {
                System.out.println("x:");
                x = Float.parseFloat(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Coordinate can only be a number");
            }
        }
        t = true;
        while (t) {
            try {
                System.out.println("y:");
                y = Float.parseFloat(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Coordinate can only be a number");
            }
        }
        return new Coordinates(x, y);
    }

    public Long newStudentsCount() {
        Long students = 0L;
        t = true;
        while (t) {
            try {
                System.out.println("Enter number of students");
                students = Long.parseLong(scanner.nextLine().trim());
                if (students <= 0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Number of students can only be an integer");
            } catch (IncorrectValueException e) {
                System.err.println("Number of students can only be a positive number");
            }
        }
        return students;
    }

    public int newExpelledStudents() {
        int exStudents = 0;
        t = true;
        while (t) {
            try {
                System.out.println("Enter number of expelled students");
                exStudents = Integer.parseInt(scanner.nextLine().trim());
                if (exStudents <= 0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Number of expelled students can only be an integer");
            } catch (IncorrectValueException e) {
                System.err.println("Number of expelled students can only be a positive number");
            }
        }
        return exStudents;
    }

    public float newAverageMark() {
        float mark = 0.0f;
        t = true;
        while (t) {
            try {
                System.out.println("Enter average mark");
                mark = Float.parseFloat(scanner.nextLine().trim());
                if (mark <= 0) throw new IncorrectValueException();
                t = false;
            } catch (IncorrectValueException e) {
                System.err.println("Number of expelled students can only be a positive number");
            }
        }
        return mark;
    }


}
