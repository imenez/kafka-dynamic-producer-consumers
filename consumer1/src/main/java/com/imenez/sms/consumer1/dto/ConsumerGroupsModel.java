package com.imenez.sms.consumer1.dto;

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
