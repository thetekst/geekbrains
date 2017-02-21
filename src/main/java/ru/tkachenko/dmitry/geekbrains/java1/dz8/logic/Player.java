package ru.tkachenko.dmitry.geekbrains.java1.dz8.logic;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Player {
    private char dot;
    private static boolean next;

    public Player(char dot) {
        this.dot = dot;
    }

    public void action(JFrame field) {

    }

    public void next() {
        next = !next;
    }
}
