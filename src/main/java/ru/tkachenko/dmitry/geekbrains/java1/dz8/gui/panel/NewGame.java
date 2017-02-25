package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/25/17
 */
public class NewGame extends JPanel {
    JButton btn;

    public NewGame() {
        setLayout(new FlowLayout());
        this.btn = new JButton("Start");
        add(btn);
    }

    public JButton getBtn() {
        return btn;
    }
}
