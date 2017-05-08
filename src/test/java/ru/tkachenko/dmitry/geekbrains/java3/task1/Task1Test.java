package ru.tkachenko.dmitry.geekbrains.java3.task1;

import org.junit.Assert;
import org.junit.Test;
import ru.tkachenko.dmitry.geekbrains.java3.task1.box.Apple;
import ru.tkachenko.dmitry.geekbrains.java3.task1.box.Box;
import ru.tkachenko.dmitry.geekbrains.java3.task1.box.Orange;

import java.util.*;

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

    @Test
    public void testDiffFruitBox() {
        List<Apple> apples = new ArrayList<>(
                Arrays.asList(
                        new Apple(),
                        new Apple())
        );
        Box<Apple> appleBox = new Box<>(apples, 1.0f);
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Box<Orange> orangeBox = new Box<>(
                Arrays.asList(
                        new Orange(),
                        new Orange(),
                        new Orange()
                ), 1.5f
        );

        Assert.assertNotEquals(appleBox.getWeight(), orangeBox.getWeight());
        Assert.assertFalse(appleBox.compare(orangeBox));
    }

    @Test
    public void testSameEquelsFruitBox() {
        List<Apple> apples1 = new ArrayList<>(
                Arrays.asList(
                        new Apple(),
                        new Apple())
        );
        Box<Apple> appleBox1 = new Box<>(apples1, 1.0f);
        appleBox1.add(new Apple());
        appleBox1.add(new Apple());

        Set<Apple> apples2 = new HashSet<>(
                Arrays.asList(
                        new Apple(),
                        new Apple(),
                        new Apple(),
                        new Apple())
        );
        Box<Apple> appleBox2 = new Box<>(1.0f);
        appleBox2.add(apples2);

        Assert.assertTrue(appleBox1.compare(appleBox2));

        appleBox1.pour(appleBox2);

        Assert.assertFalse(appleBox1.compare(appleBox2));

        Assert.assertEquals(0.0f, appleBox1.getWeight(), 0);
        Assert.assertEquals(8.0f, appleBox2.getWeight(), 0);
    }
}