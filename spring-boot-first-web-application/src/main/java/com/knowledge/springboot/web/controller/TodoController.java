package com.knowledge.springboot.web.controller;

import com.knowledge.springboot.web.exceptions.TodoNotFoundException;
import com.knowledge.springboot.web.model.Todo;
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
@SessionAttributes("name")
public class TodoController
{

    @Autowired
    private TodoService todoService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model)
    {
        String name  =  getLoggedInUserName(model);
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
            String name = getLoggedInUserName(model);
            Todo todo = todoService.getTodo(name, id);
            model.addAttribute("todo", todo);
            return "todo";
        }catch (TodoNotFoundException tex)
        {
            // TODO shows message saying that id provided doesn't match with any TODO
        }
        return "todo";
    }

    private String getLoggedInUserName(ModelMap model)
    {
        return (String) model.get("name");
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

        todo.setUser((String) getLoggedInUserName(model));

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
