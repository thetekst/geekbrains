package ru.tkachenko.dmitry.geekbrains.java2.task1.course;

import ru.tkachenko.dmitry.geekbrains.java2.task1.competitors.Competitor;
import ru.tkachenko.dmitry.geekbrains.java2.task1.competitors.Team;

/**
 * Created by dmitry tkachenko on 2/21/17.
 *
 * @author Dmitry Tkachenko
 * @version 1.0
 */
public class Course {

    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
