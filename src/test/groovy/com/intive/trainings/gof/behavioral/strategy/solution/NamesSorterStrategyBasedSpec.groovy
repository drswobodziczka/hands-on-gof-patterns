package com.intive.trainings.gof.behavioral.strategy.solution

import spock.lang.Specification

class NamesSorterStrategyBasedSpec extends Specification {

    def "given list is sorted in natural order"() {
        setup:
        def list = ["cc", "bb", "dd"]

        when:
        new NamesSorterStrategyBased().sort(list, new NaturalSortingStrategy());

        then:
        list == ["bb", "cc", "dd"]
    }

    def "given list is sorted by words' length"() {
        setup:
        def list = ["333", "xx", "15555"]

        when:
        new NamesSorterStrategyBased().sort(list, new LengthBasedSortingStrategy());

        then:
        list == ["xx", "333", "15555"]
    }

    def "given list is sorted by number of 'a' letter inside"() {
        setup:
        def list = ["3a3aaa3", "2a2a", "a55555"]

        when:
        new NamesSorterStrategyBased().sort(list, new ALetterCountBasedSortingStrategy());

        then:
        list == ["a55555", "2a2a", "3a3aaa3"]
    }
}
