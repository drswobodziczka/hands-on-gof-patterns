package com.intive.trainings.gof.behavioral.memento.solution

import spock.lang.Specification

class CareTakerEditorTest extends Specification {
    def "Successfully rollbacks all the changes done to the document"() {
        given: "caretaker editor, document originator with initial state"
        def document = DocumentOriginator.builder().cursorPosition(999).text("some-text").build()
        def editor = new CareTakerEditor(document)

        when: "editor does few changes AND undos each of them"
        editor.changeCursorPosition(0)
        editor.changeText("Tony Halik tu byłem!")
        editor.changeFont("latina")
        editor.undo()
        editor.undo()
        editor.undo()

        then: "document originator is in initial state"
        document.getCursorPosition() == 999
        document.getFont() == null
        document.getText() == "some-text"
    }

    def "Clear document and rallbacks to previous state"() {
        given: "caretaker editor, document originator with initial state"
        def document = DocumentOriginator.builder()
                .cursorPosition(999)
                .text("some-text")
                .fontSize(111)
                .font("times-new-romain")
                .build()
        def editor = new CareTakerEditor(document)

        when: "editor does few changes AND undos each of them"
        editor.clearDocument()
        editor.undo()

        then: "document originator is in initial state"
        document.getCursorPosition() == 999
        document.getText() == "some-text"
        document.getFontSize() == 111
        document.getFont() == "times-new-romain"
    }
}
