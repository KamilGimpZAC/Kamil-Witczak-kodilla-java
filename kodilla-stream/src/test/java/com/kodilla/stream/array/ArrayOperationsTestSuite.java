package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        int[] givenTable = {3,14,53,12,84,26,48,27,6,83,7,92,38,71,95,28,74,18,20,64};
        ArrayOperations arrayOperations = new ArrayOperations() {
            @Override
            public OptionalDouble getAverage(int[] numbers) {
                IntStream.range(0,numbers.length);
                Arrays.stream(numbers)
                        .forEach(System.out::println);
                IntStream.range(0,numbers.length);
                OptionalDouble output = Arrays.stream(numbers)
                        .average();
                return output;
            }
        };
        //When
        OptionalDouble output = arrayOperations.getAverage(givenTable);
        //Then
        assertEquals(43.15, output);
    }
}
