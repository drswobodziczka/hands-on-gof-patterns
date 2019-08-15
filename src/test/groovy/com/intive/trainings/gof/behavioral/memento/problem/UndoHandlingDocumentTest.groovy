package com.intive.trainings.gof.behavioral.memento.problem

import spock.lang.Specification

class UndoHandlingDocumentTest extends Specification {

    def "originator handles history itself, creates snapshots and undos successfully" () {
        given: "originator with state"
        def document =  new UndoHandlingDocument();
        document.setText("some text")
        document.setCursorPosition(100)

        when: "originator changes state and undos"
        document.setText("newawaewaewaea")
        document.undo()

        then: "initial state is restored"
        document.getText() == "some text"
    }
}
