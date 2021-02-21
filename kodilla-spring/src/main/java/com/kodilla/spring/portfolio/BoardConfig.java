package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    TaskList taskList1;

    @Autowired
    @Qualifier("inProgressList")
    TaskList taskList2;

    @Autowired
    @Qualifier("doneList")
    TaskList taskList3;

    @Bean
    public Board getBoard(){
        return new Board(taskList1,taskList2,taskList3);
    }

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList(){
        return new TaskList("Task1");
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList(){
        return new TaskList("Task2");
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList(){
        return new TaskList("Task3");
    }
}
