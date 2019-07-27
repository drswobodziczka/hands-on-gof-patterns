package com.intive.trainings.gof.behavioral.observer.problem;

import com.intive.trainings.gof.behavioral.observer.Tweet;
import com.intive.trainings.gof.behavioral.observer.TweetsConsumer;

import java.util.List;

public class FixedTweetsPublisher {

    private List<TweetsConsumer> consumers;

    public FixedTweetsPublisher(List<TweetsConsumer> consumers) {
        this.consumers = consumers;
    }

    public void publishTweet() {
        Tweet tweet = Tweet.builder().message("internal tweeting").build();
        consumers.forEach(cons -> cons.consume(tweet));
    }
}
