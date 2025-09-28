package org.rozanski.cipher

import org.rozanski.cipher.list.CipherCycle
import spock.lang.Specification
import spock.lang.Subject

class EncoderSpecification extends Specification {
    def "encoder uses cipher do encode the text"() {
        given:
        def text = "aaabbc"
        def shift = 2;
        CipherCycle cipherCycle = Mock()
        @Subject
        def encoder = new Encoder(cipherCycle)

        when:
        encoder.encode(text, shift)

        then:
        3 * cipherCycle.shift("a", shift)
        2 * cipherCycle.shift("b", shift)
        1 * cipherCycle.shift("c", shift);
    }

    def "message is encoded properly"() {
        given:
        def text = "aaabbc"
        def shift = 2;
        CipherCycle cipherCycle = Stub()
        @Subject
        def encoder = new Encoder(cipherCycle)
        cipherCycle.shift("a", 2) >> "c"
        cipherCycle.shift("b", 2) >> "d"
        cipherCycle.shift("c", 2) >> "e"

        when:
        def encodedText = encoder.encode(text, shift)

        then:
        encodedText == "cccdde"
    }

}