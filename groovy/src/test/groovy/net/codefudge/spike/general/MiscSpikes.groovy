package net.codefudge.spike.general

import spock.lang.Specification

class MiscSpikes extends Specification {
    def 'split'() {
        expect:
        println 'test hello  hi   there'.split(' +')
    }
}
