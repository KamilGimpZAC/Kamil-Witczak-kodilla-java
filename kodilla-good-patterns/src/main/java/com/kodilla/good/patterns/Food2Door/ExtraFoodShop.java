package com.kodilla.good.patterns.Food2Door;

public class ExtraFoodShop implements FoodProducer{
    private static final String NAME = "ExtraFoodShop";
    public static NewOrder newOrder;


    @Override
    public String getNAME() {
        return NAME;
    }
}
