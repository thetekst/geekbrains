package ru.tkachenko.dmitry.geekbrains.java1.dz6.cats;

import ru.tkachenko.dmitry.geekbrains.java1.dz6.Animal;

/**
 * Created by dmitry tkachenko on 2/10/17.
 */
public class Cat extends Animal {
    @Override
    public boolean run(double run) {
        return (run > 0 && run <= 200);
    }

    @Override
    public boolean jump(double jump) {
        return (jump > 0 && jump <= 2);
    }

    @Override
    public boolean swim(double swim) {
        return false;
    }
}
