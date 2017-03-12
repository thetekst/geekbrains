package ru.tkachenko.dmitry.geekbrains.java2.task6.server;

import java.io.IOException;
import java.io.PrintWriter;
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

                try (Scanner in = new Scanner(socket.getInputStream());
                     PrintWriter out = new PrintWriter(socket.getOutputStream())) {

                    String str;

                    while (true) {
                        str = in.nextLine();
                        if (str.equals("quit")) break;
                        out.println("Server: " + str);
                        out.flush();
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