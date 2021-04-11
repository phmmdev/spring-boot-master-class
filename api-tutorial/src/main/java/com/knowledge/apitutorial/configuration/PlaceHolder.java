package com.knowledge.apitutorial.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("placeholders")
public class PlaceHolder
{
    private String exclamation;
    private String env;

    public void setExclamation(String exclamation)
    {
        this.exclamation = exclamation;
    }

    public void setEnv(String env)
    {
        this.env = env;
    }

    public String getExclamation()
    {
        return exclamation;
    }

    public String getEnv()
    {
        return env;
    }
}
