package ru.tkachenko.dmitry.geekbrains.java2.task6.client;

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

            try (Scanner uin = new Scanner(System.in);
                 DataInputStream in = new DataInputStream(socket.getInputStream());
                 DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                String serverResponse;

                Sender clientSender = new Sender(uin, out);
                Thread senderThread = new Thread(clientSender);
                senderThread.start();

                while (true) {
                    serverResponse = in.readUTF();
                    if (serverResponse.equals("bye")) {
                        System.out.println("Client stop write thread");
                        clientSender.setFlag(false);
                        break;
                    }
                    System.out.println("Server says: " + serverResponse);
                }

            } catch (IOException e) {
                System.out.println("Ошибка чтения");
            }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to ");
            System.exit(1);
        }
    }
}
