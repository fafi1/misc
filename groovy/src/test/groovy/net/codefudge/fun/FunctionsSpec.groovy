package net.codefudge.fun

import spock.lang.Specification

class FunctionsSpec extends Specification {
    def 'test'() {
        expect:
        new Functions().choose([{1}, {1}], 1)
    }
}
