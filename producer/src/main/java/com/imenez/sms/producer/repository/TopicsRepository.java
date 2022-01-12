package com.imenez.sms.producer.repository;

import com.imenez.sms.producer.model.TopicsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TopicsRepository extends JpaRepository<TopicsModel, Long> {


    @Query(value = "SELECT t.id,t.content,t.topic_name,c.consumer_group_no as consumer_group_id FROM consumer_groups c, topics t where t.consumer_group_id = c.id", nativeQuery = true)
    Optional<List<TopicsModel>> getAllTopics();



}
