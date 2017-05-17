package ru.tkachenko.dmitry.geekbrains.java3.task1.box;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 5/7/17
 */
public abstract class Fruit {

    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    float getWeight() {
        return weight;
    }
}
