package com.knowledge.apitutorial.service.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements com.knowledge.apitutorial.service.MessageService
{
    private final String welcomeMessage;
    private final String goodByeMessage;

    public MessageService( @Value("${messages.welcome}") String welcomeMessage,
                           @Value("${messages.goodbye}") String goodByeMessage)
    {
        this.welcomeMessage = welcomeMessage;
        this.goodByeMessage =  goodByeMessage;
    }


    @Override
    public String retrieveWelcomeMessage()
    {
        return this.welcomeMessage;
    }

    @Override
    public String retrieveGoodbyeMessage() { return this.goodByeMessage; }
}
