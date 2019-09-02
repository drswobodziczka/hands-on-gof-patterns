package com.intive.trainings.gof.creational.builder;

public class GardenImpl implements Garden {

    /**
     * Factory Method example: concrete implementation must be in the same inheritance tree.
     * */
    public static class GardenImplFactory implements Garden.GardenFactory {
        @Override
        public Garden create() {
            return new GardenImpl();
        }
    }
}
