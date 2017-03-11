package ru.tkachenko.dmitry.geekbrains.java1.dz8.logic;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.constant.Dot;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.NewGame;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.Human;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.PC;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Game extends JFrame {
    private final int ROWS;
    private final int COLS;
    private final int COUNT;
    private final int DOTS_TO_WIN;
    private Player player1;
    private Player player2;
    private boolean trigger;
    private int step;
    private JButton[][] buttons;
    private boolean gameOver;
    private JLabel endGameLabel;
    private final boolean VERBOSE;

    public Game(Player player1, Player player2) {
        ROWS = 3;
        COLS = 3;
        COUNT = ROWS * COLS;
        step = 0;
        buttons = new JButton[ROWS][COLS];
        DOTS_TO_WIN = 3;
        VERBOSE = false;

        this.player1 = player1;
        this.player2 = player2;
        trigger = true;
        gameOver = false;
        setup();
    }

    private Player getPlayer() {
        if (trigger) {
            return player1;
        } else {
            return player2;
        }
    }

    private void nextPlayer() {
        trigger = !trigger;
    }


    private void setup() {
        setTitle("TIC-TAC-toe");
        setSize(new Dimension(250, 300));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setupLayout();

//        pack();
        setVisible(true);
    }

    public void emptyBoard() {
        trigger = true;
        step = 0;
        gameOver = false;
        endGameLabel.setText(" ");

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons[i][j].setText(Dot.EMPTY.getDot());
            }
        }
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        JPanel tiles = new JPanel(new GridLayout(ROWS, COLS));

        JButton btn;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                btn = new JButton(Dot.EMPTY.getDot());
                btn.addActionListener(new LabelListener());
                buttons[i][j] = btn;
                tiles.add(btn);
            }
        }

//        injectTest();
//        turnAI();


        endGameLabel = new JLabel(" ");

        add(new NewGame(this), BorderLayout.NORTH);
        add(tiles, BorderLayout.CENTER);
        add(endGameLabel, BorderLayout.SOUTH);
    }



    private void setWinLable(String text) {
        endGameLabel.setText(text);
        gameOver = true;
    }

    private void printMap() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.printf("[%1s]", buttons[i][j].getText());
            }
            System.out.println();
        }
        System.out.println("----------------");
    }

    private class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() instanceof JButton) {
                JButton btn = (JButton) e.getSource();
                String textBtn = btn.getText();

                if (!gameOver && Dot.EMPTY.getDot().equals(textBtn)) {
                    Player current = getPlayer();

                    if (current instanceof Human) {
                        current.turn(btn);

                        step++;

                        if (VERBOSE) {
                            System.out.println(step);
                            System.out.println();
                            printMap();
                        }

                        if (isWin(current.getChar())) {
                            setWinLable(String.format("Player %s (%s) is win",
                                    current.getClass().getSimpleName(),
                                    current.getChar()));
                        } else if (isBoardFull()) {
                            setWinLable("Draw");
                        }


                        if (!gameOver) {
                            nextPlayer();
                            current = getPlayer();


                            if (current instanceof PC) {

                                current.turn(turnAI());

                                step++;
                                if (VERBOSE) {
                                    System.out.println(step);
                                    System.out.println();
                                    printMap();
                                }

                                if (isWin(current.getChar())) {
                                    setWinLable(String.format("Player %s (%s) is win",
                                            current.getClass().getSimpleName(),
                                            current.getChar()));
                                } else if (isBoardFull()) {
                                    setWinLable("Draw");
                                }

                                nextPlayer();
                            }
                        }
                    }

                }
            }
        }
    }

    private boolean isContinue(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) return false;

        return buttons[row][col].getText().equals(Dot.EMPTY.getDot());

    }

    private boolean isWin(String aChar) {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (!buttons[row][col].getText().equals(aChar)) continue;

                if (findRightUp(row, col, aChar)) return true;
                if (findRight(row, col, aChar)) return true;
                if (findRightDown(row, col, aChar)) return true;
                if (findDown(row, col, aChar)) return true;
            }
        }
        return false;
    }

    private boolean findRightUp(int row, int col, String dot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (row < 0 || row >= ROWS || col < 0 || col >= COLS
                    || !dot.equals(buttons[row][col].getText())) return false;

            row--;
            col++;
        }
        return true;
    }

    private boolean findRight(int row, int col, String dot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (row < 0 || row >= ROWS || col < 0 || col >= COLS
                    || !dot.equals(buttons[row][col].getText())) return false;

            col++;
        }
        return true;
    }

    private boolean findRightDown(int row, int col, String dot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (row < 0 || row >= ROWS || col < 0 || col >= COLS
                    || !dot.equals(buttons[row][col].getText())) return false;

            row++;
            col++;
        }
        return true;
    }

    private boolean findDown(int row, int col, String dot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (row < 0 || row >= ROWS || col < 0 || col >= COLS
                    || !dot.equals(buttons[row][col].getText())) return false;

            row++;
        }
        return true;
    }

    private boolean isBoardFull() {
        return step == COUNT;
    }

    private int[] findPossibility(String dot) {
        String empty = Dot.EMPTY.getDot();

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (buttons[row][col].getText().equals(empty)) {
                    buttons[row][col].setText(dot);
                    if (isWin(dot)) {
                        buttons[row][col].setText(empty);
                        return new int[]{row, col};
                    }
                    buttons[row][col].setText(empty);
                }
            }
        }
        if (VERBOSE) {
            System.out.println();
        }
        return new int[]{-1, -1};
    }

    private JButton turnAI() {
        int row;
        int col;
        Random random = new Random();
        int[] coords;

        coords = findPossibility(Dot.O.getDot());

        if (-1 == coords[0]) {
            coords = findPossibility(Dot.X.getDot());
        }

        if (-1 == coords[0]) {
            do {
                row = random.nextInt(ROWS); // 0 ... ROWS
                col = random.nextInt(COLS); // 0 ... COLS
            } while (!isContinue(row, col));
            coords[0] = row;
            coords[1] = col;
        }

        return buttons[coords[0]][coords[1]];
    }

    private void injectTest() {
        step = 7;

        buttons[0][0].setText(Dot.X.getDot());
//        buttons[0][1].setText(Dot.X.getDot());

        buttons[1][0].setText(Dot.X.getDot());
//        buttons[1][1].setText(Dot.O.getDot());
//        buttons[1][2].setText(Dot.X.getDot());

//        buttons[2][0].setText(Dot.O.getDot());
//        buttons[2][1].setText(Dot.X.getDot());
        buttons[2][2].setText(Dot.O.getDot());
    }
}
