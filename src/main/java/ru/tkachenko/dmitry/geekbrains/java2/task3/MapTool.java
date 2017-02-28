package ru.tkachenko.dmitry.geekbrains.java2.task3;

import java.util.*;

/**
 * @author Dmitry Tkachenko
 * @version 1.0 2/28/17
 */
class MapTool {

    static Map<String, Integer> eachWordCounter(String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        int cnt;

        for (String word : words) {
            if (countMap.containsKey(word)) {
                cnt = countMap.get(word) + 1;
                countMap.put(word, cnt);
            } else {
                countMap.put(word, 1);
            }
        }

        return countMap;
    }

    static Set<String> getUniqWords(String[] words) {
        Set<String> uniq = new HashSet<>();

        Collections.addAll(uniq, words);

        return uniq;
    }
}
