package com.intive.trainings.gof.creational.builder;

public class GarageCostBuilder implements GarageBuilder {

    private GarageCost garageCost;

    @Override
    public GarageCostBuilder buildGarage() {
        garageCost = new GarageCost();
        return this;
    }

    public GarageCost getResult() {
        return garageCost;
    }

    public class GarageCost {
        public int getValue() {
            return 111_111_111;
        }
    }
}
