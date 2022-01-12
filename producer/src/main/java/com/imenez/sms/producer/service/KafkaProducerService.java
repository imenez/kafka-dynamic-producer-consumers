package com.imenez.sms.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imenez.sms.producer.exception.ProduceSMSException;
import com.imenez.sms.producer.loader.KafkaTopicsLoader;
import com.imenez.sms.producer.model.PtsmslogMainModel;
import com.imenez.sms.producer.model.Status;
import com.imenez.sms.producer.model.TopicsModel;
import com.imenez.sms.producer.model.elasticsearch.PtsmslogMainESModel;
import com.imenez.sms.producer.repository.PtsmsLogMainRepository;
import com.imenez.sms.producer.repository.elasticsearch.PtsmsLogMainESRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {

    private final KafkaTopicsLoader kafkaTopicsLoader;
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ModelMapper modelMapper;
    private final PtsmsLogMainRepository ptsmsLogMainRepository;
    private final PtsmsLogMainESRepository ptsmsLogMainElasticSearchRepository;

    public List<TopicsModel> getAllTopics() {
        List<TopicsModel> topicsModelList = kafkaTopicsLoader.topicsModelList;

        return topicsModelList;
    }

    @Transactional
    public String getSMSAndSendToConsumer() {

        List<TopicsModel> topicsModelList = kafkaTopicsLoader.topicsModelList;
        List<PtsmslogMainModel> ptsmslogMainModels = ptsmsLogMainRepository.findAll();

        ptsmslogMainModels.stream().forEach(ptsmslogMainModel -> {
            String content = ptsmslogMainModel.getContent();
            String msgID = ptsmslogMainModel.getMsgId();
            Status status = ptsmslogMainModel.getStatudesc();
            if (status.equals(Status.RECEIVED)) {
                topicsModelList.forEach(topicsModel -> {
                    if (content.equals(topicsModel.getContent())) {
                        String topicName = topicsModel.getTopicName();
                        try {
                            kafkaTemplate.send(topicName, ptsmslogMainModel);
                            log.info("Message is sending to --> ptsmslogMainModel: " + ptsmslogMainModel.toString());

                            ptsmsLogMainRepository.updateSMSStatus(Status.DONE.ordinal(), msgID);
                            log.info("Message's status is updated to: " + Status.DONE);
                            PtsmslogMainESModel ptsmslogMainESModel = modelMapper.map(ptsmslogMainModel, PtsmslogMainESModel.class);
                            ptsmsLogMainElasticSearchRepository.save(ptsmslogMainESModel);
                            log.info("Loggeed to Elasticsearch--> " + ptsmslogMainESModel);
                        } catch (Exception e) {
                            throw new ProduceSMSException("Kafka Producer SMS Sending Error!\n" + e);
                        }

                    }
                });
            }

        });


        return "Messages have sent";


    }


}
