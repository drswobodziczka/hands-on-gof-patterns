package com.intive.trainings.gof.structural.adapter;

/*
* Service a.k.a. Adaptee class
* */
class SquarePeg {
    private double width;

    SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }
}
