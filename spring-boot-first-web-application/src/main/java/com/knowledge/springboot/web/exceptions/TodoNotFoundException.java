package com.knowledge.springboot.web.exceptions;

public class TodoNotFoundException extends RuntimeException
{
    public TodoNotFoundException(String message)
    {
        super(message);
    }
}
