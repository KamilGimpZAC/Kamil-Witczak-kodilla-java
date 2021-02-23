package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigmacBuilder(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bum("Normal")
                .burgers(2)
                .ingredient("Becon")
                .ingredient("Onion")
                .ingredient("Cheese")
                .sauce("Chilli")
                .build();
        System.out.println(bigmac);
        //When
        //Then
        assertEquals("Normal",bigmac.getBum());
        assertEquals(3,bigmac.getIngredients().size());
        assertEquals("Chilli",bigmac.getSauce());
        assertEquals(2,bigmac.getBurgers());
    }
}
