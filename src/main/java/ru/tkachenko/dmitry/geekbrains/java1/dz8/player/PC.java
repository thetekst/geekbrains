package ru.tkachenko.dmitry.geekbrains.java1.dz8.player;

import javax.swing.*;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class PC extends Player {

    public PC(String dot) {
        super(dot);
    }

    @Override
    public void action(JButton btn) {
        btn.setText(dot);
    }
}
