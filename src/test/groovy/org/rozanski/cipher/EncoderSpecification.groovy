package org.rozanski.cipher

import org.rozanski.cipher.list.CipherCycle
import spock.lang.Specification

class EncoderSpecification extends Specification {
    def "encoder uses cipher do encode the text"() {
        given:
        def text = "aaabbc"
        def shift = 2;
        CipherCycle cipherCycle = Mock()
        def encoder = new Encoder(cipherCycle)


        when:
        encoder.encode(text, shift)

        then:
        3 * cipherCycle.shift("a", shift)
        2 * cipherCycle.shift("b", shift)
        1 * cipherCycle.shift("c", shift);
    }

}