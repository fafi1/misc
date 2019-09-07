package net.codefudge.kafka

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.StringSerializer

class ProducerClient<T> {
    Properties props = new Properties()
    KafkaProducer<String, String> producer

    ProducerClient(String bootstrapServers, String clientId) {

        this.props.put(ProducerConfig.ACKS_CONFIG, 'all')
        this.props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
        this.props.put(ProducerConfig.CLIENT_ID_CONFIG, clientId)
    }

    void init() {
        this.producer = new KafkaProducer<String, String>(props, new StringSerializer(), new StringSerializer())
    }

    void send(String topic, String key, T message) {
        producer.send(new ProducerRecord<>(topic, key, message))
    }
}
