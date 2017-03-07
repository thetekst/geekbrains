package ru.tkachenko.dmitry.geekbrains.java2.task4;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/4/17
 */
class Frame extends JFrame {

    Frame() {
        setTitle("Chat");
        setSize(new Dimension(400, 400));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BigTextPanel bigTextPanel = new BigTextPanel();
        SendPanel sendPanel = new SendPanel(bigTextPanel.getTextArea());

        add(bigTextPanel, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
