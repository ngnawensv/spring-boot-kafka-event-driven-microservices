package com.belrose.orderservice.Contoller;

import com.belrose.orderservice.kafka.OrderProducer;
import com.belrose.basedomains.dto.Order;
import com.belrose.basedomains.dto.OrderEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public ResponseEntity<String> placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = OrderEvent.builder().status("PENDING")
                .message("order status is in penidng state")
                .order(order)
                .build();
        orderProducer.sendMessage(orderEvent);

        return ResponseEntity.ok("Order placed seccessfully ...");
    }
}
