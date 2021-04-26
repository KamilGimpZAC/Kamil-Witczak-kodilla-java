package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListForStudentTestSuite {

    @Test
    public void testUpdate(){
        //Given
        TaskListForStudent taskListForStudent1 = new TaskListForStudent("Mateusz");
        TaskListForStudent taskListForStudent2 = new TaskListForStudent("Jan");
        TaskListForStudent taskListForStudent3 = new TaskListForStudent("Michał");
        TaskListForStudent taskListForStudent4 = new TaskListForStudent("Kacper");
        Mentor mentor1 = new Mentor("Sebastian");
        Mentor mentor2 = new Mentor("Paweł");
        taskListForStudent1.registerObserver(mentor1);
        taskListForStudent2.registerObserver(mentor1);
        taskListForStudent3.registerObserver(mentor2);
        taskListForStudent4.registerObserver(mentor2);
        //When
        taskListForStudent1.addTask("20.1");
        taskListForStudent1.addTask("21.2");
        taskListForStudent2.addTask("14.3");
        taskListForStudent3.addTask("15.6");
        taskListForStudent3.addTask("24.0");
        taskListForStudent3.addTask("9.1");
        taskListForStudent4.addTask("1.1");
        //Then
        assertEquals(3, mentor1.getCount());
        assertEquals(4, mentor2.getCount());
    }

}