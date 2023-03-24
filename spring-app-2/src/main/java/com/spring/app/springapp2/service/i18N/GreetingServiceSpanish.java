package com.spring.app.springapp2.service.i18N;

import com.spring.app.springapp2.service.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("i18NService")
@Profile("ES")
public class GreetingServiceSpanish implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola en ES";
    }
}
