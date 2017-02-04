package ru.tkachenko.dmitry.geekbrains.java1.dz4;

/**
 * Created by dmitry tkachenko on 2/4/17.
 */
public class Dz4Test {

    private static int DOTS_TO_WIN = 3;
    private static int SIZE = 3;
    private static char[][] tiles;
    private static char DOT_EMPTY = '_';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    public static void main(String[] args) {
        boolean result;
        fillMap();
        /*tiles[0][0] = DOT_X;
        tiles[0][2] = DOT_X;
        tiles[1][1] = DOT_X;

        tiles[1][2] = DOT_O;
        tiles[2][0] = DOT_O;
        tiles[2][2] = DOT_O;*/

        tiles = new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'X'}
        };

        printMap();
        int y = 1;
        int x = 1;
        char currentDot = DOT_O;

        long start = System.currentTimeMillis();

//        result = isContinue(currentDot);
//        System.out.println(result);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                System.out.printf("\n%d %d\n", i, j);
                result = findRightUp(i, j, currentDot);
                System.out.println(result);

                result = findRight(i, j, currentDot);
                System.out.println(result);

                result = findRightDown(i, j, currentDot);
                System.out.println(result);

                result = findDown(i, j, currentDot);
                System.out.println(result);

            }

        }
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);

    }

    private static boolean isContinue(char currentDot) {
        char dot = currentDot;

        if (dot == tiles[0][0] && dot == tiles[1][1] && dot == tiles[2][2]) return false;
        if (dot == tiles[0][2] && dot == tiles[1][1] && dot == tiles[2][0]) return false;

        if (findHorAndVerMatches(dot)) return false;
        return true;
    }

    private static boolean findHorAndVerMatches(char dot) {
        String line = "";

        for (int i = 0; i < DOTS_TO_WIN; i++) {
            line += dot;
        }

        for (int i = 0; i < SIZE; i++) {
            String horizontal = "";
            String vertical = "";

            for (int j = 0; j < SIZE; j++) {
                horizontal += tiles[i][j];
                vertical += tiles[j][i];
            }

            if (horizontal.equals(line) || vertical.equals(line)) return true;
        }

        return false;
    }

    private static boolean findRightUp(int y, int x, char currentDot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            y--;
            x++;

        }
        return true;
    }

    private static boolean findRight(int y, int x, char currentDot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            x++;
        }
        return true;
    }

    private static boolean findRightDown(int y, int x, char currentDot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            y++;
            x++;
        }
        return true;
    }

    private static boolean findDown(int y, int x, char currentDot) {
        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE || currentDot != tiles[y][x]) return false;

            y--;
        }
        return true;
    }

    static void fillMap() {
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


}