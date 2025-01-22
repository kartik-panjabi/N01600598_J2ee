package com.week2.n01600598.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greeting() {
        return "Hello World, Greeting from Kartik - N01600598 ";
    };

    @PostConstruct
    public void init() {
        System.out.println(" Greeting Service initiated ");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(" Greeting Service destroyed ");
    }
}
