package ru.tkachenko.dmitry.geekbrains.java1.dz8;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.constant.Dot;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.logic.Game;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.Human;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.PC;

import javax.swing.*;

/**
 * Created by dmitry tkachenko on 2/18/17.
 * <p>
 * Сделать крестики-нолики 3x3 с использованием Swing
 */
public class Dz8 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game(new Human(Dot.X.getDot()), new PC(Dot.O.getDot())));
    }
}
