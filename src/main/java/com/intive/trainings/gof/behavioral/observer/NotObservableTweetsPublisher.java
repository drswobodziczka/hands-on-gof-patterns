package com.intive.trainings.gof.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class NotObservableTweetsPublisher {

    private List<Tweet> tweets;

    public NotObservableTweetsPublisher() {
        tweets = new ArrayList<>();
    }

    public void publishTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public Optional<Tweet> getLastTweet() {
        return ofNullable(tweets.isEmpty() ? null : tweets.get(tweets.size() - 1));
    }
}
