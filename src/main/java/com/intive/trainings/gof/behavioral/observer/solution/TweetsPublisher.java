package com.intive.trainings.gof.behavioral.observer.solution;

import com.intive.trainings.gof.behavioral.observer.Tweet;
import com.intive.trainings.gof.behavioral.observer.TweetsConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class TweetsPublisher {

    private List<TweetsConsumer> consumers = new ArrayList<>();

    public void publishTweet(Tweet tweet) {
        consumers.forEach(cons -> {
            cons.consume(tweet);
        });
    }

    public void register(TweetsConsumer tweetsConsumer) {
        consumers.add(tweetsConsumer);
    }

    public void unregister(TweetsConsumer tweetsConsumer) {
        consumers.remove(tweetsConsumer);
    }
}
