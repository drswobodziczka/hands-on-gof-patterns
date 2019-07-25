package com.intive.trainings.gof.behavioral.observer.problem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MeddlesomeTweetsConsumer {

    private NotObservableTweetsPublisher publisher;

    public void consume() {
        if (publisher.getLastTweet().isPresent()) {
            System.out.println(publisher.getLastTweet().get());
        } else {
            System.out.println("I do not know when to read??");
        }
    }
}
