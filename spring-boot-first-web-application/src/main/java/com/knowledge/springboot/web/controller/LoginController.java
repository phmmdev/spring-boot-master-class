package com.knowledge.springboot.web.controller;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController
{
    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String showLogin()
    {
        return "login";
    }

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String showWelcome(@RequestParam String name, @RequestParam String password, ModelMap modelMap)
    {
        modelMap.put("name", name);
        return "welcome";
    }
}
