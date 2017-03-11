package ru.tkachenko.dmitry.geekbrains.java1.dz8.player;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.constant.Dot;

import javax.swing.*;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Human extends Player {

    public Human(String dot) {
        super(dot);
    }

    @Override
    public void turn(JButton btn) {
//        System.out.print("turn Human: ");
        btn.setText(dot);
//        btn.setEnabled(false);
    }
}
