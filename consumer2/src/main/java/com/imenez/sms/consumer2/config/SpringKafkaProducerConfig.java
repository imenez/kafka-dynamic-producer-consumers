package com.imenez.sms.consumer2.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class SpringKafkaProducerConfig {

    @Value("${kafka.local.server.config}")
    public String KAFKA_LOCAL_SERVER_CONFIG;
    @Value("${kafka.listener.container.factory}")
    public String KAFKA_LISTENER_CONTAINER_FACTORY;
    @Value("${kafka.consumer.key.serializer}")
    public String KAFKA_CONSUMER_KEY_SERIALIZER;
    @Value("${kafka.consumer.value.serializer}")
    public String KAFKA_CONSUMER_VALUE_SERIALIZER;
    @Value("${kafka.consumer.groupid}")
    public String KAFKA_GROUP_ID_STRING;


    /*@Autowired
    private Environment env;
    private static Environment environment;
    environment.getProperty("handlesmsms.url")*/


    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_LOCAL_SERVER_CONFIG);
        //props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KAFKA_CONSUMER_KEY_SERIALIZER);
        //props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KAFKA_CONSUMER_VALUE_SERIALIZER);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.serializer", "org.springframework.kafka.support.serializer.JsonDeserializer");
        //props.put(ProducerConfig.GROUP_ID_CONFIG, KAFKA_GROUP_ID_STRING);


        log.info("KAFKA_LOCAL_SERVER_CONFIG=> " + KAFKA_LOCAL_SERVER_CONFIG);
        log.info("KAFKA_LISTENER_CONTAINER_FACTORY=> " + KAFKA_LISTENER_CONTAINER_FACTORY);
        log.info("KAFKA_CONSUMER_KEY_SERIALIZER=> " + KAFKA_CONSUMER_KEY_SERIALIZER);
        log.info("KAFKA_CONSUMER_VALUE_SERIALIZER=> " + KAFKA_CONSUMER_VALUE_SERIALIZER);
        log.info("KAFKA_GROUP_ID_STRING=> " + KAFKA_GROUP_ID_STRING);
        return props;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(producerConfigs());
    }



}
