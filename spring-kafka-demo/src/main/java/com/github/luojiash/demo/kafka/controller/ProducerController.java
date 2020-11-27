package com.github.luojiash.demo.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class ProducerController {
    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    @RequestMapping(method = RequestMethod.POST, value = "/message/send")
    public Object sendMessage(@RequestBody String message) throws ExecutionException, InterruptedException {
        SendResult<Object, Object> result = kafkaTemplate.send("topic-fish", UUID.randomUUID().toString(), message).get();
        log.info("{}", result);
        return "success";
    }
}
