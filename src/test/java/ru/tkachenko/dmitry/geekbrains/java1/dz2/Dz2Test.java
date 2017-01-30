package ru.tkachenko.dmitry.geekbrains.java1.dz2;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.tkachenko.dmitry.geekbrains.java1.dz2.Dz2.*;

/**
 * Created by dmitry tkachenko on 28.01.2017.
 */
public class Dz2Test {
    /**
     * Task 1
     *
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    @Test
    public void testReplaceArrayValues() {
        int[] array = {0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
        int[] inverted = {1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1};
        int[] replaced = replaceArrayValues(array);

        assertArrayEquals(inverted, replaced);
    }

    /**
     * Task 2
     * <p>
     * Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    @Test
    public void testFillArray() {
        int[] array = new int[8];
        int[] expected = {0, 3, 6, 9, 12, 15, 18, 21};
        int[] result = fillArray(array);

        assertArrayEquals(expected, result);
    }

    /**
     * Task 3
     * <p>
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     * пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    @Test
    public void testMultiplyLess6() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] expected = {2, 10, 6, 4, 11, 8, 10, 4, 8, 8, 9, 2};
        int[] result = multiplyLess6(array);

        assertArrayEquals(expected, result);
    }

    /**
     * Task 4
     * <p>
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов
     * одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    @Test
    public void testFillDiagonalArray() {
        int[][] expected3x3 = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        int[][] expected4x4 = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {1, 0, 0, 1}
        };

        int[][] expected5x5 = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };

        int[][] expected6x6 = {
                {1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0},
                {1, 0, 0, 0, 0, 1}
        };

        int[][][] expectedAll = {expected3x3, expected4x4, expected5x5, expected6x6};
        final int SIZE = expectedAll.length;
        int[][] result;

        for (int i = 0; i < SIZE; i++) {
            int currentLength = expectedAll[i].length;
            result = fillDiagonalArray(new int[currentLength][currentLength]);
            assertArrayEquals(expectedAll[i], result);
        }
    }

    /**
     * Task 5
     * <p>
     * Задать одномерный массив и найти в нем минимальный и максимальный
     * элементы (без помощи интернета);
     */
    @Test
    public void testMinMax() {
        int[] array1 = {3, 5, 7, 1, 0, -1, 9, 33, 8};
        int[] array2 = {66, -3, 7, 28, 987, 2};

        int[] result;
        result = minMax(array1);
        assertArrayEquals(new int[]{-1, 33}, result);

        result = minMax(array2);
        assertArrayEquals(new int[]{-3, 987}, result);
    }

    /**
     * Task 6
     * <p>
     * Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части
     * массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance
     * ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true,
     * граница показана символами ||, эти символы в массив не входят
     */
    @Test
    public void testCheckBalance() {
        int[] arrayFalse1 = {1, 1, 2, 1};
        int[] arrayTrue2 = {1, 1, 2};
        int[] arrayTrue3 = {1, 1, 1, 2, 1};
        int[] arrayFalse4 = {2, 1, 1, 2, 1};
        int[] arrayTrue5 = {10, 10};

        assertFalse(checkBalance(arrayFalse1));
        assertTrue(checkBalance(arrayTrue2));
        assertTrue(checkBalance(arrayTrue3));
        assertFalse(checkBalance(arrayFalse4));
        assertTrue(checkBalance(arrayTrue5));
    }

    /**
     * Task 7
     * <p>
     * Написать метод, которому на вход подается одномерный массив и число n (может быть
     * положительным, или отрицательным), при этом метод должен сместить все элементы
     * массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
     * массивами.
     */
    @Test
    public void testPositiveArrayNOffset() {
        int[] result;

        int[][] arrays = {
                {6, 3, 7, 4, 0},
                {3, 5, 7, 1, 0, -1, 9, 33, 8},
                {66, -3, 7, 28, 987, 2}
        };

        int[][] expected = {
                {4, 0, 6, 3, 7},
                {7, 1, 0, -1, 9, 33, 8, 3, 5},
                {2, 66, -3, 7, 28, 987}
        };

        int length = arrays.length;

        for (int i = 0; i < length; i++) {
            result = arrayNOffset(arrays[i], 7);
            assertArrayEquals(expected[i], result);
        }
    }

    @Test
    public void testNegativeArrayNOffset() {
        int[] result;

        int[][] arrays = {
                {6, 3, 7, 4, 0},
                {3, 5, 7, 1, 0, -1, 9, 33, 8},
                {66, -3, 7, 28, 987, 2}
        };

        int[][] expected = {
                {7, 4, 0, 6, 3},
                {7, 1, 0, -1, 9, 33, 8, 3, 5},
                {7, 28, 987, 2, 66, -3}
        };

        int length = arrays.length;

        for (int i = 0; i < length; i++) {
            result = arrayNOffset(arrays[i], -2);
            assertArrayEquals(expected[i], result);
        }
    }
}