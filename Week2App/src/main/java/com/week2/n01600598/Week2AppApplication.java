package com.week2.n01600598;

import com.week2.n01600598.config.AppConfig;
import com.week2.n01600598.service.GreetingPrinter;
import com.week2.n01600598.service.GreetingService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Week2AppApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService greetingService = context.getBean(GreetingService.class);

        System.out.println("\n"+ greetingService.greeting());



        System.out.println("\n  Using GreetingPrinter by Dependency Injection");
        GreetingPrinter greetingPrinter = context.getBean(GreetingPrinter.class);

        System.out.println(greetingPrinter.getPrintGreeting());


        context.close();

        System.out.println("\n  Destroying GreetingService manually");
        greetingService.destroy();
    }

}
