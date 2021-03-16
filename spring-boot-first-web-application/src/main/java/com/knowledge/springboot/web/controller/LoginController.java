package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController
{
    @Autowired
    LoginService loginService;

    @RequestMapping(value ="/login", method = RequestMethod.GET)
    public String showLogin()
    {
        return "login";
    }

    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String showWelcome(@RequestParam String name, @RequestParam String password, ModelMap modelMap)
    {
        boolean isValidUser = loginService.validateUser(name, password);
        if (!isValidUser)
        {
            modelMap.put("errorMessage", "Invalid Credencials");
            return "login";
        }

        modelMap.put("name", name);
        return "welcome";
    }
}
