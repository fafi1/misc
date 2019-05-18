package net.codefudge.fun.eventexp

class EventHandler<T extends Event> {
    Class<T> eventClass
    private final Closure c

    EventHandler(Class<T> eventClass, Closure c) {
        this.c = c
        this.eventClass = eventClass
    }

    void handle(T t) {
        c(t)
    }

}