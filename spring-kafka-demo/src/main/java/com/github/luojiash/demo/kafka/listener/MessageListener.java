package com.github.luojiash.demo.kafka.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @KafkaListener(topics = "topic-fish")
    public void onMessage(ConsumerRecord<String, String> data, Acknowledgment acknowledgment) {
        log.info("receive message, topic: {}, key: {}, value: {}", data.topic(), data.key(), data.value());
        acknowledgment.acknowledge();
    }
}
