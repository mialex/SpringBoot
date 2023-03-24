package com.spring.app.springapp2.controller;

import com.spring.app.springapp2.service.EnvironmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

    private EnvironmentService environmentService;

    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String getEnvironment() {
        return environmentService.getEnvironment();
    }
}
