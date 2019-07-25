package com.intive.trainings.gof.behavioral.observer.problem;

import com.intive.trainings.gof.behavioral.observer.Tweet;
import com.intive.trainings.gof.behavioral.observer.TweetsConsumer;

import java.util.List;

public class TweetingController {

    private NotObservableTweetsPublisher notObservableTweetsPublisher;
    private List<TweetsConsumer> consumers;

    public TweetingController(NotObservableTweetsPublisher notObservableTweetsPublisher, List<TweetsConsumer> consumers) {
        this.notObservableTweetsPublisher = notObservableTweetsPublisher;
        this.consumers = consumers;
    }

    public void tweet(Tweet tweet) {
        notObservableTweetsPublisher.publishTweet(tweet);
        consumers.forEach(cons -> notObservableTweetsPublisher.getLastTweet()
                .ifPresent(cons::consume));
    }
}
