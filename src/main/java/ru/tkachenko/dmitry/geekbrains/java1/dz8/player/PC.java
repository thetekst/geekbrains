package ru.tkachenko.dmitry.geekbrains.java1.dz8.player;

import ru.tkachenko.dmitry.geekbrains.java1.dz8.constant.Dot;
import ru.tkachenko.dmitry.geekbrains.java1.dz8.logic.Game;

import javax.swing.*;
import java.util.Random;

/**
 * Created by dmitry tkachenko on 2/18/17.
 */
public class PC extends Player {

    public PC(String dot) {
        super(dot);
    }

    @Override
    public void turn(JButton btn) {
//        JButton btn = randomAI();
        btn.setText(dot);
//        btn.setEnabled(false);
//        randomAI();
        System.out.print("turn PC: ");
    }

    private JButton randomAI() {
        int row;
        int col;
        Random random = new Random();

        /*do {
            row = random.nextInt(board.getROWS()); // 0 ... ROWS
            col = random.nextInt(board.getCOLS()); // 0 ... COLS
        } while (!board.getButtons()[row][col].getText().equals(board.getDOT_EMPTY()));

        return board.getButtons()[row][col];*/
        return null;
    }
}
