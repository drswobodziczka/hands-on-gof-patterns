package com.intive.trainings.gof.behavioral.memento.solution;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
class DocumentOriginator {
    private String text;
    private String currentFont;
    private int cursorPosition;
    private List<String> styles;

    public Memento save() {
        return new Memento(text, currentFont, cursorPosition, styles);
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
