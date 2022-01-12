package com.imenez.sms.producer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "process_history")
@Entity
@EqualsAndHashCode
@Builder
public class ProcessLogHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String msisdn;
    private Date startTime;
    private Date updateTime;
    private String topicId;
    private String messageId;
    private String status;
    private String content;


}
