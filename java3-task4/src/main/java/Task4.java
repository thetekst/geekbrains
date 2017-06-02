import java.io.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 6/2/17
 */


/*
    1. Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз, порядок
    должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.

    2. Написать совсем небольшой метод, в котором 3 потока построчно пишут данные в файл (штук
    по 10 записей, с периодом в 20 мс)

    3. Написать класс МФУ на котором возможны одновременная печать и сканирование
    документов, при этом нельзя одновременно печатать два документа или сканировать (при
    печати в консоль выводится сообщения "отпечатано 1, 2, 3,... страницы", при сканировании то
    же самое только "отсканировано...", вывод в консоль все также с периодом в 50 мс.)
*/
public class Task4 {

    private final Object monitor;
    private volatile char letter = 'A';
    private static final String FILE_PATH = "java3-task4/src/main/resources";

    public Task4() {
        this.monitor = new Object();
    }

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'A') {
                        monitor.wait();
                    }

                    System.out.print('A');
                    letter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'B') {
                        monitor.wait();
                    }

                    System.out.print('B');
                    letter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (letter != 'C') {
                        monitor.wait();
                    }

                    System.out.print('C');
                    letter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void runTask1() {
        Task4 task4 = new Task4();

        new Thread(task4::printA, "one").start();
        new Thread(task4::printB, "two").start();
        new Thread(task4::printC, "three").start();
    }

    public void test(char ch) {
        try {
            for (int i = 0; i < 5; i++) {
                try (FileWriter fw = new FileWriter(FILE_PATH + "/readme.txt", true); BufferedWriter bw =
                        new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {

                    for (int j = 0; j < 10; j++) {
                        out.print(ch);
                    }

                    out.println();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void runTask2() {
        Task4 task4 = new Task4();

        Thread t1 = new Thread(() -> task4.test('z'));
        Thread t2 = new Thread(() -> task4.test('r'));
        Thread t3 = new Thread(() -> task4.test('d'));

        t1.start();
        t2.start();
        t3.start();
    }

    private static void runTask3() {
        // TODO
    }

    public static void main(String[] args) {
//        runTask1();
//        runTask2();
        runTask3();
    }
}
