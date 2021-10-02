package utility;

import common.Request;
import common.Response;
import common.ResponseCode;
import utility.managers.RequestProcessing;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {
    private int port;
    private RequestProcessing requestProcessing;
    ServerSocket serverSocket;
    Socket clientSocket;
    private Scanner scanner;
    public Server(int port, RequestProcessing requestProcessing){
        this.port=port;
        this.requestProcessing=requestProcessing;
    }

    public void run(){
        try {scanner = new Scanner(System.in);
            Runnable userInput = () -> {
                try {
                    while (true) {
                        String[] userCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                        userCommand[1] = userCommand[1].trim();
                        if (!userCommand[0].equals("save")) {
                            LoggerUtility.warning("Сервер не может сам принимать такую команду!");
                            return;
                        }
                        Response responseToUser = requestProcessing.processing(new Request(userCommand[0], userCommand[1]));
                        LoggerUtility.info(responseToUser.getResponseBody());
                    }
                } catch (Exception e) {}
            };
            Thread thread = new Thread(userInput);
            thread.start();
            openServerSocket();
            boolean processingStatus = true;
            while (processingStatus) {
                try (Socket clientSocket = connectToClient()) {
                    processingStatus = workingWithClientsRequest();


                } catch (IOException e) {
                    LoggerUtility.error("Произошла ошибка при попытке использовать порт " + port);
                }
            }
            serverSocket.close();
            LoggerUtility.info("Работа сервера успешно завершена.");
        }catch (IOException e) {
            LoggerUtility.error("Произошла ошибка при попытке завершить соединение с клиентом!");
        }


    }
    private void openServerSocket()  {
        try {
            LoggerUtility.info("Запуск сервера...");
            serverSocket =new ServerSocket(port);
            LoggerUtility.info("Сервер успешно запущен");
        } catch (IOException e) {
            LoggerUtility.error("Произошла ошибка при попытке использовать порт '" + port + "'!");
        }
    }
    private Socket connectToClient(){
        try {
            clientSocket= serverSocket.accept();
            LoggerUtility.info("Соединение с клиентом успешно установлено");
            return clientSocket;
        }catch (IOException e){
            LoggerUtility.error("Ошибка при соединении с клиентом");
        }

        return clientSocket;

    }
    private boolean workingWithClientsRequest() {
        Request userRequest = null;
        Response responseToUser = null;
        try (ObjectInputStream clientReader = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream clientWriter = new ObjectOutputStream(clientSocket.getOutputStream())) {
            do {
                userRequest = (Request) clientReader.readObject();
                LoggerUtility.info("Обрабатывается команда " + userRequest.getCommandName());
                //запрос такой-то успешно обработан
                responseToUser = requestProcessing.processing(userRequest);//обрабатываем запрос, отдаем ответ сервера
                clientWriter.writeObject(responseToUser);
                clientWriter.flush();

            } while (responseToUser.getResponseCode() != ResponseCode.SERVER_EXIT);
        } catch (SocketException e) {
            LoggerUtility.warning("Соединение с клиентом разорвано");

        } catch (ClassNotFoundException e) {
            LoggerUtility.error(e.getMessage(), e);
        } catch (IOException exception) {
            if (userRequest == null) {
                LoggerUtility.error("Непредвиденный разрыв соединения с клиентом!");}
        }
        return true;
    }
}
