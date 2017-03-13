package ru.tkachenko.dmitry.geekbrains.java2.task6.server;

import ru.tkachenko.dmitry.geekbrains.java2.task6.Sender;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/12/17
 */
class ServerApp {

    private final int PORT;
    private final boolean VERBOSE;

    ServerApp(int port) {
        this.PORT = port;
        this.VERBOSE = true;
    }

    ServerApp(int port, boolean verbose) {
        this.PORT = port;
        this.VERBOSE = verbose;
    }

    void start() {
        try (ServerSocket server = new ServerSocket(PORT)) {

            if (VERBOSE) System.out.println("Сервер запущен, ожидаем подключения...");

            try (Socket socket = server.accept()) {

                if (VERBOSE) System.out.println("Клиент подключился");

                try (Scanner sin = new Scanner(System.in);
                     DataInputStream in = new DataInputStream(socket.getInputStream());
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                    String clientMsg;
                    Sender serverSender = new Sender(sin, out);
                    Thread senderThread = new Thread(serverSender);
                    senderThread.start();

                    while (true) {
                        clientMsg = in.readUTF();
                        if (clientMsg.equals("bye")) {
                            System.out.println("Server stop write thread");
                            serverSender.setFlag(false);
                            break;
                        }
                        System.out.println("Client says: " + clientMsg);
                    }
                }

            } catch (IOException e) {
                System.out.println("Ошибка запуска сервера");
            }
        } catch (IOException e) {
            System.out.println("Ошибка инициализации сервера");
        }
    }
}