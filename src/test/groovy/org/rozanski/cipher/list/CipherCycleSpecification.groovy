package org.rozanski.cipher.list

import spock.lang.Specification


class CipherCycleSpecification extends Specification {
    def "list returns size of 0 when it's empty"() {
        given:
        def list = new CipherCycle();

        expect:
        list.size() == 0;
    }

    def "list returns true when empty"() {
        given:
        def list = new CipherCycle()

        expect:
        list.isEmpty()
    }

    def "list returns false when not empty"() {
        given:
        def list = new CipherCycle()

        when:
        list.add(1)

        then:
        !list.isEmpty()
    }

    def "size grows after adding single element to the list"() {
        given:
        def list = new CipherCycle<String>();

        when:
        list.add("a")

        then:
        list.size() == 1
    }

    def "add returns true on success"() {
        given:
        def list = new CipherCycle<String>();

        expect:
        list.add("a")
    }

    def "get returns first element"() {
        given:
        def list = new CipherCycle<String>();

        when:
        list.add("a")

        then:
        list.get(0) == "a"
    }

    def "list retains all elements in order"() {
        given:
        def list = new CipherCycle<String>();

        when:
        list.add("a")
        list.add("b")
        list.add("c")

        then:
        list.get(0) == "a"
        list.get(1) == "b"
        list.get(2) == "c"
    }

    def "addAll adds multiple elements at the same time in given order"() {
        given:
        def list = new CipherCycle<String>();

        when:
        list.addAll("a", "b", "c")

        then:
        list.get(0) == "a"
        list.get(1) == "b"
        list.get(2) == "c"
    }

}