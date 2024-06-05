package com.ajay.kafkaProducer.controllers;

import com.ajay.kafkaProducer.model.Person;
import com.ajay.kafkaProducer.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @PostMapping(value = "/test")
    public void test(@RequestBody Person person) {
        testService.sendMessage(person);
    }
}
