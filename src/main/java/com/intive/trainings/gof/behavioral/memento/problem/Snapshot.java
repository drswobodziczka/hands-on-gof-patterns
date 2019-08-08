package com.intive.trainings.gof.behavioral.memento.problem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
class Snapshot {
    private final String text;
    private final String currentFont;
    private final int cursorPosition;
    private final List<String> styles;
}
