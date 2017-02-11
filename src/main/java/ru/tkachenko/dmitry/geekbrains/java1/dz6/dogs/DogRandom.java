package ru.tkachenko.dmitry.geekbrains.java1.dz6.dogs;

import java.util.Random;

/**
 * Created by dmitry tkachenko on 2/10/17.
 */
public class DogRandom extends Dog {

    private final double MAX_RUN;
    private final double MAX_SWIM;

    public DogRandom() {
        Random random = new Random();
        MAX_RUN = random.nextDouble() * (600.01 - 1.0) + 1.0; // 1 - 400
        MAX_SWIM = random.nextDouble() * (10.01 - 1.0) + 1.0; // 1 - 10
    }

    @Override
    public boolean run(double run) {
        return (run > 0 && run <= MAX_RUN);
    }

    @Override
    public boolean swim(double swim) {
        return (swim > 0 && swim <= MAX_SWIM);
    }
}
