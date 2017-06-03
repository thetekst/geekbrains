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

    private static final String FILE_PATH = "java3-task4/src/main/resources";

    public static void runTask1() {
        Task4 task4 = new Task4();
        PrintLetter plt1 = new PrintLetter(task4, 'A', 'B');
        PrintLetter plt2 = new PrintLetter(task4, 'B', 'C');
        PrintLetter plt3 = new PrintLetter(task4, 'C', 'A');

        try {
            plt1.getThread().join();
            plt2.getThread().join();
            plt3.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runTask2() {
        Task4 task4 = new Task4();

        FileWriterApp fwa1 = new FileWriterApp(task4, 'a');
        FileWriterApp fwa2 = new FileWriterApp(task4, 'b');
        FileWriterApp fwa3 = new FileWriterApp(task4, 'c');

        try {
            fwa1.getThread().join();
            fwa2.getThread().join();
            fwa3.getThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
