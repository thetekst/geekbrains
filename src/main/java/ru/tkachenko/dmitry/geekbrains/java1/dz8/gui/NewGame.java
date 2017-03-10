package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/25/17
 */
public class NewGame extends JPanel {
    private Game game;
    private JButton btn;

    public NewGame(Game game) {
        this.game = game;
        setLayout(new FlowLayout());
        this.btn = new JButton("Start");
        btn.addActionListener(new BtnListener());
        add(btn);
    }

    private class BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) game.getContentPane().getLayout();
            cl.show(game.getContentPane(), "PLAY");
        }
    }
}
