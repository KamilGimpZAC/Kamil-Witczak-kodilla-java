package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.List;

public class ShapeCollectorTestSuite {

    Shape inputCircle = new Circle();
    Shape inputSquare = new Square();
    Shape inputTriangle = new Square();

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
        //When
        shapeCollector.addFigure(inputCircle);
        //Then
        Assertions.assertEquals(inputCircle, shapeCollector.getFigure(0));
    }

    @Test
    void testRemoveFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(inputSquare);
        //When
        boolean output = shapeCollector.removeFigure(inputSquare);
        //Then
        Assertions.assertTrue(output);
    }

    @Test
    void testGetFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(inputCircle);
        //When
        Shape output = shapeCollector.getFigure(0);
        //Then
        Assertions.assertEquals(inputCircle, output);
    }

    @Test
    void testShowFigures(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(inputTriangle);
        shapeCollector.addFigure(inputSquare);
        //When
        String output = shapeCollector.showFigures();
        //Then
        Assertions.assertEquals(inputTriangle.toString() + inputSquare.toString(), output);
    }
}
