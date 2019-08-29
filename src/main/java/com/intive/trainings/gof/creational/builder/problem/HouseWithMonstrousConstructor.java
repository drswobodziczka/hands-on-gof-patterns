package com.intive.trainings.gof.creational.builder.problem;

import com.intive.trainings.gof.creational.builder.*;

import java.util.List;

public class HouseWithMonstrousConstructor {
    private final int windows;
    private final int doors;
    private final int rooms;
    private final int floors;
    private final String address;
    private SwimPool swimPool;
    private Garage garage;
    private Garden garden;
    private List<FancyStatue> fancyStatues;
    private Fence fence;
    private String name;

    public HouseWithMonstrousConstructor(int windows,
                                         int doors,
                                         int rooms,
                                         int floors,
                                         String address,
                                         SwimPool swimPool,
                                         Garage garage,
                                         Garden garden,
                                         List<FancyStatue> fancyStatues,
                                         Fence fence,
                                         String name) {
        this.windows = windows;
        this.doors = doors;
        this.rooms = rooms;
        this.floors = floors;
        this.address = address;
        this.swimPool = swimPool;
        this.garage = garage;
        this.garden = garden;
        this.fancyStatues = fancyStatues;
        this.fence = fence;
        this.name = name;
    }

    public static void main(String[] args) {
        /*
         * Problems while creating client code:
         *
         * (1) which int is for number of windows?
         * (2) which null is for swimpool?
         * (3) how the hell I should read that?
         */
        new HouseWithMonstrousConstructor(
                1,
                21,
                55,
                11,
                "Witkacego 13, 54-009 Pietno",
                null,
                null,
                null,
                null,
                null,
                null);
    }

    @Override
    public String toString() {
        return "HouseWithMonstrousConstructor{" +
                "windows=" + windows +
                ", doors=" + doors +
                ", rooms=" + rooms +
                ", floors=" + floors +
                ", address=" + address +
                ", swimPool=" + swimPool +
                ", garage=" + garage +
                ", garden=" + garden +
                ", fancyStatues=" + fancyStatues +
                ", fence=" + fence +
                ", name=" + name +
                '}';
    }
}
