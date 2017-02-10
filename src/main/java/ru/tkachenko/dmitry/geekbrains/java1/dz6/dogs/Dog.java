package ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs;

import ru.tkachenko.dmitry.geekbrains.java1.dz6.Animal;

/**
 * Created by dmitry tkachenko on 2/10/17.
 */
public abstract class Dog extends Animal {

    @Override
    public boolean jump(double jump) {
        return (jump > 0 && jump <= 0.5);
    }
}
