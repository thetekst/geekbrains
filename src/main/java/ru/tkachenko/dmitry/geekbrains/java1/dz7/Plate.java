package ru.tkachenko.dmitry.geekbrains.java1.dz7;

/**
 * Created by dmitry tkachenko on 2/14/17.
 */
class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    boolean decreaseFood(int n) {
        int diff = food - n;
        if (diff < 0) return false;

        food -= n;
        return true;
    }

    void addFood(int food) {
        this.food += food;
    }

    void info() {
        System.out.println("plate: " + food);
    }
}
