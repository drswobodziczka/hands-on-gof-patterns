package com.intive.trainings.gof.structural.composite.universe

import spock.lang.Specification

import static com.google.common.collect.Lists.*

class UniverseSpec extends Specification {

    def "bigger round peg does not fit to smaller round hole"() {
        given: "few planets, stars and composite universe components"
        UniverseComponent planet = new Planet("Mars");
        UniverseComponent secondPlanet = new Planet("Pluto"); // yeah, we know
        UniverseComponent egzoPlanet = new Planet("XOI1230");
        UniverseComponent ourStar = new Star("Sun")
        UniverseComponent redGigant = new Star("Betelgeza")

        when: "creating universe composite object"
        UniverseComponent milky = new CompositeUniverseComponent(newArrayList(planet, secondPlanet, ourStar))
        UniverseComponent galactic = new CompositeUniverseComponent(newArrayList(egzoPlanet, redGigant))
        UniverseComponent universe = new CompositeUniverseComponent(newArrayList(milky, galactic))

        then: "weight of composite are equal to sum of weights of it's components"
        milky.weight == planet.weight + secondPlanet.weight + ourStar.weight
        universe.photons == milky.photons + galactic.photons
    }

}
