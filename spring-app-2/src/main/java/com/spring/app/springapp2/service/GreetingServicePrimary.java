package com.spring.app.springapp2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetingServicePrimary implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Greeting from the Primary Service";
    }
}
