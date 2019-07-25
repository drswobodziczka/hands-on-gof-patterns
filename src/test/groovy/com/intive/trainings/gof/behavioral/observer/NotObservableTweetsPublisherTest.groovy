package com.intive.trainings.gof.behavioral.observer

import spock.lang.Specification

class NotObservableTweetsPublisherTest extends Specification {

    def testee = new NotObservableTweetsPublisher()

    def "published tweet is available in tweets repository"() {
        given:
        def message = "tweeeee!"
        def tweet = Tweet.builder().message(message).build()

        when:
        testee.publishTweet(tweet);

        then:
        testee.getLastTweet().get().getMessage() == message
    }
}
