package com.intive.trainings.gof.behavioral.observer;

import java.util.List;

public class Twitter {

    private NotObservableTweetsPublisher notObservableTweetsPublisher;
    private List<TweetsConsumer> consumers;

    public Twitter(NotObservableTweetsPublisher notObservableTweetsPublisher, List<TweetsConsumer> consumers) {
        this.notObservableTweetsPublisher = notObservableTweetsPublisher;
        this.consumers = consumers;
    }

    public void tweet(Tweet tweet) {
        notObservableTweetsPublisher.publishTweet(tweet);
        consumers.forEach(cons -> notObservableTweetsPublisher.getLastTweet()
                .ifPresent(cons::consume));
    }
}
