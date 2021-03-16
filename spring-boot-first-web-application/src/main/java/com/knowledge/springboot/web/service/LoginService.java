package com.knowledge.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService
{
    public LoginService()
    {
    }

    public boolean validateUser(String name, String password)
    {
        if(name.equals("demo") && password.equals("demo")) return true;
        return false;
    }
}
