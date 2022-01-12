package com.imenez.sms.consumer1.dto;

import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class TopicsModel implements Serializable {

    @Getter
    private Long id;

    @Getter
    @Setter
    private String topicName;

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String consumerGroupId;

}
