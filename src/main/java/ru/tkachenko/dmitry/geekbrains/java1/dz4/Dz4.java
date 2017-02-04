package ru.tkachenko.dmitry.geekbrains.java1.dz4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by dmitry tkachenko on 2/3/17.
 *
 * Крестики-нолики в процедурном стиле
 *
 * 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь
 * не подглядывать в методичку;
 *
 * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
 * например, с использованием циклов.
 *
 * 3. Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
 * количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
 * возможных ситуаций;
 *
 * 4. Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */
public class Dz4 {
    private static char[][] tiles;
    private static final int SIZE = 5;
    private static final int ACTION_SUM = SIZE * SIZE;
    private static final int DOTS_TO_WIN = 4;
    private static final char DOT_EMPTY = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static boolean trigger = true;
    private static int actionCounter = 0;
    private static char currentDot;

    public static void main(String[] args) {
        fillMap();
        printMap();

        while (checkGameLoop()) {
            if (trigger) {
                currentDot = DOT_X;
//                humanPlayer();
                aiPlayer();
            } else {
                currentDot = DOT_O;
                aiPlayer();
            }

            trigger = !trigger;
            printMap();
            actionCounter++;
        }
    }

    private static void fillMap() {
        tiles = new char[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tiles[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        System.out.printf("   ");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d ", i + 1);
        }

        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%2c ", tiles[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    private static int[] humanInput() {
        int input[] = new int[2];

        while (!scanner.hasNextInt()) {
            scanner.next();
        }

        while (!scanner.hasNextInt()) {
            scanner.next();
        }

        input[0] = scanner.nextInt() - 1;
        input[1] = scanner.nextInt() - 1;

        return input;
    }

    private static void humanPlayer() {
        int y;
        int x;

        do {
            System.out.println("Ходит человек");
            System.out.println("Введите Y X");
            int[] input = humanInput();
            y = input[0];
            x = input[1];
        } while (!checkAction(y, x));

        tiles[y][x] = currentDot;
    }

    private static void aiPlayer() {
        int y;
        int x;

        System.out.println("Ходит AI");

        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!checkAction(y, x));

        System.out.printf("y: %d x: %d\n", y + 1, x + 1);

        tiles[y][x] = currentDot;
    }

    private static boolean checkAction(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return false;
        if (DOT_EMPTY == tiles[y][x]) return true;
        return false;
    }

    private static boolean isContinue() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (findRightUp(i, j)) return false;
                if (findRight(i, j)) return false;
                if (findRightDown(i, j)) return false;
                if (findDown(i, j)) return false;
            }
        }
        return true;
    }

    private static boolean findRightUp(int y, int x) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            y--;
            x++;
        }
        return true;
    }

    private static boolean findRight(int y, int x) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            x++;
        }
        return true;
    }

    private static boolean findRightDown(int y, int x) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            y++;
            x++;
        }
        return true;
    }

    private static boolean findDown(int y, int x) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            y--;
        }
        return true;
    }

    private static boolean checkGameLoop() {
        if (actionCounter == ACTION_SUM) return false;
        if (!isContinue()) return false;
        return true;
    }
}
