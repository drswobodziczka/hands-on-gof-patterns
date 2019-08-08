package com.intive.trainings.gof.behavioral.memento.problem;

import lombok.Builder;

import java.util.List;

@Builder
public class Document {
    public String text;
    public String currentFont;
    public int cursorPosition;
    public List<String> styles;
}
