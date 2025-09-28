package org.rozanski.cipher

import org.rozanski.cipher.list.CipherCycle
import spock.lang.Specification
import spock.lang.Subject


class DecoderSpecification extends Specification {
    def "decoder uses cipher do decode the text"() {
        given:
        def text = "aaabbc"
        def shift = 2;
        CipherCycle cipherCycle = Mock()
        @Subject
        def decoder = new Decoder(cipherCycle)

        when:
        decoder.decode(text, shift)

        then:
        3 * cipherCycle.shift("a", -shift)
        2 * cipherCycle.shift("b", -shift)
        1 * cipherCycle.shift("c", -shift);
    }

    def "message is decoded properly"() {
        given:
        def text = "cccdde"
        def shift = 2;
        CipherCycle cipherCycle = Stub()
        @Subject
        def decoder = new Decoder(cipherCycle)
        cipherCycle.shift("c", -2) >> "a"
        cipherCycle.shift("d", -2) >> "b"
        cipherCycle.shift("e", -2) >> "c"

        when:
        def encodedText = decoder.decode(text, shift)

        then:
        encodedText == "aaabbc"
    }

    def "spaces are preserved"() {
        given:
        def text = "a a"
        def shift = 2;
        CipherCycle cipherCycle = Stub()
        @Subject
        def decoder = new Decoder(cipherCycle)
        cipherCycle.shift("a", -2) >> "y"

        when:
        def encodedText = decoder.decode(text, shift)

        then:
        encodedText == "y y"
    }

    def "new line sign is preserved"() {
        given:
        def text = "a\na"
        def shift = 2;
        CipherCycle cipherCycle = Stub()
        @Subject
        def decoder = new Decoder(cipherCycle)
        cipherCycle.shift("a", -2) >> "y"

        when:
        def encodedText = decoder.decode(text, shift)

        then:
        encodedText == "y\ny"
    }
}