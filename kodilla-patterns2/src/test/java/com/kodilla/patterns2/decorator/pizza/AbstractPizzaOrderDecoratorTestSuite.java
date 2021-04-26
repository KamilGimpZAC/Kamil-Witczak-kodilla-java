package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPizzaOrderDecoratorTestSuite {

    @Test
    void testBasicPizzaOrderGetCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15),cost);
    }
    @Test
    void testBasicPizzaOrderGetDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza with cheese and tomato sauce",description);
    }
    @Test
    void testExtendedPizzaOrderGetCost(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamDecorate(pizzaOrder);
        pizzaOrder = new MushroomsDecorate(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new BaconDecorator(pizzaOrder);
        pizzaOrder = new KabanosDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getCost();
        //Then
        assertEquals(new BigDecimal(36), cost);
    }
    @Test
    void testExtendedPizzaOrderGetDescription(){
        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new HamDecorate(pizzaOrder);
        pizzaOrder = new MushroomsDecorate(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new BaconDecorator(pizzaOrder);
        pizzaOrder = new KabanosDecorator(pizzaOrder);
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza with cheese and tomato sauce + additional cheese + ham + mushrooms + pineapple + salami + bacon + kabanos sausages",description);
    }
}