package com.ajay.kafka.controllers;

import com.ajay.kafka.model.Person;
import com.ajay.kafka.services.PersonPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/kafka/publish")
public class PersonController {
    private final PersonPublisherService personPublisherService;

    @PostMapping(value = "/person")
    public void test(@RequestBody Person person) {
        personPublisherService.sendMessage(person);
    }
}
