package ru.tkachenko.dmitry.geekbrains.java1.dz1;

/**
 * Created by dmitry tkachenko on 1/23/17.
 */
public class Dz1 {
    public static void main(String[] args) {

//        step 2
        task2();

//        step 3
        double result = calc(1, 3, 5, 2);
        System.out.printf("step 3: %f\n",result);

//        step 4
        System.out.printf("step 4: %s\n", range(1,8));

//        step 5
        evenOrOdd(-2);

//        step 6
        System.out.printf("step 6: %s\n",isNegative(-1));

//        step 7
        printName("dima");

//        step 8
        isLeapYear(2000);
    }

    /**
     * step 2
     * Создать переменные всех пройденных типов данных, и инициализировать их значения;
     */
    public static void task2() {
        byte b = 127;
        short st = 12419;
        char ch = 'A';
        int integer = 24;
        long lg = 124124L;
        float fl = 12.345949f;
        double dl = 4323.45345;
        boolean bool = true;
    }

    /**
     * step 3
     * Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – входные параметры этого метода;
     */
    public static double calc(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    /**
     * step 4
     * Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в
     * пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     */
    public static boolean range(int one, int two) {
        int sum = one + two;
        if (sum > 9 && sum < 21) return true;
        return false;
    }

    /**
     * step 5
     * Написать метод, которому в качестве параметра передается целое число, метод должен
     * напечатать в консоль положительное ли число передали, или отрицательное; Замечание:
     * ноль считаем положительным числом
     */
    public static void evenOrOdd(int num) {
        String word;
        if ((num % 2) == 0) word = "even";
        else word = "odd";
        System.out.printf("step 5: %s\n", word);
    }

    /**
     * step 6
     * Написать метод, которому в качестве параметра передается целое число, метод должен
     * вернуть true, если число отрицательное;
     */
    public static boolean isNegative(int num) {
        if (num < 0) return true;
        return false;
    }

    /**
     * step 7
     * Написать метод, которому в качестве параметра передается строка, обозначающая имя,
     * метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     */
    public static void printName(String name) {
        System.out.printf("step 7: Привет, %s!\n", name);
    }

    /**
     * step 8 *
     * Написать метод, который определяет является ли год високосным, и выводит сообщение в
     * консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й –
     * високосный.
     */
    public static void isLeapYear(int year) {
        System.out.printf("step 8: \n");
    }
}
