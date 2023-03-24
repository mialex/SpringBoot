package com.spring.app.springapp2.controller;

import com.spring.app.springapp2.service.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ConstructorControllerTest {

    @Autowired
    ConstructorController controller;

//    @BeforeEach
//    void setUp() {
//        controller = new ConstructorController(new GreetingServiceImpl());
//    }

    @Test
    void sayHello() {
        System.out.println(controller.sayHello());
    }
}