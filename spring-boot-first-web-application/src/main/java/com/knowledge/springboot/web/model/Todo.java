package com.knowledge.springboot.web.model;

import java.util.Date;

public class Todo
{
    private int id;
    private String user;
    private String description;
    private Date targetDate;
    private boolean isDone;

    public Todo(int id, String user, String description, Date targetDate, boolean isDone)
    {
        this.id = id;
        this.user = user;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public int getId()
    {
        return id;
    }

    public String getUser()
    {
        return user;
    }

    public String getdescription()
    {
        return description;
    }

    public Date getTargetDate()
    {
        return targetDate;
    }

    public boolean isDone()
    {
        return isDone;
    }

    @Override
    public String toString()
    {
        return "Todo{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + isDone +
                '}';
    }
}
