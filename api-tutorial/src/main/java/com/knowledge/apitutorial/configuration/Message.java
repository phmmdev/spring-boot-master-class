package com.knowledge.apitutorial.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("messages")
public class Message
{
    private  String welcome;
    private  String goodbye;

    public Message()
    {
    }

    public void setWelcome(String welcome)
    {
        this.welcome = welcome;
    }

    public String getWelcome()
    {
        return welcome;
    }

    public String getGoodbye()
    {
        return goodbye;
    }

    public void setGoodbye(String goodbye)
    {
        this.goodbye = goodbye;
    }

    public String getGoodBye()
    {
        return goodbye;
    }

    public void setGoodBye(String goodbye)
    {
        this.goodbye = goodbye;
    }
}
