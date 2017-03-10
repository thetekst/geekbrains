package ru.tkachenko.dmitry.geekbrains.java1.dz8.constant;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 3/9/17
 */
public enum Dot {
    EMPTY(""),
    X("X"),
    O("O");

    private String dot;

    Dot(String dot) {
        this.dot = dot;
    }

    public String getDot() {
        return dot;
    }
}
