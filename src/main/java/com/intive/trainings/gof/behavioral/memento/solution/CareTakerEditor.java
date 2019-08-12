package com.intive.trainings.gof.behavioral.memento.solution;

import java.util.Stack;

import static java.util.Collections.emptyList;

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
        documentOriginator.setFont(newFont);
    }

    public void clearDocument() {
        createSnapshot();
        documentOriginator.setFont("latina");
        documentOriginator.setText("");
        documentOriginator.setFontSize(11);
        documentOriginator.setCursorPosition(0);
        documentOriginator.setStyles(emptyList());
    }

    public void undo() {
        if (!history.empty()) {
            DocumentOriginator.Memento memento = history.pop();
            documentOriginator.restore(memento);
        }
    }

    private void createSnapshot() {
        DocumentOriginator.Memento memento = documentOriginator.save();
        history.push(memento);
    }
}
