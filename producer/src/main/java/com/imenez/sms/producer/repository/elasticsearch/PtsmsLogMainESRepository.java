package com.imenez.sms.producer.repository.elasticsearch;

import com.imenez.sms.producer.model.elasticsearch.PtsmslogMainESModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.annotations.Query;

import java.util.List;

@Repository
public interface PtsmsLogMainESRepository extends ElasticsearchRepository<PtsmslogMainESModel, Long> {

    @Query("{\"bool\" : {\"must\" : [ {\"match\" : {\"msgId\" : \"?0\"}} ]}}\"")
    List<PtsmslogMainESModel> getByCustomQuery(String search);
}
