package com.cogent.order_service.controller;

import com.cogent.order_service.payload.OrderEvent;
import com.cogent.order_service.service.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/kafka")
@RestController
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/order")
    public ResponseEntity<String> order(@RequestBody OrderEvent orderEvent) {
        orderProducer.sendMessage(orderEvent);
        return ResponseEntity.ok(String.format("Order published, %s", orderEvent));
    }
}
