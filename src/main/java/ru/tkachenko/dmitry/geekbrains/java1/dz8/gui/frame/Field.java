package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel.Tile;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Field extends JFrame {
    private final int SIZE = 3;
    private Component[] tiles;

    public Field() {
        setup();
    }

    private void setup() {
        setTitle("TIC-TAC-toe");
        setSize(new Dimension(250, 250));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setupLayout();

        tiles = getContentPane().getComponents();

//        pack();
        setVisible(true);
    }

    private void setupLayout() {
        setLayout(new GridLayout(SIZE, SIZE));
        String title;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                title = String.format("%d%d", i, j);
                Tile tile = new Tile(title);
                JButton btn = new JButton("*");
                btn.addActionListener(new LabelListener());
                tile.add(btn);
                add(tile);

            }
        }
    }

    private class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("action");
        }
    }

    private Component[] getTiles() {
        return tiles;
    }
}
