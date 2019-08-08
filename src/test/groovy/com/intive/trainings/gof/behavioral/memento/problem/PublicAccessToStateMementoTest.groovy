package com.intive.trainings.gof.behavioral.memento.problem

import spock.lang.Specification

class PublicAccessToStateMementoTest extends Specification {

    def "action taken by editor can be successfully undone"() {
        given: "Text, Document and Caretaker"
        def text = "text version one"
        def document = Document.builder().text(text).build()
        def editor = new UndoHandlingEditor(document, new Stack<Snapshot>())

        when: "editor changes text AND hits undo"
        def newText = "new text"
        editor.changeText(newText)
        editor.undo()

        then: "previous snapshot of document's state is restored"
        document.text == text
    }

    def "all actions taken by editor can be successfully rolled back"() {
        given: "Document with full state and Editor"
        def text = "text version one"
        def font = "latin"
        def pos = 0
        def styles = ["style1", "style2"]
        def document = Document.builder().text(text).currentFont(font).cursorPosition(pos).styles(styles).build()
        def editor = new UndoHandlingEditor(document, new Stack<Snapshot>())

        when: "editor do subsequent changes and undos for several times"
        def newText = "new text"
        def newPosition = 10
        def newFont = "times_new_romain"
        editor.changeText(newText)
        editor.changeCursorPosition(newPosition);
        editor.changeFont(newFont);
        editor.undo()
        editor.undo()
        editor.undo()

        then: "initial snapshot of document's state is restored"
        document.text == text
        document.currentFont == font
        document.cursorPosition == pos
        document.styles == styles
    }
}
