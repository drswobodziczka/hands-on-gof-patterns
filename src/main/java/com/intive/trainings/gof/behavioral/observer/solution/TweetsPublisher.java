package com.intive.trainings.gof.behavioral.observer.solution;

import com.intive.trainings.gof.behavioral.observer.Tweet;
import com.intive.trainings.gof.behavioral.observer.TweetsConsumer;

import java.util.ArrayList;
import java.util.List;

public class TweetsPublisher implements Subject {

    private List<TweetsConsumer> consumers = new ArrayList<>();
    private Tweet lastTweet;

    @Override
    public void publishTweet(Tweet tweet) {
        lastTweet = tweet;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        consumers.forEach(cons -> {
            cons.consume(lastTweet);
        });
    }

    @Override
    public void registerObserver(TweetsConsumer tweetsConsumer) {
        consumers.add(tweetsConsumer);
    }

    @Override
    public void unregisterObserver(TweetsConsumer tweetsConsumer) {
        consumers.remove(tweetsConsumer);
    }
}
