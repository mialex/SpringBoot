package com.spring.app.springapp2.service;

import org.springframework.stereotype.Service;

@Service("greetingSetterService")
public class GreetingServiceSetter implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Greeting from Setter Service";
    }
}
