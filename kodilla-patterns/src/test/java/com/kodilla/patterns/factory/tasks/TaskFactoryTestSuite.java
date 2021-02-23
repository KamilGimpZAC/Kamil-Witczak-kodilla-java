package com.kodilla.patterns.factory.tasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TaskFactoryTestSuite {

    private static final TaskFactory taskFactory = new TaskFactory();
    @Test
    void testFactoryShopping(){
        //Given
        //When
        Task shoppingTask = taskFactory.makeTask(TaskFactory.SHOPPINGTASK);
        //Then
        assertEquals(true, shoppingTask.executeTask());
    }

    @Test
    void testFactoryPainting(){
        //Given
        //When
        Task paintingTask = taskFactory.makeTask(TaskFactory.PAINTINGTASK);
        //Then
        assertEquals(true,paintingTask.executeTask());
    }

    @Test
    void testFactoryDriving(){
        //Given
        //When
        Task drivingTask = taskFactory.makeTask(TaskFactory.DRIVINGTASK);
        //Then
        assertEquals(true, drivingTask.executeTask());
    }
}
