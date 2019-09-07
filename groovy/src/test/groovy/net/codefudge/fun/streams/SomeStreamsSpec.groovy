package net.codefudge.fun.streams


import net.codefudge.Json
import org.slf4j.LoggerFactory
import spock.lang.Specification

import java.time.Instant

class TestMessage {
    String text
    int offset
}

class SomeStreamsSpec extends Specification {
    static def LOG = LoggerFactory.getLogger('SomeLogger')
    static def RAND = new Random()

    String[] msgs = ['bug', 'fine', 'check', 'won\'t find me', 'hello']

    private Json json = new Json()

    def 'create logs'() {
        expect:
        1000.times {
            LOG.info('{}|{}|{}|{}', Instant.now().toString(), 'log', 'info',
                    json.write(new TestMessage(text: nextMsg(), offset: it)))
        }
    }

    String nextMsg() {
        msgs[RAND.nextInt(msgs.length)]
    }

    def 'test'() {
        new SomeStreams().process()
    }
}
