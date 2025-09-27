package org.rozanski.cipher.list

import spock.lang.Specification


class CyclicListSpecification extends Specification {
    def "list returns size of 0 when it's empty"() {
        given:
        def list = new CyclicList();

        expect:
        list.size() == 0;
    }

    def "list returns true when empty"() {
        given:
        def list = new CyclicList()

        expect:
        list.isEmpty();
    }





}