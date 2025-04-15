package com.kartik.assignment5.controller;

import com.kartik.assignment5.model.MessageParser;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lab")
public class MessageSenderController {

    private final JmsTemplate jmsTemplate;

    public MessageSenderController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        jmsTemplate.convertAndSend("lab-queue", message);
        return "Message sent: " + message;
    }

    @PostMapping("/sendObject")
    public String sendStructuredMessage(@RequestBody MessageParser payload) {
        jmsTemplate.convertAndSend("lab-queue", payload);
        return "Structured message sent for: " + payload.getName();
    }
}
