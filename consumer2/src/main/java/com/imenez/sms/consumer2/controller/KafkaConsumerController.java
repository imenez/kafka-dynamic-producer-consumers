package com.imenez.sms.consumer2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerController {


    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kafka.consumer.topicname}")
    private String topicName;

    @KafkaListener(groupId = "${kafka.consumer.groupid}", topics = "${kafka.consumer.topicname}", containerFactory = "${kafka.listener.container.factory}")
    public void getSMSFromTopic(String ptsmsLogMain) throws JsonProcessingException {

        try {

            String jsonString = objectMapper.writeValueAsString(ptsmsLogMain);
            log.info("Topic:${kafka.consumer.topicname} - Consumer 2 - Message Received using Kafka listener ==>" + jsonString);

        } catch (Exception e) {

            //statu update to failed
            kafkaTemplate.send(topicName, ptsmsLogMain);

        }
    }


}
