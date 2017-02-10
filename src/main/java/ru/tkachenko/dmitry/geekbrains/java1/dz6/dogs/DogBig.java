package ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs;

/**
 * Created by dmitry tkachenko on 2/10/17.
 */
public class DogBig extends Dog {

    @Override
    public boolean run(double run) {
        return (run > 0 && run <= 560);
    }

    @Override
    public boolean swim(double swim) {
        return (swim > 0 && swim <= 10);
    }
}
