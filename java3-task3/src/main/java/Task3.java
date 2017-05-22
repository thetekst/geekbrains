/**
 * @author Dmitry Tkachenko
 * @version 1.0 5/21/17
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
 * <p>
 * 2. Последовательно сшить 5 файлов в один (файлы также ~100 байт).
 * Может пригодиться следующая конструкция:
 * ArrayList<InputStream> al = new ArrayList<>();
 * ...
 * Enumeration<InputStream> e = Collections.enumeration(al);
 * <p>
 * 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
 * (размером > 10 mb), вводим страницу, программа выводит ее в консоль (за страницу можно
 * принять 1800 символов). Время чтения файла должно находится в разумных пределах
 * (программа не должна загружаться дольше 10 секунд), ну и чтение тоже не должно занимать
 * >5 секунд.
 */
public class Task3 {

    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final String FILE_PATH = "java3-task3/src/main/resources";

    public static void readAndPrintByteArray() {

        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

//        System.out.println(System.getProperty("user.dir"));

        try (FileInputStream fin = new FileInputStream(FILE_PATH + "/50byte.txt")) {
            final byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
            int len;

            while ((len = fin.read(buf)) != -1) {
                bytes.write(buf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] barray = bytes.toByteArray();

        System.out.println(Arrays.toString(barray));
    }

    public static void merge() {
        SequenceInputStream seq;
        ArrayList<InputStream> al = new ArrayList<>();
        FileOutputStream out = null;

        try {
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));
            al.add(new FileInputStream(FILE_PATH + "/50byte.txt"));

            out = new FileOutputStream(FILE_PATH + "/concat.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Enumeration<InputStream> e = Collections.enumeration(al);

        seq = new SequenceInputStream(e);

        try {
            int rb = seq.read();

            while (rb != -1) {
                out.write(rb);
                rb = seq.read();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void cliPageReader() {

    }

    public static void main(String[] args) {

//        readAndPrintByteArray();
//        merge();
        cliPageReader();
    }
}
