package com.intive.trainings.gof.creational.builder;

public class GarageBuilderImpl implements GarageBuilder {

    private GarageImpl garage;

    @Override
    public GarageBuilderImpl buildGarage() {
        garage = new GarageImpl();
        return this;
    }

    public GarageImpl getResult() {
        return garage;
    }

    private static class GarageImpl implements Garage {
    }
}
