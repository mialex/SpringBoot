package com.spring.app.springapp2.service.Environment;

import com.spring.app.springapp2.service.EnvironmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("qa")
public class QaService implements EnvironmentService {

    @Override
    public String getEnvironment() {
        return "qa";
    }
}
