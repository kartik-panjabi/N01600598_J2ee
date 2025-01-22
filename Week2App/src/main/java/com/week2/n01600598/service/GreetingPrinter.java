package com.week2.n01600598.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingPrinter {


    private final GreetingService greetingService;

    @Autowired
    public GreetingPrinter(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    public String getPrintGreeting() {
        return greetingService.greeting();
    }
}
