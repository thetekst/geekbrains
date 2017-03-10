package ru.tkachenko.dmitry.geekbrains.java1.dz8.logic;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.constant.Dot;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.EndGame;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.NewGame;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.gui.Tile;
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
    private Tile tiles;
    private final int DOTS_TO_WIN;
    private Player player1;
    private Player player2;
    private boolean trigger;
    private int step;
    private JButton[][] buttons;
    private boolean gameOver;
    private EndGame endGame;

    public Game(Player player1, Player player2) {
        ROWS = 3;
        COLS = 3;
        COUNT = ROWS * COLS;
        step = 0;
        buttons = new JButton[ROWS][COLS];
        DOTS_TO_WIN = 3;

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
        setSize(new Dimension(250, 250));
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

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                buttons[i][j].setText(Dot.EMPTY.getDot());
            }
        }
    }

    private void setupLayout() {
        setLayout(new CardLayout());

//        setLayout(new BorderLayout());

        this.tiles = new Tile(ROWS, COLS);
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(ROWS, COLS));

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

        NewGame menu = new NewGame(this);
        endGame = new EndGame(this);

//        add(menu, "MENU");
        add(tiles, "PLAY");
        add(endGame, "END");
    }

    private void injectTest() {
        step = 7;

        buttons[0][0].setText(Dot.X.getDot());
//        buttons[0][1].setText(Dot.X.getDot());

        buttons[1][0].setText(Dot.O.getDot());
        buttons[1][1].setText(Dot.O.getDot());
        buttons[1][2].setText(Dot.X.getDot());

        buttons[2][0].setText(Dot.O.getDot());
        buttons[2][1].setText(Dot.X.getDot());
        buttons[2][2].setText(Dot.O.getDot());
    }

    private void setWinLable(String text) {
        endGame.setLabel(text);
        gameOver = true;
        CardLayout cl = (CardLayout) getContentPane().getLayout();
        cl.show(getContentPane(), "END");
    }

    private class LabelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() instanceof JButton) {
                JButton btn = (JButton) e.getSource();
                String textBtn = btn.getText();

                if (Dot.EMPTY.getDot().equals(textBtn)) {
                    Player current = getPlayer();

                    if (current instanceof Human) {
                        current.turn(btn);
                        step++;
                        System.out.println(step);

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
                                current.turn(randomAI());

                                step++;
                                System.out.println(step);

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

        if (buttons[row][col].getText().equals(Dot.EMPTY.getDot())) {
//            System.out.printf("[%s] == [%s]\n", buttons[row][col].getText(), DOT_EMPTY);
            return true;
        }

        return false;
    }

    private boolean isWin(String aChar) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (!buttons[j][i].getText().equals(aChar)) continue;
                if (checkLine(i, j, 1, 0, aChar)) return true; // пытаемся построить горизонтальные линии
                if (checkLine(i, j, 0, 1, aChar)) return true; // пытаемся построить веритикальные линии
                if (checkLine(i, j, 1, 1, aChar))
                    return true; // пытаемся построить диагональные линии направленные вправо-вниз
                if (checkLine(i, j, 1, -1, aChar))
                    return true; // пытаемся построить диагональные линии направленные вправо-вверх
            }
        }
//        if (buttons[0][0].getText().equals(aChar) && buttons[0][1].getText().equals(aChar) && buttons[0][2].getText().equals(aChar)) return true;
//        if (buttons[1][0].getText().equals(aChar) && buttons[1][1].getText().equals(aChar) && buttons[1][2].getText().equals(aChar)) return true;
//        if (buttons[2][0].getText().equals(aChar) && buttons[2][1].getText().equals(aChar) && buttons[2][2].getText().equals(aChar)) return true;
//
//        if (buttons[0][0].getText().equals(aChar) && buttons[1][0].getText().equals(aChar) && buttons[2][0].getText().equals(aChar)) return true;
//        if (buttons[0][1].getText().equals(aChar) && buttons[1][1].getText().equals(aChar) && buttons[2][1].getText().equals(aChar)) return true;
//        if (buttons[0][2].getText().equals(aChar) && buttons[1][2].getText().equals(aChar) && buttons[2][2].getText().equals(aChar)) return true;
//
//        if (buttons[0][0].getText().equals(aChar) && buttons[1][1].getText().equals(aChar) && buttons[2][2].getText().equals(aChar)) return true;
//        if (buttons[2][0].getText().equals(aChar) && buttons[1][1].getText().equals(aChar) && buttons[0][2].getText().equals(aChar)) return true;
        return false;
    }

    private boolean checkLine(int cx, int cy, int vx, int vy, String dot) {
        // отсеиваем заранее невозможные проверки
        if (cx + DOTS_TO_WIN * vx > ROWS || cy + DOTS_TO_WIN * vy > COLS || cy + DOTS_TO_WIN * vy < -1) return false;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            if (!buttons[cy + i * vy][cx + i * vx].getText().equals(dot)) return false;
        }
        return true;
    }

    private boolean isBoardFull() {

        if (step == COUNT) {
            System.out.println("Ничья");
            endGame.setLabel("Ничья");
            return true;
        }
        return false;
    }

    private JButton randomAI() {
        int row;
        int col;
        Random random = new Random();

        do {
            row = random.nextInt(ROWS); // 0 ... ROWS
            col = random.nextInt(COLS); // 0 ... COLS
        } while (!isContinue(row, col));
//        System.out.printf("[%d][%d] = \"%s\" ", row, col, buttons[row][col].getText());

        return buttons[row][col];
    }

//    private JButton ai() {
//        int x = -1, y = -1;
//        for (int i = 0; i < ROWS; i++) {
//            for (int j = 0; j < COLS; j++) {
//                if (isCellEmpty(i, j)) {
//                    buttons[j][i].getText().equals() = O_DOT;
//                    if (checkWinNew(O_DOT)) {
//                        x = i;
//                        y = j;
//                    }
//                    buttons[j][i].getText().equals() = EMPTY_DOT;
//                }
//
//            }
//        }
//        if (x == -1 && y == -1) {
//            for (int i = 0; i < SIZE; i++) {
//                for (int j = 0; j < SIZE; j++) {
//                    if (isCellEmpty(i, j)) {
//                        buttons[j][i].getText().equals() = X_DOT;
//                        if (checkWinNew(X_DOT)) {
//                            x = i;
//                            y = j;
//                        }
//                        buttons[j][i].getText().equals() = EMPTY_DOT;
//                    }
//
//                }
//            }
//        }
//        if (x == -1 && y == -1) {
//            do {
//                x = rand.nextInt(SIZE);
//                y = rand.nextInt(SIZE);
//            } while (!isCellEmpty(x, y));
//        }
//        System.out.printf("AI сделал ход %d; %d\n", x + 1, y + 1);
//        buttons[y][x].getText().equals() = O_DOT;
//    }
}
