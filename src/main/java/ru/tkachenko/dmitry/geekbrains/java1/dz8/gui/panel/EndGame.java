package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/25/17
 */
public class EndGame extends JPanel {

    JButton btn;

    public EndGame() {
        setLayout(new FlowLayout());
        this.btn = new JButton("Play again");
        add(btn);
    }

    public JButton getBtn() {
        return btn;
    }
}
