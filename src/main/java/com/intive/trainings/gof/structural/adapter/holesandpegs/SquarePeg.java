package com.intive.trainings.gof.structural.adapter.holesandpegs;

/*
* Service a.k.a. Adaptee class
* */
public class SquarePeg {
    private double width;

    SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
