package com.knowledge.apitutorial.controller;

import com.knowledge.apitutorial.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController
{
    @Autowired
    WelcomeService welcomeService;

    @RequestMapping("/welcome")
    public String showsWelcomeMessage()
    {
        return welcomeService.retrieveWelcomeMessage();
    }
}
