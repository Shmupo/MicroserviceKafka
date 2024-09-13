package com.cogent.stock_service.service;

import com.cogent.stock_service.payload.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderEventConsumer.class);

    @KafkaListener(topics = "order-topic", groupId="order-events-group")
    public void consume(OrderEvent orderEvent) {
        LOGGER.info(String.format("#### -> Consumed Order Event -> %s", orderEvent));
    }
}
