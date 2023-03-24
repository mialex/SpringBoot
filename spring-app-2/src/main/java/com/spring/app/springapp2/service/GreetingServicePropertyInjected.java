package com.spring.app.springapp2.service;

import org.springframework.stereotype.Service;

@Service("greetingPropertyService")
public class GreetingServicePropertyInjected implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Greeting from Property Injected Service";
    }
}
