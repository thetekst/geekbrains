package ru.tkachenko.dmitry.geekbrains.java1.dz4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by dmitry tkachenko on 2/3/17.
 * <p>
 * Крестики-нолики в процедурном стиле
 * <p>
 * 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь
 * не подглядывать в методичку;
 * <p>
 * 2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
 * например, с использованием циклов.
 * <p>
 * 3. Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
 * количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
 * возможных ситуаций;
 * <p>
 * 4. Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */
public class Dz4 {
    private static char[][] tiles;
    private static final int SIZE = 3;
    private static final int ACTION_SUM = SIZE * SIZE;
    private static final int DOTS_TO_WIN = 3;
    private static final char DOT_EMPTY = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static boolean trigger = true;
    private static int actionCounter = 0;

    public static void main(String[] args) {
        fillMap();
        printMap();

        while (checkGameLoop()) {
            if (trigger) humanPlayer();
            else aiPlayer();

            trigger = !trigger;
            printMap();
            actionCounter++;
            System.out.println("actionSum: " + actionCounter);
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

        tiles[y][x] = DOT_X;
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

        tiles[y][x] = DOT_O;
    }

    private static boolean checkAction(int y, int x) {
        if (x < 0 && y < 0 && x >= SIZE & y >= SIZE) return false;
        if (DOT_EMPTY == tiles[y][x]) return true;
//        if (isTileFree(y, x)) return true;
        return false;
    }

    private static boolean isTileFree(int y, int x) {
        return false;
    }

    private static boolean checkGameLoop() {
        if (actionCounter == ACTION_SUM) return false;
        return true;
    }
}
