package ru.tkachenko.dmitry.geekbrains.java2.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/28/17
 */
class Phonebook {

    private Map<String, ArrayList<String>> map;

    Phonebook() {
        this.map = new HashMap<>();
    }

    void add(String lastName, String phone) {
        ArrayList<String> numbers;

        if (map.containsKey(lastName)) {
            numbers = map.get(lastName);
        } else {
            numbers = new ArrayList<>();
        }
        numbers.add(phone);
        map.put(lastName, numbers);

    }

    ArrayList<String> get(String lastName) {
        return map.get(lastName);
    }
}
