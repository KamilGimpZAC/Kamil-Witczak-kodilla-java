package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;
    private String task;

    public TaskList(String task) {
        this.task = task;
        this.tasks = new ArrayList<>();
        tasks.add(task);
    }

    public String getTask() {
        return task;
    }

}
