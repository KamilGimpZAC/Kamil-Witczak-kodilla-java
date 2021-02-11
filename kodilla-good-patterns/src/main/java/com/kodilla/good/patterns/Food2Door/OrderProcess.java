package com.kodilla.good.patterns.Food2Door;

public interface OrderProcess {
    NewOrder process(FoodProducer foodProducer, Product product, SendInfo sendInfo);
}
