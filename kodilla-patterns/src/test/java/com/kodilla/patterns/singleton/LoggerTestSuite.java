package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private static Logger logger;

    @Test
    void testGetLastLog(){
        //Given
        logger = Logger.LOGGER;
        logger.log("test");
        //When
        String output = logger.getLastLog();
        //Then
        assertEquals("test",output);
    }
}
