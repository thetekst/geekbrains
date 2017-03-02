package ru.tkachenko.dmitry.geekbrains.java2.task3;

import java.util.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/28/17
 */
class Phonebook {

    private Map<String, HashSet<String>> map;

    Phonebook() {
        this.map = new HashMap<>();
    }

    void add(String lastName, String phone) {
        HashSet<String> numbers;

        if (map.containsKey(lastName)) {
            numbers = map.get(lastName);
        } else {
            numbers = new HashSet<>();
        }
        numbers.add(phone);
        map.put(lastName, numbers);

    }

    Set<String> get(String lastName) {
        return map.get(lastName);
    }
}
