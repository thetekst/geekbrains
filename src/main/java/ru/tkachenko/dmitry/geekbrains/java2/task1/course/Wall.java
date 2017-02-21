package ru.tkachenko.dmitry.geekbrains.java2.task1.course;


import ru.tkachenko.dmitry.geekbrains.java2.task1.competitors.Competitor;

public class Wall extends Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}
