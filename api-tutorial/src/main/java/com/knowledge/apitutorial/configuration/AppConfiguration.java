package com.knowledge.apitutorial.configuration;

import org.springframework.stereotype.Component;

@Component
public class AppConfiguration
{
    private final Message message;
    private final PlaceHolder placeHolder;

    public AppConfiguration(Message message, PlaceHolder placeHolder)
    {
        this.message = message;
        this.placeHolder = placeHolder;
    }

    public Message getMessage()
    {
        return message;
    }

    public PlaceHolder getPlaceHolder()
    {
        return placeHolder;
    }
}
