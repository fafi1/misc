package net.codefudge.spike.general

import spock.lang.Specification

// see https://www.regular-expressions.info/catastrophic.html
class RegExpSpike extends Specification {
    def 'freeze 1'() {
        def pattern = ~/(1+)+2/

        expect:
        pattern.matcher('1111111111111111111111111111111132').find()
    }

    def 'freeze 2'() {
        def pattern = ~/(\w+)+z/

        expect:
        pattern.matcher('abcdefghijklmnopqrstuvwxyabcde?z').find()
    }
}
