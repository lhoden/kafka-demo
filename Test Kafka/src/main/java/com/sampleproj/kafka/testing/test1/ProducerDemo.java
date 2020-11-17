package com.sampleproj.kafka.testing.test1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {

    public static void main(String[] args) {

        // creating producer properties
        Properties properties = new Properties();
        String bootstrapServers = "127.0.0.1:9092";
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // creating producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // creating producer record
        ProducerRecord<String, String> record =
                new ProducerRecord<String, String>("first_topic", "hello test");

        // sending data here >>> -- asynchronous (running in background)
        producer.send(record);
        // producer flush
        producer.flush(); //forces the send
        // producer flush and close
        producer.close();
    }
}
