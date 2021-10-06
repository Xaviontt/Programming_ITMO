package utility;

import utility.managers.*;
import exceptions.*;
import common.*;
import utility.managers.Console;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Client {
    private String hostName;
    private int port = 2810;
    private Console console;
    private int reconnectionAttempts;
    private int maxReconnectionAttempts = 3;
    private SocketChannel channel;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(16384);
    private ObjectOutputStream serverWriter;
    private ObjectInputStream serverReader;
    private Selector selector;

    Client(String hostname, int port, Console console) {
        this.hostName = hostname;
        this.port = port;
        this.console = console;

    }

    public void run() {
        try {


            Request requestToServer = null;
            Response serverResponse = null;
            do {
                connectToServer();
                requestToServer = (serverResponse != null ? console.workMode(serverResponse) :
                        console.workMode(null));
                if (requestToServer.isEmpty()) continue;

                send(requestToServer);
                byteBuffer.flip();
                System.out.println(byteBuffer);
                serverResponse = recieve();

                System.out.println(serverResponse.getResponseBody());


            } while (!requestToServer.getCommandName().equals("exit"));
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println("Произошла ошибка при работе с сервером!");
            System.exit(0);
        }


    }

    private Response recieve() throws IOException, ClassNotFoundException {
        SocketChannel channel = null;
        Response res = null;
        while (channel == null) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey key : selectionKeys) {
                if (key.isReadable()) {
                    channel = (SocketChannel) key.channel();
                    channel.read(byteBuffer);
                    byteBuffer.flip();
                    res = deserialize(byteBuffer.array());
                    channel.register(selector, SelectionKey.OP_WRITE);
                    break;
                }
            }
        }
        return res;
    }

    private void send(Request request) {
        try {
            byteBuffer.put(serialize(request));
            byteBuffer.flip();
            SocketChannel channel = null;
            while (channel == null) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    if (key.isWritable()) {
                        channel = (SocketChannel) key.channel();
                        channel.write(byteBuffer);
                        channel.register(selector, SelectionKey.OP_READ);
                        break;

                    }
                }
            }
            byteBuffer.clear();
            //обработай нормально ошибки!!!!!
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
    }

    private void connectToServer() {
        try {
            SocketAddress socket = new InetSocketAddress(hostName, port);
            channel = SocketChannel.open(socket);
            System.out.println("Соединение с сервером установлено");
            channel.configureBlocking(false);
            selector = Selector.open();
            channel.register(selector, SelectionKey.OP_WRITE);
            //обработай нормально ошибки!!!!!
        } catch (IOException e) {
            System.err.println("connectToServer");
            System.exit(0);
        }


    }

    private Response deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        Response response = (Response) o.readObject();
        b.close();
        o.close();
        byteBuffer.clear();
        return response;
    }


    private byte[] serialize(Request request) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(request);
        byte[] buffer = byteArrayOutputStream.toByteArray();
        objectOutputStream.flush();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        objectOutputStream.close();
        return buffer;
    }
}
