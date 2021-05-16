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
                System.out.println("Введите имя группы");
                studyGroupName = scanner.nextLine().trim();
                if (studyGroupName.equals("")) throw new IncorrectValueException();
                t = false;
            } catch (IncorrectValueException e) {
                System.err.println("Имя группы не может быть пустой строкой");
            }
        }
        return studyGroupName;
    }

    public Coordinates newCoordinates() {
        float x = 0.0f;
        Float y = 0.0F;
        t = true;
        System.out.println("Введите координаты группы");
        while (t) {
            try {
                System.out.println("x:");
                x = Float.parseFloat(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Координаты могут быть только числом");
            }
        }
        t = true;
        while (t) {
            try {
                System.out.println("y:");
                y = Float.parseFloat(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Координаты могут быть только числом");
            }
        }
        return new Coordinates(x, y);
    }

    public Long newStudentsCount() {
        Long students = 0L;
        t = true;
        while (t) {
            try {
                System.out.println("Введите количество студентов");
                students = Long.parseLong(scanner.nextLine().trim());
                if (students <= 0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Количество студентов может быть только целым числом");
            } catch (IncorrectValueException e) {
                System.err.println("Количество студентов должно быть > 0");
            }
        }
        return students;
    }

    public int newExpelledStudents() {
        int exStudents = 0;
        t = true;
        while (t) {
            try {
                System.out.println("Введите количество отчисленных студентов");
                exStudents = Integer.parseInt(scanner.nextLine().trim());
                if (exStudents <= 0) throw new IncorrectValueException();
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Количество отчисленных студентов может быть только целым числом");
            } catch (IncorrectValueException e) {
                System.err.println("Количество отчисленных студентов должно быть > 0");
            }
        }
        return exStudents;
    }

    public float newAverageMark() {
        float mark = 0.0f;
        t = true;
        while (t) {
            try {
                System.out.println("Введите среднюю оценку");
                mark = Float.parseFloat(scanner.nextLine().trim());
                if (mark <= 0) throw new IncorrectValueException();
                t = false;
            } catch (IncorrectValueException e) {
                System.err.println("Средняя оценка должна быть > 0");
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
                System.out.println("Введите цвет глаз админа");
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
                System.err.println("Координты должны быть только числом");
            }
        }
        t = true;
        while (t) {
            try {
                System.out.println("y:");
                y = Integer.parseInt(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Координты должны быть только числом");
            }
        }
        t = true;
        while (t) {
            try {
                System.out.println("z:");
                z = Long.parseLong(scanner.nextLine().trim());
                t = false;
            } catch (NumberFormatException e) {
                System.err.println("Координты должны быть только числом");
            }
        }

        return new Person(adminName, adminWeight, adminEyeColor, adminHairColor, new Location(x,y,z));
    }

}
