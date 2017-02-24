package ru.tkachenko.dmitry.geekbrains.java2.task2.exception;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/24/17
 */
public class MyArraySizeException extends CustomException {

    public MyArraySizeException() {
        super("The matrix must be of size 4x4");
    }
}
