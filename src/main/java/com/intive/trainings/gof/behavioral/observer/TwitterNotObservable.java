package com.intive.trainings.gof.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class TwitterNotObservable {

    private List<Tweet> tweets;

    public TwitterNotObservable() {
        tweets = new ArrayList<>();
    }

    public void publishTweet() {
        Tweet message = Tweet.builder().message("FirstMessage").build();
        tweets.add(message);
    }

    public List<Tweet> getTweets() {
        return newArrayList(tweets);
    }
}
