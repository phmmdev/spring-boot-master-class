package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.model.Todo;
import com.knowledge.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        model.addAttribute("todo", new Todo(0,"", "Default Description", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodos(@ModelAttribute("todo") Todo todo, BindingResult result, ModelMap modelMap)
    {
        if(result.hasErrors())
            return "todo";

        todoService.addTodo((String) "", (String) todo.getDescription(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
