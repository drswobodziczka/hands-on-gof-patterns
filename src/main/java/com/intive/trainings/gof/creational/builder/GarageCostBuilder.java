package com.intive.trainings.gof.creational.builder;

import java.util.Base64;

public class GarageCostBuilder implements GarageBuilder {

    private GarageCost garageCost;

    @Override
    public GarageCostBuilder buildGarage() {
        garageCost = new GarageCost();
        return this;
    }

    public GarageCost getGaragePrice() {
        return garageCost;
    }

    public class GarageCost {
        public int getCost() {
            byte[] bytes = "default_garage_price".getBytes();
            Base64.Encoder encoder = Base64.getEncoder();
            return 111_111_111 + encoder.encodeToString(bytes).length();
        }
    }
}
