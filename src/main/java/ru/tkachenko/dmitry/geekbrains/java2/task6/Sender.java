package ru.tkachenko.dmitry.geekbrains.java2.task6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/13/17
 */
public class Sender implements Runnable {

    private Scanner in;
    private DataOutputStream out;
    private boolean flag;

    public Sender(Scanner in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {

        String writer;
        try {
            while (true) {
                writer = in.nextLine();
                out.writeUTF(writer);
                out.flush();

                if (writer.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("app stopped");
        }
    }
}
