package ru.tkachenko.dmitry.geekbrains.java2.task1.competitors;

/**
 * Created by dmitry tkachenko on 2/21/17.
 *
 * @author Dmitry Tkachenko
 * @version 1.0
 */
public class Team {

    String teamName;
    Competitor[] competitors;

    public Team(String teamName, Competitor[] competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResults() {
        System.out.printf("%s info:\n", teamName);
        for (Competitor competitor : competitors) {
            competitor.result();
        }
    }

    public void positiveInfo() {
        System.out.printf("%s positive info:\n", teamName);
        for (Competitor competitor : competitors) {
            if (competitor.isOnDistance()) competitor.result();
        }
    }
}
