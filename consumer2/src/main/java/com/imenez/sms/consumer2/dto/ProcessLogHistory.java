package com.imenez.sms.consumer2.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ProcessLogHistory implements Serializable {

    private Long id;
    private String msisdn;
    private Date startTime;
    private Date updateTime;
    private String topicId;
    private String messageId;
    private String status;
    private String content;


}
