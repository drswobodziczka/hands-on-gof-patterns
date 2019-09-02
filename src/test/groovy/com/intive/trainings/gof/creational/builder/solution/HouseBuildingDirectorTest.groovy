package com.intive.trainings.gof.creational.builder.solution

import spock.lang.Specification

class HouseBuildingDirectorTest extends Specification {

    def "MakeStandardHouse"() {
        given: ""
        def mainBuilder = new House.Builder()
        HouseBuildingDirector mainDirector = new HouseBuildingDirector(mainBuilder)
        def priceBuilder = new HousePrice.HousePriceBuilder()
        HouseBuildingDirector priceDirector = new HouseBuildingDirector(priceBuilder)

        when:
        mainDirector.makeStandardHouse()
        House house = mainBuilder.getHouse()

        priceDirector.makeStandardHouse()
        HousePrice housePrice = priceBuilder.getPrice()

        then:
        house.floors == 1
        housePrice.roomsPrice == 3_000
    }

    def "MakeStandardHouseWithSwimpoolAndGarage"() {
//        given:
//        when:
//        then:
    }

    def "MakeAllInclusiveHouse"() {
//        given:
//        when:
//        then:
    }
}
