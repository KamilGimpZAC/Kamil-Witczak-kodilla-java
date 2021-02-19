package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculationsAdd(){
        //Given
        //When
        double output = calculator.add(1,2);
        //Then
        assertEquals(3,output);
    }
    @Test
    void testCalculationsSub(){
        //Given
        //When
        double output = calculator.sub(3,5);
        //Then
        assertEquals(2,output);
    }
    @Test
    void testCalculationsMul(){
        //Given
        //When
        double output = calculator.mul(3,3);
        //Then
        assertEquals(9,output);
    }
    @Test
    void testCalculationsDiv(){
        //Given
        //When
        double output = calculator.div(6,2);
        //Then
        assertEquals(3,output);
    }
}
