package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.*;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("when create empty List, " +
            "then exterminate() should return List is empty"
    )

    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator emptyList = new OddNumbersExterminator();
        //When
        Object result = emptyList.exterminate(null);
        //Then
        Assertions.assertEquals("List is empty", result);
    }

    @DisplayName("when create List, " +
            "then exterminate() should return List with only even numbers"
    )

    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        List<Integer> fList = List.of(3,5,31,73,4);
        List<Integer> checkList = List.of(4);
        OddNumbersExterminator filledList = new OddNumbersExterminator();
        //When
        filledList.exterminate(fList);
        //Then
        Assertions.assertEquals(checkList, fList);

    }
}
