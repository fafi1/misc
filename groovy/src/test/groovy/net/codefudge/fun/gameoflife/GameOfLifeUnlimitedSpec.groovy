package net.codefudge.fun.gameoflife

import spock.lang.Specification
import spock.lang.Unroll

class GameOfLifeUnlimitedSpec extends Specification {
    @Unroll
    def 'rule 1: fewer than 2 neighbours cell dies'() {
        given:
        when:
        def next = createGameOfLife().next(grid)

        then:
        next == expGrid

        where:
        //@formatter:off
        grid     | expGrid
        '.'      | '.'
        '*'      | '.'
        '**'     | '..'
        '*.'     | '..'
        '...'    | '...'
        '.**'    | '...'
        '*.*\n'+
        '*.*'    | '...\n' +
                   '...'
        //@formatter:on
    }

    @Unroll
    def 'rule 2: more than 3 neighbours cell dies'() {
        given:
        when:
        def next = createGameOfLife().next(grid)

        then:
        next == expGrid

        where:
        //@formatter:off
        grid     | expGrid
        '***'    | '.*.'
        '***\n'+
        '*.*'    | '*.*\n' +
                   '*.*'
        //@formatter:on
    }

    @Unroll
    def 'rule 3: 2 or 3 neighbours cell survives'() {
        given:
        when:
        def next = createGameOfLife().next(grid)

        then:
        next == expGrid

        where:
        //@formatter:off
        grid     | expGrid
        '***'    | '.*.\n' +
                   '.*.\n' +
                   '.*.'
//        '***\n'+
//        '*.*'    | '*.*\n' +
//                   '*.*'
        //@formatter:on
    }

    @Unroll
    def 'rule 4: dead cell with exactly 3 live neighbours becomes live'() {
        given:
        when:
        def next = createGameOfLife().next(grid)

        then:
        next == expGrid

        where:
        //@formatter:off
        grid     | expGrid
        '*.*\n'+
        '*..'    | '.*.\n' +
                   '.*.'
        '.*.\n'+
        '*.*\n'+
        '...'    | '.*.\n' +
                   '.*.\n' +
                   '...'
        //@formatter:on
    }

    private GameOfLife createGameOfLife() {
        new GameOfLifeFreeUnlimited()
    }
}
