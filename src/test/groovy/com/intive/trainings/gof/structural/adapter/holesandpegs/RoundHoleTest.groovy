package com.intive.trainings.gof.structural.adapter.holesandpegs


import spock.lang.Specification

/*
* Client checking if particular pegs are matching holes
* */
class RoundHoleTest extends Specification {
    def "smaller round peg fits to bigger round hole"() {
        given:
        def hole = new RoundHole(100.00)
        def peg = new RoundPeg(80.00)
        when:
        def fits = hole.fits(peg)
        then:
        fits
    }

    def "bigger round peg does not fit to smaller round hole"() {
        given:
        def hole = new RoundHole(100.00)
        def peg = new RoundPeg(180.00)
        when:
        def doesNotFit = !hole.fits(peg)
        then:
        doesNotFit
    }

    def "smaller square peg fits to bigger round hole"() {
        given:
        def hole = new RoundHole(2.5)
        def peg = new SquarePeg(3.0)
        def adapter = new SquarePegAdapter(peg)
        when:
        def fits = hole.fits(adapter)
        then:
        fits
    }

    def "bigger square peg does not fit to smaller round hole"() {
        given:
        def hole = new RoundHole(1.0)
        def peg = new SquarePeg(2.0)
        def adapter = new SquarePegAdapter(peg)
        when:
        def doesNotFit = !hole.fits(adapter)
        then:
        doesNotFit
    }
}
