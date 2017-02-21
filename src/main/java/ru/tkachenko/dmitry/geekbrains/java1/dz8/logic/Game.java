package ru.tkachenko.dmitry.geekbrains.java1.dz8.logic;

import javax.swing.*;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Game {
    private JFrame field;
    private final char DOT_EMPTY = '_';
    private final char DOT_X = 'X';
    private final char DOT_O = 'O';
    private Player player1;
    private Player player2;
    private boolean trigger = true;

    public Game(JFrame field) {
        this.field = field;
        player1 = new Player(DOT_X);
        player2 = new Player(DOT_O);
//        start();
    }

    private void start() {
        while (true) {
            if (trigger)
                player1.action(field);
            else
                player2.action(field);


        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
