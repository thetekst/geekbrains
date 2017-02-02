package ru.tkachenko.dmitry.geekbrains.java1.dz3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by dmitry tkachenko on 2/1/17.
 */
public class Dz3 {
    public static void main(String[] args) {
//        guessTask1();
//        guessTask2();
    }

    /**
     * task 1
     * <p>
     * Написать программу, которая загадывает случайное число от 0 до 9,
     * и пользователю дается 3 попытки угадать это число.
     * При каждой попытке компьютер должен сообщить больше ли указанное пользователем
     * число чем загаданное, или меньше. После победы или проигрыша выводится
     * запрос – «Повторить игру еще раз? y/n».
     */
    static void guessTask1() {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        char answer;

        guessGame();

        do {
            System.out.println("Повторить игру еще раз? y/n");
            while (!scanner.hasNext("[yn]")) {
                System.out.println("Не символ. Введите y/n:");
                scanner.next();
            }
            answer = scanner.next().charAt(0);

            if ('n' == answer) {
                isExit = true;
            } else if ('y' == answer) {
                guessGame();
            }
        } while (!isExit);
    }

    private static void guessGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int generate = random.nextInt(10);

        boolean isWin = false;
        int currentNum;

        for (int i = 0; i < 3; i++) {
            System.out.printf("Введите число от 0 до 9: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Не число. Введите число от 0 до 9:");
                scanner.next();
            }

            currentNum = scanner.nextInt();

            if (currentNum == generate) {
                isWin = true;
                break;
            } else if (currentNum > generate) {
                System.out.printf("%d > загаданное\n\n", currentNum);
            } else {
                System.out.printf("%d < загаданное\n\n", currentNum);
            }
        }

        if (isWin) System.out.println("Победа");
        else System.out.printf("GAME OVER. Ответ: %d\n", generate);
    }

    /**
     * task 2
     * <p>
     * Создать массив из слов
     * String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
     * Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно, можно пользоваться:
     * String str = "apple";
     * str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово
     * Используем только маленькие буквы
     */
    static void guessTask2() {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"
        };
        int wordLength = words.length;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int puzzle = random.nextInt(wordLength);
        String hiddenWord = words[puzzle];
        int hiddenWordLength = hiddenWord.length();
//        System.out.printf("puzzle: %s\n\n", hiddenWord);
        String input;
        int inputLength;
        int count;
        boolean flag = true;
        String placeholder = "#";
        String know;
        int diff;

        do {
            System.out.println("Введите слово:");
            count = 0;

            while (!scanner.hasNext()) {
                System.out.println("Введите слово:");
                scanner.next();
            }

            input = scanner.nextLine().toLowerCase();
            inputLength = input.length();
            know = "";

            for (int i = 0; i < inputLength && i < hiddenWordLength; i++) {
                if (input.charAt(i) == hiddenWord.charAt(i)) {
                    know += input.charAt(i);
                    count++;
                } else {
                    know += placeholder;
                }
            }

            diff = 15 - know.length();
            for (int i = 0; i < diff; i++) {
                know += placeholder;
            }

            if (inputLength == hiddenWordLength && count == hiddenWordLength) {
                flag = false;
                System.out.println("Вы победили");
            } else if (count > 0) {
                System.out.println(know);
            } else {
                System.out.println("нет совпадений\n");
            }

        } while (flag);
    }
}
