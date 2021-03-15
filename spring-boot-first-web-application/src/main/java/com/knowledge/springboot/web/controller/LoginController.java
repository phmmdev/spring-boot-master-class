package com.knowledge.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController
{
    @RequestMapping("/login")
    @ResponseBody
    public String sayHello()
    {
        return "Hello World Customized";
    }
}
