package com.knowledge.springboot.web.service;

import com.knowledge.springboot.web.model.Todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class TodoService
{
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;

    static {
        todos.add(new Todo(1, "demo", "Learn Spring MVC", new Date(),false));
        todos.add(new Todo(2, "demo", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "demo", "Learn Hibernate", new Date(),false));
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void addTodo(String name, String description, Date targetDate,
                        boolean isDone) {
        todos.add(new Todo(++todoCount, name, description, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
}
