package ru.tkachenko.dmitry.geekbrains.java2.task2;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/24/17
 */
public class Task2 {
    public static void main(String[] args) {
        String test1 = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
        String test2 = "1 3 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";

        String test3 = "1 3 1 2\n2 3 @ 2\n5 6 7 1\n3 3 1 0";

        try {
            System.out.println(Task2.strConverter(test1));
        } catch (NumberFormatException e) {
            System.err.println("test 1 NumberFormatException");
        } catch (Exception e) {
            System.err.println("test 1 Matrix 4x4 Exception");
        }

        try {
            System.out.println(Task2.strConverter(test2));
        } catch (NumberFormatException e) {
            System.err.println("test 2 NumberFormatException");
        } catch (Exception e) {
            System.err.println("test 2 Matrix 4x4 Exception");
        }

        try {
            System.out.println(Task2.strConverter(test3));
        } catch (NumberFormatException e) {
            System.err.println("test 3 NumberFormatException");
        } catch (Exception e) {
            System.err.println("test 3 Matrix 4x4 Exception");
        }
    }

    private static int strConverter(String str) throws Exception {
        String[] array = str.split("\n");
        int sum = 0;

        if (4 != array.length) {
            throw new Exception();
        }

        for (String anArray : array) {
            String[] line = anArray.split(" ");

            if (4 != line.length) throw new Exception();

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
