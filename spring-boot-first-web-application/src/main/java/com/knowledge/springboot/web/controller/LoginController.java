package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


public class LoginController
{
    @Autowired
    LoginService loginService;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String showWelcome(ModelMap modelMap)
    {
        modelMap.put("name", "demo");
        return "welcome";
    }
}
