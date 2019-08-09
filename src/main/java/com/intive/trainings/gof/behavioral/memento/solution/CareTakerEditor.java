package com.intive.trainings.gof.behavioral.memento.solution;

import java.util.Stack;

public class CareTakerEditor {

    private final DocumentOriginator documentOriginator;
    private final Stack<DocumentOriginator.Memento> history;

    public CareTakerEditor(DocumentOriginator documentOriginator) {
        this.documentOriginator = documentOriginator;
        history = new Stack<>();
    }

    public void changeText(String newText) {
        documentOriginator.setText(newText);
    }

    public void changeCursorPosition(int i) {
        documentOriginator.setCursorPosition(i);
    }

    public void changeFont(String newFont) {
        documentOriginator.setCurrentFont(newFont);
    }

    private void createSnapshot() {
        // TODO
    }

    public void undo() {
        // TODO
    }
}
