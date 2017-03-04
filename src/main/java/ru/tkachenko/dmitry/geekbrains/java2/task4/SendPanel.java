package ru.tkachenko.dmitry.geekbrains.java2.task4;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/4/17
 */
class SendPanel extends JPanel {
    private JTextField textField;
    private JTextArea textArea;
    private String br;
    private Date date;
    private final SimpleDateFormat dateFormat;

    SendPanel(JTextArea textArea) {
        this.textArea = textArea;

        textField = new JTextField() {
            @Override
            public void addNotify() {
                super.addNotify();
                requestFocus();
            }
        };

        br = "";
        dateFormat = new SimpleDateFormat("HH:mm");

        setup();
    }

    private void setup() {
        textField.setPreferredSize(new Dimension(310, 24));
        JButton btn = new JButton("Send");

        btn.addActionListener(new SendBtnListener());
        textField.addActionListener(new SendBtnListener());

        add(textField);
        add(btn);
    }

    private String getTime() {
        date = new Date();
        return dateFormat.format(date);
    }

    private void append() {
        String text = textField.getText();

        if (!text.isEmpty()) {
            textArea.setText(String.format("%s%s[%s] %s", textArea.getText(), br, getTime(), text));
            textField.setText("");
            br = "\n";
        }
    }

    private class SendBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() instanceof JButton) {
                append();
            }

            if (e.getSource() instanceof JTextField) {
                append();
            }
        }
    }

}
