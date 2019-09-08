package com.intive.trainings.gof.structural.adapter;

class SquarePegAdapter extends RoundPeg {
    private SquarePeg adaptee;

    SquarePegAdapter(SquarePeg adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public double getRadius() {
        return adaptee.getWidth() * Math.sqrt(2.0) / 2;
    }
}
