package utility;

import utility.managers.*;
import exceptions.*;
import common.*;
import utility.managers.Console;

import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class Client {
    private String hostName;
    private int port;
    private Console console;
    private int reconnectionAttempts;
    private int maxReconnectionAttempts = 3;
    private SocketChannel channel;
    private ObjectOutputStream serverWriter;
    private ObjectInputStream serverReader;
    public ArrayList<Response> rlist = new ArrayList<>();

    Client(String hostname, int port, Console console) {
        this.hostName = hostname;
        this.port = port;
        this.console = console;

    }

    public void run() {
        try {
            boolean processingStatus = true;
            while (processingStatus) {
                try {
                    connectToServer();
                    processingStatus = requestToServer();

                } catch (ConnectionException e) {

                    if (reconnectionAttempts >= maxReconnectionAttempts) {
                        System.err.println("Превышено количество попыток подключения");
                        break;
                    }
                    try {
                        Thread.sleep(4000);
                        System.out.printf("Пытаюсь переподключиться (попытка %d).\n", reconnectionAttempts + 1);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }
                reconnectionAttempts++;
            }
            if (channel != null) channel.close();
            System.out.println("Работа клиента успешно завершена.");
        } catch (IllegalArgumentException e) {
            System.err.println("Клиент не может быть запущен");
        } catch (IOException e) {
            System.err.println("Произошла ошибка при попытке завершить соединение с сервером");
        }


    }

    private void connectToServer() throws ConnectionException {
        try {
            if (reconnectionAttempts >= 1) System.out.println("Повторное соединение с сервером...");
            SocketAddress socket = new InetSocketAddress(hostName, port);
            channel = SocketChannel.open(socket);
            System.out.println("\u001B[37m" + "\u001B[32m" + "Соединение с сервером установлено" + "\u001B[32m" + "\u001B[37m");
            reconnectionAttempts = 0;
            System.out.println("Ожидание разрешения на обмен данными...");
            // channel.configureBlocking(false);
            serverWriter = new ObjectOutputStream(channel.socket().getOutputStream());
            serverReader = new ObjectInputStream(channel.socket().getInputStream());
            System.out.println("Разрешение на обмен данными получено.");


        } catch (IllegalArgumentException e) {
            System.err.println("Неверное значение порта");
            throw new IllegalArgumentException();
        } catch (IOException exception) {
            System.err.println("Произошла ошибка при соединении с сервером!");
            throw new ConnectionException(); //для проверки количества попыток подключения
        }


    }

    private boolean requestToServer() throws ConnectionException {
        Request requestToServer = null;//запрос на сервер, в зависимости от команды содержит название команды, аргумент(если есть),элемент коллекции(если есть)
        Response serverResponse = null;
        do {
            try {

                //туть запускаем консоль
                requestToServer = (serverResponse != null ? console.workMode(serverResponse) :
                        console.workMode(null));
                if (!rlist.isEmpty()) {
                    System.out.println(rlist.get(rlist.size() - 1).getResponseBody());
                    rlist.remove(rlist.size() - 1);

                }

                if (requestToServer.isEmpty()) continue;
                //туть отправляем на сервер
                long start = System.nanoTime();
                serverWriter.writeObject(requestToServer);
                //туть получаем ответ от сервера
                serverResponse = (Response) serverReader.readObject();
                long finish = System.nanoTime();
                long time = (finish - start) / 1000000000;
                if (time >= 1) {
                    rlist.add(serverResponse);

                } else {
                    System.out.println(serverResponse.getResponseBody());
                }
                console.setList(rlist);
            } catch (InvalidClassException | NotSerializableException exception) {
                System.err.println("Произошла ошибка при отправке данных на сервер!");
            } catch (ClassNotFoundException exception) {
                System.err.println("Произошла ошибка при чтении полученных данных!");
            } catch (IOException exception) {
                System.err.println("Соединение с сервером разорвано!");
                reconnectionAttempts++;
                connectToServer();
            }

        } while (!(requestToServer.getCommandName().equals("exit") && requestToServer.getArgument().isEmpty()));
        return false;
    }

}
