package ru.tkachenko.dmitry.geekbrains.java1.dz1;

import org.junit.Test;

import static org.junit.Assert.*;
import static ru.tkachenko.dmitry.geekbrains.java1.dz1.Dz1.*;

/**
 * Created by dmitry tkachenko on 1/24/17.
 */
public class Dz1Test {

    /**
     * step 2
     * Создать переменные всех пройденных типов данных, и инициализировать их значения;
     */
    @Test
    public void task2Test() {
        task2();
    }

    /**
     * step 3
     * Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – входные параметры этого метода;
     */
    @Test
    public void calcTest() {
        double delta = 0;
        double result1 = calc(1, 3, 5, 2);
        double result2 = calc(45.3, 10.0, 5.12, 9);

        assertEquals(5.5, result1, delta);
        assertEquals(478.7706666666666, result2, delta);
    }

    /**
     * step 4
     * Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в
     * пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     */
    @Test
    public void rangeTest() {
        boolean resultFalse = range(1, 8);
        boolean resultTrue = range(6, 8);
        assertEquals(false, resultFalse);
        assertEquals(true, resultTrue);
    }

    /**
     * step 5
     * Написать метод, которому в качестве параметра передается целое число, метод должен
     * напечатать в консоль положительное ли число передали, или отрицательное;
     * Замечание: ноль считаем положительным числом
     */
    @Test
    public void printPositiveOrNegativeTest() {
        printPositiveOrNegative(3);
        printPositiveOrNegative(0);
        printPositiveOrNegative(-2);
    }

    /**
     * step 6
     * Написать метод, которому в качестве параметра передается целое число, метод должен
     * вернуть true, если число отрицательное;
     */
    @Test
    public void isNegativeTest() {
        boolean positive = isNegative(0);
        boolean negative = isNegative(-1);

        assertEquals(false, positive);
        assertEquals(true, negative);
    }

    /**
     * step 7
     * Написать метод, которому в качестве параметра передается строка, обозначающая имя,
     * метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    @Test
    public void printNameTest() {
        printName("dima");
    }

    /**
     * step 8 *
     * Написать метод, который определяет является ли год високосным, и выводит сообщение в
     * консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
     * високосный.
     */
    @Test
    public void printYearTest() {
        printYear(2020);
        printYear(2000);
        printYear(2016);
        printYear(2005);
    }
}