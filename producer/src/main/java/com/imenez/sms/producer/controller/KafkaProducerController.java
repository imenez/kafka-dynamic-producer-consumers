package com.imenez.sms.producer.controller;


import com.imenez.sms.producer.loader.KafkaTopicsLoader;
import com.imenez.sms.producer.model.PtsmslogMainModel;
import com.imenez.sms.producer.model.TopicsModel;
import com.imenez.sms.producer.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;
    

    @GetMapping("/allTopics")
    public List<TopicsModel> getAllTopics() {


        return kafkaProducerService.getAllTopics();
    }


    @Scheduled(cron="*/10 * * * * *", zone="Europe/Istanbul")
    @GetMapping("/sendConsumer")
    public String sendToConsumers() {


        return kafkaProducerService.getSMSAndSendToConsumer();
    }
}
