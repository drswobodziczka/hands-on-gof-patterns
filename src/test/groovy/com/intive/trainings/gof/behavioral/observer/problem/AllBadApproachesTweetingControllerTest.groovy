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

    /*
    * Problems?
    *
    * (-) tweets are not consumed!
    * */
    def "published tweet is NOT read by consumers when they are not connected"() {
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
    }

    /*/
    * Problems?
    *
    * (-) additional artificial class needed
    * (-) publishing and consuming MUST be done synchronously and at the same time
    * */
    def "published tweet is read by all consumers thanks to mediator class"() {
        given: "a tweet and consumers and the OBER TweetingController"
        def consumers = newArrayList Mock(TweetsConsumer), Mock(TweetsConsumer)
        def message = "aha!"
        def tweet = Tweet.builder().message(message).build()
        def twitter = new TweetingController(publisher, consumers)

        when: "tweet is published by twitter"
        twitter.tweet(tweet)

        then: "tweet is consumed by each consumer"
        consumers.each {
            expect:
            1 * it.consume(tweet)
        }
    }

    /*
    * Problems?
    *
    * (-) consumers are coupled with publisher directly
    * (-) consumers are not aware -- when they should search for new tweet, so they have to guess, block in a loop, handle everything
    * (-) consuming is burned inside consumers logics so it's not testable!
    * (-) or we have to spy!
    * */
    def "published tweet is read by meddlesome consumers directly"() {
        given: "a tweet"
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
    }
}
