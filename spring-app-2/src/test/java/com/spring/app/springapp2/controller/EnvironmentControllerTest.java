package com.spring.app.springapp2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"prod", "EN"})
@SpringBootTest
public class EnvironmentControllerTest {

    @Autowired
    EnvironmentController controller;

    @Test
    void testEnvironment() {
        System.out.println(controller.getEnvironment());
    }
}
