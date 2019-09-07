package net.codefudge

import com.fasterxml.jackson.databind.ObjectMapper

class Json {
    private static def JSON = new ObjectMapper()

    def <T> T read(String json, Class<T> c) {
        return JSON.readValue(json, c)
    }

    String write(Object o) {
        JSON.writeValueAsString(o)
    }
}
