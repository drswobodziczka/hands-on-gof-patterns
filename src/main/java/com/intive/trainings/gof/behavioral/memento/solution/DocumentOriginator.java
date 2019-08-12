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
    private String font;
    private int cursorPosition;
    private int fontSize;
    private List<String> styles;

    public Memento save() {
        return new Memento(text, font, cursorPosition, fontSize, styles);
    }

    public void restore(Memento memento) {
        setText(memento.text);
        setCursorPosition(memento.cursorPosition);
        setFont(memento.font);
        setFontSize(memento.fontSize);
        setStyles(memento.styles);
    }


    @Getter
    class Memento {
        private final String text;
        private final String font;
        private final int cursorPosition;
        private final int fontSize;
        private final List<String> styles;

        Memento(String text, String font, int cursorPosition, int fontSize, List<String> styles) {
            this.text = text;
            this.font = font;
            this.cursorPosition = cursorPosition;
            this.fontSize = fontSize;
            this.styles = styles;
        }
    }
}
