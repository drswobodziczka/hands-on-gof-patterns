package com.intive.trainings.gof.creational.builder.solution

import com.intive.trainings.gof.creational.builder.FenceImpl
import spock.lang.Specification

import static java.util.Collections.emptyList

class HouseWithLombokTest extends Specification {
    def "create house with lombok builder"() {
        HouseWithLombok
                .builder()
                .address("address")
                .windows(4)
                .doors(1)
                .floors(1)
                .rooms(3)
                .fancyStatues(emptyList())
                .fence(new FenceImpl())
                .build()
    }
}
