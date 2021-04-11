package com.knowledge.apitutorial.controller;

import com.knowledge.apitutorial.service.MessageService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController
{
    @Autowired
    MessageService messageService;

    @GetMapping("/welcome")
    public String showsWelcomeMessage()
    {
        return messageService.retrieveWelcomeMessage();
    }

    @GetMapping("/goodbye")
    public String showsGoodbyeMessage() {return messageService.retrieveGoodbyeMessage();}
}
