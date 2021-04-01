package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.service.LoggedInUserService;
import com.knowledge.springboot.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController
{
    @Autowired
    LoginService loginService;
    @Autowired
    LoggedInUserService loggedInUserService;

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap modelMap)
    {
        modelMap.put("name", loggedInUserService.getLoggedInUserName());
        return "welcome";
    }

    @RequestMapping(value ="/logout", method = RequestMethod.GET)
    public String logOutUser(HttpServletRequest request, HttpServletResponse response)
    {
        this.loggedInUserService.logOut(request, response);
        return "redirect:/";
    }

}
