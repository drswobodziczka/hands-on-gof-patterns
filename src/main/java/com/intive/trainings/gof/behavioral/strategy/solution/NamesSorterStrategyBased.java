package com.intive.trainings.gof.behavioral.strategy.solution;

import java.util.List;

public class NamesSorterStrategyBased {
    void sort(List<String> names, SortingOrderStrategy strategy) {
        strategy.sort(names);
    }
}
