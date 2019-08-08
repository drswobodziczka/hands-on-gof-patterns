package com.intive.trainings.gof.behavioral.memento.problem;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import static java.util.Collections.*;

@AllArgsConstructor
public class UndoHandlingEditor {

    private Document document;
    private Stack<Snapshot> snapshots;

    public void changeText(String newText) {
        createSnapshot();
        document.text = newText;
    }

    public void changeCursorPosition(int i) {
        createSnapshot();
        document.cursorPosition = i;
    }

    private void createSnapshot() {
        Snapshot item = new Snapshot(
                document.text,
                document.currentFont,
                document.cursorPosition,
                new ArrayList<String>(document.styles == null ? EMPTY_LIST : document.styles));
        snapshots.push(item);
    }

    public void undo() {
        if(!snapshots.empty()) {
            Snapshot snapshot = snapshots.pop();
            setDocumentState(snapshot);
        }
    }

    private void setDocumentState(Snapshot snapshot) {
        document.text = snapshot.getText();
        document.cursorPosition = snapshot.getCursorPosition();
        document.currentFont = snapshot.getCurrentFont();
        document.styles = new ArrayList<>(snapshot.getStyles());
    }

    public void changeFont(String newFont) {
        createSnapshot();
        document.currentFont = newFont;
    }
}
