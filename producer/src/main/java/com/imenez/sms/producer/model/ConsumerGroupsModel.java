package com.imenez.sms.producer.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consumer_groups")
@Entity
@EqualsAndHashCode
@Builder
public class ConsumerGroupsModel implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_group", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "seq_group", allocationSize = 1, sequenceName = "SEQ_GROUP")
    @Getter
    private Long id;

    @Getter
    @Setter
    private String consumerGroupNo;


}
