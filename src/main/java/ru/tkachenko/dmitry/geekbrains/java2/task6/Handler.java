package ru.tkachenko.dmitry.geekbrains.java2.task6;

import ru.tkachenko.dmitry.geekbrains.java2.task6.Sender;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/13/17
 */
public class Handler {

    public Handler(Socket socket, String className) {

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
                    System.out.printf("%s stop write thread%n", className);
                    serverSender.setFlag(false);
                    break;
                }
                System.out.printf("%s says: %s%n", className, clientMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
