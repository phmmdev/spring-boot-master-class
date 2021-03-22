package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.model.Todo;
import com.knowledge.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;

@Controller
@SessionAttributes("name")
public class TodoController
{

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model)
    {
        String name  =  (String) model.get("name");
        ArrayList<Todo> todos = (ArrayList<Todo>) todoService.retrieveTodos(name);
        model.put("todos", todos);
        return "list-todos";
    }
}
