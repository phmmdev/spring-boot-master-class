package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.exceptions.TodoNotFoundException;
import com.knowledge.springboot.web.model.Todo;
import com.knowledge.springboot.web.service.LoggedInUserService;
import com.knowledge.springboot.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class TodoController
{
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    private TodoService todoService;
    private LoggedInUserService loggedInUserService;

    @Autowired
    public TodoController(TodoService todoService, LoggedInUserService loggedInUserService)
    {
        this.todoService = todoService;
        this.loggedInUserService = loggedInUserService;
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model)
    {
        String name  =  this.loggedInUserService.getLoggedInUserName();
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

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodos(ModelMap model, @RequestParam int id)
    {
        try
        {
            Todo todo = todoService.getTodo(this.loggedInUserService.getLoggedInUserName(), id);
            model.addAttribute("todo", todo);
            return "todo";
        }catch (TodoNotFoundException tex)
        {
            // TODO shows message saying that id provided doesn't match with any TODO
        }
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodos(@ModelAttribute("todo") Todo todo, BindingResult result, ModelMap modelMap)
    {
        if(result.hasErrors())
            return "todo";

        todoService.addTodo((String) "demo", (String) todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUser(this.loggedInUserService.getLoggedInUserName());

        todoService.updateTodo(todo);

        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
