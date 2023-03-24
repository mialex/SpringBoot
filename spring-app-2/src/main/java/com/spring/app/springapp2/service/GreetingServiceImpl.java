package com.spring.app.springapp2.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Greeting from Services it said";
    }
}
