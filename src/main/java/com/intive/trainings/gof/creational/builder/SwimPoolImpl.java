package com.intive.trainings.gof.creational.builder;

public class SwimPoolImpl implements SwimPool {

    private static final int WORKERS_DEFAULT_COST = 1_000_000;
    private static final int MATERIAL_DEFAULT_COST = 1_000_000_000;

    @Override
    public Integer getCost() {
        return MATERIAL_DEFAULT_COST + WORKERS_DEFAULT_COST;
    }
}
