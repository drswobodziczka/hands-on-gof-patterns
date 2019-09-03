package com.intive.trainings.gof.creational.builder.solution;

import com.intive.trainings.gof.creational.builder.*;
import lombok.Getter;

import java.util.List;

/**
 * HousePrice Product
 * */
@Getter
public class HousePrice {
    private Integer windowsPrice;
    private Integer doorsPrice;
    private Integer roomsPrice;
    private Integer floorsPrice;
    private Integer swimPoolPrice;
    private Integer garagePrice;
    private Integer gardenPrice;
    private Integer fancyStatuesPrice;
    private Integer fencePrice;

    public HousePrice(HousePriceBuilder housePriceBuilder){
        this.windowsPrice = housePriceBuilder.windowsPrice;
        this.doorsPrice = housePriceBuilder.doorsPrice;
        this.roomsPrice = housePriceBuilder.roomsPrice;
        this.floorsPrice = housePriceBuilder.floorsPrice;
        this.swimPoolPrice = housePriceBuilder.swimPoolPrice;
        this.garagePrice = housePriceBuilder.garagePrice;
        this.gardenPrice = housePriceBuilder.gardenPrice;
        this.fancyStatuesPrice = housePriceBuilder.fancyStatuesPrice;
        this.fencePrice = housePriceBuilder.fencePrice;
        housePriceBuilder.reset();
    }

    public static class HousePriceBuilder implements HouseBuilder {
        private static final int WINDOW_PRICE = 10;
        private static final int DOOR_PRICE = 100;
        private static final int ROOM_PRICE = 1_000;
        private static final int FLOOR_PRICE = 10_000;
        private static final int REGULAR_SWIM_POOL_PRICE = 1_000_000_000;
        private static final int FIXED_GARDEN_PRICE = 999_999_999;

        private Integer windowsPrice;
        private Integer doorsPrice;
        private Integer roomsPrice;
        private Integer floorsPrice;
        private Integer swimPoolPrice;
        private Integer garagePrice;
        private Integer gardenPrice;
        private Integer fancyStatuesPrice;
        private Integer fencePrice;

        public HouseBuilder windows(int windows) {
            this.windowsPrice = windows * WINDOW_PRICE;
            return this;
        }

        public HouseBuilder doors(int doors) {
            this.doorsPrice = doors * DOOR_PRICE;
            return this;
        }

        public HouseBuilder rooms(int rooms) {
            this.roomsPrice = rooms * ROOM_PRICE;
            return this;
        }

        public HouseBuilder floors(int floors) {
            this.floorsPrice = floors * FLOOR_PRICE;
            return this;
        }


        public HouseBuilder swimPool(SwimPool swimPool) {
            this.swimPoolPrice = swimPool.getCost() + REGULAR_SWIM_POOL_PRICE;
            return this;
        }

        public HouseBuilder garage() {
            GarageCostBuilder garageCostBuilder = new GarageCostBuilder().buildGarage();
            this.garagePrice = garageCostBuilder.getGaragePrice().getCost();
            return this;
        }

        public HousePriceBuilder garden(Garden garden) {
            this.gardenPrice = FIXED_GARDEN_PRICE;
            return this;
        }

        public HouseBuilder fancyStatues(List<FancyStatue> fancyStatues) {
            this.fancyStatuesPrice = new FancyStatuesBiller().bill(fancyStatues);
            return this;
        }

        public HouseBuilder fence(Fence fence) {
            this.fencePrice = 1;
            return this;
        }

        public HouseBuilder reset() {
            this.windowsPrice = null;
            this.doorsPrice = null;
            this.roomsPrice = null;
            this.floorsPrice = null;
            this.garagePrice = null;
            this.gardenPrice = null;
            this.fancyStatuesPrice = null;
            this.fencePrice = null;
            return this;
        }

        public HousePrice getPrice() {
            return new HousePrice(this);
        }
    }
}
