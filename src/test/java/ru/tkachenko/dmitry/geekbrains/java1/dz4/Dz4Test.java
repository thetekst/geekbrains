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
    private static char currentDot = DOT_O;
    private static char enemyDOt = DOT_X;

    public static void main(String[] args) {
        boolean result;
        fillMap();
        /*tiles[0][0] = DOT_X;
        tiles[0][2] = DOT_X;
        tiles[1][1] = DOT_X;

        tiles[1][2] = DOT_O;
        tiles[2][0] = DOT_O;
        tiles[2][2] = DOT_O;*/

        /*tiles = new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'X'}
        };*/


        // -----

        /*tiles = new char[][]{
                {'_', '_', '_'},
                {'_', 'X', 'O'},
                {'X', '_', '_'}
        };

        tiles = new char[][]{
                {'_', '_', 'X'},
                {'_', '_', 'O'},
                {'X', '_', '_'}
        };

        tiles = new char[][]{
                {'X', 'X', '_'},
                {'_', '_', 'O'},
                {'_', '_', '_'}
        };

        tiles = new char[][]{
                {'X', '_', '_'},
                {'_', '_', 'O'},
                {'X', '_', '_'}
        };

        tiles = new char[][]{
                {'X', '_', '_'},
                {'_', '_', 'O'},
                {'_', '_', 'X'}
        };*/

        printMap();
        int y = 1;
        int x = 1;


        long start = System.currentTimeMillis();

//        result = isContinue(currentDot);
//        System.out.println(result);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                System.out.printf("\n%d %d\n", i, j);

                result = setRightUp(i, j);
                System.out.println(result);

                result = setRight(i, j);
                System.out.println(result);

                result = setRightDown(i, j);
                System.out.println(result);

                result = setDown(i, j);
                System.out.println(result);

                /*result = findRightUp(i, j);
                System.out.println(result);

                result = findRight(i, j);
                System.out.println(result);

                result = findRightDown(i, j);
                System.out.println(result);

                result = findDown(i, j);
                System.out.println(result);*/

            }
        }
        printMap();
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
//        System.out.println(timeConsumedMillis);

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

    private static void aiPlayer() {

        switch (DOTS_TO_WIN) {
            case 1:
            case 2:
            case 3:
                if (!isSet()) {
                    System.out.println("вызываем рандомайзер");
                }
                break;
        }
    }

    private static boolean isSet() {
        System.out.println("AI");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (setRightUp(i, j)) return true;
                if (setRight(i, j)) return true;
                if (setRightDown(i, j)) return true;
                if (setDown(i, j)) return true;
            }
        }
        return false;
    }

    private static boolean setRightUp(int y, int x) {
        int lastEmptyY = -1;
        int lastEmptyX = -1;
        int enemyCount = 0;
        int emptyCount = 0;

        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) return false;
            if (DOT_EMPTY == tiles[y][x]) {
                lastEmptyY = y;
                lastEmptyX = x;
                emptyCount++;
            }
            if (enemyDOt == tiles[y][x]) enemyCount++;
            if (DOT_EMPTY == tiles[y][x]) emptyCount++;

            y--;
            x++;
        }

        if (lastEmptyY < 0 || lastEmptyX < 0 || lastEmptyY >= SIZE || lastEmptyX >= SIZE) {
            System.out.println("error");
            return false;
        }

        if (emptyCount > 0 && enemyCount >= SIZE - 1 && enemyCount > 0) tiles[lastEmptyY][lastEmptyX] = currentDot;
        return true;
    }

    private static boolean setRight(int y, int x) {
        int lastEmptyY = -1;
        int lastEmptyX = -1;
        int enemyCount = 0;
        int emptyCount = 0;

        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) return false;
            if (DOT_EMPTY == tiles[y][x]) {
                lastEmptyY = y;
                lastEmptyX = x;
                emptyCount++;
            }
            if (enemyDOt == tiles[y][x]) enemyCount++;
            if (DOT_EMPTY == tiles[y][x]) emptyCount++;

            x++;
        }

        if (lastEmptyY < 0 || lastEmptyX < 0 || lastEmptyY >= SIZE || lastEmptyX >= SIZE) {
            System.out.println("error");
            return false;
        }

        if (emptyCount > 0 && enemyCount >= SIZE - 1 && enemyCount > 0) tiles[lastEmptyY][lastEmptyX] = currentDot;
        return true;
    }

    private static boolean setRightDown(int y, int x) {
        int lastEmptyY = -1;
        int lastEmptyX = -1;
        int enemyCount = 0;
        int emptyCount = 0;

        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) return false;
            if (DOT_EMPTY == tiles[y][x]) {
                lastEmptyY = y;
                lastEmptyX = x;
                emptyCount++;
            }
            if (enemyDOt == tiles[y][x]) enemyCount++;
            if (DOT_EMPTY == tiles[y][x]) emptyCount++;

            y++;
            x++;
        }

        if (lastEmptyY < 0 || lastEmptyX < 0 || lastEmptyY >= SIZE || lastEmptyX >= SIZE) {
            System.out.println("error");
            return false;
        }

        if (emptyCount > 0 && enemyCount >= SIZE - 1 && enemyCount > 0) tiles[lastEmptyY][lastEmptyX] = currentDot;
        return true;
    }

    private static boolean setDown(int y, int x) {
        int lastEmptyY = -1;
        int lastEmptyX = -1;
        int enemyCount = 0;
        int emptyCount = 0;

        for (int j = 0; j < DOTS_TO_WIN; j++) {

            if (y < 0 || y >= SIZE || x < 0 || x >= SIZE) return false;
            if (DOT_EMPTY == tiles[y][x]) {
                lastEmptyY = y;
                lastEmptyX = x;
                emptyCount++;
            }
            if (enemyDOt == tiles[y][x]) enemyCount++;
            if (DOT_EMPTY == tiles[y][x]) emptyCount++;

            y++;
        }

        if (lastEmptyY < 0 || lastEmptyX < 0 || lastEmptyY >= SIZE || lastEmptyX >= SIZE) {
            System.out.println("error");
            return false;
        }

        if (emptyCount > 0 && enemyCount >= SIZE - 1 && enemyCount > 0) tiles[lastEmptyY][lastEmptyX] = currentDot;
        return true;
    }
}