package ru.tkachenko.dmitry.geekbrains.java2.task2.exception;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/24/17
 */
public class MyArrayDataException extends CustomException {

    public MyArrayDataException(int row, int col) {
        super(String.format("Parse to int exception in array[%d, %d]", row, col));
    }
}
