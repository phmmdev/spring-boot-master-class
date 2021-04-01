package com.knowledge.springboot.web.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoggedInUserService
{
    public String getLoggedInUserName()
    {
        Object principal = getPrincipal();
        if(isPrincipalOfUserDetailsType(principal))
        {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    private Object getPrincipal()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private boolean isPrincipalOfUserDetailsType(Object principal)
    {
        return (principal instanceof UserDetails);
    }

    public void logOut(HttpServletRequest request, HttpServletResponse response)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);
    }
}
