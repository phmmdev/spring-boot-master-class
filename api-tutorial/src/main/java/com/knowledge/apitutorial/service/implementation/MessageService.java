package com.knowledge.apitutorial.service.implementation;

import com.knowledge.apitutorial.configuration.AppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements com.knowledge.apitutorial.service.MessageService
{
    /*private final String welcomeMessage;
    private final String goodByeMessage;*/

    /*public MessageService( @Value("${messages.welcome}") String welcomeMessage,
                           @Value("${messages.goodbye}") String goodByeMessage)
    {
        this.welcomeMessage = welcomeMessage;
        this.goodByeMessage =  goodByeMessage;
    }*/

    private final AppConfiguration appConfiguration;

    @Autowired
    public MessageService(AppConfiguration appConfiguration)
    {
        this.appConfiguration = appConfiguration;
    }

    @Override
    public String retrieveWelcomeMessage()
    {
        return this.appConfiguration.getMessage().getWelcome();
    }

    @Override
    public String retrieveGoodbyeMessage() { return this.appConfiguration.getMessage().getGoodbye(); }
}
