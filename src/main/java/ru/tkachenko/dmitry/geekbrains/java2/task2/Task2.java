package ru.tkachenko.dmitry.geekbrains.java2.task2;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/24/17
 */
public class Task2 {
    public static void main(String[] args) {
        String correctMatrix = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        String wrongSizeMatrix = "1 3 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        String wrongChar = "1 3 1 2\n2 3 @ 2\n5 6 7 1\n3 3 1 0";

        try {
            System.out.println(Task2.strConverter(correctMatrix));
        } catch (MatrixSizeException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Task2.strConverter(wrongSizeMatrix));
        } catch (MatrixSizeException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(Task2.strConverter(wrongChar));
        } catch (NumberFormatException e) {
            System.err.println("wrongChar: NumberFormatException");
        } catch (MatrixSizeException e) {
            e.printStackTrace();
        }
    }

    private static int strConverter(String str) throws MatrixSizeException {
        String[] array = str.split("\n");
        int sum = 0;

        if (4 != array.length) throw new MatrixSizeException();

        for (String anArray : array) {
            String[] line = anArray.split(" ");

            if (4 != line.length) throw new MatrixSizeException();

            for (String aLine : line) {

                try {
                    sum += Integer.parseInt(aLine);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();
                }
            }
        }

        return sum / 2;
    }
}
