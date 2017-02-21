package ru.tkachenko.dmitry.geekbrains.java2.task1.course;

import ru.tkachenko.dmitry.geekbrains.java2.task1.competitors.Competitor;

public class Water extends Obstacle {
    private int dist;

    public Water(int dist) {
        this.dist = dist;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(dist);
    }
}
