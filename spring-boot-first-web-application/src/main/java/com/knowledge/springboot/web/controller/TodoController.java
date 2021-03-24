package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.model.Todo;
import com.knowledge.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.Date;

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

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodos(ModelMap model)
    {
        model.addAttribute("todo", new Todo(0,"", "", new Date(), false));
        return "todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodos(ModelMap model, Todo todo)
    {
        String name  =  (String) model.get("name");
        todoService.addTodo((String) model.get("name"), (String) todo.getdescription(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
