package com.imenez.sms.producer.model.elasticsearch;

import com.imenez.sms.producer.model.Status;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@EqualsAndHashCode(of = { "id" })
@Document(indexName = "ptsmslogmain")
@AllArgsConstructor
@NoArgsConstructor
public class PtsmslogMainESModel implements Serializable {

    @Id
    private Long id;
    private String msgId;
    private String srcMsisdn;
    private String dstMsisdn;
    private String msgCode;
    private String msgDate;
    private String content;
    private Status statudesc;
    private String xser;
    private String cspsServiceId;
    private Date logDate;
}
