package com.imenez.sms.producer.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topics")
@Entity
@EqualsAndHashCode
@Builder
public class TopicsModel implements Serializable {

    @Id
    @GeneratedValue(generator = "seq_topic", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "seq_topic", allocationSize = 1, sequenceName = "SEQ_TOPIC")
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
