package ru.tkachenko.dmitry.geekbrains.java1.dz2;

/**
 * Created by dmitry tkachenko on 28.01.2017.
 */
public class Dz2 {
    /**
     * Task 1
     *
     * Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    static int[] replaceArrayValues(int[] array) {
        int arrayLength = array.length;

        for (int i = 0; i < arrayLength; i++) {
            array[i] = (array[i] > 0) ? 0 : 1;
        }
        return array;
    }

    /**
     * Task 2
     * <p>
     * Задать пустой целочисленный массив размером 8.
     * С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    static int[] fillArray(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            array[i] = i * 3;
        }
        return array;
    }

    /**
     * Task 3
     * <p>
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     * пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    static int[] multiplyLess6(int[] array) {
        int length = array.length;
        int tmp;

        for (int i = 0; i < length; i++) {
            tmp = array[i];
            array[i] = tmp < 6 ? tmp * 2 : tmp;
        }
        return array;
    }

    /**
     * Task 4
     * <p>
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов
     * одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    static int[][] fillDiagonalArray(int[][] array) {
        int length = array.length;
        int firstItem;
        int lastItem;
        int firstArray;
        int lastArray;

        for (int i = 0; i < length; i++) {
            firstItem = i;
            lastItem = length - i - 1;

            firstArray = array[i][firstItem];
            lastArray = array[i][lastItem];

            if (firstArray != 1 && lastArray != 1) {
                array[i][firstItem] = 1;
                array[i][lastItem] = 1;
            }
        }
        return array;
    }

    /**
     * Task 5
     * <p>
     * Задать одномерный массив и найти в нем минимальный и максимальный
     * элементы (без помощи интернета);
     */
    static int[] minMax(int[] array) {
        int min = 0;
        int max = 0;

        for (int item : array) {
            if (item < min) min = item;
            if (item > max) max = item;
        }
        return new int[]{min, max};
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
    static boolean checkBalance(int[] array) {
        int length = array.length;
        int leftSum;
        int rightSum;

        for (int i = 0; i < length - 1; i++) {
            leftSum = 0;
            rightSum = 0;

            for (int j = 0; j <= i; j++) {
                leftSum += array[j];
            }

            for (int k = i + 1; k < length; k++) {
                rightSum += array[k];
            }

            if (leftSum == rightSum) return true;
        }
        return false;
    }

    /**
     * Task 7
     * <p>
     * Написать метод, которому на вход подается одномерный массив и число n (может быть
     * положительным, или отрицательным), при этом метод должен сместить все элементы
     * массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
     * массивами.
     */
    static int[] arrayNOffset(int[] array, int n) {

        if (n < 0) {
            negativeArrayNOffset(array, n);
        } else {
            positiveArrayNOffset(array, n);
        }


        return array;
    }

    private static int[] negativeArrayNOffset(int[] array, int n) {
        int length = array.length;
        int current;
        int next;
        n *= -1;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < length - 1; k++) {
                current = array[k];
                next = k + 1;

                if (k + 1 > length - 1) {
                    next = 0;
                }
                array[k] = array[next];
                array[next] = current;
            }
        }

        return array;
    }

    private static int[] positiveArrayNOffset(int[] array, int n) {
        int length = array.length - 1;
        int current;
        int prev;

        for (int i = 0; i < n; i++) {
            for (int k = length; 0 <= k; k--) {
                current = array[k];
                prev = k - 1;

                if (k - 1 < 0) {
                    prev = 0;
                }
                array[k] = array[prev];
                array[prev] = current;
            }

        }

        return array;
    }
}
