package com.imenez.sms.consumer2.dto;

import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class ConsumerGroupsModel implements Serializable {

    @Getter
    private Long id;

    @Getter
    @Setter
    private String consumerGroupNo;


}
