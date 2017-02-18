package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.frame;

import javax.swing.*;
import java.awt.*;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel.Panel;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Window extends JFrame {
    private static JPanel[][] tiles;
    private static final int SIZE = 3;

    public Window() {
        setup();
    }

    private void setup() {
        setTitle("TIC-TAC-toe");
        setSize(new Dimension(400, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setupLayout();

//        pack();
        setVisible(true);
    }

    private void setupLayout() {
        setLayout(new GridLayout(SIZE, SIZE));

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                add(new Panel());
            }
        }
    }
}
