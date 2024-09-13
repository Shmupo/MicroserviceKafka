package com.cogent.order_service.service;

import com.cogent.order_service.payload.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    @Autowired
    private NewTopic topic;

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    public void sendMessage(OrderEvent orderEvent) {
        LOGGER.info("Producing message: {}", orderEvent);

        Message<OrderEvent> message = MessageBuilder
                .withPayload(orderEvent)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }
}