package com.intive.trainings.gof.creational.builder.problem;

import com.intive.trainings.gof.creational.builder.*;

import java.util.List;

public class HouseWithTelescopingConstructor {

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

    /*
     * Telescoping constructor pattern, problems:
     *
     * 1. extremely huge amount of code
     * 2. all contructors depend on default one
     * 3. each combination with optional fields needs separate constructor
     *
     * == poor reusability
     * == poor readability
     * == solution is error-prone
     * == solution is not always accurate!
     */
    public HouseWithTelescopingConstructor(int windows, int doors, int rooms, int floors, String address) {
        this(windows, doors, rooms, floors, address, null);
    }

    public HouseWithTelescopingConstructor(int windows, int doors, int rooms, int floors, String address, SwimPool swimPool) {
        this(windows, doors, rooms, floors, address, swimPool, null);
    }

    public HouseWithTelescopingConstructor(int windows, int doors, int rooms, int floors, String address, SwimPool swimPool, Garage garage) {
        this(windows, doors, rooms, floors, address, swimPool, garage, null);
    }

    public HouseWithTelescopingConstructor(int windows, int doors, int rooms, int floors, String address, SwimPool swimPool, Garage garage, Garden garden) {
        this(windows, doors, rooms, floors, address, swimPool, garage, garden, null);
    }

    public HouseWithTelescopingConstructor(int windows, int doors, int rooms, int floors, String address, SwimPool swimPool, Garage garage, Garden garden, List<FancyStatue> fancyStatues) {
        this(windows, doors, rooms, floors, address, swimPool, garage, garden, fancyStatues, null);
    }

    public HouseWithTelescopingConstructor(int windows, int doors, int rooms, int floors, String address, SwimPool swimPool, Garage garage, Garden garden, List<FancyStatue> fancyStatues, Fence fence) {
        this(windows, doors, rooms, floors, address, swimPool, garage, garden, fancyStatues, fence, null);
    }

    /*
     * Not all optional field combinations are even possible
     */
//    public HouseWithTelescopingConstructor(int windows, int doors, int rooms, int floors, String name) {
//        this(windows, doors, rooms, floors, null, null, null, null, null, null, name);
//    }

    private HouseWithTelescopingConstructor(int windows,
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
        new HouseWithTelescopingConstructor(
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
