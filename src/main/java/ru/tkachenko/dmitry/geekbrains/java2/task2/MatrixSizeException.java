package ru.tkachenko.dmitry.geekbrains.java2.task2;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/24/17
 */
class MatrixSizeException extends MatrixException {

    MatrixSizeException() {
        super("Размер матрыцы должен быть 4х4");
    }
}
