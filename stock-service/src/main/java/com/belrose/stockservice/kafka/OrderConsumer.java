package com.belrose.stockservice.kafka;

import com.belrose.stockservice.model.OrderEventModel;
import com.belrose.stockservice.repository.OrderEventRepository;
import com.belrose.basedomains.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {

    private final OrderEventRepository orderEventRepository;

    public OrderConsumer(OrderEventRepository orderEventRepository) {
        this.orderEventRepository = orderEventRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
    public  void consume(OrderEvent orderEvent){
        log.info(String.format("OrderConsumer->consume(): Order event received =>%s", orderEvent.toString()));

        // Save the order event into the database
      var orderEventModel = OrderEventModel.builder()
                .status(orderEvent.getStatus())
                .message(orderEvent.getMessage())
                .order(orderEvent.getOrder().toString())
                .build();
        orderEventRepository.save(orderEventModel);
        log.info(String.format("OrderConsumer->consume(): Order event  model save in database =>%s {}", orderEventModel));
    }
}
