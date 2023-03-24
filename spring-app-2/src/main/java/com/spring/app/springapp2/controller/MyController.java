package com.spring.app.springapp2.controller;

import com.spring.app.springapp2.service.GreetingService;
import com.spring.app.springapp2.service.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    GreetingService greetingService;

    public MyController() {
        greetingService = new GreetingServiceImpl();
    }

    public String sayHello() {
        System.out.println("We are in the Controller");

        return "Hello World! " + greetingService.sayGreeting();
    }

    public void beforeInit() {
        System.out.println(" # Before init, called by Bean Post Processor");
    }

    public void afterInit() {
        System.out.println(" # After init, called by Bean Post Processor");
    }
}
