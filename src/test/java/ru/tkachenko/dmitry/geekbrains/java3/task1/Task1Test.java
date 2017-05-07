package ru.tkachenko.dmitry.geekbrains.java3.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 5/7/17
 */
public class Task1Test {

    @Test
    public void shiftInteger() {
        Integer[] expected = {56, 31, 8};
        Integer[] actual = {8, 31, 56};

        Task1.shift(actual, 2, 0);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shiftString() {
        String[] expected = {"one", "two", "three"};
        String[] actual = {"one", "three", "two"};

        Task1.shift(actual, 2, 1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shiftObject() {
        Object[] expected = {"one", 2, "three"};
        Object[] actual = {"one", "three", 2};

        Task1.shift(actual, 2, 1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void convertCharacterToList() throws Exception {
        Character[] charArray = {'a', 'b', (byte) 33, (byte) 0x32};
        List<Character> list = Task1.convertToList(charArray);
    }

    @Test
    public void convertIntegerToList() throws Exception {
        Integer[] intArray = {100, 30, 15};
        List<Integer> list = Task1.convertToList(intArray);
    }

}