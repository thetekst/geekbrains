package ru.tkachenko.dmitry.geekbrains.java2.task6.client;

import ru.tkachenko.dmitry.geekbrains.java2.task6.Handler;
import ru.tkachenko.dmitry.geekbrains.java2.task6.Sender;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/12/17
 */
public class ClientApp {

    private final String serrverIp;
    private final int serverPort;

    ClientApp(String serrverIp, int serverPort) {
        this.serrverIp = serrverIp;
        this.serverPort = serverPort;
    }

    public void run() {
        try (Socket socket = new Socket(serrverIp, serverPort)) {
            new Handler(socket, "Server");

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to ");
            System.exit(1);
        }
    }
}
