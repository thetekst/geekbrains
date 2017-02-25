package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Tile extends JPanel {
    JButton btn;

    public Tile(int row, int col) {
        setLayout(new GridLayout(row, col));
//        setBorder(new LineBorder(Color.black, 2));
//        setName(btnName);
//        this.btn = new JButton("*");
//        add(btn);

//        addActionListener(new Board.LabelListener());
    }


}
