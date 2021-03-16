package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.model.Todo;
import com.knowledge.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class TodoController
{

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model)
    {
        ArrayList<Todo> todos = (ArrayList<Todo>) todoService.retrieveTodos("demo");
        model.put("todos", todos);
        return "list-todos";
    }
}
