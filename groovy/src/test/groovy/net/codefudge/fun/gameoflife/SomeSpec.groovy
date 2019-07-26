package net.codefudge.fun.gameoflife

import spock.lang.Specification

class SomeSpec extends Specification {
    def 'boolean to number'() {
        when:
        int one = 1 & (Boolean.hashCode(true) >> 1)
        int zero = 1 & (Boolean.hashCode(false) >> 1)

        println "$one $zero"

        then:
        one == 1
        zero == 0
    }

}
