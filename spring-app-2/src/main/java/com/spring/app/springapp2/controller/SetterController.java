package com.spring.app.springapp2.controller;

import com.spring.app.springapp2.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class SetterController {

    private GreetingService greetingService;

    @Autowired
    @Qualifier("greetingSetterService")
    public void setGreetingService(GreetingService service) {
        greetingService = service;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
