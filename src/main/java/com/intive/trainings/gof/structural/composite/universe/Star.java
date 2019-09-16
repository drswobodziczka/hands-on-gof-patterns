package com.intive.trainings.gof.structural.composite.universe;

/*
* Leaf.
* */
public class Star implements UniverseComponent {

    private final String name;

    public Star(String name) {
        this.name = name;
    }

    @Override
    public long getWeight() {
        return 1_000_000_000;
    }

    @Override
    public long getGravity() {
        return 2_000_000_000;
    }

    @Override
    public long getPhotons() {
        return Long.MAX_VALUE;
    }
}
