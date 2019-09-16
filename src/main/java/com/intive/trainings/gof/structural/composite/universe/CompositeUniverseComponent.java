package com.intive.trainings.gof.structural.composite.universe;

import java.util.List;

public class CompositeUniverseComponent implements UniverseComponent {

    private final List<UniverseComponent> children;

    public CompositeUniverseComponent(List<UniverseComponent> children) {
        this.children = children;
    }

    @Override
    public long getWeight() {
        return children
                .stream()
                .reduce(0L, (a, b) -> a + b.getWeight(), Long::sum);
    }

    @Override
    public long getGravity() {
        return children
                .stream()
                .reduce(0L, (a, b) -> a + b.getGravity(), Long::sum);
    }

    @Override
    public long getPhotons() {
        long photons = 0;
        for(UniverseComponent component: children) {
            photons += component.getPhotons();
        }
        return photons;
    }
}
