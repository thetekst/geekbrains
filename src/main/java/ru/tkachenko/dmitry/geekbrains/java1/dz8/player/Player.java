package ru.tkachenko.dmitry.geekbrains.java1.dz8.player;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public abstract class Player {
    String dot;
    private static boolean next;

    public Player(String dot) {
        this.dot = dot;
    }

    public abstract void action(JButton btn);

    public void next() {
        next = !next;
    }

    public String getChar() {
        return dot;
    }
}
