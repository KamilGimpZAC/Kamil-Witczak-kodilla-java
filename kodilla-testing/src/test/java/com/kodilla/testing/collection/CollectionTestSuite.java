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
        OddNumbersExterminator input = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> expected = input.exterminate(emptyList);
        //Then
        Assertions.assertTrue(expected.isEmpty());
    }

    @DisplayName("when create List, " +
            "then exterminate() should return List with only even numbers"
    )

    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        List<Integer> input = new ArrayList<>(){{
            add(13);
            add(6);
            add(7);
            add(2);
        }};
        List<Integer> expected = List.of(6,2);
        OddNumbersExterminator filledList = new OddNumbersExterminator();
        //When
        List<Integer> output = filledList.exterminate(input);
        //Then
        Assertions.assertEquals(expected, output);
    }
}
