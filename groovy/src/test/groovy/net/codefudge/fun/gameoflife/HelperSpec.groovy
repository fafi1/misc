package net.codefudge.fun.gameoflife

import spock.lang.Specification

class HelperSpec extends Specification {
    def 'bool 2 int'() {
        expect:
        Helper.bool2int(false) == 0
        Helper.bool2int(true) == 1
    }

    def 'if else'() {
        when:
        def r = Helper.ifElse(condition, if1, else1)

        then:
        r == expR

        where:
        condition | if1 | else1 | expR
        false | {2} | {3} | 3
        true | {2} | {3} | 2
    }
}
