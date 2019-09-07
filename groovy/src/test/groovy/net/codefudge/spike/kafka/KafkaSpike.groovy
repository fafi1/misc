package net.codefudge.spike.kafka

import net.codefudge.kafka.LoopClient
import net.codefudge.kafka.ProducerClient
import spock.lang.Specification

class KafkaSpike extends Specification {
    def 'send something'() {
        when:
        def client = new ProducerClient<>('localhost:9092', 'test-client')

        client.init()
        client.send('test-topic', 'm1', 'hi there')

        then:
        true
    }

    def 'poll something'() {
        when:
        def poll = new LoopClient<>('localhost:9092', 'poll-client')

        poll.init('test-topic', { records ->
            records.forEach {
                println it.value()
            }
        })

        then:
        sleep(60000)
    }
}
