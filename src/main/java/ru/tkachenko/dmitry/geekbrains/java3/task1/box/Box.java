package ru.tkachenko.dmitry.geekbrains.java3.task1.box;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 5/7/17
 */
public class Box<T extends Fruit> {

    private Collection<T> fruits;
    private final float weight;

    public Box(float weight) {
        this.weight = weight;
        this.fruits = new ArrayList<>();
    }

    public Box(Collection<T> fruits, float weight) {
        this.fruits = fruits;
        this.weight = weight;
    }

    public float getWeight() {
        return fruits.size() * weight;
    }

    public void pour(Box<T> another) {
        another.add(fruits);
        fruits.clear();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void add(Collection<T> fruit) {
        fruits.addAll(fruit);
    }

    public boolean compare(Box o) {
        return this.getWeight() == o.getWeight();
    }
}
