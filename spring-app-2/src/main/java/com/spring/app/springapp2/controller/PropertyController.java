package com.spring.app.springapp2.controller;

import com.spring.app.springapp2.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyController {

    @Autowired
    @Qualifier("greetingPropertyService")
    GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }

}
