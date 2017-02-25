package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.frame;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel.EndGame;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel.NewGame;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.panel.Tile;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.Human;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.PC;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.Player;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Board extends JFrame {
    private final int ROWS;
    private final int COLS;
    private final int COUNT;
    private Tile tiles;
    private final String DOT_EMPTY = "";
    private final String DOT_X = "X";
    private final String DOT_O = "O";
    private Player player1;
    private Player player2;
    private boolean trigger;
    private Player currentPlayer;
    private int step;
    private JButton[] buttons;

    public Board() {
        ROWS = 3;
        COLS = 3;
        COUNT = ROWS * COLS;
        step = 0;
        buttons = new JButton[COUNT];

        player1 = new Human(DOT_X);
        player2 = new PC(DOT_O);
        currentPlayer = player1;
        trigger = true;
        setup();
    }

    public Player getPlayer() {
        if (trigger) {
            trigger = !trigger;
            return player1;
        } else {
            trigger = !trigger;
            return player2;
        }
    }

    private void start() {
        while (isContinue()) {
//            player1.action();
//            player2.action();
        }
    }

    private boolean isContinue() {
        return true;
    }

    private void setup() {
        setTitle("TIC-TAC-toe");
        setSize(new Dimension(250, 250));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setupLayout();

//        pack();
        setVisible(true);
    }

    private void emptyBoard() {
        trigger = true;
        step = 0;

        for (int i = 0; i < COUNT; i++) {
            buttons[i].setText(DOT_EMPTY);
        }
    }

    private void setupLayout() {
        setLayout(new CardLayout());

//        setLayout(new BorderLayout());

        this.tiles = new Tile(ROWS, COLS);

        for (int i = 0; i < COUNT; i++) {
            JButton btn = new JButton(DOT_EMPTY);
            btn.addActionListener(new LabelListener());
            buttons[i] = btn;
            tiles.add(btn);
        }

        NewGame menu = new NewGame();
        menu.getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "PLAY");
            }
        });

        EndGame endGame = new EndGame();
        endGame.getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyBoard();
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "PLAY");
            }
        });

        add(menu, "MENU");
        add(tiles, "PLAY");
        add(endGame, "END");
    }

    private class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (step == COUNT) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "END");
            }

            if (e.getSource() instanceof JButton) {
                JButton btn = (JButton) e.getSource();
                String textBtn = btn.getText();

                if (DOT_EMPTY.equals(textBtn)) {
                    Player current = getPlayer();
                    current.action(btn);
                    step++;
                    System.out.println(step);

                    if (step != COUNT) {
                        current = getPlayer();

                        if (current instanceof PC) {
                            current.action(buttons[randomAI()]);
                            step++;
                            System.out.println(step);
                        }
                    }
                }
            }

            if (step == COUNT) {
                CardLayout cl = (CardLayout) getContentPane().getLayout();
                cl.show(getContentPane(), "END");
            }
        }
    }

    private int randomAI() {
        Random random = new Random();
        int rand = random.nextInt(COUNT); // 0 ... COUNT

        while (!buttons[rand].getText().equals(DOT_EMPTY)) {
            rand = random.nextInt(COUNT); // 0 ... COUNT
        }

        return rand;
    }

}
