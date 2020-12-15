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
        ShapeCollector testList = new ShapeCollector();
        List<Shape> expectedList = new LinkedList<>();
        expectedList.add(new Circle());
        //When
        testList.addFigure(new Circle());
        //Then
        Assertions.assertEquals(expectedList, testList);
    }

    @Test
    void testRemoveFigure(){
        //Given
        ShapeCollector testList = new ShapeCollector();
        testList.addFigure(new Square());
        //When
        testList.removeFigure(new Square());
        //Then
        Assertions.assertEquals(null, testList);
    }

    @Test
    void testGetFigure(){
        //Given
        ShapeCollector testList = new ShapeCollector();
        Circle circle = new Circle();
        testList.addFigure(new Circle());
        //When
        Object expectedObject = testList.getFigure(0);
        //Then
        Assertions.assertEquals(circle, expectedObject);
    }

    @Test
    void testShowFigures(){
        //Given

        //When

        //Then
    }
}
