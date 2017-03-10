package ru.tkachenko.dmitry.geekbrains.java1.dz8.gui;

import javax.swing.*;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.player.Player;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class Board extends JFrame {
    private static Board instance;
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
    private JButton[][] buttons;

    public Board() {
        System.out.println("Board init");
        ROWS = 3;
        COLS = 3;
        COUNT = ROWS * COLS;
        step = 0;
        buttons = new JButton[ROWS][COLS];

//        player1 = new Human(DOT_X);
//        player2 = new PC(DOT_O);
        currentPlayer = player1;
        trigger = true;
    }

//    public static Board getInstance() {
//        if(instance == null){
//            instance = new Board();
//        }
//        return instance;
//    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLS() {
        return COLS;
    }

    public int getCOUNT() {
        return COUNT;
    }

    public String getDOT_EMPTY() {
        return DOT_EMPTY;
    }

    public String getDOT_X() {
        return DOT_X;
    }

    public String getDOT_O() {
        return DOT_O;
    }

    public JButton[][] getButtons() {
        return buttons;
    }


    private void start() {
//        while (isContinue()) {
//            player1.action();
//            player2.action();
//        }
    }

    private boolean isContinue(Player player) {
        for (int i = 0; i < COUNT; i += ROWS) {
            for (int j = 0; j < COLS; j++) {
                System.out.printf("[%d]", i + j);
            }
            System.out.println();
        }
        return true;
    }


    private int staticAI() {
//        if (buttons[4].getText().equals((DOT_EMPTY))) return 4;
        return 0;
    }

    private int logicAI() {
        return 0;
    }

//    private JButton randomAI() {
//        int row;
//        int col;
//        Random random = new Random();
//
//        do {
//            row = random.nextInt(ROWS); // 0 ... ROWS
//            col = random.nextInt(COLS); // 0 ... COLS
//        } while (!buttons[row][col].getText().equals(DOT_EMPTY));
//
//        return buttons[row][col];
//    }


}
