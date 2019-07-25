package com.intive.trainings.gof.behavioral.observer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Tweet {
    private String message;
}
