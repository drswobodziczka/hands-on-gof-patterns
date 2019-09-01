package com.intive.trainings.gof.creational.builder.problem;

import com.intive.trainings.gof.creational.builder.*;

import java.util.stream.Stream;

public class HouseWithManySubclasses {
    protected final int windows;
    protected final int doors;
    protected final int rooms;
    protected final int floors;
    protected final String address;

    public HouseWithManySubclasses(int windows,
                                   int doors,
                                   int rooms,
                                   int floors,
                                   String address) {
        this.windows = windows;
        this.doors = doors;
        this.rooms = rooms;
        this.floors = floors;
        this.address = address;
    }

    private static class HouseWithSwimpool extends HouseWithManySubclasses {
        private final SwimPool swimPool;
        public HouseWithSwimpool(int windows, int doors, int rooms, int floors, String address, SwimPool swimPool) {
            super(windows, doors, rooms, floors, address);
            this.swimPool = swimPool;
        }
    }

    private static class HouseWithGarden extends HouseWithManySubclasses{
        private final Garden garden;
        public HouseWithGarden(int windows, int doors, int rooms, int floors, String address, Garden garden) {
            super(windows, doors, rooms, floors, address);
            this.garden = garden;
        }
    }

    private static class HouseWithSwimpoolAndGarden extends HouseWithManySubclasses {
        private final SwimPool swimPool;
        private final Garden garden;

        public HouseWithSwimpoolAndGarden(int windows, int doors, int rooms, int floors, String address, SwimPool swimPool, Garden garden) {
            super(windows, doors, rooms, floors, address);
            this.swimPool = swimPool;
            this.garden = garden;
        }
    }

    public static void main(String[] args) {
        /*
         * Problems:
         *
         * (1) hilarious number of new classes -- and inheritance subtrees
         * (2) classes are almost the same except few parameters
         * (3) it's hard to change house with garden into house with swimpool
         * (4) house with everything results into Monstrous Constructor
         * (5) how to count houses with swimpools having list of HouseWithManySubclasses?
         */
        String address = "TRANSILVANIA";
        HouseWithManySubclasses transilvania = new HouseWithManySubclasses(1, 2, 3, 4, address);
        HouseWithSwimpool houseWithSwimpool = new HouseWithSwimpool(1, 2, 3, 4, address, new SwimPoolImpl());
        HouseWithGarden houseWithGarden = new HouseWithGarden(1, 2, 3, 4, address, new GardenImpl());
        HouseWithSwimpoolAndGarden houseWithSwimpoolAndGarden = new HouseWithSwimpoolAndGarden(1, 2, 3, 4, address, new SwimPoolImpl(), new GardenImpl());

        Stream.of(transilvania, houseWithSwimpool, houseWithGarden, houseWithSwimpoolAndGarden)
                .reduce(0, (partialResult, house) -> {
                    if (house instanceof HouseWithSwimpool) {
                        HouseWithSwimpool withSwimpool = (HouseWithSwimpool) house;
                        return withSwimpool.swimPool != null ? partialResult + 1 : partialResult;
                    }
                    if (house instanceof HouseWithSwimpoolAndGarden) {
                        HouseWithSwimpoolAndGarden withSwimpoolAndGarden = (HouseWithSwimpoolAndGarden) house;
                        return withSwimpoolAndGarden.swimPool != null ? partialResult + 1 : partialResult;
                    }
                    return partialResult;
                }, Integer::sum);
    }
}
