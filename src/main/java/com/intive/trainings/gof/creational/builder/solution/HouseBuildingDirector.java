package com.intive.trainings.gof.creational.builder.solution;

import com.intive.trainings.gof.creational.builder.FancyStatueImpl;
import com.intive.trainings.gof.creational.builder.FenceImpl;
import com.intive.trainings.gof.creational.builder.Garden.GardenFactory;
import com.intive.trainings.gof.creational.builder.GardenImpl;
import com.intive.trainings.gof.creational.builder.SwimPoolImpl;

import static com.google.common.collect.Lists.newArrayList;

public class HouseBuildingDirector {

    private final HouseBuilder houseBuilder;
    private final GardenFactory gardenFactory;

    public HouseBuildingDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
        this.gardenFactory = new GardenImpl.GardenImplFactory();
    }

    public void makeStandardHouse() {
        houseBuilder
                .doors(1)
                .floors(1)
                .rooms(3)
                .windows(4)
                // factory method example: you can complement builder with factory
                .garden(gardenFactory.create())
                .garage();
    }

    public void makeStandardHouseWithSwimpoolAndGarage() {
        makeStandardHouse();
        houseBuilder
                .swimPool(new SwimPoolImpl())
                .garage();
    }

    public void makeAllInclusiveHouse() {
        makeStandardHouseWithSwimpoolAndGarage();
        houseBuilder
                .fancyStatues(newArrayList(new FancyStatueImpl()))
                .fence(new FenceImpl());
    }
}
