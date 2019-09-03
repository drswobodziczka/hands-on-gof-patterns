package com.intive.trainings.gof.creational.builder.solution;

import com.intive.trainings.gof.creational.builder.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * HouseProduct
 * */
@Getter
public class House {
    private int windows;
    private int doors;
    private int rooms;
    private int floors;
    private String address;
    private SwimPool swimPool;
    private Garage garage;
    private Garden garden;
    private List<FancyStatue> fancyStatues;
    private Fence fence;
    private String name;

    public House(RealHouseBuilder realHouseBuilder){
        this.windows = realHouseBuilder.windows;
        this.doors = realHouseBuilder.doors;
        this.rooms = realHouseBuilder.rooms;
        this.floors = realHouseBuilder.floors;
        this.address = realHouseBuilder.address;
        this.swimPool = realHouseBuilder.swimPool;
        this.garage = realHouseBuilder.garage;
        this.garden = realHouseBuilder.garden;
        this.fancyStatues = newArrayList(realHouseBuilder.fancyStatues);
        this.fence = realHouseBuilder.fence;
        this.name = realHouseBuilder.name;
        realHouseBuilder.reset();
    }

    public static class RealHouseBuilder implements HouseBuilder {
        private Integer windows;
        private Integer doors;
        private Integer rooms;
        private Integer floors;
        private String address;
        private SwimPool swimPool;
        private Garage garage;
        private Garden garden;
        private List<FancyStatue> fancyStatues = new ArrayList<>();
        private Fence fence;
        private String name;

        public HouseBuilder windows(int windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public HouseBuilder rooms(int rooms) {
            this.rooms = rooms;
            return this;
        }

        public HouseBuilder floors(int floors) {
            this.floors = floors;
            return this;
        }

        public void address(String address) {
            this.address = address;
        }

        public HouseBuilder swimPool(SwimPool swimPool) {
            this.swimPool = swimPool;
            return this;
        }

        @Override
        public HouseBuilder garage() {
            this.garage = new GarageBuilderImpl().buildGarage().getResult();
            return this;
        }

        public RealHouseBuilder garden(Garden garden) {
            this.garden = garden;
            return this;
        }

        public HouseBuilder fancyStatues(List<FancyStatue> fancyStatues) {
            this.fancyStatues = newArrayList(fancyStatues);
            return this;
        }

        public HouseBuilder fence(Fence fence) {
            this.fence = fence;
            return this;
        }

        public RealHouseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public HouseBuilder reset() {
            this.windows = null;
            this.doors = null;
            this.rooms = null;
            this.floors = null;
            this.address = null;
            this.swimPool = null;
            this.garage = null;
            this.garden = null;
            this.fancyStatues.clear();
            this.fence = null;
            this.name = null;
            return this;
        }

        public House getHouse() {
            return new House(this);
        }
    }
}
