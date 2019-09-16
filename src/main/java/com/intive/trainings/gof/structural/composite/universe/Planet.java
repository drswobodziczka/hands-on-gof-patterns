package com.intive.trainings.gof.structural.composite.universe;

/*
* Leaf.
* */
public class Planet implements UniverseComponent {

    private final String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public long getWeight() {
        return 100_000;
    }

    @Override
    public long getGravity() {
        return 200_000;
    }

    @Override
    public long getPhotons() {
        return 2_000_000;
    }

    public String getName() {
        return name;
    }
}
