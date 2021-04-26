package utilities;

import exceptions.IncorrectValueException;
import general.*;

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

    public Semester newSemester() {
        String sem = "";
        for (Semester s : Semester.values()) {
            sem += "\n" + s.name();
        }
        Semester returnn = Semester.SECOND;
        t = true;
        while (t) {
            try {
                System.out.println("Введите семестр");
                System.out.println("Выберете из следующих вариантов: " + sem);
                returnn = Semester.valueOf(scanner.nextLine().trim().toUpperCase());
                t = false;
            } catch (IllegalArgumentException e) {
                System.err.println("Значение должно быть выбрано из заданного списка");
                System.out.println();
            }
        }
        return returnn;
    }

    public Person newGroupAdmin() {
        String adminName = "";
        float adminWeight = 0.0f;
        Color adminEyeColor = Color.BLACK;
        Color adminHairColor = Color.BLACK;
        Location adminLocation = null;
        int x = 0;
        int y = 0;
        long z = 0;
        t = true;
        while (t) {
            try {
                System.out.println("Введите имя админа");
                adminName = scanner.nextLine().trim();
                if (adminName.equals("")) throw new IncorrectValueException();
                t = false;
            } catch (IncorrectValueException e) {
                System.err.println("Имя не может быть пустой строкой");
            }
        }

        t = true;
        while (t) {
            try {
                System.out.println("Введите вес админа");
                adminWeight = Float.parseFloat(scanner.nextLine().trim());
                if (adminWeight <= 0) throw new IncorrectValueException();
                t = false;
            } catch (IncorrectValueException e) {
                System.err.println("Вес может быть только положительным числом");
            }
        }
        String col = "";
        for (Color c : Color.values()) {
            col += "\n" + c.name();
        }

        t = true;
        while (t) {
            try {
                System.out.println("Введите семестр");
                System.out.println("Выберете из следующих вариантов: " + col);
                adminEyeColor = Color.valueOf(scanner.nextLine().trim().toUpperCase());
                t = false;
            } catch (IllegalArgumentException e) {
                System.err.println("Значение должно быть выбрано из заданного списка");
                System.out.println();
            }
        }

        String colr = "";
        for (Color c : Color.values()) {
            colr += "\n" + c.name();
        }
        t = true;
        while (t) {
            try {
                System.out.println("Введите цвет волос админа");
                System.out.println("Выберете из следующих вариантов: " + colr);
                adminHairColor = Color.valueOf(scanner.nextLine().trim().toUpperCase());
                t = false;
            } catch (IllegalArgumentException e) {
                System.err.println("Значение должно быть выбрано из заданного списка");
                System.out.println();
            }
        }

        t = true;
        System.out.println("Введите координаты админа");
        while (t) {
            try {
                System.out.println("x:");
                x = Integer.parseInt(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Coordinate can only be a number");
            }
        }
        t = true;
        while (t) {
            try {
                System.out.println("y:");
                y = Integer.parseInt(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Coordinate can only be a number");
            }
        }
        t = true;
        while (t) {
            try {
                System.out.println("z:");
                z = Long.parseLong(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Coordinate can only be a number");
            }
        }

        return new Person(adminName, adminWeight, adminEyeColor, adminHairColor, new Location(x,y,z));
    }

}
