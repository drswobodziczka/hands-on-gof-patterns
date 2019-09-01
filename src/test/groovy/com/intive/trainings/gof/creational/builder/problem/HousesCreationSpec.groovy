package com.intive.trainings.gof.creational.builder.problem

import com.intive.trainings.gof.creational.builder.solution.HouseWithInternalBuilder
import spock.lang.Specification

class HousesCreationSpec extends Specification {

    def "create new hause with monstrous constructor"() {
        def house = new HouseWithMonstrousConstructor(
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

    def "create new hause with telescoping constructor"() {
        def house = new HouseWithTelescopingConstructor(
                1,
                21,
                55,
                11,
                "Witkacego 13, 54-009 Pietno");
    }

    def "create new hause with builder"() {
        def houseWith = new HouseWithInternalBuilder.Builder()
        def house = houseWith
                .windows(1)
                .doors(21)
                .rooms(55)
                .floors(11)
                .address("Witkacego 13, 54-009 Pietno")
                .build()
    }
}
