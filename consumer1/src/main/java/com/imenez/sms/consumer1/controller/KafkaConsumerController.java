package com.imenez.sms.consumer1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imenez.sms.consumer1.dto.PtsmslogMainModel;
import com.imenez.sms.consumer1.dto.TopicsModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerController {


    private final ObjectMapper objectMapper;

    @KafkaListener(groupId = "${kafka.consumer.groupid}", topics = "${kafka.consumer.topicname7}", containerFactory = "${kafka.listener.container.factory}")
    public void getSMSFromTopic(String ptsmsLogMain) throws JsonProcessingException {

        String jsonString = objectMapper.writeValueAsString(ptsmsLogMain);
        log.info("Topic:${kafka.consumer.topicname7} - Consumer 1 - Message Received using Kafka listener ==>" + jsonString);
    }

    @KafkaListener(groupId = "${kafka.consumer.groupid}", topics = "${kafka.consumer.topicname2}", containerFactory = "${kafka.listener.container.factory}")
    public void getSMSFromTopic2(String ptsmsLogMain) throws JsonProcessingException {

        String jsonString = objectMapper.writeValueAsString(ptsmsLogMain);
        log.info("Topic:${kafka.consumer.topicname2} - Consumer 1 - Message Received using Kafka listener ==>" + jsonString);
    }
}
