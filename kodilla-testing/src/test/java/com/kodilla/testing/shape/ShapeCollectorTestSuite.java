package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle();
        //When
        shapeCollector.addFigure(new Circle());
        //Then
        Assertions.assertEquals(circle, shapeCollector.getFigure(0));
    }

    @Test
    void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Square());
        //When
        boolean result = shapeCollector.removeFigure(new Square());
        //Then
        Assertions.assertTrue(result);
    }

    @Test
    void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape circle = new Circle();
        shapeCollector.addFigure(new Circle());
        //When
        Shape output = shapeCollector.getFigure(0);
        //Then
        Assertions.assertEquals(circle, output);
    }

    @Test
    void testShowFigures(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Triangle());
        shapeCollector.addFigure(new Square());
        //When
        String output = shapeCollector.showFigures();
        //Then
        Assertions.assertEquals("", output);
    }
}
