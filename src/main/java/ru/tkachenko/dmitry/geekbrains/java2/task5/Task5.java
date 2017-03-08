package ru.tkachenko.dmitry.geekbrains.java2.task5;

import java.util.Arrays;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/8/17
 *          <p>
 *          Необходимо написать два метода, которые делают следующее:
 *          <p>
 *          1) Создают одномерный длинный массив, например:
 *          static final int size = 10000000;
 *          static final int h = size / 2;
 *          float[] arr = new float[size];
 *          <p>
 *          2) Заполняют этот массив единицами;
 *          <p>
 *          3) Засекают время выполнения: long a = System.currentTimeMillis();
 *          <p>
 *          4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
 *          arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 *          <p>
 *          5) Проверяется время окончания метода System.currentTimeMillis();
 *          <p>
 *          6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
 *          <p>
 *          Чем отличается первый метод от второго:
 *          Первый просто бежит по массиву и высчитывает значения.
 *          Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом
 *          склеивает эти массивы обратно в один.
 *          <p>
 *          Пример деления одного массива на два:
 *          System.arraycopy(arr, 0, a1, 0, h);
 *          System.arraycopy(arr, h, a2, 0, h);
 *          <p>
 *          Пример обратной склейки:
 *          System.arraycopy(a1, 0, arr, 0, h);
 *          System.arraycopy(a2, 0, arr, q,h);
 *          <p>
 *          Примечание:
 *          System.arraycopy() – копирует данные из одного массива в другой:
 *          System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-
 *          назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
 *          <p>
 *          По замерам времени:
 *          Для первого метода надо считать время только на цикл расчета:
 *          for (int i = 0; i < size; i++) {
 *          arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
 *          }
 *          <p>
 *          Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и
 *          склейки.
 *          <p>
 *          Например System.arraycopy(источник, 3, назначения, 2, 5) — будет скопировано 5
 *          элементов из массива-источника в результирующий массив, начиная с 3-го индекса
 *          источника во 2 индекс результирующего массива.
 */
public class Task5 {

    private static final int size = 10000000;
    private static final int h = size / 2;
    private static float[] arr = new float[size];

    public static void main(String[] args) {

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long singleTime = singleThread(arr);
        long multiTime = multiThread(arr);

        increase(singleTime, multiTime);
    }

    private static long singleThread(float[] arr) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long singleTime = System.currentTimeMillis() - start;

        System.out.printf("single thread time: %d%n", singleTime);
        return singleTime;
    }

    private static long multiThread(float[] arr) {
        float[] a = new float[h];
        float[] b = new float[h];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, a, 0, h);
        System.arraycopy(arr, h, b, 0, h);

        MyThread t1 = new MyThread("a", a);
        MyThread t2 = new MyThread("b", b);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = t1.getArr();
        b = t2.getArr();

        System.arraycopy(a, 0, arr, 0, h);
        System.arraycopy(b, 0, arr, a.length, b.length);

        long multiTime = System.currentTimeMillis() - start;

        System.out.printf("multi thread time: %d%n", multiTime);

        return multiTime;
    }

    /**
     * Расчитать прирост в %
     */
    private static void increase(long singleTime, long multiTime) {
        double diff = ((double) singleTime / (double) multiTime) - 1;
        int increase = (int) (diff * 100);

        System.out.printf("increase: %d%%%n", increase);
    }
}
