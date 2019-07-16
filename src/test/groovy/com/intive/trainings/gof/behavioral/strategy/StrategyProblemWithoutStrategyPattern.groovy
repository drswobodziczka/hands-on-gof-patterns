package com.intive.trainings.gof.behavioral.strategy


import spock.lang.Specification

class StrategyProblemWithoutStrategyPattern extends Specification {

    def "given list is sorted in natural order"() {
        setup:
        def list = ["cc", "bb", "dd"]

        when:
        new NamesSorter().sort(list, null);

        then:
        list == ["bb", "cc", "dd"]
    }

    def "given list is sorted by words' length"() {
        setup:
        def list = ["333", "22", "55555"]

        when:
        new NamesSorter().sort(list, "byLength");

        then:
        list == ["22", "333", "55555"]
    }

//    @Ignore
    def "given list is sorted by number of 'a' letter inside"() {
        setup:
        def list = ["3a3aaa3", "2a2a", "a55555"]

        when:
        new NamesSorter().sort(list, "byNumberOfA");

        then:
        list == ["a55555", "2a2a", "3a3aaa3"]
    }
}
