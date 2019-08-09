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
        createSnapshot();
        documentOriginator.setText(newText);
    }

    public void changeCursorPosition(int i) {
        createSnapshot();
        documentOriginator.setCursorPosition(i);
    }

    public void changeFont(String newFont) {
        createSnapshot();
        documentOriginator.setCurrentFont(newFont);
    }

    private void createSnapshot() {
        DocumentOriginator.Memento memento = documentOriginator.save();
        history.push(memento);
    }

    public void undo() {
        if (!history.empty()) {
            DocumentOriginator.Memento memento = history.pop();
            documentOriginator.restore(memento);
        }
    }
}
