package com.intive.trainings.gof.creational.builder;

public class GarageBuilderImpl implements GarageBuilder {

    private GarageImpl garage;

    @Override
    public GarageBuilderImpl buildGarage() {
        garage = new GarageImpl();
        return this;
    }

    public GarageImpl getGarage() {
        return garage;
    }
}
