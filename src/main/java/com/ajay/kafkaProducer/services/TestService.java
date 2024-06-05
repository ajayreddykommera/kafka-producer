package com.ajay.kafkaProducer.services;

import com.ajay.kafkaProducer.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TestService {
    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;

    public void sendMessage(Person message) {
        CompletableFuture<SendResult<String, Person>> future = kafkaTemplate.send("test2", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        message + "] due to : " + ex.getMessage());
            }
        });
    }
}
