package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity(){
        //Given
        World world = new World();
        //When
        BigDecimal totalPeople;
        totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPeople = new BigDecimal("2524890356");
        assertEquals(expectedPeople, totalPeople);
    }
}
