package com.intive.trainings.gof.creational.builder.solution;

import com.intive.trainings.gof.creational.builder.FancyStatue;

import java.util.List;

public class FancyStatuesBiller {
    public Integer bill(List<FancyStatue> fancyStatues) {
        return fancyStatues.stream().reduce(0, (current, statue) -> current++, Integer::sum);
    }
}
