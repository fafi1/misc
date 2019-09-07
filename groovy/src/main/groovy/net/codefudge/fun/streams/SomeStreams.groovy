package net.codefudge.fun.streams

import java.util.stream.Collectors
import java.util.stream.Stream

class SomeStreams {
    def process(Stream<String> source) {
        source.collect(Collectors.toList())
    }
}
