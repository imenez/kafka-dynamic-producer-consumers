package com.imenez.sms.producer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ptsmslog_main")
@Entity
@EqualsAndHashCode
@Builder
public class PtsmslogMainModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    @Setter
    @Column(unique=true, nullable = false)
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
    @Enumerated
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

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @Getter
    @Setter
    private TopicsModel topicsModel;


}
