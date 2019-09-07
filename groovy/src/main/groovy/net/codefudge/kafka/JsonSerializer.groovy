package net.codefudge.kafka

import org.apache.kafka.common.header.Headers
import org.apache.kafka.common.serialization.Serializer

class JsonSerializer<T> implements Serializer<T> {
    @Override
    void configure(Map<String, ?> configs, boolean isKey) {
        super.configure(configs, isKey)
    }

    @Override
    byte[] serialize(String topic, T data) {
        return new byte[0]
    }

    @Override
    byte[] serialize(String topic, Headers headers, T data) {
        return super.serialize(topic, headers, data)
    }

    @Override
    void close() {
        super.close()
    }
}
