package ru.tkachenko.dmitry.geekbrains.java1.dz2;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.tkachenko.dmitry.geekbrains.java1.dz2.Dz2.replaceArrayValues;

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
}