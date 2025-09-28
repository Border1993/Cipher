package org.rozanski.cipher

import spock.lang.Specification


class CesarCipherSpecification extends Specification {
    def "Cipher encodes the message" () {
        given:
        def message = "there is no spoon"
        def cipher = new CesarCipher(Alphabet.LOWER_CASE_ENGLISH, 5)

        when:
        def result = cipher.encode(message)

        then:
        result == "ymjwj nx st xutts"
    }

    def "Cipher decodes the message"() {
        given:
        def message = "ymjwj nx st xutts"
        def cipher = new CesarCipher(Alphabet.LOWER_CASE_ENGLISH, 5)

        when:
        def result = cipher.decode(message)

        then:
        result == "there is no spoon"
    }

}