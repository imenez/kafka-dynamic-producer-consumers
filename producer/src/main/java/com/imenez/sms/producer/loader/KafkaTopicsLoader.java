package com.imenez.sms.producer.loader;

import com.imenez.sms.producer.exception.ProduceSMSException;
import com.imenez.sms.producer.model.TopicsModel;
import com.imenez.sms.producer.repository.TopicsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaTopicsLoader {

    private final TopicsRepository topicsRepository;
    public static List<TopicsModel> topicsModelList;


    @PostConstruct
    public List<TopicsModel> init(){
        topicsModelList = topicsRepository.getAllTopics().orElseThrow(() -> new ProduceSMSException("Could not load Topics!"));

        log.info("topicsModelList=> " + topicsModelList.toString());

        return topicsModelList;
    }
}
