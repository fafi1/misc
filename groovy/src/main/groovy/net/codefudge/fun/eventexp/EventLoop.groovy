package net.codefudge.fun.eventexp


import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor


class EventLoop {
    List<EventHandler> handlers = []
    def pool = Executors.newFixedThreadPool(1)

    EventLoop() {
    }

    void add(EventHandler handler) {
        this.handlers << handler
    }

    void start(Closure c) {
        pool.submit(loop(c))
    }

    void stop() {
        pool.shutdown()
    }

    Closure loop(Closure c) {
        return {
            try {
                c()
                def t =  ((ThreadPoolExecutor)pool)
                if (t.getQueue().size() == 0) {
                    pool.shutdown()
                }
            } catch (Event e) {
                EventHandler find = handlers.find({ it.eventClass.isInstance(e)})
                if (find != null) {
                    pool.submit(loop({ find.handle(e) }))
                }
            }
        }
    }

}
