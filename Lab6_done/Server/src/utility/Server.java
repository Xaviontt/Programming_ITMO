package utility;

import common.Request;
import common.Response;
import common.ResponseCode;
import utility.managers.RequestProcessing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    private int port = 2810;
    private RequestProcessing requestProcessing;
    private Scanner scanner;
    ServerSocket serverSocket;
    Socket clientSocket;

    public Server(int port, RequestProcessing requestProcessing) {
        this.port = port;
        this.requestProcessing = requestProcessing;
    }

    public void run() {
        System.out.println("Запуск сервера!");
        boolean processStatus = true;
        scanner = new Scanner(System.in);
        Runnable userInput = () -> {
            try {
                while (true) {
                    String[] userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                    userCommand[1] = userCommand[1].trim();
                    if (!userCommand[0].equals("save")) {
                        System.out.println("Сервер не может сам принимать такую команду!");
                        return;
                    }
                    Response responseToUser = requestProcessing.processing(new Request(userCommand[0], userCommand[1]));
                    System.out.println(responseToUser.getResponseBody());
                }
            } catch (Exception e) {
            }
        };
        Thread thread = new Thread(userInput);
        thread.start();
        boolean processingStatus = true;
        while (processingStatus) {
            processingStatus = workingWithClientsRequest();
        }
    }

    private boolean workingWithClientsRequest() {
        try {
            Request request = null;
            Response response = null;
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер успешно запущен");

            do {
                request = getRequest();
                System.out.println("Получена команда '" + request.getCommandName() + "'");
                response = requestProcessing.processing(request);
                System.out.println("Команда '" + request.getCommandName() + "' выполнена");
                sendResponse(response);
            } while (response.getResponseCode() != ResponseCode.SERVER_EXIT);
            clientSocket.close();
            return false;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //тут надо вернуть true, но обрабатывать количество подключений
        return false;
    }

    private Request getRequest() throws IOException, ClassNotFoundException {

        byte[] getBuffer = new byte[serverSocket.getReceiveBufferSize()];
        clientSocket = serverSocket.accept();
        System.out.println("Соединение с сервером успешно установлено");
        ObjectInputStream clientReader = new ObjectInputStream(clientSocket.getInputStream());
        return (Request) clientReader.readObject();
    }

    private byte[] serialize(Response response) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(response);
        byte[] buffer = b.toByteArray();
        o.flush();
        b.flush();
        b.close();
        o.close();
        return buffer;
    }

    private void sendResponse(Response response) throws IOException {


        byte[] sendBuffer = serialize(response);
        ObjectOutputStream clientWriter = new ObjectOutputStream(clientSocket.getOutputStream());
        clientWriter.write(sendBuffer);
        System.out.println("Ответ клиенту отправлен");

    }
}
