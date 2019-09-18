package com.intive.trainings.gof.behavioral.observer.problem

import com.intive.trainings.gof.behavioral.observer.Tweet
import com.intive.trainings.gof.behavioral.observer.TweetsConsumer
import com.intive.trainings.gof.behavioral.observer.problem.MeddlesomeTweetsConsumer
import com.intive.trainings.gof.behavioral.observer.problem.NotObservableTweetsPublisher
import com.intive.trainings.gof.behavioral.observer.problem.TweetingController
import spock.lang.Specification

import static com.google.common.collect.Lists.newArrayList

class AllBadApproachesTweetingControllerTest extends Specification {

    def publisher = new NotObservableTweetsPublisher()

    def "not aware consumers"() {
        given: "a tweet and not aware consumers"
        def consumers = newArrayList Mock(TweetsConsumer), Mock(TweetsConsumer)
        def message = "aha!"
        def tweet = Tweet.builder().message(message).build()

        when: "tweet is published"
        publisher.publishTweet(tweet);

        then: "consumers not consuming because they are NOT AWARE!"
        consumers.each {
            expect:
            0 * it.consume(tweet)
        }

        /*
        * Problems?
        *
        * (-) tweets are not consumed!
        * */
    }

    def "artificial controller glueing producers and consumers"() {
        given: "a tweet and consumers and the artificial controller"
        def consumers = newArrayList Mock(TweetsConsumer), Mock(TweetsConsumer)
        def message = "aha!"
        def tweet = Tweet.builder().message(message).build()
        def twitter = new TweetingController(publisher, consumers)

        when: "tweet is published by artificial controller"
        twitter.tweet(tweet)

        then: "tweet is consumed by each consumer"
        consumers.each {
            expect:
            1 * it.consume(tweet)
        }

        /*
        * Problems?
        *
        * (-) additional class needed
        * (-) publish&consume - synchronous
        * (-) consumer - I have to listen!
        * (-) consumer - I can't stop to listen!
        * */
    }

    def "meddlesome consumers fixed to producer while creation"() {
        given: "a tweet and consumers "
        def message = "aha!"
        def tweet = Tweet.builder().message(message).build()
        def spy = Spy(MeddlesomeTweetsConsumer, constructorArgs: [publisher])
        def spy2 = Spy(MeddlesomeTweetsConsumer, constructorArgs: [publisher])
        def consumers = newArrayList spy, spy2

        when: "tweet is published and consumer arr"
        publisher.publishTweet(tweet)
        consumers.each {
            it.consume()
        }

        then: "it's consumed by each consumer"
        consumers.each {
            expect:
            1 * it.consume()
        }

        /*
        * Problems?
        *
        * (-) consumers are coupled with publisher directly
        * (-) consumers are not aware -- when they should search for new tweet, so they have to guess, block in a loop, handle everything
        * (-) consuming is burned inside consumers logics so it's not testable!
        * (-) or we have to spy!
        * (-) consumers can not stop listening
        * */
    }


    def "publisher coupled to consumers while creation"() {
        given: "publisher and consumers"
        def consumers = newArrayList Mock(TweetsConsumer), Mock(TweetsConsumer)
        def publisher = new FixedTweetsPublisher(consumers)

        when: "some tweet is published and consumer arr"
        publisher.publishTweet()

        then: "the it's consumed by each consumer"
        consumers.each {
            expect:
            1 * it.consume(_ as Tweet);
        }

        /*
        * Problems?
        *
        * (-) publisher must be passed with complete list of consumers
        * (-) no way to start/stop listening to tweets once publisher is DONE
        *
        * */
    }
}
