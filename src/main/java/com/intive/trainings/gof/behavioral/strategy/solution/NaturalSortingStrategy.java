package com.intive.trainings.gof.behavioral.strategy.solution;

import java.util.List;

public class NaturalSortingStrategy implements SortingOrderStrategy {
    @Override
    public void sort(List<String> names) {
        names.sort(null);
    }
}
