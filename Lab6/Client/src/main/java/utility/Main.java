package utility;

import utility.managers.Console;
import utility.managers.Creator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Клиент запущен");
        int port = 8823;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Значение установлено");
        } catch (InputMismatchException e) {
            System.out.println("Некорректное значение порта, Установлен порт по умолчанию (8823)");

        }
        Scanner in = new Scanner(System.in);
        Creator creator = new Creator(in);
        Console console = new Console(in, creator);
        Client client = new Client("localhost", port, console);
        client.run();
        scanner.close();
    }
}
