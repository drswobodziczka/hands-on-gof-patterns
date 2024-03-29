package com.intive.trainings.gof.behavioral.strategy.problem;

import com.google.common.base.CharMatcher;

import java.util.List;

public class NamesSorter {
    void sort(List<String> names, String sortType) {
        if (sortType == null) {
            names.sort(null);
        }
        else if (sortType.equals("byLength")) {
            names.sort((first, second) -> {
                if (first.length() < second.length()) {
                    return -1;
                } else if(first.length() > second.length()) {
                    return 1;
                }
                return 0;
            });
        }
        else if (sortType.equals("byNumberOfA")) {
            names.sort((first, second) -> {
                int aCountInFirst = CharMatcher.is('a').countIn(first);
                int aCountInSecond = CharMatcher.is('a').countIn(second);
                if (aCountInFirst < aCountInSecond) {
                    return -1;
                } else if(aCountInFirst > aCountInSecond) {
                    return 1;
                }
                return 0;
            });
        }
        else if (sortType.equals("byThoseWhichIKnowMost")) {
            // ... dependency to another object here!
        }
        else if (sortType.equals("byNumberOfA_AND_byLength")) {
            // ... mixed approaches and additional next level
        }
        else {
            names.sort(null);
        }
    }
}
