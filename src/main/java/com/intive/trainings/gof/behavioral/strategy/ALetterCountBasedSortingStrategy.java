package com.intive.trainings.gof.behavioral.strategy;

import com.google.common.base.CharMatcher;

import java.util.List;

class ALetterCountBasedSortingStrategy implements SortingOrderStrategy {
    @Override
    public void sort(List<String> names) {
        names.sort((first, second) -> {
            int aCountInFirst = CharMatcher.is('a').countIn(first);
            int aCountInSecond = CharMatcher.is('a').countIn(second);
            if (aCountInFirst < aCountInSecond) {
                return -1;
            } else if (aCountInFirst > aCountInSecond) {
                return 1;
            }
            return 0;
        });
    }
}
