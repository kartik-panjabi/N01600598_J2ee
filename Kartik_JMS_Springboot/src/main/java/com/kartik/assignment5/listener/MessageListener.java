package com.kartik.assignment5.listener;

import com.kartik.assignment5.model.MessageParser;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "lab-queue")
    public void receiveStructuredMessage(MessageParser message) {
        System.out.println("📩 Received structured message");
        System.out.println("Name: " + message.getName());
        System.out.println("Message: " + message.getMessage());
    }
}
