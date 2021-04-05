package com.knowledge.apitutorial.service.implementation;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements com.knowledge.apitutorial.service.WelcomeService
{

    @Override
    public String retrieveWelcomeMessage()
    {
        return "Welcome";
    }
}
