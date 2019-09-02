package com.intive.trainings.gof.creational.builder.solution;

import com.intive.trainings.gof.creational.builder.GarageBuilderImpl;
import com.intive.trainings.gof.creational.builder.Garden.GardenFactory;
import com.intive.trainings.gof.creational.builder.GardenImpl;

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
                // !! TODO: desing pitfall, what if houseBuilder is HousePriceBuilder ??
                .garage(new GarageBuilderImpl().buildGarage().getResult());
    }

    public void makeStandardHouseWithSwimpoolAndGarage() {
        houseBuilder
                .doors(1)
                .floors(1)
                .rooms(3)
                .windows(4)
                .garden(gardenFactory.create())
                // !! TODO: desing pitfall, what if houseBuilder is HousePriceBuilder ??
                .garage(new GarageBuilderImpl().buildGarage().getResult());
    }

    public void makeAllInclusiveHouse() {
        houseBuilder
                .doors(1)
                .floors(1)
                .rooms(3)
                .windows(4)
                .garden(gardenFactory.create())
                // !! TODO: desing pitfall, what if houseBuilder is HousePriceBuilder ??
                .garage(new GarageBuilderImpl().buildGarage().getResult());
    }
}
