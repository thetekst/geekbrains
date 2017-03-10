package ru.tkachenko.dmitry.geekbrains.java1.dz8.player;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.constant.Dot;

import javax.swing.*;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public abstract class Player {
    String dot;
    //    Board board;
    private static boolean next;

    Player(String dot) {
//        this.board = board;
        this.dot = dot;
    }

    @Override
    public String toString() {
        return "Player{" +
                "dot='" + dot + '\'' +
                '}';
    }

    public abstract void turn(JButton btn);

    public String getChar() {
        return dot;
    }
}
