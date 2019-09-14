package com.intive.trainings.gof.structural.adapter.holesandpegs;

/*
* Client class
* */
public class RoundHole {

    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    boolean fits(RoundPeg peg) {
        return this.radius >= peg.getRadius();
    }
}
