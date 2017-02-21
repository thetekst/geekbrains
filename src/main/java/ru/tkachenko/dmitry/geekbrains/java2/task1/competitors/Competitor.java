package ru.tkachenko.dmitry.geekbrains.java2.task1.competitors;

public interface Competitor {
    void run(int dist);

    void swim(int dist);

    void jump(int height);

    void result();

    boolean isOnDistance();
}
