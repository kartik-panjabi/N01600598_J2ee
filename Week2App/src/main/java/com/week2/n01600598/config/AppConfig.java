package com.week2.n01600598.config;

import com.week2.n01600598.service.GreetingPrinter;
import com.week2.n01600598.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    GreetingService greetingService(){
    return new GreetingService();
    }

    @Bean
    GreetingPrinter greetingPrinter(GreetingService greetingService){
        return new GreetingPrinter(greetingService);
    };

}
