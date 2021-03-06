package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test";
    private static final String NAME = "NAME";

    @Test
    void testFindByListName(){
        //Given
        TaskList taskList = new TaskList(NAME, DESCRIPTION);
        taskListDao.save(taskList);
        String intput = taskList.getListName();
        //When
        List<TaskList> output = taskListDao.findByListName(intput);
        //Then
        assertEquals(1,output.size());
        //CleanUp
        taskListDao.deleteById(output.get(0).getId());
    }
}
