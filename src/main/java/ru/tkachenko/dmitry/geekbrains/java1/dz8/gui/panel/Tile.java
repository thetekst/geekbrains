package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.frame.Field;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Tile extends JPanel {
    JButton btn;

    public Tile(String btnName) {
        setBorder(new LineBorder(Color.black, 2));
        setName(btnName);
//        this.btn = new JButton("*");
//        add(btn);

//        addActionListener(new Field.LabelListener());
    }


}
