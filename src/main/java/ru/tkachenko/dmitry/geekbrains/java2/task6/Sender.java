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
        this.flag = true;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

        String serverWrite;
        try {
            while (flag) {
                serverWrite = in.nextLine();
                out.writeUTF(serverWrite);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
