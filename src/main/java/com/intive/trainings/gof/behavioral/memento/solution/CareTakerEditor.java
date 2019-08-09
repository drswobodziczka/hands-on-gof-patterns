package com.intive.trainings.gof.behavioral.memento.solution;

import lombok.AllArgsConstructor;

import java.util.Stack;

@AllArgsConstructor
public class CareTakerEditor {

    private DocumentOriginator documentOriginator;
    private Stack<DocumentOriginator.Memento> history;

    public void changeText(String newText) {
        createSnapshot();
        // TODO
    }

    public void changeCursorPosition(int i) {
        createSnapshot();
        // TODO
    }

    public void changeFont(String newFont) {
        createSnapshot();
        // TODO
    }

    private void createSnapshot() {
        DocumentOriginator.Memento item = null;
        // TODO
        history.push(item);
    }

    public void undo() {
        // TODO
    }
}
