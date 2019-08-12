package com.intive.trainings.gof.behavioral.memento.solution

import spock.lang.Specification

class DocumentOriginatorTest extends Specification {

    def DocumentOriginator originator

    def "Restores previously saved documents state from memento"() {
        given: "document with text and font"
        originator = DocumentOriginator.builder()
                .text("text")
                .cursorPosition(1)
                .font("latina")
                .build()

        when: "document is saved and then changed"
        def memento = originator.save()
        originator.setFont("times-new-romain")
        originator.setCursorPosition(100)
        originator.restore(memento)

        then: "document state is restored from memento"
        originator.getText() == "text"
        originator.getCursorPosition() == 1
        originator.getFont() == "latina"
    }
}
