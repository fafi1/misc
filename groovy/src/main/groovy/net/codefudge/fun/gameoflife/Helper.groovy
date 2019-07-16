package net.codefudge.fun.gameoflife;

class Helper {
    static int bool2int(boolean b) {
        ifElse(b, {1}, {0})
    }

    static def ifElse(boolean b, Closure if1, Closure else1) {
        def m = [:]
        m[true] = if1
        m[false] = else1

        return m[b]()
    }
}
