package com.intive.trainings.gof.behavioral.observer.solution;

import com.intive.trainings.gof.behavioral.observer.Tweet;
import com.intive.trainings.gof.behavioral.observer.TweetsConsumer;

interface Subject {
    void registerObserver(TweetsConsumer observer);
    void unregisterObserver(TweetsConsumer observer);
    void notifyObservers();
    void publishTweet(Tweet tweet);
}
