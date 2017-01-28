package ru.tkachenko.dmitry.geekbrains.java1.dz2;

import java.util.Arrays;

/**
 * Created by dmitry tkachenko on 28.01.2017.
 */
public class Dz2 {
    /**
     * Task 1
     * <p>
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
}
