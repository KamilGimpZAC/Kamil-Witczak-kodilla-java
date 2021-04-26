package com.kodilla.patterns2.decorator.pizza;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class KabanosDecorator extends AbstractPizzaOrderDecorator{

    public KabanosDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(3));
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " + kabanos sausages";
    }
}
