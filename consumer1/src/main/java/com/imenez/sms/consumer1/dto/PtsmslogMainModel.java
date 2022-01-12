package com.imenez.sms.consumer1.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class PtsmslogMainModel implements Serializable {


    @Getter
    private Long id;
    @Getter
    @Setter
    private String msgId;
    @Getter
    @Setter
    private String srcMsisdn;
    @Getter
    @Setter
    private String dstMsisdn;
    @Getter
    @Setter
    private String msgCode;
    @Getter
    @Setter
    private String msgDate;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private Status statudesc;
    @Getter
    @Setter
    private String xser;
    @Getter
    @Setter
    private String cspsServiceId;
    @Getter
    @Setter
    private Date logDate;

    @Getter
    @Setter
    private TopicsModel topicsModel;


}
