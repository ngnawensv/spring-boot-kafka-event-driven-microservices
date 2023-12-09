package com.belrose.orderservice.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@Slf4j
@Data
public class KafkaTopicConfig {
    @Value("${spring.kafka.topic.name}")
    private  String topicName;

    //Spring bean for kafka topic
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(this.getTopicName())
                //.partitions(3)
                .build();
    }
}
