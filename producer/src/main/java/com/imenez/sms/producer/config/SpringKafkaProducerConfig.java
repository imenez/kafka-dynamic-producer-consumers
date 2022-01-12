package com.imenez.sms.producer.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;


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
    @Value("${kafka.producer.key.serializer}")
    public String KAFKA_PRODUCER_KEY_SERIALIZER;
    @Value("${kafka.producer.value.serializer}")
    public String KAFKA_PRODUCER_VALUE_SERIALIZER;
    @Value("${kafka.producer.factory.groupid}")
    public String KAFKA_GROUP_ID_STRING;

    /*@Autowired
    private Environment env;
    private static Environment environment;
    environment.getProperty("handlesmsms.url")*/


    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_LOCAL_SERVER_CONFIG);
        //props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KAFKA_PRODUCER_KEY_SERIALIZER);
        //props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KAFKA_PRODUCER_VALUE_SERIALIZER);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");
        //props.put(ProducerConfig.GROUP_ID_CONFIG, KAFKA_GROUP_ID_STRING);

        log.info("KAFKA_LOCAL_SERVER_CONFIG=> " + KAFKA_LOCAL_SERVER_CONFIG);
        log.info("KAFKA_LISTENER_CONTAINER_FACTORY=> " + KAFKA_LISTENER_CONTAINER_FACTORY);
        log.info("KAFKA_PRODUCER_KEY_SERIALIZER=> " + KAFKA_PRODUCER_KEY_SERIALIZER);
        log.info("KAFKA_PRODUCER_VALUE_SERIALIZER=> " + KAFKA_PRODUCER_VALUE_SERIALIZER);
        log.info("KAFKA_GROUP_ID_STRING=> " + KAFKA_GROUP_ID_STRING);
        return props;
    }

    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }


}
