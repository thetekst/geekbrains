package ru.tkachenko.dmitry.geekbrains.java3.task1.box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 5/7/17
 */
public class Box<T extends Fruit> {

    private ArrayList<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    @SafeVarargs
    public Box(T... fruits) {
        this.list = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float weight = 0.0f;

        for (T o : list) {
            weight += o.getWeight();
        }

        return weight;
    }

    public void pour(Box<T> another) {
        another.list.addAll(list);
        list.clear();
    }

    public void add(T fruit) {
        list.add(fruit);
    }

    public void add(Collection<T> fruit) {
        list.addAll(fruit);
    }

    public boolean compare(Box<?> o) {

        // избегаем ошибки округления с помощью дельты
        return Math.abs(this.getWeight() - o.getWeight()) < 0.001;
    }
}
