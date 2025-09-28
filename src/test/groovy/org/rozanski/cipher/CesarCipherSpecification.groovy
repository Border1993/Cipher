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

    def "Previously encoded message can be decoded"() {
        given:
        def message = "there is no spoon"
        def cipher = new CesarCipher(Alphabet.LOWER_CASE_ENGLISH, 5)

        when:
        def encoded = cipher.encode(message)
        def decoded = cipher.decode(encoded)

        then:
        encoded == "ymjwj nx st xutts"
        decoded == message
    }

    def "Custom alphabets are supported"() {
        given:
        def message = "zażółć żółtą jaźń"
        def cipher = new CesarCipher("aąbcćdeęfghijklłmnńoóprsśtuwyzźż", 5)

        when:
        def encoded = cipher.encode(message)
        def decoded = cipher.decode(encoded)

        then:
        encoded == "bdćtóg ćtóźe ndcs"
        decoded == message
    }

}