package com.intive.trainings.gof.creational.builder;

import java.util.Base64;

public class GarageCostBuilder implements GarageBuilder {

    private GarageCost garageCost;
    private Garage garage;

    public GarageCostBuilder(Garage garage) {
        this.garage = garage;
    }

    @Override
    public GarageCostBuilder buildGarage() {
        garageCost = new GarageCost();
        return this;
    }

    public GarageCost getResult() {
        return garageCost;
    }

    public class GarageCost {
        public int getCost() {
            byte[] bytes = garage.toString().getBytes();
            Base64.Encoder encoder = Base64.getEncoder();
            return 111_111_111 + encoder.encodeToString(bytes).length();
        }
    }
}
