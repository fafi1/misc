package net.codefudge.fun.eventexp

import net.codefudge.fun.eventexp.Event
import net.codefudge.fun.eventexp.EventHandler
import net.codefudge.fun.eventexp.EventLoop
import net.codefudge.fun.eventexp.ResultEvent
import spock.lang.Specification

import java.time.Instant
import java.util.concurrent.TimeUnit

class EventLoopSpec extends Specification {
    def 'loop'() {
        String result
        def loop = new EventLoop()
        loop.add(new EventHandler(ResultEvent.class, { ResultEvent e ->
            result = e.message
        }))
        loop.add(new EventHandler(Event.class, { Event e ->
            if (e.message.length() < 100) {
                throw new Event(e.message + ' test')
            }
            throw new ResultEvent(e.message + ' ' + Instant.now())
        }))


        when:
        loop.start({
            throw new Event('started ' + Instant.now())
        })

        loop.pool.awaitTermination(10, TimeUnit.MINUTES)

        then:
        result ==~ /.*( test){13}.*/
    }

}
