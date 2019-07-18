package com.intive.trainings.gof.behavioral.strategy;

import java.util.List;

class LengthBasedSortingStrategy implements SortingOrderStrategy {
    @Override
    public void sort(List<String> names) {
        names.sort((first, second) -> {
            if (first.length() < second.length()) {
                return -1;
            } else if (first.length() > second.length()) {
                return 1;
            }
            return 0;
        });
    }
}
