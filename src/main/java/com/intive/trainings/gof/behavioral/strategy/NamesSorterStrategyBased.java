package com.intive.trainings.gof.behavioral.strategy;

import com.google.common.base.CharMatcher;

import java.util.List;

public class NamesSorterStrategyBased {
    void sort(List<String> names, SortingOrderStrategy strategy) {
        strategy.sort(names);
    }
}
