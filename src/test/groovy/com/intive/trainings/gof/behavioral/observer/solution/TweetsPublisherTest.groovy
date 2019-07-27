package com.intive.trainings.gof.behavioral.observer.solution

import com.intive.trainings.gof.behavioral.observer.Tweet
import com.intive.trainings.gof.behavioral.observer.TweetsConsumer
import spock.lang.Specification

class TweetsPublisherTest extends Specification {
    def "published tweed is automatically broadcasted to all registered consumers"() {
        given: "publisher, tweet, registered and unregistered consumer"
        def publisher = new TweetsPublisher()
        def message = "message"
        def tweet = Tweet.builder().message(message).build()
        def registered = Mock(TweetsConsumer)
        def notRegistered = Mock(TweetsConsumer)
        publisher.registerObserver(registered)

        when:
        publisher.publishTweet(tweet)

        then:
        1 * registered.consume(tweet)
        0 * notRegistered.consume(tweet)
    }
}
