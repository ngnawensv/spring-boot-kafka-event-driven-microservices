package com.belrose.emailservice.kafka;

import com.belrose.basedomains.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderEmailConsumer {
    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public  void consume(OrderEvent orderEvent){
        log.info(String.format("OrderEmailConsumer->consume(): Order event received in email service =>%s", orderEvent.toString()));
        // Send an email to the customer
      }
}
