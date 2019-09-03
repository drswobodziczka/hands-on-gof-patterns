package com.intive.trainings.gof.creational.builder.solution

import spock.lang.Specification

class HouseBuildingDirectorTest extends Specification {

    def "makes standard house"() {
        given: "real house builder and director"
        def realHouseBuilder = new House.RealHouseBuilder()
        HouseBuildingDirector director = new HouseBuildingDirector(realHouseBuilder)

        when: "when director orchestrates house creation and house is fetched from builder"
        director.makeStandardHouse()
        House house = realHouseBuilder.getHouse()

        then: "real house is build as expected"
        house.floors == 1
        house.doors == 1
        house.rooms == 3
        house.windows == 4
        house.garden != null
    }

    def "makes standard house price"() {
        given: "house price builder and director"
        def housePriceBuilder = new HousePrice.HousePriceBuilder()
        HouseBuildingDirector director = new HouseBuildingDirector(housePriceBuilder)

        when: "when director orchestrates house creation and house is fetched from builder"
        director.makeStandardHouse()
        HousePrice housePrice = housePriceBuilder.getPrice()

        then: "real house is build as expected"
        housePrice.floorsPrice == 10_000
        housePrice.doorsPrice == 100
        housePrice.roomsPrice == 3_000
        housePrice.windowsPrice == 40
        housePrice.gardenPrice != null
    }

    def "makes standard house with swimpool and garage" () {
        given: "real house builder and director"
        def realHouseBuilder = new House.RealHouseBuilder()
        HouseBuildingDirector director = new HouseBuildingDirector(realHouseBuilder)

        when: "when director orchestrates house creation and house is fetched from builder"
        director.makeStandardHouseWithSwimpoolAndGarage()
        House house = realHouseBuilder.getHouse()

        then: "real house is build as expected with swimpool and garage"
        house.floors == 1
        house.doors == 1
        house.rooms == 3
        house.windows == 4
        house.garden != null
        house.swimPool != null
        house.garage != null
    }

    def "makes standard house with swimpool and garage price"() {
        given: "house price builder and director"
        def housePriceBuilder = new HousePrice.HousePriceBuilder()
        HouseBuildingDirector director = new HouseBuildingDirector(housePriceBuilder)

        when: "when director orchestrates house creation and house is fetched from builder"
        director.makeStandardHouseWithSwimpoolAndGarage()
        HousePrice housePrice = housePriceBuilder.getPrice()

        then: "real house is build as expected"
        housePrice.floorsPrice == 10_000
        housePrice.doorsPrice == 100
        housePrice.roomsPrice == 3_000
        housePrice.windowsPrice == 40
        housePrice.gardenPrice != null
        housePrice.swimPoolPrice != null
        housePrice.garagePrice != null
    }

    def "makes allinlcusive house" () {
        given: "real house builder and director"
        def realHouseBuilder = new House.RealHouseBuilder()
        HouseBuildingDirector director = new HouseBuildingDirector(realHouseBuilder)

        when: "when director orchestrates house creation and house is fetched from builder"
        director.makeAllInclusiveHouse()
        House house = realHouseBuilder.getHouse()

        then: "all inclusive real house is build as expected"
        house.floors == 1
        house.doors == 1
        house.rooms == 3
        house.windows == 4
        house.garden != null
        house.swimPool != null
        house.garage != null
        house.fancyStatues.size() > 0
        house.fence != null
    }

    def "makes allinlcusive house price" () {
        given: "house price builder and director"
        def housePriceBuilder = new HousePrice.HousePriceBuilder()
        HouseBuildingDirector director = new HouseBuildingDirector(housePriceBuilder)

        when: "when director orchestrates house creation and house is fetched from builder"
        director.makeAllInclusiveHouse()
        HousePrice housePrice = housePriceBuilder.getPrice()

        then: "all inclusive house price is build as expected"
        housePrice.floorsPrice == 10_000
        housePrice.doorsPrice == 100
        housePrice.roomsPrice == 3_000
        housePrice.windowsPrice == 40
        housePrice.gardenPrice != null
        housePrice.swimPoolPrice != null
        housePrice.garagePrice != null
        housePrice.fancyStatuesPrice != null
        housePrice.fencePrice != null
    }

}
