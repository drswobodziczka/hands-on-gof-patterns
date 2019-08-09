package com.intive.trainings.gof.behavioral.memento.solution;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
class DocumentOriginator {
    private String text;
    private String currentFont;
    private int cursorPosition;
    private List<String> styles;

    public String getText() {
        return text;
    }

    public String getCurrentFont() {
        return currentFont;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public List<String> getStyles() {
        return styles;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCurrentFont(String currentFont) {
        this.currentFont = currentFont;
    }

    public void setCursorPosition(int cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public void setStyles(List<String> styles) {
        this.styles = styles;
    }

    public Memento save() {
        return null;
        // TODO
    }

    public void restore(Memento memento) {
    }

    @Getter
    class Memento {
        private final String text;
        private final String currentFont;
        private final int cursorPosition;
        private final List<String> styles;

        Memento(String text, String currentFont, int cursorPosition, List<String> styles) {
            this.text = text;
            this.currentFont = currentFont;
            this.cursorPosition = cursorPosition;
            this.styles = styles;
        }
    }

}
