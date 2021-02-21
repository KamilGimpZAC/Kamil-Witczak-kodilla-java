package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class BoardTestSuite {
    @Test
    void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        TaskList taskList1 = board.getToDoList();
        TaskList taskList2 = board.getInProgressList();
        TaskList taskList3 = board.getDoneList();
        //When
        String output1 = taskList1.getTask();
        String output2 = taskList2.getTask();
        String output3 = taskList3.getTask();
        //Then
        assertEquals("Task1",output1);
        assertEquals("Task2",output2);
        assertEquals("Task3",output3);
    }
}
