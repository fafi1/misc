package net.codefudge.fun

class Functions {
    class B {
        B b() {
            b()
        }
    }

    void stop(Closure c) {

    }

    void next(Closure c) {
        c()
    }

    void callTimes(List<Closure> l) {

    }

    void call(List<Closure> a) {

    }

    void switch1(Closure a, Closure b, int i) {
        switch1(b, a, i - 1)
    }

    void choose(Closure a, Closure b, int i) {
        choose()
    }

    void choose(List<Closure> l, int p) {
        l[p]
    }
}
