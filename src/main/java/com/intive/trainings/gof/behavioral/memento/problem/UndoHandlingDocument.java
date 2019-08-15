package com.intive.trainings.gof.behavioral.memento.problem;

import lombok.Getter;

import java.util.List;
import java.util.Stack;

@Getter
public class UndoHandlingDocument {
    private String text;
    private String currentFont;
    private int cursorPosition;
    private List<String> styles;
    private Stack<Snapshot> history = new Stack<>();

    private void createSnapshot() {
        history.push(new Snapshot(this));
    }

    public void undo() {
        if (!history.empty()) {
            Snapshot snapshot = history.pop();
            setText(snapshot.text);
            setCurrentFont(snapshot.currentFont);
            setCursorPosition(snapshot.cursorPosition);
            setStyles(snapshot.styles);
        }
    }

    public void setText(String text) {
        createSnapshot();
        this.text = text;
    }

    public void setCurrentFont(String currentFont) {
        createSnapshot();
        this.currentFont = currentFont;
    }

    public void setCursorPosition(int cursorPosition) {
        createSnapshot();
        this.cursorPosition = cursorPosition;
    }

    public void setStyles(List<String> styles) {
        createSnapshot();
        this.styles = styles;
    }

    private class Snapshot {
        private String text;
        private String currentFont;
        private int cursorPosition;
        private List<String> styles;

        private Snapshot(UndoHandlingDocument undoHandlingDocument) {
            text = undoHandlingDocument.text;
            currentFont = undoHandlingDocument.currentFont;
            cursorPosition = undoHandlingDocument.cursorPosition;
            styles = undoHandlingDocument.styles;
        }
    }
}
