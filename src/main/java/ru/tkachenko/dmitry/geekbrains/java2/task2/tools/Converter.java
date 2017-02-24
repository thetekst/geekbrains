package ru.tkachenko.dmitry.geekbrains.java2.task2.tools;

import ru.tkachenko.dmitry.geekbrains.java2.task2.exception.MyArrayDataException;
import ru.tkachenko.dmitry.geekbrains.java2.task2.exception.MyArraySizeException;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/24/17
 */
public class Converter {

    public static int strConverter(String[][] strArray)
            throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (4 != strArray.length) throw new MyArraySizeException();

        for (int i = 0; i < strArray.length; i++) {

            if (4 != strArray[i].length) throw new MyArraySizeException();

            for (int k = 0; k < strArray[i].length; k++) {

                try {
                    sum += Integer.parseInt(strArray[i][k]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, k);
                }
            }
        }

        return sum;
    }
}
