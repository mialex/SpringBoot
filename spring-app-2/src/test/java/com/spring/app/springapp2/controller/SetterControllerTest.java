package com.spring.app.springapp2.controller;

import com.spring.app.springapp2.service.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SetterControllerTest {

    @Autowired
    SetterController setterController;

//    @BeforeEach
//    void setUp() {
//        setterController = new SetterController();
//        setterController.setGreetingService(new GreetingServiceImpl());
//    }

    @Test
    void sayHello() {
        System.out.println(setterController.sayHello());
    }
}